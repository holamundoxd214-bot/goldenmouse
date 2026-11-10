package androidx.compose.ui.platform;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.RecordingCanvas;
import android.graphics.RenderNode;
import android.os.Build$VERSION;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.CompositingStrategy;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RenderEffect;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000\u009C\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b5\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0011\u001A\u00020\u0012H\u0000¢\u0006\u0002\b\u0013J\r\u0010\u0014\u001A\u00020\u0012H\u0000¢\u0006\u0002\b\u0015J\b\u0010q\u001A\u00020rH\u0002J\b\u0010s\u001A\u00020\u0012H\u0002J\b\u0010t\u001A\u00020\u0012H\u0002J\b\u0010u\u001A\u00020\u0010H\u0002J\u001B\u0010v\u001A\u00020r*\u00020\t2\u0006\u0010n\u001A\u00020\rH\u0002¢\u0006\u0004\bw\u0010xJ\u0012\u0010{\u001A\u00020r2\b\u0010|\u001A\u0004\u0018\u00010}H\u0016J(\u0010~\u001A\u00020\u00122\u0006\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u001E\u001A\u00020\u001B2\u0006\u0010 \u001A\u00020\u001B2\u0006\u0010\"\u001A\u00020\u001BH\u0016J\u0011\u0010\u007F\u001A\u00020r2\u0007\u0010\u0080\u0001\u001A\u00020\u001BH\u0016J\u0012\u0010\u0081\u0001\u001A\u00020r2\u0007\u0010\u0080\u0001\u001A\u00020\u001BH\u0016J6\u0010\u0082\u0001\u001A\u00020r2\b\u0010\u0083\u0001\u001A\u00030\u0084\u00012\n\u0010\u0085\u0001\u001A\u0005\u0018\u00010\u0086\u00012\u0015\u0010\u0087\u0001\u001A\u0010\u0012\u0005\u0012\u00030\u0089\u0001\u0012\u0004\u0012\u00020r0\u0088\u0001H\u0016J\u0013\u0010\u008A\u0001\u001A\u00020r2\b\u0010\u008B\u0001\u001A\u00030\u008C\u0001H\u0016J\u0013\u0010\u008D\u0001\u001A\u00020r2\b\u0010\u008B\u0001\u001A\u00030\u008C\u0001H\u0016J\u0013\u0010\u008E\u0001\u001A\u00020r2\b\u0010\u008F\u0001\u001A\u00030\u0090\u0001H\u0016J\u0011\u0010\u0091\u0001\u001A\u00020\u00122\u0006\u0010\u0014\u001A\u00020\u0012H\u0016J\n\u0010\u0092\u0001\u001A\u00030\u0093\u0001H\u0016J\t\u0010\u0094\u0001\u001A\u00020rH\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001A\u0004\u0018\u00010\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001A\u00020\rX\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u000ER\u0010\u0010\u000F\u001A\u0004\u0018\u00010\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001A\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001A\u001A\u00020\u001B8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001C\u0010\u001DR\u0014\u0010\u001E\u001A\u00020\u001B8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001F\u0010\u001DR\u0014\u0010 \u001A\u00020\u001B8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b!\u0010\u001DR\u0014\u0010\"\u001A\u00020\u001B8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b#\u0010\u001DR\u0014\u0010$\u001A\u00020\u001B8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b%\u0010\u001DR\u0014\u0010&\u001A\u00020\u001B8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\'\u0010\u001DR$\u0010*\u001A\u00020)2\u0006\u0010(\u001A\u00020)8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u0010/\u001A\u00020)2\u0006\u0010(\u001A\u00020)8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b0\u0010,\"\u0004\b1\u0010.R$\u00102\u001A\u00020)2\u0006\u0010(\u001A\u00020)8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b3\u0010,\"\u0004\b4\u0010.R$\u00105\u001A\u00020)2\u0006\u0010(\u001A\u00020)8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b6\u0010,\"\u0004\b7\u0010.R$\u00108\u001A\u00020)2\u0006\u0010(\u001A\u00020)8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b9\u0010,\"\u0004\b:\u0010.R$\u0010;\u001A\u00020\u001B2\u0006\u0010(\u001A\u00020\u001B8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b<\u0010\u001D\"\u0004\b=\u0010>R$\u0010?\u001A\u00020\u001B2\u0006\u0010(\u001A\u00020\u001B8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b@\u0010\u001D\"\u0004\bA\u0010>R$\u0010B\u001A\u00020)2\u0006\u0010(\u001A\u00020)8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\bC\u0010,\"\u0004\bD\u0010.R$\u0010E\u001A\u00020)2\u0006\u0010(\u001A\u00020)8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\bF\u0010,\"\u0004\bG\u0010.R$\u0010H\u001A\u00020)2\u0006\u0010(\u001A\u00020)8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\bI\u0010,\"\u0004\bJ\u0010.R$\u0010K\u001A\u00020)2\u0006\u0010(\u001A\u00020)8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\bL\u0010,\"\u0004\bM\u0010.R$\u0010N\u001A\u00020)2\u0006\u0010(\u001A\u00020)8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\bO\u0010,\"\u0004\bP\u0010.R$\u0010Q\u001A\u00020)2\u0006\u0010(\u001A\u00020)8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\bR\u0010,\"\u0004\bS\u0010.R$\u0010T\u001A\u00020\u00122\u0006\u0010(\u001A\u00020\u00128V@VX\u0096\u000E¢\u0006\f\u001A\u0004\bU\u0010V\"\u0004\bW\u0010XR$\u0010Y\u001A\u00020\u00122\u0006\u0010(\u001A\u00020\u00128V@VX\u0096\u000E¢\u0006\f\u001A\u0004\bZ\u0010V\"\u0004\b[\u0010XR$\u0010\\\u001A\u00020)2\u0006\u0010(\u001A\u00020)8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b]\u0010,\"\u0004\b^\u0010.R&\u0010`\u001A\u00020_2\u0006\u0010(\u001A\u00020_@VX\u0096\u000E¢\u0006\u0010\n\u0002\u0010\u000E\u001A\u0004\ba\u0010\u001D\"\u0004\bb\u0010>R(\u0010d\u001A\u0004\u0018\u00010c2\b\u0010(\u001A\u0004\u0018\u00010c@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\be\u0010f\"\u0004\bg\u0010hR(\u0010i\u001A\u0004\u0018\u00010\u000B2\b\u0010(\u001A\u0004\u0018\u00010\u000B8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\bj\u0010k\"\u0004\bl\u0010mR$\u0010n\u001A\u00020\r2\u0006\u0010(\u001A\u00020\r8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\bo\u0010\u001D\"\u0004\bp\u0010>R\u0014\u0010y\u001A\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001A\u0004\bz\u0010V¨\u0006\u0095\u0001"}, d2={"Landroidx/compose/ui/platform/RenderNodeApi29;", "Landroidx/compose/ui/platform/DeviceRenderNode;", "ownerView", "Landroidx/compose/ui/platform/AndroidComposeView;", "<init>", "(Landroidx/compose/ui/platform/AndroidComposeView;)V", "getOwnerView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "renderNode", "Landroid/graphics/RenderNode;", "internalRenderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "internalCompositingStrategy", "Landroidx/compose/ui/graphics/CompositingStrategy;", "I", "layerPaint", "Landroidx/compose/ui/graphics/Paint;", "isUsingCompositingLayer", "", "isUsingCompositingLayer$ui", "hasOverlappingRendering", "hasOverlappingRendering$ui", "uniqueId", "", "getUniqueId", "()J", "left", "", "getLeft", "()I", "top", "getTop", "right", "getRight", "bottom", "getBottom", "width", "getWidth", "height", "getHeight", "value", "", "scaleX", "getScaleX", "()F", "setScaleX", "(F)V", "scaleY", "getScaleY", "setScaleY", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "elevation", "getElevation", "setElevation", "ambientShadowColor", "getAmbientShadowColor", "setAmbientShadowColor", "(I)V", "spotShadowColor", "getSpotShadowColor", "setSpotShadowColor", "rotationZ", "getRotationZ", "setRotationZ", "rotationX", "getRotationX", "setRotationX", "rotationY", "getRotationY", "setRotationY", "cameraDistance", "getCameraDistance", "setCameraDistance", "pivotX", "getPivotX", "setPivotX", "pivotY", "getPivotY", "setPivotY", "clipToOutline", "getClipToOutline", "()Z", "setClipToOutline", "(Z)V", "clipToBounds", "getClipToBounds", "setClipToBounds", "alpha", "getAlpha", "setAlpha", "Landroidx/compose/ui/graphics/BlendMode;", "blendMode", "getBlendMode-0nO6VwU", "setBlendMode-s9anfk8", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "renderEffect", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "compositingStrategy", "getCompositingStrategy--NrFUSI", "setCompositingStrategy-aDBOjCE", "updateLayerProperties", "", "requiresCompositingLayer", "requiresLayerPaint", "obtainLayerPaint", "applyCompositingStrategy", "applyCompositingStrategy-Qu9p0E8", "(Landroid/graphics/RenderNode;I)V", "hasDisplayList", "getHasDisplayList", "setOutline", "outline", "Landroid/graphics/Outline;", "setPosition", "offsetLeftAndRight", "offset", "offsetTopAndBottom", "record", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "clipPath", "Landroidx/compose/ui/graphics/Path;", "drawBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Canvas;", "getMatrix", "matrix", "Landroid/graphics/Matrix;", "getInverseMatrix", "drawInto", "canvas", "Landroid/graphics/Canvas;", "setHasOverlappingRendering", "dumpRenderNodeData", "Landroidx/compose/ui/platform/DeviceRenderNodeData;", "discardDisplayList", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class RenderNodeApi29 implements DeviceRenderNode {
    public static final int $stable = 8;
    private int blendMode;
    private ColorFilter colorFilter;
    private int internalCompositingStrategy;
    private RenderEffect internalRenderEffect;
    private Paint layerPaint;
    private final AndroidComposeView ownerView;
    private final RenderNode renderNode;

    static {
    }

    public RenderNodeApi29(AndroidComposeView arg2) {
        super();
        this.ownerView = arg2;
        this.renderNode = new RenderNode("Compose");
        this.internalCompositingStrategy = CompositingStrategy.Companion.getAuto--NrFUSI();
        this.blendMode = BlendMode.Companion.getSrcOver-0nO6VwU();
    }

    private final void applyCompositingStrategy-Qu9p0E8(RenderNode arg4, int arg5) {
        android.graphics.Paint v1 = null;
        if(CompositingStrategy.equals-impl0(arg5, CompositingStrategy.Companion.getOffscreen--NrFUSI())) {
            Paint v3 = this.layerPaint;
            if(v3 != null) {
                v1 = v3.asFrameworkPaint();
            }

            arg4.setUseCompositingLayer(true, v1);
            arg4.setHasOverlappingRendering(true);
            return;
        }

        if(CompositingStrategy.equals-impl0(arg5, CompositingStrategy.Companion.getModulateAlpha--NrFUSI())) {
            arg4.setUseCompositingLayer(false, v1);
            arg4.setHasOverlappingRendering(false);
            return;
        }

        arg4.setUseCompositingLayer(false, v1);
        arg4.setHasOverlappingRendering(true);
    }

    public void discardDisplayList() {
        this.renderNode.discardDisplayList();
    }

    public void drawInto(Canvas arg1) {
        arg1.drawRenderNode(this.renderNode);
    }

    public DeviceRenderNodeData dumpRenderNodeData() {
        return new DeviceRenderNodeData(this.renderNode.getUniqueId(), this.renderNode.getLeft(), this.renderNode.getTop(), this.renderNode.getRight(), this.renderNode.getBottom(), this.renderNode.getWidth(), this.renderNode.getHeight(), this.renderNode.getScaleX(), this.renderNode.getScaleY(), this.renderNode.getTranslationX(), this.renderNode.getTranslationY(), this.renderNode.getElevation(), this.renderNode.getAmbientShadowColor(), this.renderNode.getSpotShadowColor(), this.renderNode.getRotationZ(), this.renderNode.getRotationX(), this.renderNode.getRotationY(), this.renderNode.getCameraDistance(), this.renderNode.getPivotX(), this.renderNode.getPivotY(), this.renderNode.getClipToOutline(), this.renderNode.getClipToBounds(), this.renderNode.getAlpha(), this.internalRenderEffect, this.getBlendMode-0nO6VwU(), this.getColorFilter(), this.internalCompositingStrategy, null);
    }

    public float getAlpha() {
        return this.renderNode.getAlpha();
    }

    public int getAmbientShadowColor() {
        return this.renderNode.getAmbientShadowColor();
    }

    public int getBlendMode-0nO6VwU() {
        return this.blendMode;
    }

    public int getBottom() {
        return this.renderNode.getBottom();
    }

    public float getCameraDistance() {
        return this.renderNode.getCameraDistance();
    }

    public boolean getClipToBounds() {
        return this.renderNode.getClipToBounds();
    }

    public boolean getClipToOutline() {
        return this.renderNode.getClipToOutline();
    }

    public ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    public int getCompositingStrategy--NrFUSI() {
        return this.internalCompositingStrategy;
    }

    public float getElevation() {
        return this.renderNode.getElevation();
    }

    public boolean getHasDisplayList() {
        return this.renderNode.hasDisplayList();
    }

    public int getHeight() {
        return this.renderNode.getHeight();
    }

    public void getInverseMatrix(Matrix arg1) {
        this.renderNode.getInverseMatrix(arg1);
    }

    public int getLeft() {
        return this.renderNode.getLeft();
    }

    public void getMatrix(Matrix arg1) {
        this.renderNode.getMatrix(arg1);
    }

    public final AndroidComposeView getOwnerView() {
        return this.ownerView;
    }

    public float getPivotX() {
        return this.renderNode.getPivotX();
    }

    public float getPivotY() {
        return this.renderNode.getPivotY();
    }

    public RenderEffect getRenderEffect() {
        return this.internalRenderEffect;
    }

    public int getRight() {
        return this.renderNode.getRight();
    }

    public float getRotationX() {
        return this.renderNode.getRotationX();
    }

    public float getRotationY() {
        return this.renderNode.getRotationY();
    }

    public float getRotationZ() {
        return this.renderNode.getRotationZ();
    }

    public float getScaleX() {
        return this.renderNode.getScaleX();
    }

    public float getScaleY() {
        return this.renderNode.getScaleY();
    }

    public int getSpotShadowColor() {
        return this.renderNode.getSpotShadowColor();
    }

    public int getTop() {
        return this.renderNode.getTop();
    }

    public float getTranslationX() {
        return this.renderNode.getTranslationX();
    }

    public float getTranslationY() {
        return this.renderNode.getTranslationY();
    }

    public long getUniqueId() {
        return this.renderNode.getUniqueId();
    }

    public int getWidth() {
        return this.renderNode.getWidth();
    }

    public final boolean hasOverlappingRendering$ui() {
        return this.renderNode.hasOverlappingRendering();
    }

    public final boolean isUsingCompositingLayer$ui() {
        return this.renderNode.getUseCompositingLayer();
    }

    private final Paint obtainLayerPaint() {
        Paint v0 = this.layerPaint;
        if(v0 == null) {
            v0 = AndroidPaint_androidKt.Paint();
            this.layerPaint = v0;
        }

        return v0;
    }

    public void offsetLeftAndRight(int arg1) {
        this.renderNode.offsetLeftAndRight(arg1);
    }

    public void offsetTopAndBottom(int arg1) {
        this.renderNode.offsetTopAndBottom(arg1);
    }

    public void record(CanvasHolder arg6, Path arg7, Function1 arg8) {
        RecordingCanvas v0 = this.renderNode.beginRecording();
        Canvas v1 = arg6.getAndroidCanvas().getInternalCanvas();
        arg6.getAndroidCanvas().setInternalCanvas(((Canvas)v0));
        AndroidCanvas v0_1 = arg6.getAndroidCanvas();
        if(arg7 != null) {
            ((androidx.compose.ui.graphics.Canvas)v0_1).save();
            androidx.compose.ui.graphics.Canvas.clipPath-mtrdD-E$default(((androidx.compose.ui.graphics.Canvas)v0_1), arg7, 0, 2, null);
        }

        arg8.invoke(v0_1);
        if(arg7 != null) {
            ((androidx.compose.ui.graphics.Canvas)v0_1).restore();
        }

        arg6.getAndroidCanvas().setInternalCanvas(v1);
        this.renderNode.endRecording();
    }

    private final boolean requiresCompositingLayer() {
        if(!CompositingStrategy.equals-impl0(this.getCompositingStrategy--NrFUSI(), CompositingStrategy.Companion.getOffscreen--NrFUSI())) {
            if(this.requiresLayerPaint()) {
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
        this.renderNode.setAlpha(arg1);
    }

    public void setAmbientShadowColor(int arg1) {
        this.renderNode.setAmbientShadowColor(arg1);
    }

    public void setBlendMode-s9anfk8(int arg2) {
        this.blendMode = arg2;
        this.obtainLayerPaint().setBlendMode-s9anfk8(arg2);
        this.updateLayerProperties();
    }

    public void setCameraDistance(float arg1) {
        this.renderNode.setCameraDistance(arg1);
    }

    public void setClipToBounds(boolean arg1) {
        this.renderNode.setClipToBounds(arg1);
    }

    public void setClipToOutline(boolean arg1) {
        this.renderNode.setClipToOutline(arg1);
    }

    public void setColorFilter(ColorFilter arg2) {
        this.colorFilter = arg2;
        this.obtainLayerPaint().setColorFilter(arg2);
        this.updateLayerProperties();
    }

    public void setCompositingStrategy-aDBOjCE(int arg1) {
        this.internalCompositingStrategy = arg1;
        this.updateLayerProperties();
    }

    public void setElevation(float arg1) {
        this.renderNode.setElevation(arg1);
    }

    public boolean setHasOverlappingRendering(boolean arg1) {
        return this.renderNode.setHasOverlappingRendering(arg1);
    }

    public void setOutline(Outline arg1) {
        this.renderNode.setOutline(arg1);
    }

    public void setPivotX(float arg1) {
        this.renderNode.setPivotX(arg1);
    }

    public void setPivotY(float arg1) {
        this.renderNode.setPivotY(arg1);
    }

    public boolean setPosition(int arg1, int arg2, int arg3, int arg4) {
        return this.renderNode.setPosition(arg1, arg2, arg3, arg4);
    }

    public void setRenderEffect(RenderEffect arg3) {
        this.internalRenderEffect = arg3;
        if(Build$VERSION.SDK_INT >= 0x1F) {
            RenderNodeApi29VerificationHelper.INSTANCE.setRenderEffect(this.renderNode, arg3);
        }
    }

    public void setRotationX(float arg1) {
        this.renderNode.setRotationX(arg1);
    }

    public void setRotationY(float arg1) {
        this.renderNode.setRotationY(arg1);
    }

    public void setRotationZ(float arg1) {
        this.renderNode.setRotationZ(arg1);
    }

    public void setScaleX(float arg1) {
        this.renderNode.setScaleX(arg1);
    }

    public void setScaleY(float arg1) {
        this.renderNode.setScaleY(arg1);
    }

    public void setSpotShadowColor(int arg1) {
        this.renderNode.setSpotShadowColor(arg1);
    }

    public void setTranslationX(float arg1) {
        this.renderNode.setTranslationX(arg1);
    }

    public void setTranslationY(float arg1) {
        this.renderNode.setTranslationY(arg1);
    }

    private final void updateLayerProperties() {
        boolean v0 = this.requiresCompositingLayer();
        RenderNode v1 = this.renderNode;
        if(v0) {
            this.applyCompositingStrategy-Qu9p0E8(v1, CompositingStrategy.Companion.getOffscreen--NrFUSI());
            return;
        }

        this.applyCompositingStrategy-Qu9p0E8(v1, this.internalCompositingStrategy);
    }
}

