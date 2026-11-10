package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2={"Landroidx/compose/material3/SearchBarValue;", "", "<init>", "(Ljava/lang/String;I)V", "Collapsed", "Expanded", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public enum SearchBarValue {
    public static final enum SearchBarValue Collapsed;
    public static final enum SearchBarValue Expanded;

    private static final SearchBarValue[] $values() {
        return new SearchBarValue[]{SearchBarValue.Collapsed, SearchBarValue.Expanded};
    }

    static {
        SearchBarValue.Collapsed = new SearchBarValue("Collapsed", 0);
        SearchBarValue.Expanded = new SearchBarValue("Expanded", 1);
        SearchBarValue[] v0 = SearchBarValue.$values();
        SearchBarValue.$VALUES = v0;
        SearchBarValue.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private SearchBarValue(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return SearchBarValue.$ENTRIES;
    }

    public static SearchBarValue valueOf(String arg1) {
        return Enum.valueOf(SearchBarValue.class, arg1);
    }

    public static SearchBarValue[] values() {
        return SearchBarValue.$VALUES.clone();
    }
}

