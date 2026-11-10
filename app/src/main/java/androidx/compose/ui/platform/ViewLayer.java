package androidx.compose.ui.platform;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build$VERSION;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.CompositingStrategy;
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
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u0000 {2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002z{B_\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u00128\u0010\b\u001A4\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000B\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u000E¢\u0006\f\b\u000B\u0012\b\b\f\u0012\u0004\b\b(\u000F\u0012\u0004\u0012\u00020\u00100\t\u0012\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010J\u001A\u00020\u00102\u0006\u0010K\u001A\u00020LH\u0016J\b\u0010M\u001A\u00020)H\u0002J\b\u0010N\u001A\u00020\u001CH\u0016J\u0017\u0010O\u001A\u00020\u001C2\u0006\u0010P\u001A\u00020QH\u0016¢\u0006\u0004\bR\u0010SJ\b\u0010T\u001A\u00020\u0010H\u0002J\b\u0010U\u001A\u00020\u0010H\u0002J\u0017\u0010V\u001A\u00020\u00102\u0006\u0010W\u001A\u00020XH\u0016¢\u0006\u0004\bY\u0010ZJ\u0017\u0010[\u001A\u00020\u00102\u0006\u0010P\u001A\u00020\\H\u0016¢\u0006\u0004\b]\u0010ZJ\u001A\u0010^\u001A\u00020\u00102\u0006\u0010\r\u001A\u00020\n2\b\u0010\u000F\u001A\u0004\u0018\u00010\u000EH\u0016J\u0010\u0010_\u001A\u00020\u00102\u0006\u0010\r\u001A\u00020`H\u0014J\b\u0010a\u001A\u00020\u0010H\u0016J0\u0010b\u001A\u00020\u00102\u0006\u0010c\u001A\u00020\u001C2\u0006\u0010d\u001A\u00020I2\u0006\u0010e\u001A\u00020I2\u0006\u0010f\u001A\u00020I2\u0006\u0010g\u001A\u00020IH\u0014J\b\u0010h\u001A\u00020\u0010H\u0016J\b\u0010i\u001A\u00020\u0010H\u0016J\b\u0010j\u001A\u00020\u0010H\u0016J\u001F\u0010k\u001A\u00020Q2\u0006\u0010l\u001A\u00020Q2\u0006\u0010m\u001A\u00020\u001CH\u0016¢\u0006\u0004\bn\u0010oJ\u0018\u0010p\u001A\u00020\u00102\u0006\u0010q\u001A\u00020r2\u0006\u0010m\u001A\u00020\u001CH\u0016JP\u0010s\u001A\u00020\u001028\u0010\b\u001A4\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000B\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u000E¢\u0006\f\b\u000B\u0012\b\b\f\u0012\u0004\b\b(\u000F\u0012\u0004\u0012\u00020\u00100\t2\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00100\u0012H\u0016J\u0017\u0010t\u001A\u00020\u00102\u0006\u0010u\u001A\u000200H\u0016¢\u0006\u0004\bv\u0010wJ\u0017\u0010x\u001A\u00020\u00102\u0006\u0010u\u001A\u000200H\u0016¢\u0006\u0004\by\u0010wR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0018RB\u0010\b\u001A6\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000B\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u000E¢\u0006\f\b\u000B\u0012\b\b\f\u0012\u0004\b\b(\u000F\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001A\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0012X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0019\u001A\u00020\u001AX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001B\u001A\u00020\u001CX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u001D\u001A\u0004\u0018\u00010\u001EX\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010\u001F\u001A\u0004\u0018\u00010 8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b!\u0010\"R$\u0010$\u001A\u00020\u001C2\u0006\u0010#\u001A\u00020\u001C@BX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b$\u0010%\"\u0004\b&\u0010\'R\u0010\u0010(\u001A\u0004\u0018\u00010)X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010*\u001A\u00020\u001CX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010+\u001A\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010-\u001A\b\u0012\u0004\u0012\u00020\u00010.X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010/\u001A\u0002008VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b1\u00102R\u001A\u00103\u001A\u000204X\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b5\u00106\"\u0004\b7\u00108R\u001A\u00109\u001A\u00020\u001CX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b9\u0010%\"\u0004\b:\u0010\'R\u0010\u0010;\u001A\u00020<X\u0082\u000E¢\u0006\u0004\n\u0002\u0010=R\u000E\u0010>\u001A\u00020\u001CX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010?\u001A\u00020@X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\bA\u0010BR\u0014\u0010C\u001A\u00020@8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\bD\u0010BR$\u0010E\u001A\u0002042\u0006\u0010#\u001A\u0002048F@FX\u0086\u000E¢\u0006\f\u001A\u0004\bF\u00106\"\u0004\bG\u00108R\u000E\u0010H\u001A\u00020IX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006|"}, d2={"Landroidx/compose/ui/platform/ViewLayer;", "Landroid/view/View;", "Landroidx/compose/ui/node/OwnedLayer;", "Landroidx/compose/ui/layout/GraphicLayerInfo;", "ownerView", "Landroidx/compose/ui/platform/AndroidComposeView;", "container", "Landroidx/compose/ui/platform/DrawChildContainer;", "drawBlock", "Lkotlin/Function2;", "Landroidx/compose/ui/graphics/Canvas;", "Lkotlin/ParameterName;", "name", "canvas", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "parentLayer", "", "invalidateParentLayer", "Lkotlin/Function0;", "<init>", "(Landroidx/compose/ui/platform/AndroidComposeView;Landroidx/compose/ui/platform/DrawChildContainer;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "getOwnerView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "getContainer", "()Landroidx/compose/ui/platform/DrawChildContainer;", "outlineResolver", "Landroidx/compose/ui/platform/OutlineResolver;", "clipToBounds", "", "clipBoundsCache", "Landroid/graphics/Rect;", "manualClipPath", "Landroidx/compose/ui/graphics/Path;", "getManualClipPath", "()Landroidx/compose/ui/graphics/Path;", "value", "isInvalidated", "()Z", "setInvalidated", "(Z)V", "layerPaint", "Landroidx/compose/ui/graphics/Paint;", "drawnWithZ", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "matrixCache", "Landroidx/compose/ui/platform/LayerMatrixCache;", "underlyingMatrix", "Landroidx/compose/ui/graphics/Matrix;", "getUnderlyingMatrix-sQKQjiQ", "()[F", "frameRate", "", "getFrameRate", "()F", "setFrameRate", "(F)V", "isFrameRateFromParent", "setFrameRateFromParent", "mTransformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "J", "mHasOverlappingRendering", "layerId", "", "getLayerId", "()J", "ownerViewId", "getOwnerViewId", "cameraDistancePx", "getCameraDistancePx", "setCameraDistancePx", "mutatedFields", "", "updateLayerProperties", "scope", "Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;", "obtainLayerPaint", "hasOverlappingRendering", "isInLayer", "position", "Landroidx/compose/ui/geometry/Offset;", "isInLayer-k-4lQ0M", "(J)Z", "updateOutlineResolver", "resetClipBounds", "resize", "size", "Landroidx/compose/ui/unit/IntSize;", "resize-ozmzZPI", "(J)V", "move", "Landroidx/compose/ui/unit/IntOffset;", "move--gyyYBs", "drawLayer", "dispatchDraw", "Landroid/graphics/Canvas;", "invalidate", "onLayout", "changed", "l", "t", "r", "b", "destroy", "updateDisplayList", "forceLayout", "mapOffset", "point", "inverse", "mapOffset-8S9VItk", "(JZ)J", "mapBounds", "rect", "Landroidx/compose/ui/geometry/MutableRect;", "reuseLayer", "transform", "matrix", "transform-58bKbWc", "([F)V", "inverseTransform", "inverseTransform-58bKbWc", "UniqueDrawingIdApi29", "Companion", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ViewLayer extends View implements GraphicLayerInfo, OwnedLayer {
    @Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001A\u001A\u00020\b2\u0006\u0010\u001B\u001A\u00020\u0006H\u0007R \u0010\u0004\u001A\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0010\u0010\r\u001A\u0004\u0018\u00010\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u000F\u001A\u0004\u0018\u00010\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R\u001E\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0011\u001A\u00020\u0012@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001A\u00020\u00122\u0006\u0010\u0011\u001A\u00020\u0012@@X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\u0015\"\u0004\b\u0018\u0010\u0019¨\u0006\u001C"}, d2={"Landroidx/compose/ui/platform/ViewLayer$Companion;", "", "<init>", "()V", "getMatrix", "Lkotlin/Function2;", "Landroid/view/View;", "Landroid/graphics/Matrix;", "", "OutlineProvider", "Landroid/view/ViewOutlineProvider;", "getOutlineProvider", "()Landroid/view/ViewOutlineProvider;", "updateDisplayListIfDirtyMethod", "Ljava/lang/reflect/Method;", "recreateDisplayList", "Ljava/lang/reflect/Field;", "value", "", "hasRetrievedMethod", "getHasRetrievedMethod", "()Z", "shouldUseDispatchDraw", "getShouldUseDispatchDraw", "setShouldUseDispatchDraw$ui", "(Z)V", "updateDisplayList", "view", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final boolean getHasRetrievedMethod() {
            return ViewLayer.hasRetrievedMethod;
        }

        public final ViewOutlineProvider getOutlineProvider() {
            return ViewLayer.OutlineProvider;
        }

        public final boolean getShouldUseDispatchDraw() {
            return ViewLayer.shouldUseDispatchDraw;
        }

        public final void setShouldUseDispatchDraw$ui(boolean arg1) {
            ViewLayer.shouldUseDispatchDraw = arg1;
        }

        public final void updateDisplayList(View arg10) {
            try {
                if(!this.getHasRetrievedMethod()) {
                    ViewLayer.hasRetrievedMethod = true;
                    int v1 = Build$VERSION.SDK_INT;
                    goto label_6;
                }

                goto label_45;
            }
            catch(Throwable ) {
                goto label_53;
            }

        label_6:
            String v4 = "mRecreateDisplayList";
            String v5 = "updateDisplayListIfDirty";
            if(v1 < 28) {
                try {
                    Class v1_1 = View.class;
                    ViewLayer.updateDisplayListIfDirtyMethod = v1_1.getDeclaredMethod(v5);
                    ViewLayer.recreateDisplayList = v1_1.getDeclaredField(v4);
                    goto label_39;
                label_17:
                    v1_1 = Class.class;
                    Class[] v6 = new Class[2];
                    Class v7 = String.class;
                    v6[0] = v7;
                    v6[1] = new Class[0].getClass();
                    Method v3 = v1_1.getDeclaredMethod("getDeclaredMethod", v6);
                    Class v6_1 = View.class;
                    ViewLayer.updateDisplayListIfDirtyMethod = v3.invoke(v6_1, v5);
                    ViewLayer.recreateDisplayList = v1_1.getDeclaredMethod("getDeclaredField", v7).invoke(v6_1, v4);
                label_39:
                    Method v1_2 = ViewLayer.updateDisplayListIfDirtyMethod;
                    if(v1_2 != null) {
                        v1_2.setAccessible(true);
                    }

                    Field v1_3 = ViewLayer.recreateDisplayList;
                    if(v1_3 != null) {
                        v1_3.setAccessible(true);
                    }

                label_45:
                    v1_3 = ViewLayer.recreateDisplayList;
                    if(v1_3 != null) {
                        v1_3.setBoolean(arg10, true);
                    }

                    v1_2 = ViewLayer.updateDisplayListIfDirtyMethod;
                    if(v1_2 != null) {
                        v1_2.invoke(arg10);
                    }

                    return;
                }
                catch(Throwable ) {
                label_53:
                    this.setShouldUseDispatchDraw$ui(true);
                    return;
                }
            }
            else {
                goto label_17;
            }

            goto label_39;
        }
    }

    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0007¨\u0006\b"}, d2={"Landroidx/compose/ui/platform/ViewLayer$UniqueDrawingIdApi29;", "", "<init>", "()V", "getUniqueDrawingId", "", "view", "Landroid/view/View;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class UniqueDrawingIdApi29 {
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
    private static final ViewOutlineProvider OutlineProvider;
    private final CanvasHolder canvasHolder;
    private Rect clipBoundsCache;
    private boolean clipToBounds;
    private final DrawChildContainer container;
    private Function2 drawBlock;
    private boolean drawnWithZ;
    private float frameRate;
    private static final Function2 getMatrix;
    private static boolean hasRetrievedMethod;
    private Function0 invalidateParentLayer;
    private boolean isFrameRateFromParent;
    private boolean isInvalidated;
    private final long layerId;
    private Paint layerPaint;
    private boolean mHasOverlappingRendering;
    private long mTransformOrigin;
    private final LayerMatrixCache matrixCache;
    private int mutatedFields;
    private final OutlineResolver outlineResolver;
    private final AndroidComposeView ownerView;
    private static Field recreateDisplayList;
    private static boolean shouldUseDispatchDraw;
    private static Method updateDisplayListIfDirtyMethod;

    static {
        ViewLayer.Companion = new Companion(null);
        ViewLayer.$stable = 8;
        ViewLayer.getMatrix = ViewLayer$Companion$getMatrix$1.INSTANCE;
        ViewLayer.OutlineProvider = new ViewLayer$Companion$OutlineProvider$1();
    }

    public ViewLayer(AndroidComposeView arg2, DrawChildContainer arg3, Function2 arg4, Function0 arg5) {
        super(arg2.getContext());
        this.ownerView = arg2;
        this.container = arg3;
        this.drawBlock = arg4;
        this.invalidateParentLayer = arg5;
        this.outlineResolver = new OutlineResolver();
        this.canvasHolder = new CanvasHolder();
        this.matrixCache = new LayerMatrixCache(ViewLayer.getMatrix);
        this.mTransformOrigin = TransformOrigin.Companion.getCenter-SzJe1aQ();
        this.mHasOverlappingRendering = true;
        this.setWillNotDraw(false);
        arg3.addView(this);
        this.layerId = ((long)View.generateViewId());
    }

    public static final boolean access$getHasRetrievedMethod$cp() {
        return ViewLayer.hasRetrievedMethod;
    }

    public static final ViewOutlineProvider access$getOutlineProvider$cp() {
        return ViewLayer.OutlineProvider;
    }

    public static final OutlineResolver access$getOutlineResolver$p(ViewLayer arg0) {
        return arg0.outlineResolver;
    }

    public static final Field access$getRecreateDisplayList$cp() {
        return ViewLayer.recreateDisplayList;
    }

    public static final boolean access$getShouldUseDispatchDraw$cp() {
        return ViewLayer.shouldUseDispatchDraw;
    }

    public static final Method access$getUpdateDisplayListIfDirtyMethod$cp() {
        return ViewLayer.updateDisplayListIfDirtyMethod;
    }

    public static final void access$setHasRetrievedMethod$cp(boolean arg0) {
        ViewLayer.hasRetrievedMethod = arg0;
    }

    public static final void access$setRecreateDisplayList$cp(Field arg0) {
        ViewLayer.recreateDisplayList = arg0;
    }

    public static final void access$setShouldUseDispatchDraw$cp(boolean arg0) {
        ViewLayer.shouldUseDispatchDraw = arg0;
    }

    public static final void access$setUpdateDisplayListIfDirtyMethod$cp(Method arg0) {
        ViewLayer.updateDisplayListIfDirtyMethod = arg0;
    }

    public void destroy() {
        this.setInvalidated(false);
        this.ownerView.requestClearInvalidObservations();
        this.drawBlock = null;
        this.invalidateParentLayer = null;
        this.ownerView.recycle$ui(this);
        this.container.removeViewInLayout(((View)this));
    }

    protected void dispatchDraw(Canvas arg7) {
        int v7;
        CanvasHolder v0 = this.canvasHolder;
        Canvas v1 = v0.getAndroidCanvas().getInternalCanvas();
        v0.getAndroidCanvas().setInternalCanvas(arg7);
        AndroidCanvas v2 = v0.getAndroidCanvas();
        if(this.getManualClipPath() != null || !arg7.isHardwareAccelerated()) {
            ((androidx.compose.ui.graphics.Canvas)v2).save();
            this.outlineResolver.clipToOutline(((androidx.compose.ui.graphics.Canvas)v2));
            v7 = 1;
        }
        else {
            v7 = 0;
        }

        Function2 v3 = this.drawBlock;
        if(v3 != null) {
            v3.invoke(v2, null);
        }

        if(v7 != 0) {
            ((androidx.compose.ui.graphics.Canvas)v2).restore();
        }

        v0.getAndroidCanvas().setInternalCanvas(v1);
        this.setInvalidated(false);
    }

    public void drawLayer(androidx.compose.ui.graphics.Canvas arg4, GraphicsLayer arg5) {
        boolean v5 = this.getElevation() > 0f ? true : false;
        this.drawnWithZ = v5;
        if(v5) {
            arg4.enableZ();
        }

        this.container.drawChild$ui(arg4, this, this.getDrawingTime());
        if(this.drawnWithZ) {
            arg4.disableZ();
        }
    }

    public void forceLayout() {
    }

    public final float getCameraDistancePx() {
        return this.getCameraDistance() / (((float)this.getResources().getDisplayMetrics().densityDpi));
    }

    public final DrawChildContainer getContainer() {
        return this.container;
    }

    public float getFrameRate() {
        return this.frameRate;
    }

    public long getLayerId() {
        return this.layerId;
    }

    private final Path getManualClipPath() {
        if(this.getClipToOutline()) {
            if(this.outlineResolver.getOutlineClipSupported()) {
            }
            else {
                return this.outlineResolver.getClipPath();
            }
        }

        return null;
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
        return this.matrixCache.calculateMatrix-GrdbGEg(this);
    }

    public boolean hasOverlappingRendering() {
        return this.mHasOverlappingRendering;
    }

    public void invalidate() {
        if(!this.isInvalidated) {
            this.setInvalidated(true);
            super.invalidate();
            this.ownerView.invalidate();
        }
    }

    public void inverseTransform-58bKbWc(float[] arg2) {
        float[] v1 = this.matrixCache.calculateInverseMatrix-bWbORWo(this);
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
        if(this.clipToBounds) {
            if(0f <= v0 && v0 < (((float)this.getWidth())) && 0f <= v1 && v1 < (((float)this.getHeight()))) {
                return 1;
            }

            return 0;
        }

        if(this.getClipToOutline()) {
            return this.outlineResolver.isInOutline-k-4lQ0M(arg5);
        }

        return 1;
    }

    public final boolean isInvalidated() {
        return this.isInvalidated;
    }

    public void mapBounds(MutableRect arg2, boolean arg3) {
        LayerMatrixCache v0 = this.matrixCache;
        if(arg3) {
            v0.mapInverse(this, arg2);
            return;
        }

        v0.map(this, arg2);
    }

    public long mapOffset-8S9VItk(long arg2, boolean arg4) {
        LayerMatrixCache v0 = this.matrixCache;
        if(arg4) {
            return v0.mapInverse-R5De75A(this, arg2);
        }

        return v0.map-R5De75A(this, arg2);
    }

    public void move--gyyYBs(long arg3) {
        int v0 = IntOffset.getX-impl(arg3);
        if(v0 != this.getLeft()) {
            this.offsetLeftAndRight(v0 - this.getLeft());
            this.matrixCache.invalidate();
        }

        int v3 = IntOffset.getY-impl(arg3);
        if(v3 != this.getTop()) {
            this.offsetTopAndBottom(v3 - this.getTop());
            this.matrixCache.invalidate();
        }
    }

    private final Paint obtainLayerPaint() {
        Paint v0 = this.layerPaint;
        if(v0 == null) {
            v0 = AndroidPaint_androidKt.Paint();
            this.layerPaint = v0;
        }

        return v0;
    }

    protected void onLayout(boolean arg1, int arg2, int arg3, int arg4, int arg5) {
    }

    private final void resetClipBounds() {
        Rect v0;
        if(this.clipToBounds) {
            v0 = this.clipBoundsCache;
            if(v0 == null) {
                this.clipBoundsCache = new Rect(0, 0, this.getWidth(), this.getHeight());
            }
            else {
                Intrinsics.checkNotNull(v0);
                v0.set(0, 0, this.getWidth(), this.getHeight());
            }

            v0 = this.clipBoundsCache;
        }
        else {
            v0 = null;
        }

        this.setClipBounds(v0);
    }

    public void resize-ozmzZPI(long arg4) {
        int v0 = ((int)(arg4 >> 0x20));
        int v4 = ((int)(arg4 & 0xFFFFFFFFL));
        if(v0 == this.getWidth()) {
            if(v4 != this.getHeight()) {
            }
            else {
                return;
            }
        }

        this.setPivotX(TransformOrigin.getPivotFractionX-impl(this.mTransformOrigin) * (((float)v0)));
        this.setPivotY(TransformOrigin.getPivotFractionY-impl(this.mTransformOrigin) * (((float)v4)));
        this.updateOutlineResolver();
        this.layout(this.getLeft(), this.getTop(), this.getLeft() + v0, this.getTop() + v4);
        this.resetClipBounds();
        this.matrixCache.invalidate();
    }

    public void reuseLayer(Function2 arg4, Function0 arg5) {
        this.container.addView(this);
        this.matrixCache.reset();
        this.clipToBounds = false;
        this.drawnWithZ = false;
        this.mTransformOrigin = TransformOrigin.Companion.getCenter-SzJe1aQ();
        this.drawBlock = arg4;
        this.invalidateParentLayer = arg5;
        this.setInvalidated(false);
    }

    public final void setCameraDistancePx(float arg2) {
        this.setCameraDistance(arg2 * (((float)this.getResources().getDisplayMetrics().densityDpi)));
    }

    public void setFrameRate(float arg1) {
        this.frameRate = arg1;
    }

    public void setFrameRateFromParent(boolean arg1) {
        this.isFrameRateFromParent = arg1;
    }

    private final void setInvalidated(boolean arg2) {
        if(arg2 != this.isInvalidated) {
            this.isInvalidated = arg2;
            this.ownerView.notifyLayerIsDirty$ui(((OwnedLayer)this), arg2);
        }
    }

    public void transform-58bKbWc(float[] arg2) {
        Matrix.timesAssign-58bKbWc(arg2, this.matrixCache.calculateMatrix-GrdbGEg(this));
    }

    public void updateDisplayList() {
        if((this.isInvalidated) && !ViewLayer.shouldUseDispatchDraw) {
            ViewLayer.Companion.updateDisplayList(this);
            this.setInvalidated(false);
        }
    }

    public void updateLayerProperties(ReusableGraphicsLayerScope arg14) {
        boolean v4;
        int v0 = arg14.getMutatedFields$ui() | this.mutatedFields;
        if((v0 & 0x1000) != 0) {
            long v1 = arg14.getTransformOrigin-SzJe1aQ();
            this.mTransformOrigin = v1;
            this.setPivotX(TransformOrigin.getPivotFractionX-impl(v1) * (((float)this.getWidth())));
            this.setPivotY(TransformOrigin.getPivotFractionY-impl(this.mTransformOrigin) * (((float)this.getHeight())));
        }

        if((v0 & 1) != 0) {
            this.setScaleX(arg14.getScaleX());
        }

        if((v0 & 2) != 0) {
            this.setScaleY(arg14.getScaleY());
        }

        if((v0 & 4) != 0) {
            this.setAlpha(arg14.getAlpha());
        }

        if((v0 & 8) != 0) {
            this.setTranslationX(arg14.getTranslationX());
        }

        if((v0 & 16) != 0) {
            this.setTranslationY(arg14.getTranslationY());
        }

        if((v0 & 0x20) != 0) {
            this.setElevation(arg14.getShadowElevation());
        }

        if((v0 & 0x400) != 0) {
            this.setRotation(arg14.getRotationZ());
        }

        if((v0 & 0x100) != 0) {
            this.setRotationX(arg14.getRotationX());
        }

        if((v0 & 0x200) != 0) {
            this.setRotationY(arg14.getRotationY());
        }

        if((v0 & 0x800) != 0) {
            this.setCameraDistancePx(arg14.getCameraDistance());
        }

        boolean v2 = false;
        int v1_1 = this.getManualClipPath() != null ? 1 : 0;
        boolean v9 = !arg14.getClip() || arg14.getShape() == RectangleShapeKt.getRectangleShape() ? false : true;
        if((v0 & 0x6000) != 0) {
            v4 = !arg14.getClip() || arg14.getShape() != RectangleShapeKt.getRectangleShape() ? false : true;
            this.clipToBounds = v4;
            this.resetClipBounds();
            this.setClipToOutline(v9);
        }

        v4 = this.outlineResolver.update-S_szKao(arg14.getOutline$ui(), arg14.getAlpha(), v9, arg14.getShadowElevation(), arg14.getSize-NH-jbRc());
        if(this.outlineResolver.getCacheIsDirty$ui()) {
            this.updateOutlineResolver();
        }

        int v5 = this.getManualClipPath() != null ? 1 : 0;
        if(v1_1 != v5 || v5 != 0 && (v4)) {
            this.invalidate();
        }

        if(!this.drawnWithZ && this.getElevation() > 0f) {
            Function0 v1_2 = this.invalidateParentLayer;
            if(v1_2 != null) {
                v1_2.invoke();
            }
        }

        if((v0 & 0x1F1B) != 0) {
            this.matrixCache.invalidate();
        }

        if(Build$VERSION.SDK_INT >= 28) {
            if((v0 & 0x40) != 0) {
                ViewLayerVerificationHelper28.INSTANCE.setOutlineAmbientShadowColor(this, ColorKt.toArgb-8_81llA(arg14.getAmbientShadowColor-0d7_KjU()));
            }

            if((v0 & 0x80) == 0) {
                goto label_134;
            }

            ViewLayerVerificationHelper28.INSTANCE.setOutlineSpotShadowColor(this, ColorKt.toArgb-8_81llA(arg14.getSpotShadowColor-0d7_KjU()));
        }

    label_134:
        if(Build$VERSION.SDK_INT >= 0x1F && (0x20000 & v0) != 0) {
            ViewLayerVerificationHelper31.INSTANCE.setRenderEffect(this, arg14.getRenderEffect());
        }

        v1_1 = (0x40000 & v0) != 0 || (0x80000 & v0) != 0 ? 1 : 0;
        if((v0 & 0x8000) != 0 || v1_1 != 0) {
            v0 = v1_1 != 0 ? CompositingStrategy.Companion.getOffscreen--NrFUSI() : arg14.getCompositingStrategy--NrFUSI();
            android.graphics.Paint v5_1 = null;
            if(CompositingStrategy.equals-impl0(v0, CompositingStrategy.Companion.getOffscreen--NrFUSI())) {
                if(v1_1 != 0) {
                    Paint v0_1 = this.obtainLayerPaint();
                    v0_1.setColorFilter(arg14.getColorFilter());
                    v0_1.setBlendMode-s9anfk8(arg14.getBlendMode-0nO6VwU());
                    v5_1 = v0_1.asFrameworkPaint();
                }

                this.setLayerType(2, v5_1);
                goto label_185;
            }
            else {
                if(CompositingStrategy.equals-impl0(v0, CompositingStrategy.Companion.getModulateAlpha--NrFUSI())) {
                    this.setLayerType(0, v5_1);
                    goto label_186;
                }

                this.setLayerType(0, v5_1);
            label_185:
                v2 = true;
            }

        label_186:
            this.mHasOverlappingRendering = v2;
        }

        this.mutatedFields = arg14.getMutatedFields$ui();
    }

    private final void updateOutlineResolver() {
        ViewOutlineProvider v0 = this.outlineResolver.getAndroidOutline() != null ? ViewLayer.OutlineProvider : null;
        this.setOutlineProvider(v0);
    }
}

