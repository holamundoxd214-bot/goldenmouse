package com.TryJeanPc.goldenmouse.cursor;

import android.content.SharedPreferences$Editor;
import android.content.SharedPreferences;
import com.TryJeanPc.goldenmouse.input.MousePollingPreferences;
import com.TryJeanPc.goldenmouse.input.MousePollingSelection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0013B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007J\u000E\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\u0003J\u0016\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\b2\u0006\u0010\u000F\u001A\u00020\nJ\u0010\u0010\u0010\u001A\u0004\u0018\u00010\n2\u0006\u0010\u000E\u001A\u00020\bJ \u0010\u0011\u001A\u00020\r2\u0006\u0010\u000B\u001A\u00020\u00032\u0006\u0010\u000F\u001A\u00020\n2\b\u0010\u0012\u001A\u0004\u0018\u00010\bR\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2={"Lcom/TryJeanPc/goldenmouse/cursor/MouseProfileStore;", "", "storage", "Landroid/content/SharedPreferences;", "<init>", "(Landroid/content/SharedPreferences;)V", "names", "", "", "capture", "Lcom/TryJeanPc/goldenmouse/cursor/MouseProfileStore$Profile;", "prefs", "save", "", "name", "profile", "load", "apply", "activeName", "Profile", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class MouseProfileStore {
    @Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001B\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0005\u0012\b\b\u0002\u0010\b\u001A\u00020\t\u0012\b\b\u0002\u0010\n\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u000B\u001A\u00020\f¢\u0006\u0004\b\r\u0010\u000EJ\u0006\u0010\u001A\u001A\u00020\u0000J\u000B\u0010\u001B\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001C\u001A\u00020\u0005HÆ\u0003J\t\u0010\u001D\u001A\u00020\u0005HÆ\u0003J\t\u0010\u001E\u001A\u00020\u0005HÆ\u0003J\t\u0010\u001F\u001A\u00020\tHÆ\u0003J\t\u0010 \u001A\u00020\u0005HÆ\u0003J\t\u0010!\u001A\u00020\fHÆ\u0003JQ\u0010\"\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\u00052\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u00052\b\b\u0002\u0010\u000B\u001A\u00020\fHÆ\u0001J\u0013\u0010#\u001A\u00020\t2\b\u0010$\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001A\u00020\u0005HÖ\u0001J\t\u0010&\u001A\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0007\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0012R\u0011\u0010\b\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0012R\u0011\u0010\u000B\u001A\u00020\f¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0019¨\u0006\'"}, d2={"Lcom/TryJeanPc/goldenmouse/cursor/MouseProfileStore$Profile;", "", "image", "", "size", "", "opacity", "speed", "acceleration", "", "wheel", "polling", "Lcom/TryJeanPc/goldenmouse/input/MousePollingSelection;", "<init>", "(Ljava/lang/String;IIIZILcom/TryJeanPc/goldenmouse/input/MousePollingSelection;)V", "getImage", "()Ljava/lang/String;", "getSize", "()I", "getOpacity", "getSpeed", "getAcceleration", "()Z", "getWheel", "getPolling", "()Lcom/TryJeanPc/goldenmouse/input/MousePollingSelection;", "validated", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Profile {
        public static final int $stable;
        private final boolean acceleration;
        private final String image;
        private final int opacity;
        private final MousePollingSelection polling;
        private final int size;
        private final int speed;
        private final int wheel;

        static {
        }

        public Profile(String arg4, int arg5, int arg6, int arg7, boolean arg8, int arg9, MousePollingSelection arg10, int arg11, DefaultConstructorMarker arg12) {
            DefaultConstructorMarker v0 = null;
            if((arg11 & 1) != 0) {
                arg4 = ((String)v0);
            }

            int v1 = 100;
            if((arg11 & 2) != 0) {
                arg5 = v1;
            }

            if((arg11 & 4) != 0) {
                arg6 = v1;
            }

            v1 = 50;
            if((arg11 & 8) != 0) {
                arg7 = v1;
            }

            if((arg11 & 0x20) != 0) {
                arg9 = v1;
            }

            if((arg11 & 0x40) != 0) {
                arg10 = new MousePollingSelection(0, false, 3, v0);
            }

            this(arg4, arg5, arg6, arg7, false, arg9, arg10);
        }

        public Profile(String arg2, int arg3, int arg4, int arg5, boolean arg6, int arg7, MousePollingSelection arg8) {
            Intrinsics.checkNotNullParameter(arg8, "polling");
            super();
            this.image = arg2;
            this.size = arg3;
            this.opacity = arg4;
            this.speed = arg5;
            this.acceleration = arg6;
            this.wheel = arg7;
            this.polling = arg8;
        }

        public Profile() {
            this(null, 0, 0, 0, false, 0, null, 0x7F, null);
        }

        public final String component1() {
            return this.image;
        }

        public final int component2() {
            return this.size;
        }

        public final int component3() {
            return this.opacity;
        }

        public final int component4() {
            return this.speed;
        }

        public final boolean component5() {
            return this.acceleration;
        }

        public final int component6() {
            return this.wheel;
        }

        public final MousePollingSelection component7() {
            return this.polling;
        }

        public final Profile copy(String arg9, int arg10, int arg11, int arg12, boolean arg13, int arg14, MousePollingSelection arg15) {
            Intrinsics.checkNotNullParameter(arg15, "polling");
            return new Profile(arg9, arg10, arg11, arg12, arg13, arg14, arg15);
        }

        public static Profile copy$default(Profile arg0, String arg1, int arg2, int arg3, int arg4, boolean arg5, int arg6, MousePollingSelection arg7, int arg8, Object arg9) {
            if((arg8 & 1) != 0) {
                arg1 = arg0.image;
            }

            if((arg8 & 2) != 0) {
                arg2 = arg0.size;
            }

            if((arg8 & 4) != 0) {
                arg3 = arg0.opacity;
            }

            if((arg8 & 8) != 0) {
                arg4 = arg0.speed;
            }

            if((arg8 & 16) != 0) {
                arg5 = arg0.acceleration;
            }

            if((arg8 & 0x20) != 0) {
                arg6 = arg0.wheel;
            }

            if((arg8 & 0x40) != 0) {
                arg7 = arg0.polling;
            }

            return arg0.copy(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
        }

        public boolean equals(Object arg5) {
            if(this == (((Profile)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof Profile)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.image, ((Profile)arg5).image)) {
                return 0;
            }

            if(this.size != ((Profile)arg5).size) {
                return 0;
            }

            if(this.opacity != ((Profile)arg5).opacity) {
                return 0;
            }

            if(this.speed != ((Profile)arg5).speed) {
                return 0;
            }

            if(this.acceleration != ((Profile)arg5).acceleration) {
                return 0;
            }

            if(this.wheel != ((Profile)arg5).wheel) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.polling, ((Profile)arg5).polling)) {
                return 0;
            }

            return 1;
        }

        public final boolean getAcceleration() {
            return this.acceleration;
        }

        public final String getImage() {
            return this.image;
        }

        public final int getOpacity() {
            return this.opacity;
        }

        public final MousePollingSelection getPolling() {
            return this.polling;
        }

        public final int getSize() {
            return this.size;
        }

        public final int getSpeed() {
            return this.speed;
        }

        public final int getWheel() {
            return this.wheel;
        }

        public int hashCode() {
            String v0 = this.image;
            int v0_1 = v0 == null ? 0 : v0.hashCode();
            return (((((v0_1 * 0x1F + Integer.hashCode(this.size)) * 0x1F + Integer.hashCode(this.opacity)) * 0x1F + Integer.hashCode(this.speed)) * 0x1F + Boolean.hashCode(this.acceleration)) * 0x1F + Integer.hashCode(this.wheel)) * 0x1F + this.polling.hashCode();
        }

        public String toString() {
            return "Profile(image=" + this.image + ", size=" + this.size + ", opacity=" + this.opacity + ", speed=" + this.speed + ", acceleration=" + this.acceleration + ", wheel=" + this.wheel + ", polling=" + this.polling + ")";
        }

        public final Profile validated() {
            return Profile.copy$default(this, null, RangesKt.coerceIn(this.size, 0, 200), RangesKt.coerceIn(this.opacity, 0, 100), RangesKt.coerceIn(this.speed, 0, 100), false, RangesKt.coerceIn(this.wheel, 0, 100), null, 81, null);
        }
    }

    public static final int $stable = 8;
    private final SharedPreferences storage;

    static {
    }

    public MouseProfileStore(SharedPreferences arg2) {
        Intrinsics.checkNotNullParameter(arg2, "storage");
        super();
        this.storage = arg2;
    }

    public final void apply(SharedPreferences arg4, Profile arg5, String arg6) {
        Intrinsics.checkNotNullParameter(arg4, "prefs");
        Intrinsics.checkNotNullParameter(arg5, "profile");
        Profile v3 = arg5.validated();
        MousePollingSelection v5 = MousePollingPreferences.INSTANCE.load(arg4);
        SharedPreferences$Editor v0 = arg4.edit().putInt("tamano_puntero", v3.getSize()).putInt("transparencia_puntero", v3.getOpacity()).putInt("velocidad_puntero", v3.getSpeed()).putBoolean("aceleracion_puntero", v3.getAcceleration()).putInt("sensibilidad_rueda", v3.getWheel());
        String v1 = "perfil_mouse_activo";
        if(arg6 == null) {
            v0.remove(v1);
        }
        else {
            v0.putString(v1, arg6);
        }

        MousePollingPreferences v6 = MousePollingPreferences.INSTANCE;
        Intrinsics.checkNotNull(v0);
        if(v6.write(v0, v3.getPolling()).commit()) {
            return;
        }

        MousePollingPreferences v3_1 = MousePollingPreferences.INSTANCE;
        SharedPreferences$Editor v4 = arg4.edit();
        Intrinsics.checkNotNullExpressionValue(v4, "edit(...)");
        v3_1.write(v4, v5).commit();
        throw new IllegalStateException("No se pudieron aplicar los ajustes".toString());
    }

    public final Profile capture(SharedPreferences arg9) {
        Intrinsics.checkNotNullParameter(arg9, "prefs");
        return new Profile(arg9.getString("imagen_cursor", null), arg9.getInt("tamano_puntero", 100), arg9.getInt("transparencia_puntero", 100), arg9.getInt("velocidad_puntero", 50), arg9.getBoolean("aceleracion_puntero", false), arg9.getInt("sensibilidad_rueda", 50), MousePollingPreferences.INSTANCE.load(arg9)).validated();
    }

    public final Profile load(String arg13) {
        Object v12;
        Intrinsics.checkNotNullParameter(arg13, "name");
        String v0 = "profile:" + arg13.length() + ":" + arg13 + ":";
        String v1 = null;
        if(this.names().contains(arg13)) {
            if(this.storage.getInt(v0 + "version", 0) != 1) {
            }
            else {
                String v5 = this.storage.getString(v0 + "image", v1);
                int v6 = this.storage.getInt(v0 + "size", 100);
                int v7 = this.storage.getInt(v0 + "opacity", 100);
                int v8 = this.storage.getInt(v0 + "speed", 50);
                boolean v9 = this.storage.getBoolean(v0 + "acceleration", false);
                int v10 = this.storage.getInt(v0 + "wheel", 50);
                try {
                    v12 = Result.constructor-impl(new MousePollingSelection(this.storage.getInt(v0 + "polling_hz", 0), this.storage.getBoolean(v0 + "polling_custom", false)));
                }
                catch(Throwable v0_1) {
                    v12 = Result.constructor-impl(ResultKt.createFailure(v0_1));
                }

                MousePollingSelection v13 = new MousePollingSelection(0, false, 3, ((DefaultConstructorMarker)v1));
                if(Result.isFailure-impl(v12)) {
                    MousePollingSelection v12_1 = v13;
                }

                return new Profile(v5, v6, v7, v8, v9, v10, v12).validated();
            }
        }

        return ((Profile)v1);
    }

    public final List names() {
        Set v2 = this.storage.getStringSet("names", SetsKt.emptySet());
        if(v2 == null) {
            v2 = SetsKt.emptySet();
        }

        return CollectionsKt.sorted(((Iterable)v2));
    }

    public final void save(String arg4, Profile arg5) {
        Intrinsics.checkNotNullParameter(arg4, "name");
        Intrinsics.checkNotNullParameter(arg5, "profile");
        if(!StringsKt.isBlank(arg4) && arg4.length() <= 0x40) {
            String v0 = "profile:" + arg4.length() + ":" + arg4 + ":";
            arg5 = arg5.validated();
            if(this.storage.edit().putStringSet("names", SetsKt.plus(CollectionsKt.toSet(this.names()), arg4)).putInt(v0 + "version", 1).putString(v0 + "image", arg5.getImage()).putInt(v0 + "size", arg5.getSize()).putInt(v0 + "opacity", arg5.getOpacity()).putInt(v0 + "speed", arg5.getSpeed()).putBoolean(v0 + "acceleration", arg5.getAcceleration()).putInt(v0 + "wheel", arg5.getWheel()).putInt(v0 + "polling_hz", arg5.getPolling().getHz()).putBoolean(v0 + "polling_custom", arg5.getPolling().getCustom()).commit()) {
                return;
            }
            else {
                throw new IllegalStateException("No se pudo guardar el perfil".toString());
            }
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }
}

