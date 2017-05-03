/* Android IMSI-Catcher Detector | (c) AIMSICD Privacy Project
 * -----------------------------------------------------------
 * LICENSE:  http://git.io/vki47 | TERMS:  http://git.io/vki4o
 * -----------------------------------------------------------
 */
package zz.aimsicd.lite.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import zz.aimsicd.lite.R;
import zz.aimsicd.lite.service.AimsicdService;

public class BootCompletedReceiver extends BroadcastReceiver {

    public static final String TAG = "AICDL";
    public static final String mTAG = "XXX";


    @Override
    public void onReceive(Context context, Intent intent) {
        SharedPreferences prefs = context.getSharedPreferences(
                AimsicdService.SHARED_PREFERENCES_BASENAME, 0);
        final String AUTO_START = context.getString(R.string.pref_autostart_key);
        boolean mAutoStart = prefs.getBoolean(AUTO_START, false);
        if (mAutoStart) {
            Log.i(TAG, mTAG + "System booted starting service.");
            context.startService(new Intent(context, AimsicdService.class));
        }
    }
}
