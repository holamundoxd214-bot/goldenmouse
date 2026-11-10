package com.TryJeanPc.goldenmouse.aim;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.TryJeanPc.goldenmouse.cursor.CursorMotion;
import com.TryJeanPc.goldenmouse.cursor.CursorMotionSettings;
import com.TryJeanPc.goldenmouse.injector.TouchInjector;
import com.TryJeanPc.goldenmouse.input.InputEvent$Button;
import com.TryJeanPc.goldenmouse.input.InputPipelineDiagnostics$Stage;
import com.TryJeanPc.goldenmouse.input.InputPipelineDiagnostics;
import com.TryJeanPc.goldenmouse.input.MousePollingSelection;
import com.TryJeanPc.goldenmouse.profile.FpsCameraSettings;
import com.TryJeanPc.goldenmouse.recoil.RecoilSettings;
import java.util.concurrent.CompletableFuture;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;

@Metadata(d1={"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0007\u0018\u00002\u00020\u0001B\'\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u001E\u001A\u00020\u00072\u0006\u0010\u001F\u001A\u00020 H\u0002J\u0006\u0010!\u001A\u00020\u0019J\u0015\u0010\"\u001A\u00020\u00072\u0006\u0010#\u001A\u00020\rH\u0000¢\u0006\u0002\b$J\u0016\u0010/\u001A\u00020\u00072\u0006\u00100\u001A\u00020\r2\u0006\u00101\u001A\u00020\rJ\u000E\u00102\u001A\u00020\u00072\u0006\u00103\u001A\u00020*J)\u00104\u001A\b\u0012\u0004\u0012\u000206052\u0006\u00107\u001A\u0002082\f\u00109\u001A\b\u0012\u0004\u0012\u00020*0(H\u0000¢\u0006\u0002\b:J\u0015\u0010;\u001A\u00020*2\u0006\u0010<\u001A\u000206H\u0000¢\u0006\u0002\b=JG\u0010>\u001A\u00020\u00072\b\u0010?\u001A\u0004\u0018\u00010*2\n\b\u0002\u0010@\u001A\u0004\u0018\u0001082\u0010\b\u0002\u00109\u001A\n\u0012\u0004\u0012\u00020*\u0018\u00010(2\u0010\b\u0002\u0010A\u001A\n\u0012\u0004\u0012\u000206\u0018\u000105H\u0002¢\u0006\u0002\u0010BJ\u0006\u0010C\u001A\u00020\u0007J\u001B\u0010D\u001A\b\u0012\u0004\u0012\u00020*052\u0006\u0010E\u001A\u00020FH\u0000¢\u0006\u0002\bGJ\u0015\u0010H\u001A\u00020*2\u0006\u0010E\u001A\u00020FH\u0000¢\u0006\u0002\bIJ\r\u0010J\u001A\u00020\u0007H\u0000¢\u0006\u0002\bKJ\u001A\u0010L\u001A\u00020\u00072\u0012\u0010M\u001A\u000E\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u00070\u0005JE\u0010O\u001A\u00020\u00072\u0006\u0010P\u001A\u00020Q2\u0006\u0010R\u001A\u00020Q2\n\b\u0002\u0010E\u001A\u0004\u0018\u00010F2\b\b\u0002\u0010S\u001A\u00020F2\b\b\u0002\u0010T\u001A\u00020*2\b\b\u0002\u0010U\u001A\u00020*¢\u0006\u0002\u0010VJ\u0016\u0010W\u001A\u00020\u00072\u0006\u0010X\u001A\u00020\r2\u0006\u0010Y\u001A\u00020\rJ\u0006\u0010Z\u001A\u00020\rJ\u0006\u0010[\u001A\u00020\rJ\u0006\u0010\\\u001A\u00020\u0007J\u0016\u0010]\u001A\u00020\u00072\u0006\u0010^\u001A\u00020_2\u0006\u0010`\u001A\u00020*J\u000E\u0010a\u001A\u00020\u00072\u0006\u0010b\u001A\u00020*J\u000E\u0010c\u001A\u00020*2\u0006\u0010E\u001A\u00020FJ4\u0010d\u001A\u00020\u00072\u0006\u0010e\u001A\u00020f2\u0006\u0010g\u001A\u00020Q2\u0006\u0010h\u001A\u00020Q2\n\b\u0002\u0010i\u001A\u0004\u0018\u00010j2\b\b\u0002\u0010k\u001A\u00020lJ\u0015\u0010q\u001A\u00020\u00072\u0006\u0010\u000F\u001A\u00020nH\u0000¢\u0006\u0002\brJ#\u0010s\u001A\u00020\u00072\u0006\u0010e\u001A\u00020t2\f\u00109\u001A\b\u0012\u0004\u0012\u00020*0(H\u0000¢\u0006\u0002\buJ-\u0010v\u001A\u00020\u00072\u0006\u0010`\u001A\u00020*2\u0006\u00109\u001A\u00020*2\u0006\u0010w\u001A\u00020F2\u0006\u0010S\u001A\u00020FH\u0000¢\u0006\u0002\bxJ\r\u0010y\u001A\u00020\u0007H\u0000¢\u0006\u0002\bzJ \u0010{\u001A\u00020\u00072\u0018\u0010|\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0)0(J \u0010}\u001A\u00020\u00072\u0018\u0010~\u001A\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00070&R\u001A\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\rX\u0082\u000E¢\u0006\u0002\n\u0000R$\u0010\u0010\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\r8B@BX\u0082\u000E¢\u0006\f\u001A\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0015\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\r8B@BX\u0082\u000E¢\u0006\f\u001A\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u000E\u0010\u0018\u001A\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001A\u001A\u00020\u001BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001C\u001A\u00020\u001DX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010%\u001A\u0016\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0007\u0018\u00010&X\u0082\u000E¢\u0006\u0002\n\u0000R\"\u0010\'\u001A\u0016\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0)\u0018\u00010(X\u0082\u000E¢\u0006\u0002\n\u0000R\u001E\u0010+\u001A\u00020*2\u0006\u0010\u000F\u001A\u00020*@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b+\u0010,R\u000E\u0010-\u001A\u00020*X\u0082\u000E¢\u0006\u0002\n\u0000R\u001C\u0010.\u001A\u0010\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010N\u001A\u00020*X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010m\u001A\u00020n8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\bo\u0010p¨\u0006\u007F"}, d2={"Lcom/TryJeanPc/goldenmouse/aim/GoldenAimController;", "", "touchInjector", "Lcom/TryJeanPc/goldenmouse/injector/TouchInjector;", "onCameraFailure", "Lkotlin/Function1;", "", "", "<init>", "(Lcom/TryJeanPc/goldenmouse/injector/TouchInjector;Lkotlin/jvm/functions/Function1;)V", "cursorMotion", "Lcom/TryJeanPc/goldenmouse/cursor/CursorMotion;", "x", "", "y", "value", "sensibilidadX", "getSensibilidadX", "()F", "setSensibilidadX", "(F)V", "sensibilidadY", "getSensibilidadY", "setSensibilidadY", "fireAimCoordinator", "Lcom/TryJeanPc/goldenmouse/aim/FireAimCoordinator;", "fpsCameraEngine", "Lcom/TryJeanPc/goldenmouse/aim/FpsCameraEngine;", "touchDispatcher", "Lcom/TryJeanPc/goldenmouse/aim/AimTouchDispatcher;", "cameraFailed", "failure", "Lcom/TryJeanPc/goldenmouse/aim/AimTouchDispatcher$Failure;", "fireCoordinator", "setSniperMultiplier", "multiplier", "setSniperMultiplier$app", "cursorCallback", "Lkotlin/Function2;", "cursorPositionProvider", "Lkotlin/Function0;", "Lkotlin/Pair;", "", "isAimActive", "()Z", "aimInputEnabled", "aimModeListener", "iniciar", "inicioX", "inicioY", "setAimActive", "active", "setAimActiveConfirmed", "Ljava/util/concurrent/CompletableFuture;", "Lcom/TryJeanPc/goldenmouse/aim/AimModeTransition$Result;", "request", "Lcom/TryJeanPc/goldenmouse/aim/AimModeTransition$Request;", "authorized", "setAimActiveConfirmed$app", "isAimTransitionCurrent", "result", "isAimTransitionCurrent$app", "updateAimMode", "requested", "confirmation", "completion", "(Ljava/lang/Boolean;Lcom/TryJeanPc/goldenmouse/aim/AimModeTransition$Request;Lkotlin/jvm/functions/Function0;Ljava/util/concurrent/CompletableFuture;)V", "toggleFpsMode", "suspendRawForFreeLook", "sessionId", "", "suspendRawForFreeLook$app", "resumeRawFromFreeLook", "resumeRawFromFreeLook$app", "reportDiagnostics", "reportDiagnostics$app", "setAimModeListener", "listener", "isLeftButtonPressed", "aplicarMovimiento", "dx", "", "dy", "timestampNanos", "cursorOnly", "cameraOnly", "(IILjava/lang/Long;JZZ)V", "cambiarSensibilidad", "sx", "sy", "obtenerX", "obtenerY", "detener", "aplicarBoton", "button", "Lcom/TryJeanPc/goldenmouse/input/InputEvent$Button;", "pressed", "setAimInputEnabled", "enabled", "resetSession", "configureFpsCamera", "settings", "Lcom/TryJeanPc/goldenmouse/profile/FpsCameraSettings;", "viewportWidth", "viewportHeight", "touchAnchor", "Lcom/TryJeanPc/goldenmouse/aim/CameraTouchAnchor;", "context", "Lcom/TryJeanPc/goldenmouse/aim/GgCameraContext;", "mousePollingSelection", "Lcom/TryJeanPc/goldenmouse/input/MousePollingSelection;", "getMousePollingSelection$app", "()Lcom/TryJeanPc/goldenmouse/input/MousePollingSelection;", "configurePolling", "configurePolling$app", "configureRecoil", "Lcom/TryJeanPc/goldenmouse/recoil/RecoilSettings;", "configureRecoil$app", "observeRecoilButton", "session", "observeRecoilButton$app", "cancelRecoil", "cancelRecoil$app", "setCursorPositionProvider", "provider", "setCursorCallback", "callback", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GoldenAimController {
    public static final int $stable = 8;
    private volatile boolean aimInputEnabled;
    private volatile Function1 aimModeListener;
    private volatile Function2 cursorCallback;
    private final CursorMotion cursorMotion;
    private volatile Function0 cursorPositionProvider;
    private final FireAimCoordinator fireAimCoordinator;
    private final FpsCameraEngine fpsCameraEngine;
    private volatile boolean isAimActive;
    private volatile boolean isLeftButtonPressed;
    private final Function1 onCameraFailure;
    private final AimTouchDispatcher touchDispatcher;
    private float x;
    private float y;

    static {
    }

    public GoldenAimController() {
        this(null, null, 3, null);
    }

    public GoldenAimController(TouchInjector arg2, Function1 arg3, int arg4, DefaultConstructorMarker arg5) {
        GoldenAimController$$ExternalSyntheticLambda0 v3;
        if((arg4 & 1) != 0) {
            arg2 = new TouchInjector(null, null, 3, null);
        }

        if((arg4 & 2) != 0) {
            v3 = new GoldenAimController$$ExternalSyntheticLambda0();
        }

        this(arg2, ((Function1)v3));
    }

    public GoldenAimController(TouchInjector arg8, Function1 arg9) {
        Intrinsics.checkNotNullParameter(arg8, "touchInjector");
        Intrinsics.checkNotNullParameter(arg9, "onCameraFailure");
        super();
        this.onCameraFailure = arg9;
        this.cursorMotion = new CursorMotion();
        FireAimCoordinator v0 = new FireAimCoordinator(40, SuppressAxis.NONE, null, 4, null);
        this.fireAimCoordinator = v0;
        FpsCameraEngine v9 = new FpsCameraEngine(null, 1, null);
        this.fpsCameraEngine = v9;
        this.touchDispatcher = new AimTouchDispatcher(arg8, v9, v0, new GoldenAimController$touchDispatcher$1(this));
        this.aimInputEnabled = true;
    }

    static final Unit _init_$lambda$0(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "it");
        return Unit.INSTANCE;
    }

    public static final void access$cameraFailed(GoldenAimController arg0, Failure arg1) {
        arg0.cameraFailed(arg1);
    }

    public final void aplicarBoton(Button arg2, boolean arg3) {
        Intrinsics.checkNotNullParameter(arg2, "button");
        if(arg2 != Button.LEFT) {
        }
        else {
            this.isLeftButtonPressed = arg3;
            Function0 v2 = this.cursorPositionProvider;
            if(v2 != null) {
                Object v2_1 = v2.invoke();
                if(v2_1 == null) {
                }
                else {
                    this.touchDispatcher.offerMouseButton(arg3, ((Pair)v2_1).getFirst().floatValue(), ((Pair)v2_1).getSecond().floatValue());
                }
            }
        }
    }

    public final void aplicarMovimiento(int arg7, int arg8, Long arg9, long arg10, boolean arg12, boolean arg13) {
        Throwable v7_4;
        __monitor_enter(this);
        if(arg12) {
            try {
                if(!this.isAimActive) {
                label_8:
                    if(arg13) {
                        if(!this.isAimActive) {
                            goto label_13;
                        }
                        else if(!this.aimInputEnabled) {
                            goto label_13;
                        }
                    }

                    goto label_15;
                }
            }
            catch(Throwable v0) {
                goto label_6;
            }
        }
        else {
            goto label_8;
        }

    label_13:
        __monitor_exit(this);
        return;
        try {
        label_15:
            if(!this.isAimActive || !this.aimInputEnabled) {
                int v9 = arg7;
                long v11 = arg10;
                int v10 = arg8;
                InputPipelineDiagnostics.INSTANCE.count(Stage.AIM_INACTIVE);
                CameraDiagnostics.INSTANCE.cursor();
                float v7 = this.cursorMotion.gain(v9, v10, v11, CursorMotionSettings.INSTANCE.getOptions());
                float v8 = (((float)v9)) * this.getSensibilidadX() * v7;
                float v9_1 = (((float)v10)) * this.getSensibilidadY() * v7;
                Function2 v7_1 = this.cursorCallback;
                if(v7_1 != null) {
                    v7_1.invoke(Float.valueOf(v8), Float.valueOf(v9_1));
                }

                if(!this.isLeftButtonPressed) {
                    goto label_72;
                }

                Function0 v7_2 = this.cursorPositionProvider;
                if(v7_2 == null) {
                    goto label_72;
                }

                Object v7_3 = v7_2.invoke();
                if(v7_3 == null) {
                    goto label_72;
                }

                this.touchDispatcher.offerMouseDrag(((Pair)v7_3).component1().floatValue(), ((Pair)v7_3).component2().floatValue());
                goto label_72;
            label_6:
                v7_4 = v0;
                __monitor_exit(this);
                goto label_75;
            }
            else {
                InputPipelineDiagnostics.INSTANCE.count(Stage.AIM);
                this.touchDispatcher.offerDelta(arg7, arg8, arg9, arg10);
                this.x = this.fpsCameraEngine.getX();
                this.y = this.fpsCameraEngine.getY();
            }

            goto label_72;
        }
        catch(Throwable v0) {
            goto label_6;
        }

    label_75:
        throw v7_4;
    label_72:
        __monitor_exit(this);
    }

    public static void aplicarMovimiento$default(GoldenAimController arg8, int arg9, int arg10, Long arg11, long arg12, boolean arg14, boolean arg15, int arg16, Object arg17) {
        if((arg16 & 4) != 0) {
            arg11 = null;
        }

        Long v3 = arg11;
        if((arg16 & 8) != 0) {
            arg12 = System.nanoTime();
        }

        long v4 = arg12;
        boolean v6 = (arg16 & 16) != 0 ? false : arg14;
        boolean v7 = (arg16 & 0x20) != 0 ? false : arg15;
        arg8.aplicarMovimiento(arg9, arg10, v3, v4, v6, v7);
    }

    public final void cambiarSensibilidad(float arg1, float arg2) {
        this.setSensibilidadX(arg1);
        this.setSensibilidadY(arg2);
    }

    private final void cameraFailed(Failure arg3) {
        Function1 v1;
        __monitor_enter(this);
        try {
            if(this.touchDispatcher.isFailureCurrent(arg3)) {
                goto label_7;
            }
        }
        catch(Throwable v3) {
            goto label_27;
        }

        __monitor_exit(this);
        return;
        try {
        label_7:
            this.isAimActive = false;
            this.aimInputEnabled = false;
            this.cursorMotion.reset();
            v1 = this.aimModeListener;
        }
        catch(Throwable v3) {
        label_27:
            __monitor_exit(this);
            throw v3;
        }

        __monitor_exit(this);
        if(v1 != null) {
            try {
                v1.invoke(Boolean.valueOf(false));
            }
            catch(Throwable v0) {
                this.onCameraFailure.invoke(arg3.getReason());
                throw v0;
            }
        }

        this.onCameraFailure.invoke(arg3.getReason());
    }

    public final void cancelRecoil$app() {
        this.touchDispatcher.cancelRecoil();
    }

    public final void configureFpsCamera(FpsCameraSettings arg10, int arg11, int arg12, CameraTouchAnchor arg13, GgCameraContext arg14) {
        float v0_3;
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(arg10, "settings");
            Intrinsics.checkNotNullParameter(arg14, "context");
            boolean v1 = false;
            this.touchDispatcher.setAimEnabled(false);
            FpsCameraEngine v2 = this.fpsCameraEngine;
            Resources v0_1 = Resources.getSystem();
            if(v0_1 != null) {
                DisplayMetrics v0_2 = v0_1.getDisplayMetrics();
                if(v0_2 != null) {
                    v0_3 = v0_2.density * 160f;
                }
                else {
                    goto label_17;
                }
            }
            else {
            label_17:
                v0_3 = 480f;
            }

            v2.configure(arg10, arg11, arg12, arg13, v0_3, arg14);
            Pair v10 = this.fpsCameraEngine.centerPosition();
            float v3 = v10.component1().floatValue();
            float v4 = v10.component2().floatValue();
            this.x = v3;
            this.y = v4;
            if((this.aimInputEnabled) && (this.isAimActive) && (this.fpsCameraEngine.getHasValidAnchor())) {
                v1 = true;
            }

            this.touchDispatcher.setAimEnabled(v1);
            if(v1) {
                AimTouchDispatcher.engageAtCenter$default(this.touchDispatcher, v3, v4, null, 4, null);
            }
        }
        catch(Throwable v0) {
        label_52:
            Throwable v10_1 = v0;
            try {
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_52;
            }

            throw v10_1;
        }

        __monitor_exit(this);
    }

    public static void configureFpsCamera$default(GoldenAimController arg18, FpsCameraSettings arg19, int arg20, int arg21, CameraTouchAnchor arg22, GgCameraContext arg23, int arg24, Object arg25) {
        CameraTouchAnchor v5 = (arg24 & 8) != 0 ? null : arg22;
        GgCameraContext v6 = (arg24 & 16) != 0 ? new GgCameraContext(null, null, 0, 0, false, 0, 0, 0, false, 0x1FF, null) : arg23;
        arg18.configureFpsCamera(arg19, arg20, arg21, v5, v6);
    }

    public final void configurePolling$app(MousePollingSelection arg2) {
        Intrinsics.checkNotNullParameter(arg2, "value");
        this.touchDispatcher.configurePolling$app(arg2);
    }

    public final void configureRecoil$app(RecoilSettings arg2, Function0 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "settings");
        Intrinsics.checkNotNullParameter(arg3, "authorized");
        this.touchDispatcher.configureRecoil(arg2, arg3);
    }

    public final void detener() {
        this.cursorMotion.reset();
        this.touchDispatcher.stop();
    }

    public final FireAimCoordinator fireCoordinator() {
        return this.fireAimCoordinator;
    }

    public final MousePollingSelection getMousePollingSelection$app() {
        return this.touchDispatcher.getPollingSelection$app();
    }

    private final float getSensibilidadX() {
        return MouseSettings.INSTANCE.getSensibilidadX();
    }

    private final float getSensibilidadY() {
        return MouseSettings.INSTANCE.getSensibilidadY();
    }

    public final void iniciar(float arg7, float arg8) {
        __monitor_enter(this);
        try {
            this.cursorMotion.reset();
            if(TouchInjector.Companion.getScreenWidthPx() > 0 && TouchInjector.Companion.getScreenHeightPx() > 0) {
                this.fpsCameraEngine.updateViewport(TouchInjector.Companion.getScreenWidthPx(), TouchInjector.Companion.getScreenHeightPx());
            }

            this.x = this.fpsCameraEngine.getCenterX();
            this.y = this.fpsCameraEngine.getCenterY();
            this.touchDispatcher.start();
            boolean v7 = !this.aimInputEnabled || !this.isAimActive || !this.fpsCameraEngine.getHasValidAnchor() ? false : true;
            this.touchDispatcher.setAimEnabled(v7);
            if(v7) {
                AimTouchDispatcher.engageAtCenter$default(this.touchDispatcher, this.x, this.y, null, 4, null);
            }
        }
        catch(Throwable v0) {
        label_46:
            Throwable v7_1 = v0;
            try {
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_46;
            }

            throw v7_1;
        }

        __monitor_exit(this);
    }

    public final boolean isAimActive() {
        return this.isAimActive;
    }

    public final boolean isAimTransitionCurrent$app(Result arg2) {
        Intrinsics.checkNotNullParameter(arg2, "result");
        return this.touchDispatcher.isTransitionCurrent$app(arg2);
    }

    public final void observeRecoilButton$app(boolean arg1, boolean arg2, long arg3, long arg5) {
        this.touchDispatcher.observeRecoilButton(arg1, arg2, arg3, arg5);
    }

    public final float obtenerX() {
        return this.fpsCameraEngine.getX();
    }

    public final float obtenerY() {
        return this.fpsCameraEngine.getY();
    }

    public final void reportDiagnostics$app() {
        this.touchDispatcher.getMetrics$app().reportIfDue();
    }

    public final boolean resetSession(long arg6) {
        boolean v0 = this.touchDispatcher.resetSession(arg6);
        __monitor_enter(this);
        try {
            this.cursorMotion.reset();
            Pair v1 = this.fpsCameraEngine.resetToCenter("session-reset");
            float v2 = v1.component1().floatValue();
            float v1_1 = v1.component2().floatValue();
            this.x = v2;
            this.y = v1_1;
            boolean v3 = !this.aimInputEnabled || !this.isAimActive || !this.fpsCameraEngine.getHasValidAnchor() ? false : true;
            this.touchDispatcher.setAimEnabled(v3);
            if(v3) {
                this.touchDispatcher.engageAtCenter(v2, v1_1, Long.valueOf(arg6));
            }
        }
        catch(Throwable v6) {
            __monitor_exit(this);
            throw v6;
        }

        __monitor_exit(this);
        return v0;
    }

    public final boolean resumeRawFromFreeLook$app(long arg1) {
        return this.touchDispatcher.resumeRawFromFreeLook$app(arg1);
    }

    public final void setAimActive(boolean arg8) {
        GoldenAimController.updateAimMode$default(this, Boolean.valueOf(arg8), null, null, null, 14, null);
    }

    public final CompletableFuture setAimActiveConfirmed$app(Request arg3, Function0 arg4) {
        Intrinsics.checkNotNullParameter(arg3, "request");
        Intrinsics.checkNotNullParameter(arg4, "authorized");
        CompletableFuture v0 = new CompletableFuture();
        this.updateAimMode(Boolean.valueOf(arg3.getActive()), arg3, arg4, v0);
        return v0;
    }

    public final void setAimInputEnabled(boolean arg8) {
        __monitor_enter(this);
        try {
            this.cursorMotion.reset();
            boolean v1 = true;
            int v0_1 = !this.aimInputEnabled || !this.isAimActive ? 0 : 1;
            this.aimInputEnabled = arg8;
            int v8 = !this.aimInputEnabled || !this.isAimActive ? 0 : 1;
            if(v0_1 != 0 || v8 == 0) {
                AimTouchDispatcher v0_2 = this.touchDispatcher;
                if(v8 == 0 || !this.fpsCameraEngine.getHasValidAnchor()) {
                    v1 = false;
                }
                else {
                }

                v0_2.setAimEnabled(v1);
            }
            else {
                if(TouchInjector.Companion.getScreenWidthPx() > 0 && TouchInjector.Companion.getScreenHeightPx() > 0) {
                    this.fpsCameraEngine.updateViewport(TouchInjector.Companion.getScreenWidthPx(), TouchInjector.Companion.getScreenHeightPx());
                }

                Pair v8_1 = this.fpsCameraEngine.resetToCenter("input-resume");
                float v2 = v8_1.component1().floatValue();
                float v3 = v8_1.component2().floatValue();
                this.x = v2;
                this.y = v3;
                this.touchDispatcher.setAimEnabled(this.fpsCameraEngine.getHasValidAnchor());
                if(!this.fpsCameraEngine.getHasValidAnchor()) {
                    goto label_64;
                }

                AimTouchDispatcher.engageAtCenter$default(this.touchDispatcher, v2, v3, null, 4, null);
            }
        }
        catch(Throwable v0) {
        label_67:
            Throwable v8_2 = v0;
            try {
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_67;
            }

            throw v8_2;
        }

    label_64:
        __monitor_exit(this);
    }

    public final void setAimModeListener(Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "listener");
        this.aimModeListener = arg2;
    }

    public final void setCursorCallback(Function2 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "callback");
        this.cursorCallback = arg2;
    }

    public final void setCursorPositionProvider(Function0 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "provider");
        this.cursorPositionProvider = arg2;
    }

    private final void setSensibilidadX(float arg1) {
        MouseSettings.INSTANCE.setSensibilidadX(arg1);
    }

    private final void setSensibilidadY(float arg1) {
        MouseSettings.INSTANCE.setSensibilidadY(arg1);
    }

    public final void setSniperMultiplier$app(float arg1) {
        this.fpsCameraEngine.setSensitivityMultiplier$app(arg1);
    }

    public final CompletableFuture suspendRawForFreeLook$app(long arg1) {
        return this.touchDispatcher.suspendRawForFreeLook$app(arg1);
    }

    public final void toggleFpsMode() {
        GoldenAimController.updateAimMode$default(this, null, null, null, null, 14, null);
    }

    private final void updateAimMode(Boolean arg6, Request arg7, Function0 arg8, CompletableFuture arg9) {
        Function1 v6_3;
        long v3;
        boolean v6_1;
        BooleanRef v0 = new BooleanRef();
        __monitor_enter(this);
        boolean v1 = false;
        if(arg6 != null) {
            try {
                v6_1 = arg6.booleanValue();
                goto label_13;
            label_8:
                v6_1 = !this.isAimActive ? true : false;
            label_13:
                v0.element = v6_1;
                v3 = -1;
                if(arg7 != null) {
                    if(arg8 != null && (arg8.invoke().booleanValue()) && (this.aimInputEnabled)) {
                        if(!v0.element) {
                        }
                        else if(!this.fpsCameraEngine.getHasValidAnchor()) {
                            goto label_27;
                        }

                        goto label_34;
                    }

                label_27:
                    if(arg9 != null) {
                        arg9.complete(new Result(arg7, v3, Status.CANCELLED));
                    }

                    goto label_32;
                }

                goto label_34;
            }
            catch(Throwable v6) {
                goto label_78;
            }
        }
        else {
            goto label_8;
        }

        goto label_13;
    label_32:
        __monitor_exit(this);
        return;
        try {
        label_34:
            if(this.isAimActive != v0.element) {
                v1 = true;
            }

            v6_1 = this.fpsCameraEngine.viewportChanged$app(TouchInjector.Companion.getScreenWidthPx(), TouchInjector.Companion.getScreenHeightPx());
            if(!v1 && !v6_1) {
                if(arg7 != null && arg9 != null) {
                    arg9.complete(new Result(arg7, v3, Status.CANCELLED));
                }

                goto label_52;
            }

            goto label_54;
        }
        catch(Throwable v6) {
            goto label_78;
        }

    label_52:
        __monitor_exit(this);
        return;
        try {
        label_54:
            GoldenAimController$$ExternalSyntheticLambda1 v8 = new GoldenAimController$$ExternalSyntheticLambda1(this, v6_1, v1, v0);
            if(arg7 == null) {
                ((Function0)v8).invoke();
            }
            else {
                AimTouchDispatcher v6_2 = this.touchDispatcher;
                if(arg9 == null) {
                    goto label_72;
                }
                else if(!v6_2.confirmTransition$app(arg7, arg9, ((Function0)v8))) {
                    goto label_63;
                }
            }

            goto label_65;
        }
        catch(Throwable v6) {
            goto label_78;
        }

    label_63:
        __monitor_exit(this);
        return;
        try {
        label_65:
            v6_3 = this.aimModeListener;
        }
        catch(Throwable v6) {
            goto label_78;
        }

        __monitor_exit(this);
        if(v6_3 != null) {
            v6_3.invoke(Boolean.valueOf(v0.element));
        }

        return;
        try {
        label_72:
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        catch(Throwable v6) {
        label_78:
            __monitor_exit(this);
            throw v6;
        }
    }

    static void updateAimMode$default(GoldenAimController arg1, Boolean arg2, Request arg3, Function0 arg4, CompletableFuture arg5, int arg6, Object arg7) {
        Request v0 = null;
        if((arg6 & 2) != 0) {
            arg3 = v0;
        }

        if((arg6 & 4) != 0) {
            arg4 = ((Function0)v0);
        }

        if((arg6 & 8) != 0) {
            arg5 = ((CompletableFuture)v0);
        }

        arg1.updateAimMode(arg2, arg3, arg4, arg5);
    }

    static final Unit updateAimMode$lambda$3$lambda$2(GoldenAimController arg8, boolean arg9, boolean arg10, BooleanRef arg11) {
        arg8.cursorMotion.reset();
        boolean v1 = false;
        arg8.touchDispatcher.setAimEnabled(false);
        if(arg9) {
            arg8.fpsCameraEngine.updateViewport(TouchInjector.Companion.getScreenWidthPx(), TouchInjector.Companion.getScreenHeightPx());
        }

        if((arg10) || (arg11.element)) {
            Pair v9 = arg8.fpsCameraEngine.resetToCenter("mode-change");
            float v10 = v9.component1().floatValue();
            float v9_1 = v9.component2().floatValue();
            arg8.x = v10;
            arg8.y = v9_1;
            arg8.isLeftButtonPressed = false;
            arg8.fireAimCoordinator.onFireUp();
        }

        arg8.isAimActive = arg11.element;
        if((arg8.aimInputEnabled) && (arg8.isAimActive) && (arg8.fpsCameraEngine.getHasValidAnchor())) {
            v1 = true;
        }

        arg8.touchDispatcher.setAimEnabled(v1);
        if(v1) {
            AimTouchDispatcher.engageAtCenter$default(arg8.touchDispatcher, arg8.fpsCameraEngine.getCenterX(), arg8.fpsCameraEngine.getCenterY(), null, 4, null);
        }

        return Unit.INSTANCE;
    }
}

