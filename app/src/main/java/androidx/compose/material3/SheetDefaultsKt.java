package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000V\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001A$\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0011\u0010\u0003\u001A\r\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0005H\u0001¢\u0006\u0002\u0010\u0006\u001A;\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2!\u0010\r\u001A\u001D\u0012\u0013\u0012\u00110\u000F¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00010\u000EH\u0000\u001AW\u0010\u0013\u001A\u00020\n2\b\b\u0002\u0010\u0014\u001A\u00020\u00152\u0014\b\u0002\u0010\u0016\u001A\u000E\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00150\u000E2\b\b\u0002\u0010\u0018\u001A\u00020\u00172\b\b\u0002\u0010\u0019\u001A\u00020\u00152\b\b\u0002\u0010\u001A\u001A\u00020\u001B2\b\b\u0002\u0010\u001C\u001A\u00020\u001BH\u0001¢\u0006\u0004\b\u001D\u0010\u001E\"\u0010\u0010\u001F\u001A\u00020\u001BX\u0082\u0004¢\u0006\u0004\n\u0002\u0010 \"\u0014\u0010!\u001A\b\u0012\u0004\u0012\u00020\u000F0\"X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2={"DragHandleWithTooltip", "", "Landroidx/compose/foundation/layout/ColumnScope;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/layout/ColumnScope;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "sheetState", "Landroidx/compose/material3/SheetState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "onFling", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "velocity", "rememberSheetState", "skipPartiallyExpanded", "", "confirmValueChange", "Landroidx/compose/material3/SheetValue;", "initialValue", "skipHiddenState", "positionalThreshold", "Landroidx/compose/ui/unit/Dp;", "velocityThreshold", "rememberSheetState-AGcomas", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/material3/SheetValue;ZFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SheetState;", "DragHandleVerticalPadding", "F", "BottomSheetAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SheetDefaultsKt {
    private static final AnimationSpec BottomSheetAnimationSpec;
    private static final float DragHandleVerticalPadding;

    static {
        SheetDefaultsKt.DragHandleVerticalPadding = Dp.constructor-impl(22f);
        SheetDefaultsKt.BottomSheetAnimationSpec = AnimationSpecKt.tween$default(300, 0, EasingKt.getFastOutSlowInEasing(), 2, null);
    }

    public static final NestedScrollConnection ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(SheetState arg1, Orientation arg2, Function1 arg3) {
        return new SheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1(arg1, arg3, arg2);
    }

    public static final void DragHandleWithTooltip(ColumnScope arg14, Function2 arg15, Composer arg16, int arg17) {
        int v2;
        int v0 = arg17;
        int v1 = 1033612924;
        Composer v5 = arg16.startRestartGroup(v1);
        ComposerKt.sourceInformation(v5, "C(DragHandleWithTooltip)N(content)433@17991L51,435@18147L349:SheetDefaults.kt#uh7d8r");
        if((v0 & 6) == 0) {
            v2 = v5.changed(arg14) ? 4 : 2;
            v2 |= v0;
        }
        else {
            v2 = v0;
        }

        if((v0 & 0x30) == 0) {
            int v3 = v5.changedInstance(arg15) ? 0x20 : 16;
            v2 |= v3;
        }

        int v8 = v2;
        boolean v2_1 = (v8 & 19) != 18 ? true : false;
        if(v5.shouldExecute(v2_1, v8 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v1, v8, -1, "androidx.compose.material3.DragHandleWithTooltip (SheetDefaults.kt:432)");
            }

            String v1_1 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(string.m3c_bottom_sheet_drag_handle_description), v5, 0);
            Modifier v2_2 = arg14.align(Modifier.Companion, Alignment.Companion.getCenterHorizontally());
            ComposerKt.sourceInformationMarkerStart(v5, 0x2BB5B5D7, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy v3_1 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(v5, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int v4 = ComposablesKt.getCurrentCompositeKeyHash(v5, 0);
            CompositionLocalMap v6 = v5.getCurrentCompositionLocalMap();
            v2_2 = ComposedModifierKt.materializeModifier(v5, v2_2);
            Function0 v7 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(v5, 0xD6BD0031, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if(!(v5.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v5.startReusableNode();
            if(v5.getInserting()) {
                v5.createNode(v7);
            }
            else {
                v5.useNode();
            }

            Composer v7_1 = Updater.constructor-impl(v5);
            Updater.set-impl(v7_1, v3_1, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v7_1, v6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v3_2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v7_1.getInserting()) || !Intrinsics.areEqual(v7_1.rememberedValue(), Integer.valueOf(v4))) {
                v7_1.updateRememberedValue(Integer.valueOf(v4));
                v7_1.apply(Integer.valueOf(v4), v3_2);
            }

            Updater.set-impl(v7_1, v2_2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v5, 0x800B7D29, "C72@3468L9:Box.kt#2w3rfo");
            ComposerKt.sourceInformationMarkerStart(v5, 0x2E10E2FC, "C438@18272L60,439@18356L48,440@18426L22,436@18197L293:SheetDefaults.kt#uh7d8r");
            TooltipKt.TooltipBox(TooltipDefaults.INSTANCE.rememberTooltipPositionProvider-Hu5FAss(TooltipAnchorPosition.Companion.getAbove-lOKsHw4(), 0f, v5, 390, 2), ComposableLambdaKt.rememberComposableLambda(2059851063, true, new SheetDefaultsKt$DragHandleWithTooltip$1$1(v1_1), v5, 54), TooltipKt.rememberTooltipState(false, false, null, v5, 0, 7), null, null, false, false, false, arg15, v5, v8 << 21 & 0xE000000 | 0x30, 0xF8);
            v5 = v5;
            ComposerKt.sourceInformationMarkerEnd(v5);
            ComposerKt.sourceInformationMarkerEnd(v5);
            v5.endNode();
            ComposerKt.sourceInformationMarkerEnd(v5);
            ComposerKt.sourceInformationMarkerEnd(v5);
            ComposerKt.sourceInformationMarkerEnd(v5);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_150;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v5.skipToGroupEnd();
        }

    label_150:
        ScopeUpdateScope v1_2 = v5.endRestartGroup();
        if(v1_2 != null) {
            v1_2.updateScope(new SheetDefaultsKt$$ExternalSyntheticLambda4(arg14, arg15, v0));
        }
    }

    static final Unit DragHandleWithTooltip$lambda$1(ColumnScope arg0, Function2 arg1, int arg2, Composer arg3, int arg4) {
        SheetDefaultsKt.DragHandleWithTooltip(arg0, arg1, arg3, RecomposeScopeImplKt.updateChangedFlags(arg2 | 1));
        return Unit.INSTANCE;
    }

    public static final AnimationSpec access$getBottomSheetAnimationSpec$p() {
        return SheetDefaultsKt.BottomSheetAnimationSpec;
    }

    public static final float access$getDragHandleVerticalPadding$p() {
        return SheetDefaultsKt.DragHandleVerticalPadding;
    }

    public static final SheetState rememberSheetState-AGcomas(boolean arg16, Function1 arg17, SheetValue arg18, boolean arg19, float arg20, float arg21, Composer arg22, int arg23, int arg24) {
        SheetDefaultsKt$$ExternalSyntheticLambda2 v12_3;
        Object v10;
        Composer v0 = arg22;
        int v1 = arg23;
        int v3 = -20307384;
        ComposerKt.sourceInformationMarkerStart(v0, v3, "C(rememberSheetState)N(skipPartiallyExpanded,confirmValueChange,initialValue,skipHiddenState,positionalThreshold:c#ui.unit.Dp,velocityThreshold:c#ui.unit.Dp)509@20940L8,515@21212L7,516@21254L48,517@21335L46,530@21855L231,518@21393L693:SheetDefaults.kt#uh7d8r");
        boolean v6 = (arg24 & 1) != 0 ? false : arg16;
        String v5 = "CC(remember):SheetDefaults.kt#9igjgp";
        if((arg24 & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart(v0, 0x74CAC4F0, v5);
            Object v2 = v0.rememberedValue();
            if(v2 == Composer.Companion.getEmpty()) {
                SheetDefaultsKt$$ExternalSyntheticLambda0 v2_1 = new SheetDefaultsKt$$ExternalSyntheticLambda0();
                v0.updateRememberedValue(v2_1);
            }

            ComposerKt.sourceInformationMarkerEnd(v0);
            v10 = v2;
        }
        else {
            Function1 v10_1 = arg17;
        }

        SheetValue v9 = (arg24 & 4) != 0 ? SheetValue.Hidden : arg18;
        boolean v11 = (arg24 & 8) != 0 ? false : arg19;
        float v2_2 = (arg24 & 16) != 0 ? BottomSheetDefaults.INSTANCE.getPositionalThreshold-D9Ej5fM$material3() : arg20;
        int v7 = 0x20;
        float v8 = (arg24 & 0x20) != 0 ? BottomSheetDefaults.INSTANCE.getVelocityThreshold-D9Ej5fM$material3() : arg21;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v3, v1, -1, "androidx.compose.material3.rememberSheetState (SheetDefaults.kt:514)");
        }

        ProvidableCompositionLocal v3_1 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(v0, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v3_2 = v0.consume(((CompositionLocal)v3_1));
        ComposerKt.sourceInformationMarkerEnd(v0);
        ComposerKt.sourceInformationMarkerStart(v0, 0x74CAEC58, v5);
        boolean v12 = v0.changed(v3_2);
        int v14 = 0x4000;
        int v15 = 1;
        int v13 = (0xE000 & v1 ^ 0x6000) > v14 && (v0.changed(v2_2)) || (v1 & 0x6000) == v14 ? 1 : 0;
        int v12_1 = (((int)v12)) | v13;
        Object v13_1 = v0.rememberedValue();
        if(v12_1 != 0 || v13_1 == Composer.Companion.getEmpty()) {
            SheetDefaultsKt$$ExternalSyntheticLambda1 v13_2 = new SheetDefaultsKt$$ExternalSyntheticLambda1(((Density)v3_2), v2_2);
            v0.updateRememberedValue(v13_2);
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        ComposerKt.sourceInformationMarkerStart(v0, 0x74CAF676, v5);
        boolean v2_3 = v0.changed(v3_2);
        int v16 = 0x30000;
        v14 = 0x20000;
        v12_1 = (0x70000 & v1 ^ 0x30000) > v14 && (v0.changed(v8)) || (v1 & v16) == v14 ? 1 : 0;
        int v2_4 = (((int)v2_3)) | v12_1;
        Object v12_2 = v0.rememberedValue();
        if(v2_4 != 0 || v12_2 == Composer.Companion.getEmpty()) {
            v12_3 = new SheetDefaultsKt$$ExternalSyntheticLambda2(((Density)v3_2), v8);
            v0.updateRememberedValue(v12_3);
        }

        Object v8_1 = v12_3;
        ComposerKt.sourceInformationMarkerEnd(v0);
        Object[] v2_5 = new Object[]{Boolean.valueOf(v6), v10, Boolean.valueOf(v11)};
        Saver v3_3 = SheetState.Companion.Saver(v6, v13_1, v8_1, v10, v11);
        ComposerKt.sourceInformationMarkerStart(v0, 0x74CB382F, v5);
        v12_1 = 4;
        int v5_1 = (v1 & 14 ^ 6) > v12_1 && (v0.changed(v6)) || (v1 & 6) == v12_1 ? 1 : 0;
        v5_1 = v5_1 | v0.changed(v13_1) | v0.changed(v8_1);
        v14 = 0x100;
        v12_1 = (v1 & 0x380 ^ 0x180) > v14 && (v0.changed(v9.ordinal())) || (v1 & 0x180) == v14 ? 1 : 0;
        v5_1 |= v12_1;
        v7 = (v1 & 0x70 ^ 0x30) > v7 && (v0.changed(v10)) || (v1 & 0x30) == v7 ? 1 : 0;
        v5_1 |= v7;
        v12_1 = 0x800;
        if((v1 & 0x1C00 ^ 0xC00) <= v12_1 || !v0.changed(v11)) {
            if((v1 & 0xC00) == v12_1) {
            }
            else {
                v15 = 0;
            }
        }

        v1 = v5_1 | v15;
        Object v5_2 = v0.rememberedValue();
        if(v1 != 0 || v5_2 == Composer.Companion.getEmpty()) {
            SheetDefaultsKt$$ExternalSyntheticLambda3 v5_3 = new SheetDefaultsKt$$ExternalSyntheticLambda3(v6, v13_1, ((Function0)v8_1), v9, ((Function1)v10), v11);
            v0.updateRememberedValue(v5_3);
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        Object v1_1 = RememberSaveableKt.rememberSaveable(v2_5, v3_3, ((Function0)v5_2), v0, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return ((SheetState)v1_1);
    }

    static final SheetState rememberSheetState_AGcomas$lambda$11$lambda$10(boolean arg7, Function0 arg8, Function0 arg9, SheetValue arg10, Function1 arg11, boolean arg12) {
        return new SheetState(arg7, arg8, arg9, arg10, arg11, arg12);
    }

    static final boolean rememberSheetState_AGcomas$lambda$3$lambda$2(SheetValue arg0) {
        return 1;
    }

    static final float rememberSheetState_AGcomas$lambda$6$lambda$5(Density arg0, float arg1) {
        return arg0.toPx-0680j_4(arg1);
    }

    static final float rememberSheetState_AGcomas$lambda$9$lambda$8(Density arg0, float arg1) {
        return arg0.toPx-0680j_4(arg1);
    }
}

