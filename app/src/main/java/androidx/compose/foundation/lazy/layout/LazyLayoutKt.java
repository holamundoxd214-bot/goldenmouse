package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u001AP\u0010\u0000\u001A\u00020\u00012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00062\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\b2\u001D\u0010\t\u001A\u0019\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\n¢\u0006\u0002\b\u000EH\u0007¢\u0006\u0002\u0010\u000F\u001A9\u0010\u0000\u001A\u00020\u00012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00062\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\b2\u0006\u0010\t\u001A\u00020\u0010H\u0007¢\u0006\u0002\u0010\u0011\"\u000E\u0010\u0012\u001A\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2={"LazyLayout", "", "itemProvider", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "modifier", "Landroidx/compose/ui/Modifier;", "prefetchState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "measurePolicy", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasurePolicy;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasurePolicy;Landroidx/compose/runtime/Composer;II)V", "MaxItemsToRetainForReuse", "", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LazyLayoutKt {
    private static final int MaxItemsToRetainForReuse = 7;

    public static LazyLayoutItemProvider $r8$lambda$Altz_WGm0MS973MAtS5ZLmX1CD0(State arg0) {
        return LazyLayoutKt.LazyLayout$lambda$1$0$0(arg0);
    }

    public static DisposableEffectResult $r8$lambda$nAm-ve6PXT8Mp14swbWq987wENs(LazyLayoutPrefetchState arg0, LazyLayoutItemContentFactory arg1, SubcomposeLayoutState arg2, PrefetchScheduler arg3, DisposableEffectScope arg4) {
        return LazyLayoutKt.LazyLayout$lambda$1$2$0(arg0, arg1, arg2, arg3, arg4);
    }

    public static MeasureResult $r8$lambda$rf3vllu87hDgmhs57JbwRZ1rpS4(LazyLayoutItemContentFactory arg0, LazyLayoutMeasurePolicy arg1, SubcomposeMeasureScope arg2, Constraints arg3) {
        return LazyLayoutKt.LazyLayout$lambda$1$3$0(arg0, arg1, arg2, arg3);
    }

    public static final void LazyLayout(Function0 arg8, Modifier arg9, LazyLayoutPrefetchState arg10, LazyLayoutMeasurePolicy arg11, Composer arg12, int arg13, int arg14) {
        Companion v9;
        boolean v4_1;
        int v4;
        int v3;
        int v1;
        int v0 = 1055276397;
        arg12 = arg12.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg12, "C(LazyLayout)N(itemProvider,modifier,prefetchState,measurePolicy)112@5811L34,114@5883L1376,114@5851L1408:LazyLayout.kt#wow0x6");
        if((arg13 & 6) == 0) {
            v1 = arg12.changedInstance(arg8) ? 4 : 2;
            v1 |= arg13;
        }
        else {
            v1 = arg13;
        }

        int v2 = arg14 & 2;
        if(v2 != 0) {
            v1 |= 0x30;
        }
        else if((arg13 & 0x30) == 0) {
            v3 = arg12.changed(arg9) ? 0x20 : 16;
            v1 |= v3;
        }

        v3 = arg14 & 4;
        if(v3 != 0) {
            v1 |= 0x180;
        }
        else if((arg13 & 0x180) == 0) {
            v4 = arg12.changed(arg10) ? 0x100 : 0x80;
            v1 |= v4;
        }

        if((arg13 & 0xC00) == 0) {
            v4_1 = (arg13 & 0x1000) == 0 ? arg12.changed(arg11) : arg12.changedInstance(arg11);
            v4 = v4_1 ? 0x800 : 0x400;
            v1 |= v4;
        }

        v4_1 = (v1 & 0x493) != 1170 ? true : false;
        if(arg12.shouldExecute(v4_1, v1 & 1)) {
            if(v2 != 0) {
                v9 = Modifier.Companion;
            }

            if(v3 != 0) {
                arg10 = null;
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.foundation.lazy.layout.LazyLayout (LazyLayout.kt:111)");
            }

            LazySaveableStateHolderKt.LazySaveableStateHolderProvider(ComposableLambdaKt.rememberComposableLambda(0xC8613495, true, new LazyLayoutKt$$ExternalSyntheticLambda1(arg10, ((Modifier)v9), arg11, SnapshotStateKt.rememberUpdatedState(arg8, arg12, v1 & 14)), arg12, 54), arg12, 6);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_83;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg12.skipToGroupEnd();
        }

    label_83:
        Modifier v3_1 = ((Modifier)v9);
        LazyLayoutPrefetchState v4_2 = arg10;
        ScopeUpdateScope v9_1 = arg12.endRestartGroup();
        if(v9_1 != null) {
            v9_1.updateScope(new LazyLayoutKt$$ExternalSyntheticLambda2(arg8, v3_1, v4_2, arg11, arg13, arg14));
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Please use overload with LazyLayoutMeasurePolicy") public static final void LazyLayout(Function0 arg13, Modifier arg14, LazyLayoutPrefetchState arg15, Function2 arg16, Composer arg17, int arg18, int arg19) {
        LazyLayoutPrefetchState v3_1;
        Modifier v2_1;
        Companion v14;
        int v7;
        int v3;
        int v1;
        Function2 v4 = arg16;
        int v5 = arg18;
        int v0 = 2002163445;
        Composer v10 = arg17.startRestartGroup(v0);
        ComposerKt.sourceInformation(v10, "C(LazyLayout)N(itemProvider,modifier,prefetchState,measurePolicy)68@3299L89:LazyLayout.kt#wow0x6");
        if((v5 & 6) == 0) {
            v1 = v10.changedInstance(arg13) ? 4 : 2;
            v1 |= v5;
        }
        else {
            v1 = v5;
        }

        int v2 = arg19 & 2;
        if(v2 != 0) {
            v1 |= 0x30;
        }
        else if((v5 & 0x30) == 0) {
            v3 = v10.changed(arg14) ? 0x20 : 16;
            v1 |= v3;
        }

        v3 = arg19 & 4;
        if(v3 != 0) {
            v1 |= 0x180;
        }
        else if((v5 & 0x180) == 0) {
            v7 = v10.changed(arg15) ? 0x100 : 0x80;
            v1 |= v7;
        }

        if((v5 & 0xC00) == 0) {
            v7 = v10.changedInstance(v4) ? 0x800 : 0x400;
            v1 |= v7;
        }

        boolean v7_1 = (v1 & 0x493) != 1170 ? true : false;
        if(v10.shouldExecute(v7_1, v1 & 1)) {
            if(v2 != 0) {
                v14 = Modifier.Companion;
            }

            Modifier v7_2 = ((Modifier)v14);
            LazyLayoutPrefetchState v8 = v3 != 0 ? null : arg15;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.foundation.lazy.layout.LazyLayout (LazyLayout.kt:68)");
            }

            LazyLayoutKt.LazyLayout(arg13, v7_2, v8, new LazyLayoutKt$sam$androidx_compose_foundation_lazy_layout_LazyLayoutMeasurePolicy$0(v4), v10, v1 & 0x3FE, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_1 = v7_2;
            v3_1 = v8;
        }
        else {
            v10.skipToGroupEnd();
            v2_1 = arg14;
            v3_1 = arg15;
        }

        ScopeUpdateScope v14_1 = v10.endRestartGroup();
        if(v14_1 != null) {
            v14_1.updateScope(new LazyLayoutKt$$ExternalSyntheticLambda0(arg13, v2_1, v3_1, v4, v5, arg19));
        }
    }

    static final Unit LazyLayout$lambda$0(Function0 arg7, Modifier arg8, LazyLayoutPrefetchState arg9, Function2 arg10, int arg11, int arg12, Composer arg13, int arg14) {
        LazyLayoutKt.LazyLayout(arg7, arg8, arg9, arg10, arg13, RecomposeScopeImplKt.updateChangedFlags(arg11 | 1), arg12);
        return Unit.INSTANCE;
    }

    static final Unit LazyLayout$lambda$1(LazyLayoutPrefetchState arg7, Modifier arg8, LazyLayoutMeasurePolicy arg9, State arg10, SaveableStateHolder arg11, Composer arg12, int arg13) {
        LazyLayoutKt$$ExternalSyntheticLambda4 v4_1;
        SubcomposeLayoutState v10_1;
        LazyLayoutItemContentFactory v13_1;
        ComposerKt.sourceInformation(arg12, "CN(saveableStateHolder)115@5941L114,118@6092L101,137@6976L266,134@6849L404:LazyLayout.kt#wow0x6");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(0xC8613495, arg13, -1, "androidx.compose.foundation.lazy.layout.LazyLayout.<anonymous> (LazyLayout.kt:115)");
        }

        String v0 = "CC(remember):LazyLayout.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(arg12, 0x34E66B07, v0);
        Object v13 = arg12.rememberedValue();
        if(v13 == Composer.Companion.getEmpty()) {
            v13_1 = new LazyLayoutItemContentFactory(arg11, new LazyLayoutKt$$ExternalSyntheticLambda3(arg10));
            arg12.updateRememberedValue(v13_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg12);
        ComposerKt.sourceInformationMarkerStart(arg12, 887520730, v0);
        Object v10 = arg12.rememberedValue();
        if(v10 == Composer.Companion.getEmpty()) {
            v10_1 = new SubcomposeLayoutState(new LazyLayoutItemReusePolicy(v13_1));
            arg12.updateRememberedValue(v10_1);
        }

        Object v1 = v10_1;
        ComposerKt.sourceInformationMarkerEnd(arg12);
        if(arg7 != null) {
            arg12.startReplaceGroup(1743490539);
            ComposerKt.sourceInformation(arg12, "123@6425L404,123@6340L489");
            PrefetchScheduler v10_2 = arg7.getPrefetchScheduler$foundation();
            if(v10_2 == null) {
                arg12.startReplaceGroup(887527095);
                ComposerKt.sourceInformation(arg12, "122@6293L34");
                v10_2 = PrefetchScheduler_androidKt.rememberDefaultPrefetchScheduler(arg12, 0);
            }
            else {
                arg12.startReplaceGroup(887526010);
            }

            arg12.endReplaceGroup();
            Object[] v2 = new Object[]{arg7, v13_1, v1, v10_2};
            ComposerKt.sourceInformationMarkerStart(arg12, 0x34E6A8A9, v0);
            int v3 = arg12.changed(arg7) | arg12.changedInstance(v13_1) | arg12.changedInstance(v1) | arg12.changedInstance(v10_2);
            Object v4 = arg12.rememberedValue();
            if(v3 != 0 || v4 == Composer.Companion.getEmpty()) {
                v4_1 = new LazyLayoutKt$$ExternalSyntheticLambda4(arg7, v13_1, ((SubcomposeLayoutState)v1), v10_2);
                arg12.updateRememberedValue(v4_1);
            }

            ComposerKt.sourceInformationMarkerEnd(arg12);
            EffectsKt.DisposableEffect(v2, ((Function1)v4_1), arg12, 0);
        }
        else {
            arg12.startReplaceGroup(0x678CF6CD);
        }

        arg12.endReplaceGroup();
        Modifier v2_1 = LazyLayoutPrefetchStateKt.traversablePrefetchState(arg8, arg7);
        ComposerKt.sourceInformationMarkerStart(arg12, 0x34E6ECFF, v0);
        int v7 = arg12.changed(v13_1) | arg12.changed(arg9);
        Object v8 = arg12.rememberedValue();
        if(v7 != 0 || v8 == Composer.Companion.getEmpty()) {
            LazyLayoutKt$$ExternalSyntheticLambda5 v8_1 = new LazyLayoutKt$$ExternalSyntheticLambda5(v13_1, arg9);
            arg12.updateRememberedValue(v8_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg12);
        SubcomposeLayoutKt.SubcomposeLayout(((SubcomposeLayoutState)v1), v2_1, v8, arg12, SubcomposeLayoutState.$stable, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        return Unit.INSTANCE;
    }

    private static final LazyLayoutItemProvider LazyLayout$lambda$1$0$0(State arg0) {
        return arg0.getValue().invoke();
    }

    private static final DisposableEffectResult LazyLayout$lambda$1$2$0(LazyLayoutPrefetchState arg0, LazyLayoutItemContentFactory arg1, SubcomposeLayoutState arg2, PrefetchScheduler arg3, DisposableEffectScope arg4) {
        arg0.setPrefetchHandleProvider$foundation(new PrefetchHandleProvider(arg1, arg2, arg3));
        return new LazyLayoutKt$LazyLayout$lambda$1$2$0$$inlined$onDispose$1(arg0);
    }

    private static final MeasureResult LazyLayout$lambda$1$3$0(LazyLayoutItemContentFactory arg1, LazyLayoutMeasurePolicy arg2, SubcomposeMeasureScope arg3, Constraints arg4) {
        return arg2.measure-0kLqBqw(new LazyLayoutMeasureScopeImpl(arg1, arg3), arg4.unbox-impl());
    }

    static final Unit LazyLayout$lambda$2(Function0 arg7, Modifier arg8, LazyLayoutPrefetchState arg9, LazyLayoutMeasurePolicy arg10, int arg11, int arg12, Composer arg13, int arg14) {
        LazyLayoutKt.LazyLayout(arg7, arg8, arg9, arg10, arg13, RecomposeScopeImplKt.updateChangedFlags(arg11 | 1), arg12);
        return Unit.INSTANCE;
    }
}

