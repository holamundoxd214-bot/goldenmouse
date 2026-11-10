package androidx.lifecycle;

import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMap;
import androidx.collection.ScatterMapKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A0\u0010\u0000\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001H\u0002¨\u0006\u0004"}, d2={"toScatterMap", "Landroidx/collection/ScatterMap;", "K", "V", "lifecycle-viewmodel"}, k=2, mv={2, 1, 0}, xi=0x30) public final class ViewModelStoreKt {
    private static final ScatterMap toScatterMap(ScatterMap arg2) {
        if(arg2.isEmpty()) {
            return ScatterMapKt.emptyScatterMap();
        }

        MutableScatterMap v0 = new MutableScatterMap(arg2.getSize());
        v0.putAll(arg2);
        return ((ScatterMap)v0);
    }
}

