package androidx.compose.foundation.text.contextmenu.internal;

import androidx.compose.foundation.text.contextmenu.provider.BasicTextContextMenuProvider;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Modifier;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

public final class PlatformDefaultTextContextMenuProviders_androidKt$$ExternalSyntheticLambda1 implements Function2 {
    public PlatformDefaultTextContextMenuProviders_androidKt$$ExternalSyntheticLambda1(Modifier arg1, MutableState arg2, Function2 arg3, BasicTextContextMenuProvider arg4, Function0 arg5) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
        this.f$4 = arg5;
    }

    public final Object invoke(Object arg8, Object arg9) {
        return PlatformDefaultTextContextMenuProviders_androidKt.ProvideBothDefaultProviders$lambda$4(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, arg8, ((Integer)arg9).intValue());
    }
}

