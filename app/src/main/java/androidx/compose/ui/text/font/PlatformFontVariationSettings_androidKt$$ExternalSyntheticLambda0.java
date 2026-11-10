package androidx.compose.ui.text.font;

import androidx.compose.ui.unit.Density;
import kotlin.jvm.functions.Function1;

public final class PlatformFontVariationSettings_androidKt$$ExternalSyntheticLambda0 implements Function1 {
    public PlatformFontVariationSettings_androidKt$$ExternalSyntheticLambda0(Density arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return PlatformFontVariationSettings_androidKt.toAndroidString$lambda$0(this.f$0, ((Setting)arg1));
    }
}

