package androidx.core.content;

import android.content.ContentProvider;
import android.content.Context;

public final class ContentProviderCompat {
    private ContentProviderCompat() {
        super();
    }

    public static Context requireContext(ContentProvider arg1) {
        Context v1 = arg1.getContext();
        if(v1 != null) {
            return v1;
        }

        throw new IllegalStateException("Cannot find context from the provider.");
    }
}

