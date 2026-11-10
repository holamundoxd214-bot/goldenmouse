package com.TryJeanPc.goldenmouse.engine;

import com.TryJeanPc.goldenmouse.mapper.MappedControlBinding;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R!\u0010\b\u001A\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000B¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u001A\u0010\u000E\u001A\u00020\u000FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001A\u0010\u0014\u001A\u00020\u000FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001A\u0010\u0017\u001A\u00020\u0018X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0019\u0010\u001A\"\u0004\b\u001B\u0010\u001CR\u001A\u0010\u001D\u001A\u00020\u0018X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001E\u0010\u001A\"\u0004\b\u001F\u0010\u001C¨\u0006 "}, d2={"Lcom/TryJeanPc/goldenmouse/engine/JoystickRuntimeState;", "", "binding", "Lcom/TryJeanPc/goldenmouse/mapper/MappedControlBinding;", "<init>", "(Lcom/TryJeanPc/goldenmouse/mapper/MappedControlBinding;)V", "getBinding", "()Lcom/TryJeanPc/goldenmouse/mapper/MappedControlBinding;", "directions", "Ljava/util/LinkedHashSet;", "Lcom/TryJeanPc/goldenmouse/mapper/GameAction;", "Lkotlin/collections/LinkedHashSet;", "getDirections", "()Ljava/util/LinkedHashSet;", "sprintPressed", "", "getSprintPressed", "()Z", "setSprintPressed", "(Z)V", "activationPending", "getActivationPending", "setActivationPending", "currentX", "", "getCurrentX", "()F", "setCurrentX", "(F)V", "currentY", "getCurrentY", "setCurrentY", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class JoystickRuntimeState {
    public static final int $stable = 8;
    private boolean activationPending;
    private final MappedControlBinding binding;
    private float currentX;
    private float currentY;
    private final LinkedHashSet directions;
    private boolean sprintPressed;

    static {
    }

    public JoystickRuntimeState(MappedControlBinding arg2) {
        Intrinsics.checkNotNullParameter(arg2, "binding");
        super();
        this.binding = arg2;
        this.directions = new LinkedHashSet();
        this.currentX = arg2.getCenterX();
        this.currentY = arg2.getCenterY();
    }

    public final boolean getActivationPending() {
        return this.activationPending;
    }

    public final MappedControlBinding getBinding() {
        return this.binding;
    }

    public final float getCurrentX() {
        return this.currentX;
    }

    public final float getCurrentY() {
        return this.currentY;
    }

    public final LinkedHashSet getDirections() {
        return this.directions;
    }

    public final boolean getSprintPressed() {
        return this.sprintPressed;
    }

    public final void setActivationPending(boolean arg1) {
        this.activationPending = arg1;
    }

    public final void setCurrentX(float arg1) {
        this.currentX = arg1;
    }

    public final void setCurrentY(float arg1) {
        this.currentY = arg1;
    }

    public final void setSprintPressed(boolean arg1) {
        this.sprintPressed = arg1;
    }
}

