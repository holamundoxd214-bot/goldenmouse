package com.TryJeanPc.goldenmouse.controls;

import com.TryJeanPc.goldenmouse.profile.ControlComponent;
import com.TryJeanPc.goldenmouse.profile.GameProfile;
import com.TryJeanPc.goldenmouse.profile.JoystickComponent;
import com.TryJeanPc.goldenmouse.profile.ProfileControl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u0095\u0001\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\r\u0012\u0014\b\u0002\u0010\u000F\u001A\u000E\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u000E\u0010)\u001A\u00020*2\u0006\u0010+\u001A\u00020*J=\u0010,\u001A\b\u0012\u0004\u0012\u00020.0-2\u0006\u0010/\u001A\u00020.2\u0006\u00100\u001A\u00020\u00112\u0018\u00101\u001A\u0014\u0012\u0004\u0012\u00020.\u0012\n\u0012\b\u0012\u0004\u0012\u0002030-02¢\u0006\u0004\b4\u00105J\u0010\u00106\u001A\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u00107\u001A\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u00108\u001A\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u00109\u001A\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010:\u001A\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001CJ\u0010\u0010;\u001A\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010<\u001A\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001CJ\u0010\u0010=\u001A\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010>\u001A\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010?\u001A\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\"J\u0015\u0010@\u001A\u000E\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010HÆ\u0003J\u009C\u0001\u0010A\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\r2\u0014\b\u0002\u0010\u000F\u001A\u000E\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010HÆ\u0001¢\u0006\u0002\u0010BJ\u0013\u0010C\u001A\u00020\r2\b\u0010D\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010E\u001A\u00020FHÖ\u0001J\t\u0010G\u001A\u00020\u0011HÖ\u0001R\u0015\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001A\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0004\u001A\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001A\u0004\b\u0018\u0010\u0016R\u0015\u0010\u0005\u001A\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001A\u0004\b\u0019\u0010\u0016R\u0015\u0010\u0006\u001A\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001A\u0004\b\u001A\u0010\u0016R\u0015\u0010\u0007\u001A\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001D\u001A\u0004\b\u001B\u0010\u001CR\u0015\u0010\t\u001A\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001A\u0004\b\u001E\u0010\u0016R\u0015\u0010\n\u001A\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001D\u001A\u0004\b\u001F\u0010\u001CR\u0015\u0010\u000B\u001A\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001A\u0004\b \u0010\u0016R\u0015\u0010\f\u001A\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010#\u001A\u0004\b!\u0010\"R\u0015\u0010\u000E\u001A\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010#\u001A\u0004\b$\u0010\"R\u001D\u0010\u000F\u001A\u000E\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010¢\u0006\b\n\u0000\u001A\u0004\b%\u0010&R\u0011\u0010\'\u001A\u00020\r8F¢\u0006\u0006\u001A\u0004\b\'\u0010(¨\u0006H"}, d2={"Lcom/TryJeanPc/goldenmouse/controls/JoystickSettingsEdit;", "", "x", "", "y", "radius", "movementSpeed", "activationTimeMs", "", "diagonalAngleDeg", "smoothingMs", "radius1", "sprintEnabled", "", "socdEnabled", "bindings", "", "", "Lcom/TryJeanPc/goldenmouse/mapper/InputBinding;", "<init>", "(Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Long;Ljava/lang/Float;Ljava/lang/Long;Ljava/lang/Float;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/Map;)V", "getX", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getY", "getRadius", "getMovementSpeed", "getActivationTimeMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDiagonalAngleDeg", "getSmoothingMs", "getRadius1", "getSprintEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSocdEnabled", "getBindings", "()Ljava/util/Map;", "isEmpty", "()Z", "applyTo", "Lcom/TryJeanPc/goldenmouse/profile/ProfileControl;", "control", "save", "Lkotlin/Result;", "Lcom/TryJeanPc/goldenmouse/profile/GameProfile;", "profile", "controlId", "write", "Lkotlin/Function1;", "", "save-0E7RQCE", "(Lcom/TryJeanPc/goldenmouse/profile/GameProfile;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Long;Ljava/lang/Float;Ljava/lang/Long;Ljava/lang/Float;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/Map;)Lcom/TryJeanPc/goldenmouse/controls/JoystickSettingsEdit;", "equals", "other", "hashCode", "", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class JoystickSettingsEdit {
    public static final int $stable = 8;
    private final Long activationTimeMs;
    private final Map bindings;
    private final Float diagonalAngleDeg;
    private final Float movementSpeed;
    private final Float radius;
    private final Float radius1;
    private final Long smoothingMs;
    private final Boolean socdEnabled;
    private final Boolean sprintEnabled;
    private final Float x;
    private final Float y;

    static {
    }

    public JoystickSettingsEdit(Float arg2, Float arg3, Float arg4, Float arg5, Long arg6, Float arg7, Long arg8, Float arg9, Boolean arg10, Boolean arg11, Map arg12) {
        Intrinsics.checkNotNullParameter(arg12, "bindings");
        super();
        this.x = arg2;
        this.y = arg3;
        this.radius = arg4;
        this.movementSpeed = arg5;
        this.activationTimeMs = arg6;
        this.diagonalAngleDeg = arg7;
        this.smoothingMs = arg8;
        this.radius1 = arg9;
        this.sprintEnabled = arg10;
        this.socdEnabled = arg11;
        this.bindings = arg12;
    }

    public JoystickSettingsEdit() {
        this(null, null, null, null, null, null, null, null, null, null, null, 0x7FF, null);
    }

    public JoystickSettingsEdit(Float arg2, Float arg3, Float arg4, Float arg5, Long arg6, Float arg7, Long arg8, Float arg9, Boolean arg10, Boolean arg11, Map arg12, int arg13, DefaultConstructorMarker arg14) {
        Float v0 = null;
        if((arg13 & 1) != 0) {
            arg2 = v0;
        }

        if((arg13 & 2) != 0) {
            arg3 = v0;
        }

        if((arg13 & 4) != 0) {
            arg4 = v0;
        }

        if((arg13 & 8) != 0) {
            arg5 = v0;
        }

        if((arg13 & 16) != 0) {
            arg6 = ((Long)v0);
        }

        if((arg13 & 0x20) != 0) {
            arg7 = v0;
        }

        if((arg13 & 0x40) != 0) {
            arg8 = ((Long)v0);
        }

        if((arg13 & 0x80) != 0) {
            arg9 = v0;
        }

        if((arg13 & 0x100) != 0) {
            arg10 = ((Boolean)v0);
        }

        if((arg13 & 0x200) != 0) {
            arg11 = ((Boolean)v0);
        }

        if((arg13 & 0x400) != 0) {
            arg12 = MapsKt.emptyMap();
        }

        this(arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12);
    }

    public final ProfileControl applyTo(ProfileControl arg28) {
        JoystickSettingsEdit v0 = this;
        ProfileControl v2 = arg28;
        Intrinsics.checkNotNullParameter(v2, "control");
        ControlComponent v1 = v2.getComponent();
        if((v1 instanceof JoystickComponent)) {
        }
        else {
            v1 = null;
        }

        ControlComponent v3 = v1;
        if(v3 != null) {
            Float v1_1 = v0.x;
            float v1_2 = v1_1 != null ? v1_1.floatValue() : v2.getX();
            Float v4 = v0.y;
            float v4_1 = v4 != null ? v4.floatValue() : v2.getY();
            float v23 = v4_1;
            v4 = v0.radius;
            float v5 = 3f;
            int v4_2 = v4 != null ? ((int)(((Number)v4).floatValue() * v5)) : v2.getWidth();
            int v24 = v4_2;
            v4 = v0.radius;
            v4_2 = v4 != null ? ((int)(((Number)v4).floatValue() * v5)) : v2.getHeight();
            int v25 = v4_2;
            Map v26 = MapsKt.plus(v2.getBindings(), v0.bindings);
            v4 = v0.radius;
            v4_1 = v4 != null ? v4.floatValue() : ((JoystickComponent)v3).getRadius();
            Float v5_1 = v0.movementSpeed;
            v5 = v5_1 != null ? v5_1.floatValue() : ((JoystickComponent)v3).getMovementSpeed();
            float v9 = v5;
            Long v5_2 = v0.activationTimeMs;
            long v5_3 = v5_2 != null ? v5_2.longValue() : ((JoystickComponent)v3).getActivationTimeMs();
            long v10 = v5_3;
            v5_1 = v0.diagonalAngleDeg;
            v5 = v5_1 != null ? v5_1.floatValue() : ((JoystickComponent)v3).getDiagonalAngleDeg();
            float v14 = v5;
            v5_2 = v0.smoothingMs;
            v5_3 = v5_2 != null ? v5_2.longValue() : ((JoystickComponent)v3).getSmoothingMs();
            long v15 = v5_3;
            v5_1 = v0.radius1;
            v5 = v5_1 != null ? v5_1.floatValue() : ((JoystickComponent)v3).getRadius1();
            float v6 = v5;
            Boolean v5_4 = v0.sprintEnabled;
            boolean v5_5 = v5_4 != null ? v5_4.booleanValue() : ((JoystickComponent)v3).getSprintEnabled();
            boolean v17 = v5_5;
            Boolean v0_1 = v0.socdEnabled;
            boolean v0_2 = v0_1 != null ? v0_1.booleanValue() : ((JoystickComponent)v3).getSocdEnabled();
            return ProfileControl.copy$default(v2, null, null, v1_2, v23, v24, v25, v26, JoystickComponent.copy$default(((JoystickComponent)v3), v4_1, 0f, v6, 0f, 0f, v9, v10, 0f, false, v14, v15, v17, null, 0f, v0_2, 0x319A, null), 3, null);
        }

        throw new IllegalStateException("El control ya no es JOYSTICK".toString());
    }

    public final Float component1() {
        return this.x;
    }

    public final Boolean component10() {
        return this.socdEnabled;
    }

    public final Map component11() {
        return this.bindings;
    }

    public final Float component2() {
        return this.y;
    }

    public final Float component3() {
        return this.radius;
    }

    public final Float component4() {
        return this.movementSpeed;
    }

    public final Long component5() {
        return this.activationTimeMs;
    }

    public final Float component6() {
        return this.diagonalAngleDeg;
    }

    public final Long component7() {
        return this.smoothingMs;
    }

    public final Float component8() {
        return this.radius1;
    }

    public final Boolean component9() {
        return this.sprintEnabled;
    }

    public final JoystickSettingsEdit copy(Float arg13, Float arg14, Float arg15, Float arg16, Long arg17, Float arg18, Long arg19, Float arg20, Boolean arg21, Boolean arg22, Map arg23) {
        Intrinsics.checkNotNullParameter(arg23, "bindings");
        return new JoystickSettingsEdit(arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23);
    }

    public static JoystickSettingsEdit copy$default(JoystickSettingsEdit arg0, Float arg1, Float arg2, Float arg3, Float arg4, Long arg5, Float arg6, Long arg7, Float arg8, Boolean arg9, Boolean arg10, Map arg11, int arg12, Object arg13) {
        if((arg12 & 1) != 0) {
            arg1 = arg0.x;
        }

        if((arg12 & 2) != 0) {
            arg2 = arg0.y;
        }

        if((arg12 & 4) != 0) {
            arg3 = arg0.radius;
        }

        if((arg12 & 8) != 0) {
            arg4 = arg0.movementSpeed;
        }

        if((arg12 & 16) != 0) {
            arg5 = arg0.activationTimeMs;
        }

        if((arg12 & 0x20) != 0) {
            arg6 = arg0.diagonalAngleDeg;
        }

        if((arg12 & 0x40) != 0) {
            arg7 = arg0.smoothingMs;
        }

        if((arg12 & 0x80) != 0) {
            arg8 = arg0.radius1;
        }

        if((arg12 & 0x100) != 0) {
            arg9 = arg0.sprintEnabled;
        }

        if((arg12 & 0x200) != 0) {
            arg10 = arg0.socdEnabled;
        }

        if((arg12 & 0x400) != 0) {
            arg11 = arg0.bindings;
        }

        return arg0.copy(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11);
    }

    public boolean equals(Object arg5) {
        if(this == (((JoystickSettingsEdit)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof JoystickSettingsEdit)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.x, ((JoystickSettingsEdit)arg5).x)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.y, ((JoystickSettingsEdit)arg5).y)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.radius, ((JoystickSettingsEdit)arg5).radius)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.movementSpeed, ((JoystickSettingsEdit)arg5).movementSpeed)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.activationTimeMs, ((JoystickSettingsEdit)arg5).activationTimeMs)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.diagonalAngleDeg, ((JoystickSettingsEdit)arg5).diagonalAngleDeg)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.smoothingMs, ((JoystickSettingsEdit)arg5).smoothingMs)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.radius1, ((JoystickSettingsEdit)arg5).radius1)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.sprintEnabled, ((JoystickSettingsEdit)arg5).sprintEnabled)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.socdEnabled, ((JoystickSettingsEdit)arg5).socdEnabled)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.bindings, ((JoystickSettingsEdit)arg5).bindings)) {
            return 0;
        }

        return 1;
    }

    public final Long getActivationTimeMs() {
        return this.activationTimeMs;
    }

    public final Map getBindings() {
        return this.bindings;
    }

    public final Float getDiagonalAngleDeg() {
        return this.diagonalAngleDeg;
    }

    public final Float getMovementSpeed() {
        return this.movementSpeed;
    }

    public final Float getRadius() {
        return this.radius;
    }

    public final Float getRadius1() {
        return this.radius1;
    }

    public final Long getSmoothingMs() {
        return this.smoothingMs;
    }

    public final Boolean getSocdEnabled() {
        return this.socdEnabled;
    }

    public final Boolean getSprintEnabled() {
        return this.sprintEnabled;
    }

    public final Float getX() {
        return this.x;
    }

    public final Float getY() {
        return this.y;
    }

    public int hashCode() {
        Float v0 = this.x;
        int v1 = 0;
        int v0_1 = v0 == null ? 0 : v0.hashCode();
        v0_1 *= 0x1F;
        Float v2 = this.y;
        int v2_1 = v2 == null ? 0 : v2.hashCode();
        v0_1 = (v0_1 + v2_1) * 0x1F;
        v2 = this.radius;
        v2_1 = v2 == null ? 0 : v2.hashCode();
        v0_1 = (v0_1 + v2_1) * 0x1F;
        v2 = this.movementSpeed;
        v2_1 = v2 == null ? 0 : v2.hashCode();
        v0_1 = (v0_1 + v2_1) * 0x1F;
        Long v2_2 = this.activationTimeMs;
        v2_1 = v2_2 == null ? 0 : v2_2.hashCode();
        v0_1 = (v0_1 + v2_1) * 0x1F;
        v2 = this.diagonalAngleDeg;
        v2_1 = v2 == null ? 0 : v2.hashCode();
        v0_1 = (v0_1 + v2_1) * 0x1F;
        v2_2 = this.smoothingMs;
        v2_1 = v2_2 == null ? 0 : v2_2.hashCode();
        v0_1 = (v0_1 + v2_1) * 0x1F;
        v2 = this.radius1;
        v2_1 = v2 == null ? 0 : v2.hashCode();
        v0_1 = (v0_1 + v2_1) * 0x1F;
        Boolean v2_3 = this.sprintEnabled;
        v2_1 = v2_3 == null ? 0 : v2_3.hashCode();
        v0_1 = (v0_1 + v2_1) * 0x1F;
        v2_3 = this.socdEnabled;
        if(v2_3 == null) {
        }
        else {
            v1 = v2_3.hashCode();
        }

        return (v0_1 + v1) * 0x1F + this.bindings.hashCode();
    }

    public final boolean isEmpty() {
        return Intrinsics.areEqual(this, new JoystickSettingsEdit(null, null, null, null, null, null, null, null, null, null, null, 0x7FF, null));
    }

    public final Object save-0E7RQCE(GameProfile arg8, String arg9, Function1 arg10) {
        ProfileControl v2_2;
        Intrinsics.checkNotNullParameter(arg8, "profile");
        Intrinsics.checkNotNullParameter(arg9, "controlId");
        Intrinsics.checkNotNullParameter(arg10, "write");
        try {
            Iterator v0_1 = arg8.getControls().iterator();
            Object v1 = null;
            int v2 = 0;
            Object v3 = v1;
            while(true) {
                if(v0_1.hasNext()) {
                    Object v4 = v0_1.next();
                    if(!Intrinsics.areEqual(v4.getId(), arg9)) {
                        continue;
                    }

                    if(v2 != 0) {
                    }
                    else {
                        v2 = 1;
                        v3 = v4;
                        continue;
                    }
                }
                else {
                    break;
                }

                goto label_28;
            }

            if(v2 == 0) {
            }
            else {
                v1 = v3;
            }

        label_28:
            if(v1 == null) {
                goto label_67;
            }

            if(!(((ProfileControl)v1).getComponent() instanceof JoystickComponent)) {
                goto label_62;
            }

            if(this.isEmpty()) {
            }
            else {
                ProfileControl v7 = this.applyTo(((ProfileControl)v1));
                List v9 = arg8.getControls();
                ArrayList v0_2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v9), 10));
                Iterator v9_1 = ((Iterable)v9).iterator();
                goto label_42;
            label_62:
                throw new IllegalArgumentException("El control ya no es JOYSTICK".toString());
            label_67:
                throw new IllegalStateException("No hay un único JOYSTICK vigente".toString());
            label_42:
                while(v9_1.hasNext()) {
                    Object v2_1 = v9_1.next();
                    if(v2_1 == v1) {
                        v2_2 = v7;
                    }

                    ((Collection)v0_2).add(v2_2);
                }

                arg8 = GameProfile.copy$default(arg8, null, null, v0_2, null, 11, null);
                ResultKt.throwOnFailure(arg10.invoke(arg8).unbox-impl());
            }

            return Result.constructor-impl(arg8);
        }
        catch(Throwable v0) {
            return Result.constructor-impl(ResultKt.createFailure(v0));
        }
    }

    public String toString() {
        return "JoystickSettingsEdit(x=" + this.x + ", y=" + this.y + ", radius=" + this.radius + ", movementSpeed=" + this.movementSpeed + ", activationTimeMs=" + this.activationTimeMs + ", diagonalAngleDeg=" + this.diagonalAngleDeg + ", smoothingMs=" + this.smoothingMs + ", radius1=" + this.radius1 + ", sprintEnabled=" + this.sprintEnabled + ", socdEnabled=" + this.socdEnabled + ", bindings=" + this.bindings + ")";
    }
}

