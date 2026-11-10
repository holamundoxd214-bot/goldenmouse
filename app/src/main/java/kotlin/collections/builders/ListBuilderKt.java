package kotlin.collections.builders;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00008\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\u001E\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\u001A#\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0080\u0080\u0004¢\u0006\u0002\u0010\u0005\u001A?\u0010\u0006\u001A\u00020\u0007\"\u0004\b\u0000\u0010\b*\n\u0012\u0006\b\u0001\u0012\u0002H\b0\u00012\u0006\u0010\t\u001A\u00020\u00042\u0006\u0010\n\u001A\u00020\u00042\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u0002H\b0\fH\u0082\u0080\u0004¢\u0006\u0002\u0010\r\u001A/\u0010\u000E\u001A\u00020\u0004\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u00012\u0006\u0010\t\u001A\u00020\u00042\u0006\u0010\n\u001A\u00020\u0004H\u0082\u0080\u0004¢\u0006\u0002\u0010\u000F\u001A;\u0010\u0010\u001A\u00020\u0011\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u00012\u0006\u0010\t\u001A\u00020\u00042\u0006\u0010\n\u001A\u00020\u00042\n\u0010\u0012\u001A\u0006\u0012\u0002\b\u00030\u0013H\u0082\u0080\u0004¢\u0006\u0002\u0010\u0014\u001A-\u0010\u0015\u001A\b\u0012\u0004\u0012\u0002H\b0\u0001\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u00012\u0006\u0010\u0016\u001A\u00020\u0004H\u0080\u0080\u0004¢\u0006\u0002\u0010\u0017\u001A\'\u0010\u0018\u001A\u00020\u0019\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u001A\u001A\u00020\u0004H\u0080\u0080\u0004¢\u0006\u0002\u0010\u001B\u001A/\u0010\u001C\u001A\u00020\u0019\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u001D\u001A\u00020\u00042\u0006\u0010\u001E\u001A\u00020\u0004H\u0080\u0080\u0004¢\u0006\u0002\u0010\u001F¨\u0006 "}, d2={"arrayOfUninitializedElements", "", "E", "size", "", "(I)[Ljava/lang/Object;", "subarrayContentToString", "", "T", "offset", "length", "thisCollection", "", "([Ljava/lang/Object;IILjava/util/Collection;)Ljava/lang/String;", "subarrayContentHashCode", "([Ljava/lang/Object;II)I", "subarrayContentEquals", "", "other", "", "([Ljava/lang/Object;IILjava/util/List;)Z", "copyOfUninitializedElements", "newSize", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "resetAt", "", "index", "([Ljava/lang/Object;I)V", "resetRange", "fromIndex", "toIndex", "([Ljava/lang/Object;II)V", "kotlin-stdlib"}, k=2, mv={2, 3, 0}, xi=0x30) public final class ListBuilderKt {
    public static final boolean access$subarrayContentEquals(Object[] arg0, int arg1, int arg2, List arg3) {
        return ListBuilderKt.subarrayContentEquals(arg0, arg1, arg2, arg3);
    }

    public static final int access$subarrayContentHashCode(Object[] arg0, int arg1, int arg2) {
        return ListBuilderKt.subarrayContentHashCode(arg0, arg1, arg2);
    }

    public static final String access$subarrayContentToString(Object[] arg0, int arg1, int arg2, Collection arg3) {
        return ListBuilderKt.subarrayContentToString(arg0, arg1, arg2, arg3);
    }

    public static final Object[] arrayOfUninitializedElements(int arg1) {
        if(arg1 >= 0) {
            return new Object[arg1];
        }

        throw new IllegalArgumentException("capacity must be non-negative.".toString());
    }

    public static final Object[] copyOfUninitializedElements(Object[] arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1 = Arrays.copyOf(arg1, arg2);
        Intrinsics.checkNotNullExpressionValue(arg1, "copyOf(...)");
        return arg1;
    }

    public static final void resetAt(Object[] arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1[arg2] = null;
    }

    public static final void resetRange(Object[] arg1, int arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        while(arg2 < arg3) {
            ListBuilderKt.resetAt(arg1, arg2);
            ++arg2;
        }
    }

    private static final boolean subarrayContentEquals(Object[] arg4, int arg5, int arg6, List arg7) {
        if(arg6 != arg7.size()) {
            return 0;
        }

        int v0;
        for(v0 = 0; v0 < arg6; ++v0) {
            if(!Intrinsics.areEqual(arg4[arg5 + v0], arg7.get(v0))) {
                return 0;
            }
        }

        return 1;
    }

    private static final int subarrayContentHashCode(Object[] arg4, int arg5, int arg6) {
        int v0 = 1;
        int v2;
        for(v2 = 0; v2 < arg6; ++v2) {
            Object v3 = arg4[arg5 + v2];
            v0 *= 0x1F;
            int v3_1 = v3 != null ? v3.hashCode() : 0;
            v0 += v3_1;
        }

        return v0;
    }

    private static final String subarrayContentToString(Object[] arg3, int arg4, int arg5, Collection arg6) {
        StringBuilder v0 = new StringBuilder(arg5 * 3 + 2);
        v0.append("[");
        int v1;
        for(v1 = 0; v1 < arg5; ++v1) {
            if(v1 > 0) {
                v0.append(", ");
            }

            Object v2 = arg3[arg4 + v1];
            if((((Collection)v2)) == arg6) {
                v0.append("(this Collection)");
            }
            else {
                v0.append(v2);
            }
        }

        v0.append("]");
        String v3 = v0.toString();
        Intrinsics.checkNotNullExpressionValue(v3, "toString(...)");
        return v3;
    }
}

