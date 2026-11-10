package androidx.compose.ui.unit;

import android.content.Context;
import androidx.compose.ui.unit.fontscaling.FontScaleConverter;
import androidx.compose.ui.unit.fontscaling.FontScaleConverterFactory;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\u000E\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003¨\u0006\u0004"}, d2={"Density", "Landroidx/compose/ui/unit/Density;", "context", "Landroid/content/Context;", "ui-unit"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AndroidDensity_androidKt {
    public static final Density Density(Context arg3) {
        LinearFontScaleConverter v2_1;
        float v0 = arg3.getResources().getConfiguration().fontScale;
        float v3 = arg3.getResources().getDisplayMetrics().density;
        FontScaleConverter v2 = FontScaleConverterFactory.INSTANCE.forScale(v0);
        if(v2 == null) {
            v2_1 = new LinearFontScaleConverter(v0);
        }

        return new DensityWithConverter(v3, v0, ((FontScaleConverter)v2_1));
    }
}

