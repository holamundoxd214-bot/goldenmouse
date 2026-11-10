package com.TryJeanPc.goldenmouse.stretch.agent;

import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import kotlin.jvm.functions.Function0;

public final class AndroidStretchOriginalReader$$ExternalSyntheticLambda9 implements Function0 {
    public AndroidStretchOriginalReader$$ExternalSyntheticLambda9(IBinder arg1, ParcelFileDescriptor[] arg2, Query arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final Object invoke() {
        return AndroidStretchOriginalReader.dump$lambda$16(this.f$0, this.f$1, this.f$2);
    }
}

