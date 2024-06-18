package com.example.projetreservationsallereunion.data.models;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.ArrayList;

@DatabaseTable(tableName = "Salle")

public class Salle {

    @DatabaseField(id = true, canBeNull = false, columnName = "id")
    private Long id;

    @DatabaseField
    private String libelle;

    @DatabaseField(dataType = DataType.SERIALIZABLE)
    private ArrayList<Reservation> listReservations = new ArrayList<>();

    public ArrayList<Reservation> getListReservations() {
        return listReservations;
    }

    public void setListReservations(ArrayList<Reservation> listReservations) {
        this.listReservations = listReservations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
