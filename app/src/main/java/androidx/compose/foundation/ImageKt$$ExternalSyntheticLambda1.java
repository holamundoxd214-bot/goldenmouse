package androidx.compose.foundation;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import kotlin.jvm.functions.Function2;

public final class ImageKt$$ExternalSyntheticLambda1 implements Function2 {
    public ImageKt$$ExternalSyntheticLambda1(Painter arg1, String arg2, Modifier arg3, Alignment arg4, ContentScale arg5, float arg6, ColorFilter arg7, int arg8, int arg9) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
        this.f$4 = arg5;
        this.f$5 = arg6;
        this.f$6 = arg7;
        this.f$7 = arg8;
        this.f$8 = arg9;
    }

    public final Object invoke(Object arg12, Object arg13) {
        return ImageKt.Image$lambda$2(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, arg12, ((Integer)arg13).intValue());
    }
}

