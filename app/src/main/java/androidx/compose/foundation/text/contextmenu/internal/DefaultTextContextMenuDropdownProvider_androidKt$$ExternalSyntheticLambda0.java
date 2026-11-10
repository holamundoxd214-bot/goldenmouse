package androidx.compose.foundation.text.contextmenu.internal;

import androidx.compose.runtime.Composer;
import kotlin.jvm.functions.Function2;

public final class DefaultTextContextMenuDropdownProvider_androidKt$$ExternalSyntheticLambda0 implements Function2 {
    public DefaultTextContextMenuDropdownProvider_androidKt$$ExternalSyntheticLambda0(Function2 arg1, int arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2, Object arg3) {
        return DefaultTextContextMenuDropdownProvider_androidKt.ProvideDefaultTextContextMenuDropdown$lambda$0(this.f$0, this.f$1, ((Composer)arg2), ((Integer)arg3).intValue());
    }
}

