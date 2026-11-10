package com.TryJeanPc.goldenmouse.stretch.agent;

import android.os.ParcelFileDescriptor$AutoCloseInputStream;
import android.os.ParcelFileDescriptor;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref$ObjectRef;

public final class AndroidStretchOriginalReader$$ExternalSyntheticLambda6 implements Function0 {
    public AndroidStretchOriginalReader$$ExternalSyntheticLambda6(ObjectRef arg1, AndroidStretchOriginalReader arg2, ParcelFileDescriptor$AutoCloseInputStream arg3, ParcelFileDescriptor[] arg4) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
    }

    public final Object invoke() {
        return AndroidStretchOriginalReader.dump$lambda$21(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}

