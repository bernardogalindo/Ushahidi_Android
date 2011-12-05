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

package com.ushahidi.android.app.fragments;

import java.lang.reflect.InvocationTargetException;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.ListFragment;
import android.support.v4.view.Menu;
import android.util.Log;
import android.view.MenuInflater;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ushahidi.android.app.BaseApplication;
import com.ushahidi.android.app.R;
import com.ushahidi.android.app.adapters.BaseListAdapter;
import com.ushahidi.android.app.models.Model;
import com.ushahidi.android.app.tasks.ProgressTask;
import com.ushahidi.android.app.views.View;

/**
 * @author eyedol
 */
public abstract class BaseListFragment<V extends View, M extends Model, L extends BaseListAdapter<M>>
        extends ListFragment implements AdapterView.OnItemClickListener,
        AdapterView.OnItemSelectedListener {

    /**
     * ListView resource id
     */
    private final int listViewId;

    /**
     * ListAdpater class
     */
    private final Class<L> adapterClass;

    /**
     * ListAdapter
     */
    private L adapter;

    /**
     * ListView
     */
    private ListView listView;

    /**
     * Menu resource id
     */
    protected final int menu;

    /**
     * BaseListActivity
     * 
     * @param view View class type
     * @param adapter List adapter class type
     * @param layout layout resource id
     * @param menu menu resource id
     * @param listView list view resource id
     */
    protected BaseListFragment(Class<V> view, Class<L> adapter, int layout, int menu, int listView) {
        this.adapterClass = adapter;
        this.listViewId = listView;
        this.menu = menu;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (listViewId != 0) {
            listView = getListView();
            listView.setOnItemClickListener(this);
            android.view.View emptyView = getActivity().findViewById(android.R.id.empty);
            if (emptyView != null) {
                listView.setEmptyView(emptyView);
            }
            if (listView.getCount() == 0) {
                // Start out with a progress indicator.
                setListShown(true);
                setEmptyText(getString(R.string.no_items));
            }
            adapter = createInstance(adapterClass, Context.class, this);
            listView.setAdapter(adapter);
            listView.setFocusable(true);
            listView.setFocusableInTouchMode(true);

        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        if (this.menu != 0) {
            inflater.inflate(this.menu, menu);
        }

    }

    /**
     * Called after ListAdapter has been loaded
     * 
     * @param success true is successfully loaded
     */
    protected abstract void onLoaded(boolean success);

    /*
     * @Override protected void onResume(){ super.onResume(); //new
     * LoadingTask(this).execute((String)null); }
     */

    @SuppressWarnings("unchecked")
    protected M getItem(int position) {
        return (M)listView.getItemAtPosition(position);
    }

    @SuppressWarnings("unchecked")
    protected M getSelectedItem() {
        return (M)listView.getSelectedItem();
    }

    public void onItemSelected(AdapterView<?> adapterView, android.view.View view, int position,
            long id) {
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    /**
     * ProgressTask sub-class for showing Loading... dialog while the
     * BaseListAdapter loads the data
     */
    protected class LoadingTask extends ProgressTask {
        public LoadingTask(FragmentActivity activity) {
            super(activity, R.string.loading_);
        }

        @Override
        protected Boolean doInBackground(String... args) {
            adapter.refresh(activity);
            return true;
        }

        @Override
        protected void onPostExecute(Boolean success) {
            super.onPostExecute(success);
            onLoaded(success);
        }
    }

    protected void log(String message) {
        if (BaseApplication.LOGGING_MODE)
            Log.i(getClass().getName(), message);
    }

    protected void log(String format, Object... args) {
        if (BaseApplication.LOGGING_MODE)
            Log.i(getClass().getName(), String.format(format, args));
    }

    protected void log(String message, Exception ex) {
        if (BaseApplication.LOGGING_MODE)
            Log.e(getClass().getName(), message, ex);
    }

    @SuppressWarnings("unchecked")
    protected <T> T createInstance(Class<?> type, Class<?> constructor, Object... params) {
        try {
            return (T)type.getConstructor(constructor).newInstance(params);
        } catch (InstantiationException e) {
            log("InstantiationException", e);
        } catch (IllegalAccessException e) {
            log("IllegalAccessException", e);
        } catch (InvocationTargetException e) {
            log("InvocationTargetException", e);
        } catch (NoSuchMethodException e) {
            log("NoSuchMethodException", e);
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (java.lang.InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}
