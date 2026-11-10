package com.TryJeanPc.goldenmouse.ui;

import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import android.view.ViewParent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\u0010\u0002\n\u0002\b\u000F\n\u0002\u0010\b\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003B#\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0012\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\n\u0010\u000BJ\b\u0010\u0013\u001A\u00020\tH\u0002J\b\u0010\u0014\u001A\u00020\tH\u0014J\b\u0010\u0015\u001A\u00020\tH\u0014J\u0018\u0010\u0016\u001A\u00020\t2\u0006\u0010\u0017\u001A\u00020\u00012\u0006\u0010\u0018\u001A\u00020\u0019H\u0014J\u0010\u0010\u001A\u001A\u00020\t2\u0006\u0010\u0018\u001A\u00020\u0019H\u0014J\b\u0010\u001B\u001A\u00020\tH\u0016R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u001E\u0010\u0010\u001A\u00020\b2\u0006\u0010\u000F\u001A\u00020\b@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012¨\u0006\u001C"}, d2={"Lcom/TryJeanPc/goldenmouse/ui/VisualVisibilityObserver;", "Landroid/view/View;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "root", "Landroid/view/ViewGroup;", "changed", "Lkotlin/Function1;", "", "", "<init>", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function1;)V", "attached", "windowShown", "closed", "value", "visible", "getVisible", "()Z", "reconcile", "onAttachedToWindow", "onDetachedFromWindow", "onVisibilityChanged", "changedView", "visibility", "", "onWindowVisibilityChanged", "close", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class VisualVisibilityObserver extends View implements AutoCloseable {
    public static final int $stable = 8;
    private boolean attached;
    private final Function1 changed;
    private boolean closed;
    private final ViewGroup root;
    private boolean visible;
    private boolean windowShown;

    static {
    }

    public VisualVisibilityObserver(ViewGroup arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "root");
        Intrinsics.checkNotNullParameter(arg3, "changed");
        super(arg2.getContext());
        this.root = arg2;
        this.changed = arg3;
        this.setImportantForAccessibility(2);
        arg2.addView(((View)this), new ViewGroup$LayoutParams(0, 0));
    }

    public void close() {
        this.closed = true;
        this.reconcile();
        ViewParent v0 = this.getParent();
        if((v0 instanceof ViewGroup)) {
        }
        else {
            v0 = null;
        }

        if(v0 != null) {
            ((ViewGroup)v0).removeView(((View)this));
        }
    }

    public final boolean getVisible() {
        return this.visible;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        boolean v0 = true;
        this.attached = true;
        if(this.getWindowVisibility() == 0) {
        }
        else {
            v0 = false;
        }

        this.windowShown = v0;
        this.reconcile();
    }

    protected void onDetachedFromWindow() {
        this.attached = false;
        this.reconcile();
        super.onDetachedFromWindow();
    }

    protected void onVisibilityChanged(View arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "changedView");
        super.onVisibilityChanged(arg2, arg3);
        this.reconcile();
    }

    protected void onWindowVisibilityChanged(int arg1) {
        super.onWindowVisibilityChanged(arg1);
        boolean v1 = arg1 == 0 ? true : false;
        this.windowShown = v1;
        this.reconcile();
    }

    private final void reconcile() {
        boolean v0 = (this.closed) || !this.attached || !this.windowShown || !this.root.isShown() ? false : true;
        if(this.visible == v0) {
            return;
        }

        this.visible = v0;
        this.changed.invoke(Boolean.valueOf(v0));
    }
}

