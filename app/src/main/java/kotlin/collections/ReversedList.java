package kotlin.collections;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010)\n\u0000\n\u0002\u0010+\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0017\bF\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u000B\u001A\u00028\u00002\u0006\u0010\f\u001A\u00020\bH\u0096\u0082\u0004¢\u0006\u0002\u0010\rJ\n\u0010\u000E\u001A\u00020\u000FH\u0096\u0080\u0004J\u0017\u0010\u0010\u001A\u00028\u00002\u0006\u0010\f\u001A\u00020\bH\u0096\u0080\b¢\u0006\u0002\u0010\rJ\u001F\u0010\u0011\u001A\u00028\u00002\u0006\u0010\f\u001A\u00020\b2\u0006\u0010\u0012\u001A\u00028\u0000H\u0096\u0082\b¢\u0006\u0002\u0010\u0013J\u001F\u0010\u0014\u001A\u00020\u000F2\u0006\u0010\f\u001A\u00020\b2\u0006\u0010\u0012\u001A\u00028\u0000H\u0096\u0080\u0004¢\u0006\u0002\u0010\u0015J\u0010\u0010\u0016\u001A\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0096\u0082\u0004J\u0010\u0010\u0018\u001A\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0096\u0080\u0004J\u0018\u0010\u0018\u001A\b\u0012\u0004\u0012\u00028\u00000\u00192\u0006\u0010\f\u001A\u00020\bH\u0096\u0080\u0004R\u0015\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\u0007\u001A\u00020\b8VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b\t\u0010\n¨\u0006\u001A"}, d2={"Lkotlin/collections/ReversedList;", "T", "Lkotlin/collections/AbstractMutableList;", "delegate", "", "<init>", "(Ljava/util/List;)V", "size", "", "getSize", "()I", "get", "index", "(I)Ljava/lang/Object;", "clear", "", "removeAt", "set", "element", "(ILjava/lang/Object;)Ljava/lang/Object;", "add", "(ILjava/lang/Object;)V", "iterator", "", "listIterator", "", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class ReversedList extends AbstractMutableList {
    private final List delegate;

    public ReversedList(List arg2) {
        Intrinsics.checkNotNullParameter(arg2, "delegate");
        super();
        this.delegate = arg2;
    }

    public static final List access$getDelegate$p(ReversedList arg0) {
        return arg0.delegate;
    }

    public void add(int arg2, Object arg3) {
        this.delegate.add(CollectionsKt__ReversedViewsKt.reversePositionIndex$CollectionsKt__ReversedViewsKt(((List)this), arg2), arg3);
    }

    public void clear() {
        this.delegate.clear();
    }

    public Object get(int arg2) {
        return this.delegate.get(CollectionsKt__ReversedViewsKt.reverseElementIndex$CollectionsKt__ReversedViewsKt(((List)this), arg2));
    }

    public int getSize() {
        return this.delegate.size();
    }

    public Iterator iterator() {
        return this.listIterator(0);
    }

    public ListIterator listIterator(int arg2) {
        return new ReversedList$listIterator$1(this, arg2);
    }

    public ListIterator listIterator() {
        return this.listIterator(0);
    }

    public Object removeAt(int arg2) {
        return this.delegate.remove(CollectionsKt__ReversedViewsKt.reverseElementIndex$CollectionsKt__ReversedViewsKt(((List)this), arg2));
    }

    public Object set(int arg2, Object arg3) {
        return this.delegate.set(CollectionsKt__ReversedViewsKt.reverseElementIndex$CollectionsKt__ReversedViewsKt(((List)this), arg2), arg3);
    }
}

