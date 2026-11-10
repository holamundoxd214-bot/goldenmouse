package androidx.core.util;

import android.util.LongSparseArray;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.LongIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000D\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000\u001A!\u0010\u0006\u001A\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001A\u00020\tH\u0086\n\u001A.\u0010\n\u001A\u00020\u000B\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\f\u001A\u0002H\u0002H\u0086\n¢\u0006\u0002\u0010\r\u001A-\u0010\u000E\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\u0002\u001A!\u0010\u0010\u001A\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001A\u00020\tH\u0086\b\u001A&\u0010\u0011\u001A\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\f\u001A\u0002H\u0002H\u0086\b¢\u0006\u0002\u0010\u0012\u001A.\u0010\u0013\u001A\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\u0014\u001A\u0002H\u0002H\u0086\b¢\u0006\u0002\u0010\u0015\u001A7\u0010\u0016\u001A\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001A\u00020\t2\f\u0010\u0014\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0017H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001A\u0019\u0010\u0019\u001A\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\b\u001A\u0019\u0010\u001A\u001A\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\b\u001A+\u0010\u001B\u001A\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\f\u001A\u0002H\u0002¢\u0006\u0002\u0010\u001C\u001A$\u0010\u001D\u001A\u00020\u000B\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0003\u001AT\u0010\u001E\u001A\u00020\u000B\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000326\u0010\u001F\u001A2\u0012\u0013\u0012\u00110\t¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\b\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000B0 H\u0086\bø\u0001\u0000\u001A\u0016\u0010#\u001A\u00020$\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\u001A\u001C\u0010%\u001A\b\u0012\u0004\u0012\u0002H\u00020&\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\"\u0010\u0000\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00038Æ\u0002¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\'"}, d2={"size", "", "T", "Landroid/util/LongSparseArray;", "getSize", "(Landroid/util/LongSparseArray;)I", "contains", "", "key", "", "set", "", "value", "(Landroid/util/LongSparseArray;JLjava/lang/Object;)V", "plus", "other", "containsKey", "containsValue", "(Landroid/util/LongSparseArray;Ljava/lang/Object;)Z", "getOrDefault", "defaultValue", "(Landroid/util/LongSparseArray;JLjava/lang/Object;)Ljava/lang/Object;", "getOrElse", "Lkotlin/Function0;", "(Landroid/util/LongSparseArray;JLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isEmpty", "isNotEmpty", "remove", "(Landroid/util/LongSparseArray;JLjava/lang/Object;)Z", "putAll", "forEach", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "keyIterator", "Lkotlin/collections/LongIterator;", "valueIterator", "", "core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class LongSparseArrayKt {
    public static final boolean contains(LongSparseArray arg1, long arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.indexOfKey(arg2) >= 0) {
            return 1;
        }

        return 0;
    }

    public static final boolean containsKey(LongSparseArray arg1, long arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.indexOfKey(arg2) >= 0) {
            return 1;
        }

        return 0;
    }

    public static final boolean containsValue(LongSparseArray arg1, Object arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.indexOfValue(arg2) >= 0) {
            return 1;
        }

        return 0;
    }

    public static final void forEach(LongSparseArray arg4, Function2 arg5) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        Intrinsics.checkNotNullParameter(arg5, "action");
        int v0 = arg4.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            arg5.invoke(Long.valueOf(arg4.keyAt(v1)), arg4.valueAt(v1));
        }
    }

    public static final Object getOrDefault(LongSparseArray arg1, long arg2, Object arg4) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Object v1 = arg1.get(arg2);
        if(v1 == null) {
            return arg4;
        }

        return v1;
    }

    public static final Object getOrElse(LongSparseArray arg1, long arg2, Function0 arg4) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "defaultValue");
        Object v1 = arg1.get(arg2);
        if(v1 == null) {
            v1 = arg4.invoke();
        }

        return v1;
    }

    public static final int getSize(LongSparseArray arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.size();
    }

    public static final boolean isEmpty(LongSparseArray arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.size() == 0) {
            return 1;
        }

        return 0;
    }

    public static final boolean isNotEmpty(LongSparseArray arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.size() != 0) {
            return 1;
        }

        return 0;
    }

    public static final LongIterator keyIterator(LongSparseArray arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return new LongSparseArrayKt$keyIterator$1(arg1);
    }

    public static final LongSparseArray plus(LongSparseArray arg3, LongSparseArray arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "other");
        LongSparseArray v0 = new LongSparseArray(arg3.size() + arg4.size());
        LongSparseArrayKt.putAll(v0, arg3);
        LongSparseArrayKt.putAll(v0, arg4);
        return v0;
    }

    public static final void putAll(LongSparseArray arg5, LongSparseArray arg6) {
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        Intrinsics.checkNotNullParameter(arg6, "other");
        int v0 = arg6.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            arg5.put(arg6.keyAt(v1), arg6.valueAt(v1));
        }
    }

    public static final boolean remove(LongSparseArray arg1, long arg2, Object arg4) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        int v2 = arg1.indexOfKey(arg2);
        if(v2 >= 0 && (Intrinsics.areEqual(arg4, arg1.valueAt(v2)))) {
            arg1.removeAt(v2);
            return 1;
        }

        return 0;
    }

    public static final void set(LongSparseArray arg1, long arg2, Object arg4) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1.put(arg2, arg4);
    }

    public static final Iterator valueIterator(LongSparseArray arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return new LongSparseArrayKt$valueIterator$1(arg1);
    }
}

