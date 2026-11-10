package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$LongRef;

@Metadata(d1={"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u001AB\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u000BH\u0007\u001A\u001C\u0010\u000E\u001A\u00020\u000F*\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u000FH\u0082@¢\u0006\u0004\b\u0012\u0010\u0013\"\u000E\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0018\u0010\u0014\u001A\u00020\u0015*\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0018\"\u0018\u0010\u0019\u001A\u00020\u0015*\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u001A\u0010\u0018¨\u0006\u001B"}, d2={"scrollable2D", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/gestures/Scrollable2DState;", "enabled", "", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "NoOpScrollScope", "Landroidx/compose/foundation/gestures/Scroll2DScope;", "semanticsScrollBy", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/foundation/gestures/ScrollingLogic2D;", "offset", "semanticsScrollBy-d-4ec7I", "(Landroidx/compose/foundation/gestures/ScrollingLogic2D;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "magnitude", "", "Landroidx/compose/ui/unit/Velocity;", "getMagnitude-TH1AsA0", "(J)F", "angle", "getAngle-TH1AsA0", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class Scrollable2DKt {
    private static final Scroll2DScope NoOpScrollScope;

    static {
        Scrollable2DKt.NoOpScrollScope = new Scrollable2DKt$NoOpScrollScope$1();
    }

    public static final float access$getAngle-TH1AsA0(long arg0) {
        return Scrollable2DKt.getAngle-TH1AsA0(arg0);
    }

    public static final float access$getMagnitude-TH1AsA0(long arg0) {
        return Scrollable2DKt.getMagnitude-TH1AsA0(arg0);
    }

    public static final Scroll2DScope access$getNoOpScrollScope$p() {
        return Scrollable2DKt.NoOpScrollScope;
    }

    public static final Object access$semanticsScrollBy-d-4ec7I(ScrollingLogic2D arg0, long arg1, Continuation arg3) {
        return Scrollable2DKt.semanticsScrollBy-d-4ec7I(arg0, arg1, arg3);
    }

    private static final float getAngle-TH1AsA0(long arg2) {
        return ((float)Math.atan2(((double)Velocity.getY-impl(arg2)), ((double)Velocity.getX-impl(arg2))));
    }

    private static final float getMagnitude-TH1AsA0(long arg4) {
        return ((float)Math.sqrt(((double)((((float)Math.pow(((double)Velocity.getX-impl(arg4)), 2))) + (((float)Math.pow(((double)Velocity.getY-impl(arg4)), 2)))))));
    }

    public static final Modifier scrollable2D(Modifier arg6, Scrollable2DState arg7, boolean arg8, OverscrollEffect arg9, FlingBehavior arg10, MutableInteractionSource arg11) {
        return arg6.then(new Scrollable2DElement(arg7, arg9, arg8, arg10, arg11));
    }

    public static Modifier scrollable2D$default(Modifier arg6, Scrollable2DState arg7, boolean arg8, OverscrollEffect arg9, FlingBehavior arg10, MutableInteractionSource arg11, int arg12, Object arg13) {
        OverscrollEffect v13 = null;
        OverscrollEffect v3 = (arg12 & 4) != 0 ? v13 : arg9;
        FlingBehavior v4 = (arg12 & 8) != 0 ? ((FlingBehavior)v13) : arg10;
        MutableInteractionSource v5 = (arg12 & 16) != 0 ? ((MutableInteractionSource)v13) : arg11;
        return Scrollable2DKt.scrollable2D(arg6, arg7, true, v3, v4, v5);
    }

    private static final Object semanticsScrollBy-d-4ec7I(ScrollingLogic2D arg6, long arg7, Continuation arg9) {
        Object v6;
        int v2;
        Continuation v0;
        if((arg9 instanceof Scrollable2DKt$semanticsScrollBy$1)) {
            v0 = arg9;
            v2 = 0x80000000;
            if((((Scrollable2DKt$semanticsScrollBy$1)v0).label & v2) != 0) {
                ((Scrollable2DKt$semanticsScrollBy$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            Scrollable2DKt$semanticsScrollBy$1 v0_1 = new Scrollable2DKt$semanticsScrollBy$1(arg9);
        }

        Object v9 = ((Scrollable2DKt$semanticsScrollBy$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((Scrollable2DKt$semanticsScrollBy$1)v0).label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v9);
            LongRef v9_1 = new LongRef();
            v9_1.element = Offset.Companion.getZero-F1C5BW0();
            MutatePriority v2_1 = MutatePriority.Default;
            Scrollable2DKt$semanticsScrollBy$2 v4 = new Scrollable2DKt$semanticsScrollBy$2(arg7, v9_1, null);
            ((Scrollable2DKt$semanticsScrollBy$1)v0).L$0 = v9_1;
            ((Scrollable2DKt$semanticsScrollBy$1)v0).label = 1;
            if(arg6.scroll(v2_1, ((Function2)v4), v0) == v1) {
                return v1;
            }
            else {
                LongRef v6_1 = v9_1;
            }
        }
        else if(v2 == 1) {
            v6 = ((Scrollable2DKt$semanticsScrollBy$1)v0).L$0;
            ResultKt.throwOnFailure(v9);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        return Offset.box-impl(((LongRef)v6).element);
    }
}

