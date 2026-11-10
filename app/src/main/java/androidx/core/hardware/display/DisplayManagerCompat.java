package androidx.core.hardware.display;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build$VERSION;
import android.view.Display;
import java.util.Objects;

public final class DisplayManagerCompat {
    static final String DISPLAY_CATEGORY_ALL = "android.hardware.display.category.ALL_INCLUDING_DISABLED";
    public static final String DISPLAY_CATEGORY_BUILT_IN_DISPLAYS = "android.hardware.display.category.BUILT_IN_DISPLAYS";
    public static final String DISPLAY_CATEGORY_PRESENTATION = "android.hardware.display.category.PRESENTATION";
    static final int DISPLAY_TYPE_INTERNAL = 1;
    private final Context mContext;

    private DisplayManagerCompat(Context arg1) {
        super();
        this.mContext = arg1;
    }

    private static Display[] computeBuiltInDisplays(DisplayManager arg6) {
        Display[] v6 = Build$VERSION.SDK_INT >= 33 ? arg6.getDisplays("android.hardware.display.category.ALL_INCLUDING_DISABLED") : arg6.getDisplays();
        Display[] v1 = new Display[DisplayManagerCompat.numberOfDisplaysByType(1, v6)];
        int v2 = 0;
        int v3 = 0;
        while(v2 < v6.length) {
            Display v4 = v6[v2];
            if(1 == DisplayManagerCompat.getTypeCompat(v4)) {
                v1[v3] = v4;
                ++v3;
            }

            ++v2;
        }

        return v1;
    }

    public Display getDisplay(int arg2) {
        return this.mContext.getSystemService("display").getDisplay(arg2);
    }

    public Display[] getDisplays() {
        return this.mContext.getSystemService("display").getDisplays();
    }

    public Display[] getDisplays(String arg4) {
        String v1 = "display";
        Object v0 = this.mContext.getSystemService(v1);
        if("android.hardware.display.category.BUILT_IN_DISPLAYS".equals(arg4)) {
            return DisplayManagerCompat.computeBuiltInDisplays(((DisplayManager)v0));
        }

        return this.mContext.getSystemService(v1).getDisplays(arg4);
    }

    public static DisplayManagerCompat getInstance(Context arg1) {
        return new DisplayManagerCompat(arg1);
    }

    static int getTypeCompat(Display arg4) {
        try {
            return Objects.requireNonNull(Display.class.getMethod("getType").invoke(arg4)).intValue();
        }
        catch(Exception v4) {
            throw new RuntimeException(((Throwable)v4));
        }
        catch(NoSuchMethodException ) {
            return 0;
        }
    }

    private static int numberOfDisplaysByType(int arg3, Display[] arg4) {
        int v0 = 0;
        int v1 = 0;
        while(v0 < arg4.length) {
            if(arg3 == DisplayManagerCompat.getTypeCompat(arg4[v0])) {
                ++v1;
            }

            ++v0;
        }

        return v1;
    }
}

