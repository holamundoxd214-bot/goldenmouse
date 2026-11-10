package androidx.compose.ui.text.font;

import kotlin.jvm.functions.Function1;

public final class FontFamilyResolverImpl$$ExternalSyntheticLambda3 implements Function1 {
    public FontFamilyResolverImpl$$ExternalSyntheticLambda3(FontFamilyResolverImpl arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return FontFamilyResolverImpl.preload$lambda$1(this.f$0, ((TypefaceRequest)arg1));
    }
}

