package androidx.compose.ui.node;

import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u000B\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H&J\u0017\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH&¢\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010\f\u001A\u00020\u00032\u0006\u0010\b\u001A\u00020\rH&¢\u0006\u0004\b\u000E\u0010\u000FJ\u0017\u0010\u0010\u001A\u00020\u00032\u0006\u0010\u0011\u001A\u00020\u0012H&¢\u0006\u0004\b\u0013\u0010\u000FJ\u001A\u0010\u0014\u001A\u00020\u00032\u0006\u0010\u0015\u001A\u00020\u00162\b\u0010\u0017\u001A\u0004\u0018\u00010\u0018H&J\b\u0010\u0019\u001A\u00020\u0003H&J\b\u0010\u001A\u001A\u00020\u0003H&J\b\u0010\u001B\u001A\u00020\u0003H&J\u001F\u0010\u001C\u001A\u00020\t2\u0006\u0010\u001D\u001A\u00020\t2\u0006\u0010\u001E\u001A\u00020\u0007H&¢\u0006\u0004\b\u001F\u0010 J\u0018\u0010!\u001A\u00020\u00032\u0006\u0010\"\u001A\u00020#2\u0006\u0010\u001E\u001A\u00020\u0007H&JP\u0010$\u001A\u00020\u000328\u0010%\u001A4\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\'\u0012\b\b(\u0012\u0004\b\b(\u0015\u0012\u0015\u0012\u0013\u0018\u00010\u0018¢\u0006\f\b\'\u0012\b\b(\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00030&2\f\u0010)\u001A\b\u0012\u0004\u0012\u00020\u00030*H&J\u0017\u0010+\u001A\u00020\u00032\u0006\u0010,\u001A\u00020-H&¢\u0006\u0004\b.\u0010/J\u0017\u0010=\u001A\u00020\u00032\u0006\u0010,\u001A\u00020-H&¢\u0006\u0004\b>\u0010/R\u0012\u00100\u001A\u00020-X¦\u0004¢\u0006\u0006\u001A\u0004\b1\u00102R\u0018\u00103\u001A\u000204X¦\u000E¢\u0006\f\u001A\u0004\b5\u00106\"\u0004\b7\u00108R\u0018\u00109\u001A\u00020\u0007X¦\u000E¢\u0006\f\u001A\u0004\b9\u0010:\"\u0004\b;\u0010<ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006?À\u0006\u0001"}, d2={"Landroidx/compose/ui/node/OwnedLayer;", "", "updateLayerProperties", "", "scope", "Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;", "isInLayer", "", "position", "Landroidx/compose/ui/geometry/Offset;", "isInLayer-k-4lQ0M", "(J)Z", "move", "Landroidx/compose/ui/unit/IntOffset;", "move--gyyYBs", "(J)V", "resize", "size", "Landroidx/compose/ui/unit/IntSize;", "resize-ozmzZPI", "drawLayer", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "parentLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "updateDisplayList", "invalidate", "destroy", "mapOffset", "point", "inverse", "mapOffset-8S9VItk", "(JZ)J", "mapBounds", "rect", "Landroidx/compose/ui/geometry/MutableRect;", "reuseLayer", "drawBlock", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "invalidateParentLayer", "Lkotlin/Function0;", "transform", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "transform-58bKbWc", "([F)V", "underlyingMatrix", "getUnderlyingMatrix-sQKQjiQ", "()[F", "frameRate", "", "getFrameRate", "()F", "setFrameRate", "(F)V", "isFrameRateFromParent", "()Z", "setFrameRateFromParent", "(Z)V", "inverseTransform", "inverseTransform-58bKbWc", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface OwnedLayer {
    void destroy();

    void drawLayer(Canvas arg1, GraphicsLayer arg2);

    float getFrameRate();

    float[] getUnderlyingMatrix-sQKQjiQ();

    void invalidate();

    void inverseTransform-58bKbWc(float[] arg1);

    boolean isFrameRateFromParent();

    boolean isInLayer-k-4lQ0M(long arg1);

    void mapBounds(MutableRect arg1, boolean arg2);

    long mapOffset-8S9VItk(long arg1, boolean arg2);

    void move--gyyYBs(long arg1);

    void resize-ozmzZPI(long arg1);

    void reuseLayer(Function2 arg1, Function0 arg2);

    void setFrameRate(float arg1);

    void setFrameRateFromParent(boolean arg1);

    void transform-58bKbWc(float[] arg1);

    void updateDisplayList();

    void updateLayerProperties(ReusableGraphicsLayerScope arg1);
}

