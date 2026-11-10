package androidx.core.content;

import android.content.UriMatcher;
import android.net.Uri;
import androidx.core.util.Predicate;

public class UriMatcherCompat {
    private UriMatcherCompat() {
        super();
    }

    public static Predicate asPredicate(UriMatcher arg1) {
        return new UriMatcherCompat$$ExternalSyntheticLambda0(arg1);
    }

    static boolean lambda$asPredicate$0(UriMatcher arg0, Uri arg1) {
        if(arg0.match(arg1) != -1) {
            return 1;
        }

        return 0;
    }
}

