package androidx.compose.foundation.lazy;

import android.os.Trace;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.ScrollableAreaKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement$Vertical;
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
import androidx.compose.ui.Alignment$Horizontal;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.platform.CompositionLocalsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1={"\u0000\u0098\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A¢\u0001\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\t2\b\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u00112\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001A\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001A\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001A\u0004\u0018\u00010\u00192\u0017\u0010\u001A\u001A\u0013\u0012\u0004\u0012\u00020\u001C\u0012\u0004\u0012\u00020\u00010\u001B¢\u0006\u0002\b\u001DH\u0001¢\u0006\u0002\u0010\u001E\u001A\u0085\u0001\u0010\u001F\u001A\u00020 2\f\u0010!\u001A\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\u0010\u001A\u00020\u00112\b\u0010\u0012\u001A\u0004\u0018\u00010\u00132\b\u0010\u0016\u001A\u0004\u0018\u00010\u00172\b\u0010\u0018\u001A\u0004\u0018\u00010\u00192\b\u0010\u0014\u001A\u0004\u0018\u00010\u00152\u0006\u0010$\u001A\u00020%2\u0006\u0010&\u001A\u00020\'2\b\u0010(\u001A\u0004\u0018\u00010)H\u0003¢\u0006\u0002\u0010*\u001A\"\u0010+\u001A\u00020\u0001*\u00020,2\f\u0010-\u001A\b\u0012\u0004\u0012\u00020/0.2\u0006\u00100\u001A\u000201H\u0002¨\u00062"}, d2={"LazyList", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "isVertical", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "beyondBoundsItemCount", "", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/LazyListScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/OverscrollEffect;ILandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "rememberLazyListMeasurePolicy", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasurePolicy;", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/LazyListItemProvider;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "stickyItemsPlacement", "Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZZILandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/graphics/GraphicsContext;Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasurePolicy;", "keepAroundItems", "Landroidx/compose/foundation/lazy/layout/CacheWindowLogic;", "visibleItemsList", "", "Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "measuredItemProvider", "Landroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LazyListKt {
    public static final void LazyList(Modifier arg28, LazyListState arg29, PaddingValues arg30, boolean arg31, boolean arg32, FlingBehavior arg33, boolean arg34, OverscrollEffect arg35, int arg36, Horizontal arg37, Vertical arg38, androidx.compose.ui.Alignment$Vertical arg39, androidx.compose.foundation.layout.Arrangement$Horizontal arg40, Function1 arg41, Composer arg42, int arg43, int arg44, int arg45) {
        androidx.compose.foundation.layout.Arrangement$Horizontal v13_4;
        Horizontal v10_2;
        int v9_2;
        Modifier v3_3;
        LazyListState v14_4;
        CoroutineScope v0_4;
        int v7_1;
        androidx.compose.ui.Alignment$Vertical v9_1;
        Vertical v11_1;
        Horizontal v8_1;
        androidx.compose.foundation.layout.Arrangement$Horizontal v10_1;
        androidx.compose.ui.Alignment$Vertical v12_1;
        int v25;
        int v23;
        int v12;
        int v22;
        int v21;
        int v11;
        int v19;
        PaddingValues v13_1;
        int v10;
        Modifier v1 = arg28;
        LazyListState v2 = arg29;
        boolean v7 = arg31;
        boolean v5 = arg32;
        boolean v0 = arg34;
        Function1 v3 = arg41;
        int v4 = arg43;
        int v6 = arg44;
        int v8 = arg45;
        Composer v15 = arg42.startRestartGroup(0x37213AF3);
        ComposerKt.sourceInformation(v15, "C(LazyList)N(modifier,state,contentPadding,reverseLayout,isVertical,flingBehavior,userScrollEnabled,overscrollEffect,beyondBoundsItemCount,horizontalAlignment,verticalArrangement,verticalAlignment,horizontalArrangement,content)86@4189L50,88@4265L48,89@4339L24,90@4411L7,91@4480L7,94@4521L484,133@5809L302,128@5640L1117:LazyList.kt#428nma");
        if((v4 & 6) == 0) {
            v10 = v15.changed(v1) ? 4 : 2;
            v10 |= v4;
        }
        else {
            v10 = v4;
        }

        int v16 = 16;
        if((v4 & 0x30) == 0) {
            int v13 = v15.changed(v2) ? 0x20 : v16;
            v10 |= v13;
        }

        int v17 = 0x80;
        int v18 = 0x100;
        if((v4 & 0x180) == 0) {
            v13_1 = arg30;
            v19 = v15.changed(v13_1) ? v18 : v17;
            v10 |= v19;
        }
        else {
            v13_1 = arg30;
        }

        v19 = 0x800;
        int v20 = 0x400;
        if((v4 & 0xC00) == 0) {
            v11 = v15.changed(v7) ? v19 : v20;
            v10 |= v11;
        }

        if((v4 & 0x6000) == 0) {
            v11 = v15.changed(v5) ? 0x4000 : 0x2000;
            v10 |= v11;
        }

        if((0x30000 & v4) == 0) {
            v21 = v15.changed(arg33) ? 0x20000 : 0x10000;
            v10 |= v21;
        }

        if((v4 & 0x180000) == 0) {
            v21 = v15.changed(v0) ? 0x100000 : 0x80000;
            v10 |= v21;
        }

        OverscrollEffect v9 = arg35;
        if((v4 & 0xC00000) == 0) {
            v22 = v15.changed(v9) ? 0x800000 : 0x400000;
            v10 |= v22;
        }

        if((v4 & 0x6000000) == 0) {
            if((v8 & 0x100) == 0) {
                v12 = arg36;
                if(v15.changed(v12)) {
                    v23 = 0x4000000;
                }
                else {
                    goto label_106;
                }
            }
            else {
                v12 = arg36;
            label_106:
                v23 = 0x2000000;
            }

            v10 |= v23;
        }
        else {
            v12 = arg36;
        }

        int v14 = v8 & 0x200;
        int v24 = 0x30000000;
        if(v14 != 0) {
            v10 |= v24;
        }
        else {
            Horizontal v0_1 = arg37;
            if((v4 & v24) == 0) {
                v24 = v15.changed(v0_1) ? 0x20000000 : 0x10000000;
                v10 |= v24;
            }
        }

        int v0_2 = v8 & 0x400;
        if(v0_2 != 0) {
            v22 = v6 | 6;
            v24 = v0_2;
        }
        else if((v6 & 6) == 0) {
            v24 = v0_2;
            v22 = v15.changed(arg38) ? 4 : 2;
            v22 |= v6;
        }
        else {
            v24 = v0_2;
            v22 = v6;
        }

        v0_2 = v8 & 0x800;
        if(v0_2 != 0) {
            v22 |= 0x30;
            v25 = v0_2;
        }
        else if((v6 & 0x30) == 0) {
            v25 = v0_2;
            if(v15.changed(arg39)) {
                v16 = 0x20;
            }

            v22 |= v16;
        }
        else {
            v25 = v0_2;
        }

        v0_2 = v22;
        v4 = v8 & 0x1000;
        if(v4 != 0) {
            v16 = v0_2 | 0x180;
        }
        else {
            v16 = v0_2;
            if((v6 & 0x180) == 0) {
                if(v15.changed(arg40)) {
                    v17 = v18;
                }

                v16 |= v17;
            }
        }

        if((v6 & 0xC00) == 0) {
            if(v15.changedInstance(v3)) {
            }
            else {
                v19 = v20;
            }

            v16 |= v19;
        }

        v0_2 = v16;
        v17 = v4;
        boolean v4_1 = (v10 & 306783379) != 306783378 || (v0_2 & 0x493) != 1170 ? true : false;
        if(v15.shouldExecute(v4_1, v10 & 1)) {
            v15.startDefaults();
            ComposerKt.sourceInformation(v15, "74@3486L38");
            v6 = 0xF1FFFFFF;
            StickyItemsPlacement v16_1 = null;
            if((arg43 & 1) == 0 || (v15.getDefaultsInvalid())) {
                if((v8 & 0x100) != 0) {
                    v4 = LazyList_androidKt.defaultLazyListBeyondBoundsItemCount(v15, 0);
                    v10 &= v6;
                }
                else {
                    v4 = v12;
                }

                Horizontal v6_1 = v14 != 0 ? ((Horizontal)v16_1) : arg37;
                Vertical v7_2 = v24 != 0 ? ((Vertical)v16_1) : arg38;
                v12_1 = v25 != 0 ? ((androidx.compose.ui.Alignment$Vertical)v16_1) : arg39;
                v8_1 = v6_1;
                v11_1 = v7_2;
                v9_1 = v12_1;
                v7_1 = v4;
                v4 = v10;
                if(v17 != 0) {
                    v10_1 = ((androidx.compose.foundation.layout.Arrangement$Horizontal)v16_1);
                    goto label_247;
                }

            label_220:
                v10_1 = arg40;
            }
            else {
                v15.skipToGroupEnd();
                if((v8 & 0x100) != 0) {
                    v10 &= v6;
                }

                v8_1 = arg37;
                v11_1 = arg38;
                v9_1 = arg39;
                v4 = v10;
                v7_1 = v12;
                goto label_220;
            }

        label_247:
            v15.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x37213AF3, v4, v0_2, "androidx.compose.foundation.lazy.LazyList (LazyList.kt:85)");
            }

            v18 = v4 >> 3 & 14;
            Function0 v6_2 = LazyListItemProviderKt.rememberLazyListItemProviderLambda(v2, v3, v15, v18 | v0_2 >> 6 & 0x70);
            v12 = v4 >> 9;
            LazyLayoutSemanticState v19_1 = LazyListSemanticsKt.rememberLazyListSemanticState(v2, v5, v15, v18 | v12 & 0x70);
            v17 = v0_2;
            ComposerKt.sourceInformationMarkerStart(v15, 0x2E20B340, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(v15, 0x28C0FDC4, "CC(remember):Effects.kt#9igjgp");
            Object v0_3 = v15.rememberedValue();
            if(v0_3 == Composer.Companion.getEmpty()) {
                v0_4 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, v15);
                v15.updateRememberedValue(v0_4);
            }

            ComposerKt.sourceInformationMarkerEnd(v15);
            ComposerKt.sourceInformationMarkerEnd(v15);
            ProvidableCompositionLocal v14_1 = CompositionLocalsKt.getLocalGraphicsContext();
            Object v36 = v0_4;
            ComposerKt.sourceInformationMarkerStart(v15, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v14_2 = v15.consume(((CompositionLocal)v14_1));
            ComposerKt.sourceInformationMarkerEnd(v15);
            CompositionLocal v3_1 = CompositionLocalsKt.getLocalScrollCaptureInProgress();
            ComposerKt.sourceInformationMarkerStart(v15, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            v0_3 = v15.consume(v3_1);
            ComposerKt.sourceInformationMarkerEnd(v15);
            if(!((Boolean)v0_3).booleanValue()) {
                v16_1 = StickyItemsPlacement.Companion.getStickToTopPlacement();
            }

            v20 = 0x70000;
            int v2_1 = v17 << 18;
            v0_2 = 0xFFF0 & v4 | v12 & v20 | 0x380000 & v12 | 0x1C00000 & v2_1 | v2_1 & 0xE000000;
            StickyItemsPlacement v2_2 = v16_1;
            v16 = v0_2 | v17 << 27 & 0x70000000;
            v0_2 = v4;
            PaddingValues v4_2 = v13_1;
            Object v13_2 = v14_2;
            StickyItemsPlacement v14_3 = v2_2;
            Function0 v2_3 = v6_2;
            LazyLayoutMeasurePolicy v13_3 = LazyListKt.rememberLazyListMeasurePolicy(v2_3, arg29, v4_2, arg31, v5, v7_1, v8_1, v9_1, v10_1, v11_1, v36, ((GraphicsContext)v13_2), v14_3, v15, v16, 0);
            v14_4 = arg29;
            Horizontal v16_2 = v8_1;
            androidx.compose.ui.Alignment$Vertical v17_1 = v9_1;
            androidx.compose.foundation.layout.Arrangement$Horizontal v21_1 = v10_1;
            Vertical v22_1 = v11_1;
            v10 = v7_1;
            v7 = arg31;
            Orientation v3_2 = arg32 ? Orientation.Vertical : Orientation.Horizontal;
            Orientation v4_3 = v3_2;
            if(arg34) {
                v15.startReplaceGroup(0x84313F18);
                ComposerKt.sourceInformation(v15, "116@5256L166");
                v3_3 = LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(Modifier.Companion, LazyListBeyondBoundsModifierKt.rememberLazyListBeyondBoundsState(v14_4, v10, v15, v18 | v0_2 >> 21 & 0x70), v14_4.getBeyondBoundsInfo$foundation(), v7, v4_3);
                v15.endReplaceGroup();
            }
            else {
                v15.startReplaceGroup(-2076718545);
                v15.endReplaceGroup();
                Companion v3_4 = Modifier.Companion;
            }

            Function0 v18_1 = v2_3;
            Modifier v2_4 = LazyLayoutSemanticsKt.lazyLayoutSemantics(v1.then(v14_4.getRemeasurementModifier$foundation()).then(v14_4.getAwaitLayoutModifier$foundation()), v2_3, v19_1, v4_3, arg34, v7, v15, v0_2 >> 6 & 0xE000 | v0_2 << 6 & v20).then(v3_3).then(v14_4.getItemAnimator$foundation().getModifier());
            v0_2 = v10;
            LazyLayoutKt.LazyLayout(v18_1, ScrollableAreaKt.scrollableArea$default(v2_4, v14_4, v4_3, arg35, arg34, arg31, arg33, v14_4.getInternalInteractionSource$foundation(), null, 0x80, null), v14_4.getPrefetchState$foundation(), v13_3, v15, 0, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v9_2 = v0_2;
            v10_2 = v16_2;
            v12_1 = v17_1;
            v13_4 = v21_1;
            v11_1 = v22_1;
        }
        else {
            v14_4 = v2;
            v15.skipToGroupEnd();
            v10_2 = arg37;
            v11_1 = arg38;
            v13_4 = arg40;
            v9_2 = v12;
            v12_1 = arg39;
        }

        ScopeUpdateScope v0_5 = v15.endRestartGroup();
        if(v0_5 != null) {
            v0_5.updateScope(new LazyListKt$$ExternalSyntheticLambda0(v1, v14_4, arg30, arg31, arg32, arg33, arg34, arg35, v9_2, v10_2, v11_1, v12_1, v13_4, arg41, arg43, arg44, arg45));
        }
    }

    static final Unit LazyList$lambda$0(Modifier arg19, LazyListState arg20, PaddingValues arg21, boolean arg22, boolean arg23, FlingBehavior arg24, boolean arg25, OverscrollEffect arg26, int arg27, Horizontal arg28, Vertical arg29, androidx.compose.ui.Alignment$Vertical arg30, androidx.compose.foundation.layout.Arrangement$Horizontal arg31, Function1 arg32, int arg33, int arg34, int arg35, Composer arg36, int arg37) {
        LazyListKt.LazyList(arg19, arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg36, RecomposeScopeImplKt.updateChangedFlags(arg33 | 1), RecomposeScopeImplKt.updateChangedFlags(arg34), arg35);
        return Unit.INSTANCE;
    }

    public static final void access$keepAroundItems(CacheWindowLogic arg0, List arg1, LazyListMeasuredItemProvider arg2) {
        LazyListKt.keepAroundItems(arg0, arg1, arg2);
    }

    private static final void keepAroundItems(CacheWindowLogic arg2, List arg3, LazyListMeasuredItemProvider arg4) {
        Trace.beginSection("compose:lazy:cache_window:keepAroundItems");
        try {
            if((arg2.hasValidBounds()) && !arg3.isEmpty()) {
                int v0 = CollectionsKt.first(arg3).getIndex();
                int v3 = CollectionsKt.last(arg3).getIndex();
                int v1;
                for(v1 = arg2.getPrefetchWindowStartLine$foundation(); v1 < v0; ++v1) {
                    arg4.keepAround(v1);
                }

                ++v3;
                int v2_1 = arg2.getPrefetchWindowEndLine$foundation();
                if(v3 > v2_1) {
                    goto label_23;
                }

                while(true) {
                    arg4.keepAround(v3);
                    if(v3 == v2_1) {
                        break;
                    }

                    ++v3;
                }
            }

        label_23:
        }
        catch(Throwable v2) {
            Trace.endSection();
            throw v2;
        }

        Trace.endSection();
    }

    private static final LazyLayoutMeasurePolicy rememberLazyListMeasurePolicy(Function0 arg21, LazyListState arg22, PaddingValues arg23, boolean arg24, boolean arg25, int arg26, Horizontal arg27, androidx.compose.ui.Alignment$Vertical arg28, androidx.compose.foundation.layout.Arrangement$Horizontal arg29, Vertical arg30, CoroutineScope arg31, GraphicsContext arg32, StickyItemsPlacement arg33, Composer arg34, int arg35, int arg36) {
        LazyListKt$rememberLazyListMeasurePolicy$1$1 v2_2;
        int v16;
        StickyItemsPlacement v6_1;
        Vertical v5_1;
        androidx.compose.foundation.layout.Arrangement$Horizontal v13_1;
        androidx.compose.ui.Alignment$Vertical v12_1;
        Horizontal v9_1;
        boolean v4_1;
        Composer v0 = arg34;
        int v1 = arg35;
        int v2 = arg36;
        int v4 = 0x183598F4;
        ComposerKt.sourceInformationMarkerStart(v0, v4, "C(rememberLazyListMeasurePolicy)N(itemProviderLambda,state,contentPadding,reverseLayout,isVertical,beyondBoundsItemCount,horizontalAlignment,verticalAlignment,horizontalArrangement,verticalArrangement,coroutineScope,graphicsContext,stickyItemsPlacement)187@8024L9764:LazyList.kt#428nma");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v4, v1, v2, "androidx.compose.foundation.lazy.rememberLazyListMeasurePolicy (LazyList.kt:187)");
        }

        ComposerKt.sourceInformationMarkerStart(v0, 0xE133EA18, "CC(remember):LazyList.kt#9igjgp");
        v4 = 0x20;
        LazyListState v8 = arg22;
        int v3 = (v1 & 0x70 ^ 0x30) > v4 && (v0.changed(v8)) || (v1 & 0x30) == v4 ? 1 : 0;
        int v7 = 0x100;
        PaddingValues v10 = arg23;
        v4 = (v1 & 0x380 ^ 0x180) > v7 && (v0.changed(v10)) || (v1 & 0x180) == v7 ? 1 : 0;
        v3 |= v4;
        int v9 = 0x800;
        boolean v11 = arg24;
        v4 = (v1 & 0x1C00 ^ 0xC00) > v9 && (v0.changed(v11)) || (v1 & 0xC00) == v9 ? 1 : 0;
        v3 |= v4;
        v9 = 0x4000;
        if((0xE000 & v1 ^ 0x6000) > v9) {
            v4_1 = arg25;
            if(!v0.changed(v4_1)) {
                goto label_61;
            }
            else {
                goto label_63;
            }
        }
        else {
            v4_1 = arg25;
        label_61:
            if((v1 & 0x6000) == v9) {
            label_63:
                v9 = 1;
            }
            else {
                v9 = 0;
            }
        }

        v3 |= v9;
        int v12 = 0x30000;
        int v13 = 0x20000;
        int v15 = arg26;
        v9 = (0x70000 & v1 ^ v12) > v13 && (v0.changed(v15)) || (v1 & v12) == v13 ? 1 : 0;
        v3 |= v9;
        v12 = 0x180000;
        v13 = 0x100000;
        if((0x380000 & v1 ^ v12) > v13) {
            v9_1 = arg27;
            if(!v0.changed(v9_1)) {
                goto label_93;
            }
            else {
                goto label_95;
            }
        }
        else {
            v9_1 = arg27;
        label_93:
            if((v12 & v1) == v13) {
            label_95:
                v12 = 1;
            }
            else {
                v12 = 0;
            }
        }

        v3 |= v12;
        v13 = 0xC00000;
        int v14 = 0x800000;
        if((0x1C00000 & v1 ^ v13) > v14) {
            v12_1 = arg28;
            if(!v0.changed(v12_1)) {
                goto label_110;
            }
            else {
                goto label_112;
            }
        }
        else {
            v12_1 = arg28;
        label_110:
            if((v13 & v1) == v14) {
            label_112:
                v13 = 1;
            }
            else {
                v13 = 0;
            }
        }

        v3 |= v13;
        v14 = 0x6000000;
        int v5 = 0x4000000;
        if((0xE000000 & v1 ^ v14) > v5) {
            v13_1 = arg29;
            if(!v0.changed(v13_1)) {
                goto label_127;
            }
            else {
                goto label_129;
            }
        }
        else {
            v13_1 = arg29;
        label_127:
            if((v14 & v1) == v5) {
            label_129:
                v5 = 1;
            }
            else {
                v5 = 0;
            }
        }

        v3 |= v5;
        v14 = 0x30000000;
        int v6 = 0x20000000;
        if((0x70000000 & v1 ^ v14) > v6) {
            v5_1 = arg30;
            if(!v0.changed(v5_1)) {
                goto label_144;
            }
            else {
                goto label_146;
            }
        }
        else {
            v5_1 = arg30;
        label_144:
            if((v1 & v14) == v6) {
            label_146:
                v1 = 1;
            }
            else {
                v1 = 0;
            }
        }

        v1 |= v3;
        GraphicsContext v3_1 = arg32;
        v1 |= v0.changed(v3_1);
        if((v2 & 0x380 ^ 0x180) > v7) {
            v6_1 = arg33;
            if(!v0.changed(v6_1)) {
                goto label_161;
            }
            else {
                goto label_163;
            }
        }
        else {
            v6_1 = arg33;
        label_161:
            if((v2 & 0x180) == v7) {
            label_163:
                v16 = 1;
            }
            else {
                v16 = 0;
            }
        }

        Object v2_1 = v0.rememberedValue();
        if((v1 | v16) != 0 || v2_1 == Composer.Companion.getEmpty()) {
            v2_2 = new LazyListKt$rememberLazyListMeasurePolicy$1$1(v8, v4_1, v10, v11, arg21, v5_1, v13_1, v15, arg31, v3_1, v6_1, v9_1, v12_1);
            v0.updateRememberedValue(v2_2);
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return ((LazyLayoutMeasurePolicy)v2_2);
    }
}

