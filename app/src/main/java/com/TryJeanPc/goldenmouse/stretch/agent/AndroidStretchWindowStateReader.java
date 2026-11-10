package com.TryJeanPc.goldenmouse.stretch.agent;

import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.os.IBinder;
import android.view.Display;
import com.TryJeanPc.goldenmouse.stretch.StretchSize;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001A\u00020\u0007R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/AndroidStretchWindowStateReader;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "capture", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchWindowState;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class AndroidStretchWindowStateReader {
    public static final int $stable = 8;
    private final Context context;

    static {
    }

    public AndroidStretchWindowStateReader(Context arg2) {
        Intrinsics.checkNotNullParameter(arg2, "context");
        super();
        this.context = arg2;
    }

    public final StretchWindowState capture() {
        StretchWindowState v12_2;
        Object v12;
        Display v1_1;
        int v11;
        StretchSize v8;
        StretchSize v7;
        Object v3;
        try {
            v3 = null;
            Object v0 = Class.forName("android.os.ServiceManager").getMethod("getService", String.class).invoke(v3, "window");
            if((v0 instanceof IBinder)) {
            }
            else {
                v0 = v3;
            }

            if(v0 == null) {
                goto label_86;
            }

            if(!((IBinder)v0).isBinderAlive()) {
                goto label_82;
            }

            Class v1 = Class.forName("android.view.IWindowManager");
            v0 = Class.forName("android.view.IWindowManager$Stub").getMethod("asInterface", IBinder.class).invoke(v3, v0);
            v7 = AndroidStretchWindowStateReader.capture$size(v1, v0, "getInitialDisplaySize");
            v8 = AndroidStretchWindowStateReader.capture$size(v1, v0, "getBaseDisplaySize");
            v0 = v1.getMethod("getBaseDisplayDensity", Integer.TYPE).invoke(v0, Integer.valueOf(0));
            Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type kotlin.Int");
            v11 = ((Integer)v0).intValue();
            v0 = this.context.getSystemService(DisplayManager.class);
            if(v0 != null) {
                v1_1 = ((DisplayManager)v0).getDisplay(0);
            }
            else {
                goto label_53;
            }

            goto label_54;
        }
        catch(Exception ) {
            goto label_91;
        }

    label_53:
        v1_1 = ((Display)v3);
    label_54:
        if(v1_1 == null) {
            goto label_77;
        }

        try {
            v12 = Result.constructor-impl(Integer.valueOf(Display.class.getField("FLAG_SCALING_DISABLED").getInt(v3)));
            goto label_68;
        }
        catch(Throwable v0_1) {
            Throwable v12_1 = v0_1;
            try {
                v12 = Result.constructor-impl(ResultKt.createFailure(v12_1));
            label_68:
                if(Result.isFailure-impl(v12)) {
                }
                else {
                    v3 = v12;
                }

                v12_2 = StretchWindowState.Companion.observed(v7, v8, v1_1.getFlags(), v3, v11);
                return v12_2;
            label_77:
                throw new IllegalArgumentException("Required value was null.".toString());
            label_82:
                throw new IllegalStateException("Check failed.");
            label_86:
                throw new IllegalStateException("Window unavailable".toString());
            }
            catch(Exception ) {
            label_91:
                v12_2 = StretchWindowState.Companion.unavailable();
            }
        }

        return v12_2;
    }

    private static final StretchSize capture$size(Class arg5, Object arg6, String arg7) {
        Point v0 = new Point();
        arg5.getMethod(arg7, Integer.TYPE, Point.class).invoke(arg6, Integer.valueOf(0), v0);
        return new StretchSize(v0.x, v0.y);
    }
}

