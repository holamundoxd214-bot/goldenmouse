package androidx.compose.runtime.saveable.serialization;

import android.os.Bundle;
import androidx.savedstate.serialization.SavedStateConfiguration;
import kotlin.jvm.functions.Function1;
import kotlinx.serialization.KSerializer;

public final class SerializableSaverKt$$ExternalSyntheticLambda1 implements Function1 {
    public SerializableSaverKt$$ExternalSyntheticLambda1(KSerializer arg1, SavedStateConfiguration arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return SerializableSaverKt.serializableSaver$lambda$1(this.f$0, this.f$1, ((Bundle)arg2));
    }
}

