package androidx.compose.runtime;

import androidx.compose.runtime.composer.RememberManager;
import androidx.compose.runtime.composer.gapbuffer.SlotWriter;
import kotlin.jvm.functions.Function2;

public final class GapComposerKt$$ExternalSyntheticLambda0 implements Function2 {
    public GapComposerKt$$ExternalSyntheticLambda0(RememberManager arg1, SlotWriter arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2, Object arg3) {
        return GapComposerKt.deactivateCurrentGroup$lambda$0(this.f$0, this.f$1, ((Integer)arg2).intValue(), arg3);
    }
}

