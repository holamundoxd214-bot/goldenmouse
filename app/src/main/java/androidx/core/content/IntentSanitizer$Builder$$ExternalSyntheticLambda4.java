package androidx.core.content;

import androidx.core.util.Predicate;

public final class IntentSanitizer$Builder$$ExternalSyntheticLambda4 implements Predicate {
    public IntentSanitizer$Builder$$ExternalSyntheticLambda4(Class arg1, Predicate arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final boolean test(Object arg2) {
        return Builder.lambda$allowExtra$13(this.f$0, this.f$1, arg2);
    }
}

