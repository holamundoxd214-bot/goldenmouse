package androidx.core.view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B1\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u001A\u0010\u0004\u001A\u0016\u0012\u0004\u0012\u00028\u0000\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000B\u001A\u00020\fH\u0096\u0002J\u000E\u0010\r\u001A\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u000EJ\u0015\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0012R\"\u0010\u0004\u001A\u0016\u0012\u0004\u0012\u00028\u0000\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\b\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2={"Landroidx/core/view/TreeIterator;", "T", "", "rootIterator", "getChildIterator", "Lkotlin/Function1;", "<init>", "(Ljava/util/Iterator;Lkotlin/jvm/functions/Function1;)V", "stack", "", "iterator", "hasNext", "", "next", "()Ljava/lang/Object;", "prepareNextIterator", "", "item", "(Ljava/lang/Object;)V", "core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class TreeIterator implements Iterator, KMappedMarker {
    private final Function1 getChildIterator;
    private Iterator iterator;
    private final List stack;

    public TreeIterator(Iterator arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "rootIterator");
        Intrinsics.checkNotNullParameter(arg3, "getChildIterator");
        super();
        this.getChildIterator = arg3;
        this.stack = new ArrayList();
        this.iterator = arg2;
    }

    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    public Object next() {
        Object v0 = this.iterator.next();
        this.prepareNextIterator(v0);
        return v0;
    }

    private final void prepareNextIterator(Object arg3) {
        arg3 = this.getChildIterator.invoke(arg3);
        if(arg3 != null && (((Iterator)arg3).hasNext())) {
            this.stack.add(this.iterator);
            this.iterator = ((Iterator)arg3);
            return;
        }

        while(!this.iterator.hasNext()) {
            if(this.stack.isEmpty()) {
                return;
            }

            this.iterator = CollectionsKt.last(this.stack);
            CollectionsKt.removeLast(this.stack);
        }
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

