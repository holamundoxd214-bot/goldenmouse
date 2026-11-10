package com.TryJeanPc.goldenmouse.mapper;

import android.util.Log;
import com.TryJeanPc.goldenmouse.input.InputEvent$Button;
import com.TryJeanPc.goldenmouse.macro.MacroValidationPolicy;
import com.TryJeanPc.goldenmouse.macro.editor.MacroDraft;
import com.TryJeanPc.goldenmouse.macro.execution.MacroProgram;
import com.TryJeanPc.goldenmouse.profile.ControlComponent;
import com.TryJeanPc.goldenmouse.profile.FireComponent;
import com.TryJeanPc.goldenmouse.profile.GameProfile;
import com.TryJeanPc.goldenmouse.profile.JoystickComponent;
import com.TryJeanPc.goldenmouse.profile.MacroScriptComponent;
import com.TryJeanPc.goldenmouse.profile.ProfileControl;
import com.TryJeanPc.goldenmouse.profile.TapComponent;
import com.TryJeanPc.goldenmouse.profile.TapMode;
import com.TryJeanPc.goldenmouse.profile.TapTimingPolicy;
import com.TryJeanPc.goldenmouse.profile.ViewComponent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.GroupingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007J\u000E\u0010\b\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007J\u000E\u0010\t\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007J,\u0010\n\u001A\b\u0012\u0004\u0012\u00020\f0\u000B2\u0006\u0010\r\u001A\u00020\u000E2\u0016\b\u0002\u0010\u000F\u001A\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0010J\u001A\u0010\u0013\u001A\u00020\u00122\u0006\u0010\r\u001A\u00020\u000E2\n\b\u0002\u0010\u0014\u001A\u0004\u0018\u00010\u0011J<\u0010\u0015\u001A\u00020\f*\u00020\u00162\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u001A2\n\b\u0002\u0010\u001B\u001A\u0004\u0018\u00010\u001C2\n\b\u0002\u0010\u001D\u001A\u0004\u0018\u00010\u001EH\u0002J\u0010\u0010\u001F\u001A\u00020 2\u0006\u0010!\u001A\u00020\u0011H\u0002R&\u0010\"\u001A\u001A\u0012\u0004\u0012\u00020\f\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00110#0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010%\u001A\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010&\u001A\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\'\u001A\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010(\u001A\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010)\u001A\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010*\u001A\u00020\u0011X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010+\u001A\u00020\u0011X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010,\u001A\u00020\u0011X\u0082T¢\u0006\u0002\n\u0000R \u0010-\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00180#0\u000BX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2={"Lcom/TryJeanPc/goldenmouse/mapper/GameProfileCompiler;", "", "<init>", "()V", "isTapInputAllowed", "", "input", "Lcom/TryJeanPc/goldenmouse/mapper/InputBinding;", "isVistaInputAllowed", "isMacroInputAllowed", "compile", "", "Lcom/TryJeanPc/goldenmouse/mapper/MappedControlBinding;", "profile", "Lcom/TryJeanPc/goldenmouse/profile/GameProfile;", "onMacroError", "Lkotlin/Function1;", "", "", "requireMacroContactBudgets", "macroId", "toBinding", "Lcom/TryJeanPc/goldenmouse/profile/ProfileControl;", "action", "Lcom/TryJeanPc/goldenmouse/mapper/GameAction;", "behavior", "Lcom/TryJeanPc/goldenmouse/mapper/ControlBehavior;", "tap", "Lcom/TryJeanPc/goldenmouse/profile/TapComponent;", "joystick", "Lcom/TryJeanPc/goldenmouse/profile/JoystickComponent;", "defaultSize", "", "type", "InputBindingKeySelector", "Lkotlin/Pair;", "Lcom/TryJeanPc/goldenmouse/mapper/InputBindingSource;", "SLOT_PRIMARY", "SLOT_UP", "SLOT_LEFT", "SLOT_DOWN", "SLOT_RIGHT", "TYPE_TAP", "TYPE_FIRE", "TYPE_JOYSTICK", "JOYSTICK_ACTIONS", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GameProfileCompiler {
    public static final int $stable = 0;
    public static final GameProfileCompiler INSTANCE = null;
    private static final Function1 InputBindingKeySelector = null;
    private static final List JOYSTICK_ACTIONS = null;
    public static final String SLOT_DOWN = "DOWN";
    public static final String SLOT_LEFT = "LEFT";
    public static final String SLOT_PRIMARY = "PRIMARY";
    public static final String SLOT_RIGHT = "RIGHT";
    public static final String SLOT_UP = "UP";
    private static final String TYPE_FIRE = "DISPARO";
    private static final String TYPE_JOYSTICK = "JOYSTICK";
    private static final String TYPE_TAP = "TAP";

    static {
        GameProfileCompiler.INSTANCE = new GameProfileCompiler();
        GameProfileCompiler.InputBindingKeySelector = new GameProfileCompiler$$ExternalSyntheticLambda0();
        GameProfileCompiler.JOYSTICK_ACTIONS = CollectionsKt.listOf(new Pair[]{TuplesKt.to("UP", GameAction.MOVE_FORWARD), TuplesKt.to("LEFT", GameAction.MOVE_LEFT), TuplesKt.to("DOWN", GameAction.MOVE_BACKWARD), TuplesKt.to("RIGHT", GameAction.MOVE_RIGHT)});
        GameProfileCompiler.$stable = 8;
    }

    private GameProfileCompiler() {
        super();
    }

    static final Pair InputBindingKeySelector$lambda$24(MappedControlBinding arg1) {
        Intrinsics.checkNotNullParameter(arg1, "it");
        return TuplesKt.to(arg1.getInput().getSource(), arg1.getInput().getNormalizedCode());
    }

    public final List compile(GameProfile arg29, Function1 arg30) {
        boolean v0_10;
        Object v5_4;
        Object v6_1;
        Iterator v0_5;
        JoystickComponent v17;
        Object v13_1;
        GameProfileCompiler v11_2;
        Object v7_1;
        String v0_4;
        Object v11_1;
        Object v0;
        Object v12;
        String v9;
        String v8;
        String v7;
        Function1 v1 = arg30;
        GameProfile v2 = arg29;
        Intrinsics.checkNotNullParameter(v2, "profile");
        ArrayList v3 = new ArrayList();
        ArrayList v4 = new ArrayList();
        Map v5 = GroupingKt.eachCount(new GameProfileCompiler$compile$$inlined$groupingBy$1(v2.getControls()));
        Iterator v6 = v2.getControls().iterator();
        while(true) {
        label_16:
            v7 = "GoldenMacro";
            v8 = ": ";
            v9 = "/";
            if(!v6.hasNext()) {
                break;
            }

            v12 = v6.next();
            if(!StringsKt.isBlank(((ProfileControl)v12).getId())) {
                v0 = v5.get(((ProfileControl)v12).getId());
                if(v0 == null) {
                }
                else if(((Integer)v0).intValue() != 1) {
                }
                else {
                    ControlComponent v0_1 = ((ProfileControl)v12).getComponent();
                    String v11 = "PRIMARY";
                    String v13 = null;
                    if((v0_1 instanceof MacroScriptComponent)) {
                        Object v10 = ((ProfileControl)v12).getBindings().get(v11);
                        if(v10 == null || !GameProfileCompiler.INSTANCE.isMacroInputAllowed(((InputBinding)v10))) {
                            v10 = v13;
                        }
                        else {
                        }

                        MacroDraft v0_2 = ((MacroScriptComponent)v0_1).getMacro();
                        if(v10 == null) {
                            continue;
                        }

                        if(v0_2 == null) {
                            continue;
                        }

                        try {
                            v0 = Result.constructor-impl(MacroProgram.Companion.compile(v0_2));
                        }
                        catch(Throwable v0_3) {
                            v0 = Result.constructor-impl(ResultKt.createFailure(v0_3));
                        }

                        v11_1 = Result.isFailure-impl(v0) ? v13 : v0;
                        Object v25 = v11_1;
                        if(v25 != null) {
                            v3.add(MappedControlBinding.copy$default(GameProfileCompiler.toBinding$default(GameProfileCompiler.INSTANCE, ((ProfileControl)v12), v10, GameAction.MACRO, ControlBehavior.MACRO, null, null, 24, null), null, null, null, null, 0f, 0f, 0f, 0f, null, null, ((MacroProgram)v25), 0x3FF, null));
                            continue;
                        }

                        String v10_1 = v2.getTargetPackage();
                        v11 = ((ProfileControl)v12).getId();
                        v0_3 = Result.exceptionOrNull-impl(v0);
                        if(v0_3 != null) {
                            v13 = v0_3.getMessage();
                        }

                        v0_4 = v10_1 + v9 + v11 + v8 + v13;
                        Log.e(v7, v0_4);
                        if(v1 == null) {
                            continue;
                        }

                        v1.invoke(v0_4);
                        continue;
                    }
                    else {
                        if((v0_1 instanceof TapComponent)) {
                            v7_1 = ((ProfileControl)v12).getBindings().get(v11);
                            if(v7_1 == null) {
                                continue;
                            }

                            v11_2 = GameProfileCompiler.INSTANCE;
                            if(v11_2.isTapInputAllowed(((InputBinding)v7_1))) {
                                v13_1 = v7_1;
                            }

                            if(v13_1 == null) {
                                continue;
                            }

                            ArrayList v7_2 = v3;
                            GameAction v14 = GameAction.TOUCH;
                            ControlBehavior v8_1 = ((TapComponent)v0_1).getMode() == TapMode.HOLD ? ControlBehavior.FIRE : ControlBehavior.TAP;
                            ((Collection)v7_2).add(GameProfileCompiler.toBinding$default(v11_2, ((ProfileControl)v12), ((InputBinding)v13_1), v14, v8_1, TapTimingPolicy.INSTANCE.forExecution(((TapComponent)v0_1)), null, 16, null));
                            continue;
                        }

                        if((v0_1 instanceof FireComponent)) {
                            v3.add(GameProfileCompiler.toBinding$default(GameProfileCompiler.INSTANCE, ((ProfileControl)v12), InputBinding.Companion.mouse(Button.LEFT), GameAction.FIRE, ControlBehavior.FIRE, null, null, 24, null));
                            continue;
                        }

                        if((v0_1 instanceof JoystickComponent)) {
                            v17 = ((JoystickComponent)v0_1).normalized();
                            v0_5 = GameProfileCompiler.JOYSTICK_ACTIONS.iterator();
                            goto label_154;
                        }

                        if((v0_1 instanceof ViewComponent)) {
                            v0 = ((ProfileControl)v12).getBindings().get(v11);
                            if(v0 == null) {
                                v0 = CollectionsKt.firstOrNull(((ProfileControl)v12).getBindings().values());
                            }

                            v13_1 = v0;
                            if(v13_1 == null) {
                                continue;
                            }

                            v11_2 = GameProfileCompiler.INSTANCE;
                            if(!v11_2.isVistaInputAllowed(((InputBinding)v13_1))) {
                                continue;
                            }

                            v3.add(GameProfileCompiler.toBinding$default(v11_2, ((ProfileControl)v12), ((InputBinding)v13_1), GameAction.AIM, ControlBehavior.AIM, null, null, 24, null));
                            continue;
                        }

                        throw new NoWhenBranchMatchedException();
                    }
                }
            }

            v0_4 = v2.getTargetPackage() + ": ID de control vacío o repetido (" + ((ProfileControl)v12).getId() + ")";
            Log.e("GoldenCore_Input", v0_4);
            if(v1 == null) {
                continue;
            }

            v1.invoke(v0_4);
        }

        ArrayList v0_6 = new ArrayList();
        Iterator v5_1 = ((Iterable)v3).iterator();
        goto label_231;
    label_154:
        while(v0_5.hasNext()) {
            v7_1 = v0_5.next();
            Object v8_2 = ((Pair)v7_1).component1();
            Object v14_1 = ((Pair)v7_1).component2();
            v13_1 = ((ProfileControl)v12).getBindings().get(v8_2);
            if(v13_1 == null) {
                continue;
            }

            v3.add(GameProfileCompiler.toBinding$default(GameProfileCompiler.INSTANCE, ((ProfileControl)v12), ((InputBinding)v13_1), ((GameAction)v14_1), ControlBehavior.JOYSTICK, null, v17, 8, null));
        }

        if(!v17.getSprintEnabled()) {
            goto label_16;
        }

        v4.add(GameProfileCompiler.toBinding$default(GameProfileCompiler.INSTANCE, ((ProfileControl)v12), v17.getSprintBinding(), GameAction.JOYSTICK_SPRINT, ControlBehavior.JOYSTICK, null, v17, 8, null));
        goto label_16;
    label_231:
        while(v5_1.hasNext()) {
            v6_1 = v5_1.next();
            if(v6_1.getBehavior() != ControlBehavior.AIM) {
                continue;
            }

            ((Collection)v0_6).add(v6_1);
        }

        int v6_2 = 10;
        ArrayList v5_2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v0_6), v6_2));
        v0_5 = ((Iterable)v0_6).iterator();
        while(v0_5.hasNext()) {
            ((Collection)v5_2).add(v0_5.next().getInput());
        }

        Set v0_7 = CollectionsKt.toSet(((Iterable)v5_2));
        v5_2 = new ArrayList();
        Iterator v3_1 = ((Iterable)v3).iterator();
        while(v3_1.hasNext()) {
            v11_1 = v3_1.next();
            v12 = v11_1;
            if(((MappedControlBinding)v12).getAction() != GameAction.FIRE && !GameProfileCompiler.INSTANCE.isTapInputAllowed(((MappedControlBinding)v12).getInput())) {
                continue;
            }

            ((Collection)v5_2).add(v11_1);
        }

        v3 = new ArrayList();
        v5_1 = ((Iterable)v5_2).iterator();
        while(v5_1.hasNext()) {
            v11_1 = v5_1.next();
            v12 = v11_1;
            if(((MappedControlBinding)v12).getBehavior() != ControlBehavior.AIM && (v0_7.contains(((MappedControlBinding)v12).getInput()))) {
                continue;
            }

            ((Collection)v3).add(v11_1);
        }

        Function1 v0_8 = GameProfileCompiler.InputBindingKeySelector;
        HashSet v5_3 = new HashSet();
        ArrayList v11_3 = new ArrayList();
        v3_1 = ((Iterable)v3).iterator();
        while(v3_1.hasNext()) {
            v12 = v3_1.next();
            if(!v5_3.add(v0_8.invoke(v12))) {
                continue;
            }

            v11_3.add(v12);
        }

        v3 = new ArrayList();
        v0_5 = v11_3.iterator();
        while(v0_5.hasNext()) {
            v5_4 = v0_5.next();
            if(v5_4.getBehavior() != ControlBehavior.JOYSTICK) {
                continue;
            }

            ((Collection)v3).add(v5_4);
        }

        v0_6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v3), v6_2));
        v3_1 = ((Iterable)v3).iterator();
        while(v3_1.hasNext()) {
            ((Collection)v0_6).add(v3_1.next().getControlId());
        }

        v0_7 = CollectionsKt.toSet(((Iterable)v0_6));
        v3 = new ArrayList();
        Iterator v4_1 = ((Iterable)v4).iterator();
        while(v4_1.hasNext()) {
            v5_4 = v4_1.next();
            v6_1 = v5_4;
            if(!v0_7.contains(((MappedControlBinding)v6_1).getControlId())) {
                continue;
            }

            if(!GameProfileCompiler.INSTANCE.isTapInputAllowed(((MappedControlBinding)v6_1).getInput())) {
                continue;
            }

            ((Collection)v3).add(v5_4);
        }

        List v0_9 = CollectionsKt.plus(((Collection)v11_3), ((Iterable)v3));
        v3 = new ArrayList();
        v4_1 = ((Iterable)v0_9).iterator();
        while(v4_1.hasNext()) {
            v5_4 = v4_1.next();
            v6_1 = v5_4;
            if(((MappedControlBinding)v6_1).getBehavior() != ControlBehavior.MACRO) {
                v0_10 = true;
                goto label_380;
            }

            try {
                MacroValidationPolicy v0_11 = MacroValidationPolicy.INSTANCE;
                MacroProgram v11_4 = ((MappedControlBinding)v6_1).getMacro();
                Intrinsics.checkNotNull(v11_4);
                v0_11.requireContactBudget(v11_4.getPeakContacts());
                v0 = Result.constructor-impl(Unit.INSTANCE);
            }
            catch(Throwable v0_3) {
                v0 = Result.constructor-impl(ResultKt.createFailure(v0_3));
            }

            Throwable v11_5 = Result.exceptionOrNull-impl(v0);
            if(v11_5 != null) {
                String v6_3 = v2.getTargetPackage() + v9 + ((MappedControlBinding)v6_1).getControlId() + v8 + v11_5.getMessage();
                Log.e(v7, v6_3);
                if(v1 != null) {
                    v1.invoke(v6_3);
                }
            }

            v0_10 = Result.isSuccess-impl(v0);
        label_380:
            if(!v0_10) {
                continue;
            }

            ((Collection)v3).add(v5_4);
        }

        return ((List)v3);
    }

    public static List compile$default(GameProfileCompiler arg0, GameProfile arg1, Function1 arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = null;
        }

        return arg0.compile(arg1, arg2);
    }

    private final int defaultSize(String arg2) {
        String v1 = StringsKt.trim(((CharSequence)arg2)).toString().toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(v1, "toUpperCase(...)");
        int v2 = v1.hashCode();
        if(v2 != -1905230500) {
            if(v2 != 0xF6BB793C) {
                if(v2 != 82819) {
                    return 80;
                }
                else if(!v1.equals("TAP")) {
                    return 80;
                }
            }
            else if(!v1.equals("JOYSTICK")) {
                return 80;
            }
            else {
                return 0xA0;
            }
        }
        else if(!v1.equals("DISPARO")) {
            return 80;
        }

        return 110;
    }

    public final boolean isMacroInputAllowed(InputBinding arg2) {
        Intrinsics.checkNotNullParameter(arg2, "input");
        if(arg2.getSource() == InputBindingSource.MOUSE) {
            if(!Intrinsics.areEqual(arg2.getNormalizedCode(), "LEFT")) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public final boolean isTapInputAllowed(InputBinding arg2) {
        Intrinsics.checkNotNullParameter(arg2, "input");
        if(arg2.getSource() == InputBindingSource.MOUSE) {
            if(!Intrinsics.areEqual(arg2.getNormalizedCode(), "LEFT")) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public final boolean isVistaInputAllowed(InputBinding arg2) {
        Intrinsics.checkNotNullParameter(arg2, "input");
        if(arg2.getSource() == InputBindingSource.MOUSE) {
            if(!Intrinsics.areEqual(arg2.getNormalizedCode(), "LEFT")) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public final void requireMacroContactBudgets(GameProfile arg6, String arg7) {
        MacroDraft v0_2;
        Object v7;
        Intrinsics.checkNotNullParameter(arg6, "profile");
        List v5 = arg6.getControls();
        ArrayList v0 = new ArrayList();
        Iterator v5_1 = ((Iterable)v5).iterator();
        while(v5_1.hasNext()) {
            Object v1 = v5_1.next();
            Object v2 = v1;
            if(arg7 != null && !Intrinsics.areEqual(((ProfileControl)v2).getId(), arg7)) {
                continue;
            }

            ((Collection)v0).add(v1);
        }

        v5_1 = ((Iterable)v0).iterator();
        do {
        label_17:
            if(!v5_1.hasNext()) {
                return;
            }

            v7 = v5_1.next();
            ControlComponent v0_1 = ((ProfileControl)v7).getComponent();
            if((v0_1 instanceof MacroScriptComponent)) {
            }
            else {
                v0_1 = null;
            }

            if(v0_1 == null) {
                goto label_17;
            }

            v0_2 = ((MacroScriptComponent)v0_1).getMacro();
        }
        while(v0_2 == null);

        if(!StringsKt.isBlank(((ProfileControl)v7).getId())) {
            List v1_1 = arg6.getControls();
            int v3 = 0;
            if(!(v1_1 instanceof Collection) || !v1_1.isEmpty()) {
                Iterator v1_2 = ((Iterable)v1_1).iterator();
                goto label_40;
                return;
            label_40:
                while(v1_2.hasNext()) {
                    if(!Intrinsics.areEqual(v1_2.next().getId(), ((ProfileControl)v7).getId())) {
                        continue;
                    }

                    ++v3;
                    if(v3 >= 0) {
                        continue;
                    }

                    CollectionsKt.throwCountOverflow();
                }
            }
            else {
            }

            if(v3 != 1) {
                goto label_59;
            }

            MacroValidationPolicy.INSTANCE.requireContactBudget(MacroProgram.Companion.compile(v0_2).getPeakContacts());
            goto label_17;
        }

    label_59:
        throw new IllegalArgumentException("ID de Macro-Script vacío o repetido (" + ((ProfileControl)v7).getId() + ")".toString());
    }

    public static void requireMacroContactBudgets$default(GameProfileCompiler arg0, GameProfile arg1, String arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = null;
        }

        arg0.requireMacroContactBudgets(arg1, arg2);
    }

    private final MappedControlBinding toBinding(ProfileControl arg17, InputBinding arg18, GameAction arg19, ControlBehavior arg20, TapComponent arg21, JoystickComponent arg22) {
        GameProfileCompiler v0 = this;
        Integer v1 = Integer.valueOf(arg17.getWidth());
        Integer v3 = null;
        if(v1.intValue() > 0) {
        }
        else {
            v1 = v3;
        }

        int v1_1 = v1 != null ? v1.intValue() : v0.defaultSize(arg17.getType());
        Integer v2 = Integer.valueOf(arg17.getHeight());
        if(v2.intValue() > 0) {
            v3 = v2;
        }

        int v0_1 = v3 != null ? v3.intValue() : v0.defaultSize(arg17.getType());
        return new MappedControlBinding(arg18, arg19, arg20, arg17.getId(), arg17.getX(), arg17.getY(), ((float)v1_1), ((float)v0_1), arg21, arg22, null, 0x400, null);
    }

    static MappedControlBinding toBinding$default(GameProfileCompiler arg1, ProfileControl arg2, InputBinding arg3, GameAction arg4, ControlBehavior arg5, TapComponent arg6, JoystickComponent arg7, int arg8, Object arg9) {
        TapComponent v0 = null;
        if((arg8 & 8) != 0) {
            arg6 = v0;
        }

        if((arg8 & 16) != 0) {
            arg7 = ((JoystickComponent)v0);
        }

        return arg1.toBinding(arg2, arg3, arg4, arg5, arg6, arg7);
    }
}

