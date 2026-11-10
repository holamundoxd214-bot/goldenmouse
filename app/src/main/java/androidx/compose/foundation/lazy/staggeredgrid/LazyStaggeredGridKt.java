package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.ScrollableAreaKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocalKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1={"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\u0090\u0001\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\r2\b\u0010\u0011\u001A\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001A\u00020\u00142\b\b\u0002\u0010\u0015\u001A\u00020\u00142\u0017\u0010\u0016\u001A\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00010\u0017¢\u0006\u0002\b\u0019H\u0001¢\u0006\u0004\b\u001A\u0010\u001B¨\u0006\u001C"}, d2={"LazyStaggeredGrid", "", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "slots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;", "modifier", "Landroidx/compose/ui/Modifier;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "mainAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisSpacing", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;", "Lkotlin/ExtensionFunctionType;", "LazyStaggeredGrid-w41Enmo", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/OverscrollEffect;FFLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LazyStaggeredGridKt {
    public static final void LazyStaggeredGrid-w41Enmo(LazyStaggeredGridState arg25, Orientation arg26, LazyGridStaggeredGridSlotsProvider arg27, Modifier arg28, PaddingValues arg29, boolean arg30, FlingBehavior arg31, boolean arg32, OverscrollEffect arg33, float arg34, float arg35, Function1 arg36, Composer arg37, int arg38, int arg39, int arg40) {
        boolean v6_1;
        float v11_3;
        float v10_3;
        PaddingValues v5_3;
        boolean v8_3;
        Modifier v4_4;
        FlingBehavior v7_3;
        Composer v12_2;
        Modifier v3_3;
        CoroutineScope v4_3;
        Modifier v14_1;
        boolean v5_1;
        PaddingValues v2_2;
        FlingBehavior v16_1;
        float v7_2;
        float v8_1;
        Companion v2_3;
        int v22;
        int v21;
        boolean v9;
        int v18;
        FlingBehavior v5;
        int v16;
        PaddingValues v14;
        int v11;
        Modifier v10;
        int v7;
        int v2;
        LazyStaggeredGridState v0 = arg25;
        LazyGridStaggeredGridSlotsProvider v3 = arg27;
        Function1 v12 = arg36;
        int v13 = arg38;
        int v15 = arg40;
        Composer v6 = arg37.startRestartGroup(-1904835166);
        ComposerKt.sourceInformation(v6, "C(LazyStaggeredGrid)N(state,orientation,slots,modifier,contentPadding,reverseLayout,flingBehavior,userScrollEnabled,overscrollEffect,mainAxisSpacing:c#ui.unit.Dp,crossAxisSpacing:c#ui.unit.Dp,content)63@2868L55,64@2949L24,65@3021L7,67@3061L311,79@3397L60,98@4044L302,93@3875L1116:LazyStaggeredGrid.kt#fzvcnm");
        if((v13 & 6) == 0) {
            v2 = v6.changed(v0) ? 4 : 2;
            v2 |= v13;
        }
        else {
            v2 = v13;
        }

        if((v13 & 0x30) == 0) {
            v7 = v6.changed(arg26.ordinal()) ? 0x20 : 16;
            v2 |= v7;
        }

        if((v13 & 0x180) == 0) {
            boolean v7_1 = (v13 & 0x200) == 0 ? v6.changed(v3) : v6.changedInstance(v3);
            v7 = v7_1 ? 0x100 : 0x80;
            v2 |= v7;
        }

        v7 = v15 & 8;
        if(v7 != 0) {
            v2 |= 0xC00;
            goto label_56;
        }
        else if((v13 & 0xC00) == 0) {
            v10 = arg28;
            v11 = v6.changed(v10) ? 0x800 : 0x400;
            v2 |= v11;
        }
        else {
        label_56:
            v10 = arg28;
        }

        v11 = v15 & 16;
        if(v11 != 0) {
            v2 |= 0x6000;
            goto label_71;
        }
        else if((v13 & 0x6000) == 0) {
            v14 = arg29;
            v16 = v6.changed(v14) ? 0x4000 : 0x2000;
            v2 |= v16;
        }
        else {
        label_71:
            v14 = arg29;
        }

        v16 = v15 & 0x20;
        int v17 = 0x30000;
        if(v16 != 0) {
            v2 |= v17;
        }
        else {
            boolean v4 = arg30;
            if((v13 & v17) == 0) {
                v17 = v6.changed(v4) ? 0x20000 : 0x10000;
                v2 |= v17;
            }
        }

        if((v13 & 0x180000) == 0) {
            v5 = arg31;
            v18 = (v15 & 0x40) != 0 || !v6.changed(v5) ? 0x80000 : 0x100000;
            v2 |= v18;
        }
        else {
            v5 = arg31;
        }

        int v8 = v15 & 0x80;
        int v19 = 0xC00000;
        if(v8 != 0) {
            v2 |= v19;
            v9 = arg32;
        }
        else {
            v9 = arg32;
            if((v13 & v19) == 0) {
                int v20 = v6.changed(v9) ? 0x800000 : 0x400000;
                v2 |= v20;
            }
        }

        OverscrollEffect v1 = arg33;
        if((v13 & 0x6000000) == 0) {
            v21 = v6.changed(v1) ? 0x4000000 : 0x2000000;
            v2 |= v21;
        }

        int v1_1 = v15 & 0x200;
        v21 = 0x30000000;
        if(v1_1 != 0) {
            v2 |= v21;
            goto label_142;
        }
        else if((v13 & v21) == 0) {
            v21 = v1_1;
            v22 = v6.changed(arg34) ? 0x20000000 : 0x10000000;
            v2 |= v22;
        }
        else {
        label_142:
            v21 = v1_1;
        }

        v1_1 = v15 & 0x400;
        if(v1_1 != 0) {
            v17 = arg39 | 6;
            v22 = v1_1;
        }
        else if((arg39 & 6) == 0) {
            v22 = v1_1;
            v17 = v6.changed(arg35) ? 4 : 2;
            v17 |= arg39;
        }
        else {
            v22 = v1_1;
            v17 = arg39;
        }

        if((arg39 & 0x30) == 0) {
            v18 = v6.changedInstance(v12) ? 0x20 : 16;
            v17 |= v18;
        }

        v1_1 = v17;
        int v37 = v2;
        boolean v17_1 = false;
        int v4_1 = 18;
        boolean v18_1 = true;
        boolean v2_1 = (v37 & 306783379) != 306783378 || (v1_1 & 19) != v4_1 ? true : false;
        if(v6.shouldExecute(v2_1, v37 & 1)) {
            v6.startDefaults();
            ComposerKt.sourceInformation(v6, "51@2361L15");
            int v3_1 = 0xFFC7FFFF;
            if((v13 & 1) == 0 || (v6.getDefaultsInvalid())) {
                if(v7 != 0) {
                    v2_3 = Modifier.Companion;
                }
                else {
                    Modifier v2_4 = v10;
                }

                PaddingValues v10_1 = v11 != 0 ? PaddingKt.PaddingValues-0680j_4(Dp.constructor-impl(0f)) : v14;
                if(v16 != 0) {
                }
                else {
                    v17_1 = arg30;
                }

                if((v15 & 0x40) != 0) {
                    v5 = ScrollableDefaults.INSTANCE.flingBehavior(v6, 6);
                    v3_1 &= v37;
                }
                else {
                    v3_1 = v37;
                }

                if(v8 != 0) {
                }
                else {
                    v18_1 = v9;
                }

                v8_1 = v21 != 0 ? Dp.constructor-impl(0f) : arg34;
                v7_2 = v22 != 0 ? Dp.constructor-impl(0f) : arg35;
                Companion v14_2 = v2_3;
                v16_1 = v5;
                v2_2 = v10_1;
                v5_1 = v17_1;
            }
            else {
                v6.skipToGroupEnd();
                if((v15 & 0x40) != 0) {
                    v8_1 = arg34;
                    v7_2 = arg35;
                    v3_1 &= v37;
                }
                else {
                    v8_1 = arg34;
                    v7_2 = arg35;
                    v3_1 = v37;
                }

                v16_1 = v5;
                v18_1 = v9;
                v2_2 = v14;
                v5_1 = arg30;
                v14_1 = v10;
            }

            v6.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1904835166, v3_1, v1_1, "androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGrid (LazyStaggeredGrid.kt:62)");
            }

            int v9_1 = v3_1 & 14;
            Function0 v10_2 = LazyStaggeredGridItemProviderKt.rememberStaggeredGridItemProviderLambda(v0, v12, v6, v1_1 & 0x70 | v9_1);
            ComposerKt.sourceInformationMarkerStart(v6, 0x2E20B340, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(v6, 0x28C0FDC4, "CC(remember):Effects.kt#9igjgp");
            Object v4_2 = v6.rememberedValue();
            if(v4_2 == Composer.Companion.getEmpty()) {
                v4_3 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, v6);
                v6.updateRememberedValue(v4_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v6);
            ComposerKt.sourceInformationMarkerEnd(v6);
            ProvidableCompositionLocal v11_1 = CompositionLocalsKt.getLocalGraphicsContext();
            v17 = v1_1;
            ComposerKt.sourceInformationMarkerStart(v6, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v0_1 = v6.consume(((CompositionLocal)v11_1));
            ComposerKt.sourceInformationMarkerEnd(v6);
            v1_1 = v3_1 >> 6;
            v19 = v3_1 >> 12;
            v11 = v3_1 << 18 & 0xE000000 | (v1_1 & 0x1C00 | (v1_1 & 0x380 | v9_1) | v3_1 << 9 & 0xE000 | v19 & 0x70000 | v17 << 18 & 0x380000);
            v17 = v3_1;
            boolean v3_2 = v5_1;
            float v5_2 = v8_1;
            int v12_1 = v9_1;
            Function0 v1_2 = v10_2;
            LazyLayoutMeasurePolicy v11_2 = LazyStaggeredGridMeasurePolicyKt.rememberStaggeredGridMeasurePolicy-qKj4JfE(arg25, v1_2, v2_2, v3_2, arg26, v5_2, v7_2, v4_3, arg27, v0_1, v6, v11);
            LazyStaggeredGridState v8_2 = arg25;
            PaddingValues v20_1 = v2_2;
            Orientation v2_5 = arg26;
            float v21_1 = v5_2;
            float v22_1 = v7_2;
            v6 = v6;
            v5_1 = v3_2;
            LazyLayoutSemanticState v0_2 = LazyStaggeredGridSemanticsKt.rememberLazyStaggeredGridSemanticState(v8_2, v5_1, v6, v19 & 0x70 | v12_1);
            if(v18_1) {
                v6.startReplaceGroup(0x92A6480A);
                ComposerKt.sourceInformation(v6, "84@3600L57");
                v3_3 = LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(Modifier.Companion, LazyStaggeredGridBeyondBoundsModifierKt.rememberLazyStaggeredGridBeyondBoundsState(v8_2, v6, v12_1), v8_2.getBeyondBoundsInfo$foundation(), v5_1, v2_5);
                v6.endReplaceGroup();
            }
            else {
                v6.startReplaceGroup(0x92AAEEE0);
                v6.endReplaceGroup();
                Companion v3_4 = Modifier.Companion;
            }

            Modifier v0_3 = LazyLayoutSemanticsKt.lazyLayoutSemantics(v14_1.then(v8_2.getRemeasurementModifier$foundation()).then(v8_2.getAwaitLayoutModifier$foundation()), v1_2, v0_2, v2_5, v18_1, v5_1, v6, v17 & 0x70000 | (v17 << 6 & 0x1C00 | v17 >> 9 & 0xE000));
            Function0 v17_2 = v1_2;
            boolean v1_3 = v5_1;
            FlingBehavior v9_2 = v16_1;
            v6 = v6;
            LazyLayoutKt.LazyLayout(v17_2, ScrollableAreaKt.scrollableArea$default(v0_3.then(v3_3).then(v8_2.getItemAnimator$foundation().getModifier()), v8_2, arg26, arg33, v18_1, v5_1, v16_1, v8_2.getMutableInteractionSource$foundation(), null, 0x80, null), arg25.getPrefetchState$foundation(), v11_2, v6, 0, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v12_2 = v6;
            v7_3 = v9_2;
            v4_4 = v14_1;
            v8_3 = v18_1;
            v5_3 = v20_1;
            v10_3 = v21_1;
            v11_3 = v22_1;
            v6_1 = v1_3;
        }
        else {
            v6.skipToGroupEnd();
            v11_3 = arg35;
            v7_3 = v5;
            v12_2 = v6;
            v8_3 = v9;
            v4_4 = v10;
            v5_3 = v14;
            v6_1 = arg30;
            v10_3 = arg34;
        }

        ScopeUpdateScope v0_4 = v12_2.endRestartGroup();
        if(v0_4 != null) {
            v0_4.updateScope(new LazyStaggeredGridKt$$ExternalSyntheticLambda0(arg25, arg26, arg27, v4_4, v5_3, v6_1, v7_3, v8_3, arg33, v10_3, v11_3, arg36, v13, arg39, v15));
        }
    }

    static final Unit LazyStaggeredGrid_w41Enmo$lambda$0(LazyStaggeredGridState arg17, Orientation arg18, LazyGridStaggeredGridSlotsProvider arg19, Modifier arg20, PaddingValues arg21, boolean arg22, FlingBehavior arg23, boolean arg24, OverscrollEffect arg25, float arg26, float arg27, Function1 arg28, int arg29, int arg30, int arg31, Composer arg32, int arg33) {
        LazyStaggeredGridKt.LazyStaggeredGrid-w41Enmo(arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg32, RecomposeScopeImplKt.updateChangedFlags(arg29 | 1), RecomposeScopeImplKt.updateChangedFlags(arg30), arg31);
        return Unit.INSTANCE;
    }
}

