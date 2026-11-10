package androidx.compose.ui.graphics;

import android.graphics.ColorSpace;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\f\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0007\u001A\f\u0010\u0003\u001A\u00020\u0002*\u00020\u0001H\u0007¨\u0006\u0004"}, d2={"toAndroidColorSpace", "Landroid/graphics/ColorSpace;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "toComposeColorSpace", "ui-graphics"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AndroidColorSpace_androidKt {
    public static final ColorSpace toAndroidColorSpace(androidx.compose.ui.graphics.colorspace.ColorSpace arg1) {
        return ColorSpaceVerificationHelper.androidColorSpace(arg1);
    }

    public static final androidx.compose.ui.graphics.colorspace.ColorSpace toComposeColorSpace(ColorSpace arg1) {
        return ColorSpaceVerificationHelper.composeColorSpace(arg1);
    }
}

