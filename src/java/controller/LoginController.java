/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.UserDAO;
import entity.UserManager;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 *
 * @author Lenovo
 */
@Named(value = "lc")
@SessionScoped
public class LoginController implements Serializable {

    private UserManager user;
    private UserDAO udao;

    public LoginController() {
    }

    public void login() {

        if (user.getUsername().equals("test") && user.getPassword().equals("123")) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("validUser", user);
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Kullanıcı adı veya şifre hatalı girilmiştir!!!"));
        }
    }

    public UserManager getUser() {
        if (user == null) {
            user = new UserManager();
        }
        return user;
    }

    public void setUser(UserManager user) {
        this.user = user;
    }

    public UserDAO getUdao() {
        if(this.udao==null){
            this.udao= new UserDAO();
        }
        return udao;
    }

    public void setUdao(UserDAO udao) {
        this.udao = udao;
    }
    
    

}