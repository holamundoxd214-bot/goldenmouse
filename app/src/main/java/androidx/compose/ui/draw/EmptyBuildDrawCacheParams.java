package androidx.compose.ui.draw;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001A\u00020\u0005X\u0096\u0004¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001A\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0014\u0010\r\u001A\u00020\u000EX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u0011"}, d2={"Landroidx/compose/ui/draw/EmptyBuildDrawCacheParams;", "Landroidx/compose/ui/draw/BuildDrawCacheParams;", "<init>", "()V", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "()J", "J", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class EmptyBuildDrawCacheParams implements BuildDrawCacheParams {
    public static final EmptyBuildDrawCacheParams INSTANCE;
    private static final Density density;
    private static final LayoutDirection layoutDirection;
    private static final long size;

    static {
        EmptyBuildDrawCacheParams.INSTANCE = new EmptyBuildDrawCacheParams();
        EmptyBuildDrawCacheParams.size = Size.Companion.getUnspecified-NH-jbRc();
        EmptyBuildDrawCacheParams.layoutDirection = LayoutDirection.Ltr;
        EmptyBuildDrawCacheParams.density = DensityKt.Density(1f, 1f);
    }

    private EmptyBuildDrawCacheParams() {
        super();
    }

    public Density getDensity() {
        return EmptyBuildDrawCacheParams.density;
    }

    public LayoutDirection getLayoutDirection() {
        return EmptyBuildDrawCacheParams.layoutDirection;
    }

    public long getSize-NH-jbRc() {
        return EmptyBuildDrawCacheParams.size;
    }
}

