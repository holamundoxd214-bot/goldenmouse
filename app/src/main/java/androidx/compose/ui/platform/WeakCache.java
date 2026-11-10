package androidx.compose.ui.platform;

import androidx.compose.runtime.collection.MutableVector;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import kotlin.Metadata;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00028\u0000¢\u0006\u0002\u0010\rJ\r\u0010\u000E\u001A\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u000FJ\b\u0010\u0014\u001A\u00020\u000BH\u0002R\u001A\u0010\u0005\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00000\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001A\u00020\u00118F¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2={"Landroidx/compose/ui/platform/WeakCache;", "T", "", "<init>", "()V", "values", "Landroidx/compose/runtime/collection/MutableVector;", "Ljava/lang/ref/Reference;", "referenceQueue", "Ljava/lang/ref/ReferenceQueue;", "push", "", "element", "(Ljava/lang/Object;)V", "pop", "()Ljava/lang/Object;", "size", "", "getSize", "()I", "clearWeakReferences", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class WeakCache {
    public static final int $stable = 8;
    private final ReferenceQueue referenceQueue;
    private final MutableVector values;

    static {
    }

    public WeakCache() {
        super();
        this.values = new MutableVector(new Reference[16], 0);
        this.referenceQueue = new ReferenceQueue();
    }

    private final void clearWeakReferences() {
        do {
            Reference v0 = this.referenceQueue.poll();
            if(v0 != null) {
                this.values.remove(v0);
            }
        }
        while(v0 != null);
    }

    public final int getSize() {
        this.clearWeakReferences();
        return this.values.getSize();
    }

    public final Object pop() {
        Object v0;
        this.clearWeakReferences();
        do {
            if(this.values.getSize() == 0) {
                return null;
            }

            v0 = this.values.removeAt(this.values.getSize() - 1).get();
        }
        while(v0 == null);

        return v0;
    }

    public final void push(Object arg3) {
        this.clearWeakReferences();
        this.values.add(new WeakReference(arg3, this.referenceQueue));
    }
}

