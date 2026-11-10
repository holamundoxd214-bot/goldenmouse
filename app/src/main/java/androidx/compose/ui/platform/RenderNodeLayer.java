package androidx.compose.ui.platform;

import android.os.Build$VERSION;
import android.view.View;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.layout.GraphicLayerInfo;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u0000 c2\u00020\u00012\u00020\u0002:\u0002bcBW\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u00128\u0010\u0005\u001A4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u000B¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0006\u0012\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\r0\u000F¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u00100\u001A\u00020\r2\u0006\u00101\u001A\u000202H\u0016J\u0017\u00103\u001A\u00020\u00152\u0006\u00104\u001A\u000205H\u0016¢\u0006\u0004\b6\u00107J\u0017\u00108\u001A\u00020\r2\u0006\u00109\u001A\u00020:H\u0016¢\u0006\u0004\b;\u0010<J\u0017\u0010=\u001A\u00020\r2\u0006\u00104\u001A\u00020>H\u0016¢\u0006\u0004\b?\u0010<J\b\u0010@\u001A\u00020\rH\u0016J\b\u0010A\u001A\u00020\rH\u0002J\u001A\u0010B\u001A\u00020\r2\u0006\u0010\n\u001A\u00020\u00072\b\u0010\f\u001A\u0004\u0018\u00010\u000BH\u0016J\u0010\u0010C\u001A\u00020\r2\u0006\u0010\n\u001A\u00020\u0007H\u0002J\b\u0010D\u001A\u00020\rH\u0016J\b\u0010E\u001A\u00020\rH\u0016J\u001F\u0010S\u001A\u0002052\u0006\u0010T\u001A\u0002052\u0006\u0010U\u001A\u00020\u0015H\u0016¢\u0006\u0004\bV\u0010WJ\u0018\u0010X\u001A\u00020\r2\u0006\u0010Y\u001A\u00020Z2\u0006\u0010U\u001A\u00020\u0015H\u0016JP\u0010[\u001A\u00020\r28\u0010\u0005\u001A4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u000B¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u00062\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\r0\u000FH\u0016J\u0017\u0010\\\u001A\u00020\r2\u0006\u0010]\u001A\u00020GH\u0016¢\u0006\u0004\b^\u0010_J\u0017\u0010`\u001A\u00020\r2\u0006\u0010]\u001A\u00020GH\u0016¢\u0006\u0004\ba\u0010_R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013RB\u0010\u0005\u001A6\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u000B¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010\u000E\u001A\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000FX\u0082\u000E¢\u0006\u0002\n\u0000R\u001E\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0014\u001A\u00020\u0015@BX\u0082\u000E¢\u0006\b\n\u0000\"\u0004\b\u0017\u0010\u0018R\u000E\u0010\u0019\u001A\u00020\u001AX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001B\u001A\u00020\u0015X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001C\u001A\u00020\u0015X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u001D\u001A\u0004\u0018\u00010\u001EX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u001F\u001A\b\u0012\u0004\u0012\u00020!0 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\"\u001A\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010$\u001A\u00020%X\u0082\u000E¢\u0006\u0004\n\u0002\u0010&R\u000E\u0010\'\u001A\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010(\u001A\u00020)8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b*\u0010+R\u0014\u0010,\u001A\u00020)8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b-\u0010+R\u000E\u0010.\u001A\u00020/X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010F\u001A\u00020G8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\bH\u0010IR\u001A\u0010J\u001A\u00020KX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001A\u0010P\u001A\u00020\u0015X\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bP\u0010Q\"\u0004\bR\u0010\u0018¨\u0006d"}, d2={"Landroidx/compose/ui/platform/RenderNodeLayer;", "Landroidx/compose/ui/node/OwnedLayer;", "Landroidx/compose/ui/layout/GraphicLayerInfo;", "ownerView", "Landroidx/compose/ui/platform/AndroidComposeView;", "drawBlock", "Lkotlin/Function2;", "Landroidx/compose/ui/graphics/Canvas;", "Lkotlin/ParameterName;", "name", "canvas", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "parentLayer", "", "invalidateParentLayer", "Lkotlin/Function0;", "<init>", "(Landroidx/compose/ui/platform/AndroidComposeView;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "getOwnerView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "value", "", "isDirty", "setDirty", "(Z)V", "outlineResolver", "Landroidx/compose/ui/platform/OutlineResolver;", "isDestroyed", "drawnWithZ", "softwareLayerPaint", "Landroidx/compose/ui/graphics/Paint;", "matrixCache", "Landroidx/compose/ui/platform/LayerMatrixCache;", "Landroidx/compose/ui/platform/DeviceRenderNode;", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "J", "renderNode", "layerId", "", "getLayerId", "()J", "ownerViewId", "getOwnerViewId", "mutatedFields", "", "updateLayerProperties", "scope", "Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;", "isInLayer", "position", "Landroidx/compose/ui/geometry/Offset;", "isInLayer-k-4lQ0M", "(J)Z", "resize", "size", "Landroidx/compose/ui/unit/IntSize;", "resize-ozmzZPI", "(J)V", "move", "Landroidx/compose/ui/unit/IntOffset;", "move--gyyYBs", "invalidate", "triggerRepaint", "drawLayer", "clipRenderNode", "updateDisplayList", "destroy", "underlyingMatrix", "Landroidx/compose/ui/graphics/Matrix;", "getUnderlyingMatrix-sQKQjiQ", "()[F", "frameRate", "", "getFrameRate", "()F", "setFrameRate", "(F)V", "isFrameRateFromParent", "()Z", "setFrameRateFromParent", "mapOffset", "point", "inverse", "mapOffset-8S9VItk", "(JZ)J", "mapBounds", "rect", "Landroidx/compose/ui/geometry/MutableRect;", "reuseLayer", "transform", "matrix", "transform-58bKbWc", "([F)V", "inverseTransform", "inverseTransform-58bKbWc", "UniqueDrawingIdApi29", "Companion", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class RenderNodeLayer implements GraphicLayerInfo, OwnedLayer {
    @Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2={"Landroidx/compose/ui/platform/RenderNodeLayer$Companion;", "", "<init>", "()V", "getMatrix", "Lkotlin/Function2;", "Landroidx/compose/ui/platform/DeviceRenderNode;", "Landroid/graphics/Matrix;", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0007¨\u0006\b"}, d2={"Landroidx/compose/ui/platform/RenderNodeLayer$UniqueDrawingIdApi29;", "", "<init>", "()V", "getUniqueDrawingId", "", "view", "Landroid/view/View;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class UniqueDrawingIdApi29 {
        public static final UniqueDrawingIdApi29 INSTANCE;

        static {
            UniqueDrawingIdApi29.INSTANCE = new UniqueDrawingIdApi29();
        }

        private UniqueDrawingIdApi29() {
            super();
        }

        @JvmStatic public static final long getUniqueDrawingId(View arg2) {
            return arg2.getUniqueDrawingId();
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private final CanvasHolder canvasHolder;
    private Function2 drawBlock;
    private boolean drawnWithZ;
    private float frameRate;
    private static final Function2 getMatrix;
    private Function0 invalidateParentLayer;
    private boolean isDestroyed;
    private boolean isDirty;
    private boolean isFrameRateFromParent;
    private final LayerMatrixCache matrixCache;
    private int mutatedFields;
    private final OutlineResolver outlineResolver;
    private final AndroidComposeView ownerView;
    private final DeviceRenderNode renderNode;
    private Paint softwareLayerPaint;
    private long transformOrigin;

    static {
        RenderNodeLayer.Companion = new Companion(null);
        RenderNodeLayer.$stable = 8;
        RenderNodeLayer.getMatrix = RenderNodeLayer$Companion$getMatrix$1.INSTANCE;
    }

    public RenderNodeLayer(AndroidComposeView arg1, Function2 arg2, Function0 arg3) {
        RenderNodeApi23 v2_1;
        super();
        this.ownerView = arg1;
        this.drawBlock = arg2;
        this.invalidateParentLayer = arg3;
        this.outlineResolver = new OutlineResolver();
        this.matrixCache = new LayerMatrixCache(RenderNodeLayer.getMatrix);
        this.canvasHolder = new CanvasHolder();
        this.transformOrigin = TransformOrigin.Companion.getCenter-SzJe1aQ();
        if(Build$VERSION.SDK_INT >= 29) {
            RenderNodeApi29 v2 = new RenderNodeApi29(arg1);
        }
        else {
            v2_1 = new RenderNodeApi23(arg1);
        }

        ((DeviceRenderNode)v2_1).setHasOverlappingRendering(true);
        ((DeviceRenderNode)v2_1).setClipToBounds(false);
        this.renderNode = ((DeviceRenderNode)v2_1);
    }

    private final void clipRenderNode(Canvas arg2) {
        if(!this.renderNode.getClipToOutline()) {
            if(this.renderNode.getClipToBounds()) {
            }
            else {
                return;
            }
        }

        this.outlineResolver.clipToOutline(arg2);
    }

    public void destroy() {
        if(this.renderNode.getHasDisplayList()) {
            this.renderNode.discardDisplayList();
        }

        this.drawBlock = null;
        this.invalidateParentLayer = null;
        this.isDestroyed = true;
        this.setDirty(false);
        this.ownerView.requestClearInvalidObservations();
        this.ownerView.recycle$ui(((OwnedLayer)this));
    }

    public void drawLayer(Canvas arg8, GraphicsLayer arg9) {
        android.graphics.Canvas v0 = AndroidCanvas_androidKt.getNativeCanvas(arg8);
        boolean v6 = false;
        if(v0.isHardwareAccelerated()) {
            this.updateDisplayList();
            if(this.renderNode.getElevation() > 0f) {
                v6 = true;
            }

            this.drawnWithZ = v6;
            if(v6) {
                arg8.enableZ();
            }

            this.renderNode.drawInto(v0);
            if(this.drawnWithZ) {
                arg8.disableZ();
            }

            return;
        }

        float v1 = ((float)this.renderNode.getLeft());
        float v2 = ((float)this.renderNode.getTop());
        float v3 = ((float)this.renderNode.getRight());
        float v4 = ((float)this.renderNode.getBottom());
        if(this.renderNode.getAlpha() < 1f) {
            Paint v9 = this.softwareLayerPaint;
            if(v9 == null) {
                v9 = AndroidPaint_androidKt.Paint();
                this.softwareLayerPaint = v9;
            }

            v9.setAlpha(this.renderNode.getAlpha());
            v0.saveLayer(v1, v2, v3, v4, v9.asFrameworkPaint());
        }
        else {
            arg8.save();
        }

        arg8.translate(v1, v2);
        arg8.concat-58bKbWc(this.matrixCache.calculateMatrix-GrdbGEg(this.renderNode));
        this.clipRenderNode(arg8);
        Function2 v9_1 = this.drawBlock;
        if(v9_1 != null) {
            v9_1.invoke(arg8, null);
        }

        arg8.restore();
        this.setDirty(false);
    }

    public float getFrameRate() {
        return this.frameRate;
    }

    public long getLayerId() {
        return this.renderNode.getUniqueId();
    }

    public final AndroidComposeView getOwnerView() {
        return this.ownerView;
    }

    public long getOwnerViewId() {
        if(Build$VERSION.SDK_INT >= 29) {
            return UniqueDrawingIdApi29.getUniqueDrawingId(this.ownerView);
        }

        return -1;
    }

    public float[] getUnderlyingMatrix-sQKQjiQ() {
        return this.matrixCache.calculateMatrix-GrdbGEg(this.renderNode);
    }

    public void invalidate() {
        if(!this.isDirty && !this.isDestroyed) {
            this.ownerView.invalidate();
            this.setDirty(true);
        }
    }

    public void inverseTransform-58bKbWc(float[] arg2) {
        float[] v1 = this.matrixCache.calculateInverseMatrix-bWbORWo(this.renderNode);
        if(v1 != null) {
            Matrix.timesAssign-58bKbWc(arg2, v1);
        }
    }

    public boolean isFrameRateFromParent() {
        return this.isFrameRateFromParent;
    }

    public boolean isInLayer-k-4lQ0M(long arg5) {
        float v0 = Float.intBitsToFloat(((int)(arg5 >> 0x20)));
        float v1 = Float.intBitsToFloat(((int)(0xFFFFFFFFL & arg5)));
        if(this.renderNode.getClipToBounds()) {
            if(0f <= v0 && v0 < (((float)this.renderNode.getWidth())) && 0f <= v1 && v1 < (((float)this.renderNode.getHeight()))) {
                return 1;
            }

            return 0;
        }

        if(this.renderNode.getClipToOutline()) {
            return this.outlineResolver.isInOutline-k-4lQ0M(arg5);
        }

        return 1;
    }

    public void mapBounds(MutableRect arg2, boolean arg3) {
        LayerMatrixCache v0 = this.matrixCache;
        if(arg3) {
            v0.mapInverse(this.renderNode, arg2);
            return;
        }

        v0.map(this.renderNode, arg2);
    }

    public long mapOffset-8S9VItk(long arg2, boolean arg4) {
        LayerMatrixCache v0 = this.matrixCache;
        if(arg4) {
            return v0.mapInverse-R5De75A(this.renderNode, arg2);
        }

        return v0.map-R5De75A(this.renderNode, arg2);
    }

    public void move--gyyYBs(long arg4) {
        int v0 = this.renderNode.getLeft();
        int v1 = this.renderNode.getTop();
        int v2 = IntOffset.getX-impl(arg4);
        int v4 = IntOffset.getY-impl(arg4);
        if(v0 == v2) {
            if(v1 != v4) {
            }
            else {
                return;
            }
        }

        if(v0 != v2) {
            this.renderNode.offsetLeftAndRight(v2 - v0);
        }

        if(v1 != v4) {
            this.renderNode.offsetTopAndBottom(v4 - v1);
        }

        this.triggerRepaint();
        this.matrixCache.invalidate();
    }

    public void resize-ozmzZPI(long arg5) {
        int v0 = ((int)(arg5 >> 0x20));
        int v5 = ((int)(arg5 & 0xFFFFFFFFL));
        this.renderNode.setPivotX(TransformOrigin.getPivotFractionX-impl(this.transformOrigin) * (((float)v0)));
        this.renderNode.setPivotY(TransformOrigin.getPivotFractionY-impl(this.transformOrigin) * (((float)v5)));
        if(this.renderNode.setPosition(this.renderNode.getLeft(), this.renderNode.getTop(), this.renderNode.getLeft() + v0, this.renderNode.getTop() + v5)) {
            this.renderNode.setOutline(this.outlineResolver.getAndroidOutline());
            this.invalidate();
            this.matrixCache.invalidate();
        }
    }

    public void reuseLayer(Function2 arg3, Function0 arg4) {
        this.matrixCache.reset();
        this.setDirty(false);
        this.isDestroyed = false;
        this.drawnWithZ = false;
        this.transformOrigin = TransformOrigin.Companion.getCenter-SzJe1aQ();
        this.drawBlock = arg3;
        this.invalidateParentLayer = arg4;
    }

    private final void setDirty(boolean arg2) {
        if(arg2 != this.isDirty) {
            this.isDirty = arg2;
            this.ownerView.notifyLayerIsDirty$ui(((OwnedLayer)this), arg2);
        }
    }

    public void setFrameRate(float arg1) {
        this.frameRate = arg1;
    }

    public void setFrameRateFromParent(boolean arg1) {
        this.isFrameRateFromParent = arg1;
    }

    public void transform-58bKbWc(float[] arg2) {
        Matrix.timesAssign-58bKbWc(arg2, this.matrixCache.calculateMatrix-GrdbGEg(this.renderNode));
    }

    private final void triggerRepaint() {
        WrapperRenderNodeLayerHelperMethods.INSTANCE.onDescendantInvalidated(this.ownerView);
    }

    public void updateDisplayList() {
        if(!this.isDirty) {
            if(!this.renderNode.getHasDisplayList()) {
            }
            else {
                return;
            }
        }

        Path v0 = !this.renderNode.getClipToOutline() || (this.outlineResolver.getOutlineClipSupported()) ? null : this.outlineResolver.getClipPath();
        Function2 v1 = this.drawBlock;
        if(v1 != null) {
            this.renderNode.record(this.canvasHolder, v0, new RenderNodeLayer$updateDisplayList$1$1(v1));
        }

        this.setDirty(false);
    }

    public void updateLayerProperties(ReusableGraphicsLayerScope arg14) {
        int v0 = arg14.getMutatedFields$ui() | this.mutatedFields;
        int v1 = v0 & 0x1000;
        if(v1 != 0) {
            this.transformOrigin = arg14.getTransformOrigin-SzJe1aQ();
        }

        int v3 = 0;
        int v2 = !this.renderNode.getClipToOutline() || (this.outlineResolver.getOutlineClipSupported()) ? 0 : 1;
        if((v0 & 1) != 0) {
            this.renderNode.setScaleX(arg14.getScaleX());
        }

        if((v0 & 2) != 0) {
            this.renderNode.setScaleY(arg14.getScaleY());
        }

        if((v0 & 4) != 0) {
            this.renderNode.setAlpha(arg14.getAlpha());
        }

        if((v0 & 8) != 0) {
            this.renderNode.setTranslationX(arg14.getTranslationX());
        }

        if((v0 & 16) != 0) {
            this.renderNode.setTranslationY(arg14.getTranslationY());
        }

        if((v0 & 0x20) != 0) {
            this.renderNode.setElevation(arg14.getShadowElevation());
        }

        if((v0 & 0x40) != 0) {
            this.renderNode.setAmbientShadowColor(ColorKt.toArgb-8_81llA(arg14.getAmbientShadowColor-0d7_KjU()));
        }

        if((v0 & 0x80) != 0) {
            this.renderNode.setSpotShadowColor(ColorKt.toArgb-8_81llA(arg14.getSpotShadowColor-0d7_KjU()));
        }

        if((v0 & 0x400) != 0) {
            this.renderNode.setRotationZ(arg14.getRotationZ());
        }

        if((v0 & 0x100) != 0) {
            this.renderNode.setRotationX(arg14.getRotationX());
        }

        if((v0 & 0x200) != 0) {
            this.renderNode.setRotationY(arg14.getRotationY());
        }

        if((v0 & 0x800) != 0) {
            this.renderNode.setCameraDistance(arg14.getCameraDistance());
        }

        if(v1 != 0) {
            this.renderNode.setPivotX(TransformOrigin.getPivotFractionX-impl(this.transformOrigin) * (((float)this.renderNode.getWidth())));
            this.renderNode.setPivotY(TransformOrigin.getPivotFractionY-impl(this.transformOrigin) * (((float)this.renderNode.getHeight())));
        }

        boolean v9 = !arg14.getClip() || arg14.getShape() == RectangleShapeKt.getRectangleShape() ? false : true;
        if((v0 & 0x6000) != 0) {
            this.renderNode.setClipToOutline(v9);
            DeviceRenderNode v1_1 = this.renderNode;
            boolean v5 = !arg14.getClip() || arg14.getShape() != RectangleShapeKt.getRectangleShape() ? false : true;
            v1_1.setClipToBounds(v5);
        }

        if((0x20000 & v0) != 0) {
            this.renderNode.setRenderEffect(arg14.getRenderEffect());
        }

        if((0x40000 & v0) != 0) {
            this.renderNode.setColorFilter(arg14.getColorFilter());
        }

        if((0x80000 & v0) != 0) {
            this.renderNode.setBlendMode-s9anfk8(arg14.getBlendMode-0nO6VwU());
        }

        if((0x8000 & v0) != 0) {
            this.renderNode.setCompositingStrategy-aDBOjCE(arg14.getCompositingStrategy--NrFUSI());
        }

        boolean v1_2 = this.outlineResolver.update-S_szKao(arg14.getOutline$ui(), arg14.getAlpha(), v9, arg14.getShadowElevation(), arg14.getSize-NH-jbRc());
        if(this.outlineResolver.getCacheIsDirty$ui()) {
            this.renderNode.setOutline(this.outlineResolver.getAndroidOutline());
        }

        if((v9) && !this.outlineResolver.getOutlineClipSupported()) {
            v3 = 1;
        }

        if(v2 == v3) {
            if(v3 != 0 && (v1_2)) {
                goto label_167;
            }

            this.triggerRepaint();
        }
        else {
        label_167:
            this.invalidate();
        }

        if(!this.drawnWithZ && this.renderNode.getElevation() > 0f) {
            Function0 v1_3 = this.invalidateParentLayer;
            if(v1_3 != null) {
                v1_3.invoke();
            }
        }

        if((v0 & 0x1F1B) != 0) {
            this.matrixCache.invalidate();
        }

        this.mutatedFields = arg14.getMutatedFields$ui();
    }
}

