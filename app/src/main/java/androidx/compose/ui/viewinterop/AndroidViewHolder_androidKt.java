package androidx.compose.ui.viewinterop;

import android.view.View;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.LayoutNode;
import kotlin.Metadata;

@Metadata(d1={"\u0000?\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\b\u001A\u0014\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0002\u001A\f\u0010\n\u001A\u00020\u000B*\u00020\u0006H\u0002\u001A\f\u0010\f\u001A\u00020\u000B*\u00020\u000BH\u0002\u001A\u0015\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u0006H\u0002¢\u0006\u0002\u0010\u0010\"\u000E\u0010\u0005\u001A\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t*(\b\u0002\u0010\u0011\"\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u00010\u00122\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u00010\u0012*<\b\u0002\u0010\u0014\"\u0010\u0012\u0006\u0012\u0004\u0018\u0001`\u0015\u0012\u0004\u0012\u00020\u00010\u00122$\u0012\u001A\u0012\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012j\u0004\u0018\u0001`\u0015\u0012\u0004\u0012\u00020\u00010\u0012¨\u0006\u0016"}, d2={"layoutAccordingTo", "", "Landroid/view/View;", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "Unmeasured", "", "NoOpScrollConnection", "androidx/compose/ui/viewinterop/AndroidViewHolder_androidKt$NoOpScrollConnection$1", "Landroidx/compose/ui/viewinterop/AndroidViewHolder_androidKt$NoOpScrollConnection$1;", "toComposeOffset", "", "toComposeVelocity", "toNestedScrollSource", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "type", "(I)I", "BringIntoViewRequester", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Rect;", "OnRequesterReady", "Landroidx/compose/ui/viewinterop/BringIntoViewRequester;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AndroidViewHolder_androidKt {
    private static final AndroidViewHolder_androidKt$NoOpScrollConnection$1 NoOpScrollConnection = null;
    private static final int Unmeasured = 0x80000000;

    static {
        AndroidViewHolder_androidKt.NoOpScrollConnection = new AndroidViewHolder_androidKt$NoOpScrollConnection$1();
    }

    public static final AndroidViewHolder_androidKt$NoOpScrollConnection$1 access$getNoOpScrollConnection$p() {
        return AndroidViewHolder_androidKt.NoOpScrollConnection;
    }

    public static final void access$layoutAccordingTo(View arg0, LayoutNode arg1) {
        AndroidViewHolder_androidKt.layoutAccordingTo(arg0, arg1);
    }

    public static final float access$toComposeOffset(int arg0) {
        return AndroidViewHolder_androidKt.toComposeOffset(arg0);
    }

    public static final float access$toComposeVelocity(float arg0) {
        return AndroidViewHolder_androidKt.toComposeVelocity(arg0);
    }

    public static final int access$toNestedScrollSource(int arg0) {
        return AndroidViewHolder_androidKt.toNestedScrollSource(arg0);
    }

    private static final void layoutAccordingTo(View arg4, LayoutNode arg5) {
        long v0 = LayoutCoordinatesKt.positionInRoot(arg5.getCoordinates());
        int v5 = Math.round(Float.intBitsToFloat(((int)(v0 >> 0x20))));
        int v0_1 = Math.round(Float.intBitsToFloat(((int)(v0 & 0xFFFFFFFFL))));
        arg4.layout(v5, v0_1, arg4.getMeasuredWidth() + v5, arg4.getMeasuredHeight() + v0_1);
    }

    private static final float toComposeOffset(int arg1) {
        return (((float)arg1)) * -1f;
    }

    private static final float toComposeVelocity(float arg1) {
        return arg1 * -1f;
    }

    private static final int toNestedScrollSource(int arg0) {
        if(arg0 == 0) {
            return NestedScrollSource.Companion.getUserInput-WNlRxjI();
        }

        return NestedScrollSource.Companion.getSideEffect-WNlRxjI();
    }
}

