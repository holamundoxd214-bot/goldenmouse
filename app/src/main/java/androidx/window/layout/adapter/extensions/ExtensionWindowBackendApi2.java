package androidx.window.layout.adapter.extensions;

import android.content.Context;
import androidx.core.util.Consumer;
import androidx.window.core.ConsumerAdapter;
import androidx.window.extensions.layout.WindowLayoutComponent;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\b\u0011\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\f2\u0006\u0010\u0014\u001A\u00020\u00152\f\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00100\u000FH\u0016J\u0016\u0010\u0017\u001A\u00020\u00122\f\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00100\u000FH\u0016J\b\u0010\u0018\u001A\u00020\u0019H\u0017R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001C\u0010\n\u001A\u000E\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000B8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000E\u001A\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000F\u0012\u0004\u0012\u00020\f0\u000B8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006\u001A"}, d2={"Landroidx/window/layout/adapter/extensions/ExtensionWindowBackendApi2;", "Landroidx/window/layout/adapter/extensions/ExtensionWindowBackendApi1;", "component", "Landroidx/window/extensions/layout/WindowLayoutComponent;", "adapter", "Landroidx/window/core/ConsumerAdapter;", "<init>", "(Landroidx/window/extensions/layout/WindowLayoutComponent;Landroidx/window/core/ConsumerAdapter;)V", "globalLock", "Ljava/util/concurrent/locks/ReentrantLock;", "contextToListeners", "", "Landroid/content/Context;", "Landroidx/window/layout/adapter/extensions/MulticastConsumerApi2;", "listenerToContext", "Landroidx/core/util/Consumer;", "Landroidx/window/layout/WindowLayoutInfo;", "registerLayoutChangeCallback", "", "context", "executor", "Ljava/util/concurrent/Executor;", "callback", "unregisterLayoutChangeCallback", "hasRegisteredListeners", "", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public class ExtensionWindowBackendApi2 extends ExtensionWindowBackendApi1 {
    private final Map contextToListeners;
    private final ReentrantLock globalLock;
    private final Map listenerToContext;

    public ExtensionWindowBackendApi2(WindowLayoutComponent arg2, ConsumerAdapter arg3) {
        Intrinsics.checkNotNullParameter(arg2, "component");
        Intrinsics.checkNotNullParameter(arg3, "adapter");
        super(arg2, arg3);
        this.globalLock = new ReentrantLock();
        this.contextToListeners = new LinkedHashMap();
        this.listenerToContext = new LinkedHashMap();
    }

    public boolean hasRegisteredListeners() {
        if(this.contextToListeners.isEmpty()) {
            if(!this.listenerToContext.isEmpty()) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public void registerLayoutChangeCallback(Context arg3, Executor arg4, Consumer arg5) {
        Intrinsics.checkNotNullParameter(arg3, "context");
        Intrinsics.checkNotNullParameter(arg4, "executor");
        Intrinsics.checkNotNullParameter(arg5, "callback");
        ReentrantLock v4 = this.globalLock;
        ((Lock)v4).lock();
        try {
            Object v0 = this.contextToListeners.get(arg3);
            if(v0 != null) {
                ((MulticastConsumerApi2)v0).addListener(arg5);
                this.listenerToContext.put(arg5, arg3);
            }
            else {
                MulticastConsumerApi2 v0_1 = new MulticastConsumerApi2(arg3);
                this.contextToListeners.put(arg3, v0_1);
                this.listenerToContext.put(arg5, arg3);
                v0_1.addListener(arg5);
                this.getComponent().addWindowLayoutInfoListener(arg3, ((androidx.window.extensions.core.util.function.Consumer)v0_1));
            }
        }
        catch(Throwable v2) {
            ((Lock)v4).unlock();
            throw v2;
        }

        ((Lock)v4).unlock();
    }

    public void unregisterLayoutChangeCallback(Consumer arg5) {
        Object v2;
        Object v1;
        Intrinsics.checkNotNullParameter(arg5, "callback");
        ReentrantLock v0 = this.globalLock;
        ((Lock)v0).lock();
        try {
            v1 = this.listenerToContext.get(arg5);
            if(v1 != null) {
                goto label_9;
            }
        }
        catch(Throwable v4) {
            goto label_27;
        }

        ((Lock)v0).unlock();
        return;
        try {
        label_9:
            v2 = this.contextToListeners.get(v1);
            if(v2 != null) {
                goto label_14;
            }
        }
        catch(Throwable v4) {
            goto label_27;
        }

        ((Lock)v0).unlock();
        return;
        try {
        label_14:
            ((MulticastConsumerApi2)v2).removeListener(arg5);
            this.listenerToContext.remove(arg5);
            if(((MulticastConsumerApi2)v2).isEmpty()) {
                this.contextToListeners.remove(v1);
                this.getComponent().removeWindowLayoutInfoListener(((androidx.window.extensions.core.util.function.Consumer)v2));
            }
        }
        catch(Throwable v4) {
        label_27:
            ((Lock)v0).unlock();
            throw v4;
        }

        ((Lock)v0).unlock();
    }
}

