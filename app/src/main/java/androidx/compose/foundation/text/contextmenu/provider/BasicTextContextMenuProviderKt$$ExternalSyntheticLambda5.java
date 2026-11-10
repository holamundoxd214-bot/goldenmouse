package androidx.compose.foundation.text.contextmenu.provider;

import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.Modifier;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;

public final class BasicTextContextMenuProviderKt$$ExternalSyntheticLambda5 implements Function2 {
    public BasicTextContextMenuProviderKt$$ExternalSyntheticLambda5(Modifier arg1, ProvidableCompositionLocal arg2, Function5 arg3, Function2 arg4, int arg5) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
        this.f$4 = arg5;
    }

    public final Object invoke(Object arg8, Object arg9) {
        return BasicTextContextMenuProviderKt.ProvideBasicTextContextMenu$lambda$5(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, arg8, ((Integer)arg9).intValue());
    }
}

