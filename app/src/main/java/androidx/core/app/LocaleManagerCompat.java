package androidx.core.app;

import android.app.LocaleManager;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build$VERSION;
import android.os.LocaleList;
import androidx.core.os.LocaleListCompat;

public final class LocaleManagerCompat {
    class Api24Impl {
        private Api24Impl() {
            super();
        }

        static LocaleListCompat getLocales(Configuration arg0) {
            return LocaleListCompat.forLanguageTags(arg0.getLocales().toLanguageTags());
        }
    }

    class Api33Impl {
        private Api33Impl() {
            super();
        }

        static LocaleList localeManagerGetApplicationLocales(Object arg0) {
            return ((LocaleManager)arg0).getApplicationLocales();
        }

        static LocaleList localeManagerGetSystemLocales(Object arg0) {
            return ((LocaleManager)arg0).getSystemLocales();
        }
    }

    private LocaleManagerCompat() {
        super();
    }

    public static LocaleListCompat getApplicationLocales(Context arg2) {
        if(Build$VERSION.SDK_INT >= 33) {
            Object v2 = LocaleManagerCompat.getLocaleManagerForApplication(arg2);
            if(v2 != null) {
                return LocaleListCompat.wrap(Api33Impl.localeManagerGetApplicationLocales(v2));
            }

            return LocaleListCompat.getEmptyLocaleList();
        }

        return LocaleListCompat.forLanguageTags(AppLocalesStorageHelper.readLocales(arg2));
    }

    static LocaleListCompat getConfigurationLocales(Configuration arg0) {
        return Api24Impl.getLocales(arg0);
    }

    private static Object getLocaleManagerForApplication(Context arg1) {
        return arg1.getSystemService("locale");
    }

    public static LocaleListCompat getSystemLocales(Context arg3) {
        LocaleListCompat v0 = LocaleListCompat.getEmptyLocaleList();
        if(Build$VERSION.SDK_INT >= 33) {
            Object v3 = LocaleManagerCompat.getLocaleManagerForApplication(arg3);
            if(v3 != null) {
                return LocaleListCompat.wrap(Api33Impl.localeManagerGetSystemLocales(v3));
            }

            return v0;
        }

        return LocaleManagerCompat.getConfigurationLocales(Resources.getSystem().getConfiguration());
    }
}

