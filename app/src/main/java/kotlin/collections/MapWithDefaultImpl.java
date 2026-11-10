package kotlin.collections;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u000B\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u001E\n\u0002\b\u0003\n\u0002\u0010&\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0006\b\u0001\u0010\u0002 \u00012\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B@\bF\u0012\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u0012!\u0010\u0006\u001A\u001D\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\u0004\b\u000B\u0010\fJ\u0014\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0012H\u0096\u0082\u0004J\n\u0010\u0013\u001A\u00020\u0014H\u0096\u0080\u0004J\n\u0010\u0015\u001A\u00020\u0016H\u0096\u0080\u0004J\n\u0010\u001A\u001A\u00020\u0010H\u0096\u0080\u0004J\u0017\u0010\u001B\u001A\u00020\u00102\u0006\u0010\n\u001A\u00028\u0000H\u0096\u0080\u0004¢\u0006\u0002\u0010\u001CJ\u0017\u0010\u001D\u001A\u00020\u00102\u0006\u0010\u001E\u001A\u00028\u0001H\u0096\u0080\u0004¢\u0006\u0002\u0010\u001CJ\u0019\u0010\u001F\u001A\u0004\u0018\u00018\u00012\u0006\u0010\n\u001A\u00028\u0000H\u0096\u0082\u0004¢\u0006\u0002\u0010 J\u0017\u0010,\u001A\u00028\u00012\u0006\u0010\n\u001A\u00028\u0000H\u0096\u0080\u0004¢\u0006\u0002\u0010 R!\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005X\u0096\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER*\u0010\u0006\u001A\u001D\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00028\u00010\u0007X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\u0017\u001A\u00020\u00148VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b\u0018\u0010\u0019R\u001B\u0010!\u001A\b\u0012\u0004\u0012\u00028\u00000\"8VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b#\u0010$R\u001B\u0010%\u001A\b\u0012\u0004\u0012\u00028\u00010&8VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b\'\u0010(R\'\u0010)\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010*0\"8VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b+\u0010$¨\u0006-"}, d2={"Lkotlin/collections/MapWithDefaultImpl;", "K", "V", "Lkotlin/collections/MapWithDefault;", "map", "", "default", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "key", "<init>", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)V", "getMap", "()Ljava/util/Map;", "equals", "", "other", "", "hashCode", "", "toString", "", "size", "getSize", "()I", "isEmpty", "containsKey", "(Ljava/lang/Object;)Z", "containsValue", "value", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "keys", "", "getKeys", "()Ljava/util/Set;", "values", "", "getValues", "()Ljava/util/Collection;", "entries", "", "getEntries", "getOrImplicitDefault", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class MapWithDefaultImpl implements MapWithDefault {
    private final Function1 default;
    private final Map map;

    public MapWithDefaultImpl(Map arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "map");
        Intrinsics.checkNotNullParameter(arg3, "default");
        super();
        this.map = arg2;
        this.default = arg3;
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean containsKey(Object arg1) {
        return this.getMap().containsKey(arg1);
    }

    public boolean containsValue(Object arg1) {
        return this.getMap().containsValue(arg1);
    }

    public final Set entrySet() {
        return this.getEntries();
    }

    public boolean equals(Object arg1) {
        return this.getMap().equals(arg1);
    }

    public Object get(Object arg1) {
        return this.getMap().get(arg1);
    }

    public Set getEntries() {
        return this.getMap().entrySet();
    }

    public Set getKeys() {
        return this.getMap().keySet();
    }

    public Map getMap() {
        return this.map;
    }

    public Object getOrImplicitDefault(Object arg3) {
        Map v0 = this.getMap();
        Object v1 = v0.get(arg3);
        if(v1 == null && !v0.containsKey(arg3)) {
            return this.default.invoke(arg3);
        }

        return v1;
    }

    public int getSize() {
        return this.getMap().size();
    }

    public Collection getValues() {
        return this.getMap().values();
    }

    public int hashCode() {
        return this.getMap().hashCode();
    }

    public boolean isEmpty() {
        return this.getMap().isEmpty();
    }

    public final Set keySet() {
        return this.getKeys();
    }

    public Object put(Object arg1, Object arg2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void putAll(Map arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object remove(Object arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean remove(Object arg1, Object arg2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final int size() {
        return this.getSize();
    }

    public String toString() {
        return this.getMap().toString();
    }

    public final Collection values() {
        return this.getValues();
    }
}

