package kotlin.collections;

import java.util.AbstractCollection;
import java.util.Collection;
import kotlin.IgnorableReturnValue;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMutableCollection;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001F\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\b\'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\t\bD¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00028\u0000H§\u0080\b¢\u0006\u0002\u0010\t¨\u0006\n"}, d2={"Lkotlin/collections/AbstractMutableCollection;", "E", "", "Ljava/util/AbstractCollection;", "<init>", "()V", "add", "", "element", "(Ljava/lang/Object;)Z", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public abstract class AbstractMutableCollection extends AbstractCollection implements Collection, KMutableCollection {
    protected AbstractMutableCollection() {
        super();
    }

    @IgnorableReturnValue public abstract boolean add(Object arg1);

    public abstract int getSize();

    public final int size() {
        return this.getSize();
    }
}

