package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H\u0016J\u0010\u0010\u0006\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H\u0016J\u0010\u0010\u0007\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H\u0016J\u0010\u0010\b\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H\u0016J\u0010\u0010\t\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H\u0016J\u0010\u0010\n\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000BÀ\u0006\u0001"}, d2={"Landroidx/lifecycle/DefaultLifecycleObserver;", "Landroidx/lifecycle/LifecycleObserver;", "onCreate", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onStart", "onResume", "onPause", "onStop", "onDestroy", "lifecycle-common"}, k=1, mv={2, 1, 0}, xi=0x30) public interface DefaultLifecycleObserver extends LifecycleObserver {
    default void onCreate(LifecycleOwner arg1) {
        Intrinsics.checkNotNullParameter(arg1, "owner");
    }

    default void onDestroy(LifecycleOwner arg1) {
        Intrinsics.checkNotNullParameter(arg1, "owner");
    }

    default void onPause(LifecycleOwner arg1) {
        Intrinsics.checkNotNullParameter(arg1, "owner");
    }

    default void onResume(LifecycleOwner arg1) {
        Intrinsics.checkNotNullParameter(arg1, "owner");
    }

    default void onStart(LifecycleOwner arg1) {
        Intrinsics.checkNotNullParameter(arg1, "owner");
    }

    default void onStop(LifecycleOwner arg1) {
        Intrinsics.checkNotNullParameter(arg1, "owner");
    }
}

