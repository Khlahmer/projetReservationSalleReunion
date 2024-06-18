package com.example.projetreservationsallereunion.data.dbManager;

import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;

import java.io.IOException;
import java.sql.SQLException;

public class DBConfig extends OrmLiteConfigUtil {

    public static void main(String args[]) throws IOException, SQLException {
        writeConfigFile("ormlite_config.txt");
    }
}
