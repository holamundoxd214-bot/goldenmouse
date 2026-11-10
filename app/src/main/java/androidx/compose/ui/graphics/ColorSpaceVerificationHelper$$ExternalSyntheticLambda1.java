package androidx.compose.ui.graphics;

import java.util.function.DoubleUnaryOperator;
import kotlin.jvm.functions.Function1;

public final class ColorSpaceVerificationHelper$$ExternalSyntheticLambda1 implements DoubleUnaryOperator {
    public ColorSpaceVerificationHelper$$ExternalSyntheticLambda1(Function1 arg1) {
        super();
        this.f$0 = arg1;
    }

    public final double applyAsDouble(double arg1) {
        return ColorSpaceVerificationHelper.androidColorSpace$lambda$1(this.f$0, arg1);
    }
}

