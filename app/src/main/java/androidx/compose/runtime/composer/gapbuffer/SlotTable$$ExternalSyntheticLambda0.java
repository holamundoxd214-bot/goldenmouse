package androidx.compose.runtime.composer.gapbuffer;

import androidx.compose.runtime.MovableContentStateReference;
import kotlin.jvm.functions.Function1;

public final class SlotTable$$ExternalSyntheticLambda0 implements Function1 {
    public SlotTable$$ExternalSyntheticLambda0(SlotTable arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return SlotTable.extractNestedStates$lambda$1(this.f$0, ((MovableContentStateReference)arg1));
    }
}

