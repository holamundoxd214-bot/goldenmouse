package androidx.compose.runtime.snapshots;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map$Entry;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\u0010&\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\"\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B5\u0012\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0018\u0010\u0006\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u001D\u001A\u00020\u001EJ\u0006\u0010\u001F\u001A\u00020 J\b\u0010!\u001A\u00020\u001EH\u0004J\"\u0010\"\u001A\u0002H#\"\u0004\b\u0002\u0010#2\f\u0010$\u001A\b\u0012\u0004\u0012\u0002H#0%H\u0084\b¢\u0006\u0002\u0010&R\u001D\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR#\u0010\u0006\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b0\u0007¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u001A\u0010\u000F\u001A\u00020\u0010X\u0084\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R(\u0010\u0015\u001A\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\bX\u0084\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R(\u0010\u001A\u001A\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\bX\u0084\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001B\u0010\u0017\"\u0004\b\u001C\u0010\u0019¨\u0006\'"}, d2={"Landroidx/compose/runtime/snapshots/StateMapMutableIterator;", "K", "V", "", "map", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "iterator", "", "", "<init>", "(Landroidx/compose/runtime/snapshots/SnapshotStateMap;Ljava/util/Iterator;)V", "getMap", "()Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "getIterator", "()Ljava/util/Iterator;", "modification", "", "getModification", "()I", "setModification", "(I)V", "current", "getCurrent", "()Ljava/util/Map$Entry;", "setCurrent", "(Ljava/util/Map$Entry;)V", "next", "getNext", "setNext", "remove", "", "hasNext", "", "advance", "modify", "T", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) abstract class StateMapMutableIterator {
    private Map$Entry current;
    private final Iterator iterator;
    private final SnapshotStateMap map;
    private int modification;
    private Map$Entry next;

    public StateMapMutableIterator(SnapshotStateMap arg1, Iterator arg2) {
        super();
        this.map = arg1;
        this.iterator = arg2;
        this.modification = arg1.getModification$runtime();
        this.advance();
    }

    public static final int access$getModification(StateMapMutableIterator arg0) {
        return arg0.modification;
    }

    public static final void access$setModification(StateMapMutableIterator arg0, int arg1) {
        arg0.modification = arg1;
    }

    protected final void advance() {
        Map$Entry v0_1;
        this.current = this.next;
        if(this.iterator.hasNext()) {
            Object v0 = this.iterator.next();
        }
        else {
            v0_1 = null;
        }

        this.next = v0_1;
    }

    protected final Map$Entry getCurrent() {
        return this.current;
    }

    public final Iterator getIterator() {
        return this.iterator;
    }

    public final SnapshotStateMap getMap() {
        return this.map;
    }

    protected final int getModification() {
        return this.modification;
    }

    protected final Map$Entry getNext() {
        return this.next;
    }

    public final boolean hasNext() {
        if(this.next != null) {
            return 1;
        }

        return 0;
    }

    protected final Object modify(Function0 arg3) {
        if(this.getMap().getModification$runtime() == this.modification) {
            Object v3 = arg3.invoke();
            this.modification = this.getMap().getModification$runtime();
            return v3;
        }

        throw new ConcurrentModificationException();
    }

    public final void remove() {
        if(this.getMap().getModification$runtime() == this.modification) {
            Map$Entry v0 = this.current;
            if(v0 != null) {
                this.map.remove(v0.getKey());
                this.current = null;
                this.modification = this.getMap().getModification$runtime();
                return;
            }

            throw new IllegalStateException();
        }

        throw new ConcurrentModificationException();
    }

    protected final void setCurrent(Map$Entry arg1) {
        this.current = arg1;
    }

    protected final void setModification(int arg1) {
        this.modification = arg1;
    }

    protected final void setNext(Map$Entry arg1) {
        this.next = arg1;
    }
}

