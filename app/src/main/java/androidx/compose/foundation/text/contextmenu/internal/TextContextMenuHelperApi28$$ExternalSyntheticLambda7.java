package androidx.compose.foundation.text.contextmenu.internal;

import android.graphics.drawable.Drawable;
import androidx.compose.runtime.Composer;
import kotlin.jvm.functions.Function2;

public final class TextContextMenuHelperApi28$$ExternalSyntheticLambda7 implements Function2 {
    public TextContextMenuHelperApi28$$ExternalSyntheticLambda7(TextContextMenuHelperApi28 arg1, Drawable arg2, int arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final Object invoke(Object arg3, Object arg4) {
        return TextContextMenuHelperApi28.IconBox$lambda$4(this.f$0, this.f$1, this.f$2, ((Composer)arg3), ((Integer)arg4).intValue());
    }
}

