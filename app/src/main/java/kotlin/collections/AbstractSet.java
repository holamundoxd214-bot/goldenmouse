package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\'\u0018\u0000 \f*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\fB\t\bD¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0006\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\tH\u0096\u0082\u0004J\n\u0010\n\u001A\u00020\u000BH\u0096\u0080\u0004¨\u0006\r"}, d2={"Lkotlin/collections/AbstractSet;", "E", "Lkotlin/collections/AbstractCollection;", "", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "Companion", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public abstract class AbstractSet extends AbstractCollection implements Set, KMappedMarker {
    @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u001E\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\u0010\"\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\u001B\u0010\u0004\u001A\u00020\u00052\n\u0010\u0006\u001A\u0006\u0012\u0002\b\u00030\u0007H\u0080\u0080\u0004¢\u0006\u0002\b\bJ\'\u0010\t\u001A\u00020\n2\n\u0010\u0006\u001A\u0006\u0012\u0002\b\u00030\u000B2\n\u0010\f\u001A\u0006\u0012\u0002\b\u00030\u000BH\u0080\u0080\u0004¢\u0006\u0002\b\r¨\u0006\u000E"}, d2={"Lkotlin/collections/AbstractSet$Companion;", "", "<init>", "()V", "unorderedHashCode", "", "c", "", "unorderedHashCode$kotlin_stdlib", "setEquals", "", "", "other", "setEquals$kotlin_stdlib", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final boolean setEquals$kotlin_stdlib(Set arg2, Set arg3) {
            Intrinsics.checkNotNullParameter(arg2, "c");
            Intrinsics.checkNotNullParameter(arg3, "other");
            if(arg2.size() != arg3.size()) {
                return 0;
            }

            return arg2.containsAll(((Collection)arg3));
        }

        public final int unorderedHashCode$kotlin_stdlib(Collection arg3) {
            Intrinsics.checkNotNullParameter(arg3, "c");
            Iterator v2 = arg3.iterator();
            int v0;
            for(v0 = 0; v2.hasNext(); v0 += v1_1) {
                Object v1 = v2.next();
                int v1_1 = v1 != null ? v1.hashCode() : 0;
            }

            return v0;
        }
    }

    public static final Companion Companion;

    static {
        AbstractSet.Companion = new Companion(null);
    }

    protected AbstractSet() {
        super();
    }

    public boolean equals(Object arg2) {
        if((((AbstractSet)arg2)) == this) {
            return 1;
        }

        if(!(arg2 instanceof Set)) {
            return 0;
        }

        return AbstractSet.Companion.setEquals$kotlin_stdlib(((Set)this), ((Set)arg2));
    }

    public int hashCode() {
        return AbstractSet.Companion.unorderedHashCode$kotlin_stdlib(((Collection)this));
    }

    public Iterator iterator() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

