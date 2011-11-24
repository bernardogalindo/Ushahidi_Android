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
import android.content.Context;

/**
 * An extension of {@link com.ushahidi.android.app.BaseActionBarHelper} that
 * provides Android 4.0-specific functionality for IceCreamSandwich devices.
 */
public class ActionBarHelperICS extends BaseActionBarHelper {
    
    protected ActionBarHelperICS(Activity activity) {
        super(activity);
    }
    
    @Override
    public void setRefreshActionItemState(boolean refreshing) {
        // TODO Auto-generated method stub

    }
    
   
    protected Context getActionBarThemedContext() {
        return mActivity.getActionBar().getThemedContext();
    }

}
