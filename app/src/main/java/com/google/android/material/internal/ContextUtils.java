package com.google.android.material.internal;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;

public class ContextUtils {
    public ContextUtils() {
        super();
    }

    public static Activity getActivity(Context arg1) {
        while((arg1 instanceof ContextWrapper)) {
            if((arg1 instanceof Activity)) {
                return arg1;
            }

            arg1 = ((ContextWrapper)arg1).getBaseContext();
        }

        return null;
    }
}

