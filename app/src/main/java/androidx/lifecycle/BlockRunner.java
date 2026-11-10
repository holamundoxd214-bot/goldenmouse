package androidx.lifecycle;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job$DefaultImpls;
import kotlinx.coroutines.Job;

@Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002Bl\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004\u00127\u0010\u0005\u001A3\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006j\b\u0012\u0004\u0012\u00028\u0000`\u000B¢\u0006\u0002\b\n\u0012\u0006\u0010\f\u001A\u00020\r\u0012\u0006\u0010\u000E\u001A\u00020\u000F\u0012\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0018\u001A\u00020\tH\u0007J\b\u0010\u0019\u001A\u00020\tH\u0007R\u0014\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000RA\u0010\u0005\u001A3\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006j\b\u0012\u0004\u0012\u00028\u0000`\u000B¢\u0006\u0002\b\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u000E\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u000FX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\t0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001A\u0004\u0018\u00010\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001A\u0004\u0018\u00010\u0016X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u001A"}, d2={"Landroidx/lifecycle/BlockRunner;", "T", "", "liveData", "Landroidx/lifecycle/CoroutineLiveData;", "block", "Lkotlin/Function2;", "Landroidx/lifecycle/LiveDataScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/lifecycle/Block;", "timeoutInMs", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "onDone", "Lkotlin/Function0;", "<init>", "(Landroidx/lifecycle/CoroutineLiveData;Lkotlin/jvm/functions/Function2;JLkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function0;)V", "Lkotlin/jvm/functions/Function2;", "runningJob", "Lkotlinx/coroutines/Job;", "cancellationJob", "maybeRun", "cancel", "lifecycle-livedata"}, k=1, mv={2, 1, 0}, xi=0x30) public final class BlockRunner {
    private final Function2 block;
    private Job cancellationJob;
    private final CoroutineLiveData liveData;
    private final Function0 onDone;
    private Job runningJob;
    private final CoroutineScope scope;
    private final long timeoutInMs;

    public BlockRunner(CoroutineLiveData arg2, Function2 arg3, long arg4, CoroutineScope arg6, Function0 arg7) {
        Intrinsics.checkNotNullParameter(arg2, "liveData");
        Intrinsics.checkNotNullParameter(arg3, "block");
        Intrinsics.checkNotNullParameter(arg6, "scope");
        Intrinsics.checkNotNullParameter(arg7, "onDone");
        super();
        this.liveData = arg2;
        this.block = arg3;
        this.timeoutInMs = arg4;
        this.scope = arg6;
        this.onDone = arg7;
    }

    public static final Function2 access$getBlock$p(BlockRunner arg0) {
        return arg0.block;
    }

    public static final CoroutineLiveData access$getLiveData$p(BlockRunner arg0) {
        return arg0.liveData;
    }

    public static final Function0 access$getOnDone$p(BlockRunner arg0) {
        return arg0.onDone;
    }

    public static final Job access$getRunningJob$p(BlockRunner arg0) {
        return arg0.runningJob;
    }

    public static final long access$getTimeoutInMs$p(BlockRunner arg2) {
        return arg2.timeoutInMs;
    }

    public static final void access$setRunningJob$p(BlockRunner arg0, Job arg1) {
        arg0.runningJob = arg1;
    }

    public final void cancel() {
        if(this.cancellationJob == null) {
            this.cancellationJob = BuildersKt.launch$default(this.scope, Dispatchers.getMain().getImmediate(), null, new BlockRunner$cancel$1(this, null), 2, null);
            return;
        }

        throw new IllegalStateException("Cancel call cannot happen without a maybeRun".toString());
    }

    public final void maybeRun() {
        Job v0 = this.cancellationJob;
        CancellationException v1 = null;
        if(v0 != null) {
            DefaultImpls.cancel$default(v0, v1, 1, v1);
        }

        this.cancellationJob = ((Job)v1);
        if(this.runningJob != null) {
            return;
        }

        this.runningJob = BuildersKt.launch$default(this.scope, null, null, new BlockRunner$maybeRun$1(this, ((Continuation)v1)), 3, null);
    }
}

