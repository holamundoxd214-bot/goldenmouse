package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider$Factory;
import androidx.lifecycle.viewmodel.internal.ViewModelProviders;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u001A\u0010\u0002\u001A\u000E\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003\"\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\b\u001A\u0002H\t\"\b\b\u0000\u0010\t*\u00020\n2\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u0002H\t0\f2\u0006\u0010\r\u001A\u00020\u000EH\u0016¢\u0006\u0002\u0010\u000FR\u001C\u0010\u0002\u001A\u000E\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u0010"}, d2={"Landroidx/lifecycle/viewmodel/InitializerViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "initializers", "", "Landroidx/lifecycle/viewmodel/ViewModelInitializer;", "<init>", "([Landroidx/lifecycle/viewmodel/ViewModelInitializer;)V", "[Landroidx/lifecycle/viewmodel/ViewModelInitializer;", "create", "VM", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "extras", "Landroidx/lifecycle/viewmodel/CreationExtras;", "(Ljava/lang/Class;Landroidx/lifecycle/viewmodel/CreationExtras;)Landroidx/lifecycle/ViewModel;", "lifecycle-viewmodel"}, k=1, mv={2, 1, 0}, xi=0x30) public final class InitializerViewModelFactory implements Factory {
    private final ViewModelInitializer[] initializers;

    public InitializerViewModelFactory(ViewModelInitializer[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "initializers");
        super();
        this.initializers = arg2;
    }

    public ViewModel create(Class arg3, CreationExtras arg4) {
        Intrinsics.checkNotNullParameter(arg3, "modelClass");
        Intrinsics.checkNotNullParameter(arg4, "extras");
        return ViewModelProviders.INSTANCE.createViewModelFromInitializers$lifecycle_viewmodel(JvmClassMappingKt.getKotlinClass(arg3), arg4, Arrays.copyOf(this.initializers, this.initializers.length));
    }
}

