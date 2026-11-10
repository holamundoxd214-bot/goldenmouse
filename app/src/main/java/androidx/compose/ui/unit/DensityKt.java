package androidx.compose.ui.unit;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u001A\u001A\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0003H\u0007¨\u0006\u0005"}, d2={"Density", "Landroidx/compose/ui/unit/Density;", "density", "", "fontScale", "ui-unit"}, k=2, mv={2, 0, 0}, xi=0x30) public final class DensityKt {
    public static final Density Density(float arg1, float arg2) {
        return new DensityImpl(arg1, arg2);
    }

    public static Density Density$default(float arg0, float arg1, int arg2, Object arg3) {
        if((arg2 & 2) != 0) {
            arg1 = 1f;
        }

        return DensityKt.Density(arg0, arg1);
    }
}

