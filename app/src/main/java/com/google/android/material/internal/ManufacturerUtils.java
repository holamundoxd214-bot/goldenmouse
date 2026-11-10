package com.google.android.material.internal;

import android.os.Build;
import java.util.Locale;

public class ManufacturerUtils {
    private static final String LGE = "lge";
    private static final String MEIZU = "meizu";
    private static final String SAMSUNG = "samsung";

    private ManufacturerUtils() {
        super();
    }

    private static String getManufacturer() {
        String v0 = Build.MANUFACTURER;
        if(v0 != null) {
            return v0.toLowerCase(Locale.ENGLISH);
        }

        return "";
    }

    public static boolean isDateInputKeyboardMissingSeparatorCharacters() {
        if(!ManufacturerUtils.isLGEDevice()) {
            if(ManufacturerUtils.isSamsungDevice()) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public static boolean isLGEDevice() {
        return ManufacturerUtils.getManufacturer().equals("lge");
    }

    public static boolean isMeizuDevice() {
        return ManufacturerUtils.getManufacturer().equals("meizu");
    }

    public static boolean isSamsungDevice() {
        return ManufacturerUtils.getManufacturer().equals("samsung");
    }
}

