/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.FakulteDAO;
import entity.Fakulte;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author Lenovo
 */
@FacesConverter("fakulteConverter")
public class FakulteConverter implements  Converter {

    private FakulteDAO fakulteDao;
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int id=Integer.valueOf(string);
        Fakulte f=this.getFakulteDao().findById(id);
        return f;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Fakulte f=(Fakulte)t;
        return String.valueOf(f.getId());
    }
    
    public FakulteDAO getFakulteDao() {
        if( fakulteDao == null){
            this.fakulteDao =new FakulteDAO();
        }
        return fakulteDao;
    }

    public void setFakulteDao(FakulteDAO fakulteDao) {
        this.fakulteDao = fakulteDao;
    }
}
