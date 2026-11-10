package com.TryJeanPc.goldenmouse.cursor;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import android.view.View$OnLayoutChangeListener;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager$LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000}\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001#\b\u0007\u0018\u0000 ;2\u00020\u0001:\u0001;B7\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u000B\u0012\u0006\u0010\f\u001A\u00020\u000B¢\u0006\u0004\b\r\u0010\u000EJ\u0016\u0010*\u001A\u00020+2\u0006\u0010,\u001A\u00020\u000B2\u0006\u0010-\u001A\u00020\u000BJ\u000E\u0010.\u001A\u00020+2\u0006\u0010/\u001A\u00020\u0013J\b\u00100\u001A\u00020+H\u0002J\u0016\u00101\u001A\u00020+2\u0006\u00102\u001A\u00020\u000B2\u0006\u00103\u001A\u00020\u000BJ\u0016\u00104\u001A\u00020+2\u0006\u00105\u001A\u00020\u000B2\u0006\u00106\u001A\u00020\u000BJ\u0012\u00107\u001A\u000E\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u000B08J\b\u00109\u001A\u00020+H\u0002J\u0006\u0010:\u001A\u00020+R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0013X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\u0013X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0017\u001A\u00020\u0013X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001A\u0004\u0018\u00010\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001A\u001A\u00020\u001BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001C\u001A\u00020\u001DX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001E\u001A\u00020\u001FX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010 \u001A\u00020!X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001A\u00020#X\u0082\u0004¢\u0006\u0004\n\u0002\u0010$R\u000E\u0010%\u001A\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\'\u001A\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010(\u001A\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, d2={"Lcom/TryJeanPc/goldenmouse/cursor/GoldenCursorRenderer;", "", "windowManager", "Landroid/view/WindowManager;", "cursorView", "Landroid/widget/ImageView;", "layoutParams", "Landroid/view/WindowManager$LayoutParams;", "mainHandler", "Landroid/os/Handler;", "maxX", "", "maxY", "<init>", "(Landroid/view/WindowManager;Landroid/widget/ImageView;Landroid/view/WindowManager$LayoutParams;Landroid/os/Handler;FF)V", "lock", "targetX", "targetY", "frameScheduled", "", "active", "lastRenderFrameNanos", "", "builtInImageHotspot", "overlayHost", "Landroid/view/View;", "hostLocation", "", "mappedImageHotspot", "", "mappedImageBounds", "Landroid/graphics/RectF;", "hotspotLimits", "Lcom/TryJeanPc/goldenmouse/cursor/CursorGeometry$Rectangle;", "frameCallback", "com/TryJeanPc/goldenmouse/cursor/GoldenCursorRenderer$frameCallback$1", "Lcom/TryJeanPc/goldenmouse/cursor/GoldenCursorRenderer$frameCallback$1;", "scheduleFrame", "Ljava/lang/Runnable;", "applyLatestPosition", "layoutListener", "Landroid/view/View$OnLayoutChangeListener;", "updateBounds", "", "newMaxX", "newMaxY", "setBuiltInImageHotspot", "enabled", "requestFrame", "moveBy", "dx", "dy", "moveTo", "x", "y", "currentHotspot", "Lkotlin/Pair;", "applyLatestPositionOnMain", "stop", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GoldenCursorRenderer {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2={"Lcom/TryJeanPc/goldenmouse/cursor/GoldenCursorRenderer$Companion;", "", "<init>", "()V", "MAX_RENDER_HZ", "", "NANOS_PER_SECOND", "MIN_FRAME_INTERVAL_NANOS", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    public static final int $stable = 0;
    private static final Companion Companion = null;
    @Deprecated public static final long MAX_RENDER_HZ = 120;
    @Deprecated public static final long MIN_FRAME_INTERVAL_NANOS = 0x7F2815;
    @Deprecated public static final long NANOS_PER_SECOND = 1000000000;
    private boolean active;
    private final Runnable applyLatestPosition;
    private boolean builtInImageHotspot;
    private final ImageView cursorView;
    private final GoldenCursorRenderer$frameCallback$1 frameCallback;
    private boolean frameScheduled;
    private final int[] hostLocation;
    private Rectangle hotspotLimits;
    private long lastRenderFrameNanos;
    private final View$OnLayoutChangeListener layoutListener;
    private final WindowManager$LayoutParams layoutParams;
    private final Object lock;
    private final Handler mainHandler;
    private final RectF mappedImageBounds;
    private final float[] mappedImageHotspot;
    private volatile float maxX;
    private volatile float maxY;
    private final View overlayHost;
    private final Runnable scheduleFrame;
    private float targetX;
    private float targetY;
    private final WindowManager windowManager;

    static {
        GoldenCursorRenderer.Companion = new Companion(null);
        GoldenCursorRenderer.$stable = 8;
    }

    public GoldenCursorRenderer(WindowManager arg4, ImageView arg5, WindowManager$LayoutParams arg6, Handler arg7, float arg8, float arg9) {
        Intrinsics.checkNotNullParameter(arg4, "windowManager");
        Intrinsics.checkNotNullParameter(arg5, "cursorView");
        Intrinsics.checkNotNullParameter(arg6, "layoutParams");
        Intrinsics.checkNotNullParameter(arg7, "mainHandler");
        super();
        this.windowManager = arg4;
        this.cursorView = arg5;
        this.layoutParams = arg6;
        this.mainHandler = arg7;
        this.maxX = arg8;
        this.maxY = arg9;
        this.lock = new Object();
        this.targetX = arg5.getTranslationX();
        this.targetY = arg5.getTranslationY();
        this.active = true;
        this.builtInImageHotspot = true;
        ViewParent v7 = arg5.getParent();
        if((v7 instanceof View)) {
        }
        else {
            View v7_1 = null;
        }

        this.overlayHost = ((View)v7);
        this.hostLocation = new int[2];
        this.mappedImageHotspot = new float[2];
        this.mappedImageBounds = new RectF();
        this.hotspotLimits = new Rectangle(0f, 0f, this.maxX, this.maxY);
        this.frameCallback = new GoldenCursorRenderer$frameCallback$1(this);
        this.scheduleFrame = new GoldenCursorRenderer$$ExternalSyntheticLambda1(this);
        this.applyLatestPosition = new GoldenCursorRenderer$$ExternalSyntheticLambda2(this);
        GoldenCursorRenderer$$ExternalSyntheticLambda3 v8 = new GoldenCursorRenderer$$ExternalSyntheticLambda3(this);
        this.layoutListener = ((View$OnLayoutChangeListener)v8);
        this.maxX = CursorGeometry.INSTANCE.lastPixel(this.maxX);
        this.maxY = CursorGeometry.INSTANCE.lastPixel(this.maxY);
        this.hotspotLimits = new Rectangle(0f, 0f, this.maxX, this.maxY);
        this.targetX = RangesKt.coerceIn(this.targetX, 0f, this.maxX);
        this.targetY = RangesKt.coerceIn(this.targetY, 0f, this.maxY);
        if(Build$VERSION.SDK_INT >= 30) {
            arg6.layoutInDisplayCutoutMode = 3;
        }
        else if(Build$VERSION.SDK_INT >= 28) {
            arg6.layoutInDisplayCutoutMode = 1;
        }

        arg6.flags |= 0x300;
        arg5.addOnLayoutChangeListener(((View$OnLayoutChangeListener)v8));
        if(v7 != null) {
            ((View)v7).addOnLayoutChangeListener(((View$OnLayoutChangeListener)v8));
        }
    }

    public static final void access$applyLatestPositionOnMain(GoldenCursorRenderer arg0) {
        arg0.applyLatestPositionOnMain();
    }

    public static final boolean access$getActive$p(GoldenCursorRenderer arg0) {
        return arg0.active;
    }

    public static final long access$getLastRenderFrameNanos$p(GoldenCursorRenderer arg2) {
        return arg2.lastRenderFrameNanos;
    }

    public static final Object access$getLock$p(GoldenCursorRenderer arg0) {
        return arg0.lock;
    }

    public static final void access$setFrameScheduled$p(GoldenCursorRenderer arg0, boolean arg1) {
        arg0.frameScheduled = arg1;
    }

    public static final void access$setLastRenderFrameNanos$p(GoldenCursorRenderer arg0, long arg1) {
        arg0.lastRenderFrameNanos = arg1;
    }

    static final void applyLatestPosition$lambda$2(GoldenCursorRenderer arg0) {
        arg0.applyLatestPositionOnMain();
    }

    private final void applyLatestPositionOnMain() {
        Point v7_3;
        boolean v0_1;
        if(this.cursorView.getWidth() > 0 && this.cursorView.getHeight() > 0) {
            if(!this.cursorView.isAttachedToWindow()) {
            }
            else {
                Object v1 = this.lock;
                __monitor_enter(v1);
                try {
                    if(!this.active) {
                    }
                    else {
                        goto label_16;
                    }
                }
                catch(Throwable v0) {
                    goto label_204;
                }

                __monitor_exit(v1);
                return;
                try {
                label_16:
                    v0_1 = this.builtInImageHotspot;
                }
                catch(Throwable v0) {
                label_204:
                    __monitor_exit(v1);
                    throw v0;
                }

                __monitor_exit(v1);
                Drawable v1_1 = this.cursorView.getDrawable();
                if(v1_1 == null) {
                }
                else if(v1_1.getIntrinsicWidth() > 0) {
                    if(v1_1.getIntrinsicHeight() <= 0) {
                    }
                    else {
                        Point v2 = CursorGeometry.INSTANCE.imageHotspot(v1_1.getIntrinsicWidth(), v1_1.getIntrinsicHeight(), v0_1);
                        this.mappedImageHotspot[0] = v2.getX();
                        this.mappedImageHotspot[1] = v2.getY();
                        this.cursorView.getImageMatrix().mapPoints(this.mappedImageHotspot);
                        Rectangle v0_2 = (v0_1) || !(v1_1 instanceof CursorBitmapDrawable) ? CursorGeometry.INSTANCE.imageBounds(v1_1.getIntrinsicWidth(), v1_1.getIntrinsicHeight(), v0_1) : CursorGeometry.INSTANCE.imageBounds(((CursorBitmapDrawable)v1_1).getImageWidth$app(), ((CursorBitmapDrawable)v1_1).getImageHeight$app(), false);
                        this.mappedImageBounds.set(v0_2.getLeft(), v0_2.getTop(), v0_2.getRight(), v0_2.getBottom());
                        this.cursorView.getImageMatrix().mapRect(this.mappedImageBounds);
                        this.mappedImageBounds.offset(((float)this.cursorView.getPaddingLeft()), ((float)this.cursorView.getPaddingTop()));
                        View v0_3 = this.overlayHost;
                        if(v0_3 != null) {
                            v0_3.getLocationOnScreen(this.hostLocation);
                        }

                        Point v8 = new Point(this.mappedImageHotspot[0] + (((float)this.cursorView.getPaddingLeft())), this.mappedImageHotspot[1] + (((float)this.cursorView.getPaddingTop())));
                        v1 = this.lock;
                        __monitor_enter(v1);
                        try {
                            if(this.active) {
                                goto label_98;
                            }
                        }
                        catch(Throwable v0) {
                            goto label_200;
                        }

                        __monitor_exit(v1);
                        return;
                        try {
                        label_98:
                            float v0_4 = RangesKt.coerceAtLeast(((float)this.hostLocation[0]), 0f);
                            float v2_1 = RangesKt.coerceAtLeast(((float)this.hostLocation[1]), 0f);
                            float v6 = 1f;
                            float v3 = this.maxX + v6;
                            View v7 = this.overlayHost;
                            float v7_1 = v7 != null ? ((float)(this.hostLocation[0] + v7.getWidth())) : this.maxX + v6;
                            v3 = Math.min(v3, v7_1);
                            v7_1 = this.maxY + v6;
                            View v9 = this.overlayHost;
                            if(v9 != null) {
                                v6 = ((float)(this.hostLocation[1] + v9.getHeight()));
                            }
                            else {
                                v6 += this.maxY;
                            }

                            Rectangle v7_2 = new Rectangle(v0_4, v2_1, v3, Math.min(v7_1, v6));
                            if(v7_2.getRight() > v7_2.getLeft()) {
                                if(v7_2.getBottom() <= v7_2.getTop()) {
                                }
                                else {
                                    v0_2 = CursorGeometry.INSTANCE.hotspotBounds(v7_2, new Rectangle(this.mappedImageBounds.left, this.mappedImageBounds.top, this.mappedImageBounds.right, this.mappedImageBounds.bottom), v8);
                                    this.hotspotLimits = v0_2;
                                    this.targetX = RangesKt.coerceIn(this.targetX, v0_2.getLeft(), this.hotspotLimits.getRight());
                                    this.targetY = RangesKt.coerceIn(this.targetY, this.hotspotLimits.getTop(), this.hotspotLimits.getBottom());
                                    v7_3 = new Point(this.targetX, this.targetY);
                                    goto label_173;
                                }
                            }

                            goto label_196;
                        }
                        catch(Throwable v0) {
                        label_200:
                            __monitor_exit(v1);
                            throw v0;
                        }

                    label_173:
                        __monitor_exit(v1);
                        Point v0_5 = CursorGeometry.INSTANCE.translation(v7_3, v8, new Point(((float)this.hostLocation[0]), ((float)this.hostLocation[1])), ((float)this.cursorView.getLeft()), ((float)this.cursorView.getTop()));
                        this.cursorView.setTranslationX(v0_5.getX());
                        this.cursorView.setTranslationY(v0_5.getY());
                        return;
                    label_196:
                        __monitor_exit(v1);
                        return;
                    }
                }
            }
        }
    }

    public final Pair currentHotspot() {
        Pair v2_1;
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            v2_1 = TuplesKt.to(Float.valueOf(this.targetX), Float.valueOf(this.targetY));
        }
        catch(Throwable v2) {
            __monitor_exit(v0);
            throw v2;
        }

        __monitor_exit(v0);
        return v2_1;
    }

    static final void layoutListener$lambda$3(GoldenCursorRenderer arg0, View arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9) {
        arg0.applyLatestPositionOnMain();
        arg0.requestFrame();
    }

    public final void moveBy(float arg4, float arg5) {
        float v1 = 3.402823E+38f;
        if(Math.abs(arg4) <= v1 && Math.abs(arg5) <= v1) {
            Object v0 = this.lock;
            __monitor_enter(v0);
            try {
                if(!this.active) {
                }
                else {
                    goto label_11;
                }
            }
            catch(Throwable v3) {
                goto label_32;
            }

            __monitor_exit(v0);
            return;
            try {
            label_11:
                this.targetX = RangesKt.coerceIn(this.targetX + arg4, this.hotspotLimits.getLeft(), this.hotspotLimits.getRight());
                this.targetY = RangesKt.coerceIn(this.targetY + arg5, this.hotspotLimits.getTop(), this.hotspotLimits.getBottom());
            }
            catch(Throwable v3) {
            label_32:
                __monitor_exit(v0);
                throw v3;
            }

            __monitor_exit(v0);
            this.requestFrame();
            return;
        }
    }

    public final void moveTo(float arg4, float arg5) {
        float v1 = 3.402823E+38f;
        if(Math.abs(arg4) <= v1 && Math.abs(arg5) <= v1) {
            Object v0 = this.lock;
            __monitor_enter(v0);
            try {
                if(!this.active) {
                }
                else {
                    goto label_11;
                }
            }
            catch(Throwable v3) {
                goto label_37;
            }

            __monitor_exit(v0);
            return;
            try {
            label_11:
                this.targetX = RangesKt.coerceIn(arg4, this.hotspotLimits.getLeft(), this.hotspotLimits.getRight());
                this.targetY = RangesKt.coerceIn(arg5, this.hotspotLimits.getTop(), this.hotspotLimits.getBottom());
            }
            catch(Throwable v3) {
            label_37:
                __monitor_exit(v0);
                throw v3;
            }

            __monitor_exit(v0);
            if(Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                this.applyLatestPositionOnMain();
            }
            else {
                this.mainHandler.post(this.applyLatestPosition);
            }

            this.requestFrame();
            return;
        }
    }

    private final void requestFrame() {
        int v1;
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            if(!this.active) {
                goto label_10;
            }
            else if(this.frameScheduled) {
                goto label_10;
            }
            else {
                v1 = 1;
                this.frameScheduled = true;
            }

            goto label_11;
        }
        catch(Throwable v2) {
            __monitor_exit(v0);
            throw v2;
        }

    label_10:
        v1 = 0;
    label_11:
        __monitor_exit(v0);
        if(v1 == 0) {
            return;
        }

        if(Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            this.scheduleFrame.run();
            return;
        }

        this.mainHandler.post(this.scheduleFrame);
    }

    static final void scheduleFrame$lambda$1(GoldenCursorRenderer arg2) {
        Object v0 = arg2.lock;
        __monitor_enter(v0);
        try {
            boolean v1 = arg2.active;
        }
        catch(Throwable v2) {
            __monitor_exit(v0);
            throw v2;
        }

        __monitor_exit(v0);
        if(v1) {
            Choreographer.getInstance().postFrameCallback(arg2.frameCallback);
        }
    }

    public final void setBuiltInImageHotspot(boolean arg2) {
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            this.builtInImageHotspot = arg2;
        }
        catch(Throwable v1) {
            __monitor_exit(v0);
            throw v1;
        }

        __monitor_exit(v0);
        if(Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            this.applyLatestPositionOnMain();
        }
        else {
            this.mainHandler.post(this.applyLatestPosition);
        }

        this.requestFrame();
    }

    public final void stop() {
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            this.active = false;
            this.frameScheduled = false;
        }
        catch(Throwable v3) {
            __monitor_exit(v0);
            throw v3;
        }

        __monitor_exit(v0);
        this.mainHandler.removeCallbacks(this.scheduleFrame);
        this.mainHandler.removeCallbacks(this.applyLatestPosition);
        GoldenCursorRenderer$$ExternalSyntheticLambda0 v0_1 = new GoldenCursorRenderer$$ExternalSyntheticLambda0(this);
        if(Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            ((Runnable)v0_1).run();
            return;
        }

        this.mainHandler.post(((Runnable)v0_1));
    }

    static final void stop$lambda$15(GoldenCursorRenderer arg2) {
        Choreographer.getInstance().removeFrameCallback(arg2.frameCallback);
        arg2.cursorView.removeOnLayoutChangeListener(arg2.layoutListener);
        View v0 = arg2.overlayHost;
        if(v0 != null) {
            v0.removeOnLayoutChangeListener(arg2.layoutListener);
        }
    }

    public final void updateBounds(float arg6, float arg7) {
        float v1 = 3.402823E+38f;
        if(Math.abs(arg6) <= v1 && Math.abs(arg7) <= v1 && arg6 > 0f) {
            if(arg7 <= 0f) {
            }
            else {
                Object v1_1 = this.lock;
                __monitor_enter(v1_1);
                try {
                    this.maxX = CursorGeometry.INSTANCE.lastPixel(arg6);
                    this.maxY = CursorGeometry.INSTANCE.lastPixel(arg7);
                    arg6 = RangesKt.coerceIn(this.hotspotLimits.getLeft(), 0f, this.maxX);
                    arg7 = RangesKt.coerceIn(this.hotspotLimits.getTop(), 0f, this.maxY);
                    Rectangle v0 = new Rectangle(arg6, arg7, RangesKt.coerceIn(this.hotspotLimits.getRight(), arg6, this.maxX), RangesKt.coerceIn(this.hotspotLimits.getBottom(), arg7, this.maxY));
                    this.hotspotLimits = v0;
                    this.targetX = RangesKt.coerceIn(this.targetX, v0.getLeft(), this.hotspotLimits.getRight());
                    this.targetY = RangesKt.coerceIn(this.targetY, this.hotspotLimits.getTop(), this.hotspotLimits.getBottom());
                }
                catch(Throwable v5) {
                    __monitor_exit(v1_1);
                    throw v5;
                }

                __monitor_exit(v1_1);
                this.requestFrame();
                return;
            }
        }
    }
}

