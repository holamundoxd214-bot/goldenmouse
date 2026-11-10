package androidx.compose.foundation.text.contextmenu.provider;

import androidx.compose.runtime.Composer;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

public final class BasicTextContextMenuProvider$$ExternalSyntheticLambda0 implements Function2 {
    public BasicTextContextMenuProvider$$ExternalSyntheticLambda0(BasicTextContextMenuProvider arg1, Function0 arg2, int arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final Object invoke(Object arg3, Object arg4) {
        return BasicTextContextMenuProvider.ContextMenu$lambda$0(this.f$0, this.f$1, this.f$2, ((Composer)arg3), ((Integer)arg4).intValue());
    }
}

