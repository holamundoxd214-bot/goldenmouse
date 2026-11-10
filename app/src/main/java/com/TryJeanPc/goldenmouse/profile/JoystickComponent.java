package com.TryJeanPc.goldenmouse.profile;

import com.TryJeanPc.goldenmouse.input.InputEvent$Button;
import com.TryJeanPc.goldenmouse.mapper.InputBinding;
import com.TryJeanPc.goldenmouse.mapper.InputBindingSource;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000E\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u009D\u0001\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0003\u0012\b\b\u0002\u0010\b\u001A\u00020\u0003\u0012\b\b\u0002\u0010\t\u001A\u00020\n\u0012\b\b\u0002\u0010\u000B\u001A\u00020\u0003\u0012\b\b\u0002\u0010\f\u001A\u00020\r\u0012\b\b\u0002\u0010\u000E\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u000F\u001A\u00020\n\u0012\b\b\u0002\u0010\u0010\u001A\u00020\r\u0012\b\b\u0002\u0010\u0011\u001A\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001A\u00020\r¢\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010.\u001A\u00020\u0000J\t\u0010/\u001A\u00020\u0003HÆ\u0003J\t\u00100\u001A\u00020\u0003HÆ\u0003J\t\u00101\u001A\u00020\u0003HÆ\u0003J\t\u00102\u001A\u00020\u0003HÆ\u0003J\t\u00103\u001A\u00020\u0003HÆ\u0003J\t\u00104\u001A\u00020\u0003HÆ\u0003J\t\u00105\u001A\u00020\nHÆ\u0003J\t\u00106\u001A\u00020\u0003HÆ\u0003J\t\u00107\u001A\u00020\rHÆ\u0003J\t\u00108\u001A\u00020\u0003HÆ\u0003J\t\u00109\u001A\u00020\nHÆ\u0003J\t\u0010:\u001A\u00020\rHÆ\u0003J\t\u0010;\u001A\u00020\u0012HÆ\u0003J\t\u0010<\u001A\u00020\u0003HÆ\u0003J\t\u0010=\u001A\u00020\rHÆ\u0003J\u009F\u0001\u0010>\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\u00032\b\b\u0002\u0010\b\u001A\u00020\u00032\b\b\u0002\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\u00032\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u00032\b\b\u0002\u0010\u000F\u001A\u00020\n2\b\b\u0002\u0010\u0010\u001A\u00020\r2\b\b\u0002\u0010\u0011\u001A\u00020\u00122\b\b\u0002\u0010\u0013\u001A\u00020\u00032\b\b\u0002\u0010\u0014\u001A\u00020\rHÆ\u0001J\u0013\u0010?\u001A\u00020\r2\b\u0010@\u001A\u0004\u0018\u00010AHÖ\u0003J\t\u0010B\u001A\u00020CHÖ\u0001J\t\u0010D\u001A\u00020+HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u0018R\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u0018R\u0011\u0010\u0006\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u001B\u0010\u0018R\u0011\u0010\u0007\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u0018R\u0011\u0010\b\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u0018R\u0011\u0010\t\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\u001E\u0010\u001FR\u0011\u0010\u000B\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b \u0010\u0018R\u0011\u0010\f\u001A\u00020\r¢\u0006\b\n\u0000\u001A\u0004\b!\u0010\"R\u0011\u0010\u000E\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b#\u0010\u0018R\u0011\u0010\u000F\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b$\u0010\u001FR\u0011\u0010\u0010\u001A\u00020\r¢\u0006\b\n\u0000\u001A\u0004\b%\u0010\"R\u0011\u0010\u0011\u001A\u00020\u0012¢\u0006\b\n\u0000\u001A\u0004\b&\u0010\'R\u0011\u0010\u0013\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b(\u0010\u0018R\u0011\u0010\u0014\u001A\u00020\r¢\u0006\b\n\u0000\u001A\u0004\b)\u0010\"R\u0014\u0010*\u001A\u00020+X\u0096D¢\u0006\b\n\u0000\u001A\u0004\b,\u0010-¨\u0006E"}, d2={"Lcom/TryJeanPc/goldenmouse/profile/JoystickComponent;", "Lcom/TryJeanPc/goldenmouse/profile/ControlComponent;", "radius", "", "speedModifier1", "radius1", "speedModifier2", "radius2", "movementSpeed", "activationTimeMs", "", "activationSpeed", "mobaMode", "", "diagonalAngleDeg", "smoothingMs", "sprintEnabled", "sprintBinding", "Lcom/TryJeanPc/goldenmouse/mapper/InputBinding;", "sprintExpansion", "socdEnabled", "<init>", "(FFFFFFJFZFJZLcom/TryJeanPc/goldenmouse/mapper/InputBinding;FZ)V", "getRadius", "()F", "getSpeedModifier1", "getRadius1", "getSpeedModifier2", "getRadius2", "getMovementSpeed", "getActivationTimeMs", "()J", "getActivationSpeed", "getMobaMode", "()Z", "getDiagonalAngleDeg", "getSmoothingMs", "getSprintEnabled", "getSprintBinding", "()Lcom/TryJeanPc/goldenmouse/mapper/InputBinding;", "getSprintExpansion", "getSocdEnabled", "type", "", "getType", "()Ljava/lang/String;", "normalized", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "equals", "other", "", "hashCode", "", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class JoystickComponent implements ControlComponent {
    public static final int $stable;
    private final float activationSpeed;
    private final long activationTimeMs;
    private final float diagonalAngleDeg;
    private final boolean mobaMode;
    private final float movementSpeed;
    private final float radius;
    private final float radius1;
    private final float radius2;
    private final long smoothingMs;
    private final boolean socdEnabled;
    private final float speedModifier1;
    private final float speedModifier2;
    private final InputBinding sprintBinding;
    private final boolean sprintEnabled;
    private final float sprintExpansion;
    private final String type;

    static {
    }

    public JoystickComponent(float arg17, float arg18, float arg19, float arg20, float arg21, float arg22, long arg23, float arg25, boolean arg26, float arg27, long arg28, boolean arg30, InputBinding arg31, float arg32, boolean arg33, int arg34, DefaultConstructorMarker arg35) {
        InputBinding v1_1;
        int v0 = arg34;
        float v1 = (v0 & 1) != 0 ? 52f : arg17;
        float v3 = 1f;
        float v2 = (v0 & 2) != 0 ? v3 : arg18;
        float v4 = (v0 & 4) != 0 ? 0.55f : arg19;
        float v5 = (v0 & 8) != 0 ? v3 : arg20;
        float v6 = (v0 & 16) != 0 ? v3 : arg21;
        float v7 = (v0 & 0x20) != 0 ? v3 : arg22;
        long v9 = 0;
        long v11 = (v0 & 0x40) != 0 ? v9 : arg23;
        if((v0 & 0x80) != 0) {
        }
        else {
            v3 = arg25;
        }

        boolean v13 = false;
        boolean v8 = (v0 & 0x100) != 0 ? false : arg26;
        float v14 = (v0 & 0x200) != 0 ? 45f : arg27;
        if((v0 & 0x400) != 0) {
        }
        else {
            v9 = arg28;
        }

        if((v0 & 0x800) != 0) {
        }
        else {
            v13 = arg30;
        }

        if((v0 & 0x1000) != 0) {
            arg17 = v1;
            v1_1 = InputBinding.Companion.keyboard("SHIFT");
        }
        else {
            arg17 = v1;
            v1_1 = arg31;
        }

        float v15 = (v0 & 0x2000) != 0 ? 1.25f : arg32;
        boolean v34 = (v0 & 0x4000) != 0 ? true : arg33;
        this(arg17, v2, v4, v5, v6, v7, v11, v3, v8, v14, v9, v13, v1_1, v15, v34);
    }

    public JoystickComponent(float arg3, float arg4, float arg5, float arg6, float arg7, float arg8, long arg9, float arg11, boolean arg12, float arg13, long arg14, boolean arg16, InputBinding arg17, float arg18, boolean arg19) {
        Intrinsics.checkNotNullParameter(arg17, "sprintBinding");
        super();
        this.radius = arg3;
        this.speedModifier1 = arg4;
        this.radius1 = arg5;
        this.speedModifier2 = arg6;
        this.radius2 = arg7;
        this.movementSpeed = arg8;
        this.activationTimeMs = arg9;
        this.activationSpeed = arg11;
        this.mobaMode = arg12;
        this.diagonalAngleDeg = arg13;
        this.smoothingMs = arg14;
        this.sprintEnabled = arg16;
        this.sprintBinding = arg17;
        this.sprintExpansion = arg18;
        this.socdEnabled = arg19;
        this.type = "JOYSTICK";
    }

    public JoystickComponent() {
        this(0f, 0f, 0f, 0f, 0f, 0f, 0, 0f, false, 0f, 0, false, null, 0f, false, 0x7FFF, null);
    }

    public final float component1() {
        return this.radius;
    }

    public final float component10() {
        return this.diagonalAngleDeg;
    }

    public final long component11() {
        return this.smoothingMs;
    }

    public final boolean component12() {
        return this.sprintEnabled;
    }

    public final InputBinding component13() {
        return this.sprintBinding;
    }

    public final float component14() {
        return this.sprintExpansion;
    }

    public final boolean component15() {
        return this.socdEnabled;
    }

    public final float component2() {
        return this.speedModifier1;
    }

    public final float component3() {
        return this.radius1;
    }

    public final float component4() {
        return this.speedModifier2;
    }

    public final float component5() {
        return this.radius2;
    }

    public final float component6() {
        return this.movementSpeed;
    }

    public final long component7() {
        return this.activationTimeMs;
    }

    public final float component8() {
        return this.activationSpeed;
    }

    public final boolean component9() {
        return this.mobaMode;
    }

    public final JoystickComponent copy(float arg20, float arg21, float arg22, float arg23, float arg24, float arg25, long arg26, float arg28, boolean arg29, float arg30, long arg31, boolean arg33, InputBinding arg34, float arg35, boolean arg36) {
        Intrinsics.checkNotNullParameter(arg34, "sprintBinding");
        return new JoystickComponent(arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg28, arg29, arg30, arg31, arg33, arg34, arg35, arg36);
    }

    public static JoystickComponent copy$default(JoystickComponent arg16, float arg17, float arg18, float arg19, float arg20, float arg21, float arg22, long arg23, float arg25, boolean arg26, float arg27, long arg28, boolean arg30, InputBinding arg31, float arg32, boolean arg33, int arg34, Object arg35) {
        JoystickComponent v0 = arg16;
        int v1 = arg34;
        float v2 = (v1 & 1) != 0 ? v0.radius : arg17;
        float v3 = (v1 & 2) != 0 ? v0.speedModifier1 : arg18;
        float v4 = (v1 & 4) != 0 ? v0.radius1 : arg19;
        float v5 = (v1 & 8) != 0 ? v0.speedModifier2 : arg20;
        float v6 = (v1 & 16) != 0 ? v0.radius2 : arg21;
        float v7 = (v1 & 0x20) != 0 ? v0.movementSpeed : arg22;
        long v8 = (v1 & 0x40) != 0 ? v0.activationTimeMs : arg23;
        float v10 = (v1 & 0x80) != 0 ? v0.activationSpeed : arg25;
        boolean v11 = (v1 & 0x100) != 0 ? v0.mobaMode : arg26;
        float v12 = (v1 & 0x200) != 0 ? v0.diagonalAngleDeg : arg27;
        long v13 = (v1 & 0x400) != 0 ? v0.smoothingMs : arg28;
        boolean v15 = (v1 & 0x800) != 0 ? v0.sprintEnabled : arg30;
        arg17 = v2;
        InputBinding v2_1 = (v1 & 0x1000) != 0 ? v0.sprintBinding : arg31;
        InputBinding v18 = v2_1;
        v2 = (v1 & 0x2000) != 0 ? v0.sprintExpansion : arg32;
        boolean v34 = (v1 & 0x4000) != 0 ? v0.socdEnabled : arg33;
        return v0.copy(arg17, v3, v4, v5, v6, v7, v8, v10, v11, v12, v13, v15, v18, v2, v34);
    }

    public boolean equals(Object arg8) {
        if(this == (((JoystickComponent)arg8))) {
            return 1;
        }

        if(!(arg8 instanceof JoystickComponent)) {
            return 0;
        }

        if(Float.compare(this.radius, ((JoystickComponent)arg8).radius) != 0) {
            return 0;
        }

        if(Float.compare(this.speedModifier1, ((JoystickComponent)arg8).speedModifier1) != 0) {
            return 0;
        }

        if(Float.compare(this.radius1, ((JoystickComponent)arg8).radius1) != 0) {
            return 0;
        }

        if(Float.compare(this.speedModifier2, ((JoystickComponent)arg8).speedModifier2) != 0) {
            return 0;
        }

        if(Float.compare(this.radius2, ((JoystickComponent)arg8).radius2) != 0) {
            return 0;
        }

        if(Float.compare(this.movementSpeed, ((JoystickComponent)arg8).movementSpeed) != 0) {
            return 0;
        }

        if(this.activationTimeMs != ((JoystickComponent)arg8).activationTimeMs) {
            return 0;
        }

        if(Float.compare(this.activationSpeed, ((JoystickComponent)arg8).activationSpeed) != 0) {
            return 0;
        }

        if(this.mobaMode != ((JoystickComponent)arg8).mobaMode) {
            return 0;
        }

        if(Float.compare(this.diagonalAngleDeg, ((JoystickComponent)arg8).diagonalAngleDeg) != 0) {
            return 0;
        }

        if(this.smoothingMs != ((JoystickComponent)arg8).smoothingMs) {
            return 0;
        }

        if(this.sprintEnabled != ((JoystickComponent)arg8).sprintEnabled) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.sprintBinding, ((JoystickComponent)arg8).sprintBinding)) {
            return 0;
        }

        if(Float.compare(this.sprintExpansion, ((JoystickComponent)arg8).sprintExpansion) != 0) {
            return 0;
        }

        if(this.socdEnabled != ((JoystickComponent)arg8).socdEnabled) {
            return 0;
        }

        return 1;
    }

    public final float getActivationSpeed() {
        return this.activationSpeed;
    }

    public final long getActivationTimeMs() {
        return this.activationTimeMs;
    }

    public final float getDiagonalAngleDeg() {
        return this.diagonalAngleDeg;
    }

    public final boolean getMobaMode() {
        return this.mobaMode;
    }

    public final float getMovementSpeed() {
        return this.movementSpeed;
    }

    public final float getRadius() {
        return this.radius;
    }

    public final float getRadius1() {
        return this.radius1;
    }

    public final float getRadius2() {
        return this.radius2;
    }

    public final long getSmoothingMs() {
        return this.smoothingMs;
    }

    public final boolean getSocdEnabled() {
        return this.socdEnabled;
    }

    public final float getSpeedModifier1() {
        return this.speedModifier1;
    }

    public final float getSpeedModifier2() {
        return this.speedModifier2;
    }

    public final InputBinding getSprintBinding() {
        return this.sprintBinding;
    }

    public final boolean getSprintEnabled() {
        return this.sprintEnabled;
    }

    public final float getSprintExpansion() {
        return this.sprintExpansion;
    }

    public String getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((((((((((Float.hashCode(this.radius) * 0x1F + Float.hashCode(this.speedModifier1)) * 0x1F + Float.hashCode(this.radius1)) * 0x1F + Float.hashCode(this.speedModifier2)) * 0x1F + Float.hashCode(this.radius2)) * 0x1F + Float.hashCode(this.movementSpeed)) * 0x1F + Long.hashCode(this.activationTimeMs)) * 0x1F + Float.hashCode(this.activationSpeed)) * 0x1F + Boolean.hashCode(this.mobaMode)) * 0x1F + Float.hashCode(this.diagonalAngleDeg)) * 0x1F + Long.hashCode(this.smoothingMs)) * 0x1F + Boolean.hashCode(this.sprintEnabled)) * 0x1F + this.sprintBinding.hashCode()) * 0x1F + Float.hashCode(this.sprintExpansion)) * 0x1F + Boolean.hashCode(this.socdEnabled);
    }

    public final JoystickComponent normalized() {
        JoystickComponent v1 = this;
        long v8 = RangesKt.coerceIn(v1.activationTimeMs, 0, 10000);
        Float v0 = Float.valueOf(v1.diagonalAngleDeg);
        float v3 = 3.402823E+38f;
        InputBinding v4 = null;
        if(Float.compare(Math.abs(v0.floatValue()), v3) <= 0) {
        }
        else {
            v0 = ((Float)v4);
        }

        float v0_1 = v0 != null ? v0.floatValue() : 45f;
        float v12 = RangesKt.coerceIn(v0_1, 10f, 75f);
        long v13 = RangesKt.coerceIn(v1.smoothingMs, 0, 1000);
        v0 = Float.valueOf(v1.sprintExpansion);
        if(Math.abs(v0.floatValue()) <= v3) {
        }
        else {
            v0 = ((Float)v4);
        }

        v0_1 = v0 != null ? v0.floatValue() : 1.25f;
        float v17 = RangesKt.coerceIn(v0_1, 1f, 3f);
        InputBinding v0_2 = v1.sprintBinding;
        if(!StringsKt.isBlank(v0_2.getNormalizedCode())) {
            if(v0_2.getSource() == InputBindingSource.MOUSE) {
                EnumEntries v2 = Button.getEntries();
                if(((v2 instanceof Collection)) && (v2.isEmpty())) {
                    goto label_65;
                }

                Iterator v2_1 = ((Iterable)v2).iterator();
                do {
                    if(!v2_1.hasNext()) {
                        goto label_65;
                    }

                    if(!Intrinsics.areEqual(v2_1.next().name(), v0_2.getNormalizedCode())) {
                        continue;
                    }

                    break;
                }
                while(true);
            }

            v4 = v0_2;
        }

    label_65:
        if(v4 == null) {
            v4 = InputBinding.Companion.keyboard("SHIFT");
        }

        return JoystickComponent.copy$default(v1, 0f, 0f, 0f, 0f, 0f, 0f, v8, 0f, false, v12, v13, false, v4, v17, false, 0x49BF, null);
    }

    public String toString() {
        return "JoystickComponent(radius=" + this.radius + ", speedModifier1=" + this.speedModifier1 + ", radius1=" + this.radius1 + ", speedModifier2=" + this.speedModifier2 + ", radius2=" + this.radius2 + ", movementSpeed=" + this.movementSpeed + ", activationTimeMs=" + this.activationTimeMs + ", activationSpeed=" + this.activationSpeed + ", mobaMode=" + this.mobaMode + ", diagonalAngleDeg=" + this.diagonalAngleDeg + ", smoothingMs=" + this.smoothingMs + ", sprintEnabled=" + this.sprintEnabled + ", sprintBinding=" + this.sprintBinding + ", sprintExpansion=" + this.sprintExpansion + ", socdEnabled=" + this.socdEnabled + ")";
    }
}

