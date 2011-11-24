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

package com.ushahidi.android.app.helpers;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;

/**
 * An abstract class that handles some common action bar-related functionality
 * in the app. This class provides functionality useful for both phones and
 * tablets, and does not require any Android 3.0-specific features, although it
 * uses them if available. Two implementations of this class are
 * {@link ActionBarHelperBase} for a pre-Honeycomb version of the action bar,
 * and {@link ActionBarHelperHoneycomb}, which uses the built-in ActionBar
 * features in Android 3.0 and later.
 */
public abstract class BaseActionBarHelper {
    protected Activity mActivity;

    /**
     * Factory method for creating {@link BaseActionBarHelper} objects for a
     * given activity. Depending on which device the app is running, either a
     * basic helper or Honeycomb-specific helper will be returned.
     */
    public static BaseActionBarHelper createInstance(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            Log.i("ActionBarHelperBase","createInstance1"+Build.VERSION.SDK_INT);
            return new ActionBarHelperICS(activity);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            Log.i("ActionBarHelperBase","createInstance2"+Build.VERSION.SDK_INT);
            return new ActionBarHelperHoneycomb(activity);
        } else {
            Log.i("ActionBarHelperBase","createInstance3"+Build.VERSION.SDK_INT);
            return new ActionBarHelperBase(activity);
        }
    }
    
    public BaseActionBarHelper(Activity activity) {
        mActivity = activity;
    }

    /**
     * Base action bar helper code to be run in
     * {@link Activity#onCreate(android.os.Bundle)}.
     */
    public void onCreate(Bundle savedInstanceState) {
    }

    /**
     * Base action bar helper code to be run in
     * {@link Activity#onPostCreate(android.os.Bundle)}.
     */
    public void onPostCreate(Bundle savedInstanceState) {
    }

    /**
     * Action bar helper code to be run in
     * {@link Activity#onCreateOptionsMenu(android.view.Menu)}.
     */
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    /**
     * Action bar helper code to be run in
     * {@link Activity#onTitleChanged(CharSequence, int)}.
     */
    public void onTitleChanged(CharSequence title, int color) {
    }

    /**
     * Sets the indeterminate loading state of the item with ID
     * {@link R.id.menu_refresh}. (where the item ID was menu_refresh).
     */
    public abstract void setRefreshActionItemState(boolean refreshing);

    /**
     * Returns a {@link MenuInflater} for use when inflating menus. The
     * implementation of this method in {@link ActionBarHelperBase} returns a
     * wrapped menu inflater that can read action bar metadata from a menu
     * resource pre-Honeycomb.
     */
    public MenuInflater getMenuInflater(MenuInflater superMenuInflater) {
        return superMenuInflater;
    }
}
