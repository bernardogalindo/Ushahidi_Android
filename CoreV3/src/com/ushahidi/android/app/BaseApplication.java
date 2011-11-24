/**
 ** Copyright (c) 2010 Ushahidi Inc
 ** All rights reserved
 ** Contact: team@ushahidi.com
 ** Website: http://www.ushahidi.com
 **
 ** GNU Lesser General Public License Usage
 ** This file may be used under the terms of the GNU Lesser
 ** General Public License version 3 as published by the Free Software
 ** Foundation and appearing in the file LICENSE.LGPL included in the
 ** packaging of this file. Please review the following information to
 ** ensure the GNU Lesser General Public License version 3 requirements
 ** will be met: http://www.gnu.org/licenses/lgpl.html.
 **
 **
 ** If you have questions regarding the use of this file, please contact
 ** Ushahidi developers at team@ushahidi.com.
 **
 **/

package com.ushahidi.android.app;

import android.app.Application;
import android.util.Log;

/**
 * Base application class Your application should extend this base class
 */
public class BaseApplication extends Application {

    /**
     * Allow logging to be turned on or off. Good for development.
     **/
    public static boolean LOGGING_MODE = true;

    protected void log(String message) {
        if (LOGGING_MODE)
            Log.i(getClass().getName(), message);
    }

    protected void log(String format, Object... args) {
        if (LOGGING_MODE)
            Log.i(getClass().getName(), String.format(format, args));
    }

    protected void log(String message, Exception ex) {
        if (LOGGING_MODE)
            Log.e(getClass().getName(), message, ex);
    }
}
