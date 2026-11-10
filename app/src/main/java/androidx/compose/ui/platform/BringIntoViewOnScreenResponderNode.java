package androidx.compose.ui.platform;

import android.view.ViewGroup;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.relocation.BringIntoViewModifierNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J&\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u000E\u0010\u000E\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000FH\u0096@¢\u0006\u0002\u0010\u0011R\u001A\u0010\u0003\u001A\u00020\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u0012"}, d2={"Landroidx/compose/ui/platform/BringIntoViewOnScreenResponderNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/relocation/BringIntoViewModifierNode;", "view", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "getView", "()Landroid/view/ViewGroup;", "setView", "bringIntoView", "", "childCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "boundsProvider", "Lkotlin/Function0;", "Landroidx/compose/ui/geometry/Rect;", "(Landroidx/compose/ui/layout/LayoutCoordinates;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class BringIntoViewOnScreenResponderNode extends Node implements BringIntoViewModifierNode {
    private ViewGroup view;

    public BringIntoViewOnScreenResponderNode(ViewGroup arg1) {
        super();
        this.view = arg1;
    }

    public Object bringIntoView(LayoutCoordinates arg3, Function0 arg4, Continuation arg5) {
        long v0 = LayoutCoordinatesKt.positionInRoot(arg3);
        Object v3 = arg4.invoke();
        Rect v3_1 = v3 != null ? ((Rect)v3).translate-k-4lQ0M(v0) : null;
        if(v3_1 != null) {
            this.view.requestRectangleOnScreen(RectHelper_androidKt.toAndroidRect(v3_1), false);
        }

        return Unit.INSTANCE;
    }

    public final ViewGroup getView() {
        return this.view;
    }

    public final void setView(ViewGroup arg1) {
        this.view = arg1;
    }
}

