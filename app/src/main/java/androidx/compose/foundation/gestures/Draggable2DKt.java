package androidx.compose.foundation.gestures;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001A\u001A\u0010\u0000\u001A\u00020\u00012\u0012\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u001A!\u0010\u0006\u001A\u00020\u00012\u0012\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0007¢\u0006\u0002\u0010\u0007\u001A\u0088\u0001\u0010\b\u001A\u00020\t*\u00020\t2\u0006\u0010\n\u001A\u00020\u00012\b\b\u0002\u0010\u000B\u001A\u00020\f2\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\f2#\b\u0002\u0010\u0010\u001A\u001D\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00050\u00032#\b\u0002\u0010\u0014\u001A\u001D\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0002\u0010\u0017\u001A\u00020\fH\u0007\")\u0010\u0018\u001A\u001D\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\")\u0010\u0019\u001A\u001D\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001A"}, d2={"Draggable2DState", "Landroidx/compose/foundation/gestures/Draggable2DState;", "onDelta", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "", "rememberDraggable2DState", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/Draggable2DState;", "draggable2D", "Landroidx/compose/ui/Modifier;", "state", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "startDragImmediately", "onDragStarted", "Lkotlin/ParameterName;", "name", "startedPosition", "onDragStopped", "Landroidx/compose/ui/unit/Velocity;", "velocity", "reverseDirection", "NoOpOnDragStart", "NoOpOnDragStop", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class Draggable2DKt {
    private static final Function1 NoOpOnDragStart;
    private static final Function1 NoOpOnDragStop;

    public static Unit $r8$lambda$hjjtSfcwu_9VyCvcdzRZI0iRMLM(State arg0, Offset arg1) {
        return Draggable2DKt.rememberDraggable2DState$lambda$0$0(arg0, arg1);
    }

    static {
        Draggable2DKt.NoOpOnDragStart = new Draggable2DKt$$ExternalSyntheticLambda1();
        Draggable2DKt.NoOpOnDragStop = new Draggable2DKt$$ExternalSyntheticLambda2();
    }

    public static final Draggable2DState Draggable2DState(Function1 arg1) {
        return new DefaultDraggable2DState(arg1);
    }

    static final Unit NoOpOnDragStart$lambda$0(Offset arg0) {
        return Unit.INSTANCE;
    }

    static final Unit NoOpOnDragStop$lambda$0(Velocity arg0) {
        return Unit.INSTANCE;
    }

    public static final Modifier draggable2D(Modifier arg8, Draggable2DState arg9, boolean arg10, MutableInteractionSource arg11, boolean arg12, Function1 arg13, Function1 arg14, boolean arg15) {
        return arg8.then(new Draggable2DElement(arg9, arg10, arg11, arg12, arg13, arg14, arg15));
    }

    public static Modifier draggable2D$default(Modifier arg7, Draggable2DState arg8, boolean arg9, MutableInteractionSource arg10, boolean arg11, Function1 arg12, Function1 arg13, boolean arg14, int arg15, Object arg16) {
        boolean v0 = (arg15 & 2) != 0 ? true : arg9;
        MutableInteractionSource v1 = (arg15 & 4) != 0 ? null : arg10;
        boolean v2 = (arg15 & 8) != 0 ? false : arg11;
        Function1 v4 = (arg15 & 16) != 0 ? Draggable2DKt.NoOpOnDragStart : arg12;
        Function1 v5 = (arg15 & 0x20) != 0 ? Draggable2DKt.NoOpOnDragStop : arg13;
        boolean v16 = (arg15 & 0x40) != 0 ? false : arg14;
        return Draggable2DKt.draggable2D(arg7, arg8, v0, v1, v2, v4, v5, v16);
    }

    public static final Draggable2DState rememberDraggable2DState(Function1 arg3, Composer arg4, int arg5) {
        int v1 = 0xBB702811;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(rememberDraggable2DState)N(onDelta)107@4635L29,108@4676L63:Draggable2D.kt#8bwon0");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.foundation.gestures.rememberDraggable2DState (Draggable2D.kt:106)");
        }

        State v3 = SnapshotStateKt.rememberUpdatedState(arg3, arg4, arg5 & 14);
        ComposerKt.sourceInformationMarkerStart(arg4, 0xA0067990, "CC(remember):Draggable2D.kt#9igjgp");
        Object v5 = arg4.rememberedValue();
        if(v5 == Composer.Companion.getEmpty()) {
            Draggable2DState v5_1 = Draggable2DKt.Draggable2DState(new Draggable2DKt$$ExternalSyntheticLambda0(v3));
            arg4.updateRememberedValue(v5_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return ((Draggable2DState)v5);
    }

    private static final Unit rememberDraggable2DState$lambda$0$0(State arg0, Offset arg1) {
        arg0.getValue().invoke(arg1);
        return Unit.INSTANCE;
    }
}

