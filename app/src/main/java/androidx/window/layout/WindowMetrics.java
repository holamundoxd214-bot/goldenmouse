package androidx.window.layout;

import android.graphics.Rect;
import androidx.window.core.Bounds;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0017\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\nJ\u0013\u0010\u0013\u001A\u00020\u00142\b\u0010\u0015\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0016\u001A\u00020\u0017H\u0016J\b\u0010\u0018\u001A\u00020\u0019H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\b\u001A\u00020\t8F¢\u0006\u0006\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\u000F\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\b\u0010\u0010\fR\u0011\u0010\u0011\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\b\u0012\u0010\f¨\u0006\u001A"}, d2={"Landroidx/window/layout/WindowMetrics;", "", "_bounds", "Landroidx/window/core/Bounds;", "density", "", "<init>", "(Landroidx/window/core/Bounds;F)V", "bounds", "Landroid/graphics/Rect;", "(Landroid/graphics/Rect;F)V", "getDensity", "()F", "getBounds", "()Landroid/graphics/Rect;", "widthDp", "getWidthDp", "heightDp", "getHeightDp", "equals", "", "other", "hashCode", "", "toString", "", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class WindowMetrics {
    private final Bounds _bounds;
    private final float density;

    public WindowMetrics(Rect arg2, float arg3) {
        Intrinsics.checkNotNullParameter(arg2, "bounds");
        this(new Bounds(arg2), arg3);
    }

    public WindowMetrics(Bounds arg2, float arg3) {
        Intrinsics.checkNotNullParameter(arg2, "_bounds");
        super();
        this._bounds = arg2;
        this.density = arg3;
    }

    public boolean equals(Object arg5) {
        if(this == (((WindowMetrics)arg5))) {
            return 1;
        }

        Class v1 = this.getClass();
        if(arg5 != null) {
            Class v2 = arg5.getClass();
        }
        else {
            Object v2_1 = null;
        }

        if(!Intrinsics.areEqual(v1, v2)) {
            return 0;
        }

        Intrinsics.checkNotNull(arg5, "null cannot be cast to non-null type androidx.window.layout.WindowMetrics");
        if(!Intrinsics.areEqual(this._bounds, ((WindowMetrics)arg5)._bounds)) {
            return 0;
        }

        if(this.density == ((WindowMetrics)arg5).density) {
            return 1;
        }

        return 0;
    }

    public final Rect getBounds() {
        return this._bounds.toRect();
    }

    public final float getDensity() {
        return this.density;
    }

    public final float getHeightDp() {
        return (((float)this.getBounds().height())) / this.density;
    }

    public final float getWidthDp() {
        return (((float)this.getBounds().width())) / this.density;
    }

    public int hashCode() {
        return this._bounds.hashCode() * 0x1F + Float.hashCode(this.density);
    }

    public String toString() {
        return "WindowMetrics(_bounds=" + this._bounds + ", density=" + this.density + ')';
    }
}

