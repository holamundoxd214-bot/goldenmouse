package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\u000B\u001A\u00020\f*\u00020\r2\u0006\u0010\u000E\u001A\u00020\fH\u0016J\u0014\u0010\u000F\u001A\u00020\f*\u00020\r2\u0006\u0010\u000E\u001A\u00020\fH\u0016J\b\u0010\u0010\u001A\u00020\fH\u0016J\u0013\u0010\u0011\u001A\u00020\u00122\b\u0010\u0013\u001A\u0004\u0018\u00010\u0014H\u0096\u0002R\u0013\u0010\u0002\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\t\u001A\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\t\u001A\u0004\b\n\u0010\b¨\u0006\u0015"}, d2={"Landroidx/compose/foundation/lazy/layout/DpLazyLayoutCacheWindow;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutCacheWindow;", "ahead", "Landroidx/compose/ui/unit/Dp;", "behind", "<init>", "(FFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAhead-D9Ej5fM", "()F", "F", "getBehind-D9Ej5fM", "calculateAheadWindow", "", "Landroidx/compose/ui/unit/Density;", "viewport", "calculateBehindWindow", "hashCode", "equals", "", "other", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class DpLazyLayoutCacheWindow implements LazyLayoutCacheWindow {
    private final float ahead;
    private final float behind;

    private DpLazyLayoutCacheWindow(float arg1, float arg2) {
        super();
        this.ahead = arg1;
        this.behind = arg2;
    }

    public DpLazyLayoutCacheWindow(float arg1, float arg2, DefaultConstructorMarker arg3) {
        this(arg1, arg2);
    }

    public int calculateAheadWindow(Density arg1, int arg2) {
        return arg1.roundToPx-0680j_4(this.ahead);
    }

    public int calculateBehindWindow(Density arg1, int arg2) {
        return arg1.roundToPx-0680j_4(this.behind);
    }

    public boolean equals(Object arg4) {
        if(((arg4 instanceof DpLazyLayoutCacheWindow)) && (Dp.equals-impl0(((DpLazyLayoutCacheWindow)arg4).ahead, this.ahead)) && (Dp.equals-impl0(((DpLazyLayoutCacheWindow)arg4).behind, this.behind))) {
            return 1;
        }

        return 0;
    }

    public final float getAhead-D9Ej5fM() {
        return this.ahead;
    }

    public final float getBehind-D9Ej5fM() {
        return this.behind;
    }

    public int hashCode() {
        return Dp.hashCode-impl(this.ahead) * 0x1F + Dp.hashCode-impl(this.behind);
    }
}

