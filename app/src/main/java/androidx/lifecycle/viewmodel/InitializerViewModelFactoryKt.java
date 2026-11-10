package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider$Factory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1={"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001A%\u0010\u0000\u001A\u00020\u00012\u0017\u0010\u0002\u001A\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u001A7\u0010\u0007\u001A\u00020\u0005\"\n\b\u0000\u0010\b\u0018\u0001*\u00020\t*\u00020\u00042\u0019\b\b\u0010\u0007\u001A\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H\b0\u0003¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000B"}, d2={"viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "builder", "Lkotlin/Function1;", "Landroidx/lifecycle/viewmodel/InitializerViewModelFactoryBuilder;", "", "Lkotlin/ExtensionFunctionType;", "initializer", "VM", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/viewmodel/CreationExtras;", "lifecycle-viewmodel"}, k=2, mv={2, 1, 0}, xi=0x30) public final class InitializerViewModelFactoryKt {
    public static final void initializer(InitializerViewModelFactoryBuilder arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "initializer");
        Intrinsics.reifiedOperationMarker(4, "VM");
        arg2.addInitializer(Reflection.getOrCreateKotlinClass(ViewModel.class), arg3);
    }

    public static final Factory viewModelFactory(Function1 arg1) {
        Intrinsics.checkNotNullParameter(arg1, "builder");
        InitializerViewModelFactoryBuilder v0 = new InitializerViewModelFactoryBuilder();
        arg1.invoke(v0);
        return v0.build();
    }
}

