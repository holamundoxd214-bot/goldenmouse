package androidx.compose.foundation.draganddrop;

import androidx.compose.ui.draganddrop.DragAndDropNodeKt;
import androidx.compose.ui.draganddrop.DragAndDropTransferData;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002BI\u0012\u0017\u0010\u0003\u001A\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007\u0012\'\u0010\b\u001A#\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000B\u0012\u0006\u0012\u0004\u0018\u00010\f0\t¢\u0006\u0002\b\u0007¢\u0006\u0004\b\r\u0010\u000EJ\u0017\u0010\u001B\u001A\u00020\u00062\u0006\u0010\u0018\u001A\u00020\u0019H\u0016¢\u0006\u0004\b\u001C\u0010\u001DR+\u0010\u0003\u001A\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012R=\u0010\b\u001A#\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000B\u0012\u0006\u0012\u0004\u0018\u00010\f0\t¢\u0006\u0002\b\u0007X\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u0017\u001A\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0018\u001A\u00020\u0019X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u001A¨\u0006\u001E"}, d2={"Landroidx/compose/foundation/draganddrop/LegacyDragAndDropSourceNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/LayoutAwareModifierNode;", "drawDragDecoration", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "Lkotlin/ExtensionFunctionType;", "dragAndDropSourceHandler", "Lkotlin/Function2;", "Landroidx/compose/foundation/draganddrop/DragAndDropSourceScope;", "Lkotlin/coroutines/Continuation;", "", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "getDrawDragDecoration", "()Lkotlin/jvm/functions/Function1;", "setDrawDragDecoration", "(Lkotlin/jvm/functions/Function1;)V", "getDragAndDropSourceHandler", "()Lkotlin/jvm/functions/Function2;", "setDragAndDropSourceHandler", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "size", "Landroidx/compose/ui/unit/IntSize;", "J", "onRemeasured", "onRemeasured-ozmzZPI", "(J)V", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LegacyDragAndDropSourceNode extends DelegatingNode implements LayoutAwareModifierNode {
    public static final int $stable = 8;
    private Function2 dragAndDropSourceHandler;
    private Function1 drawDragDecoration;
    private long size;

    static {
    }

    public LegacyDragAndDropSourceNode(Function1 arg1, Function2 arg2) {
        super();
        this.drawDragDecoration = arg1;
        this.dragAndDropSourceHandler = arg2;
        this.size = IntSize.Companion.getZero-YbymL2g();
        this.delegate(SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new PointerInputEventHandler(this.delegate(DragAndDropNodeKt.DragAndDropModifierNode())) {
            public final Object invoke(PointerInputScope arg4, Continuation arg5) {
                Object v3 = LegacyDragAndDropSourceNode.this.getDragAndDropSourceHandler().invoke(new Object(this.$dragAndDropModifierNode, LegacyDragAndDropSourceNode.this) {
                    public Object awaitPointerEventScope(Function2 arg1, Continuation arg2) {
                        return this.$$delegate_0.awaitPointerEventScope(arg1, arg2);
                    }

                    public float getDensity() {
                        return this.$$delegate_0.getDensity();
                    }

                    public long getExtendedTouchPadding-NH-jbRc() {
                        return this.$$delegate_0.getExtendedTouchPadding-NH-jbRc();
                    }

                    public float getFontScale() {
                        return this.$$delegate_0.getFontScale();
                    }

                    public boolean getInterceptOutOfBoundsChildEvents() {
                        return this.$$delegate_0.getInterceptOutOfBoundsChildEvents();
                    }

                    public long getSize-YbymL2g() {
                        return this.$$delegate_0.getSize-YbymL2g();
                    }

                    public ViewConfiguration getViewConfiguration() {
                        return this.$$delegate_0.getViewConfiguration();
                    }

                    public int roundToPx--R2X_6o(long arg1) {
                        return this.$$delegate_0.roundToPx--R2X_6o(arg1);
                    }

                    public int roundToPx-0680j_4(float arg1) {
                        return this.$$delegate_0.roundToPx-0680j_4(arg1);
                    }

                    public void setInterceptOutOfBoundsChildEvents(boolean arg1) {
                        this.$$delegate_0.setInterceptOutOfBoundsChildEvents(arg1);
                    }

                    public void startTransfer(DragAndDropTransferData arg4) {
                        this.$dragAndDropModifierNode.drag-12SF9DM(arg4, IntSizeKt.toSize-ozmzZPI(this.getSize-YbymL2g()), LegacyDragAndDropSourceNode.this.getDrawDragDecoration());
                    }

                    public float toDp-GaN1DYA(long arg1) {
                        return this.$$delegate_0.toDp-GaN1DYA(arg1);
                    }

                    public float toDp-u2uoSUM(float arg1) {
                        return this.$$delegate_0.toDp-u2uoSUM(arg1);
                    }

                    public float toDp-u2uoSUM(int arg1) {
                        return this.$$delegate_0.toDp-u2uoSUM(arg1);
                    }

                    public long toDpSize-k-rfVVM(long arg1) {
                        return this.$$delegate_0.toDpSize-k-rfVVM(arg1);
                    }

                    public float toPx--R2X_6o(long arg1) {
                        return this.$$delegate_0.toPx--R2X_6o(arg1);
                    }

                    public float toPx-0680j_4(float arg1) {
                        return this.$$delegate_0.toPx-0680j_4(arg1);
                    }

                    public Rect toRect(DpRect arg1) {
                        return this.$$delegate_0.toRect(arg1);
                    }

                    public long toSize-XkaWNTQ(long arg1) {
                        return this.$$delegate_0.toSize-XkaWNTQ(arg1);
                    }

                    public long toSp-0xMU5do(float arg1) {
                        return this.$$delegate_0.toSp-0xMU5do(arg1);
                    }

                    public long toSp-kPz2Gy4(float arg1) {
                        return this.$$delegate_0.toSp-kPz2Gy4(arg1);
                    }

                    public long toSp-kPz2Gy4(int arg1) {
                        return this.$$delegate_0.toSp-kPz2Gy4(arg1);
                    }
                }, arg5);
                if(v3 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return v3;
                }

                return Unit.INSTANCE;
            }
        }));
    }

    public final Function2 getDragAndDropSourceHandler() {
        return this.dragAndDropSourceHandler;
    }

    public final Function1 getDrawDragDecoration() {
        return this.drawDragDecoration;
    }

    public void onRemeasured-ozmzZPI(long arg1) {
        this.size = arg1;
    }

    public final void setDragAndDropSourceHandler(Function2 arg1) {
        this.dragAndDropSourceHandler = arg1;
    }

    public final void setDrawDragDecoration(Function1 arg1) {
        this.drawDragDecoration = arg1;
    }
}

