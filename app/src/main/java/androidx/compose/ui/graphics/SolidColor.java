package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\'\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0014\u001A\u00020\u00152\b\u0010\u0016\u001A\u0004\u0018\u00010\u0017H\u0096\u0002J\b\u0010\u0018\u001A\u00020\u0019H\u0016J\b\u0010\u001A\u001A\u00020\u001BH\u0016J\u001C\u0010\u001C\u001A\u0004\u0018\u00010\u00172\b\u0010\u0016\u001A\u0004\u0018\u00010\u00172\u0006\u0010\u001D\u001A\u00020\u0011H\u0016R\u0013\u0010\u0003\u001A\u00020\u0004¢\u0006\n\n\u0002\u0010\t\u001A\u0004\b\u0007\u0010\b¨\u0006\u001E"}, d2={"Landroidx/compose/ui/graphics/SolidColor;", "Landroidx/compose/ui/graphics/Brush;", "Landroidx/compose/ui/graphics/Interpolatable;", "value", "Landroidx/compose/ui/graphics/Color;", "<init>", "(JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getValue-0d7_KjU", "()J", "J", "applyTo", "", "size", "Landroidx/compose/ui/geometry/Size;", "p", "Landroidx/compose/ui/graphics/Paint;", "alpha", "", "applyTo-Pq9zytI", "(JLandroidx/compose/ui/graphics/Paint;F)V", "equals", "", "other", "", "hashCode", "", "toString", "", "lerp", "t", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SolidColor extends Brush implements Interpolatable {
    public static final int $stable;
    private final long value;

    static {
    }

    public SolidColor(long arg1, DefaultConstructorMarker arg3) {
        this(arg1);
    }

    private SolidColor(long arg2) {
        super(null);
        this.value = arg2;
    }

    public void applyTo-Pq9zytI(long arg9, Paint arg11, float arg12) {
        arg11.setAlpha(1f);
        int v9 = Float.compare(arg12, 1f);
        long v0 = this.value;
        if(v9 == 0) {
        }
        else {
            v0 = Color.copy-wmQWz5c$default(v0, Color.getAlpha-impl(v0) * arg12, 0f, 0f, 0f, 14, null);
        }

        arg11.setColor-8_81llA(v0);
        if(arg11.getShader() != null) {
            arg11.setShader(null);
        }
    }

    public boolean equals(Object arg6) {
        if(this == (((SolidColor)arg6))) {
            return 1;
        }

        if(!(arg6 instanceof SolidColor)) {
            return 0;
        }

        if(!Color.equals-impl0(this.value, ((SolidColor)arg6).value)) {
            return 0;
        }

        return 1;
    }

    public final long getValue-0d7_KjU() {
        return this.value;
    }

    public int hashCode() {
        return Color.hashCode-impl(this.value);
    }

    public Object lerp(Object arg5, float arg6) {
        SolidColor v5;
        DefaultConstructorMarker v0 = null;
        if(arg5 == null) {
            v5 = new SolidColor(Color.Companion.getTransparent-0d7_KjU(), v0);
        }

        if((v5 instanceof SolidColor)) {
            return new SolidColor(ColorKt.lerp-jxsXWHM(this.value, v5.value, arg6), v0);
        }

        return v0;
    }

    public String toString() {
        return "SolidColor(value=" + Color.toString-impl(this.value) + ')';
    }
}

