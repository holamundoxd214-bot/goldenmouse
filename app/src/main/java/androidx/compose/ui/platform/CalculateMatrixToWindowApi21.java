package androidx.compose.ui.platform;

import android.view.View;
import android.view.ViewParent;
import androidx.compose.ui.graphics.AndroidMatrixConversions_androidKt;
import androidx.compose.ui.graphics.Matrix;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001F\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u0003H\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ\u001F\u0010\u0010\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u0003H\u0002¢\u0006\u0004\b\u0011\u0010\u000FJ\u001B\u0010\u0012\u001A\u00020\n*\u00020\u00032\u0006\u0010\u0013\u001A\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0017\u001A\u00020\n*\u00020\u00032\u0006\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u001A\u001A\u00020\u0019H\u0002¢\u0006\u0004\b\u001B\u0010\u001CR\u0010\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001D"}, d2={"Landroidx/compose/ui/platform/CalculateMatrixToWindowApi21;", "Landroidx/compose/ui/platform/CalculateMatrixToWindow;", "tmpMatrix", "Landroidx/compose/ui/graphics/Matrix;", "<init>", "([FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "[F", "tmpLocation", "", "calculateMatrixToWindow", "", "view", "Landroid/view/View;", "matrix", "calculateMatrixToWindow-EL8BTi8", "(Landroid/view/View;[F)V", "transformMatrixToWindow", "transformMatrixToWindow-EL8BTi8", "preConcat", "other", "Landroid/graphics/Matrix;", "preConcat-tU-YjHk", "([FLandroid/graphics/Matrix;)V", "preTranslate", "x", "", "y", "preTranslate-3XD1CNM", "([FFF)V", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class CalculateMatrixToWindowApi21 implements CalculateMatrixToWindow {
    private final int[] tmpLocation;
    private final float[] tmpMatrix;

    public CalculateMatrixToWindowApi21(float[] arg1, DefaultConstructorMarker arg2) {
        this(arg1);
    }

    private CalculateMatrixToWindowApi21(float[] arg1) {
        super();
        this.tmpMatrix = arg1;
        this.tmpLocation = new int[2];
    }

    public void calculateMatrixToWindow-EL8BTi8(View arg1, float[] arg2) {
        Matrix.reset-impl(arg2);
        this.transformMatrixToWindow-EL8BTi8(arg1, arg2);
    }

    private final void preConcat-tU-YjHk(float[] arg2, android.graphics.Matrix arg3) {
        AndroidMatrixConversions_androidKt.setFrom-tU-YjHk(this.tmpMatrix, arg3);
        AndroidComposeView_androidKt.preTransform-JiSxe2E(arg2, this.tmpMatrix);
    }

    private final void preTranslate-3XD1CNM(float[] arg1, float arg2, float arg3) {
        AndroidComposeView_androidKt.preTranslate-cG2Xzmc(arg1, arg2, arg3, this.tmpMatrix);
    }

    private final void transformMatrixToWindow-EL8BTi8(View arg4, float[] arg5) {
        ViewParent v0 = arg4.getParent();
        if((v0 instanceof View)) {
            this.transformMatrixToWindow-EL8BTi8(((View)v0), arg5);
            this.preTranslate-3XD1CNM(arg5, -(((float)arg4.getScrollX())), -(((float)arg4.getScrollY())));
            this.preTranslate-3XD1CNM(arg5, ((float)arg4.getLeft()), ((float)arg4.getTop()));
        }
        else {
            int[] v0_1 = this.tmpLocation;
            arg4.getLocationInWindow(v0_1);
            this.preTranslate-3XD1CNM(arg5, -(((float)arg4.getScrollX())), -(((float)arg4.getScrollY())));
            this.preTranslate-3XD1CNM(arg5, ((float)v0_1[0]), ((float)v0_1[1]));
        }

        android.graphics.Matrix v4 = arg4.getMatrix();
        if(!v4.isIdentity()) {
            this.preConcat-tU-YjHk(arg5, v4);
        }
    }
}

