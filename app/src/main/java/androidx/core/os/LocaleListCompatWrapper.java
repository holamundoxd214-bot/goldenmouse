package androidx.core.os;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

final class LocaleListCompatWrapper implements LocaleListInterface {
    private static final Locale EN_LATN;
    private static final Locale LOCALE_AR_XB;
    private static final Locale LOCALE_EN_XA;
    private final Locale[] mList;
    private final String mStringRepresentation;
    private static final Locale[] sEmptyList;

    static {
        LocaleListCompatWrapper.sEmptyList = new Locale[0];
        LocaleListCompatWrapper.LOCALE_EN_XA = new Locale("en", "XA");
        LocaleListCompatWrapper.LOCALE_AR_XB = new Locale("ar", "XB");
        LocaleListCompatWrapper.EN_LATN = LocaleListCompat.forLanguageTagCompat("en-Latn");
    }

    LocaleListCompatWrapper(Locale[] arg8) {
        super();
        if(arg8.length == 0) {
            this.mList = LocaleListCompatWrapper.sEmptyList;
            this.mStringRepresentation = "";
            return;
        }

        ArrayList v0 = new ArrayList();
        HashSet v1 = new HashSet();
        StringBuilder v2 = new StringBuilder();
        int v4;
        for(v4 = 0; true; ++v4) {
            if(v4 >= arg8.length) {
                goto label_43;
            }

            Locale v5 = arg8[v4];
            if(v5 == null) {
                break;
            }

            if(!v1.contains(v5)) {
                Object v5_1 = v5.clone();
                ((List)v0).add(v5_1);
                LocaleListCompatWrapper.toLanguageTag(v2, ((Locale)v5_1));
                if(v4 < arg8.length - 1) {
                    v2.append(',');
                }

                v1.add(v5_1);
            }
        }

        throw new NullPointerException("list[" + v4 + "] is null");
    label_43:
        this.mList = ((List)v0).toArray(new Locale[0]);
        this.mStringRepresentation = v2.toString();
    }

    private Locale computeFirstMatch(Collection arg1, boolean arg2) {
        int v1 = this.computeFirstMatchIndex(arg1, arg2);
        if(v1 == -1) {
            return null;
        }

        return this.mList[v1];
    }

    private int computeFirstMatchIndex(Collection arg5, boolean arg6) {
        int v6;
        Locale[] v0 = this.mList;
        if(v0.length == 1) {
            return 0;
        }

        if(v0.length == 0) {
            return -1;
        }

        int v0_1 = 0x7FFFFFFF;
        if(arg6) {
            v6 = this.findFirstMatchIndex(LocaleListCompatWrapper.EN_LATN);
            if(v6 == 0) {
                return 0;
            }
            else if(v6 < v0_1) {
            }
            else {
                goto label_18;
            }
        }
        else {
        label_18:
            v6 = v0_1;
        }

        Iterator v5 = arg5.iterator();
        while(v5.hasNext()) {
            int v1 = this.findFirstMatchIndex(LocaleListCompat.forLanguageTagCompat(v5.next()));
            if(v1 == 0) {
                return 0;
            }

            if(v1 >= v6) {
                continue;
            }

            v6 = v1;
        }

        if(v6 == v0_1) {
            return 0;
        }

        return v6;
    }

    public boolean equals(Object arg6) {
        if((((LocaleListCompatWrapper)arg6)) == this) {
            return 1;
        }

        if(!(arg6 instanceof LocaleListCompatWrapper)) {
            return 0;
        }

        Locale[] v6 = ((LocaleListCompatWrapper)arg6).mList;
        if(this.mList.length != v6.length) {
            return 0;
        }

        int v1;
        for(v1 = 0; true; ++v1) {
            Locale[] v3 = this.mList;
            if(v1 >= v3.length) {
                return 1;
            }

            if(!v3[v1].equals(v6[v1])) {
                return 0;
            }
        }

        return 1;
    }

    private int findFirstMatchIndex(Locale arg4) {
        int v0;
        for(v0 = 0; true; ++v0) {
            Locale[] v1 = this.mList;
            if(v0 >= v1.length) {
                return 0x7FFFFFFF;
            }

            if(LocaleListCompatWrapper.matchScore(arg4, v1[v0]) > 0) {
                return v0;
            }
        }

        return 0x7FFFFFFF;
    }

    public Locale get(int arg2) {
        if(arg2 >= 0) {
            Locale[] v1 = this.mList;
            if(arg2 < v1.length) {
                return v1[arg2];
            }
        }

        return null;
    }

    public Locale getFirstMatch(String[] arg2) {
        return this.computeFirstMatch(Arrays.asList(((Object[])arg2)), false);
    }

    private static String getLikelyScript(Locale arg1) {
        String v1 = arg1.getScript();
        if(!v1.isEmpty()) {
            return v1;
        }

        return "";
    }

    public Object getLocaleList() {
        return null;
    }

    public int hashCode() {
        Locale[] v4 = this.mList;
        int v0 = v4.length;
        int v1 = 1;
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            v1 = v1 * 0x1F + v4[v2].hashCode();
        }

        return v1;
    }

    public int indexOf(Locale arg4) {
        int v0;
        for(v0 = 0; true; ++v0) {
            Locale[] v1 = this.mList;
            if(v0 >= v1.length) {
                return -1;
            }

            if(v1[v0].equals(arg4)) {
                return v0;
            }
        }

        return -1;
    }

    public boolean isEmpty() {
        if(this.mList.length == 0) {
            return 1;
        }

        return 0;
    }

    private static boolean isPseudoLocale(Locale arg1) {
        if(!LocaleListCompatWrapper.LOCALE_EN_XA.equals(arg1)) {
            if(LocaleListCompatWrapper.LOCALE_AR_XB.equals(arg1)) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    private static int matchScore(Locale arg4, Locale arg5) {
        if(arg4.equals(arg5)) {
            return 1;
        }

        if(!arg4.getLanguage().equals(arg5.getLanguage())) {
            return 0;
        }

        if(!LocaleListCompatWrapper.isPseudoLocale(arg4)) {
            if(LocaleListCompatWrapper.isPseudoLocale(arg5)) {
            }
            else {
                String v0 = LocaleListCompatWrapper.getLikelyScript(arg4);
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
                    return v0.equals(LocaleListCompatWrapper.getLikelyScript(arg5));
                }
            }
        }

        return 0;
    }

    public int size() {
        return this.mList.length;
    }

    static void toLanguageTag(StringBuilder arg1, Locale arg2) {
        arg1.append(arg2.getLanguage());
        String v0 = arg2.getCountry();
        if(v0 != null && !v0.isEmpty()) {
            arg1.append('-');
            arg1.append(arg2.getCountry());
        }
    }

    public String toLanguageTags() {
        return this.mStringRepresentation;
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder("[");
        int v1;
        for(v1 = 0; true; ++v1) {
            Locale[] v2 = this.mList;
            if(v1 >= v2.length) {
                break;
            }

            v0.append(v2[v1]);
            if(v1 < this.mList.length - 1) {
                v0.append(',');
            }
        }

        v0.append("]");
        return v0.toString();
    }
}

