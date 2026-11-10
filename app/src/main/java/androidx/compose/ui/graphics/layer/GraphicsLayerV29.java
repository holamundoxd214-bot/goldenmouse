package androidx.compose.ui.graphics.layer;

import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.RecordingCanvas;
import android.graphics.RenderNode;
import android.os.Build$VERSION;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidBlendMode_androidKt;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidColorFilter_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u001A\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010Y\u001A\u00020ZH\u0002J\u001B\u0010e\u001A\u00020Z*\u00020\r2\u0006\u0010b\u001A\u00020aH\u0002¢\u0006\u0004\bf\u0010gJ\b\u0010h\u001A\u00020ZH\u0002J\'\u0010i\u001A\u00020Z2\u0006\u0010j\u001A\u00020k2\u0006\u0010l\u001A\u00020k2\u0006\u0010\u000E\u001A\u00020mH\u0016¢\u0006\u0004\bn\u0010oJ!\u0010p\u001A\u00020Z2\b\u0010q\u001A\u0004\u0018\u00010r2\u0006\u0010s\u001A\u00020mH\u0016¢\u0006\u0004\bt\u0010uJ<\u0010x\u001A\u00020Z2\u0006\u0010y\u001A\u00020z2\u0006\u0010{\u001A\u00020|2\u0006\u0010}\u001A\u00020~2\u001A\u0010\u007F\u001A\u0016\u0012\u0005\u0012\u00030\u0081\u0001\u0012\u0004\u0012\u00020Z0\u0080\u0001¢\u0006\u0003\b\u0082\u0001H\u0016J\u0013\u0010\u0083\u0001\u001A\u00020Z2\b\u0010\u0084\u0001\u001A\u00030\u0085\u0001H\u0016J\t\u0010\u0086\u0001\u001A\u00020\u0014H\u0016J\t\u0010\u0089\u0001\u001A\u00020ZH\u0016J\t\u0010\u008C\u0001\u001A\u00020\u0012H\u0002J\t\u0010\u008D\u0001\u001A\u00020\u0016H\u0002J\t\u0010\u008E\u0001\u001A\u00020\u0016H\u0002R\u0014\u0010\u0002\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000E\u001A\u00020\u000FX\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010\u0011\u001A\u0004\u0018\u00010\u0012X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001A\u0004\u0018\u00010\u0014X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R$\u0010\u0019\u001A\u00020\u00182\u0006\u0010\u0017\u001A\u00020\u0018@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001A\u0010\u001B\"\u0004\b\u001C\u0010\u001DR&\u0010\u001F\u001A\u00020\u001E2\u0006\u0010\u0017\u001A\u00020\u001E@VX\u0096\u000E¢\u0006\u0010\n\u0002\u0010$\u001A\u0004\b \u0010!\"\u0004\b\"\u0010#R(\u0010&\u001A\u0004\u0018\u00010%2\b\u0010\u0017\u001A\u0004\u0018\u00010%@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\'\u0010(\"\u0004\b)\u0010*R&\u0010,\u001A\u00020+2\u0006\u0010\u0017\u001A\u00020+@VX\u0096\u000E¢\u0006\u0010\n\u0002\u0010\u0010\u001A\u0004\b-\u0010\u000B\"\u0004\b.\u0010/R$\u00100\u001A\u00020\u00182\u0006\u0010\u0017\u001A\u00020\u0018@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b1\u0010\u001B\"\u0004\b2\u0010\u001DR$\u00103\u001A\u00020\u00182\u0006\u0010\u0017\u001A\u00020\u0018@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b4\u0010\u001B\"\u0004\b5\u0010\u001DR$\u00106\u001A\u00020\u00182\u0006\u0010\u0017\u001A\u00020\u0018@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b7\u0010\u001B\"\u0004\b8\u0010\u001DR$\u00109\u001A\u00020\u00182\u0006\u0010\u0017\u001A\u00020\u0018@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b:\u0010\u001B\"\u0004\b;\u0010\u001DR$\u0010<\u001A\u00020\u00182\u0006\u0010\u0017\u001A\u00020\u0018@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b=\u0010\u001B\"\u0004\b>\u0010\u001DR&\u0010@\u001A\u00020?2\u0006\u0010\u0017\u001A\u00020?@VX\u0096\u000E¢\u0006\u0010\n\u0002\u0010\u0010\u001A\u0004\bA\u0010\u000B\"\u0004\bB\u0010/R&\u0010C\u001A\u00020?2\u0006\u0010\u0017\u001A\u00020?@VX\u0096\u000E¢\u0006\u0010\n\u0002\u0010\u0010\u001A\u0004\bD\u0010\u000B\"\u0004\bE\u0010/R$\u0010F\u001A\u00020\u00182\u0006\u0010\u0017\u001A\u00020\u0018@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bG\u0010\u001B\"\u0004\bH\u0010\u001DR$\u0010I\u001A\u00020\u00182\u0006\u0010\u0017\u001A\u00020\u0018@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bJ\u0010\u001B\"\u0004\bK\u0010\u001DR$\u0010L\u001A\u00020\u00182\u0006\u0010\u0017\u001A\u00020\u0018@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bM\u0010\u001B\"\u0004\bN\u0010\u001DR$\u0010O\u001A\u00020\u00182\u0006\u0010\u0017\u001A\u00020\u0018@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bP\u0010\u001B\"\u0004\bQ\u0010\u001DR$\u0010R\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u0016@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bS\u0010T\"\u0004\bU\u0010VR\u000E\u0010W\u001A\u00020\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010X\u001A\u00020\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R(\u0010\\\u001A\u0004\u0018\u00010[2\b\u0010\u0017\u001A\u0004\u0018\u00010[@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b]\u0010^\"\u0004\b_\u0010`R&\u0010b\u001A\u00020a2\u0006\u0010\u0017\u001A\u00020a@VX\u0096\u000E¢\u0006\u0010\n\u0002\u0010$\u001A\u0004\bc\u0010!\"\u0004\bd\u0010#R\u001A\u0010v\u001A\u00020\u0016X\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bv\u0010T\"\u0004\bw\u0010VR\u0016\u0010\u0087\u0001\u001A\u00020\u00168VX\u0096\u0004¢\u0006\u0007\u001A\u0005\b\u0088\u0001\u0010TR\u0016\u0010\u008A\u0001\u001A\u00020\u00038VX\u0096\u0004¢\u0006\u0007\u001A\u0005\b\u008B\u0001\u0010\u000B¨\u0006\u008F\u0001"}, d2={"Landroidx/compose/ui/graphics/layer/GraphicsLayerV29;", "Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl;", "ownerId", "", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "canvasDrawScope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "<init>", "(JLandroidx/compose/ui/graphics/CanvasHolder;Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;)V", "getOwnerId", "()J", "renderNode", "Landroid/graphics/RenderNode;", "size", "Landroidx/compose/ui/geometry/Size;", "J", "layerPaint", "Landroid/graphics/Paint;", "matrix", "Landroid/graphics/Matrix;", "outlineIsProvided", "", "value", "", "alpha", "getAlpha", "()F", "setAlpha", "(F)V", "Landroidx/compose/ui/graphics/BlendMode;", "blendMode", "getBlendMode-0nO6VwU", "()I", "setBlendMode-s9anfk8", "(I)V", "I", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "Landroidx/compose/ui/geometry/Offset;", "pivotOffset", "getPivotOffset-F1C5BW0", "setPivotOffset-k-4lQ0M", "(J)V", "scaleX", "getScaleX", "setScaleX", "scaleY", "getScaleY", "setScaleY", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "shadowElevation", "getShadowElevation", "setShadowElevation", "Landroidx/compose/ui/graphics/Color;", "ambientShadowColor", "getAmbientShadowColor-0d7_KjU", "setAmbientShadowColor-8_81llA", "spotShadowColor", "getSpotShadowColor-0d7_KjU", "setSpotShadowColor-8_81llA", "rotationX", "getRotationX", "setRotationX", "rotationY", "getRotationY", "setRotationY", "rotationZ", "getRotationZ", "setRotationZ", "cameraDistance", "getCameraDistance", "setCameraDistance", "clip", "getClip", "()Z", "setClip", "(Z)V", "clipToBounds", "clipToOutline", "applyClip", "", "Landroidx/compose/ui/graphics/RenderEffect;", "renderEffect", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "Landroidx/compose/ui/graphics/layer/CompositingStrategy;", "compositingStrategy", "getCompositingStrategy-ke2Ky5w", "setCompositingStrategy-Wpw9cng", "applyCompositingStrategy", "applyCompositingStrategy-Z1X6vPc", "(Landroid/graphics/RenderNode;I)V", "updateLayerProperties", "setPosition", "x", "", "y", "Landroidx/compose/ui/unit/IntSize;", "setPosition-H0pRuoY", "(IIJ)V", "setOutline", "outline", "Landroid/graphics/Outline;", "outlineSize", "setOutline-O0kMr_c", "(Landroid/graphics/Outline;J)V", "isInvalidated", "setInvalidated", "record", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "layer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Lkotlin/ExtensionFunctionType;", "draw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "calculateMatrix", "hasDisplayList", "getHasDisplayList", "discardDisplayList", "layerId", "getLayerId", "obtainLayerPaint", "requiresCompositingLayer", "requiresLayerPaint", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class GraphicsLayerV29 implements GraphicsLayerImpl {
    public static final int $stable = 8;
    private float alpha;
    private long ambientShadowColor;
    private int blendMode;
    private float cameraDistance;
    private final CanvasDrawScope canvasDrawScope;
    private final CanvasHolder canvasHolder;
    private boolean clip;
    private boolean clipToBounds;
    private boolean clipToOutline;
    private ColorFilter colorFilter;
    private int compositingStrategy;
    private boolean isInvalidated;
    private Paint layerPaint;
    private Matrix matrix;
    private boolean outlineIsProvided;
    private final long ownerId;
    private long pivotOffset;
    private RenderEffect renderEffect;
    private final RenderNode renderNode;
    private float rotationX;
    private float rotationY;
    private float rotationZ;
    private float scaleX;
    private float scaleY;
    private float shadowElevation;
    private long size;
    private long spotShadowColor;
    private float translationX;
    private float translationY;

    static {
    }

    public GraphicsLayerV29(long arg1, CanvasHolder arg3, CanvasDrawScope arg4, int arg5, DefaultConstructorMarker arg6) {
        if((arg5 & 2) != 0) {
            arg3 = new CanvasHolder();
        }

        if((arg5 & 4) != 0) {
            arg4 = new CanvasDrawScope();
        }

        this(arg1, arg3, arg4);
    }

    public GraphicsLayerV29(long arg1, CanvasHolder arg3, CanvasDrawScope arg4) {
        super();
        this.ownerId = arg1;
        this.canvasHolder = arg3;
        this.canvasDrawScope = arg4;
        RenderNode v1 = new RenderNode("graphicsLayer");
        this.renderNode = v1;
        this.size = Size.Companion.getZero-NH-jbRc();
        v1.setClipToBounds(false);
        this.applyCompositingStrategy-Z1X6vPc(v1, CompositingStrategy.Companion.getAuto-ke2Ky5w());
        this.alpha = 1f;
        this.blendMode = BlendMode.Companion.getSrcOver-0nO6VwU();
        this.pivotOffset = Offset.Companion.getUnspecified-F1C5BW0();
        this.scaleX = 1f;
        this.scaleY = 1f;
        this.ambientShadowColor = Color.Companion.getBlack-0d7_KjU();
        this.spotShadowColor = Color.Companion.getBlack-0d7_KjU();
        this.cameraDistance = 8f;
        this.compositingStrategy = CompositingStrategy.Companion.getAuto-ke2Ky5w();
        this.isInvalidated = true;
    }

    private final void applyClip() {
        boolean v1 = true;
        boolean v0 = !this.getClip() || (this.outlineIsProvided) ? false : true;
        if(!this.getClip() || !this.outlineIsProvided) {
            v1 = false;
        }
        else {
        }

        if(v0 != this.clipToBounds) {
            this.clipToBounds = v0;
            this.renderNode.setClipToBounds(v0);
        }

        if(v1 != this.clipToOutline) {
            this.clipToOutline = v1;
            this.renderNode.setClipToOutline(v1);
        }
    }

    private final void applyCompositingStrategy-Z1X6vPc(RenderNode arg3, int arg4) {
        if(CompositingStrategy.equals-impl0(arg4, CompositingStrategy.Companion.getOffscreen-ke2Ky5w())) {
            arg3.setUseCompositingLayer(true, this.layerPaint);
            arg3.setHasOverlappingRendering(true);
            return;
        }

        boolean v4 = CompositingStrategy.equals-impl0(arg4, CompositingStrategy.Companion.getModulateAlpha-ke2Ky5w());
        Paint v2 = this.layerPaint;
        if(v4) {
            arg3.setUseCompositingLayer(false, v2);
            arg3.setHasOverlappingRendering(false);
            return;
        }

        arg3.setUseCompositingLayer(false, v2);
        arg3.setHasOverlappingRendering(true);
    }

    public Matrix calculateMatrix() {
        Matrix v0 = this.matrix;
        if(v0 == null) {
            v0 = new Matrix();
            this.matrix = v0;
        }

        this.renderNode.getMatrix(v0);
        return v0;
    }

    public void discardDisplayList() {
        this.renderNode.discardDisplayList();
    }

    public void draw(Canvas arg1) {
        AndroidCanvas_androidKt.getNativeCanvas(arg1).drawRenderNode(this.renderNode);
    }

    public float getAlpha() {
        return this.alpha;
    }

    public long getAmbientShadowColor-0d7_KjU() {
        return this.ambientShadowColor;
    }

    public int getBlendMode-0nO6VwU() {
        return this.blendMode;
    }

    public float getCameraDistance() {
        return this.cameraDistance;
    }

    public boolean getClip() {
        return this.clip;
    }

    public ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    public int getCompositingStrategy-ke2Ky5w() {
        return this.compositingStrategy;
    }

    public boolean getHasDisplayList() {
        return this.renderNode.hasDisplayList();
    }

    public long getLayerId() {
        return this.renderNode.getUniqueId();
    }

    public long getOwnerId() {
        return this.ownerId;
    }

    public long getPivotOffset-F1C5BW0() {
        return this.pivotOffset;
    }

    public RenderEffect getRenderEffect() {
        return this.renderEffect;
    }

    public float getRotationX() {
        return this.rotationX;
    }

    public float getRotationY() {
        return this.rotationY;
    }

    public float getRotationZ() {
        return this.rotationZ;
    }

    public float getScaleX() {
        return this.scaleX;
    }

    public float getScaleY() {
        return this.scaleY;
    }

    public float getShadowElevation() {
        return this.shadowElevation;
    }

    public long getSpotShadowColor-0d7_KjU() {
        return this.spotShadowColor;
    }

    public float getTranslationX() {
        return this.translationX;
    }

    public float getTranslationY() {
        return this.translationY;
    }

    public boolean isInvalidated() {
        return this.isInvalidated;
    }

    private final Paint obtainLayerPaint() {
        Paint v0 = this.layerPaint;
        if(v0 == null) {
            v0 = new Paint();
            this.layerPaint = v0;
        }

        return v0;
    }

    public void record(Density arg5, LayoutDirection arg6, GraphicsLayer arg7, Function1 arg8) {
        RecordingCanvas v0 = this.renderNode.beginRecording();
        try {
            CanvasHolder v1 = this.canvasHolder;
            android.graphics.Canvas v2 = v1.getAndroidCanvas().getInternalCanvas();
            v1.getAndroidCanvas().setInternalCanvas(((android.graphics.Canvas)v0));
            AndroidCanvas v0_1 = v1.getAndroidCanvas();
            DrawContext v3 = this.canvasDrawScope.getDrawContext();
            v3.setDensity(arg5);
            v3.setLayoutDirection(arg6);
            v3.setGraphicsLayer(arg7);
            v3.setSize-uvyYCjk(this.size);
            v3.setCanvas(((Canvas)v0_1));
            arg8.invoke(this.canvasDrawScope);
            v1.getAndroidCanvas().setInternalCanvas(v2);
        }
        catch(Throwable v5) {
            this.renderNode.endRecording();
            throw v5;
        }

        this.renderNode.endRecording();
        this.setInvalidated(false);
    }

    private final boolean requiresCompositingLayer() {
        if(!CompositingStrategy.equals-impl0(this.getCompositingStrategy-ke2Ky5w(), CompositingStrategy.Companion.getOffscreen-ke2Ky5w()) && !this.requiresLayerPaint()) {
            if(this.getRenderEffect() != null) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    private final boolean requiresLayerPaint() {
        if(BlendMode.equals-impl0(this.getBlendMode-0nO6VwU(), BlendMode.Companion.getSrcOver-0nO6VwU())) {
            if(this.getColorFilter() != null) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public void setAlpha(float arg1) {
        this.alpha = arg1;
        this.renderNode.setAlpha(arg1);
    }

    public void setAmbientShadowColor-8_81llA(long arg1) {
        this.ambientShadowColor = arg1;
        this.renderNode.setAmbientShadowColor(ColorKt.toArgb-8_81llA(arg1));
    }

    public void setBlendMode-s9anfk8(int arg2) {
        this.blendMode = arg2;
        this.obtainLayerPaint().setBlendMode(AndroidBlendMode_androidKt.toAndroidBlendMode-s9anfk8(arg2));
        this.updateLayerProperties();
    }

    public void setCameraDistance(float arg1) {
        this.cameraDistance = arg1;
        this.renderNode.setCameraDistance(arg1);
    }

    public void setClip(boolean arg1) {
        this.clip = arg1;
        this.applyClip();
    }

    public void setColorFilter(ColorFilter arg2) {
        this.colorFilter = arg2;
        Paint v0 = this.obtainLayerPaint();
        android.graphics.ColorFilter v2 = arg2 != null ? AndroidColorFilter_androidKt.asAndroidColorFilter(arg2) : null;
        v0.setColorFilter(v2);
        this.updateLayerProperties();
    }

    public void setCompositingStrategy-Wpw9cng(int arg1) {
        this.compositingStrategy = arg1;
        this.updateLayerProperties();
    }

    public void setInvalidated(boolean arg1) {
        this.isInvalidated = arg1;
    }

    public void setOutline-O0kMr_c(Outline arg1, long arg2) {
        this.renderNode.setOutline(arg1);
        boolean v1 = arg1 != null ? true : false;
        this.outlineIsProvided = v1;
        this.applyClip();
    }

    public void setPivotOffset-k-4lQ0M(long arg5) {
        this.pivotOffset = arg5;
        int v0 = Long.compare(0x7FFFFFFF7FFFFFFFL & arg5, 0x7FC000007FC00000L);
        RenderNode v1 = this.renderNode;
        if(v0 == 0) {
            v1.resetPivot();
            return;
        }

        v1.setPivotX(Float.intBitsToFloat(((int)(arg5 >> 0x20))));
        this.renderNode.setPivotY(Float.intBitsToFloat(((int)(arg5 & 0xFFFFFFFFL))));
    }

    public void setPosition-H0pRuoY(int arg5, int arg6, long arg7) {
        this.renderNode.setPosition(arg5, arg6, (((int)(arg7 >> 0x20))) + arg5, (((int)(0xFFFFFFFFL & arg7))) + arg6);
        this.size = IntSizeKt.toSize-ozmzZPI(arg7);
    }

    public void setRenderEffect(RenderEffect arg3) {
        this.renderEffect = arg3;
        if(Build$VERSION.SDK_INT >= 0x1F) {
            RenderNodeVerificationHelper.INSTANCE.setRenderEffect(this.renderNode, arg3);
        }
    }

    public void setRotationX(float arg1) {
        this.rotationX = arg1;
        this.renderNode.setRotationX(arg1);
    }

    public void setRotationY(float arg1) {
        this.rotationY = arg1;
        this.renderNode.setRotationY(arg1);
    }

    public void setRotationZ(float arg1) {
        this.rotationZ = arg1;
        this.renderNode.setRotationZ(arg1);
    }

    public void setScaleX(float arg1) {
        this.scaleX = arg1;
        this.renderNode.setScaleX(arg1);
    }

    public void setScaleY(float arg1) {
        this.scaleY = arg1;
        this.renderNode.setScaleY(arg1);
    }

    public void setShadowElevation(float arg1) {
        this.shadowElevation = arg1;
        this.renderNode.setElevation(arg1);
    }

    public void setSpotShadowColor-8_81llA(long arg1) {
        this.spotShadowColor = arg1;
        this.renderNode.setSpotShadowColor(ColorKt.toArgb-8_81llA(arg1));
    }

    public void setTranslationX(float arg1) {
        this.translationX = arg1;
        this.renderNode.setTranslationX(arg1);
    }

    public void setTranslationY(float arg1) {
        this.translationY = arg1;
        this.renderNode.setTranslationY(arg1);
    }

    private final void updateLayerProperties() {
        boolean v0 = this.requiresCompositingLayer();
        RenderNode v1 = this.renderNode;
        if(v0) {
            this.applyCompositingStrategy-Z1X6vPc(v1, CompositingStrategy.Companion.getOffscreen-ke2Ky5w());
            return;
        }

        this.applyCompositingStrategy-Z1X6vPc(v1, this.getCompositingStrategy-ke2Ky5w());
    }
}

