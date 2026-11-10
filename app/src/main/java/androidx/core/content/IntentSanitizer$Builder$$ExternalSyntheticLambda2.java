package androidx.core.content;

import android.content.ComponentName;
import androidx.core.util.Predicate;

public final class IntentSanitizer$Builder$$ExternalSyntheticLambda2 implements Predicate {
    public IntentSanitizer$Builder$$ExternalSyntheticLambda2(String arg1) {
        super();
        this.f$0 = arg1;
    }

    public final boolean test(Object arg1) {
        return Builder.lambda$allowComponentWithPackage$9(this.f$0, ((ComponentName)arg1));
    }
}

