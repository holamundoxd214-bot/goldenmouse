package androidx.compose.ui.platform;

import android.graphics.RenderNode;
import androidx.compose.ui.graphics.RenderEffect;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\t¨\u0006\n"}, d2={"Landroidx/compose/ui/platform/RenderNodeApi29VerificationHelper;", "", "<init>", "()V", "setRenderEffect", "", "renderNode", "Landroid/graphics/RenderNode;", "target", "Landroidx/compose/ui/graphics/RenderEffect;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class RenderNodeApi29VerificationHelper {
    public static final RenderNodeApi29VerificationHelper INSTANCE;

    static {
        RenderNodeApi29VerificationHelper.INSTANCE = new RenderNodeApi29VerificationHelper();
    }

    private RenderNodeApi29VerificationHelper() {
        super();
    }

    public final void setRenderEffect(RenderNode arg1, RenderEffect arg2) {
        android.graphics.RenderEffect v0 = arg2 != null ? arg2.asAndroidRenderEffect() : null;
        arg1.setRenderEffect(v0);
    }
}

