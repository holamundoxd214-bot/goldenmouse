package androidx.compose.ui.tooling.preview.datasource;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref$IntRef;

public final class LoremIpsum$$ExternalSyntheticLambda0 implements Function0 {
    public LoremIpsum$$ExternalSyntheticLambda0(IntRef arg1, int arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke() {
        return LoremIpsum.generateLoremIpsum$lambda$0(this.f$0, this.f$1);
    }
}

