package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A^\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004*\u00020\u00052\u0012\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u00072\u0006\u0010\b\u001A\u0002H\u00032\u0006\u0010\t\u001A\u00020\n2\u0017\u0010\u000B\u001A\u0013\u0012\t\u0012\u0007H\u0004¢\u0006\u0002\b\r\u0012\u0004\u0012\u00020\u00020\f¢\u0006\u0002\u0010\u000E\u001AV\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004*\u00020\u00052\u0012\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u00072\u0006\u0010\b\u001A\u0002H\u00032\u0017\u0010\u000B\u001A\u0013\u0012\t\u0012\u0007H\u0004¢\u0006\u0002\b\r\u0012\u0004\u0012\u00020\u00020\f¢\u0006\u0002\u0010\u000F¨\u0006\u0010"}, d2={"registerForActivityResult", "Landroidx/activity/result/ActivityResultLauncher;", "", "I", "O", "Landroidx/activity/result/ActivityResultCaller;", "contract", "Landroidx/activity/result/contract/ActivityResultContract;", "input", "registry", "Landroidx/activity/result/ActivityResultRegistry;", "callback", "Lkotlin/Function1;", "Lkotlin/jvm/JvmSuppressWildcards;", "(Landroidx/activity/result/ActivityResultCaller;Landroidx/activity/result/contract/ActivityResultContract;Ljava/lang/Object;Landroidx/activity/result/ActivityResultRegistry;Lkotlin/jvm/functions/Function1;)Landroidx/activity/result/ActivityResultLauncher;", "(Landroidx/activity/result/ActivityResultCaller;Landroidx/activity/result/contract/ActivityResultContract;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Landroidx/activity/result/ActivityResultLauncher;", "activity"}, k=2, mv={2, 1, 0}, xi=0x30) public final class ActivityResultCallerKt {
    public static final ActivityResultLauncher registerForActivityResult(ActivityResultCaller arg1, ActivityResultContract arg2, Object arg3, ActivityResultRegistry arg4, Function1 arg5) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "contract");
        Intrinsics.checkNotNullParameter(arg4, "registry");
        Intrinsics.checkNotNullParameter(arg5, "callback");
        return new ActivityResultCallerLauncher(arg1.registerForActivityResult(arg2, arg4, new ActivityResultCallerKt$$ExternalSyntheticLambda0(arg5)), arg2, arg3);
    }

    public static final ActivityResultLauncher registerForActivityResult(ActivityResultCaller arg1, ActivityResultContract arg2, Object arg3, Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "contract");
        Intrinsics.checkNotNullParameter(arg4, "callback");
        return new ActivityResultCallerLauncher(arg1.registerForActivityResult(arg2, new ActivityResultCallerKt$$ExternalSyntheticLambda1(arg4)), arg2, arg3);
    }

    static final void registerForActivityResult$lambda$0(Function1 arg0, Object arg1) {
        arg0.invoke(arg1);
    }

    static final void registerForActivityResult$lambda$1(Function1 arg0, Object arg1) {
        arg0.invoke(arg1);
    }
}

