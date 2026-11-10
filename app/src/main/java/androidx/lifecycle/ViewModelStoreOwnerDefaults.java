package androidx.lifecycle;

import androidx.lifecycle.viewmodel.CreationExtras$Empty;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.internal.DefaultViewModelProviderFactory;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0017\u0010\u0000\u001A\u00020\u0001*\u0004\u0018\u00010\u00028G¢\u0006\u0006\u001A\u0004\b\u0003\u0010\u0004\"\u0017\u0010\u0005\u001A\u00020\u0006*\u0004\u0018\u00010\u00028G¢\u0006\u0006\u001A\u0004\b\u0007\u0010\b¨\u0006\t"}, d2={"defaultViewModelProviderFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModelStoreOwner;", "getViewModelProviderFactory", "(Landroidx/lifecycle/ViewModelStoreOwner;)Landroidx/lifecycle/ViewModelProvider$Factory;", "defaultViewModelCreationExtras", "Landroidx/lifecycle/viewmodel/CreationExtras;", "getViewModelCreationExtras", "(Landroidx/lifecycle/ViewModelStoreOwner;)Landroidx/lifecycle/viewmodel/CreationExtras;", "lifecycle-viewmodel"}, k=2, mv={2, 1, 0}, xi=0x30) public final class ViewModelStoreOwnerDefaults {
    public static final CreationExtras getViewModelCreationExtras(ViewModelStoreOwner arg1) {
        if((arg1 instanceof HasDefaultViewModelProviderFactory)) {
            return ((HasDefaultViewModelProviderFactory)arg1).getDefaultViewModelCreationExtras();
        }

        return Empty.INSTANCE;
    }

    public static final Factory getViewModelProviderFactory(ViewModelStoreOwner arg1) {
        if((arg1 instanceof HasDefaultViewModelProviderFactory)) {
            return ((HasDefaultViewModelProviderFactory)arg1).getDefaultViewModelProviderFactory();
        }

        return DefaultViewModelProviderFactory.INSTANCE;
    }
}

