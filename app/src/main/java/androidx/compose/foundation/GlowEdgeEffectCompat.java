package androidx.compose.foundation;

import android.content.Context;
import android.widget.EdgeEffect;
import androidx.compose.ui.unit.AndroidDensity_androidKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\u0007H\u0016J\u0010\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\u0007H\u0016J\b\u0010\r\u001A\u00020\nH\u0016J\u0010\u0010\u000E\u001A\u00020\n2\u0006\u0010\u000F\u001A\u00020\u0010H\u0016J\u000E\u0010\u0011\u001A\u00020\n2\u0006\u0010\u0012\u001A\u00020\u0007R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2={"Landroidx/compose/foundation/GlowEdgeEffectCompat;", "Landroid/widget/EdgeEffect;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "oppositeReleaseDeltaThreshold", "", "oppositeReleaseDelta", "onPull", "", "deltaDistance", "displacement", "onRelease", "onAbsorb", "velocity", "", "releaseWithOppositeDelta", "delta", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class GlowEdgeEffectCompat extends EdgeEffect {
    private float oppositeReleaseDelta;
    private final float oppositeReleaseDeltaThreshold;

    public GlowEdgeEffectCompat(Context arg2) {
        super(arg2);
        this.oppositeReleaseDeltaThreshold = AndroidDensity_androidKt.Density(arg2).toPx-0680j_4(Dp.constructor-impl(1f));
    }

    public void onAbsorb(int arg2) {
        this.oppositeReleaseDelta = 0f;
        super.onAbsorb(arg2);
    }

    public void onPull(float arg2) {
        this.oppositeReleaseDelta = 0f;
        super.onPull(arg2);
    }

    public void onPull(float arg2, float arg3) {
        this.oppositeReleaseDelta = 0f;
        super.onPull(arg2, arg3);
    }

    public void onRelease() {
        this.oppositeReleaseDelta = 0f;
        super.onRelease();
    }

    public final void releaseWithOppositeDelta(float arg2) {
        float v0 = this.oppositeReleaseDelta + arg2;
        this.oppositeReleaseDelta = v0;
        if(Math.abs(v0) > this.oppositeReleaseDeltaThreshold) {
            this.onRelease();
        }
    }
}

