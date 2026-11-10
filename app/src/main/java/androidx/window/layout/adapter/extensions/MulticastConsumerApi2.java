package androidx.window.layout.adapter.extensions;

import android.content.Context;
import androidx.core.util.Consumer;
import androidx.window.layout.WindowLayoutInfo;
import androidx.window.reflection.Consumer2;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0000\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u0002H\u0016J\u0014\u0010\u0011\u001A\u00020\u000F2\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u000B0\u0001J\u0014\u0010\u0013\u001A\u00020\u000F2\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u000B0\u0001J\u0006\u0010\u0014\u001A\u00020\u0015R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001A\u0004\u0018\u00010\u000B8\u0002@\u0002X\u0083\u000E¢\u0006\u0002\n\u0000R\u001C\u0010\f\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000B0\u00010\r8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2={"Landroidx/window/layout/adapter/extensions/MulticastConsumerApi2;", "Landroidx/core/util/Consumer;", "Landroidx/window/extensions/layout/WindowLayoutInfo;", "Landroidx/window/reflection/Consumer2;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "globalLock", "Ljava/util/concurrent/locks/ReentrantLock;", "lastKnownValue", "Landroidx/window/layout/WindowLayoutInfo;", "registeredListeners", "", "accept", "", "value", "addListener", "listener", "removeListener", "isEmpty", "", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class MulticastConsumerApi2 implements Consumer, Consumer2 {
    private final Context context;
    private final ReentrantLock globalLock;
    private WindowLayoutInfo lastKnownValue;
    private final Set registeredListeners;

    public MulticastConsumerApi2(Context arg2) {
        Intrinsics.checkNotNullParameter(arg2, "context");
        super();
        this.context = arg2;
        this.globalLock = new ReentrantLock();
        this.registeredListeners = new LinkedHashSet();
    }

    public void accept(androidx.window.extensions.layout.WindowLayoutInfo arg4) {
        Intrinsics.checkNotNullParameter(arg4, "value");
        ReentrantLock v0 = this.globalLock;
        ((Lock)v0).lock();
        try {
            WindowLayoutInfo v4 = ExtensionsWindowLayoutInfoAdapter.INSTANCE.translate$window_release(this.context, arg4);
            this.lastKnownValue = v4;
            Iterator v3_1 = this.registeredListeners.iterator();
            while(v3_1.hasNext()) {
                v3_1.next().accept(v4);
            }
        }
        catch(Throwable v3) {
            goto label_19;
        }

        ((Lock)v0).unlock();
        return;
    label_19:
        ((Lock)v0).unlock();
        throw v3;
    }

    public void accept(Object arg1) {
        this.accept(((androidx.window.extensions.layout.WindowLayoutInfo)arg1));
    }

    public final void addListener(Consumer arg3) {
        Intrinsics.checkNotNullParameter(arg3, "listener");
        ReentrantLock v0 = this.globalLock;
        ((Lock)v0).lock();
        try {
            WindowLayoutInfo v1 = this.lastKnownValue;
            if(v1 != null) {
                arg3.accept(v1);
            }

            this.registeredListeners.add(arg3);
        }
        catch(Throwable v2) {
            ((Lock)v0).unlock();
            throw v2;
        }

        ((Lock)v0).unlock();
    }

    public final boolean isEmpty() {
        return this.registeredListeners.isEmpty();
    }

    public final void removeListener(Consumer arg2) {
        Intrinsics.checkNotNullParameter(arg2, "listener");
        ReentrantLock v0 = this.globalLock;
        ((Lock)v0).lock();
        try {
            this.registeredListeners.remove(arg2);
        }
        catch(Throwable v1) {
            ((Lock)v0).unlock();
            throw v1;
        }

        ((Lock)v0).unlock();
    }
}

