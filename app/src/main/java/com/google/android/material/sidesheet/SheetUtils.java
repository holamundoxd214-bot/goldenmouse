package com.google.android.material.sidesheet;

final class SheetUtils {
    private SheetUtils() {
        super();
    }

    static boolean isSwipeMostlyHorizontal(float arg0, float arg1) {
        if(Math.abs(arg0) > Math.abs(arg1)) {
            return 1;
        }

        return 0;
    }
}

