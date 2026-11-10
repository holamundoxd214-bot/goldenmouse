package androidx.core.util;

import android.util.LruCache;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u001Aû\u0001\u0010\u0000\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004\"\b\b\u0001\u0010\u0003*\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u000628\b\u0006\u0010\u0007\u001A2\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000B\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00060\b2%\b\u0006\u0010\r\u001A\u001F\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000B\u0012\u0006\u0012\u0004\u0018\u0001H\u00030\u000E2d\b\u0006\u0010\u000F\u001A^\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000B\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u0001H\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00150\u0010H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0016"}, d2={"lruCache", "Landroid/util/LruCache;", "K", "V", "", "maxSize", "", "sizeOf", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "key", "value", "create", "Lkotlin/Function1;", "onEntryRemoved", "Lkotlin/Function4;", "", "evicted", "oldValue", "newValue", "", "core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class LruCacheKt {
    public static final LruCache lruCache(int arg1, Function2 arg2, Function1 arg3, Function4 arg4) {
        Intrinsics.checkNotNullParameter(arg2, "sizeOf");
        Intrinsics.checkNotNullParameter(arg3, "create");
        Intrinsics.checkNotNullParameter(arg4, "onEntryRemoved");
        return new LruCacheKt$lruCache$4(arg1, arg2, arg3, arg4);
    }

    public static LruCache lruCache$default(int arg0, Function2 arg1, Function1 arg2, Function4 arg3, int arg4, Object arg5) {
        LruCacheKt$lruCache$3 v3;
        LruCacheKt$lruCache$2 v2;
        LruCacheKt$lruCache$1 v1;
        if((arg4 & 2) != 0) {
            v1 = LruCacheKt$lruCache$1.INSTANCE;
        }

        if((arg4 & 4) != 0) {
            v2 = LruCacheKt$lruCache$2.INSTANCE;
        }

        if((arg4 & 8) != 0) {
            v3 = LruCacheKt$lruCache$3.INSTANCE;
        }

        Intrinsics.checkNotNullParameter(v1, "sizeOf");
        Intrinsics.checkNotNullParameter(v2, "create");
        Intrinsics.checkNotNullParameter(v3, "onEntryRemoved");
        return new LruCacheKt$lruCache$4(arg0, ((Function2)v1), ((Function1)v2), ((Function4)v3));
    }
}

