package androidx.compose.foundation.pager;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapPosition$Start;
import androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1={"\u0000k\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0018\u001A/\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0003\u0010\u0004\u001A\u00020\u00052\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0007¢\u0006\u0002\u0010\b\u001A(\u0010\t\u001A\u00020\u00012\b\b\u0002\u0010\n\u001A\u00020\u00032\b\b\u0003\u0010\u000B\u001A\u00020\u00052\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00030\u0007\u001A\u0012\u0010\f\u001A\u00020\r*\u00020\u0001H\u0080@¢\u0006\u0002\u0010\u000E\u001A\u0012\u0010\u000F\u001A\u00020\r*\u00020\u0001H\u0080@¢\u0006\u0002\u0010\u000E\u001A\u0017\u0010\u001E\u001A\u00020\r2\f\u0010\u001F\u001A\b\u0012\u0004\u0012\u00020 0\u0007H\u0082\b\u001A\u0014\u0010!\u001A\u00020\"*\u00020#2\u0006\u0010\u0006\u001A\u00020\u0003H\u0000\u001A\u0014\u0010$\u001A\u00020\"*\u00020\u001B2\u0006\u0010\u0006\u001A\u00020\u0003H\u0002\u001AO\u0010%\u001A\u00020\r*\u00020&2\u0006\u0010\'\u001A\u00020\u00032\u0006\u0010(\u001A\u00020\u00052\f\u0010)\u001A\b\u0012\u0004\u0012\u00020\u00050*2\u001D\u0010+\u001A\u0019\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0,¢\u0006\u0002\b.H\u0082@¢\u0006\u0002\u0010/\"\u0016\u0010\u0010\u001A\u00020\u0011X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0014\u001A\u0004\b\u0012\u0010\u0013\"\u000E\u0010\u0015\u001A\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0016\u001A\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0017\u001A\u00020\u0018X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019\"\u0014\u0010\u001A\u001A\u00020\u001BX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u001D¨\u00060"}, d2={"rememberPagerState", "Landroidx/compose/foundation/pager/PagerState;", "initialPage", "", "initialPageOffsetFraction", "", "pageCount", "Lkotlin/Function0;", "(IFLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/pager/PagerState;", "PagerState", "currentPage", "currentPageOffsetFraction", "animateToNextPage", "", "(Landroidx/compose/foundation/pager/PagerState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateToPreviousPage", "DefaultPositionThreshold", "Landroidx/compose/ui/unit/Dp;", "getDefaultPositionThreshold", "()F", "F", "MaxPagesForAnimateScroll", "PagesToPrefetch", "UnitDensity", "androidx/compose/foundation/pager/PagerStateKt$UnitDensity$1", "Landroidx/compose/foundation/pager/PagerStateKt$UnitDensity$1;", "EmptyLayoutInfo", "Landroidx/compose/foundation/pager/PagerMeasureResult;", "getEmptyLayoutInfo", "()Landroidx/compose/foundation/pager/PagerMeasureResult;", "debugLog", "generateMsg", "", "calculateNewMaxScrollOffset", "", "Landroidx/compose/foundation/pager/PagerLayoutInfo;", "calculateNewMinScrollOffset", "animateScrollToPage", "Landroidx/compose/foundation/lazy/layout/LazyLayoutScrollScope;", "targetPage", "targetPageOffsetToSnappedPosition", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "updateTargetPage", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutScrollScope;IFLandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class PagerStateKt {
    private static final float DefaultPositionThreshold = 0f;
    private static final PagerMeasureResult EmptyLayoutInfo = null;
    private static final int MaxPagesForAnimateScroll = 3;
    public static final int PagesToPrefetch = 1;
    private static final PagerStateKt$UnitDensity$1 UnitDensity;

    public static DefaultPagerState $r8$lambda$WTlKe4s8yOEtxidSI5APUxIN5YA(int arg0, float arg1, Function0 arg2) {
        return PagerStateKt.rememberPagerState$lambda$0$0(arg0, arg1, arg2);
    }

    static {
        PagerStateKt.DefaultPositionThreshold = Dp.constructor-impl(56f);
        PagerStateKt$UnitDensity$1 v0 = new PagerStateKt$UnitDensity$1();
        PagerStateKt.UnitDensity = v0;
        PagerStateKt.EmptyLayoutInfo = new PagerMeasureResult(CollectionsKt.emptyList(), 0, 0, 0, Orientation.Horizontal, 0, 0, false, 0, null, null, 0f, 0, false, Start.INSTANCE, new PagerStateKt$EmptyLayoutInfo$1(), false, null, null, CoroutineScopeKt.CoroutineScope(EmptyCoroutineContext.INSTANCE), v0, ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null), 0x60000, null);
    }

    public static final PagerState PagerState(int arg1, float arg2, Function0 arg3) {
        return new DefaultPagerState(arg1, arg2, arg3);
    }

    public static PagerState PagerState$default(int arg0, float arg1, Function0 arg2, int arg3, Object arg4) {
        return PagerStateKt.PagerState(0, 0f, arg2);
    }

    public static final Object access$animateScrollToPage(LazyLayoutScrollScope arg0, int arg1, float arg2, AnimationSpec arg3, Function2 arg4, Continuation arg5) {
        return PagerStateKt.animateScrollToPage(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    public static final long access$calculateNewMinScrollOffset(PagerMeasureResult arg0, int arg1) {
        return PagerStateKt.calculateNewMinScrollOffset(arg0, arg1);
    }

    public static final PagerStateKt$UnitDensity$1 access$getUnitDensity$p() {
        return PagerStateKt.UnitDensity;
    }

    private static final Object animateScrollToPage(LazyLayoutScrollScope arg8, int arg9, float arg10, AnimationSpec arg11, Function2 arg12, Continuation arg13) {
        arg12.invoke(arg8, Boxing.boxInt(arg9));
        int v12 = arg9 > arg8.getFirstVisibleItemIndex() ? 1 : 0;
        int v2 = arg8.getLastVisibleItemIndex() - arg8.getFirstVisibleItemIndex() + 1;
        if((v12 != 0 && arg9 > arg8.getLastVisibleItemIndex() || v12 == 0 && arg9 < arg8.getFirstVisibleItemIndex()) && Math.abs(arg9 - arg8.getFirstVisibleItemIndex()) >= 3) {
            v12 = v12 != 0 ? RangesKt.coerceAtLeast(arg9 - v2, arg8.getFirstVisibleItemIndex()) : RangesKt.coerceAtMost(v2 + arg9, arg8.getFirstVisibleItemIndex());
            arg8.snapToItem(v12, 0);
        }

        Object v8 = SuspendAnimationKt.animate$default(0f, (((float)LazyLayoutScrollScope.calculateDistanceTo$default(arg8, arg9, 0, 2, null))) + arg10, 0f, arg11, new PagerStateKt$$ExternalSyntheticLambda1(new FloatRef(), arg8), arg13, 4, null);
        if(v8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v8;
        }

        return Unit.INSTANCE;
    }

    static final Unit animateScrollToPage$lambda$2(FloatRef arg0, LazyLayoutScrollScope arg1, float arg2, float arg3) {
        arg0.element += arg1.scrollBy(arg2 - arg0.element);
        return Unit.INSTANCE;
    }

    public static final Object animateToNextPage(PagerState arg8, Continuation arg9) {
        if(arg8.getCurrentPage() + 1 < arg8.getPageCount()) {
            Object v8 = PagerState.animateScrollToPage$default(arg8, arg8.getCurrentPage() + 1, 0f, null, arg9, 6, null);
            if(v8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return v8;
            }

            return Unit.INSTANCE;
        }

        return Unit.INSTANCE;
    }

    public static final Object animateToPreviousPage(PagerState arg8, Continuation arg9) {
        if(arg8.getCurrentPage() - 1 >= 0) {
            Object v8 = PagerState.animateScrollToPage$default(arg8, arg8.getCurrentPage() - 1, 0f, null, arg9, 6, null);
            if(v8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return v8;
            }

            return Unit.INSTANCE;
        }

        return Unit.INSTANCE;
    }

    public static final long calculateNewMaxScrollOffset(PagerLayoutInfo arg10, int arg11) {
        long v1 = (((long)arg11)) * (((long)(arg10.getPageSpacing() + arg10.getPageSize()))) + (((long)arg10.getBeforeContentPadding())) + (((long)arg10.getAfterContentPadding())) - (((long)arg10.getPageSpacing()));
        long v3 = arg10.getOrientation() == Orientation.Horizontal ? arg10.getViewportSize-YbymL2g() >> 0x20 : arg10.getViewportSize-YbymL2g() & 0xFFFFFFFFL;
        int v4 = ((int)v3);
        return RangesKt.coerceAtLeast(v1 - (((long)(v4 - RangesKt.coerceIn(arg10.getSnapPosition().position(v4, arg10.getPageSize(), arg10.getBeforeContentPadding(), arg10.getAfterContentPadding(), arg11 - 1, arg11), 0, v4)))), 0);
    }

    private static final long calculateNewMinScrollOffset(PagerMeasureResult arg8, int arg9) {
        long v0 = arg8.getOrientation() == Orientation.Horizontal ? arg8.getViewportSize-YbymL2g() >> 0x20 : arg8.getViewportSize-YbymL2g() & 0xFFFFFFFFL;
        int v2 = ((int)v0);
        return ((long)RangesKt.coerceIn(arg8.getSnapPosition().position(v2, arg8.getPageSize(), arg8.getBeforeContentPadding(), arg8.getAfterContentPadding(), 0, arg9), 0, v2));
    }

    private static final void debugLog(Function0 arg0) {
    }

    public static final float getDefaultPositionThreshold() {
        return PagerStateKt.DefaultPositionThreshold;
    }

    public static final PagerMeasureResult getEmptyLayoutInfo() {
        return PagerStateKt.EmptyLayoutInfo;
    }

    public static final PagerState rememberPagerState(int arg6, float arg7, Function0 arg8, Composer arg9, int arg10, int arg11) {
        int v1 = 0xB7D52303;
        ComposerKt.sourceInformationMarkerStart(arg9, v1, "C(rememberPagerState)N(initialPage,initialPageOffsetFraction,pageCount)94@4368L92,94@4318L142:PagerState.kt#g6yjnt");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg10, -1, "androidx.compose.foundation.pager.rememberPagerState (PagerState.kt:93)");
        }

        Object[] v11 = new Object[0];
        Saver v0 = DefaultPagerState.Companion.getSaver();
        ComposerKt.sourceInformationMarkerStart(arg9, 0x17188B7F, "CC(remember):PagerState.kt#9igjgp");
        int v3 = 4;
        int v4 = 1;
        v1 = (arg10 & 14 ^ 6) > v3 && (arg9.changed(0)) || (arg10 & 6) == v3 ? 1 : 0;
        int v5 = 0x20;
        v3 = (arg10 & 0x70 ^ 0x30) > v5 && (arg9.changed(0f)) || (arg10 & 0x30) == v5 ? 1 : 0;
        v1 |= v3;
        v5 = 0x100;
        if((arg10 & 0x380 ^ 0x180) <= v5 || !arg9.changed(arg8)) {
            if((arg10 & 0x180) == v5) {
            }
            else {
                v4 = 0;
            }
        }

        arg10 = v1 | v4;
        Object v1_1 = arg9.rememberedValue();
        if(arg10 != 0 || v1_1 == Composer.Companion.getEmpty()) {
            PagerStateKt$$ExternalSyntheticLambda0 v1_2 = new PagerStateKt$$ExternalSyntheticLambda0(0, 0f, arg8);
            arg9.updateRememberedValue(v1_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg9);
        Object v6 = RememberSaveableKt.rememberSaveable(v11, v0, ((Function0)v1_1), arg9, 0);
        ((DefaultPagerState)v6).getPageCountState().setValue(arg8);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg9);
        return ((PagerState)v6);
    }

    private static final DefaultPagerState rememberPagerState$lambda$0$0(int arg1, float arg2, Function0 arg3) {
        return new DefaultPagerState(arg1, arg2, arg3);
    }
}

