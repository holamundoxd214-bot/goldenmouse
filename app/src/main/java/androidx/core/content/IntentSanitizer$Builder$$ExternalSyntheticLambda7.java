package androidx.core.content;

import android.net.Uri;
import androidx.core.util.Predicate;

public final class IntentSanitizer$Builder$$ExternalSyntheticLambda7 implements Predicate {
    public IntentSanitizer$Builder$$ExternalSyntheticLambda7(String arg1) {
        super();
        this.f$0 = arg1;
    }

    public final boolean test(Object arg1) {
        return Builder.lambda$allowClipDataUriWithAuthority$11(this.f$0, ((Uri)arg1));
    }
}

