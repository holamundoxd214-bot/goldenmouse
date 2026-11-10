package androidx.compose.foundation.lazy.layout;

import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u0001R\u001C\u0010\u0007\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u00050\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001A\u0004\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2={"Landroidx/compose/foundation/lazy/layout/PrefetchMetrics;", "", "<init>", "()V", "getAverage", "Landroidx/compose/foundation/lazy/layout/Averages;", "contentType", "averagesByContentType", "Landroidx/collection/MutableScatterMap;", "lastUsedContentType", "lastUsedAverage", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PrefetchMetrics {
    public static final int $stable = 8;
    private final MutableScatterMap averagesByContentType;
    private Averages lastUsedAverage;
    private Object lastUsedContentType;

    static {
    }

    public PrefetchMetrics() {
        super();
        this.averagesByContentType = ScatterMapKt.mutableScatterMapOf();
    }

    public final Averages getAverage(Object arg3) {
        Averages v0 = this.lastUsedAverage;
        if(this.lastUsedContentType == arg3 && v0 != null) {
            return v0;
        }

        MutableScatterMap v0_1 = this.averagesByContentType;
        Object v1 = v0_1.get(arg3);
        if(v1 == null) {
            Averages v1_1 = new Averages();
            v0_1.set(arg3, v1_1);
        }

        this.lastUsedContentType = arg3;
        this.lastUsedAverage = ((Averages)v1);
        return ((Averages)v1);
    }
}

