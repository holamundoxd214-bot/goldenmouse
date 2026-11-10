package androidx.core.content;

import android.content.BroadcastReceiver;
import android.content.Intent;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

public final class ContextKt$receiveBroadcastsAsync$2$$ExternalSyntheticLambda0 implements Function2 {
    public ContextKt$receiveBroadcastsAsync$2$$ExternalSyntheticLambda0(CoroutineScope arg1, Function3 arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2, Object arg3) {
        return ContextKt$receiveBroadcastsAsync$2.invokeSuspend$lambda$0(this.f$0, this.f$1, ((BroadcastReceiver)arg2), ((Intent)arg3));
    }
}

