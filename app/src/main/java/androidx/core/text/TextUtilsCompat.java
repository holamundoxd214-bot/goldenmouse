package androidx.core.text;

import android.text.TextUtils;
import java.util.Locale;

public final class TextUtilsCompat {
    private TextUtilsCompat() {
        super();
    }

    public static int getLayoutDirectionFromLocale(Locale arg0) {
        return TextUtils.getLayoutDirectionFromLocale(arg0);
    }

    public static String htmlEncode(String arg0) {
        return TextUtils.htmlEncode(arg0);
    }
}

