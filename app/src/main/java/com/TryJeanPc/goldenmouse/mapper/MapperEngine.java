package com.TryJeanPc.goldenmouse.mapper;

import android.util.Log;
import com.TryJeanPc.goldenmouse.engine.ActionExecutor;
import com.TryJeanPc.goldenmouse.input.InputEvent$KeyDown;
import com.TryJeanPc.goldenmouse.input.InputEvent$KeyUp;
import com.TryJeanPc.goldenmouse.input.InputEvent$MouseButton;
import com.TryJeanPc.goldenmouse.input.InputEvent;
import com.TryJeanPc.goldenmouse.macro.execution.MacroPlaybackEngine;
import com.TryJeanPc.goldenmouse.profile.GameProfile;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000B\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nB\u001F\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\t\u0010\u000BJ\f\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u000E0\u0013J\u000E\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u0018J\u0016\u0010\u001C\u001A\u00020\u00062\u000E\u0010\u001D\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005J\u0016\u0010\u001E\u001A\u00020\u00062\u000E\u0010\u001F\u001A\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0005J\u000E\u0010 \u001A\u00020\u00062\u0006\u0010!\u001A\u00020\u0016J\u000E\u0010\"\u001A\u00020\u00062\u0006\u0010#\u001A\u00020$J\u0010\u0010%\u001A\u0004\u0018\u00010&2\u0006\u0010\u0017\u001A\u00020\u0018J*\u0010\'\u001A\u00020\u00162\u0006\u0010(\u001A\u00020)2\u0006\u0010*\u001A\u00020)2\b\b\u0002\u0010+\u001A\u00020,2\b\b\u0002\u0010-\u001A\u00020,J\u000E\u0010.\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u0018J\u0010\u0010/\u001A\u0004\u0018\u00010&2\u0006\u0010\u0017\u001A\u00020\u0018J\u0018\u00100\u001A\u00020\u00162\u0006\u00101\u001A\u00020\u000E2\u0006\u00102\u001A\u00020\u000EH\u0002J\u0012\u00103\u001A\u0004\u0018\u00010\u000F2\u0006\u00102\u001A\u00020\u000EH\u0002J\u0018\u00104\u001A\u00020\u00162\u0006\u00101\u001A\u00020\u000E2\u0006\u00102\u001A\u00020\u000EH\u0002J\u001D\u00105\u001A\u00020\u00162\u0006\u00101\u001A\u00020\u000E2\u0006\u00102\u001A\u00020\u000EH\u0000¢\u0006\u0002\b6J\u0010\u00107\u001A\u0002082\u0006\u00109\u001A\u000208H\u0002J\u0006\u0010:\u001A\u00020\u0016J\u000E\u0010;\u001A\u00020\u00162\u0006\u0010<\u001A\u00020=J\u0006\u0010>\u001A\u00020\u0006J\f\u0010?\u001A\b\u0012\u0004\u0012\u0002080\u0013J\u000E\u0010@\u001A\u0004\u0018\u00010\u000E*\u00020\u0018H\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001A\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\f\u001A\u000E\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u000F0\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u000F0\u0011X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u000E0\u0013X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u000E0\u001AX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001B\u001A\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006A"}, d2={"Lcom/TryJeanPc/goldenmouse/mapper/MapperEngine;", "", "actionExecutor", "Lcom/TryJeanPc/goldenmouse/engine/ActionExecutor;", "onAimToggle", "Lkotlin/Function0;", "", "macroEngine", "Lcom/TryJeanPc/goldenmouse/macro/execution/MacroPlaybackEngine;", "<init>", "(Lcom/TryJeanPc/goldenmouse/engine/ActionExecutor;Lkotlin/jvm/functions/Function0;Lcom/TryJeanPc/goldenmouse/macro/execution/MacroPlaybackEngine;)V", "(Lcom/TryJeanPc/goldenmouse/engine/ActionExecutor;Lkotlin/jvm/functions/Function0;)V", "bindings", "", "Lcom/TryJeanPc/goldenmouse/mapper/InputBinding;", "Lcom/TryJeanPc/goldenmouse/mapper/MappedControlBinding;", "joystickModifiers", "", "aimInputs", "", "aimToggleInputs", "isAimToggleEvent", "", "event", "Lcom/TryJeanPc/goldenmouse/input/InputEvent;", "pressedInputs", "", "aimActiveProvider", "setOnAimToggle", "listener", "setAimActiveProvider", "provider", "setGamingEnabled", "enabled", "applyProfile", "profile", "Lcom/TryJeanPc/goldenmouse/profile/GameProfile;", "onEvent", "Lcom/TryJeanPc/goldenmouse/mapper/GameAction;", "onMouseMove", "dx", "", "dy", "sensX", "", "sensY", "hasBinding", "getBindingAction", "matchesJoystickModifier", "binding", "input", "resolveBinding", "matchesTapKeyboard", "vistaInputsOverlap", "vistaInputsOverlap$app", "tapKeyboardCode", "", "code", "releaseAll", "beginSession", "sessionId", "", "close", "getPressedKeys", "toBinding", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class MapperEngine {
    public static final int $stable = 8;
    private final ActionExecutor actionExecutor;
    private volatile Function0 aimActiveProvider;
    private volatile Set aimInputs;
    private Map bindings;
    private List joystickModifiers;
    private final MacroPlaybackEngine macroEngine;
    private Function0 onAimToggle;
    private final Set pressedInputs;

    static {
    }

    public MapperEngine(ActionExecutor arg2, Function0 arg3, MacroPlaybackEngine arg4) {
        Intrinsics.checkNotNullParameter(arg2, "actionExecutor");
        super();
        this.actionExecutor = arg2;
        this.onAimToggle = arg3;
        this.macroEngine = arg4;
        this.bindings = MapsKt.emptyMap();
        this.joystickModifiers = CollectionsKt.emptyList();
        this.aimInputs = SetsKt.emptySet();
        this.pressedInputs = new LinkedHashSet();
        Function0 v1 = this.onAimToggle;
        if(v1 != null) {
            arg2.setOnAimToggle(v1);
        }
    }

    public MapperEngine() {
        this(null, null, null, 7, null);
    }

    public MapperEngine(ActionExecutor arg9, Function0 arg10, MacroPlaybackEngine arg11, int arg12, DefaultConstructorMarker arg13) {
        if((arg12 & 1) != 0) {
            arg9 = new ActionExecutor(null, null, null, null, null, 0x1F, null);
        }

        Function0 v0 = null;
        if((arg12 & 2) != 0) {
            arg10 = v0;
        }

        if((arg12 & 4) != 0) {
            arg11 = ((MacroPlaybackEngine)v0);
        }

        this(arg9, arg10, arg11);
    }

    public MapperEngine(ActionExecutor arg2, Function0 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "actionExecutor");
        Intrinsics.checkNotNullParameter(arg3, "onAimToggle");
        this(arg2, arg3, null);
    }

    public final Set aimToggleInputs() {
        return this.aimInputs;
    }

    public final void applyProfile(GameProfile arg8) {
        Object v1_2;
        LinkedHashMap v3_3;
        Iterator v0_2;
        List v3_1;
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(arg8, "profile");
            MacroPlaybackEngine v0 = this.macroEngine;
            if(v0 != null) {
                v0.cancelAll();
            }

            this.actionExecutor.releaseAll();
            this.pressedInputs.clear();
            List v0_1 = GameProfileCompiler.INSTANCE.compile(arg8, new MapperEngine$$ExternalSyntheticLambda0(this));
            boolean v1 = this.actionExecutor.configureContactCapacity(v0_1);
            if(v1) {
                ArrayList v3 = new ArrayList();
                Iterator v2 = v0_1.iterator();
                while(v2.hasNext()) {
                    Object v4 = v2.next();
                    if(v4.getAction() != GameAction.JOYSTICK_SPRINT) {
                        continue;
                    }

                    ((Collection)v3).add(v4);
                }
            }
            else {
                v3_1 = CollectionsKt.emptyList();
            }

            this.joystickModifiers = v3_1;
            int v2_1 = 10;
            if(v1) {
                ArrayList v1_1 = new ArrayList();
                v0_2 = ((Iterable)v0_1).iterator();
                while(v0_2.hasNext()) {
                    Object v3_2 = v0_2.next();
                    if(v3_2.getAction() == GameAction.JOYSTICK_SPRINT) {
                        continue;
                    }

                    ((Collection)v1_1).add(v3_2);
                }

                v3_3 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(((Iterable)v1_1), v2_1)), 16));
                v0_2 = ((Iterable)v1_1).iterator();
                while(v0_2.hasNext()) {
                    v1_2 = v0_2.next();
                    ((Map)v3_3).put(v1_2.getInput(), v1_2);
                }
            }
            else {
                Log.e("GoldenCore_Input", "Perfil rechazado: capacidad insuficiente para FIRE/WASD");
                Map v3_4 = MapsKt.emptyMap();
            }

            this.bindings = ((Map)v3_3);
            v0 = this.macroEngine;
            if(v0 != null) {
                v0.applyProfile(arg8.getTargetPackage(), CollectionsKt.toList(this.bindings.values()));
            }

            Collection v8_1 = this.bindings.values();
            ArrayList v0_3 = new ArrayList();
            Iterator v8_2 = ((Iterable)v8_1).iterator();
            while(v8_2.hasNext()) {
                v1_2 = v8_2.next();
                if(v1_2.getBehavior() != ControlBehavior.AIM) {
                    continue;
                }

                ((Collection)v0_3).add(v1_2);
            }

            ArrayList v8_3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v0_3), v2_1));
            v0_2 = ((Iterable)v0_3).iterator();
            while(v0_2.hasNext()) {
                ((Collection)v8_3).add(v0_2.next().getInput());
            }

            this.aimInputs = CollectionsKt.toSet(((Iterable)v8_3));
        }
        catch(Throwable v8) {
            goto label_102;
        }

        __monitor_exit(this);
        return;
        try {
        label_102:
            __monitor_exit(this);
        }
        catch(Throwable v8) {
            goto label_102;
        }

        throw v8;
    }

    static final Unit applyProfile$lambda$1(MapperEngine arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "it");
        MacroPlaybackEngine v1 = arg1.macroEngine;
        if(v1 != null) {
            v1.reportError(arg2);
        }

        return Unit.INSTANCE;
    }

    public final boolean beginSession(long arg4) {
        boolean v1;
        __monitor_enter(this);
        try {
            this.pressedInputs.clear();
            MacroPlaybackEngine v0 = this.macroEngine;
            v1 = true;
            boolean v0_1 = v0 != null ? v0.beginSession(arg4) : true;
            if(!this.actionExecutor.beginSession(arg4)) {
                goto label_14;
            }
        }
        catch(Throwable v4) {
            try {
            label_18:
                __monitor_exit(this);
            }
            catch(Throwable v4) {
                goto label_18;
            }

            throw v4;
        }

        if(v0_1) {
        }
        else {
        label_14:
            v1 = false;
        }

        __monitor_exit(this);
        return v1;
    }

    public final void close() {
        __monitor_enter(this);
        try {
            this.pressedInputs.clear();
            MacroPlaybackEngine v0_1 = this.macroEngine;
            if(v0_1 != null) {
                v0_1.close();
            }

            this.actionExecutor.close();
        }
        catch(Throwable v0) {
            try {
            label_11:
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_11;
            }

            throw v0;
        }

        __monitor_exit(this);
    }

    public final GameAction getBindingAction(InputEvent arg5) {
        GameAction v1_1;
        GameAction v0;
        InputBinding v5_1;
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(arg5, "event");
            v5_1 = this.toBinding(arg5);
            v0 = null;
            if(v5_1 != null) {
                goto label_8;
            }
        }
        catch(Throwable v5) {
            goto label_34;
        }

        __monitor_exit(this);
        return v0;
        try {
        label_8:
            MappedControlBinding v1 = this.resolveBinding(v5_1);
            if(v1 != null) {
                v1_1 = v1.getAction();
                if(v1_1 == null) {
                    goto label_15;
                }
                else {
                    goto label_13;
                }
            }
            else {
            label_15:
                v1_1 = GameAction.JOYSTICK_SPRINT;
                List v2 = this.joystickModifiers;
                if(((v2 instanceof Collection)) && (v2.isEmpty())) {
                    goto label_31;
                }

                Iterator v2_1 = ((Iterable)v2).iterator();
                do {
                    if(!v2_1.hasNext()) {
                        goto label_31;
                    }

                    if(!this.matchesJoystickModifier(v2_1.next().getInput(), v5_1)) {
                        continue;
                    }

                    goto label_13;
                }
                while(true);
            }

            goto label_31;
        }
        catch(Throwable v5) {
            goto label_34;
        }

    label_13:
        v0 = v1_1;
        goto label_31;
        try {
        label_34:
            __monitor_exit(this);
        }
        catch(Throwable v5) {
            goto label_34;
        }

        throw v5;
    label_31:
        __monitor_exit(this);
        return v0;
    }

    public final Set getPressedKeys() {
        __monitor_enter(this);
        try {
            Set v0_1 = this.pressedInputs;
            ArrayList v1 = new ArrayList();
            Iterator v0_2 = ((Iterable)v0_1).iterator();
            while(v0_2.hasNext()) {
                Object v2 = v0_2.next();
                if(v2.getSource() != InputBindingSource.KEYBOARD) {
                    continue;
                }

                ((Collection)v1).add(v2);
            }

            LinkedHashSet v0_3 = new LinkedHashSet();
            Iterator v1_1 = ((Iterable)v1).iterator();
            while(v1_1.hasNext()) {
                ((Collection)v0_3).add(v1_1.next().getNormalizedCode());
            }

            __monitor_exit(this);
            return ((Set)v0_3);
        }
        catch(Throwable v0) {
            try {
            label_26:
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_26;
            }

            throw v0;
        }
    }

    public final boolean hasBinding(InputEvent arg4) {
        boolean v0;
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(arg4, "event");
            InputBinding v4_1 = this.toBinding(arg4);
            v0 = false;
            if(v4_1 != null) {
                goto label_8;
            }
        }
        catch(Throwable v4) {
            goto label_28;
        }

        __monitor_exit(this);
        return 0;
        try {
        label_8:
            if(this.resolveBinding(v4_1) == null) {
                List v1 = this.joystickModifiers;
                if(((v1 instanceof Collection)) && (v1.isEmpty())) {
                    goto label_25;
                }

                Iterator v1_1 = ((Iterable)v1).iterator();
                do {
                    if(!v1_1.hasNext()) {
                        goto label_25;
                    }

                    if(!this.matchesJoystickModifier(v1_1.next().getInput(), v4_1)) {
                        continue;
                    }

                    goto label_24;
                }
                while(true);
            }
            else {
                goto label_24;
            }

            goto label_25;
        }
        catch(Throwable v4) {
            try {
            label_28:
                __monitor_exit(this);
            }
            catch(Throwable v4) {
                goto label_28;
            }

            throw v4;
        }

    label_24:
        v0 = true;
    label_25:
        __monitor_exit(this);
        return v0;
    }

    public final boolean isAimToggleEvent(InputEvent arg3) {
        Intrinsics.checkNotNullParameter(arg3, "event");
        if(this.aimInputs.isEmpty()) {
            return 0;
        }

        InputBinding v3 = this.toBinding(arg3);
        if(v3 != null) {
            MappedControlBinding v2 = this.resolveBinding(v3);
            GameAction v2_1 = v2 != null ? v2.getAction() : null;
            if(v2_1 != GameAction.AIM) {
                return 0;
            }

            return 1;
        }

        return 0;
    }

    private final boolean matchesJoystickModifier(InputBinding arg4, InputBinding arg5) {
        if(!Intrinsics.areEqual(arg4, arg5) && (arg4.getSource() != InputBindingSource.KEYBOARD || arg5.getSource() != arg4.getSource() || !Intrinsics.areEqual(arg4.getNormalizedCode(), "SHIFT") || !SetsKt.setOf(new String[]{"LEFTSHIFT", "RIGHTSHIFT"}).contains(arg5.getNormalizedCode()))) {
            return 0;
        }

        return 1;
    }

    private final boolean matchesTapKeyboard(InputBinding arg3, InputBinding arg4) {
        if(arg3.getSource() == InputBindingSource.KEYBOARD && arg4.getSource() == InputBindingSource.KEYBOARD && (Intrinsics.areEqual(this.tapKeyboardCode(arg3.getNormalizedCode()), this.tapKeyboardCode(arg4.getNormalizedCode())))) {
            return 1;
        }

        return 0;
    }

    public final GameAction onEvent(InputEvent arg12) {
        boolean v8_2;
        Object v4_1;
        GameAction v12_2;
        boolean v12_1;
        Iterator v3_1;
        ArrayList v4;
        MappedControlBinding v2;
        GameAction v1;
        InputBinding v0;
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(arg12, "event");
            v0 = this.toBinding(arg12);
            v1 = null;
            if(v0 != null) {
                goto label_8;
            }
        }
        catch(Throwable v12) {
            goto label_143;
        }

        __monitor_exit(this);
        return v1;
        try {
        label_8:
            v2 = this.resolveBinding(v0);
            List v3 = this.joystickModifiers;
            v4 = new ArrayList();
            v3_1 = ((Iterable)v3).iterator();
            while(v3_1.hasNext()) {
                Object v5 = v3_1.next();
                if(!this.matchesJoystickModifier(v5.getInput(), v0)) {
                    continue;
                }

                ((Collection)v4).add(v5);
            }

            if(v2 == null && (((List)v4).isEmpty())) {
                goto label_25;
            }

            goto label_27;
        }
        catch(Throwable v12) {
            goto label_143;
        }

    label_25:
        __monitor_exit(this);
        return v1;
        try {
        label_27:
            if((arg12 instanceof KeyDown)) {
                v12_1 = true;
            }
            else if((arg12 instanceof KeyUp)) {
                v12_1 = false;
            }
            else if((arg12 instanceof MouseButton)) {
                v12_1 = ((MouseButton)arg12).getPressed();
            }
            else {
                goto label_140;
            }

            GameAction v3_2 = v2 != null ? v2.getAction() : v1;
            if(v3_2 != GameAction.TOUCH || !((List)v4).isEmpty() || !this.matchesTapKeyboard(v2.getInput(), v0)) {
                v3_2 = v2 != null ? v2.getAction() : v1;
                if(v3_2 != GameAction.AIM) {
                    goto label_65;
                }

                if(!((List)v4).isEmpty()) {
                    goto label_65;
                }

                if(!this.matchesTapKeyboard(v2.getInput(), v0)) {
                    goto label_65;
                }

                v0 = v2.getInput();
            }
            else {
                v0 = v2.getInput();
            }
        }
        catch(Throwable v12) {
            goto label_143;
        }

    label_65:
        Set v3_3 = this.pressedInputs;
        if(v12_1) {
            try {
                boolean v3_4 = v3_3.add(v0);
                goto label_70;
            label_69:
                v3_4 = v3_3.remove(v0);
            label_70:
                if(v3_4) {
                    goto label_77;
                }

                if(v2 != null) {
                    v12_2 = v2.getAction();
                    if(v12_2 == null) {
                        goto label_74;
                    }
                }
                else {
                label_74:
                    v12_2 = GameAction.JOYSTICK_SPRINT;
                }

                goto label_75;
            }
            catch(Throwable v12) {
                goto label_143;
            }
        }
        else {
            goto label_69;
        }

        goto label_70;
    label_75:
        __monitor_exit(this);
        return v12_2;
        try {
        label_77:
            v3_1 = ((Iterable)v4).iterator();
            goto label_78;
        }
        catch(Throwable v12) {
            goto label_143;
        }

    label_140:
        __monitor_exit(this);
        return v1;
        try {
        label_78:
            while(v3_1.hasNext()) {
                v4_1 = v3_1.next();
                ActionExecutor v7 = this.actionExecutor;
                Set v8 = this.pressedInputs;
                if(!(v8 instanceof Collection) || !v8.isEmpty()) {
                    Iterator v8_1 = ((Iterable)v8).iterator();
                    do {
                        if(v8_1.hasNext()) {
                            if(!this.matchesJoystickModifier(((MappedControlBinding)v4_1).getInput(), v8_1.next())) {
                                continue;
                            }

                            break;
                        }
                        else {
                            goto label_88;
                        }
                    }
                    while(true);

                    v8_2 = true;
                    goto label_98;
                label_88:
                    v8_2 = false;
                }
                else {
                    goto label_88;
                }

            label_98:
                v7.setPressed(((MappedControlBinding)v4_1), v8_2);
            }

            if(v2 != null) {
                goto label_104;
            }

            v12_2 = GameAction.JOYSTICK_SPRINT;
        }
        catch(Throwable v12) {
            goto label_143;
        }

        __monitor_exit(this);
        return v12_2;
        try {
        label_104:
            v3_3 = this.pressedInputs;
            if(!(v3_3 instanceof Collection) || !v3_3.isEmpty()) {
                v3_1 = ((Iterable)v3_3).iterator();
                do {
                    if(v3_1.hasNext()) {
                        v4_1 = v3_1.next();
                        if(Intrinsics.areEqual(v4_1, v0)) {
                            continue;
                        }

                        MappedControlBinding v4_2 = this.resolveBinding(((InputBinding)v4_1));
                        if(v4_2 != null) {
                            InputBinding v4_3 = v4_2.getInput();
                        }
                        else {
                            v4_1 = v1;
                        }

                        if(!Intrinsics.areEqual(v4_1, v2.getInput())) {
                            continue;
                        }

                        break;
                    }

                    goto label_128;
                }
                while(true);

                v12_2 = v2.getAction();
                goto label_126;
            }
            else {
            }

            goto label_128;
        }
        catch(Throwable v12) {
            goto label_143;
        }

    label_126:
        __monitor_exit(this);
        return v12_2;
        try {
        label_128:
            if(v2.getBehavior() == ControlBehavior.MACRO) {
                MacroPlaybackEngine v0_1 = this.macroEngine;
                if(v0_1 != null) {
                    v0_1.setPressed(v2, v12_1);
                }
            }
            else {
                this.actionExecutor.setPressed(v2, v12_1);
            }

            v12_2 = v2.getAction();
        }
        catch(Throwable v12) {
            goto label_143;
        }

        __monitor_exit(this);
        return v12_2;
        try {
        label_143:
            __monitor_exit(this);
        }
        catch(Throwable v12) {
            goto label_143;
        }

        throw v12;
    }

    public final boolean onMouseMove(int arg3, int arg4, float arg5, float arg6) {
        Function0 v0 = this.aimActiveProvider;
        if(v0 != null && (v0.invoke().booleanValue())) {
            return 0;
        }

        return this.actionExecutor.onMouseMove(arg3, arg4, arg5, arg6);
    }

    public static boolean onMouseMove$default(MapperEngine arg1, int arg2, int arg3, float arg4, float arg5, int arg6, Object arg7) {
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
        boolean v1;
        __monitor_enter(this);
        try {
            this.pressedInputs.clear();
            MacroPlaybackEngine v0_1 = this.macroEngine;
            v1 = true;
            boolean v0_2 = v0_1 != null ? v0_1.cancelAll() : true;
            if(!this.actionExecutor.releaseAll()) {
                goto label_14;
            }
        }
        catch(Throwable v0) {
            try {
            label_18:
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_18;
            }

            throw v0;
        }

        if(v0_2) {
        }
        else {
        label_14:
            v1 = false;
        }

        __monitor_exit(this);
        return v1;
    }

    private final MappedControlBinding resolveBinding(InputBinding arg7) {
        Object v3;
        Object v1;
        Object v0 = this.bindings.get(arg7);
        if(v0 != null) {
            return ((MappedControlBinding)v0);
        }

        if(arg7.getSource() == InputBindingSource.KEYBOARD && ((Intrinsics.areEqual(arg7.getNormalizedCode(), "LEFTSHIFT")) || (Intrinsics.areEqual(arg7.getNormalizedCode(), "RIGHTSHIFT")))) {
            return this.bindings.get(InputBinding.Companion.keyboard("SHIFT"));
        }

        MappedControlBinding v2 = null;
        if(arg7.getSource() == InputBindingSource.KEYBOARD) {
            Iterator v0_1 = this.bindings.values().iterator();
            do {
                if(v0_1.hasNext()) {
                    v1 = v0_1.next();
                    v3 = v1;
                    if(((MappedControlBinding)v3).getAction() != GameAction.TOUCH) {
                        continue;
                    }

                    if(!this.matchesTapKeyboard(((MappedControlBinding)v3).getInput(), arg7)) {
                        continue;
                    }

                    break;
                }
                else {
                    goto label_39;
                }
            }
            while(true);

            goto label_40;
        label_39:
            v1 = v2;
        label_40:
            if(v1 != null) {
                return ((MappedControlBinding)v1);
            }

            List v0_2 = this.joystickModifiers;
            if(!(v0_2 instanceof Collection) || !v0_2.isEmpty()) {
                v0_1 = ((Iterable)v0_2).iterator();
                do {
                    if(v0_1.hasNext()) {
                        if(!this.matchesJoystickModifier(v0_1.next().getInput(), arg7)) {
                            continue;
                        }

                        return v2;
                    }

                    goto label_57;
                }
                while(true);

                return v2;
            }
            else {
            }

        label_57:
            v0_1 = this.bindings.values().iterator();
            do {
            label_60:
                if(!v0_1.hasNext()) {
                    return v2;
                }

                v1 = v0_1.next();
                v3 = v1;
                if(((MappedControlBinding)v3).getAction() != GameAction.AIM) {
                    goto label_60;
                }
            }
            while(!this.matchesTapKeyboard(((MappedControlBinding)v3).getInput(), arg7));

            Object v2_1 = v1;
        }

        return v2;
    }

    public final void setAimActiveProvider(Function0 arg1) {
        this.aimActiveProvider = arg1;
    }

    public final void setGamingEnabled(boolean arg2) {
        this.actionExecutor.setGamingEnabled(arg2);
        MacroPlaybackEngine v1 = this.macroEngine;
        if(v1 != null) {
            v1.setGamingEnabled(arg2);
        }
    }

    public final void setOnAimToggle(Function0 arg1) {
        this.onAimToggle = arg1;
        this.actionExecutor.setOnAimToggle(arg1);
    }

    private final String tapKeyboardCode(String arg2) {
        int v1 = arg2.hashCode();
        switch(v1) {
            case -2071440257: {
                goto label_265;
            }
            case -1942422166: {
                goto label_259;
            }
            case -1818328173: {
                goto label_253;
            }
            case -1793460494: {
                goto label_247;
            }
            case -1793176948: {
                goto label_241;
            }
            case -1282225775: {
                goto label_235;
            }
            case -899848809: {
                goto label_229;
            }
            case -653450739: {
                goto label_223;
            }
            case -154864545: {
                goto label_217;
            }
            case 2715: {
                goto label_211;
            }
            case 67881: {
                goto label_205;
            }
            case 68795: {
                goto label_199;
            }
            case 68949: {
                goto label_193;
            }
            case 2104482: {
                goto label_187;
            }
            case 2332679: {
                goto label_181;
            }
            case 16923607: {
                goto label_175;
            }
            case 66219796: {
                goto label_169;
            }
            case 71715236: {
                goto label_163;
            }
            case 75902422: {
                goto label_157;
            }
            case 77974012: {
                goto label_151;
            }
            case 80162174: {
                goto label_145;
            }
            case 199761011: {
                goto label_139;
            }
            case 199851215: {
                goto label_133;
            }
            case 206994955: {
                goto label_127;
            }
            case 212612888: {
                goto label_121;
            }
            case 236299884: {
                goto label_115;
            }
            case 552102264: {
                goto label_109;
            }
            case 731699084: {
                goto label_103;
            }
            case 773428258: {
                goto label_97;
            }
            case 1217930855: {
                goto label_91;
            }
            case 1218214401: {
                goto label_85;
            }
            case 1471986732: {
                goto label_81;
            }
            case 1471986734: {
                goto label_77;
            }
            case 1471986920: {
                goto label_73;
            }
            case 1471986942: {
                goto label_69;
            }
            case 1642567601: {
                goto label_63;
            }
            case 1987146347: {
                goto label_57;
            }
            case 2012838315: {
                goto label_51;
            }
            default: {
                switch(v1) {
                    case 74603: {
                        if(arg2.equals("KP0")) {
                            goto label_44;
                        }

                        return arg2;
                    }
                    case 74604: {
                        if(arg2.equals("KP1")) {
                            goto label_44;
                        }

                        return arg2;
                    }
                    case 74605: {
                        if(!arg2.equals("KP2")) {
                            return arg2;
                        }

                    label_44:
                        return "NUMPAD_" + StringsKt.last(((CharSequence)arg2));
                    label_97:
                        if(!arg2.equals("LEFTALT")) {
                            return arg2;
                        }

                        return "ALT_LEFT";
                    label_163:
                        if(!arg2.equals("KPDOT")) {
                            return arg2;
                        }

                        return "NUMPAD_DOT";
                    label_229:
                        if(!arg2.equals("RIGHTBRACE")) {
                            return arg2;
                        }

                        return "RIGHT_BRACKET";
                    label_103:
                        if(!arg2.equals("CAPSLOCK")) {
                            return arg2;
                        }

                        return "CAPS_LOCK";
                    label_169:
                        if(!arg2.equals("EQUAL")) {
                            return arg2;
                        }

                        return "EQUALS";
                    label_235:
                        if(!arg2.equals("NUMLOCK")) {
                            return arg2;
                        }

                        return "NUM_LOCK";
                    label_109:
                        if(!arg2.equals("SCROLLLOCK")) {
                            return arg2;
                        }

                        return "SCROLL_LOCK";
                    label_175:
                        if(!arg2.equals("KPASTERISK")) {
                            return arg2;
                        }

                        return "NUMPAD_MULTIPLY";
                    label_241:
                        if(!arg2.equals("LEFTMETA")) {
                            return arg2;
                        }

                        return "META_LEFT";
                    label_51:
                        if(!arg2.equals("DELETE")) {
                            return arg2;
                        }

                        return "FORWARD_DEL";
                    label_115:
                        if(!arg2.equals("LEFTBRACE")) {
                            return arg2;
                        }

                        return "LEFT_BRACKET";
                    label_181:
                        if(!arg2.equals("LEFT")) {
                            return arg2;
                        }

                        return "DPAD_LEFT";
                    label_247:
                        if(!arg2.equals("LEFTCTRL")) {
                            return arg2;
                        }

                        return "CTRL_LEFT";
                    label_57:
                        if(!arg2.equals("LINUX_99")) {
                            return arg2;
                        }

                        return "SYSRQ";
                    label_121:
                        if(!arg2.equals("KPSLASH")) {
                            return arg2;
                        }

                        return "NUMPAD_DIVIDE";
                    label_187:
                        if(!arg2.equals("DOWN")) {
                            return arg2;
                        }

                        return "DPAD_DOWN";
                    label_253:
                        if(arg2.equals("KPRIGHTPAREN")) {
                            return "NUMPAD_RIGHT_PAREN";
                        }

                        return arg2;
                    label_63:
                        if(!arg2.equals("PAGEDOWN")) {
                            return arg2;
                        }

                        return "PAGE_DOWN";
                    label_127:
                        if(!arg2.equals("KPMINUS")) {
                            return arg2;
                        }

                        return "NUMPAD_SUBTRACT";
                    label_193:
                        if(!arg2.equals("ESC")) {
                            return arg2;
                        }

                        return "ESCAPE";
                    label_259:
                        if(!arg2.equals("PAGEUP")) {
                            return arg2;
                        }

                        return "PAGE_UP";
                    label_69:
                        if(!arg2.equals("LINUX_180")) {
                            return arg2;
                        }

                        return "NUMPAD_RIGHT_PAREN";
                    label_133:
                        if(arg2.equals("KPEQUAL")) {
                            return "NUMPAD_EQUALS";
                        }

                        return arg2;
                    label_199:
                        if(!arg2.equals("END")) {
                            return arg2;
                        }

                        return "MOVE_END";
                    label_73:
                        if(arg2.equals("LINUX_179")) {
                            return "NUMPAD_LEFT_PAREN";
                        }

                        return arg2;
                    label_265:
                        if(!arg2.equals("KPPLUS")) {
                            return arg2;
                        }

                        return "NUMPAD_ADD";
                    label_139:
                        if(!arg2.equals("KPENTER")) {
                            return arg2;
                        }

                        return "NUMPAD_ENTER";
                    label_77:
                        if(arg2.equals("LINUX_119")) {
                            return "BREAK";
                        }

                        return arg2;
                    label_205:
                        if(!arg2.equals("DOT")) {
                            return arg2;
                        }

                        return "PERIOD";
                    label_81:
                        if(!arg2.equals("LINUX_117")) {
                            return arg2;
                        }

                        return "NUMPAD_EQUALS";
                    label_145:
                        if(!arg2.equals("KPLEFTPAREN")) {
                            return arg2;
                        }

                        return "NUMPAD_LEFT_PAREN";
                    label_211:
                        if(!arg2.equals("UP")) {
                            return arg2;
                        }

                        return "DPAD_UP";
                    label_85:
                        if(!arg2.equals("RIGHTMETA")) {
                            return arg2;
                        }

                        return "META_RIGHT";
                    label_151:
                        if(!arg2.equals("RIGHT")) {
                            return arg2;
                        }

                        return "DPAD_RIGHT";
                    label_217:
                        if(!arg2.equals("BACKSPACE")) {
                            return arg2;
                        }

                        return "DEL";
                    label_91:
                        if(!arg2.equals("RIGHTCTRL")) {
                            return arg2;
                        }

                        return "CTRL_RIGHT";
                    label_157:
                        if(!arg2.equals("PAUSE")) {
                            return arg2;
                        }

                        return "BREAK";
                    label_223:
                        if(arg2.equals("RIGHTALT")) {
                            return "ALT_RIGHT";
                        }

                        return arg2;
                    }
                    case 74606: {
                        if(arg2.equals("KP3")) {
                            goto label_44;
                        }

                        return arg2;
                    }
                    case 74607: {
                        if(arg2.equals("KP4")) {
                            goto label_44;
                        }

                        return arg2;
                    }
                    case 74608: {
                        if(arg2.equals("KP5")) {
                            goto label_44;
                        }

                        return arg2;
                    }
                    case 74609: {
                        if(arg2.equals("KP6")) {
                            goto label_44;
                        }

                        return arg2;
                    }
                    case 74610: {
                        if(arg2.equals("KP7")) {
                            goto label_44;
                        }

                        return arg2;
                    }
                    case 74611: {
                        if(arg2.equals("KP8")) {
                            goto label_44;
                        }

                        return arg2;
                    }
                    case 74612: {
                        if(arg2.equals("KP9")) {
                            goto label_44;
                        }

                        return arg2;
                    }
                    default: {
                        return arg2;
                    }
                }
            }
        }

        return arg2;
    }

    private final InputBinding toBinding(InputEvent arg1) {
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

    public final boolean vistaInputsOverlap$app(InputBinding arg8, InputBinding arg9) {
        String[] v7;
        Intrinsics.checkNotNullParameter(arg8, "binding");
        Intrinsics.checkNotNullParameter(arg9, "input");
        if(!Intrinsics.areEqual(arg8, arg9) && !this.matchesTapKeyboard(arg8, arg9)) {
            if(arg8.getSource() == InputBindingSource.KEYBOARD && arg9.getSource() == InputBindingSource.KEYBOARD) {
                String v0 = "SHIFT";
                String v3 = "RIGHTSHIFT";
                String v4 = "LEFTSHIFT";
                int v5 = 2;
                if(Intrinsics.areEqual(arg8.getNormalizedCode(), v0)) {
                    v7 = new String[v5];
                    v7[0] = v4;
                    v7[1] = v3;
                    if(!SetsKt.setOf(((Object[])v7)).contains(arg9.getNormalizedCode())) {
                        goto label_30;
                    }

                    return 1;
                }

            label_30:
                if(!Intrinsics.areEqual(arg9.getNormalizedCode(), v0)) {
                    return 0;
                }

                v7 = new String[v5];
                v7[0] = v4;
                v7[1] = v3;
                if(!SetsKt.setOf(((Object[])v7)).contains(arg8.getNormalizedCode())) {
                    return 0;
                }

                return 1;
            }

            return 0;
        }

        return 1;
    }
}

