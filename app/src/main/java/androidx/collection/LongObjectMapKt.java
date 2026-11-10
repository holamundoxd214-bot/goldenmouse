package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0015\u001AD\u0010\u0003\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u001D\u0010\u0006\u001A\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u0001\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\b\tH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001AL\u0010\u0003\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\n\u001A\u00020\u000B2\u001D\u0010\u0006\u001A\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u0001\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\b\tH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001A\u0012\u0010\f\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u0005\u001A\u0012\u0010\r\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u0005\u001A\'\u0010\r\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u0002H\u0005¢\u0006\u0002\u0010\u0011\u001A7\u0010\r\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u0002H\u00052\u0006\u0010\u0012\u001A\u00020\u000F2\u0006\u0010\u0013\u001A\u0002H\u0005¢\u0006\u0002\u0010\u0014\u001AG\u0010\r\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u0002H\u00052\u0006\u0010\u0012\u001A\u00020\u000F2\u0006\u0010\u0013\u001A\u0002H\u00052\u0006\u0010\u0015\u001A\u00020\u000F2\u0006\u0010\u0016\u001A\u0002H\u0005¢\u0006\u0002\u0010\u0017\u001AW\u0010\r\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u0002H\u00052\u0006\u0010\u0012\u001A\u00020\u000F2\u0006\u0010\u0013\u001A\u0002H\u00052\u0006\u0010\u0015\u001A\u00020\u000F2\u0006\u0010\u0016\u001A\u0002H\u00052\u0006\u0010\u0018\u001A\u00020\u000F2\u0006\u0010\u0019\u001A\u0002H\u0005¢\u0006\u0002\u0010\u001A\u001Ag\u0010\r\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u0002H\u00052\u0006\u0010\u0012\u001A\u00020\u000F2\u0006\u0010\u0013\u001A\u0002H\u00052\u0006\u0010\u0015\u001A\u00020\u000F2\u0006\u0010\u0016\u001A\u0002H\u00052\u0006\u0010\u0018\u001A\u00020\u000F2\u0006\u0010\u0019\u001A\u0002H\u00052\u0006\u0010\u001B\u001A\u00020\u000F2\u0006\u0010\u001C\u001A\u0002H\u0005¢\u0006\u0002\u0010\u001D\u001A\u0012\u0010\u001E\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u0005\u001A\'\u0010\u001E\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u0002H\u0005¢\u0006\u0002\u0010\u001F\u001A7\u0010\u001E\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u0002H\u00052\u0006\u0010\u0012\u001A\u00020\u000F2\u0006\u0010\u0013\u001A\u0002H\u0005¢\u0006\u0002\u0010 \u001AG\u0010\u001E\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u0002H\u00052\u0006\u0010\u0012\u001A\u00020\u000F2\u0006\u0010\u0013\u001A\u0002H\u00052\u0006\u0010\u0015\u001A\u00020\u000F2\u0006\u0010\u0016\u001A\u0002H\u0005¢\u0006\u0002\u0010!\u001AW\u0010\u001E\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u0002H\u00052\u0006\u0010\u0012\u001A\u00020\u000F2\u0006\u0010\u0013\u001A\u0002H\u00052\u0006\u0010\u0015\u001A\u00020\u000F2\u0006\u0010\u0016\u001A\u0002H\u00052\u0006\u0010\u0018\u001A\u00020\u000F2\u0006\u0010\u0019\u001A\u0002H\u0005¢\u0006\u0002\u0010\"\u001Ag\u0010\u001E\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u0002H\u00052\u0006\u0010\u0012\u001A\u00020\u000F2\u0006\u0010\u0013\u001A\u0002H\u00052\u0006\u0010\u0015\u001A\u00020\u000F2\u0006\u0010\u0016\u001A\u0002H\u00052\u0006\u0010\u0018\u001A\u00020\u000F2\u0006\u0010\u0019\u001A\u0002H\u00052\u0006\u0010\u001B\u001A\u00020\u000F2\u0006\u0010\u001C\u001A\u0002H\u0005¢\u0006\u0002\u0010#\"\u0014\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006$"}, d2={"EmptyLongObjectMap", "Landroidx/collection/MutableLongObjectMap;", "", "buildLongObjectMap", "Landroidx/collection/LongObjectMap;", "V", "builderAction", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "initialCapacity", "", "emptyLongObjectMap", "longObjectMapOf", "key1", "", "value1", "(JLjava/lang/Object;)Landroidx/collection/LongObjectMap;", "key2", "value2", "(JLjava/lang/Object;JLjava/lang/Object;)Landroidx/collection/LongObjectMap;", "key3", "value3", "(JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;)Landroidx/collection/LongObjectMap;", "key4", "value4", "(JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;)Landroidx/collection/LongObjectMap;", "key5", "value5", "(JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;)Landroidx/collection/LongObjectMap;", "mutableLongObjectMapOf", "(JLjava/lang/Object;)Landroidx/collection/MutableLongObjectMap;", "(JLjava/lang/Object;JLjava/lang/Object;)Landroidx/collection/MutableLongObjectMap;", "(JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;)Landroidx/collection/MutableLongObjectMap;", "(JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;)Landroidx/collection/MutableLongObjectMap;", "(JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;)Landroidx/collection/MutableLongObjectMap;", "collection"}, k=2, mv={1, 9, 0}, xi=0x30) public final class LongObjectMapKt {
    private static final MutableLongObjectMap EmptyLongObjectMap;

    static {
        LongObjectMapKt.EmptyLongObjectMap = new MutableLongObjectMap(0);
    }

    public static final LongObjectMap buildLongObjectMap(int arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "builderAction");
        MutableLongObjectMap v0 = new MutableLongObjectMap(arg1);
        arg2.invoke(v0);
        return ((LongObjectMap)v0);
    }

    public static final LongObjectMap buildLongObjectMap(Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg4, "builderAction");
        MutableLongObjectMap v0 = new MutableLongObjectMap(0, 1, null);
        arg4.invoke(v0);
        return ((LongObjectMap)v0);
    }

    public static final LongObjectMap emptyLongObjectMap() {
        MutableLongObjectMap v0 = LongObjectMapKt.EmptyLongObjectMap;
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type androidx.collection.LongObjectMap<V of androidx.collection.LongObjectMapKt.emptyLongObjectMap>");
        return ((LongObjectMap)v0);
    }

    public static final LongObjectMap longObjectMapOf() {
        MutableLongObjectMap v0 = LongObjectMapKt.EmptyLongObjectMap;
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type androidx.collection.LongObjectMap<V of androidx.collection.LongObjectMapKt.longObjectMapOf>");
        return ((LongObjectMap)v0);
    }

    public static final LongObjectMap longObjectMapOf(long arg4, Object arg6) {
        MutableLongObjectMap v0 = new MutableLongObjectMap(0, 1, null);
        v0.set(arg4, arg6);
        return ((LongObjectMap)v0);
    }

    public static final LongObjectMap longObjectMapOf(long arg4, Object arg6, long arg7, Object arg9) {
        MutableLongObjectMap v0 = new MutableLongObjectMap(0, 1, null);
        v0.set(arg4, arg6);
        v0.set(arg7, arg9);
        return ((LongObjectMap)v0);
    }

    public static final LongObjectMap longObjectMapOf(long arg4, Object arg6, long arg7, Object arg9, long arg10, Object arg12) {
        MutableLongObjectMap v0 = new MutableLongObjectMap(0, 1, null);
        v0.set(arg4, arg6);
        v0.set(arg7, arg9);
        v0.set(arg10, arg12);
        return ((LongObjectMap)v0);
    }

    public static final LongObjectMap longObjectMapOf(long arg4, Object arg6, long arg7, Object arg9, long arg10, Object arg12, long arg13, Object arg15) {
        MutableLongObjectMap v0 = new MutableLongObjectMap(0, 1, null);
        v0.set(arg4, arg6);
        v0.set(arg7, arg9);
        v0.set(arg10, arg12);
        v0.set(arg13, arg15);
        return ((LongObjectMap)v0);
    }

    public static final LongObjectMap longObjectMapOf(long arg4, Object arg6, long arg7, Object arg9, long arg10, Object arg12, long arg13, Object arg15, long arg16, Object arg18) {
        MutableLongObjectMap v0 = new MutableLongObjectMap(0, 1, null);
        v0.set(arg4, arg6);
        v0.set(arg7, arg9);
        v0.set(arg10, arg12);
        v0.set(arg13, arg15);
        v0.set(arg16, arg18);
        return ((LongObjectMap)v0);
    }

    public static final MutableLongObjectMap mutableLongObjectMapOf() {
        return new MutableLongObjectMap(0, 1, null);
    }

    public static final MutableLongObjectMap mutableLongObjectMapOf(long arg4, Object arg6) {
        MutableLongObjectMap v0 = new MutableLongObjectMap(0, 1, null);
        v0.set(arg4, arg6);
        return v0;
    }

    public static final MutableLongObjectMap mutableLongObjectMapOf(long arg4, Object arg6, long arg7, Object arg9) {
        MutableLongObjectMap v0 = new MutableLongObjectMap(0, 1, null);
        v0.set(arg4, arg6);
        v0.set(arg7, arg9);
        return v0;
    }

    public static final MutableLongObjectMap mutableLongObjectMapOf(long arg4, Object arg6, long arg7, Object arg9, long arg10, Object arg12) {
        MutableLongObjectMap v0 = new MutableLongObjectMap(0, 1, null);
        v0.set(arg4, arg6);
        v0.set(arg7, arg9);
        v0.set(arg10, arg12);
        return v0;
    }

    public static final MutableLongObjectMap mutableLongObjectMapOf(long arg4, Object arg6, long arg7, Object arg9, long arg10, Object arg12, long arg13, Object arg15) {
        MutableLongObjectMap v0 = new MutableLongObjectMap(0, 1, null);
        v0.set(arg4, arg6);
        v0.set(arg7, arg9);
        v0.set(arg10, arg12);
        v0.set(arg13, arg15);
        return v0;
    }

    public static final MutableLongObjectMap mutableLongObjectMapOf(long arg4, Object arg6, long arg7, Object arg9, long arg10, Object arg12, long arg13, Object arg15, long arg16, Object arg18) {
        MutableLongObjectMap v0 = new MutableLongObjectMap(0, 1, null);
        v0.set(arg4, arg6);
        v0.set(arg7, arg9);
        v0.set(arg10, arg12);
        v0.set(arg13, arg15);
        v0.set(arg16, arg18);
        return v0;
    }
}

