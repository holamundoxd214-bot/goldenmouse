package androidx.lifecycle.viewmodel.internal;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider$Factory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0004\u001A\u0002H\u0005\"\b\b\u0000\u0010\u0005*\u00020\u00062\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u0002H\u00050\bH\u0016¢\u0006\u0002\u0010\t¨\u0006\n"}, d2={"Landroidx/lifecycle/viewmodel/internal/DefaultViewModelProviderFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "<init>", "()V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "lifecycle-viewmodel"}, k=1, mv={2, 1, 0}, xi=0x30) public final class DefaultViewModelProviderFactory implements Factory {
    public static final DefaultViewModelProviderFactory INSTANCE;

    static {
        DefaultViewModelProviderFactory.INSTANCE = new DefaultViewModelProviderFactory();
    }

    private DefaultViewModelProviderFactory() {
        super();
    }

    public ViewModel create(Class arg1) {
        Intrinsics.checkNotNullParameter(arg1, "modelClass");
        return JvmViewModelProviders.INSTANCE.createViewModel(arg1);
    }
}

