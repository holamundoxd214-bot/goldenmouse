package androidx.compose.ui.text.platform;

import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import kotlin.jvm.functions.Function4;

public final class AndroidParagraphIntrinsics$$ExternalSyntheticLambda0 implements Function4 {
    public AndroidParagraphIntrinsics$$ExternalSyntheticLambda0(AndroidParagraphIntrinsics arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1, Object arg2, Object arg3, Object arg4) {
        return AndroidParagraphIntrinsics._init_$lambda$0(this.f$0, ((FontFamily)arg1), ((FontWeight)arg2), ((FontStyle)arg3), ((FontSynthesis)arg4));
    }
}

