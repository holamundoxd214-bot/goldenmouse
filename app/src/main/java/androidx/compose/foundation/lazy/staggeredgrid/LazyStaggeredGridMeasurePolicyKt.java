package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1={"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001Ae\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u0015H\u0001¢\u0006\u0004\b\u0016\u0010\u0017\u001A!\u0010\u0018\u001A\u00020\u000E*\u00020\b2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\u0019\u001A\u00020\u001AH\u0002¢\u0006\u0002\u0010\u001B\u001A)\u0010\u001C\u001A\u00020\u000E*\u00020\b2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u0019\u001A\u00020\u001AH\u0002¢\u0006\u0002\u0010\u001D\u001A)\u0010\u001E\u001A\u00020\u000E*\u00020\b2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u0019\u001A\u00020\u001AH\u0002¢\u0006\u0002\u0010\u001D¨\u0006\u001F"}, d2={"rememberStaggeredGridMeasurePolicy", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasurePolicy;", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "mainAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisSpacing", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "slots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "rememberStaggeredGridMeasurePolicy-qKj4JfE", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/Orientation;FFLkotlinx/coroutines/CoroutineScope;Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;Landroidx/compose/ui/graphics/GraphicsContext;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasurePolicy;", "startPadding", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/unit/LayoutDirection;)F", "beforePadding", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/ui/unit/LayoutDirection;)F", "afterPadding", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LazyStaggeredGridMeasurePolicyKt {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[Orientation.values().length];
            try {
                v0[Orientation.Vertical.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[Orientation.Horizontal.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                label_11:
                    WhenMappings.$EnumSwitchMapping$0 = v0;
                    return;
                }
            }
        }
    }

    public static final float access$afterPadding(PaddingValues arg0, Orientation arg1, boolean arg2, LayoutDirection arg3) {
        return LazyStaggeredGridMeasurePolicyKt.afterPadding(arg0, arg1, arg2, arg3);
    }

    public static final float access$beforePadding(PaddingValues arg0, Orientation arg1, boolean arg2, LayoutDirection arg3) {
        return LazyStaggeredGridMeasurePolicyKt.beforePadding(arg0, arg1, arg2, arg3);
    }

    public static final float access$startPadding(PaddingValues arg0, Orientation arg1, LayoutDirection arg2) {
        return LazyStaggeredGridMeasurePolicyKt.startPadding(arg0, arg1, arg2);
    }

    private static final float afterPadding(PaddingValues arg1, Orientation arg2, boolean arg3, LayoutDirection arg4) {
        int v2 = WhenMappings.$EnumSwitchMapping$0[arg2.ordinal()];
        if(v2 != 1) {
            if(v2 == 2) {
                if(arg3) {
                    return PaddingKt.calculateStartPadding(arg1, arg4);
                }

                return PaddingKt.calculateEndPadding(arg1, arg4);
            }

            throw new NoWhenBranchMatchedException();
        }

        if(arg3) {
            return arg1.calculateTopPadding-D9Ej5fM();
        }

        return arg1.calculateBottomPadding-D9Ej5fM();
    }

    private static final float beforePadding(PaddingValues arg1, Orientation arg2, boolean arg3, LayoutDirection arg4) {
        int v2 = WhenMappings.$EnumSwitchMapping$0[arg2.ordinal()];
        if(v2 != 1) {
            if(v2 == 2) {
                if(arg3) {
                    return PaddingKt.calculateEndPadding(arg1, arg4);
                }

                return PaddingKt.calculateStartPadding(arg1, arg4);
            }

            throw new NoWhenBranchMatchedException();
        }

        if(arg3) {
            return arg1.calculateBottomPadding-D9Ej5fM();
        }

        return arg1.calculateTopPadding-D9Ej5fM();
    }

    public static final LazyLayoutMeasurePolicy rememberStaggeredGridMeasurePolicy-qKj4JfE(LazyStaggeredGridState arg16, Function0 arg17, PaddingValues arg18, boolean arg19, Orientation arg20, float arg21, float arg22, CoroutineScope arg23, LazyGridStaggeredGridSlotsProvider arg24, GraphicsContext arg25, Composer arg26, int arg27) {
        LazyStaggeredGridMeasurePolicyKt$rememberStaggeredGridMeasurePolicy$1$1 v2_2;
        Composer v0 = arg26;
        int v1 = arg27;
        int v3 = 0xE0006E9;
        ComposerKt.sourceInformationMarkerStart(v0, v3, "C(rememberStaggeredGridMeasurePolicy)N(state,itemProviderLambda,contentPadding,reverseLayout,orientation,mainAxisSpacing:c#ui.unit.Dp,crossAxisSpacing:c#ui.unit.Dp,coroutineScope,slots,graphicsContext)50@2088L3728:LazyStaggeredGridMeasurePolicy.kt#fzvcnm");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v3, v1, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberStaggeredGridMeasurePolicy (LazyStaggeredGridMeasurePolicy.kt:50)");
        }

        ComposerKt.sourceInformationMarkerStart(v0, -1910884999, "CC(remember):LazyStaggeredGridMeasurePolicy.kt#9igjgp");
        v3 = 4;
        int v4 = 0;
        LazyStaggeredGridState v7 = arg16;
        int v2 = (v1 & 14 ^ 6) > v3 && (v0.changed(v7)) || (v1 & 6) == v3 ? 1 : 0;
        int v6 = 0x20;
        Function0 v10 = arg17;
        v3 = (v1 & 0x70 ^ 0x30) > v6 && (v0.changed(v10)) || (v1 & 0x30) == v6 ? 1 : 0;
        v2 |= v3;
        v6 = 0x100;
        PaddingValues v11 = arg18;
        v3 = (v1 & 0x380 ^ 0x180) > v6 && (v0.changed(v11)) || (v1 & 0x180) == v6 ? 1 : 0;
        v2 |= v3;
        v6 = 0x800;
        boolean v12 = arg19;
        v3 = (v1 & 0x1C00 ^ 0xC00) > v6 && (v0.changed(v12)) || (v1 & 0xC00) == v6 ? 1 : 0;
        v2 |= v3;
        v6 = 0x4000;
        v3 = (0xE000 & v1 ^ 0x6000) > v6 && (v0.changed(arg20.ordinal())) || (v1 & 0x6000) == v6 ? 1 : 0;
        v2 |= v3;
        v6 = 0x30000;
        int v8 = 0x20000;
        float v13 = arg21;
        v3 = (0x70000 & v1 ^ v6) > v8 && (v0.changed(v13)) || (v1 & v6) == v8 ? 1 : 0;
        v2 |= v3;
        v6 = 0x180000;
        v8 = 0x100000;
        v3 = (0x380000 & v1 ^ v6) > v8 && (v0.changed(arg22)) || (v1 & v6) == v8 ? 1 : 0;
        v2 |= v3;
        v6 = 0x6000000;
        v8 = 0x4000000;
        LazyGridStaggeredGridSlotsProvider v9 = arg24;
        if((0xE000000 & v1 ^ v6) > v8 && (v0.changed(v9)) || (v1 & v6) == v8) {
            v4 = 1;
        }

        GraphicsContext v15 = arg25;
        v1 = v2 | v4 | v0.changed(v15);
        Object v2_1 = v0.rememberedValue();
        if(v1 != 0 || v2_1 == Composer.Companion.getEmpty()) {
            v2_2 = new LazyStaggeredGridMeasurePolicyKt$rememberStaggeredGridMeasurePolicy$1$1(v7, arg20, v9, v10, v11, v12, v13, arg23, v15);
            v0.updateRememberedValue(v2_2);
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return ((LazyLayoutMeasurePolicy)v2_2);
    }

    private static final float startPadding(PaddingValues arg1, Orientation arg2, LayoutDirection arg3) {
        int v2 = WhenMappings.$EnumSwitchMapping$0[arg2.ordinal()];
        if(v2 != 1) {
            if(v2 == 2) {
                return arg1.calculateTopPadding-D9Ej5fM();
            }

            throw new NoWhenBranchMatchedException();
        }

        return PaddingKt.calculateStartPadding(arg1, arg3);
    }
}

