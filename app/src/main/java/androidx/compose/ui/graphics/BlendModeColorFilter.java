package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0007\u0018\u00002\u00020\u0001B%\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\n\u0010\u0006\u001A\u00060\u0007j\u0002`\b¢\u0006\u0004\b\t\u0010\nB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\t\u0010\u000BJ\u0013\u0010\u0012\u001A\u00020\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001A\u00020\u0017H\u0016J\b\u0010\u0018\u001A\u00020\u0019H\u0016R\u0013\u0010\u0002\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u000E\u001A\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\u0011\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u001A"}, d2={"Landroidx/compose/ui/graphics/BlendModeColorFilter;", "Landroidx/compose/ui/graphics/ColorFilter;", "color", "Landroidx/compose/ui/graphics/Color;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "nativeColorFilter", "Landroid/graphics/ColorFilter;", "Landroidx/compose/ui/graphics/NativeColorFilter;", "<init>", "(JILandroid/graphics/ColorFilter;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(JILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getColor-0d7_KjU", "()J", "J", "getBlendMode-0nO6VwU", "()I", "I", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class BlendModeColorFilter extends ColorFilter {
    public static final int $stable;
    private final int blendMode;
    private final long color;

    static {
    }

    public BlendModeColorFilter(long arg1, int arg3, DefaultConstructorMarker arg4) {
        this(arg1, arg3);
    }

    private BlendModeColorFilter(long arg7, int arg9) {
        this(arg7, arg9, AndroidColorFilter_androidKt.actualTintColorFilter-xETnrds(arg7, arg9), null);
    }

    public BlendModeColorFilter(long arg1, int arg3, android.graphics.ColorFilter arg4, DefaultConstructorMarker arg5) {
        this(arg1, arg3, arg4);
    }

    private BlendModeColorFilter(long arg1, int arg3, android.graphics.ColorFilter arg4) {
        super(arg4);
        this.color = arg1;
        this.blendMode = arg3;
    }

    public boolean equals(Object arg8) {
        if(this == (((BlendModeColorFilter)arg8))) {
            return 1;
        }

        if(!(arg8 instanceof BlendModeColorFilter)) {
            return 0;
        }

        if(!Color.equals-impl0(this.color, ((BlendModeColorFilter)arg8).color)) {
            return 0;
        }

        if(!BlendMode.equals-impl0(this.blendMode, ((BlendModeColorFilter)arg8).blendMode)) {
            return 0;
        }

        return 1;
    }

    public final int getBlendMode-0nO6VwU() {
        return this.blendMode;
    }

    public final long getColor-0d7_KjU() {
        return this.color;
    }

    public int hashCode() {
        return Color.hashCode-impl(this.color) * 0x1F + BlendMode.hashCode-impl(this.blendMode);
    }

    public String toString() {
        return "BlendModeColorFilter(color=" + Color.toString-impl(this.color) + ", blendMode=" + BlendMode.toString-impl(this.blendMode) + ')';
    }
}

