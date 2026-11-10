package androidx.collection;

import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000@\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010(\n\u0000\u001A!\u0010\u0006\u001A\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001A\u00020\u0001H\u0086\n\u001AT\u0010\t\u001A\u00020\n\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000326\u0010\u000B\u001A2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\r\u0012\b\b\u000E\u0012\u0004\b\b(\b\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\r\u0012\b\b\u000E\u0012\u0004\b\b(\u000F\u0012\u0004\u0012\u00020\n0\fH\u0086\bø\u0001\u0000\u001A.\u0010\u0010\u001A\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001A\u00020\u00012\u0006\u0010\u0011\u001A\u0002H\u0002H\u0086\b¢\u0006\u0002\u0010\u0012\u001A7\u0010\u0013\u001A\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001A\u00020\u00012\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0014H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0015\u001A\u0019\u0010\u0016\u001A\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\b\u001A\u0016\u0010\u0017\u001A\u00020\u0018\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\u001A-\u0010\u0019\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u001A\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\u0002\u001A-\u0010\u001B\u001A\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001A\u00020\u00012\u0006\u0010\u000F\u001A\u0002H\u0002H\u0007¢\u0006\u0002\u0010\u001C\u001A.\u0010\u001D\u001A\u00020\n\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001A\u00020\u00012\u0006\u0010\u000F\u001A\u0002H\u0002H\u0086\n¢\u0006\u0002\u0010\u001E\u001A\u001C\u0010\u001F\u001A\b\u0012\u0004\u0012\u0002H\u00020 \"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\"\u0010\u0000\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00038Æ\u0002¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006!"}, d2={"size", "", "T", "Landroidx/collection/SparseArrayCompat;", "getSize", "(Landroidx/collection/SparseArrayCompat;)I", "contains", "", "key", "forEach", "", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "value", "getOrDefault", "defaultValue", "(Landroidx/collection/SparseArrayCompat;ILjava/lang/Object;)Ljava/lang/Object;", "getOrElse", "Lkotlin/Function0;", "(Landroidx/collection/SparseArrayCompat;ILkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isNotEmpty", "keyIterator", "Lkotlin/collections/IntIterator;", "plus", "other", "remove", "(Landroidx/collection/SparseArrayCompat;ILjava/lang/Object;)Z", "set", "(Landroidx/collection/SparseArrayCompat;ILjava/lang/Object;)V", "valueIterator", "", "collection"}, k=2, mv={1, 9, 0}, xi=0x30) public final class SparseArrayKt {
    public static final boolean contains(SparseArrayCompat arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.containsKey(arg2);
    }

    public static final void forEach(SparseArrayCompat arg4, Function2 arg5) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        Intrinsics.checkNotNullParameter(arg5, "action");
        int v0 = arg4.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            arg5.invoke(Integer.valueOf(arg4.keyAt(v1)), arg4.valueAt(v1));
        }
    }

    public static final Object getOrDefault(SparseArrayCompat arg1, int arg2, Object arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.get(arg2, arg3);
    }

    public static final Object getOrElse(SparseArrayCompat arg1, int arg2, Function0 arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "defaultValue");
        Object v1 = arg1.get(arg2);
        if(v1 == null) {
            v1 = arg3.invoke();
        }

        return v1;
    }

    public static final int getSize(SparseArrayCompat arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.size();
    }

    public static final boolean isNotEmpty(SparseArrayCompat arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.isEmpty() ^ 1;
    }

    public static final IntIterator keyIterator(SparseArrayCompat arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return new SparseArrayKt$keyIterator$1(arg1);
    }

    public static final SparseArrayCompat plus(SparseArrayCompat arg3, SparseArrayCompat arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "other");
        SparseArrayCompat v0 = new SparseArrayCompat(arg3.size() + arg4.size());
        v0.putAll(arg3);
        v0.putAll(arg4);
        return v0;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Replaced with member function. Remove extension import!") public static final boolean remove(SparseArrayCompat arg1, int arg2, Object arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.remove(arg2, arg3);
    }

    public static final void set(SparseArrayCompat arg1, int arg2, Object arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1.put(arg2, arg3);
    }

    public static final Iterator valueIterator(SparseArrayCompat arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return new SparseArrayKt$valueIterator$1(arg1);
    }
}

