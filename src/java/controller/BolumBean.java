/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.BolumDAO;
import entity.Bolum;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Lenovo
 */
@Named(value = "bolumBean")
@SessionScoped
public class BolumBean implements Serializable {

    private Bolum entity;
    private BolumDAO dao;
    private List<Bolum> list;

    private int page = 1;
    private int pageSize=4;
    private int pageCount;
    
    /**
     * Creates a new instance of BolumBean
     */
    public BolumBean() {
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
        entity = new Bolum();
    }

    public String getTitle(int id){
        Bolum b = this.getDao().findById(id);
        return b.getBolumad();
    }
   
    public void update() {
        this.getDao().update(entity);
        entity = new Bolum();
    }
    public void delete(Bolum b) {
        this.getDao().delete(b);
        entity = new Bolum();
    }

    public Bolum getEntity() {
        if (entity == null) {
            entity = new Bolum();
        }
        return entity;
    }

    public void setEntity(Bolum entity) {
        this.entity = entity;
    }

    public BolumDAO getDao() {
        if (dao == null) {
            dao = new BolumDAO();
        }
        return dao;
    }

    public void setDao(BolumDAO dao) {
        this.dao = dao;
    }

    public List<Bolum> getList() {
        this.list = this.getDao().getList(page, pageSize);
        return list;
    }

    public void setList(List<Bolum> list) {
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
