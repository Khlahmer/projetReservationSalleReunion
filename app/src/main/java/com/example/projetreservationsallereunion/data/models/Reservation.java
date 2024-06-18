package com.example.projetreservationsallereunion.data.models;

import androidx.annotation.NonNull;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.text.SimpleDateFormat;
import java.util.Date;

@DatabaseTable(tableName = "Reservation")

public class Reservation {
    @DatabaseField(id = true, canBeNull = false, columnName = "id")

    private Long id;

    @DatabaseField
    private Long dateDebut;

    @DatabaseField
    private Long dateFin;

    @DatabaseField
    private Long idSalle;

    public Reservation() {
    }

    public static String dateTimeStringFromTimeStamp(long timestamp) {
        Date date = new Date(timestamp);

        // Format the date according to your desired format
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Long dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Long getDateFin() {
        return dateFin;
    }

    public void setDateFin(Long dateFin) {
        this.dateFin = dateFin;
    }

    public Long getIdSalle() {
        return idSalle;
    }

    public void setIdSalle(Long idSalle) {
        this.idSalle = idSalle;
    }
}
