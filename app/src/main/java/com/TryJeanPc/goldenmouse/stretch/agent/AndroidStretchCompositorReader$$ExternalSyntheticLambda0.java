package com.TryJeanPc.goldenmouse.stretch.agent;

import android.os.ParcelFileDescriptor$AutoCloseInputStream;
import java.util.concurrent.Callable;

public final class AndroidStretchCompositorReader$$ExternalSyntheticLambda0 implements Callable {
    public AndroidStretchCompositorReader$$ExternalSyntheticLambda0(ParcelFileDescriptor$AutoCloseInputStream arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object call() {
        return AndroidStretchCompositorReader.dump$lambda$2(this.f$0);
    }
}

