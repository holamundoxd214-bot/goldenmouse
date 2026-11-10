package androidx.compose.material3.carousel;

import kotlin.jvm.functions.Function1;

public final class StrategyKt$$ExternalSyntheticLambda1 implements Function1 {
    public StrategyKt$$ExternalSyntheticLambda1(KeylineList arg1, float arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return StrategyKt.createShiftedKeylineListForContentPadding$lambda$2(this.f$0, this.f$1, ((KeylineListScope)arg2));
    }
}

