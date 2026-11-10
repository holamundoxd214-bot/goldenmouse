package androidx.lifecycle.viewmodel.internal;

import androidx.activity.OnBackPressedCallback$$ExternalSyntheticThrowIAE2;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000E\n\u0002\u0010#\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006B%\b\u0016\u0012\u001A\u0010\u0007\u001A\u000E\u0012\n\b\u0001\u0012\u00060\tj\u0002`\n0\b\"\u00060\tj\u0002`\n¢\u0006\u0004\b\u0002\u0010\u000BB-\b\u0016\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u001A\u0010\u0007\u001A\u000E\u0012\n\b\u0001\u0012\u00060\tj\u0002`\n0\b\"\u00060\tj\u0002`\n¢\u0006\u0004\b\u0002\u0010\fJ\b\u0010\u0015\u001A\u00020\u0016H\u0007J\u001A\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0018\u001A\u00020\u00112\n\u0010\u0019\u001A\u00060\tj\u0002`\nJ\u0012\u0010\u0017\u001A\u00020\u00162\n\u0010\u0019\u001A\u00060\tj\u0002`\nJ#\u0010\u001A\u001A\u0004\u0018\u0001H\u001B\"\f\b\u0000\u0010\u001B*\u00060\tj\u0002`\n2\u0006\u0010\u0018\u001A\u00020\u0011¢\u0006\u0002\u0010\u001CJ\u0018\u0010\u001D\u001A\u00020\u00162\u000E\u0010\u0019\u001A\n\u0018\u00010\tj\u0004\u0018\u0001`\nH\u0002R\u000E\u0010\r\u001A\u00020\u000EX\u0082\u0004¢\u0006\u0002\n\u0000R\u001E\u0010\u000F\u001A\u0012\u0012\u0004\u0012\u00020\u0011\u0012\b\u0012\u00060\tj\u0002`\n0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001A\f\u0012\b\u0012\u00060\tj\u0002`\n0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0014X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u001E"}, d2={"Landroidx/lifecycle/viewmodel/internal/ViewModelImpl;", "", "<init>", "()V", "viewModelScope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlinx/coroutines/CoroutineScope;)V", "closeables", "", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "([Ljava/lang/AutoCloseable;)V", "(Lkotlinx/coroutines/CoroutineScope;[Ljava/lang/AutoCloseable;)V", "lock", "Landroidx/lifecycle/viewmodel/internal/SynchronizedObject;", "keyToCloseables", "", "", "", "isCleared", "", "clear", "", "addCloseable", "key", "closeable", "getCloseable", "T", "(Ljava/lang/String;)Ljava/lang/AutoCloseable;", "closeWithRuntimeException", "lifecycle-viewmodel"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ViewModelImpl {
    private final Set closeables;
    private volatile boolean isCleared;
    private final Map keyToCloseables;
    private final SynchronizedObject lock;

    public ViewModelImpl() {
        super();
        this.lock = new SynchronizedObject();
        this.keyToCloseables = new LinkedHashMap();
        this.closeables = new LinkedHashSet();
    }

    public ViewModelImpl(CoroutineScope arg2) {
        Intrinsics.checkNotNullParameter(arg2, "viewModelScope");
        super();
        this.lock = new SynchronizedObject();
        this.keyToCloseables = new LinkedHashMap();
        this.closeables = new LinkedHashSet();
        this.addCloseable("androidx.lifecycle.viewmodel.internal.ViewModelCoroutineScope.JOB_KEY", CloseableCoroutineScopeKt.asCloseable(arg2));
    }

    public ViewModelImpl(CoroutineScope arg3, AutoCloseable[] arg4) {
        Intrinsics.checkNotNullParameter(arg3, "viewModelScope");
        Intrinsics.checkNotNullParameter(arg4, "closeables");
        super();
        this.lock = new SynchronizedObject();
        this.keyToCloseables = new LinkedHashMap();
        LinkedHashSet v0 = new LinkedHashSet();
        this.closeables = ((Set)v0);
        this.addCloseable("androidx.lifecycle.viewmodel.internal.ViewModelCoroutineScope.JOB_KEY", CloseableCoroutineScopeKt.asCloseable(arg3));
        CollectionsKt.addAll(((Collection)v0), ((Object[])arg4));
    }

    public ViewModelImpl(AutoCloseable[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "closeables");
        super();
        this.lock = new SynchronizedObject();
        this.keyToCloseables = new LinkedHashMap();
        LinkedHashSet v0 = new LinkedHashSet();
        this.closeables = ((Set)v0);
        CollectionsKt.addAll(((Collection)v0), ((Object[])arg2));
    }

    public static final void access$closeWithRuntimeException(ViewModelImpl arg0, AutoCloseable arg1) {
        arg0.closeWithRuntimeException(arg1);
    }

    public static final Set access$getCloseables$p(ViewModelImpl arg0) {
        return arg0.closeables;
    }

    public static final Map access$getKeyToCloseables$p(ViewModelImpl arg0) {
        return arg0.keyToCloseables;
    }

    public final void addCloseable(AutoCloseable arg2) {
        Intrinsics.checkNotNullParameter(arg2, "closeable");
        if(this.isCleared) {
            this.closeWithRuntimeException(arg2);
            return;
        }

        SynchronizedObject v0 = this.lock;
        __monitor_enter(v0);
        try {
            this.closeables.add(arg2);
        }
        catch(Throwable v1) {
            __monitor_exit(v0);
            throw v1;
        }

        __monitor_exit(v0);
    }

    public final void addCloseable(String arg3, AutoCloseable arg4) {
        Object v3;
        Intrinsics.checkNotNullParameter(arg3, "key");
        Intrinsics.checkNotNullParameter(arg4, "closeable");
        if(this.isCleared) {
            this.closeWithRuntimeException(arg4);
            return;
        }

        SynchronizedObject v0 = this.lock;
        __monitor_enter(v0);
        try {
            v3 = this.keyToCloseables.put(arg3, arg4);
            __monitor_exit(v0);
        }
        catch(Throwable v2) {
            __monitor_exit(v0);
            throw v2;
        }

        this.closeWithRuntimeException(((AutoCloseable)v3));
    }

    public final void clear() {
        if(this.isCleared) {
            return;
        }

        this.isCleared = true;
        SynchronizedObject v0 = this.lock;
        __monitor_enter(v0);
        try {
            Iterator v1 = this.keyToCloseables.values().iterator();
            while(v1.hasNext()) {
                this.closeWithRuntimeException(v1.next());
            }

            v1 = this.closeables.iterator();
            while(v1.hasNext()) {
                this.closeWithRuntimeException(v1.next());
            }

            this.closeables.clear();
        }
        catch(Throwable v3) {
            goto label_28;
        }

        __monitor_exit(v0);
        return;
    label_28:
        __monitor_exit(v0);
        throw v3;
    }

    private final void closeWithRuntimeException(AutoCloseable arg1) {
        if(arg1 != null) {
            try {
                OnBackPressedCallback$$ExternalSyntheticThrowIAE2.m(arg1);
                return;
            }
            catch(Exception v0) {
                throw new RuntimeException(((Throwable)v0));
            }
        }
    }

    public final AutoCloseable getCloseable(String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        SynchronizedObject v0 = this.lock;
        __monitor_enter(v0);
        try {
            __monitor_exit(v0);
            return this.keyToCloseables.get(arg2);
        }
        catch(Throwable v1) {
            __monitor_exit(v0);
            throw v1;
        }
    }
}

