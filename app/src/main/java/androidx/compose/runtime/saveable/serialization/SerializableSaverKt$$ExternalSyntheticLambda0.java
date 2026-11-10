package androidx.compose.runtime.saveable.serialization;

import androidx.compose.runtime.saveable.SaverScope;
import androidx.savedstate.serialization.SavedStateConfiguration;
import kotlin.jvm.functions.Function2;
import kotlinx.serialization.KSerializer;

public final class SerializableSaverKt$$ExternalSyntheticLambda0 implements Function2 {
    public SerializableSaverKt$$ExternalSyntheticLambda0(KSerializer arg1, SavedStateConfiguration arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2, Object arg3) {
        return SerializableSaverKt.serializableSaver$lambda$0(this.f$0, this.f$1, ((SaverScope)arg2), arg3);
    }
}

