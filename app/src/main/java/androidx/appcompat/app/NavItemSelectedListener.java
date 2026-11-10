package androidx.appcompat.app;

import android.view.View;
import android.widget.AdapterView$OnItemSelectedListener;
import android.widget.AdapterView;

class NavItemSelectedListener implements AdapterView$OnItemSelectedListener {
    private final OnNavigationListener mListener;

    public NavItemSelectedListener(OnNavigationListener arg1) {
        super();
        this.mListener = arg1;
    }

    public void onItemSelected(AdapterView arg1, View arg2, int arg3, long arg4) {
        OnNavigationListener v0 = this.mListener;
        if(v0 != null) {
            v0.onNavigationItemSelected(arg3, arg4);
        }
    }

    public void onNothingSelected(AdapterView arg1) {
    }
}

