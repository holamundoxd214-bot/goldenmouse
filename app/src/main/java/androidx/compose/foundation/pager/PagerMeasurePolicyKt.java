package androidx.compose.foundation.pager;

import android.os.Trace;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.CacheWindowLogic;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Alignment$Horizontal;
import androidx.compose.ui.Alignment$Vertical;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1={"\u0000x\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\u001A\u0087\u0001\u0010\u0000\u001A\u00020\u00012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00122\b\u0010\u0013\u001A\u0004\u0018\u00010\u00142\b\u0010\u0015\u001A\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u001A2\f\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u000E0\u0003H\u0001¢\u0006\u0004\b\u001C\u0010\u001D\u001A\"\u0010\u001E\u001A\u00020\u001F*\u00020 2\u0006\u0010!\u001A\u00020\"2\f\u0010#\u001A\b\u0012\u0004\u0012\u00020%0$H\u0002\u001A\u0017\u0010\'\u001A\u00020\u001F2\f\u0010(\u001A\b\u0012\u0004\u0012\u00020)0\u0003H\u0082\b\"\u000E\u0010&\u001A\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006*"}, d2={"rememberPagerMeasurePolicy", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasurePolicy;", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "state", "Landroidx/compose/foundation/pager/PagerState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "beyondViewportPageCount", "", "pageSpacing", "Landroidx/compose/ui/unit/Dp;", "pageSize", "Landroidx/compose/foundation/pager/PageSize;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "snapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "pageCount", "rememberPagerMeasurePolicy-8u0NR3k", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/Orientation;IFLandroidx/compose/foundation/pager/PageSize;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasurePolicy;", "keepAroundItems", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "cacheWindowLogic", "Landroidx/compose/foundation/lazy/layout/CacheWindowLogic;", "visiblePagesList", "", "Landroidx/compose/foundation/pager/PageInfo;", "DebugEnabled", "debugLog", "generateMsg", "", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class PagerMeasurePolicyKt {
    private static final boolean DebugEnabled = false;

    public static final void access$keepAroundItems(LazyLayoutMeasureScope arg0, CacheWindowLogic arg1, List arg2) {
        PagerMeasurePolicyKt.keepAroundItems(arg0, arg1, arg2);
    }

    private static final void debugLog(Function0 arg0) {
    }

    private static final void keepAroundItems(LazyLayoutMeasureScope arg2, CacheWindowLogic arg3, List arg4) {
        Trace.beginSection("compose:pager:cache_window:keepAroundItems");
        try {
            if((arg3.hasValidBounds()) && !arg4.isEmpty()) {
                int v0 = CollectionsKt.first(arg4).getIndex();
                int v4 = CollectionsKt.last(arg4).getIndex();
                int v1;
                for(v1 = arg3.getPrefetchWindowStartLine$foundation(); v1 < v0; ++v1) {
                    arg2.compose(v1);
                }

                ++v4;
                int v3 = arg3.getPrefetchWindowEndLine$foundation();
                if(v4 > v3) {
                    goto label_23;
                }

                while(true) {
                    arg2.compose(v4);
                    if(v4 == v3) {
                        break;
                    }

                    ++v4;
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

    public static final LazyLayoutMeasurePolicy rememberPagerMeasurePolicy-8u0NR3k(Function0 arg21, PagerState arg22, PaddingValues arg23, boolean arg24, Orientation arg25, int arg26, float arg27, PageSize arg28, Horizontal arg29, Vertical arg30, SnapPosition arg31, CoroutineScope arg32, Function0 arg33, Composer arg34, int arg35, int arg36) {
        PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1 v5_2;
        int v5;
        SnapPosition v14_1;
        PageSize v13_1;
        float v12_1;
        Vertical v9_1;
        Horizontal v4_1;
        Composer v0 = arg34;
        int v1 = arg35;
        int v2 = arg36;
        int v4 = 0xB2DD1EAF;
        ComposerKt.sourceInformationMarkerStart(v0, v4, "C(rememberPagerMeasurePolicy)N(itemProviderLambda,state,contentPadding,reverseLayout,orientation,beyondViewportPageCount,pageSpacing:c#ui.unit.Dp,pageSize,horizontalAlignment,verticalAlignment,snapPosition,coroutineScope,pageCount)61@2523L7806:PagerMeasurePolicy.kt#g6yjnt");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v4, v1, v2, "androidx.compose.foundation.pager.rememberPagerMeasurePolicy (PagerMeasurePolicy.kt:61)");
        }

        ComposerKt.sourceInformationMarkerStart(v0, 0x7010896D, "CC(remember):PagerMeasurePolicy.kt#9igjgp");
        v4 = 0x20;
        PagerState v8 = arg22;
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
        v4 = (0xE000 & v1 ^ 0x6000) > v9 && (v0.changed(arg25.ordinal())) || (v1 & 0x6000) == v9 ? 1 : 0;
        v3 |= v4;
        v9 = 0x6000000;
        int v12 = 0x4000000;
        if((0xE000000 & v1 ^ v9) > v12) {
            v4_1 = arg29;
            if(!v0.changed(v4_1)) {
                goto label_78;
            }
            else {
                goto label_80;
            }
        }
        else {
            v4_1 = arg29;
        label_78:
            if((v9 & v1) == v12) {
            label_80:
                v9 = 1;
            }
            else {
                v9 = 0;
            }
        }

        v3 |= v9;
        v12 = 0x30000000;
        int v13 = 0x20000000;
        if((0x70000000 & v1 ^ v12) > v13) {
            v9_1 = arg30;
            if(!v0.changed(v9_1)) {
                goto label_95;
            }
            else {
                goto label_97;
            }
        }
        else {
            v9_1 = arg30;
        label_95:
            if((v12 & v1) == v13) {
            label_97:
                v12 = 1;
            }
            else {
                v12 = 0;
            }
        }

        v3 |= v12;
        v13 = 0x180000;
        int v14 = 0x100000;
        if((0x380000 & v1 ^ v13) > v14) {
            v12_1 = arg27;
            if(!v0.changed(v12_1)) {
                goto label_112;
            }
            else {
                goto label_114;
            }
        }
        else {
            v12_1 = arg27;
        label_112:
            if((v13 & v1) == v14) {
            label_114:
                v13 = 1;
            }
            else {
                v13 = 0;
            }
        }

        v3 |= v13;
        v14 = 0xC00000;
        int v15 = 0x800000;
        if((0x1C00000 & v1 ^ v14) > v15) {
            v13_1 = arg28;
            if(!v0.changed(v13_1)) {
                goto label_129;
            }
            else {
                goto label_131;
            }
        }
        else {
            v13_1 = arg28;
        label_129:
            if((v14 & v1) == v15) {
            label_131:
                v14 = 1;
            }
            else {
                v14 = 0;
            }
        }

        v3 |= v14;
        v15 = 4;
        if((v2 & 14 ^ 6) > v15) {
            v14_1 = arg31;
            if(!v0.changed(v14_1)) {
                goto label_144;
            }
            else {
                goto label_146;
            }
        }
        else {
            v14_1 = arg31;
        label_144:
            if((v2 & 6) == v15) {
            label_146:
                v5 = 1;
            }
            else {
                v5 = 0;
            }
        }

        v3 |= v5;
        Function0 v15_1 = arg33;
        v2 = (v2 & 0x380 ^ 0x180) > v7 && (v0.changed(v15_1)) || (v2 & 0x180) == v7 ? 1 : 0;
        v2 |= v3;
        if((0x70000 & v1 ^ 0x30000) > 0x20000) {
            v3 = arg26;
            if(!v0.changed(v3)) {
                goto label_173;
            }
            else {
                goto label_177;
            }
        }
        else {
            v3 = arg26;
        label_173:
            if((v1 & 0x30000) == 0x20000) {
            label_177:
                v5 = 1;
            }
            else {
                v5 = 0;
            }
        }

        v1 = v2 | v5;
        CoroutineScope v2_1 = arg32;
        v1 |= v0.changed(v2_1);
        Object v5_1 = v0.rememberedValue();
        if(v1 != 0 || v5_1 == Composer.Companion.getEmpty()) {
            v5_2 = new PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1(v8, arg25, v10, v11, v12_1, v13_1, arg21, v15_1, v9_1, v4_1, v3, v14_1, v2_1);
            v0.updateRememberedValue(v5_2);
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return ((LazyLayoutMeasurePolicy)v5_2);
    }
}

