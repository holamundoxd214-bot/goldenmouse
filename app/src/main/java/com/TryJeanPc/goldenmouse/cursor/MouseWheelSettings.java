package com.TryJeanPc.goldenmouse.cursor;

import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0012J\u0016\u0010\u0013\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0006\u001A\u00020\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001E\u0010\b\u001A\u00020\u00072\u0006\u0010\u0006\u001A\u00020\u0007@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u001E\u0010\f\u001A\u00020\u000B2\u0006\u0010\u0006\u001A\u00020\u000B@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000E¨\u0006\u0014"}, d2={"Lcom/TryJeanPc/goldenmouse/cursor/MouseWheelSettings;", "", "<init>", "()V", "KEY", "", "value", "", "percent", "getPercent", "()I", "", "revision", "getRevision", "()J", "load", "", "prefs", "Landroid/content/SharedPreferences;", "set", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class MouseWheelSettings {
    public static final int $stable = 0;
    public static final MouseWheelSettings INSTANCE = null;
    public static final String KEY = "sensibilidad_rueda";
    private static volatile int percent;
    private static volatile long revision;

    static {
        MouseWheelSettings.INSTANCE = new MouseWheelSettings();
        MouseWheelSettings.percent = 50;
        MouseWheelSettings.$stable = 8;
    }

    private MouseWheelSettings() {
        super();
    }

    public final int getPercent() {
        return MouseWheelSettings.percent;
    }

    public final long getRevision() {
        return MouseWheelSettings.revision;
    }

    public final void load(SharedPreferences arg3) {
        Intrinsics.checkNotNullParameter(arg3, "prefs");
        MouseWheelSettings.percent = RangesKt.coerceIn(arg3.getInt("sensibilidad_rueda", 50), 0, 100);
        ++MouseWheelSettings.revision;
    }

    public final void set(SharedPreferences arg5, int arg6) {
        Intrinsics.checkNotNullParameter(arg5, "prefs");
        MouseWheelSettings.percent = RangesKt.coerceIn(arg6, 0, 100);
        ++MouseWheelSettings.revision;
        arg5.edit().putInt("sensibilidad_rueda", MouseWheelSettings.percent).apply();
    }
}

