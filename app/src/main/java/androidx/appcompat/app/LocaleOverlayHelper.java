package androidx.appcompat.app;

import android.os.LocaleList;
import androidx.core.os.LocaleListCompat;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;

final class LocaleOverlayHelper {
    private LocaleOverlayHelper() {
        super();
    }

    private static LocaleListCompat combineLocales(LocaleListCompat arg4, LocaleListCompat arg5) {
        LinkedHashSet v0 = new LinkedHashSet();
        int v1;
        for(v1 = 0; v1 < arg4.size() + arg5.size(); ++v1) {
            Locale v2 = v1 < arg4.size() ? arg4.get(v1) : arg5.get(v1 - arg4.size());
            if(v2 != null) {
                ((Set)v0).add(v2);
            }
        }

        return LocaleListCompat.create(((Set)v0).toArray(new Locale[((Set)v0).size()]));
    }

    static LocaleListCompat combineLocalesIfOverlayExists(LocaleListCompat arg1, LocaleListCompat arg2) {
        if(arg1 != null) {
            if(arg1.isEmpty()) {
            }
            else {
                return LocaleOverlayHelper.combineLocales(arg1, arg2);
            }
        }

        return LocaleListCompat.getEmptyLocaleList();
    }

    static LocaleListCompat combineLocalesIfOverlayExists(LocaleList arg1, LocaleList arg2) {
        if(arg1 != null) {
            if(arg1.isEmpty()) {
            }
            else {
                return LocaleOverlayHelper.combineLocales(LocaleListCompat.wrap(arg1), LocaleListCompat.wrap(arg2));
            }
        }

        return LocaleListCompat.getEmptyLocaleList();
    }
}

