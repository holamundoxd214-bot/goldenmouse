package androidx.core.os;

import android.os.PersistableBundle;
import java.util.Iterator;
import java.util.Map$Entry;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\u001A=\u0010\u0000\u001A\u00020\u00012.\u0010\u0002\u001A\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00040\u0003\"\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0007¢\u0006\u0002\u0010\u0007\u001A\u0006\u0010\u0000\u001A\u00020\u0001\u001A\u0018\u0010\b\u001A\u00020\u0001*\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\t¨\u0006\n"}, d2={"persistableBundleOf", "Landroid/os/PersistableBundle;", "pairs", "", "Lkotlin/Pair;", "", "", "([Lkotlin/Pair;)Landroid/os/PersistableBundle;", "toPersistableBundle", "", "core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class PersistableBundleKt {
    public static final PersistableBundle persistableBundleOf() {
        return new PersistableBundle(0);
    }

    @Deprecated(message="This method does not provide type safety at compile time. Use the platform `PersistableBundle` class directly instead.") public static final PersistableBundle persistableBundleOf(Pair[] arg5) {
        Intrinsics.checkNotNullParameter(arg5, "pairs");
        PersistableBundle v0 = new PersistableBundle(arg5.length);
        int v1 = arg5.length;
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            PersistableBundleApi21ImplKt.putValue(v0, arg5[v2].component1(), arg5[v2].component2());
        }

        return v0;
    }

    public static final PersistableBundle toPersistableBundle(Map arg3) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        PersistableBundle v0 = new PersistableBundle(arg3.size());
        Iterator v3 = arg3.entrySet().iterator();
        while(v3.hasNext()) {
            Object v1 = v3.next();
            PersistableBundleApi21ImplKt.putValue(v0, ((Map$Entry)v1).getKey(), ((Map$Entry)v1).getValue());
        }

        return v0;
    }
}

