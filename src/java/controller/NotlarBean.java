/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.NotlarDAO;
import entity.Notlar;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Lenovo
 */
@Named(value = "notlarBean")
@SessionScoped
public class NotlarBean implements Serializable {

    private Notlar entity;
    private NotlarDAO dao;
    private List<Notlar> list;

    private int page = 1;
    private int pageSize = 4;
    private int pageCount;

    /**
     * Creates a new instance of NotlarBean
     */
    public NotlarBean() {
    }

    public void next() {
        if (this.page == this.getPageCount()) {
            this.page = 1;
        } else {
            this.page++;
        }

    }

    public void previous() {
        if (this.page == 1) {
            this.page = this.getPageCount();
        } else {
            this.page--;
        }
    }

    public void create() {
        this.getDao().create(entity);
        entity = new Notlar();
    }

    /*
    public String getTitle(int id){
        Notlar n = this.getDao().findById(id);
        return n.getDurum();
    }
     */
    public void update() {
        this.getDao().update(entity);
        entity = new Notlar();
    }

    public void delete(Notlar n) {
        this.getDao().delete(n);
        entity = new Notlar();
    }

    public Notlar getEntity() {
        if (entity == null) {
            entity = new Notlar();
        }
        return entity;
    }

    public void setEntity(Notlar entity) {
        this.entity = entity;
    }

    public NotlarDAO getDao() {
        if (dao == null) {
            dao = new NotlarDAO();
        }
        return dao;
    }

    public void setDao(NotlarDAO dao) {
        this.dao = dao;
    }

    public List<Notlar> getList() {
        this.list = this.getDao().getList(page, pageSize);
        return list;
    }

    public void setList(List<Notlar> list) {
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
