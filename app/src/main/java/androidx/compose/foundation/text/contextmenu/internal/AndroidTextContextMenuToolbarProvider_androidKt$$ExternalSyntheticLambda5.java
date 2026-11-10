package androidx.compose.foundation.text.contextmenu.internal;

import androidx.compose.ui.Modifier;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

public final class AndroidTextContextMenuToolbarProvider_androidKt$$ExternalSyntheticLambda5 implements Function2 {
    public AndroidTextContextMenuToolbarProvider_androidKt$$ExternalSyntheticLambda5(Modifier arg1, Function1 arg2, Function2 arg3, int arg4, int arg5) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
        this.f$4 = arg5;
    }

    public final Object invoke(Object arg8, Object arg9) {
        return AndroidTextContextMenuToolbarProvider_androidKt.ProvidePlatformTextContextMenuToolbar$lambda$6(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, arg8, ((Integer)arg9).intValue());
    }
}

