package com.example.projetreservationsallereunion.data.dbManager;

import android.content.Context;

import com.j256.ormlite.android.apptools.OpenHelperManager;

public class DBManager {
    /**
     * variables
     */
    private DBHelper dBHelper = null;

    /**
     * Return DB Helper
     *
     * @return
     */
    public DBHelper getHelper(Context context) {
        if (dBHelper == null) {
            dBHelper = OpenHelperManager.getHelper(context, DBHelper.class);
        }
        return dBHelper;
    }

    /**
     * Release DB Helper
     *
     * @param helper
     */
    public void releaseHelper(DBHelper helper) {
        if (dBHelper != null) {
            OpenHelperManager.releaseHelper();
            dBHelper = null;
        }
    }
}
