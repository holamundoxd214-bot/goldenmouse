package androidx.compose.ui.graphics;

import android.graphics.ColorSpace;
import androidx.compose.ui.graphics.colorspace.DoubleFunction;

public final class ColorSpaceVerificationHelper$$ExternalSyntheticLambda2 implements DoubleFunction {
    public ColorSpaceVerificationHelper$$ExternalSyntheticLambda2(ColorSpace arg1) {
        super();
        this.f$0 = arg1;
    }

    public final double invoke(double arg1) {
        return ColorSpaceVerificationHelper.composeColorSpace$lambda$0(this.f$0, arg1);
    }
}

