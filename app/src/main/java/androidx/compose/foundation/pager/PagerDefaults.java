package androidx.compose.foundation.pager;

import androidx.compose.animation.SplineBasedFloatDecayAnimationSpec_androidKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.gestures.snapping.PagerSnapLayoutInfoProviderKt;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.IntCompanionObject;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JI\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\u000E\b\u0002\u0010\n\u001A\b\u0012\u0004\u0012\u00020\f0\u000B2\u000E\b\u0002\u0010\r\u001A\b\u0012\u0004\u0012\u00020\f0\u000E2\b\b\u0003\u0010\u000F\u001A\u00020\fH\u0007¢\u0006\u0002\u0010\u0010J\u001D\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u0013\u001A\u00020\u0014H\u0007¢\u0006\u0002\u0010\u0015R\u000E\u0010\u0016\u001A\u00020\u0017X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2={"Landroidx/compose/foundation/pager/PagerDefaults;", "", "<init>", "()V", "flingBehavior", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "state", "Landroidx/compose/foundation/pager/PagerState;", "pagerSnapDistance", "Landroidx/compose/foundation/pager/PagerSnapDistance;", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "snapPositionalThreshold", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/pager/PagerSnapDistance;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;FLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "pageNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "BeyondViewportPageCount", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PagerDefaults {
    public static final int $stable;
    public static final int BeyondViewportPageCount;
    public static final PagerDefaults INSTANCE;

    public static float $r8$lambda$Y8fAEK2Na6zoCUKEOP9ZJbMN9Sc(PagerState arg0, LayoutDirection arg1, float arg2, float arg3, float arg4, float arg5) {
        return PagerDefaults.flingBehavior$lambda$1$0(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    static {
        PagerDefaults.INSTANCE = new PagerDefaults();
    }

    private PagerDefaults() {
        super();
    }

    public final TargetedFlingBehavior flingBehavior(PagerState arg6, PagerSnapDistance arg7, DecayAnimationSpec arg8, AnimationSpec arg9, float arg10, Composer arg11, int arg12, int arg13) {
        SpringSpec v9;
        int v0 = 0x5CF8305D;
        ComposerKt.sourceInformationMarkerStart(arg11, v0, "C(flingBehavior)N(state,pagerSnapDistance,decayAnimationSpec,snapAnimationSpec,snapPositionalThreshold)377@20920L26,389@21520L7,390@21579L7,391@21602L1058:Pager.kt#g6yjnt");
        int v1 = 1;
        if((arg13 & 2) != 0) {
            arg7 = PagerSnapDistance.Companion.atMost(1);
        }

        if((arg13 & 4) != 0) {
            arg8 = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(arg11, 0);
        }

        if((arg13 & 8) != 0) {
            v9 = AnimationSpecKt.spring$default(0f, 400f, Float.valueOf(((float)VisibilityThresholdsKt.getVisibilityThreshold(IntCompanionObject.INSTANCE))), 1, null);
        }

        if((arg13 & 16) != 0) {
            arg10 = 0.5f;
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg12, -1, "androidx.compose.foundation.pager.PagerDefaults.flingBehavior (Pager.kt:384)");
        }

        int v5 = 0f > arg10 || arg10 > 1f ? 0 : 1;
        if(v5 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("snapPositionalThreshold should be a number between 0 and 1. You\'ve specified " + arg10);
        }

        ProvidableCompositionLocal v5_1 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(arg11, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v5_2 = arg11.consume(((CompositionLocal)v5_1));
        ComposerKt.sourceInformationMarkerEnd(arg11);
        ProvidableCompositionLocal v3 = CompositionLocalsKt.getLocalLayoutDirection();
        ComposerKt.sourceInformationMarkerStart(arg11, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v13 = arg11.consume(((CompositionLocal)v3));
        ComposerKt.sourceInformationMarkerEnd(arg11);
        ComposerKt.sourceInformationMarkerStart(arg11, 0xFFADFCBF, "CC(remember):Pager.kt#9igjgp");
        int v3_1 = 4;
        v0 = (arg12 & 14 ^ 6) > v3_1 && (arg11.changed(arg6)) || (arg12 & 6) == v3_1 ? 1 : 0;
        v0 = v0 | arg11.changed(arg8) | arg11.changed(v9);
        int v4 = 0x20;
        if((arg12 & 0x70 ^ 0x30) <= v4 || !arg11.changed(arg7)) {
            if((arg12 & 0x30) == v4) {
            }
            else {
                v1 = 0;
            }
        }

        v5 = arg11.changed(v5_2) | (v0 | v1) | arg11.changed(v13.ordinal());
        Object v12 = arg11.rememberedValue();
        if(v5 != 0 || v12 == Composer.Companion.getEmpty()) {
            TargetedFlingBehavior v12_1 = SnapFlingBehaviorKt.snapFlingBehavior(PagerSnapLayoutInfoProviderKt.SnapLayoutInfoProvider(arg6, arg7, new PagerDefaults$$ExternalSyntheticLambda0(arg6, ((LayoutDirection)v13), arg10)), arg8, ((AnimationSpec)v9));
            arg11.updateRememberedValue(v12_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg11);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg11);
        return ((TargetedFlingBehavior)v12);
    }

    private static final float flingBehavior$lambda$1$0(PagerState arg0, LayoutDirection arg1, float arg2, float arg3, float arg4, float arg5) {
        return PagerSnapLayoutInfoProviderKt.calculateFinalSnappingBound(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    public final NestedScrollConnection pageNestedScrollConnection(PagerState arg5, Orientation arg6, Composer arg7, int arg8) {
        DefaultPagerNestedScrollConnection v8_1;
        int v0 = 0x344EDB10;
        ComposerKt.sourceInformationMarkerStart(arg7, v0, "C(pageNestedScrollConnection)N(state,orientation)434@23131L107:Pager.kt#g6yjnt");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg8, -1, "androidx.compose.foundation.pager.PagerDefaults.pageNestedScrollConnection (Pager.kt:433)");
        }

        ComposerKt.sourceInformationMarkerStart(arg7, 0x5C0468FB, "CC(remember):Pager.kt#9igjgp");
        v0 = 0;
        int v2 = 4;
        int v4 = (arg8 & 14 ^ 6) > v2 && (arg7.changed(arg5)) || (arg8 & 6) == v2 ? 1 : 0;
        int v3 = 0x20;
        if((arg8 & 0x70 ^ 0x30) > v3 && (arg7.changed(arg6.ordinal())) || (arg8 & 0x30) == v3) {
            v0 = 1;
        }

        Object v8 = arg7.rememberedValue();
        if((v4 | v0) != 0 || v8 == Composer.Companion.getEmpty()) {
            v8_1 = new DefaultPagerNestedScrollConnection(arg5, arg6);
            arg7.updateRememberedValue(v8_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg7);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg7);
        return ((NestedScrollConnection)v8_1);
    }
}

