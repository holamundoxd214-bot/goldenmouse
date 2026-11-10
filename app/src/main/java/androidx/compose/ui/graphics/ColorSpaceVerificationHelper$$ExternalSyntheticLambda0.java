package androidx.compose.ui.graphics;

import java.util.function.DoubleUnaryOperator;
import kotlin.jvm.functions.Function1;

public final class ColorSpaceVerificationHelper$$ExternalSyntheticLambda0 implements DoubleUnaryOperator {
    public ColorSpaceVerificationHelper$$ExternalSyntheticLambda0(Function1 arg1) {
        super();
        this.f$0 = arg1;
    }

    public final double applyAsDouble(double arg1) {
        return ColorSpaceVerificationHelper.androidColorSpace$lambda$0(this.f$0, arg1);
    }
}

