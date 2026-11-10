package androidx.compose.foundation.text.contextmenu.internal;

import android.app.RemoteAction;
import androidx.compose.runtime.Composer;
import kotlin.jvm.functions.Function2;

public final class TextContextMenuHelperApi28$$ExternalSyntheticLambda4 implements Function2 {
    public TextContextMenuHelperApi28$$ExternalSyntheticLambda4(RemoteAction arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1, Object arg2) {
        return TextContextMenuHelperApi28.textClassificationItem$lambda$3(this.f$0, ((Composer)arg1), ((Integer)arg2).intValue());
    }
}

