package kotlin.collections;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.IgnorableReturnValue;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMutableMap;

@Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0007\b\'\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004B\t\bD¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u0007\u001A\u0004\u0018\u00018\u00012\u0006\u0010\b\u001A\u00028\u00002\u0006\u0010\t\u001A\u00028\u0001H§\u0080\b¢\u0006\u0002\u0010\n¨\u0006\u000B"}, d2={"Lkotlin/collections/AbstractMutableMap;", "K", "V", "", "Ljava/util/AbstractMap;", "<init>", "()V", "put", "key", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public abstract class AbstractMutableMap extends AbstractMap implements Map, KMutableMap {
    protected AbstractMutableMap() {
        super();
    }

    public final Set entrySet() {
        return this.getEntries();
    }

    public abstract Set getEntries();

    public Set getKeys() {
        return super.keySet();
    }

    public int getSize() {
        return super.size();
    }

    public Collection getValues() {
        return super.values();
    }

    public final Set keySet() {
        return this.getKeys();
    }

    @IgnorableReturnValue public abstract Object put(Object arg1, Object arg2);

    public final int size() {
        return this.getSize();
    }

    public final Collection values() {
        return this.getValues();
    }
}

