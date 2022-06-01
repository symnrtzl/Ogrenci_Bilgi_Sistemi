/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.OgrenciDAO;
import entity.Ogrenci;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author Lenovo
 */
@FacesConverter("ogrenciConverter")
public class OgrenciConverter implements  Converter {

    private OgrenciDAO ogrenciDao;
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int id=Integer.valueOf(string);
        Ogrenci f=this.getOgrenciDao().findById(id);
        return f;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Ogrenci f=(Ogrenci)t;
        return String.valueOf(f.getId());
    }
    
    public OgrenciDAO getOgrenciDao() {
        if( ogrenciDao == null){
            this.ogrenciDao =new OgrenciDAO();
        }
        return ogrenciDao;
    }

    public void setOgrenciDao(OgrenciDAO ogrenciDao) {
        this.ogrenciDao = ogrenciDao;
    }
}
