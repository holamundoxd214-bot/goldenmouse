package androidx.compose.material3;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.ui.node.ComposeUiNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u001AS\u0010\u0000\u001A\u00020\u00012\u0017\u0010\u0002\u001A\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\u0017\u0010\n\u001A\u0013\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\r¨\u0006\u000E²\u0006\n\u0010\u000F\u001A\u00020\u0010X\u008A\u0084\u0002"}, d2={"AppBarRow", "", "overflowIndicator", "Lkotlin/Function1;", "Landroidx/compose/material3/AppBarMenuState;", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "maxItemCount", "", "content", "Landroidx/compose/material3/AppBarRowScope;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;ILkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "material3", "scope", "Landroidx/compose/material3/AppBarRowScopeImpl;"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AppBarRowKt {
    public static final void AppBarRow(Function3 arg16, Modifier arg17, int arg18, Function1 arg19, Composer arg20, int arg21, int arg22) {
        MeasurePolicy v6_2;
        AppBarMenuState v0_3;
        Modifier v7_2;
        int v12;
        int v11;
        int v9;
        Modifier v8;
        int v3;
        Function3 v1 = arg16;
        Function1 v4 = arg19;
        int v5 = arg21;
        int v0 = 0x70BB4AB4;
        Composer v2 = arg20.startRestartGroup(v0);
        ComposerKt.sourceInformation(v2, "C(AppBarRow)N(overflowIndicator,modifier,maxItemCount,content)57@2869L29,58@2916L108,61@3045L30,62@3100L29,64@3162L132,71@3363L50,72@3431L680,68@3300L901:AppBarRow.kt#uh7d8r");
        int v6 = 2;
        if((arg22 & 1) != 0) {
            v3 = v5 | 6;
        }
        else if((v5 & 6) == 0) {
            v3 = v2.changedInstance(v1) ? 4 : v6;
            v3 |= v5;
        }
        else {
            v3 = v5;
        }

        int v7 = arg22 & 2;
        if(v7 != 0) {
            v3 |= 0x30;
            goto label_37;
        }
        else if((v5 & 0x30) == 0) {
            v8 = arg17;
            v9 = v2.changed(v8) ? 0x20 : 16;
            v3 |= v9;
        }
        else {
        label_37:
            v8 = arg17;
        }

        v9 = arg22 & 4;
        int v10 = 0x100;
        if(v9 != 0) {
            v3 |= 0x180;
            goto label_53;
        }
        else if((v5 & 0x180) == 0) {
            v11 = arg18;
            v12 = v2.changed(v11) ? v10 : 0x80;
            v3 |= v12;
        }
        else {
        label_53:
            v11 = arg18;
        }

        if((arg22 & 8) != 0) {
            v3 |= 0xC00;
        }
        else if((v5 & 0xC00) == 0) {
            v12 = v2.changedInstance(v4) ? 0x800 : 0x400;
            v3 |= v12;
        }

        boolean v12_1 = (v3 & 0x493) != 1170 ? true : false;
        if(v2.shouldExecute(v12_1, v3 & 1)) {
            if(v7 != 0) {
                Companion v7_1 = Modifier.Companion;
            }
            else {
                v7_2 = v8;
            }

            if(v9 != 0) {
                v11 = 0x7FFFFFFF;
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v3, -1, "androidx.compose.material3.AppBarRow (AppBarRow.kt:56)");
            }

            State v0_1 = SnapshotStateKt.rememberUpdatedState(v4, v2, v3 >> 9 & 14);
            String v9_1 = "CC(remember):AppBarRow.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v2, 0x2F139AA0, v9_1);
            Object v8_1 = v2.rememberedValue();
            if(v8_1 == Composer.Companion.getEmpty()) {
                State v8_2 = SnapshotStateKt.derivedStateOf(new AppBarRowKt$$ExternalSyntheticLambda0(v0_1));
                v2.updateRememberedValue(v8_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v2);
            ComposerKt.sourceInformationMarkerStart(v2, 0x2F13AA72, v9_1);
            Object v0_2 = v2.rememberedValue();
            if(v0_2 == Composer.Companion.getEmpty()) {
                v0_3 = new AppBarMenuState();
                v2.updateRememberedValue(v0_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v2);
            AppBarOverflowState v12_2 = AppBarDslKt.rememberAppBarOverflowState(v2, 0);
            ComposerKt.sourceInformationMarkerStart(v2, 0x2F13B978, v9_1);
            boolean v9_2 = v2.changed(v12_2);
            v3 = (v3 & 0x380) == v10 ? 1 : 0;
            v3 |= ((int)v9_2);
            Object v9_3 = v2.rememberedValue();
            if(v3 != 0 || v9_3 == Composer.Companion.getEmpty()) {
                OverflowMeasurePolicy v9_4 = new OverflowMeasurePolicy(v12_2, v11, false);
                v2.updateRememberedValue(v9_4);
            }

            ComposerKt.sourceInformationMarkerEnd(v2);
            Function2[] v3_1 = new Function2[v6];
            v3_1[0] = ComposableLambdaKt.rememberComposableLambda(0x41C2E85, true, new AppBarRowKt$AppBarRow$1(((State)v8_1)), v2, 54);
            v3_1[1] = ComposableLambdaKt.rememberComposableLambda(0xCF602F46, true, new AppBarRowKt$AppBarRow$2(v1, v0_3, v12_2, ((State)v8_1)), v2, 54);
            List v0_4 = CollectionsKt.listOf(((Object[])v3_1));
            ComposerKt.sourceInformationMarkerStart(v2, 0x5365E06C, "CC(Layout)P(!1,2)168@6883L62,165@6769L182:Layout.kt#80mrfh");
            Function2 v0_5 = LayoutKt.combineAsVirtualLayouts(v0_4);
            ComposerKt.sourceInformationMarkerStart(v2, -290764973, "CC(remember):Layout.kt#9igjgp");
            boolean v3_2 = v2.changed(v9_3);
            Object v6_1 = v2.rememberedValue();
            if((v3_2) || v6_1 == Composer.Companion.getEmpty()) {
                v6_2 = MultiContentMeasurePolicyKt.createMeasurePolicy(((MultiContentMeasurePolicy)v9_3));
                v2.updateRememberedValue(v6_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v2);
            ComposerKt.sourceInformationMarkerStart(v2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            v3 = ComposablesKt.getCurrentCompositeKeyHash(v2, 0);
            CompositionLocalMap v8_3 = v2.getCurrentCompositionLocalMap();
            Modifier v9_5 = ComposedModifierKt.materializeModifier(v2, v7_2);
            Function0 v10_1 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(v2, 0xD6BD0031, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if(!(v2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v2.startReusableNode();
            if(v2.getInserting()) {
                v2.createNode(v10_1);
            }
            else {
                v2.useNode();
            }

            Composer v10_2 = Updater.constructor-impl(v2);
            Updater.set-impl(v10_2, v6_2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v10_2, v8_3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v6_3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v10_2.getInserting()) || !Intrinsics.areEqual(v10_2.rememberedValue(), Integer.valueOf(v3))) {
                v10_2.updateRememberedValue(Integer.valueOf(v3));
                v10_2.apply(Integer.valueOf(v3), v6_3);
            }

            Updater.set-impl(v10_2, v9_5, ComposeUiNode.Companion.getSetModifier());
            v0_5.invoke(v2, Integer.valueOf(0));
            v2.endNode();
            ComposerKt.sourceInformationMarkerEnd(v2);
            ComposerKt.sourceInformationMarkerEnd(v2);
            ComposerKt.sourceInformationMarkerEnd(v2);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_218;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v2.skipToGroupEnd();
            v7_2 = v8;
        }

    label_218:
        v3 = v11;
        ScopeUpdateScope v8_4 = v2.endRestartGroup();
        if(v8_4 != null) {
            v8_4.updateScope(new AppBarRowKt$$ExternalSyntheticLambda1(v1, ((Companion)v7_2), v3, v4, v5, arg22));
        }
    }

    static final AppBarRowScopeImpl AppBarRow$lambda$1$lambda$0(State arg2) {
        AppBarRowScopeImpl v0 = new AppBarRowScopeImpl(new AppBarScopeImpl());
        arg2.getValue().invoke(v0);
        return v0;
    }

    private static final AppBarRowScopeImpl AppBarRow$lambda$2(State arg0) {
        return arg0.getValue();
    }

    static final Unit AppBarRow$lambda$5(Function3 arg7, Modifier arg8, int arg9, Function1 arg10, int arg11, int arg12, Composer arg13, int arg14) {
        AppBarRowKt.AppBarRow(arg7, arg8, arg9, arg10, arg13, RecomposeScopeImplKt.updateChangedFlags(arg11 | 1), arg12);
        return Unit.INSTANCE;
    }

    public static final AppBarRowScopeImpl access$AppBarRow$lambda$2(State arg0) {
        return AppBarRowKt.AppBarRow$lambda$2(arg0);
    }
}

