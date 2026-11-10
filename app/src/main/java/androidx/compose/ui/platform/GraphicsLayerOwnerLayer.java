package androidx.compose.ui.platform;

import android.os.Build$VERSION;
import androidx.compose.ui.FrameRateCategory;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CompositingStrategy;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.MatrixKt;
import androidx.compose.ui.graphics.Outline$Generic;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.GraphicLayerInfo;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\r\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002Bi\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u00128\u0010\t\u001A4\u0012\u0013\u0012\u00110\u000B¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000E\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000F\u0012\u0004\u0012\u00020\u00100\n\u0012\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010:\u001A\u00020\u00102\u0006\u0010&\u001A\u00020;H\u0016J\b\u0010<\u001A\u00020\u0010H\u0002J\b\u0010=\u001A\u00020\u0010H\u0002J\u0017\u0010>\u001A\u00020\u00192\u0006\u0010?\u001A\u00020@H\u0016¢\u0006\u0004\bA\u0010BJ\u0017\u0010C\u001A\u00020\u00102\u0006\u0010?\u001A\u00020DH\u0016¢\u0006\u0004\bE\u0010FJ\u0017\u0010G\u001A\u00020\u00102\u0006\u0010\u0015\u001A\u00020\u0016H\u0016¢\u0006\u0004\bH\u0010FJ\u001A\u0010J\u001A\u00020\u00102\u0006\u0010\u000E\u001A\u00020\u000B2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0004H\u0016J\b\u0010K\u001A\u00020\u0010H\u0016J\b\u0010P\u001A\u00020\u0010H\u0016J\b\u0010Q\u001A\u00020\u0010H\u0016J\u001F\u0010R\u001A\u00020@2\u0006\u0010S\u001A\u00020@2\u0006\u0010T\u001A\u00020\u0019H\u0016¢\u0006\u0004\bU\u0010VJ\u0018\u0010W\u001A\u00020\u00102\u0006\u0010X\u001A\u00020Y2\u0006\u0010T\u001A\u00020\u0019H\u0016JP\u0010Z\u001A\u00020\u001028\u0010\t\u001A4\u0012\u0013\u0012\u00110\u000B¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000E\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000F\u0012\u0004\u0012\u00020\u00100\n2\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00100\u0012H\u0016J\u0017\u0010[\u001A\u00020\u00102\u0006\u0010\\\u001A\u00020\u001BH\u0016¢\u0006\u0004\b]\u0010^J\u0017\u0010_\u001A\u00020\u00102\u0006\u0010\\\u001A\u00020\u001BH\u0016¢\u0006\u0004\b`\u0010^J\u000F\u0010g\u001A\u00020\u001BH\u0002¢\u0006\u0004\bh\u0010iJ\u0011\u0010l\u001A\u0004\u0018\u00010\u001BH\u0002¢\u0006\u0004\bm\u0010iJ\b\u0010n\u001A\u00020\u0010H\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001A\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000RB\u0010\t\u001A6\u0012\u0013\u0012\u00110\u000B¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000E\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000F\u0012\u0004\u0012\u00020\u0010\u0018\u00010\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001A\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0012X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001A\u00020\u0016X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0017R\u000E\u0010\u0018\u001A\u00020\u0019X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u001A\u001A\u00020\u001BX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001CR\u0012\u0010\u001D\u001A\u0004\u0018\u00010\u001BX\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u001CR\u001E\u0010\u001F\u001A\u00020\u00192\u0006\u0010\u001E\u001A\u00020\u0019@BX\u0082\u000E¢\u0006\b\n\u0000\"\u0004\b \u0010!R\u000E\u0010\"\u001A\u00020#X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010$\u001A\u00020%X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010&\u001A\u00020\'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010(\u001A\u00020)X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010*\u001A\u00020+X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0017R\u0010\u0010,\u001A\u0004\u0018\u00010-X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010.\u001A\u00020\u0019X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010/\u001A\u00020\u0019X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u00100\u001A\u00020\u0019X\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u00101\u001A\u000202X\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b3\u00104\"\u0004\b5\u00106R\u001A\u00107\u001A\u00020\u0019X\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b7\u00108\"\u0004\b9\u0010!R\u000E\u0010I\u001A\u00020\u0019X\u0082\u000E¢\u0006\u0002\n\u0000R\u001F\u0010L\u001A\u0013\u0012\u0004\u0012\u00020N\u0012\u0004\u0012\u00020\u00100M¢\u0006\u0002\bOX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010a\u001A\u00020b8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\bc\u0010dR\u0014\u0010e\u001A\u00020b8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\bf\u0010dR\u0014\u0010j\u001A\u00020\u001B8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\bk\u0010i¨\u0006o"}, d2={"Landroidx/compose/ui/platform/GraphicsLayerOwnerLayer;", "Landroidx/compose/ui/node/OwnedLayer;", "Landroidx/compose/ui/layout/GraphicLayerInfo;", "graphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "context", "Landroidx/compose/ui/graphics/GraphicsContext;", "ownerView", "Landroidx/compose/ui/platform/AndroidComposeView;", "drawBlock", "Lkotlin/Function2;", "Landroidx/compose/ui/graphics/Canvas;", "Lkotlin/ParameterName;", "name", "canvas", "parentLayer", "", "invalidateParentLayer", "Lkotlin/Function0;", "<init>", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;Landroidx/compose/ui/graphics/GraphicsContext;Landroidx/compose/ui/platform/AndroidComposeView;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "size", "Landroidx/compose/ui/unit/IntSize;", "J", "isDestroyed", "", "matrixCache", "Landroidx/compose/ui/graphics/Matrix;", "[F", "inverseMatrixCache", "value", "isDirty", "setDirty", "(Z)V", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "scope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "mutatedFields", "", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "outline", "Landroidx/compose/ui/graphics/Outline;", "isMatrixDirty", "isInverseMatrixDirty", "isIdentity", "frameRate", "", "getFrameRate", "()F", "setFrameRate", "(F)V", "isFrameRateFromParent", "()Z", "setFrameRateFromParent", "updateLayerProperties", "Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;", "triggerRepaint", "updateOutline", "isInLayer", "position", "Landroidx/compose/ui/geometry/Offset;", "isInLayer-k-4lQ0M", "(J)Z", "move", "Landroidx/compose/ui/unit/IntOffset;", "move--gyyYBs", "(J)V", "resize", "resize-ozmzZPI", "drawnWithEnabledZ", "drawLayer", "updateDisplayList", "recordLambda", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Lkotlin/ExtensionFunctionType;", "invalidate", "destroy", "mapOffset", "point", "inverse", "mapOffset-8S9VItk", "(JZ)J", "mapBounds", "rect", "Landroidx/compose/ui/geometry/MutableRect;", "reuseLayer", "transform", "matrix", "transform-58bKbWc", "([F)V", "inverseTransform", "inverseTransform-58bKbWc", "layerId", "", "getLayerId", "()J", "ownerViewId", "getOwnerViewId", "getMatrix", "getMatrix-sQKQjiQ", "()[F", "underlyingMatrix", "getUnderlyingMatrix-sQKQjiQ", "getInverseMatrix", "getInverseMatrix-3i98HWw", "updateMatrix", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class GraphicsLayerOwnerLayer implements GraphicLayerInfo, OwnedLayer {
    public static final int $stable = 8;
    private final GraphicsContext context;
    private Density density;
    private Function2 drawBlock;
    private boolean drawnWithEnabledZ;
    private float frameRate;
    private GraphicsLayer graphicsLayer;
    private Function0 invalidateParentLayer;
    private float[] inverseMatrixCache;
    private boolean isDestroyed;
    private boolean isDirty;
    private boolean isFrameRateFromParent;
    private boolean isIdentity;
    private boolean isInverseMatrixDirty;
    private boolean isMatrixDirty;
    private LayoutDirection layoutDirection;
    private final float[] matrixCache;
    private int mutatedFields;
    private Outline outline;
    private final AndroidComposeView ownerView;
    private final Function1 recordLambda;
    private final CanvasDrawScope scope;
    private long size;
    private long transformOrigin;

    static {
    }

    public GraphicsLayerOwnerLayer(GraphicsLayer arg1, GraphicsContext arg2, AndroidComposeView arg3, Function2 arg4, Function0 arg5) {
        super();
        this.graphicsLayer = arg1;
        this.context = arg2;
        this.ownerView = arg3;
        this.drawBlock = arg4;
        this.invalidateParentLayer = arg5;
        this.size = IntSize.constructor-impl(0x7FFFFFFF7FFFFFFFL);
        this.matrixCache = Matrix.constructor-impl$default(null, 1, null);
        this.density = DensityKt.Density$default(1f, 0f, 2, null);
        this.layoutDirection = LayoutDirection.Ltr;
        this.scope = new CanvasDrawScope();
        this.transformOrigin = TransformOrigin.Companion.getCenter-SzJe1aQ();
        this.isIdentity = true;
        this.recordLambda = new GraphicsLayerOwnerLayer$recordLambda$1(this);
    }

    public static final Function2 access$getDrawBlock$p(GraphicsLayerOwnerLayer arg0) {
        return arg0.drawBlock;
    }

    public void destroy() {
        this.setFrameRate(0f);
        this.setFrameRateFromParent(false);
        this.drawBlock = null;
        this.invalidateParentLayer = null;
        this.isDestroyed = true;
        this.setDirty(false);
        GraphicsContext v0 = this.context;
        if(v0 != null) {
            v0.releaseGraphicsLayer(this.graphicsLayer);
            this.ownerView.recycle$ui(((OwnedLayer)this));
        }
    }

    public void drawLayer(Canvas arg3, GraphicsLayer arg4) {
        this.updateDisplayList();
        boolean v0 = this.graphicsLayer.getShadowElevation() > 0f ? true : false;
        this.drawnWithEnabledZ = v0;
        DrawContext v0_1 = this.scope.getDrawContext();
        v0_1.setCanvas(arg3);
        v0_1.setGraphicsLayer(arg4);
        GraphicsLayerKt.drawLayer(this.scope, this.graphicsLayer);
    }

    public float getFrameRate() {
        return this.frameRate;
    }

    private final float[] getInverseMatrix-3i98HWw() {
        float[] v0 = this.inverseMatrixCache;
        float[] v1 = null;
        if(v0 == null) {
            v0 = Matrix.constructor-impl$default(v1, 1, ((DefaultConstructorMarker)v1));
            this.inverseMatrixCache = v0;
        }

        if(this.isInverseMatrixDirty) {
            this.isInverseMatrixDirty = false;
            float[] v2 = this.getMatrix-sQKQjiQ();
            if(this.isIdentity) {
                return v2;
            }
            else {
                if(InvertMatrixKt.invertTo-JiSxe2E(v2, v0)) {
                    return v0;
                }

                goto label_21;
            }
        }
        else if(Float.isNaN(v0[0])) {
            return v1;
        }

        return v0;
    label_21:
        v0[0] = NaNf;
        return v1;
    }

    public long getLayerId() {
        return this.graphicsLayer.getLayerId();
    }

    private final float[] getMatrix-sQKQjiQ() {
        this.updateMatrix();
        return this.matrixCache;
    }

    public long getOwnerViewId() {
        return this.graphicsLayer.getOwnerViewId();
    }

    public float[] getUnderlyingMatrix-sQKQjiQ() {
        return this.getMatrix-sQKQjiQ();
    }

    public void invalidate() {
        if(!this.isDirty && !this.isDestroyed) {
            this.ownerView.invalidate();
            this.setDirty(true);
        }
    }

    public void inverseTransform-58bKbWc(float[] arg1) {
        float[] v0 = this.getInverseMatrix-3i98HWw();
        if(v0 != null) {
            Matrix.timesAssign-58bKbWc(arg1, v0);
        }
    }

    public boolean isFrameRateFromParent() {
        return this.isFrameRateFromParent;
    }

    public boolean isInLayer-k-4lQ0M(long arg9) {
        float v2 = Float.intBitsToFloat(((int)(arg9 >> 0x20)));
        float v3 = Float.intBitsToFloat(((int)(arg9 & 0xFFFFFFFFL)));
        if(this.graphicsLayer.getClip()) {
            return ShapeContainingUtilKt.isInOutline$default(this.graphicsLayer.getOutline(), v2, v3, null, null, 24, null);
        }

        return 1;
    }

    public void mapBounds(MutableRect arg1, boolean arg2) {
        float[] v2 = arg2 ? this.getInverseMatrix-3i98HWw() : this.getMatrix-sQKQjiQ();
        if(!this.isIdentity) {
            if(v2 == null) {
                arg1.set(0f, 0f, 0f, 0f);
                return;
            }
            else {
                Matrix.map-impl(v2, arg1);
            }
        }
    }

    public long mapOffset-8S9VItk(long arg1, boolean arg3) {
        float[] v3;
        if(arg3) {
            v3 = this.getInverseMatrix-3i98HWw();
            if(v3 == null) {
                return Offset.Companion.getInfinite-F1C5BW0();
            }
        }
        else {
            v3 = this.getMatrix-sQKQjiQ();
        }

        if(this.isIdentity) {
            return arg1;
        }

        return Matrix.map-MK-Hz9U(v3, arg1);
    }

    public void move--gyyYBs(long arg3) {
        if(this.ownerView.isArrEnabled$ui()) {
            this.ownerView.voteFrameRate(FrameRateCategory.Companion.getHigh-NSsRyOo());
        }

        this.graphicsLayer.setTopLeft--gyyYBs(arg3);
        this.triggerRepaint();
    }

    public void resize-ozmzZPI(long arg3) {
        if(!IntSize.equals-impl0(arg3, this.size)) {
            if(this.ownerView.isArrEnabled$ui()) {
                this.ownerView.voteFrameRate(FrameRateCategory.Companion.getHigh-NSsRyOo());
            }

            this.size = arg3;
            this.invalidate();
        }
    }

    public void reuseLayer(Function2 arg3, Function0 arg4) {
        GraphicsContext v0 = this.context;
        if(v0 != null) {
            if(!this.graphicsLayer.isReleased()) {
                InlineClassHelperKt.throwIllegalArgumentException("layer should have been released before reuse");
            }

            this.graphicsLayer = v0.createGraphicsLayer();
            this.isDestroyed = false;
            this.drawBlock = arg3;
            this.invalidateParentLayer = arg4;
            this.isMatrixDirty = false;
            this.isInverseMatrixDirty = false;
            this.isIdentity = true;
            Matrix.reset-impl(this.matrixCache);
            float[] v3 = this.inverseMatrixCache;
            if(v3 != null) {
                Matrix.reset-impl(v3);
            }

            this.transformOrigin = TransformOrigin.Companion.getCenter-SzJe1aQ();
            this.drawnWithEnabledZ = false;
            this.size = IntSize.constructor-impl(0x7FFFFFFF7FFFFFFFL);
            this.outline = null;
            this.mutatedFields = 0;
            return;
        }

        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("currently reuse is only supported when we manage the layer lifecycle");
        throw new KotlinNothingValueException();
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

    public void transform-58bKbWc(float[] arg1) {
        Matrix.timesAssign-58bKbWc(arg1, this.getMatrix-sQKQjiQ());
    }

    private final void triggerRepaint() {
        WrapperRenderNodeLayerHelperMethods.INSTANCE.onDescendantInvalidated(this.ownerView);
    }

    public void updateDisplayList() {
        if(this.ownerView.isArrEnabled$ui()) {
            if(this.getFrameRate() == 0f) {
            }
            else {
                this.ownerView.voteFrameRate(this.getFrameRate());
            }
        }

        if(this.isDirty) {
            if(!TransformOrigin.equals-impl0(this.transformOrigin, TransformOrigin.Companion.getCenter-SzJe1aQ()) && !IntSize.equals-impl0(this.graphicsLayer.getSize-YbymL2g(), this.size)) {
                this.graphicsLayer.setPivotOffset-k-4lQ0M(Offset.constructor-impl((((long)Float.floatToRawIntBits(TransformOrigin.getPivotFractionY-impl(this.transformOrigin) * (((float)(((int)(this.size & 0xFFFFFFFFL)))))))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(TransformOrigin.getPivotFractionX-impl(this.transformOrigin) * (((float)(((int)(this.size >> 0x20)))))))) << 0x20));
            }

            this.graphicsLayer.record-mL-hObY(this.density, this.layoutDirection, this.size, this.recordLambda);
            this.setDirty(false);
        }
    }

    public void updateLayerProperties(ReusableGraphicsLayerScope arg11) {
        int v2_2;
        int v0 = arg11.getMutatedFields$ui() | this.mutatedFields;
        this.layoutDirection = arg11.getLayoutDirection$ui();
        this.density = arg11.getGraphicsDensity$ui();
        int v1 = v0 & 0x1000;
        if(v1 != 0) {
            this.transformOrigin = arg11.getTransformOrigin-SzJe1aQ();
        }

        if((v0 & 1) != 0) {
            this.graphicsLayer.setScaleX(arg11.getScaleX());
        }

        if((v0 & 2) != 0) {
            this.graphicsLayer.setScaleY(arg11.getScaleY());
        }

        if((v0 & 4) != 0) {
            this.graphicsLayer.setAlpha(arg11.getAlpha());
        }

        if((v0 & 8) != 0) {
            this.graphicsLayer.setTranslationX(arg11.getTranslationX());
        }

        if((v0 & 16) != 0) {
            this.graphicsLayer.setTranslationY(arg11.getTranslationY());
        }

        if((v0 & 0x20) != 0) {
            this.graphicsLayer.setShadowElevation(arg11.getShadowElevation());
            if(arg11.getShadowElevation() > 0f && !this.drawnWithEnabledZ) {
                Function0 v2 = this.invalidateParentLayer;
                if(v2 != null) {
                    v2.invoke();
                }
            }
        }

        if((v0 & 0x40) != 0) {
            this.graphicsLayer.setAmbientShadowColor-8_81llA(arg11.getAmbientShadowColor-0d7_KjU());
        }

        if((v0 & 0x80) != 0) {
            this.graphicsLayer.setSpotShadowColor-8_81llA(arg11.getSpotShadowColor-0d7_KjU());
        }

        if((v0 & 0x400) != 0) {
            this.graphicsLayer.setRotationZ(arg11.getRotationZ());
        }

        if((v0 & 0x100) != 0) {
            this.graphicsLayer.setRotationX(arg11.getRotationX());
        }

        if((v0 & 0x200) != 0) {
            this.graphicsLayer.setRotationY(arg11.getRotationY());
        }

        if((v0 & 0x800) != 0) {
            this.graphicsLayer.setCameraDistance(arg11.getCameraDistance());
        }

        if(v1 != 0) {
            boolean v1_1 = TransformOrigin.equals-impl0(this.transformOrigin, TransformOrigin.Companion.getCenter-SzJe1aQ());
            GraphicsLayer v2_1 = this.graphicsLayer;
            if(v1_1) {
                v2_1.setPivotOffset-k-4lQ0M(Offset.Companion.getUnspecified-F1C5BW0());
            }
            else {
                v2_1.setPivotOffset-k-4lQ0M(Offset.constructor-impl((((long)Float.floatToRawIntBits(TransformOrigin.getPivotFractionY-impl(this.transformOrigin) * (((float)(((int)(this.size & 0xFFFFFFFFL)))))))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(TransformOrigin.getPivotFractionX-impl(this.transformOrigin) * (((float)(((int)(this.size >> 0x20)))))))) << 0x20));
            }
        }

        if((v0 & 0x4000) != 0) {
            this.graphicsLayer.setClip(arg11.getClip());
        }

        if((0x20000 & v0) != 0) {
            this.graphicsLayer.setRenderEffect(arg11.getRenderEffect());
        }

        if((0x40000 & v0) != 0) {
            this.graphicsLayer.setColorFilter(arg11.getColorFilter());
        }

        if((0x80000 & v0) != 0) {
            this.graphicsLayer.setBlendMode-s9anfk8(arg11.getBlendMode-0nO6VwU());
        }

        if((0x8000 & v0) != 0) {
            GraphicsLayer v1_2 = this.graphicsLayer;
            v2_2 = arg11.getCompositingStrategy--NrFUSI();
            if(CompositingStrategy.equals-impl0(v2_2, CompositingStrategy.Companion.getAuto--NrFUSI())) {
                v2_2 = androidx.compose.ui.graphics.layer.CompositingStrategy.Companion.getAuto-ke2Ky5w();
            }
            else if(CompositingStrategy.equals-impl0(v2_2, CompositingStrategy.Companion.getOffscreen--NrFUSI())) {
                v2_2 = androidx.compose.ui.graphics.layer.CompositingStrategy.Companion.getOffscreen-ke2Ky5w();
            }
            else if(CompositingStrategy.equals-impl0(v2_2, CompositingStrategy.Companion.getModulateAlpha--NrFUSI())) {
                v2_2 = androidx.compose.ui.graphics.layer.CompositingStrategy.Companion.getModulateAlpha-ke2Ky5w();
            }
            else {
                goto label_165;
            }

            v1_2.setCompositingStrategy-Wpw9cng(v2_2);
            goto label_169;
        label_165:
            throw new IllegalStateException("Not supported composition strategy");
        }

    label_169:
        v2_2 = 1;
        if((v0 & 0x1F1B) != 0) {
            this.isMatrixDirty = true;
            this.isInverseMatrixDirty = true;
        }

        if(!Intrinsics.areEqual(this.outline, arg11.getOutline$ui())) {
            this.outline = arg11.getOutline$ui();
            this.updateOutline();
        }
        else {
            v2_2 = 0;
        }

        this.mutatedFields = arg11.getMutatedFields$ui();
        if(v0 != 0 || v2_2 != 0) {
            this.triggerRepaint();
            if(this.ownerView.isArrEnabled$ui()) {
                this.ownerView.voteFrameRate(this.getFrameRate());
            }
        }
    }

    private final void updateMatrix() {
        GraphicsLayerOwnerLayer v0 = this;
        if(v0.isMatrixDirty) {
            GraphicsLayer v1 = v0.graphicsLayer;
            long v2 = (v1.getPivotOffset-F1C5BW0() & 0x7FFFFFFF7FFFFFFFL) == 0x7FC000007FC00000L ? SizeKt.getCenter-uvyYCjk(IntSizeKt.toSize-ozmzZPI(v0.size)) : v1.getPivotOffset-F1C5BW0();
            Matrix.resetToPivotedTransform-impl$default(v0.matrixCache, Float.intBitsToFloat(((int)(v2 >> 0x20))), Float.intBitsToFloat(((int)(v2 & 0xFFFFFFFFL))), v1.getTranslationX(), v1.getTranslationY(), 0f, v1.getRotationX(), v1.getRotationY(), v1.getRotationZ(), v1.getScaleX(), v1.getScaleY(), 0f, 1040, null);
            v0.isMatrixDirty = false;
            v0.isIdentity = MatrixKt.isIdentity-58bKbWc(v0.matrixCache);
        }
    }

    private final void updateOutline() {
        Outline v0 = this.outline;
        if(v0 == null) {
        }
        else {
            GraphicsLayerKt.setOutline(this.graphicsLayer, v0);
            if(((v0 instanceof Generic)) && Build$VERSION.SDK_INT < 33) {
                Function0 v2 = this.invalidateParentLayer;
                if(v2 != null) {
                    v2.invoke();
                }
            }
        }
    }
}

