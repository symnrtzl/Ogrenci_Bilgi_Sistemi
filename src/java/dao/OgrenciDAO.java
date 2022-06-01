/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Akademisyen;
import entity.Bolum;
import entity.Ders;
import entity.Fakulte;
import entity.Ogrenci;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class OgrenciDAO extends DBConnection {

    private BolumDAO bolumDao;
    private AkademisyenDAO akademisyenDao;
    private FakulteDAO fakulteDao;

    public Ogrenci findById(int id) {
        Ogrenci o = null;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from ogrenci where id=" + id;

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Bolum b = this.getBolumDao().findById(rs.getInt("bolum_id"));
                Fakulte f = this.getFakulteDao().findById(rs.getInt("fakulte_id"));
                o = new Ogrenci(rs.getInt("id"), rs.getString("adsoyad"), rs.getInt("numara"), rs.getString("eposta"), rs.getString("cinsiyet"), b, f, this.getOgrenciDersler(rs.getInt("id")));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return o;
    }

    public void create(Ogrenci o) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "insert into ogrenci(adsoyad,numara,eposta,cinsiyet,bolum_id,fakulte_id) values ('" + o.getAdsoyad() + "','" + o.getNumara() + "','" + o.getEposta() + "','" + o.getCinsiyet() + "','" + o.getBolum().getId() + "','" + o.getFakulte().getId() + "')";
            st.executeLargeUpdate(query);

            ResultSet rs = st.executeQuery("select max(id) as mid from ogrenci");
            rs.next();

            int ogrenci_id = rs.getInt("mid");

            for (Ders dersler : o.getDersler()) {
                query = "insert into ogrenci_ders (ogrenci_id,ders_id) values (" + ogrenci_id + "," + dersler.getId() + ")";
                st.executeUpdate(query);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(Ogrenci o) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "update ogrenci set adsoyad='" + o.getAdsoyad() + "', numara='" + o.getNumara() + "',  eposta='" + o.getEposta() + "',  cinsiyet='" + o.getCinsiyet() + "', bolum_id='" + o.getBolum().getId() + "', fakulte_id='" + o.getFakulte().getId() + "'where id=" + o.getId();

            st.executeLargeUpdate(query);

            st.executeUpdate("delete from  ogrenci_ders where ogrenci_id=" + o.getId());

            for (Ders dersler : o.getDersler()) {
                query = "insert into ogrenci_ders (ogrenci_id,ders_id) values (" + o.getId() + "," + dersler.getId() + ")";
                st.executeUpdate(query);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(Ogrenci o) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "delete from ogrenci where id=" + o.getId();

            st.executeUpdate(query);
            st.executeUpdate("delete from  ogrenci_ders where ogrenci_id=" + o.getId());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Ogrenci> getList(int page, int pageSize) {

        List<Ogrenci> list = new ArrayList<>();
        int start=(page-1)*pageSize;
        
        
        try {
            Statement st = this.getConnection().createStatement();
            String query ="select * from ogrenci order by id asc limit "+pageSize+" offset "+start;
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {
                Bolum b = this.getBolumDao().findById(rs.getInt("bolum_id"));
                
                Fakulte f = this.getFakulteDao().findById(rs.getInt("fakulte_id")); 
                
                list.add(new Ogrenci(rs.getInt("id"), rs.getString("adsoyad"), rs.getInt("numara"), rs.getString("eposta"), rs.getString("cinsiyet"), b, f, this.getOgrenciDersler(rs.getInt("id"))));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public List<Ders> getOgrenciDersler(int ogrenci_id) {
        List<Ders> list = new ArrayList<>();

        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from ders where id in (select ders_id from ogrenci_ders where ogrenci_id=" + ogrenci_id + ")";

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Bolum b = this.getBolumDao().findById(rs.getInt("bolum_id"));
                Akademisyen a = this.getAkademisyenDao().findById(rs.getInt("akademisyen_id"));
                list.add(new Ders(rs.getInt("id"), rs.getString("derskod"), rs.getString("dersad"), rs.getInt("kredi"), b, a));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
    public int count(){
        int count=0;
        try {
            
            Statement st = this.getConnection().createStatement();
            String query = "select count(id) as ogrenci_count from ogrenci ";

            ResultSet rs = st.executeQuery(query);
            rs.next();
            count=rs.getInt("ogrenci_count");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    public BolumDAO getBolumDao() {
        if (bolumDao == null) {
            this.bolumDao = new BolumDAO();
        }
        return bolumDao;
    }

    public void setBolumDao(BolumDAO bolumDao) {
        this.bolumDao = bolumDao;
    }

    public AkademisyenDAO getAkademisyenDao() {
        if (akademisyenDao == null) {
            this.akademisyenDao = new AkademisyenDAO();
        }
        return akademisyenDao;
    }

    public void setAkademisyenDao(AkademisyenDAO akademisyenDao) {
        this.akademisyenDao = akademisyenDao;
    }

    public FakulteDAO getFakulteDao() {
        return fakulteDao;
    }

    public void setFakulteDao(FakulteDAO fakulteDao) {
        this.fakulteDao = fakulteDao;
    }

}
