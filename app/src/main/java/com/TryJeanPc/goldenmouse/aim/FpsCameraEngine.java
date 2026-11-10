package com.TryJeanPc.goldenmouse.aim;

import com.TryJeanPc.goldenmouse.aim.gg.FpsCameraKernel$Bounds;
import com.TryJeanPc.goldenmouse.aim.gg.FpsCameraKernel$HorizontalCorrection;
import com.TryJeanPc.goldenmouse.aim.gg.FpsCameraKernel$TouchSink;
import com.TryJeanPc.goldenmouse.aim.gg.FpsCameraKernel;
import com.TryJeanPc.goldenmouse.profile.FpsCameraSettings;
import com.TryJeanPc.goldenmouse.profile.GameProfileKt;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000g\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0017\n\u0002\u0010\u000E\n\u0000*\u0001(\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u000E\b\u0002\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010*\u001A\u00020+2\u0006\u0010\u0007\u001A\u00020$H\u0000¢\u0006\u0002\b,J>\u0010-\u001A\u00020+2\u0006\u0010\u0016\u001A\u00020\u00172\u0006\u0010.\u001A\u00020\u001D2\u0006\u0010/\u001A\u00020\u001D2\n\b\u0002\u0010\u0018\u001A\u0004\u0018\u00010\u00192\b\b\u0002\u00100\u001A\u00020\b2\b\b\u0002\u0010\u001A\u001A\u00020\u001BJ\u0010\u00101\u001A\u00020\u001D2\u0006\u0010\u0007\u001A\u00020\bH\u0002J\u0015\u00102\u001A\u00020+2\u0006\u0010\u0007\u001A\u00020\bH\u0000¢\u0006\u0002\b3J\u0015\u00104\u001A\u00020+2\u0006\u00105\u001A\u00020&H\u0000¢\u0006\u0002\b6J\u0015\u00107\u001A\u00020\u001D2\u0006\u0010\u0007\u001A\u00020\u001DH\u0000¢\u0006\u0002\b8J\u000F\u00109\u001A\u0004\u0018\u00010&H\u0000¢\u0006\u0002\b:J\u001D\u0010;\u001A\u00020\u00122\u0006\u0010<\u001A\u00020\u001D2\u0006\u0010=\u001A\u00020\u001DH\u0000¢\u0006\u0002\b>J\u0016\u0010?\u001A\u00020+2\u0006\u0010<\u001A\u00020\u001D2\u0006\u0010=\u001A\u00020\u001DJ\u0012\u0010@\u001A\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\"J\u001C\u0010A\u001A\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\"2\b\b\u0002\u0010B\u001A\u00020CR\u0014\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001E\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\b@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u001E\u0010\f\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\b@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000BR\u001E\u0010\u000E\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\b@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u000BR\u001E\u0010\u0010\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\b@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u000BR\u001E\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0007\u001A\u00020\u0012@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u000E\u0010\u0016\u001A\u00020\u0017X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001A\u0004\u0018\u00010\u0019X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001A\u001A\u00020\u001BX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001C\u001A\u00020\u001DX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001E\u001A\u00020\u001DX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001F\u001A\u00020\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010 \u001A\u00020\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u0010!\u001A\u000E\u0012\u0004\u0012\u00020\u001D\u0012\u0004\u0012\u00020\u001D0\"X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010#\u001A\u0004\u0018\u00010$X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010%\u001A\u0004\u0018\u00010&X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\'\u001A\u00020(X\u0082\u0004¢\u0006\u0004\n\u0002\u0010)¨\u0006D"}, d2={"Lcom/TryJeanPc/goldenmouse/aim/FpsCameraEngine;", "", "randomSeed", "Lkotlin/Function0;", "", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "value", "", "x", "getX", "()F", "y", "getY", "centerX", "getCenterX", "centerY", "getCenterY", "", "hasValidAnchor", "getHasValidAnchor", "()Z", "settings", "Lcom/TryJeanPc/goldenmouse/profile/FpsCameraSettings;", "touchAnchor", "Lcom/TryJeanPc/goldenmouse/aim/CameraTouchAnchor;", "context", "Lcom/TryJeanPc/goldenmouse/aim/GgCameraContext;", "width", "", "height", "dpi", "multiplier", "effectiveSensitivity", "Lkotlin/Pair;", "sink", "Lcom/TryJeanPc/goldenmouse/aim/gg/FpsCameraKernel$TouchSink;", "kernel", "Lcom/TryJeanPc/goldenmouse/aim/gg/FpsCameraKernel;", "output", "com/TryJeanPc/goldenmouse/aim/FpsCameraEngine$output$1", "Lcom/TryJeanPc/goldenmouse/aim/FpsCameraEngine$output$1;", "attachSink", "", "attachSink$app", "configure", "viewportWidth", "viewportHeight", "densityDpi", "sensitivity", "setSensitivityMultiplier", "setSensitivityMultiplier$app", "applySensitivityTo", "target", "applySensitivityTo$app", "recoilVerticalDelta", "recoilVerticalDelta$app", "dispatchKernel", "dispatchKernel$app", "viewportChanged", "w", "h", "viewportChanged$app", "updateViewport", "centerPosition", "resetToCenter", "reason", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class FpsCameraEngine {
    public static final int $stable = 8;
    private volatile float centerX;
    private volatile float centerY;
    private GgCameraContext context;
    private float dpi;
    private volatile Pair effectiveSensitivity;
    private volatile boolean hasValidAnchor;
    private int height;
    private volatile FpsCameraKernel kernel;
    private float multiplier;
    private final FpsCameraEngine$output$1 output;
    private final Function0 randomSeed;
    private FpsCameraSettings settings;
    private TouchSink sink;
    private CameraTouchAnchor touchAnchor;
    private int width;
    private volatile float x;
    private volatile float y;

    public static long $r8$lambda$VDnw1lbBGTMwvhsf4ok7s_RgRLc() {
        return System.currentTimeMillis();
    }

    static {
    }

    public FpsCameraEngine(Function0 arg1, int arg2, DefaultConstructorMarker arg3) {
        com.TryJeanPc.goldenmouse.aim.FpsCameraEngine$1 v1;
        if((arg2 & 1) != 0) {
            v1 = com.TryJeanPc.goldenmouse.aim.FpsCameraEngine$1.INSTANCE;
        }

        this(((Function0)v1));
    }

    public FpsCameraEngine() {
        this(null, 1, null);
    }

    public FpsCameraEngine(Function0 arg14) {
        Intrinsics.checkNotNullParameter(arg14, "randomSeed");
        super();
        this.randomSeed = arg14;
        this.x = 1440f;
        this.y = 540f;
        this.centerX = this.x;
        this.centerY = this.y;
        this.hasValidAnchor = true;
        this.settings = new FpsCameraSettings(false, 0f, 0f, 0f, 0f, 0f, false, 0f, false, 0x1FF, null);
        this.context = new GgCameraContext(null, null, 0, 0, false, 0, 0, 0, false, 0x1FF, null);
        this.width = 0x780;
        this.height = 1080;
        this.dpi = 480f;
        this.multiplier = 1f;
        Integer v14 = Integer.valueOf(1000);
        this.effectiveSensitivity = TuplesKt.to(v14, v14);
        this.output = new FpsCameraEngine$output$1(this);
    }

    public static final TouchSink access$getSink$p(FpsCameraEngine arg0) {
        return arg0.sink;
    }

    public static final void access$setX$p(FpsCameraEngine arg0, float arg1) {
        arg0.x = arg1;
    }

    public static final void access$setY$p(FpsCameraEngine arg0, float arg1) {
        arg0.y = arg1;
    }

    public final void applySensitivityTo$app(FpsCameraKernel arg2) {
        Intrinsics.checkNotNullParameter(arg2, "target");
        arg2.setSensitivity(this.effectiveSensitivity.component1().intValue(), this.effectiveSensitivity.component2().intValue());
    }

    public final void attachSink$app(TouchSink arg2) {
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(arg2, "value");
            this.sink = arg2;
        }
        catch(Throwable v2) {
            try {
            label_7:
                __monitor_exit(this);
            }
            catch(Throwable v2) {
                goto label_7;
            }

            throw v2;
        }

        __monitor_exit(this);
    }

    public final Pair centerPosition() {
        return TuplesKt.to(Float.valueOf(this.centerX), Float.valueOf(this.centerY));
    }

    public final void configure(FpsCameraSettings arg23, int arg24, int arg25, CameraTouchAnchor arg26, float arg27, GgCameraContext arg28) {
        String v5_3;
        HorizontalCorrection v0_2;
        boolean v7;
        FpsCameraKernel v9;
        FpsCameraEngine v1 = this;
        FpsCameraSettings v0 = arg23;
        CameraTouchAnchor v2 = arg26;
        GgCameraContext v3 = arg28;
        String v4 = "GG configured package=";
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(v0, "settings");
            Intrinsics.checkNotNullParameter(v3, "context");
            v1.settings = v0;
            v1.touchAnchor = v2;
            v1.context = v3;
            v1.width = arg24;
            v1.height = arg25;
            Float v5 = Float.valueOf(arg27);
            float v6 = v5.floatValue();
            float v8 = 0f;
            v9 = null;
            if(Float.compare(Math.abs(v6), 3.402823E+38f) > 0 || v6 <= 0f) {
                v5 = ((Float)v9);
            }
            else {
            }

            float v5_1 = v5 != null ? v5.floatValue() : 480f;
            v1.dpi = v5_1;
            v1.multiplier = 1f;
            v1.effectiveSensitivity = TuplesKt.to(Integer.valueOf(v1.sensitivity(v0.getSensitivityX())), Integer.valueOf(v1.sensitivity(v0.getSensitivityY())));
            if(v2 == null) {
                v2 = CameraTouchAnchor.Companion.getDEFAULT();
            }

            Pair v2_1 = v2.resolve$app(v1.width, v1.height);
            v7 = v2_1 != null ? true : false;
            v1.hasValidAnchor = v7;
            float v7_1 = v2_1 != null ? v2_1.getFirst().floatValue() : 0f;
            v1.centerX = v7_1;
            if(v2_1 != null) {
                v8 = v2_1.getSecond().floatValue();
            }

            v1.centerY = v8;
            v1.x = v1.centerX;
            v1.y = v1.centerY;
            if(v2_1 != null) {
                goto label_75;
            }

            v1.kernel = v9;
        }
        catch(Throwable v0_1) {
            goto label_212;
        }

        __monitor_exit(this);
        return;
        try {
        label_75:
            String v2_2 = v3.getGamePackage();
            Locale v7_2 = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(v7_2, "ROOT");
            v2_2 = v2_2.toLowerCase(v7_2);
            Intrinsics.checkNotNullExpressionValue(v2_2, "toLowerCase(...)");
            int v10 = 2;
            v7 = StringsKt.contains$default(v2_2, "com.dts.freefire", false, v10, v9);
            int v8_1 = (v7) || (StringsKt.contains$default(v2_2, "com.moonite.elhero", false, v10, v9)) ? 1 : 0;
            Bounds v6_1 = v8_1 != 0 || (StringsKt.contains$default(v3.getGamePackage(), "com.netease.l22", false, v10, v9)) ? new Bounds(0xFFF5D3D6, 0xFFF5D3D6, 0xA2C2A, 0xA2C2A) : new Bounds(Math.min(50, (v1.width - 1) / v10), Math.min(50, (v1.height - 1) / v10), Math.max(v1.width - 50, v1.width / v10), Math.max(v1.height - 50, v1.height / v10));
            FpsCameraKernel v12 = new FpsCameraKernel(v6_1, ((int)v1.centerX), ((int)v1.centerY), Math.max(v1.width, v1.height), v1.dpi, v1.randomSeed.invoke().longValue(), v1.output, new FpsCameraEngine$$ExternalSyntheticLambda0());
            v12.setCompletionClock(new FpsCameraEngine$$ExternalSyntheticLambda1());
            v12.setSensitivity(v1.sensitivity(v0.getSensitivityX()), v1.sensitivity(v0.getSensitivityY()));
            v12.setInvertY(v0.getInvertY());
            v12.setJitterRange(v3.getJitterRadius());
            if(v8_1 == 0) {
                if(v3.getEdgeReleaseOnly()) {
                }
                else {
                    v10 = 3;
                }
            }

            v12.setGesturePolicy(false, v10, v3.getIdleReleaseMillis(), v3.getDownDelayMillis(), v3.getUpDelayMillis(), v3.getGlobalDownDelayMillis());
            if(v8_1 == 0) {
                v0_2 = HorizontalCorrection.NONE;
            }
            else {
                if(!Intrinsics.areEqual(v3.getObservedV6(), Boolean.valueOf(true)) && (!v7 || !v3.getGoldenPrecisionPlus())) {
                    v0_2 = HorizontalCorrection.POSITION_RATIONAL;
                    goto label_183;
                }

                v0_2 = HorizontalCorrection.POSITION_CURVE;
            }

        label_183:
            v12.setCorrection(v0_2);
            v1.kernel = v12;
            CameraDiagnostics v0_3 = CameraDiagnostics.INSTANCE;
            Boolean v5_2 = v3.getObservedV6();
            if(v5_2 == null) {
                v5_3 = "unavailable (null context)";
            }

            v0_3.event(v4 + v2_2 + " V6=" + v5_3 + " precisionPlus=" + v3.getGoldenPrecisionPlus() + " origin=" + v1.centerX + "," + v1.centerY);
        }
        catch(Throwable v0_1) {
            try {
            label_212:
                __monitor_exit(this);
            }
            catch(Throwable v0_1) {
                goto label_212;
            }

            throw v0_1;
        }

        __monitor_exit(this);
    }

    public static void configure$default(FpsCameraEngine arg7, FpsCameraSettings arg8, int arg9, int arg10, CameraTouchAnchor arg11, float arg12, GgCameraContext arg13, int arg14, Object arg15) {
        if((arg14 & 8) != 0) {
            arg11 = arg7.touchAnchor;
        }

        CameraTouchAnchor v4 = arg11;
        if((arg14 & 16) != 0) {
            arg12 = arg7.dpi;
        }

        float v5 = arg12;
        if((arg14 & 0x20) != 0) {
            arg13 = arg7.context;
        }

        arg7.configure(arg8, arg9, arg10, v4, v5, arg13);
    }

    static final void configure$lambda$1(int arg2) {
        Thread.sleep(((long)arg2));
    }

    public final FpsCameraKernel dispatchKernel$app() {
        FpsCameraKernel v10;
        FpsCameraEngine v1;
        GgCameraContext v7;
        CameraTouchAnchor v5;
        Object v9;
        int v8;
        int v4;
        int v3;
        FpsCameraSettings v2;
        __monitor_enter(this);
        try {
            if(this.kernel != null) {
                goto label_16;
            }
            else if(this.hasValidAnchor) {
                v2 = this.settings;
                v3 = this.width;
                v4 = this.height;
                v8 = 56;
                v9 = null;
                v5 = null;
                v7 = null;
                v1 = this;
            }
            else {
                goto label_16;
            }
        }
        catch(Throwable v0) {
            goto label_28;
        }

        try {
            FpsCameraEngine.configure$default(v1, v2, v3, v4, v5, 0f, v7, v8, v9);
            goto label_17;
        label_16:
            v1 = this;
        label_17:
            v10 = v1.kernel;
            if(!v1.settings.getEnabled()) {
                goto label_24;
            }
            else if(v1.hasValidAnchor) {
            }
            else {
                goto label_24;
            }
        }
        catch(Throwable v0) {
            goto label_29;
        }

        goto label_25;
    label_24:
        v10 = null;
    label_25:
        __monitor_exit(v1);
        return v10;
    label_28:
        v1 = this;
    label_29:
        Throwable v10_1 = v0;
        try {
            __monitor_exit(v1);
        }
        catch(Throwable v0) {
            goto label_29;
        }

        throw v10_1;
    }

    public final float getCenterX() {
        return this.centerX;
    }

    public final float getCenterY() {
        return this.centerY;
    }

    public final boolean getHasValidAnchor() {
        return this.hasValidAnchor;
    }

    public final float getX() {
        return this.x;
    }

    public final float getY() {
        return this.y;
    }

    public final int recoilVerticalDelta$app(int arg2) {
        __monitor_enter(this);
        try {
            if(!this.settings.getInvertY()) {
                goto label_5;
            }
        }
        catch(Throwable v2) {
            try {
            label_8:
                __monitor_exit(this);
            }
            catch(Throwable v2) {
                goto label_8;
            }

            throw v2;
        }

        arg2 = -arg2;
    label_5:
        __monitor_exit(this);
        return arg2;
    }

    public final Pair resetToCenter(String arg4) {
        Intrinsics.checkNotNullParameter(arg4, "reason");
        CameraDiagnostics.INSTANCE.event("GG reset reason=" + arg4 + " (contact release is serialized by dispatcher)");
        return this.centerPosition();
    }

    public static Pair resetToCenter$default(FpsCameraEngine arg0, String arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = "explicit-reset";
        }

        return arg0.resetToCenter(arg1);
    }

    private final int sensitivity(float arg3) {
        return MathKt.roundToInt(RangesKt.coerceAtMost((((double)GameProfileKt.normalizeViewSensitivity(arg3))) * (((double)this.multiplier)) * 500, 2147483647));
    }

    public final void setSensitivityMultiplier$app(float arg3) {
        __monitor_enter(this);
        try {
            if(Math.abs(arg3) <= 3.402823E+38f && arg3 > 0f) {
                this.multiplier = arg3;
                this.effectiveSensitivity = TuplesKt.to(Integer.valueOf(this.sensitivity(this.settings.getSensitivityX())), Integer.valueOf(this.sensitivity(this.settings.getSensitivityY())));
                goto label_17;
            }

            goto label_19;
        }
        catch(Throwable v3) {
            goto label_25;
        }

    label_17:
        __monitor_exit(this);
        return;
        try {
        label_19:
            throw new IllegalArgumentException("Failed requirement.".toString());
        label_25:
            __monitor_exit(this);
        }
        catch(Throwable v3) {
            goto label_25;
        }

        throw v3;
    }

    public final void updateViewport(int arg11, int arg12) {
        int v4;
        int v3;
        FpsCameraEngine v1;
        GgCameraContext v7;
        CameraTouchAnchor v5;
        Object v9;
        int v8;
        FpsCameraSettings v2;
        __monitor_enter(this);
        try {
            if(this.viewportChanged$app(arg11, arg12)) {
                v2 = this.settings;
                v8 = 56;
                v9 = null;
                v5 = null;
                v7 = null;
                v1 = this;
                v3 = arg11;
                v4 = arg12;
            }
            else {
                goto label_14;
            }
        }
        catch(Throwable v0) {
            goto label_18;
        }

        try {
            FpsCameraEngine.configure$default(v1, v2, v3, v4, v5, 0f, v7, v8, v9);
            goto label_15;
        }
        catch(Throwable v0) {
            goto label_19;
        }

    label_14:
        v1 = this;
    label_15:
        __monitor_exit(v1);
        return;
    label_18:
        v1 = this;
    label_19:
        Throwable v10 = v0;
        try {
            __monitor_exit(v1);
        }
        catch(Throwable v0) {
            goto label_19;
        }

        throw v10;
    }

    public final boolean viewportChanged$app(int arg2, int arg3) {
        boolean v2_1;
        __monitor_enter(this);
        if(arg2 <= 0 || arg3 <= 0) {
        label_12:
            v2_1 = false;
        }
        else {
            try {
                if(arg2 == this.width && arg3 == this.height) {
                    goto label_12;
                }

                v2_1 = true;
                goto label_13;
            label_10:
                __monitor_exit(this);
            }
            catch(Throwable v2) {
                goto label_10;
            }

            throw v2;
        }

    label_13:
        __monitor_exit(this);
        return v2_1;
    }
}

