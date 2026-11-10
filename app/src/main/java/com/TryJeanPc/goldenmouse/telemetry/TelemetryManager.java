package com.TryJeanPc.goldenmouse.telemetry;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.WindowManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u000E\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001)B#\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000E\u0010\u001B\u001A\u00020\u001C2\u0006\u0010\u001D\u001A\u00020\u0007J\b\u0010\u001E\u001A\u00020\u001CH\u0002J\u000E\u0010\u001F\u001A\u00020\u001C2\u0006\u0010 \u001A\u00020\u0007J\u000E\u0010!\u001A\u00020\u001C2\u0006\u0010 \u001A\u00020\u0007J\u000E\u0010\"\u001A\u00020\u001C2\u0006\u0010 \u001A\u00020\u0007J\u000E\u0010#\u001A\u00020\u001C2\u0006\u0010 \u001A\u00020\u0007J\u000E\u0010$\u001A\u00020\u001C2\u0006\u0010 \u001A\u00020\u0007J\u000E\u0010%\u001A\u00020\u001C2\u0006\u0010 \u001A\u00020\u0007J\u000E\u0010&\u001A\u00020\u001C2\u0006\u0010 \u001A\u00020\u0007J\b\u0010\'\u001A\u00020\u001CH\u0002J\u0006\u0010(\u001A\u00020\u001CR\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u000FX\u0082\u0004¢\u0006\u0002\n\u0000R\u001E\u0010\u0011\u001A\u00020\u00072\u0006\u0010\u0010\u001A\u00020\u0007@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u001E\u0010\u0013\u001A\u00020\u00072\u0006\u0010\u0010\u001A\u00020\u0007@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0012R\u001E\u0010\u0014\u001A\u00020\u00072\u0006\u0010\u0010\u001A\u00020\u0007@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0012R\u001E\u0010\u0015\u001A\u00020\u00072\u0006\u0010\u0010\u001A\u00020\u0007@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0012R\u001E\u0010\u0016\u001A\u00020\u00072\u0006\u0010\u0010\u001A\u00020\u0007@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0012R\u001E\u0010\u0017\u001A\u00020\u00072\u0006\u0010\u0010\u001A\u00020\u0007@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0012R\u001E\u0010\u0018\u001A\u00020\u00072\u0006\u0010\u0010\u001A\u00020\u0007@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0012R\u000E\u0010\u0019\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001A\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006*"}, d2={"Lcom/TryJeanPc/goldenmouse/telemetry/TelemetryManager;", "", "context", "Landroid/content/Context;", "windowManager", "Landroid/view/WindowManager;", "initiallyVisible", "", "<init>", "(Landroid/content/Context;Landroid/view/WindowManager;Z)V", "prefs", "Landroid/content/SharedPreferences;", "overlay", "Lcom/TryJeanPc/goldenmouse/telemetry/BluestacksOsdOverlay;", "fpsCalculator", "Lcom/TryJeanPc/goldenmouse/telemetry/FpsCalculator;", "value", "isBluestacksEnabled", "()Z", "isFpsActive", "isPingActive", "isCpuActive", "isRamActive", "isTempActive", "isHoraActive", "sessionVisible", "destroyed", "setSessionVisible", "", "visible", "reconcileVisualWork", "setBluestacksEnabled", "enabled", "setFpsEnabled", "setPingEnabled", "setCpuEnabled", "setRamEnabled", "setTempEnabled", "setHoraEnabled", "detenerOsd", "destroy", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class TelemetryManager {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2={"Lcom/TryJeanPc/goldenmouse/telemetry/TelemetryManager$Companion;", "", "<init>", "()V", "PREFS_NAME", "", "KEY_OSD_BLUESTACKS_ENABLED", "KEY_FPS_ENABLED", "KEY_PING_ENABLED", "KEY_CPU_ENABLED", "KEY_RAM_ENABLED", "KEY_TEMP_ENABLED", "KEY_HORA_ENABLED", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    public static final int $stable = 0;
    public static final Companion Companion = null;
    public static final String KEY_CPU_ENABLED = "pref_cpu_enabled";
    public static final String KEY_FPS_ENABLED = "pref_fps_enabled";
    public static final String KEY_HORA_ENABLED = "pref_hora_enabled";
    public static final String KEY_OSD_BLUESTACKS_ENABLED = "pref_osd_bluestacks_enabled";
    public static final String KEY_PING_ENABLED = "pref_ping_enabled";
    public static final String KEY_RAM_ENABLED = "pref_ram_enabled";
    public static final String KEY_TEMP_ENABLED = "pref_temp_enabled";
    public static final String PREFS_NAME = "GoldenMouseConfig";
    private final Context context;
    private boolean destroyed;
    private final FpsCalculator fpsCalculator;
    private boolean isBluestacksEnabled;
    private boolean isCpuActive;
    private boolean isFpsActive;
    private boolean isHoraActive;
    private boolean isPingActive;
    private boolean isRamActive;
    private boolean isTempActive;
    private final BluestacksOsdOverlay overlay;
    private final SharedPreferences prefs;
    private boolean sessionVisible;

    static {
        TelemetryManager.Companion = new Companion(null);
        TelemetryManager.$stable = 8;
    }

    public TelemetryManager(Context arg10, WindowManager arg11, boolean arg12) {
        Intrinsics.checkNotNullParameter(arg10, "context");
        Intrinsics.checkNotNullParameter(arg11, "windowManager");
        super();
        this.context = arg10;
        SharedPreferences v0 = arg10.getSharedPreferences("GoldenMouseConfig", 0);
        Intrinsics.checkNotNullExpressionValue(v0, "getSharedPreferences(...)");
        this.prefs = v0;
        this.overlay = new BluestacksOsdOverlay(arg10, arg11);
        this.fpsCalculator = new FpsCalculator(null, null, new TelemetryManager$$ExternalSyntheticLambda0(this), 3, null);
        this.isBluestacksEnabled = v0.getBoolean("pref_osd_bluestacks_enabled", true);
        this.isFpsActive = v0.getBoolean("pref_fps_enabled", true);
        this.isPingActive = v0.getBoolean("pref_ping_enabled", false);
        this.isCpuActive = v0.getBoolean("pref_cpu_enabled", false);
        this.isRamActive = v0.getBoolean("pref_ram_enabled", false);
        this.isTempActive = v0.getBoolean("pref_temp_enabled", false);
        this.isHoraActive = v0.getBoolean("pref_hora_enabled", false);
        this.sessionVisible = arg12;
        this.reconcileVisualWork();
    }

    public TelemetryManager(Context arg1, WindowManager arg2, boolean arg3, int arg4, DefaultConstructorMarker arg5) {
        Object v2;
        if((arg4 & 2) != 0) {
            v2 = arg1.getSystemService("window");
            Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type android.view.WindowManager");
        }

        this(arg1, ((WindowManager)v2), true);
    }

    public final void destroy() {
        this.destroyed = true;
        this.detenerOsd();
    }

    private final void detenerOsd() {
        this.fpsCalculator.stop();
        this.overlay.ocultar();
    }

    static final Unit fpsCalculator$lambda$0(TelemetryManager arg1, int arg2) {
        if((arg1.sessionVisible) && !arg1.destroyed && (arg1.isBluestacksEnabled) && (arg1.isFpsActive)) {
            arg1.overlay.actualizarTexto(String.valueOf(arg2));
        }

        return Unit.INSTANCE;
    }

    public final boolean isBluestacksEnabled() {
        return this.isBluestacksEnabled;
    }

    public final boolean isCpuActive() {
        return this.isCpuActive;
    }

    public final boolean isFpsActive() {
        return this.isFpsActive;
    }

    public final boolean isHoraActive() {
        return this.isHoraActive;
    }

    public final boolean isPingActive() {
        return this.isPingActive;
    }

    public final boolean isRamActive() {
        return this.isRamActive;
    }

    public final boolean isTempActive() {
        return this.isTempActive;
    }

    private final void reconcileVisualWork() {
        if(!this.destroyed && (this.sessionVisible) && (this.isBluestacksEnabled)) {
            this.overlay.mostrar();
            if((this.isFpsActive) && (this.overlay.isShowing())) {
                this.fpsCalculator.start();
                return;
            }

            this.fpsCalculator.stop();
            return;
        }

        this.detenerOsd();
    }

    public final void setBluestacksEnabled(boolean arg3) {
        this.isBluestacksEnabled = arg3;
        this.prefs.edit().putBoolean("pref_osd_bluestacks_enabled", arg3).apply();
        this.reconcileVisualWork();
    }

    public final void setCpuEnabled(boolean arg2) {
        this.isCpuActive = arg2;
        this.prefs.edit().putBoolean("pref_cpu_enabled", arg2).apply();
    }

    public final void setFpsEnabled(boolean arg3) {
        this.isFpsActive = arg3;
        this.prefs.edit().putBoolean("pref_fps_enabled", arg3).apply();
        this.reconcileVisualWork();
    }

    public final void setHoraEnabled(boolean arg2) {
        this.isHoraActive = arg2;
        this.prefs.edit().putBoolean("pref_hora_enabled", arg2).apply();
    }

    public final void setPingEnabled(boolean arg2) {
        this.isPingActive = arg2;
        this.prefs.edit().putBoolean("pref_ping_enabled", arg2).apply();
    }

    public final void setRamEnabled(boolean arg2) {
        this.isRamActive = arg2;
        this.prefs.edit().putBoolean("pref_ram_enabled", arg2).apply();
    }

    public final void setSessionVisible(boolean arg2) {
        if(this.sessionVisible != arg2) {
            if(this.destroyed) {
            }
            else {
                this.sessionVisible = arg2;
                this.reconcileVisualWork();
            }
        }
    }

    public final void setTempEnabled(boolean arg2) {
        this.isTempActive = arg2;
        this.prefs.edit().putBoolean("pref_temp_enabled", arg2).apply();
    }
}

