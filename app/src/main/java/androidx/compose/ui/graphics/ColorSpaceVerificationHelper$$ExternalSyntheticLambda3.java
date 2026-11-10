package androidx.compose.ui.graphics;

import android.graphics.ColorSpace;
import androidx.compose.ui.graphics.colorspace.DoubleFunction;

public final class ColorSpaceVerificationHelper$$ExternalSyntheticLambda3 implements DoubleFunction {
    public ColorSpaceVerificationHelper$$ExternalSyntheticLambda3(ColorSpace arg1) {
        super();
        this.f$0 = arg1;
    }

    public final double invoke(double arg1) {
        return ColorSpaceVerificationHelper.composeColorSpace$lambda$1(this.f$0, arg1);
    }
}

