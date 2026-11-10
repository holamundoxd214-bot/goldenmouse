package androidx.compose.foundation.text.contextmenu.internal;

import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider;
import kotlin.jvm.functions.Function0;

public final class AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda0 implements Function0 {
    public AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda0(TextContextMenuDataProvider arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke() {
        return AndroidTextContextMenuToolbarProvider.observeAndGetData$lambda$0(this.f$0);
    }
}

