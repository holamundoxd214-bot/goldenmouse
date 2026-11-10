package androidx.compose.material3.carousel;

import androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$FloatRef;

public final class CarouselStateKt$$ExternalSyntheticLambda1 implements Function2 {
    public CarouselStateKt$$ExternalSyntheticLambda1(FloatRef arg1, LazyLayoutScrollScope arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2, Object arg3) {
        return CarouselStateKt.animateScrollToPage$lambda$3(this.f$0, this.f$1, ((Float)arg2).floatValue(), ((Float)arg3).floatValue());
    }
}

