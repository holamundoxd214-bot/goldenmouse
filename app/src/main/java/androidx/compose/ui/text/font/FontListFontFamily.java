package androidx.compose.ui.text.font;

import androidx.compose.ui.text.internal.InlineClassHelperKt;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;
import kotlin.Metadata;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\u001E\n\u0002\b\u0005\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010*\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0017\b\u0000\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\t\u001A\u00020\n2\b\u0010\u000B\u001A\u0004\u0018\u00010\fH\u0096\u0002J\b\u0010\r\u001A\u00020\u000EH\u0016J\b\u0010\u000F\u001A\u00020\u0010H\u0016J\u0011\u0010\u0011\u001A\u00020\n2\u0006\u0010\u0012\u001A\u00020\u0003H\u0096\u0003J\u0017\u0010\u0013\u001A\u00020\n2\f\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00030\u0015H\u0096\u0001J\u0011\u0010\u0016\u001A\u00020\u00032\u0006\u0010\u0017\u001A\u00020\u000EH\u0096\u0003J\u0011\u0010\u0018\u001A\u00020\u000E2\u0006\u0010\u0012\u001A\u00020\u0003H\u0096\u0001J\t\u0010\u0019\u001A\u00020\nH\u0096\u0001J\u000F\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u00030\u001BH\u0096\u0003J\u0011\u0010\u001C\u001A\u00020\u000E2\u0006\u0010\u0012\u001A\u00020\u0003H\u0096\u0001J\u000F\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\u00030\u001EH\u0096\u0001J\u0017\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\u00030\u001E2\u0006\u0010\u0017\u001A\u00020\u000EH\u0096\u0001J\u001F\u0010\u001F\u001A\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010 \u001A\u00020\u000E2\u0006\u0010!\u001A\u00020\u000EH\u0096\u0001R\u0017\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0012\u0010\"\u001A\u00020\u000EX\u0096\u0005¢\u0006\u0006\u001A\u0004\b#\u0010$¨\u0006%"}, d2={"Landroidx/compose/ui/text/font/FontListFontFamily;", "Landroidx/compose/ui/text/font/FileBasedFontFamily;", "", "Landroidx/compose/ui/text/font/Font;", "fonts", "<init>", "(Ljava/util/List;)V", "getFonts", "()Ljava/util/List;", "equals", "", "other", "", "hashCode", "", "toString", "", "contains", "element", "containsAll", "elements", "", "get", "index", "indexOf", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "subList", "fromIndex", "toIndex", "size", "getSize", "()I", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class FontListFontFamily extends FileBasedFontFamily implements List, KMappedMarker {
    public static final int $stable;
    private final List fonts;

    static {
    }

    public FontListFontFamily(List arg2) {
        super(null);
        this.fonts = arg2;
        if(((Collection)arg2).isEmpty()) {
            InlineClassHelperKt.throwIllegalStateException("At least one font should be passed to FontFamily");
        }
    }

    public void add(int arg1, Font arg2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void add(int arg1, Object arg2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean add(Font arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean add(Object arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(int arg1, Collection arg2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void addFirst(Font arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void addFirst(Object arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void addLast(Font arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void addLast(Object arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean contains(Font arg1) {
        return this.fonts.contains(arg1);
    }

    public final boolean contains(Object arg2) {
        if(!(arg2 instanceof Font)) {
            return 0;
        }

        return this.contains(((Font)arg2));
    }

    public boolean containsAll(Collection arg1) {
        return this.fonts.containsAll(arg1);
    }

    public boolean equals(Object arg4) {
        if(this == (((FontListFontFamily)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof FontListFontFamily)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.fonts, ((FontListFontFamily)arg4).fonts)) {
            return 0;
        }

        return 1;
    }

    public Font get(int arg1) {
        return this.fonts.get(arg1);
    }

    public Object get(int arg1) {
        return this.get(arg1);
    }

    public final List getFonts() {
        return this.fonts;
    }

    public int getSize() {
        return this.fonts.size();
    }

    public int hashCode() {
        return this.fonts.hashCode();
    }

    public int indexOf(Font arg1) {
        return this.fonts.indexOf(arg1);
    }

    public final int indexOf(Object arg2) {
        if(!(arg2 instanceof Font)) {
            return -1;
        }

        return this.indexOf(((Font)arg2));
    }

    public boolean isEmpty() {
        return this.fonts.isEmpty();
    }

    public Iterator iterator() {
        return this.fonts.iterator();
    }

    public int lastIndexOf(Font arg1) {
        return this.fonts.lastIndexOf(arg1);
    }

    public final int lastIndexOf(Object arg2) {
        if(!(arg2 instanceof Font)) {
            return -1;
        }

        return this.lastIndexOf(((Font)arg2));
    }

    public ListIterator listIterator() {
        return this.fonts.listIterator();
    }

    public ListIterator listIterator(int arg1) {
        return this.fonts.listIterator(arg1);
    }

    public Font remove(int arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object remove(int arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean remove(Object arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Font removeFirst() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object removeFirst() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Font removeLast() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object removeLast() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void replaceAll(UnaryOperator arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Font set(int arg1, Font arg2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object set(int arg1, Object arg2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final int size() {
        return this.getSize();
    }

    public void sort(Comparator arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public List subList(int arg1, int arg2) {
        return this.fonts.subList(arg1, arg2);
    }

    public Object[] toArray() {
        return CollectionToArray.toArray(((Collection)this));
    }

    public Object[] toArray(Object[] arg1) {
        return CollectionToArray.toArray(((Collection)this), arg1);
    }

    public String toString() {
        return "FontListFontFamily(fonts=" + this.fonts + ')';
    }
}

