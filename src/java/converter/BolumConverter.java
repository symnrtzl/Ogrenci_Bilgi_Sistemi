/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.BolumDAO;
import entity.Bolum;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author Lenovo
 */
@FacesConverter("bolumConverter")
public class BolumConverter implements  Converter {

    private BolumDAO bolumDao;
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int id=Integer.valueOf(string);
        Bolum b=this.getBolumDao().findById(id);
        return b;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Bolum b=(Bolum)t;
        return String.valueOf(b.getId());
    }
    
    public BolumDAO getBolumDao() {
        if( bolumDao == null){
            this.bolumDao =new BolumDAO();
        }
        return bolumDao;
    }

    public void setBolumDao(BolumDAO bolumDao) {
        this.bolumDao = bolumDao;
    }
}