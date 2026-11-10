package com.TryJeanPc.goldenmouse.cursor;

import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FJ\u0016\u0010\u0010\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0011\u001A\u00020\u0012J\u0016\u0010\u0013\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0014\u001A\u00020\u0015R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001E\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\b@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u0017"}, d2={"Lcom/TryJeanPc/goldenmouse/cursor/CursorMotionSettings;", "", "<init>", "()V", "SPEED_KEY", "", "ACCELERATION_KEY", "value", "Lcom/TryJeanPc/goldenmouse/cursor/CursorMotionSettings$Options;", "options", "getOptions", "()Lcom/TryJeanPc/goldenmouse/cursor/CursorMotionSettings$Options;", "load", "", "prefs", "Landroid/content/SharedPreferences;", "setSpeed", "percent", "", "setAcceleration", "enabled", "", "Options", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class CursorMotionSettings {
    @Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\r\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001B\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001A\u00020\u0003HÆ\u0003J\t\u0010\r\u001A\u00020\u0005HÆ\u0003J\u001D\u0010\u000E\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\u000F\u001A\u00020\u00052\b\u0010\u0010\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001A\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001A\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u0014"}, d2={"Lcom/TryJeanPc/goldenmouse/cursor/CursorMotionSettings$Options;", "", "speedPercent", "", "acceleration", "", "<init>", "(IZ)V", "getSpeedPercent", "()I", "getAcceleration", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Options {
        public static final int $stable;
        private final boolean acceleration;
        private final int speedPercent;

        static {
        }

        public Options(int arg1, boolean arg2, int arg3, DefaultConstructorMarker arg4) {
            if((arg3 & 1) != 0) {
                arg1 = 50;
            }

            this(arg1, false);
        }

        public Options(int arg1, boolean arg2) {
            super();
            this.speedPercent = arg1;
            this.acceleration = arg2;
        }

        public Options() {
            this(0, false, 3, null);
        }

        public final int component1() {
            return this.speedPercent;
        }

        public final boolean component2() {
            return this.acceleration;
        }

        public final Options copy(int arg1, boolean arg2) {
            return new Options(arg1, arg2);
        }

        public static Options copy$default(Options arg0, int arg1, boolean arg2, int arg3, Object arg4) {
            if((arg3 & 1) != 0) {
                arg1 = arg0.speedPercent;
            }

            if((arg3 & 2) != 0) {
                arg2 = arg0.acceleration;
            }

            return arg0.copy(arg1, arg2);
        }

        public boolean equals(Object arg5) {
            if(this == (((Options)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof Options)) {
                return 0;
            }

            if(this.speedPercent != ((Options)arg5).speedPercent) {
                return 0;
            }

            if(this.acceleration != ((Options)arg5).acceleration) {
                return 0;
            }

            return 1;
        }

        public final boolean getAcceleration() {
            return this.acceleration;
        }

        public final int getSpeedPercent() {
            return this.speedPercent;
        }

        public int hashCode() {
            return Integer.hashCode(this.speedPercent) * 0x1F + Boolean.hashCode(this.acceleration);
        }

        public String toString() {
            return "Options(speedPercent=" + this.speedPercent + ", acceleration=" + this.acceleration + ")";
        }
    }

    public static final int $stable = 0;
    public static final String ACCELERATION_KEY = "aceleracion_puntero";
    public static final CursorMotionSettings INSTANCE = null;
    public static final String SPEED_KEY = "velocidad_puntero";
    private static volatile Options options;

    static {
        CursorMotionSettings.INSTANCE = new CursorMotionSettings();
        CursorMotionSettings.options = new Options(0, false, 3, null);
        CursorMotionSettings.$stable = 8;
    }

    private CursorMotionSettings() {
        super();
    }

    public final Options getOptions() {
        return CursorMotionSettings.options;
    }

    public final void load(SharedPreferences arg4) {
        Intrinsics.checkNotNullParameter(arg4, "prefs");
        CursorMotionSettings.options = new Options(RangesKt.coerceIn(arg4.getInt("velocidad_puntero", 50), 0, 100), arg4.getBoolean("aceleracion_puntero", false));
    }

    public final void setAcceleration(SharedPreferences arg4, boolean arg5) {
        Intrinsics.checkNotNullParameter(arg4, "prefs");
        CursorMotionSettings.options = Options.copy$default(CursorMotionSettings.options, 0, arg5, 1, null);
        arg4.edit().putBoolean("aceleracion_puntero", arg5).apply();
    }

    public final void setSpeed(SharedPreferences arg4, int arg5) {
        Intrinsics.checkNotNullParameter(arg4, "prefs");
        int v3 = RangesKt.coerceIn(arg5, 0, 100);
        CursorMotionSettings.options = Options.copy$default(CursorMotionSettings.options, v3, false, 2, null);
        arg4.edit().putInt("velocidad_puntero", v3).apply();
    }
}

