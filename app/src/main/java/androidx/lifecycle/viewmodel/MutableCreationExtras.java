package androidx.lifecycle.viewmodel;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B#\b\u0000\u0012\u0018\u0010\u0002\u001A\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007B\u0013\b\u0017\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0001¢\u0006\u0004\b\u0006\u0010\bJ*\u0010\t\u001A\u00020\n\"\u0004\b\u0000\u0010\u000B2\f\u0010\f\u001A\b\u0012\u0004\u0012\u0002H\u000B0\u00042\u0006\u0010\r\u001A\u0002H\u000BH\u0086\u0002¢\u0006\u0002\u0010\u000EJ$\u0010\u000F\u001A\u0004\u0018\u0001H\u000B\"\u0004\b\u0000\u0010\u000B2\f\u0010\f\u001A\b\u0012\u0004\u0012\u0002H\u000B0\u0004H\u0096\u0002¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2={"Landroidx/lifecycle/viewmodel/MutableCreationExtras;", "Landroidx/lifecycle/viewmodel/CreationExtras;", "initialExtras", "", "Landroidx/lifecycle/viewmodel/CreationExtras$Key;", "", "<init>", "(Ljava/util/Map;)V", "(Landroidx/lifecycle/viewmodel/CreationExtras;)V", "set", "", "T", "key", "t", "(Landroidx/lifecycle/viewmodel/CreationExtras$Key;Ljava/lang/Object;)V", "get", "(Landroidx/lifecycle/viewmodel/CreationExtras$Key;)Ljava/lang/Object;", "lifecycle-viewmodel"}, k=1, mv={2, 1, 0}, xi=0x30) public final class MutableCreationExtras extends CreationExtras {
    public MutableCreationExtras(CreationExtras arg1, int arg2, DefaultConstructorMarker arg3) {
        Empty v1;
        if((arg2 & 1) != 0) {
            v1 = Empty.INSTANCE;
        }

        this(((CreationExtras)v1));
    }

    public MutableCreationExtras(CreationExtras arg2) {
        Intrinsics.checkNotNullParameter(arg2, "initialExtras");
        this(arg2.getExtras$lifecycle_viewmodel());
    }

    public MutableCreationExtras(Map arg2) {
        Intrinsics.checkNotNullParameter(arg2, "initialExtras");
        super();
        this.getExtras$lifecycle_viewmodel().putAll(arg2);
    }

    public MutableCreationExtras() {
        this(null, 1, null);
    }

    public Object get(Key arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        return this.getExtras$lifecycle_viewmodel().get(arg2);
    }

    public final void set(Key arg2, Object arg3) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        this.getExtras$lifecycle_viewmodel().put(arg2, arg3);
    }
}

