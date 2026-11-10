package androidx.compose.material3.carousel;

import androidx.compose.foundation.gestures.ScrollScope;
import kotlin.jvm.functions.Function2;

public final class CarouselState$animateScrollToItem$2$1$$ExternalSyntheticLambda0 implements Function2 {
    public CarouselState$animateScrollToItem$2$1$$ExternalSyntheticLambda0(CarouselPagerState arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1, Object arg2) {
        return CarouselState$animateScrollToItem$2$1.invokeSuspend$lambda$0(this.f$0, ((ScrollScope)arg1), ((Integer)arg2).intValue());
    }
}

