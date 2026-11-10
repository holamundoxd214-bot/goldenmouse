package androidx.compose.ui.platform;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.os.Build$VERSION;
import android.view.DisplayListCanvas;
import android.view.RenderNode;
import android.view.View;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u009E\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b)\n\u0002\u0010\u000B\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \u009A\u00012\u00020\u0001:\u0002\u009A\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010p\u001A\u00020qH\u0002J\b\u0010r\u001A\u00020WH\u0002J\b\u0010s\u001A\u00020WH\u0002J\b\u0010t\u001A\u00020\u000EH\u0002J\u001B\u0010u\u001A\u00020q*\u00020\t2\u0006\u0010m\u001A\u00020\u000BH\u0002¢\u0006\u0004\bv\u0010wJ\r\u0010x\u001A\u00020\u0014H\u0000¢\u0006\u0002\byJ\r\u0010z\u001A\u00020WH\u0000¢\u0006\u0002\b{J\u0013\u0010~\u001A\u00020q2\t\u0010\u007F\u001A\u0005\u0018\u00010\u0080\u0001H\u0016J)\u0010\u0081\u0001\u001A\u00020W2\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0019\u001A\u00020\u00142\u0006\u0010\u001C\u001A\u00020\u00142\u0006\u0010\u001F\u001A\u00020\u0014H\u0016J\u0012\u0010\u0082\u0001\u001A\u00020q2\u0007\u0010\u0083\u0001\u001A\u00020\u0014H\u0016J\u0012\u0010\u0084\u0001\u001A\u00020q2\u0007\u0010\u0083\u0001\u001A\u00020\u0014H\u0016J6\u0010\u0085\u0001\u001A\u00020q2\b\u0010\u0086\u0001\u001A\u00030\u0087\u00012\n\u0010\u0088\u0001\u001A\u0005\u0018\u00010\u0089\u00012\u0015\u0010\u008A\u0001\u001A\u0010\u0012\u0005\u0012\u00030\u008C\u0001\u0012\u0004\u0012\u00020q0\u008B\u0001H\u0016J\u0013\u0010\u008D\u0001\u001A\u00020q2\b\u0010\u008E\u0001\u001A\u00030\u008F\u0001H\u0016J\u0013\u0010\u0090\u0001\u001A\u00020q2\b\u0010\u008E\u0001\u001A\u00030\u008F\u0001H\u0016J\u0013\u0010\u0091\u0001\u001A\u00020q2\b\u0010\u0092\u0001\u001A\u00030\u0093\u0001H\u0016J\u0011\u0010\u0094\u0001\u001A\u00020W2\u0006\u0010z\u001A\u00020WH\u0016J\n\u0010\u0095\u0001\u001A\u00030\u0096\u0001H\u0016J\t\u0010\u0097\u0001\u001A\u00020qH\u0016J\t\u0010\u0098\u0001\u001A\u00020qH\u0002J\u0011\u0010\u0099\u0001\u001A\u00020q2\u0006\u0010\b\u001A\u00020\tH\u0002R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\r\u001A\u0004\u0018\u00010\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u000F\u001A\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u0012R\u001A\u0010\u0013\u001A\u00020\u0014X\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001A\u0010\u0019\u001A\u00020\u0014X\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001A\u0010\u0016\"\u0004\b\u001B\u0010\u0018R\u001A\u0010\u001C\u001A\u00020\u0014X\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001D\u0010\u0016\"\u0004\b\u001E\u0010\u0018R\u001A\u0010\u001F\u001A\u00020\u0014X\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b \u0010\u0016\"\u0004\b!\u0010\u0018R\u0014\u0010\"\u001A\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b#\u0010\u0016R\u0014\u0010$\u001A\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b%\u0010\u0016R\u001C\u0010&\u001A\u0004\u0018\u00010\'X\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u0010.\u001A\u00020-2\u0006\u0010,\u001A\u00020-8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b/\u00100\"\u0004\b1\u00102R$\u00103\u001A\u00020-2\u0006\u0010,\u001A\u00020-8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b4\u00100\"\u0004\b5\u00102R$\u00106\u001A\u00020-2\u0006\u0010,\u001A\u00020-8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b7\u00100\"\u0004\b8\u00102R$\u00109\u001A\u00020-2\u0006\u0010,\u001A\u00020-8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b:\u00100\"\u0004\b;\u00102R$\u0010<\u001A\u00020-2\u0006\u0010,\u001A\u00020-8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b=\u00100\"\u0004\b>\u00102R$\u0010?\u001A\u00020\u00142\u0006\u0010,\u001A\u00020\u00148V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b@\u0010\u0016\"\u0004\bA\u0010\u0018R$\u0010B\u001A\u00020\u00142\u0006\u0010,\u001A\u00020\u00148V@VX\u0096\u000E¢\u0006\f\u001A\u0004\bC\u0010\u0016\"\u0004\bD\u0010\u0018R$\u0010E\u001A\u00020-2\u0006\u0010,\u001A\u00020-8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\bF\u00100\"\u0004\bG\u00102R$\u0010H\u001A\u00020-2\u0006\u0010,\u001A\u00020-8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\bI\u00100\"\u0004\bJ\u00102R$\u0010K\u001A\u00020-2\u0006\u0010,\u001A\u00020-8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\bL\u00100\"\u0004\bM\u00102R$\u0010N\u001A\u00020-2\u0006\u0010,\u001A\u00020-8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\bO\u00100\"\u0004\bP\u00102R$\u0010Q\u001A\u00020-2\u0006\u0010,\u001A\u00020-8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\bR\u00100\"\u0004\bS\u00102R$\u0010T\u001A\u00020-2\u0006\u0010,\u001A\u00020-8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\bU\u00100\"\u0004\bV\u00102R$\u0010X\u001A\u00020W2\u0006\u0010,\u001A\u00020W8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\bY\u0010Z\"\u0004\b[\u0010\\R$\u0010]\u001A\u00020W2\u0006\u0010,\u001A\u00020W@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b^\u0010Z\"\u0004\b_\u0010\\R$\u0010`\u001A\u00020-2\u0006\u0010,\u001A\u00020-8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\ba\u00100\"\u0004\bb\u00102R&\u0010d\u001A\u00020c2\u0006\u0010,\u001A\u00020c@VX\u0096\u000E¢\u0006\u0010\n\u0002\u0010\f\u001A\u0004\be\u0010\u0016\"\u0004\bf\u0010\u0018R(\u0010h\u001A\u0004\u0018\u00010g2\b\u0010,\u001A\u0004\u0018\u00010g@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bi\u0010j\"\u0004\bk\u0010lR$\u0010m\u001A\u00020\u000B2\u0006\u0010,\u001A\u00020\u000B8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\bn\u0010\u0016\"\u0004\bo\u0010\u0018R\u0014\u0010|\u001A\u00020W8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b}\u0010Z¨\u0006\u009B\u0001"}, d2={"Landroidx/compose/ui/platform/RenderNodeApi23;", "Landroidx/compose/ui/platform/DeviceRenderNode;", "ownerView", "Landroidx/compose/ui/platform/AndroidComposeView;", "<init>", "(Landroidx/compose/ui/platform/AndroidComposeView;)V", "getOwnerView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "renderNode", "Landroid/view/RenderNode;", "internalCompositingStrategy", "Landroidx/compose/ui/graphics/CompositingStrategy;", "I", "layerPaint", "Landroidx/compose/ui/graphics/Paint;", "uniqueId", "", "getUniqueId", "()J", "left", "", "getLeft", "()I", "setLeft", "(I)V", "top", "getTop", "setTop", "right", "getRight", "setRight", "bottom", "getBottom", "setBottom", "width", "getWidth", "height", "getHeight", "renderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "value", "", "scaleX", "getScaleX", "()F", "setScaleX", "(F)V", "scaleY", "getScaleY", "setScaleY", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "elevation", "getElevation", "setElevation", "ambientShadowColor", "getAmbientShadowColor", "setAmbientShadowColor", "spotShadowColor", "getSpotShadowColor", "setSpotShadowColor", "rotationZ", "getRotationZ", "setRotationZ", "rotationX", "getRotationX", "setRotationX", "rotationY", "getRotationY", "setRotationY", "cameraDistance", "getCameraDistance", "setCameraDistance", "pivotX", "getPivotX", "setPivotX", "pivotY", "getPivotY", "setPivotY", "", "clipToOutline", "getClipToOutline", "()Z", "setClipToOutline", "(Z)V", "clipToBounds", "getClipToBounds", "setClipToBounds", "alpha", "getAlpha", "setAlpha", "Landroidx/compose/ui/graphics/BlendMode;", "blendMode", "getBlendMode-0nO6VwU", "setBlendMode-s9anfk8", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "compositingStrategy", "getCompositingStrategy--NrFUSI", "setCompositingStrategy-aDBOjCE", "updateLayerProperties", "", "requiresCompositingLayer", "requiresLayerPaint", "obtainLayerPaint", "applyCompositingStrategy", "applyCompositingStrategy-Qu9p0E8", "(Landroid/view/RenderNode;I)V", "getLayerType", "getLayerType$ui", "hasOverlappingRendering", "hasOverlappingRendering$ui", "hasDisplayList", "getHasDisplayList", "setOutline", "outline", "Landroid/graphics/Outline;", "setPosition", "offsetLeftAndRight", "offset", "offsetTopAndBottom", "record", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "clipPath", "Landroidx/compose/ui/graphics/Path;", "drawBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Canvas;", "getMatrix", "matrix", "Landroid/graphics/Matrix;", "getInverseMatrix", "drawInto", "canvas", "Landroid/graphics/Canvas;", "setHasOverlappingRendering", "dumpRenderNodeData", "Landroidx/compose/ui/platform/DeviceRenderNodeData;", "discardDisplayList", "discardDisplayListInternal", "verifyShadowColorProperties", "Companion", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class RenderNodeApi23 implements DeviceRenderNode {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001A\u0010\u0004\u001A\u00020\u0005X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000E\u0010\n\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2={"Landroidx/compose/ui/platform/RenderNodeApi23$Companion;", "", "<init>", "()V", "testFailCreateRenderNode", "", "getTestFailCreateRenderNode$ui", "()Z", "setTestFailCreateRenderNode$ui", "(Z)V", "needToValidateAccess", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final boolean getTestFailCreateRenderNode$ui() {
            return RenderNodeApi23.testFailCreateRenderNode;
        }

        public final void setTestFailCreateRenderNode$ui(boolean arg1) {
            RenderNodeApi23.testFailCreateRenderNode = arg1;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private int blendMode;
    private int bottom;
    private boolean clipToBounds;
    private ColorFilter colorFilter;
    private int internalCompositingStrategy;
    private Paint layerPaint;
    private int left;
    private static boolean needToValidateAccess;
    private final AndroidComposeView ownerView;
    private RenderEffect renderEffect;
    private final RenderNode renderNode;
    private int right;
    private static boolean testFailCreateRenderNode;
    private int top;

    static {
        RenderNodeApi23.Companion = new Companion(null);
        RenderNodeApi23.$stable = 8;
        RenderNodeApi23.needToValidateAccess = true;
    }

    public RenderNodeApi23(AndroidComposeView arg3) {
        super();
        this.ownerView = arg3;
        RenderNode v3 = RenderNode.create("Compose", ((View)arg3));
        this.renderNode = v3;
        this.internalCompositingStrategy = CompositingStrategy.Companion.getAuto--NrFUSI();
        if(RenderNodeApi23.needToValidateAccess) {
            v3.setScaleX(v3.getScaleX());
            v3.setScaleY(v3.getScaleY());
            v3.setTranslationX(v3.getTranslationX());
            v3.setTranslationY(v3.getTranslationY());
            v3.setElevation(v3.getElevation());
            v3.setRotation(v3.getRotation());
            v3.setRotationX(v3.getRotationX());
            v3.setRotationY(v3.getRotationY());
            v3.setCameraDistance(v3.getCameraDistance());
            v3.setPivotX(v3.getPivotX());
            v3.setPivotY(v3.getPivotY());
            v3.setClipToOutline(v3.getClipToOutline());
            v3.setClipToBounds(false);
            v3.setAlpha(v3.getAlpha());
            v3.isValid();
            v3.setLeftTopRightBottom(0, 0, 0, 0);
            v3.offsetLeftAndRight(0);
            v3.offsetTopAndBottom(0);
            this.verifyShadowColorProperties(v3);
            this.discardDisplayListInternal();
            v3.setLayerType(0);
            v3.setHasOverlappingRendering(v3.hasOverlappingRendering());
            RenderNodeApi23.needToValidateAccess = false;
        }

        if(!RenderNodeApi23.testFailCreateRenderNode) {
            this.blendMode = BlendMode.Companion.getSrcOver-0nO6VwU();
            return;
        }

        throw new NoClassDefFoundError();
    }

    public static final boolean access$getTestFailCreateRenderNode$cp() {
        return RenderNodeApi23.testFailCreateRenderNode;
    }

    public static final void access$setTestFailCreateRenderNode$cp(boolean arg0) {
        RenderNodeApi23.testFailCreateRenderNode = arg0;
    }

    private final void applyCompositingStrategy-Qu9p0E8(RenderNode arg3, int arg4) {
        if(CompositingStrategy.equals-impl0(arg4, CompositingStrategy.Companion.getOffscreen--NrFUSI())) {
            arg3.setLayerType(2);
            Paint v2 = this.layerPaint;
            android.graphics.Paint v2_1 = v2 != null ? v2.asFrameworkPaint() : null;
            arg3.setLayerPaint(v2_1);
            arg3.setHasOverlappingRendering(true);
            return;
        }

        if(CompositingStrategy.equals-impl0(arg4, CompositingStrategy.Companion.getModulateAlpha--NrFUSI())) {
            arg3.setLayerType(0);
            arg3.setHasOverlappingRendering(false);
            return;
        }

        arg3.setLayerType(0);
        arg3.setHasOverlappingRendering(true);
    }

    public void discardDisplayList() {
        this.discardDisplayListInternal();
    }

    private final void discardDisplayListInternal() {
        RenderNodeVerificationHelper24.INSTANCE.discardDisplayList(this.renderNode);
    }

    public void drawInto(Canvas arg2) {
        Intrinsics.checkNotNull(arg2, "null cannot be cast to non-null type android.view.DisplayListCanvas");
        ((DisplayListCanvas)arg2).drawRenderNode(this.renderNode);
    }

    public DeviceRenderNodeData dumpRenderNodeData() {
        return new DeviceRenderNodeData(0, 0, 0, 0, 0, 0, 0, this.renderNode.getScaleX(), this.renderNode.getScaleY(), this.renderNode.getTranslationX(), this.renderNode.getTranslationY(), this.renderNode.getElevation(), this.getAmbientShadowColor(), this.getSpotShadowColor(), this.renderNode.getRotation(), this.renderNode.getRotationX(), this.renderNode.getRotationY(), this.renderNode.getCameraDistance(), this.renderNode.getPivotX(), this.renderNode.getPivotY(), this.renderNode.getClipToOutline(), this.getClipToBounds(), this.renderNode.getAlpha(), this.getRenderEffect(), this.getBlendMode-0nO6VwU(), this.getColorFilter(), this.internalCompositingStrategy, null);
    }

    public float getAlpha() {
        return this.renderNode.getAlpha();
    }

    public int getAmbientShadowColor() {
        if(Build$VERSION.SDK_INT >= 28) {
            return RenderNodeVerificationHelper28.INSTANCE.getAmbientShadowColor(this.renderNode);
        }

        return 0xFF000000;
    }

    public int getBlendMode-0nO6VwU() {
        return this.blendMode;
    }

    public int getBottom() {
        return this.bottom;
    }

    public float getCameraDistance() {
        return -this.renderNode.getCameraDistance();
    }

    public boolean getClipToBounds() {
        return this.clipToBounds;
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
        return this.renderNode.isValid();
    }

    public int getHeight() {
        return this.getBottom() - this.getTop();
    }

    public void getInverseMatrix(Matrix arg1) {
        this.renderNode.getInverseMatrix(arg1);
    }

    public final int getLayerType$ui() {
        if(CompositingStrategy.equals-impl0(this.internalCompositingStrategy, CompositingStrategy.Companion.getOffscreen--NrFUSI())) {
            return 2;
        }

        return 0;
    }

    public int getLeft() {
        return this.left;
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
        return this.renderEffect;
    }

    public int getRight() {
        return this.right;
    }

    public float getRotationX() {
        return this.renderNode.getRotationX();
    }

    public float getRotationY() {
        return this.renderNode.getRotationY();
    }

    public float getRotationZ() {
        return this.renderNode.getRotation();
    }

    public float getScaleX() {
        return this.renderNode.getScaleX();
    }

    public float getScaleY() {
        return this.renderNode.getScaleY();
    }

    public int getSpotShadowColor() {
        if(Build$VERSION.SDK_INT >= 28) {
            return RenderNodeVerificationHelper28.INSTANCE.getSpotShadowColor(this.renderNode);
        }

        return 0xFF000000;
    }

    public int getTop() {
        return this.top;
    }

    public float getTranslationX() {
        return this.renderNode.getTranslationX();
    }

    public float getTranslationY() {
        return this.renderNode.getTranslationY();
    }

    public long getUniqueId() {
        return 0;
    }

    public int getWidth() {
        return this.getRight() - this.getLeft();
    }

    public final boolean hasOverlappingRendering$ui() {
        return this.renderNode.hasOverlappingRendering();
    }

    private final Paint obtainLayerPaint() {
        Paint v0 = this.layerPaint;
        if(v0 == null) {
            v0 = AndroidPaint_androidKt.Paint();
            this.layerPaint = v0;
        }

        return v0;
    }

    public void offsetLeftAndRight(int arg2) {
        this.setLeft(this.getLeft() + arg2);
        this.setRight(this.getRight() + arg2);
        this.renderNode.offsetLeftAndRight(arg2);
    }

    public void offsetTopAndBottom(int arg2) {
        this.setTop(this.getTop() + arg2);
        this.setBottom(this.getBottom() + arg2);
        this.renderNode.offsetTopAndBottom(arg2);
    }

    public void record(CanvasHolder arg7, Path arg8, Function1 arg9) {
        DisplayListCanvas v0 = this.renderNode.start(this.getWidth(), this.getHeight());
        Canvas v2 = arg7.getAndroidCanvas().getInternalCanvas();
        arg7.getAndroidCanvas().setInternalCanvas(v0);
        AndroidCanvas v1 = arg7.getAndroidCanvas();
        if(arg8 != null) {
            ((androidx.compose.ui.graphics.Canvas)v1).save();
            androidx.compose.ui.graphics.Canvas.clipPath-mtrdD-E$default(((androidx.compose.ui.graphics.Canvas)v1), arg8, 0, 2, null);
        }

        arg9.invoke(v1);
        if(arg8 != null) {
            ((androidx.compose.ui.graphics.Canvas)v1).restore();
        }

        arg7.getAndroidCanvas().setInternalCanvas(v2);
        this.renderNode.end(v0);
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

    public void setAmbientShadowColor(int arg3) {
        if(Build$VERSION.SDK_INT >= 28) {
            RenderNodeVerificationHelper28.INSTANCE.setAmbientShadowColor(this.renderNode, arg3);
        }
    }

    public void setBlendMode-s9anfk8(int arg2) {
        this.blendMode = arg2;
        this.obtainLayerPaint().setBlendMode-s9anfk8(arg2);
        this.updateLayerProperties();
    }

    public void setBottom(int arg1) {
        this.bottom = arg1;
    }

    public void setCameraDistance(float arg1) {
        this.renderNode.setCameraDistance(-arg1);
    }

    public void setClipToBounds(boolean arg1) {
        this.clipToBounds = arg1;
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

    public void setLeft(int arg1) {
        this.left = arg1;
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
        this.setLeft(arg1);
        this.setTop(arg2);
        this.setRight(arg3);
        this.setBottom(arg4);
        return this.renderNode.setLeftTopRightBottom(arg1, arg2, arg3, arg4);
    }

    public void setRenderEffect(RenderEffect arg1) {
        this.renderEffect = arg1;
    }

    public void setRight(int arg1) {
        this.right = arg1;
    }

    public void setRotationX(float arg1) {
        this.renderNode.setRotationX(arg1);
    }

    public void setRotationY(float arg1) {
        this.renderNode.setRotationY(arg1);
    }

    public void setRotationZ(float arg1) {
        this.renderNode.setRotation(arg1);
    }

    public void setScaleX(float arg1) {
        this.renderNode.setScaleX(arg1);
    }

    public void setScaleY(float arg1) {
        this.renderNode.setScaleY(arg1);
    }

    public void setSpotShadowColor(int arg3) {
        if(Build$VERSION.SDK_INT >= 28) {
            RenderNodeVerificationHelper28.INSTANCE.setSpotShadowColor(this.renderNode, arg3);
        }
    }

    public void setTop(int arg1) {
        this.top = arg1;
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

    private final void verifyShadowColorProperties(RenderNode arg2) {
        if(Build$VERSION.SDK_INT >= 28) {
            RenderNodeVerificationHelper28.INSTANCE.setAmbientShadowColor(arg2, RenderNodeVerificationHelper28.INSTANCE.getAmbientShadowColor(arg2));
            RenderNodeVerificationHelper28.INSTANCE.setSpotShadowColor(arg2, RenderNodeVerificationHelper28.INSTANCE.getSpotShadowColor(arg2));
        }
    }
}

