package androidx.compose.foundation.text.contextmenu.internal;

import android.view.textclassifier.TextClassification;
import androidx.compose.runtime.Composer;
import kotlin.jvm.functions.Function2;

public final class TextContextMenuHelperApi28$$ExternalSyntheticLambda2 implements Function2 {
    public TextContextMenuHelperApi28$$ExternalSyntheticLambda2(TextClassification arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1, Object arg2) {
        return TextContextMenuHelperApi28.textClassificationItem$lambda$0(this.f$0, ((Composer)arg1), ((Integer)arg2).intValue());
    }
}

