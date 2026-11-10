package androidx.compose.ui.platform;

import android.view.View;
import android.view.ViewParent;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007¨\u0006\b"}, d2={"Landroidx/compose/ui/platform/WrapperRenderNodeLayerHelperMethods;", "", "<init>", "()V", "onDescendantInvalidated", "", "ownerView", "Landroidx/compose/ui/platform/AndroidComposeView;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class WrapperRenderNodeLayerHelperMethods {
    public static final int $stable;
    public static final WrapperRenderNodeLayerHelperMethods INSTANCE;

    static {
        WrapperRenderNodeLayerHelperMethods.INSTANCE = new WrapperRenderNodeLayerHelperMethods();
    }

    private WrapperRenderNodeLayerHelperMethods() {
        super();
    }

    public final void onDescendantInvalidated(AndroidComposeView arg1) {
        ViewParent v0 = arg1.getParent();
        if(v0 != null) {
            v0.onDescendantInvalidated(((View)arg1), ((View)arg1));
        }
    }
}

