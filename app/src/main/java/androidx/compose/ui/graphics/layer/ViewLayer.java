package androidx.compose.ui.graphics.layer;

import android.graphics.Canvas;
import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawContextKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u0000 32\u00020\u0001:\u00013B#\u0012\u0006\u0010\u0002\u001A\u00020\u0001\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0012\u001A\u00020\u000E2\b\u0010\u0013\u001A\u0004\u0018\u00010\u0014J9\u0010%\u001A\u00020!2\u0006\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u001D2\b\u0010#\u001A\u0004\u0018\u00010$2\u0017\u0010\u001E\u001A\u0013\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001F¢\u0006\u0002\b\"J\b\u0010&\u001A\u00020!H\u0016J\b\u0010\'\u001A\u00020\u000EH\u0016J\u0010\u0010(\u001A\u00020!2\u0006\u0010)\u001A\u00020*H\u0014J0\u0010+\u001A\u00020!2\u0006\u0010,\u001A\u00020\u000E2\u0006\u0010-\u001A\u00020.2\u0006\u0010/\u001A\u00020.2\u0006\u00100\u001A\u00020.2\u0006\u00101\u001A\u00020.H\u0014J\b\u00102\u001A\u00020!H\u0016R\u0011\u0010\u0002\u001A\u00020\u0001¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\r\u001A\u00020\u000EX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\u000F\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0015\u001A\u0004\u0018\u00010\u0014X\u0082\u000E¢\u0006\u0002\n\u0000R$\u0010\u0017\u001A\u00020\u000E2\u0006\u0010\u0016\u001A\u00020\u000E@@X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0018\u0010\u000F\"\u0004\b\u0019\u0010\u0011R\u000E\u0010\u001A\u001A\u00020\u001BX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001C\u001A\u00020\u001DX\u0082\u000E¢\u0006\u0002\n\u0000R\u001F\u0010\u001E\u001A\u0013\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001F¢\u0006\u0002\b\"X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010#\u001A\u0004\u0018\u00010$X\u0082\u000E¢\u0006\u0002\n\u0000¨\u00064"}, d2={"Landroidx/compose/ui/graphics/layer/ViewLayer;", "Landroid/view/View;", "ownerView", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "canvasDrawScope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "<init>", "(Landroid/view/View;Landroidx/compose/ui/graphics/CanvasHolder;Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;)V", "getOwnerView", "()Landroid/view/View;", "getCanvasHolder", "()Landroidx/compose/ui/graphics/CanvasHolder;", "isInvalidated", "", "()Z", "setInvalidated", "(Z)V", "setLayerOutline", "outline", "Landroid/graphics/Outline;", "layerOutline", "value", "canUseCompositingLayer", "getCanUseCompositingLayer$ui_graphics", "setCanUseCompositingLayer$ui_graphics", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "drawBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "Lkotlin/ExtensionFunctionType;", "parentLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "setDrawParams", "invalidate", "hasOverlappingRendering", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "onLayout", "changed", "l", "", "t", "r", "b", "forceLayout", "Companion", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ViewLayer extends View {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001A\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"Landroidx/compose/ui/graphics/layer/ViewLayer$Companion;", "", "<init>", "()V", "LayerOutlineProvider", "Landroid/view/ViewOutlineProvider;", "getLayerOutlineProvider$ui_graphics", "()Landroid/view/ViewOutlineProvider;", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final ViewOutlineProvider getLayerOutlineProvider$ui_graphics() {
            return ViewLayer.LayerOutlineProvider;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final ViewOutlineProvider LayerOutlineProvider;
    private boolean canUseCompositingLayer;
    private final CanvasDrawScope canvasDrawScope;
    private final CanvasHolder canvasHolder;
    private Density density;
    private Function1 drawBlock;
    private boolean isInvalidated;
    private Outline layerOutline;
    private LayoutDirection layoutDirection;
    private final View ownerView;
    private GraphicsLayer parentLayer;

    static {
        ViewLayer.Companion = new Companion(null);
        ViewLayer.$stable = 8;
        ViewLayer.LayerOutlineProvider = new ViewLayer$Companion$LayerOutlineProvider$1();
    }

    public ViewLayer(View arg2, CanvasHolder arg3, CanvasDrawScope arg4) {
        super(arg2.getContext());
        this.ownerView = arg2;
        this.canvasHolder = arg3;
        this.canvasDrawScope = arg4;
        this.setOutlineProvider(ViewLayer.LayerOutlineProvider);
        this.canUseCompositingLayer = true;
        this.density = DrawContextKt.getDefaultDensity();
        this.layoutDirection = LayoutDirection.Ltr;
        this.drawBlock = GraphicsLayerImpl.Companion.getDefaultDrawBlock();
        this.setWillNotDraw(false);
        this.setClipBounds(null);
    }

    public ViewLayer(View arg1, CanvasHolder arg2, CanvasDrawScope arg3, int arg4, DefaultConstructorMarker arg5) {
        if((arg4 & 2) != 0) {
            arg2 = new CanvasHolder();
        }

        if((arg4 & 4) != 0) {
            arg3 = new CanvasDrawScope();
        }

        this(arg1, arg2, arg3);
    }

    public static final Outline access$getLayerOutline$p(ViewLayer arg0) {
        return arg0.layerOutline;
    }

    public static final ViewOutlineProvider access$getLayerOutlineProvider$cp() {
        return ViewLayer.LayerOutlineProvider;
    }

    protected void dispatchDraw(Canvas arg19) {
        CanvasHolder v1 = this.canvasHolder;
        Canvas v2 = v1.getAndroidCanvas().getInternalCanvas();
        v1.getAndroidCanvas().setInternalCanvas(arg19);
        AndroidCanvas v3 = v1.getAndroidCanvas();
        CanvasDrawScope v4 = this.canvasDrawScope;
        Density v5 = this.density;
        LayoutDirection v6 = this.layoutDirection;
        long v7 = Size.constructor-impl((((long)Float.floatToRawIntBits(((float)this.getHeight())))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(((float)this.getWidth())))) << 0x20);
        GraphicsLayer v9 = this.parentLayer;
        Function1 v10 = this.drawBlock;
        Density v11 = ((DrawScope)v4).getDrawContext().getDensity();
        LayoutDirection v12 = ((DrawScope)v4).getDrawContext().getLayoutDirection();
        androidx.compose.ui.graphics.Canvas v13 = ((DrawScope)v4).getDrawContext().getCanvas();
        long v14 = ((DrawScope)v4).getDrawContext().getSize-NH-jbRc();
        CanvasHolder v17 = v1;
        GraphicsLayer v1_1 = ((DrawScope)v4).getDrawContext().getGraphicsLayer();
        DrawContext v0 = ((DrawScope)v4).getDrawContext();
        v0.setDensity(v5);
        v0.setLayoutDirection(v6);
        v0.setCanvas(((androidx.compose.ui.graphics.Canvas)v3));
        v0.setSize-uvyYCjk(v7);
        v0.setGraphicsLayer(v9);
        ((androidx.compose.ui.graphics.Canvas)v3).save();
        try {
            v10.invoke(v4);
        }
        catch(Throwable v0_1) {
            ((androidx.compose.ui.graphics.Canvas)v3).restore();
            DrawContext v2_1 = ((DrawScope)v4).getDrawContext();
            v2_1.setDensity(v11);
            v2_1.setLayoutDirection(v12);
            v2_1.setCanvas(v13);
            v2_1.setSize-uvyYCjk(v14);
            v2_1.setGraphicsLayer(v1_1);
            throw v0_1;
        }

        ((androidx.compose.ui.graphics.Canvas)v3).restore();
        v0 = ((DrawScope)v4).getDrawContext();
        v0.setDensity(v11);
        v0.setLayoutDirection(v12);
        v0.setCanvas(v13);
        v0.setSize-uvyYCjk(v14);
        v0.setGraphicsLayer(v1_1);
        v17.getAndroidCanvas().setInternalCanvas(v2);
        this.isInvalidated = false;
    }

    public void forceLayout() {
    }

    public final boolean getCanUseCompositingLayer$ui_graphics() {
        return this.canUseCompositingLayer;
    }

    public final CanvasHolder getCanvasHolder() {
        return this.canvasHolder;
    }

    public final View getOwnerView() {
        return this.ownerView;
    }

    public boolean hasOverlappingRendering() {
        return this.canUseCompositingLayer;
    }

    public void invalidate() {
        if(!this.isInvalidated) {
            this.isInvalidated = true;
            super.invalidate();
        }
    }

    public final boolean isInvalidated() {
        return this.isInvalidated;
    }

    protected void onLayout(boolean arg1, int arg2, int arg3, int arg4, int arg5) {
    }

    public final void setCanUseCompositingLayer$ui_graphics(boolean arg2) {
        if(this.canUseCompositingLayer != arg2) {
            this.canUseCompositingLayer = arg2;
            this.invalidate();
        }
    }

    public final void setDrawParams(Density arg1, LayoutDirection arg2, GraphicsLayer arg3, Function1 arg4) {
        this.density = arg1;
        this.layoutDirection = arg2;
        this.drawBlock = arg4;
        this.parentLayer = arg3;
    }

    public final void setInvalidated(boolean arg1) {
        this.isInvalidated = arg1;
    }

    public final boolean setLayerOutline(Outline arg1) {
        this.layerOutline = arg1;
        return OutlineUtils.INSTANCE.rebuildOutline(((View)this));
    }
}

