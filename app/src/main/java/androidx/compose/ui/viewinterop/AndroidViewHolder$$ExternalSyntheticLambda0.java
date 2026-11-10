package androidx.compose.ui.viewinterop;

import kotlin.jvm.functions.Function0;

public final class AndroidViewHolder$$ExternalSyntheticLambda0 implements Runnable {
    public AndroidViewHolder$$ExternalSyntheticLambda0(Function0 arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void run() {
        AndroidViewHolder.invalidateOrDefer$lambda$0(this.f$0);
    }
}

