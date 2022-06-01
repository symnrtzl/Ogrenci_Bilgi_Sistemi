/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Akademisyen;
import entity.Bolum;
import entity.Ders;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class DersDAO extends DBConnection {

    private BolumDAO bolumDao;
    private AkademisyenDAO akademisyenDao;

    public Ders findById(int id) {
        Ders d = null;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from ders where id=" + id;

            ResultSet rs = st.executeQuery(query);

            

            while (rs.next()) {
                Bolum b = this.getBolumDao().findById(rs.getInt("bolum_id"));
                Akademisyen a = this.getAkademisyenDao().findById(rs.getInt("akademisyen_id"));
                d = new Ders(rs.getInt("id"), rs.getString("derskod"), rs.getString("dersad"), rs.getInt("kredi"), b, a);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return d;
    }

    public void create(Ders d) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "insert into ders(derskod,dersad,kredi,bolum_id,akademisyen_id) values ('" + d.getDerskodu() + "','" + d.getDersadı() + "','" + d.getKredi() + "','" + d.getBolum().getId() + "','" + d.getAkademisyen().getId() + "')";
            st.executeLargeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(Ders d) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "update ders set derskod='" + d.getDerskodu() + "', dersad='" + d.getDersadı() + "',  kredi='" + d.getKredi() + "',  bolum_id='" + d.getBolum().getId() + "', akademisyen_id='" + d.getAkademisyen().getId()+ "'where id=" + d.getId();
            st.executeLargeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(Ders d) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "delete from ders where id=" + d.getId();
            st.executeLargeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Ders> getList(int page, int pageSize) {

        List<Ders> list = new ArrayList<>();
        int start=(page-1)*pageSize;
        
        try {
            Statement st = this.getConnection().createStatement();
            String query ="select * from ders order by id asc limit "+pageSize+" offset "+start;

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
            String query = "select count(id) as ders_count from ders ";

            ResultSet rs = st.executeQuery(query);
            rs.next();
            count=rs.getInt("ders_count");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    public BolumDAO getBolumDao() {
        if(bolumDao==null){
            this.bolumDao=new BolumDAO();
        }
        return bolumDao;
    }

    public void setBolumDao(BolumDAO bolumDao) {
        this.bolumDao = bolumDao;
    }

    public AkademisyenDAO getAkademisyenDao() {
        if(akademisyenDao==null){
            this.akademisyenDao=new AkademisyenDAO();
        }
        return akademisyenDao;
    }

    public void setAkademisyenDao(AkademisyenDAO akademisyenDao) {
        this.akademisyenDao = akademisyenDao;
    }

}
