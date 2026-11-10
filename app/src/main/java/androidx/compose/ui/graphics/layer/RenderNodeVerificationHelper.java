package androidx.compose.ui.graphics.layer;

import android.graphics.RenderNode;
import androidx.compose.ui.graphics.RenderEffect;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\t¨\u0006\n"}, d2={"Landroidx/compose/ui/graphics/layer/RenderNodeVerificationHelper;", "", "<init>", "()V", "setRenderEffect", "", "renderNode", "Landroid/graphics/RenderNode;", "target", "Landroidx/compose/ui/graphics/RenderEffect;", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class RenderNodeVerificationHelper {
    public static final int $stable;
    public static final RenderNodeVerificationHelper INSTANCE;

    static {
        RenderNodeVerificationHelper.INSTANCE = new RenderNodeVerificationHelper();
    }

    private RenderNodeVerificationHelper() {
        super();
    }

    public final void setRenderEffect(RenderNode arg1, RenderEffect arg2) {
        android.graphics.RenderEffect v0 = arg2 != null ? arg2.asAndroidRenderEffect() : null;
        arg1.setRenderEffect(v0);
    }
}

