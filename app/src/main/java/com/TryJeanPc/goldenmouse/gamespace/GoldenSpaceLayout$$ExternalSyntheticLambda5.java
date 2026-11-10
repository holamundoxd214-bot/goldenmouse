package com.TryJeanPc.goldenmouse.gamespace;

import com.TryJeanPc.goldenmouse.GameInfo;
import kotlin.jvm.functions.Function1;

public final class GoldenSpaceLayout$$ExternalSyntheticLambda5 implements Function1 {
    public GoldenSpaceLayout$$ExternalSyntheticLambda5(GoldenSpaceLayout arg1, GoldenGameAdapter arg2, GoldenCarouselLayoutManager arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final Object invoke(Object arg3) {
        return GoldenSpaceLayout.switchViewMode$lambda$5(this.f$0, this.f$1, this.f$2, ((GameInfo)arg3));
    }
}

