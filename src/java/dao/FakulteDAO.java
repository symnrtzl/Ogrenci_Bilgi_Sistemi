/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author Lenovo
 */
import entity.Fakulte;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class FakulteDAO extends DBConnection {
    
    public Fakulte findById(int id){
        Fakulte f=null;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from fakulte where id="+id;

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                f= new Fakulte(rs.getInt("id"), rs.getString("fakultead"), rs.getString("fakultekod"));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return f;
    }

    public void create(Fakulte f) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "insert into fakulte(fakultead,fakultekod) values ('" + f.getFakultead() + "','" + f.getFakultekod() + "')";
            st.executeLargeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(Fakulte f) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "update fakulte set fakultead='" + f.getFakultead() + "', fakultekod='" +f.getFakultekod() + "' where id=" + f.getId();
            st.executeLargeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(Fakulte f) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "delete from fakulte where id=" + f.getId();
            st.executeLargeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Fakulte> getList(int page, int pageSize) {

        List<Fakulte> list = new ArrayList<>();
        int start=(page-1)*pageSize;
        try {
            Statement st = this.getConnection().createStatement();
            String query ="select * from fakulte order by id asc limit "+pageSize+" offset "+start;

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                list.add(new Fakulte(rs.getInt("id"), rs.getString("fakultead"), rs.getString("fakultekod")));
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
            String query = "select count(id) as fakulte_count from fakulte ";

            ResultSet rs = st.executeQuery(query);
            rs.next();
            count=rs.getInt("fakulte_count");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return count;
    }
    
}
