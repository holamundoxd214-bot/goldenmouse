package androidx.compose.ui.input.pointer;

import androidx.compose.ui.Modifier;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000P\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\u001A:\u0010\u0004\u001A\u00020\u0005*\u00020\u00052\'\u0010\u0006\u001A#\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000B0\u0007¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\r\u001AD\u0010\u0004\u001A\u00020\u0005*\u00020\u00052\b\u0010\u000E\u001A\u0004\u0018\u00010\u000B2\'\u0010\u0006\u001A#\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000B0\u0007¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\u000F\u001A\u001C\u0010\u0004\u001A\u00020\u0005*\u00020\u00052\b\u0010\u000E\u001A\u0004\u0018\u00010\u000B2\u0006\u0010\u0006\u001A\u00020\u0010\u001AN\u0010\u0004\u001A\u00020\u0005*\u00020\u00052\b\u0010\u000E\u001A\u0004\u0018\u00010\u000B2\b\u0010\u0011\u001A\u0004\u0018\u00010\u000B2\'\u0010\u0006\u001A#\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000B0\u0007¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\u0012\u001A&\u0010\u0004\u001A\u00020\u0005*\u00020\u00052\b\u0010\u000E\u001A\u0004\u0018\u00010\u000B2\b\u0010\u0011\u001A\u0004\u0018\u00010\u000B2\u0006\u0010\u0006\u001A\u00020\u0010\u001AR\u0010\u0004\u001A\u00020\u0005*\u00020\u00052\u0016\u0010\u0013\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000B0\u0014\"\u0004\u0018\u00010\u000B2\'\u0010\u0006\u001A#\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000B0\u0007¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\u0015\u001A/\u0010\u0004\u001A\u00020\u0005*\u00020\u00052\u0016\u0010\u0013\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000B0\u0014\"\u0004\u0018\u00010\u000B2\u0006\u0010\u0006\u001A\u00020\u0010¢\u0006\u0002\u0010\u0016\u001A6\u0010\u0019\u001A\u00020\u001A2\'\u0010\u001B\u001A#\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000B0\u0007¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\u001C\u001A\u000E\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001D\u001A\u00020\u0010\"\u0014\u0010\u0000\u001A\u00020\u0001X\u0082T¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u000E\u0010\u0017\u001A\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010\u001E\u001A\u00020\u001FX\u0080T¢\u0006\u0002\n\u0000¨\u0006 "}, d2={"PointerInputModifierNoParamError", "", "getPointerInputModifierNoParamError$annotations", "()V", "pointerInput", "Landroidx/compose/ui/Modifier;", "block", "Lkotlin/Function2;", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;)Landroidx/compose/ui/Modifier;", "key1", "(Landroidx/compose/ui/Modifier;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/input/pointer/PointerInputEventHandler;", "key2", "(Landroidx/compose/ui/Modifier;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Landroidx/compose/ui/Modifier;", "keys", "", "(Landroidx/compose/ui/Modifier;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;[Ljava/lang/Object;Landroidx/compose/ui/input/pointer/PointerInputEventHandler;)Landroidx/compose/ui/Modifier;", "EmptyPointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "SuspendingPointerInputModifierNode", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "pointerInputHandler", "(Lkotlin/jvm/functions/Function2;)Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "pointerInputEventHandler", "WITH_TIMEOUT_MICRO_DELAY_MILLIS", "", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SuspendingPointerInputFilterKt {
    private static final PointerEvent EmptyPointerEvent = null;
    private static final String PointerInputModifierNoParamError = "Modifier.pointerInput must provide one or more \'key\' parameters that define the identity of the modifier and determine when its previous input processing coroutine should be cancelled and a new effect launched for the new key.";
    public static final long WITH_TIMEOUT_MICRO_DELAY_MILLIS = 8;

    static {
        SuspendingPointerInputFilterKt.EmptyPointerEvent = new PointerEvent(CollectionsKt.emptyList());
    }

    public static final SuspendingPointerInputModifierNode SuspendingPointerInputModifierNode(PointerInputEventHandler arg2) {
        return new SuspendingPointerInputModifierNodeImpl(null, null, null, arg2);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="This function is deprecated. Use \'SuspendingPointerInputModifierNode\' with thePointerInputEventHandler instead.", replaceWith="<_subannotation>") public static final SuspendingPointerInputModifierNode SuspendingPointerInputModifierNode(Function2 arg2) {
        return new SuspendingPointerInputModifierNodeImpl(null, null, null, arg2);
    }

    public static final PointerEvent access$getEmptyPointerEvent$p() {
        return SuspendingPointerInputFilterKt.EmptyPointerEvent;
    }

    private static void getPointerInputModifierNoParamError$annotations() {
    }

    public static final Modifier pointerInput(Modifier arg7, Object arg8, PointerInputEventHandler arg9) {
        return arg7.then(new SuspendPointerInputElement(arg8, null, null, arg9, 6, null));
    }

    public static final Modifier pointerInput(Modifier arg7, Object arg8, Object arg9, PointerInputEventHandler arg10) {
        return arg7.then(new SuspendPointerInputElement(arg8, arg9, null, arg10, 4, null));
    }

    public static final Modifier pointerInput(Modifier arg7, Object[] arg8, PointerInputEventHandler arg9) {
        return arg7.then(new SuspendPointerInputElement(null, null, arg8, arg9, 3, null));
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="This function is deprecated. Use the PointerInputEventHandler block variation instead", replaceWith="<_subannotation>") public static final Modifier pointerInput(Modifier arg7, Object arg8, Object arg9, Function2 arg10) {
        return arg7.then(new SuspendPointerInputElement(arg8, arg9, null, new SuspendingPointerInputFilterKt$sam$androidx_compose_ui_input_pointer_PointerInputEventHandler$0(arg10), 4, null));
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="This function is deprecated. Use the PointerInputEventHandler block variation instead", replaceWith="<_subannotation>") public static final Modifier pointerInput(Modifier arg7, Object arg8, Function2 arg9) {
        return arg7.then(new SuspendPointerInputElement(arg8, null, null, new SuspendingPointerInputFilterKt$sam$androidx_compose_ui_input_pointer_PointerInputEventHandler$0(arg9), 6, null));
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Modifier.pointerInput must provide one or more \'key\' parameters that define the identity of the modifier and determine when its previous input processing coroutine should be cancelled and a new effect launched for the new key.") public static final Modifier pointerInput(Modifier arg0, Function2 arg1) {
        throw new IllegalStateException("Modifier.pointerInput must provide one or more \'key\' parameters that define the identity of the modifier and determine when its previous input processing coroutine should be cancelled and a new effect launched for the new key.".toString());
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="This function is deprecated. Use the PointerInputEventHandler block variation instead", replaceWith="<_subannotation>") public static final Modifier pointerInput(Modifier arg7, Object[] arg8, Function2 arg9) {
        return arg7.then(new SuspendPointerInputElement(null, null, arg8, new SuspendingPointerInputFilterKt$sam$androidx_compose_ui_input_pointer_PointerInputEventHandler$0(arg9), 3, null));
    }
}

