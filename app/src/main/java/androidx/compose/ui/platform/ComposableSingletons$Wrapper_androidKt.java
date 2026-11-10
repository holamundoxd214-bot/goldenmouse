package androidx.compose.ui.platform;

import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

@Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class ComposableSingletons$Wrapper_androidKt {
    public static final ComposableSingletons$Wrapper_androidKt INSTANCE;
    private static Function2 lambda$-1759434350;

    static {
        ComposableSingletons$Wrapper_androidKt.INSTANCE = new ComposableSingletons$Wrapper_androidKt();
        ComposableSingletons$Wrapper_androidKt.lambda$-1759434350 = ComposableLambdaKt.composableLambdaInstance(-1759434350, false, ComposableSingletons$Wrapper_androidKt$lambda$-1759434350$1.INSTANCE);
    }

    public ComposableSingletons$Wrapper_androidKt() {
        super();
    }

    public final Function2 getLambda$-1759434350$ui() {
        return ComposableSingletons$Wrapper_androidKt.lambda$-1759434350;
    }
}

