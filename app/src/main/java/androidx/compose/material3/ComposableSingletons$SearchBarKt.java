package androidx.compose.material3;

import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

@Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class ComposableSingletons$SearchBarKt {
    public static final ComposableSingletons$SearchBarKt INSTANCE;
    private static Function2 lambda$-1146652811;
    private static Function2 lambda$1165377840;

    static {
        ComposableSingletons$SearchBarKt.INSTANCE = new ComposableSingletons$SearchBarKt();
        ComposableSingletons$SearchBarKt.lambda$1165377840 = ComposableLambdaKt.composableLambdaInstance(0x45764130, false, ComposableSingletons$SearchBarKt$lambda$1165377840$1.INSTANCE);
        ComposableSingletons$SearchBarKt.lambda$-1146652811 = ComposableLambdaKt.composableLambdaInstance(0xBBA77775, false, ComposableSingletons$SearchBarKt$lambda$-1146652811$1.INSTANCE);
    }

    public ComposableSingletons$SearchBarKt() {
        super();
    }

    public final Function2 getLambda$-1146652811$material3() {
        return ComposableSingletons$SearchBarKt.lambda$-1146652811;
    }

    public final Function2 getLambda$1165377840$material3() {
        return ComposableSingletons$SearchBarKt.lambda$1165377840;
    }
}

