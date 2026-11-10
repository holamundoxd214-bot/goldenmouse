package androidx.compose.ui.text.intl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u001E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B\u0015\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\u0005\u0010\tB\u001D\b\u0016\u0012\u0012\u0010\n\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u000B\"\u00020\u0002¢\u0006\u0004\b\u0005\u0010\fJ\u0011\u0010\u000F\u001A\u00020\u00022\u0006\u0010\u0010\u001A\u00020\u0011H\u0086\u0002J\u0011\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u0002H\u0096\u0002J\u0016\u0010\u0018\u001A\u00020\u00162\f\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016J\b\u0010\u001A\u001A\u00020\u0016H\u0016J\u000F\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u00020\u001CH\u0096\u0002J\u0013\u0010\u001D\u001A\u00020\u00162\b\u0010\u001E\u001A\u0004\u0018\u00010\u001FH\u0096\u0002J\b\u0010 \u001A\u00020\u0011H\u0016J\b\u0010!\u001A\u00020\bH\u0016R\u0017\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0014\u0010\u0012\u001A\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014¨\u0006#"}, d2={"Landroidx/compose/ui/text/intl/LocaleList;", "", "Landroidx/compose/ui/text/intl/Locale;", "localeList", "", "<init>", "(Ljava/util/List;)V", "languageTags", "", "(Ljava/lang/String;)V", "locales", "", "([Landroidx/compose/ui/text/intl/Locale;)V", "getLocaleList", "()Ljava/util/List;", "get", "i", "", "size", "getSize", "()I", "contains", "", "element", "containsAll", "elements", "isEmpty", "iterator", "", "equals", "other", "", "hashCode", "toString", "Companion", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LocaleList implements Collection, KMappedMarker {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\b\t\u0010\u0007¨\u0006\n"}, d2={"Landroidx/compose/ui/text/intl/LocaleList$Companion;", "", "<init>", "()V", "Empty", "Landroidx/compose/ui/text/intl/LocaleList;", "getEmpty", "()Landroidx/compose/ui/text/intl/LocaleList;", "current", "getCurrent", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final LocaleList getCurrent() {
            return PlatformLocaleKt.getPlatformLocaleDelegate().getCurrent();
        }

        public final LocaleList getEmpty() {
            return LocaleList.Empty;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final LocaleList Empty;
    private final List localeList;
    private final int size;

    static {
        LocaleList.Companion = new Companion(null);
        LocaleList.Empty = new LocaleList(CollectionsKt.emptyList());
    }

    public LocaleList(List arg1) {
        super();
        this.localeList = arg1;
        this.size = arg1.size();
    }

    public LocaleList(String arg8) {
        String[] v1 = new String[1];
        int v6 = 0;
        v1[0] = ",";
        List v8 = StringsKt.split$default(arg8, v1, false, 0, 6, null);
        ArrayList v0 = new ArrayList(v8.size());
        int v1_1 = v8.size();
        int v2;
        for(v2 = 0; v2 < v1_1; ++v2) {
            v0.add(StringsKt.trim(v8.get(v2)).toString());
        }

        ArrayList v8_1 = new ArrayList(((List)v0).size());
        v1_1 = v0.size();
        while(v6 < v1_1) {
            v8_1.add(new Locale(((List)v0).get(v6)));
            ++v6;
        }

        this(((List)v8_1));
    }

    public LocaleList(Locale[] arg1) {
        this(ArraysKt.toList(((Object[])arg1)));
    }

    public static final LocaleList access$getEmpty$cp() {
        return LocaleList.Empty;
    }

    public boolean add(Locale arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean add(Object arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean contains(Locale arg1) {
        return this.localeList.contains(arg1);
    }

    public final boolean contains(Object arg2) {
        if(!(arg2 instanceof Locale)) {
            return 0;
        }

        return this.contains(((Locale)arg2));
    }

    public boolean containsAll(Collection arg1) {
        return this.localeList.containsAll(arg1);
    }

    public boolean equals(Object arg4) {
        if(this == (((LocaleList)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof LocaleList)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.localeList, ((LocaleList)arg4).localeList)) {
            return 0;
        }

        return 1;
    }

    public final Locale get(int arg1) {
        return this.localeList.get(arg1);
    }

    public final List getLocaleList() {
        return this.localeList;
    }

    public int getSize() {
        return this.size;
    }

    public int hashCode() {
        return this.localeList.hashCode();
    }

    public boolean isEmpty() {
        return this.localeList.isEmpty();
    }

    public Iterator iterator() {
        return this.localeList.iterator();
    }

    public boolean remove(Object arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeIf(Predicate arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final int size() {
        return this.getSize();
    }

    public Object[] toArray() {
        return CollectionToArray.toArray(((Collection)this));
    }

    public Object[] toArray(Object[] arg1) {
        return CollectionToArray.toArray(((Collection)this), arg1);
    }

    public String toString() {
        return "LocaleList(localeList=" + this.localeList + ')';
    }
}

