package androidx.core.os;

import android.content.res.Configuration;
import android.os.LocaleList;

public final class ConfigurationCompat {
    class Api24Impl {
        private Api24Impl() {
            super();
        }

        static LocaleList getLocales(Configuration arg0) {
            return arg0.getLocales();
        }

        static void setLocales(Configuration arg0, LocaleListCompat arg1) {
            arg0.setLocales(arg1.unwrap());
        }
    }

    private ConfigurationCompat() {
        super();
    }

    public static LocaleListCompat getLocales(Configuration arg0) {
        return LocaleListCompat.wrap(Api24Impl.getLocales(arg0));
    }

    public static void setLocales(Configuration arg0, LocaleListCompat arg1) {
        Api24Impl.setLocales(arg0, arg1);
    }
}

