/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikacjanazaliczenie;

/**
 *
 * @author Andrzej
 */
public class Pozycz {

    private String tytul;
    private String pozyczyl;
    private String data;
    private String informacje;
    // SimpleDateFormat formatdaty = new SimpleDateFormat("yyyy.MM.dd");

    public Pozycz() {
    }

    public Pozycz(String tytul, String pozyczyl, String data, String informacje) {
        this.tytul = tytul;
        this.pozyczyl = pozyczyl;
        this.data = data;
        this.informacje = informacje;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getPozyczyl() {
        return pozyczyl;
    }

    public void setPozyczyl(String pozyczyl) {
        this.pozyczyl = pozyczyl;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getInformacje() {
        return informacje;
    }

    public void setInformacje(String informacje) {
        this.informacje = informacje;
    }

    @Override
    public String toString() {
        //    return "Pozycz{" +", tytul=" + tytul + ", pozyczyl=" + pozyczyl + ", data=" + data + ", informacje=" + informacje + '}';
        return tytul + ";" + pozyczyl + ";" + data + ";" + informacje;
    }

}
