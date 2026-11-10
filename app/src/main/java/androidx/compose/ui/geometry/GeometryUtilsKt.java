package androidx.compose.ui.geometry;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0012\n\u0000\n\u0002\u0010\u000E\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\u001A\u0014\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0000¨\u0006\u0005"}, d2={"toStringAsFixed", "", "", "digits", "", "ui-geometry"}, k=2, mv={2, 0, 0}, xi=0x30) public final class GeometryUtilsKt {
    public static final String toStringAsFixed(float arg4, int arg5) {
        if(Float.isNaN(arg4)) {
            return "NaN";
        }

        if(Float.isInfinite(arg4)) {
            if(arg4 < 0f) {
                return "-Infinity";
            }

            return "Infinity";
        }

        arg5 = Math.max(arg5, 0);
        float v0 = ((float)Math.pow(10, ((double)arg5)));
        arg4 *= v0;
        int v1 = ((int)arg4);
        if(arg4 - (((float)v1)) >= 0.5f) {
            ++v1;
        }

        arg4 = (((float)v1)) / v0;
        if(arg5 > 0) {
            return String.valueOf(arg4);
        }

        return String.valueOf(((int)arg4));
    }
}

