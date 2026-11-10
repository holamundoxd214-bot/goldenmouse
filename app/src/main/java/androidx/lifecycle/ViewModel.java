package androidx.lifecycle;

import androidx.lifecycle.viewmodel.internal.ViewModelImpl;
import java.io.Closeable;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006B%\b\u0016\u0012\u001A\u0010\u0007\u001A\u000E\u0012\n\b\u0001\u0012\u00060\tj\u0002`\n0\b\"\u00060\tj\u0002`\n¢\u0006\u0004\b\u0002\u0010\u000BB-\b\u0016\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u001A\u0010\u0007\u001A\u000E\u0012\n\b\u0001\u0012\u00060\tj\u0002`\n0\b\"\u00060\tj\u0002`\n¢\u0006\u0004\b\u0002\u0010\fB\u001D\b\u0017\u0012\u0012\u0010\u0007\u001A\n\u0012\u0006\b\u0001\u0012\u00020\r0\b\"\u00020\r¢\u0006\u0004\b\u0002\u0010\u000EJ\b\u0010\u0011\u001A\u00020\u0012H\u0015J\r\u0010\u0013\u001A\u00020\u0012H\u0001¢\u0006\u0002\b\u0014J\u001A\u0010\u0015\u001A\u00020\u00122\u0006\u0010\u0016\u001A\u00020\u00172\n\u0010\u0018\u001A\u00060\tj\u0002`\nJ\u0014\u0010\u0015\u001A\u00020\u00122\n\u0010\u0018\u001A\u00060\tj\u0002`\nH\u0016J\u0010\u0010\u0015\u001A\u00020\u00122\u0006\u0010\u0018\u001A\u00020\rH\u0017J#\u0010\u0019\u001A\u0004\u0018\u0001H\u001A\"\f\b\u0000\u0010\u001A*\u00060\tj\u0002`\n2\u0006\u0010\u0016\u001A\u00020\u0017¢\u0006\u0002\u0010\u001BR\u0010\u0010\u000F\u001A\u0004\u0018\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001C"}, d2={"Landroidx/lifecycle/ViewModel;", "", "<init>", "()V", "viewModelScope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlinx/coroutines/CoroutineScope;)V", "closeables", "", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "([Ljava/lang/AutoCloseable;)V", "(Lkotlinx/coroutines/CoroutineScope;[Ljava/lang/AutoCloseable;)V", "Ljava/io/Closeable;", "([Ljava/io/Closeable;)V", "impl", "Landroidx/lifecycle/viewmodel/internal/ViewModelImpl;", "onCleared", "", "clear", "clear$lifecycle_viewmodel", "addCloseable", "key", "", "closeable", "getCloseable", "T", "(Ljava/lang/String;)Ljava/lang/AutoCloseable;", "lifecycle-viewmodel"}, k=1, mv={2, 1, 0}, xi=0x30) public abstract class ViewModel {
    private final ViewModelImpl impl;

    public ViewModel() {
        super();
        this.impl = new ViewModelImpl();
    }

    public ViewModel(CoroutineScope arg2) {
        Intrinsics.checkNotNullParameter(arg2, "viewModelScope");
        super();
        this.impl = new ViewModelImpl(arg2);
    }

    public ViewModel(CoroutineScope arg3, AutoCloseable[] arg4) {
        Intrinsics.checkNotNullParameter(arg3, "viewModelScope");
        Intrinsics.checkNotNullParameter(arg4, "closeables");
        super();
        this.impl = new ViewModelImpl(arg3, Arrays.copyOf(((Object[])arg4), arg4.length));
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Replaced by `AutoCloseable` overload.") public ViewModel(Closeable[] arg3) {
        Intrinsics.checkNotNullParameter(arg3, "closeables");
        super();
        this.impl = new ViewModelImpl(Arrays.copyOf(((Object[])arg3), arg3.length));
    }

    public ViewModel(AutoCloseable[] arg3) {
        Intrinsics.checkNotNullParameter(arg3, "closeables");
        super();
        this.impl = new ViewModelImpl(Arrays.copyOf(((Object[])arg3), arg3.length));
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Replaced by `AutoCloseable` overload.") public void addCloseable(Closeable arg2) {
        Intrinsics.checkNotNullParameter(arg2, "closeable");
        ViewModelImpl v1 = this.impl;
        if(v1 != null) {
            v1.addCloseable(((AutoCloseable)arg2));
        }
    }

    public void addCloseable(AutoCloseable arg2) {
        Intrinsics.checkNotNullParameter(arg2, "closeable");
        ViewModelImpl v1 = this.impl;
        if(v1 != null) {
            v1.addCloseable(arg2);
        }
    }

    public final void addCloseable(String arg2, AutoCloseable arg3) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        Intrinsics.checkNotNullParameter(arg3, "closeable");
        ViewModelImpl v1 = this.impl;
        if(v1 != null) {
            v1.addCloseable(arg2, arg3);
        }
    }

    public final void clear$lifecycle_viewmodel() {
        ViewModelImpl v0 = this.impl;
        if(v0 != null) {
            v0.clear();
        }

        this.onCleared();
    }

    public final AutoCloseable getCloseable(String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        ViewModelImpl v1 = this.impl;
        if(v1 != null) {
            return v1.getCloseable(arg2);
        }

        return null;
    }

    protected void onCleared() {
    }
}

