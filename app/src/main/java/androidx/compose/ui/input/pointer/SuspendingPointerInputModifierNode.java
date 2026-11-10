package androidx.compose.ui.input.pointer;

import androidx.compose.ui.node.PointerInputModifierNode;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\b\u0010\u0016\u001A\u00020\u0006H&RC\u0010\u0002\u001A#\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003¢\u0006\u0002\b\b8&@&X§\u000E¢\u0006\u0012\u0012\u0004\b\t\u0010\n\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000ER$\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000F\u001A\u00020\u00108V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u0082\u0001\u0001\u0017ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0018À\u0006\u0001"}, d2={"Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "pointerInputHandler", "Lkotlin/Function2;", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "getPointerInputHandler$annotations", "()V", "getPointerInputHandler", "()Lkotlin/jvm/functions/Function2;", "setPointerInputHandler", "(Lkotlin/jvm/functions/Function2;)V", "value", "Landroidx/compose/ui/input/pointer/PointerInputEventHandler;", "pointerInputEventHandler", "getPointerInputEventHandler", "()Landroidx/compose/ui/input/pointer/PointerInputEventHandler;", "setPointerInputEventHandler", "(Landroidx/compose/ui/input/pointer/PointerInputEventHandler;)V", "resetPointerInputHandler", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNodeImpl;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface SuspendingPointerInputModifierNode extends PointerInputModifierNode {
    default PointerInputEventHandler getPointerInputEventHandler() {
        throw new NotImplementedError("An operation is not implemented: pointerInputEventHandler must be implemented (get()).");
    }

    Function2 getPointerInputHandler();

    @Deprecated(level=DeprecationLevel.ERROR, message="This property is deprecated. Use \'pointerInputEventHandler\' instead.", replaceWith="<_subannotation>") static void getPointerInputHandler$annotations() {
    }

    void resetPointerInputHandler();

    default void setPointerInputEventHandler(PointerInputEventHandler arg3) {
        throw new NotImplementedError("An operation is not implemented: " + ("pointerInputEventHandler must be implemented (set(" + arg3 + "))."));
    }

    void setPointerInputHandler(Function2 arg1);
}

