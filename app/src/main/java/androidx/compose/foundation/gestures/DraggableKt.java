package androidx.compose.foundation.gestures;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

@Metadata(d1={"\u0000`\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u001A\u001A\u0010\u0000\u001A\u00020\u00012\u0012\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u001A!\u0010\u0006\u001A\u00020\u00012\u0012\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0007¢\u0006\u0002\u0010\u0007\u001AË\u0001\u0010\b\u001A\u00020\t*\u00020\t2\u0006\u0010\n\u001A\u00020\u00012\u0006\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\u000E2\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001A\u00020\u000E2>\b\u0002\u0010\u0012\u001A8\b\u0001\u0012\u0004\u0012\u00020\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001A0\u0013¢\u0006\u0002\b\u001B2>\b\u0002\u0010\u001C\u001A8\b\u0001\u0012\u0004\u0012\u00020\u0014\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001D\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001A0\u0013¢\u0006\u0002\b\u001B2\b\b\u0002\u0010\u001E\u001A\u00020\u000EH\u0007¢\u0006\u0002\u0010\u001F\u001A\u001B\u0010 \u001A\u00020\u0004*\u00020\u00152\u0006\u0010\u000B\u001A\u00020\fH\u0000¢\u0006\u0004\b!\u0010\"\u001A\u001B\u0010 \u001A\u00020\u0004*\u00020#2\u0006\u0010\u000B\u001A\u00020\fH\u0002¢\u0006\u0004\b$\u0010\"\u001A\u0013\u0010%\u001A\u00020#*\u00020#H\u0000¢\u0006\u0004\b&\u0010\'\"F\u0010(\u001A8\b\u0001\u0012\u0004\u0012\u00020\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001A0\u0013¢\u0006\u0002\b\u001BX\u0082\u0004¢\u0006\u0004\n\u0002\u0010)\"F\u0010*\u001A8\b\u0001\u0012\u0004\u0012\u00020\u0014\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001D\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001A0\u0013¢\u0006\u0002\b\u001BX\u0082\u0004¢\u0006\u0004\n\u0002\u0010)¨\u0006+"}, d2={"DraggableState", "Landroidx/compose/foundation/gestures/DraggableState;", "onDelta", "Lkotlin/Function1;", "", "", "rememberDraggableState", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/DraggableState;", "draggable", "Landroidx/compose/ui/Modifier;", "state", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "startDragImmediately", "onDragStarted", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ParameterName;", "name", "startedPosition", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "onDragStopped", "velocity", "reverseDirection", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/gestures/DraggableState;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;ZLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Z)Landroidx/compose/ui/Modifier;", "toFloat", "toFloat-3MmeM6k", "(JLandroidx/compose/foundation/gestures/Orientation;)F", "Landroidx/compose/ui/unit/Velocity;", "toFloat-sF-c-tU", "toValidVelocity", "toValidVelocity-TH1AsA0", "(J)J", "NoOpOnDragStarted", "Lkotlin/jvm/functions/Function3;", "NoOpOnDragStopped", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class DraggableKt {
    private static final Function3 NoOpOnDragStarted;
    private static final Function3 NoOpOnDragStopped;

    public static Unit $r8$lambda$r45YVRyb2U7OeKoVC_XqEZgEtWY(State arg0, float arg1) {
        return DraggableKt.rememberDraggableState$lambda$0$0(arg0, arg1);
    }

    static {
        DraggableKt.NoOpOnDragStarted = new DraggableKt$NoOpOnDragStarted$1(null);
        DraggableKt.NoOpOnDragStopped = new DraggableKt$NoOpOnDragStopped$1(null);
    }

    public static final DraggableState DraggableState(Function1 arg1) {
        return new DefaultDraggableState(arg1);
    }

    public static final Function3 access$getNoOpOnDragStarted$p() {
        return DraggableKt.NoOpOnDragStarted;
    }

    public static final Function3 access$getNoOpOnDragStopped$p() {
        return DraggableKt.NoOpOnDragStopped;
    }

    public static final float access$toFloat-sF-c-tU(long arg0, Orientation arg2) {
        return DraggableKt.toFloat-sF-c-tU(arg0, arg2);
    }

    public static final Modifier draggable(Modifier arg9, DraggableState arg10, Orientation arg11, boolean arg12, MutableInteractionSource arg13, boolean arg14, Function3 arg15, Function3 arg16, boolean arg17) {
        return arg9.then(new DraggableElement(arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17));
    }

    public static Modifier draggable$default(Modifier arg9, DraggableState arg10, Orientation arg11, boolean arg12, MutableInteractionSource arg13, boolean arg14, Function3 arg15, Function3 arg16, boolean arg17, int arg18, Object arg19) {
        int v0 = arg18;
        if((v0 & 8) != 0) {
            arg13 = null;
        }

        MutableInteractionSource v4 = arg13;
        boolean v5 = (v0 & 16) != 0 ? false : arg14;
        Function3 v6 = (v0 & 0x20) != 0 ? DraggableKt.NoOpOnDragStarted : arg15;
        Function3 v7 = (v0 & 0x40) != 0 ? DraggableKt.NoOpOnDragStopped : arg16;
        boolean v8 = (v0 & 0x80) != 0 ? false : arg17;
        return DraggableKt.draggable(arg9, arg10, arg11, true, v4, v5, v6, v7, v8);
    }

    public static final DraggableState rememberDraggableState(Function1 arg3, Composer arg4, int arg5) {
        DraggableState v5_1;
        int v1 = 0xF513E663;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(rememberDraggableState)N(onDelta)145@6769L29,146@6810L61:Draggable.kt#8bwon0");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.foundation.gestures.rememberDraggableState (Draggable.kt:144)");
        }

        State v3 = SnapshotStateKt.rememberUpdatedState(arg3, arg4, arg5 & 14);
        ComposerKt.sourceInformationMarkerStart(arg4, 0xFFB3EAC0, "CC(remember):Draggable.kt#9igjgp");
        Object v5 = arg4.rememberedValue();
        if(v5 == Composer.Companion.getEmpty()) {
            v5_1 = DraggableKt.DraggableState(new DraggableKt$$ExternalSyntheticLambda0(v3));
            arg4.updateRememberedValue(v5_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v5_1;
    }

    private static final Unit rememberDraggableState$lambda$0$0(State arg0, float arg1) {
        arg0.getValue().invoke(Float.valueOf(arg1));
        return Unit.INSTANCE;
    }

    public static final float toFloat-3MmeM6k(long arg2, Orientation arg4) {
        if(arg4 == Orientation.Vertical) {
            arg2 &= 0xFFFFFFFFL;
        }
        else {
            arg2 >>= 0x20;
        }

        return Float.intBitsToFloat(((int)arg2));
    }

    private static final float toFloat-sF-c-tU(long arg1, Orientation arg3) {
        if(arg3 == Orientation.Vertical) {
            return Velocity.getY-impl(arg1);
        }

        return Velocity.getX-impl(arg1);
    }

    public static final long toValidVelocity-TH1AsA0(long arg3) {
        float v1 = 0f;
        float v0 = Float.isNaN(Velocity.getX-impl(arg3)) ? 0f : Velocity.getX-impl(arg3);
        if(Float.isNaN(Velocity.getY-impl(arg3))) {
        }
        else {
            v1 = Velocity.getY-impl(arg3);
        }

        return VelocityKt.Velocity(v0, v1);
    }
}

