package androidx.window.reflection;

import java.lang.reflect.Method;
import kotlin.jvm.functions.Function0;

public final class ReflectionUtils$$ExternalSyntheticLambda0 implements Function0 {
    public ReflectionUtils$$ExternalSyntheticLambda0(Class arg1, Method arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke() {
        return Boolean.valueOf(ReflectionUtils.validateImplementation$lambda$1$lambda$0(this.f$0, this.f$1));
    }
}

