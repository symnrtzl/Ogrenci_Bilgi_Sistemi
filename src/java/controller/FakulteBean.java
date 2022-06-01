/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.FakulteDAO;
import entity.Fakulte;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Lenovo
 */
@Named(value = "fakulteBean")
@SessionScoped
public class FakulteBean implements Serializable {

    /**
     * Creates a new instance of FakulteBean
     */
    private Fakulte entity;
    private FakulteDAO dao;
    private List<Fakulte> list;

    private int page = 1;
    private int pageSize=4;
    private int pageCount;

    /**
     * Creates a new instance of OgrenciBean
     */
    public FakulteBean() {
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
        entity = new Fakulte();
    }

    public String getTitle(int id) {
        Fakulte f = this.getDao().findById(id);
        return f.getFakultead();
    }

    public void delete(Fakulte f) {
        this.getDao().delete(f);
        entity = new Fakulte();
    }

    public void update() {
        this.getDao().update(entity);
        entity = new Fakulte();
    }

    public Fakulte getEntity() {
        if (entity == null) {
            entity = new Fakulte();
        }
        return entity;
    }

    public void setEntity(Fakulte entity) {
        this.entity = entity;
    }

    public FakulteDAO getDao() {
        if (dao == null) {
            dao = new FakulteDAO();
        }
        return dao;
    }

    public void setDao(FakulteDAO dao) {
        this.dao = dao;
    }

    public List<Fakulte> getList() {
        this.list = this.getDao().getList(page, pageSize);
        return list;
    }
    public void setList(List<Fakulte> list) {
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
