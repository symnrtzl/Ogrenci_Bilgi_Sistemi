/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.AkademisyenDAO;
import entity.Akademisyen;

import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Lenovo
 */
@Named(value = "akademisyenBean")
@SessionScoped
public class AkademisyenBean implements Serializable {

    private Akademisyen entity;
    private AkademisyenDAO dao;
    private List<Akademisyen> list;

    private int page = 1;
    private int pageSize=4;
    private int pageCount;
    
    /**
     * Creates a new instance of AkademisyenBean
     */
    public AkademisyenBean() {
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
        entity = new Akademisyen();
    }
    
    public String getTitle(int id){
        Akademisyen a = this.getDao().findById(id);
        return a.getAd();
    }

    public void update() {
        this.getDao().update(entity);
        entity = new Akademisyen();
    }

    public void delete(Akademisyen a) {
        this.getDao().delete(a);
        entity = new Akademisyen();
    }

    public Akademisyen getEntity() {
        if (entity == null) {
            entity = new Akademisyen();
        }
        return entity;
    }

    public void setEntity(Akademisyen entity) {
        this.entity = entity;
    }

    public AkademisyenDAO getDao() {
        if (dao == null) {
            dao = new AkademisyenDAO();
        }
        return dao;
    }

    public void setDao(AkademisyenDAO dao) {
        this.dao = dao;
    }

    public List<Akademisyen> getList() {
        this.list = this.getDao().getList(page, pageSize);
        return list;
    }

    public void setList(List<Akademisyen> list) {
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
