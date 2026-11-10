package androidx.core.util;

import android.util.SparseLongArray;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.collections.LongIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000D\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\u0015\u0010\u0005\u001A\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001A\u00020\u0001H\u0086\n\u001A\u001D\u0010\b\u001A\u00020\t*\u00020\u00022\u0006\u0010\u0007\u001A\u00020\u00012\u0006\u0010\n\u001A\u00020\u000BH\u0086\n\u001A\u0015\u0010\f\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\r\u001A\u00020\u0002H\u0086\u0002\u001A\u0015\u0010\u000E\u001A\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001A\u00020\u0001H\u0086\b\u001A\u0015\u0010\u000F\u001A\u00020\u0006*\u00020\u00022\u0006\u0010\n\u001A\u00020\u000BH\u0086\b\u001A\u001D\u0010\u0010\u001A\u00020\u000B*\u00020\u00022\u0006\u0010\u0007\u001A\u00020\u00012\u0006\u0010\u0011\u001A\u00020\u000BH\u0086\b\u001A&\u0010\u0012\u001A\u00020\u000B*\u00020\u00022\u0006\u0010\u0007\u001A\u00020\u00012\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u000B0\u0013H\u0086\bø\u0001\u0000\u001A\r\u0010\u0014\u001A\u00020\u0006*\u00020\u0002H\u0086\b\u001A\r\u0010\u0015\u001A\u00020\u0006*\u00020\u0002H\u0086\b\u001A\u001A\u0010\u0016\u001A\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001A\u00020\u00012\u0006\u0010\n\u001A\u00020\u000B\u001A\u0012\u0010\u0017\u001A\u00020\t*\u00020\u00022\u0006\u0010\r\u001A\u00020\u0002\u001AH\u0010\u0018\u001A\u00020\t*\u00020\u000226\u0010\u0019\u001A2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u001B\u0012\b\b\u001C\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u000B¢\u0006\f\b\u001B\u0012\b\b\u001C\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\t0\u001AH\u0086\bø\u0001\u0000\u001A\n\u0010\u001D\u001A\u00020\u001E*\u00020\u0002\u001A\n\u0010\u001F\u001A\u00020 *\u00020\u0002\"\u0016\u0010\u0000\u001A\u00020\u0001*\u00020\u00028Æ\u0002¢\u0006\u0006\u001A\u0004\b\u0003\u0010\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006!"}, d2={"size", "", "Landroid/util/SparseLongArray;", "getSize", "(Landroid/util/SparseLongArray;)I", "contains", "", "key", "set", "", "value", "", "plus", "other", "containsKey", "containsValue", "getOrDefault", "defaultValue", "getOrElse", "Lkotlin/Function0;", "isEmpty", "isNotEmpty", "remove", "putAll", "forEach", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "keyIterator", "Lkotlin/collections/IntIterator;", "valueIterator", "Lkotlin/collections/LongIterator;", "core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class SparseLongArrayKt {
    public static final boolean contains(SparseLongArray arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.indexOfKey(arg2) >= 0) {
            return 1;
        }

        return 0;
    }

    public static final boolean containsKey(SparseLongArray arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.indexOfKey(arg2) >= 0) {
            return 1;
        }

        return 0;
    }

    public static final boolean containsValue(SparseLongArray arg1, long arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.indexOfValue(arg2) >= 0) {
            return 1;
        }

        return 0;
    }

    public static final void forEach(SparseLongArray arg5, Function2 arg6) {
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        Intrinsics.checkNotNullParameter(arg6, "action");
        int v0 = arg5.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            arg6.invoke(Integer.valueOf(arg5.keyAt(v1)), Long.valueOf(arg5.valueAt(v1)));
        }
    }

    public static final long getOrDefault(SparseLongArray arg1, int arg2, long arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.get(arg2, arg3);
    }

    public static final long getOrElse(SparseLongArray arg1, int arg2, Function0 arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "defaultValue");
        arg2 = arg1.indexOfKey(arg2);
        if(arg2 >= 0) {
            return arg1.valueAt(arg2);
        }

        return arg3.invoke().longValue();
    }

    public static final int getSize(SparseLongArray arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.size();
    }

    public static final boolean isEmpty(SparseLongArray arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.size() == 0) {
            return 1;
        }

        return 0;
    }

    public static final boolean isNotEmpty(SparseLongArray arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.size() != 0) {
            return 1;
        }

        return 0;
    }

    public static final IntIterator keyIterator(SparseLongArray arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return new SparseLongArrayKt$keyIterator$1(arg1);
    }

    public static final SparseLongArray plus(SparseLongArray arg3, SparseLongArray arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "other");
        SparseLongArray v0 = new SparseLongArray(arg3.size() + arg4.size());
        SparseLongArrayKt.putAll(v0, arg3);
        SparseLongArrayKt.putAll(v0, arg4);
        return v0;
    }

    public static final void putAll(SparseLongArray arg5, SparseLongArray arg6) {
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        Intrinsics.checkNotNullParameter(arg6, "other");
        int v0 = arg6.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            arg5.put(arg6.keyAt(v1), arg6.valueAt(v1));
        }
    }

    public static final boolean remove(SparseLongArray arg2, int arg3, long arg4) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        arg3 = arg2.indexOfKey(arg3);
        if(arg3 >= 0 && arg4 == arg2.valueAt(arg3)) {
            arg2.removeAt(arg3);
            return 1;
        }

        return 0;
    }

    public static final void set(SparseLongArray arg1, int arg2, long arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1.put(arg2, arg3);
    }

    public static final LongIterator valueIterator(SparseLongArray arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return new SparseLongArrayKt$valueIterator$1(arg1);
    }
}

