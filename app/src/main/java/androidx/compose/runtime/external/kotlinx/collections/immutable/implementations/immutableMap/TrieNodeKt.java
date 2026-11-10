package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001E\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\u001A\u0018\u0010\u0006\u001A\u00020\u00012\u0006\u0010\u0007\u001A\u00020\u00012\u0006\u0010\b\u001A\u00020\u0001H\u0000\u001AE\u0010\t\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u000B0\n\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\r*\n\u0012\u0006\u0012\u0004\u0018\u00010\u000B0\n2\u0006\u0010\u000E\u001A\u00020\u00012\u0006\u0010\u000F\u001A\u0002H\f2\u0006\u0010\u0010\u001A\u0002H\rH\u0002¢\u0006\u0002\u0010\u0011\u001AA\u0010\u0012\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u000B0\n*\n\u0012\u0006\u0012\u0004\u0018\u00010\u000B0\n2\u0006\u0010\u000E\u001A\u00020\u00012\u0006\u0010\u0013\u001A\u00020\u00012\u000E\u0010\u0014\u001A\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0015H\u0002¢\u0006\u0002\u0010\u0016\u001AM\u0010\u0017\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u000B0\n\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\r*\n\u0012\u0006\u0012\u0004\u0018\u00010\u000B0\n2\u0006\u0010\u0013\u001A\u00020\u00012\u0006\u0010\u000E\u001A\u00020\u00012\u0006\u0010\u000F\u001A\u0002H\f2\u0006\u0010\u0010\u001A\u0002H\rH\u0002¢\u0006\u0002\u0010\u0018\u001A)\u0010\u0019\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u000B0\n*\n\u0012\u0006\u0012\u0004\u0018\u00010\u000B0\n2\u0006\u0010\u000E\u001A\u00020\u0001H\u0002¢\u0006\u0002\u0010\u001A\u001A)\u0010\u001B\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u000B0\n*\n\u0012\u0006\u0012\u0004\u0018\u00010\u000B0\n2\u0006\u0010\u0013\u001A\u00020\u0001H\u0002¢\u0006\u0002\u0010\u001A\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0002\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0003\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0004\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0005\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u001C"}, d2={"MAX_BRANCHING_FACTOR", "", "LOG_MAX_BRANCHING_FACTOR", "MAX_BRANCHING_FACTOR_MINUS_ONE", "ENTRY_SIZE", "MAX_SHIFT", "indexSegment", "index", "shift", "insertEntryAtIndex", "", "", "K", "V", "keyIndex", "key", "value", "([Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Object;)[Ljava/lang/Object;", "replaceEntryWithNode", "nodeIndex", "newNode", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "([Ljava/lang/Object;IILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;)[Ljava/lang/Object;", "replaceNodeWithEntry", "([Ljava/lang/Object;IILjava/lang/Object;Ljava/lang/Object;)[Ljava/lang/Object;", "removeEntryAtIndex", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "removeNodeAtIndex", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class TrieNodeKt {
    public static final int ENTRY_SIZE = 2;
    public static final int LOG_MAX_BRANCHING_FACTOR = 5;
    public static final int MAX_BRANCHING_FACTOR = 0x20;
    public static final int MAX_BRANCHING_FACTOR_MINUS_ONE = 0x1F;
    public static final int MAX_SHIFT = 30;

    public static final Object[] access$insertEntryAtIndex(Object[] arg0, int arg1, Object arg2, Object arg3) {
        return TrieNodeKt.insertEntryAtIndex(arg0, arg1, arg2, arg3);
    }

    public static final Object[] access$removeEntryAtIndex(Object[] arg0, int arg1) {
        return TrieNodeKt.removeEntryAtIndex(arg0, arg1);
    }

    public static final Object[] access$removeNodeAtIndex(Object[] arg0, int arg1) {
        return TrieNodeKt.removeNodeAtIndex(arg0, arg1);
    }

    public static final Object[] access$replaceEntryWithNode(Object[] arg0, int arg1, int arg2, TrieNode arg3) {
        return TrieNodeKt.replaceEntryWithNode(arg0, arg1, arg2, arg3);
    }

    public static final Object[] access$replaceNodeWithEntry(Object[] arg0, int arg1, int arg2, Object arg3, Object arg4) {
        return TrieNodeKt.replaceNodeWithEntry(arg0, arg1, arg2, arg3, arg4);
    }

    public static final int indexSegment(int arg0, int arg1) {
        return arg0 >> arg1 & 0x1F;
    }

    private static final Object[] insertEntryAtIndex(Object[] arg8, int arg9, Object arg10, Object arg11) {
        Object[] v2 = new Object[arg8.length + 2];
        ArraysKt.copyInto$default(arg8, v2, 0, 0, arg9, 6, null);
        ArraysKt.copyInto(arg8, v2, arg9 + 2, arg9, arg8.length);
        v2[arg9] = arg10;
        v2[arg9 + 1] = arg11;
        return v2;
    }

    private static final Object[] removeEntryAtIndex(Object[] arg8, int arg9) {
        Object[] v2 = new Object[arg8.length - 2];
        ArraysKt.copyInto$default(arg8, v2, 0, 0, arg9, 6, null);
        ArraysKt.copyInto(arg8, v2, arg9, arg9 + 2, arg8.length);
        return v2;
    }

    private static final Object[] removeNodeAtIndex(Object[] arg8, int arg9) {
        Object[] v2 = new Object[arg8.length - 1];
        ArraysKt.copyInto$default(arg8, v2, 0, 0, arg9, 6, null);
        ArraysKt.copyInto(arg8, v2, arg9, arg9 + 1, arg8.length);
        return v2;
    }

    private static final Object[] replaceEntryWithNode(Object[] arg9, int arg10, int arg11, TrieNode arg12) {
        Object[] v3 = new Object[arg9.length - 1];
        ArraysKt.copyInto$default(arg9, v3, 0, 0, arg10, 6, null);
        ArraysKt.copyInto(arg9, v3, arg10, arg10 + 2, arg11);
        v3[arg11 - 2] = arg12;
        ArraysKt.copyInto(arg9, v3, arg11 - 1, arg11, arg9.length);
        return v3;
    }

    private static final Object[] replaceNodeWithEntry(Object[] arg3, int arg4, int arg5, Object arg6, Object arg7) {
        Object[] v0 = Arrays.copyOf(arg3, arg3.length + 1);
        Intrinsics.checkNotNullExpressionValue(v0, "copyOf(...)");
        ArraysKt.copyInto(v0, v0, arg4 + 2, arg4 + 1, arg3.length);
        ArraysKt.copyInto(v0, v0, arg5 + 2, arg5, arg4);
        v0[arg5] = arg6;
        v0[arg5 + 1] = arg7;
        return v0;
    }
}

