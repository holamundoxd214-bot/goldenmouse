package com.TryJeanPc.goldenmouse.shizuku;

import android.os.IBinder;
import com.TryJeanPc.goldenmouse.injector.TouchCommand;
import kotlin.jvm.functions.Function0;

public final class GoldenInputServiceConnection$$ExternalSyntheticLambda3 implements Function0 {
    public GoldenInputServiceConnection$$ExternalSyntheticLambda3(TouchCommand arg1, IBinder arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke() {
        return Boolean.valueOf(GoldenInputServiceConnection.execute$lambda$6(this.f$0, this.f$1));
    }
}

