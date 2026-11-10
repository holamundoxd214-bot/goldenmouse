package androidx.compose.ui.node;

import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import kotlin.Metadata;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\'\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH&¢\u0006\u0004\b\n\u0010\u000BJ\b\u0010\f\u001A\u00020\u0003H&J\b\u0010\r\u001A\u00020\u000EH\u0016J\b\u0010\u000F\u001A\u00020\u000EH\u0016J\b\u0010\u0010\u001A\u00020\u0003H\u0016J\b\u0010\u0011\u001A\u00020\u0003H\u0016R\u0014\u0010\u0012\u001A\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0016À\u0006\u0001"}, d2={"Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/node/DelegatableNode;", "onPointerEvent", "", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onCancelPointerInput", "interceptOutOfBoundsChildEvents", "", "sharePointerInputWithSiblings", "onDensityChange", "onViewConfigurationChange", "touchBoundsExpansion", "Landroidx/compose/ui/node/TouchBoundsExpansion;", "getTouchBoundsExpansion-RZrCHBk", "()J", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface PointerInputModifierNode extends DelegatableNode {
    default long getTouchBoundsExpansion-RZrCHBk() {
        return TouchBoundsExpansion.Companion.getNone-RZrCHBk();
    }

    default boolean interceptOutOfBoundsChildEvents() {
        return 0;
    }

    void onCancelPointerInput();

    default void onDensityChange() {
        this.onCancelPointerInput();
    }

    void onPointerEvent-H0pRuoY(PointerEvent arg1, PointerEventPass arg2, long arg3);

    default void onViewConfigurationChange() {
        this.onCancelPointerInput();
    }

    default boolean sharePointerInputWithSiblings() {
        return 0;
    }
}

