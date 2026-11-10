package androidx.compose.foundation;

import androidx.compose.ui.unit.Density;

public final class MarqueeSpacing$Companion$$ExternalSyntheticLambda0 implements MarqueeSpacing {
    public MarqueeSpacing$Companion$$ExternalSyntheticLambda0(float arg1) {
        super();
        this.f$0 = arg1;
    }

    public final int calculateSpacing(Density arg1, int arg2, int arg3) {
        return Companion.fractionOfContainer$lambda$0(this.f$0, arg1, arg2, arg3);
    }
}

