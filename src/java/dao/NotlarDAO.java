/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Ders;
import entity.Notlar;
import entity.Ogrenci;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class NotlarDAO extends DBConnection{
    
    private DersDAO dersDao;
    private OgrenciDAO ogrenciDao;
    
    public Notlar findById(int id){
        Notlar n=null;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from notlar where id="+id;

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Ogrenci o=this.getOgrenciDao().findById(rs.getInt("ogrencino_id"));
                Ders d=this.getDersDao().findById(rs.getInt("derskodu_id"));
                
                n= new Notlar(rs.getInt("id"),o, d, rs.getInt("vizenot"),rs.getInt("finalnot"),rs.getInt("ortalama"),rs.getString("durum"));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return n;
    }
    public void create(Notlar n) {
        try {
            Statement st = this.getConnection().createStatement();
            String query="insert into notlar(ogrencino_id,derskodu_id,vizenot,finalnot,ortalama,durum) values ('"+n.getOgrencino().getId()+"','"+n.getDerskodu().getId()+"','"+n.getVizenot()+"','"+n.getFinalnot()+"','"+n.getOrtalama()+"','"+n.getDurum()+"')";
            st.executeLargeUpdate(query);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(Notlar n) {
        try {
            Statement st = this.getConnection().createStatement();
            String query="update notlar set ogrencino_id='"+n.getOgrencino().getId()+"', derskodu_id='"+n.getDerskodu().getId()+"',  vizenot='"+n.getVizenot()+"',  finalnot='"+n.getFinalnot()+"', ortalama='"+n.getOrtalama()+"', durum='"+n.getDurum()+"'where id="+n.getId();
            st.executeLargeUpdate(query);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(Notlar n) {
        try {
            Statement st = this.getConnection().createStatement();
            String query="delete from notlar where id="+n.getId();
            st.executeLargeUpdate(query);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List <Notlar> getList(int page, int pageSize) {
        
        List <Notlar> list= new ArrayList<>();
        int start=(page-1)*pageSize;
        try {
            Statement st = this.getConnection().createStatement();
            String query ="select * from fakulte order by id asc limit "+pageSize+" offset "+start;
            ResultSet rs=st.executeQuery(query);
            
            while(rs.next()){
                Ogrenci o=this.getOgrenciDao().findById(rs.getInt("ogrencino_id"));
                Ders d=this.getDersDao().findById(rs.getInt("derskodu_id"));
                list.add(new Notlar(rs.getInt("id"), o, d, rs.getInt("vizenot"),rs.getInt("finalnot"),rs.getInt("ortalama"),rs.getString("durum")));
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
            String query = "select count(id) as notlar_count from notlar ";

            ResultSet rs = st.executeQuery(query);
            rs.next();
            count=rs.getInt("notlar_count");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    public DersDAO getDersDao() {
        if (dersDao == null) {
            this.dersDao = new DersDAO();
        }
        return dersDao;
    }

    public void setDersDao(DersDAO dersDao) {
        this.dersDao = dersDao;
    }

    public OgrenciDAO getOgrenciDao() {
        if (ogrenciDao == null) {
            this.ogrenciDao = new OgrenciDAO();
        }
        return ogrenciDao;
    }

    public void setOgrenciDao(OgrenciDAO ogrenciDao) {
        this.ogrenciDao = ogrenciDao;
    }
    
    
    
}
