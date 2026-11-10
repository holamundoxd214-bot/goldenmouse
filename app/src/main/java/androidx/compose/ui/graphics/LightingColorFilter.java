package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0007\u0018\u00002\u00020\u0001B%\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\n\u0010\u0005\u001A\u00060\u0006j\u0002`\u0007¢\u0006\u0004\b\b\u0010\tB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\b\u0010\nJ\u0013\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001A\u00020\u0014H\u0016J\b\u0010\u0015\u001A\u00020\u0016H\u0016R\u0013\u0010\u0002\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001A\u0004\b\u000B\u0010\fR\u0013\u0010\u0004\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001A\u0004\b\u000E\u0010\f¨\u0006\u0017"}, d2={"Landroidx/compose/ui/graphics/LightingColorFilter;", "Landroidx/compose/ui/graphics/ColorFilter;", "multiply", "Landroidx/compose/ui/graphics/Color;", "add", "nativeColorFilter", "Landroid/graphics/ColorFilter;", "Landroidx/compose/ui/graphics/NativeColorFilter;", "<init>", "(JJLandroid/graphics/ColorFilter;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getMultiply-0d7_KjU", "()J", "J", "getAdd-0d7_KjU", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LightingColorFilter extends ColorFilter {
    public static final int $stable;
    private final long add;
    private final long multiply;

    static {
    }

    public LightingColorFilter(long arg1, long arg3, android.graphics.ColorFilter arg5, DefaultConstructorMarker arg6) {
        this(arg1, arg3, arg5);
    }

    public LightingColorFilter(long arg1, long arg3, DefaultConstructorMarker arg5) {
        this(arg1, arg3);
    }

    private LightingColorFilter(long arg8, long arg10) {
        this(arg8, arg10, AndroidColorFilter_androidKt.actualLightingColorFilter--OWjLjI(arg8, arg10), null);
    }

    private LightingColorFilter(long arg1, long arg3, android.graphics.ColorFilter arg5) {
        super(arg5);
        this.multiply = arg1;
        this.add = arg3;
    }

    public boolean equals(Object arg8) {
        if(this == (((LightingColorFilter)arg8))) {
            return 1;
        }

        if(!(arg8 instanceof LightingColorFilter)) {
            return 0;
        }

        if(!Color.equals-impl0(this.multiply, ((LightingColorFilter)arg8).multiply)) {
            return 0;
        }

        if(!Color.equals-impl0(this.add, ((LightingColorFilter)arg8).add)) {
            return 0;
        }

        return 1;
    }

    public final long getAdd-0d7_KjU() {
        return this.add;
    }

    public final long getMultiply-0d7_KjU() {
        return this.multiply;
    }

    public int hashCode() {
        return Color.hashCode-impl(this.multiply) * 0x1F + Color.hashCode-impl(this.add);
    }

    public String toString() {
        return "LightingColorFilter(multiply=" + Color.toString-impl(this.multiply) + ", add=" + Color.toString-impl(this.add) + ')';
    }
}

