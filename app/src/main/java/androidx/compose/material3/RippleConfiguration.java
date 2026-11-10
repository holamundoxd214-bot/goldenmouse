package androidx.compose.material3;

import androidx.compose.material.ripple.RippleAlpha;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001D\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0010\u001A\u00020\u0011H\u0016J\b\u0010\u0012\u001A\u00020\u0013H\u0016R\u0013\u0010\u0002\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001A\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\f¨\u0006\u0014"}, d2={"Landroidx/compose/material3/RippleConfiguration;", "", "color", "Landroidx/compose/ui/graphics/Color;", "rippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "<init>", "(JLandroidx/compose/material/ripple/RippleAlpha;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getColor-0d7_KjU", "()J", "J", "getRippleAlpha", "()Landroidx/compose/material/ripple/RippleAlpha;", "equals", "", "other", "hashCode", "", "toString", "", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class RippleConfiguration {
    public static final int $stable;
    private final long color;
    private final RippleAlpha rippleAlpha;

    static {
    }

    private RippleConfiguration(long arg1, RippleAlpha arg3) {
        super();
        this.color = arg1;
        this.rippleAlpha = arg3;
    }

    public RippleConfiguration(long arg1, RippleAlpha arg3, int arg4, DefaultConstructorMarker arg5) {
        if((arg4 & 1) != 0) {
            arg1 = Color.Companion.getUnspecified-0d7_KjU();
        }

        arg5 = null;
        if((arg4 & 2) != 0) {
            arg3 = ((RippleAlpha)arg5);
        }

        this(arg1, arg3, arg5);
    }

    public RippleConfiguration(long arg1, RippleAlpha arg3, DefaultConstructorMarker arg4) {
        this(arg1, arg3);
    }

    public boolean equals(Object arg8) {
        if(this == (((RippleConfiguration)arg8))) {
            return 1;
        }

        if(!(arg8 instanceof RippleConfiguration)) {
            return 0;
        }

        if(!Color.equals-impl0(this.color, ((RippleConfiguration)arg8).color)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.rippleAlpha, ((RippleConfiguration)arg8).rippleAlpha)) {
            return 0;
        }

        return 1;
    }

    public final long getColor-0d7_KjU() {
        return this.color;
    }

    public final RippleAlpha getRippleAlpha() {
        return this.rippleAlpha;
    }

    public int hashCode() {
        int v0 = Color.hashCode-impl(this.color) * 0x1F;
        RippleAlpha v2 = this.rippleAlpha;
        int v2_1 = v2 != null ? v2.hashCode() : 0;
        return v0 + v2_1;
    }

    public String toString() {
        return "RippleConfiguration(color=" + Color.toString-impl(this.color) + ", rippleAlpha=" + this.rippleAlpha + ')';
    }
}

