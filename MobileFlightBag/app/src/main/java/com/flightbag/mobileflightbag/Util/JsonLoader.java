package com.flightbag.mobileflightbag.Util;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by casey on 2016-03-27.
 */
public class JsonLoader {

    //Replace with with api if needed
    public static String loadJSONFromAsset(String jsonFile, Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open(jsonFile);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
