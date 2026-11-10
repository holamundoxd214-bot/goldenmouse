package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.MotionDurationScale;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$FloatRef;

@Metadata(d1={"\u0000p\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0000\u001AH\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u00072\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\fH\u0007\u001A^\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\b\u0010\r\u001A\u0004\u0018\u00010\u000E2\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u00072\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u0010H\u0007\u001A\u001C\u0010%\u001A\u00020&*\u00020\'2\u0006\u0010(\u001A\u00020&H\u0082@¢\u0006\u0004\b)\u0010*\" \u0010\u0011\u001A\u000E\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00070\u0012X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015\"\u000E\u0010\u0016\u001A\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0018\u0010\u0018\u001A\u00020\u0007*\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u001A\"\u000E\u0010\u001B\u001A\u00020\u001CX\u0082T¢\u0006\u0002\n\u0000\"\u0014\u0010\u001D\u001A\u00020\u001EX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u001F\u0010 \"\u0014\u0010!\u001A\u00020\"X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b#\u0010$\"\u000E\u0010+\u001A\u00020,X\u0082T¢\u0006\u0002\n\u0000¨\u0006-"}, d2={"scrollable", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/gestures/ScrollableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "", "reverseDirection", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "bringIntoViewSpec", "Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "CanDragCalculation", "Lkotlin/Function1;", "Landroidx/compose/ui/input/pointer/PointerType;", "getCanDragCalculation", "()Lkotlin/jvm/functions/Function1;", "NoOpScrollScope", "Landroidx/compose/foundation/gestures/ScrollScope;", "shouldBeTriggeredByMouseWheel", "getShouldBeTriggeredByMouseWheel", "(Landroidx/compose/foundation/gestures/FlingBehavior;)Z", "DefaultScrollMotionDurationScaleFactor", "", "DefaultScrollMotionDurationScale", "Landroidx/compose/ui/MotionDurationScale;", "getDefaultScrollMotionDurationScale", "()Landroidx/compose/ui/MotionDurationScale;", "UnityDensity", "Landroidx/compose/ui/unit/Density;", "getUnityDensity", "()Landroidx/compose/ui/unit/Density;", "semanticsScrollBy", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/foundation/gestures/ScrollingLogic;", "offset", "semanticsScrollBy-d-4ec7I", "(Landroidx/compose/foundation/gestures/ScrollingLogic;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "VerticalAxisThresholdAngle", "", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ScrollableKt {
    private static final Function1 CanDragCalculation = null;
    private static final MotionDurationScale DefaultScrollMotionDurationScale = null;
    private static final float DefaultScrollMotionDurationScaleFactor = 1f;
    private static final ScrollScope NoOpScrollScope = null;
    private static final Density UnityDensity = null;
    private static final double VerticalAxisThresholdAngle = 0.785398;

    static {
        ScrollableKt.CanDragCalculation = new ScrollableKt$$ExternalSyntheticLambda0();
        ScrollableKt.NoOpScrollScope = new ScrollableKt$NoOpScrollScope$1();
        ScrollableKt.DefaultScrollMotionDurationScale = new ScrollableKt$DefaultScrollMotionDurationScale$1();
        ScrollableKt.UnityDensity = new ScrollableKt$UnityDensity$1();
    }

    static final boolean CanDragCalculation$lambda$0(PointerType arg1) {
        int v1;
        int v0 = PointerType.Companion.getMouse-T8wyACA();
        if(arg1 == null) {
            v1 = 0;
        }
        else {
            boolean v1_1 = PointerType.equals-impl0(arg1.unbox-impl(), v0);
        }

        return v1 ^ 1;
    }

    public static final ScrollScope access$getNoOpScrollScope$p() {
        return ScrollableKt.NoOpScrollScope;
    }

    public static final boolean access$getShouldBeTriggeredByMouseWheel(FlingBehavior arg0) {
        return ScrollableKt.getShouldBeTriggeredByMouseWheel(arg0);
    }

    public static final Object access$semanticsScrollBy-d-4ec7I(ScrollingLogic arg0, long arg1, Continuation arg3) {
        return ScrollableKt.semanticsScrollBy-d-4ec7I(arg0, arg1, arg3);
    }

    public static final Function1 getCanDragCalculation() {
        return ScrollableKt.CanDragCalculation;
    }

    public static final MotionDurationScale getDefaultScrollMotionDurationScale() {
        return ScrollableKt.DefaultScrollMotionDurationScale;
    }

    private static final boolean getShouldBeTriggeredByMouseWheel(FlingBehavior arg0) {
        return arg0 instanceof ScrollableDefaultFlingBehavior ^ 1;
    }

    public static final Density getUnityDensity() {
        return ScrollableKt.UnityDensity;
    }

    public static final Modifier scrollable(Modifier arg9, ScrollableState arg10, Orientation arg11, OverscrollEffect arg12, boolean arg13, boolean arg14, FlingBehavior arg15, MutableInteractionSource arg16, BringIntoViewSpec arg17) {
        return arg9.then(new ScrollableElement(arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17));
    }

    public static final Modifier scrollable(Modifier arg11, ScrollableState arg12, Orientation arg13, boolean arg14, boolean arg15, FlingBehavior arg16, MutableInteractionSource arg17) {
        return ScrollableKt.scrollable$default(arg11, arg12, arg13, null, arg14, arg15, arg16, arg17, null, 0x80, null);
    }

    public static Modifier scrollable$default(Modifier arg9, ScrollableState arg10, Orientation arg11, OverscrollEffect arg12, boolean arg13, boolean arg14, FlingBehavior arg15, MutableInteractionSource arg16, BringIntoViewSpec arg17, int arg18, Object arg19) {
        ScrollableState v1_1;
        OverscrollEffect v3;
        Orientation v2;
        Modifier v0_1;
        BringIntoViewSpec v8;
        int v0 = arg18;
        boolean v5 = (v0 & 16) != 0 ? false : arg14;
        FlingBehavior v1 = null;
        FlingBehavior v6 = (v0 & 0x20) != 0 ? v1 : arg15;
        MutableInteractionSource v7 = (v0 & 0x40) != 0 ? ((MutableInteractionSource)v1) : arg16;
        if((v0 & 0x80) != 0) {
            v8 = ((BringIntoViewSpec)v1);
            v0_1 = arg9;
            v2 = arg11;
            v3 = arg12;
            v1_1 = arg10;
        }
        else {
            v8 = arg17;
            v0_1 = arg9;
            v1_1 = arg10;
            v2 = arg11;
            v3 = arg12;
        }

        return ScrollableKt.scrollable(v0_1, v1_1, v2, v3, true, v5, v6, v7, v8);
    }

    public static Modifier scrollable$default(Modifier arg7, ScrollableState arg8, Orientation arg9, boolean arg10, boolean arg11, FlingBehavior arg12, MutableInteractionSource arg13, int arg14, Object arg15) {
        FlingBehavior v11 = null;
        FlingBehavior v5 = (arg14 & 16) != 0 ? v11 : arg12;
        MutableInteractionSource v6 = (arg14 & 0x20) != 0 ? ((MutableInteractionSource)v11) : arg13;
        return ScrollableKt.scrollable(arg7, arg8, arg9, true, false, v5, v6);
    }

    private static final Object semanticsScrollBy-d-4ec7I(ScrollingLogic arg10, long arg11, Continuation arg13) {
        FloatRef v8_1;
        int v2;
        Continuation v0;
        if((arg13 instanceof ScrollableKt$semanticsScrollBy$1)) {
            v0 = arg13;
            v2 = 0x80000000;
            if((((ScrollableKt$semanticsScrollBy$1)v0).label & v2) != 0) {
                ((ScrollableKt$semanticsScrollBy$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            ScrollableKt$semanticsScrollBy$1 v0_1 = new ScrollableKt$semanticsScrollBy$1(arg13);
        }

        Object v13 = ((ScrollableKt$semanticsScrollBy$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((ScrollableKt$semanticsScrollBy$1)v0).label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v13);
            v8_1 = new FloatRef();
            MutatePriority v13_1 = MutatePriority.Default;
            ScrollingLogic v5 = arg10;
            ScrollableKt$semanticsScrollBy$2 v4 = new ScrollableKt$semanticsScrollBy$2(v5, arg11, v8_1, null);
            ((ScrollableKt$semanticsScrollBy$1)v0).L$0 = v5;
            ((ScrollableKt$semanticsScrollBy$1)v0).L$1 = v8_1;
            ((ScrollableKt$semanticsScrollBy$1)v0).label = 1;
            if(v5.scroll(v13_1, ((Function2)v4), v0) == v1) {
                return v1;
            }
            else {
                arg10 = v5;
            }
        }
        else if(v2 == 1) {
            Object v10 = ((ScrollableKt$semanticsScrollBy$1)v0).L$1;
            Object v11 = ((ScrollableKt$semanticsScrollBy$1)v0).L$0;
            ResultKt.throwOnFailure(v13);
            Object v8 = v10;
            v10 = v11;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        return Offset.box-impl(arg10.toOffset-tuRUvjQ(v8_1.element));
    }
}

