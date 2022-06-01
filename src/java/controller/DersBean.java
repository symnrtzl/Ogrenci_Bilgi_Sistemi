/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.DersDAO;
import entity.Ders;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Lenovo
 */
@Named(value = "dersBean")
@SessionScoped
public class DersBean implements Serializable {

    private Ders entity;
    private DersDAO dao;
    private List<Ders> list;
    
    private int page = 1;
    private int pageSize=4;
    private int pageCount;
    
    /**
     * Creates a new instance of DersBean
     */
    public DersBean() {
        
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
        entity = new Ders();
    }
    
    public String getTitle(int id){
        Ders d = this.getDao().findById(id);
        return d.getDersadı();
    }

    public void update() {
        this.getDao().update(entity);
        entity = new Ders();
    }

    public void delete(Ders d) {
        this.getDao().delete(d);
        entity = new Ders();
    }

    public Ders getEntity() {
        if (entity == null) {
            entity = new Ders();
        }
        return entity;
    }

    public void setEntity(Ders entity) {
        this.entity = entity;
    }

    public DersDAO getDao() {
        if (dao == null) {
            dao = new DersDAO();
        }
        return dao;
    }

    public void setDao(DersDAO dao) {
        this.dao = dao;
    }

    public List<Ders> getList() {
        this.list = this.getDao().getList(page, pageSize);
        return list;
    }

    public void setList(List<Ders> list) {
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
