package androidx.compose.foundation;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Deprecated(message="Providing `OverscrollConfiguration` through `LocalOverscrollConfiguration` to disable / configure overscroll has been replaced with `LocalOverscrollFactory` and `rememberPlatformOverscrollFactory`. To disable overscroll, instead of `LocalOverscrollConfiguration provides null`, use `LocalOverscrollFactory provides null`. To change the glow color / padding, instead of `LocalOverscrollConfiguration provides OverscrollConfiguration(myColor, myPadding)`, use `LocalOverscrollFactory provides rememberPlatformOverscrollFactory(myColor, myPadding)`") @Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001B\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0010\u001A\u00020\u0011H\u0016J\b\u0010\u0012\u001A\u00020\u0013H\u0016R\u0013\u0010\u0002\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\f¨\u0006\u0014"}, d2={"Landroidx/compose/foundation/OverscrollConfiguration;", "", "glowColor", "Landroidx/compose/ui/graphics/Color;", "drawPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "<init>", "(JLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getGlowColor-0d7_KjU", "()J", "J", "getDrawPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "equals", "", "other", "hashCode", "", "toString", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class OverscrollConfiguration {
    public static final int $stable;
    private final PaddingValues drawPadding;
    private final long glowColor;

    static {
    }

    private OverscrollConfiguration(long arg1, PaddingValues arg3) {
        super();
        this.glowColor = arg1;
        this.drawPadding = arg3;
    }

    public OverscrollConfiguration(long arg1, PaddingValues arg3, int arg4, DefaultConstructorMarker arg5) {
        if((arg4 & 1) != 0) {
            arg1 = ColorKt.Color(0xFF666666L);
        }

        Object v5 = null;
        if((arg4 & 2) != 0) {
            arg3 = PaddingKt.PaddingValues-YgX7TsA$default(0f, 0f, 3, v5);
        }

        this(arg1, arg3, ((DefaultConstructorMarker)v5));
    }

    public OverscrollConfiguration(long arg1, PaddingValues arg3, DefaultConstructorMarker arg4) {
        this(arg1, arg3);
    }

    public boolean equals(Object arg8) {
        if(this == (((OverscrollConfiguration)arg8))) {
            return 1;
        }

        Class v1 = this.getClass();
        if(arg8 != null) {
            Class v2 = arg8.getClass();
        }
        else {
            Object v2_1 = null;
        }

        if(!Intrinsics.areEqual(v1, v2)) {
            return 0;
        }

        Intrinsics.checkNotNull(arg8, "null cannot be cast to non-null type androidx.compose.foundation.OverscrollConfiguration");
        if(!Color.equals-impl0(this.glowColor, ((OverscrollConfiguration)arg8).glowColor)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.drawPadding, ((OverscrollConfiguration)arg8).drawPadding)) {
            return 0;
        }

        return 1;
    }

    public final PaddingValues getDrawPadding() {
        return this.drawPadding;
    }

    public final long getGlowColor-0d7_KjU() {
        return this.glowColor;
    }

    public int hashCode() {
        return Color.hashCode-impl(this.glowColor) * 0x1F + this.drawPadding.hashCode();
    }

    public String toString() {
        return "OverscrollConfiguration(glowColor=" + Color.toString-impl(this.glowColor) + ", drawPadding=" + this.drawPadding + ')';
    }
}

