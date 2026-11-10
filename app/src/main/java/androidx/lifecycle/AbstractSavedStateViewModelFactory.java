package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Deprecated(message="Use `viewModelFactory` or implement `ViewModelProvider.Factory`, combined with `CreationExtras.createSavedStateHandle()`.") @Metadata(d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\'\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0016¢\u0006\u0004\b\u0003\u0010\u0004B\u001B\b\u0016\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\b¢\u0006\u0004\b\u0003\u0010\tJ-\u0010\u000E\u001A\u0002H\u000F\"\b\b\u0000\u0010\u000F*\u00020\u00102\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u00122\u0006\u0010\u0013\u001A\u00020\u0014H\u0016¢\u0006\u0002\u0010\u0015J-\u0010\u000E\u001A\u0002H\u000F\"\b\b\u0000\u0010\u000F*\u00020\u00102\u0006\u0010\u0016\u001A\u00020\u00172\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u0012H\u0002¢\u0006\u0002\u0010\u0018J%\u0010\u000E\u001A\u0002H\u000F\"\b\b\u0000\u0010\u000F*\u00020\u00102\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u0012H\u0016¢\u0006\u0002\u0010\u0019J5\u0010\u000E\u001A\u0002H\u000F\"\b\b\u0000\u0010\u000F*\u00020\u00102\u0006\u0010\u0016\u001A\u00020\u00172\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u00122\u0006\u0010\u001A\u001A\u00020\u001BH$¢\u0006\u0002\u0010\u001CJ\u0010\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u001F\u001A\u00020\u0010H\u0017R\u0010\u0010\n\u001A\u0004\u0018\u00010\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001A\u0004\u0018\u00010\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001A\u0004\u0018\u00010\bX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006 "}, d2={"Landroidx/lifecycle/AbstractSavedStateViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$OnRequeryFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "<init>", "()V", "owner", "Landroidx/savedstate/SavedStateRegistryOwner;", "defaultArgs", "Landroid/os/Bundle;", "(Landroidx/savedstate/SavedStateRegistryOwner;Landroid/os/Bundle;)V", "savedStateRegistry", "Landroidx/savedstate/SavedStateRegistry;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "extras", "Landroidx/lifecycle/viewmodel/CreationExtras;", "(Ljava/lang/Class;Landroidx/lifecycle/viewmodel/CreationExtras;)Landroidx/lifecycle/ViewModel;", "key", "", "(Ljava/lang/String;Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "handle", "Landroidx/lifecycle/SavedStateHandle;", "(Ljava/lang/String;Ljava/lang/Class;Landroidx/lifecycle/SavedStateHandle;)Landroidx/lifecycle/ViewModel;", "onRequery", "", "viewModel", "lifecycle-viewmodel-savedstate"}, k=1, mv={2, 1, 0}, xi=0x30) public abstract class AbstractSavedStateViewModelFactory extends OnRequeryFactory implements Factory {
    private Bundle defaultArgs;
    private Lifecycle lifecycle;
    private SavedStateRegistry savedStateRegistry;

    public AbstractSavedStateViewModelFactory() {
        super();
    }

    public AbstractSavedStateViewModelFactory(SavedStateRegistryOwner arg2, Bundle arg3) {
        Intrinsics.checkNotNullParameter(arg2, "owner");
        super();
        this.savedStateRegistry = arg2.getSavedStateRegistry();
        this.lifecycle = arg2.getLifecycle();
        this.defaultArgs = arg3;
    }

    private final ViewModel create(String arg4, Class arg5) {
        SavedStateRegistry v0 = this.savedStateRegistry;
        Intrinsics.checkNotNull(v0);
        Lifecycle v1 = this.lifecycle;
        Intrinsics.checkNotNull(v1);
        SavedStateHandleController v0_1 = LegacySavedStateHandleController.create(v0, v1, arg4, this.defaultArgs);
        ViewModel v3 = this.create(arg4, arg5, v0_1.getHandle());
        v3.addCloseable("androidx.lifecycle.savedstate.vm.tag", ((AutoCloseable)v0_1));
        return v3;
    }

    protected abstract ViewModel create(String arg1, Class arg2, SavedStateHandle arg3);

    public ViewModel create(Class arg3) {
        Intrinsics.checkNotNullParameter(arg3, "modelClass");
        String v0 = arg3.getCanonicalName();
        if(v0 != null) {
            if(this.lifecycle != null) {
                return this.create(v0, arg3);
            }

            throw new UnsupportedOperationException("AbstractSavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
        }

        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public ViewModel create(Class arg3, CreationExtras arg4) {
        Intrinsics.checkNotNullParameter(arg3, "modelClass");
        Intrinsics.checkNotNullParameter(arg4, "extras");
        Object v0 = arg4.get(NewInstanceFactory.VIEW_MODEL_KEY);
        if(v0 != null) {
            if(this.savedStateRegistry != null) {
                return this.create(((String)v0), arg3);
            }

            return this.create(((String)v0), arg3, SavedStateHandleSupport.createSavedStateHandle(arg4));
        }

        throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
    }

    public void onRequery(ViewModel arg2) {
        Intrinsics.checkNotNullParameter(arg2, "viewModel");
        SavedStateRegistry v0 = this.savedStateRegistry;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            Lifecycle v1 = this.lifecycle;
            Intrinsics.checkNotNull(v1);
            LegacySavedStateHandleController.attachHandleIfNeeded(arg2, v0, v1);
        }
    }
}

