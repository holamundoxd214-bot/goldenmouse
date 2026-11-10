package androidx.compose.foundation.text.contextmenu.internal;

import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSession;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider;
import androidx.compose.runtime.Composer;
import kotlin.jvm.functions.Function2;

public final class DefaultTextContextMenuDropdownProvider_androidKt$$ExternalSyntheticLambda1 implements Function2 {
    public DefaultTextContextMenuDropdownProvider_androidKt$$ExternalSyntheticLambda1(TextContextMenuDataProvider arg1, TextContextMenuSession arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2, Object arg3) {
        return DefaultTextContextMenuDropdownProvider_androidKt.OpenContextMenu$lambda$2(this.f$0, this.f$1, ((Composer)arg2), ((Integer)arg3).intValue());
    }
}

