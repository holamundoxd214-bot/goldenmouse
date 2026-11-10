package androidx.compose.animation.core;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

@Metadata(d1={"\u0000t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000F\u001AW\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00022\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u00022\b\b\u0002\u0010\t\u001A\u00020\n2\u0016\b\u0002\u0010\u000B\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0007¢\u0006\u0002\u0010\u000E\u001AO\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00100\u00042\u0006\u0010\u0005\u001A\u00020\u00102\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00100\u00072\b\b\u0002\u0010\t\u001A\u00020\n2\u0016\b\u0002\u0010\u000B\u001A\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001AO\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00150\u00042\u0006\u0010\u0005\u001A\u00020\u00152\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00150\u00072\b\b\u0002\u0010\t\u001A\u00020\n2\u0016\b\u0002\u0010\u000B\u001A\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001AO\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u001A0\u00042\u0006\u0010\u0005\u001A\u00020\u001A2\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u001A0\u00072\b\b\u0002\u0010\t\u001A\u00020\n2\u0016\b\u0002\u0010\u000B\u001A\u0010\u0012\u0004\u0012\u00020\u001A\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0007¢\u0006\u0004\b\u001B\u0010\u0017\u001AM\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\u001E0\u00042\u0006\u0010\u0005\u001A\u00020\u001E2\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u001E0\u00072\b\b\u0002\u0010\t\u001A\u00020\n2\u0016\b\u0002\u0010\u000B\u001A\u0010\u0012\u0004\u0012\u00020\u001E\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0007¢\u0006\u0002\u0010\u001F\u001AM\u0010!\u001A\b\u0012\u0004\u0012\u00020\"0\u00042\u0006\u0010\u0005\u001A\u00020\"2\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\"0\u00072\b\b\u0002\u0010\t\u001A\u00020\n2\u0016\b\u0002\u0010\u000B\u001A\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0007¢\u0006\u0002\u0010#\u001AO\u0010%\u001A\b\u0012\u0004\u0012\u00020&0\u00042\u0006\u0010\u0005\u001A\u00020&2\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020&0\u00072\b\b\u0002\u0010\t\u001A\u00020\n2\u0016\b\u0002\u0010\u000B\u001A\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0007¢\u0006\u0004\b\'\u0010\u0017\u001AO\u0010)\u001A\b\u0012\u0004\u0012\u00020*0\u00042\u0006\u0010\u0005\u001A\u00020*2\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020*0\u00072\b\b\u0002\u0010\t\u001A\u00020\n2\u0016\b\u0002\u0010\u000B\u001A\u0010\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0007¢\u0006\u0004\b+\u0010\u0017\u001A}\u0010-\u001A\b\u0012\u0004\u0012\u0002H.0\u0004\"\u0004\b\u0000\u0010.\"\b\b\u0001\u0010/*\u0002002\u0006\u0010\u0005\u001A\u0002H.2\u0012\u00101\u001A\u000E\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H/022\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u0002H.0\u00072\n\b\u0002\u0010\b\u001A\u0004\u0018\u0001H.2\b\b\u0002\u0010\t\u001A\u00020\n2\u0016\b\u0002\u0010\u000B\u001A\u0010\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0007¢\u0006\u0002\u00103\u001AM\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00022\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u00022\u0016\b\u0002\u0010\u000B\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0007¢\u0006\u0002\u00104\u001AE\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00100\u00042\u0006\u0010\u0005\u001A\u00020\u00102\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00100\u00072\u0016\b\u0002\u0010\u000B\u001A\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0007¢\u0006\u0004\b5\u00106\u001AE\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00150\u00042\u0006\u0010\u0005\u001A\u00020\u00152\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00150\u00072\u0016\b\u0002\u0010\u000B\u001A\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0007¢\u0006\u0004\b7\u00108\u001AE\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u001A0\u00042\u0006\u0010\u0005\u001A\u00020\u001A2\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u001A0\u00072\u0016\b\u0002\u0010\u000B\u001A\u0010\u0012\u0004\u0012\u00020\u001A\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0007¢\u0006\u0004\b9\u00108\u001AC\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\u001E0\u00042\u0006\u0010\u0005\u001A\u00020\u001E2\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u001E0\u00072\u0016\b\u0002\u0010\u000B\u001A\u0010\u0012\u0004\u0012\u00020\u001E\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0007¢\u0006\u0002\u0010:\u001AC\u0010!\u001A\b\u0012\u0004\u0012\u00020\"0\u00042\u0006\u0010\u0005\u001A\u00020\"2\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\"0\u00072\u0016\b\u0002\u0010\u000B\u001A\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0007¢\u0006\u0002\u0010;\u001AE\u0010%\u001A\b\u0012\u0004\u0012\u00020&0\u00042\u0006\u0010\u0005\u001A\u00020&2\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020&0\u00072\u0016\b\u0002\u0010\u000B\u001A\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0007¢\u0006\u0004\b<\u00108\u001AE\u0010)\u001A\b\u0012\u0004\u0012\u00020*0\u00042\u0006\u0010\u0005\u001A\u00020*2\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020*0\u00072\u0016\b\u0002\u0010\u000B\u001A\u0010\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0007¢\u0006\u0004\b=\u00108\u001As\u0010-\u001A\b\u0012\u0004\u0012\u0002H.0\u0004\"\u0004\b\u0000\u0010.\"\b\b\u0001\u0010/*\u0002002\u0006\u0010\u0005\u001A\u0002H.2\u0012\u00101\u001A\u000E\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H/022\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u0002H.0\u00072\n\b\u0002\u0010\b\u001A\u0004\u0018\u0001H.2\u0016\b\u0002\u0010\u000B\u001A\u0010\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0007¢\u0006\u0002\u0010>\"\u0014\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u00100\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020\u00150\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u001C\u001A\b\u0012\u0004\u0012\u00020\u001A0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010 \u001A\b\u0012\u0004\u0012\u00020\u001E0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010$\u001A\b\u0012\u0004\u0012\u00020\"0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010(\u001A\b\u0012\u0004\u0012\u00020&0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010,\u001A\b\u0012\u0004\u0012\u00020*0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006?²\u0006\u001E\u0010@\u001A\u0010\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u00020\r\u0018\u00010\f\"\u0004\b\u0000\u0010.X\u008A\u0084\u0002²\u0006\u0016\u0010A\u001A\b\u0012\u0004\u0012\u0002H.0\u0007\"\u0004\b\u0000\u0010.X\u008A\u0084\u0002"}, d2={"defaultAnimation", "Landroidx/compose/animation/core/SpringSpec;", "", "animateFloatAsState", "Landroidx/compose/runtime/State;", "targetValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "visibilityThreshold", "label", "", "finishedListener", "Lkotlin/Function1;", "", "(FLandroidx/compose/animation/core/AnimationSpec;FLjava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateDpAsState", "Landroidx/compose/ui/unit/Dp;", "animateDpAsState-AjpBEmI", "(FLandroidx/compose/animation/core/AnimationSpec;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "dpDefaultSpring", "animateSizeAsState", "Landroidx/compose/ui/geometry/Size;", "animateSizeAsState-YLp_XPw", "(JLandroidx/compose/animation/core/AnimationSpec;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "sizeDefaultSpring", "animateOffsetAsState", "Landroidx/compose/ui/geometry/Offset;", "animateOffsetAsState-7362WCg", "offsetDefaultSpring", "animateRectAsState", "Landroidx/compose/ui/geometry/Rect;", "(Landroidx/compose/ui/geometry/Rect;Landroidx/compose/animation/core/AnimationSpec;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "rectDefaultSpring", "animateIntAsState", "", "(ILandroidx/compose/animation/core/AnimationSpec;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "intDefaultSpring", "animateIntOffsetAsState", "Landroidx/compose/ui/unit/IntOffset;", "animateIntOffsetAsState-HyPO7BM", "intOffsetDefaultSpring", "animateIntSizeAsState", "Landroidx/compose/ui/unit/IntSize;", "animateIntSizeAsState-4goxYXU", "intSizeDefaultSpring", "animateValueAsState", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "(Ljava/lang/Object;Landroidx/compose/animation/core/TwoWayConverter;Landroidx/compose/animation/core/AnimationSpec;Ljava/lang/Object;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "(FLandroidx/compose/animation/core/AnimationSpec;FLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateDpAsState-Kz89ssw", "(FLandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateSizeAsState-LjSzlW0", "(JLandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateOffsetAsState-N6fFfp4", "(Landroidx/compose/ui/geometry/Rect;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "(ILandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateIntOffsetAsState-8f6pmRE", "animateIntSizeAsState-zTRF_AQ", "(Ljava/lang/Object;Landroidx/compose/animation/core/TwoWayConverter;Landroidx/compose/animation/core/AnimationSpec;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animation-core", "listener", "animSpec"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AnimateAsStateKt {
    private static final SpringSpec defaultAnimation;
    private static final SpringSpec dpDefaultSpring;
    private static final SpringSpec intDefaultSpring;
    private static final SpringSpec intOffsetDefaultSpring;
    private static final SpringSpec intSizeDefaultSpring;
    private static final SpringSpec offsetDefaultSpring;
    private static final SpringSpec rectDefaultSpring;
    private static final SpringSpec sizeDefaultSpring;

    public static Unit $r8$lambda$sgo7hSAUwHCqZ7OT0F9GrJyPKiQ(Channel arg0, Object arg1) {
        return AnimateAsStateKt.animateValueAsState$lambda$7$0(arg0, arg1);
    }

    static {
        AnimateAsStateKt.defaultAnimation = AnimationSpecKt.spring$default(0f, 0f, null, 7, null);
        AnimateAsStateKt.dpDefaultSpring = AnimationSpecKt.spring$default(0f, 0f, Dp.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(Dp.Companion)), 3, null);
        AnimateAsStateKt.sizeDefaultSpring = AnimationSpecKt.spring$default(0f, 0f, Size.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(Size.Companion)), 3, null);
        AnimateAsStateKt.offsetDefaultSpring = AnimationSpecKt.spring$default(0f, 0f, Offset.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(Offset.Companion)), 3, null);
        AnimateAsStateKt.rectDefaultSpring = AnimationSpecKt.spring$default(0f, 0f, VisibilityThresholdsKt.getVisibilityThreshold(Rect.Companion), 3, null);
        AnimateAsStateKt.intDefaultSpring = AnimationSpecKt.spring$default(0f, 0f, Integer.valueOf(VisibilityThresholdsKt.getVisibilityThreshold(IntCompanionObject.INSTANCE)), 3, null);
        AnimateAsStateKt.intOffsetDefaultSpring = AnimationSpecKt.spring$default(0f, 0f, IntOffset.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 3, null);
        AnimateAsStateKt.intSizeDefaultSpring = AnimationSpecKt.spring$default(0f, 0f, IntSize.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 3, null);
    }

    public static final Function1 access$animateValueAsState$lambda$3(State arg0) {
        return AnimateAsStateKt.animateValueAsState$lambda$3(arg0);
    }

    public static final AnimationSpec access$animateValueAsState$lambda$5(State arg0) {
        return AnimateAsStateKt.animateValueAsState$lambda$5(arg0);
    }

    public static final State animateDpAsState-AjpBEmI(float arg12, AnimationSpec arg13, String arg14, Function1 arg15, Composer arg16, int arg17, int arg18) {
        SpringSpec v13;
        int v0 = arg17;
        int v2 = -1407150062;
        Composer v9 = arg16;
        ComposerKt.sourceInformationMarkerStart(v9, v2, "C(animateDpAsState)N(targetValue:c#ui.unit.Dp,animationSpec,label,finishedListener)112@5031L166:AnimateAsState.kt#pdpnli");
        if((arg18 & 2) != 0) {
            v13 = AnimateAsStateKt.dpDefaultSpring;
        }

        AnimationSpec v5 = ((AnimationSpec)v13);
        if((arg18 & 4) != 0) {
            arg14 = "DpAnimation";
        }

        String v7 = arg14;
        if((arg18 & 8) != 0) {
            arg15 = null;
        }

        Function1 v8 = arg15;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, v0, -1, "androidx.compose.animation.core.animateDpAsState (AnimateAsState.kt:111)");
        }

        int v13_1 = v0 << 6;
        State v12 = AnimateAsStateKt.animateValueAsState(Dp.box-impl(arg12), VectorConvertersKt.getVectorConverter(Dp.Companion), v5, null, v7, v8, v9, v0 & 14 | v0 << 3 & 0x380 | 0xE000 & v13_1 | v13_1 & 0x70000, 8);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg16);
        return v12;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="animate*AsState APIs now have a new label parameter added.") public static final State animateDpAsState-Kz89ssw(float arg12, AnimationSpec arg13, Function1 arg14, Composer arg15, int arg16, int arg17) {
        SpringSpec v13;
        int v0 = arg16;
        int v2 = 704104481;
        ComposerKt.sourceInformationMarkerStart(arg15, v2, "C(animateDpAsState)N(targetValue:c#ui.unit.Dp,animationSpec,finishedListener)463@20568L143:AnimateAsState.kt#pdpnli");
        if((arg17 & 2) != 0) {
            v13 = AnimateAsStateKt.dpDefaultSpring;
        }

        AnimationSpec v5 = ((AnimationSpec)v13);
        if((arg17 & 4) != 0) {
            arg14 = null;
        }

        Function1 v8 = arg14;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, v0, -1, "androidx.compose.animation.core.animateDpAsState (AnimateAsState.kt:462)");
        }

        State v12 = AnimateAsStateKt.animateValueAsState(Dp.box-impl(arg12), VectorConvertersKt.getVectorConverter(Dp.Companion), v5, null, null, v8, arg15, v0 & 14 | v0 << 3 & 0x380 | v0 << 9 & 0x70000, 24);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg15);
        return v12;
    }

    public static final State animateFloatAsState(float arg9, AnimationSpec arg10, float arg11, String arg12, Function1 arg13, Composer arg14, int arg15, int arg16) {
        SpringSpec v10;
        int v2 = 668842840;
        ComposerKt.sourceInformationMarkerStart(arg14, v2, "C(animateFloatAsState)N(targetValue,animationSpec,visibilityThreshold,label,finishedListener)74@3329L174:AnimateAsState.kt#pdpnli");
        if((arg16 & 2) != 0) {
            v10 = AnimateAsStateKt.defaultAnimation;
        }

        if((arg16 & 4) != 0) {
            arg11 = 0.01f;
        }

        if((arg16 & 8) != 0) {
            arg12 = "FloatAnimation";
        }

        String v4 = arg12;
        Object v1 = null;
        Function1 v5 = (arg16 & 16) != 0 ? ((Function1)v1) : arg13;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, arg15, -1, "androidx.compose.animation.core.animateFloatAsState (AnimateAsState.kt:67)");
        }

        int v13 = 3;
        if((((AnimationSpec)v10)) == AnimateAsStateKt.defaultAnimation) {
            arg14.startReplaceGroup(0x44316D7F);
            ComposerKt.sourceInformation(arg14, "70@3181L83");
            ComposerKt.sourceInformationMarkerStart(arg14, 0xA75C708B, "CC(remember):AnimateAsState.kt#9igjgp");
            int v12 = 0x100;
            int v10_1 = (arg15 & 0x380 ^ 0x180) > v12 && (arg14.changed(arg11)) || (arg15 & 0x180) == v12 ? 1 : 0;
            Object v12_1 = arg14.rememberedValue();
            if(v10_1 != 0 || v12_1 == Composer.Companion.getEmpty()) {
                SpringSpec v12_2 = AnimationSpecKt.spring$default(0f, 0f, Float.valueOf(arg11), v13, v1);
                arg14.updateRememberedValue(v12_2);
            }

            ComposerKt.sourceInformationMarkerEnd(arg14);
            arg14.endReplaceGroup();
            Object v10_2 = v12_1;
        }
        else {
            arg14.startReplaceGroup(1144199909);
            arg14.endReplaceGroup();
        }

        Float v9 = Float.valueOf(arg9);
        TwoWayConverter v1_1 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
        Float v3 = Float.valueOf(arg11);
        int v11 = arg15 << 3;
        State v9_1 = AnimateAsStateKt.animateValueAsState(v9, v1_1, ((AnimationSpec)v10), v3, v4, v5, arg14, arg15 & 14 | v11 & 0x1C00 | 0xE000 & v11 | v11 & 0x70000, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg14);
        return v9_1;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="animate*AsState APIs now have a new label parameter added.") public static final State animateFloatAsState(float arg11, AnimationSpec arg12, float arg13, Function1 arg14, Composer arg15, int arg16, int arg17) {
        SpringSpec v12;
        int v0 = arg16;
        int v2 = 1091643291;
        ComposerKt.sourceInformationMarkerStart(arg15, v2, "C(animateFloatAsState)N(targetValue,animationSpec,visibilityThreshold,finishedListener)446@20114L144:AnimateAsState.kt#pdpnli");
        if((arg17 & 2) != 0) {
            v12 = AnimateAsStateKt.defaultAnimation;
        }

        AnimationSpec v4 = ((AnimationSpec)v12);
        if((arg17 & 4) != 0) {
            arg13 = 0.01f;
        }

        float v5 = arg13;
        if((arg17 & 8) != 0) {
            arg14 = null;
        }

        Function1 v7 = arg14;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, v0, -1, "androidx.compose.animation.core.animateFloatAsState (AnimateAsState.kt:446)");
        }

        State v11 = AnimateAsStateKt.animateFloatAsState(arg11, v4, v5, null, v7, arg15, v0 & 0x3FE | v0 << 3 & 0xE000, 8);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg15);
        return v11;
    }

    public static final State animateIntAsState(int arg12, AnimationSpec arg13, String arg14, Function1 arg15, Composer arg16, int arg17, int arg18) {
        SpringSpec v13;
        int v0 = arg17;
        int v2 = 428074472;
        Composer v9 = arg16;
        ComposerKt.sourceInformationMarkerStart(v9, v2, "C(animateIntAsState)N(targetValue,animationSpec,label,finishedListener)271@12268L167:AnimateAsState.kt#pdpnli");
        if((arg18 & 2) != 0) {
            v13 = AnimateAsStateKt.intDefaultSpring;
        }

        AnimationSpec v5 = ((AnimationSpec)v13);
        if((arg18 & 4) != 0) {
            arg14 = "IntAnimation";
        }

        String v7 = arg14;
        if((arg18 & 8) != 0) {
            arg15 = null;
        }

        Function1 v8 = arg15;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, v0, -1, "androidx.compose.animation.core.animateIntAsState (AnimateAsState.kt:270)");
        }

        int v13_1 = v0 << 6;
        State v12 = AnimateAsStateKt.animateValueAsState(Integer.valueOf(arg12), VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE), v5, null, v7, v8, v9, v0 & 14 | v0 << 3 & 0x380 | 0xE000 & v13_1 | v13_1 & 0x70000, 8);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg16);
        return v12;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="animate*AsState APIs now have a new label parameter added.") public static final State animateIntAsState(int arg12, AnimationSpec arg13, Function1 arg14, Composer arg15, int arg16, int arg17) {
        SpringSpec v13;
        int v0 = arg16;
        int v2 = 0xCDC6BF0B;
        ComposerKt.sourceInformationMarkerStart(arg15, v2, "C(animateIntAsState)N(targetValue,animationSpec,finishedListener)535@22450L144:AnimateAsState.kt#pdpnli");
        if((arg17 & 2) != 0) {
            v13 = AnimateAsStateKt.intDefaultSpring;
        }

        AnimationSpec v5 = ((AnimationSpec)v13);
        if((arg17 & 4) != 0) {
            arg14 = null;
        }

        Function1 v8 = arg14;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, v0, -1, "androidx.compose.animation.core.animateIntAsState (AnimateAsState.kt:534)");
        }

        State v12 = AnimateAsStateKt.animateValueAsState(Integer.valueOf(arg12), VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE), v5, null, null, v8, arg15, v0 & 14 | v0 << 3 & 0x380 | v0 << 9 & 0x70000, 24);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg15);
        return v12;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="animate*AsState APIs now have a new label parameter added.") public static final State animateIntOffsetAsState-8f6pmRE(long arg12, AnimationSpec arg14, Function1 arg15, Composer arg16, int arg17, int arg18) {
        SpringSpec v14;
        int v0 = arg17;
        int v2 = 1010307371;
        Composer v9 = arg16;
        ComposerKt.sourceInformationMarkerStart(v9, v2, "C(animateIntOffsetAsState)N(targetValue:c#ui.unit.IntOffset,animationSpec,finishedListener)553@22948L150:AnimateAsState.kt#pdpnli");
        if((arg18 & 2) != 0) {
            v14 = AnimateAsStateKt.intOffsetDefaultSpring;
        }

        AnimationSpec v5 = ((AnimationSpec)v14);
        if((arg18 & 4) != 0) {
            arg15 = null;
        }

        Function1 v8 = arg15;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, v0, -1, "androidx.compose.animation.core.animateIntOffsetAsState (AnimateAsState.kt:552)");
        }

        State v12 = AnimateAsStateKt.animateValueAsState(IntOffset.box-impl(arg12), VectorConvertersKt.getVectorConverter(IntOffset.Companion), v5, null, null, v8, v9, v0 & 14 | v0 << 3 & 0x380 | v0 << 9 & 0x70000, 24);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg16);
        return v12;
    }

    public static final State animateIntOffsetAsState-HyPO7BM(long arg12, AnimationSpec arg14, String arg15, Function1 arg16, Composer arg17, int arg18, int arg19) {
        SpringSpec v14;
        int v0 = arg18;
        int v2 = 0xD677EFC8;
        Composer v9 = arg17;
        ComposerKt.sourceInformationMarkerStart(v9, v2, "C(animateIntOffsetAsState)N(targetValue:c#ui.unit.IntOffset,animationSpec,label,finishedListener)310@14118L173:AnimateAsState.kt#pdpnli");
        if((arg19 & 2) != 0) {
            v14 = AnimateAsStateKt.intOffsetDefaultSpring;
        }

        AnimationSpec v5 = ((AnimationSpec)v14);
        if((arg19 & 4) != 0) {
            arg15 = "IntOffsetAnimation";
        }

        String v7 = arg15;
        Function1 v8 = (arg19 & 8) != 0 ? null : arg16;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, v0, -1, "androidx.compose.animation.core.animateIntOffsetAsState (AnimateAsState.kt:309)");
        }

        IntOffset v3 = IntOffset.box-impl(arg12);
        int v13 = v0 << 6;
        State v12 = AnimateAsStateKt.animateValueAsState(v3, VectorConvertersKt.getVectorConverter(IntOffset.Companion), v5, null, v7, v8, v9, v0 & 14 | v0 << 3 & 0x380 | 0xE000 & v13 | v13 & 0x70000, 8);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg17);
        return v12;
    }

    public static final State animateIntSizeAsState-4goxYXU(long arg12, AnimationSpec arg14, String arg15, Function1 arg16, Composer arg17, int arg18, int arg19) {
        SpringSpec v14;
        int v0 = arg18;
        int v2 = 0x22B968C8;
        Composer v9 = arg17;
        ComposerKt.sourceInformationMarkerStart(v9, v2, "C(animateIntSizeAsState)N(targetValue:c#ui.unit.IntSize,animationSpec,label,finishedListener)348@15895L171:AnimateAsState.kt#pdpnli");
        if((arg19 & 2) != 0) {
            v14 = AnimateAsStateKt.intSizeDefaultSpring;
        }

        AnimationSpec v5 = ((AnimationSpec)v14);
        if((arg19 & 4) != 0) {
            arg15 = "IntSizeAnimation";
        }

        String v7 = arg15;
        Function1 v8 = (arg19 & 8) != 0 ? null : arg16;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, v0, -1, "androidx.compose.animation.core.animateIntSizeAsState (AnimateAsState.kt:347)");
        }

        IntSize v3 = IntSize.box-impl(arg12);
        int v13 = v0 << 6;
        State v12 = AnimateAsStateKt.animateValueAsState(v3, VectorConvertersKt.getVectorConverter(IntSize.Companion), v5, null, v7, v8, v9, v0 & 14 | v0 << 3 & 0x380 | 0xE000 & v13 | v13 & 0x70000, 8);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg17);
        return v12;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="animate*AsState APIs now have a new label parameter added.") public static final State animateIntSizeAsState-zTRF_AQ(long arg12, AnimationSpec arg14, Function1 arg15, Composer arg16, int arg17, int arg18) {
        SpringSpec v14;
        int v0 = arg17;
        int v2 = 0x97BCB82B;
        Composer v9 = arg16;
        ComposerKt.sourceInformationMarkerStart(v9, v2, "C(animateIntSizeAsState)N(targetValue:c#ui.unit.IntSize,animationSpec,finishedListener)571@23440L148:AnimateAsState.kt#pdpnli");
        if((arg18 & 2) != 0) {
            v14 = AnimateAsStateKt.intSizeDefaultSpring;
        }

        AnimationSpec v5 = ((AnimationSpec)v14);
        if((arg18 & 4) != 0) {
            arg15 = null;
        }

        Function1 v8 = arg15;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, v0, -1, "androidx.compose.animation.core.animateIntSizeAsState (AnimateAsState.kt:570)");
        }

        State v12 = AnimateAsStateKt.animateValueAsState(IntSize.box-impl(arg12), VectorConvertersKt.getVectorConverter(IntSize.Companion), v5, null, null, v8, v9, v0 & 14 | v0 << 3 & 0x380 | v0 << 9 & 0x70000, 24);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg16);
        return v12;
    }

    public static final State animateOffsetAsState-7362WCg(long arg12, AnimationSpec arg14, String arg15, Function1 arg16, Composer arg17, int arg18, int arg19) {
        SpringSpec v14;
        int v0 = arg18;
        int v2 = 357896800;
        Composer v9 = arg17;
        ComposerKt.sourceInformationMarkerStart(v9, v2, "C(animateOffsetAsState)N(targetValue:c#ui.geometry.Offset,animationSpec,label,finishedListener)192@8692L170:AnimateAsState.kt#pdpnli");
        if((arg19 & 2) != 0) {
            v14 = AnimateAsStateKt.offsetDefaultSpring;
        }

        AnimationSpec v5 = ((AnimationSpec)v14);
        if((arg19 & 4) != 0) {
            arg15 = "OffsetAnimation";
        }

        String v7 = arg15;
        Function1 v8 = (arg19 & 8) != 0 ? null : arg16;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, v0, -1, "androidx.compose.animation.core.animateOffsetAsState (AnimateAsState.kt:191)");
        }

        Offset v3 = Offset.box-impl(arg12);
        int v13 = v0 << 6;
        State v12 = AnimateAsStateKt.animateValueAsState(v3, VectorConvertersKt.getVectorConverter(Offset.Companion), v5, null, v7, v8, v9, v0 & 14 | v0 << 3 & 0x380 | 0xE000 & v13 | v13 & 0x70000, 8);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg17);
        return v12;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="animate*AsState APIs now have a new label parameter added.") public static final State animateOffsetAsState-N6fFfp4(long arg12, AnimationSpec arg14, Function1 arg15, Composer arg16, int arg17, int arg18) {
        SpringSpec v14;
        int v0 = arg17;
        int v2 = 0xE4CA2993;
        Composer v9 = arg16;
        ComposerKt.sourceInformationMarkerStart(v9, v2, "C(animateOffsetAsState)N(targetValue:c#ui.geometry.Offset,animationSpec,finishedListener)499@21516L147:AnimateAsState.kt#pdpnli");
        if((arg18 & 2) != 0) {
            v14 = AnimateAsStateKt.offsetDefaultSpring;
        }

        AnimationSpec v5 = ((AnimationSpec)v14);
        if((arg18 & 4) != 0) {
            arg15 = null;
        }

        Function1 v8 = arg15;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, v0, -1, "androidx.compose.animation.core.animateOffsetAsState (AnimateAsState.kt:498)");
        }

        State v12 = AnimateAsStateKt.animateValueAsState(Offset.box-impl(arg12), VectorConvertersKt.getVectorConverter(Offset.Companion), v5, null, null, v8, v9, v0 & 14 | v0 << 3 & 0x380 | v0 << 9 & 0x70000, 24);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg16);
        return v12;
    }

    public static final State animateRectAsState(Rect arg12, AnimationSpec arg13, String arg14, Function1 arg15, Composer arg16, int arg17, int arg18) {
        SpringSpec v13;
        int v0 = arg17;
        int v2 = 0x1FF3AC02;
        Composer v9 = arg16;
        ComposerKt.sourceInformationMarkerStart(v9, v2, "C(animateRectAsState)N(targetValue,animationSpec,label,finishedListener)233@10546L168:AnimateAsState.kt#pdpnli");
        if((arg18 & 2) != 0) {
            v13 = AnimateAsStateKt.rectDefaultSpring;
        }

        AnimationSpec v5 = ((AnimationSpec)v13);
        if((arg18 & 4) != 0) {
            arg14 = "RectAnimation";
        }

        String v7 = arg14;
        if((arg18 & 8) != 0) {
            arg15 = null;
        }

        Function1 v8 = arg15;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, v0, -1, "androidx.compose.animation.core.animateRectAsState (AnimateAsState.kt:232)");
        }

        int v14 = v0 << 6;
        State v12 = AnimateAsStateKt.animateValueAsState(arg12, VectorConvertersKt.getVectorConverter(Rect.Companion), v5, null, v7, v8, v9, v0 & 14 | v0 << 3 & 0x380 | 0xE000 & v14 | v14 & 0x70000, 8);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg16);
        return v12;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="animate*AsState APIs now have a new label parameter added.") public static final State animateRectAsState(Rect arg12, AnimationSpec arg13, Function1 arg14, Composer arg15, int arg16, int arg17) {
        SpringSpec v13;
        int v0 = arg16;
        int v2 = 0xD15A4231;
        ComposerKt.sourceInformationMarkerStart(arg15, v2, "C(animateRectAsState)N(targetValue,animationSpec,finishedListener)517@21987L145:AnimateAsState.kt#pdpnli");
        if((arg17 & 2) != 0) {
            v13 = AnimateAsStateKt.rectDefaultSpring;
        }

        AnimationSpec v5 = ((AnimationSpec)v13);
        if((arg17 & 4) != 0) {
            arg14 = null;
        }

        Function1 v8 = arg14;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, v0, -1, "androidx.compose.animation.core.animateRectAsState (AnimateAsState.kt:516)");
        }

        State v12 = AnimateAsStateKt.animateValueAsState(arg12, VectorConvertersKt.getVectorConverter(Rect.Companion), v5, null, null, v8, arg15, v0 & 14 | v0 << 3 & 0x380 | v0 << 9 & 0x70000, 24);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg15);
        return v12;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="animate*AsState APIs now have a new label parameter added.") public static final State animateSizeAsState-LjSzlW0(long arg12, AnimationSpec arg14, Function1 arg15, Composer arg16, int arg17, int arg18) {
        SpringSpec v14;
        int v0 = arg17;
        int v2 = 0x342AAEB7;
        Composer v9 = arg16;
        ComposerKt.sourceInformationMarkerStart(v9, v2, "C(animateSizeAsState)N(targetValue:c#ui.geometry.Size,animationSpec,finishedListener)481@21035L145:AnimateAsState.kt#pdpnli");
        if((arg18 & 2) != 0) {
            v14 = AnimateAsStateKt.sizeDefaultSpring;
        }

        AnimationSpec v5 = ((AnimationSpec)v14);
        if((arg18 & 4) != 0) {
            arg15 = null;
        }

        Function1 v8 = arg15;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, v0, -1, "androidx.compose.animation.core.animateSizeAsState (AnimateAsState.kt:480)");
        }

        State v12 = AnimateAsStateKt.animateValueAsState(Size.box-impl(arg12), VectorConvertersKt.getVectorConverter(Size.Companion), v5, null, null, v8, v9, v0 & 14 | v0 << 3 & 0x380 | v0 << 9 & 0x70000, 24);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg16);
        return v12;
    }

    public static final State animateSizeAsState-YLp_XPw(long arg12, AnimationSpec arg14, String arg15, Function1 arg16, Composer arg17, int arg18, int arg19) {
        SpringSpec v14;
        int v0 = arg18;
        int v2 = 0x51EF3CBC;
        Composer v9 = arg17;
        ComposerKt.sourceInformationMarkerStart(v9, v2, "C(animateSizeAsState)N(targetValue:c#ui.geometry.Size,animationSpec,label,finishedListener)153@6870L168:AnimateAsState.kt#pdpnli");
        if((arg19 & 2) != 0) {
            v14 = AnimateAsStateKt.sizeDefaultSpring;
        }

        AnimationSpec v5 = ((AnimationSpec)v14);
        if((arg19 & 4) != 0) {
            arg15 = "SizeAnimation";
        }

        String v7 = arg15;
        Function1 v8 = (arg19 & 8) != 0 ? null : arg16;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, v0, -1, "androidx.compose.animation.core.animateSizeAsState (AnimateAsState.kt:152)");
        }

        Size v3 = Size.box-impl(arg12);
        int v13 = v0 << 6;
        State v12 = AnimateAsStateKt.animateValueAsState(v3, VectorConvertersKt.getVectorConverter(Size.Companion), v5, null, v7, v8, v9, v0 & 14 | v0 << 3 & 0x380 | 0xE000 & v13 | v13 & 0x70000, 8);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg17);
        return v12;
    }

    public static final State animateValueAsState(Object arg12, TwoWayConverter arg13, AnimationSpec arg14, Object arg15, String arg16, Function1 arg17, Composer arg18, int arg19, int arg20) {
        Object v13_1;
        Channel v7_2;
        Object v7_1;
        Animatable v9_1;
        Function1 v8_1;
        SpringSpec v2_1;
        Composer v0 = arg18;
        int v1 = arg19;
        int v3 = 0x892044A4;
        ComposerKt.sourceInformationMarkerStart(v0, v3, "C(animateValueAsState)N(targetValue,typeConverter,animationSpec,visibilityThreshold,label,finishedListener)391@17999L21,397@18182L44,398@18248L79,399@18348L38,401@18433L428,414@18880L42,415@18938L32,415@18927L43,416@18999L697,416@18975L721:AnimateAsState.kt#pdpnli");
        String v4 = "CC(remember):AnimateAsState.kt#9igjgp";
        Object v5 = null;
        if((arg20 & 4) != 0) {
            ComposerKt.sourceInformationMarkerStart(v0, -1037975943, v4);
            Object v2 = v0.rememberedValue();
            if(v2 == Composer.Companion.getEmpty()) {
                v2_1 = AnimationSpecKt.spring$default(0f, 0f, v5, 7, v5);
                v0.updateRememberedValue(v2_1);
            }

            ComposerKt.sourceInformationMarkerEnd(v0);
        }
        else {
            AnimationSpec v2_2 = arg14;
        }

        Object v6 = (arg20 & 8) != 0 ? v5 : arg15;
        String v7 = (arg20 & 16) != 0 ? "ValueAnimation" : arg16;
        if((arg20 & 0x20) != 0) {
            Object v8 = v5;
        }
        else {
            v8_1 = arg17;
        }

        int v10 = -1;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v3, v1, v10, "androidx.compose.animation.core.animateValueAsState (AnimateAsState.kt:395)");
        }

        ComposerKt.sourceInformationMarkerStart(v0, -1037970064, v4);
        Object v3_1 = v0.rememberedValue();
        if(v3_1 == Composer.Companion.getEmpty()) {
            MutableState v3_2 = SnapshotStateKt.mutableStateOf$default(v5, ((SnapshotMutationPolicy)v5), 2, v5);
            v0.updateRememberedValue(v3_2);
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        ComposerKt.sourceInformationMarkerStart(v0, -1037967917, v4);
        Object v9 = v0.rememberedValue();
        if(v9 == Composer.Companion.getEmpty()) {
            v9_1 = new Animatable(arg12, arg13, v6, v7);
            v0.updateRememberedValue(v9_1);
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        State v13 = SnapshotStateKt.rememberUpdatedState(v8_1, v0, v1 >> 15 & 14);
        if(v6 != null && ((v2_1 instanceof SpringSpec))) {
            v7_1 = v2_1;
            if(!Intrinsics.areEqual(((SpringSpec)v7_1).getVisibilityThreshold(), v6)) {
                v2_1 = AnimationSpecKt.spring(((SpringSpec)v7_1).getDampingRatio(), ((SpringSpec)v7_1).getStiffness(), v6);
            }
        }

        State v2_3 = SnapshotStateKt.rememberUpdatedState(v2_1, v0, 0);
        ComposerKt.sourceInformationMarkerStart(v0, -1037947730, v4);
        v7_1 = v0.rememberedValue();
        int v11 = 6;
        if(v7_1 == Composer.Companion.getEmpty()) {
            v7_2 = ChannelKt.Channel$default(v10, ((BufferOverflow)v5), ((Function1)v5), v11, v5);
            v0.updateRememberedValue(v7_2);
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        ComposerKt.sourceInformationMarkerStart(v0, -1037945884, v4);
        boolean v5_1 = v0.changedInstance(v7_2);
        v10 = 4;
        v1 = (v1 & 14 ^ v11) > v10 && (v0.changedInstance(arg12)) || (v1 & v11) == v10 ? 1 : 0;
        v1 |= ((int)v5_1);
        v5 = v0.rememberedValue();
        if(v1 != 0 || v5 == Composer.Companion.getEmpty()) {
            AnimateAsStateKt$$ExternalSyntheticLambda0 v5_2 = new AnimateAsStateKt$$ExternalSyntheticLambda0(v7_2, arg12);
            v0.updateRememberedValue(v5_2);
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        EffectsKt.SideEffect(((Function0)v5), v0, 0);
        ComposerKt.sourceInformationMarkerStart(v0, -1037943267, v4);
        int v12 = v0.changedInstance(v7_2) | v0.changedInstance(v9_1) | v0.changed(v2_3) | v0.changed(v13);
        Object v1_1 = v0.rememberedValue();
        if(v12 != 0 || v1_1 == Composer.Companion.getEmpty()) {
            State v16 = v13;
            v13_1 = v7_2;
            AnimateAsStateKt$animateValueAsState$3$1 v1_2 = new AnimateAsStateKt$animateValueAsState$3$1(((Channel)v13_1), v9_1, v2_3, v16, null);
            v0.updateRememberedValue(v1_2);
        }
        else {
            v13_1 = v7_2;
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        EffectsKt.LaunchedEffect(v13_1, ((Function2)v1_1), v0, 0);
        arg12 = ((MutableState)v3_1).getValue();
        if(arg12 == null) {
            State v12_1 = v9_1.asState();
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return ((State)arg12);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="animate*AsState APIs now have a new label parameter added.") public static final State animateValueAsState(Object arg9, TwoWayConverter arg10, AnimationSpec arg11, Object arg12, Function1 arg13, Composer arg14, int arg15, int arg16) {
        Object v1;
        int v2 = 0xCD8D3BCF;
        ComposerKt.sourceInformationMarkerStart(arg14, v2, "C(animateValueAsState)N(targetValue,typeConverter,animationSpec,visibilityThreshold,finishedListener)587@23879L21,591@24001L269:AnimateAsState.kt#pdpnli");
        Object v3 = null;
        if((arg16 & 4) != 0) {
            ComposerKt.sourceInformationMarkerStart(arg14, -1624402204, "CC(remember):AnimateAsState.kt#9igjgp");
            v1 = arg14.rememberedValue();
            if(v1 == Composer.Companion.getEmpty()) {
                SpringSpec v1_1 = AnimationSpecKt.spring$default(0f, 0f, v3, 7, v3);
                arg14.updateRememberedValue(v1_1);
            }

            ComposerKt.sourceInformationMarkerEnd(arg14);
        }
        else {
            AnimationSpec v1_2 = arg11;
        }

        Object v4 = (arg16 & 8) != 0 ? v3 : arg12;
        Function1 v5 = (arg16 & 16) != 0 ? ((Function1)v3) : arg13;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, arg15, -1, "androidx.compose.animation.core.animateValueAsState (AnimateAsState.kt:591)");
        }

        v2 = arg15 & 8;
        State v0 = AnimateAsStateKt.animateValueAsState(arg9, arg10, v1, v4, "ValueAnimation", v5, arg14, v2 << 9 | (v2 | 0x6000 | arg15 & 14 | arg15 & 0x70 | arg15 & 0x380) | arg15 & 0x1C00 | arg15 << 3 & 0x70000, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg14);
        return v0;
    }

    private static final Function1 animateValueAsState$lambda$3(State arg0) {
        return arg0.getValue();
    }

    private static final AnimationSpec animateValueAsState$lambda$5(State arg0) {
        return arg0.getValue();
    }

    private static final Unit animateValueAsState$lambda$7$0(Channel arg0, Object arg1) {
        arg0.trySend-JP2dKIU(arg1);
        return Unit.INSTANCE;
    }
}

