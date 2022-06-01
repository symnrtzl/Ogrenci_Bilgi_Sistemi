/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;


import dao.OgrenciDAO;
import entity.Ogrenci;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Lenovo
 */
@Named(value = "ogrenciBean")
@SessionScoped
public class OgrenciBean implements Serializable {
    private Ogrenci entity;
    private OgrenciDAO dao;
    private List<Ogrenci> list;
    
    private int page = 1;
    private int pageSize=4;
    private int pageCount;
    
    /**
     * Creates a new instance of OgrenciBean
     */
    public OgrenciBean() {
    }
    
    public void next() {
        if (this.page == this.getPageCount()) 
            this.page = 1;
        else 
            this.page++;
        
    }

    public void previous() {
        if(this.page==1)
            this.page=this.getPageCount();
        else
            this.page--;
    }
    
    public void create() {
        this.getDao().create(entity);
        entity = new Ogrenci();
    }
    
    public String getTitle(int id){
        Ogrenci o = this.getDao().findById(id);
        return o.getAdsoyad();
    }

    public void update() {
        this.getDao().update(entity);
        entity = new Ogrenci();
    }

    public void delete(Ogrenci o) {
        this.getDao().delete(o);
        entity = new Ogrenci();
    }

    public Ogrenci getEntity() {
        if (entity == null) {
            entity = new Ogrenci();
        }
        return entity;
    }

    public void setEntity(Ogrenci entity) {
        this.entity = entity;
    }

    public OgrenciDAO getDao() {
        if (dao == null) {
            dao = new OgrenciDAO();
        }
        return dao;
    }

    public void setDao(OgrenciDAO dao) {
        this.dao = dao;
    }

    public List<Ogrenci> getList() {
        this.list = this.getDao().getList(page, pageSize);
        return list;
    }

    public void setList(List<Ogrenci> list) {
        this.list = list;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        this.pageCount = (int) Math.ceil(this.getDao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

}
