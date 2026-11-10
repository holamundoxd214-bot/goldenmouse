package androidx.compose.ui.graphics.layer;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Build$VERSION;
import android.view.View;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.AndroidBlendMode_androidKt;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidColorFilter_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.view.DrawChildContainer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 \u009B\u00012\u00020\u0001:\u0002\u009B\u0001B+\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007\u0012\b\b\u0002\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010?\u001A\u00020@2\u0006\u0010<\u001A\u00020;H\u0002¢\u0006\u0004\bA\u00103J\b\u0010B\u001A\u00020@H\u0002J\b\u0010C\u001A\u00020\u0018H\u0002J\b\u0010D\u001A\u00020$H\u0002J\b\u0010E\u001A\u00020$H\u0002J\'\u0010}\u001A\u00020@2\u0006\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u001F\u001A\u00020\u001E2\u0006\u0010 \u001A\u00020!H\u0016¢\u0006\u0004\b~\u0010\u007FJ\'\u0010\u0080\u0001\u001A\u00020@2\n\u0010\u0081\u0001\u001A\u0005\u0018\u00010\u0082\u00012\u0007\u0010\u0083\u0001\u001A\u00020!H\u0016¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001JD\u0010\u0086\u0001\u001A\u00020@2\b\u0010\u0087\u0001\u001A\u00030\u0088\u00012\b\u0010\u0089\u0001\u001A\u00030\u008A\u00012\b\u0010\u008B\u0001\u001A\u00030\u008C\u00012\u001B\u0010\u008D\u0001\u001A\u0016\u0012\u0005\u0012\u00030\u008F\u0001\u0012\u0004\u0012\u00020@0\u008E\u0001¢\u0006\u0003\b\u0090\u0001H\u0016J\t\u0010\u0093\u0001\u001A\u00020@H\u0002J\u0013\u0010\u0094\u0001\u001A\u00020@2\b\u0010\u0095\u0001\u001A\u00030\u0096\u0001H\u0016J\n\u0010\u0097\u0001\u001A\u00030\u0098\u0001H\u0016J\t\u0010\u0099\u0001\u001A\u00020@H\u0002J\t\u0010\u009A\u0001\u001A\u00020@H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001A\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u000E\u0010\u0010\u001A\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001A\n \u0014*\u0004\u0018\u00010\u00130\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001A\u0004\u0018\u00010\u0018X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001A\u0004\u0018\u00010\u001AX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001B\u001A\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001C\u001A\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001D\u001A\u00020\u001EX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001F\u001A\u00020\u001EX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010 \u001A\u00020!X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\"R\u000E\u0010#\u001A\u00020$X\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u0010%\u001A\u00020$X\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b%\u0010&\"\u0004\b\'\u0010(R\u000E\u0010)\u001A\u00020$X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010*\u001A\u00020$X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010+\u001A\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b,\u0010\rR&\u0010/\u001A\u00020.2\u0006\u0010-\u001A\u00020.@VX\u0096\u000E¢\u0006\u0010\n\u0002\u00104\u001A\u0004\b0\u00101\"\u0004\b2\u00103R(\u00106\u001A\u0004\u0018\u0001052\b\u0010-\u001A\u0004\u0018\u000105@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b7\u00108\"\u0004\b9\u0010:R&\u0010<\u001A\u00020;2\u0006\u0010-\u001A\u00020;@VX\u0096\u000E¢\u0006\u0010\n\u0002\u00104\u001A\u0004\b=\u00101\"\u0004\b>\u00103R$\u0010G\u001A\u00020F2\u0006\u0010-\u001A\u00020F@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u000E\u0010L\u001A\u00020$X\u0082\u000E¢\u0006\u0002\n\u0000R&\u0010N\u001A\u00020M2\u0006\u0010-\u001A\u00020M@VX\u0096\u000E¢\u0006\u0010\n\u0002\u0010\"\u001A\u0004\bO\u0010\r\"\u0004\bP\u0010QR$\u0010R\u001A\u00020F2\u0006\u0010-\u001A\u00020F@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bS\u0010I\"\u0004\bT\u0010KR$\u0010U\u001A\u00020F2\u0006\u0010-\u001A\u00020F@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bV\u0010I\"\u0004\bW\u0010KR$\u0010X\u001A\u00020F2\u0006\u0010-\u001A\u00020F@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bY\u0010I\"\u0004\bZ\u0010KR$\u0010[\u001A\u00020F2\u0006\u0010-\u001A\u00020F@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\\\u0010I\"\u0004\b]\u0010KR$\u0010^\u001A\u00020F2\u0006\u0010-\u001A\u00020F@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b_\u0010I\"\u0004\b`\u0010KR&\u0010b\u001A\u00020a2\u0006\u0010-\u001A\u00020a@VX\u0096\u000E¢\u0006\u0010\n\u0002\u0010\"\u001A\u0004\bc\u0010\r\"\u0004\bd\u0010QR&\u0010e\u001A\u00020a2\u0006\u0010-\u001A\u00020a@VX\u0096\u000E¢\u0006\u0010\n\u0002\u0010\"\u001A\u0004\bf\u0010\r\"\u0004\bg\u0010QR$\u0010h\u001A\u00020F2\u0006\u0010-\u001A\u00020F@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bi\u0010I\"\u0004\bj\u0010KR$\u0010k\u001A\u00020F2\u0006\u0010-\u001A\u00020F@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bl\u0010I\"\u0004\bm\u0010KR$\u0010n\u001A\u00020F2\u0006\u0010-\u001A\u00020F@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bo\u0010I\"\u0004\bp\u0010KR$\u0010q\u001A\u00020F2\u0006\u0010-\u001A\u00020F8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\br\u0010I\"\u0004\bs\u0010KR$\u0010t\u001A\u00020$2\u0006\u0010-\u001A\u00020$8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\bu\u0010&\"\u0004\bv\u0010(R(\u0010x\u001A\u0004\u0018\u00010w2\b\u0010-\u001A\u0004\u0018\u00010w@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\by\u0010z\"\u0004\b{\u0010|R\u0016\u0010\u0091\u0001\u001A\u00020$X\u0096\u0004¢\u0006\t\n\u0000\u001A\u0005\b\u0092\u0001\u0010&¨\u0006\u009C\u0001"}, d2={"Landroidx/compose/ui/graphics/layer/GraphicsViewLayer;", "Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl;", "layerContainer", "Landroidx/compose/ui/graphics/layer/view/DrawChildContainer;", "ownerId", "", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "canvasDrawScope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "<init>", "(Landroidx/compose/ui/graphics/layer/view/DrawChildContainer;JLandroidx/compose/ui/graphics/CanvasHolder;Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;)V", "getOwnerId", "()J", "getCanvasHolder", "()Landroidx/compose/ui/graphics/CanvasHolder;", "viewLayer", "Landroidx/compose/ui/graphics/layer/ViewLayer;", "resources", "Landroid/content/res/Resources;", "kotlin.jvm.PlatformType", "clipRect", "Landroid/graphics/Rect;", "layerPaint", "Landroid/graphics/Paint;", "picture", "Landroid/graphics/Picture;", "pictureDrawScope", "pictureCanvasHolder", "x", "", "y", "size", "Landroidx/compose/ui/unit/IntSize;", "J", "clipBoundsInvalidated", "", "isInvalidated", "()Z", "setInvalidated", "(Z)V", "outlineIsProvided", "clipToBounds", "layerId", "getLayerId", "value", "Landroidx/compose/ui/graphics/BlendMode;", "blendMode", "getBlendMode-0nO6VwU", "()I", "setBlendMode-s9anfk8", "(I)V", "I", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "Landroidx/compose/ui/graphics/layer/CompositingStrategy;", "compositingStrategy", "getCompositingStrategy-ke2Ky5w", "setCompositingStrategy-Wpw9cng", "applyCompositingLayer", "", "applyCompositingLayer-Wpw9cng", "updateLayerProperties", "obtainLayerPaint", "requiresCompositingLayer", "requiresLayerPaint", "", "alpha", "getAlpha", "()F", "setAlpha", "(F)V", "shouldManuallySetCenterPivot", "Landroidx/compose/ui/geometry/Offset;", "pivotOffset", "getPivotOffset-F1C5BW0", "setPivotOffset-k-4lQ0M", "(J)V", "scaleX", "getScaleX", "setScaleX", "scaleY", "getScaleY", "setScaleY", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "shadowElevation", "getShadowElevation", "setShadowElevation", "Landroidx/compose/ui/graphics/Color;", "ambientShadowColor", "getAmbientShadowColor-0d7_KjU", "setAmbientShadowColor-8_81llA", "spotShadowColor", "getSpotShadowColor-0d7_KjU", "setSpotShadowColor-8_81llA", "rotationX", "getRotationX", "setRotationX", "rotationY", "getRotationY", "setRotationY", "rotationZ", "getRotationZ", "setRotationZ", "cameraDistance", "getCameraDistance", "setCameraDistance", "clip", "getClip", "setClip", "Landroidx/compose/ui/graphics/RenderEffect;", "renderEffect", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "setPosition", "setPosition-H0pRuoY", "(IIJ)V", "setOutline", "outline", "Landroid/graphics/Outline;", "outlineSize", "setOutline-O0kMr_c", "(Landroid/graphics/Outline;J)V", "record", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "layer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Lkotlin/ExtensionFunctionType;", "supportsSoftwareRendering", "getSupportsSoftwareRendering", "recordDrawingOperations", "draw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "calculateMatrix", "Landroid/graphics/Matrix;", "updateClipBounds", "discardDisplayList", "Companion", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class GraphicsViewLayer implements GraphicsLayerImpl {
    @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\f"}, d2={"Landroidx/compose/ui/graphics/layer/GraphicsViewLayer$Companion;", "", "<init>", "()V", "mayRenderInSoftware", "", "getMayRenderInSoftware", "()Z", "PlaceholderCanvas", "Landroid/graphics/Canvas;", "getPlaceholderCanvas", "()Landroid/graphics/Canvas;", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final boolean getMayRenderInSoftware() {
            return GraphicsViewLayer.mayRenderInSoftware;
        }

        public final Canvas getPlaceholderCanvas() {
            return GraphicsViewLayer.PlaceholderCanvas;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final Canvas PlaceholderCanvas;
    private float alpha;
    private long ambientShadowColor;
    private int blendMode;
    private final CanvasHolder canvasHolder;
    private boolean clipBoundsInvalidated;
    private final Rect clipRect;
    private boolean clipToBounds;
    private ColorFilter colorFilter;
    private int compositingStrategy;
    private boolean isInvalidated;
    private final DrawChildContainer layerContainer;
    private final long layerId;
    private Paint layerPaint;
    private static final boolean mayRenderInSoftware;
    private boolean outlineIsProvided;
    private final long ownerId;
    private final Picture picture;
    private final CanvasHolder pictureCanvasHolder;
    private final CanvasDrawScope pictureDrawScope;
    private long pivotOffset;
    private RenderEffect renderEffect;
    private final Resources resources;
    private float rotationX;
    private float rotationY;
    private float rotationZ;
    private float scaleX;
    private float scaleY;
    private float shadowElevation;
    private boolean shouldManuallySetCenterPivot;
    private long size;
    private long spotShadowColor;
    private final boolean supportsSoftwareRendering;
    private float translationX;
    private float translationY;
    private final ViewLayer viewLayer;
    private int x;
    private int y;

    static {
        GraphicsViewLayer.Companion = new Companion(null);
        GraphicsViewLayer.$stable = 8;
        GraphicsViewLayer.mayRenderInSoftware = SurfaceUtils.INSTANCE.isLockHardwareCanvasAvailable() ^ 1;
        GraphicsViewLayer.PlaceholderCanvas = new GraphicsViewLayer$Companion$PlaceholderCanvas$1();
    }

    public GraphicsViewLayer(DrawChildContainer arg7, long arg8, CanvasHolder arg10, CanvasDrawScope arg11, int arg12, DefaultConstructorMarker arg13) {
        if((arg12 & 4) != 0) {
            arg10 = new CanvasHolder();
        }

        CanvasHolder v4 = arg10;
        if((arg12 & 8) != 0) {
            arg11 = new CanvasDrawScope();
        }

        this(arg7, arg8, v4, arg11);
    }

    public GraphicsViewLayer(DrawChildContainer arg1, long arg2, CanvasHolder arg4, CanvasDrawScope arg5) {
        super();
        this.layerContainer = arg1;
        this.ownerId = arg2;
        this.canvasHolder = arg4;
        ViewLayer v2 = new ViewLayer(arg1, arg4, arg5);
        this.viewLayer = v2;
        this.resources = arg1.getResources();
        this.clipRect = new Rect();
        boolean v3 = GraphicsViewLayer.mayRenderInSoftware;
        Rect v4 = null;
        Picture v5 = v3 ? new Picture() : ((Picture)v4);
        this.picture = v5;
        arg5 = v3 ? new CanvasDrawScope() : ((CanvasDrawScope)v4);
        this.pictureDrawScope = arg5;
        CanvasHolder v5_1 = v3 ? new CanvasHolder() : ((CanvasHolder)v4);
        this.pictureCanvasHolder = v5_1;
        arg1.addView(v2);
        v2.setClipBounds(v4);
        this.size = IntSize.Companion.getZero-YbymL2g();
        this.isInvalidated = true;
        this.layerId = ((long)View.generateViewId());
        this.blendMode = BlendMode.Companion.getSrcOver-0nO6VwU();
        this.compositingStrategy = CompositingStrategy.Companion.getAuto-ke2Ky5w();
        this.alpha = 1f;
        this.pivotOffset = Offset.Companion.getZero-F1C5BW0();
        this.scaleX = 1f;
        this.scaleY = 1f;
        this.ambientShadowColor = Color.Companion.getBlack-0d7_KjU();
        this.spotShadowColor = Color.Companion.getBlack-0d7_KjU();
        this.supportsSoftwareRendering = v3;
    }

    public static final boolean access$getMayRenderInSoftware$cp() {
        return GraphicsViewLayer.mayRenderInSoftware;
    }

    public static final Canvas access$getPlaceholderCanvas$cp() {
        return GraphicsViewLayer.PlaceholderCanvas;
    }

    private final void applyCompositingLayer-Wpw9cng(int arg5) {
        ViewLayer v0 = this.viewLayer;
        boolean v2 = true;
        if(CompositingStrategy.equals-impl0(arg5, CompositingStrategy.Companion.getOffscreen-ke2Ky5w())) {
            this.viewLayer.setLayerType(2, this.layerPaint);
        }
        else {
            boolean v5 = CompositingStrategy.equals-impl0(arg5, CompositingStrategy.Companion.getModulateAlpha-ke2Ky5w());
            ViewLayer v1 = this.viewLayer;
            if(v5) {
                v1.setLayerType(0, this.layerPaint);
                v2 = false;
            }
            else {
                v1.setLayerType(0, this.layerPaint);
            }
        }

        v0.setCanUseCompositingLayer$ui_graphics(v2);
    }

    public Matrix calculateMatrix() {
        return this.viewLayer.getMatrix();
    }

    public void discardDisplayList() {
        this.layerContainer.removeViewInLayout(this.viewLayer);
    }

    public void draw(androidx.compose.ui.graphics.Canvas arg5) {
        this.updateClipBounds();
        Canvas v0 = AndroidCanvas_androidKt.getNativeCanvas(arg5);
        if(v0.isHardwareAccelerated()) {
            this.layerContainer.drawChild$ui_graphics(arg5, this.viewLayer, this.viewLayer.getDrawingTime());
            return;
        }

        Picture v4 = this.picture;
        if(v4 != null) {
            v0.drawPicture(v4);
        }
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
        return this.viewLayer.getCameraDistance() / (((float)this.resources.getDisplayMetrics().densityDpi));
    }

    public final CanvasHolder getCanvasHolder() {
        return this.canvasHolder;
    }

    public boolean getClip() {
        if(!this.clipToBounds) {
            if(this.viewLayer.getClipToOutline()) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    public int getCompositingStrategy-ke2Ky5w() {
        return this.compositingStrategy;
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

    public boolean getSupportsSoftwareRendering() {
        return this.supportsSoftwareRendering;
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

    public void record(Density arg19, LayoutDirection arg20, GraphicsLayer arg21, Function1 arg22) {
        GraphicsLayer v5_1;
        Picture v17;
        DrawContext v0_2;
        long v7_1;
        Canvas v16;
        CanvasHolder v15;
        androidx.compose.ui.graphics.Canvas v14;
        LayoutDirection v13;
        Density v12;
        long v10;
        CanvasDrawScope v9;
        AndroidCanvas v6_1;
        Canvas v8;
        CanvasHolder v7;
        GraphicsViewLayer v0 = this;
        Density v1 = arg19;
        LayoutDirection v2 = arg20;
        GraphicsLayer v3 = arg21;
        Function1 v4 = arg22;
        if(v0.viewLayer.getParent() == null) {
            v0.layerContainer.addView(v0.viewLayer);
        }

        v0.viewLayer.setDrawParams(v1, v2, v3, v4);
        if(v0.viewLayer.isAttachedToWindow()) {
            v0.viewLayer.setVisibility(4);
            v0.viewLayer.setVisibility(0);
            v0.recordDrawingOperations();
            Picture v5 = v0.picture;
            if(v5 != null) {
                Canvas v6 = v5.beginRecording(((int)(v0.size >> 0x20)), ((int)(v0.size & 0xFFFFFFFFL)));
                try {
                    v7 = v0.pictureCanvasHolder;
                    if(v7 != null) {
                        v8 = v7.getAndroidCanvas().getInternalCanvas();
                        v7.getAndroidCanvas().setInternalCanvas(v6);
                        v6_1 = v7.getAndroidCanvas();
                        v9 = v0.pictureDrawScope;
                        if(v9 != null) {
                            v10 = IntSizeKt.toSize-ozmzZPI(v0.size);
                            v12 = ((DrawScope)v9).getDrawContext().getDensity();
                            v13 = ((DrawScope)v9).getDrawContext().getLayoutDirection();
                            v14 = ((DrawScope)v9).getDrawContext().getCanvas();
                            v15 = v7;
                            v16 = v8;
                            v7_1 = ((DrawScope)v9).getDrawContext().getSize-NH-jbRc();
                            v0_2 = ((DrawScope)v9).getDrawContext();
                            v17 = v5;
                            goto label_56;
                        }
                        else {
                            goto label_82;
                        }
                    }
                    else {
                        goto label_92;
                    }

                    goto label_93;
                }
                catch(Throwable v0_1) {
                    v17 = v5;
                    goto label_97;
                }

                try {
                label_56:
                    v5_1 = v0_2.getGraphicsLayer();
                    v0_2 = ((DrawScope)v9).getDrawContext();
                    v0_2.setDensity(v1);
                    v0_2.setLayoutDirection(v2);
                    v0_2.setCanvas(((androidx.compose.ui.graphics.Canvas)v6_1));
                    v0_2.setSize-uvyYCjk(v10);
                    v0_2.setGraphicsLayer(v3);
                    ((androidx.compose.ui.graphics.Canvas)v6_1).save();
                }
                catch(Throwable v0_1) {
                    goto label_91;
                }

                try {
                    v4.invoke(v9);
                    goto label_65;
                }
                catch(Throwable v0_1) {
                    try {
                        ((androidx.compose.ui.graphics.Canvas)v6_1).restore();
                        DrawContext v1_1 = ((DrawScope)v9).getDrawContext();
                        v1_1.setDensity(v12);
                        v1_1.setLayoutDirection(v13);
                        v1_1.setCanvas(v14);
                        v1_1.setSize-uvyYCjk(v7_1);
                        v1_1.setGraphicsLayer(v5_1);
                        throw v0_1;
                    label_65:
                        ((androidx.compose.ui.graphics.Canvas)v6_1).restore();
                        v0_2 = ((DrawScope)v9).getDrawContext();
                        v0_2.setDensity(v12);
                        v0_2.setLayoutDirection(v13);
                        v0_2.setCanvas(v14);
                        v0_2.setSize-uvyYCjk(v7_1);
                        v0_2.setGraphicsLayer(v5_1);
                        goto label_85;
                    label_82:
                        v17 = v5;
                        v15 = v7;
                        v16 = v8;
                    label_85:
                        v15.getAndroidCanvas().setInternalCanvas(v16);
                        goto label_93;
                    }
                    catch(Throwable v0_1) {
                    label_91:
                    }
                }

            label_97:
                v17.endRecording();
                throw v0_1;
            label_92:
                v17 = v5;
            label_93:
                v17.endRecording();
                return;
            }
        }
    }

    private final void recordDrawingOperations() {
        try {
            CanvasHolder v0 = this.canvasHolder;
            Canvas v1 = GraphicsViewLayer.PlaceholderCanvas;
            Canvas v2 = v0.getAndroidCanvas().getInternalCanvas();
            v0.getAndroidCanvas().setInternalCanvas(v1);
            this.layerContainer.drawChild$ui_graphics(v0.getAndroidCanvas(), this.viewLayer, this.viewLayer.getDrawingTime());
            v0.getAndroidCanvas().setInternalCanvas(v2);
            return;
        }
        catch(ClassCastException ) {
            return;
        }
    }

    private final boolean requiresCompositingLayer() {
        if(!CompositingStrategy.equals-impl0(this.getCompositingStrategy-ke2Ky5w(), CompositingStrategy.Companion.getOffscreen-ke2Ky5w())) {
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
        this.alpha = arg1;
        this.viewLayer.setAlpha(arg1);
    }

    public void setAmbientShadowColor-8_81llA(long arg3) {
        if(Build$VERSION.SDK_INT >= 28) {
            this.ambientShadowColor = arg3;
            ViewLayerVerificationHelper28.INSTANCE.setOutlineAmbientShadowColor(this.viewLayer, ColorKt.toArgb-8_81llA(arg3));
        }
    }

    public void setBlendMode-s9anfk8(int arg3) {
        this.blendMode = arg3;
        this.obtainLayerPaint().setXfermode(new PorterDuffXfermode(AndroidBlendMode_androidKt.toPorterDuffMode-s9anfk8(arg3)));
        this.updateLayerProperties();
    }

    public void setCameraDistance(float arg2) {
        this.viewLayer.setCameraDistance(arg2 * (((float)this.resources.getDisplayMetrics().densityDpi)));
    }

    public void setClip(boolean arg4) {
        boolean v0 = false;
        boolean v2 = !arg4 || (this.outlineIsProvided) ? false : true;
        this.clipToBounds = v2;
        this.clipBoundsInvalidated = true;
        ViewLayer v2_1 = this.viewLayer;
        if((arg4) && (this.outlineIsProvided)) {
            v0 = true;
        }

        v2_1.setClipToOutline(v0);
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

    public void setOutline-O0kMr_c(Outline arg3, long arg4) {
        boolean v4 = this.viewLayer.setLayerOutline(arg3);
        boolean v0 = false;
        if((this.getClip()) && arg3 != null) {
            this.viewLayer.setClipToOutline(true);
            if(this.clipToBounds) {
                this.clipToBounds = false;
                this.clipBoundsInvalidated = true;
            }
        }

        if(arg3 != null) {
            v0 = true;
        }

        this.outlineIsProvided = v0;
        if(!v4) {
            this.viewLayer.invalidate();
            this.recordDrawingOperations();
        }
    }

    public void setPivotOffset-k-4lQ0M(long arg7) {
        this.pivotOffset = arg7;
        long v1 = 0xFFFFFFFFL;
        int v3 = 0x20;
        if(Long.compare(0x7FFFFFFF7FFFFFFFL & arg7, 0x7FC000007FC00000L) == 0) {
            if(Build$VERSION.SDK_INT >= 28) {
                ViewLayerVerificationHelper28.INSTANCE.resetPivot(this.viewLayer);
                return;
            }

            this.shouldManuallySetCenterPivot = true;
            this.viewLayer.setPivotX((((float)(((int)(this.size >> v3))))) / 2f);
            this.viewLayer.setPivotY((((float)(((int)(v1 & this.size))))) / 2f);
            return;
        }

        this.shouldManuallySetCenterPivot = false;
        this.viewLayer.setPivotX(Float.intBitsToFloat(((int)(arg7 >> v3))));
        this.viewLayer.setPivotY(Float.intBitsToFloat(((int)(arg7 & v1))));
    }

    public void setPosition-H0pRuoY(int arg6, int arg7, long arg8) {
        if(!IntSize.equals-impl0(this.size, arg8)) {
            if(this.getClip()) {
                this.clipBoundsInvalidated = true;
            }

            int v1 = ((int)(arg8 >> 0x20));
            int v3 = ((int)(0xFFFFFFFFL & arg8));
            this.viewLayer.layout(arg6, arg7, arg6 + v1, arg7 + v3);
            this.size = arg8;
            if(!this.shouldManuallySetCenterPivot) {
                goto label_40;
            }

            this.viewLayer.setPivotX((((float)v1)) / 2f);
            this.viewLayer.setPivotY((((float)v3)) / 2f);
        }
        else {
            int v8 = this.x;
            if(v8 != arg6) {
                this.viewLayer.offsetLeftAndRight(arg6 - v8);
            }

            v8 = this.y;
            if(v8 == arg7) {
                goto label_40;
            }

            this.viewLayer.offsetTopAndBottom(arg7 - v8);
        }

    label_40:
        this.x = arg6;
        this.y = arg7;
    }

    public void setRenderEffect(RenderEffect arg3) {
        this.renderEffect = arg3;
        if(Build$VERSION.SDK_INT >= 0x1F) {
            ViewLayerVerificationHelper31.INSTANCE.setRenderEffect(this.viewLayer, arg3);
        }
    }

    public void setRotationX(float arg1) {
        this.rotationX = arg1;
        this.viewLayer.setRotationX(arg1);
    }

    public void setRotationY(float arg1) {
        this.rotationY = arg1;
        this.viewLayer.setRotationY(arg1);
    }

    public void setRotationZ(float arg1) {
        this.rotationZ = arg1;
        this.viewLayer.setRotation(arg1);
    }

    public void setScaleX(float arg1) {
        this.scaleX = arg1;
        this.viewLayer.setScaleX(arg1);
    }

    public void setScaleY(float arg1) {
        this.scaleY = arg1;
        this.viewLayer.setScaleY(arg1);
    }

    public void setShadowElevation(float arg1) {
        this.shadowElevation = arg1;
        this.viewLayer.setElevation(arg1);
    }

    public void setSpotShadowColor-8_81llA(long arg3) {
        if(Build$VERSION.SDK_INT >= 28) {
            this.spotShadowColor = arg3;
            ViewLayerVerificationHelper28.INSTANCE.setOutlineSpotShadowColor(this.viewLayer, ColorKt.toArgb-8_81llA(arg3));
        }
    }

    public void setTranslationX(float arg1) {
        this.translationX = arg1;
        this.viewLayer.setTranslationX(arg1);
    }

    public void setTranslationY(float arg1) {
        this.translationY = arg1;
        this.viewLayer.setTranslationY(arg1);
    }

    private final void updateClipBounds() {
        Rect v1;
        if(this.clipBoundsInvalidated) {
            ViewLayer v0 = this.viewLayer;
            if(!this.getClip() || (this.outlineIsProvided)) {
                v1 = null;
            }
            else {
                v1 = this.clipRect;
                v1.left = 0;
                v1.top = 0;
                v1.right = this.viewLayer.getWidth();
                v1.bottom = this.viewLayer.getHeight();
            }

            v0.setClipBounds(v1);
        }
    }

    private final void updateLayerProperties() {
        if(this.requiresCompositingLayer()) {
            this.applyCompositingLayer-Wpw9cng(CompositingStrategy.Companion.getOffscreen-ke2Ky5w());
            return;
        }

        this.applyCompositingLayer-Wpw9cng(this.getCompositingStrategy-ke2Ky5w());
    }
}

