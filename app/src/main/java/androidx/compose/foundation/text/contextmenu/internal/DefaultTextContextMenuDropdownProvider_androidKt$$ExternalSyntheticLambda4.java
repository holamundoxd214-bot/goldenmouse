package androidx.compose.foundation.text.contextmenu.internal;

import androidx.compose.foundation.text.contextmenu.data.TextContextMenuData;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSession;
import androidx.compose.runtime.Composer;
import kotlin.jvm.functions.Function2;

public final class DefaultTextContextMenuDropdownProvider_androidKt$$ExternalSyntheticLambda4 implements Function2 {
    public DefaultTextContextMenuDropdownProvider_androidKt$$ExternalSyntheticLambda4(TextContextMenuSession arg1, TextContextMenuData arg2, int arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final Object invoke(Object arg3, Object arg4) {
        return DefaultTextContextMenuDropdownProvider_androidKt.DefaultTextContextMenuDropdown$lambda$1(this.f$0, this.f$1, this.f$2, ((Composer)arg3), ((Integer)arg4).intValue());
    }
}

