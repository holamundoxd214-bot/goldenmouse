package androidx.compose.foundation.text.contextmenu.internal;

import androidx.compose.ui.Modifier;
import kotlin.jvm.functions.Function2;

public final class AndroidTextContextMenuToolbarProvider_androidKt$$ExternalSyntheticLambda0 implements Function2 {
    public AndroidTextContextMenuToolbarProvider_androidKt$$ExternalSyntheticLambda0(Modifier arg1, Function2 arg2, int arg3, int arg4) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
    }

    public final Object invoke(Object arg7, Object arg8) {
        return AndroidTextContextMenuToolbarProvider_androidKt.ProvidePlatformTextContextMenuToolbar$lambda$0(this.f$0, this.f$1, this.f$2, this.f$3, arg7, ((Integer)arg8).intValue());
    }
}

