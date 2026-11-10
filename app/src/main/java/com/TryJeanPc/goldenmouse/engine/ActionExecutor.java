package com.TryJeanPc.goldenmouse.engine;

import android.util.Log;
import com.TryJeanPc.goldenmouse.aim.FireAimCoordinator;
import com.TryJeanPc.goldenmouse.injector.InjectionBackend;
import com.TryJeanPc.goldenmouse.injector.TouchInjector$PointerLease;
import com.TryJeanPc.goldenmouse.injector.TouchInjector$PointerOwner;
import com.TryJeanPc.goldenmouse.injector.TouchInjector;
import com.TryJeanPc.goldenmouse.mapper.ControlBehavior;
import com.TryJeanPc.goldenmouse.mapper.GameAction;
import com.TryJeanPc.goldenmouse.mapper.MappedControlBinding;
import com.TryJeanPc.goldenmouse.profile.JoystickComponent;
import com.TryJeanPc.goldenmouse.profile.TapComponent;
import com.TryJeanPc.goldenmouse.profile.TapMode;
import com.TryJeanPc.goldenmouse.profile.TapTimingPolicy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001BG\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001A\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001A\u00020\n\u0012\u000E\b\u0002\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\u0004\b\r\u0010\u000EJ\u0014\u0010$\u001A\u00020 2\f\u0010%\u001A\b\u0012\u0004\u0012\u00020\'0&J\u0010\u0010(\u001A\u00020 2\u0006\u0010)\u001A\u00020\'H\u0002J \u0010*\u001A\u00020 2\u0006\u0010)\u001A\u00020\'2\u0006\u0010+\u001A\u00020,2\u0006\u0010-\u001A\u00020,H\u0002J \u0010.\u001A\u00020 2\u0006\u0010)\u001A\u00020\'2\u0006\u0010+\u001A\u00020,2\u0006\u0010-\u001A\u00020,H\u0002J\u0010\u0010/\u001A\u00020 2\u0006\u0010)\u001A\u00020\'H\u0002J\u000E\u00100\u001A\u00020\b2\u0006\u00101\u001A\u00020 J\u0016\u00102\u001A\u00020\b2\u000E\u00103\u001A\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007J\u0016\u00104\u001A\u00020\b2\u0006\u0010)\u001A\u00020\'2\u0006\u00105\u001A\u00020 J\u0006\u00106\u001A\u00020 J\u000E\u00107\u001A\u00020 2\u0006\u00108\u001A\u00020\fJ\u0006\u00109\u001A\u00020\bJ\u0018\u0010:\u001A\u00020\b2\u0006\u0010)\u001A\u00020\'2\u0006\u00105\u001A\u00020 H\u0002J0\u0010;\u001A\u00020\b2\u0006\u0010)\u001A\u00020\'2\u0006\u0010<\u001A\u00020\f2\u0006\u0010=\u001A\u00020\f2\u0006\u0010>\u001A\u00020?2\u0006\u0010@\u001A\u00020AH\u0002J\u0018\u0010B\u001A\u00020\b2\u0006\u0010)\u001A\u00020\'2\u0006\u00105\u001A\u00020 H\u0002J*\u0010C\u001A\u00020 2\u0006\u0010D\u001A\u00020A2\u0006\u0010E\u001A\u00020A2\b\b\u0002\u0010F\u001A\u00020,2\b\b\u0002\u0010G\u001A\u00020,J\u0018\u0010H\u001A\u00020\b2\u0006\u0010)\u001A\u00020\'2\u0006\u00105\u001A\u00020 H\u0002J\u001A\u0010I\u001A\u00020\b2\u0006\u0010J\u001A\u00020\u00152\b\b\u0002\u0010K\u001A\u00020 H\u0002J\u0010\u0010L\u001A\u00020\b2\u0006\u0010J\u001A\u00020\u0015H\u0002J\u0018\u0010M\u001A\u00020\b2\u0006\u0010)\u001A\u00020\'2\u0006\u0010=\u001A\u00020\fH\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001A\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0013\u001A\u000E\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0016\u001A\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0018\u001A\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u001A\u001A\u000E\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\f0\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u001C\u001A\u000E\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\f0\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001D\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001E\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001F\u001A\u00020 X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010!\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\"\u001A\u000E\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020#0\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006N"}, d2={"Lcom/TryJeanPc/goldenmouse/engine/ActionExecutor;", "", "touchInjector", "Lcom/TryJeanPc/goldenmouse/injector/TouchInjector;", "scheduler", "Lcom/TryJeanPc/goldenmouse/engine/ActionScheduler;", "onAimToggle", "Lkotlin/Function0;", "", "fireAimCoordinator", "Lcom/TryJeanPc/goldenmouse/aim/FireAimCoordinator;", "nanoTimeProvider", "", "<init>", "(Lcom/TryJeanPc/goldenmouse/injector/TouchInjector;Lcom/TryJeanPc/goldenmouse/engine/ActionScheduler;Lkotlin/jvm/functions/Function0;Lcom/TryJeanPc/goldenmouse/aim/FireAimCoordinator;Lkotlin/jvm/functions/Function0;)V", "activeButtons", "", "", "activeFireButtons", "joysticks", "", "Lcom/TryJeanPc/goldenmouse/engine/JoystickRuntimeState;", "joystickAdmissionGeneration", "Ljava/util/concurrent/atomic/AtomicLong;", "joystickSmoother", "Lcom/TryJeanPc/goldenmouse/engine/JoystickMotionSmoother;", "joystickActivationTokens", "heldTapControls", "tapTokens", "activationToken", "sessionId", "gamingEnabled", "", "capacityKey", "ownedPointers", "Lcom/TryJeanPc/goldenmouse/injector/TouchInjector$PointerLease;", "configureContactCapacity", "bindings", "", "Lcom/TryJeanPc/goldenmouse/mapper/MappedControlBinding;", "essential", "binding", "startMapped", "x", "", "y", "moveMapped", "endMapped", "setGamingEnabled", "enabled", "setOnAimToggle", "listener", "setPressed", "pressed", "releaseAll", "beginSession", "id", "close", "updateTap", "scheduleTapPulse", "generation", "token", "settings", "Lcom/TryJeanPc/goldenmouse/profile/TapComponent;", "remaining", "", "updateButton", "onMouseMove", "dx", "dy", "sensX", "sensY", "updateJoystick", "moveJoystick", "state", "activation", "stopJoystick", "scheduleJoystickActivation", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class ActionExecutor {
    @Metadata(k=3, mv={2, 2, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[ControlBehavior.values().length];
            try {
                v0[ControlBehavior.TAP.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[ControlBehavior.FIRE.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[ControlBehavior.JOYSTICK.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_15:
                            v0[ControlBehavior.AIM.ordinal()] = 4;
                            goto label_19;
                        }
                        catch(NoSuchFieldError ) {
                            try {
                            label_19:
                                v0[ControlBehavior.MACRO.ordinal()] = 5;
                                goto label_23;
                            }
                            catch(NoSuchFieldError ) {
                            label_23:
                                WhenMappings.$EnumSwitchMapping$0 = v0;
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    public static final int $stable = 8;
    private long activationToken;
    private final Set activeButtons;
    private final Set activeFireButtons;
    private final Object capacityKey;
    private final FireAimCoordinator fireAimCoordinator;
    private volatile boolean gamingEnabled;
    private final Set heldTapControls;
    private final Map joystickActivationTokens;
    private final AtomicLong joystickAdmissionGeneration;
    private final JoystickMotionSmoother joystickSmoother;
    private final Map joysticks;
    private final Function0 nanoTimeProvider;
    private Function0 onAimToggle;
    private final Map ownedPointers;
    private final ActionScheduler scheduler;
    private long sessionId;
    private final Map tapTokens;
    private final TouchInjector touchInjector;

    static {
    }

    public ActionExecutor() {
        this(null, null, null, null, null, 0x1F, null);
    }

    public ActionExecutor(TouchInjector arg9, ActionScheduler arg10, Function0 arg11, FireAimCoordinator arg12, Function0 arg13, int arg14, DefaultConstructorMarker arg15) {
        Function0 v15_1;
        ActionExecutor v10_1;
        ActionScheduler v12;
        TouchInjector v11;
        FireAimCoordinator v14;
        TimedActionScheduler v10;
        InjectionBackend v1 = null;
        if((arg14 & 1) != 0) {
            arg9 = new TouchInjector(v1, ((Function0)v1), 3, ((DefaultConstructorMarker)v1));
        }

        if((arg14 & 2) != 0) {
            v10 = new TimedActionScheduler();
        }

        if((arg14 & 4) != 0) {
            arg11 = ((Function0)v1);
        }

        if((arg14 & 8) != 0) {
            arg12 = new FireAimCoordinator(0, null, null, 6, null);
        }

        if((arg14 & 16) != 0) {
            com.TryJeanPc.goldenmouse.engine.ActionExecutor$1 v15 = com.TryJeanPc.goldenmouse.engine.ActionExecutor$1.INSTANCE;
            arg13 = arg11;
            v14 = arg12;
            v11 = arg9;
            v12 = ((ActionScheduler)v10);
            v10_1 = this;
        }
        else {
            v15_1 = arg13;
            v14 = arg12;
            v12 = ((ActionScheduler)v10);
            arg13 = arg11;
            v10_1 = this;
            v11 = arg9;
        }

        this(v11, v12, arg13, v14, v15_1);
    }

    public ActionExecutor(TouchInjector arg2, ActionScheduler arg3, Function0 arg4, FireAimCoordinator arg5, Function0 arg6) {
        Intrinsics.checkNotNullParameter(arg2, "touchInjector");
        Intrinsics.checkNotNullParameter(arg3, "scheduler");
        Intrinsics.checkNotNullParameter(arg5, "fireAimCoordinator");
        Intrinsics.checkNotNullParameter(arg6, "nanoTimeProvider");
        super();
        this.touchInjector = arg2;
        this.scheduler = arg3;
        this.onAimToggle = arg4;
        this.fireAimCoordinator = arg5;
        this.nanoTimeProvider = arg6;
        this.activeButtons = new LinkedHashSet();
        this.activeFireButtons = new LinkedHashSet();
        this.joysticks = new LinkedHashMap();
        this.joystickAdmissionGeneration = new AtomicLong();
        this.joystickSmoother = new JoystickMotionSmoother(arg3, arg6, new ActionExecutor$$ExternalSyntheticLambda1(this));
        this.joystickActivationTokens = new LinkedHashMap();
        this.heldTapControls = new LinkedHashSet();
        this.tapTokens = new LinkedHashMap();
        this.gamingEnabled = true;
        this.capacityKey = new Object();
        this.ownedPointers = new LinkedHashMap();
    }

    public final boolean beginSession(long arg2) {
        boolean v0;
        __monitor_enter(this);
        try {
            v0 = this.releaseAll();
            this.sessionId = arg2;
        }
        catch(Throwable v2) {
            try {
            label_6:
                __monitor_exit(this);
            }
            catch(Throwable v2) {
                goto label_6;
            }

            throw v2;
        }

        __monitor_exit(this);
        return v0;
    }

    public final void close() {
        __monitor_enter(this);
        try {
            this.releaseAll();
            this.touchInjector.releaseCapacity(this.capacityKey);
            this.scheduler.close();
        }
        catch(Throwable v0) {
            try {
            label_10:
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_10;
            }

            throw v0;
        }

        __monitor_exit(this);
    }

    public final boolean configureContactCapacity(List arg6) {
        boolean v6_3;
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(arg6, "bindings");
            TouchInjector v0 = this.touchInjector;
            Object v1 = this.capacityKey;
            ArrayList v2 = new ArrayList();
            Iterator v6_1 = ((Iterable)arg6).iterator();
            while(v6_1.hasNext()) {
                Object v3 = v6_1.next();
                if(!this.essential(v3)) {
                    continue;
                }

                ((Collection)v2).add(v3);
            }

            ArrayList v6_2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v2), 10));
            Iterator v2_1 = ((Iterable)v2).iterator();
            while(v2_1.hasNext()) {
                ((Collection)v6_2).add(v2_1.next().getControlId());
            }

            v6_3 = v0.reserveCapacity(v1, CollectionsKt.toSet(((Iterable)v6_2)).size());
        }
        catch(Throwable v6) {
            goto label_33;
        }

        __monitor_exit(this);
        return v6_3;
        try {
        label_33:
            __monitor_exit(this);
        }
        catch(Throwable v6) {
            goto label_33;
        }

        throw v6;
    }

    private final boolean endMapped(MappedControlBinding arg6) {
        Object v0 = this.ownedPointers.get(arg6.getControlId());
        if(v0 == null) {
            return 1;
        }

        if(Intrinsics.areEqual(((PointerLease)v0).getOwner().getComponentId(), arg6.getControlId())) {
            if(((PointerLease)v0).getOwner().getSessionId() != this.sessionId) {
            }
            else {
                boolean v1 = this.touchInjector.pointerUp(((PointerLease)v0));
                if(!v1) {
                    if(!this.touchInjector.ownsPointer(((PointerLease)v0))) {
                    }
                    else {
                        return v1;
                    }
                }

                this.ownedPointers.remove(arg6.getControlId());
                return v1;
            }
        }

        return 0;
    }

    private final boolean essential(MappedControlBinding arg2) {
        if(arg2.getAction() != GameAction.FIRE) {
            if(arg2.getBehavior() == ControlBehavior.JOYSTICK) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    static final Unit joystickSmoother$lambda$1(ActionExecutor arg1, Function0 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "action");
        __monitor_enter(arg1);
        try {
            arg2.invoke();
        }
        catch(Throwable v2) {
            __monitor_exit(arg1);
            throw v2;
        }

        __monitor_exit(arg1);
        return Unit.INSTANCE;
    }

    private final void moveJoystick(JoystickRuntimeState arg21, boolean arg22) {
        ActionExecutor v1 = this;
        MappedControlBinding v6 = arg21.getBinding();
        Object v0 = v1.joystickActivationTokens.get(v6.getControlId());
        if(v0 != null) {
            long v7 = ((Long)v0).longValue();
            long v2 = v1.sessionId;
            long v4 = v1.joystickAdmissionGeneration.get();
            JoystickRuntimeState v9 = arg21;
            Pair v0_1 = JoystickVectorPolicy.INSTANCE.target(v9, arg22);
            float v15 = v0_1.component1().floatValue();
            float v16 = v0_1.component2().floatValue();
            JoystickMotionSmoother v11 = v1.joystickSmoother;
            String v12 = v6.getControlId();
            float v13 = v9.getCurrentX();
            float v14 = v9.getCurrentY();
            JoystickComponent v0_2 = v6.getJoystick();
            long v17 = v0_2 != null ? v0_2.getSmoothingMs() : 0;
            v11.move(v12, v13, v14, v15, v16, v17, new ActionExecutor$$ExternalSyntheticLambda0(v1, v2, v4, v6, v7, v9));
        }
    }

    static void moveJoystick$default(ActionExecutor arg0, JoystickRuntimeState arg1, boolean arg2, int arg3, Object arg4) {
        arg0.moveJoystick(arg1, false);
    }

    static final boolean moveJoystick$lambda$13(ActionExecutor arg4, long arg5, long arg7, MappedControlBinding arg9, long arg10, JoystickRuntimeState arg12, float arg13, float arg14) {
        Boolean v5_2;
        if((arg4.gamingEnabled) && arg5 == arg4.sessionId && arg7 == arg4.joystickAdmissionGeneration.get()) {
            Object v5 = arg4.joystickActivationTokens.get(arg9.getControlId());
            if(v5 == null) {
            }
            else if(((Long)v5).longValue() == arg10) {
                if(arg4.joysticks.get(arg9.getControlId()) != arg12) {
                }
                else {
                    try {
                        v5 = Result.constructor-impl(Boolean.valueOf(arg4.moveMapped(arg9, arg13, arg14)));
                    }
                    catch(Throwable v5_1) {
                        v5 = Result.constructor-impl(ResultKt.createFailure(v5_1));
                    }

                    Boolean v6 = Boolean.valueOf(false);
                    if(Result.isFailure-impl(v5)) {
                        v5_2 = v6;
                    }

                    boolean v5_3 = v5_2.booleanValue();
                    if(v5_3) {
                        arg12.setCurrentX(arg13);
                        arg12.setCurrentY(arg14);
                    }
                    else {
                        arg4.stopJoystick(arg12);
                    }

                    return v5_3;
                }
            }
        }

        return 0;
    }

    private final boolean moveMapped(MappedControlBinding arg7, float arg8, float arg9) {
        Object v0 = this.ownedPointers.get(arg7.getControlId());
        if(v0 == null) {
            return 0;
        }

        if(Intrinsics.areEqual(((PointerLease)v0).getOwner().getComponentId(), arg7.getControlId())) {
            if(((PointerLease)v0).getOwner().getSessionId() != this.sessionId) {
            }
            else {
                return this.touchInjector.pointerMove(((PointerLease)v0), arg8, arg9);
            }
        }

        return 0;
    }

    public final boolean onMouseMove(int arg1, int arg2, float arg3, float arg4) {
        return 0;
    }

    public static boolean onMouseMove$default(ActionExecutor arg1, int arg2, int arg3, float arg4, float arg5, int arg6, Object arg7) {
        float v0 = 1f;
        if((arg6 & 4) != 0) {
            arg4 = v0;
        }

        if((arg6 & 8) != 0) {
            arg5 = v0;
        }

        return arg1.onMouseMove(arg2, arg3, arg4, arg5);
    }

    public final boolean releaseAll() {
        boolean v2;
        __monitor_enter(this);
        try {
            this.activeButtons.clear();
            this.activeFireButtons.clear();
            this.fireAimCoordinator.onFireUp();
            this.joysticks.clear();
            this.joystickSmoother.clear();
            this.joystickActivationTokens.clear();
            this.heldTapControls.clear();
            this.tapTokens.clear();
            ++this.sessionId;
            Iterator v0_1 = CollectionsKt.toList(this.ownedPointers.values()).iterator();
            while(true) {
            label_26:
                v2 = true;
                while(true) {
                label_27:
                    if(!v0_1.hasNext()) {
                        goto label_48;
                    }

                    Object v3 = v0_1.next();
                    boolean v4 = this.touchInjector.ownsPointer(((PointerLease)v3)) ? this.touchInjector.releaseOwner(((PointerLease)v3).getOwner()) : true;
                    if(v4) {
                        this.ownedPointers.remove(((PointerLease)v3).getOwner().getComponentId());
                    }

                    break;
                }
            }
        }
        catch(Throwable v0) {
            goto label_51;
        }

        if((v4) && (v2)) {
            goto label_26;
        }

        v2 = false;
        goto label_27;
    label_48:
        __monitor_exit(this);
        return v2;
        try {
        label_51:
            __monitor_exit(this);
        }
        catch(Throwable v0) {
            goto label_51;
        }

        throw v0;
    }

    private final void scheduleJoystickActivation(MappedControlBinding arg13, long arg14) {
        JoystickComponent v0 = arg13.getJoystick();
        if(v0 != null) {
            long v0_1 = v0.getActivationTimeMs();
            if(v0_1 <= 0) {
            }
            else {
                this.scheduler.schedule(RangesKt.coerceAtMost(v0_1, 10000), new ActionExecutor$$ExternalSyntheticLambda4(this, this.sessionId, this.joystickAdmissionGeneration.get(), arg13, arg14));
            }
        }
    }

    static final Unit scheduleJoystickActivation$lambda$17(ActionExecutor arg2, long arg3, long arg5, MappedControlBinding arg7, long arg8) {
        __monitor_enter(arg2);
        try {
            if((arg2.gamingEnabled) && arg3 == arg2.sessionId && arg5 == arg2.joystickAdmissionGeneration.get()) {
                Object v3_1 = arg2.joystickActivationTokens.get(arg7.getControlId());
                if(v3_1 == null) {
                }
                else if(((Long)v3_1).longValue() != arg8) {
                }
                else {
                    v3_1 = arg2.joysticks.get(arg7.getControlId());
                    if(v3_1 != null) {
                        if(!((JoystickRuntimeState)v3_1).getDirections().isEmpty()) {
                        }
                        else {
                            v3_1 = null;
                        }

                        if(v3_1 == null) {
                            goto label_31;
                        }

                        ((JoystickRuntimeState)v3_1).setActivationPending(false);
                        arg2.moveJoystick(((JoystickRuntimeState)v3_1), true);
                    }
                }
            }

        label_31:
        }
        catch(Throwable v3) {
            __monitor_exit(arg2);
            throw v3;
        }

        __monitor_exit(arg2);
        return Unit.INSTANCE;
    }

    private final void scheduleTapPulse(MappedControlBinding arg13, long arg14, long arg16, TapComponent arg18, int arg19) {
        boolean v0_4;
        if((this.gamingEnabled) && arg19 > 0 && arg14 == this.sessionId) {
            Object v0 = this.tapTokens.get(arg13.getControlId());
            if(v0 == null) {
                return;
            }

            if(((Long)v0).longValue() != arg16) {
                return;
            }

            if(arg18.getMode() == TapMode.REPEATING && !arg18.getRepeatEnabled() && !this.heldTapControls.contains(arg13.getControlId())) {
                return;
            }

            String v0_1 = arg13.getControlId();
            float v2 = arg13.getCenterX();
            float v3 = arg13.getCenterY();
            StringBuilder v0_2 = new StringBuilder("Inyectando Tap control=").append(v0_1).append(" en: x=").append(v2);
            String v2_1 = "GoldenCore_Input";
            Log.d(v2_1, v0_2.append(", y=").append(v3).toString());
            try {
                v0_4 = this.startMapped(arg13, arg13.getCenterX(), arg13.getCenterY());
            }
            catch(Throwable v0_3) {
                Log.e(v2_1, "Error inyectando Tap", v0_3);
                v0_4 = false;
            }

            if(!v0_4) {
                this.tapTokens.remove(arg13.getControlId());
                this.heldTapControls.remove(arg13.getControlId());
                return;
            }

            long v9 = TapTimingPolicy.INSTANCE.durationMs(arg18.getTouchDurationMs());
            this.scheduler.schedule(v9, new ActionExecutor$$ExternalSyntheticLambda3(this, arg14, arg13, arg16, arg19, arg18, v9));
        }
    }

    static final Unit scheduleTapPulse$lambda$9(ActionExecutor arg6, long arg7, MappedControlBinding arg9, long arg10, int arg12, TapComponent arg13, long arg14) {
        long v9;
        MappedControlBinding v8;
        long v11;
        ActionScheduler v3;
        long v1;
        Throwable v6;
        ActionExecutor v7;
        int v0_2;
        __monitor_enter(arg6);
        try {
            if(arg7 == arg6.sessionId) {
                Object v0_1 = arg6.tapTokens.get(arg9.getControlId());
                if(v0_1 == null) {
                    goto label_51;
                }
                else if(((Long)v0_1).longValue() != arg10) {
                    goto label_51;
                }
                else if(!arg6.endMapped(arg9)) {
                    goto label_13;
                }
                else {
                    goto label_26;
                }
            }
            else {
                goto label_51;
            }

            goto label_52;
        }
        catch(Throwable v0) {
            goto label_59;
        }

        try {
        label_13:
            arg6.tapTokens.remove(arg9.getControlId());
            arg6.heldTapControls.remove(arg9.getControlId());
            goto label_51;
        label_26:
            v0_2 = 0x7FFFFFFF;
            if(arg12 == v0_2) {
            }
            else {
                v0_2 = arg12 - 1;
            }

            if(v0_2 > 0) {
                goto label_35;
            }

            arg6.tapTokens.remove(arg9.getControlId());
            goto label_51;
        label_23:
            v7 = arg6;
            v6 = v0;
            goto label_61;
        }
        catch(Throwable v0) {
            goto label_23;
        }

        try {
        label_35:
            v1 = TapTimingPolicy.INSTANCE.periodMs(arg13);
            v3 = arg6.scheduler;
            v1 = RangesKt.coerceAtLeast(v1 - arg14, 0);
            v11 = arg10;
            long v4 = arg7;
            v7 = arg6;
            v8 = arg9;
            v9 = v4;
        }
        catch(Throwable v0) {
        label_59:
            v7 = arg6;
            goto label_60;
        }

        try {
            v3.schedule(v1, new ActionExecutor$$ExternalSyntheticLambda2(v7, v8, v9, v11, arg13, v0_2));
            goto label_52;
        label_51:
            v7 = arg6;
        label_52:
            goto label_53;
        }
        catch(Throwable v0) {
        }

    label_60:
        v6 = v0;
    label_61:
        __monitor_exit(v7);
        throw v6;
    label_53:
        __monitor_exit(v7);
        return Unit.INSTANCE;
    }

    static final Unit scheduleTapPulse$lambda$9$lambda$8$lambda$7(ActionExecutor arg1, MappedControlBinding arg2, long arg3, long arg5, TapComponent arg7, int arg8) {
        __monitor_enter(arg1);
        try {
            arg1.scheduleTapPulse(arg2, arg3, arg5, arg7, arg8);
        }
        catch(Throwable v0) {
            __monitor_exit(arg1);
            throw v0;
        }

        __monitor_exit(arg1);
        return Unit.INSTANCE;
    }

    public final void setGamingEnabled(boolean arg1) {
        this.gamingEnabled = arg1;
        if(!arg1) {
            this.joystickAdmissionGeneration.incrementAndGet();
        }
    }

    public final void setOnAimToggle(Function0 arg1) {
        this.onAimToggle = arg1;
    }

    public final void setPressed(MappedControlBinding arg3, boolean arg4) {
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(arg3, "binding");
            if((arg4) && !this.gamingEnabled) {
                goto label_6;
            }

            goto label_8;
        }
        catch(Throwable v3) {
            goto label_39;
        }

    label_6:
        __monitor_exit(this);
        return;
        try {
        label_8:
            int v0 = WhenMappings.$EnumSwitchMapping$0[arg3.getBehavior().ordinal()];
            if(v0 == 1) {
                this.updateTap(arg3, arg4);
            }
            else if(v0 == 2) {
                this.updateButton(arg3, arg4);
            }
            else if(v0 == 3) {
                this.updateJoystick(arg3, arg4);
            }
            else if(v0 != 4) {
                if(v0 == 5) {
                }
                else {
                    throw new NoWhenBranchMatchedException();
                }
            }
            else if(arg4) {
                Function0 v3_1 = this.onAimToggle;
                if(v3_1 != null) {
                    v3_1.invoke();
                }
            }
        }
        catch(Throwable v3) {
            try {
            label_39:
                __monitor_exit(this);
            }
            catch(Throwable v3) {
                goto label_39;
            }

            throw v3;
        }

        __monitor_exit(this);
    }

    private final boolean startMapped(MappedControlBinding arg19, float arg20, float arg21) {
        ActionExecutor v0 = this;
        Object v1 = v0.ownedPointers.get(arg19.getControlId());
        if(v1 != null) {
            if(v0.touchInjector.ownsPointer(((PointerLease)v1))) {
                return 0;
            }
            else {
                v0.ownedPointers.remove(arg19.getControlId());
            }
        }

        String v4 = arg19.getControlId();
        long v5 = v0.activationToken + 1;
        v0.activationToken = v5;
        long v7 = v0.sessionId;
        v1 = v0.capacityKey;
        Integer v10 = null;
        Object v9 = this.essential(arg19) ? v1 : v10;
        PointerLease v12 = TouchInjector.reservePointer$default(v0.touchInjector, new PointerOwner(v4, v5, v7, v9), v10, 2, v10);
        if(v12 == null) {
            return 0;
        }

        v0.ownedPointers.put(arg19.getControlId(), v12);
        ControlBehavior v1_1 = arg19.getBehavior();
        ControlBehavior v2 = ControlBehavior.FIRE;
        TouchInjector v11 = v0.touchInjector;
        if(v1_1 == v2) {
            return TouchInjector.pointerDownPixels$default(v11, v12, arg20, arg21, false, 8, null);
        }

        return v11.pointerDown(v12, arg20, arg21);
    }

    private final void stopJoystick(JoystickRuntimeState arg3) {
        MappedControlBinding v3 = arg3.getBinding();
        this.joystickSmoother.stop(v3.getControlId());
        this.joystickActivationTokens.remove(v3.getControlId());
        this.joysticks.remove(v3.getControlId());
        try {
            Result.constructor-impl(Boolean.valueOf(this.endMapped(v3)));
            return;
        }
        catch(Throwable v2) {
            Result.constructor-impl(ResultKt.createFailure(v2));
            return;
        }
    }

    private final void updateButton(MappedControlBinding arg3, boolean arg4) {
        Set v0 = this.activeButtons;
        if(arg4) {
            if(v0.contains(arg3.getControlId())) {
                return;
            }

            try {
                arg4 = this.startMapped(arg3, arg3.getCenterX(), arg3.getCenterY());
            }
            catch(Throwable v4) {
                Log.e("GoldenCore_Input", "Error inyectando Boton/Disparo", v4);
                arg4 = false;
            }

            if(!arg4) {
                return;
            }

            this.activeButtons.add(arg3.getControlId());
            if(arg3.getAction() != GameAction.FIRE) {
                return;
            }

            this.activeFireButtons.add(arg3.getControlId());
            this.fireAimCoordinator.onFireDown();
            return;
        }

        if(!v0.remove(arg3.getControlId())) {
            return;
        }

        if((this.activeFireButtons.remove(arg3.getControlId())) && (this.activeFireButtons.isEmpty())) {
            this.fireAimCoordinator.onFireUp();
        }

        this.endMapped(arg3);
    }

    private final void updateJoystick(MappedControlBinding arg9, boolean arg10) {
        Object v10_1;
        Map v0 = this.joysticks;
        String v1 = arg9.getControlId();
        Object v2 = v0.get(v1);
        if(v2 == null) {
            JoystickRuntimeState v2_1 = new JoystickRuntimeState(arg9);
            v0.put(v1, v2_1);
        }

        Object v3 = null;
        int v4 = 2;
        if(arg9.getAction() == GameAction.JOYSTICK_SPRINT) {
            if(((JoystickRuntimeState)v2).getSprintPressed() == arg10) {
                return;
            }

            ((JoystickRuntimeState)v2).setSprintPressed(arg10);
            if(((JoystickRuntimeState)v2).getDirections().isEmpty()) {
                if(arg10) {
                    return;
                }

                this.joysticks.remove(arg9.getControlId());
                return;
            }

            ActionExecutor.moveJoystick$default(this, ((JoystickRuntimeState)v2), false, v4, v3);
            return;
        }

        boolean v0_1 = ((JoystickRuntimeState)v2).getDirections().isEmpty();
        arg10 = arg10 ? ((JoystickRuntimeState)v2).getDirections().add(arg9.getAction()) : ((JoystickRuntimeState)v2).getDirections().remove(arg9.getAction());
        if(arg10) {
            if(((JoystickRuntimeState)v2).getDirections().isEmpty()) {
                this.joystickSmoother.stop(arg9.getControlId());
                this.joystickActivationTokens.remove(arg9.getControlId());
                ((JoystickRuntimeState)v2).setActivationPending(false);
                this.endMapped(arg9);
                if(((JoystickRuntimeState)v2).getSprintPressed()) {
                    return;
                }

                this.joysticks.remove(arg9.getControlId());
                return;
            }

            if(!v0_1) {
                goto label_107;
            }

            try {
                v10_1 = Result.constructor-impl(Boolean.valueOf(this.startMapped(arg9, arg9.getCenterX(), arg9.getCenterY())));
            }
            catch(Throwable v10) {
                v10_1 = Result.constructor-impl(ResultKt.createFailure(v10));
            }

            Boolean v0_2 = Boolean.valueOf(false);
            if(Result.isFailure-impl(v10_1)) {
                Boolean v10_2 = v0_2;
            }

            if(!v10_2.booleanValue()) {
                this.stopJoystick(((JoystickRuntimeState)v2));
                return;
            }

            ((JoystickRuntimeState)v2).setCurrentX(arg9.getCenterX());
            ((JoystickRuntimeState)v2).setCurrentY(arg9.getCenterY());
            JoystickComponent v10_3 = arg9.getJoystick();
            long v0_3 = 0;
            long v6 = v10_3 != null ? v10_3.getActivationTimeMs() : v0_3;
            arg10 = v6 > v0_3 ? true : false;
            ((JoystickRuntimeState)v2).setActivationPending(arg10);
            v0_3 = this.activationToken + 1;
            this.activationToken = v0_3;
            this.joystickActivationTokens.put(arg9.getControlId(), Long.valueOf(v0_3));
            ActionExecutor.moveJoystick$default(this, ((JoystickRuntimeState)v2), false, v4, v3);
            if(this.joysticks.get(arg9.getControlId()) == v2) {
                this.scheduleJoystickActivation(arg9, v0_3);
            }
        }

        return;
    label_107:
        ActionExecutor.moveJoystick$default(this, ((JoystickRuntimeState)v2), false, v4, v3);
    }

    private final void updateTap(MappedControlBinding arg9, boolean arg10) {
        if(!arg10) {
            this.heldTapControls.remove(arg9.getControlId());
            return;
        }

        TapComponent v6 = arg9.getTap();
        if(v6 == null) {
        }
        else {
            if(!this.heldTapControls.add(arg9.getControlId())) {
                return;
            }

            goto label_13;
        }

        return;
    label_13:
        if(this.tapTokens.remove(arg9.getControlId()) != null && !this.endMapped(arg9)) {
            this.heldTapControls.remove(arg9.getControlId());
            return;
        }

        long v4 = this.activationToken + 1;
        this.activationToken = v4;
        this.tapTokens.put(arg9.getControlId(), Long.valueOf(v4));
        long v2 = this.sessionId;
        int v0 = 1;
        if(v6.getRepeatEnabled()) {
            v0 = RangesKt.coerceIn(v6.getRepeatCount(), 1, 999);
        }
        else if(v6.getMode() == TapMode.REPEATING) {
            v0 = 0x7FFFFFFF;
        }

        MappedControlBinding v1 = arg9;
        int v7 = v0;
        ActionExecutor v0_1 = this;
        v0_1.scheduleTapPulse(v1, v2, v4, v6, v7);
    }
}

