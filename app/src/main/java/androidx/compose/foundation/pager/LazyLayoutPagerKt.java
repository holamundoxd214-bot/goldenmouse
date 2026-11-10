package androidx.compose.foundation.pager;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.ScrollableAreaKt;
import androidx.compose.foundation.gestures.BringIntoViewSpec;
import androidx.compose.foundation.gestures.BringIntoViewSpec_androidKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocalKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt;
import androidx.compose.foundation.lazy.layout.NearestRangeKeyIndexMap;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment$Horizontal;
import androidx.compose.ui.Alignment$Vertical;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1={"\u0000\u0092\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001Aå\u0001\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\t2\b\u0010\u000F\u001A\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001A\u00020\u00122\b\b\u0002\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u00182#\u0010\u0019\u001A\u001F\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u001B\u0012\b\b\u001C\u0012\u0004\b\b(\u001D\u0012\u0004\u0012\u00020\u001E\u0018\u00010\u001A2\u0006\u0010\u001F\u001A\u00020 2\u0006\u0010!\u001A\u00020\"2\u0006\u0010#\u001A\u00020$21\u0010%\u001A-\u0012\u0004\u0012\u00020\'\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u001B\u0012\b\b\u001C\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u00010&¢\u0006\u0002\b)¢\u0006\u0002\b*H\u0001¢\u0006\u0004\b+\u0010,\u001A\u0081\u0001\u0010-\u001A\b\u0012\u0004\u0012\u00020/0.2\u0006\u0010\u0004\u001A\u00020\u000521\u0010%\u001A-\u0012\u0004\u0012\u00020\'\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u001B\u0012\b\b\u001C\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u00010&¢\u0006\u0002\b)¢\u0006\u0002\b*2#\u0010\u0019\u001A\u001F\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u001B\u0012\b\b\u001C\u0012\u0004\b\b(\u001D\u0012\u0004\u0012\u00020\u001E\u0018\u00010\u001A2\f\u00100\u001A\b\u0012\u0004\u0012\u00020\u00120.H\u0003¢\u0006\u0002\u00101\u001A\u0014\u00102\u001A\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H\u0002¨\u00063"}, d2={"Pager", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/pager/PagerState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "flingBehavior", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "userScrollEnabled", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "beyondViewportPageCount", "", "pageSpacing", "Landroidx/compose/ui/unit/Dp;", "pageSize", "Landroidx/compose/foundation/pager/PageSize;", "pageNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "key", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "snapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "pageContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/pager/PagerScope;", "page", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "Pager-eLwUrMk", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/gestures/TargetedFlingBehavior;ZLandroidx/compose/foundation/OverscrollEffect;IFLandroidx/compose/foundation/pager/PageSize;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "rememberPagerItemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "pageCount", "(Landroidx/compose/foundation/pager/PagerState;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function0;", "dragDirectionDetector", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LazyLayoutPagerKt {
    public static int $r8$lambda$98LggfimmYMbRYvWxUjqbmoNA3E(PagerState arg0) {
        return LazyLayoutPagerKt.Pager_eLwUrMk$lambda$2$0(arg0);
    }

    public static int $r8$lambda$JZ_PysSSUubzaTkSetpMuVjEjOo(PagerState arg0) {
        return LazyLayoutPagerKt.Pager_eLwUrMk$lambda$1$0(arg0);
    }

    public static PagerLazyLayoutItemProvider $r8$lambda$PPuCBKyPKlcfjfOGB5aItnS4LnM(State arg0, PagerState arg1) {
        return LazyLayoutPagerKt.rememberPagerItemProviderLambda$lambda$0$1(arg0, arg1);
    }

    public static PagerLayoutIntervalContent $r8$lambda$knAdVZFQq-bpz27gDN8sXmlNFf8(State arg0, State arg1, Function0 arg2) {
        return LazyLayoutPagerKt.rememberPagerItemProviderLambda$lambda$0$0(arg0, arg1, arg2);
    }

    public static final void Pager-eLwUrMk(Modifier arg31, PagerState arg32, PaddingValues arg33, boolean arg34, Orientation arg35, TargetedFlingBehavior arg36, boolean arg37, OverscrollEffect arg38, int arg39, float arg40, PageSize arg41, NestedScrollConnection arg42, Function1 arg43, Horizontal arg44, Vertical arg45, SnapPosition arg46, Function4 arg47, Composer arg48, int arg49, int arg50, int arg51) {
        float v10_1;
        NestedScrollConnection v3_5;
        Modifier v0_6;
        int v9_1;
        PagerState v11_1;
        LazyLayoutPagerKt$$ExternalSyntheticLambda1 v7_3;
        Composer v6_1;
        LazyLayoutPagerKt$$ExternalSyntheticLambda0 v7_2;
        int v27;
        float v14;
        int v25;
        int v23;
        int v21;
        int v5;
        int v19;
        int v4;
        Modifier v1 = arg31;
        PagerState v2 = arg32;
        boolean v0 = arg34;
        TargetedFlingBehavior v8 = arg36;
        boolean v9 = arg37;
        NestedScrollConnection v10 = arg42;
        int v11 = arg49;
        int v12 = arg50;
        int v13 = arg51;
        Composer v15 = arg48.startRestartGroup(-572816025);
        ComposerKt.sourceInformation(v15, "C(Pager)N(modifier,state,contentPadding,reverseLayout,orientation,flingBehavior,userScrollEnabled,overscrollEffect,beyondViewportPageCount,pageSpacing:c#ui.unit.Dp,pageSize,pageNestedScrollConnection,key,horizontalAlignment,verticalAlignment,snapPosition,pageContent)109@5362L39,109@5277L124,113@5428L24,129@6071L19,116@5486L615,132@6127L70,135@6239L82,137@6381L7,139@6430L121,164@7268L301,159@7099L1450:LazyLayoutPager.kt#g6yjnt");
        if((v11 & 6) == 0) {
            v4 = v15.changed(v1) ? 4 : 2;
            v4 |= v11;
        }
        else {
            v4 = v11;
        }

        if((v11 & 0x30) == 0) {
            int v6 = v15.changed(v2) ? 0x20 : 16;
            v4 |= v6;
        }

        int v17 = 0x80;
        int v18 = 0x100;
        if((v11 & 0x180) == 0) {
            v19 = v15.changed(arg33) ? v18 : v17;
            v4 |= v19;
        }

        v19 = 0x800;
        int v20 = 0x400;
        if((v11 & 0xC00) == 0) {
            v5 = v15.changed(v0) ? v19 : v20;
            v4 |= v5;
        }

        if((v11 & 0x6000) == 0) {
            v5 = v15.changed(arg35.ordinal()) ? 0x4000 : 0x2000;
            v4 |= v5;
        }

        v5 = 0x30000;
        if((v11 & v5) == 0) {
            v21 = v15.changed(v8) ? 0x20000 : 0x10000;
            v4 |= v21;
        }

        v21 = 0x180000;
        if((v11 & v21) == 0) {
            v23 = v15.changed(v9) ? 0x100000 : 0x80000;
            v4 |= v23;
        }

        OverscrollEffect v0_1 = arg38;
        if((v11 & 0xC00000) == 0) {
            v23 = v15.changed(v0_1) ? 0x800000 : 0x400000;
            v4 |= v23;
        }

        int v3 = v13 & 0x100;
        int v24 = 0x6000000;
        if(v3 != 0) {
            v4 |= v24;
            goto label_109;
        }
        else if((v11 & v24) == 0) {
            v24 = v5;
            v25 = v15.changed(arg39) ? 0x4000000 : 0x2000000;
            v4 |= v25;
        }
        else {
        label_109:
            v24 = v5;
        }

        int v7 = v13 & 0x200;
        int v26 = 0x30000000;
        if(v7 != 0) {
            v4 |= v26;
            v14 = arg40;
        }
        else {
            v14 = arg40;
            if((v11 & v26) == 0) {
                v27 = v15.changed(v14) ? 0x20000000 : 0x10000000;
                v4 |= v27;
            }
        }

        PageSize v0_2 = arg41;
        if((v12 & 6) == 0) {
            v27 = v15.changed(v0_2) ? 4 : 2;
            v27 |= v12;
        }
        else {
            v27 = v12;
        }

        if((v12 & 0x30) == 0) {
            v25 = v15.changedInstance(v10) ? 0x20 : 16;
            v27 |= v25;
        }

        if((v12 & 0x180) == 0) {
            if(v15.changedInstance(arg43)) {
                v17 = v18;
            }

            v27 |= v17;
        }

        if((v12 & 0xC00) == 0) {
            if(v15.changed(arg44)) {
            }
            else {
                v19 = v20;
            }

            v27 |= v19;
        }

        if((v12 & 0x6000) == 0) {
            v17 = v15.changed(arg45) ? 0x4000 : 0x2000;
            v27 |= v17;
        }

        SnapPosition v0_3 = arg46;
        if((v12 & v24) == 0) {
            v17 = v15.changed(v0_3) ? 0x20000 : 0x10000;
            v27 |= v17;
        }

        Function4 v0_4 = arg47;
        if((v12 & v21) == 0) {
            v17 = v15.changedInstance(v0_4) ? 0x100000 : 0x80000;
            v27 |= v17;
        }

        int v0_5 = v27;
        v18 = v3;
        boolean v3_1 = (v4 & 306783379) != 306783378 || (0x92493 & v0_5) != 0x92492 ? true : false;
        if(v15.shouldExecute(v3_1, v4 & 1)) {
            v3 = v18 != 0 ? 0 : arg39;
            float v8_1 = v7 != 0 ? Dp.constructor-impl(0f) : v14;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-572816025, v4, v0_5, "androidx.compose.foundation.pager.Pager (LazyLayoutPager.kt:102)");
            }

            v5 = v3 >= 0 ? 1 : 0;
            if(v5 == 0) {
                InlineClassHelperKt.throwIllegalArgumentException("beyondViewportPageCount should be greater than or equal to 0, you selected " + v3);
            }

            String v14_1 = "CC(remember):LazyLayoutPager.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v15, 0xD510CAAE, v14_1);
            v5 = v4 & 0x70;
            int v16 = v5 == 0x20 ? 1 : 0;
            Object v7_1 = v15.rememberedValue();
            if(v16 == 0) {
                arg39 = v3;
                if(v7_1 == Composer.Companion.getEmpty()) {
                    goto label_255;
                }
            }
            else {
                arg39 = v3;
            label_255:
                v7_2 = new LazyLayoutPagerKt$$ExternalSyntheticLambda0(v2);
                v15.updateRememberedValue(v7_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v15);
            v3 = v4 >> 3;
            int v1_1 = v3 & 14;
            v16 = v0_5 >> 15;
            int v2_1 = v1_1 | v16 & 0x70 | v0_5 & 0x380;
            int v48 = v0_5;
            int v29 = v3;
            v18 = v4;
            v0_5 = v5;
            Object v5_1 = v7_2;
            v6_1 = v15;
            int v15_1 = arg39;
            arg39 = v1_1;
            v7 = v2_1;
            v1_1 = 0x20;
            v2 = arg32;
            Function0 v5_2 = LazyLayoutPagerKt.rememberPagerItemProviderLambda(v2, arg47, arg43, ((Function0)v5_1), v6_1, v7);
            ComposerKt.sourceInformationMarkerStart(v6_1, 0x2E20B340, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(v6_1, 0x28C0FDC4, "CC(remember):Effects.kt#9igjgp");
            Object v3_2 = v6_1.rememberedValue();
            if(v3_2 == Composer.Companion.getEmpty()) {
                CoroutineScope v3_3 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, v6_1);
                v6_1.updateRememberedValue(v3_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v6_1);
            ComposerKt.sourceInformationMarkerEnd(v6_1);
            ComposerKt.sourceInformationMarkerStart(v6_1, -720297158, v14_1);
            v4 = v0_5 == v1_1 ? 1 : 0;
            v7_1 = v6_1.rememberedValue();
            if(v4 != 0 || v7_1 == Composer.Companion.getEmpty()) {
                v7_3 = new LazyLayoutPagerKt$$ExternalSyntheticLambda1(v2);
                v6_1.updateRememberedValue(v7_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v6_1);
            v17 = v18 >> 9;
            v21 = 0x70000;
            v4 = v18 & 0xFFF0 | v17 & v21 | v17 & 0x380000;
            v17 = v48 << 15;
            Object v13_1 = v3_2;
            String v1_2 = v14_1;
            PagerState v3_4 = v2;
            Function0 v2_2 = v5_2;
            LazyLayoutMeasurePolicy v14_2 = PagerMeasurePolicyKt.rememberPagerMeasurePolicy-8u0NR3k(v2_2, v3_4, arg33, arg34, arg35, v15_1, v8_1, arg41, arg44, arg45, arg46, ((CoroutineScope)v13_1), v7_3, v6_1, v4 | v48 << 21 & 0x1C00000 | v17 & 0xE000000 | v17 & 0x70000000, v16 & 14);
            boolean v7_4 = arg34;
            Orientation v5_3 = arg35;
            v6_1 = v6_1;
            v15_1 = v15_1;
            v11_1 = v3_4;
            float v12_1 = v8_1;
            boolean v4_1 = v5_3 == Orientation.Vertical ? true : false;
            v3 = arg39;
            LazyLayoutSemanticState v4_2 = PagerSemanticsKt.rememberPagerSemanticState(v11_1, v4_1, v6_1, v3);
            ComposerKt.sourceInformationMarkerStart(v6_1, -720291719, v1_2);
            int v8_2 = v0_5 == 0x20 ? 1 : 0;
            v9_1 = (v18 & v21) == 0x20000 ? 1 : 0;
            v8_2 |= v9_1;
            Object v9_2 = v6_1.rememberedValue();
            if(v8_2 != 0 || v9_2 == Composer.Companion.getEmpty()) {
                PagerWrapperFlingBehavior v9_3 = new PagerWrapperFlingBehavior(arg36, v11_1);
                v6_1.updateRememberedValue(v9_3);
            }

            Object v16_1 = v9_2;
            ComposerKt.sourceInformationMarkerEnd(v6_1);
            ProvidableCompositionLocal v8_3 = BringIntoViewSpec_androidKt.getLocalBringIntoViewSpec();
            Function0 v39 = v2_2;
            ComposerKt.sourceInformationMarkerStart(v6_1, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v2_3 = v6_1.consume(((CompositionLocal)v8_3));
            ComposerKt.sourceInformationMarkerEnd(v6_1);
            ComposerKt.sourceInformationMarkerStart(v6_1, 0xD5115080, v1_2);
            v0_5 = v0_5 == 0x20 ? 1 : 0;
            v0_5 |= v6_1.changed(v2_3);
            Object v1_3 = v6_1.rememberedValue();
            if(v0_5 != 0 || v1_3 == Composer.Companion.getEmpty()) {
                PagerBringIntoViewSpec v1_4 = new PagerBringIntoViewSpec(v11_1, ((BringIntoViewSpec)v2_3));
                v6_1.updateRememberedValue(v1_4);
            }

            ComposerKt.sourceInformationMarkerEnd(v6_1);
            if(arg37) {
                v6_1.startReplaceGroup(0xCD1BB303);
                ComposerKt.sourceInformation(v6_1, "147@6714L167");
                v0_6 = LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(Modifier.Companion, PagerBeyondBoundsModifierKt.rememberPagerBeyondBoundsState(v11_1, v15_1, v6_1, v18 >> 21 & 0x70 | v3), v11_1.getBeyondBoundsInfo$foundation(), v7_4, v5_3);
                v6_1.endReplaceGroup();
            }
            else {
                v6_1.startReplaceGroup(0xCD2241DB);
                v6_1.endReplaceGroup();
                Companion v0_7 = Modifier.Companion;
            }

            Composer v8_4 = v6_1;
            boolean v6_2 = arg37;
            Modifier v2_4 = LazyLayoutSemanticsKt.lazyLayoutSemantics(arg31.then(v11_1.getRemeasurementModifier$foundation()).then(v11_1.getAwaitLayoutModifier$foundation()), v39, v4_2, v5_3, v6_2, v7_4, v8_4, v18 << 6 & v21 | (v29 & 0x1C00 | v18 >> 6 & 0xE000));
            Function0 v18_1 = v39;
            Composer v17_1 = v8_4;
            v3_1 = v5_3 == Orientation.Vertical ? true : false;
            v0_6 = LazyLayoutPagerKt.dragDirectionDetector(ScrollableAreaKt.scrollableArea(PagerKt.pagerSemantics(v2_4, v11_1, v3_1, ((CoroutineScope)v13_1), v6_2).then(v0_6), v11_1, v5_3, arg38, v6_2, arg34, v16_1, v11_1.getInternalInteractionSource$foundation(), v1_3), v11_1);
            v3_5 = arg42;
            LazyLayoutKt.LazyLayout(v18_1, NestedScrollModifierKt.nestedScroll$default(v0_6, v3_5, null, 2, null), v11_1.getPrefetchState$foundation(), v14_2, v17_1, 0, 0);
            v6_1 = v17_1;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v10_1 = v12_1;
            v9_1 = v15_1;
        }
        else {
            v11_1 = v2;
            v3_5 = v10;
            v6_1 = v15;
            v6_1.skipToGroupEnd();
            v9_1 = arg39;
            v10_1 = v14;
        }

        ScopeUpdateScope v0_8 = v6_1.endRestartGroup();
        if(v0_8 != null) {
            v0_8.updateScope(new LazyLayoutPagerKt$$ExternalSyntheticLambda2(arg31, v11_1, arg33, arg34, arg35, arg36, arg37, arg38, v9_1, v10_1, arg41, v3_5, arg43, arg44, arg45, arg46, arg47, arg49, arg50, arg51));
        }
    }

    private static final int Pager_eLwUrMk$lambda$1$0(PagerState arg0) {
        return arg0.getPageCount();
    }

    private static final int Pager_eLwUrMk$lambda$2$0(PagerState arg0) {
        return arg0.getPageCount();
    }

    static final Unit Pager_eLwUrMk$lambda$5(Modifier arg22, PagerState arg23, PaddingValues arg24, boolean arg25, Orientation arg26, TargetedFlingBehavior arg27, boolean arg28, OverscrollEffect arg29, int arg30, float arg31, PageSize arg32, NestedScrollConnection arg33, Function1 arg34, Horizontal arg35, Vertical arg36, SnapPosition arg37, Function4 arg38, int arg39, int arg40, int arg41, Composer arg42, int arg43) {
        LazyLayoutPagerKt.Pager-eLwUrMk(arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg35, arg36, arg37, arg38, arg42, RecomposeScopeImplKt.updateChangedFlags(arg39 | 1), RecomposeScopeImplKt.updateChangedFlags(arg40), arg41);
        return Unit.INSTANCE;
    }

    private static final Modifier dragDirectionDetector(Modifier arg2, PagerState arg3) {
        return arg2.then(SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion, arg3, new LazyLayoutPagerKt$dragDirectionDetector$1(arg3)));
    }

    private static final Function0 rememberPagerItemProviderLambda(PagerState arg5, Function4 arg6, Function1 arg7, Function0 arg8, Composer arg9, int arg10) {
        LazyLayoutPagerKt$rememberPagerItemProviderLambda$1$1 v0_2;
        int v1 = 1052364153;
        ComposerKt.sourceInformationMarkerStart(arg9, v1, "C(rememberPagerItemProviderLambda)N(state,pageContent,key,pageCount)258@10763L33,259@10817L25,260@10854L742:LazyLayoutPager.kt#g6yjnt");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg10, -1, "androidx.compose.foundation.pager.rememberPagerItemProviderLambda (LazyLayoutPager.kt:257)");
        }

        State v6 = SnapshotStateKt.rememberUpdatedState(arg6, arg9, arg10 >> 3 & 14);
        State v7 = SnapshotStateKt.rememberUpdatedState(arg7, arg9, arg10 >> 6 & 14);
        ComposerKt.sourceInformationMarkerStart(arg9, 2004647903, "CC(remember):LazyLayoutPager.kt#9igjgp");
        v1 = 0;
        int v3 = 4;
        int v0 = (arg10 & 14 ^ 6) > v3 && (arg9.changed(arg5)) || (arg10 & 6) == v3 ? 1 : 0;
        v0 = v0 | arg9.changed(v6) | arg9.changed(v7);
        int v4 = 0x800;
        if((arg10 & 0x1C00 ^ 0xC00) > v4 && (arg9.changed(arg8)) || (arg10 & 0xC00) == v4) {
            v1 = 1;
        }

        arg10 = v0 | v1;
        Object v0_1 = arg9.rememberedValue();
        if(arg10 != 0 || v0_1 == Composer.Companion.getEmpty()) {
            v0_2 = new LazyLayoutPagerKt$rememberPagerItemProviderLambda$1$1(SnapshotStateKt.derivedStateOf(SnapshotStateKt.referentialEqualityPolicy(), new LazyLayoutPagerKt$$ExternalSyntheticLambda4(SnapshotStateKt.derivedStateOf(SnapshotStateKt.referentialEqualityPolicy(), new LazyLayoutPagerKt$$ExternalSyntheticLambda3(v6, v7, arg8)), arg5)));
            arg9.updateRememberedValue(v0_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg9);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg9);
        return ((Function0)v0_2);
    }

    private static final PagerLayoutIntervalContent rememberPagerItemProviderLambda$lambda$0$0(State arg1, State arg2, Function0 arg3) {
        return new PagerLayoutIntervalContent(arg1.getValue(), arg2.getValue(), arg3.invoke().intValue());
    }

    private static final PagerLazyLayoutItemProvider rememberPagerItemProviderLambda$lambda$0$1(State arg2, PagerState arg3) {
        Object v2 = arg2.getValue();
        return new PagerLazyLayoutItemProvider(arg3, ((LazyLayoutIntervalContent)v2), new NearestRangeKeyIndexMap(arg3.getNearestRange$foundation(), ((LazyLayoutIntervalContent)v2)));
    }
}

