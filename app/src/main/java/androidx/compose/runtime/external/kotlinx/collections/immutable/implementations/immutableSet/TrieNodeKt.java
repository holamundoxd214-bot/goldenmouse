package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000\"\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\u001A\u0018\u0010\u0005\u001A\u00020\u00012\u0006\u0010\u0006\u001A\u00020\u00012\u0006\u0010\u0007\u001A\u00020\u0001H\u0000\u001A7\u0010\b\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\"\u0004\b\u0000\u0010\u000B*\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\u0006\u0010\u0006\u001A\u00020\u00012\u0006\u0010\f\u001A\u0002H\u000BH\u0002¢\u0006\u0002\u0010\r\u001A)\u0010\u000E\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t*\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\u0006\u0010\u000F\u001A\u00020\u0001H\u0002¢\u0006\u0002\u0010\u0010\u001AL\u0010\u0011\u001A\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\u000E\u0010\u0012\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\b\b\u0002\u0010\u0013\u001A\u00020\u00012\u0016\b\u0002\u0010\u0014\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00160\u0015H\u0082\b¢\u0006\u0002\u0010\u0017\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0002\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0003\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0004\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2={"MAX_BRANCHING_FACTOR", "", "LOG_MAX_BRANCHING_FACTOR", "MAX_BRANCHING_FACTOR_MINUS_ONE", "MAX_SHIFT", "indexSegment", "index", "shift", "addElementAtIndex", "", "", "E", "element", "([Ljava/lang/Object;ILjava/lang/Object;)[Ljava/lang/Object;", "removeCellAtIndex", "cellIndex", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "filterTo", "newArray", "newArrayOffset", "predicate", "Lkotlin/Function1;", "", "([Ljava/lang/Object;[Ljava/lang/Object;ILkotlin/jvm/functions/Function1;)I", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class TrieNodeKt {
    public static final int LOG_MAX_BRANCHING_FACTOR = 5;
    public static final int MAX_BRANCHING_FACTOR = 0x20;
    public static final int MAX_BRANCHING_FACTOR_MINUS_ONE = 0x1F;
    public static final int MAX_SHIFT = 30;

    public static final Object[] access$addElementAtIndex(Object[] arg0, int arg1, Object arg2) {
        return TrieNodeKt.addElementAtIndex(arg0, arg1, arg2);
    }

    public static final Object[] access$removeCellAtIndex(Object[] arg0, int arg1) {
        return TrieNodeKt.removeCellAtIndex(arg0, arg1);
    }

    private static final Object[] addElementAtIndex(Object[] arg8, int arg9, Object arg10) {
        Object[] v2 = new Object[arg8.length + 1];
        ArraysKt.copyInto$default(arg8, v2, 0, 0, arg9, 6, null);
        ArraysKt.copyInto(arg8, v2, arg9 + 1, arg9, arg8.length);
        v2[arg9] = arg10;
        return v2;
    }

    private static final int filterTo(Object[] arg6, Object[] arg7, int arg8, Function1 arg9) {
        int v1 = 0;
        int v2 = 0;
        while(v1 < arg6.length) {
            boolean v3 = true;
            boolean v4 = v2 <= v1 ? true : false;
            CommonFunctionsKt.assert(v4);
            if(arg9.invoke(arg6[v1]).booleanValue()) {
                arg7[arg8 + v2] = arg6[v1];
                ++v2;
                if(arg8 + v2 <= arg7.length) {
                }
                else {
                    v3 = false;
                }

                CommonFunctionsKt.assert(v3);
            }

            ++v1;
        }

        return v2;
    }

    static int filterTo$default(Object[] arg4, Object[] arg5, int arg6, Function1 arg7, int arg8, Object arg9) {
        if((arg8 & 4) != 0) {
            TrieNodeKt$filterTo$1 v7 = TrieNodeKt$filterTo$1.INSTANCE;
        }

        arg8 = 0;
        int v9 = 0;
        while(arg8 < arg4.length) {
            boolean v1 = true;
            boolean v2 = v9 <= arg8 ? true : false;
            CommonFunctionsKt.assert(v2);
            if(((Function1)v7).invoke(arg4[arg8]).booleanValue()) {
                arg5[v9] = arg4[arg8];
                ++v9;
                if(v9 <= arg5.length) {
                }
                else {
                    v1 = false;
                }

                CommonFunctionsKt.assert(v1);
            }

            ++arg8;
        }

        return v9;
    }

    public static final int indexSegment(int arg0, int arg1) {
        return arg0 >> arg1 & 0x1F;
    }

    private static final Object[] removeCellAtIndex(Object[] arg8, int arg9) {
        Object[] v2 = new Object[arg8.length - 1];
        ArraysKt.copyInto$default(arg8, v2, 0, 0, arg9, 6, null);
        ArraysKt.copyInto(arg8, v2, arg9, arg9 + 1, arg8.length);
        return v2;
    }
}

