package androidx.window.layout.adapter.extensions;

import android.app.Activity;
import android.content.Context;
import androidx.core.util.Consumer;
import androidx.window.core.ConsumerAdapter$Subscription;
import androidx.window.core.ConsumerAdapter;
import androidx.window.extensions.layout.WindowLayoutComponent;
import androidx.window.extensions.layout.WindowLayoutInfo;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\b\u0011\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u000E2\u0006\u0010\u0018\u001A\u00020\u00192\f\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\u0016\u0010\u001B\u001A\u00020\u00162\f\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\b\u0010\u001C\u001A\u00020\u001DH\u0017R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u001C\u0010\f\u001A\u000E\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u000F0\r8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0010\u001A\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u000E0\r8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u001C\u0010\u0013\u001A\u000E\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020\u00140\r8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006\u001E"}, d2={"Landroidx/window/layout/adapter/extensions/ExtensionWindowBackendApi1;", "Landroidx/window/layout/adapter/extensions/ExtensionWindowBackendApi0;", "component", "Landroidx/window/extensions/layout/WindowLayoutComponent;", "consumerAdapter", "Landroidx/window/core/ConsumerAdapter;", "<init>", "(Landroidx/window/extensions/layout/WindowLayoutComponent;Landroidx/window/core/ConsumerAdapter;)V", "getComponent", "()Landroidx/window/extensions/layout/WindowLayoutComponent;", "globalLock", "Ljava/util/concurrent/locks/ReentrantLock;", "contextToListeners", "", "Landroid/content/Context;", "Landroidx/window/layout/adapter/extensions/MulticastConsumer;", "listenerToContext", "Landroidx/core/util/Consumer;", "Landroidx/window/layout/WindowLayoutInfo;", "consumerToToken", "Landroidx/window/core/ConsumerAdapter$Subscription;", "registerLayoutChangeCallback", "", "context", "executor", "Ljava/util/concurrent/Executor;", "callback", "unregisterLayoutChangeCallback", "hasRegisteredListeners", "", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public class ExtensionWindowBackendApi1 extends ExtensionWindowBackendApi0 {
    private final WindowLayoutComponent component;
    private final ConsumerAdapter consumerAdapter;
    private final Map consumerToToken;
    private final Map contextToListeners;
    private final ReentrantLock globalLock;
    private final Map listenerToContext;

    public ExtensionWindowBackendApi1(WindowLayoutComponent arg2, ConsumerAdapter arg3) {
        Intrinsics.checkNotNullParameter(arg2, "component");
        Intrinsics.checkNotNullParameter(arg3, "consumerAdapter");
        super();
        this.component = arg2;
        this.consumerAdapter = arg3;
        this.globalLock = new ReentrantLock();
        this.contextToListeners = new LinkedHashMap();
        this.listenerToContext = new LinkedHashMap();
        this.consumerToToken = new LinkedHashMap();
    }

    public final WindowLayoutComponent getComponent() {
        return this.component;
    }

    public boolean hasRegisteredListeners() {
        if((this.contextToListeners.isEmpty()) && (this.listenerToContext.isEmpty())) {
            if(!this.consumerToToken.isEmpty()) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public void registerLayoutChangeCallback(Context arg9, Executor arg10, Consumer arg11) {
        MulticastConsumer v0_2;
        Intrinsics.checkNotNullParameter(arg9, "context");
        Intrinsics.checkNotNullParameter(arg10, "executor");
        Intrinsics.checkNotNullParameter(arg11, "callback");
        ReentrantLock v10 = this.globalLock;
        ((Lock)v10).lock();
        try {
            Object v0_1 = this.contextToListeners.get(arg9);
            if(v0_1 != null) {
                ((MulticastConsumer)v0_1).addListener(arg11);
                this.listenerToContext.put(arg11, arg9);
            }
            else {
                v0_2 = new MulticastConsumer(arg9);
                this.contextToListeners.put(arg9, v0_2);
                this.listenerToContext.put(arg11, arg9);
                v0_2.addListener(arg11);
                if((arg9 instanceof Activity)) {
                    this.consumerToToken.put(v0_2, this.consumerAdapter.createSubscription(this.component, Reflection.getOrCreateKotlinClass(WindowLayoutInfo.class), "addWindowLayoutInfoListener", "removeWindowLayoutInfoListener", arg9, new ExtensionWindowBackendApi1$registerLayoutChangeCallback$1$2$disposableToken$1(v0_2)));
                }
                else {
                    goto label_41;
                }
            }
        }
        catch(Throwable v0) {
            goto label_49;
        }

        ((Lock)v10).unlock();
        return;
        try {
        label_41:
            v0_2.accept(new WindowLayoutInfo(CollectionsKt.emptyList()));
        }
        catch(Throwable v0) {
        label_49:
            ((Lock)v10).unlock();
            throw v0;
        }

        ((Lock)v10).unlock();
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
            goto label_29;
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
            goto label_29;
        }

        ((Lock)v0).unlock();
        return;
        try {
        label_14:
            ((MulticastConsumer)v2).removeListener(arg5);
            this.listenerToContext.remove(arg5);
            if(((MulticastConsumer)v2).isEmpty()) {
                this.contextToListeners.remove(v1);
                Object v4_1 = this.consumerToToken.remove(v2);
                if(v4_1 != null) {
                    ((Subscription)v4_1).dispose();
                }
            }
        }
        catch(Throwable v4) {
        label_29:
            ((Lock)v0).unlock();
            throw v4;
        }

        ((Lock)v0).unlock();
    }
}

