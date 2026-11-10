package androidx.compose.foundation.text.contextmenu.provider;

import androidx.compose.runtime.ProvidableCompositionLocal;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;

public final class BasicTextContextMenuProviderKt$$ExternalSyntheticLambda0 implements Function2 {
    public BasicTextContextMenuProviderKt$$ExternalSyntheticLambda0(ProvidableCompositionLocal arg1, Function5 arg2, Function2 arg3, int arg4) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
    }

    public final Object invoke(Object arg7, Object arg8) {
        return BasicTextContextMenuProviderKt.ProvideBasicTextContextMenu$lambda$0(this.f$0, this.f$1, this.f$2, this.f$3, arg7, ((Integer)arg8).intValue());
    }
}

