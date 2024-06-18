package com.example.projetreservationsallereunion.data.repos;

import android.content.Context;
import android.util.Log;

import com.example.projetreservationsallereunion.data.dbManager.DBHelper;
import com.example.projetreservationsallereunion.data.dbManager.DBManager;
import com.example.projetreservationsallereunion.data.models.Reservation;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationRepository {
    private static String TAG = "ReservationRepository";
    private DBHelper db;
    private Dao<Reservation, Long> itemDao;

    public ReservationRepository(Context context) {
        DBManager dbManager = new DBManager();
        this.db = dbManager.getHelper(context);
        try {
            itemDao = db.getReservationDao();
        } catch (SQLException e) {
            Log.e(TAG, "(" + e.getMessage() + ")");
        }
    }

    /* --------------------------------------------  READER REPOS  -----------------------------------------*/


    public List<Reservation> findAll() {
        List<Reservation> aItem = new ArrayList<>();
        try {
            aItem = itemDao.queryForAll();
        } catch (SQLException e) {
            Log.e(TAG, "FindAll(" + e.getMessage() + ")");
        }
        return aItem;
    }

    public List<Reservation> findAllByIdSalle(Long idSalle) {
        List<Reservation> aItem = new ArrayList<>();
        try {
            aItem = itemDao.queryBuilder().where().eq("idSalle", idSalle).query();
        } catch (SQLException e) {
            Log.e(TAG, "FindAll(" + e.getMessage() + ")");
        }
        return aItem;
    }

}
