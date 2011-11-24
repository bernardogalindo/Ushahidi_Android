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

package com.ushahidi.android.app.activities;

import com.google.android.maps.MapActivity;
import com.ushahidi.android.app.helpers.BaseActionBarHelper;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

/**
 * A base activity that defers common functionality across app activities to an
 * {@link ActionBarHelper}.
 */

public abstract class BaseActionBarMapActivity extends MapActivity {
    
    final BaseActionBarHelper mBaseActionBarHelper = BaseActionBarHelper.createInstance(this);
    
    /**
     * Returns the {@link BaseActionBarHelper} for this activity.
     */
    protected BaseActionBarHelper getActionBarHelper() {
        return mBaseActionBarHelper;
    }

    /** {@inheritDoc} */
    @Override
    public MenuInflater getMenuInflater() {
        return mBaseActionBarHelper.getMenuInflater(super.getMenuInflater());
    }

    /** {@inheritDoc} */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBaseActionBarHelper.onCreate(savedInstanceState);
    }

    /** {@inheritDoc} */
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mBaseActionBarHelper.onPostCreate(savedInstanceState);
    }

    /**
     * Base action bar-aware implementation for
     * {@link Activity#onCreateOptionsMenu(android.view.Menu)}. Note: marking
     * menu items as invisible/visible is not currently supported.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        boolean retValue = false;
        retValue |= mBaseActionBarHelper.onCreateOptionsMenu(menu);
        retValue |= super.onCreateOptionsMenu(menu);
        return retValue;
    }

    /** {@inheritDoc} */
    @Override
    protected void onTitleChanged(CharSequence title, int color) {
        mBaseActionBarHelper.onTitleChanged(title, color);
        super.onTitleChanged(title, color);
    }
}
