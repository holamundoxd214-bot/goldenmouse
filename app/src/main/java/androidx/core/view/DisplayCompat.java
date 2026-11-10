package androidx.core.view;

import android.app.UiModeManager;
import android.content.Context;
import android.graphics.Point;
import android.os.Build$VERSION;
import android.os.Build;
import android.text.TextUtils;
import android.view.Display$Mode;
import android.view.Display;
import androidx.core.util.Preconditions;
import java.util.Objects;

public final class DisplayCompat {
    class Api23Impl {
        private Api23Impl() {
            super();
        }

        static ModeCompat getMode(Context arg1, Display arg2) {
            Display$Mode v0 = arg2.getMode();
            Point v1 = DisplayCompat.getCurrentDisplaySizeFromWorkarounds(arg1, arg2);
            if(v1 != null) {
                if(Api23Impl.physicalSizeEquals(v0, v1)) {
                }
                else {
                    return new ModeCompat(v0, v1);
                }
            }

            return new ModeCompat(v0, true);
        }

        public static ModeCompat[] getSupportedModes(Context arg6, Display arg7) {
            Display$Mode[] v0 = arg7.getSupportedModes();
            ModeCompat[] v1 = new ModeCompat[v0.length];
            Display$Mode v2 = arg7.getMode();
            Point v6 = DisplayCompat.getCurrentDisplaySizeFromWorkarounds(arg6, arg7);
            int v7 = 0;
            if(v6 == null || (Api23Impl.physicalSizeEquals(v2, v6))) {
                while(v7 < v0.length) {
                    v1[v7] = new ModeCompat(v0[v7], Api23Impl.physicalSizeEquals(v0[v7], v2));
                    ++v7;
                }
            }
            else {
                int v3;
                for(v3 = 0; v3 < v0.length; ++v3) {
                    ModeCompat v4 = Api23Impl.physicalSizeEquals(v0[v3], v2) ? new ModeCompat(v0[v3], v6) : new ModeCompat(v0[v3], false);
                    v1[v3] = v4;
                }
            }

            return v1;
        }

        static boolean isCurrentModeTheLargestMode(Display arg7) {
            Display$Mode v0 = arg7.getMode();
            Display$Mode[] v7 = arg7.getSupportedModes();
            int v1 = v7.length;
            int v3 = 0;
            while(true) {
                if(v3 >= v1) {
                    return 1;
                }

                Display$Mode v4 = v7[v3];
                if(v0.getPhysicalHeight() >= v4.getPhysicalHeight()) {
                    if(v0.getPhysicalWidth() < v4.getPhysicalWidth()) {
                    }
                    else {
                        ++v3;
                        continue;
                    }
                }

                return 0;
            }

            return 0;
        }

        static boolean physicalSizeEquals(Display$Mode arg2, Point arg3) {
            if(arg2.getPhysicalWidth() == arg3.x && arg2.getPhysicalHeight() == arg3.y || arg2.getPhysicalWidth() == arg3.y && arg2.getPhysicalHeight() == arg3.x) {
                return 1;
            }

            return 0;
        }

        static boolean physicalSizeEquals(Display$Mode arg2, Display$Mode arg3) {
            if(arg2.getPhysicalWidth() == arg3.getPhysicalWidth() && arg2.getPhysicalHeight() == arg3.getPhysicalHeight()) {
                return 1;
            }

            return 0;
        }
    }

    public final class ModeCompat {
        private final boolean mIsNative;
        private final Display$Mode mMode;
        private final Point mPhysicalSize;

        ModeCompat(Display$Mode arg2, Point arg3) {
            super();
            Preconditions.checkNotNull(arg2, "mode == null, can\'t wrap a null reference");
            Preconditions.checkNotNull(arg3, "physicalSize == null");
            this.mPhysicalSize = arg3;
            this.mMode = arg2;
            this.mIsNative = true;
        }

        ModeCompat(Display$Mode arg4, boolean arg5) {
            super();
            Preconditions.checkNotNull(arg4, "mode == null, can\'t wrap a null reference");
            this.mPhysicalSize = new Point(arg4.getPhysicalWidth(), arg4.getPhysicalHeight());
            this.mMode = arg4;
            this.mIsNative = arg5;
        }

        ModeCompat(Point arg2) {
            super();
            Preconditions.checkNotNull(arg2, "physicalSize == null");
            this.mPhysicalSize = arg2;
            this.mMode = null;
            this.mIsNative = true;
        }

        public int getPhysicalHeight() {
            return this.mPhysicalSize.y;
        }

        public int getPhysicalWidth() {
            return this.mPhysicalSize.x;
        }

        @Deprecated public boolean isNative() {
            return this.mIsNative;
        }

        public Display$Mode toMode() {
            return this.mMode;
        }
    }

    private static final int DISPLAY_SIZE_4K_HEIGHT = 0x870;
    private static final int DISPLAY_SIZE_4K_WIDTH = 0xF00;

    private DisplayCompat() {
        super();
    }

    static Point getCurrentDisplaySizeFromWorkarounds(Context arg2, Display arg3) {
        Point v0 = Build$VERSION.SDK_INT < 28 ? DisplayCompat.parsePhysicalDisplaySizeFromSystemProperties("sys.display-size", arg3) : DisplayCompat.parsePhysicalDisplaySizeFromSystemProperties("vendor.display-size", arg3);
        if(v0 != null) {
            return v0;
        }

        v0 = null;
        if((DisplayCompat.isSonyBravia4kTv(arg2)) && (DisplayCompat.isCurrentModeTheLargestMode(arg3))) {
            return new Point(0xF00, 0x870);
        }

        return v0;
    }

    public static ModeCompat getMode(Context arg0, Display arg1) {
        return Api23Impl.getMode(arg0, arg1);
    }

    public static RoundedCornerCompat getRoundedCorner(Display arg2, int arg3) {
        if(Build$VERSION.SDK_INT >= 0x1F) {
            return RoundedCornerCompat.toRoundedCornerCompat(arg2.getRoundedCorner(arg3));
        }

        return null;
    }

    public static DisplayShapeCompat getShape(Context arg11, Display arg12) {
        Objects.requireNonNull(arg11);
        Objects.requireNonNull(arg12);
        if(Build$VERSION.SDK_INT >= 34) {
            return DisplayShapeCompat.toDisplayShapeCompat(arg12.getShape());
        }

        Point v11 = DisplayCompat.getCurrentDisplaySizeFromWorkarounds(arg11, arg12);
        int v0 = 0;
        RoundedCornerCompat v1 = DisplayCompat.getRoundedCorner(arg12, 0);
        RoundedCornerCompat v2 = DisplayCompat.getRoundedCorner(arg12, 1);
        RoundedCornerCompat v3 = DisplayCompat.getRoundedCorner(arg12, 2);
        RoundedCornerCompat v12 = DisplayCompat.getRoundedCorner(arg12, 3);
        int v4 = v11.x;
        int v5 = v11.y;
        int v7 = v1 != null ? v1.getRadius() : 0;
        int v8 = v2 != null ? v2.getRadius() : 0;
        int v9 = v3 != null ? v3.getRadius() : 0;
        if(v12 != null) {
            v0 = v12.getRadius();
        }

        return DisplayShapeCompat.create(v4, v5, false, v7, v8, v9, v0);
    }

    public static ModeCompat[] getSupportedModes(Context arg0, Display arg1) {
        return Api23Impl.getSupportedModes(arg0, arg1);
    }

    private static String getSystemProperty(String arg5) {
        try {
            Class v0 = Class.forName("android.os.SystemProperties");
            return v0.getMethod("get", String.class).invoke(v0, arg5);
        }
        catch(Exception ) {
            return null;
        }
    }

    static boolean isCurrentModeTheLargestMode(Display arg0) {
        return Api23Impl.isCurrentModeTheLargestMode(arg0);
    }

    private static boolean isSonyBravia4kTv(Context arg2) {
        if((DisplayCompat.isTv(arg2)) && ("Sony".equals(Build.MANUFACTURER)) && (Build.MODEL.startsWith("BRAVIA")) && (arg2.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd"))) {
            return 1;
        }

        return 0;
    }

    private static boolean isTv(Context arg1) {
        Object v1 = arg1.getSystemService("uimode");
        if(v1 != null && ((UiModeManager)v1).getCurrentModeType() == 4) {
            return 1;
        }

        return 0;
    }

    private static Point parseDisplaySize(String arg2) throws NumberFormatException {
        String[] v2 = arg2.trim().split("x", -1);
        if(v2.length == 2) {
            int v0 = Integer.parseInt(v2[0]);
            int v2_1 = Integer.parseInt(v2[1]);
            if(v0 > 0 && v2_1 > 0) {
                return new Point(v0, v2_1);
            }
        }

        throw new NumberFormatException();
    }

    private static Point parsePhysicalDisplaySizeFromSystemProperties(String arg1, Display arg2) {
        Point v0 = null;
        if(arg2.getDisplayId() != 0) {
            return v0;
        }

        arg1 = DisplayCompat.getSystemProperty(arg1);
        if(!TextUtils.isEmpty(((CharSequence)arg1))) {
            if(arg1 == null) {
            }
            else {
                try {
                    return DisplayCompat.parseDisplaySize(arg1);
                }
                catch(NumberFormatException ) {
                    return v0;
                }
            }
        }

        return v0;
    }
}

