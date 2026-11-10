package androidx.core.content;

import android.content.UriMatcher;
import android.net.Uri;
import androidx.core.util.Predicate;

public final class UriMatcherCompat$$ExternalSyntheticLambda0 implements Predicate {
    public UriMatcherCompat$$ExternalSyntheticLambda0(UriMatcher arg1) {
        super();
        this.f$0 = arg1;
    }

    public final boolean test(Object arg1) {
        return UriMatcherCompat.lambda$asPredicate$0(this.f$0, ((Uri)arg1));
    }
}

