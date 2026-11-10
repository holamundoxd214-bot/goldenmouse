package kotlin.collections;

import java.util.AbstractList;
import java.util.List;
import kotlin.IgnorableReturnValue;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMutableList;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\t\bD¢\u0006\u0004\b\u0004\u0010\u0005J\u001F\u0010\u0006\u001A\u00028\u00002\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00028\u0000H§\u0082\b¢\u0006\u0002\u0010\nJ\u0017\u0010\u000B\u001A\u00028\u00002\u0006\u0010\u0007\u001A\u00020\bH§\u0080\b¢\u0006\u0002\u0010\fJ\u001F\u0010\r\u001A\u00020\u000E2\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00028\u0000H¦\u0080\u0004¢\u0006\u0002\u0010\u000F¨\u0006\u0010"}, d2={"Lkotlin/collections/AbstractMutableList;", "E", "", "Ljava/util/AbstractList;", "<init>", "()V", "set", "index", "", "element", "(ILjava/lang/Object;)Ljava/lang/Object;", "removeAt", "(I)Ljava/lang/Object;", "add", "", "(ILjava/lang/Object;)V", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public abstract class AbstractMutableList extends AbstractList implements List, KMutableList {
    protected AbstractMutableList() {
        super();
    }

    public abstract void add(int arg1, Object arg2);

    public abstract int getSize();

    public final Object remove(int arg1) {
        return this.removeAt(arg1);
    }

    @IgnorableReturnValue public abstract Object removeAt(int arg1);

    @IgnorableReturnValue public abstract Object set(int arg1, Object arg2);

    public final int size() {
        return this.getSize();
    }
}

