package androidx.core.os;

import android.os.LocaleList;
import java.util.Locale;

final class LocaleListPlatformWrapper implements LocaleListInterface {
    private final LocaleList mLocaleList;

    LocaleListPlatformWrapper(Object arg1) {
        super();
        this.mLocaleList = ((LocaleList)arg1);
    }

    public boolean equals(Object arg1) {
        return this.mLocaleList.equals(((LocaleListInterface)arg1).getLocaleList());
    }

    public Locale get(int arg1) {
        return this.mLocaleList.get(arg1);
    }

    public Locale getFirstMatch(String[] arg1) {
        return this.mLocaleList.getFirstMatch(arg1);
    }

    public Object getLocaleList() {
        return this.mLocaleList;
    }

    public int hashCode() {
        return this.mLocaleList.hashCode();
    }

    public int indexOf(Locale arg1) {
        return this.mLocaleList.indexOf(arg1);
    }

    public boolean isEmpty() {
        return this.mLocaleList.isEmpty();
    }

    public int size() {
        return this.mLocaleList.size();
    }

    public String toLanguageTags() {
        return this.mLocaleList.toLanguageTags();
    }

    public String toString() {
        return this.mLocaleList.toString();
    }
}

