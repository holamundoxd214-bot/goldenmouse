package androidx.compose.runtime.snapshots;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.markers.KMutableIterator;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B#\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u001C\u001A\u00020\u001DH\u0096\u0002J\u000E\u0010\u0013\u001A\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u000FJ\b\u0010\u001E\u001A\u00020\u001FH\u0016J\b\u0010 \u001A\u00020\u001FH\u0002J\"\u0010!\u001A\u0002H\u0001\"\u0004\b\u0001\u0010\u00012\f\u0010\"\u001A\b\u0012\u0004\u0012\u0002H\u00010#H\u0082\b¢\u0006\u0002\u0010$J\b\u0010%\u001A\u00020\u001FH\u0002R\u0017\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u001E\u0010\r\u001A\u0004\u0018\u00018\u0000X\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u0012\u001A\u0004\b\u000E\u0010\u000F\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001A\u0004\u0018\u00018\u00008\u0006@\u0006X\u0087\u000E¢\u0006\u0010\n\u0002\u0010\u0012\u001A\u0004\b\u0014\u0010\u000F\"\u0004\b\u0015\u0010\u0011R\u001A\u0010\u0016\u001A\u00020\u0017X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0018\u0010\u0019\"\u0004\b\u001A\u0010\u001B¨\u0006&"}, d2={"Landroidx/compose/runtime/snapshots/StateSetIterator;", "T", "", "set", "Landroidx/compose/runtime/snapshots/SnapshotStateSet;", "iterator", "", "<init>", "(Landroidx/compose/runtime/snapshots/SnapshotStateSet;Ljava/util/Iterator;)V", "getSet", "()Landroidx/compose/runtime/snapshots/SnapshotStateSet;", "getIterator", "()Ljava/util/Iterator;", "current", "getCurrent", "()Ljava/lang/Object;", "setCurrent", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "next", "getNext", "setNext", "modification", "", "getModification", "()I", "setModification", "(I)V", "hasNext", "", "remove", "", "advance", "modify", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "validateModification", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class StateSetIterator implements Iterator, KMutableIterator {
    public static final int $stable = 8;
    private Object current;
    private final Iterator iterator;
    private int modification;
    private Object next;
    private final SnapshotStateSet set;

    static {
    }

    public StateSetIterator(SnapshotStateSet arg1, Iterator arg2) {
        super();
        this.set = arg1;
        this.iterator = arg2;
        this.modification = SnapshotStateSetKt.getModification(arg1);
        this.advance();
    }

    private final void advance() {
        this.current = this.next;
        Object v0 = this.iterator.hasNext() ? this.iterator.next() : null;
        this.next = v0;
    }

    public final Object getCurrent() {
        return this.current;
    }

    public final Iterator getIterator() {
        return this.iterator;
    }

    public final int getModification() {
        return this.modification;
    }

    public final Object getNext() {
        return this.next;
    }

    public final SnapshotStateSet getSet() {
        return this.set;
    }

    public boolean hasNext() {
        if(this.next != null) {
            return 1;
        }

        return 0;
    }

    private final Object modify(Function0 arg2) {
        this.validateModification();
        Object v2 = arg2.invoke();
        this.modification = SnapshotStateSetKt.getModification(this.set);
        return v2;
    }

    public Object next() {
        this.validateModification();
        this.advance();
        Object v0 = this.current;
        if(v0 != null) {
            return v0;
        }

        throw new IllegalStateException();
    }

    public void remove() {
        this.validateModification();
        Object v0 = this.current;
        if(v0 != null) {
            this.set.remove(v0);
            this.current = null;
            this.modification = SnapshotStateSetKt.getModification(this.set);
            return;
        }

        throw new IllegalStateException();
    }

    public final void setCurrent(Object arg1) {
        this.current = arg1;
    }

    public final void setModification(int arg1) {
        this.modification = arg1;
    }

    public final void setNext(Object arg1) {
        this.next = arg1;
    }

    private final void validateModification() {
        if(SnapshotStateSetKt.getModification(this.set) == this.modification) {
            return;
        }

        throw new ConcurrentModificationException();
    }
}

