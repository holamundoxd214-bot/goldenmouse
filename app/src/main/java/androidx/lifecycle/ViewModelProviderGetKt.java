package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1={"\u0000\u0018\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\u001A\u001E\u0010\u0000\u001A\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0003H\u0087\b¢\u0006\u0002\u0010\u0004\u001A&\u0010\u0000\u001A\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\u0006\u0010\u0005\u001A\u00020\u0006H\u0087\b¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2={"get", "VM", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/ViewModelProvider;", "(Landroidx/lifecycle/ViewModelProvider;)Landroidx/lifecycle/ViewModel;", "key", "", "(Landroidx/lifecycle/ViewModelProvider;Ljava/lang/String;)Landroidx/lifecycle/ViewModel;", "lifecycle-viewmodel"}, k=2, mv={2, 1, 0}, xi=0x30) public final class ViewModelProviderGetKt {
    public static final ViewModel get(ViewModelProvider arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.reifiedOperationMarker(4, "VM");
        return arg2.get(Reflection.getOrCreateKotlinClass(ViewModel.class));
    }

    public static final ViewModel get(ViewModelProvider arg2, String arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "key");
        Intrinsics.reifiedOperationMarker(4, "VM");
        return arg2.get(arg3, Reflection.getOrCreateKotlinClass(ViewModel.class));
    }
}

