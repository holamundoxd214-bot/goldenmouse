package androidx.compose.ui.semantics;

import android.graphics.Region$Op;
import android.graphics.Region;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.unit.IntRect;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0016J\u0010\u0010\u0012\u001A\u00020\u00102\u0006\u0010\u0004\u001A\u00020\u0001H\u0016J\u0010\u0010\u0013\u001A\u00020\u00102\u0006\u0010\n\u001A\u00020\u000BH\u0016R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0014\u0010\f\u001A\u00020\u000B8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\u000ER\u0014\u0010\u000F\u001A\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0011¨\u0006\u0014"}, d2={"Landroidx/compose/ui/semantics/SemanticRegionImpl;", "Landroidx/compose/ui/semantics/SemanticsRegion;", "<init>", "()V", "region", "Landroid/graphics/Region;", "getRegion", "()Landroid/graphics/Region;", "set", "", "rect", "Landroidx/compose/ui/unit/IntRect;", "bounds", "getBounds", "()Landroidx/compose/ui/unit/IntRect;", "isEmpty", "", "()Z", "intersect", "difference", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class SemanticRegionImpl implements SemanticsRegion {
    private final Region region;

    public SemanticRegionImpl() {
        super();
        this.region = new Region();
    }

    public boolean difference(IntRect arg7) {
        return this.region.op(arg7.getLeft(), arg7.getTop(), arg7.getRight(), arg7.getBottom(), Region$Op.DIFFERENCE);
    }

    public IntRect getBounds() {
        return RectHelper_androidKt.toComposeIntRect(this.region.getBounds());
    }

    public final Region getRegion() {
        return this.region;
    }

    public boolean intersect(SemanticsRegion arg2) {
        Region v1 = this.region;
        Intrinsics.checkNotNull(arg2, "null cannot be cast to non-null type androidx.compose.ui.semantics.SemanticRegionImpl");
        return v1.op(((SemanticRegionImpl)arg2).region, Region$Op.INTERSECT);
    }

    public boolean isEmpty() {
        return this.region.isEmpty();
    }

    public void set(IntRect arg4) {
        this.region.set(arg4.getLeft(), arg4.getTop(), arg4.getRight(), arg4.getBottom());
    }
}

