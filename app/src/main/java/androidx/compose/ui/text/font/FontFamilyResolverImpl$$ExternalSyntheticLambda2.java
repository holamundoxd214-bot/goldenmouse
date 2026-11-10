package androidx.compose.ui.text.font;

import kotlin.jvm.functions.Function1;

public final class FontFamilyResolverImpl$$ExternalSyntheticLambda2 implements Function1 {
    public FontFamilyResolverImpl$$ExternalSyntheticLambda2(FontFamilyResolverImpl arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return FontFamilyResolverImpl.createDefaultTypeface$lambda$0(this.f$0, ((TypefaceRequest)arg1));
    }
}

