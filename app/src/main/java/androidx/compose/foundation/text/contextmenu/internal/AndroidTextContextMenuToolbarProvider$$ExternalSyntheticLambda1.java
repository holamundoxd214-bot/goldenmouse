package androidx.compose.foundation.text.contextmenu.internal;

import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider;
import kotlin.jvm.functions.Function0;

public final class AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda1 implements Function0 {
    public AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda1(AndroidTextContextMenuToolbarProvider arg1, TextContextMenuDataProvider arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke() {
        return AndroidTextContextMenuToolbarProvider.createActionModeCallback$lambda$0(this.f$0, this.f$1);
    }
}

