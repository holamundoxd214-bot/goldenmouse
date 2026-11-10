package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityOptionsCompat;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B1\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0012\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0006\u0010\b\u001A\u00028\u0000¢\u0006\u0004\b\t\u0010\nJ\u001F\u0010\u0014\u001A\u00020\u00042\u0006\u0010\u0015\u001A\u00020\u00042\b\u0010\u0016\u001A\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001A\u00020\u0004H\u0016R\u0014\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001D\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0013\u0010\b\u001A\u00028\u0000¢\u0006\n\n\u0002\u0010\u000F\u001A\u0004\b\r\u0010\u000ER\'\u0010\u0010\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001A\u0004\b\u0011\u0010\fR \u0010\u001A\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u001B\u0010\f¨\u0006\u001C"}, d2={"Landroidx/activity/result/ActivityResultCallerLauncher;", "I", "O", "Landroidx/activity/result/ActivityResultLauncher;", "", "launcher", "callerContract", "Landroidx/activity/result/contract/ActivityResultContract;", "callerInput", "<init>", "(Landroidx/activity/result/ActivityResultLauncher;Landroidx/activity/result/contract/ActivityResultContract;Ljava/lang/Object;)V", "getCallerContract", "()Landroidx/activity/result/contract/ActivityResultContract;", "getCallerInput", "()Ljava/lang/Object;", "Ljava/lang/Object;", "resultContract", "getResultContract", "resultContract$delegate", "Lkotlin/Lazy;", "launch", "input", "options", "Landroidx/core/app/ActivityOptionsCompat;", "(Lkotlin/Unit;Landroidx/core/app/ActivityOptionsCompat;)V", "unregister", "contract", "getContract", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ActivityResultCallerLauncher extends ActivityResultLauncher {
    private final ActivityResultContract callerContract;
    private final Object callerInput;
    private final ActivityResultContract contract;
    private final ActivityResultLauncher launcher;
    private final Lazy resultContract$delegate;

    public ActivityResultCallerLauncher(ActivityResultLauncher arg2, ActivityResultContract arg3, Object arg4) {
        Intrinsics.checkNotNullParameter(arg2, "launcher");
        Intrinsics.checkNotNullParameter(arg3, "callerContract");
        super();
        this.launcher = arg2;
        this.callerContract = arg3;
        this.callerInput = arg4;
        this.resultContract$delegate = LazyKt.lazy(new ActivityResultCallerLauncher$$ExternalSyntheticLambda0(this));
        this.contract = this.getResultContract();
    }

    public final ActivityResultContract getCallerContract() {
        return this.callerContract;
    }

    public final Object getCallerInput() {
        return this.callerInput;
    }

    public ActivityResultContract getContract() {
        return this.contract;
    }

    private final ActivityResultContract getResultContract() {
        return this.resultContract$delegate.getValue();
    }

    public void launch(Object arg1, ActivityOptionsCompat arg2) {
        this.launch(((Unit)arg1), arg2);
    }

    public void launch(Unit arg2, ActivityOptionsCompat arg3) {
        Intrinsics.checkNotNullParameter(arg2, "input");
        this.launcher.launch(this.callerInput, arg3);
    }

    static final ActivityResultCallerLauncher$resultContract$2$1 resultContract_delegate$lambda$0(ActivityResultCallerLauncher arg1) {
        return new ActivityResultCallerLauncher$resultContract$2$1(arg1);
    }

    public void unregister() {
        this.launcher.unregister();
    }
}

