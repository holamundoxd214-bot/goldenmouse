package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0014\u0010\u0000\u001A\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2={"DefaultDensity", "Landroidx/compose/ui/unit/Density;", "getDefaultDensity", "()Landroidx/compose/ui/unit/Density;", "ui-graphics"}, k=2, mv={2, 0, 0}, xi=0x30) public final class DrawContextKt {
    private static final Density DefaultDensity;

    static {
        DrawContextKt.DefaultDensity = DensityKt.Density(1f, 1f);
    }

    public static final Density getDefaultDensity() {
        return DrawContextKt.DefaultDensity;
    }
}

