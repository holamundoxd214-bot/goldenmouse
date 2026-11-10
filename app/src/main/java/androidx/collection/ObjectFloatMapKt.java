package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0015\u001AD\u0010\u0003\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u001D\u0010\u0006\u001A\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u0001\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\b\tH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001AL\u0010\u0003\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\n\u001A\u00020\u000B2\u001D\u0010\u0006\u001A\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u0001\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\b\tH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001A\u0012\u0010\f\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u0005\u001A\u0012\u0010\r\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u0005\u001A\'\u0010\r\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u000E\u001A\u0002H\u00052\u0006\u0010\u000F\u001A\u00020\u0010¢\u0006\u0002\u0010\u0011\u001A7\u0010\r\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u000E\u001A\u0002H\u00052\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0012\u001A\u0002H\u00052\u0006\u0010\u0013\u001A\u00020\u0010¢\u0006\u0002\u0010\u0014\u001AG\u0010\r\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u000E\u001A\u0002H\u00052\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0012\u001A\u0002H\u00052\u0006\u0010\u0013\u001A\u00020\u00102\u0006\u0010\u0015\u001A\u0002H\u00052\u0006\u0010\u0016\u001A\u00020\u0010¢\u0006\u0002\u0010\u0017\u001AW\u0010\r\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u000E\u001A\u0002H\u00052\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0012\u001A\u0002H\u00052\u0006\u0010\u0013\u001A\u00020\u00102\u0006\u0010\u0015\u001A\u0002H\u00052\u0006\u0010\u0016\u001A\u00020\u00102\u0006\u0010\u0018\u001A\u0002H\u00052\u0006\u0010\u0019\u001A\u00020\u0010¢\u0006\u0002\u0010\u001A\u001Ag\u0010\r\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u000E\u001A\u0002H\u00052\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0012\u001A\u0002H\u00052\u0006\u0010\u0013\u001A\u00020\u00102\u0006\u0010\u0015\u001A\u0002H\u00052\u0006\u0010\u0016\u001A\u00020\u00102\u0006\u0010\u0018\u001A\u0002H\u00052\u0006\u0010\u0019\u001A\u00020\u00102\u0006\u0010\u001B\u001A\u0002H\u00052\u0006\u0010\u001C\u001A\u00020\u0010¢\u0006\u0002\u0010\u001D\u001A\u0012\u0010\u001E\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u0005\u001A\'\u0010\u001F\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u000E\u001A\u0002H\u00052\u0006\u0010\u000F\u001A\u00020\u0010¢\u0006\u0002\u0010 \u001A7\u0010\u001F\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u000E\u001A\u0002H\u00052\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0012\u001A\u0002H\u00052\u0006\u0010\u0013\u001A\u00020\u0010¢\u0006\u0002\u0010!\u001AG\u0010\u001F\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u000E\u001A\u0002H\u00052\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0012\u001A\u0002H\u00052\u0006\u0010\u0013\u001A\u00020\u00102\u0006\u0010\u0015\u001A\u0002H\u00052\u0006\u0010\u0016\u001A\u00020\u0010¢\u0006\u0002\u0010\"\u001AW\u0010\u001F\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u000E\u001A\u0002H\u00052\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0012\u001A\u0002H\u00052\u0006\u0010\u0013\u001A\u00020\u00102\u0006\u0010\u0015\u001A\u0002H\u00052\u0006\u0010\u0016\u001A\u00020\u00102\u0006\u0010\u0018\u001A\u0002H\u00052\u0006\u0010\u0019\u001A\u00020\u0010¢\u0006\u0002\u0010#\u001Ag\u0010\u001F\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u000E\u001A\u0002H\u00052\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0012\u001A\u0002H\u00052\u0006\u0010\u0013\u001A\u00020\u00102\u0006\u0010\u0015\u001A\u0002H\u00052\u0006\u0010\u0016\u001A\u00020\u00102\u0006\u0010\u0018\u001A\u0002H\u00052\u0006\u0010\u0019\u001A\u00020\u00102\u0006\u0010\u001B\u001A\u0002H\u00052\u0006\u0010\u001C\u001A\u00020\u0010¢\u0006\u0002\u0010$\"\u0016\u0010\u0000\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006%"}, d2={"EmptyObjectFloatMap", "Landroidx/collection/MutableObjectFloatMap;", "", "buildObjectFloatMap", "Landroidx/collection/ObjectFloatMap;", "K", "builderAction", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "initialCapacity", "", "emptyObjectFloatMap", "mutableObjectFloatMapOf", "key1", "value1", "", "(Ljava/lang/Object;F)Landroidx/collection/MutableObjectFloatMap;", "key2", "value2", "(Ljava/lang/Object;FLjava/lang/Object;F)Landroidx/collection/MutableObjectFloatMap;", "key3", "value3", "(Ljava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;F)Landroidx/collection/MutableObjectFloatMap;", "key4", "value4", "(Ljava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;F)Landroidx/collection/MutableObjectFloatMap;", "key5", "value5", "(Ljava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;F)Landroidx/collection/MutableObjectFloatMap;", "objectFloatMap", "objectFloatMapOf", "(Ljava/lang/Object;F)Landroidx/collection/ObjectFloatMap;", "(Ljava/lang/Object;FLjava/lang/Object;F)Landroidx/collection/ObjectFloatMap;", "(Ljava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;F)Landroidx/collection/ObjectFloatMap;", "(Ljava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;F)Landroidx/collection/ObjectFloatMap;", "(Ljava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;F)Landroidx/collection/ObjectFloatMap;", "collection"}, k=2, mv={1, 9, 0}, xi=0x30) public final class ObjectFloatMapKt {
    private static final MutableObjectFloatMap EmptyObjectFloatMap;

    static {
        ObjectFloatMapKt.EmptyObjectFloatMap = new MutableObjectFloatMap(0);
    }

    public static final ObjectFloatMap buildObjectFloatMap(int arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "builderAction");
        MutableObjectFloatMap v0 = new MutableObjectFloatMap(arg1);
        arg2.invoke(v0);
        return ((ObjectFloatMap)v0);
    }

    public static final ObjectFloatMap buildObjectFloatMap(Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg4, "builderAction");
        MutableObjectFloatMap v0 = new MutableObjectFloatMap(0, 1, null);
        arg4.invoke(v0);
        return ((ObjectFloatMap)v0);
    }

    public static final ObjectFloatMap emptyObjectFloatMap() {
        MutableObjectFloatMap v0 = ObjectFloatMapKt.EmptyObjectFloatMap;
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type androidx.collection.ObjectFloatMap<K of androidx.collection.ObjectFloatMapKt.emptyObjectFloatMap>");
        return ((ObjectFloatMap)v0);
    }

    public static final MutableObjectFloatMap mutableObjectFloatMapOf() {
        return new MutableObjectFloatMap(0, 1, null);
    }

    public static final MutableObjectFloatMap mutableObjectFloatMapOf(Object arg4, float arg5) {
        MutableObjectFloatMap v0 = new MutableObjectFloatMap(0, 1, null);
        v0.set(arg4, arg5);
        return v0;
    }

    public static final MutableObjectFloatMap mutableObjectFloatMapOf(Object arg4, float arg5, Object arg6, float arg7) {
        MutableObjectFloatMap v0 = new MutableObjectFloatMap(0, 1, null);
        v0.set(arg4, arg5);
        v0.set(arg6, arg7);
        return v0;
    }

    public static final MutableObjectFloatMap mutableObjectFloatMapOf(Object arg4, float arg5, Object arg6, float arg7, Object arg8, float arg9) {
        MutableObjectFloatMap v0 = new MutableObjectFloatMap(0, 1, null);
        v0.set(arg4, arg5);
        v0.set(arg6, arg7);
        v0.set(arg8, arg9);
        return v0;
    }

    public static final MutableObjectFloatMap mutableObjectFloatMapOf(Object arg4, float arg5, Object arg6, float arg7, Object arg8, float arg9, Object arg10, float arg11) {
        MutableObjectFloatMap v0 = new MutableObjectFloatMap(0, 1, null);
        v0.set(arg4, arg5);
        v0.set(arg6, arg7);
        v0.set(arg8, arg9);
        v0.set(arg10, arg11);
        return v0;
    }

    public static final MutableObjectFloatMap mutableObjectFloatMapOf(Object arg4, float arg5, Object arg6, float arg7, Object arg8, float arg9, Object arg10, float arg11, Object arg12, float arg13) {
        MutableObjectFloatMap v0 = new MutableObjectFloatMap(0, 1, null);
        v0.set(arg4, arg5);
        v0.set(arg6, arg7);
        v0.set(arg8, arg9);
        v0.set(arg10, arg11);
        v0.set(arg12, arg13);
        return v0;
    }

    public static final ObjectFloatMap objectFloatMap() {
        MutableObjectFloatMap v0 = ObjectFloatMapKt.EmptyObjectFloatMap;
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type androidx.collection.ObjectFloatMap<K of androidx.collection.ObjectFloatMapKt.objectFloatMap>");
        return ((ObjectFloatMap)v0);
    }

    public static final ObjectFloatMap objectFloatMapOf(Object arg4, float arg5) {
        MutableObjectFloatMap v0 = new MutableObjectFloatMap(0, 1, null);
        v0.set(arg4, arg5);
        return ((ObjectFloatMap)v0);
    }

    public static final ObjectFloatMap objectFloatMapOf(Object arg4, float arg5, Object arg6, float arg7) {
        MutableObjectFloatMap v0 = new MutableObjectFloatMap(0, 1, null);
        v0.set(arg4, arg5);
        v0.set(arg6, arg7);
        return ((ObjectFloatMap)v0);
    }

    public static final ObjectFloatMap objectFloatMapOf(Object arg4, float arg5, Object arg6, float arg7, Object arg8, float arg9) {
        MutableObjectFloatMap v0 = new MutableObjectFloatMap(0, 1, null);
        v0.set(arg4, arg5);
        v0.set(arg6, arg7);
        v0.set(arg8, arg9);
        return ((ObjectFloatMap)v0);
    }

    public static final ObjectFloatMap objectFloatMapOf(Object arg4, float arg5, Object arg6, float arg7, Object arg8, float arg9, Object arg10, float arg11) {
        MutableObjectFloatMap v0 = new MutableObjectFloatMap(0, 1, null);
        v0.set(arg4, arg5);
        v0.set(arg6, arg7);
        v0.set(arg8, arg9);
        v0.set(arg10, arg11);
        return ((ObjectFloatMap)v0);
    }

    public static final ObjectFloatMap objectFloatMapOf(Object arg4, float arg5, Object arg6, float arg7, Object arg8, float arg9, Object arg10, float arg11, Object arg12, float arg13) {
        MutableObjectFloatMap v0 = new MutableObjectFloatMap(0, 1, null);
        v0.set(arg4, arg5);
        v0.set(arg6, arg7);
        v0.set(arg8, arg9);
        v0.set(arg10, arg11);
        v0.set(arg12, arg13);
        return ((ObjectFloatMap)v0);
    }
}

