package androidx.activity;

import android.content.res.Resources;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u000E\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B5\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0012\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\n\u0010\u000BJ\u0015\u0010\u0011\u001A\u00020\u00032\u0006\u0010\u0012\u001A\u00020\tH\u0000¢\u0006\u0002\b\u0013J\u0015\u0010\u0014\u001A\u00020\u00032\u0006\u0010\u0012\u001A\u00020\tH\u0000¢\u0006\u0002\b\u0015R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0014\u0010\u0005\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\rR \u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u0017"}, d2={"Landroidx/activity/SystemBarStyle;", "", "lightScrim", "", "darkScrim", "nightMode", "detectDarkMode", "Lkotlin/Function1;", "Landroid/content/res/Resources;", "", "<init>", "(IIILkotlin/jvm/functions/Function1;)V", "getDarkScrim$activity", "()I", "getNightMode$activity", "getDetectDarkMode$activity", "()Lkotlin/jvm/functions/Function1;", "getScrim", "isDark", "getScrim$activity", "getScrimWithEnforcedContrast", "getScrimWithEnforcedContrast$activity", "Companion", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public final class SystemBarStyle {
    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001A\u00020\u00052\b\b\u0001\u0010\u0006\u001A\u00020\u00072\b\b\u0001\u0010\b\u001A\u00020\u00072\u0014\b\u0002\u0010\t\u001A\u000E\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\f0\nH\u0007J\u0012\u0010\r\u001A\u00020\u00052\b\b\u0001\u0010\u000E\u001A\u00020\u0007H\u0007J\u001C\u0010\u000F\u001A\u00020\u00052\b\b\u0001\u0010\u000E\u001A\u00020\u00072\b\b\u0001\u0010\b\u001A\u00020\u0007H\u0007¨\u0006\u0010"}, d2={"Landroidx/activity/SystemBarStyle$Companion;", "", "<init>", "()V", "auto", "Landroidx/activity/SystemBarStyle;", "lightScrim", "", "darkScrim", "detectDarkMode", "Lkotlin/Function1;", "Landroid/content/res/Resources;", "", "dark", "scrim", "light", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        @JvmStatic public final SystemBarStyle auto(int arg7, int arg8) {
            return Companion.auto$default(this, arg7, arg8, null, 4, null);
        }

        @JvmStatic public final SystemBarStyle auto(int arg7, int arg8, Function1 arg9) {
            Intrinsics.checkNotNullParameter(arg9, "detectDarkMode");
            return new SystemBarStyle(arg7, arg8, 0, arg9, null);
        }

        public static SystemBarStyle auto$default(Companion arg0, int arg1, int arg2, Function1 arg3, int arg4, Object arg5) {
            SystemBarStyle$Companion$$ExternalSyntheticLambda2 v3;
            if((arg4 & 4) != 0) {
                v3 = new SystemBarStyle$Companion$$ExternalSyntheticLambda2();
            }

            return arg0.auto(arg1, arg2, ((Function1)v3));
        }

        static final boolean auto$lambda$0(Resources arg1) {
            Intrinsics.checkNotNullParameter(arg1, "resources");
            if((arg1.getConfiguration().uiMode & 0x30) == 0x20) {
                return 1;
            }

            return 0;
        }

        @JvmStatic public final SystemBarStyle dark(int arg7) {
            return new SystemBarStyle(arg7, arg7, 2, new SystemBarStyle$Companion$$ExternalSyntheticLambda1(), null);
        }

        static final boolean dark$lambda$0(Resources arg1) {
            Intrinsics.checkNotNullParameter(arg1, "<unused var>");
            return 1;
        }

        @JvmStatic public final SystemBarStyle light(int arg7, int arg8) {
            return new SystemBarStyle(arg7, arg8, 1, new SystemBarStyle$Companion$$ExternalSyntheticLambda0(), null);
        }

        static final boolean light$lambda$0(Resources arg1) {
            Intrinsics.checkNotNullParameter(arg1, "<unused var>");
            return 0;
        }
    }

    public static final Companion Companion;
    private final int darkScrim;
    private final Function1 detectDarkMode;
    private final int lightScrim;
    private final int nightMode;

    static {
        SystemBarStyle.Companion = new Companion(null);
    }

    private SystemBarStyle(int arg1, int arg2, int arg3, Function1 arg4) {
        super();
        this.lightScrim = arg1;
        this.darkScrim = arg2;
        this.nightMode = arg3;
        this.detectDarkMode = arg4;
    }

    public SystemBarStyle(int arg1, int arg2, int arg3, Function1 arg4, DefaultConstructorMarker arg5) {
        this(arg1, arg2, arg3, arg4);
    }

    @JvmStatic public static final SystemBarStyle auto(int arg1, int arg2) {
        return SystemBarStyle.Companion.auto(arg1, arg2);
    }

    @JvmStatic public static final SystemBarStyle auto(int arg1, int arg2, Function1 arg3) {
        return SystemBarStyle.Companion.auto(arg1, arg2, arg3);
    }

    @JvmStatic public static final SystemBarStyle dark(int arg1) {
        return SystemBarStyle.Companion.dark(arg1);
    }

    public final int getDarkScrim$activity() {
        return this.darkScrim;
    }

    public final Function1 getDetectDarkMode$activity() {
        return this.detectDarkMode;
    }

    public final int getNightMode$activity() {
        return this.nightMode;
    }

    public final int getScrim$activity(boolean arg1) {
        if(arg1) {
            return this.darkScrim;
        }

        return this.lightScrim;
    }

    public final int getScrimWithEnforcedContrast$activity(boolean arg2) {
        if(this.nightMode == 0) {
            return 0;
        }

        if(arg2) {
            return this.darkScrim;
        }

        return this.lightScrim;
    }

    @JvmStatic public static final SystemBarStyle light(int arg1, int arg2) {
        return SystemBarStyle.Companion.light(arg1, arg2);
    }
}

