package com.bshmedia.NavigationToggle;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

public class NavigationToggle extends CordovaPlugin {
    private boolean statusBarIsShown = true;

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        try {
            if (action.equals("show") && !this.statusBarIsShown) {
                // TODO

                this.statusBarIsShown = false;
            }
            else if (action.equals("hide") && this.statusBarIsShown) {
                Process proc = Runtime.getRuntime().exec(new String[] { "su", "-c", "service call activity 42 s16 com.android.systemui" }); 
                proc.waitFor();

                this.statusBarIsShown = false;
            }
        }
        catch (Exception exception) {
            // Do nothing.
        }

        PluginResult result = new PluginResult(PluginResult.Status.NO_RESULT, "");
        result.setKeepCallback(true);
        callbackContext.sendPluginResult(result);
        return true;
    }
}