package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0015\b\u0000\u0012\n\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u001A\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\t\u001A\u0004\b\u0007\u0010\b¨\u0006\u000B"}, d2={"Landroidx/compose/ui/graphics/ColorFilter;", "", "nativeColorFilter", "Landroid/graphics/ColorFilter;", "Landroidx/compose/ui/graphics/NativeColorFilter;", "<init>", "(Landroid/graphics/ColorFilter;)V", "getNativeColorFilter$ui_graphics", "()Landroid/graphics/ColorFilter;", "Landroid/graphics/ColorFilter;", "Companion", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public class ColorFilter {
    @Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010\f\u001A\u00020\u00052\u0006\u0010\f\u001A\u00020\rH\u0007¢\u0006\u0004\b\u000E\u0010\u000FJ\u001F\u0010\u0010\u001A\u00020\u00052\u0006\u0010\u0011\u001A\u00020\u00072\u0006\u0010\u0012\u001A\u00020\u0007H\u0007¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2={"Landroidx/compose/ui/graphics/ColorFilter$Companion;", "", "<init>", "()V", "tint", "Landroidx/compose/ui/graphics/ColorFilter;", "color", "Landroidx/compose/ui/graphics/Color;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "tint-xETnrds", "(JI)Landroidx/compose/ui/graphics/ColorFilter;", "colorMatrix", "Landroidx/compose/ui/graphics/ColorMatrix;", "colorMatrix-jHG-Opc", "([F)Landroidx/compose/ui/graphics/ColorFilter;", "lighting", "multiply", "add", "lighting--OWjLjI", "(JJ)Landroidx/compose/ui/graphics/ColorFilter;", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final ColorFilter colorMatrix-jHG-Opc(float[] arg2) {
            return new ColorMatrixColorFilter(arg2, null);
        }

        public final ColorFilter lighting--OWjLjI(long arg7, long arg9) {
            return new LightingColorFilter(arg7, arg9, null);
        }

        public final ColorFilter tint-xETnrds(long arg2, int arg4) {
            return new BlendModeColorFilter(arg2, arg4, null);
        }

        public static ColorFilter tint-xETnrds$default(Companion arg0, long arg1, int arg3, int arg4, Object arg5) {
            if((arg4 & 2) != 0) {
                arg3 = BlendMode.Companion.getSrcIn-0nO6VwU();
            }

            return arg0.tint-xETnrds(arg1, arg3);
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private final android.graphics.ColorFilter nativeColorFilter;

    static {
        ColorFilter.Companion = new Companion(null);
    }

    public ColorFilter(android.graphics.ColorFilter arg1) {
        super();
        this.nativeColorFilter = arg1;
    }

    public final android.graphics.ColorFilter getNativeColorFilter$ui_graphics() {
        return this.nativeColorFilter;
    }
}

