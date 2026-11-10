package androidx.window.area;

import androidx.window.reflection.Consumer2;
import kotlinx.coroutines.channels.ProducerScope;

public final class WindowAreaControllerImpl$windowAreaInfos$1$$ExternalSyntheticLambda0 implements Consumer2 {
    public WindowAreaControllerImpl$windowAreaInfos$1$$ExternalSyntheticLambda0(WindowAreaControllerImpl arg1, ProducerScope arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final void accept(Object arg2) {
        WindowAreaControllerImpl$windowAreaInfos$1.invokeSuspend$lambda$0(this.f$0, this.f$1, ((Integer)arg2).intValue());
    }
}

