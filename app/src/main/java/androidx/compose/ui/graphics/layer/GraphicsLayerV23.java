package androidx.compose.ui.graphics.layer;

import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.os.Build$VERSION;
import android.view.DisplayListCanvas;
import android.view.RenderNode;
import android.view.View;
import androidx.compose.ui.geometry.Offset;
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
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u001B\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u0000 \u0092\u00012\u00020\u0001:\u0002\u0092\u0001B+\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007\u0012\b\b\u0002\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BJ\b\u0010\u001A\u001A\u00020\u0014H\u0002J\u0017\u0010#\u001A\u00020$2\u0006\u0010\u001D\u001A\u00020\u001CH\u0002¢\u0006\u0004\b%\u0010!J\b\u0010*\u001A\u00020\u0018H\u0002J\b\u0010+\u001A\u00020$H\u0002J\b\u0010g\u001A\u00020$H\u0002J\'\u0010n\u001A\u00020$2\u0006\u0010o\u001A\u00020p2\u0006\u0010q\u001A\u00020p2\u0006\u0010\u0010\u001A\u00020\u0011H\u0016¢\u0006\u0004\br\u0010sJ!\u0010t\u001A\u00020$2\b\u0010u\u001A\u0004\u0018\u00010v2\u0006\u0010\u0019\u001A\u00020\u0011H\u0016¢\u0006\u0004\bw\u0010xJA\u0010}\u001A\u00020$2\u0006\u0010~\u001A\u00020\u007F2\b\u0010\u0080\u0001\u001A\u00030\u0081\u00012\b\u0010\u0082\u0001\u001A\u00030\u0083\u00012\u001B\u0010\u0084\u0001\u001A\u0016\u0012\u0005\u0012\u00030\u0086\u0001\u0012\u0004\u0012\u00020$0\u0085\u0001¢\u0006\u0003\b\u0087\u0001H\u0016J\u0013\u0010\u0088\u0001\u001A\u00020$2\b\u0010\u0089\u0001\u001A\u00030\u008A\u0001H\u0016J\t\u0010\u008B\u0001\u001A\u00020\u0016H\u0016J\t\u0010\u008C\u0001\u001A\u00020$H\u0016J\u0011\u0010\u008F\u0001\u001A\u00020$2\u0006\u0010\u000E\u001A\u00020\u000FH\u0002J\u000F\u0010\u0090\u0001\u001A\u00020$H\u0000¢\u0006\u0003\b\u0091\u0001R\u0014\u0010\u0004\u001A\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u000FX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001A\u00020\u0011X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\u0013\u001A\u0004\u0018\u00010\u0014X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001A\u0004\u0018\u00010\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0017\u001A\u00020\u0018X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001A\u00020\u0011X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0012R&\u0010\u001D\u001A\u00020\u001C2\u0006\u0010\u001B\u001A\u00020\u001C@VX\u0096\u000E¢\u0006\u0010\n\u0002\u0010\"\u001A\u0004\b\u001E\u0010\u001F\"\u0004\b \u0010!R&\u0010\'\u001A\u00020&2\u0006\u0010\u001B\u001A\u00020&@VX\u0096\u000E¢\u0006\u0010\n\u0002\u0010\"\u001A\u0004\b(\u0010\u001F\"\u0004\b)\u0010!R(\u0010-\u001A\u0004\u0018\u00010,2\b\u0010\u001B\u001A\u0004\u0018\u00010,@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b.\u0010/\"\u0004\b0\u00101R$\u00103\u001A\u0002022\u0006\u0010\u001B\u001A\u000202@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b4\u00105\"\u0004\b6\u00107R\u000E\u00108\u001A\u00020\u0018X\u0082\u000E¢\u0006\u0002\n\u0000R&\u0010:\u001A\u0002092\u0006\u0010\u001B\u001A\u000209@VX\u0096\u000E¢\u0006\u0010\n\u0002\u0010\u0012\u001A\u0004\b;\u0010\r\"\u0004\b<\u0010=R$\u0010>\u001A\u0002022\u0006\u0010\u001B\u001A\u000202@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b?\u00105\"\u0004\b@\u00107R$\u0010A\u001A\u0002022\u0006\u0010\u001B\u001A\u000202@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bB\u00105\"\u0004\bC\u00107R$\u0010D\u001A\u0002022\u0006\u0010\u001B\u001A\u000202@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bE\u00105\"\u0004\bF\u00107R$\u0010G\u001A\u0002022\u0006\u0010\u001B\u001A\u000202@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bH\u00105\"\u0004\bI\u00107R$\u0010J\u001A\u0002022\u0006\u0010\u001B\u001A\u000202@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bK\u00105\"\u0004\bL\u00107R&\u0010N\u001A\u00020M2\u0006\u0010\u001B\u001A\u00020M@VX\u0096\u000E¢\u0006\u0010\n\u0002\u0010\u0012\u001A\u0004\bO\u0010\r\"\u0004\bP\u0010=R&\u0010Q\u001A\u00020M2\u0006\u0010\u001B\u001A\u00020M@VX\u0096\u000E¢\u0006\u0010\n\u0002\u0010\u0012\u001A\u0004\bR\u0010\r\"\u0004\bS\u0010=R$\u0010T\u001A\u0002022\u0006\u0010\u001B\u001A\u000202@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bU\u00105\"\u0004\bV\u00107R$\u0010W\u001A\u0002022\u0006\u0010\u001B\u001A\u000202@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bX\u00105\"\u0004\bY\u00107R$\u0010Z\u001A\u0002022\u0006\u0010\u001B\u001A\u000202@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b[\u00105\"\u0004\b\\\u00107R$\u0010]\u001A\u0002022\u0006\u0010\u001B\u001A\u000202@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b^\u00105\"\u0004\b_\u00107R$\u0010`\u001A\u00020\u00182\u0006\u0010\u001B\u001A\u00020\u0018@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\ba\u0010b\"\u0004\bc\u0010dR\u000E\u0010e\u001A\u00020\u0018X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010f\u001A\u00020\u0018X\u0082\u000E¢\u0006\u0002\n\u0000R\u001C\u0010h\u001A\u0004\u0018\u00010iX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bj\u0010k\"\u0004\bl\u0010mR\u001A\u0010y\u001A\u00020\u0018X\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\by\u0010b\"\u0004\bz\u0010dR\u0014\u0010{\u001A\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b|\u0010bR\u0016\u0010\u008D\u0001\u001A\u00020\u0005X\u0096D¢\u0006\t\n\u0000\u001A\u0005\b\u008E\u0001\u0010\r¨\u0006\u0093\u0001"}, d2={"Landroidx/compose/ui/graphics/layer/GraphicsLayerV23;", "Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl;", "ownerView", "Landroid/view/View;", "ownerId", "", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "canvasDrawScope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "<init>", "(Landroid/view/View;JLandroidx/compose/ui/graphics/CanvasHolder;Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;)V", "getOwnerId", "()J", "renderNode", "Landroid/view/RenderNode;", "size", "Landroidx/compose/ui/unit/IntSize;", "J", "layerPaint", "Landroid/graphics/Paint;", "matrix", "Landroid/graphics/Matrix;", "outlineIsProvided", "", "outlineSize", "obtainLayerPaint", "value", "Landroidx/compose/ui/graphics/layer/CompositingStrategy;", "compositingStrategy", "getCompositingStrategy-ke2Ky5w", "()I", "setCompositingStrategy-Wpw9cng", "(I)V", "I", "applyCompositingStrategy", "", "applyCompositingStrategy-Wpw9cng", "Landroidx/compose/ui/graphics/BlendMode;", "blendMode", "getBlendMode-0nO6VwU", "setBlendMode-s9anfk8", "requiresCompositingLayer", "updateLayerProperties", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "", "alpha", "getAlpha", "()F", "setAlpha", "(F)V", "shouldManuallySetCenterPivot", "Landroidx/compose/ui/geometry/Offset;", "pivotOffset", "getPivotOffset-F1C5BW0", "setPivotOffset-k-4lQ0M", "(J)V", "scaleX", "getScaleX", "setScaleX", "scaleY", "getScaleY", "setScaleY", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "shadowElevation", "getShadowElevation", "setShadowElevation", "Landroidx/compose/ui/graphics/Color;", "ambientShadowColor", "getAmbientShadowColor-0d7_KjU", "setAmbientShadowColor-8_81llA", "spotShadowColor", "getSpotShadowColor-0d7_KjU", "setSpotShadowColor-8_81llA", "rotationX", "getRotationX", "setRotationX", "rotationY", "getRotationY", "setRotationY", "rotationZ", "getRotationZ", "setRotationZ", "cameraDistance", "getCameraDistance", "setCameraDistance", "clip", "getClip", "()Z", "setClip", "(Z)V", "clipToBounds", "clipToOutline", "applyClip", "renderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "setPosition", "x", "", "y", "setPosition-H0pRuoY", "(IIJ)V", "setOutline", "outline", "Landroid/graphics/Outline;", "setOutline-O0kMr_c", "(Landroid/graphics/Outline;J)V", "isInvalidated", "setInvalidated", "hasDisplayList", "getHasDisplayList", "record", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "layer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Lkotlin/ExtensionFunctionType;", "draw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "calculateMatrix", "discardDisplayList", "layerId", "getLayerId", "verifyShadowColorProperties", "discardDisplayListInternal", "discardDisplayListInternal$ui_graphics", "Companion", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class GraphicsLayerV23 implements GraphicsLayerImpl {
    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001A\u0010\u0004\u001A\u00020\u0005X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2={"Landroidx/compose/ui/graphics/layer/GraphicsLayerV23$Companion;", "", "<init>", "()V", "testFailCreateRenderNode", "", "getTestFailCreateRenderNode$ui_graphics", "()Z", "setTestFailCreateRenderNode$ui_graphics", "(Z)V", "needToValidateAccess", "Ljava/util/concurrent/atomic/AtomicBoolean;", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final boolean getTestFailCreateRenderNode$ui_graphics() {
            return GraphicsLayerV23.testFailCreateRenderNode;
        }

        public final void setTestFailCreateRenderNode$ui_graphics(boolean arg1) {
            GraphicsLayerV23.testFailCreateRenderNode = arg1;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
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
    private final long layerId;
    private Paint layerPaint;
    private Matrix matrix;
    private static final AtomicBoolean needToValidateAccess;
    private boolean outlineIsProvided;
    private long outlineSize;
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
    private boolean shouldManuallySetCenterPivot;
    private long size;
    private long spotShadowColor;
    private static boolean testFailCreateRenderNode;
    private float translationX;
    private float translationY;

    static {
        GraphicsLayerV23.Companion = new Companion(null);
        GraphicsLayerV23.$stable = 8;
        GraphicsLayerV23.needToValidateAccess = new AtomicBoolean(true);
    }

    public GraphicsLayerV23(View arg7, long arg8, CanvasHolder arg10, CanvasDrawScope arg11, int arg12, DefaultConstructorMarker arg13) {
        if((arg12 & 4) != 0) {
            arg10 = new CanvasHolder();
        }

        CanvasHolder v4 = arg10;
        if((arg12 & 8) != 0) {
            arg11 = new CanvasDrawScope();
        }

        this(arg7, arg8, v4, arg11);
    }

    public GraphicsLayerV23(View arg1, long arg2, CanvasHolder arg4, CanvasDrawScope arg5) {
        super();
        this.ownerId = arg2;
        this.canvasHolder = arg4;
        this.canvasDrawScope = arg5;
        RenderNode v1 = RenderNode.create("Compose", arg1);
        this.renderNode = v1;
        this.size = IntSize.Companion.getZero-YbymL2g();
        this.outlineSize = IntSize.Companion.getZero-YbymL2g();
        if(GraphicsLayerV23.needToValidateAccess.getAndSet(false)) {
            v1.setScaleX(v1.getScaleX());
            v1.setScaleY(v1.getScaleY());
            v1.setTranslationX(v1.getTranslationX());
            v1.setTranslationY(v1.getTranslationY());
            v1.setElevation(v1.getElevation());
            v1.setRotation(v1.getRotation());
            v1.setRotationX(v1.getRotationX());
            v1.setRotationY(v1.getRotationY());
            v1.setCameraDistance(v1.getCameraDistance());
            v1.setPivotX(v1.getPivotX());
            v1.setPivotY(v1.getPivotY());
            v1.setClipToOutline(v1.getClipToOutline());
            v1.setClipToBounds(false);
            v1.setAlpha(v1.getAlpha());
            v1.isValid();
            v1.setLeftTopRightBottom(0, 0, 0, 0);
            v1.offsetLeftAndRight(0);
            v1.offsetTopAndBottom(0);
            this.verifyShadowColorProperties(v1);
            this.discardDisplayListInternal$ui_graphics();
            v1.setLayerType(0);
            v1.setHasOverlappingRendering(v1.hasOverlappingRendering());
        }

        if(!GraphicsLayerV23.testFailCreateRenderNode) {
            v1.setClipToBounds(false);
            this.applyCompositingStrategy-Wpw9cng(CompositingStrategy.Companion.getAuto-ke2Ky5w());
            this.compositingStrategy = CompositingStrategy.Companion.getAuto-ke2Ky5w();
            this.blendMode = BlendMode.Companion.getSrcOver-0nO6VwU();
            this.alpha = 1f;
            this.pivotOffset = Offset.Companion.getUnspecified-F1C5BW0();
            this.scaleX = 1f;
            this.scaleY = 1f;
            this.ambientShadowColor = Color.Companion.getBlack-0d7_KjU();
            this.spotShadowColor = Color.Companion.getBlack-0d7_KjU();
            this.cameraDistance = 8f;
            this.isInvalidated = true;
            return;
        }

        throw new NoClassDefFoundError();
    }

    public static final boolean access$getTestFailCreateRenderNode$cp() {
        return GraphicsLayerV23.testFailCreateRenderNode;
    }

    public static final void access$setTestFailCreateRenderNode$cp(boolean arg0) {
        GraphicsLayerV23.testFailCreateRenderNode = arg0;
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

    private final void applyCompositingStrategy-Wpw9cng(int arg4) {
        RenderNode v0 = this.renderNode;
        if(CompositingStrategy.equals-impl0(arg4, CompositingStrategy.Companion.getOffscreen-ke2Ky5w())) {
            v0.setLayerType(2);
            v0.setLayerPaint(this.layerPaint);
            v0.setHasOverlappingRendering(true);
            return;
        }

        if(CompositingStrategy.equals-impl0(arg4, CompositingStrategy.Companion.getModulateAlpha-ke2Ky5w())) {
            v0.setLayerType(0);
            v0.setLayerPaint(this.layerPaint);
            v0.setHasOverlappingRendering(false);
            return;
        }

        v0.setLayerType(0);
        v0.setLayerPaint(this.layerPaint);
        v0.setHasOverlappingRendering(true);
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
        this.discardDisplayListInternal$ui_graphics();
    }

    public final void discardDisplayListInternal$ui_graphics() {
        RenderNodeVerificationHelper24.INSTANCE.discardDisplayList(this.renderNode);
    }

    public void draw(Canvas arg2) {
        android.graphics.Canvas v2 = AndroidCanvas_androidKt.getNativeCanvas(arg2);
        Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type android.view.DisplayListCanvas");
        ((DisplayListCanvas)v2).drawRenderNode(this.renderNode);
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
        return this.renderNode.isValid();
    }

    public long getLayerId() {
        return this.layerId;
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

    public void record(Density arg17, LayoutDirection arg18, GraphicsLayer arg19, Function1 arg20) {
        Function1 v6_1;
        GraphicsLayer v13;
        long v11;
        Canvas v10;
        LayoutDirection v9;
        Density v8;
        CanvasDrawScope v5;
        AndroidCanvas v3;
        android.graphics.Canvas v4;
        CanvasHolder v0_1;
        GraphicsLayerV23 v1 = this;
        DisplayListCanvas v2 = v1.renderNode.start(Math.max(((int)(v1.size >> 0x20)), ((int)(v1.outlineSize >> 0x20))), Math.max(((int)(v1.size & 0xFFFFFFFFL)), ((int)(v1.outlineSize & 0xFFFFFFFFL))));
        try {
            v0_1 = v1.canvasHolder;
            v4 = v0_1.getAndroidCanvas().getInternalCanvas();
            v0_1.getAndroidCanvas().setInternalCanvas(v2);
            v3 = v0_1.getAndroidCanvas();
            v5 = v1.canvasDrawScope;
            long v6 = IntSizeKt.toSize-ozmzZPI(v1.size);
            v8 = ((DrawScope)v5).getDrawContext().getDensity();
            v9 = ((DrawScope)v5).getDrawContext().getLayoutDirection();
            v10 = ((DrawScope)v5).getDrawContext().getCanvas();
            v11 = ((DrawScope)v5).getDrawContext().getSize-NH-jbRc();
            v13 = ((DrawScope)v5).getDrawContext().getGraphicsLayer();
            DrawContext v14 = ((DrawScope)v5).getDrawContext();
            v14.setDensity(arg17);
            v14.setLayoutDirection(arg18);
            v14.setCanvas(((Canvas)v3));
            v14.setSize-uvyYCjk(v6);
            v14.setGraphicsLayer(arg19);
            ((Canvas)v3).save();
            v6_1 = arg20;
        }
        catch(Throwable v0) {
            goto label_76;
        }

        try {
            v6_1.invoke(v5);
            goto label_51;
        }
        catch(Throwable v0) {
            try {
                ((Canvas)v3).restore();
                DrawContext v3_1 = ((DrawScope)v5).getDrawContext();
                v3_1.setDensity(v8);
                v3_1.setLayoutDirection(v9);
                v3_1.setCanvas(v10);
                v3_1.setSize-uvyYCjk(v11);
                v3_1.setGraphicsLayer(v13);
                throw v0;
            label_51:
                ((Canvas)v3).restore();
                v3_1 = ((DrawScope)v5).getDrawContext();
                v3_1.setDensity(v8);
                v3_1.setLayoutDirection(v9);
                v3_1.setCanvas(v10);
                v3_1.setSize-uvyYCjk(v11);
                v3_1.setGraphicsLayer(v13);
                v0_1.getAndroidCanvas().setInternalCanvas(v4);
            }
            catch(Throwable v0) {
            label_76:
                v1.renderNode.end(v2);
                throw v0;
            }
        }

        v1.renderNode.end(v2);
        v1.setInvalidated(false);
    }

    private final boolean requiresCompositingLayer() {
        if(!CompositingStrategy.equals-impl0(this.getCompositingStrategy-ke2Ky5w(), CompositingStrategy.Companion.getOffscreen-ke2Ky5w()) && (BlendMode.equals-impl0(this.getBlendMode-0nO6VwU(), BlendMode.Companion.getSrcOver-0nO6VwU()))) {
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

    public void setAmbientShadowColor-8_81llA(long arg3) {
        if(Build$VERSION.SDK_INT >= 28) {
            this.ambientShadowColor = arg3;
            RenderNodeVerificationHelper28.INSTANCE.setAmbientShadowColor(this.renderNode, ColorKt.toArgb-8_81llA(arg3));
        }
    }

    public void setBlendMode-s9anfk8(int arg3) {
        if(!BlendMode.equals-impl0(this.blendMode, arg3)) {
            this.blendMode = arg3;
            this.obtainLayerPaint().setXfermode(new PorterDuffXfermode(AndroidBlendMode_androidKt.toPorterDuffMode-s9anfk8(arg3)));
            this.updateLayerProperties();
        }
    }

    public void setCameraDistance(float arg1) {
        this.cameraDistance = arg1;
        this.renderNode.setCameraDistance(-arg1);
    }

    public void setClip(boolean arg1) {
        this.clip = arg1;
        this.applyClip();
    }

    public void setColorFilter(ColorFilter arg2) {
        this.colorFilter = arg2;
        if(arg2 != null) {
            this.applyCompositingStrategy-Wpw9cng(CompositingStrategy.Companion.getOffscreen-ke2Ky5w());
            RenderNode v0 = this.renderNode;
            Paint v1 = this.obtainLayerPaint();
            v1.setColorFilter(AndroidColorFilter_androidKt.asAndroidColorFilter(arg2));
            v0.setLayerPaint(v1);
            return;
        }

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
        this.outlineSize = arg2;
        this.renderNode.setOutline(arg1);
        boolean v1 = arg1 != null ? true : false;
        this.outlineIsProvided = v1;
        this.applyClip();
    }

    public void setPivotOffset-k-4lQ0M(long arg7) {
        this.pivotOffset = arg7;
        long v1 = 0xFFFFFFFFL;
        int v3 = 0x20;
        if(Long.compare(0x7FFFFFFF7FFFFFFFL & arg7, 0x7FC000007FC00000L) == 0) {
            this.shouldManuallySetCenterPivot = true;
            this.renderNode.setPivotX((((float)(((int)(this.size >> v3))))) / 2f);
            this.renderNode.setPivotY((((float)(((int)(v1 & this.size))))) / 2f);
            return;
        }

        this.shouldManuallySetCenterPivot = false;
        this.renderNode.setPivotX(Float.intBitsToFloat(((int)(arg7 >> v3))));
        this.renderNode.setPivotY(Float.intBitsToFloat(((int)(arg7 & v1))));
    }

    public void setPosition-H0pRuoY(int arg6, int arg7, long arg8) {
        int v1 = ((int)(arg8 >> 0x20));
        int v3 = ((int)(0xFFFFFFFFL & arg8));
        this.renderNode.setLeftTopRightBottom(arg6, arg7, arg6 + v1, arg7 + v3);
        if(!IntSize.equals-impl0(this.size, arg8)) {
            if(this.shouldManuallySetCenterPivot) {
                this.renderNode.setPivotX((((float)v1)) / 2f);
                this.renderNode.setPivotY((((float)v3)) / 2f);
            }

            this.size = arg8;
        }
    }

    public void setRenderEffect(RenderEffect arg1) {
        this.renderEffect = arg1;
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
        this.renderNode.setRotation(arg1);
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

    public void setSpotShadowColor-8_81llA(long arg3) {
        if(Build$VERSION.SDK_INT >= 28) {
            this.spotShadowColor = arg3;
            RenderNodeVerificationHelper28.INSTANCE.setSpotShadowColor(this.renderNode, ColorKt.toArgb-8_81llA(arg3));
        }
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
        if(this.requiresCompositingLayer()) {
            this.applyCompositingStrategy-Wpw9cng(CompositingStrategy.Companion.getOffscreen-ke2Ky5w());
            return;
        }

        this.applyCompositingStrategy-Wpw9cng(this.getCompositingStrategy-ke2Ky5w());
    }

    private final void verifyShadowColorProperties(RenderNode arg2) {
        if(Build$VERSION.SDK_INT >= 28) {
            RenderNodeVerificationHelper28.INSTANCE.setAmbientShadowColor(arg2, RenderNodeVerificationHelper28.INSTANCE.getAmbientShadowColor(arg2));
            RenderNodeVerificationHelper28.INSTANCE.setSpotShadowColor(arg2, RenderNodeVerificationHelper28.INSTANCE.getSpotShadowColor(arg2));
        }
    }
}

