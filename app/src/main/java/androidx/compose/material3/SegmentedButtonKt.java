package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement$Horizontal;
import androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.OutlinedSegmentedButtonTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment$Vertical;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000x\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\u001A\u009B\u0001\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0012\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00062\u0006\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\u00042\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u00112\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u00132\u0013\b\u0002\u0010\u0014\u001A\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u00162\u0011\u0010\u0017\u001A\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u0018\u001A\u0095\u0001\u0010\u0000\u001A\u00020\u0001*\u00020\u00192\u0006\u0010\u001A\u001A\u00020\u00042\f\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u00010\u00152\u0006\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\u00042\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u00112\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u00132\u0013\b\u0002\u0010\u0014\u001A\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u00162\u0011\u0010\u0017\u001A\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u001C\u001A\u0091\u0001\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0012\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00062\u0006\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\u00042\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u00132\u0013\b\u0002\u0010\u0014\u001A\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u00162\u0011\u0010\u0017\u001A\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u001D\u001A\u008B\u0001\u0010\u0000\u001A\u00020\u0001*\u00020\u00192\u0006\u0010\u001A\u001A\u00020\u00042\f\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u00010\u00152\u0006\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\u00042\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u00132\u0013\b\u0002\u0010\u0014\u001A\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u00162\u0011\u0010\u0017\u001A\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u001E\u001AA\u0010\u001F\u001A\u00020\u00012\b\b\u0002\u0010\t\u001A\u00020\n2\b\b\u0002\u0010 \u001A\u00020!2\u001C\u0010\"\u001A\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0016¢\u0006\u0002\b#H\u0007¢\u0006\u0004\b$\u0010%\u001AA\u0010&\u001A\u00020\u00012\b\b\u0002\u0010\t\u001A\u00020\n2\b\b\u0002\u0010 \u001A\u00020!2\u001C\u0010\"\u001A\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0016¢\u0006\u0002\b#H\u0007¢\u0006\u0004\b\'\u0010%\u001A;\u0010(\u001A\u00020\u00012\u0011\u0010\u0014\u001A\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u00162\u0011\u0010\"\u001A\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u00162\u0006\u0010\u0010\u001A\u00020\u0011H\u0003¢\u0006\u0002\u0010)\u001A\u0017\u0010*\u001A\b\u0012\u0004\u0012\u00020,0+*\u00020-H\u0003¢\u0006\u0002\u0010.\u001A\"\u0010/\u001A\u00020\n*\u00020\n2\u0006\u0010\u0003\u001A\u00020\u00042\f\u00100\u001A\b\u0012\u0004\u0012\u00020,0+H\u0002\"\u000E\u00101\u001A\u000202X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u00103\u001A\u00020!X\u0082\u0004¢\u0006\u0004\n\u0002\u00104¨\u00065"}, d2={"SegmentedButton", "", "Landroidx/compose/material3/MultiChoiceSegmentedButtonRowScope;", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "shape", "Landroidx/compose/ui/graphics/Shape;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "colors", "Landroidx/compose/material3/SegmentedButtonColors;", "border", "Landroidx/compose/foundation/BorderStroke;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "icon", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "label", "(Landroidx/compose/material3/MultiChoiceSegmentedButtonRowScope;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SegmentedButtonColors;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "Landroidx/compose/material3/SingleChoiceSegmentedButtonRowScope;", "selected", "onClick", "(Landroidx/compose/material3/SingleChoiceSegmentedButtonRowScope;ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SegmentedButtonColors;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "(Landroidx/compose/material3/MultiChoiceSegmentedButtonRowScope;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SegmentedButtonColors;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "(Landroidx/compose/material3/SingleChoiceSegmentedButtonRowScope;ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SegmentedButtonColors;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "SingleChoiceSegmentedButtonRow", "space", "Landroidx/compose/ui/unit/Dp;", "content", "Lkotlin/ExtensionFunctionType;", "SingleChoiceSegmentedButtonRow-uFdPcIQ", "(Landroidx/compose/ui/Modifier;FLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "MultiChoiceSegmentedButtonRow", "MultiChoiceSegmentedButtonRow-uFdPcIQ", "SegmentedButtonContent", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)V", "interactionCountAsState", "Landroidx/compose/runtime/State;", "", "Landroidx/compose/foundation/interaction/InteractionSource;", "(Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "interactionZIndex", "interactionCount", "CheckedZIndexFactor", "", "IconSpacing", "F", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SegmentedButtonKt {
    private static final float CheckedZIndexFactor = 5f;
    private static final float IconSpacing;

    static {
        SegmentedButtonKt.IconSpacing = Dp.constructor-impl(8f);
    }

    public static final void MultiChoiceSegmentedButtonRow-uFdPcIQ(Modifier arg8, float arg9, Function3 arg10, Composer arg11, int arg12, int arg13) {
        Companion v8;
        int v4;
        int v2;
        int v0 = 0x6DF527BE;
        arg11 = arg11.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg11, "C(MultiChoiceSegmentedButtonRow)N(modifier,space:c#ui.unit.Dp,content)368@16414L412:SegmentedButton.kt#uh7d8r");
        int v1 = arg13 & 1;
        if(v1 != 0) {
            v2 = arg12 | 6;
        }
        else if((arg12 & 6) == 0) {
            v2 = arg11.changed(arg8) ? 4 : 2;
            v2 |= arg12;
        }
        else {
            v2 = arg12;
        }

        int v3 = arg13 & 2;
        if(v3 != 0) {
            v2 |= 0x30;
        }
        else if((arg12 & 0x30) == 0) {
            v4 = arg11.changed(arg9) ? 0x20 : 16;
            v2 |= v4;
        }

        if((arg13 & 4) != 0) {
            v2 |= 0x180;
        }
        else if((arg12 & 0x180) == 0) {
            v4 = arg11.changedInstance(arg10) ? 0x100 : 0x80;
            v2 |= v4;
        }

        boolean v4_1 = (v2 & 0x93) != 0x92 ? true : false;
        if(arg11.shouldExecute(v4_1, v2 & 1)) {
            if(v1 != 0) {
                v8 = Modifier.Companion;
            }

            if(v3 != 0) {
                arg9 = SegmentedButtonDefaults.INSTANCE.getBorderWidth-D9Ej5fM();
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v2, -1, "androidx.compose.material3.MultiChoiceSegmentedButtonRow (SegmentedButton.kt:367)");
            }

            Modifier v0_1 = IntrinsicKt.width(SizeKt.defaultMinSize-VpY3zN4$default(((Modifier)v8), 0f, OutlinedSegmentedButtonTokens.INSTANCE.getContainerHeight-D9Ej5fM(), 1, null), IntrinsicSize.Min);
            HorizontalOrVertical v1_1 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(-arg9));
            Vertical v3_1 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(arg11, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy v1_2 = RowKt.rowMeasurePolicy(((Horizontal)v1_1), v3_1, arg11, 0x30);
            ComposerKt.sourceInformationMarkerStart(arg11, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            v3 = ComposablesKt.getCurrentCompositeKeyHash(arg11, 0);
            CompositionLocalMap v4_2 = arg11.getCurrentCompositionLocalMap();
            v0_1 = ComposedModifierKt.materializeModifier(arg11, v0_1);
            Function0 v5 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(arg11, 0xD6BD0031, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if(!(arg11.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            arg11.startReusableNode();
            if(arg11.getInserting()) {
                arg11.createNode(v5);
            }
            else {
                arg11.useNode();
            }

            Composer v5_1 = Updater.constructor-impl(arg11);
            Updater.set-impl(v5_1, v1_2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v5_1, v4_2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v1_3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v5_1.getInserting()) || !Intrinsics.areEqual(v5_1.rememberedValue(), Integer.valueOf(v3))) {
                v5_1.updateRememberedValue(Integer.valueOf(v3));
                v5_1.apply(Integer.valueOf(v3), v1_3);
            }

            Updater.set-impl(v5_1, v0_1, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(arg11, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance v0_2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(arg11, 714807460, "C376@16739L57,377@16811L9:SegmentedButton.kt#uh7d8r");
            ComposerKt.sourceInformationMarkerStart(arg11, 0x7D3ED09B, "CC(remember):SegmentedButton.kt#9igjgp");
            Object v1_4 = arg11.rememberedValue();
            if(v1_4 == Composer.Companion.getEmpty()) {
                MultiChoiceSegmentedButtonScopeWrapper v1_5 = new MultiChoiceSegmentedButtonScopeWrapper(((RowScope)v0_2));
                arg11.updateRememberedValue(v1_5);
            }

            ComposerKt.sourceInformationMarkerEnd(arg11);
            arg10.invoke(v1_4, arg11, Integer.valueOf(v2 >> 3 & 0x70 | 6));
            ComposerKt.sourceInformationMarkerEnd(arg11);
            ComposerKt.sourceInformationMarkerEnd(arg11);
            arg11.endNode();
            ComposerKt.sourceInformationMarkerEnd(arg11);
            ComposerKt.sourceInformationMarkerEnd(arg11);
            ComposerKt.sourceInformationMarkerEnd(arg11);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_158;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg11.skipToGroupEnd();
        }

    label_158:
        Modifier v2_1 = ((Modifier)v8);
        float v3_2 = arg9;
        ScopeUpdateScope v8_1 = arg11.endRestartGroup();
        if(v8_1 != null) {
            v8_1.updateScope(new SegmentedButtonKt$$ExternalSyntheticLambda3(v2_1, v3_2, arg10, arg12, arg13));
        }
    }

    static final Unit MultiChoiceSegmentedButtonRow_uFdPcIQ$lambda$13(Modifier arg6, float arg7, Function3 arg8, int arg9, int arg10, Composer arg11, int arg12) {
        SegmentedButtonKt.MultiChoiceSegmentedButtonRow-uFdPcIQ(arg6, arg7, arg8, arg11, RecomposeScopeImplKt.updateChangedFlags(arg9 | 1), arg10);
        return Unit.INSTANCE;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="kept for binary compatibility") public static final void SegmentedButton(MultiChoiceSegmentedButtonRowScope arg27, boolean arg28, Function1 arg29, Shape arg30, Modifier arg31, boolean arg32, SegmentedButtonColors arg33, BorderStroke arg34, MutableInteractionSource arg35, Function2 arg36, Function2 arg37, Composer arg38, int arg39, int arg40, int arg41) {
        Modifier v5_2;
        boolean v6_2;
        SegmentedButtonColors v7_2;
        BorderStroke v8_2;
        SegmentedButtonColors v6_1;
        Modifier v4;
        MutableInteractionSource v9_1;
        Function2 v10_1;
        Companion v4_1;
        SegmentedButtonColors v10_2;
        Modifier v2_3;
        int v20;
        int v19;
        MutableInteractionSource v6;
        BorderStroke v5;
        int v16;
        SegmentedButtonColors v15_1;
        boolean v14_1;
        int v13;
        Modifier v11;
        int v10;
        Function1 v8_1;
        int v7;
        boolean v1 = arg28;
        int v0 = arg39;
        int v2 = arg41;
        Composer v12 = arg38.startRestartGroup(2065856961);
        ComposerKt.sourceInformation(v12, "C(SegmentedButton)N(checked,onCheckedChange,shape,modifier,enabled,colors,border,interactionSource,icon,label)267@12589L377:SegmentedButton.kt#uh7d8r");
        if((0x80000000 & v2) != 0) {
            v7 = v0 | 6;
        }
        else if((v0 & 6) == 0) {
            v7 = v12.changed(arg27) ? 4 : 2;
            v7 |= v0;
        }
        else {
            v7 = v0;
        }

        if((v2 & 1) != 0) {
            v7 |= 0x30;
        }
        else if((v0 & 0x30) == 0) {
            int v8 = v12.changed(v1) ? 0x20 : 16;
            v7 |= v8;
        }

        if((v2 & 2) != 0) {
            v7 |= 0x180;
            goto label_53;
        }
        else if((v0 & 0x180) == 0) {
            v8_1 = arg29;
            int v9 = v12.changedInstance(v8_1) ? 0x100 : 0x80;
            v7 |= v9;
        }
        else {
        label_53:
            v8_1 = arg29;
        }

        if((v2 & 4) != 0) {
            v7 |= 0xC00;
        }
        else if((v0 & 0xC00) == 0) {
            v10 = v12.changed(arg30) ? 0x800 : 0x400;
            v7 |= v10;
        }

        v10 = v2 & 8;
        if(v10 != 0) {
            v7 |= 0x6000;
            goto label_83;
        }
        else if((v0 & 0x6000) == 0) {
            v11 = arg31;
            v13 = v12.changed(v11) ? 0x4000 : 0x2000;
            v7 |= v13;
        }
        else {
        label_83:
            v11 = arg31;
        }

        v13 = v2 & 16;
        int v14 = 0x30000;
        if(v13 != 0) {
            v7 |= v14;
            goto label_99;
        }
        else if((v14 & v0) == 0) {
            v14_1 = arg32;
            int v15 = v12.changed(v14_1) ? 0x20000 : 0x10000;
            v7 |= v15;
        }
        else {
        label_99:
            v14_1 = arg32;
        }

        if((0x180000 & v0) == 0) {
            if((v2 & 0x20) == 0) {
                v15_1 = arg33;
                if(v12.changed(v15_1)) {
                    v16 = 0x100000;
                }
                else {
                    goto label_111;
                }
            }
            else {
                v15_1 = arg33;
            label_111:
                v16 = 0x80000;
            }

            v7 |= v16;
        }
        else {
            v15_1 = arg33;
        }

        if((v0 & 0xC00000) == 0) {
            v5 = arg34;
            v16 = (v2 & 0x40) != 0 || !v12.changed(v5) ? 0x400000 : 0x800000;
            v7 |= v16;
        }
        else {
            v5 = arg34;
        }

        int v3 = v2 & 0x80;
        int v17 = 0x6000000;
        if(v3 != 0) {
            v7 |= v17;
            v6 = arg35;
        }
        else {
            v6 = arg35;
            if((v0 & v17) == 0) {
                v19 = v12.changed(v6) ? 0x4000000 : 0x2000000;
                v7 |= v19;
            }
        }

        v0 = v2 & 0x100;
        v19 = 0x30000000;
        if(v0 != 0) {
            v7 |= v19;
            goto label_160;
        }
        else if((arg39 & v19) == 0) {
            v19 = v0;
            v20 = v12.changedInstance(arg36) ? 0x20000000 : 0x10000000;
            v7 |= v20;
        }
        else {
        label_160:
            v19 = v0;
        }

        if((v2 & 0x200) != 0) {
            v0 = arg40 | 6;
        }
        else if((arg40 & 6) == 0) {
            v20 = v12.changedInstance(arg37) ? 4 : 2;
            v0 = arg40 | v20;
        }
        else {
            v0 = arg40;
        }

        v20 = v3;
        boolean v2_1 = (v7 & 306783379) != 306783378 || (v0 & 3) != 2 ? true : false;
        if(v12.shouldExecute(v2_1, v7 & 1)) {
            v12.startDefaults();
            ComposerKt.sourceInformation(v12, "260@12290L8,264@12503L41");
            v3 = 0xFE3FFFFF;
            int v18 = 0xFFC7FFFF;
            if((arg39 & 1) == 0 || (v12.getDefaultsInvalid())) {
                if(v10 != 0) {
                    Companion v2_2 = Modifier.Companion;
                }
                else {
                    v2_3 = v11;
                }

                if(v13 != 0) {
                    v14_1 = true;
                }

                if((arg41 & 0x20) != 0) {
                    v10_2 = SegmentedButtonDefaults.INSTANCE.colors(v12, 6);
                    v7 &= v18;
                }
                else {
                    v10_2 = v15_1;
                }

                if((arg41 & 0x40) != 0) {
                    v5 = SegmentedButtonDefaults.borderStroke-l07J4OM$default(SegmentedButtonDefaults.INSTANCE, v10_2.borderColor-WaAFU9c$material3(v14_1, v1), 0f, 2, null);
                    v7 &= v3;
                }

                MutableInteractionSource v3_1 = v20 != 0 ? null : v6;
                if(v19 != 0) {
                    v9_1 = v3_1;
                    v6_1 = v10_2;
                    ComposableLambda v10_3 = ComposableLambdaKt.rememberComposableLambda(0x90B64608, true, new SegmentedButtonKt$SegmentedButton$8(v1), v12, 54);
                    v4_1 = ((Companion)v2_3);
                    v2 = v7;
                    goto label_217;
                }

                v4_1 = ((Companion)v2_3);
                v9_1 = v3_1;
                v2 = v7;
                v6_1 = v10_2;
                v10_1 = arg36;
            }
            else {
                v12.skipToGroupEnd();
                if((arg41 & 0x20) != 0) {
                    v7 &= v18;
                }

                if((arg41 & 0x40) != 0) {
                    v7 &= v3;
                }

                v10_1 = arg36;
                v9_1 = v6;
                v2 = v7;
                v4 = v11;
                v6_1 = v15_1;
            }

        label_217:
            BorderStroke v7_1 = v5;
            boolean v5_1 = v14_1;
            v12.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2065856961, v2, v0, "androidx.compose.material3.SegmentedButton (SegmentedButton.kt:266)");
            }

            SegmentedButtonKt.SegmentedButton(arg27, v1, v8_1, arg30, v4, v5_1, v6_1, v7_1, SegmentedButtonDefaults.INSTANCE.getContentPadding(), v9_1, v10_1, arg37, v12, v2 << 3 & 0x70000000 | (v2 & 14 | v17 | v2 & 0x70 | v2 & 0x380 | v2 & 0x1C00 | 0xE000 & v2 | 0x70000 & v2 | 0x380000 & v2 | 0x1C00000 & v2), v2 >> 27 & 14 | v0 << 3 & 0x70, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v8_2 = v7_1;
            v7_2 = v6_1;
            v6_2 = v5_1;
            v5_2 = v4;
        }
        else {
            v12.skipToGroupEnd();
            v10_1 = arg36;
            v8_2 = v5;
            v9_1 = v6;
            v5_2 = v11;
            v6_2 = v14_1;
            v7_2 = v15_1;
        }

        ScopeUpdateScope v15_2 = v12.endRestartGroup();
        if(v15_2 != null) {
            v15_2.updateScope(new SegmentedButtonKt$$ExternalSyntheticLambda8(arg27, arg28, arg29, arg30, v5_2, v6_2, v7_2, v8_2, v9_1, v10_1, arg37, arg39, arg40, arg41));
        }
    }

    public static final void SegmentedButton(MultiChoiceSegmentedButtonRowScope arg30, boolean arg31, Function1 arg32, Shape arg33, Modifier arg34, boolean arg35, SegmentedButtonColors arg36, BorderStroke arg37, PaddingValues arg38, MutableInteractionSource arg39, Function2 arg40, Function2 arg41, Composer arg42, int arg43, int arg44, int arg45) {
        Function2 v11_2;
        MutableInteractionSource v10_1;
        Modifier v5_2;
        BorderStroke v8_1;
        boolean v6_1;
        PaddingValues v9_3;
        SegmentedButtonColors v7_3;
        Composer v16_1;
        Object v14_2;
        PaddingValues v4_1;
        BorderStroke v13_1;
        SegmentedButtonColors v3_2;
        MutableInteractionSource v21_1;
        ComposableLambda v7_1;
        int v9_1;
        Companion v15_1;
        MutableInteractionSource v14_1;
        Modifier v3_4;
        int v22;
        int v21;
        BorderStroke v11;
        int v18;
        SegmentedButtonColors v9;
        boolean v8;
        int v16;
        Modifier v15;
        int v14;
        int v7;
        MultiChoiceSegmentedButtonRowScope v1 = arg30;
        boolean v2 = arg31;
        Function2 v0 = arg41;
        int v3 = arg43;
        int v4 = arg45;
        Composer v6 = arg42.startRestartGroup(0x2998B09A);
        ComposerKt.sourceInformation(v6, "C(SegmentedButton)N(checked,onCheckedChange,shape,modifier,enabled,colors,border,contentPadding,interactionSource,icon,label)147@7453L25,166@8056L101,149@7484L673:SegmentedButton.kt#uh7d8r");
        if((0x80000000 & v4) != 0) {
            v7 = v3 | 6;
        }
        else if((v3 & 6) == 0) {
            v7 = v6.changed(v1) ? 4 : 2;
            v7 |= v3;
        }
        else {
            v7 = v3;
        }

        if((v4 & 1) != 0) {
            v7 |= 0x30;
        }
        else if((v3 & 0x30) == 0) {
            int v10 = v6.changed(v2) ? 0x20 : 16;
            v7 |= v10;
        }

        if((v4 & 2) != 0) {
            v7 |= 0x180;
        }
        else if((v3 & 0x180) == 0) {
            int v13 = v6.changedInstance(arg32) ? 0x100 : 0x80;
            v7 |= v13;
        }

        if((v4 & 4) != 0) {
            v7 |= 0xC00;
        }
        else if((v3 & 0xC00) == 0) {
            v14 = v6.changed(arg33) ? 0x800 : 0x400;
            v7 |= v14;
        }

        v14 = v4 & 8;
        if(v14 != 0) {
            v7 |= 0x6000;
            goto label_81;
        }
        else if((v3 & 0x6000) == 0) {
            v15 = arg34;
            v16 = v6.changed(v15) ? 0x4000 : 0x2000;
            v7 |= v16;
        }
        else {
        label_81:
            v15 = arg34;
        }

        v16 = v4 & 16;
        int v17 = 0x30000;
        if(v16 != 0) {
            v7 |= v17;
            v8 = arg35;
        }
        else {
            v8 = arg35;
            if((v3 & v17) == 0) {
                v17 = v6.changed(v8) ? 0x20000 : 0x10000;
                v7 |= v17;
            }
        }

        if((v3 & 0x180000) == 0) {
            v9 = arg36;
            v18 = (v4 & 0x20) != 0 || !v6.changed(v9) ? 0x80000 : 0x100000;
            v7 |= v18;
        }
        else {
            v9 = arg36;
        }

        if((v3 & 0xC00000) == 0) {
            v11 = arg37;
            int v19 = (v4 & 0x40) != 0 || !v6.changed(v11) ? 0x400000 : 0x800000;
            v7 |= v19;
        }
        else {
            v11 = arg37;
        }

        int v12 = v4 & 0x80;
        int v20 = 0x6000000;
        if(v12 != 0) {
            v7 |= v20;
        }
        else {
            PaddingValues v5 = arg38;
            if((v3 & v20) == 0) {
                v21 = v6.changed(v5) ? 0x4000000 : 0x2000000;
                v7 |= v21;
            }
        }

        int v1_1 = v4 & 0x100;
        v21 = 0x30000000;
        if(v1_1 != 0) {
            v7 |= v21;
            goto label_156;
        }
        else if((v3 & v21) == 0) {
            v21 = v1_1;
            v22 = v6.changed(arg39) ? 0x20000000 : 0x10000000;
            v7 |= v22;
        }
        else {
        label_156:
            v21 = v1_1;
        }

        v1_1 = v4 & 0x200;
        if(v1_1 != 0) {
            v17 = arg44 | 6;
            v22 = v1_1;
        }
        else if((arg44 & 6) == 0) {
            v22 = v1_1;
            v17 = v6.changedInstance(arg40) ? 4 : 2;
            v17 |= arg44;
        }
        else {
            v22 = v1_1;
            v17 = arg44;
        }

        if((v4 & 0x400) != 0) {
            v17 |= 0x30;
        }
        else if((arg44 & 0x30) == 0) {
            v18 = v6.changedInstance(v0) ? 0x20 : 16;
            v17 |= v18;
        }

        v1_1 = v17;
        boolean v3_1 = (v7 & 306783379) != 306783378 || (v1_1 & 19) != 18 ? true : false;
        if(v6.shouldExecute(v3_1, v7 & 1)) {
            v6.startDefaults();
            ComposerKt.sourceInformation(v6, "135@6790L8,140@7079L41");
            v17 = 0xFE3FFFFF;
            v18 = 0xFFC7FFFF;
            v4 = 6;
            if((arg43 & 1) == 0 || (v6.getDefaultsInvalid())) {
                if(v14 != 0) {
                    Companion v3_3 = Modifier.Companion;
                }
                else {
                    v3_4 = v15;
                }

                if(v16 != 0) {
                    v8 = true;
                }

                if((arg45 & 0x20) != 0) {
                    v9 = SegmentedButtonDefaults.INSTANCE.colors(v6, v4);
                    v7 &= v18;
                }

                if((arg45 & 0x40) != 0) {
                    v11 = SegmentedButtonDefaults.borderStroke-l07J4OM$default(SegmentedButtonDefaults.INSTANCE, v9.borderColor-WaAFU9c$material3(v8, v2), 0f, 2, null);
                    v7 &= v17;
                }

                PaddingValues v12_1 = v12 != 0 ? SegmentedButtonDefaults.INSTANCE.getContentPadding() : arg38;
                v14_1 = v21 != 0 ? null : arg39;
                if(v22 != 0) {
                    v15_1 = ((Companion)v3_4);
                    v3_2 = v9;
                    v13_1 = v11;
                    v21_1 = v14_1;
                    v9_1 = v7;
                    v7_1 = ComposableLambdaKt.rememberComposableLambda(0x4671F4A1, true, new SegmentedButtonKt$SegmentedButton$1(v2), v6, 54);
                    v4_1 = v12_1;
                    goto label_285;
                }

                v15_1 = ((Companion)v3_4);
                v3_2 = v9;
                v13_1 = v11;
                v4_1 = v12_1;
                v21_1 = v14_1;
            label_229:
                v9_1 = v7;
                Function2 v7_2 = arg40;
            }
            else {
                v6.skipToGroupEnd();
                if((arg45 & 0x20) != 0) {
                    v7 &= v18;
                }

                if((arg45 & 0x40) != 0) {
                    v7 &= v17;
                }

                v21_1 = arg39;
                v3_2 = v9;
                v13_1 = v11;
                v4_1 = arg38;
                goto label_229;
            }

        label_285:
            v6.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x2998B09A, v9_1, v1_1, "androidx.compose.material3.SegmentedButton (SegmentedButton.kt:142)");
            }

            if(v21_1 == null) {
                v6.startReplaceGroup(0x9FBA4B61);
                ComposerKt.sourceInformation(v6, "144@7242L39");
                ComposerKt.sourceInformationMarkerStart(v6, 640634049, "CC(remember):SegmentedButton.kt#9igjgp");
                Object v1_2 = v6.rememberedValue();
                if(v1_2 == Composer.Companion.getEmpty()) {
                    MutableInteractionSource v1_3 = InteractionSourceKt.MutableInteractionSource();
                    v6.updateRememberedValue(v1_3);
                }

                ComposerKt.sourceInformationMarkerEnd(v6);
                v6.endReplaceGroup();
                v14_2 = v1_2;
            }
            else {
                v6.startReplaceGroup(0x262F4A36);
                v6.endReplaceGroup();
                v14_1 = v21_1;
            }

            long v11_1 = v3_2.containerColor-WaAFU9c$material3(v8, v2);
            v1_1 = v9_1;
            long v9_2 = v3_2.contentColor-WaAFU9c$material3(v8, v2);
            int v34 = v1_1;
            Modifier v20_1 = v15;
            Modifier v35 = SizeKt.defaultMinSize-VpY3zN4(SegmentedButtonKt.interactionZIndex(RowScope.weight$default(arg30, v15, 1f, false, 2, null), v2, SegmentedButtonKt.interactionCountAsState(v14_2, v6, 0)), ButtonDefaults.INSTANCE.getMinWidth-D9Ej5fM(), ButtonDefaults.INSTANCE.getMinHeight-D9Ej5fM());
            ComposableLambda v15_2 = ComposableLambdaKt.rememberComposableLambda(1717860164, true, new SegmentedButtonKt$SegmentedButton$2(((Function2)v7_1), v0, v4_1), v6, 54);
            boolean v5_1 = v8;
            Function2 v22_1 = ((Function2)v7_1);
            SegmentedButtonColors v0_1 = v3_2;
            PaddingValues v1_4 = v4_1;
            v16_1 = v6;
            SurfaceKt.Surface-d85dljk(v2, arg32, v35, v5_1, arg33, v11_1, v9_2, 0f, 0f, v13_1, ((MutableInteractionSource)v14_2), ((Function2)v15_2), v16_1, v34 >> 3 & 0x7E | v34 >> 6 & 0x1C00 | v34 << 3 & 0xE000 | 0x70000000 & v34 << 6, 0x30, 0x180);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v7_3 = v0_1;
            v9_3 = v1_4;
            v6_1 = v5_1;
            v8_1 = v13_1;
            v5_2 = v20_1;
            v10_1 = v21_1;
            v11_2 = v22_1;
        }
        else {
            v16_1 = v6;
            v16_1.skipToGroupEnd();
            v10_1 = arg39;
            v6_1 = v8;
            v7_3 = v9;
            v8_1 = v11;
            v5_2 = v15;
            v9_3 = arg38;
            v11_2 = arg40;
        }

        ScopeUpdateScope v0_2 = v16_1.endRestartGroup();
        if(v0_2 != null) {
            v0_2.updateScope(new SegmentedButtonKt$$ExternalSyntheticLambda1(arg30, arg31, arg32, arg33, v5_2, v6_1, v7_3, v8_1, v9_3, v10_1, v11_2, arg41, arg43, arg44, arg45));
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="kept for binary compatibility") public static final void SegmentedButton(SingleChoiceSegmentedButtonRowScope arg27, boolean arg28, Function0 arg29, Shape arg30, Modifier arg31, boolean arg32, SegmentedButtonColors arg33, BorderStroke arg34, MutableInteractionSource arg35, Function2 arg36, Function2 arg37, Composer arg38, int arg39, int arg40, int arg41) {
        Modifier v5_2;
        boolean v6_2;
        SegmentedButtonColors v7_2;
        BorderStroke v8_2;
        SegmentedButtonColors v6_1;
        MutableInteractionSource v9_1;
        Function2 v10_1;
        Companion v4_1;
        SegmentedButtonColors v10_2;
        Modifier v2_3;
        int v20;
        int v19;
        MutableInteractionSource v6;
        BorderStroke v5;
        int v16;
        SegmentedButtonColors v15_1;
        boolean v14_1;
        int v13;
        Modifier v11;
        int v10;
        Function0 v8_1;
        int v7;
        boolean v1 = arg28;
        int v0 = arg39;
        int v2 = arg41;
        Composer v12 = arg38.startRestartGroup(1723786701);
        ComposerKt.sourceInformation(v12, "C(SegmentedButton)N(selected,onClick,shape,modifier,enabled,colors,border,interactionSource,icon,label)297@13618L363:SegmentedButton.kt#uh7d8r");
        if((0x80000000 & v2) != 0) {
            v7 = v0 | 6;
        }
        else if((v0 & 6) == 0) {
            v7 = v12.changed(arg27) ? 4 : 2;
            v7 |= v0;
        }
        else {
            v7 = v0;
        }

        if((v2 & 1) != 0) {
            v7 |= 0x30;
        }
        else if((v0 & 0x30) == 0) {
            int v8 = v12.changed(v1) ? 0x20 : 16;
            v7 |= v8;
        }

        if((v2 & 2) != 0) {
            v7 |= 0x180;
            goto label_53;
        }
        else if((v0 & 0x180) == 0) {
            v8_1 = arg29;
            int v9 = v12.changedInstance(v8_1) ? 0x100 : 0x80;
            v7 |= v9;
        }
        else {
        label_53:
            v8_1 = arg29;
        }

        if((v2 & 4) != 0) {
            v7 |= 0xC00;
        }
        else if((v0 & 0xC00) == 0) {
            v10 = v12.changed(arg30) ? 0x800 : 0x400;
            v7 |= v10;
        }

        v10 = v2 & 8;
        if(v10 != 0) {
            v7 |= 0x6000;
            goto label_83;
        }
        else if((v0 & 0x6000) == 0) {
            v11 = arg31;
            v13 = v12.changed(v11) ? 0x4000 : 0x2000;
            v7 |= v13;
        }
        else {
        label_83:
            v11 = arg31;
        }

        v13 = v2 & 16;
        int v14 = 0x30000;
        if(v13 != 0) {
            v7 |= v14;
            goto label_99;
        }
        else if((v14 & v0) == 0) {
            v14_1 = arg32;
            int v15 = v12.changed(v14_1) ? 0x20000 : 0x10000;
            v7 |= v15;
        }
        else {
        label_99:
            v14_1 = arg32;
        }

        if((0x180000 & v0) == 0) {
            if((v2 & 0x20) == 0) {
                v15_1 = arg33;
                if(v12.changed(v15_1)) {
                    v16 = 0x100000;
                }
                else {
                    goto label_111;
                }
            }
            else {
                v15_1 = arg33;
            label_111:
                v16 = 0x80000;
            }

            v7 |= v16;
        }
        else {
            v15_1 = arg33;
        }

        if((v0 & 0xC00000) == 0) {
            v5 = arg34;
            v16 = (v2 & 0x40) != 0 || !v12.changed(v5) ? 0x400000 : 0x800000;
            v7 |= v16;
        }
        else {
            v5 = arg34;
        }

        int v3 = v2 & 0x80;
        int v17 = 0x6000000;
        if(v3 != 0) {
            v7 |= v17;
            v6 = arg35;
        }
        else {
            v6 = arg35;
            if((v0 & v17) == 0) {
                v19 = v12.changed(v6) ? 0x4000000 : 0x2000000;
                v7 |= v19;
            }
        }

        v0 = v2 & 0x100;
        v19 = 0x30000000;
        if(v0 != 0) {
            v7 |= v19;
            goto label_160;
        }
        else if((arg39 & v19) == 0) {
            v19 = v0;
            v20 = v12.changedInstance(arg36) ? 0x20000000 : 0x10000000;
            v7 |= v20;
        }
        else {
        label_160:
            v19 = v0;
        }

        if((v2 & 0x200) != 0) {
            v0 = arg40 | 6;
        }
        else if((arg40 & 6) == 0) {
            v20 = v12.changedInstance(arg37) ? 4 : 2;
            v0 = arg40 | v20;
        }
        else {
            v0 = arg40;
        }

        v20 = v3;
        boolean v2_1 = (v7 & 306783379) != 306783378 || (v0 & 3) != 2 ? true : false;
        if(v12.shouldExecute(v2_1, v7 & 1)) {
            v12.startDefaults();
            ComposerKt.sourceInformation(v12, "290@13317L8,294@13531L42");
            v3 = 0xFE3FFFFF;
            int v18 = 0xFFC7FFFF;
            if((arg39 & 1) == 0 || (v12.getDefaultsInvalid())) {
                if(v10 != 0) {
                    Companion v2_2 = Modifier.Companion;
                }
                else {
                    v2_3 = v11;
                }

                if(v13 != 0) {
                    v14_1 = true;
                }

                if((arg41 & 0x20) != 0) {
                    v10_2 = SegmentedButtonDefaults.INSTANCE.colors(v12, 6);
                    v7 &= v18;
                }
                else {
                    v10_2 = v15_1;
                }

                if((arg41 & 0x40) != 0) {
                    v5 = SegmentedButtonDefaults.borderStroke-l07J4OM$default(SegmentedButtonDefaults.INSTANCE, v10_2.borderColor-WaAFU9c$material3(v14_1, v1), 0f, 2, null);
                    v7 &= v3;
                }

                MutableInteractionSource v3_1 = v20 != 0 ? null : v6;
                if(v19 != 0) {
                    v9_1 = v3_1;
                    v6_1 = v10_2;
                    ComposableLambda v10_3 = ComposableLambdaKt.rememberComposableLambda(0x3A4A266, true, new SegmentedButtonKt$SegmentedButton$10(v1), v12, 54);
                    v4_1 = ((Companion)v2_3);
                    v2 = v7;
                    goto label_217;
                }

                v4_1 = ((Companion)v2_3);
                v9_1 = v3_1;
                v2 = v7;
                v6_1 = v10_2;
                v10_1 = arg36;
            }
            else {
                v12.skipToGroupEnd();
                if((arg41 & 0x20) != 0) {
                    v7 &= v18;
                }

                if((arg41 & 0x40) != 0) {
                    v7 &= v3;
                }

                v10_1 = arg36;
                v9_1 = v6;
                v2 = v7;
                Modifier v4 = v11;
                v6_1 = v15_1;
            }

        label_217:
            BorderStroke v7_1 = v5;
            boolean v5_1 = v14_1;
            v12.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1723786701, v2, v0, "androidx.compose.material3.SegmentedButton (SegmentedButton.kt:296)");
            }

            SegmentedButtonKt.SegmentedButton(arg27, v1, v8_1, arg30, ((Modifier)v4_1), v5_1, v6_1, v7_1, SegmentedButtonDefaults.INSTANCE.getContentPadding(), v9_1, v10_1, arg37, v12, v2 << 3 & 0x70000000 | (v2 & 14 | v17 | v2 & 0x70 | v2 & 0x380 | v2 & 0x1C00 | 0xE000 & v2 | 0x70000 & v2 | 0x380000 & v2 | 0x1C00000 & v2), v2 >> 27 & 14 | v0 << 3 & 0x70, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v8_2 = v7_1;
            v7_2 = v6_1;
            v6_2 = v5_1;
            v5_2 = ((Modifier)v4_1);
        }
        else {
            v12.skipToGroupEnd();
            v10_1 = arg36;
            v8_2 = v5;
            v9_1 = v6;
            v5_2 = v11;
            v6_2 = v14_1;
            v7_2 = v15_1;
        }

        ScopeUpdateScope v15_2 = v12.endRestartGroup();
        if(v15_2 != null) {
            v15_2.updateScope(new SegmentedButtonKt$$ExternalSyntheticLambda2(arg27, arg28, arg29, arg30, v5_2, v6_2, v7_2, v8_2, v9_1, v10_1, arg37, arg39, arg40, arg41));
        }
    }

    public static final void SegmentedButton(SingleChoiceSegmentedButtonRowScope arg30, boolean arg31, Function0 arg32, Shape arg33, Modifier arg34, boolean arg35, SegmentedButtonColors arg36, BorderStroke arg37, PaddingValues arg38, MutableInteractionSource arg39, Function2 arg40, Function2 arg41, Composer arg42, int arg43, int arg44, int arg45) {
        PaddingValues v9_3;
        Function2 v11_4;
        MutableInteractionSource v10_1;
        Modifier v5_2;
        BorderStroke v8_1;
        boolean v6_1;
        SegmentedButtonColors v7_3;
        Composer v16_1;
        Object v14_2;
        PaddingValues v4_1;
        BorderStroke v13_1;
        SegmentedButtonColors v3_2;
        MutableInteractionSource v21_1;
        Companion v15_1;
        int v9_1;
        ComposableLambda v7_1;
        MutableInteractionSource v14_1;
        Modifier v3_4;
        Companion v3_3;
        int v22;
        int v21;
        BorderStroke v11;
        int v18;
        SegmentedButtonColors v9;
        boolean v8;
        int v16;
        Modifier v15;
        int v14;
        int v7;
        SingleChoiceSegmentedButtonRowScope v1 = arg30;
        boolean v2 = arg31;
        Function2 v0 = arg41;
        int v3 = arg43;
        int v4 = arg45;
        Composer v6 = arg42.startRestartGroup(1532041126);
        ComposerKt.sourceInformation(v6, "C(SegmentedButton)N(selected,onClick,shape,modifier,enabled,colors,border,contentPadding,interactionSource,icon,label)227@11214L25,238@11577L27,247@11859L67,229@11245L681:SegmentedButton.kt#uh7d8r");
        if((0x80000000 & v4) != 0) {
            v7 = v3 | 6;
        }
        else if((v3 & 6) == 0) {
            v7 = v6.changed(v1) ? 4 : 2;
            v7 |= v3;
        }
        else {
            v7 = v3;
        }

        if((v4 & 1) != 0) {
            v7 |= 0x30;
        }
        else if((v3 & 0x30) == 0) {
            int v10 = v6.changed(v2) ? 0x20 : 16;
            v7 |= v10;
        }

        if((v4 & 2) != 0) {
            v7 |= 0x180;
        }
        else if((v3 & 0x180) == 0) {
            int v13 = v6.changedInstance(arg32) ? 0x100 : 0x80;
            v7 |= v13;
        }

        if((v4 & 4) != 0) {
            v7 |= 0xC00;
        }
        else if((v3 & 0xC00) == 0) {
            v14 = v6.changed(arg33) ? 0x800 : 0x400;
            v7 |= v14;
        }

        v14 = v4 & 8;
        if(v14 != 0) {
            v7 |= 0x6000;
            goto label_81;
        }
        else if((v3 & 0x6000) == 0) {
            v15 = arg34;
            v16 = v6.changed(v15) ? 0x4000 : 0x2000;
            v7 |= v16;
        }
        else {
        label_81:
            v15 = arg34;
        }

        v16 = v4 & 16;
        int v17 = 0x30000;
        if(v16 != 0) {
            v7 |= v17;
            v8 = arg35;
        }
        else {
            v8 = arg35;
            if((v3 & v17) == 0) {
                v17 = v6.changed(v8) ? 0x20000 : 0x10000;
                v7 |= v17;
            }
        }

        if((v3 & 0x180000) == 0) {
            v9 = arg36;
            v18 = (v4 & 0x20) != 0 || !v6.changed(v9) ? 0x80000 : 0x100000;
            v7 |= v18;
        }
        else {
            v9 = arg36;
        }

        if((v3 & 0xC00000) == 0) {
            v11 = arg37;
            int v19 = (v4 & 0x40) != 0 || !v6.changed(v11) ? 0x400000 : 0x800000;
            v7 |= v19;
        }
        else {
            v11 = arg37;
        }

        int v12 = v4 & 0x80;
        int v20 = 0x6000000;
        if(v12 != 0) {
            v7 |= v20;
        }
        else {
            PaddingValues v5 = arg38;
            if((v3 & v20) == 0) {
                v21 = v6.changed(v5) ? 0x4000000 : 0x2000000;
                v7 |= v21;
            }
        }

        int v1_1 = v4 & 0x100;
        v21 = 0x30000000;
        if(v1_1 != 0) {
            v7 |= v21;
            goto label_156;
        }
        else if((v3 & v21) == 0) {
            v21 = v1_1;
            v22 = v6.changed(arg39) ? 0x20000000 : 0x10000000;
            v7 |= v22;
        }
        else {
        label_156:
            v21 = v1_1;
        }

        v1_1 = v4 & 0x200;
        if(v1_1 != 0) {
            v17 = arg44 | 6;
            v22 = v1_1;
        }
        else if((arg44 & 6) == 0) {
            v22 = v1_1;
            v17 = v6.changedInstance(arg40) ? 4 : 2;
            v17 |= arg44;
        }
        else {
            v22 = v1_1;
            v17 = arg44;
        }

        if((v4 & 0x400) != 0) {
            v17 |= 0x30;
        }
        else if((arg44 & 0x30) == 0) {
            v18 = v6.changedInstance(v0) ? 0x20 : 16;
            v17 |= v18;
        }

        v1_1 = v17;
        boolean v3_1 = (v7 & 306783379) != 306783378 || (v1_1 & 19) != 18 ? true : false;
        if(v6.shouldExecute(v3_1, v7 & 1)) {
            v6.startDefaults();
            ComposerKt.sourceInformation(v6, "215@10547L8,220@10837L42");
            v17 = 0xFFC7FFFF;
            v18 = 0xFE3FFFFF;
            v4 = 6;
            if((arg43 & 1) == 0 || (v6.getDefaultsInvalid())) {
                if(v14 != 0) {
                    v3_3 = Modifier.Companion;
                }
                else {
                    v3_4 = v15;
                }

                if(v16 != 0) {
                    v8 = true;
                }

                if((arg45 & 0x20) != 0) {
                    v9 = SegmentedButtonDefaults.INSTANCE.colors(v6, v4);
                    v7 &= v17;
                }

                if((arg45 & 0x40) != 0) {
                    v11 = SegmentedButtonDefaults.borderStroke-l07J4OM$default(SegmentedButtonDefaults.INSTANCE, v9.borderColor-WaAFU9c$material3(v8, v2), 0f, 2, null);
                    v7 &= v18;
                }

                PaddingValues v12_1 = v12 != 0 ? SegmentedButtonDefaults.INSTANCE.getContentPadding() : arg38;
                v14_1 = v21 != 0 ? null : arg39;
                if(v22 != 0) {
                    Companion v34 = v3_3;
                    v4 = v7;
                    v7_1 = ComposableLambdaKt.rememberComposableLambda(-643804033, true, new SegmentedButtonKt$SegmentedButton$4(v2), v6, 54);
                    v3_2 = v9;
                    v9_1 = v4;
                    v15_1 = v34;
                    v13_1 = v11;
                    v4_1 = v12_1;
                    v21_1 = v14_1;
                    goto label_286;
                }

                v15_1 = v3_3;
                v3_2 = v9;
                v13_1 = v11;
                v4_1 = v12_1;
                v21_1 = v14_1;
            label_229:
                v9_1 = v7;
                Function2 v7_2 = arg40;
            }
            else {
                v6.skipToGroupEnd();
                if((arg45 & 0x20) != 0) {
                    v7 &= v17;
                }

                if((arg45 & 0x40) != 0) {
                    v7 &= v18;
                }

                v21_1 = arg39;
                v3_2 = v9;
                v13_1 = v11;
                v4_1 = arg38;
                goto label_229;
            }

        label_286:
            v6.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1532041126, v9_1, v1_1, "androidx.compose.material3.SegmentedButton (SegmentedButton.kt:222)");
            }

            String v1_2 = "CC(remember):SegmentedButton.kt#9igjgp";
            if(v21_1 == null) {
                v6.startReplaceGroup(0xA1D9CE35);
                ComposerKt.sourceInformation(v6, "224@11001L39");
                ComposerKt.sourceInformationMarkerStart(v6, 0xCB6A1F6D, v1_2);
                Object v11_1 = v6.rememberedValue();
                if(v11_1 == Composer.Companion.getEmpty()) {
                    MutableInteractionSource v11_2 = InteractionSourceKt.MutableInteractionSource();
                    v6.updateRememberedValue(v11_2);
                }

                ComposerKt.sourceInformationMarkerEnd(v6);
                v6.endReplaceGroup();
                v14_2 = v11_1;
            }
            else {
                v6.startReplaceGroup(0xCB6A1CE2);
                v6.endReplaceGroup();
                v14_1 = v21_1;
            }

            long v11_3 = v3_2.containerColor-WaAFU9c$material3(v8, v2);
            v17 = v9_1;
            long v9_2 = v3_2.contentColor-WaAFU9c$material3(v8, v2);
            SegmentedButtonColors v19_1 = v3_2;
            Modifier v20_1 = ((Modifier)v15_1);
            v3_4 = SizeKt.defaultMinSize-VpY3zN4(SegmentedButtonKt.interactionZIndex(RowScope.weight$default(arg30, ((Modifier)v15_1), 1f, false, 2, null), v2, SegmentedButtonKt.interactionCountAsState(v14_2, v6, 0)), ButtonDefaults.INSTANCE.getMinWidth-D9Ej5fM(), ButtonDefaults.INSTANCE.getMinHeight-D9Ej5fM());
            ComposerKt.sourceInformationMarkerStart(v6, 0xCB6A6761, v1_2);
            Object v1_3 = v6.rememberedValue();
            if(v1_3 == Composer.Companion.getEmpty()) {
                SegmentedButtonKt$$ExternalSyntheticLambda4 v1_4 = new SegmentedButtonKt$$ExternalSyntheticLambda4();
                v6.updateRememberedValue(v1_4);
            }

            ComposerKt.sourceInformationMarkerEnd(v6);
            Modifier v1_5 = SemanticsModifierKt.semantics$default(v3_4, false, ((Function1)v1_3), 1, null);
            ComposableLambda v15_2 = ComposableLambdaKt.rememberComposableLambda(-1208080836, true, new SegmentedButtonKt$SegmentedButton$6(((Function2)v7_1), v0, v4_1), v6, 54);
            boolean v5_1 = v8;
            Function2 v22_1 = ((Function2)v7_1);
            PaddingValues v23 = v4_1;
            v16_1 = v6;
            Modifier v4_2 = v1_5;
            SegmentedButtonColors v1_6 = v19_1;
            SurfaceKt.Surface-d85dljk(arg31, arg32, v4_2, v5_1, arg33, v11_3, v9_2, 0f, 0f, v13_1, ((MutableInteractionSource)v14_2), ((Function2)v15_2), v16_1, v17 >> 3 & 0x7E | v17 >> 6 & 0x1C00 | v17 << 3 & 0xE000 | 0x70000000 & v17 << 6, 0x30, 0x180);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v7_3 = v1_6;
            v6_1 = v5_1;
            v8_1 = v13_1;
            v5_2 = v20_1;
            v10_1 = v21_1;
            v11_4 = v22_1;
            v9_3 = v23;
        }
        else {
            v16_1 = v6;
            v16_1.skipToGroupEnd();
            v10_1 = arg39;
            v6_1 = v8;
            v7_3 = v9;
            v8_1 = v11;
            v5_2 = v15;
            v9_3 = arg38;
            v11_4 = arg40;
        }

        ScopeUpdateScope v1_7 = v16_1.endRestartGroup();
        if(v1_7 != null) {
            v1_7.updateScope(new SegmentedButtonKt$$ExternalSyntheticLambda5(arg30, arg31, arg32, arg33, v5_2, v6_1, v7_3, v8_1, v9_3, v10_1, v11_4, arg41, arg43, arg44, arg45));
        }
    }

    static final Unit SegmentedButton$lambda$1(MultiChoiceSegmentedButtonRowScope arg17, boolean arg18, Function1 arg19, Shape arg20, Modifier arg21, boolean arg22, SegmentedButtonColors arg23, BorderStroke arg24, PaddingValues arg25, MutableInteractionSource arg26, Function2 arg27, Function2 arg28, int arg29, int arg30, int arg31, Composer arg32, int arg33) {
        SegmentedButtonKt.SegmentedButton(arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg32, RecomposeScopeImplKt.updateChangedFlags(arg29 | 1), RecomposeScopeImplKt.updateChangedFlags(arg30), arg31);
        return Unit.INSTANCE;
    }

    static final Unit SegmentedButton$lambda$4$lambda$3(SemanticsPropertyReceiver arg1) {
        SemanticsPropertiesKt.setRole-kuIjeqM(arg1, Role.Companion.getRadioButton-o7Vup1c());
        return Unit.INSTANCE;
    }

    static final Unit SegmentedButton$lambda$5(SingleChoiceSegmentedButtonRowScope arg17, boolean arg18, Function0 arg19, Shape arg20, Modifier arg21, boolean arg22, SegmentedButtonColors arg23, BorderStroke arg24, PaddingValues arg25, MutableInteractionSource arg26, Function2 arg27, Function2 arg28, int arg29, int arg30, int arg31, Composer arg32, int arg33) {
        SegmentedButtonKt.SegmentedButton(arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg32, RecomposeScopeImplKt.updateChangedFlags(arg29 | 1), RecomposeScopeImplKt.updateChangedFlags(arg30), arg31);
        return Unit.INSTANCE;
    }

    static final Unit SegmentedButton$lambda$6(MultiChoiceSegmentedButtonRowScope arg16, boolean arg17, Function1 arg18, Shape arg19, Modifier arg20, boolean arg21, SegmentedButtonColors arg22, BorderStroke arg23, MutableInteractionSource arg24, Function2 arg25, Function2 arg26, int arg27, int arg28, int arg29, Composer arg30, int arg31) {
        SegmentedButtonKt.SegmentedButton(arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg30, RecomposeScopeImplKt.updateChangedFlags(arg27 | 1), RecomposeScopeImplKt.updateChangedFlags(arg28), arg29);
        return Unit.INSTANCE;
    }

    static final Unit SegmentedButton$lambda$7(SingleChoiceSegmentedButtonRowScope arg16, boolean arg17, Function0 arg18, Shape arg19, Modifier arg20, boolean arg21, SegmentedButtonColors arg22, BorderStroke arg23, MutableInteractionSource arg24, Function2 arg25, Function2 arg26, int arg27, int arg28, int arg29, Composer arg30, int arg31) {
        SegmentedButtonKt.SegmentedButton(arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg30, RecomposeScopeImplKt.updateChangedFlags(arg27 | 1), RecomposeScopeImplKt.updateChangedFlags(arg28), arg29);
        return Unit.INSTANCE;
    }

    private static final void SegmentedButtonContent(Function2 arg8, Function2 arg9, PaddingValues arg10, Composer arg11, int arg12) {
        int v2;
        int v1;
        int v0 = 0xC0444F4F;
        arg11 = arg11.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg11, "C(SegmentedButtonContent)N(icon,content,contentPadding)387@16992L743:SegmentedButton.kt#uh7d8r");
        if((arg12 & 6) == 0) {
            v1 = arg11.changedInstance(arg8) ? 4 : 2;
            v1 |= arg12;
        }
        else {
            v1 = arg12;
        }

        if((arg12 & 0x30) == 0) {
            v2 = arg11.changedInstance(arg9) ? 0x20 : 16;
            v1 |= v2;
        }

        if((arg12 & 0x180) == 0) {
            v2 = arg11.changed(arg10) ? 0x100 : 0x80;
            v1 |= v2;
        }

        boolean v2_1 = (v1 & 0x93) != 0x92 ? true : false;
        if(arg11.shouldExecute(v2_1, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.material3.SegmentedButtonContent (SegmentedButton.kt:386)");
            }

            Alignment v0_1 = Alignment.Companion.getCenter();
            Modifier v1_1 = PaddingKt.padding(Modifier.Companion, arg10);
            ComposerKt.sourceInformationMarkerStart(arg11, 0x2BB5B5D7, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy v0_2 = BoxKt.maybeCachedBoxMeasurePolicy(v0_1, false);
            ComposerKt.sourceInformationMarkerStart(arg11, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            v2 = ComposablesKt.getCurrentCompositeKeyHash(arg11, 0);
            CompositionLocalMap v3 = arg11.getCurrentCompositionLocalMap();
            v1_1 = ComposedModifierKt.materializeModifier(arg11, v1_1);
            Function0 v5 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(arg11, 0xD6BD0031, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if(!(arg11.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            arg11.startReusableNode();
            if(arg11.getInserting()) {
                arg11.createNode(v5);
            }
            else {
                arg11.useNode();
            }

            Composer v5_1 = Updater.constructor-impl(arg11);
            Updater.set-impl(v5_1, v0_2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v5_1, v3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v0_3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v5_1.getInserting()) || !Intrinsics.areEqual(v5_1.rememberedValue(), Integer.valueOf(v2))) {
                v5_1.updateRememberedValue(Integer.valueOf(v2));
                v5_1.apply(Integer.valueOf(v2), v0_3);
            }

            Updater.set-impl(v5_1, v1_1, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(arg11, 0x800B7D29, "C72@3468L9:Box.kt#2w3rfo");
            ComposerKt.sourceInformationMarkerStart(arg11, 0x12C26B39, "C388@17149L5,390@17293L12,391@17343L386,391@17314L415:SegmentedButton.kt#uh7d8r");
            TextKt.ProvideTextStyle(TypographyKt.getValue(OutlinedSegmentedButtonTokens.INSTANCE.getLabelTextFont(), arg11, 6), ComposableLambdaKt.rememberComposableLambda(0xAE2F9238, true, new SegmentedButtonKt$SegmentedButtonContent$1$1(arg8, arg9, MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, arg11, 6)), arg11, 54), arg11, 0x30);
            ComposerKt.sourceInformationMarkerEnd(arg11);
            ComposerKt.sourceInformationMarkerEnd(arg11);
            arg11.endNode();
            ComposerKt.sourceInformationMarkerEnd(arg11);
            ComposerKt.sourceInformationMarkerEnd(arg11);
            ComposerKt.sourceInformationMarkerEnd(arg11);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_128;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg11.skipToGroupEnd();
        }

    label_128:
        ScopeUpdateScope v11 = arg11.endRestartGroup();
        if(v11 != null) {
            v11.updateScope(new SegmentedButtonKt$$ExternalSyntheticLambda9(arg8, arg9, arg10, arg12));
        }
    }

    static final Unit SegmentedButtonContent$lambda$15(Function2 arg0, Function2 arg1, PaddingValues arg2, int arg3, Composer arg4, int arg5) {
        SegmentedButtonKt.SegmentedButtonContent(arg0, arg1, arg2, arg4, RecomposeScopeImplKt.updateChangedFlags(arg3 | 1));
        return Unit.INSTANCE;
    }

    public static final void SingleChoiceSegmentedButtonRow-uFdPcIQ(Modifier arg8, float arg9, Function3 arg10, Composer arg11, int arg12, int arg13) {
        Companion v8;
        int v4;
        int v2;
        int v0 = 2041406825;
        arg11 = arg11.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg11, "C(SingleChoiceSegmentedButtonRow)N(modifier,space:c#ui.unit.Dp,content)332@14963L448:SegmentedButton.kt#uh7d8r");
        int v1 = arg13 & 1;
        if(v1 != 0) {
            v2 = arg12 | 6;
        }
        else if((arg12 & 6) == 0) {
            v2 = arg11.changed(arg8) ? 4 : 2;
            v2 |= arg12;
        }
        else {
            v2 = arg12;
        }

        int v3 = arg13 & 2;
        if(v3 != 0) {
            v2 |= 0x30;
        }
        else if((arg12 & 0x30) == 0) {
            v4 = arg11.changed(arg9) ? 0x20 : 16;
            v2 |= v4;
        }

        if((arg13 & 4) != 0) {
            v2 |= 0x180;
        }
        else if((arg12 & 0x180) == 0) {
            v4 = arg11.changedInstance(arg10) ? 0x100 : 0x80;
            v2 |= v4;
        }

        boolean v4_1 = (v2 & 0x93) != 0x92 ? true : false;
        if(arg11.shouldExecute(v4_1, v2 & 1)) {
            if(v1 != 0) {
                v8 = Modifier.Companion;
            }

            if(v3 != 0) {
                arg9 = SegmentedButtonDefaults.INSTANCE.getBorderWidth-D9Ej5fM();
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v2, -1, "androidx.compose.material3.SingleChoiceSegmentedButtonRow (SegmentedButton.kt:331)");
            }

            Modifier v0_1 = IntrinsicKt.width(SizeKt.defaultMinSize-VpY3zN4$default(SelectableGroupKt.selectableGroup(((Modifier)v8)), 0f, OutlinedSegmentedButtonTokens.INSTANCE.getContainerHeight-D9Ej5fM(), 1, null), IntrinsicSize.Min);
            HorizontalOrVertical v1_1 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(-arg9));
            Vertical v3_1 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(arg11, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy v1_2 = RowKt.rowMeasurePolicy(((Horizontal)v1_1), v3_1, arg11, 0x30);
            ComposerKt.sourceInformationMarkerStart(arg11, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            v3 = ComposablesKt.getCurrentCompositeKeyHash(arg11, 0);
            CompositionLocalMap v4_2 = arg11.getCurrentCompositionLocalMap();
            v0_1 = ComposedModifierKt.materializeModifier(arg11, v0_1);
            Function0 v5 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(arg11, 0xD6BD0031, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if(!(arg11.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            arg11.startReusableNode();
            if(arg11.getInserting()) {
                arg11.createNode(v5);
            }
            else {
                arg11.useNode();
            }

            Composer v5_1 = Updater.constructor-impl(arg11);
            Updater.set-impl(v5_1, v1_2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v5_1, v4_2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v1_3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v5_1.getInserting()) || !Intrinsics.areEqual(v5_1.rememberedValue(), Integer.valueOf(v3))) {
                v5_1.updateRememberedValue(Integer.valueOf(v3));
                v5_1.apply(Integer.valueOf(v3), v1_3);
            }

            Updater.set-impl(v5_1, v0_1, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(arg11, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance v0_2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(arg11, 0x468F3C80, "C341@15323L58,342@15396L9:SegmentedButton.kt#uh7d8r");
            ComposerKt.sourceInformationMarkerStart(arg11, 0xA88C13F, "CC(remember):SegmentedButton.kt#9igjgp");
            Object v1_4 = arg11.rememberedValue();
            if(v1_4 == Composer.Companion.getEmpty()) {
                SingleChoiceSegmentedButtonScopeWrapper v1_5 = new SingleChoiceSegmentedButtonScopeWrapper(((RowScope)v0_2));
                arg11.updateRememberedValue(v1_5);
            }

            ComposerKt.sourceInformationMarkerEnd(arg11);
            arg10.invoke(v1_4, arg11, Integer.valueOf(v2 >> 3 & 0x70 | 6));
            ComposerKt.sourceInformationMarkerEnd(arg11);
            ComposerKt.sourceInformationMarkerEnd(arg11);
            arg11.endNode();
            ComposerKt.sourceInformationMarkerEnd(arg11);
            ComposerKt.sourceInformationMarkerEnd(arg11);
            ComposerKt.sourceInformationMarkerEnd(arg11);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_159;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg11.skipToGroupEnd();
        }

    label_159:
        Modifier v2_1 = ((Modifier)v8);
        float v3_2 = arg9;
        ScopeUpdateScope v8_1 = arg11.endRestartGroup();
        if(v8_1 != null) {
            v8_1.updateScope(new SegmentedButtonKt$$ExternalSyntheticLambda0(v2_1, v3_2, arg10, arg12, arg13));
        }
    }

    static final Unit SingleChoiceSegmentedButtonRow_uFdPcIQ$lambda$10(Modifier arg6, float arg7, Function3 arg8, int arg9, int arg10, Composer arg11, int arg12) {
        SegmentedButtonKt.SingleChoiceSegmentedButtonRow-uFdPcIQ(arg6, arg7, arg8, arg11, RecomposeScopeImplKt.updateChangedFlags(arg9 | 1), arg10);
        return Unit.INSTANCE;
    }

    public static final void access$SegmentedButtonContent(Function2 arg0, Function2 arg1, PaddingValues arg2, Composer arg3, int arg4) {
        SegmentedButtonKt.SegmentedButtonContent(arg0, arg1, arg2, arg3, arg4);
    }

    public static final float access$getIconSpacing$p() {
        return SegmentedButtonKt.IconSpacing;
    }

    private static final State interactionCountAsState(InteractionSource arg5, Composer arg6, int arg7) {
        SegmentedButtonKt$interactionCountAsState$1$1 v7_1;
        int v1 = 0x10CD4D53;
        ComposerKt.sourceInformationMarkerStart(arg6, v1, "C(interactionCountAsState)460@19902L33,461@19961L499,461@19940L520:SegmentedButton.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg7, -1, "androidx.compose.material3.interactionCountAsState (SegmentedButton.kt:459)");
        }

        String v1_1 = "CC(remember):SegmentedButton.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(arg6, 0x12AF5254, v1_1);
        Object v0 = arg6.rememberedValue();
        int v3 = 0;
        if(v0 == Composer.Companion.getEmpty()) {
            MutableIntState v0_1 = SnapshotIntStateKt.mutableIntStateOf(0);
            arg6.updateRememberedValue(v0_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg6);
        ComposerKt.sourceInformationMarkerStart(arg6, 0x12AF5B86, v1_1);
        v1 = arg7 & 14;
        int v4 = 4;
        if((v1 ^ 6) > v4 && (arg6.changed(arg5)) || (arg7 & 6) == v4) {
            v3 = 1;
        }

        Object v7 = arg6.rememberedValue();
        if(v3 != 0 || v7 == Composer.Companion.getEmpty()) {
            v7_1 = new SegmentedButtonKt$interactionCountAsState$1$1(arg5, ((MutableIntState)v0), null);
            arg6.updateRememberedValue(v7_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg6);
        EffectsKt.LaunchedEffect(arg5, ((Function2)v7_1), arg6, v1);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg6);
        return ((State)v0);
    }

    private static final Modifier interactionZIndex(Modifier arg1, boolean arg2, State arg3) {
        return LayoutModifierKt.layout(arg1, new SegmentedButtonKt$$ExternalSyntheticLambda6(arg3, arg2));
    }

    static final MeasureResult interactionZIndex$lambda$19(State arg7, boolean arg8, MeasureScope arg9, Measurable arg10, Constraints arg11) {
        Placeable v10 = arg10.measure-BRTryo0(arg11.unbox-impl());
        return MeasureScope.layout$default(arg9, v10.getWidth(), v10.getHeight(), null, new SegmentedButtonKt$$ExternalSyntheticLambda7(arg7, arg8, v10), 4, null);
    }

    static final Unit interactionZIndex$lambda$19$lambda$18(State arg0, boolean arg1, Placeable arg2, PlacementScope arg3) {
        float v0 = arg0.getValue().floatValue();
        float v1 = arg1 ? 5f : 0f;
        arg3.place(arg2, 0, 0, v0 + v1);
        return Unit.INSTANCE;
    }
}

