package androidx.compose.ui.graphics.shadow;

import android.graphics.BlurMaskFilter$Blur;
import android.graphics.BlurMaskFilter;
import android.graphics.MaskFilter;
import androidx.compose.ui.graphics.Paint;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u0014\u0010\u0000\u001A\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0000\u001A\u001C\u0010\u0005\u001A\u00020\u0006*\u00020\u00072\u000E\u0010\b\u001A\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002H\u0000*\f\b\u0000\u0010\u0000\"\u00020\u00012\u00020\u0001¨\u0006\t"}, d2={"BlurFilter", "Landroid/graphics/BlurMaskFilter;", "Landroidx/compose/ui/graphics/shadow/BlurFilter;", "radius", "", "setBlurFilter", "", "Landroidx/compose/ui/graphics/Paint;", "blur", "ui-graphics"}, k=2, mv={2, 0, 0}, xi=0x30) public final class Blur_androidKt {
    public static final BlurMaskFilter BlurFilter(float arg2) {
        return new BlurMaskFilter(arg2, BlurMaskFilter$Blur.NORMAL);
    }

    public static final void setBlurFilter(Paint arg0, BlurMaskFilter arg1) {
        arg0.asFrameworkPaint().setMaskFilter(((MaskFilter)arg1));
    }
}

