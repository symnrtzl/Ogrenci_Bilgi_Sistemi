/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Lenovo
 */
public class Notlar {

    private int id;
    private Ogrenci ogrencino;
    private Ders derskodu;
    private int vizenot;
    private int finalnot;
    private int ortalama;
    private String durum;

    public Notlar() {
    }

    public Notlar(int id, Ogrenci ogrencino, Ders derskodu, int vizenot, int finalnot, int ortalama, String durum) {
        this.id = id;
        this.ogrencino = ogrencino;
        this.derskodu = derskodu;
        this.vizenot = vizenot;
        this.finalnot = finalnot;
        this.ortalama = ortalama;
        this.durum = durum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Ogrenci getOgrencino() {
        return ogrencino;
    }

    public void setOgrencino(Ogrenci ogrencino) {
        this.ogrencino = ogrencino;
    }

    public Ders getDerskodu() {
        return derskodu;
    }

    public void setDerskodu(Ders derskodu) {
        this.derskodu = derskodu;
    }

    public int getVizenot() {
        return vizenot;
    }

    public void setVizenot(int vizenot) {
        this.vizenot = vizenot;
    }

    public int getFinalnot() {
        return finalnot;
    }

    public void setFinalnot(int finalnot) {
        this.finalnot = finalnot;
    }

    public int getOrtalama() {
        return ortalama;
    }

    public void setOrtalama(int ortalama) {
        this.ortalama = ortalama;
    }

    public String getDurum() {
        return durum;
    }

    public void setDurum(String durum) {
        this.durum = durum;
    }

}
