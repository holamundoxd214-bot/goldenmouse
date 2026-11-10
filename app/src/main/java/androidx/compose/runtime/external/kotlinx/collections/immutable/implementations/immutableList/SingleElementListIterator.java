package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0017\u0012\u0006\u0010\u0003\u001A\u00028\u0000\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000E\u0010\t\u001A\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\nJ\r\u0010\u000B\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\nR\u0010\u0010\u0003\u001A\u00028\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\f"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/SingleElementListIterator;", "E", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/AbstractListIterator;", "element", "index", "", "<init>", "(Ljava/lang/Object;I)V", "Ljava/lang/Object;", "next", "()Ljava/lang/Object;", "previous", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class SingleElementListIterator extends AbstractListIterator {
    public static final int $stable = 8;
    private final Object element;

    static {
    }

    public SingleElementListIterator(Object arg2, int arg3) {
        super(arg3, 1);
        this.element = arg2;
    }

    public Object next() {
        this.checkHasNext$runtime();
        this.setIndex(this.getIndex() + 1);
        return this.element;
    }

    public Object previous() {
        this.checkHasPrevious$runtime();
        this.setIndex(this.getIndex() - 1);
        return this.element;
    }
}

