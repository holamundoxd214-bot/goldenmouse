package com.TryJeanPc.goldenmouse.stretch.agent;

import android.os.ParcelFileDescriptor$AutoCloseInputStream;
import java.util.concurrent.Callable;

public final class AndroidStretchOriginalReader$$ExternalSyntheticLambda4 implements Callable {
    public AndroidStretchOriginalReader$$ExternalSyntheticLambda4(ParcelFileDescriptor$AutoCloseInputStream arg1, Query arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object call() {
        return AndroidStretchOriginalReader.dump$lambda$15$lambda$14(this.f$0, this.f$1);
    }
}

