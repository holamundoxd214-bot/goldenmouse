package androidx.compose.ui.graphics.layer;

import android.view.View;
import kotlin.Metadata;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tJ\u0016\u0010\n\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tJ\u000E\u0010\u000B\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007¨\u0006\f"}, d2={"Landroidx/compose/ui/graphics/layer/ViewLayerVerificationHelper28;", "", "<init>", "()V", "setOutlineAmbientShadowColor", "", "view", "Landroid/view/View;", "target", "", "setOutlineSpotShadowColor", "resetPivot", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) final class ViewLayerVerificationHelper28 {
    public static final ViewLayerVerificationHelper28 INSTANCE;

    static {
        ViewLayerVerificationHelper28.INSTANCE = new ViewLayerVerificationHelper28();
    }

    private ViewLayerVerificationHelper28() {
        super();
    }

    public final void resetPivot(View arg1) {
        arg1.resetPivot();
    }

    public final void setOutlineAmbientShadowColor(View arg1, int arg2) {
        arg1.setOutlineAmbientShadowColor(arg2);
    }

    public final void setOutlineSpotShadowColor(View arg1, int arg2) {
        arg1.setOutlineSpotShadowColor(arg2);
    }
}

