package com.TryJeanPc.goldenmouse.activation;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0001\u0018\u0000 \u00192\u00020\u0001:\u0002\u0018\u0019B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\t\u001A\u0004\u0018\u00010\nJ\u0006\u0010\u000B\u001A\u00020\fJ\u000E\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\nJ\b\u0010\u0010\u001A\u0004\u0018\u00010\u0011J\u0016\u0010\u0012\u001A\u00020\u000E2\u0006\u0010\u0013\u001A\u00020\n2\u0006\u0010\u0014\u001A\u00020\u0015J\u0006\u0010\u0016\u001A\u00020\u000EJ\u0006\u0010\u0017\u001A\u00020\u000ER\u0016\u0010\u0006\u001A\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001A"}, d2={"Lcom/TryJeanPc/goldenmouse/activation/ActivationStorage;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "preferences", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "activeMethod", "", "isKadbPaired", "", "saveActiveMethod", "", "method", "kadbConfiguration", "Lcom/TryJeanPc/goldenmouse/activation/ActivationStorage$KadbConfiguration;", "saveKadbConfiguration", "host", "connectPort", "", "markKadbPaired", "clearKadbPairing", "KadbConfiguration", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class ActivationStorage {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2={"Lcom/TryJeanPc/goldenmouse/activation/ActivationStorage$Companion;", "", "<init>", "()V", "METHOD_KADB", "", "METHOD_SHIZUKU", "PREFERENCES_NAME", "KEY_ACTIVE_METHOD", "KEY_KADB_HOST", "KEY_KADB_CONNECT_PORT", "KEY_KADB_PAIRED", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    @Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001A\u00020\u0003HÆ\u0003J\t\u0010\r\u001A\u00020\u0005HÆ\u0003J\u001D\u0010\u000E\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001A\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u0014"}, d2={"Lcom/TryJeanPc/goldenmouse/activation/ActivationStorage$KadbConfiguration;", "", "host", "", "connectPort", "", "<init>", "(Ljava/lang/String;I)V", "getHost", "()Ljava/lang/String;", "getConnectPort", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class KadbConfiguration {
        public static final int $stable;
        private final int connectPort;
        private final String host;

        static {
        }

        public KadbConfiguration(String arg2, int arg3) {
            Intrinsics.checkNotNullParameter(arg2, "host");
            super();
            this.host = arg2;
            this.connectPort = arg3;
        }

        public final String component1() {
            return this.host;
        }

        public final int component2() {
            return this.connectPort;
        }

        public final KadbConfiguration copy(String arg1, int arg2) {
            Intrinsics.checkNotNullParameter(arg1, "host");
            return new KadbConfiguration(arg1, arg2);
        }

        public static KadbConfiguration copy$default(KadbConfiguration arg0, String arg1, int arg2, int arg3, Object arg4) {
            if((arg3 & 1) != 0) {
                arg1 = arg0.host;
            }

            if((arg3 & 2) != 0) {
                arg2 = arg0.connectPort;
            }

            return arg0.copy(arg1, arg2);
        }

        public boolean equals(Object arg5) {
            if(this == (((KadbConfiguration)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof KadbConfiguration)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.host, ((KadbConfiguration)arg5).host)) {
                return 0;
            }

            if(this.connectPort != ((KadbConfiguration)arg5).connectPort) {
                return 0;
            }

            return 1;
        }

        public final int getConnectPort() {
            return this.connectPort;
        }

        public final String getHost() {
            return this.host;
        }

        public int hashCode() {
            return this.host.hashCode() * 0x1F + Integer.hashCode(this.connectPort);
        }

        public String toString() {
            return "KadbConfiguration(host=" + this.host + ", connectPort=" + this.connectPort + ")";
        }
    }

    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final String KEY_ACTIVE_METHOD = "active_method";
    private static final String KEY_KADB_CONNECT_PORT = "kadb_connect_port";
    private static final String KEY_KADB_HOST = "kadb_host";
    private static final String KEY_KADB_PAIRED = "kadb_paired";
    public static final String METHOD_KADB = "KADB";
    public static final String METHOD_SHIZUKU = "SHIZUKU";
    private static final String PREFERENCES_NAME = "GoldenActivationPrefs";
    private final SharedPreferences preferences;

    static {
        ActivationStorage.Companion = new Companion(null);
        ActivationStorage.$stable = 8;
    }

    public ActivationStorage(Context arg3) {
        Intrinsics.checkNotNullParameter(arg3, "context");
        super();
        this.preferences = arg3.getSharedPreferences("GoldenActivationPrefs", 0);
    }

    public final String activeMethod() {
        return this.preferences.getString("active_method", null);
    }

    public final void clearKadbPairing() {
        this.preferences.edit().remove("kadb_host").remove("kadb_connect_port").putBoolean("kadb_paired", false).apply();
    }

    public final boolean isKadbPaired() {
        return this.preferences.getBoolean("kadb_paired", false);
    }

    public final KadbConfiguration kadbConfiguration() {
        KadbConfiguration v1 = null;
        if(!this.preferences.getBoolean("kadb_paired", false)) {
            return v1;
        }

        String v0 = this.preferences.getString("kadb_host", ((String)v1));
        if(v0 == null) {
            return v1;
        }

        int v4 = this.preferences.getInt("kadb_connect_port", -1);
        if(1 <= v4 && v4 < 0x10000) {
            v1 = new KadbConfiguration(v0, v4);
        }

        return v1;
    }

    public final void markKadbPaired() {
        this.preferences.edit().putString("active_method", "KADB").putBoolean("kadb_paired", true).apply();
    }

    public final void saveActiveMethod(String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "method");
        this.preferences.edit().putString("active_method", arg2).apply();
    }

    public final void saveKadbConfiguration(String arg3, int arg4) {
        Intrinsics.checkNotNullParameter(arg3, "host");
        this.preferences.edit().putString("active_method", "KADB").putString("kadb_host", arg3).putInt("kadb_connect_port", arg4).putBoolean("kadb_paired", true).apply();
    }
}

