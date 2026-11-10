package androidx.core.text;

import android.icu.util.ULocale;
import java.lang.reflect.Method;
import java.util.Locale;

public final class ICUCompat {
    class Api24Impl {
        private Api24Impl() {
            super();
        }

        static ULocale addLikelySubtags(Object arg0) {
            return ULocale.addLikelySubtags(((ULocale)arg0));
        }

        static ULocale forLocale(Locale arg0) {
            return ULocale.forLocale(arg0);
        }

        static String getScript(Object arg0) {
            return ((ULocale)arg0).getScript();
        }
    }

    private static final String TAG = "ICUCompat";
    private static Method sAddLikelySubtagsMethod;

    static {
    }

    private ICUCompat() {
        super();
    }

    public static String maximizeAndGetScript(Locale arg0) {
        return Api24Impl.getScript(Api24Impl.addLikelySubtags(Api24Impl.forLocale(arg0)));
    }
}

