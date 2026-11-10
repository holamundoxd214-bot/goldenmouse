package androidx.lifecycle;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\b\u001A\u00020\t2\'\u0010\n\u001A#\b\u0001\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u000E0\u000B¢\u0006\u0002\b\u000FH\u0007¢\u0006\u0002\u0010\u0010J6\u0010\u0011\u001A\u00020\t2\'\u0010\n\u001A#\b\u0001\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u000E0\u000B¢\u0006\u0002\b\u000FH\u0007¢\u0006\u0002\u0010\u0010J6\u0010\u0012\u001A\u00020\t2\'\u0010\n\u001A#\b\u0001\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u000E0\u000B¢\u0006\u0002\b\u000FH\u0007¢\u0006\u0002\u0010\u0010R\u0012\u0010\u0004\u001A\u00020\u0005X \u0004¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2={"Landroidx/lifecycle/LifecycleCoroutineScope;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "getLifecycle$lifecycle_common", "()Landroidx/lifecycle/Lifecycle;", "launchWhenCreated", "Lkotlinx/coroutines/Job;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "launchWhenStarted", "launchWhenResumed", "lifecycle-common"}, k=1, mv={2, 1, 0}, xi=0x30) public abstract class LifecycleCoroutineScope implements CoroutineScope {
    public LifecycleCoroutineScope() {
        super();
    }

    public abstract Lifecycle getLifecycle$lifecycle_common();

    @Deprecated(message="launchWhenCreated is deprecated as it can lead to wasted resources in some cases. Replace with suspending repeatOnLifecycle to run the block whenever the Lifecycle state is at least Lifecycle.State.CREATED.") public final Job launchWhenCreated(Function2 arg8) {
        Intrinsics.checkNotNullParameter(arg8, "block");
        return BuildersKt.launch$default(this, null, null, new LifecycleCoroutineScope$launchWhenCreated$1(this, arg8, null), 3, null);
    }

    @Deprecated(message="launchWhenResumed is deprecated as it can lead to wasted resources in some cases. Replace with suspending repeatOnLifecycle to run the block whenever the Lifecycle state is at least Lifecycle.State.RESUMED.") public final Job launchWhenResumed(Function2 arg8) {
        Intrinsics.checkNotNullParameter(arg8, "block");
        return BuildersKt.launch$default(this, null, null, new LifecycleCoroutineScope$launchWhenResumed$1(this, arg8, null), 3, null);
    }

    @Deprecated(message="launchWhenStarted is deprecated as it can lead to wasted resources in some cases. Replace with suspending repeatOnLifecycle to run the block whenever the Lifecycle state is at least Lifecycle.State.STARTED.") public final Job launchWhenStarted(Function2 arg8) {
        Intrinsics.checkNotNullParameter(arg8, "block");
        return BuildersKt.launch$default(this, null, null, new LifecycleCoroutineScope$launchWhenStarted$1(this, arg8, null), 3, null);
    }
}

