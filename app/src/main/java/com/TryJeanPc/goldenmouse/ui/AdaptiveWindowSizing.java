package com.TryJeanPc.goldenmouse.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.graphics.Insets;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.View$MeasureSpec;
import android.view.View$OnAttachStateChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver$OnGlobalLayoutListener;
import android.view.ViewTreeObserver$OnPreDrawListener;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowInsets$Type;
import android.view.WindowInsets;
import android.view.WindowManager$LayoutParams;
import android.view.WindowManager;
import android.view.WindowMetrics;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000EJ,\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\u0013\u001A\u00020\u0014H\u0007¨\u0006\u0016"}, d2={"Lcom/TryJeanPc/goldenmouse/ui/AdaptiveWindowSizing;", "", "<init>", "()V", "calculate", "Lcom/TryJeanPc/goldenmouse/ui/WindowSize;", "area", "Lcom/TryJeanPc/goldenmouse/ui/WindowArea;", "type", "Lcom/TryJeanPc/goldenmouse/ui/WindowType;", "config", "Lcom/TryJeanPc/goldenmouse/ui/WindowSizingConfig;", "contentHeightPx", "", "(Lcom/TryJeanPc/goldenmouse/ui/WindowArea;Lcom/TryJeanPc/goldenmouse/ui/WindowType;Lcom/TryJeanPc/goldenmouse/ui/WindowSizingConfig;Ljava/lang/Integer;)Lcom/TryJeanPc/goldenmouse/ui/WindowSize;", "bind", "Lcom/TryJeanPc/goldenmouse/ui/AdaptiveWindowSizing$Binding;", "dialog", "Landroid/app/Dialog;", "settleBeforeDraw", "", "Binding", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class AdaptiveWindowSizing {
    @Metadata(d1={"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u00032\u00020\u0004B)\b\u0000\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n\u0012\u0006\u0010\u000B\u001A\u00020\f¢\u0006\u0004\b\r\u0010\u000EJ\r\u0010(\u001A\u00020)H\u0000¢\u0006\u0002\b*J\u0010\u0010+\u001A\u00020)2\u0006\u0010,\u001A\u00020\u0012H\u0016J\u0010\u0010-\u001A\u00020)2\u0006\u0010,\u001A\u00020\u0012H\u0016J\u0010\u0010.\u001A\u00020)2\u0006\u0010/\u001A\u000200H\u0016J\b\u00101\u001A\u00020)H\u0016J\b\u00102\u001A\u00020)H\u0002J\b\u00103\u001A\u00020)H\u0007J\b\u00104\u001A\u00020\u0016H\u0002J\b\u00105\u001A\u000206H\u0002J\b\u00107\u001A\u00020)H\u0017R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001A\u0004\u0018\u00010\u0014X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001A\u0004\u0018\u00010\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001A\u0004\u0018\u00010\u0018X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0019R\u000E\u0010\u001A\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001B\u001A\u00020\u001CX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001D\u001A\u0004\u0018\u00010\u001EX\u0082\u000E¢\u0006\u0002\n\u0000R\u001E\u0010 \u001A\u00020\f2\u0006\u0010\u001F\u001A\u00020\f@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b \u0010!R\u000E\u0010\"\u001A\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010$\u001A\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010&\u001A\u00020\'X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00068"}, d2={"Lcom/TryJeanPc/goldenmouse/ui/AdaptiveWindowSizing$Binding;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/content/ComponentCallbacks;", "dialog", "Landroid/app/Dialog;", "type", "Lcom/TryJeanPc/goldenmouse/ui/WindowType;", "config", "Lcom/TryJeanPc/goldenmouse/ui/WindowSizingConfig;", "settleBeforeDraw", "", "<init>", "(Landroid/app/Dialog;Lcom/TryJeanPc/goldenmouse/ui/WindowType;Lcom/TryJeanPc/goldenmouse/ui/WindowSizingConfig;Z)V", "window", "Landroid/view/Window;", "decor", "Landroid/view/View;", "observer", "Landroid/view/ViewTreeObserver;", "measuringContext", "Landroid/content/Context;", "displayId", "", "Ljava/lang/Integer;", "pending", "lastVisibleFrame", "Landroid/graphics/Rect;", "lastInsets", "Landroid/view/WindowInsets;", "value", "isClosed", "()Z", "update", "Ljava/lang/Runnable;", "layoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "insetsListener", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "start", "", "start$app", "onViewAttachedToWindow", "view", "onViewDetachedFromWindow", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onLowMemory", "schedule", "refresh", "measurementContext", "availableArea", "Lcom/TryJeanPc/goldenmouse/ui/WindowArea;", "close", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Binding implements ComponentCallbacks, View$OnAttachStateChangeListener, AutoCloseable {
        public static final int $stable = 8;
        private final WindowSizingConfig config;
        private final View decor;
        private final Dialog dialog;
        private Integer displayId;
        private final ViewTreeObserver$OnPreDrawListener insetsListener;
        private boolean isClosed;
        private WindowInsets lastInsets;
        private final Rect lastVisibleFrame;
        private final ViewTreeObserver$OnGlobalLayoutListener layoutListener;
        private Context measuringContext;
        private ViewTreeObserver observer;
        private boolean pending;
        private final boolean settleBeforeDraw;
        private final WindowType type;
        private final Runnable update;
        private final Window window;

        static {
        }

        public Binding(Dialog arg2, WindowType arg3, WindowSizingConfig arg4, boolean arg5) {
            Intrinsics.checkNotNullParameter(arg2, "dialog");
            Intrinsics.checkNotNullParameter(arg3, "type");
            Intrinsics.checkNotNullParameter(arg4, "config");
            super();
            this.dialog = arg2;
            this.type = arg3;
            this.config = arg4;
            this.settleBeforeDraw = arg5;
            Window v2 = arg2.getWindow();
            if(v2 != null) {
                this.window = v2;
                View v2_1 = v2.getDecorView();
                Intrinsics.checkNotNullExpressionValue(v2_1, "getDecorView(...)");
                this.decor = v2_1;
                this.lastVisibleFrame = new Rect();
                this.update = new AdaptiveWindowSizing$Binding$$ExternalSyntheticLambda0(this);
                this.layoutListener = new AdaptiveWindowSizing$Binding$$ExternalSyntheticLambda1(this);
                this.insetsListener = new AdaptiveWindowSizing$Binding$$ExternalSyntheticLambda2(this);
                return;
            }

            throw new IllegalArgumentException("Required value was null.".toString());
        }

        private final WindowArea availableArea() {
            Rect v2_3;
            Rect v7;
            Rect v3;
            Binding v0 = this;
            Context v1 = v0.measurementContext();
            Object v2 = v1.getSystemService("window");
            Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type android.view.WindowManager");
            int v6 = 30;
            if(Build$VERSION.SDK_INT >= v6) {
                WindowMetrics v2_1 = ((WindowManager)v2).getCurrentWindowMetrics();
                Intrinsics.checkNotNullExpressionValue(v2_1, "getCurrentWindowMetrics(...)");
                v3 = new Rect(v2_1.getBounds());
                Insets v2_2 = v2_1.getWindowInsets().getInsets(WindowInsets$Type.systemBars() | WindowInsets$Type.displayCutout() | WindowInsets$Type.ime());
                Intrinsics.checkNotNullExpressionValue(v2_2, "getInsets(...)");
                v7 = new Rect(v3.left + v2_2.left, v3.top + v2_2.top, v3.right - v2_2.right, v3.bottom - v2_2.bottom);
            }
            else {
                Point v3_1 = new Point();
                Display v7_1 = v0.decor.getDisplay();
                if(v7_1 == null) {
                    v7_1 = ((WindowManager)v2).getDefaultDisplay();
                }

                v7_1.getRealSize(v3_1);
                v2_3 = new Rect(0, 0, v3_1.x, v3_1.y);
                if(v0.window.getAttributes().type != 0x7F6) {
                    Context v3_2 = v0.dialog.getContext();
                    Intrinsics.checkNotNullExpressionValue(v3_2, "getContext(...)");
                    while((v3_2 instanceof ContextWrapper)) {
                        if((v3_2 instanceof Activity)) {
                            break;
                        }

                        Context v7_2 = v3_2.getBaseContext();
                        if(v7_2 == v3_2) {
                            break;
                        }

                        Intrinsics.checkNotNull(v7_2);
                        v3_2 = v7_2;
                    }

                    View v8 = null;
                    if((v3_2 instanceof Activity)) {
                    }
                    else {
                        v3_2 = ((Context)v8);
                    }

                    if(v3_2 != null) {
                        Window v3_3 = ((Activity)v3_2).getWindow();
                        if(v3_3 != null) {
                            v8 = v3_3.getDecorView();
                        }
                    }

                    if(v8 == null) {
                        goto label_98;
                    }

                    if(!v8.isAttachedToWindow()) {
                        goto label_98;
                    }

                    if(v8.getWidth() <= 0) {
                        goto label_98;
                    }

                    if(v8.getHeight() <= 0) {
                        goto label_98;
                    }

                    int[] v3_4 = new int[2];
                    v8.getLocationOnScreen(v3_4);
                    v2_3.set(v3_4[0], v3_4[1], v8.getWidth() + v3_4[0], v3_4[1] + v8.getHeight());
                }

            label_98:
                v7 = new Rect(v2_3);
                v3 = v2_3;
            }

            if(v0.type != WindowType.FULLSCREEN_EDITOR) {
                v2_3 = new Rect();
                v0.decor.getWindowVisibleDisplayFrame(v2_3);
                if(!v2_3.isEmpty() && !v7.intersect(v2_3)) {
                    v7.set(v3.left, v3.top, v3.left, v3.top);
                }

                if(Build$VERSION.SDK_INT < 28) {
                    goto label_146;
                }

                if(Build$VERSION.SDK_INT >= v6) {
                    goto label_146;
                }

                WindowInsets v0_1 = v0.decor.getRootWindowInsets();
                if(v0_1 == null) {
                    goto label_146;
                }

                DisplayCutout v0_2 = v0_1.getDisplayCutout();
                if(v0_2 == null) {
                    goto label_146;
                }

                if(v7.intersect(v3.left + v0_2.getSafeInsetLeft(), v3.top + v0_2.getSafeInsetTop(), v3.right - v0_2.getSafeInsetRight(), v3.bottom - v0_2.getSafeInsetBottom())) {
                    goto label_146;
                }

                v7.set(v3.left, v3.top, v3.left, v3.top);
            }

        label_146:
            return new WindowArea(RangesKt.coerceAtLeast(v3.width(), 1), RangesKt.coerceAtLeast(v3.height(), 1), v1.getResources().getDisplayMetrics().density, RangesKt.coerceAtLeast(v7.left - v3.left, 0), RangesKt.coerceAtLeast(v7.top - v3.top, 0), RangesKt.coerceAtLeast(v3.right - v7.right, 0), RangesKt.coerceAtLeast(v3.bottom - v7.bottom, 0));
        }

        public void close() {
            if(this.isClosed) {
                return;
            }

            this.isClosed = true;
            this.decor.removeCallbacks(this.update);
            this.pending = false;
            ViewTreeObserver v0 = this.observer;
            ViewTreeObserver v1 = null;
            if(v0 != null) {
                if(v0.isAlive()) {
                }
                else {
                    v0 = v1;
                }

                if(v0 == null) {
                    goto label_22;
                }

                v0.removeOnGlobalLayoutListener(this.layoutListener);
                v0.removeOnPreDrawListener(this.insetsListener);
            }

        label_22:
            this.observer = v1;
            this.decor.removeOnAttachStateChangeListener(this);
            Context v0_1 = this.measuringContext;
            if(v0_1 != null) {
                v0_1.unregisterComponentCallbacks(this);
            }

            this.measuringContext = ((Context)v1);
            this.lastInsets = ((WindowInsets)v1);
        }

        static final boolean insetsListener$lambda$2(Binding arg4) {
            Rect v0 = new Rect();
            arg4.decor.getWindowVisibleDisplayFrame(v0);
            WindowInsets v1 = arg4.decor.getRootWindowInsets();
            if(!Intrinsics.areEqual(v0, arg4.lastVisibleFrame) || !Intrinsics.areEqual(v1, arg4.lastInsets)) {
                arg4.lastVisibleFrame.set(v0);
                arg4.lastInsets = v1;
                arg4.schedule();
            }

            if(arg4.settleBeforeDraw) {
                int v0_1 = arg4.window.getAttributes().width;
                int v2 = arg4.window.getAttributes().height;
                arg4.refresh();
                if(v0_1 == arg4.window.getAttributes().width && v2 == arg4.window.getAttributes().height && !arg4.decor.isLayoutRequested()) {
                    return 1;
                }

                return 0;
            }

            return 1;
        }

        public final boolean isClosed() {
            return this.isClosed;
        }

        static final void layoutListener$lambda$1(Binding arg0) {
            arg0.schedule();
        }

        private final Context measurementContext() {
            Display v0 = this.decor.getDisplay();
            Bundle v2 = null;
            if(this.measuringContext != null) {
                Integer v1 = this.displayId;
                if(v0 != null) {
                    Integer v3 = Integer.valueOf(v0.getDisplayId());
                }
                else {
                    Object v3_1 = v2;
                }

                if(Intrinsics.areEqual(v1, v3_1)) {
                    goto label_47;
                }

                goto label_13;
            }
            else {
            label_13:
                Context v1_1 = this.measuringContext;
                if(v1_1 != null) {
                    v1_1.unregisterComponentCallbacks(this);
                }

                v1_1 = Build$VERSION.SDK_INT < 30 || this.window.getAttributes().type != 0x7F6 || v0 == null ? this.dialog.getContext() : this.dialog.getContext().createDisplayContext(v0).createWindowContext(this.window.getAttributes().type, v2);
                this.measuringContext = v1_1;
                if(v0 != null) {
                    Integer v2_1 = Integer.valueOf(v0.getDisplayId());
                }

                this.displayId = ((Integer)v2);
                if(this.observer == null) {
                    goto label_47;
                }

                Context v0_1 = this.measuringContext;
                Intrinsics.checkNotNull(v0_1);
                v0_1.registerComponentCallbacks(this);
            }

        label_47:
            Context v4 = this.measuringContext;
            Intrinsics.checkNotNull(v4);
            return v4;
        }

        public void onConfigurationChanged(Configuration arg2) {
            Intrinsics.checkNotNullParameter(arg2, "newConfig");
            this.schedule();
        }

        public void onLowMemory() {
        }

        public void onViewAttachedToWindow(View arg2) {
            Intrinsics.checkNotNullParameter(arg2, "view");
            if(!this.isClosed) {
                if(this.observer != null) {
                }
                else {
                    ViewTreeObserver v2 = this.decor.getViewTreeObserver();
                    v2.addOnGlobalLayoutListener(this.layoutListener);
                    v2.addOnPreDrawListener(this.insetsListener);
                    this.observer = v2;
                    this.measurementContext();
                    this.schedule();
                }
            }
        }

        public void onViewDetachedFromWindow(View arg2) {
            Intrinsics.checkNotNullParameter(arg2, "view");
            this.close();
        }

        public final void refresh() {
            if(!this.isClosed && (this.decor.isAttachedToWindow())) {
                if(this.decor.getWindowVisibility() != 0) {
                }
                else {
                    WindowArea v2 = this.availableArea();
                    WindowSize v0 = AdaptiveWindowSizing.calculate$default(AdaptiveWindowSizing.INSTANCE, v2, this.type, this.config, null, 8, null);
                    int v1 = this.type == WindowType.SHORT_FORM || this.type == WindowType.COMPACT ? 1 : 0;
                    View v3 = this.window.findViewById(0x1020002);
                    v3 = v3 != null ? ((ViewGroup)v3).getChildAt(0) : null;
                    if(v1 != 0 && this.config.getPreferredHeightDp() == null && v3 != null) {
                        v1 = this.decor.getPaddingLeft() + this.decor.getPaddingRight();
                        int v4 = this.decor.getPaddingTop() + this.decor.getPaddingBottom();
                        v3.measure(View$MeasureSpec.makeMeasureSpec(RangesKt.coerceAtLeast(v0.getWidthPx() - v1, 1), 0x40000000), View$MeasureSpec.makeMeasureSpec(RangesKt.coerceAtLeast(v0.getHeightPx() - v4, 1), 0x80000000));
                        v0 = AdaptiveWindowSizing.INSTANCE.calculate(v2, this.type, this.config, Integer.valueOf(v3.getMeasuredHeight() + v4));
                    }

                    WindowManager$LayoutParams v1_1 = this.window.getAttributes();
                    if(v1_1.width == v0.getWidthPx() && v1_1.height == v0.getHeightPx()) {
                        return;
                    }

                    this.window.setLayout(v0.getWidthPx(), v0.getHeightPx());
                }
            }
        }

        private final void schedule() {
            if(!this.isClosed && (this.decor.isAttachedToWindow()) && !this.pending) {
                this.pending = true;
                this.decor.post(this.update);
            }
        }

        public final void start$app() {
            this.decor.addOnAttachStateChangeListener(this);
            if(this.decor.isAttachedToWindow()) {
                this.onViewAttachedToWindow(this.decor);
            }
        }

        static final void update$lambda$0(Binding arg1) {
            arg1.pending = false;
            arg1.refresh();
        }
    }

    @Metadata(k=3, mv={2, 2, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[WindowType.values().length];
            try {
                v0[WindowType.LARGE_FORM.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[WindowType.SHORT_FORM.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[WindowType.COMPACT.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_15:
                            v0[WindowType.SIDE_PANEL.ordinal()] = 4;
                            goto label_19;
                        }
                        catch(NoSuchFieldError ) {
                            try {
                            label_19:
                                v0[WindowType.FULLSCREEN_EDITOR.ordinal()] = 5;
                                goto label_23;
                            }
                            catch(NoSuchFieldError ) {
                            label_23:
                                WhenMappings.$EnumSwitchMapping$0 = v0;
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    public static final int $stable;
    public static final AdaptiveWindowSizing INSTANCE;

    static {
        AdaptiveWindowSizing.INSTANCE = new AdaptiveWindowSizing();
    }

    private AdaptiveWindowSizing() {
        super();
    }

    public final Binding bind(Dialog arg2, WindowType arg3, WindowSizingConfig arg4, boolean arg5) {
        Intrinsics.checkNotNullParameter(arg2, "dialog");
        Intrinsics.checkNotNullParameter(arg3, "type");
        Intrinsics.checkNotNullParameter(arg4, "config");
        if(Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            Binding v1 = new Binding(arg2, arg3, arg4, arg5);
            v1.start$app();
            return v1;
        }

        throw new IllegalStateException("Bind adaptive windows on the main thread".toString());
    }

    public static Binding bind$default(AdaptiveWindowSizing arg12, Dialog arg13, WindowType arg14, WindowSizingConfig arg15, boolean arg16, int arg17, Object arg18) {
        if((arg17 & 4) != 0) {
            arg15 = new WindowSizingConfig(null, null, 0, 0, null, null, null, null, 0xFF, null);
        }

        boolean v0 = (arg17 & 8) != 0 ? false : arg16;
        return arg12.bind(arg13, arg14, arg15, v0);
    }

    public final WindowSize calculate(WindowArea arg9, WindowType arg10, WindowSizingConfig arg11, Integer arg12) {
        int v12;
        int v10_1;
        int v2_1;
        Intrinsics.checkNotNullParameter(arg9, "area");
        Intrinsics.checkNotNullParameter(arg10, "type");
        Intrinsics.checkNotNullParameter(arg11, "config");
        int v0 = 0;
        int v8 = arg10 == WindowType.FULLSCREEN_EDITOR ? 1 : 0;
        Integer v2 = arg11.getMarginDp();
        if(v2 != null) {
            v2_1 = v2.intValue();
        }
        else if(v8 != 0) {
            v2_1 = 0;
        }
        else {
            v2_1 = 12;
        }

        v2_1 = AdaptiveWindowSizing.calculate$dp(arg9, v2_1);
        int v3 = arg9.getWidthPx();
        int v4 = v8 != 0 ? 0 : arg9.getLeftInsetPx() + arg9.getRightInsetPx();
        v3 = RangesKt.coerceAtLeast(v3 - v4, 1);
        v4 = 2;
        v2_1 *= v4;
        int v5 = RangesKt.coerceAtLeast(v3 - v2_1, 1);
        int v6 = arg9.getHeightPx();
        v8 = v8 != 0 ? 0 : arg9.getTopInsetPx() + arg9.getBottomInsetPx();
        v8 = RangesKt.coerceAtLeast(v6 - v8 - v2_1, 1);
        v2_1 = WhenMappings.$EnumSwitchMapping$0[arg10.ordinal()];
        Integer v6_1 = null;
        if(v2_1 == 1) {
            v2 = Integer.valueOf(600);
        }
        else if(v2_1 == v4) {
            v2 = Integer.valueOf(480);
        }
        else if(v2_1 == 3) {
            v2 = arg11.getPreferredWidthDp();
            v2_1 = v2 != null ? v2.intValue() : 360;
            v2 = Integer.valueOf(v2_1);
        }
        else if(v2_1 == 4) {
            v2 = arg11.getPreferredWidthDp();
            v2_1 = v2 != null ? v2.intValue() : 300;
            v2 = Integer.valueOf(v2_1);
        }
        else if(v2_1 == 5) {
            v2 = v6_1;
        }
        else {
            throw new NoWhenBranchMatchedException();
        }

        Integer v4_1 = arg11.getMaxWidthDp();
        if(v4_1 == null) {
        }
        else {
            v2 = v4_1;
        }

        v2_1 = v2 != null ? AdaptiveWindowSizing.calculate$dp(arg9, ((Number)v2).intValue()) : v5;
        v2_1 = Math.min(v5, v2_1);
        v4_1 = arg11.getMaxHeightDp();
        if(v4_1 != null) {
            v6_1 = v4_1;
        }
        else if(arg10 == WindowType.LARGE_FORM) {
            v6_1 = Integer.valueOf(840);
        }

        v4 = v6_1 != null ? AdaptiveWindowSizing.calculate$dp(arg9, ((Number)v6_1).intValue()) : v8;
        v8 = Math.min(v8, v4);
        if(arg10 == WindowType.SHORT_FORM || arg10 == WindowType.COMPACT) {
            v0 = 1;
        }

        Integer v10 = arg11.getPreferredWidthDp();
        if(v10 != null) {
            v10_1 = AdaptiveWindowSizing.calculate$dp(arg9, ((Number)v10).intValue());
        }
        else {
            Float v10_2 = arg11.getPreferredWidthFraction();
            v10_1 = v10_2 != null ? MathKt.roundToInt((((float)v3)) * ((Number)v10_2).floatValue()) : v2_1;
        }

        v10_1 = RangesKt.coerceAtLeast(RangesKt.coerceIn(v10_1, Math.min(AdaptiveWindowSizing.calculate$dp(arg9, arg11.getMinWidthDp()), v2_1), v2_1), 1);
        v2 = arg11.getPreferredHeightDp();
        if(v2 != null) {
            v12 = AdaptiveWindowSizing.calculate$dp(arg9, ((Number)v2).intValue());
        }
        else {
            if(v0 != 0 && arg12 != null) {
                v12 = arg12.intValue();
                goto label_138;
            }

            v12 = v8;
        }

    label_138:
        return new WindowSize(v10_1, RangesKt.coerceAtLeast(RangesKt.coerceIn(v12, Math.min(AdaptiveWindowSizing.calculate$dp(arg9, arg11.getMinHeightDp()), v8), v8), 1));
    }

    public static WindowSize calculate$default(AdaptiveWindowSizing arg12, WindowArea arg13, WindowType arg14, WindowSizingConfig arg15, Integer arg16, int arg17, Object arg18) {
        if((arg17 & 4) != 0) {
            arg15 = new WindowSizingConfig(null, null, 0, 0, null, null, null, null, 0xFF, null);
        }

        Integer v0 = (arg17 & 8) != 0 ? null : arg16;
        return arg12.calculate(arg13, arg14, arg15, v0);
    }

    private static final int calculate$dp(WindowArea arg0, int arg1) {
        return MathKt.roundToInt((((float)arg1)) * arg0.getDensity());
    }
}

