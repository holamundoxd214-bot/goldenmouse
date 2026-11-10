package androidx.core.os;

import android.os.OutcomeReceiver;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\u001A.\u0010\u0000\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0007¨\u0006\u0006"}, d2={"asOutcomeReceiver", "Landroid/os/OutcomeReceiver;", "R", "E", "", "Lkotlin/coroutines/Continuation;", "core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class OutcomeReceiverKt {
    public static final OutcomeReceiver asOutcomeReceiver(Continuation arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return new ContinuationOutcomeReceiver(arg1);
    }
}

