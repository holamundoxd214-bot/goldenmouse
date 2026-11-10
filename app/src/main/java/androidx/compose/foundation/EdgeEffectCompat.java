package androidx.compose.foundation;

import android.content.Context;
import android.os.Build$VERSION;
import android.widget.EdgeEffect;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.math.MathKt;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007J\u001A\u0010\b\u001A\u00020\t*\u00020\u00052\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\u000B\u001A\u00020\tJ\u0012\u0010\f\u001A\u00020\r*\u00020\u00052\u0006\u0010\u000E\u001A\u00020\u000FJ\"\u0010\u0010\u001A\u00020\t*\u00020\u00052\u0006\u0010\u000E\u001A\u00020\t2\u0006\u0010\u0011\u001A\u00020\t2\u0006\u0010\u0012\u001A\u00020\u0013J\u0012\u0010\u0014\u001A\u00020\r*\u00020\u00052\u0006\u0010\u0015\u001A\u00020\tR\u0015\u0010\u0016\u001A\u00020\t*\u00020\u00058F¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2={"Landroidx/compose/foundation/EdgeEffectCompat;", "", "<init>", "()V", "create", "Landroid/widget/EdgeEffect;", "context", "Landroid/content/Context;", "onPullDistanceCompat", "", "deltaDistance", "displacement", "onAbsorbCompat", "", "velocity", "", "absorbToRelaxIfNeeded", "edgeEffectLength", "density", "Landroidx/compose/ui/unit/Density;", "onReleaseWithOppositeDelta", "delta", "distanceCompat", "getDistanceCompat", "(Landroid/widget/EdgeEffect;)F", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class EdgeEffectCompat {
    public static final int $stable;
    public static final EdgeEffectCompat INSTANCE;

    static {
        EdgeEffectCompat.INSTANCE = new EdgeEffectCompat();
    }

    private EdgeEffectCompat() {
        super();
    }

    public final float absorbToRelaxIfNeeded(EdgeEffect arg2, float arg3, float arg4, Density arg5) {
        if(EdgeEffectCompat_androidKt.access$flingDistance(arg5, arg3) <= this.getDistanceCompat(arg2) * arg4) {
            this.onAbsorbCompat(arg2, MathKt.roundToInt(arg3));
            return arg3;
        }

        return 0;
    }

    public final EdgeEffect create(Context arg2) {
        if(Build$VERSION.SDK_INT >= 0x1F) {
            return Api31Impl.INSTANCE.create(arg2, null);
        }

        return new GlowEdgeEffectCompat(arg2);
    }

    public final float getDistanceCompat(EdgeEffect arg2) {
        if(Build$VERSION.SDK_INT >= 0x1F) {
            return Api31Impl.INSTANCE.getDistance(arg2);
        }

        return 0;
    }

    public final void onAbsorbCompat(EdgeEffect arg2, int arg3) {
        if(Build$VERSION.SDK_INT >= 0x1F) {
            arg2.onAbsorb(arg3);
            return;
        }

        if(arg2.isFinished()) {
            arg2.onAbsorb(arg3);
        }
    }

    public final float onPullDistanceCompat(EdgeEffect arg2, float arg3, float arg4) {
        if(Build$VERSION.SDK_INT >= 0x1F) {
            return Api31Impl.INSTANCE.onPullDistance(arg2, arg3, arg4);
        }

        arg2.onPull(arg3, arg4);
        return arg3;
    }

    public final void onReleaseWithOppositeDelta(EdgeEffect arg1, float arg2) {
        if((arg1 instanceof GlowEdgeEffectCompat)) {
            ((GlowEdgeEffectCompat)arg1).releaseWithOppositeDelta(arg2);
            return;
        }

        arg1.onRelease();
    }
}

