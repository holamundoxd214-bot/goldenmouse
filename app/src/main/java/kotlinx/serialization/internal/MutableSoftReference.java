package kotlinx.serialization.internal;

import java.lang.ref.SoftReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001A\u00028\u00002\f\u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0002\u0010\nR\u0018\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u00068\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2={"Lkotlinx/serialization/internal/MutableSoftReference;", "T", "", "<init>", "()V", "reference", "Ljava/lang/ref/SoftReference;", "getOrSetWithLock", "factory", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) final class MutableSoftReference {
    public volatile SoftReference reference;

    public MutableSoftReference() {
        super();
        this.reference = new SoftReference(null);
    }

    public final Object getOrSetWithLock(Function0 arg2) {
        Object v2_1;
        Object v0;
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(arg2, "factory");
            v0 = this.reference.get();
            if(v0 == null) {
                goto label_8;
            }
        }
        catch(Throwable v2) {
            goto label_15;
        }

        __monitor_exit(this);
        return v0;
        try {
        label_8:
            v2_1 = arg2.invoke();
            this.reference = new SoftReference(v2_1);
        }
        catch(Throwable v2) {
            try {
            label_15:
                __monitor_exit(this);
            }
            catch(Throwable v2) {
                goto label_15;
            }

            throw v2;
        }

        __monitor_exit(this);
        return v2_1;
    }
}

