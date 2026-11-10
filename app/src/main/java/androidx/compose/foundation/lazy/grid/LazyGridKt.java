package androidx.compose.foundation.lazy.grid;

import android.os.Trace;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.ScrollableAreaKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.layout.Arrangement$Horizontal;
import androidx.compose.foundation.layout.Arrangement$Vertical;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.CacheWindowLogic;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocalKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt;
import androidx.compose.foundation.lazy.layout.StickyItemsPlacement;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1={"\u0000\u0092\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\u0088\u0001\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u000B2\b\b\u0002\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u000B2\b\u0010\u0010\u001A\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00152\u0017\u0010\u0016\u001A\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00010\u0017¢\u0006\u0002\b\u0019H\u0001¢\u0006\u0002\u0010\u001A\u001Aq\u0010\u001B\u001A\u00020\u001C2\f\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\u001F0\u001E2\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u000B2\b\u0010\u0014\u001A\u0004\u0018\u00010\u00152\b\u0010\u0012\u001A\u0004\u0018\u00010\u00132\u0006\u0010 \u001A\u00020!2\u0006\u0010\"\u001A\u00020#2\b\u0010$\u001A\u0004\u0018\u00010%H\u0003¢\u0006\u0002\u0010&\u001A*\u0010\'\u001A\u00020\u0001*\u00020(2\u0006\u0010)\u001A\u00020*2\f\u0010+\u001A\b\u0012\u0004\u0012\u00020-0,2\u0006\u0010.\u001A\u00020/H\u0002¨\u00060"}, d2={"LazyGrid", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "slots", "Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "isVertical", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/grid/LazyGridScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/OverscrollEffect;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "rememberLazyGridMeasurePolicy", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasurePolicy;", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "stickyItemsScrollBehavior", "Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/graphics/GraphicsContext;Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasurePolicy;", "keepAroundItems", "Landroidx/compose/foundation/lazy/layout/CacheWindowLogic;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "visibleItemsList", "", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "measuredLineProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLineProvider;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LazyGridKt {
    public static final void LazyGrid(Modifier arg23, LazyGridState arg24, LazyGridSlotsProvider arg25, PaddingValues arg26, boolean arg27, boolean arg28, FlingBehavior arg29, boolean arg30, OverscrollEffect arg31, Vertical arg32, Horizontal arg33, Function1 arg34, Composer arg35, int arg36, int arg37, int arg38) {
        PaddingValues v4_2;
        FlingBehavior v7_2;
        Modifier v1_3;
        LazyGridState v11_4;
        CoroutineScope v11_3;
        FlingBehavior v16_1;
        int v7_1;
        Modifier v2_2;
        PaddingValues v3_2;
        boolean v4_1;
        int v8_1;
        int v17;
        int v19;
        FlingBehavior v12;
        int v18;
        boolean v8;
        int v16;
        PaddingValues v7;
        int v11;
        Modifier v9;
        int v10;
        LazyGridState v1 = arg24;
        LazyGridSlotsProvider v2 = arg25;
        boolean v5 = arg28;
        boolean v14 = arg30;
        Function1 v15 = arg34;
        int v0 = arg36;
        Composer v6 = arg35.startRestartGroup(708740370);
        ComposerKt.sourceInformation(v6, "C(LazyGrid)N(modifier,state,slots,contentPadding,reverseLayout,isVertical,flingBehavior,userScrollEnabled,overscrollEffect,verticalArrangement,horizontalArrangement,content)84@4015L50,86@4091L51,88@4169L24,89@4241L7,90@4310L7,93@4351L404,126@5421L302,121@5252L1117:LazyGrid.kt#7791vq");
        int v4 = arg38 & 1;
        if(v4 != 0) {
            v10 = v0 | 6;
            v9 = arg23;
        }
        else if((v0 & 6) == 0) {
            v9 = arg23;
            v10 = v6.changed(v9) ? 4 : 2;
            v10 |= v0;
        }
        else {
            v9 = arg23;
            v10 = v0;
        }

        if((v0 & 0x30) == 0) {
            v11 = v6.changed(v1) ? 0x20 : 16;
            v10 |= v11;
        }

        if((v0 & 0x180) == 0) {
            boolean v11_1 = (v0 & 0x200) == 0 ? v6.changed(v2) : v6.changedInstance(v2);
            v11 = v11_1 ? 0x100 : 0x80;
            v10 |= v11;
        }

        v11 = arg38 & 8;
        if(v11 != 0) {
            v10 |= 0xC00;
            goto label_63;
        }
        else if((v0 & 0xC00) == 0) {
            v7 = arg26;
            v16 = v6.changed(v7) ? 0x800 : 0x400;
            v10 |= v16;
        }
        else {
        label_63:
            v7 = arg26;
        }

        v16 = arg38 & 16;
        if(v16 != 0) {
            v10 |= 0x6000;
            goto label_78;
        }
        else if((v0 & 0x6000) == 0) {
            v8 = arg27;
            v18 = v6.changed(v8) ? 0x4000 : 0x2000;
            v10 |= v18;
        }
        else {
        label_78:
            v8 = arg27;
        }

        if((v0 & 0x30000) == 0) {
            v18 = v6.changed(v5) ? 0x20000 : 0x10000;
            v10 |= v18;
        }

        if((v0 & 0x180000) == 0) {
            v12 = arg29;
            v19 = (arg38 & 0x40) != 0 || !v6.changed(v12) ? 0x80000 : 0x100000;
            v10 |= v19;
        }
        else {
            v12 = arg29;
        }

        if((v0 & 0xC00000) == 0) {
            v19 = v6.changed(v14) ? 0x800000 : 0x400000;
            v10 |= v19;
        }

        OverscrollEffect v13 = arg31;
        if((v0 & 0x6000000) == 0) {
            int v20 = v6.changed(v13) ? 0x4000000 : 0x2000000;
            v10 |= v20;
        }

        Vertical v3 = arg32;
        if((v0 & 0x30000000) == 0) {
            int v21 = v6.changed(v3) ? 0x20000000 : 0x10000000;
            v10 |= v21;
        }

        Horizontal v0_1 = arg33;
        if((arg37 & 6) == 0) {
            v17 = v6.changed(v0_1) ? 4 : 2;
            v17 |= arg37;
        }
        else {
            v17 = arg37;
        }

        if((arg37 & 0x30) == 0) {
            v18 = v6.changedInstance(v15) ? 0x20 : 16;
            v17 |= v18;
        }

        v0 = v17;
        boolean v17_1 = false;
        int v35 = v4;
        v4 = 18;
        boolean v2_1 = (v10 & 306783379) != 306783378 || (v0 & 19) != v4 ? true : false;
        if(v6.shouldExecute(v2_1, v10 & 1)) {
            v6.startDefaults();
            ComposerKt.sourceInformation(v6, "72@3483L15");
            int v3_1 = 0xFFC7FFFF;
            if((arg36 & 1) == 0 || (v6.getDefaultsInvalid())) {
                if(v35 != 0) {
                    Companion v2_3 = Modifier.Companion;
                }
                else {
                    v2_2 = v9;
                }

                if(v11 != 0) {
                    v7 = PaddingKt.PaddingValues-0680j_4(Dp.constructor-impl(0f));
                }

                if(v16 != 0) {
                }
                else {
                    v17_1 = v8;
                }

                if((arg38 & 0x40) != 0) {
                    v10 &= v3_1;
                    v3_2 = v7;
                    v16_1 = ScrollableDefaults.INSTANCE.flingBehavior(v6, 6);
                    v7_1 = v10;
                    v8_1 = v4;
                }
                else {
                    v8_1 = v4;
                    v3_2 = v7;
                    v7_1 = v10;
                    v16_1 = v12;
                }

                v4_1 = v17_1;
            }
            else {
                v6.skipToGroupEnd();
                if((arg38 & 0x40) != 0) {
                    v10 &= v3_1;
                }

                v2_1 = v8;
                v8_1 = v4;
                v4_1 = v2_1;
                v3_2 = v7;
                v2_2 = v9;
                v7_1 = v10;
                v16_1 = v12;
            }

            v6.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(708740370, v7_1, v0, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:83)");
            }

            int v9_1 = v7_1 >> 3 & 14;
            Function0 v10_1 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(v1, v15, v6, v0 & 0x70 | v9_1);
            v17 = v7_1 >> 9;
            LazyLayoutSemanticState v18_1 = LazySemanticsKt.rememberLazyGridSemanticState(v1, v4_1, v6, v17 & 0x70 | v9_1);
            ComposerKt.sourceInformationMarkerStart(v6, 0x2E20B340, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(v6, 0x28C0FDC4, "CC(remember):Effects.kt#9igjgp");
            Object v11_2 = v6.rememberedValue();
            if(v11_2 == Composer.Companion.getEmpty()) {
                v11_3 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, v6);
                v6.updateRememberedValue(v11_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v6);
            ComposerKt.sourceInformationMarkerEnd(v6);
            ProvidableCompositionLocal v12_1 = CompositionLocalsKt.getLocalGraphicsContext();
            v35 = v0;
            ComposerKt.sourceInformationMarkerStart(v6, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v12_2 = v6.consume(((CompositionLocal)v12_1));
            ComposerKt.sourceInformationMarkerEnd(v6);
            CompositionLocal v1_1 = CompositionLocalsKt.getLocalScrollCaptureInProgress();
            ComposerKt.sourceInformationMarkerStart(v6, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v0_2 = v6.consume(v1_1);
            ComposerKt.sourceInformationMarkerEnd(v6);
            StickyItemsPlacement v0_3 = !((Boolean)v0_2).booleanValue() ? StickyItemsPlacement.Companion.getStickToTopPlacement() : null;
            Function0 v8_2 = v10_1;
            StickyItemsPlacement v10_2 = v0_3;
            Function0 v0_4 = v8_2;
            Modifier v15_1 = v2_2;
            v19 = v7_1;
            int v14_1 = v9_1;
            LazyLayoutMeasurePolicy v12_3 = LazyGridKt.rememberLazyGridMeasurePolicy(v0_4, arg24, arg25, v3_2, v4_1, v5, arg33, arg32, v11_3, v12_2, v10_2, v6, 0x7FFF0 & v7_1 | v35 << 18 & 0x380000 | v7_1 >> 6 & 0x1C00000, 0);
            PaddingValues v13_1 = v3_2;
            v5 = v4_1;
            v6 = v6;
            v11_4 = arg24;
            Orientation v1_2 = arg28 ? Orientation.Vertical : Orientation.Horizontal;
            Orientation v2_4 = v1_2;
            if(arg30) {
                v6.startReplaceGroup(0x1A048E3);
                ComposerKt.sourceInformation(v6, "112@4986L48");
                v1_3 = LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(Modifier.Companion, LazyGridBeyondBoundsModifierKt.rememberLazyGridBeyondBoundsState(v11_4, v6, v14_1), v11_4.getBeyondBoundsInfo$foundation(), v5, v2_4);
                v6.endReplaceGroup();
            }
            else {
                v6.startReplaceGroup(0x1A4CDF0);
                v6.endReplaceGroup();
                Companion v1_4 = Modifier.Companion;
            }

            Modifier v8_3 = v1_3;
            Function0 v1_5 = v0_4;
            Modifier v0_5 = LazyLayoutSemanticsKt.lazyLayoutSemantics(v15_1.then(v11_4.getRemeasurementModifier$foundation()).then(v11_4.getAwaitLayoutModifier$foundation()), v1_5, v18_1, v2_4, arg30, v5, v6, v17 & 0xE000 | 0x70000 & v19 << 3);
            Function0 v17_2 = v1_5;
            v0_5 = ScrollableAreaKt.scrollableArea$default(v0_5.then(v8_3).then(v11_4.getItemAnimator$foundation().getModifier()), v11_4, v2_4, arg31, arg30, v5, v16_1, v11_4.getInternalInteractionSource$foundation(), null, 0x80, null);
            boolean v1_6 = v5;
            FlingBehavior v2_5 = v16_1;
            LazyLayoutKt.LazyLayout(v17_2, v0_5, v11_4.getPrefetchState$foundation(), v12_3, v6, 0, 0);
            v6 = v6;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v5 = v1_6;
            v7_2 = v2_5;
            v4_2 = v13_1;
            v1_3 = v15_1;
        }
        else {
            v11_4 = v1;
            v6.skipToGroupEnd();
            v4_2 = v7;
            v5 = v8;
            v1_3 = v9;
            v7_2 = v12;
        }

        ScopeUpdateScope v0_6 = v6.endRestartGroup();
        if(v0_6 != null) {
            v0_6.updateScope(new LazyGridKt$$ExternalSyntheticLambda0(v1_3, v11_4, arg25, v4_2, v5, arg28, v7_2, arg30, arg31, arg32, arg33, arg34, arg36, arg37, arg38));
        }
    }

    static final Unit LazyGrid$lambda$0(Modifier arg17, LazyGridState arg18, LazyGridSlotsProvider arg19, PaddingValues arg20, boolean arg21, boolean arg22, FlingBehavior arg23, boolean arg24, OverscrollEffect arg25, Vertical arg26, Horizontal arg27, Function1 arg28, int arg29, int arg30, int arg31, Composer arg32, int arg33) {
        LazyGridKt.LazyGrid(arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg32, RecomposeScopeImplKt.updateChangedFlags(arg29 | 1), RecomposeScopeImplKt.updateChangedFlags(arg30), arg31);
        return Unit.INSTANCE;
    }

    public static final void access$keepAroundItems(CacheWindowLogic arg0, Orientation arg1, List arg2, LazyGridMeasuredLineProvider arg3) {
        LazyGridKt.keepAroundItems(arg0, arg1, arg2, arg3);
    }

    private static final void keepAroundItems(CacheWindowLogic arg1, Orientation arg2, List arg3, LazyGridMeasuredLineProvider arg4) {
        Trace.beginSection("compose:lazy:cache_window:keepAroundItems");
        try {
            if((arg1.hasValidBounds()) && !arg3.isEmpty()) {
                int v0 = LazyGridItemInfoKt.lineIndex(CollectionsKt.first(arg3), arg2);
                int v2 = LazyGridItemInfoKt.lineIndex(CollectionsKt.last(arg3), arg2);
                int v3;
                for(v3 = arg1.getPrefetchWindowStartLine$foundation(); v3 < v0; ++v3) {
                    arg4.keepAround(v3);
                }

                ++v2;
                int v1_1 = arg1.getPrefetchWindowEndLine$foundation();
                if(v2 > v1_1) {
                    goto label_23;
                }

                while(true) {
                    arg4.keepAround(v2);
                    if(v2 == v1_1) {
                        break;
                    }

                    ++v2;
                }
            }

        label_23:
        }
        catch(Throwable v1) {
            Trace.endSection();
            throw v1;
        }

        Trace.endSection();
    }

    private static final LazyLayoutMeasurePolicy rememberLazyGridMeasurePolicy(Function0 arg18, LazyGridState arg19, LazyGridSlotsProvider arg20, PaddingValues arg21, boolean arg22, boolean arg23, Horizontal arg24, Vertical arg25, CoroutineScope arg26, GraphicsContext arg27, StickyItemsPlacement arg28, Composer arg29, int arg30, int arg31) {
        boolean v3_1;
        Composer v0 = arg29;
        int v1 = arg30;
        int v3 = 0xC28C40FB;
        ComposerKt.sourceInformationMarkerStart(v0, v3, "C(rememberLazyGridMeasurePolicy)N(itemProviderLambda,state,slots,contentPadding,reverseLayout,isVertical,horizontalArrangement,verticalArrangement,coroutineScope,graphicsContext,stickyItemsScrollBehavior)179@7590L12074:LazyGrid.kt#7791vq");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v3, v1, arg31, "androidx.compose.foundation.lazy.grid.rememberLazyGridMeasurePolicy (LazyGrid.kt:179)");
        }

        ComposerKt.sourceInformationMarkerStart(v0, 0x50809FC5, "CC(remember):LazyGrid.kt#9igjgp");
        v3 = 0x20;
        int v4 = 0;
        LazyGridState v7 = arg19;
        int v2 = (v1 & 0x70 ^ 0x30) > v3 && (v0.changed(v7)) || (v1 & 0x30) == v3 ? 1 : 0;
        int v6 = 0x100;
        LazyGridSlotsProvider v12 = arg20;
        v3 = (v1 & 0x380 ^ 0x180) > v6 && (v0.changed(v12)) || (v1 & 0x180) == v6 ? 1 : 0;
        v2 |= v3;
        v6 = 0x800;
        PaddingValues v9 = arg21;
        v3 = (v1 & 0x1C00 ^ 0xC00) > v6 && (v0.changed(v9)) || (v1 & 0xC00) == v6 ? 1 : 0;
        v2 |= v3;
        v6 = 0x4000;
        boolean v10 = arg22;
        v3 = (0xE000 & v1 ^ 0x6000) > v6 && (v0.changed(v10)) || (v1 & 0x6000) == v6 ? 1 : 0;
        v2 |= v3;
        v6 = 0x30000;
        int v8 = 0x20000;
        if((0x70000 & v1 ^ v6) > v8) {
            v3_1 = arg23;
            if(!v0.changed(v3_1)) {
                goto label_78;
            }
            else {
                goto label_80;
            }
        }
        else {
            v3_1 = arg23;
        label_78:
            if((v6 & v1) == v8) {
            label_80:
                v6 = 1;
            }
            else {
                v6 = 0;
            }
        }

        v2 |= v6;
        v8 = 0x180000;
        int v11 = 0x100000;
        Horizontal v14 = arg24;
        v6 = (0x380000 & v1 ^ v8) > v11 && (v0.changed(v14)) || (v1 & v8) == v11 ? 1 : 0;
        v2 |= v6;
        v8 = 0xC00000;
        v11 = 0x800000;
        Vertical v13 = arg25;
        if((0x1C00000 & v1 ^ v8) > v11 && (v0.changed(v13)) || (v1 & v8) == v11) {
            v4 = 1;
        }

        v1 = v2 | v4;
        GraphicsContext v2_1 = arg27;
        v1 |= v0.changed(v2_1);
        Object v4_1 = v0.rememberedValue();
        if(v1 != 0 || v4_1 == Composer.Companion.getEmpty()) {
            LazyGridKt$rememberLazyGridMeasurePolicy$1$1 v4_2 = new LazyGridKt$rememberLazyGridMeasurePolicy$1$1(v7, v3_1, v9, v10, arg18, v12, v13, v14, arg26, v2_1, arg28);
            v0.updateRememberedValue(v4_2);
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return ((LazyLayoutMeasurePolicy)v4_1);
    }
}

