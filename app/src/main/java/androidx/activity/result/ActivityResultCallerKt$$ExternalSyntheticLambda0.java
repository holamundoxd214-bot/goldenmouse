package androidx.activity.result;

import kotlin.jvm.functions.Function1;

public final class ActivityResultCallerKt$$ExternalSyntheticLambda0 implements ActivityResultCallback {
    public ActivityResultCallerKt$$ExternalSyntheticLambda0(Function1 arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void onActivityResult(Object arg1) {
        ActivityResultCallerKt.registerForActivityResult$lambda$0(this.f$0, arg1);
    }
}

