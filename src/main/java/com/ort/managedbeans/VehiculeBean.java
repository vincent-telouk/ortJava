/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ort.managedbeans;

import com.ort.beans.Vehicule;
import com.ort.models.VehiculeModel;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author telou
 */
@Named(value = "vehiculeBean")
@RequestScoped
public class VehiculeBean implements Serializable {

    
    private Vehicule vehicule = new Vehicule();
    
    @EJB
    private VehiculeModel vehiculeModel;
    
    private List<Vehicule> listeVehicule;
    
    /**
     * Creates a new instance of VehiculeBean
     */
    public VehiculeBean() {
    }
    
    public void edit(){
        System.out.println("Dans le controller"+vehicule);
        
        vehiculeModel.create(vehicule);
        //messagesucces
        FacesMessage success=new FacesMessage(FacesMessage.SEVERITY_INFO,"Merci d'avoir ajouter un véhicule",null);        
        FacesContext.getCurrentInstance().addMessage(null, success);
        this.vehicule=new Vehicule();
    }
    
    public void clickEdit(Vehicule vehicule){
        this.vehicule=vehicule;
    }
    
      public void delete(Vehicule vehicule){
        
        vehiculeModel.delete(vehicule);
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    public List<Vehicule> getListeVehicule() {
         listeVehicule = vehiculeModel.read();
         
        return listeVehicule;
    }

    public void setListeVehicule(List<Vehicule> listeVehicule) {
        this.listeVehicule = listeVehicule;
    }
    
    
    
}
