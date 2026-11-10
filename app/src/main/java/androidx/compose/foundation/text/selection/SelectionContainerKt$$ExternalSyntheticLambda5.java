package androidx.compose.foundation.text.selection;

import androidx.compose.ui.platform.Clipboard;
import androidx.compose.ui.text.AnnotatedString;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;

public final class SelectionContainerKt$$ExternalSyntheticLambda5 implements Function1 {
    public SelectionContainerKt$$ExternalSyntheticLambda5(CoroutineScope arg1, Clipboard arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return SelectionContainerKt.$r8$lambda$syYRcAulwyDVp840vp4uR2xJiQ4(this.f$0, this.f$1, ((AnnotatedString)arg2));
    }
}

