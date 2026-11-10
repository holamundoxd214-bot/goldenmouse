package androidx.core.os;

import android.os.Build$VERSION;
import android.os.LocaleList;
import androidx.core.text.ICUCompat;
import java.util.Locale;

public final class LocaleListCompat {
    class Api21Impl {
        private static final Locale[] PSEUDO_LOCALE;

        static {
            Api21Impl.PSEUDO_LOCALE = new Locale[]{new Locale("en", "XA"), new Locale("ar", "XB")};
        }

        private Api21Impl() {
            super();
        }

        private static boolean isPseudoLocale(Locale arg5) {
            Locale[] v0 = Api21Impl.PSEUDO_LOCALE;
            int v1 = v0.length;
            int v3;
            for(v3 = 0; v3 < v1; ++v3) {
                if(v0[v3].equals(arg5)) {
                    return 1;
                }
            }

            return 0;
        }

        static boolean matchesLanguageAndScript(Locale arg4, Locale arg5) {
            if(arg4.equals(arg5)) {
                return 1;
            }

            if(!arg4.getLanguage().equals(arg5.getLanguage())) {
                return 0;
            }

            if(!Api21Impl.isPseudoLocale(arg4)) {
                if(Api21Impl.isPseudoLocale(arg5)) {
                }
                else {
                    String v0 = ICUCompat.maximizeAndGetScript(arg4);
                    if(v0.isEmpty()) {
                        String v4 = arg4.getCountry();
                        if(!v4.isEmpty()) {
                            if(v4.equals(arg5.getCountry())) {
                            }
                            else {
                                return 0;
                            }
                        }

                        return 1;
                    }
                    else {
                        return v0.equals(ICUCompat.maximizeAndGetScript(arg5));
                    }
                }
            }

            return 0;
        }
    }

    class Api24Impl {
        private Api24Impl() {
            super();
        }

        static LocaleList createLocaleList(Locale[] arg1) {
            return new LocaleList(arg1);
        }

        static LocaleList getAdjustedDefault() {
            return LocaleList.getAdjustedDefault();
        }

        static LocaleList getDefault() {
            return LocaleList.getDefault();
        }
    }

    private final LocaleListInterface mImpl;
    private static final LocaleListCompat sEmptyLocaleList;

    static {
        LocaleListCompat.sEmptyLocaleList = LocaleListCompat.create(new Locale[0]);
    }

    private LocaleListCompat(LocaleListInterface arg1) {
        super();
        this.mImpl = arg1;
    }

    public static LocaleListCompat create(Locale[] arg0) {
        return LocaleListCompat.wrap(Api24Impl.createLocaleList(arg0));
    }

    public boolean equals(Object arg2) {
        if(((arg2 instanceof LocaleListCompat)) && (this.mImpl.equals(((LocaleListCompat)arg2).mImpl))) {
            return 1;
        }

        return 0;
    }

    static Locale forLanguageTagCompat(String arg6) {
        String[] v0_1;
        String v0 = "-";
        int v2 = -1;
        int v3 = 2;
        if(arg6.contains(((CharSequence)v0))) {
            v0_1 = arg6.split(v0, v2);
            if(v0_1.length > v3) {
                return new Locale(v0_1[0], v0_1[1], v0_1[v3]);
            }
            else if(v0_1.length > 1) {
                return new Locale(v0_1[0], v0_1[1]);
            }
            else if(v0_1.length == 1) {
                return new Locale(v0_1[0]);
            }
        }
        else {
            v0 = "_";
            if(arg6.contains(((CharSequence)v0))) {
                v0_1 = arg6.split(v0, v2);
                if(v0_1.length > v3) {
                    return new Locale(v0_1[0], v0_1[1], v0_1[v3]);
                }
                else if(v0_1.length > 1) {
                    return new Locale(v0_1[0], v0_1[1]);
                }
                else if(v0_1.length == 1) {
                    return new Locale(v0_1[0]);
                }
            }
            else {
                goto label_64;
            }
        }

        throw new IllegalArgumentException("Can not parse language tag: [" + arg6 + "]");
    label_64:
        return new Locale(arg6);
    }

    public static LocaleListCompat forLanguageTags(String arg4) {
        if(arg4 != null) {
            if(arg4.isEmpty()) {
            }
            else {
                String[] v4 = arg4.split(",", -1);
                int v0 = v4.length;
                Locale[] v1 = new Locale[v0];
                int v2;
                for(v2 = 0; v2 < v0; ++v2) {
                    v1[v2] = Locale.forLanguageTag(v4[v2]);
                }

                return LocaleListCompat.create(v1);
            }
        }

        return LocaleListCompat.getEmptyLocaleList();
    }

    public Locale get(int arg1) {
        return this.mImpl.get(arg1);
    }

    public static LocaleListCompat getAdjustedDefault() {
        return LocaleListCompat.wrap(Api24Impl.getAdjustedDefault());
    }

    public static LocaleListCompat getDefault() {
        return LocaleListCompat.wrap(Api24Impl.getDefault());
    }

    public static LocaleListCompat getEmptyLocaleList() {
        return LocaleListCompat.sEmptyLocaleList;
    }

    public Locale getFirstMatch(String[] arg1) {
        return this.mImpl.getFirstMatch(arg1);
    }

    public int hashCode() {
        return this.mImpl.hashCode();
    }

    public int indexOf(Locale arg1) {
        return this.mImpl.indexOf(arg1);
    }

    public boolean isEmpty() {
        return this.mImpl.isEmpty();
    }

    public static boolean matchesLanguageAndScript(Locale arg2, Locale arg3) {
        if(Build$VERSION.SDK_INT >= 33) {
            return LocaleList.matchesLanguageAndScript(arg2, arg3);
        }

        return Api21Impl.matchesLanguageAndScript(arg2, arg3);
    }

    public int size() {
        return this.mImpl.size();
    }

    public String toLanguageTags() {
        return this.mImpl.toLanguageTags();
    }

    public String toString() {
        return this.mImpl.toString();
    }

    public Object unwrap() {
        return this.mImpl.getLocaleList();
    }

    public static LocaleListCompat wrap(LocaleList arg2) {
        return new LocaleListCompat(new LocaleListPlatformWrapper(arg2));
    }

    @Deprecated public static LocaleListCompat wrap(Object arg0) {
        return LocaleListCompat.wrap(((LocaleList)arg0));
    }
}

