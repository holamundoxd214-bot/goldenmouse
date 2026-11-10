package androidx.compose.ui.text.platform.extensions;

import android.text.Spannable;
import androidx.compose.ui.text.SpanStyle;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;

public final class SpannableExtensions_androidKt$$ExternalSyntheticLambda0 implements Function3 {
    public SpannableExtensions_androidKt$$ExternalSyntheticLambda0(Spannable arg1, Function4 arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2, Object arg3, Object arg4) {
        return SpannableExtensions_androidKt.setFontAttributes$lambda$2(this.f$0, this.f$1, ((SpanStyle)arg2), ((Integer)arg3).intValue(), ((Integer)arg4).intValue());
    }
}

