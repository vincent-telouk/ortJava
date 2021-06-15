/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ort.beans;

import java.util.Date;
import org.bson.types.ObjectId;

/**
 *
 * @author telou
 */
public class Vehicule {
    
    private ObjectId _id;
    private String immatriculation;
    private String description;
    private Date dateAchat = new Date();
    private int tarifActuel;
    private int kilometrage;

    public Vehicule() {
    }

    
    
    public Vehicule(String immatriculation, String description, int tarifActuel, int kilometrage) {
        this.immatriculation = immatriculation;
        this.description = description;
        this.tarifActuel = tarifActuel;
        this.kilometrage = kilometrage;
    }
    
    

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public int getTarifActuel() {
        return tarifActuel;
    }

    public void setTarifActuel(int tarifActuel) {
        this.tarifActuel = tarifActuel;
    }

    public int getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(int kilometrage) {
        this.kilometrage = kilometrage;
    }

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    
    @Override
    public String toString() {
        return "Vehicule{" + "immatriculation=" + immatriculation + ", description=" + description + ", dateAchat=" + dateAchat + ", tarifArgus=" + tarifActuel + ", kilometrageActuel=" + kilometrage + '}';
    }
    
    
}
