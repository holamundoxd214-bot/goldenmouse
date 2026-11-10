package androidx.activity;

import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001A9\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\n\b\u0002\u0010\u0003\u001A\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u00062\u0017\u0010\u0007\u001A\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\n¨\u0006\u000B"}, d2={"addCallback", "Landroidx/activity/OnBackPressedCallback;", "Landroidx/activity/OnBackPressedDispatcher;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "enabled", "", "onBackPressed", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "activity"}, k=2, mv={2, 1, 0}, xi=0x30) public final class OnBackPressedDispatcherKt {
    public static final OnBackPressedCallback addCallback(OnBackPressedDispatcher arg1, LifecycleOwner arg2, boolean arg3, Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "onBackPressed");
        OnBackPressedDispatcherKt$addCallback$callback$1 v0 = new OnBackPressedDispatcherKt$addCallback$callback$1(arg3, arg4);
        if(arg2 != null) {
            arg1.addCallback(arg2, v0);
        }
        else {
            arg1.addCallback(v0);
        }

        return ((OnBackPressedCallback)v0);
    }

    public static OnBackPressedCallback addCallback$default(OnBackPressedDispatcher arg0, LifecycleOwner arg1, boolean arg2, Function1 arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = null;
        }

        return OnBackPressedDispatcherKt.addCallback(arg0, arg1, true, arg3);
    }
}

