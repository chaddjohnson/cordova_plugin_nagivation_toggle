package org.bshmedia.navigationToggle;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

public class NavigationToggle extends CordovaPlugin {
    private boolean navigationBarIsShown = true;

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("show") && !this.navigationBarIsShown) {
            showNavigationBar(callbackContext);
        }
        else if (action.equals("hide") && this.navigationBarIsShown) {
            hideNavigationBar(callbackContext);
        }
        else if (action.equals("toggle")) {
            if (this.navigationBarIsShown) {
                this.hideNavigationBar(callbackContext);
            }
            else {
                this.showNavigationBar(callbackContext);
            }
        }

        PluginResult result = new PluginResult(PluginResult.Status.NO_RESULT, "");
        result.setKeepCallback(true);
        callbackContext.sendPluginResult(result);
        return true;
    }

    private void showNavigationBar(CallbackContext callbackContext) {
        try {
            Process proc = Runtime.getRuntime().exec(new String[] { "su", "-c", "LD_LIBRARY_PATH=/vendor/lib:/system/lib am startservice -n com.android.systemui/.SystemUIService" }); 
            proc.waitFor();

            this.navigationBarIsShown = true;
        }
        catch (Exception e) {
            callbackContext.error(e.getMessage());
        }
    }

    private void hideNavigationBar(CallbackContext callbackContext) {
        try {
            Process proc = Runtime.getRuntime().exec(new String[] { "su", "-c", "LD_LIBRARY_PATH=/vendor/lib:/system/lib service call activity 42 s16 com.android.systemui" }); 
            proc.waitFor();

            this.navigationBarIsShown = false;
        }
        catch (Exception e) {
            callbackContext.error(e.getMessage());
        }
    }
}