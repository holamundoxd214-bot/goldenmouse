package androidx.lifecycle;

import androidx.savedstate.SavedStateRegistry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003B\u0017\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u0015J\u0018\u0010\u0016\u001A\u00020\u00112\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u001AH\u0016J\b\u0010\u001B\u001A\u00020\u0011H\u0016R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u001E\u0010\u000E\u001A\u00020\r2\u0006\u0010\f\u001A\u00020\r@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u001C"}, d2={"Landroidx/lifecycle/SavedStateHandleController;", "Landroidx/lifecycle/LifecycleEventObserver;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "key", "", "handle", "Landroidx/lifecycle/SavedStateHandle;", "<init>", "(Ljava/lang/String;Landroidx/lifecycle/SavedStateHandle;)V", "getHandle", "()Landroidx/lifecycle/SavedStateHandle;", "value", "", "isAttached", "()Z", "attachToLifecycle", "", "registry", "Landroidx/savedstate/SavedStateRegistry;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "onStateChanged", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "close", "lifecycle-viewmodel-savedstate"}, k=1, mv={2, 1, 0}, xi=0x30) public final class SavedStateHandleController implements LifecycleEventObserver, AutoCloseable {
    private final SavedStateHandle handle;
    private boolean isAttached;
    private final String key;

    public SavedStateHandleController(String arg2, SavedStateHandle arg3) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        Intrinsics.checkNotNullParameter(arg3, "handle");
        super();
        this.key = arg2;
        this.handle = arg3;
    }

    public final void attachToLifecycle(SavedStateRegistry arg2, Lifecycle arg3) {
        Intrinsics.checkNotNullParameter(arg2, "registry");
        Intrinsics.checkNotNullParameter(arg3, "lifecycle");
        if(!this.isAttached) {
            this.isAttached = true;
            arg3.addObserver(this);
            arg2.registerSavedStateProvider(this.key, this.handle.savedStateProvider());
            return;
        }

        throw new IllegalStateException("Already attached to lifecycleOwner".toString());
    }

    public void close() {
    }

    public final SavedStateHandle getHandle() {
        return this.handle;
    }

    public final boolean isAttached() {
        return this.isAttached;
    }

    public void onStateChanged(LifecycleOwner arg2, Event arg3) {
        Intrinsics.checkNotNullParameter(arg2, "source");
        Intrinsics.checkNotNullParameter(arg3, "event");
        if(arg3 == Event.ON_DESTROY) {
            this.isAttached = false;
            arg2.getLifecycle().removeObserver(((LifecycleObserver)this));
        }
    }
}

