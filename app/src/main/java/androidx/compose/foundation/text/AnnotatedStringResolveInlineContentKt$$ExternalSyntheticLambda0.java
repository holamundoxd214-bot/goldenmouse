package androidx.compose.foundation.text;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.text.AnnotatedString;
import java.util.List;
import kotlin.jvm.functions.Function2;

public final class AnnotatedStringResolveInlineContentKt$$ExternalSyntheticLambda0 implements Function2 {
    public AnnotatedStringResolveInlineContentKt$$ExternalSyntheticLambda0(AnnotatedString arg1, List arg2, int arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final Object invoke(Object arg3, Object arg4) {
        return AnnotatedStringResolveInlineContentKt.InlineChildren$lambda$1(this.f$0, this.f$1, this.f$2, ((Composer)arg3), ((Integer)arg4).intValue());
    }
}

