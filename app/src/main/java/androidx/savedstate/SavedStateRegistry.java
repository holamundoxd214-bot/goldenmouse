package androidx.savedstate;

import android.os.Bundle;
import androidx.savedstate.internal.SavedStateRegistryImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u001A\u001BB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\t\u001A\n\u0018\u00010\nj\u0004\u0018\u0001`\u000B2\u0006\u0010\f\u001A\u00020\rH\u0007J\u0018\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\u0011H\u0007J\u0010\u0010\u0012\u001A\u0004\u0018\u00010\u00112\u0006\u0010\f\u001A\u00020\rJ\u0010\u0010\u0013\u001A\u00020\u000F2\u0006\u0010\f\u001A\u00020\rH\u0007J\u0018\u0010\u0016\u001A\u00020\u000F2\u000E\u0010\u0017\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00190\u0018H\u0007R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001A\u00020\u00078G¢\u0006\u0006\u001A\u0004\b\u0006\u0010\bR\u0010\u0010\u0014\u001A\u0004\u0018\u00010\u0015X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u001C"}, d2={"Landroidx/savedstate/SavedStateRegistry;", "", "impl", "Landroidx/savedstate/internal/SavedStateRegistryImpl;", "<init>", "(Landroidx/savedstate/internal/SavedStateRegistryImpl;)V", "isRestored", "", "()Z", "consumeRestoredStateForKey", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "key", "", "registerSavedStateProvider", "", "provider", "Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "getSavedStateProvider", "unregisterSavedStateProvider", "recreatorProvider", "Landroidx/savedstate/Recreator$SavedStateProvider;", "runOnNextRecreation", "clazz", "Ljava/lang/Class;", "Landroidx/savedstate/SavedStateRegistry$AutoRecreated;", "SavedStateProvider", "AutoRecreated", "savedstate"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SavedStateRegistry {
    @Metadata(d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2={"Landroidx/savedstate/SavedStateRegistry$AutoRecreated;", "", "onRecreated", "", "owner", "Landroidx/savedstate/SavedStateRegistryOwner;", "savedstate"}, k=1, mv={2, 0, 0}, xi=0x30) public interface AutoRecreated {
        void onRecreated(SavedStateRegistryOwner arg1);
    }

    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\f\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0005À\u0006\u0001"}, d2={"Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "", "saveState", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "savedstate"}, k=1, mv={2, 0, 0}, xi=0x30) public interface SavedStateProvider {
        Bundle saveState();
    }

    private final SavedStateRegistryImpl impl;
    private androidx.savedstate.Recreator$SavedStateProvider recreatorProvider;

    public SavedStateRegistry(SavedStateRegistryImpl arg2) {
        Intrinsics.checkNotNullParameter(arg2, "impl");
        super();
        this.impl = arg2;
    }

    public final Bundle consumeRestoredStateForKey(String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        return this.impl.consumeRestoredStateForKey(arg2);
    }

    public final SavedStateProvider getSavedStateProvider(String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        return this.impl.getSavedStateProvider(arg2);
    }

    public final boolean isRestored() {
        return this.impl.isRestored();
    }

    public final void registerSavedStateProvider(String arg2, SavedStateProvider arg3) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        Intrinsics.checkNotNullParameter(arg3, "provider");
        this.impl.registerSavedStateProvider(arg2, arg3);
    }

    public final void runOnNextRecreation(Class arg4) {
        Intrinsics.checkNotNullParameter(arg4, "clazz");
        if(this.impl.isAllowingSavingState$savedstate()) {
            androidx.savedstate.Recreator$SavedStateProvider v0 = this.recreatorProvider;
            if(v0 == null) {
                v0 = new androidx.savedstate.Recreator$SavedStateProvider(this);
            }

            this.recreatorProvider = v0;
            try {
                arg4.getDeclaredConstructor();
            }
            catch(NoSuchMethodException v3) {
                throw new IllegalArgumentException("Class " + arg4.getSimpleName() + " must have default constructor in order to be automatically recreated", ((Throwable)v3));
            }

            androidx.savedstate.Recreator$SavedStateProvider v3_1 = this.recreatorProvider;
            if(v3_1 != null) {
                String v4 = arg4.getName();
                Intrinsics.checkNotNullExpressionValue(v4, "getName(...)");
                v3_1.add(v4);
            }

            return;
        }

        throw new IllegalStateException("Can not perform this action after onSaveInstanceState".toString());
    }

    public final void unregisterSavedStateProvider(String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        this.impl.unregisterSavedStateProvider(arg2);
    }
}

