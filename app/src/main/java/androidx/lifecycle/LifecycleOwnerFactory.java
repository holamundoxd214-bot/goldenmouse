package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u0015\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0007¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2={"LifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "create", "lifecycle-common"}, k=2, mv={2, 1, 0}, xi=0x30) public final class LifecycleOwnerFactory {
    public static final LifecycleOwner create(Lifecycle arg1) {
        Intrinsics.checkNotNullParameter(arg1, "lifecycle");
        return new LifecycleOwnerFactory$LifecycleOwner$1(arg1);
    }
}

