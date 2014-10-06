package com.bshmedia.NavigationToggle;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

public class NavigationToggle extends CordovaPlugin {
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        try {
            if (action.equals("show")) {
                // TODO
            }
            else if (action.equals("hide")) {
                Process proc = Runtime.getRuntime().exec(new String[] { "su", "-c", "service call activity 42 s16 com.android.systemui" }); 
                proc.waitFor();

                statusBarIsShown = false;
            }
        }
        catch(Exception ex) {
            // Do nothing.
        }
    }
}