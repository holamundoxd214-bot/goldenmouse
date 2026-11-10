package com.TryJeanPc.goldenmouse.profile;

import com.TryJeanPc.goldenmouse.mapper.InputBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u001E\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BÇ\u0001\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0003\u0012\b\b\u0002\u0010\b\u001A\u00020\u0003\u0012\b\b\u0002\u0010\t\u001A\u00020\u0005\u0012\b\b\u0002\u0010\n\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u000B\u001A\u00020\u0005\u0012\b\b\u0002\u0010\f\u001A\u00020\u0005\u0012\b\b\u0002\u0010\r\u001A\u00020\u000E\u0012\b\b\u0002\u0010\u000F\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001A\u00020\u000E\u0012\b\b\u0002\u0010\u0011\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001A\u00020\u000E\u0012\b\b\u0002\u0010\u0013\u001A\u00020\u000E\u0012\b\b\u0002\u0010\u0014\u001A\u00020\u0003\u0012\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0017\u001A\u00020\u0018\u0012\b\b\u0002\u0010\u0019\u001A\u00020\u0003¢\u0006\u0004\b\u001A\u0010\u001BJ\u0006\u00106\u001A\u000207J\t\u00108\u001A\u00020\u0003HÆ\u0003J\t\u00109\u001A\u00020\u0005HÆ\u0003J\t\u0010:\u001A\u00020\u0005HÆ\u0003J\t\u0010;\u001A\u00020\u0003HÆ\u0003J\t\u0010<\u001A\u00020\u0003HÆ\u0003J\t\u0010=\u001A\u00020\u0005HÆ\u0003J\t\u0010>\u001A\u00020\u0005HÆ\u0003J\t\u0010?\u001A\u00020\u0005HÆ\u0003J\t\u0010@\u001A\u00020\u0005HÆ\u0003J\t\u0010A\u001A\u00020\u000EHÆ\u0003J\t\u0010B\u001A\u00020\u0003HÆ\u0003J\t\u0010C\u001A\u00020\u000EHÆ\u0003J\t\u0010D\u001A\u00020\u0005HÆ\u0003J\t\u0010E\u001A\u00020\u000EHÆ\u0003J\t\u0010F\u001A\u00020\u000EHÆ\u0003J\t\u0010G\u001A\u00020\u0003HÆ\u0003J\u000B\u0010H\u001A\u0004\u0018\u00010\u0016HÆ\u0003J\t\u0010I\u001A\u00020\u0018HÆ\u0003J\t\u0010J\u001A\u00020\u0003HÆ\u0003JÉ\u0001\u0010K\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\u00032\b\b\u0002\u0010\b\u001A\u00020\u00032\b\b\u0002\u0010\t\u001A\u00020\u00052\b\b\u0002\u0010\n\u001A\u00020\u00052\b\b\u0002\u0010\u000B\u001A\u00020\u00052\b\b\u0002\u0010\f\u001A\u00020\u00052\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\u00032\b\b\u0002\u0010\u0010\u001A\u00020\u000E2\b\b\u0002\u0010\u0011\u001A\u00020\u00052\b\b\u0002\u0010\u0012\u001A\u00020\u000E2\b\b\u0002\u0010\u0013\u001A\u00020\u000E2\b\b\u0002\u0010\u0014\u001A\u00020\u00032\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001A\u00020\u00182\b\b\u0002\u0010\u0019\u001A\u00020\u0003HÆ\u0001J\u0013\u0010L\u001A\u00020\u00032\b\u0010M\u001A\u0004\u0018\u00010NHÖ\u0003J\t\u0010O\u001A\u00020PHÖ\u0001J\t\u0010Q\u001A\u00020\u000EHÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u001DR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u001E\u0010\u001FR\u0011\u0010\u0006\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b \u0010\u001FR\u0011\u0010\u0007\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b!\u0010\u001DR\u0011\u0010\b\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\"\u0010\u001DR\u0011\u0010\t\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b#\u0010\u001FR\u0011\u0010\n\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b$\u0010\u001FR\u0011\u0010\u000B\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b%\u0010\u001FR\u0011\u0010\f\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b&\u0010\u001FR\u0011\u0010\r\u001A\u00020\u000E¢\u0006\b\n\u0000\u001A\u0004\b\'\u0010(R\u0011\u0010\u000F\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b)\u0010\u001DR\u0011\u0010\u0010\u001A\u00020\u000E¢\u0006\b\n\u0000\u001A\u0004\b*\u0010(R\u0011\u0010\u0011\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b+\u0010\u001FR\u0011\u0010\u0012\u001A\u00020\u000E¢\u0006\b\n\u0000\u001A\u0004\b,\u0010(R\u0011\u0010\u0013\u001A\u00020\u000E¢\u0006\b\n\u0000\u001A\u0004\b-\u0010(R\u0011\u0010\u0014\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b.\u0010\u001DR\u0013\u0010\u0015\u001A\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001A\u0004\b/\u00100R\u0011\u0010\u0017\u001A\u00020\u0018¢\u0006\b\n\u0000\u001A\u0004\b1\u00102R\u0011\u0010\u0019\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b3\u0010\u001DR\u0014\u00104\u001A\u00020\u000EX\u0096D¢\u0006\b\n\u0000\u001A\u0004\b5\u0010(¨\u0006R"}, d2={"Lcom/TryJeanPc/goldenmouse/profile/ViewComponent;", "Lcom/TryJeanPc/goldenmouse/profile/ControlComponent;", "enabled", "", "sensitivityX", "", "sensitivityY", "invertY", "mouseAcceleration", "acceleration", "speed", "smoothing", "maxDelta", "tweaks", "", "sniperEnabled", "sniperKey", "sniperMultiplier", "toggleCursorKey", "suspendCursorKey", "linkedSensitivities", "quickChangeBinding", "Lcom/TryJeanPc/goldenmouse/mapper/InputBinding;", "quickChangeDelayMs", "", "goldenPrecisionPlus", "<init>", "(ZFFZZFFFFLjava/lang/String;ZLjava/lang/String;FLjava/lang/String;Ljava/lang/String;ZLcom/TryJeanPc/goldenmouse/mapper/InputBinding;JZ)V", "getEnabled", "()Z", "getSensitivityX", "()F", "getSensitivityY", "getInvertY", "getMouseAcceleration", "getAcceleration", "getSpeed", "getSmoothing", "getMaxDelta", "getTweaks", "()Ljava/lang/String;", "getSniperEnabled", "getSniperKey", "getSniperMultiplier", "getToggleCursorKey", "getSuspendCursorKey", "getLinkedSensitivities", "getQuickChangeBinding", "()Lcom/TryJeanPc/goldenmouse/mapper/InputBinding;", "getQuickChangeDelayMs", "()J", "getGoldenPrecisionPlus", "type", "getType", "toCameraSettings", "Lcom/TryJeanPc/goldenmouse/profile/FpsCameraSettings;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "copy", "equals", "other", "", "hashCode", "", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class ViewComponent implements ControlComponent {
    public static final int $stable;
    private final float acceleration;
    private final boolean enabled;
    private final boolean goldenPrecisionPlus;
    private final boolean invertY;
    private final boolean linkedSensitivities;
    private final float maxDelta;
    private final boolean mouseAcceleration;
    private final InputBinding quickChangeBinding;
    private final long quickChangeDelayMs;
    private final float sensitivityX;
    private final float sensitivityY;
    private final float smoothing;
    private final boolean sniperEnabled;
    private final String sniperKey;
    private final float sniperMultiplier;
    private final float speed;
    private final String suspendCursorKey;
    private final String toggleCursorKey;
    private final String tweaks;
    private final String type;

    static {
    }

    public ViewComponent(boolean arg22, float arg23, float arg24, boolean arg25, boolean arg26, float arg27, float arg28, float arg29, float arg30, String arg31, boolean arg32, String arg33, float arg34, String arg35, String arg36, boolean arg37, InputBinding arg38, long arg39, boolean arg41, int arg42, DefaultConstructorMarker arg43) {
        float v7;
        int v0 = arg42;
        boolean v1 = (v0 & 1) != 0 ? true : arg22;
        float v3 = 2f;
        float v2 = (v0 & 2) != 0 ? v3 : arg23;
        if((v0 & 4) != 0) {
        }
        else {
            v3 = arg24;
        }

        boolean v4 = (v0 & 8) != 0 ? false : arg25;
        boolean v6 = (v0 & 16) != 0 ? false : arg26;
        float v8 = 0f;
        float v9 = 1f;
        if((v0 & 0x20) == 0) {
            v7 = arg27;
        }
        else if(v6) {
            v7 = v9;
        }
        else {
            v7 = 0f;
        }

        if((v0 & 0x40) != 0) {
        }
        else {
            v9 = arg28;
        }

        if((v0 & 0x80) != 0) {
        }
        else {
            v8 = arg29;
        }

        float v10 = (v0 & 0x100) != 0 ? 96f : arg30;
        String v11 = (v0 & 0x200) != 0 ? "16450" : arg31;
        boolean v12 = (v0 & 0x400) != 0 ? false : arg32;
        String v13 = (v0 & 0x800) != 0 ? "MOUSE_RIGHT" : arg33;
        float v14 = (v0 & 0x1000) != 0 ? 0.5f : arg34;
        String v15 = (v0 & 0x2000) != 0 ? "F1" : arg35;
        String v5 = (v0 & 0x4000) != 0 ? "ALT" : arg36;
        boolean v16 = (v0 & 0x8000) != 0 ? false : arg37;
        InputBinding v17 = (v0 & 0x10000) != 0 ? null : arg38;
        long v18 = (v0 & 0x20000) != 0 ? 0 : arg39;
        boolean v42 = (v0 & 0x40000) != 0 ? false : arg41;
        this(v1, v2, v3, v4, v6, v7, v9, v8, v10, v11, v12, v13, v14, v15, v5, v16, v17, v18, v42);
    }

    public ViewComponent(boolean arg5, float arg6, float arg7, boolean arg8, boolean arg9, float arg10, float arg11, float arg12, float arg13, String arg14, boolean arg15, String arg16, float arg17, String arg18, String arg19, boolean arg20, InputBinding arg21, long arg22, boolean arg24) {
        Intrinsics.checkNotNullParameter(arg14, "tweaks");
        Intrinsics.checkNotNullParameter(arg16, "sniperKey");
        Intrinsics.checkNotNullParameter(arg18, "toggleCursorKey");
        Intrinsics.checkNotNullParameter(arg19, "suspendCursorKey");
        super();
        this.enabled = arg5;
        this.sensitivityX = arg6;
        this.sensitivityY = arg7;
        this.invertY = arg8;
        this.mouseAcceleration = arg9;
        this.acceleration = arg10;
        this.speed = arg11;
        this.smoothing = arg12;
        this.maxDelta = arg13;
        this.tweaks = arg14;
        this.sniperEnabled = arg15;
        this.sniperKey = arg16;
        this.sniperMultiplier = arg17;
        this.toggleCursorKey = arg18;
        this.suspendCursorKey = arg19;
        this.linkedSensitivities = arg20;
        this.quickChangeBinding = arg21;
        this.quickChangeDelayMs = arg22;
        this.goldenPrecisionPlus = arg24;
        this.type = "CAMARA";
    }

    public ViewComponent() {
        this(false, 0f, 0f, false, false, 0f, 0f, 0f, 0f, null, false, null, 0f, null, null, false, null, 0, false, 0x7FFFF, null);
    }

    public final boolean component1() {
        return this.enabled;
    }

    public final String component10() {
        return this.tweaks;
    }

    public final boolean component11() {
        return this.sniperEnabled;
    }

    public final String component12() {
        return this.sniperKey;
    }

    public final float component13() {
        return this.sniperMultiplier;
    }

    public final String component14() {
        return this.toggleCursorKey;
    }

    public final String component15() {
        return this.suspendCursorKey;
    }

    public final boolean component16() {
        return this.linkedSensitivities;
    }

    public final InputBinding component17() {
        return this.quickChangeBinding;
    }

    public final long component18() {
        return this.quickChangeDelayMs;
    }

    public final boolean component19() {
        return this.goldenPrecisionPlus;
    }

    public final float component2() {
        return this.sensitivityX;
    }

    public final float component3() {
        return this.sensitivityY;
    }

    public final boolean component4() {
        return this.invertY;
    }

    public final boolean component5() {
        return this.mouseAcceleration;
    }

    public final float component6() {
        return this.acceleration;
    }

    public final float component7() {
        return this.speed;
    }

    public final float component8() {
        return this.smoothing;
    }

    public final float component9() {
        return this.maxDelta;
    }

    public final ViewComponent copy(boolean arg23, float arg24, float arg25, boolean arg26, boolean arg27, float arg28, float arg29, float arg30, float arg31, String arg32, boolean arg33, String arg34, float arg35, String arg36, String arg37, boolean arg38, InputBinding arg39, long arg40, boolean arg42) {
        Intrinsics.checkNotNullParameter(arg32, "tweaks");
        Intrinsics.checkNotNullParameter(arg34, "sniperKey");
        Intrinsics.checkNotNullParameter(arg36, "toggleCursorKey");
        Intrinsics.checkNotNullParameter(arg37, "suspendCursorKey");
        return new ViewComponent(arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg35, arg36, arg37, arg38, arg39, arg40, arg42);
    }

    public static ViewComponent copy$default(ViewComponent arg17, boolean arg18, float arg19, float arg20, boolean arg21, boolean arg22, float arg23, float arg24, float arg25, float arg26, String arg27, boolean arg28, String arg29, float arg30, String arg31, String arg32, boolean arg33, InputBinding arg34, long arg35, boolean arg37, int arg38, Object arg39) {
        boolean v38;
        long v36;
        ViewComponent v0 = arg17;
        int v1 = arg38;
        boolean v2 = (v1 & 1) != 0 ? v0.enabled : arg18;
        float v3 = (v1 & 2) != 0 ? v0.sensitivityX : arg19;
        float v4 = (v1 & 4) != 0 ? v0.sensitivityY : arg20;
        boolean v5 = (v1 & 8) != 0 ? v0.invertY : arg21;
        boolean v6 = (v1 & 16) != 0 ? v0.mouseAcceleration : arg22;
        float v7 = (v1 & 0x20) != 0 ? v0.acceleration : arg23;
        float v8 = (v1 & 0x40) != 0 ? v0.speed : arg24;
        float v9 = (v1 & 0x80) != 0 ? v0.smoothing : arg25;
        float v10 = (v1 & 0x100) != 0 ? v0.maxDelta : arg26;
        String v11 = (v1 & 0x200) != 0 ? v0.tweaks : arg27;
        boolean v12 = (v1 & 0x400) != 0 ? v0.sniperEnabled : arg28;
        String v13 = (v1 & 0x800) != 0 ? v0.sniperKey : arg29;
        float v14 = (v1 & 0x1000) != 0 ? v0.sniperMultiplier : arg30;
        String v15 = (v1 & 0x2000) != 0 ? v0.toggleCursorKey : arg31;
        arg18 = v2;
        String v2_1 = (v1 & 0x4000) != 0 ? v0.suspendCursorKey : arg32;
        boolean v1_1 = (v1 & 0x8000) != 0 ? v0.linkedSensitivities : arg33;
        boolean v19 = v1_1;
        InputBinding v1_2 = (arg38 & 0x10000) != 0 ? v0.quickChangeBinding : arg34;
        InputBinding v21 = v1_2;
        String v20 = v2_1;
        long v1_3 = (arg38 & 0x20000) != 0 ? v0.quickChangeDelayMs : arg35;
        if((arg38 & 0x40000) != 0) {
            v36 = v1_3;
            v38 = v0.goldenPrecisionPlus;
        }
        else {
            v38 = arg37;
            v36 = v1_3;
        }

        return v0.copy(arg18, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v20, v19, v21, v36, v38);
    }

    public boolean equals(Object arg8) {
        if(this == (((ViewComponent)arg8))) {
            return 1;
        }

        if(!(arg8 instanceof ViewComponent)) {
            return 0;
        }

        if(this.enabled != ((ViewComponent)arg8).enabled) {
            return 0;
        }

        if(Float.compare(this.sensitivityX, ((ViewComponent)arg8).sensitivityX) != 0) {
            return 0;
        }

        if(Float.compare(this.sensitivityY, ((ViewComponent)arg8).sensitivityY) != 0) {
            return 0;
        }

        if(this.invertY != ((ViewComponent)arg8).invertY) {
            return 0;
        }

        if(this.mouseAcceleration != ((ViewComponent)arg8).mouseAcceleration) {
            return 0;
        }

        if(Float.compare(this.acceleration, ((ViewComponent)arg8).acceleration) != 0) {
            return 0;
        }

        if(Float.compare(this.speed, ((ViewComponent)arg8).speed) != 0) {
            return 0;
        }

        if(Float.compare(this.smoothing, ((ViewComponent)arg8).smoothing) != 0) {
            return 0;
        }

        if(Float.compare(this.maxDelta, ((ViewComponent)arg8).maxDelta) != 0) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.tweaks, ((ViewComponent)arg8).tweaks)) {
            return 0;
        }

        if(this.sniperEnabled != ((ViewComponent)arg8).sniperEnabled) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.sniperKey, ((ViewComponent)arg8).sniperKey)) {
            return 0;
        }

        if(Float.compare(this.sniperMultiplier, ((ViewComponent)arg8).sniperMultiplier) != 0) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.toggleCursorKey, ((ViewComponent)arg8).toggleCursorKey)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.suspendCursorKey, ((ViewComponent)arg8).suspendCursorKey)) {
            return 0;
        }

        if(this.linkedSensitivities != ((ViewComponent)arg8).linkedSensitivities) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.quickChangeBinding, ((ViewComponent)arg8).quickChangeBinding)) {
            return 0;
        }

        if(this.quickChangeDelayMs != ((ViewComponent)arg8).quickChangeDelayMs) {
            return 0;
        }

        if(this.goldenPrecisionPlus != ((ViewComponent)arg8).goldenPrecisionPlus) {
            return 0;
        }

        return 1;
    }

    public final float getAcceleration() {
        return this.acceleration;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final boolean getGoldenPrecisionPlus() {
        return this.goldenPrecisionPlus;
    }

    public final boolean getInvertY() {
        return this.invertY;
    }

    public final boolean getLinkedSensitivities() {
        return this.linkedSensitivities;
    }

    public final float getMaxDelta() {
        return this.maxDelta;
    }

    public final boolean getMouseAcceleration() {
        return this.mouseAcceleration;
    }

    public final InputBinding getQuickChangeBinding() {
        return this.quickChangeBinding;
    }

    public final long getQuickChangeDelayMs() {
        return this.quickChangeDelayMs;
    }

    public final float getSensitivityX() {
        return this.sensitivityX;
    }

    public final float getSensitivityY() {
        return this.sensitivityY;
    }

    public final float getSmoothing() {
        return this.smoothing;
    }

    public final boolean getSniperEnabled() {
        return this.sniperEnabled;
    }

    public final String getSniperKey() {
        return this.sniperKey;
    }

    public final float getSniperMultiplier() {
        return this.sniperMultiplier;
    }

    public final float getSpeed() {
        return this.speed;
    }

    public final String getSuspendCursorKey() {
        return this.suspendCursorKey;
    }

    public final String getToggleCursorKey() {
        return this.toggleCursorKey;
    }

    public final String getTweaks() {
        return this.tweaks;
    }

    public String getType() {
        return this.type;
    }

    public int hashCode() {
        int v0 = (((((((((((((((Boolean.hashCode(this.enabled) * 0x1F + Float.hashCode(this.sensitivityX)) * 0x1F + Float.hashCode(this.sensitivityY)) * 0x1F + Boolean.hashCode(this.invertY)) * 0x1F + Boolean.hashCode(this.mouseAcceleration)) * 0x1F + Float.hashCode(this.acceleration)) * 0x1F + Float.hashCode(this.speed)) * 0x1F + Float.hashCode(this.smoothing)) * 0x1F + Float.hashCode(this.maxDelta)) * 0x1F + this.tweaks.hashCode()) * 0x1F + Boolean.hashCode(this.sniperEnabled)) * 0x1F + this.sniperKey.hashCode()) * 0x1F + Float.hashCode(this.sniperMultiplier)) * 0x1F + this.toggleCursorKey.hashCode()) * 0x1F + this.suspendCursorKey.hashCode()) * 0x1F + Boolean.hashCode(this.linkedSensitivities)) * 0x1F;
        InputBinding v1 = this.quickChangeBinding;
        int v1_1 = v1 == null ? 0 : v1.hashCode();
        return ((v0 + v1_1) * 0x1F + Long.hashCode(this.quickChangeDelayMs)) * 0x1F + Boolean.hashCode(this.goldenPrecisionPlus);
    }

    public final FpsCameraSettings toCameraSettings() {
        boolean v1 = this.enabled;
        float v2 = GameProfileKt.normalizeViewSensitivity(this.sensitivityX);
        float v3 = GameProfileKt.normalizeViewSensitivity(this.sensitivityY);
        float v4 = this.speed;
        float v5 = this.smoothing;
        float v6 = this.maxDelta;
        boolean v7 = this.invertY;
        float v8 = this.mouseAcceleration ? 1f : 0f;
        return new FpsCameraSettings(v1, v2, v3, v4, v5, v6, v7, v8, this.goldenPrecisionPlus);
    }

    public String toString() {
        return "ViewComponent(enabled=" + this.enabled + ", sensitivityX=" + this.sensitivityX + ", sensitivityY=" + this.sensitivityY + ", invertY=" + this.invertY + ", mouseAcceleration=" + this.mouseAcceleration + ", acceleration=" + this.acceleration + ", speed=" + this.speed + ", smoothing=" + this.smoothing + ", maxDelta=" + this.maxDelta + ", tweaks=" + this.tweaks + ", sniperEnabled=" + this.sniperEnabled + ", sniperKey=" + this.sniperKey + ", sniperMultiplier=" + this.sniperMultiplier + ", toggleCursorKey=" + this.toggleCursorKey + ", suspendCursorKey=" + this.suspendCursorKey + ", linkedSensitivities=" + this.linkedSensitivities + ", quickChangeBinding=" + this.quickChangeBinding + ", quickChangeDelayMs=" + this.quickChangeDelayMs + ", goldenPrecisionPlus=" + this.goldenPrecisionPlus + ")";
    }
}

