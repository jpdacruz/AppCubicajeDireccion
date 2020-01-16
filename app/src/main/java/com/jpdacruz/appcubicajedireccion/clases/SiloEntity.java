package com.jpdacruz.appcubicajedireccion.clases;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "silos")
public class SiloEntity {

    @PrimaryKey(autoGenerate = true)
    public int id;
    public String idSilo;
    public String tipoGrano;
    public double phGrano;
    public double diametro;
    public double altoGrano;
    public double cono;
    public double copete;
    public double totalm3;
    public double totaltons;

    public SiloEntity() {
    }

    public SiloEntity(String idSilo, String tipoGrano,
                      double phGrano, double diametro,
                      double altoGrano, double cono, double copete,
                      double totalm3, double totaltons) {

        this.idSilo = idSilo;
        this.tipoGrano = tipoGrano;
        this.phGrano = phGrano;
        this.diametro = diametro;
        this.altoGrano = altoGrano;
        this.cono = cono;
        this.copete = copete;
        this.totalm3 = totalm3;
        this.totaltons = totaltons;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdSilo() {
        return idSilo;
    }

    public void setIdSilo(String idSilo) {
        this.idSilo = idSilo;
    }

    public String getTipoGrano() {
        return tipoGrano;
    }

    public void setTipoGrano(String tipoGrano) {
        this.tipoGrano = tipoGrano;
    }

    public double getPhGrano() {
        return phGrano;
    }

    public void setPhGrano(double phGrano) {
        this.phGrano = phGrano;
    }

    public double getDiametro() {
        return diametro;
    }

    public void setDiametro(double diametro) {
        this.diametro = diametro;
    }

    public double getAltoGrano() {
        return altoGrano;
    }

    public void setAltoGrano(double altoGrano) {
        this.altoGrano = altoGrano;
    }

    public double getCono() {
        return cono;
    }

    public void setCono(double cono) {
        this.cono = cono;
    }

    public double getCopete() {
        return copete;
    }

    public void setCopete(double copete) {
        this.copete = copete;
    }

    public double getTotalm3() {
        return totalm3;
    }

    public void setTotalm3(double totalm3) {
        this.totalm3 = totalm3;
    }

    public double getTotaltons() {
        return totaltons;
    }

    public void setTotaltons(double totaltons) {
        this.totaltons = totaltons;
    }

    @Override
    public String toString() {
        return "SiloEntity{" +
                "id=" + id +
                ", idSilo='" + idSilo + '\'' +
                ", tipoGrano='" + tipoGrano + '\'' +
                ", phGrano=" + phGrano +
                ", diametro=" + diametro +
                ", altoGrano=" + altoGrano +
                ", cono=" + cono +
                ", copete=" + copete +
                ", totalm3=" + totalm3 +
                ", totaltons=" + totaltons +
                '}';
    }
}
