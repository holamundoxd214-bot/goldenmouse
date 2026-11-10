package androidx.compose.ui.graphics;

import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2={"Landroidx/compose/ui/graphics/ColorMatrixFilterHelper;", "", "<init>", "()V", "getColorMatrix", "Landroidx/compose/ui/graphics/ColorMatrix;", "colorFilter", "Landroid/graphics/ColorMatrixColorFilter;", "getColorMatrix-8unuwjk", "(Landroid/graphics/ColorMatrixColorFilter;)[F", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) final class ColorMatrixFilterHelper {
    public static final ColorMatrixFilterHelper INSTANCE;

    static {
        ColorMatrixFilterHelper.INSTANCE = new ColorMatrixFilterHelper();
    }

    private ColorMatrixFilterHelper() {
        super();
    }

    public final float[] getColorMatrix-8unuwjk(ColorMatrixColorFilter arg1) {
        ColorMatrix v0 = new ColorMatrix();
        arg1.getColorMatrix(v0);
        return androidx.compose.ui.graphics.ColorMatrix.constructor-impl(v0.getArray());
    }
}

