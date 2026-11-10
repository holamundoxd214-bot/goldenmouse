package androidx.compose.material3;

import androidx.compose.foundation.gestures.AnchoredDraggableDefaults;
import androidx.compose.foundation.gestures.AnchoredDraggableKt;
import androidx.compose.foundation.gestures.AnchoredDraggableState;
import androidx.compose.foundation.gestures.DraggableAnchorsConfig;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.material3.internal.DraggableAnchorsKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A<\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032#\b\u0002\u0010\u0004\u001A\u001D\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¢\u0006\u0002\u0010\n\u001AR\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\u0014\b\u0002\u0010\u000B\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f0\u00052#\b\u0002\u0010\u0004\u001A\u001D\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¢\u0006\u0002\u0010\r\u001A\u008F\u0001\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u00012\u001C\u0010\u0011\u001A\u0018\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000F0\u0005¢\u0006\u0002\b\u0013¢\u0006\u0002\b\u00142\b\b\u0002\u0010\u0015\u001A\u00020\u00162\b\b\u0002\u0010\u0017\u001A\u00020\f2\b\b\u0002\u0010\u0018\u001A\u00020\f2\b\b\u0002\u0010\u0019\u001A\u00020\f2\u0014\b\u0002\u0010\u001A\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000F0\u00052\u001C\u0010\u001B\u001A\u0018\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000F0\u0005¢\u0006\u0002\b\u0013¢\u0006\u0002\b\u0014H\u0007¢\u0006\u0002\u0010\u001C\u001Ay\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u00012\u001C\u0010\u0011\u001A\u0018\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000F0\u0005¢\u0006\u0002\b\u0013¢\u0006\u0002\b\u00142\b\b\u0002\u0010\u0015\u001A\u00020\u00162\b\b\u0002\u0010\u0017\u001A\u00020\f2\b\b\u0002\u0010\u0018\u001A\u00020\f2\b\b\u0002\u0010\u0019\u001A\u00020\f2\u001C\u0010\u001B\u001A\u0018\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000F0\u0005¢\u0006\u0002\b\u0013¢\u0006\u0002\b\u0014H\u0007¢\u0006\u0002\u0010\u001D\"\u0010\u0010\u001E\u001A\u00020\u001FX\u0082\u0004¢\u0006\u0004\n\u0002\u0010 ¨\u0006!"}, d2={"rememberSwipeToDismissBoxState", "Landroidx/compose/material3/SwipeToDismissBoxState;", "initialValue", "Landroidx/compose/material3/SwipeToDismissBoxValue;", "positionalThreshold", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "totalDistance", "(Landroidx/compose/material3/SwipeToDismissBoxValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SwipeToDismissBoxState;", "confirmValueChange", "", "(Landroidx/compose/material3/SwipeToDismissBoxValue;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SwipeToDismissBoxState;", "SwipeToDismissBox", "", "state", "backgroundContent", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "enableDismissFromStartToEnd", "enableDismissFromEndToStart", "gesturesEnabled", "onDismiss", "content", "(Landroidx/compose/material3/SwipeToDismissBoxState;Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;ZZZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/material3/SwipeToDismissBoxState;Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;ZZZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DismissVelocityThreshold", "Landroidx/compose/ui/unit/Dp;", "F", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SwipeToDismissBoxKt {
    private static final float DismissVelocityThreshold;

    static {
        SwipeToDismissBoxKt.DismissVelocityThreshold = Dp.constructor-impl(125f);
    }

    public static final void SwipeToDismissBox(SwipeToDismissBoxState arg29, Function3 arg30, Modifier arg31, boolean arg32, boolean arg33, boolean arg34, Function1 arg35, Function3 arg36, Composer arg37, int arg38, int arg39) {
        Function1 v7_9;
        boolean v6_4;
        Companion v3_1;
        SwipeToDismissBoxKt$SwipeToDismissBox$3$1 v7_8;
        boolean v5_2;
        SwipeToDismissBoxKt$$ExternalSyntheticLambda5 v12_3;
        TargetedFlingBehavior v11_1;
        boolean v31;
        SwipeToDismissBoxKt$$ExternalSyntheticLambda4 v6_2;
        boolean v4_1;
        Modifier v20_1;
        int v0_1;
        int v18;
        boolean v7;
        int v14;
        boolean v13;
        int v12;
        boolean v11;
        int v6;
        Modifier v5;
        int v4;
        int v3;
        SwipeToDismissBoxState v1 = arg29;
        Function3 v2 = arg30;
        Function3 v8 = arg36;
        int v9 = arg38;
        int v10 = arg39;
        Composer v15 = arg37.startRestartGroup(0xD3CDADDA);
        ComposerKt.sourceInformation(v15, "C(SwipeToDismissBox)N(state,backgroundContent,modifier,enableDismissFromStartToEnd,enableDismissFromEndToStart,gesturesEnabled,onDismiss,content)311@13044L2,314@13102L1524,350@14677L200,350@14631L246:SwipeToDismissBox.kt#uh7d8r");
        if((v10 & 1) != 0) {
            v3 = v9 | 6;
        }
        else if((v9 & 6) == 0) {
            v3 = v15.changedInstance(v1) ? 4 : 2;
            v3 |= v9;
        }
        else {
            v3 = v9;
        }

        if((v10 & 2) != 0) {
            v3 |= 0x30;
        }
        else if((v9 & 0x30) == 0) {
            v4 = v15.changedInstance(v2) ? 0x20 : 16;
            v3 |= v4;
        }

        v4 = v10 & 4;
        if(v4 != 0) {
            v3 |= 0x180;
            goto label_50;
        }
        else if((v9 & 0x180) == 0) {
            v5 = arg31;
            v6 = v15.changed(v5) ? 0x100 : 0x80;
            v3 |= v6;
        }
        else {
        label_50:
            v5 = arg31;
        }

        v6 = v10 & 8;
        if(v6 != 0) {
            v3 |= 0xC00;
            goto label_65;
        }
        else if((v9 & 0xC00) == 0) {
            v11 = arg32;
            v12 = v15.changed(v11) ? 0x800 : 0x400;
            v3 |= v12;
        }
        else {
        label_65:
            v11 = arg32;
        }

        v12 = v10 & 16;
        if(v12 != 0) {
            v3 |= 0x6000;
            goto label_80;
        }
        else if((v9 & 0x6000) == 0) {
            v13 = arg33;
            v14 = v15.changed(v13) ? 0x4000 : 0x2000;
            v3 |= v14;
        }
        else {
        label_80:
            v13 = arg33;
        }

        v14 = v10 & 0x20;
        int v16 = 0x30000;
        if(v14 != 0) {
            v3 |= v16;
            v7 = arg34;
        }
        else {
            v7 = arg34;
            if((v9 & v16) == 0) {
                v16 = v15.changed(v7) ? 0x20000 : 0x10000;
                v3 |= v16;
            }
        }

        v16 = v10 & 0x40;
        int v17 = 0x180000;
        if(v16 != 0) {
            v3 |= v17;
        }
        else {
            Function1 v0 = arg35;
            if((v9 & v17) == 0) {
                v18 = v15.changedInstance(v0) ? 0x100000 : 0x80000;
                v3 |= v18;
            }
        }

        if((v10 & 0x80) != 0) {
            v0_1 = 0xC00000;
            goto label_114;
        }
        else if((0xC00000 & v9) == 0) {
            if(v15.changedInstance(v8)) {
                v0_1 = 0x800000;
                goto label_114;
            }
            else {
                v0_1 = 0x400000;
            label_114:
                v3 |= v0_1;
            }
        }

        v18 = v4;
        int v19 = v14;
        boolean v0_2 = (0x492493 & v3) != 4793490 ? true : false;
        if(v15.shouldExecute(v0_2, v3 & 1)) {
            if(v18 != 0) {
                Companion v20 = Modifier.Companion;
            }
            else {
                v20_1 = v5;
            }

            v0_2 = v6 != 0 ? true : v11;
            v4_1 = v12 != 0 ? true : v13;
            if(v19 != 0) {
                v7 = true;
            }

            String v5_1 = "CC(remember):SwipeToDismissBox.kt#9igjgp";
            if(v16 != 0) {
                ComposerKt.sourceInformationMarkerStart(v15, 0x1719CA9C, v5_1);
                Object v6_1 = v15.rememberedValue();
                if(v6_1 == Composer.Companion.getEmpty()) {
                    v6_2 = new SwipeToDismissBoxKt$$ExternalSyntheticLambda4();
                    v15.updateRememberedValue(v6_2);
                }

                ComposerKt.sourceInformationMarkerEnd(v15);
            }
            else {
                Function1 v6_3 = arg35;
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xD3CDADDA, v3, -1, "androidx.compose.material3.SwipeToDismissBox (SwipeToDismissBox.kt:313)");
            }

            AnchoredDraggableState v21 = v1.getAnchoredDraggableState$material3();
            Orientation v22 = Orientation.Horizontal;
            boolean v23 = !v7 || v1.getSettledValue() != SwipeToDismissBoxValue.Settled ? false : true;
            if(v1.getUseFlingBehavior$material3()) {
                v15.startReplaceGroup(0x171A04B1);
                ComposerKt.sourceInformation(v15, "322@13503L183");
                v31 = v7;
                v7 = true;
                v11_1 = AnchoredDraggableDefaults.INSTANCE.flingBehavior(v1.getAnchoredDraggableState$material3(), v1.getPositionalThreshold$material3(), null, v15, AnchoredDraggableDefaults.$stable << 9, 4);
                v15.endReplaceGroup();
            }
            else {
                v31 = v7;
                v7 = true;
                v15.startReplaceGroup(0xCC29A5A3);
                v15.endReplaceGroup();
                v11_1 = null;
            }

            Modifier v11_2 = AnchoredDraggableKt.anchoredDraggable$default(v20_1, v21, v22, v23, null, null, v11_1, 24, null);
            ComposerKt.sourceInformationMarkerStart(v15, 0x2BB5B5D7, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy v12_1 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), v7);
            String v14_1 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart(v15, -1323940314, v14_1);
            v16 = ComposablesKt.getCurrentCompositeKeyHash(v15, 0);
            CompositionLocalMap v7_1 = v15.getCurrentCompositionLocalMap();
            v11_2 = ComposedModifierKt.materializeModifier(v15, v11_2);
            Function0 v13_1 = ComposeUiNode.Companion.getConstructor();
            String v10_1 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v15, 0xD6BD0031, v10_1);
            if(!(v15.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v15.startReusableNode();
            if(v15.getInserting()) {
                v15.createNode(v13_1);
            }
            else {
                v15.useNode();
            }

            Composer v9_1 = Updater.constructor-impl(v15);
            Updater.set-impl(v9_1, v12_1, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v9_1, v7_1, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v7_2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v9_1.getInserting()) || !Intrinsics.areEqual(v9_1.rememberedValue(), Integer.valueOf(v16))) {
                v9_1.updateRememberedValue(Integer.valueOf(v16));
                v9_1.apply(Integer.valueOf(v16), v7_2);
            }

            Updater.set-impl(v9_1, v11_2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v15, 0x800B7D29, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance v7_3 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(v15, -1704030332, "C330@13789L71,334@14026L583,331@13869L751:SwipeToDismissBox.kt#uh7d8r");
            Modifier v7_4 = ((BoxScope)v7_3).matchParentSize(Modifier.Companion);
            ComposerKt.sourceInformationMarkerStart(v15, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy v11_3 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), v15, 0);
            ComposerKt.sourceInformationMarkerStart(v15, -1323940314, v14_1);
            v12 = ComposablesKt.getCurrentCompositeKeyHash(v15, 0);
            CompositionLocalMap v13_2 = v15.getCurrentCompositionLocalMap();
            v7_4 = ComposedModifierKt.materializeModifier(v15, v7_4);
            v17 = v3 << 6 & 0x1C00;
            Function0 v9_2 = ComposeUiNode.Companion.getConstructor();
            int v34 = v12;
            ComposerKt.sourceInformationMarkerStart(v15, 0xD6BD0031, v10_1);
            if(!(v15.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v15.startReusableNode();
            if(v15.getInserting()) {
                v15.createNode(v9_2);
            }
            else {
                v15.useNode();
            }

            v9_1 = Updater.constructor-impl(v15);
            Updater.set-impl(v9_1, v11_3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v9_1, v13_2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v11_4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v9_1.getInserting()) || !Intrinsics.areEqual(v9_1.rememberedValue(), Integer.valueOf(v34))) {
                v9_1.updateRememberedValue(Integer.valueOf(v34));
                v9_1.apply(Integer.valueOf(v34), v11_4);
            }

            Updater.set-impl(v9_1, v7_4, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v15, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            v2.invoke(RowScopeInstance.INSTANCE, v15, Integer.valueOf(v17 >> 6 & 0x70 | 6));
            ComposerKt.sourceInformationMarkerEnd(v15);
            v15.endNode();
            ComposerKt.sourceInformationMarkerEnd(v15);
            ComposerKt.sourceInformationMarkerEnd(v15);
            ComposerKt.sourceInformationMarkerEnd(v15);
            Companion v7_5 = Modifier.Companion;
            AnchoredDraggableState v9_3 = v1.getAnchoredDraggableState$material3();
            Orientation v11_5 = Orientation.Horizontal;
            ComposerKt.sourceInformationMarkerStart(v15, -609150713, v5_1);
            v12 = (v3 & 0x1C00) == 0x800 ? 1 : 0;
            int v2_1 = (0xE000 & v3) == 0x4000 ? 1 : 0;
            v2_1 = v2_1 | v12 | v15.changedInstance(v1);
            Object v12_2 = v15.rememberedValue();
            if(v2_1 != 0 || v12_2 == Composer.Companion.getEmpty()) {
                v12_3 = new SwipeToDismissBoxKt$$ExternalSyntheticLambda5(v1, v0_2, v4_1);
                v15.updateRememberedValue(v12_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v15);
            Modifier v2_2 = DraggableAnchorsKt.draggableAnchorsV2(((Modifier)v7_5), v9_3, v11_5, ((Function2)v12_3));
            int v7_6 = v3 >> 12 & 0x1C00;
            ComposerKt.sourceInformationMarkerStart(v15, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy v9_4 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), v15, 0);
            ComposerKt.sourceInformationMarkerStart(v15, -1323940314, v14_1);
            int v11_6 = ComposablesKt.getCurrentCompositeKeyHash(v15, 0);
            CompositionLocalMap v12_4 = v15.getCurrentCompositionLocalMap();
            v2_2 = ComposedModifierKt.materializeModifier(v15, v2_2);
            Function0 v14_2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(v15, 0xD6BD0031, v10_1);
            if(!(v15.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v15.startReusableNode();
            if(v15.getInserting()) {
                v15.createNode(v14_2);
            }
            else {
                v15.useNode();
            }

            Composer v10_2 = Updater.constructor-impl(v15);
            Updater.set-impl(v10_2, v9_4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v10_2, v12_4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v9_5 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v10_2.getInserting()) || !Intrinsics.areEqual(v10_2.rememberedValue(), Integer.valueOf(v11_6))) {
                v10_2.updateRememberedValue(Integer.valueOf(v11_6));
                v10_2.apply(Integer.valueOf(v11_6), v9_5);
            }

            Updater.set-impl(v10_2, v2_2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v15, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            v8.invoke(RowScopeInstance.INSTANCE, v15, Integer.valueOf(v7_6 >> 6 & 0x70 | 6));
            ComposerKt.sourceInformationMarkerEnd(v15);
            v15.endNode();
            ComposerKt.sourceInformationMarkerEnd(v15);
            ComposerKt.sourceInformationMarkerEnd(v15);
            ComposerKt.sourceInformationMarkerEnd(v15);
            ComposerKt.sourceInformationMarkerEnd(v15);
            ComposerKt.sourceInformationMarkerEnd(v15);
            v15.endNode();
            ComposerKt.sourceInformationMarkerEnd(v15);
            ComposerKt.sourceInformationMarkerEnd(v15);
            ComposerKt.sourceInformationMarkerEnd(v15);
            SwipeToDismissBoxValue v2_3 = v1.getSettledValue();
            ComposerKt.sourceInformationMarkerStart(v15, 387618690, v5_1);
            v5_2 = v15.changedInstance(v1);
            v14 = (0x380000 & v3) == 0x100000 ? 1 : 0;
            Object v7_7 = v15.rememberedValue();
            if(((((int)v5_2)) | v14) != 0 || v7_7 == Composer.Companion.getEmpty()) {
                v7_8 = new SwipeToDismissBoxKt$SwipeToDismissBox$3$1(v1, ((Function1)v6_2), null);
                v15.updateRememberedValue(v7_8);
            }

            ComposerKt.sourceInformationMarkerEnd(v15);
            EffectsKt.LaunchedEffect(v2_3, v6_2, ((Function2)v7_8), v15, v3 >> 15 & 0x70);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v5_2 = v4_1;
            v7_7 = v6_2;
            v3_1 = ((Companion)v20_1);
            v6_4 = v31;
            v4_1 = v0_2;
        }
        else {
            v15.skipToGroupEnd();
            Modifier v3_2 = v5;
            v6_4 = v7;
            v4_1 = v11;
            v5_2 = v13;
            v7_9 = arg35;
        }

        ScopeUpdateScope v11_7 = v15.endRestartGroup();
        if(v11_7 != null) {
            v11_7.updateScope(new SwipeToDismissBoxKt$$ExternalSyntheticLambda6(v1, arg30, ((Modifier)v3_1), v4_1, v5_2, v6_4, v7_9, v8, arg38, arg39));
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compatibility. Use updated signature with onDismissed parameter.") public static final void SwipeToDismissBox(SwipeToDismissBoxState arg20, Function3 arg21, Modifier arg22, boolean arg23, boolean arg24, boolean arg25, Function3 arg26, Composer arg27, int arg28, int arg29) {
        boolean v5_1;
        boolean v4_1;
        Companion v3_1;
        Composer v17;
        SwipeToDismissBoxKt$$ExternalSyntheticLambda2 v0_3;
        Modifier v11_1;
        int v12;
        int v7;
        boolean v6;
        int v5;
        Modifier v4;
        int v3;
        Function3 v10;
        SwipeToDismissBoxState v9;
        int v2;
        int v8 = arg28;
        Composer v1 = arg27.startRestartGroup(-1807005299);
        ComposerKt.sourceInformation(v1, "C(SwipeToDismissBox)N(state,backgroundContent,modifier,enableDismissFromStartToEnd,enableDismissFromEndToStart,gesturesEnabled,content)388@16066L2,381@15751L351:SwipeToDismissBox.kt#uh7d8r");
        if((arg29 & 1) != 0) {
            v2 = v8 | 6;
            v9 = arg20;
        }
        else {
            v9 = arg20;
            if((v8 & 6) == 0) {
                v2 = v1.changedInstance(v9) ? 4 : 2;
                v2 |= v8;
            }
            else {
                v2 = v8;
            }
        }

        if((arg29 & 2) != 0) {
            v2 |= 0x30;
            v10 = arg21;
        }
        else {
            v10 = arg21;
            if((v8 & 0x30) == 0) {
                v3 = v1.changedInstance(v10) ? 0x20 : 16;
                v2 |= v3;
            }
        }

        v3 = arg29 & 4;
        if(v3 != 0) {
            v2 |= 0x180;
            goto label_50;
        }
        else if((v8 & 0x180) == 0) {
            v4 = arg22;
            v5 = v1.changed(v4) ? 0x100 : 0x80;
            v2 |= v5;
        }
        else {
        label_50:
            v4 = arg22;
        }

        v5 = arg29 & 8;
        if(v5 != 0) {
            v2 |= 0xC00;
            goto label_65;
        }
        else if((v8 & 0xC00) == 0) {
            v6 = arg23;
            v7 = v1.changed(v6) ? 0x800 : 0x400;
            v2 |= v7;
        }
        else {
        label_65:
            v6 = arg23;
        }

        v7 = arg29 & 16;
        if(v7 != 0) {
            v2 |= 0x6000;
        }
        else if((v8 & 0x6000) == 0) {
            v12 = v1.changed(arg24) ? 0x4000 : 0x2000;
            v2 |= v12;
        }

        v12 = arg29 & 0x20;
        int v13 = 0x30000;
        if(v12 != 0) {
            v2 |= v13;
        }
        else if((v13 & v8) == 0) {
            int v14 = v1.changed(arg25) ? 0x20000 : 0x10000;
            v2 |= v14;
        }

        int v15 = 0x180000;
        if((arg29 & 0x40) != 0) {
            v2 |= v15;
        }
        else if((v8 & v15) == 0) {
            int v16 = v1.changedInstance(arg26) ? 0x100000 : 0x80000;
            v2 |= v16;
        }

        int v27 = v15;
        boolean v0 = (v2 & 0x92493) != 0x92492 ? true : false;
        if(v1.shouldExecute(v0, v2 & 1)) {
            if(v3 != 0) {
                Companion v11 = Modifier.Companion;
            }
            else {
                v11_1 = v4;
            }

            int v0_1 = v12;
            boolean v12_1 = v5 != 0 ? true : v6;
            boolean v13_1 = v7 != 0 ? true : arg24;
            boolean v14_1 = v0_1 != 0 ? true : arg25;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1807005299, v2, -1, "androidx.compose.material3.SwipeToDismissBox (SwipeToDismissBox.kt:381)");
            }

            ComposerKt.sourceInformationMarkerStart(v1, 0xAE9F840F, "CC(remember):SwipeToDismissBox.kt#9igjgp");
            Object v0_2 = v1.rememberedValue();
            if(v0_2 == Composer.Companion.getEmpty()) {
                v0_3 = new SwipeToDismissBoxKt$$ExternalSyntheticLambda2();
                v1.updateRememberedValue(v0_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v1);
            v17 = v1;
            SwipeToDismissBoxKt.SwipeToDismissBox(v9, v10, v11_1, v12_1, v13_1, v14_1, v0_3, arg26, v17, v2 & 14 | v27 | v2 & 0x70 | v2 & 0x380 | v2 & 0x1C00 | 0xE000 & v2 | 0x70000 & v2 | v2 << 3 & 0x1C00000, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v3_1 = ((Companion)v11_1);
            v4_1 = v12_1;
            v5_1 = v13_1;
            v6 = v14_1;
        }
        else {
            v17 = v1;
            v17.skipToGroupEnd();
            v5_1 = arg24;
            Modifier v3_2 = v4;
            v4_1 = v6;
            v6 = arg25;
        }

        ScopeUpdateScope v10_1 = v17.endRestartGroup();
        if(v10_1 != null) {
            v10_1.updateScope(new SwipeToDismissBoxKt$$ExternalSyntheticLambda3(arg20, arg21, ((Modifier)v3_1), v4_1, v5_1, v6, arg26, v8, arg29));
        }
    }

    static final Pair SwipeToDismissBox$lambda$11$lambda$10$lambda$9(SwipeToDismissBoxState arg0, boolean arg1, boolean arg2, IntSize arg3, Constraints arg4) {
        return TuplesKt.to(AnchoredDraggableKt.DraggableAnchors(new SwipeToDismissBoxKt$$ExternalSyntheticLambda7(arg3, arg1, arg2)), arg0.getTargetValue());
    }

    static final Unit SwipeToDismissBox$lambda$11$lambda$10$lambda$9$lambda$8(IntSize arg2, boolean arg3, boolean arg4, DraggableAnchorsConfig arg5) {
        float v2 = ((float)(((int)(arg2.unbox-impl() >> 0x20))));
        arg5.at(SwipeToDismissBoxValue.Settled, 0f);
        if(arg3) {
            arg5.at(SwipeToDismissBoxValue.StartToEnd, v2);
        }

        if(arg4) {
            arg5.at(SwipeToDismissBoxValue.EndToStart, -v2);
        }

        return Unit.INSTANCE;
    }

    static final Unit SwipeToDismissBox$lambda$13(SwipeToDismissBoxState arg12, Function3 arg13, Modifier arg14, boolean arg15, boolean arg16, boolean arg17, Function1 arg18, Function3 arg19, int arg20, int arg21, Composer arg22, int arg23) {
        SwipeToDismissBoxKt.SwipeToDismissBox(arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg22, RecomposeScopeImplKt.updateChangedFlags(arg20 | 1), arg21);
        return Unit.INSTANCE;
    }

    static final Unit SwipeToDismissBox$lambda$15$lambda$14(SwipeToDismissBoxValue arg0) {
        return Unit.INSTANCE;
    }

    static final Unit SwipeToDismissBox$lambda$16(SwipeToDismissBoxState arg11, Function3 arg12, Modifier arg13, boolean arg14, boolean arg15, boolean arg16, Function3 arg17, int arg18, int arg19, Composer arg20, int arg21) {
        SwipeToDismissBoxKt.SwipeToDismissBox(arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg20, RecomposeScopeImplKt.updateChangedFlags(arg18 | 1), arg19);
        return Unit.INSTANCE;
    }

    static final Unit SwipeToDismissBox$lambda$7$lambda$6(SwipeToDismissBoxValue arg0) {
        return Unit.INSTANCE;
    }

    public static final float access$getDismissVelocityThreshold$p() {
        return SwipeToDismissBoxKt.DismissVelocityThreshold;
    }

    public static final SwipeToDismissBoxState rememberSwipeToDismissBoxState(SwipeToDismissBoxValue arg6, Function1 arg7, Composer arg8, int arg9, int arg10) {
        int v1 = 0xE3F3A1F4;
        ComposerKt.sourceInformationMarkerStart(arg8, v1, "C(rememberSwipeToDismissBoxState)N(initialValue,positionalThreshold)242@9960L19,246@10132L73,244@10020L185:SwipeToDismissBox.kt#uh7d8r");
        if((arg10 & 1) != 0) {
            arg6 = SwipeToDismissBoxValue.Settled;
        }

        int v0 = 6;
        if((arg10 & 2) != 0) {
            arg7 = SwipeToDismissBoxDefaults.INSTANCE.getPositionalThreshold(arg8, v0);
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg9, -1, "androidx.compose.material3.rememberSwipeToDismissBoxState (SwipeToDismissBox.kt:243)");
        }

        Object[] v1_1 = new Object[0];
        Saver v2 = SwipeToDismissBoxState.Companion.Saver(arg7);
        ComposerKt.sourceInformationMarkerStart(arg8, 0xB59325BD, "CC(remember):SwipeToDismissBox.kt#9igjgp");
        int v3 = 4;
        int v4 = 1;
        v0 = (v0 ^ arg9 & 14) > v3 && (arg8.changed(arg6.ordinal())) || (arg9 & 6) == v3 ? 1 : 0;
        int v5 = 0x20;
        if((arg9 & 0x70 ^ 0x30) <= v5 || !arg8.changed(arg7)) {
            if((arg9 & 0x30) == v5) {
            }
            else {
                v4 = 0;
            }
        }

        arg9 = v0 | v4;
        Object v0_1 = arg8.rememberedValue();
        if(arg9 != 0 || v0_1 == Composer.Companion.getEmpty()) {
            SwipeToDismissBoxKt$$ExternalSyntheticLambda8 v0_2 = new SwipeToDismissBoxKt$$ExternalSyntheticLambda8(arg6, arg7);
            arg8.updateRememberedValue(v0_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg8);
        Object v6 = RememberSaveableKt.rememberSaveable(v1_1, v2, ((Function0)v0_1), arg8, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg8);
        return ((SwipeToDismissBoxState)v6);
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="confirmValueChange is deprecated without replacement. Rather than relying on a callback to veto state changes, the anchor set should not include disallowed anchors. See androidx.compose.foundation.samples.AnchoredDraggableDynamicAnchorsSample for an example of using dynamic anchors over confirmValueChange.", replaceWith="<_subannotation>") public static final SwipeToDismissBoxState rememberSwipeToDismissBoxState(SwipeToDismissBoxValue arg7, Function1 arg8, Function1 arg9, Composer arg10, int arg11, int arg12) {
        SwipeToDismissBoxKt$$ExternalSyntheticLambda0 v8_1;
        int v1 = 0xF1513801;
        ComposerKt.sourceInformationMarkerStart(arg10, v1, "C(rememberSwipeToDismissBoxState)N(initialValue,confirmValueChange,positionalThreshold)270@11214L8,272@11317L19,274@11397L7,282@11663L102,275@11416L349:SwipeToDismissBox.kt#uh7d8r");
        if((arg12 & 1) != 0) {
            arg7 = SwipeToDismissBoxValue.Settled;
        }

        String v2 = "CC(remember):SwipeToDismissBox.kt#9igjgp";
        if((arg12 & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart(arg10, -505188695, v2);
            Object v8 = arg10.rememberedValue();
            if(v8 == Composer.Companion.getEmpty()) {
                v8_1 = new SwipeToDismissBoxKt$$ExternalSyntheticLambda0();
                arg10.updateRememberedValue(v8_1);
            }

            ComposerKt.sourceInformationMarkerEnd(arg10);
        }

        int v0 = 4;
        int v3 = 6;
        if((arg12 & v0) != 0) {
            arg9 = SwipeToDismissBoxDefaults.INSTANCE.getPositionalThreshold(arg10, v3);
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg11, -1, "androidx.compose.material3.rememberSwipeToDismissBoxState (SwipeToDismissBox.kt:273)");
        }

        ProvidableCompositionLocal v12 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(arg10, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v12_1 = arg10.consume(((CompositionLocal)v12));
        ComposerKt.sourceInformationMarkerEnd(arg10);
        Object[] v4 = new Object[0];
        Saver v5 = SwipeToDismissBoxState.Companion.Saver(((Function1)v8_1), arg9, ((Density)v12_1));
        ComposerKt.sourceInformationMarkerStart(arg10, -505174233, v2);
        int v2_1 = arg11 & 14 ^ v3;
        v3 = 1;
        v0 = v2_1 > v0 && (arg10.changed(arg7.ordinal())) || (arg11 & 6) == v0 ? 1 : 0;
        v0 |= arg10.changed(v12_1);
        int v6 = 0x20;
        v2_1 = (arg11 & 0x70 ^ 0x30) > v6 && (arg10.changed(v8_1)) || (arg11 & 0x30) == v6 ? 1 : 0;
        v0 |= v2_1;
        v6 = 0x100;
        if((arg11 & 0x380 ^ 0x180) <= v6 || !arg10.changed(arg9)) {
            if((arg11 & 0x180) == v6) {
            }
            else {
                v3 = 0;
            }
        }

        arg11 = v0 | v3;
        Object v0_1 = arg10.rememberedValue();
        if(arg11 != 0 || v0_1 == Composer.Companion.getEmpty()) {
            SwipeToDismissBoxKt$$ExternalSyntheticLambda1 v0_2 = new SwipeToDismissBoxKt$$ExternalSyntheticLambda1(arg7, ((Density)v12_1), ((Function1)v8_1), arg9);
            arg10.updateRememberedValue(v0_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg10);
        Object v7 = RememberSaveableKt.rememberSaveable(v4, v5, ((Function0)v0_1), arg10, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg10);
        return ((SwipeToDismissBoxState)v7);
    }

    static final SwipeToDismissBoxState rememberSwipeToDismissBoxState$lambda$1$lambda$0(SwipeToDismissBoxValue arg1, Function1 arg2) {
        return new SwipeToDismissBoxState(arg1, arg2);
    }

    static final boolean rememberSwipeToDismissBoxState$lambda$3$lambda$2(SwipeToDismissBoxValue arg0) {
        return 1;
    }

    static final SwipeToDismissBoxState rememberSwipeToDismissBoxState$lambda$5$lambda$4(SwipeToDismissBoxValue arg1, Density arg2, Function1 arg3, Function1 arg4) {
        return new SwipeToDismissBoxState(arg1, arg2, arg3, arg4);
    }
}

