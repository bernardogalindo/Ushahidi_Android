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

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;

import com.ushahidi.android.app.R;
import com.ushahidi.android.app.adapters.ListMapAdapter;
import com.ushahidi.android.app.models.ListMapModel;
import com.ushahidi.android.app.tasks.ProgressTask;
import com.ushahidi.android.app.views.ListMapView;

/**
 * @author eyedol
 *
 */
public class ListMapActivity extends BaseListActivity<ListMapView, ListMapModel, ListMapAdapter> {

    public  ListMapActivity() {
        super(ListMapView.class,
              ListMapAdapter.class,
              R.layout.list_map,
              R.menu.list_report,
              R.id.list_map_table);
    }



    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        //toastShort("onItemClick %d", position);
    }

    /**
     * Example of a ProgressTask
     */
    class TaskOne extends ProgressTask {

        public TaskOne(FragmentActivity activity) {
            super(activity, R.string.loading_);
            //pass custom loading message to super call
        }
        @Override
        protected Boolean doInBackground(String... strings) {
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            return true;
        }
    }

    /**
     * Another example of a ProgressTask
     */
    class TaskTwo extends ProgressTask {

        public TaskTwo(FragmentActivity activity) {
            super(activity, R.string.loading_);
            //pass custom loading message to super call
        }
        @Override
        protected Boolean doInBackground(String... strings) {
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            return true;
        }
    }

    @Override
    protected void onLoaded(boolean success) {
        // TODO Auto-generated method stub
        
    }
    

}
