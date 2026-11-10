package com.TryJeanPc.goldenmouse.bridge;

import android.os.IBinder;
import android.os.Process;
import android.util.Log;
import android.view.InputEvent;
import android.view.MotionEvent;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rikka.shizuku.SystemServiceHelper;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\t\u001A\u00020\bJ\u000E\u0010\n\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\fJ\u0010\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u0010H\u0002R\u0010\u0010\u0004\u001A\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001A\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2={"Lcom/TryJeanPc/goldenmouse/bridge/InputManagerBridge;", "", "<init>", "()V", "inputManager", "injectInputEventMethod", "Ljava/lang/reflect/Method;", "legacyInjectMethodAvailable", "", "estaDisponible", "inyectar", "evento", "Landroid/view/MotionEvent;", "readDisplayId", "", "event", "Landroid/view/InputEvent;", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class InputManagerBridge {
    @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2={"Lcom/TryJeanPc/goldenmouse/bridge/InputManagerBridge$Companion;", "", "<init>", "()V", "TAG", "", "TRACE_TAG", "INJECT_INPUT_EVENT_MODE_ASYNC", "", "INVALID_UID", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final int INJECT_INPUT_EVENT_MODE_ASYNC = 0;
    private static final int INVALID_UID = -1;
    private static final String TAG = "GOLDEN_INJECTOR";
    private static final String TRACE_TAG = "GOLDEN_SHIZUKU_TRACE";
    private final Method injectInputEventMethod;
    private final Object inputManager;
    private final boolean legacyInjectMethodAvailable;

    static {
        InputManagerBridge.Companion = new Companion(null);
        InputManagerBridge.$stable = 8;
    }

    public InputManagerBridge() {
        Object v10_2;
        boolean v9_3;
        Object v9_2;
        int v7;
        Class v6;
        Method v10;
        Object v5;
        String v0 = "injectInputEvent";
        String v1 = "GOLDEN_INJECTOR";
        String v2 = "IInputManager preparado método=";
        super();
        Object v3 = null;
        boolean v4 = false;
        try {
            v5 = Class.forName("android.hardware.input.IInputManager$Stub").getMethod("asInterface", IBinder.class).invoke(v3, SystemServiceHelper.getSystemService("input"));
        }
        catch(Throwable v0_1) {
            v10 = ((Method)v3);
            goto label_83;
        }

        try {
            v6 = Class.forName("android.hardware.input.IInputManager");
            v7 = 2;
        }
        catch(Throwable v0_1) {
            goto label_78;
        }

        try {
            v9_2 = Result.constructor-impl(v6.getMethod(v0, InputEvent.class, Integer.TYPE));
            goto label_35;
        }
        catch(Throwable v9) {
            try {
                v9_2 = Result.constructor-impl(ResultKt.createFailure(v9));
            label_35:
                v9_3 = Result.isSuccess-impl(v9_2);
            }
            catch(Throwable v0_1) {
            label_78:
                v10 = ((Method)v3);
                v3 = v5;
                goto label_83;
            }
        }

        try {
            Class[] v11 = new Class[3];
            v11[0] = InputEvent.class;
            v11[1] = Integer.TYPE;
            v11[v7] = Integer.TYPE;
            v10_2 = Result.constructor-impl(v6.getMethod("injectInputEventToTarget", v11));
            goto label_54;
        }
        catch(Throwable v10_1) {
            try {
                v10_2 = Result.constructor-impl(ResultKt.createFailure(v10_1));
            label_54:
                if(Result.exceptionOrNull-impl(v10_2) == null) {
                }
                else {
                    v10 = v6.getMethod(v0, InputEvent.class, Integer.TYPE);
                }
            }
            catch(Throwable v0_1) {
                goto label_73;
            }
        }

        try {
            v0 = ((Method)v10_2).getName();
            goto label_64;
        }
        catch(Throwable v0_1) {
        }
        catch(Throwable v0_1) {
        label_73:
            v10 = ((Method)v3);
            goto label_74;
            try {
            label_64:
                Log.i(v1, v2 + v0);
                goto label_87;
            }
            catch(Throwable v0_1) {
            }
        }

    label_74:
        v3 = v5;
        v4 = v9_3;
    label_83:
        Log.e(v1, "No se pudo preparar IInputManager", v0_1);
        v5 = v3;
        v9_3 = v4;
    label_87:
        this.inputManager = v5;
        this.injectInputEventMethod = ((Method)v10_2);
        this.legacyInjectMethodAvailable = v9_3;
    }

    public final boolean estaDisponible() {
        if(this.inputManager != null && this.injectInputEventMethod != null) {
            return 1;
        }

        return 0;
    }

    public final boolean inyectar(MotionEvent arg23) {
        boolean v0_3;
        Object v0_2;
        Method v3_1;
        Method v20;
        Object v19;
        String v18;
        int v17;
        boolean v16;
        InputManagerBridge v0 = this;
        MotionEvent v1 = arg23;
        String v2 = "after method=";
        Intrinsics.checkNotNullParameter(v1, "evento");
        Object v3 = v0.inputManager;
        Integer v5 = Integer.valueOf(0);
        if(v3 == null) {
            return 0;
        }

        Method v6 = v0.injectInputEventMethod;
        if(v6 == null) {
            return 0;
        }

        int v8 = 1;
        if(v1.getActionMasked() != 0 && v1.getActionMasked() != 1) {
            goto label_22;
        }
        else if(v1.getPointerId(v1.getActionIndex()) == 0) {
        }
        else {
        label_22:
            v8 = 0;
        }

        String v7 = "GOLDEN_SHIZUKU_TRACE";
        if(v8 != 0) {
            int v9 = Process.myUid();
            String v10 = v6.getName();
            Class[] v11 = v6.getParameterTypes();
            Intrinsics.checkNotNullExpressionValue(v11, "getParameterTypes(...)");
            v16 = false;
            v17 = v8;
            v18 = v2;
            v19 = v3;
            v20 = v6;
            Log.i(v7, "before packageTarget=<not-provided> targetUid=-1 callingUid=" + v9 + " method=" + v10 + ArraysKt.joinToString$default(v11, null, "(", ")", 0, null, new InputManagerBridge$$ExternalSyntheticLambda0(), 25, null) + " legacyAvailable=" + v0.legacyInjectMethodAvailable + " mode=0 displayId=" + v0.readDisplayId(v1) + " deviceId=" + v1.getDeviceId() + " source=" + v1.getSource() + " pointerId=" + v1.getPointerId(v1.getActionIndex()) + " action=" + v1.getActionMasked() + " x=" + v1.getX(v1.getActionIndex()) + " y=" + v1.getY(v1.getActionIndex()));
        }
        else {
            v18 = v2;
            v19 = v3;
            v16 = false;
            v20 = v6;
            v17 = v8;
        }

        try {
            if(v20.getParameterTypes().length == 3) {
                v3_1 = v20;
                v0_2 = v3_1.invoke(v19, v1, v5, Integer.valueOf(-1));
            }
            else {
                v3_1 = v20;
                v0_2 = v3_1.invoke(v19, v1, v5);
            }

            if((v0_2 instanceof Boolean)) {
            }
            else {
                v0_2 = null;
            }

            v0_3 = v0_2 != null ? ((Boolean)v0_2).booleanValue() : v16;
            if(v17 != 0) {
                Log.i(v7, v18 + v3_1.getName() + " result=" + v0_3);
            }
        }
        catch(Throwable v0_1) {
            Log.e("GOLDEN_INJECTOR", "Falló injectInputEvent", v0_1);
            if(v17 != 0) {
                Log.e(v7, "exception result=false", v0_1);
            }

            return v16;
        }

        return v0_3;
    }

    static final CharSequence inyectar$lambda$3(Class arg1) {
        String v1 = arg1.getName();
        Intrinsics.checkNotNullExpressionValue(v1, "getName(...)");
        return ((CharSequence)v1);
    }

    private final int readDisplayId(InputEvent arg4) {
        Object v3_1;
        try {
            v3_1 = InputEvent.class.getMethod("getDisplayId").invoke(arg4);
            Intrinsics.checkNotNull(v3_1, "null cannot be cast to non-null type kotlin.Int");
            v3_1 = Result.constructor-impl(Integer.valueOf(((Integer)v3_1).intValue()));
        }
        catch(Throwable v3) {
            v3_1 = Result.constructor-impl(ResultKt.createFailure(v3));
        }

        Integer v4 = Integer.valueOf(-1);
        if(Result.isFailure-impl(v3_1)) {
            Integer v3_2 = v4;
        }

        return ((Number)v3_1).intValue();
    }
}

