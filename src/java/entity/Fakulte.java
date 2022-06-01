/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Lenovo
 */
public class Fakulte {

    private int id;
    private String fakultead;
    private String fakultekod;

    public Fakulte() {
    }

    public Fakulte(int id, String fakultead, String fakultekod) {
        this.id = id;
        this.fakultead = fakultead;
        this.fakultekod = fakultekod;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFakultead() {
        return fakultead;
    }

    public void setFakultead(String fakultead) {
        this.fakultead = fakultead;
    }

    public String getFakultekod() {
        return fakultekod;
    }

    public void setFakultekod(String fakultekod) {
        this.fakultekod = fakultekod;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Fakulte other = (Fakulte) obj;
        return this.id == other.id;
    }
    
    
}
