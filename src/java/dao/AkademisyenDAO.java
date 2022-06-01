/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Akademisyen;
import entity.Bolum;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class AkademisyenDAO extends DBConnection {

    private BolumDAO bolumDao;

    public Akademisyen findById(int id) {
        Akademisyen a = null;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from akademisyen where id=" + id;

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Bolum b = this.getBolumDao().findById(rs.getInt("bolum_id"));
                a = new Akademisyen(rs.getInt("id"), rs.getString("ad"), rs.getString("email"), rs.getInt("numara"), b);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return a;
    }

    public void create(Akademisyen a) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "insert into akademisyen(ad,email,numara,bolum_id) values ('" + a.getAd() + "','" + a.getEmail() + "','" + a.getNumara() + "','" + a.getBolum().getId() + "')";
            st.executeLargeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(Akademisyen a) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "update akademisyen set ad='" + a.getAd()  + "',  email='" + a.getEmail() + "',  numara='" + a.getNumara() + "', bolum_id='" + a.getBolum().getId() + "'where id=" + a.getId();
            st.executeLargeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(Akademisyen a) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "delete from akademisyen where id=" + a.getId();
            st.executeLargeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Akademisyen> getList(int page, int pageSize) {

        List<Akademisyen> list = new ArrayList<>();
        int start=(page-1)*pageSize;

        try {
            Statement st = this.getConnection().createStatement();
            String query ="select * from akademisyen order by id asc limit "+pageSize+" offset "+start;

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Bolum b = this.getBolumDao().findById(rs.getInt("bolum_id"));
                list.add(new Akademisyen(rs.getInt("id"), rs.getString("ad"), rs.getString("email"), rs.getInt("numara"), b));
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
            String query = "select count(id) as akademisyen_count from fakulte ";

            ResultSet rs = st.executeQuery(query);
            rs.next();
            count=rs.getInt("akademisyen_count");
            
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

}
