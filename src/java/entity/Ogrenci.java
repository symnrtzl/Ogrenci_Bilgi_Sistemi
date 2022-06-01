/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.List;

/**
 *
 * @author Lenovo
 */
public class Ogrenci {

    private int id;
    private String adsoyad;
    private int numara;
    private String eposta;
    private String cinsiyet;
    private Bolum bolum;
    private Fakulte fakulte;
    private List<Ders> dersler;

    public Ogrenci() {
    }

    public Ogrenci(int id, String adsoyad, int numara, String eposta, String cinsiyet, Bolum bolum, Fakulte fakulte, List<Ders> dersler) {
        this.id = id;
        this.adsoyad = adsoyad;
        this.numara = numara;
        this.eposta = eposta;
        this.cinsiyet = cinsiyet;
        this.bolum = bolum;
        this.fakulte = fakulte;
        this.dersler = dersler;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdsoyad() {
        return adsoyad;
    }

    public void setAdsoyad(String adsoyad) {
        this.adsoyad = adsoyad;
    }

    public int getNumara() {
        return numara;
    }

    public void setNumara(int numara) {
        this.numara = numara;
    }

    public String getEposta() {
        return eposta;
    }

    public void setEposta(String eposta) {
        this.eposta = eposta;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public Bolum getBolum() {
        return bolum;
    }

    public void setBolum(Bolum bolum) {
        this.bolum = bolum;
    }

    public Fakulte getFakulte() {
        return fakulte;
    }

    public void setFakulte(Fakulte fakulte) {
        this.fakulte = fakulte;
    }

    public List<Ders> getDersler() {
        return dersler;
    }

    public void setDersler(List<Ders> dersler) {
        this.dersler = dersler;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Ogrenci other = (Ogrenci) obj;
        return this.id == other.id;
    }
    
    

}
