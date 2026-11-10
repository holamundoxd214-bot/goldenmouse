package com.TryJeanPc.goldenmouse.stretch.physical;

import android.graphics.Rect;
import android.os.IBinder;
import android.os.Process;
import com.TryJeanPc.goldenmouse.stretch.StretchFullProjection;
import com.TryJeanPc.goldenmouse.stretch.StretchRect;
import com.TryJeanPc.goldenmouse.stretch.StretchSize;
import com.TryJeanPc.goldenmouse.stretch.agent.AndroidStretchDisplayTokens;
import com.TryJeanPc.goldenmouse.stretch.recovery.StretchScaling;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\tH\u0002J\u001C\u0010\n\u001A\u00020\u00072\b\u0010\u000B\u001A\u0004\u0018\u00010\f2\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\tJ\u001A\u0010\r\u001A\u00020\u00072\u0006\u0010\u000E\u001A\u00020\u000F2\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\tJ\"\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u000E\u001A\u00020\u00142\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\tJ\u0018\u0010\u0015\u001A\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0017\u0012\u0004\u0012\u00020\u00010\u0016H\u0002R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/physical/AndroidStretchPhysicalCommands;", "", "<init>", "()V", "recoveryWithoutUiVerified", "", "requirePhysicalPermit", "", "permit", "Lcom/TryJeanPc/goldenmouse/stretch/physical/StretchPhysicalCommandPermit;", "size", "override", "Lcom/TryJeanPc/goldenmouse/stretch/StretchSize;", "scaling", "value", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchScaling;", "projection", "", "identity", "", "Lcom/TryJeanPc/goldenmouse/stretch/StretchFullProjection;", "window", "Lkotlin/Pair;", "Ljava/lang/Class;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class AndroidStretchPhysicalCommands {
    public static final int $stable = 0;
    public static final AndroidStretchPhysicalCommands INSTANCE = null;
    public static final boolean recoveryWithoutUiVerified = false;

    static {
        AndroidStretchPhysicalCommands.INSTANCE = new AndroidStretchPhysicalCommands();
    }

    private AndroidStretchPhysicalCommands() {
        super();
    }

    public final long projection(String arg9, StretchFullProjection arg10, StretchPhysicalCommandPermit arg11) {
        long v8_4;
        Intrinsics.checkNotNullParameter(arg9, "identity");
        Intrinsics.checkNotNullParameter(arg10, "value");
        this.requirePhysicalPermit(arg11);
        int v8 = arg10.getRotation();
        String v11 = "Failed requirement.";
        if(v8 >= 0) {
            int v0 = 4;
            if(v8 < v0) {
                String v8_1 = "aosp-physical:";
                int v2 = 2;
                Object v3 = null;
                if(StringsKt.startsWith$default(arg9, v8_1, false, v2, v3)) {
                    long v4 = Long.parseUnsignedLong(StringsKt.removePrefix(arg9, v8_1));
                    if(Intrinsics.areEqual(arg9, v8_1 + Long.toUnsignedString(v4))) {
                        Rect v8_2 = AndroidStretchPhysicalCommands.projection$rect(arg10.getSource());
                        Rect v9 = AndroidStretchPhysicalCommands.projection$rect(arg10.getDestination());
                        IBinder v11_1 = AndroidStretchDisplayTokens.INSTANCE.resolve(v4).getBinder();
                        Class v4_1 = Class.forName("android.view.SurfaceControl$Transaction");
                        Class[] v0_1 = new Class[v0];
                        v0_1[0] = IBinder.class;
                        v0_1[1] = Integer.TYPE;
                        Class v5 = Rect.class;
                        v0_1[v2] = v5;
                        v0_1[3] = v5;
                        Method v0_2 = v4_1.getMethod("setDisplayProjection", v0_1);
                        StretchProjectionApply v2_1 = StretchProjectionApply.INSTANCE;
                        Intrinsics.checkNotNull(v4_1);
                        v2_1.method(v4_1);
                        Object v1 = v4_1.getConstructor().newInstance();
                        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type java.lang.AutoCloseable");
                        try {
                            v0_2.invoke(v1, v11_1, Integer.valueOf(arg10.getRotation()), v8_2, v9);
                            v8_4 = System.nanoTime();
                            StretchProjectionApply.INSTANCE.invoke(v1);
                            v8_4 = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - v8_4);
                        }
                        catch(Throwable v8_3) {
                            try {
                                throw v8_3;
                            }
                            catch(Throwable v9_1) {
                                AutoCloseableKt.closeFinally(((AutoCloseable)v1), v8_3);
                                throw v9_1;
                            }
                        }

                        AutoCloseableKt.closeFinally(((AutoCloseable)v1), ((Throwable)v3));
                        return v8_4;
                    }
                    else {
                        throw new IllegalArgumentException(v11.toString());
                    }
                }
            }
        }

        throw new IllegalArgumentException(v11.toString());
    }

    public static long projection$default(AndroidStretchPhysicalCommands arg0, String arg1, StretchFullProjection arg2, StretchPhysicalCommandPermit arg3, int arg4, Object arg5) {
        if((arg4 & 4) != 0) {
            arg3 = null;
        }

        return arg0.projection(arg1, arg2, arg3);
    }

    private static final Rect projection$rect(StretchRect arg4) {
        if(arg4.getLeft() >= 0 && arg4.getTop() >= 0 && arg4.getRight() > arg4.getLeft() && arg4.getBottom() > arg4.getTop()) {
            int v1 = 0x8000;
            if(arg4.getRight() <= v1 && arg4.getBottom() <= v1) {
                return new Rect(arg4.getLeft(), arg4.getTop(), arg4.getRight(), arg4.getBottom());
            }
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private final void requirePhysicalPermit(StretchPhysicalCommandPermit arg1) {
        if(arg1 != null && (arg1.active())) {
            if(Process.myUid() == 2000) {
                return;
            }
            else {
                throw new IllegalStateException("Check failed.");
            }
        }

        throw new IllegalStateException("PHYSICAL_WRITES_DISABLED_EMERGENCY_UNPROVEN".toString());
    }

    public final void scaling(StretchScaling arg5, StretchPhysicalCommandPermit arg6) {
        Intrinsics.checkNotNullParameter(arg5, "value");
        this.requirePhysicalPermit(arg6);
        Pair v4 = this.window();
        Object v6 = v4.component1();
        Object v4_1 = v4.component2();
        Class[] v0 = new Class[2];
        int v2 = 0;
        v0[0] = Integer.TYPE;
        v0[1] = Integer.TYPE;
        Method v6_1 = ((Class)v6).getMethod("setForcedDisplayScalingMode", v0);
        Integer v0_1 = Integer.valueOf(0);
        if(arg5 == StretchScaling.OFF) {
            v2 = 1;
        }

        v6_1.invoke(v4_1, v0_1, Integer.valueOf(v2));
    }

    public static void scaling$default(AndroidStretchPhysicalCommands arg0, StretchScaling arg1, StretchPhysicalCommandPermit arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = null;
        }

        arg0.scaling(arg1, arg2);
    }

    public final void size(StretchSize arg6, StretchPhysicalCommandPermit arg7) {
        this.requirePhysicalPermit(arg7);
        Pair v5 = this.window();
        Object v7 = v5.component1();
        Object v5_1 = v5.component2();
        Integer v1 = Integer.valueOf(0);
        if(arg6 == null) {
            ((Class)v7).getMethod("clearForcedDisplaySize", Integer.TYPE).invoke(v5_1, v1);
            return;
        }

        int v3 = arg6.getWidth();
        if(1 <= v3) {
            int v4 = 0x8001;
            if(v3 < v4) {
                v3 = arg6.getHeight();
                if(1 <= v3 && v3 < v4) {
                    ((Class)v7).getMethod("setForcedDisplaySize", Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(v5_1, v1, Integer.valueOf(arg6.getWidth()), Integer.valueOf(arg6.getHeight()));
                    return;
                }
            }
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public static void size$default(AndroidStretchPhysicalCommands arg0, StretchSize arg1, StretchPhysicalCommandPermit arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = null;
        }

        arg0.size(arg1, arg2);
    }

    private final Pair window() {
        Object v2 = null;
        Object v6 = Class.forName("android.os.ServiceManager").getMethod("getService", String.class).invoke(v2, "window");
        if((v6 instanceof IBinder)) {
        }
        else {
            v6 = v2;
        }

        if(v6 != null && (((IBinder)v6).isBinderAlive())) {
            Class v1 = Class.forName("android.view.IWindowManager");
            v6 = Class.forName("android.view.IWindowManager$Stub").getMethod("asInterface", IBinder.class).invoke(v2, v6);
            if(v6 != null) {
                return TuplesKt.to(v1, v6);
            }
            else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }

        throw new IllegalStateException("Check failed.");
    }
}

