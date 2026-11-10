package androidx.compose.ui.scrollcapture;

import android.graphics.Point;
import android.view.ScrollCaptureCallback;
import android.view.ScrollCaptureTarget;
import android.view.View;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.semantics.SemanticsOwner;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRectKt;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00142\f\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u00170\u0016J\b\u0010\u0018\u001A\u00020\u000EH\u0016J\b\u0010\u0019\u001A\u00020\u000EH\u0016R+\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0004\u001A\u00020\u00058F@BX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\u000B\u0010\f\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u001A"}, d2={"Landroidx/compose/ui/scrollcapture/ScrollCapture;", "Landroidx/compose/ui/scrollcapture/ComposeScrollCaptureCallback$ScrollCaptureSessionListener;", "<init>", "()V", "<set-?>", "", "scrollCaptureInProgress", "getScrollCaptureInProgress", "()Z", "setScrollCaptureInProgress", "(Z)V", "scrollCaptureInProgress$delegate", "Landroidx/compose/runtime/MutableState;", "onScrollCaptureSearch", "", "view", "Landroid/view/View;", "semanticsOwner", "Landroidx/compose/ui/semantics/SemanticsOwner;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "targets", "Ljava/util/function/Consumer;", "Landroid/view/ScrollCaptureTarget;", "onSessionStarted", "onSessionEnded", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ScrollCapture implements ScrollCaptureSessionListener {
    public static final int $stable;
    private final MutableState scrollCaptureInProgress$delegate;

    static {
    }

    public ScrollCapture() {
        super();
        this.scrollCaptureInProgress$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(false), null, 2, null);
    }

    public final boolean getScrollCaptureInProgress() {
        return this.scrollCaptureInProgress$delegate.getValue().booleanValue();
    }

    public final void onScrollCaptureSearch(View arg12, SemanticsOwner arg13, CoroutineContext arg14, Consumer arg15) {
        MutableVector v0 = new MutableVector(new ScrollCaptureCandidate[16], 0);
        Object v4 = null;
        ScrollCapture_androidKt.visitScrollCaptureCandidates$default(arg13.getUnmergedRootSemanticsNode(), 0, new ScrollCapture$onScrollCaptureSearch$1(v0), 2, v4);
        v0.sortWith(ComparisonsKt.compareBy(new Function1[]{ScrollCapture$onScrollCaptureSearch$2.INSTANCE, ScrollCapture$onScrollCaptureSearch$3.INSTANCE}));
        if(v0.getSize() == 0) {
        }
        else {
            v4 = v0.content[v0.getSize() - 1];
        }

        if(v4 == null) {
            return;
        }

        View v10 = arg12;
        ComposeScrollCaptureCallback v5 = new ComposeScrollCaptureCallback(((ScrollCaptureCandidate)v4).getNode(), ((ScrollCaptureCandidate)v4).getViewportBoundsInWindow(), CoroutineScopeKt.CoroutineScope(arg14), this, v10);
        Rect v11 = LayoutCoordinatesKt.boundsInRoot(((ScrollCaptureCandidate)v4).getCoordinates());
        long v12 = ((ScrollCaptureCandidate)v4).getViewportBoundsInWindow().getTopLeft-nOcc-ac();
        ScrollCaptureTarget v12_1 = new ScrollCaptureTarget(v10, RectHelper_androidKt.toAndroidRect(IntRectKt.roundToIntRect(v11)), new Point(IntOffset.getX-impl(v12), IntOffset.getY-impl(v12)), ((ScrollCaptureCallback)v5));
        v12_1.setScrollBounds(RectHelper_androidKt.toAndroidRect(((ScrollCaptureCandidate)v4).getViewportBoundsInWindow()));
        arg15.accept(v12_1);
    }

    public void onSessionEnded() {
        this.setScrollCaptureInProgress(false);
    }

    public void onSessionStarted() {
        this.setScrollCaptureInProgress(true);
    }

    private final void setScrollCaptureInProgress(boolean arg1) {
        this.scrollCaptureInProgress$delegate.setValue(Boolean.valueOf(arg1));
    }
}

