package com.TryJeanPc.goldenmouse.engine;

import com.TryJeanPc.goldenmouse.aim.AimModeTransition$Request;
import com.TryJeanPc.goldenmouse.aim.AimModeTransition$Result;
import com.TryJeanPc.goldenmouse.aim.CameraDiagnostics$Rejection;
import com.TryJeanPc.goldenmouse.aim.CameraDiagnostics;
import com.TryJeanPc.goldenmouse.aim.CameraTouchAnchor;
import com.TryJeanPc.goldenmouse.aim.FireAimCoordinator;
import com.TryJeanPc.goldenmouse.aim.GgCameraContext;
import com.TryJeanPc.goldenmouse.aim.GoldenAimController;
import com.TryJeanPc.goldenmouse.injector.TouchInjector;
import com.TryJeanPc.goldenmouse.input.InputEvent$MouseButton;
import com.TryJeanPc.goldenmouse.input.InputPipelineDiagnostics$Stage;
import com.TryJeanPc.goldenmouse.input.InputPipelineDiagnostics;
import com.TryJeanPc.goldenmouse.input.MousePollingSelection;
import com.TryJeanPc.goldenmouse.profile.FpsCameraSettings;
import com.TryJeanPc.goldenmouse.recoil.RecoilSettings;
import java.util.concurrent.CompletableFuture;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u009E\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\'\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\f\u001A\u00020\rJ\u0015\u0010\u000E\u001A\u00020\u00072\u0006\u0010\u000F\u001A\u00020\u0010H\u0000¢\u0006\u0002\b\u0011J\r\u0010\u0012\u001A\u00020\u0007H\u0000¢\u0006\u0002\b\u0013J\u001B\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001A\u00020\u0018H\u0000¢\u0006\u0002\b\u0019J\u0015\u0010\u001A\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u0018H\u0000¢\u0006\u0002\b\u001BJ \u0010\u001C\u001A\u00020\u00072\u0018\u0010\u001D\u001A\u0014\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00070\u001EJ \u0010\u001F\u001A\u00020\u00072\u0018\u0010 \u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\"0!J\u000E\u0010#\u001A\u00020\u00072\u0006\u0010$\u001A\u00020\u0016J\u0006\u0010%\u001A\u00020\u0007J\u000E\u0010&\u001A\u00020\u00072\u0006\u0010\'\u001A\u00020\u0016J)\u0010(\u001A\b\u0012\u0004\u0012\u00020)0\u00152\u0006\u0010*\u001A\u00020+2\f\u0010,\u001A\b\u0012\u0004\u0012\u00020\u00160!H\u0000¢\u0006\u0002\b-J\u0015\u0010.\u001A\u00020\u00162\u0006\u0010/\u001A\u00020)H\u0000¢\u0006\u0002\b0J\u0006\u00101\u001A\u00020\u0016J\u001A\u00102\u001A\u00020\u00072\u0012\u00103\u001A\u000E\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00070\u0005J\u000E\u00104\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u0018J4\u00105\u001A\u00020\u00072\u0006\u00106\u001A\u0002072\u0006\u00108\u001A\u0002092\u0006\u0010:\u001A\u0002092\n\b\u0002\u0010;\u001A\u0004\u0018\u00010<2\b\b\u0002\u0010=\u001A\u00020\u0006J\u0006\u0010@\u001A\u00020\u0007J\u0006\u0010A\u001A\u00020\u0007J\u0006\u0010B\u001A\u00020\u0007J4\u0010C\u001A\u00020\u00072\u0006\u0010D\u001A\u0002092\u0006\u0010E\u001A\u0002092\b\b\u0002\u0010\u0017\u001A\u00020\u00182\b\b\u0002\u0010F\u001A\u00020\u00182\b\b\u0002\u0010G\u001A\u00020\u0016J-\u0010H\u001A\u00020\u00072\u0006\u0010D\u001A\u0002092\u0006\u0010E\u001A\u0002092\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010F\u001A\u00020\u0018H\u0000¢\u0006\u0002\bIJ\u000E\u0010J\u001A\u00020\u00072\u0006\u0010K\u001A\u00020LJ\u0015\u0010Q\u001A\u00020\u00072\u0006\u0010R\u001A\u00020NH\u0000¢\u0006\u0002\bSJ#\u0010T\u001A\u00020\u00072\u0006\u00106\u001A\u00020U2\f\u0010,\u001A\b\u0012\u0004\u0012\u00020\u00160!H\u0000¢\u0006\u0002\bVJ-\u0010W\u001A\u00020\u00072\u0006\u0010X\u001A\u00020\u00162\u0006\u0010,\u001A\u00020\u00162\u0006\u0010Y\u001A\u00020\u00182\u0006\u0010F\u001A\u00020\u0018H\u0000¢\u0006\u0002\bZJ\r\u0010[\u001A\u00020\u0007H\u0000¢\u0006\u0002\b\\J\u0016\u0010]\u001A\u00020\u00072\u0006\u0010^\u001A\u00020\u00102\u0006\u0010_\u001A\u00020\u0010J\u0006\u0010`\u001A\u00020?R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010>\u001A\u00020?X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010M\u001A\u00020N8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\bO\u0010P¨\u0006a"}, d2={"Lcom/TryJeanPc/goldenmouse/engine/GoldenEngine;", "", "touchInjector", "Lcom/TryJeanPc/goldenmouse/injector/TouchInjector;", "onCameraFailure", "Lkotlin/Function1;", "", "", "<init>", "(Lcom/TryJeanPc/goldenmouse/injector/TouchInjector;Lkotlin/jvm/functions/Function1;)V", "aimController", "Lcom/TryJeanPc/goldenmouse/aim/GoldenAimController;", "fireCoordinator", "Lcom/TryJeanPc/goldenmouse/aim/FireAimCoordinator;", "setSniperMultiplier", "multiplier", "", "setSniperMultiplier$app", "reportAimDiagnostics", "reportAimDiagnostics$app", "suspendRawForFreeLook", "Ljava/util/concurrent/CompletableFuture;", "", "sessionId", "", "suspendRawForFreeLook$app", "resumeRawFromFreeLook", "resumeRawFromFreeLook$app", "setCursorCallback", "callback", "Lkotlin/Function2;", "setCursorPositionProvider", "provider", "Lkotlin/Function0;", "Lkotlin/Pair;", "setAimInputEnabled", "enabled", "toggleAimMode", "setAimActive", "active", "setAimActiveConfirmed", "Lcom/TryJeanPc/goldenmouse/aim/AimModeTransition$Result;", "request", "Lcom/TryJeanPc/goldenmouse/aim/AimModeTransition$Request;", "authorized", "setAimActiveConfirmed$app", "isAimTransitionCurrent", "result", "isAimTransitionCurrent$app", "isAimActive", "setAimModeListener", "listener", "resetSession", "configureFpsCamera", "settings", "Lcom/TryJeanPc/goldenmouse/profile/FpsCameraSettings;", "viewportWidth", "", "viewportHeight", "touchAnchor", "Lcom/TryJeanPc/goldenmouse/aim/CameraTouchAnchor;", "gamePackage", "estado", "Lcom/TryJeanPc/goldenmouse/engine/GoldenState;", "preparar", "activar", "detener", "recibirMovimiento", "dx", "dy", "timestampNanos", "cameraOnly", "recibirMovimientoCursor", "recibirMovimientoCursor$app", "recibirBoton", "event", "Lcom/TryJeanPc/goldenmouse/input/InputEvent$MouseButton;", "mousePollingSelection", "Lcom/TryJeanPc/goldenmouse/input/MousePollingSelection;", "getMousePollingSelection$app", "()Lcom/TryJeanPc/goldenmouse/input/MousePollingSelection;", "configurePolling", "value", "configurePolling$app", "configureRecoil", "Lcom/TryJeanPc/goldenmouse/recoil/RecoilSettings;", "configureRecoil$app", "observeRecoilButton", "pressed", "session", "observeRecoilButton$app", "cancelRecoil", "cancelRecoil$app", "probarToque", "x", "y", "obtenerEstado", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GoldenEngine {
    public static final int $stable = 8;
    private final GoldenAimController aimController;
    private volatile GoldenState estado;
    private final TouchInjector touchInjector;

    static {
    }

    public GoldenEngine(TouchInjector arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "touchInjector");
        Intrinsics.checkNotNullParameter(arg3, "onCameraFailure");
        super();
        this.touchInjector = arg2;
        this.aimController = new GoldenAimController(arg2, arg3);
        this.estado = GoldenState.OFF;
    }

    public GoldenEngine() {
        this(null, null, 3, null);
    }

    public GoldenEngine(TouchInjector arg2, Function1 arg3, int arg4, DefaultConstructorMarker arg5) {
        GoldenEngine$$ExternalSyntheticLambda0 v3;
        if((arg4 & 1) != 0) {
            arg2 = new TouchInjector(null, null, 3, null);
        }

        if((arg4 & 2) != 0) {
            v3 = new GoldenEngine$$ExternalSyntheticLambda0();
        }

        this(arg2, ((Function1)v3));
    }

    static final Unit _init_$lambda$0(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "it");
        return Unit.INSTANCE;
    }

    public final void activar() {
        this.estado = GoldenState.ACTIVE;
        float v0 = TouchInjector.Companion.getScreenWidthPx() > 0 ? (((float)TouchInjector.Companion.getScreenWidthPx())) * 0.75f : 1440f;
        float v1 = TouchInjector.Companion.getScreenHeightPx() > 0 ? (((float)TouchInjector.Companion.getScreenHeightPx())) / 2f : 540f;
        this.aimController.iniciar(v0, v1);
        System.out.println("GOLDEN CORE ACTIVE — start=" + v0 + "," + v1);
    }

    public final void cancelRecoil$app() {
        this.aimController.cancelRecoil$app();
    }

    public final void configureFpsCamera(FpsCameraSettings arg16, int arg17, int arg18, CameraTouchAnchor arg19, String arg20) {
        Intrinsics.checkNotNullParameter(arg16, "settings");
        Intrinsics.checkNotNullParameter(arg20, "gamePackage");
        this.aimController.configureFpsCamera(arg16, arg17, arg18, arg19, new GgCameraContext(arg20, null, 0, 0, false, 0, 0, 0, arg16.getGoldenPrecisionPlus(), 0xFE, null));
    }

    public static void configureFpsCamera$default(GoldenEngine arg6, FpsCameraSettings arg7, int arg8, int arg9, CameraTouchAnchor arg10, String arg11, int arg12, Object arg13) {
        if((arg12 & 8) != 0) {
            arg10 = null;
        }

        CameraTouchAnchor v4 = arg10;
        if((arg12 & 16) != 0) {
            arg11 = "";
        }

        arg6.configureFpsCamera(arg7, arg8, arg9, v4, arg11);
    }

    public final void configurePolling$app(MousePollingSelection arg2) {
        Intrinsics.checkNotNullParameter(arg2, "value");
        this.aimController.configurePolling$app(arg2);
    }

    public final void configureRecoil$app(RecoilSettings arg2, Function0 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "settings");
        Intrinsics.checkNotNullParameter(arg3, "authorized");
        this.aimController.configureRecoil$app(arg2, arg3);
    }

    public final void detener() {
        this.aimController.detener();
        this.estado = GoldenState.OFF;
        System.out.println("GOLDEN CORE OFF");
    }

    public final FireAimCoordinator fireCoordinator() {
        return this.aimController.fireCoordinator();
    }

    public final MousePollingSelection getMousePollingSelection$app() {
        return this.aimController.getMousePollingSelection$app();
    }

    public final boolean isAimActive() {
        return this.aimController.isAimActive();
    }

    public final boolean isAimTransitionCurrent$app(Result arg2) {
        Intrinsics.checkNotNullParameter(arg2, "result");
        return this.aimController.isAimTransitionCurrent$app(arg2);
    }

    public final void observeRecoilButton$app(boolean arg1, boolean arg2, long arg3, long arg5) {
        this.aimController.observeRecoilButton$app(arg1, arg2, arg3, arg5);
    }

    public final GoldenState obtenerEstado() {
        return this.estado;
    }

    public final void preparar() {
        this.estado = GoldenState.READY;
        System.out.println("GOLDEN CORE READY");
    }

    public final void probarToque(float arg3, float arg4) {
        if(this.estado != GoldenState.ACTIVE) {
            return;
        }

        this.touchInjector.tocar(arg3, arg4);
    }

    public final void recibirBoton(MouseButton arg3) {
        Intrinsics.checkNotNullParameter(arg3, "event");
        if(this.estado != GoldenState.ACTIVE) {
            return;
        }

        this.aimController.aplicarBoton(arg3.getButton(), arg3.getPressed());
    }

    public final void recibirMovimiento(int arg11, int arg12, long arg13, long arg15, boolean arg17) {
        if(this.estado != GoldenState.ACTIVE) {
            CameraDiagnostics.INSTANCE.reject(Rejection.ENGINE_INACTIVE);
            InputPipelineDiagnostics.INSTANCE.count(Stage.ENGINE_INACTIVE);
            return;
        }

        GoldenAimController v0 = this.aimController;
        Long v10 = arg13 == -1 ? null : Long.valueOf(arg13);
        GoldenAimController.aplicarMovimiento$default(v0, arg11, arg12, v10, arg15, false, arg17, 16, null);
    }

    public static void recibirMovimiento$default(GoldenEngine arg8, int arg9, int arg10, long arg11, long arg13, boolean arg15, int arg16, Object arg17) {
        if((arg16 & 4) != 0) {
            arg11 = -1;
        }

        long v3 = arg11;
        long v5 = (arg16 & 8) != 0 ? System.nanoTime() : arg13;
        boolean v7 = (arg16 & 16) != 0 ? false : arg15;
        arg8.recibirMovimiento(arg9, arg10, v3, v5, v7);
    }

    public final void recibirMovimientoCursor$app(int arg13, int arg14, long arg15, long arg17) {
        if(this.estado == GoldenState.ACTIVE) {
            GoldenAimController.aplicarMovimiento$default(this.aimController, arg13, arg14, Long.valueOf(arg15), arg17, true, false, 0x20, null);
        }
    }

    public final void reportAimDiagnostics$app() {
        this.aimController.reportDiagnostics$app();
    }

    public final boolean resetSession(long arg1) {
        return this.aimController.resetSession(arg1);
    }

    public final boolean resumeRawFromFreeLook$app(long arg1) {
        return this.aimController.resumeRawFromFreeLook$app(arg1);
    }

    public final void setAimActive(boolean arg1) {
        this.aimController.setAimActive(arg1);
    }

    public final CompletableFuture setAimActiveConfirmed$app(Request arg2, Function0 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "request");
        Intrinsics.checkNotNullParameter(arg3, "authorized");
        return this.aimController.setAimActiveConfirmed$app(arg2, arg3);
    }

    public final void setAimInputEnabled(boolean arg1) {
        this.aimController.setAimInputEnabled(arg1);
    }

    public final void setAimModeListener(Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "listener");
        this.aimController.setAimModeListener(arg2);
    }

    public final void setCursorCallback(Function2 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "callback");
        this.aimController.setCursorCallback(arg2);
    }

    public final void setCursorPositionProvider(Function0 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "provider");
        this.aimController.setCursorPositionProvider(arg2);
    }

    public final void setSniperMultiplier$app(float arg1) {
        this.aimController.setSniperMultiplier$app(arg1);
    }

    public final CompletableFuture suspendRawForFreeLook$app(long arg1) {
        return this.aimController.suspendRawForFreeLook$app(arg1);
    }

    public final void toggleAimMode() {
        this.aimController.toggleFpsMode();
    }
}

