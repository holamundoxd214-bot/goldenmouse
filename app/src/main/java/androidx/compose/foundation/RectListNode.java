package androidx.compose.foundation;

import android.graphics.Rect;
import android.view.View;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNode_androidKt;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b!\u0018\u00002\u00020\u00012\u00020\u0002B\u001D\u0012\u0014\u0010\u0003\u001A\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u0005H\u0016J\b\u0010\u0015\u001A\u00020\u0013H\u0016J\u000E\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\r0\u0017H&J\u0016\u0010\u0018\u001A\u00020\u00132\f\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\r0\u0017H&J\u0012\u0010\u001A\u001A\u00020\u00132\b\u0010\u001B\u001A\u0004\u0018\u00010\rH\u0002J\u0018\u0010\u001C\u001A\u00020\r2\u0006\u0010\u001D\u001A\u00020\u00052\u0006\u0010\u0003\u001A\u00020\u0006H\u0002R(\u0010\u0003\u001A\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\bR\u0010\u0010\f\u001A\u0004\u0018\u00010\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u000E\u001A\u00020\u000F8DX\u0084\u0004¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0011¨\u0006\u001E"}, d2={"Landroidx/compose/foundation/RectListNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "rect", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/geometry/Rect;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getRect", "()Lkotlin/jvm/functions/Function1;", "setRect", "androidRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "onGloballyPositioned", "", "coordinates", "onDetach", "currentRects", "Landroidx/compose/runtime/collection/MutableVector;", "updateRects", "rects", "replaceRect", "newRect", "calcBounds", "layoutCoordinates", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class RectListNode extends Node implements GlobalPositionAwareModifierNode {
    public static final int $stable = 8;
    private Rect androidRect;
    private Function1 rect;

    static {
    }

    public RectListNode(Function1 arg1) {
        super();
        this.rect = arg1;
    }

    private final Rect calcBounds(LayoutCoordinates arg20, androidx.compose.ui.geometry.Rect arg21) {
        LayoutCoordinates v1 = LayoutCoordinatesKt.findRootCoordinates(arg20);
        long v2 = v1.localPositionOf-R5De75A(arg20, arg21.getTopLeft-F1C5BW0());
        long v4 = v1.localPositionOf-R5De75A(arg20, arg21.getTopRight-F1C5BW0());
        long v6 = v1.localPositionOf-R5De75A(arg20, arg21.getBottomLeft-F1C5BW0());
        int v9 = ((int)(v2 >> 0x20));
        int v11 = ((int)(v4 >> 0x20));
        int v13 = ((int)(v6 >> 0x20));
        long v19 = v1.localPositionOf-R5De75A(arg20, arg21.getBottomRight-F1C5BW0());
        int v0 = ((int)(v19 >> 0x20));
        int v2_1 = ((int)(v2 & 0xFFFFFFFFL));
        int v4_1 = ((int)(v4 & 0xFFFFFFFFL));
        int v6_1 = ((int)(v6 & 0xFFFFFFFFL));
        int v12 = ((int)(v19 & 0xFFFFFFFFL));
        return new Rect(MathKt.roundToInt(ComparisonsKt.minOf(Float.intBitsToFloat(v9), new float[]{Float.intBitsToFloat(v11), Float.intBitsToFloat(v13), Float.intBitsToFloat(v0)})), MathKt.roundToInt(ComparisonsKt.minOf(Float.intBitsToFloat(v2_1), new float[]{Float.intBitsToFloat(v4_1), Float.intBitsToFloat(v6_1), Float.intBitsToFloat(v12)})), MathKt.roundToInt(ComparisonsKt.maxOf(Float.intBitsToFloat(v9), new float[]{Float.intBitsToFloat(v11), Float.intBitsToFloat(v13), Float.intBitsToFloat(v0)})), MathKt.roundToInt(ComparisonsKt.maxOf(Float.intBitsToFloat(v2_1), new float[]{Float.intBitsToFloat(v4_1), Float.intBitsToFloat(v6_1), Float.intBitsToFloat(v12)})));
    }

    public abstract MutableVector currentRects();

    public Function1 getRect() {
        return this.rect;
    }

    protected final View getView() {
        return DelegatableNode_androidKt.requireView(((DelegatableNode)this));
    }

    public void onDetach() {
        super.onDetach();
        this.replaceRect(null);
    }

    public void onGloballyPositioned(LayoutCoordinates arg5) {
        Rect v0;
        if(this.getRect() == null) {
            androidx.compose.ui.geometry.Rect v5 = LayoutCoordinatesKt.boundsInRoot(arg5);
            v0 = new Rect(MathKt.roundToInt(v5.getLeft()), MathKt.roundToInt(v5.getTop()), MathKt.roundToInt(v5.getRight()), MathKt.roundToInt(v5.getBottom()));
        }
        else {
            Function1 v0_1 = this.getRect();
            Intrinsics.checkNotNull(v0_1);
            v0 = this.calcBounds(arg5, v0_1.invoke(arg5));
        }

        this.replaceRect(v0);
    }

    private final void replaceRect(Rect arg3) {
        MutableVector v0 = this.currentRects();
        Rect v1 = this.androidRect;
        if(v1 != null) {
            v0.remove(v1);
        }

        if(arg3 != null && !arg3.isEmpty()) {
            v0.add(arg3);
        }

        this.updateRects(v0);
        this.androidRect = arg3;
    }

    public void setRect(Function1 arg1) {
        this.rect = arg1;
    }

    public abstract void updateRects(MutableVector arg1);
}

