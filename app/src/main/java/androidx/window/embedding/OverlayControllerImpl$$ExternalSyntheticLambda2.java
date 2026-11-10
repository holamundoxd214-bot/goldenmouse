package androidx.window.embedding;

import androidx.core.util.Consumer;
import androidx.window.reflection.Consumer2;
import java.util.List;

public final class OverlayControllerImpl$$ExternalSyntheticLambda2 implements Consumer2 {
    public OverlayControllerImpl$$ExternalSyntheticLambda2(String arg1, OverlayControllerImpl arg2, Consumer arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final void accept(Object arg3) {
        OverlayControllerImpl.addOverlayInfoCallback$lambda$11$lambda$10(this.f$0, this.f$1, this.f$2, ((List)arg3));
    }
}

