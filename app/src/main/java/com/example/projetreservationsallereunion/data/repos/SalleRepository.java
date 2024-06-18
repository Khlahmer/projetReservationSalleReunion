package com.example.projetreservationsallereunion.data.repos;

import android.content.Context;
import android.util.Log;

import com.example.projetreservationsallereunion.data.dbManager.DBHelper;
import com.example.projetreservationsallereunion.data.dbManager.DBManager;
import com.example.projetreservationsallereunion.data.models.Salle;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalleRepository {

    private static String TAG = "SalleRepository";
    private DBHelper db;
    private Dao<Salle, Long> itemDao;

    public SalleRepository(Context context) {
        DBManager dbManager = new DBManager();
        this.db = dbManager.getHelper(context);
        try {
            itemDao = db.getSalleDao();
        } catch (SQLException e) {
            Log.e(TAG, "(" + e.getMessage() + ")");
        }
    }

    /* --------------------------------------------  READ REPOS  -----------------------------------------*/


    public List<Salle> findAll() {
        List<Salle> aItem = new ArrayList<>();
        try {
            aItem = itemDao.queryForAll();
        } catch (SQLException e) {
            Log.e(TAG, "FindAll(" + e.getMessage() + ")");
        }
        return aItem;
    }


    /* --------------------------------------------  WRITE REPOS  -----------------------------------------*/

    public void insert(Salle salle) {
        try {
            itemDao.create(salle);

        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }
}
