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
            showNavigationBar();
        }
        else if (action.equals("hide") && this.navigationBarIsShown) {
            hideNavigationBar();
        }
        else if (action.equals("toggle")) {
            if (this.navigationBarIsShown) {
                this.hideNavigationBar();
            }
            else {
                this.showNavigationBar();
            }
        }

        // PluginResult result = new PluginResult(PluginResult.Status.NO_RESULT, "");
        // result.setKeepCallback(true);
        // callbackContext.sendPluginResult(result);
        callbackContext.success();
        return true;
    }

    private void showNavigationBar() {
        try {
            Process proc = Runtime.getRuntime().exec(new String[] { "su", "-c", "am startservice --user 0 -n com.android.systemui/.SystemUIService" }); 
            proc.waitFor();

            this.navigationBarIsShown = false;
        }
        catch (Exception e) {
            // Do nothing.
            callbackContext.error(e.getMessage());
            return false;
        }
    }

    private void hideNavigationBar() {
        try {
            Process proc = Runtime.getRuntime().exec(new String[] { "su", "-c", "service call activity 42 s16 com.android.systemui" }); 
            proc.waitFor();

            this.navigationBarIsShown = false;
        }
        catch (Exception e) {
            // Do nothing.
            callbackContext.error(e.getMessage());
            return false;
        }
    }
}