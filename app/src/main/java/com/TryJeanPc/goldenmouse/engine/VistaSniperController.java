package com.TryJeanPc.goldenmouse.engine;

import com.TryJeanPc.goldenmouse.aim.CameraDiagnostics;
import com.TryJeanPc.goldenmouse.input.InputEvent$KeyDown;
import com.TryJeanPc.goldenmouse.input.InputEvent$KeyUp;
import com.TryJeanPc.goldenmouse.input.InputEvent$MouseButton;
import com.TryJeanPc.goldenmouse.input.InputEvent;
import com.TryJeanPc.goldenmouse.mapper.InputBinding;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010#\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001BC\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0018\u0010\t\u001A\u0014\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u00040\n¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0013\u001A\u00020\b2\b\u0010\u000E\u001A\u0004\u0018\u00010\u000B2\u0006\u0010\u000F\u001A\u00020\u0007J\u000E\u0010\u0014\u001A\u00020\b2\u0006\u0010\u0015\u001A\u00020\u0004J\u0006\u0010\u0016\u001A\u00020\bJ\u000E\u0010\u0017\u001A\u00020\u00042\u0006\u0010\u0018\u001A\u00020\u0019J\u000E\u0010\u001A\u001A\u00020\u00042\u0006\u0010\u0018\u001A\u00020\u0019J\u0012\u0010\u001B\u001A\u0004\u0018\u00010\u000B2\u0006\u0010\u0018\u001A\u00020\u0019H\u0002R\u0014\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\t\u001A\u0014\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u00040\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000E\u001A\u0004\u0018\u00010\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0004X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u000B0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001C"}, d2={"Lcom/TryJeanPc/goldenmouse/engine/VistaSniperController;", "", "isAimActive", "Lkotlin/Function0;", "", "setMultiplier", "Lkotlin/Function1;", "", "", "matches", "Lkotlin/Function2;", "Lcom/TryJeanPc/goldenmouse/mapper/InputBinding;", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "binding", "multiplier", "admitted", "held", "", "configure", "setAdmitted", "enabled", "invalidate", "isConfiguredFor", "event", "Lcom/TryJeanPc/goldenmouse/input/InputEvent;", "handle", "input", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class VistaSniperController {
    public static final int $stable = 8;
    private boolean admitted;
    private InputBinding binding;
    private final Set held;
    private final Function0 isAimActive;
    private final Function2 matches;
    private float multiplier;
    private final Function1 setMultiplier;

    static {
    }

    public VistaSniperController(Function0 arg2, Function1 arg3, Function2 arg4) {
        Intrinsics.checkNotNullParameter(arg2, "isAimActive");
        Intrinsics.checkNotNullParameter(arg3, "setMultiplier");
        Intrinsics.checkNotNullParameter(arg4, "matches");
        super();
        this.isAimActive = arg2;
        this.setMultiplier = arg3;
        this.matches = arg4;
        this.multiplier = 1f;
        this.held = new LinkedHashSet();
    }

    public final void configure(InputBinding arg4, float arg5) {
        __monitor_enter(this);
        try {
            this.invalidate();
            Float v0 = null;
            if(arg4 == null || !VistaQuickChangeCoordinator.Companion.isBindingAllowed(arg4)) {
                arg4 = ((InputBinding)v0);
            }
            else {
            }

            this.binding = arg4;
            Float v4_1 = Float.valueOf(arg5);
            arg5 = v4_1.floatValue();
            if(Math.abs(arg5) <= 3.402823E+38f && arg5 > 0f) {
                v0 = v4_1;
            }

            float v4_2 = v0 != null ? v0.floatValue() : 1f;
            this.multiplier = v4_2;
        }
        catch(Throwable v4) {
            try {
            label_27:
                __monitor_exit(this);
            }
            catch(Throwable v4) {
                goto label_27;
            }

            throw v4;
        }

        __monitor_exit(this);
    }

    public final boolean handle(InputEvent arg5) {
        InputBinding v2;
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(arg5, "event");
            InputBinding v0 = this.binding;
            if(v0 != null) {
                goto label_8;
            }
        }
        catch(Throwable v5) {
            goto label_62;
        }

        __monitor_exit(this);
        return 0;
        try {
        label_8:
            v2 = this.input(arg5);
            if(v2 != null) {
                goto label_12;
            }
        }
        catch(Throwable v5) {
            goto label_62;
        }

        __monitor_exit(this);
        return 0;
        try {
        label_12:
            if(this.matches.invoke(v0, v2).booleanValue()) {
                goto label_18;
            }
        }
        catch(Throwable v5) {
            goto label_62;
        }

        __monitor_exit(this);
        return 0;
        try {
        label_18:
            float v1 = 1f;
            if(!(arg5 instanceof KeyDown)) {
                if(((arg5 instanceof MouseButton)) && (((MouseButton)arg5).getPressed())) {
                    goto label_35;
                }

                this.held.remove(v2);
                if(!this.held.isEmpty()) {
                    goto label_48;
                }

                this.setMultiplier.invoke(Float.valueOf(v1));
            }
            else {
            label_35:
                if(!this.admitted) {
                    goto label_48;
                }

                if(!this.isAimActive.invoke().booleanValue()) {
                    goto label_48;
                }

                if(!this.held.add(v2)) {
                    goto label_48;
                }

                this.setMultiplier.invoke(Float.valueOf(this.multiplier));
            }

        label_48:
            CameraDiagnostics v5_1 = CameraDiagnostics.INSTANCE;
            int v0_1 = this.held.isEmpty() ^ 1;
            if(this.held.isEmpty()) {
            }
            else {
                v1 = this.multiplier;
            }

            v5_1.sniper(((boolean)v0_1), v1);
        }
        catch(Throwable v5) {
            try {
            label_62:
                __monitor_exit(this);
            }
            catch(Throwable v5) {
                goto label_62;
            }

            throw v5;
        }

        __monitor_exit(this);
        return 1;
    }

    private final InputBinding input(InputEvent arg1) {
        if((arg1 instanceof KeyDown)) {
            return InputBinding.Companion.keyboard(((KeyDown)arg1).getKeyName());
        }

        if((arg1 instanceof KeyUp)) {
            return InputBinding.Companion.keyboard(((KeyUp)arg1).getKeyName());
        }

        if((arg1 instanceof MouseButton)) {
            return InputBinding.Companion.mouse(((MouseButton)arg1).getButton());
        }

        return null;
    }

    public final void invalidate() {
        __monitor_enter(this);
        try {
            this.held.clear();
            this.setMultiplier.invoke(Float.valueOf(1f));
            CameraDiagnostics.INSTANCE.sniper(false, 1f);
        }
        catch(Throwable v0) {
            try {
            label_13:
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_13;
            }

            throw v0;
        }

        __monitor_exit(this);
    }

    public final boolean isConfiguredFor(InputEvent arg3) {
        boolean v3_4;
        Object v3_3;
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(arg3, "event");
            InputBinding v3_1 = this.input(arg3);
            if(v3_1 != null) {
                InputBinding v0 = this.binding;
                if(v0 != null) {
                    Boolean v3_2 = Boolean.valueOf(this.matches.invoke(v0, v3_1).booleanValue());
                }
                else {
                    v3_3 = null;
                }

                v3_4 = Intrinsics.areEqual(v3_3, Boolean.valueOf(true));
            }
            else {
                goto label_17;
            }

            goto label_18;
        }
        catch(Throwable v3) {
            try {
            label_21:
                __monitor_exit(this);
            }
            catch(Throwable v3) {
                goto label_21;
            }

            throw v3;
        }

    label_17:
        v3_4 = false;
    label_18:
        __monitor_exit(this);
        return v3_4;
    }

    public final void setAdmitted(boolean arg1) {
        __monitor_enter(this);
        try {
            this.admitted = arg1;
            if(!arg1) {
                this.invalidate();
            }
        }
        catch(Throwable v1) {
            try {
            label_7:
                __monitor_exit(this);
            }
            catch(Throwable v1) {
                goto label_7;
            }

            throw v1;
        }

        __monitor_exit(this);
    }
}

