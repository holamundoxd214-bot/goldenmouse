package androidx.compose.foundation.text.contextmenu.internal;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Modifier;
import kotlin.jvm.functions.Function2;

public final class AndroidTextContextMenuToolbarProvider_androidKt$$ExternalSyntheticLambda4 implements Function2 {
    public AndroidTextContextMenuToolbarProvider_androidKt$$ExternalSyntheticLambda4(Modifier arg1, MutableState arg2, Function2 arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final Object invoke(Object arg3, Object arg4) {
        return AndroidTextContextMenuToolbarProvider_androidKt.ProvidePlatformTextContextMenuToolbar$lambda$5(this.f$0, this.f$1, this.f$2, ((Composer)arg3), ((Integer)arg4).intValue());
    }
}

