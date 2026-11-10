package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u000F\u0012\u0006\u0010\u0003\u001A\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\t\u001A\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\nR\u001C\u0010\u0006\u001A\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00018\u00008\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2={"Landroidx/lifecycle/WeakReference;", "T", "", "reference", "<init>", "(Ljava/lang/Object;)V", "delegate", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "get", "()Ljava/lang/Object;", "lifecycle-runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class WeakReference {
    private final java.lang.ref.WeakReference delegate;

    public WeakReference(Object arg2) {
        Intrinsics.checkNotNullParameter(arg2, "reference");
        super();
        this.delegate = new java.lang.ref.WeakReference(arg2);
    }

    public final Object get() {
        return this.delegate.get();
    }
}

