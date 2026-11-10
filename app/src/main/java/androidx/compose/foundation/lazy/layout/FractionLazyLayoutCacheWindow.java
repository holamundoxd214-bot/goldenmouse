package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.math.MathKt;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\n\u001A\u00020\u000B*\u00020\f2\u0006\u0010\r\u001A\u00020\u000BH\u0016J\u0014\u0010\u000E\u001A\u00020\u000B*\u00020\f2\u0006\u0010\r\u001A\u00020\u000BH\u0016J\b\u0010\u000F\u001A\u00020\u000BH\u0016J\u0013\u0010\u0010\u001A\u00020\u00112\b\u0010\u0012\u001A\u0004\u0018\u00010\u0013H\u0096\u0002R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\b¨\u0006\u0014"}, d2={"Landroidx/compose/foundation/lazy/layout/FractionLazyLayoutCacheWindow;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutCacheWindow;", "aheadFraction", "", "behindFraction", "<init>", "(FF)V", "getAheadFraction", "()F", "getBehindFraction", "calculateAheadWindow", "", "Landroidx/compose/ui/unit/Density;", "viewport", "calculateBehindWindow", "hashCode", "equals", "", "other", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class FractionLazyLayoutCacheWindow implements LazyLayoutCacheWindow {
    private final float aheadFraction;
    private final float behindFraction;

    public FractionLazyLayoutCacheWindow(float arg1, float arg2) {
        super();
        this.aheadFraction = arg1;
        this.behindFraction = arg2;
    }

    public int calculateAheadWindow(Density arg1, int arg2) {
        return MathKt.roundToInt((((float)arg2)) * this.aheadFraction);
    }

    public int calculateBehindWindow(Density arg1, int arg2) {
        return MathKt.roundToInt((((float)arg2)) * this.behindFraction);
    }

    public boolean equals(Object arg4) {
        if(((arg4 instanceof FractionLazyLayoutCacheWindow)) && ((FractionLazyLayoutCacheWindow)arg4).aheadFraction == this.aheadFraction && ((FractionLazyLayoutCacheWindow)arg4).behindFraction == this.behindFraction) {
            return 1;
        }

        return 0;
    }

    public final float getAheadFraction() {
        return this.aheadFraction;
    }

    public final float getBehindFraction() {
        return this.behindFraction;
    }

    public int hashCode() {
        return Float.hashCode(this.aheadFraction) * 0x1F + Float.hashCode(this.behindFraction);
    }
}

