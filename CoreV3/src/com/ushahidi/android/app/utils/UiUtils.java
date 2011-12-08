
package com.ushahidi.android.app.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;

public class UiUtils {

    public static boolean isHoneycomb() {

        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB;
    }

    public static boolean isIceCreamSandwich() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH;
    }

}
