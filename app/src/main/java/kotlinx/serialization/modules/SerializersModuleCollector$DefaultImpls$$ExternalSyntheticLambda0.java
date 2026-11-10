package kotlinx.serialization.modules;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlinx.serialization.KSerializer;

public final class SerializersModuleCollector$DefaultImpls$$ExternalSyntheticLambda0 implements Function1 {
    public SerializersModuleCollector$DefaultImpls$$ExternalSyntheticLambda0(KSerializer arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return DefaultImpls.contextual$lambda$0(this.f$0, ((List)arg1));
    }
}

