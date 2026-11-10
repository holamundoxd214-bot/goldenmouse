package androidx.compose.foundation.text.selection;

import android.content.Context;
import androidx.compose.foundation.text.contextmenu.builder.TextContextMenuBuilderScope;
import kotlin.jvm.functions.Function2;

public final class SelectionManager_androidKt$$ExternalSyntheticLambda2 implements Function2 {
    public SelectionManager_androidKt$$ExternalSyntheticLambda2(SelectionManager arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1, Object arg2) {
        return SelectionManager_androidKt.addSelectionContainerTextContextMenuComponents$lambda$0(this.f$0, ((TextContextMenuBuilderScope)arg1), ((Context)arg2));
    }
}

