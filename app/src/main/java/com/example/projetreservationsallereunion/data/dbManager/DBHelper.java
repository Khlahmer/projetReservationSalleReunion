package com.example.projetreservationsallereunion.data.dbManager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.projetreservationsallereunion.data.models.Reservation;
import com.example.projetreservationsallereunion.data.models.Salle;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class DBHelper extends OrmLiteSqliteOpenHelper {
    private static final String TAG = "DBHelper";

    private Dao<Salle, Long> salleDao = null;
    private RuntimeExceptionDao<Salle, Long> salleRuntimeExceptionDao = null;

    private Dao<Reservation, Long> reservationDao = null;
    private RuntimeExceptionDao<Reservation, Long> reservationRuntimeExceptionDao = null;

    public DBHelper(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Reservation.class);
            TableUtils.createTable(connectionSource, Salle.class);

        } catch (Exception e) {
            Log.e(TAG, e.getMessage());

        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

    }

    public Dao<Salle, Long> getSalleDao() throws SQLException {
        if (salleDao == null) {
            salleDao = getDao(Salle.class);
        }
        return salleDao;
    }

    public Dao<Reservation, Long> getReservationDao() throws SQLException {
        if (reservationDao == null) {
            reservationDao = getDao(Reservation.class);
        }
        return reservationDao;
    }


    /**
     * Return SalleDAO RuntimeException
     *
     * @return
     */
    public RuntimeExceptionDao<Salle, Long> getSalleRuntimeExceptionDao() {
        if (salleRuntimeExceptionDao == null) {
            salleRuntimeExceptionDao = getRuntimeExceptionDao(Salle.class);
        }
        return salleRuntimeExceptionDao;
    }

    /**
     * Return ReservationDAO RuntimeException
     *
     * @return
     */
    public RuntimeExceptionDao<Reservation, Long> getReservationRuntimeExceptionDao() {
        if (reservationRuntimeExceptionDao == null) {
            reservationRuntimeExceptionDao = getRuntimeExceptionDao(Reservation.class);
        }
        return reservationRuntimeExceptionDao;
    }
}