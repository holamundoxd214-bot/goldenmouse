package com.google.android.material.slider;

import java.util.Locale;

public final class BasicLabelFormatter implements LabelFormatter {
    private static final int BILLION = 1000000000;
    private static final int MILLION = 1000000;
    private static final int THOUSAND = 1000;
    private static final long TRILLION = 1000000000000L;

    public BasicLabelFormatter() {
        super();
    }

    public String getFormattedValue(float arg2) {
        float v1 = 999999995904f;
        if(arg2 >= v1) {
            return String.format(Locale.US, "%.1fT", Float.valueOf(arg2 / v1));
        }

        v1 = 1000000000f;
        if(arg2 >= v1) {
            return String.format(Locale.US, "%.1fB", Float.valueOf(arg2 / v1));
        }

        v1 = 1000000f;
        if(arg2 >= v1) {
            return String.format(Locale.US, "%.1fM", Float.valueOf(arg2 / v1));
        }

        v1 = 1000f;
        if(arg2 >= v1) {
            return String.format(Locale.US, "%.1fK", Float.valueOf(arg2 / v1));
        }

        return String.format(Locale.US, "%.0f", Float.valueOf(arg2));
    }
}

