package com.TryJeanPc.goldenmouse.mapper;

import com.TryJeanPc.goldenmouse.macro.execution.MacroProgram;
import com.TryJeanPc.goldenmouse.profile.JoystickComponent;
import com.TryJeanPc.goldenmouse.profile.TapComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bk\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u000B\u0012\u0006\u0010\f\u001A\u00020\u000B\u0012\u0006\u0010\r\u001A\u00020\u000B\u0012\u0006\u0010\u000E\u001A\u00020\u000B\u0012\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\t\u00102\u001A\u00020\u0003HÆ\u0003J\t\u00103\u001A\u00020\u0005HÆ\u0003J\t\u00104\u001A\u00020\u0007HÆ\u0003J\t\u00105\u001A\u00020\tHÆ\u0003J\t\u00106\u001A\u00020\u000BHÆ\u0003J\t\u00107\u001A\u00020\u000BHÆ\u0003J\t\u00108\u001A\u00020\u000BHÆ\u0003J\t\u00109\u001A\u00020\u000BHÆ\u0003J\u000B\u0010:\u001A\u0004\u0018\u00010\u0010HÆ\u0003J\u000B\u0010;\u001A\u0004\u0018\u00010\u0012HÆ\u0003J\u000B\u0010<\u001A\u0004\u0018\u00010\u0014HÆ\u0003J}\u0010=\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\f\u001A\u00020\u000B2\b\b\u0002\u0010\r\u001A\u00020\u000B2\b\b\u0002\u0010\u000E\u001A\u00020\u000B2\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u0014HÆ\u0001J\u0013\u0010>\u001A\u00020?2\b\u0010@\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010A\u001A\u00020BHÖ\u0001J\t\u0010C\u001A\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u001AR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u001B\u0010\u001CR\u0011\u0010\b\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u001ER\u0011\u0010\n\u001A\u00020\u000B¢\u0006\b\n\u0000\u001A\u0004\b\u001F\u0010 R\u0011\u0010\f\u001A\u00020\u000B¢\u0006\b\n\u0000\u001A\u0004\b!\u0010 R\u0011\u0010\r\u001A\u00020\u000B¢\u0006\b\n\u0000\u001A\u0004\b\"\u0010 R\u0011\u0010\u000E\u001A\u00020\u000B¢\u0006\b\n\u0000\u001A\u0004\b#\u0010 R\u0013\u0010\u000F\u001A\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001A\u0004\b$\u0010%R\u0013\u0010\u0011\u001A\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001A\u0004\b&\u0010\'R\u0013\u0010\u0013\u001A\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001A\u0004\b(\u0010)R\u0011\u0010*\u001A\u00020\u000B8F¢\u0006\u0006\u001A\u0004\b+\u0010 R\u0011\u0010,\u001A\u00020\u000B8F¢\u0006\u0006\u001A\u0004\b-\u0010 R\u0011\u0010.\u001A\u00020\u000B8F¢\u0006\u0006\u001A\u0004\b/\u0010 R\u0011\u00100\u001A\u00020\u000B8F¢\u0006\u0006\u001A\u0004\b1\u0010 ¨\u0006D"}, d2={"Lcom/TryJeanPc/goldenmouse/mapper/MappedControlBinding;", "", "input", "Lcom/TryJeanPc/goldenmouse/mapper/InputBinding;", "action", "Lcom/TryJeanPc/goldenmouse/mapper/GameAction;", "behavior", "Lcom/TryJeanPc/goldenmouse/mapper/ControlBehavior;", "controlId", "", "x", "", "y", "width", "height", "tap", "Lcom/TryJeanPc/goldenmouse/profile/TapComponent;", "joystick", "Lcom/TryJeanPc/goldenmouse/profile/JoystickComponent;", "macro", "Lcom/TryJeanPc/goldenmouse/macro/execution/MacroProgram;", "<init>", "(Lcom/TryJeanPc/goldenmouse/mapper/InputBinding;Lcom/TryJeanPc/goldenmouse/mapper/GameAction;Lcom/TryJeanPc/goldenmouse/mapper/ControlBehavior;Ljava/lang/String;FFFFLcom/TryJeanPc/goldenmouse/profile/TapComponent;Lcom/TryJeanPc/goldenmouse/profile/JoystickComponent;Lcom/TryJeanPc/goldenmouse/macro/execution/MacroProgram;)V", "getInput", "()Lcom/TryJeanPc/goldenmouse/mapper/InputBinding;", "getAction", "()Lcom/TryJeanPc/goldenmouse/mapper/GameAction;", "getBehavior", "()Lcom/TryJeanPc/goldenmouse/mapper/ControlBehavior;", "getControlId", "()Ljava/lang/String;", "getX", "()F", "getY", "getWidth", "getHeight", "getTap", "()Lcom/TryJeanPc/goldenmouse/profile/TapComponent;", "getJoystick", "()Lcom/TryJeanPc/goldenmouse/profile/JoystickComponent;", "getMacro", "()Lcom/TryJeanPc/goldenmouse/macro/execution/MacroProgram;", "centerX", "getCenterX", "centerY", "getCenterY", "joystickRadius", "getJoystickRadius", "joystickInitialRadius", "getJoystickInitialRadius", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "", "other", "hashCode", "", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class MappedControlBinding {
    public static final int $stable = 8;
    private final GameAction action;
    private final ControlBehavior behavior;
    private final String controlId;
    private final float height;
    private final InputBinding input;
    private final JoystickComponent joystick;
    private final MacroProgram macro;
    private final TapComponent tap;
    private final float width;
    private final float x;
    private final float y;

    static {
    }

    public MappedControlBinding(InputBinding arg2, GameAction arg3, ControlBehavior arg4, String arg5, float arg6, float arg7, float arg8, float arg9, TapComponent arg10, JoystickComponent arg11, MacroProgram arg12, int arg13, DefaultConstructorMarker arg14) {
        TapComponent v0 = null;
        if((arg13 & 0x100) != 0) {
            arg10 = v0;
        }

        if((arg13 & 0x200) != 0) {
            arg11 = ((JoystickComponent)v0);
        }

        if((arg13 & 0x400) != 0) {
            arg12 = ((MacroProgram)v0);
        }

        this(arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12);
    }

    public MappedControlBinding(InputBinding arg2, GameAction arg3, ControlBehavior arg4, String arg5, float arg6, float arg7, float arg8, float arg9, TapComponent arg10, JoystickComponent arg11, MacroProgram arg12) {
        Intrinsics.checkNotNullParameter(arg2, "input");
        Intrinsics.checkNotNullParameter(arg3, "action");
        Intrinsics.checkNotNullParameter(arg4, "behavior");
        Intrinsics.checkNotNullParameter(arg5, "controlId");
        super();
        this.input = arg2;
        this.action = arg3;
        this.behavior = arg4;
        this.controlId = arg5;
        this.x = arg6;
        this.y = arg7;
        this.width = arg8;
        this.height = arg9;
        this.tap = arg10;
        this.joystick = arg11;
        this.macro = arg12;
    }

    public final InputBinding component1() {
        return this.input;
    }

    public final JoystickComponent component10() {
        return this.joystick;
    }

    public final MacroProgram component11() {
        return this.macro;
    }

    public final GameAction component2() {
        return this.action;
    }

    public final ControlBehavior component3() {
        return this.behavior;
    }

    public final String component4() {
        return this.controlId;
    }

    public final float component5() {
        return this.x;
    }

    public final float component6() {
        return this.y;
    }

    public final float component7() {
        return this.width;
    }

    public final float component8() {
        return this.height;
    }

    public final TapComponent component9() {
        return this.tap;
    }

    public final MappedControlBinding copy(InputBinding arg13, GameAction arg14, ControlBehavior arg15, String arg16, float arg17, float arg18, float arg19, float arg20, TapComponent arg21, JoystickComponent arg22, MacroProgram arg23) {
        Intrinsics.checkNotNullParameter(arg13, "input");
        Intrinsics.checkNotNullParameter(arg14, "action");
        Intrinsics.checkNotNullParameter(arg15, "behavior");
        Intrinsics.checkNotNullParameter(arg16, "controlId");
        return new MappedControlBinding(arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23);
    }

    public static MappedControlBinding copy$default(MappedControlBinding arg0, InputBinding arg1, GameAction arg2, ControlBehavior arg3, String arg4, float arg5, float arg6, float arg7, float arg8, TapComponent arg9, JoystickComponent arg10, MacroProgram arg11, int arg12, Object arg13) {
        if((arg12 & 1) != 0) {
            arg1 = arg0.input;
        }

        if((arg12 & 2) != 0) {
            arg2 = arg0.action;
        }

        if((arg12 & 4) != 0) {
            arg3 = arg0.behavior;
        }

        if((arg12 & 8) != 0) {
            arg4 = arg0.controlId;
        }

        if((arg12 & 16) != 0) {
            arg5 = arg0.x;
        }

        if((arg12 & 0x20) != 0) {
            arg6 = arg0.y;
        }

        if((arg12 & 0x40) != 0) {
            arg7 = arg0.width;
        }

        if((arg12 & 0x80) != 0) {
            arg8 = arg0.height;
        }

        if((arg12 & 0x100) != 0) {
            arg9 = arg0.tap;
        }

        if((arg12 & 0x200) != 0) {
            arg10 = arg0.joystick;
        }

        if((arg12 & 0x400) != 0) {
            arg11 = arg0.macro;
        }

        return arg0.copy(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11);
    }

    public boolean equals(Object arg5) {
        if(this == (((MappedControlBinding)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof MappedControlBinding)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.input, ((MappedControlBinding)arg5).input)) {
            return 0;
        }

        if(this.action != ((MappedControlBinding)arg5).action) {
            return 0;
        }

        if(this.behavior != ((MappedControlBinding)arg5).behavior) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.controlId, ((MappedControlBinding)arg5).controlId)) {
            return 0;
        }

        if(Float.compare(this.x, ((MappedControlBinding)arg5).x) != 0) {
            return 0;
        }

        if(Float.compare(this.y, ((MappedControlBinding)arg5).y) != 0) {
            return 0;
        }

        if(Float.compare(this.width, ((MappedControlBinding)arg5).width) != 0) {
            return 0;
        }

        if(Float.compare(this.height, ((MappedControlBinding)arg5).height) != 0) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.tap, ((MappedControlBinding)arg5).tap)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.joystick, ((MappedControlBinding)arg5).joystick)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.macro, ((MappedControlBinding)arg5).macro)) {
            return 0;
        }

        return 1;
    }

    public final GameAction getAction() {
        return this.action;
    }

    public final ControlBehavior getBehavior() {
        return this.behavior;
    }

    public final float getCenterX() {
        return this.x + this.width / 2f;
    }

    public final float getCenterY() {
        return this.y + this.height / 2f;
    }

    public final String getControlId() {
        return this.controlId;
    }

    public final float getHeight() {
        return this.height;
    }

    public final InputBinding getInput() {
        return this.input;
    }

    public final JoystickComponent getJoystick() {
        return this.joystick;
    }

    public final float getJoystickInitialRadius() {
        JoystickComponent v0 = this.joystick;
        if(v0 != null) {
            return RangesKt.coerceIn(v0.getRadius() * v0.getRadius1() * v0.getSpeedModifier1(), 1f, Math.min(this.width, this.height) / 2f);
        }

        return this.getJoystickRadius();
    }

    public final float getJoystickRadius() {
        JoystickComponent v0 = this.joystick;
        if(v0 != null) {
            return RangesKt.coerceIn(v0.getRadius() * v0.getRadius2() * v0.getSpeedModifier2() * v0.getMovementSpeed(), 1f, Math.min(this.width, this.height) / 2f);
        }

        return Math.min(this.width, this.height) * 0.32f;
    }

    public final MacroProgram getMacro() {
        return this.macro;
    }

    public final TapComponent getTap() {
        return this.tap;
    }

    public final float getWidth() {
        return this.width;
    }

    public final float getX() {
        return this.x;
    }

    public final float getY() {
        return this.y;
    }

    public int hashCode() {
        int v0 = (((((((this.input.hashCode() * 0x1F + this.action.hashCode()) * 0x1F + this.behavior.hashCode()) * 0x1F + this.controlId.hashCode()) * 0x1F + Float.hashCode(this.x)) * 0x1F + Float.hashCode(this.y)) * 0x1F + Float.hashCode(this.width)) * 0x1F + Float.hashCode(this.height)) * 0x1F;
        TapComponent v1 = this.tap;
        int v2 = 0;
        int v1_1 = v1 == null ? 0 : v1.hashCode();
        v0 = (v0 + v1_1) * 0x1F;
        JoystickComponent v1_2 = this.joystick;
        v1_1 = v1_2 == null ? 0 : v1_2.hashCode();
        v0 = (v0 + v1_1) * 0x1F;
        MacroProgram v3 = this.macro;
        if(v3 == null) {
        }
        else {
            v2 = v3.hashCode();
        }

        return v0 + v2;
    }

    public String toString() {
        return "MappedControlBinding(input=" + this.input + ", action=" + this.action + ", behavior=" + this.behavior + ", controlId=" + this.controlId + ", x=" + this.x + ", y=" + this.y + ", width=" + this.width + ", height=" + this.height + ", tap=" + this.tap + ", joystick=" + this.joystick + ", macro=" + this.macro + ")";
    }
}

