/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Lenovo
 */
public class Ders {

    private int id;
    private String derskodu;
    private String dersadı;
    private int kredi;
    private Bolum bolum;
    private Akademisyen akademisyen;

    public Ders() {
    }

    public Ders(int id, String derskodu, String dersadı, int kredi, Bolum bolum, Akademisyen akademisyen) {
        this.id = id;
        this.derskodu = derskodu;
        this.dersadı = dersadı;
        this.kredi = kredi;
        this.bolum = bolum;
        this.akademisyen = akademisyen;
    }

    

   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDerskodu() {
        return derskodu;
    }

    public void setDerskodu(String derskodu) {
        this.derskodu = derskodu;
    }

    public String getDersadı() {
        return dersadı;
    }

    public void setDersadı(String dersadı) {
        this.dersadı = dersadı;
    }

    public int getKredi() {
        return kredi;
    }

    public void setKredi(int kredi) {
        this.kredi = kredi;
    }

    public Bolum getBolum() {
        return bolum;
    }

    public void setBolum(Bolum bolum) {
        this.bolum = bolum;
    }

    public Akademisyen getAkademisyen() {
        return akademisyen;
    }

    public void setAkademisyen(Akademisyen akademisyen) {
        this.akademisyen = akademisyen;
    }



    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.id;
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
        final Ders other = (Ders) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return dersadı;
    }

   
}
