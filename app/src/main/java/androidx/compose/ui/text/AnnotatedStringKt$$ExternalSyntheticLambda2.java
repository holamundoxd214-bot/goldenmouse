package androidx.compose.ui.text;

import androidx.compose.ui.text.intl.LocaleList;
import kotlin.jvm.functions.Function3;

public final class AnnotatedStringKt$$ExternalSyntheticLambda2 implements Function3 {
    public AnnotatedStringKt$$ExternalSyntheticLambda2(LocaleList arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1, Object arg2, Object arg3) {
        return AnnotatedStringKt.toUpperCase$lambda$0(this.f$0, ((String)arg1), ((Integer)arg2).intValue(), ((Integer)arg3).intValue());
    }
}

