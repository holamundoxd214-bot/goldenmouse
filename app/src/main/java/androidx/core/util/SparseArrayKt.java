package androidx.core.util;

import android.util.SparseArray;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000@\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000\u001A!\u0010\u0006\u001A\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001A\u00020\u0001H\u0086\n\u001A.\u0010\t\u001A\u00020\n\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001A\u00020\u00012\u0006\u0010\u000B\u001A\u0002H\u0002H\u0086\n¢\u0006\u0002\u0010\f\u001A-\u0010\r\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\u0002\u001A!\u0010\u000F\u001A\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001A\u00020\u0001H\u0086\b\u001A&\u0010\u0010\u001A\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u000B\u001A\u0002H\u0002H\u0086\b¢\u0006\u0002\u0010\u0011\u001A.\u0010\u0012\u001A\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001A\u00020\u00012\u0006\u0010\u0013\u001A\u0002H\u0002H\u0086\b¢\u0006\u0002\u0010\u0014\u001A7\u0010\u0015\u001A\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001A\u00020\u00012\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0016H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0017\u001A\u0019\u0010\u0018\u001A\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\b\u001A\u0019\u0010\u0019\u001A\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\b\u001A+\u0010\u001A\u001A\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001A\u00020\u00012\u0006\u0010\u000B\u001A\u0002H\u0002¢\u0006\u0002\u0010\u001B\u001A$\u0010\u001C\u001A\u00020\n\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0003\u001AT\u0010\u001D\u001A\u00020\n\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000326\u0010\u001E\u001A2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\b\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\u000B\u0012\u0004\u0012\u00020\n0\u001FH\u0086\bø\u0001\u0000\u001A\u0016\u0010\"\u001A\u00020#\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\u001A\u001C\u0010$\u001A\b\u0012\u0004\u0012\u0002H\u00020%\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\"\u0010\u0000\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00038Æ\u0002¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006&"}, d2={"size", "", "T", "Landroid/util/SparseArray;", "getSize", "(Landroid/util/SparseArray;)I", "contains", "", "key", "set", "", "value", "(Landroid/util/SparseArray;ILjava/lang/Object;)V", "plus", "other", "containsKey", "containsValue", "(Landroid/util/SparseArray;Ljava/lang/Object;)Z", "getOrDefault", "defaultValue", "(Landroid/util/SparseArray;ILjava/lang/Object;)Ljava/lang/Object;", "getOrElse", "Lkotlin/Function0;", "(Landroid/util/SparseArray;ILkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isEmpty", "isNotEmpty", "remove", "(Landroid/util/SparseArray;ILjava/lang/Object;)Z", "putAll", "forEach", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "keyIterator", "Lkotlin/collections/IntIterator;", "valueIterator", "", "core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class SparseArrayKt {
    public static final boolean contains(SparseArray arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.indexOfKey(arg2) >= 0) {
            return 1;
        }

        return 0;
    }

    public static final boolean containsKey(SparseArray arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.indexOfKey(arg2) >= 0) {
            return 1;
        }

        return 0;
    }

    public static final boolean containsValue(SparseArray arg1, Object arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.indexOfValue(arg2) >= 0) {
            return 1;
        }

        return 0;
    }

    public static final void forEach(SparseArray arg4, Function2 arg5) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        Intrinsics.checkNotNullParameter(arg5, "action");
        int v0 = arg4.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            arg5.invoke(Integer.valueOf(arg4.keyAt(v1)), arg4.valueAt(v1));
        }
    }

    public static final Object getOrDefault(SparseArray arg1, int arg2, Object arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Object v1 = arg1.get(arg2);
        if(v1 == null) {
            return arg3;
        }

        return v1;
    }

    public static final Object getOrElse(SparseArray arg1, int arg2, Function0 arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "defaultValue");
        Object v1 = arg1.get(arg2);
        if(v1 == null) {
            v1 = arg3.invoke();
        }

        return v1;
    }

    public static final int getSize(SparseArray arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.size();
    }

    public static final boolean isEmpty(SparseArray arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.size() == 0) {
            return 1;
        }

        return 0;
    }

    public static final boolean isNotEmpty(SparseArray arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.size() != 0) {
            return 1;
        }

        return 0;
    }

    public static final IntIterator keyIterator(SparseArray arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return new SparseArrayKt$keyIterator$1(arg1);
    }

    public static final SparseArray plus(SparseArray arg3, SparseArray arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "other");
        SparseArray v0 = new SparseArray(arg3.size() + arg4.size());
        SparseArrayKt.putAll(v0, arg3);
        SparseArrayKt.putAll(v0, arg4);
        return v0;
    }

    public static final void putAll(SparseArray arg4, SparseArray arg5) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        Intrinsics.checkNotNullParameter(arg5, "other");
        int v0 = arg5.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            arg4.put(arg5.keyAt(v1), arg5.valueAt(v1));
        }
    }

    public static final boolean remove(SparseArray arg1, int arg2, Object arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg2 = arg1.indexOfKey(arg2);
        if(arg2 >= 0 && (Intrinsics.areEqual(arg3, arg1.valueAt(arg2)))) {
            arg1.removeAt(arg2);
            return 1;
        }

        return 0;
    }

    public static final void set(SparseArray arg1, int arg2, Object arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1.put(arg2, arg3);
    }

    public static final Iterator valueIterator(SparseArray arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return new SparseArrayKt$valueIterator$1(arg1);
    }
}

