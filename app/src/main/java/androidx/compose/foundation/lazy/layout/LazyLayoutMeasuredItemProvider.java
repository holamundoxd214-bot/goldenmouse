package androidx.compose.foundation.lazy.layout;

import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntObjectMap;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b!\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J/\u0010\n\u001A\u00028\u00002\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u000E\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\u0010H&¢\u0006\u0004\b\u0011\u0010\u0012J\'\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\t0\b*\u00020\u00142\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\u0010¢\u0006\u0004\b\u0015\u0010\u0016R\u001A\u0010\u0006\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2={"Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItemProvider;", "T", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;", "", "<init>", "()V", "placeablesCache", "Landroidx/collection/MutableIntObjectMap;", "", "Landroidx/compose/ui/layout/Placeable;", "getAndMeasure", "index", "", "lane", "span", "constraints", "Landroidx/compose/ui/unit/Constraints;", "getAndMeasure--hBUhpc", "(IIIJ)Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;", "getPlaceables", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "getPlaceables-3p2s80s", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;IJ)Ljava/util/List;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class LazyLayoutMeasuredItemProvider {
    public static final int $stable = 8;
    private final MutableIntObjectMap placeablesCache;

    static {
    }

    public LazyLayoutMeasuredItemProvider() {
        super();
        this.placeablesCache = IntObjectMapKt.mutableIntObjectMapOf();
    }

    public abstract LazyLayoutMeasuredItem getAndMeasure--hBUhpc(int arg1, int arg2, int arg3, long arg4);

    public final List getPlaceables-3p2s80s(LazyLayoutMeasureScope arg5, int arg6, long arg7) {
        Object v0 = this.placeablesCache.get(arg6);
        if(v0 != null) {
            return ((List)v0);
        }

        List v5 = arg5.compose(arg6);
        int v0_1 = v5.size();
        ArrayList v1 = new ArrayList(v0_1);
        int v2;
        for(v2 = 0; v2 < v0_1; ++v2) {
            v1.add(v5.get(v2).measure-BRTryo0(arg7));
        }

        this.placeablesCache.set(arg6, v1);
        return ((List)v1);
    }
}

