package androidx.core.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B4\u0012\n\u0010\u0002\u001A\u0006\u0012\u0002\b\u00030\u0003\u0012\u001F\u0010\u0004\u001A\u001B\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\b¢\u0006\u0004\b\t\u0010\nJ\u001C\u0010\u000B\u001A\u00020\u00072\b\u0010\f\u001A\u0004\u0018\u00010\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u0006H\u0016R\'\u0010\u0004\u001A\u001B\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001A\b\u0012\u0002\b\u0003\u0018\u00010\u0003X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2={"Landroidx/core/content/ContinuationBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "continuation", "Lkotlin/coroutines/Continuation;", "onReceiveChecked", "Lkotlin/Function2;", "Landroid/content/Intent;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlin/coroutines/Continuation;Lkotlin/jvm/functions/Function2;)V", "onReceive", "context", "Landroid/content/Context;", "intent", "core"}, k=1, mv={2, 1, 0}, xi=0x30) final class ContinuationBroadcastReceiver extends BroadcastReceiver {
    private Continuation continuation;
    private final Function2 onReceiveChecked;

    public ContinuationBroadcastReceiver(Continuation arg2, Function2 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "continuation");
        Intrinsics.checkNotNullParameter(arg3, "onReceiveChecked");
        super();
        this.onReceiveChecked = arg3;
        this.continuation = arg2;
    }

    public void onReceive(Context arg2, Intent arg3) {
        try {
            this.onReceiveChecked.invoke(this, arg3);
            return;
        }
        catch(Throwable v2) {
            Continuation v3 = this.continuation;
            if(v3 != null) {
                v3.resumeWith(Result.constructor-impl(ResultKt.createFailure(v2)));
                this.continuation = null;
                return;
            }

            throw v2;
        }
    }
}

