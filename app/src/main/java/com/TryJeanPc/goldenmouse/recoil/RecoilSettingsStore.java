package com.TryJeanPc.goldenmouse.recoil;

import android.content.SharedPreferences;
import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000B2\u00020\u0001:\u0001\u000BB\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001A\u00020\u0007J\u000E\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0007R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2={"Lcom/TryJeanPc/goldenmouse/recoil/RecoilSettingsStore;", "", "preferences", "Landroid/content/SharedPreferences;", "<init>", "(Landroid/content/SharedPreferences;)V", "load", "Lcom/TryJeanPc/goldenmouse/recoil/RecoilSettings;", "save", "", "settings", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class RecoilSettingsStore {
    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2={"Lcom/TryJeanPc/goldenmouse/recoil/RecoilSettingsStore$Companion;", "", "<init>", "()V", "PREFERENCES", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    public static final int $stable = 0;
    public static final Companion Companion = null;
    public static final String PREFERENCES = "golden_recoil_control";
    private final SharedPreferences preferences;

    static {
        RecoilSettingsStore.Companion = new Companion(null);
        RecoilSettingsStore.$stable = 8;
    }

    public RecoilSettingsStore(SharedPreferences arg2) {
        Intrinsics.checkNotNullParameter(arg2, "preferences");
        super();
        this.preferences = arg2;
    }

    public final RecoilSettings load() {
        RecoilSettingsStore v0 = this;
        String v1 = "0.0";
        try {
            boolean v3 = v0.preferences.getBoolean("enabled", false);
            boolean v4 = v0.preferences.getBoolean("show_panel", false);
            boolean v6 = v0.preferences.getBoolean("fixed_panel", false);
            int v7 = v0.preferences.getInt("panel_opacity", 100);
            int v8 = v0.preferences.getInt("global_percent", 100);
            boolean v9 = v0.preferences.getBoolean("limit_duration", false);
            String v10 = v0.preferences.getString("max_duration_seconds", "5.0");
            Intrinsics.checkNotNull(v10);
            double v10_1 = Double.parseDouble(v10);
            String v12 = v0.preferences.getString("vertical_speed", v1);
            Intrinsics.checkNotNull(v12);
            double v12_1 = Double.parseDouble(v12);
            boolean v5 = v0.preferences.getBoolean("downward", false);
            String v0_2 = v0.preferences.getString("horizontal_speed", v1);
            Intrinsics.checkNotNull(v0_2);
            return new RecoilSettings(v3, v4, v6, v7, v8, v9, v10_1, v12_1, v5, Double.parseDouble(v0_2));
        }
        catch(RuntimeException v0_1) {
            Log.w("GoldenRecoil", "Configuración inválida; Retroceso queda desactivado", ((Throwable)v0_1));
            return new RecoilSettings(false, false, false, 0, 0, false, 0, 0, false, 0, 0x3FF, null);
        }
    }

    public final boolean save(RecoilSettings arg4) {
        Intrinsics.checkNotNullParameter(arg4, "settings");
        try {
            return this.preferences.edit().putBoolean("enabled", arg4.getEnabled()).putBoolean("show_panel", arg4.getShowPanel()).putBoolean("fixed_panel", arg4.getFixedPanel()).putInt("panel_opacity", arg4.getPanelOpacity()).putInt("global_percent", arg4.getGlobalPercent()).putBoolean("limit_duration", arg4.getLimitDuration()).putString("max_duration_seconds", String.valueOf(arg4.getMaxDurationSeconds())).putString("vertical_speed", String.valueOf(arg4.getVerticalSpeed())).putBoolean("downward", arg4.getDownward()).putString("horizontal_speed", String.valueOf(arg4.getHorizontalSpeed())).commit();
        }
        catch(RuntimeException v3) {
            Log.e("GoldenRecoil", "No se pudo guardar Retroceso", ((Throwable)v3));
            return 0;
        }
    }
}

