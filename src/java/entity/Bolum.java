/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Lenovo
 */
public class Bolum {
    private int id;
    private Fakulte fakulte;
    private String bolumad;
    private String bolumkod;

    public Bolum() {
    }

    public Bolum(int id, Fakulte fakulte, String bolumad, String bolumkod) {
        this.id = id;
        this.fakulte = fakulte;
        this.bolumad = bolumad;
        this.bolumkod = bolumkod;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Fakulte getFakulte() {
        return fakulte;
    }

    public void setFakulte(Fakulte fakulte) {
        this.fakulte = fakulte;
    }

   

    public String getBolumad() {
        return bolumad;
    }

    public void setBolumad(String bolumad) {
        this.bolumad = bolumad;
    }

    public String getBolumkod() {
        return bolumkod;
    }

    public void setBolumkod(String bolumkod) {
        this.bolumkod = bolumkod;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.id;
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
        final Bolum other = (Bolum) obj;
        return this.id == other.id;
    }

   

   

}