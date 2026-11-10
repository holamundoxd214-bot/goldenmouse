package androidx.lifecycle;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u001A@\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0014\b\u0004\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\b0\u0007H\u0087\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2={"observe", "Landroidx/lifecycle/Observer;", "T", "Landroidx/lifecycle/LiveData;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onChanged", "Lkotlin/Function1;", "", "lifecycle-livedata-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class LiveDataKt {
    @Deprecated(message="This extension method is not required when using Kotlin 1.4. You should remove \"import androidx.lifecycle.observe\"") public static final Observer observe(LiveData arg1, LifecycleOwner arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "owner");
        Intrinsics.checkNotNullParameter(arg3, "onChanged");
        LiveDataKt$observe$wrappedObserver$1 v0 = new LiveDataKt$observe$wrappedObserver$1(arg3);
        arg1.observe(arg2, ((Observer)v0));
        return ((Observer)v0);
    }
}

