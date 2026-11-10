package androidx.compose.ui.graphics;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build$VERSION;
import android.view.View$OnAttachStateChangeListener;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerImpl;
import androidx.compose.ui.graphics.layer.GraphicsLayerV23;
import androidx.compose.ui.graphics.layer.GraphicsLayerV29;
import androidx.compose.ui.graphics.layer.GraphicsViewLayer;
import androidx.compose.ui.graphics.layer.view.DrawChildContainer;
import androidx.compose.ui.graphics.layer.view.ViewLayerContainer;
import androidx.compose.ui.graphics.shadow.AndroidShadowContext_androidKt;
import androidx.compose.ui.graphics.shadow.ShadowContext;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000 \"2\u00020\u0001:\u0002\"#B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0010\u001A\u00020\u0011H\u0002J\u0010\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0013\u001A\u00020\u0014H\u0002J\u0010\u0010\u0015\u001A\u00020\u00112\u0006\u0010\u0013\u001A\u00020\u0014H\u0002J\b\u0010\u0016\u001A\u00020\u0017H\u0016J\u0010\u0010\u001B\u001A\u00020\u00112\u0006\u0010\u001C\u001A\u00020\u0017H\u0016J\u0010\u0010\u001D\u001A\u00020\t2\u0006\u0010\u0002\u001A\u00020\u0003H\u0002J\u0010\u0010\u001E\u001A\u00020\u001F2\u0006\u0010 \u001A\u00020!H\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001A\u0004\u0018\u00010\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001A\u0004\u0018\u00010\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u000FX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001A\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u001A¨\u0006$"}, d2={"Landroidx/compose/ui/graphics/AndroidGraphicsContext;", "Landroidx/compose/ui/graphics/GraphicsContext;", "ownerView", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "lock", "", "viewLayerContainer", "Landroidx/compose/ui/graphics/layer/view/DrawChildContainer;", "componentCallbackRegistered", "", "shadowCache", "Landroidx/compose/ui/graphics/shadow/ShadowContext;", "componentCallback", "Landroid/content/ComponentCallbacks2;", "clearShadowCache", "", "registerComponentCallback", "context", "Landroid/content/Context;", "unregisterComponentCallback", "createGraphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "shadowContext", "getShadowContext", "()Landroidx/compose/ui/graphics/shadow/ShadowContext;", "releaseGraphicsLayer", "layer", "obtainViewLayerContainer", "getUniqueDrawingId", "", "view", "Landroid/view/View;", "Companion", "UniqueDrawingIdApi29", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) final class AndroidGraphicsContext implements GraphicsContext {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001A\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2={"Landroidx/compose/ui/graphics/AndroidGraphicsContext$Companion;", "", "<init>", "()V", "isRenderNodeCompatible", "", "()Z", "setRenderNodeCompatible", "(Z)V", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final boolean isRenderNodeCompatible() {
            return AndroidGraphicsContext.isRenderNodeCompatible;
        }

        public final void setRenderNodeCompatible(boolean arg1) {
            AndroidGraphicsContext.isRenderNodeCompatible = arg1;
        }
    }

    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0007¨\u0006\b"}, d2={"Landroidx/compose/ui/graphics/AndroidGraphicsContext$UniqueDrawingIdApi29;", "", "<init>", "()V", "getUniqueDrawingId", "", "view", "Landroid/view/View;", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) final class UniqueDrawingIdApi29 {
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

    public static final Companion Companion;
    private final ComponentCallbacks2 componentCallback;
    private boolean componentCallbackRegistered;
    private static boolean isRenderNodeCompatible;
    private final Object lock;
    private final ViewGroup ownerView;
    private ShadowContext shadowCache;
    private DrawChildContainer viewLayerContainer;

    static {
        AndroidGraphicsContext.Companion = new Companion(null);
        AndroidGraphicsContext.isRenderNodeCompatible = true;
    }

    public AndroidGraphicsContext(ViewGroup arg2) {
        super();
        this.ownerView = arg2;
        this.lock = new Object();
        this.componentCallback = new ComponentCallbacks2() {
            public void onConfigurationChanged(Configuration arg1) {
            }

            public void onLowMemory() {
            }

            public void onTrimMemory(int arg2) {
                if(arg2 >= 40) {
                    AndroidGraphicsContext.access$clearShadowCache(AndroidGraphicsContext.this);
                }
            }
        };
        if(arg2.isAttachedToWindow()) {
            this.registerComponentCallback(arg2.getContext());
        }

        arg2.addOnAttachStateChangeListener(new View$OnAttachStateChangeListener() {
            public void onViewAttachedToWindow(View arg1) {
                AndroidGraphicsContext.access$registerComponentCallback(AndroidGraphicsContext.this, arg1.getContext());
            }

            public void onViewDetachedFromWindow(View arg2) {
                AndroidGraphicsContext.access$unregisterComponentCallback(AndroidGraphicsContext.this, arg2.getContext());
                AndroidGraphicsContext.access$clearShadowCache(AndroidGraphicsContext.this);
            }
        });
    }

    public static final void access$clearShadowCache(AndroidGraphicsContext arg0) {
        arg0.clearShadowCache();
    }

    public static final boolean access$isRenderNodeCompatible$cp() {
        return AndroidGraphicsContext.isRenderNodeCompatible;
    }

    public static final void access$registerComponentCallback(AndroidGraphicsContext arg0, Context arg1) {
        arg0.registerComponentCallback(arg1);
    }

    public static final void access$setRenderNodeCompatible$cp(boolean arg0) {
        AndroidGraphicsContext.isRenderNodeCompatible = arg0;
    }

    public static final void access$unregisterComponentCallback(AndroidGraphicsContext arg0, Context arg1) {
        arg0.unregisterComponentCallback(arg1);
    }

    private final void clearShadowCache() {
        ShadowContext v0 = this.shadowCache;
        if(v0 != null) {
            v0.clearCache();
        }

        this.shadowCache = null;
    }

    public GraphicsLayer createGraphicsLayer() {
        GraphicsLayer v10;
        long v4;
        Object v1 = this.lock;
        __monitor_enter(v1);
        try {
            v4 = this.getUniqueDrawingId(this.ownerView);
            if(Build$VERSION.SDK_INT >= 29) {
                GraphicsLayerV29 v2 = new GraphicsLayerV29(v4, null, null, 6, null);
                goto label_46;
            }

            if(!AndroidGraphicsContext.isRenderNodeCompatible) {
                goto label_37;
            }
        }
        catch(Throwable v0) {
            goto label_51;
        }

        try {
            GraphicsLayerV23 v2_1 = new GraphicsLayerV23(this.ownerView, v4, null, null, 12, null);
            goto label_46;
        }
        catch(Throwable ) {
            try {
                AndroidGraphicsContext.isRenderNodeCompatible = false;
                GraphicsViewLayer v2_2 = new GraphicsViewLayer(this.obtainViewLayerContainer(this.ownerView), v4, null, null, 12, null);
                goto label_46;
            label_37:
                v2_2 = new GraphicsViewLayer(this.obtainViewLayerContainer(this.ownerView), v4, null, null, 12, null);
            label_46:
                v10 = new GraphicsLayer(((GraphicsLayerImpl)v2_2));
            }
            catch(Throwable v0) {
            label_51:
                __monitor_exit(v1);
                throw v0;
            }
        }

        __monitor_exit(v1);
        return v10;
    }

    public ShadowContext getShadowContext() {
        ShadowContext v0 = this.shadowCache;
        if(v0 == null) {
            v0 = AndroidShadowContext_androidKt.ShadowContext();
            this.shadowCache = v0;
        }

        return v0;
    }

    private final long getUniqueDrawingId(View arg2) {
        if(Build$VERSION.SDK_INT >= 29) {
            return UniqueDrawingIdApi29.getUniqueDrawingId(arg2);
        }

        return -1;
    }

    private final DrawChildContainer obtainViewLayerContainer(ViewGroup arg3) {
        DrawChildContainer v0 = this.viewLayerContainer;
        if(v0 == null) {
            ViewLayerContainer v1 = new ViewLayerContainer(arg3.getContext());
            arg3.addView(v1);
            this.viewLayerContainer = ((DrawChildContainer)v1);
            return ((DrawChildContainer)v1);
        }

        return v0;
    }

    private final void registerComponentCallback(Context arg2) {
        if(!this.componentCallbackRegistered) {
            arg2.getApplicationContext().registerComponentCallbacks(this.componentCallback);
            this.componentCallbackRegistered = true;
        }
    }

    public void releaseGraphicsLayer(GraphicsLayer arg1) {
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            arg1.release$ui_graphics();
        }
        catch(Throwable v1) {
            __monitor_exit(v0);
            throw v1;
        }

        __monitor_exit(v0);
    }

    private final void unregisterComponentCallback(Context arg2) {
        if(this.componentCallbackRegistered) {
            arg2.getApplicationContext().unregisterComponentCallbacks(this.componentCallback);
            this.componentCallbackRegistered = false;
        }
    }
}

