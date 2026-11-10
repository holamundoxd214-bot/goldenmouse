package androidx.compose.ui.platform;

import android.graphics.Matrix;
import android.view.View;
import android.view.ViewParent;
import androidx.compose.ui.graphics.AndroidMatrixConversions_androidKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\rH\u0017¢\u0006\u0004\b\u000E\u0010\u000FR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2={"Landroidx/compose/ui/platform/CalculateMatrixToWindowApi29;", "Landroidx/compose/ui/platform/CalculateMatrixToWindow;", "<init>", "()V", "tmpMatrix", "Landroid/graphics/Matrix;", "tmpPosition", "", "calculateMatrixToWindow", "", "view", "Landroid/view/View;", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "calculateMatrixToWindow-EL8BTi8", "(Landroid/view/View;[F)V", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class CalculateMatrixToWindowApi29 implements CalculateMatrixToWindow {
    private final Matrix tmpMatrix;
    private final int[] tmpPosition;

    public CalculateMatrixToWindowApi29() {
        super();
        this.tmpMatrix = new Matrix();
        this.tmpPosition = new int[2];
    }

    public void calculateMatrixToWindow-EL8BTi8(View arg6, float[] arg7) {
        ViewParent v6;
        this.tmpMatrix.reset();
        arg6.transformMatrixToGlobal(this.tmpMatrix);
        ViewParent v0;
        for(v0 = arg6.getParent(); (v0 instanceof View); v0 = ((View)v6).getParent()) {
            v6 = v0;
        }

        ((View)v6).getLocationOnScreen(this.tmpPosition);
        int[] v0_1 = this.tmpPosition;
        int v2 = v0_1[0];
        int v4 = v0_1[1];
        ((View)v6).getLocationInWindow(v0_1);
        this.tmpMatrix.postTranslate(((float)(this.tmpPosition[0] - v2)), ((float)(this.tmpPosition[1] - v4)));
        AndroidMatrixConversions_androidKt.setFrom-tU-YjHk(arg7, this.tmpMatrix);
    }
}

