/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Document;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class DocumentDao extends DBConnection {

    public List<Document> findAll() {
        List<Document> dList = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from documents";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Document d = new Document();
                d.setFilePath(rs.getString("path"));
                d.setFileName(rs.getString("name"));
                d.setFileType(rs.getString("type"));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return dList;
    }

    public void insert(Document d) {
        String query = "insert into document(path,name,type) value(?,?,?)";
        try {
            PreparedStatement pst = this.getConnection().prepareStatement(query);
            pst.setString(1, d.getFilePath());
            pst.setString(2, d.getFilePath());
            pst.setString(3, d.getFilePath());
            pst.executeUpdate();

        } catch (Exception e) {

            System.out.print(e.getMessage());

        }
    }
}

