package androidx.arch.core.internal;

import java.util.HashMap;
import java.util.Map$Entry;

public class FastSafeIterableMap extends SafeIterableMap {
    private final HashMap mHashMap;

    public FastSafeIterableMap() {
        super();
        this.mHashMap = new HashMap();
    }

    public Map$Entry ceil(Object arg2) {
        if(this.contains(arg2)) {
            return this.mHashMap.get(arg2).mPrevious;
        }

        return null;
    }

    public boolean contains(Object arg1) {
        return this.mHashMap.containsKey(arg1);
    }

    protected Entry get(Object arg1) {
        return this.mHashMap.get(arg1);
    }

    public Object putIfAbsent(Object arg2, Object arg3) {
        Entry v0 = this.get(arg2);
        if(v0 != null) {
            return v0.mValue;
        }

        this.mHashMap.put(arg2, this.put(arg2, arg3));
        return null;
    }

    public Object remove(Object arg2) {
        Object v0 = super.remove(arg2);
        this.mHashMap.remove(arg2);
        return v0;
    }
}

