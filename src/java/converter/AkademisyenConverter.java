/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.AkademisyenDAO;
import entity.Akademisyen;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author Lenovo
 */
@FacesConverter("akademisyenConverter")
public class AkademisyenConverter implements  Converter {

    private AkademisyenDAO akademisyenDao;
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int id=Integer.valueOf(string);
        Akademisyen a=this.getAkademisyenDao().findById(id);
        return a;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Akademisyen a=(Akademisyen)t;
        return String.valueOf(a.getId());
    }
    
    public AkademisyenDAO getAkademisyenDao() {
        if( akademisyenDao == null){
            this.akademisyenDao =new AkademisyenDAO();
        }
        return akademisyenDao;
    }

    public void setAkademisyenDao(AkademisyenDAO akademisyenDao) {
        this.akademisyenDao = akademisyenDao;
    }

   
}