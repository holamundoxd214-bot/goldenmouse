package androidx.compose.ui.platform;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.R$id;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0011\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J0\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u00072\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u000E\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\fH\u0014J\u0018\u0010\u0010\u001A\u00020\t2\u0006\u0010\u0011\u001A\u00020\f2\u0006\u0010\u0012\u001A\u00020\fH\u0014J\b\u0010\u0013\u001A\u00020\tH\u0016J\u0010\u0010\u0014\u001A\u00020\t2\u0006\u0010\u0015\u001A\u00020\u0016H\u0014J\b\u0010\u0017\u001A\u00020\fH\u0016J%\u0010\u0018\u001A\u00020\t2\u0006\u0010\u0015\u001A\u00020\u00192\u0006\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u001DH\u0000¢\u0006\u0002\b\u001ER\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u001F"}, d2={"Landroidx/compose/ui/platform/DrawChildContainer;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "isDrawing", "", "onLayout", "", "changed", "l", "", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "requestLayout", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "getChildCount", "drawChild", "Landroidx/compose/ui/graphics/Canvas;", "view", "Landroid/view/View;", "drawingTime", "", "drawChild$ui", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public class DrawChildContainer extends ViewGroup {
    public static final int $stable = 8;
    private boolean isDrawing;

    static {
    }

    public DrawChildContainer(Context arg2) {
        super(arg2);
        this.setClipChildren(false);
        this.setTag(id.hide_in_inspector_tag, Boolean.valueOf(true));
    }

    protected void dispatchDraw(Canvas arg6) {
        int v0 = super.getChildCount();
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            View v3 = this.getChildAt(v2);
            Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type androidx.compose.ui.platform.ViewLayer");
            if(((ViewLayer)v3).isInvalidated()) {
                this.isDrawing = true;
                try {
                    super.dispatchDraw(arg6);
                }
                catch(Throwable v6) {
                    this.isDrawing = false;
                    throw v6;
                }

                this.isDrawing = false;
                return;
            }
        }
    }

    public final void drawChild$ui(androidx.compose.ui.graphics.Canvas arg1, View arg2, long arg3) {
        super.drawChild(AndroidCanvas_androidKt.getNativeCanvas(arg1), arg2, arg3);
    }

    public int getChildCount() {
        if(this.isDrawing) {
            return super.getChildCount();
        }

        return 0;
    }

    protected void onLayout(boolean arg1, int arg2, int arg3, int arg4, int arg5) {
    }

    protected void onMeasure(int arg1, int arg2) {
        this.setMeasuredDimension(0, 0);
    }

    public void requestLayout() {
    }
}

