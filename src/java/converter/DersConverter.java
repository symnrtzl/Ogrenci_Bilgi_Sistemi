/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;


import dao.DersDAO;
import entity.Ders;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
/**
 *
 * @author Lenovo
 */
@FacesConverter("dersConverter")
public class DersConverter implements  Converter {

    private DersDAO dersDao;
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int id=Integer.valueOf(string);
        Ders f=this.getDersDao().findById(id);
        return f;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Ders f=(Ders)t;
        return String.valueOf(f.getId());
    }
    
    public DersDAO getDersDao() {
        if( dersDao == null){
            this.dersDao =new DersDAO();
        }
        return dersDao;
    }

    public void setDersDao(DersDAO dersDao) {
        this.dersDao = dersDao;
    }
}
