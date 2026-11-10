package androidx.compose.ui.platform;

import android.view.RenderNode;
import kotlin.Metadata;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007J\u0016\u0010\b\u001A\u00020\t2\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\u0005J\u000E\u0010\u000B\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007J\u0016\u0010\f\u001A\u00020\t2\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\u0005¨\u0006\r"}, d2={"Landroidx/compose/ui/platform/RenderNodeVerificationHelper28;", "", "<init>", "()V", "getAmbientShadowColor", "", "renderNode", "Landroid/view/RenderNode;", "setAmbientShadowColor", "", "target", "getSpotShadowColor", "setSpotShadowColor", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class RenderNodeVerificationHelper28 {
    public static final RenderNodeVerificationHelper28 INSTANCE;

    static {
        RenderNodeVerificationHelper28.INSTANCE = new RenderNodeVerificationHelper28();
    }

    private RenderNodeVerificationHelper28() {
        super();
    }

    public final int getAmbientShadowColor(RenderNode arg1) {
        return arg1.getAmbientShadowColor();
    }

    public final int getSpotShadowColor(RenderNode arg1) {
        return arg1.getSpotShadowColor();
    }

    public final void setAmbientShadowColor(RenderNode arg1, int arg2) {
        arg1.setAmbientShadowColor(arg2);
    }

    public final void setSpotShadowColor(RenderNode arg1, int arg2) {
        arg1.setSpotShadowColor(arg2);
    }
}

