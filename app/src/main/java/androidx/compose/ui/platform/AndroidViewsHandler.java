package androidx.compose.ui.platform;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;

@Metadata(d1={"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u0012H\u0014J0\u0010\u0014\u001A\u00020\u00102\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u00122\u0006\u0010\u0018\u001A\u00020\u00122\u0006\u0010\u0019\u001A\u00020\u00122\u0006\u0010\u001A\u001A\u00020\u0012H\u0014J\u0018\u0010\u001B\u001A\u00020\u00102\u0006\u0010\u001C\u001A\u00020\u001D2\u0006\u0010\u001E\u001A\u00020\u001DH\u0017J\u001E\u0010\u001F\u001A\u0004\u0018\u00010 2\b\u0010!\u001A\u0004\u0018\u00010\"2\b\u0010#\u001A\u0004\u0018\u00010$H\u0016J\u0016\u0010%\u001A\u00020\u00102\u0006\u0010&\u001A\u00020\b2\u0006\u0010\'\u001A\u00020(J\u0012\u0010)\u001A\u00020\u00162\b\u0010*\u001A\u0004\u0018\u00010+H\u0016J\b\u0010,\u001A\u00020\u0010H\u0017J\b\u0010-\u001A\u00020\u0016H\u0016J\u0010\u0010.\u001A\u00020\u00102\u0006\u0010\'\u001A\u00020(H\u0014R-\u0010\u0006\u001A\u001E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t`\n¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR-\u0010\r\u001A\u001E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\b0\u0007j\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\b`\n¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\f¨\u0006/"}, d2={"Landroidx/compose/ui/platform/AndroidViewsHandler;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "holderToLayoutNode", "Ljava/util/HashMap;", "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "Landroidx/compose/ui/node/LayoutNode;", "Lkotlin/collections/HashMap;", "getHolderToLayoutNode", "()Ljava/util/HashMap;", "layoutNodeToHolder", "getLayoutNodeToHolder", "onMeasure", "", "widthMeasureSpec", "", "heightMeasureSpec", "onLayout", "changed", "", "l", "t", "r", "b", "onDescendantInvalidated", "child", "Landroid/view/View;", "target", "invalidateChildInParent", "", "location", "", "dirty", "Landroid/graphics/Rect;", "drawView", "view", "canvas", "Landroid/graphics/Canvas;", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "requestLayout", "shouldDelayChildPressedState", "dispatchDraw", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AndroidViewsHandler extends ViewGroup {
    public static final int $stable = 8;
    private final HashMap holderToLayoutNode;
    private final HashMap layoutNodeToHolder;

    static {
    }

    public AndroidViewsHandler(Context arg1) {
        super(arg1);
        this.setClipChildren(false);
        this.holderToLayoutNode = new HashMap();
        this.layoutNodeToHolder = new HashMap();
    }

    protected void dispatchDraw(Canvas arg1) {
    }

    public boolean dispatchTouchEvent(MotionEvent arg1) {
        return 1;
    }

    public final void drawView(AndroidViewHolder arg1, Canvas arg2) {
        arg1.draw(arg2);
    }

    public final HashMap getHolderToLayoutNode() {
        return this.holderToLayoutNode;
    }

    public final HashMap getLayoutNodeToHolder() {
        return this.layoutNodeToHolder;
    }

    public ViewParent invalidateChildInParent(int[] arg1, Rect arg2) {
        return this.invalidateChildInParent(arg1, arg2);
    }

    public Void invalidateChildInParent(int[] arg1, Rect arg2) {
        return null;
    }

    public void onDescendantInvalidated(View arg1, View arg2) {
    }

    protected void onLayout(boolean arg1, int arg2, int arg3, int arg4, int arg5) {
        Iterator v0 = this.holderToLayoutNode.keySet().iterator();
        while(v0.hasNext()) {
            Object v1 = v0.next();
            ((AndroidViewHolder)v1).layout(((AndroidViewHolder)v1).getLeft(), ((AndroidViewHolder)v1).getTop(), ((AndroidViewHolder)v1).getRight(), ((AndroidViewHolder)v1).getBottom());
        }
    }

    protected void onMeasure(int arg5, int arg6) {
        int v1 = 1;
        int v3 = 0x40000000;
        int v0 = View$MeasureSpec.getMode(arg5) == v3 ? 1 : 0;
        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("widthMeasureSpec should be EXACTLY");
        }

        if(View$MeasureSpec.getMode(arg6) == v3) {
        }
        else {
            v1 = 0;
        }

        if(v1 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("heightMeasureSpec should be EXACTLY");
        }

        this.setMeasuredDimension(View$MeasureSpec.getSize(arg5), View$MeasureSpec.getSize(arg6));
        Iterator v4 = this.holderToLayoutNode.keySet().iterator();
        while(v4.hasNext()) {
            v4.next().remeasure();
        }
    }

    public void requestLayout() {
        this.cleanupLayoutState(this);
        int v0 = this.getChildCount();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            View v2 = this.getChildAt(v1);
            Object v4 = this.holderToLayoutNode.get(v2);
            if((v2.isLayoutRequested()) && v4 != null) {
                LayoutNode.requestRemeasure$ui$default(((LayoutNode)v4), false, false, false, 7, null);
            }
        }
    }

    public boolean shouldDelayChildPressedState() {
        return 0;
    }
}

