/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Bolum;
import entity.Fakulte;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class BolumDAO extends DBConnection {

    private FakulteDAO fakulteDao;

    public Bolum findById(int id) {
        Bolum b = null;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from bolum where id=" + id;

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Fakulte f = this.getFakulteDao().findById(rs.getInt("fakulte_id"));
                b = new Bolum(rs.getInt("id"), f, rs.getString("bolumad"), rs.getString("bolumkod"));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return b;
    }

    public void create(Bolum b) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "insert into bolum(fakulte_id,bolumad,bolumkod) values ('" + b.getFakulte().getId() + "','" + b.getBolumad() + "','" + b.getBolumkod() + "')";
            st.executeLargeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(Bolum b) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "update bolum set fakulte_id='" + b.getFakulte().getId() + "', bolumad='" + b.getBolumad() + "', bolumkod='" + b.getBolumkod() + "' where id=" + b.getId();
            st.executeLargeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(Bolum b) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "delete from bolum where id=" + b.getId();
            st.executeLargeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Bolum> getList(int page, int pageSize) {

        List<Bolum> list = new ArrayList<>();
        int start=(page-1)*pageSize;

        try {
            Statement st = this.getConnection().createStatement();
            String query ="select * from bolum order by id asc limit "+pageSize+" offset "+start;
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Fakulte f = this.getFakulteDao().findById(rs.getInt("fakulte_id"));

                list.add(new Bolum(rs.getInt("id"), f, rs.getString("bolumad"), rs.getString("bolumkod")));
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
            String query = "select count(id) as bolum_count from bolum ";

            ResultSet rs = st.executeQuery(query);
            rs.next();
            count=rs.getInt("bolum_count");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    public FakulteDAO getFakulteDao() {
        if (fakulteDao == null) {
            this.fakulteDao = new FakulteDAO();
        }
        return fakulteDao;
    }

    public void setFakulteDao(FakulteDAO fakulteDao) {
        this.fakulteDao = fakulteDao;
    }

}
