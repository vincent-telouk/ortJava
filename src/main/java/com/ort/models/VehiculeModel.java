/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ort.models;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import com.ort.beans.Vehicule;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.bson.Document;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 *
 * @author telou
 */
@Stateless
public class VehiculeModel {
    // injecter l'EJB Singleton de connexion
    @EJB
    MongoClientProvider mongoClientProvider;

    // variables mongodb
    private MongoClient mongoClient;
    private MongoDatabase mongoDatabase;
    private MongoCollection<Vehicule> collection;


@PostConstruct
    public void init() {
        mongoClient = mongoClientProvider.getMongoClient();
        //This registry is required for your Mongo document to POJO conversion
        CodecRegistry codecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(), fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        //ouverture
        mongoDatabase = mongoClient.getDatabase("vehiloc").withCodecRegistry(codecRegistry);
        collection = mongoDatabase.getCollection("vehicule",Vehicule.class);
    }
    
    //crée un véhicule
    //public void create (Vehicule vehicule){
    //    Document document = new Document();
      //  document.put("immatriculation", vehicule.getImmatriculation());
     //   document.put("description", vehicule.getDescription());
      //  document.put("dateAchat", vehicule.getDateAchat());
      //  document.put("tarifActuel", vehicule.getTarifActuel());
      //  document.put("kilometrage", vehicule.getKilometrage());
      //  collection.insertOne(document);
    //}
    // créer un objet
    public void create(Vehicule vehicule) {
        collection.insertOne(vehicule);
    }
    
 //lire mes enregistrements
    public List<Vehicule> read(){
        List<Vehicule> liste=new ArrayList<>();
        collection.find().iterator().forEachRemaining(liste::add);
        return liste;
    }
    
    public void delete(Vehicule vehicule){
        collection.deleteOne(eq("immatriculation", vehicule.getImmatriculation()));
    }
    
        public void update(Vehicule vehicule){
        collection.updateOne(eq("immatriculation", vehicule.getImmatriculation()));
    }
}
