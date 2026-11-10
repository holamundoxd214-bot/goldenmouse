package androidx.compose.foundation.text.contextmenu.internal;

import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSession;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

public final class DefaultTextContextMenuDropdownProvider_androidKt$$ExternalSyntheticLambda2 implements Function2 {
    public DefaultTextContextMenuDropdownProvider_androidKt$$ExternalSyntheticLambda2(TextContextMenuSession arg1, TextContextMenuDataProvider arg2, Function0 arg3, int arg4) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
    }

    public final Object invoke(Object arg7, Object arg8) {
        return DefaultTextContextMenuDropdownProvider_androidKt.OpenContextMenu$lambda$3(this.f$0, this.f$1, this.f$2, this.f$3, arg7, ((Integer)arg8).intValue());
    }
}

