package androidx.compose.material3;

import androidx.compose.ui.focus.FocusState;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;

public final class SearchBarDefaults$$ExternalSyntheticLambda13 implements Function1 {
    public SearchBarDefaults$$ExternalSyntheticLambda13(boolean arg1, CoroutineScope arg2, SearchBarState arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final Object invoke(Object arg3) {
        return SearchBarDefaults.InputField$lambda$9$lambda$8(this.f$0, this.f$1, this.f$2, ((FocusState)arg3));
    }
}

