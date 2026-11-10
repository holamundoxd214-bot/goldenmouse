package androidx.compose.ui.text;

import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref$ObjectRef;

public final class JvmAnnotatedString_jvmKt$$ExternalSyntheticLambda0 implements Function1 {
    public JvmAnnotatedString_jvmKt$$ExternalSyntheticLambda0(ObjectRef arg1, Function3 arg2, AnnotatedString arg3, Map arg4) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
    }

    public final Object invoke(Object arg4) {
        return JvmAnnotatedString_jvmKt.transform$lambda$0(this.f$0, this.f$1, this.f$2, this.f$3, ((List)arg4));
    }
}

