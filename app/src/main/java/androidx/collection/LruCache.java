package androidx.collection;

import androidx.collection.internal.Lock;
import androidx.collection.internal.LruHashMap;
import androidx.collection.internal.RuntimeHelpersKt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map$Entry;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u000E\n\u0002\u0010%\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002B\u000F\u0012\b\b\u0001\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0017\u0010\u0011\u001A\u0004\u0018\u00018\u00012\u0006\u0010\u0012\u001A\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0013J\u0006\u0010\u0007\u001A\u00020\u0005J/\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0012\u001A\u00028\u00002\u0006\u0010\u0018\u001A\u00028\u00012\b\u0010\u0019\u001A\u0004\u0018\u00018\u0001H\u0014¢\u0006\u0002\u0010\u001AJ\u0006\u0010\u001B\u001A\u00020\u0015J\u0006\u0010\b\u001A\u00020\u0005J\u0018\u0010\u001C\u001A\u0004\u0018\u00018\u00012\u0006\u0010\u0012\u001A\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u0013J\u0006\u0010\t\u001A\u00020\u0005J\u0006\u0010\u0004\u001A\u00020\u0005J\u0006\u0010\u000E\u001A\u00020\u0005J\u001D\u0010\u001D\u001A\u0004\u0018\u00018\u00012\u0006\u0010\u0012\u001A\u00028\u00002\u0006\u0010\u001E\u001A\u00028\u0001¢\u0006\u0002\u0010\u001FJ\u0006\u0010\u000F\u001A\u00020\u0005J\u0015\u0010 \u001A\u0004\u0018\u00018\u00012\u0006\u0010\u0012\u001A\u00028\u0000¢\u0006\u0002\u0010\u0013J\u0012\u0010!\u001A\u00020\u00152\b\b\u0001\u0010\u0004\u001A\u00020\u0005H\u0016J\u001D\u0010\"\u001A\u00020\u00052\u0006\u0010\u0012\u001A\u00028\u00002\u0006\u0010\u001E\u001A\u00028\u0001H\u0002¢\u0006\u0002\u0010#J\u0006\u0010\u0010\u001A\u00020\u0005J\u001D\u0010$\u001A\u00020\u00052\u0006\u0010\u0012\u001A\u00028\u00002\u0006\u0010\u001E\u001A\u00028\u0001H\u0014¢\u0006\u0002\u0010#J\u0012\u0010%\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010&J\b\u0010\'\u001A\u00020(H\u0016J\u0010\u0010)\u001A\u00020\u00152\u0006\u0010\u0004\u001A\u00020\u0005H\u0016R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\f\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006*"}, d2={"Landroidx/collection/LruCache;", "K", "", "V", "maxSize", "", "(I)V", "createCount", "evictionCount", "hitCount", "lock", "Landroidx/collection/internal/Lock;", "map", "Landroidx/collection/internal/LruHashMap;", "missCount", "putCount", "size", "create", "key", "(Ljava/lang/Object;)Ljava/lang/Object;", "entryRemoved", "", "evicted", "", "oldValue", "newValue", "(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "evictAll", "get", "put", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove", "resize", "safeSizeOf", "(Ljava/lang/Object;Ljava/lang/Object;)I", "sizeOf", "snapshot", "", "toString", "", "trimToSize", "collection"}, k=1, mv={1, 9, 0}, xi=0x30) public class LruCache {
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private final Lock lock;
    private final LruHashMap map;
    private int maxSize;
    private int missCount;
    private int putCount;
    private int size;

    public LruCache(int arg3) {
        super();
        this.maxSize = arg3;
        arg3 = arg3 > 0 ? 1 : 0;
        if(arg3 == 0) {
            RuntimeHelpersKt.throwIllegalArgumentException("maxSize <= 0");
        }

        this.map = new LruHashMap(0, 0.75f);
        this.lock = new Lock();
    }

    protected Object create(Object arg1) {
        Intrinsics.checkNotNullParameter(arg1, "key");
        return null;
    }

    public final int createCount() {
        int v1_1;
        Lock v0 = this.lock;
        __monitor_enter(v0);
        try {
            v1_1 = this.createCount;
        }
        catch(Throwable v1) {
            __monitor_exit(v0);
            throw v1;
        }

        __monitor_exit(v0);
        return v1_1;
    }

    protected void entryRemoved(boolean arg1, Object arg2, Object arg3, Object arg4) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        Intrinsics.checkNotNullParameter(arg3, "oldValue");
    }

    public final void evictAll() {
        this.trimToSize(-1);
    }

    public final int evictionCount() {
        int v1_1;
        Lock v0 = this.lock;
        __monitor_enter(v0);
        try {
            v1_1 = this.evictionCount;
        }
        catch(Throwable v1) {
            __monitor_exit(v0);
            throw v1;
        }

        __monitor_exit(v0);
        return v1_1;
    }

    public final Object get(Object arg6) {
        Object v2;
        Object v1;
        Intrinsics.checkNotNullParameter(arg6, "key");
        Lock v0 = this.lock;
        __monitor_enter(v0);
        try {
            v1 = this.map.get(arg6);
            if(v1 == null) {
                goto label_12;
            }

            ++this.hitCount;
        }
        catch(Throwable v5) {
            goto label_48;
        }

        __monitor_exit(v0);
        return v1;
        try {
        label_12:
            ++this.missCount;
        }
        catch(Throwable v5) {
        label_48:
            __monitor_exit(v0);
            throw v5;
        }

        __monitor_exit(v0);
        Object v0_1 = this.create(arg6);
        if(v0_1 == null) {
            return null;
        }

        Lock v1_1 = this.lock;
        __monitor_enter(v1_1);
        try {
            ++this.createCount;
            v2 = this.map.put(arg6, v0_1);
            if(v2 != null) {
                this.map.put(arg6, v2);
            }
            else {
                this.size += this.safeSizeOf(arg6, v0_1);
            }
        }
        catch(Throwable v5) {
            __monitor_exit(v1_1);
            throw v5;
        }

        __monitor_exit(v1_1);
        if(v2 != null) {
            this.entryRemoved(false, arg6, v0_1, v2);
            return v2;
        }

        this.trimToSize(this.maxSize);
        return v0_1;
    }

    public final int hitCount() {
        int v1_1;
        Lock v0 = this.lock;
        __monitor_enter(v0);
        try {
            v1_1 = this.hitCount;
        }
        catch(Throwable v1) {
            __monitor_exit(v0);
            throw v1;
        }

        __monitor_exit(v0);
        return v1_1;
    }

    public final int maxSize() {
        int v1_1;
        Lock v0 = this.lock;
        __monitor_enter(v0);
        try {
            v1_1 = this.maxSize;
        }
        catch(Throwable v1) {
            __monitor_exit(v0);
            throw v1;
        }

        __monitor_exit(v0);
        return v1_1;
    }

    public final int missCount() {
        int v1_1;
        Lock v0 = this.lock;
        __monitor_enter(v0);
        try {
            v1_1 = this.missCount;
        }
        catch(Throwable v1) {
            __monitor_exit(v0);
            throw v1;
        }

        __monitor_exit(v0);
        return v1_1;
    }

    public final Object put(Object arg5, Object arg6) {
        Object v1;
        Intrinsics.checkNotNullParameter(arg5, "key");
        Intrinsics.checkNotNullParameter(arg6, "value");
        Lock v0 = this.lock;
        __monitor_enter(v0);
        try {
            ++this.putCount;
            this.size += this.safeSizeOf(arg5, arg6);
            v1 = this.map.put(arg5, arg6);
            if(v1 != null) {
                this.size -= this.safeSizeOf(arg5, v1);
            }
        }
        catch(Throwable v4) {
            __monitor_exit(v0);
            throw v4;
        }

        __monitor_exit(v0);
        if(v1 != null) {
            this.entryRemoved(false, arg5, v1, arg6);
        }

        this.trimToSize(this.maxSize);
        return v1;
    }

    public final int putCount() {
        int v1_1;
        Lock v0 = this.lock;
        __monitor_enter(v0);
        try {
            v1_1 = this.putCount;
        }
        catch(Throwable v1) {
            __monitor_exit(v0);
            throw v1;
        }

        __monitor_exit(v0);
        return v1_1;
    }

    public final Object remove(Object arg5) {
        Object v1;
        Intrinsics.checkNotNullParameter(arg5, "key");
        Lock v0 = this.lock;
        __monitor_enter(v0);
        try {
            v1 = this.map.remove(arg5);
            if(v1 != null) {
                this.size -= this.safeSizeOf(arg5, v1);
            }
        }
        catch(Throwable v4) {
            __monitor_exit(v0);
            throw v4;
        }

        __monitor_exit(v0);
        if(v1 != null) {
            this.entryRemoved(false, arg5, v1, null);
        }

        return v1;
    }

    public void resize(int arg3) {
        int v0 = arg3 > 0 ? 1 : 0;
        if(v0 == 0) {
            RuntimeHelpersKt.throwIllegalArgumentException("maxSize <= 0");
        }

        Lock v0_1 = this.lock;
        __monitor_enter(v0_1);
        try {
            this.maxSize = arg3;
        }
        catch(Throwable v2) {
            __monitor_exit(v0_1);
            throw v2;
        }

        __monitor_exit(v0_1);
        this.trimToSize(arg3);
    }

    private final int safeSizeOf(Object arg3, Object arg4) {
        int v2 = this.sizeOf(arg3, arg4);
        int v0 = v2 >= 0 ? 1 : 0;
        if(v0 == 0) {
            RuntimeHelpersKt.throwIllegalStateException("Negative size: " + arg3 + '=' + arg4);
        }

        return v2;
    }

    public final int size() {
        int v1_1;
        Lock v0 = this.lock;
        __monitor_enter(v0);
        try {
            v1_1 = this.size;
        }
        catch(Throwable v1) {
            __monitor_exit(v0);
            throw v1;
        }

        __monitor_exit(v0);
        return v1_1;
    }

    protected int sizeOf(Object arg1, Object arg2) {
        Intrinsics.checkNotNullParameter(arg1, "key");
        Intrinsics.checkNotNullParameter(arg2, "value");
        return 1;
    }

    public final Map snapshot() {
        Lock v0 = this.lock;
        __monitor_enter(v0);
        try {
            LinkedHashMap v1 = new LinkedHashMap(this.map.getEntries().size());
            Iterator v5_1 = this.map.getEntries().iterator();
            while(v5_1.hasNext()) {
                Object v2 = v5_1.next();
                v1.put(((Map$Entry)v2).getKey(), ((Map$Entry)v2).getValue());
            }

            __monitor_exit(v0);
            return ((Map)v1);
        }
        catch(Throwable v5) {
            __monitor_exit(v0);
            throw v5;
        }
    }

    public String toString() {
        String v4_1;
        String v0 = "LruCache[maxSize=";
        Lock v1 = this.lock;
        __monitor_enter(v1);
        try {
            int v2 = this.hitCount;
            int v3 = this.missCount + v2;
            v2 = v3 != 0 ? v2 * 100 / v3 : 0;
            v4_1 = v0 + this.maxSize + ",hits=" + this.hitCount + ",misses=" + this.missCount + ",hitRate=" + v2 + "%]";
        }
        catch(Throwable v4) {
            __monitor_exit(v1);
            throw v4;
        }

        __monitor_exit(v1);
        return v4_1;
    }

    public void trimToSize(int arg7) {
        Object v3;
        Object v1_1;
        int v1;
        Lock v0;
        while(true) {
            v0 = this.lock;
            __monitor_enter(v0);
            try {
                if(this.size >= 0) {
                    if((this.map.isEmpty()) && this.size != 0) {
                        goto label_12;
                    }

                    v1 = 1;
                }
                else {
                label_12:
                    v1 = 0;
                }

                if(v1 == 0) {
                    RuntimeHelpersKt.throwIllegalStateException("LruCache.sizeOf() is reporting inconsistent results!");
                }

                if(this.size > arg7) {
                    if(this.map.isEmpty()) {
                    }
                    else {
                        v1_1 = CollectionsKt.firstOrNull(this.map.getEntries());
                        if(v1_1 == null) {
                            goto label_26;
                        }
                        else {
                            goto label_28;
                        }
                    }
                }

                break;
            }
            catch(Throwable v6) {
                goto label_46;
            }

        label_26:
            __monitor_exit(v0);
            return;
            try {
            label_28:
                v3 = ((Map$Entry)v1_1).getKey();
                v1_1 = ((Map$Entry)v1_1).getValue();
                this.map.remove(v3);
                this.size -= this.safeSizeOf(v3, v1_1);
                ++this.evictionCount;
            }
            catch(Throwable v6) {
            label_46:
                __monitor_exit(v0);
                throw v6;
            }

            __monitor_exit(v0);
            this.entryRemoved(true, v3, v1_1, null);
        }

        __monitor_exit(v0);
    }
}

