package kotlin.jvm.internal;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u00002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001E\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A%\u0010\u0006\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001A\u0006\u0012\u0002\b\u00030\bH\u0087\u0080\u0004¢\u0006\u0004\b\t\u0010\n\u001A7\u0010\u0006\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001A\u0006\u0012\u0002\b\u00030\b2\u0010\u0010\u000B\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001H\u0087\u0080\u0004¢\u0006\u0004\b\t\u0010\f\u001A\u007F\u0010\r\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001A\u0006\u0012\u0002\b\u00030\b2\u0014\u0010\u000E\u001A\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u000F2\u001A\u0010\u0010\u001A\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u00112(\u0010\u0012\u001A$\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u0013H\u0082\u0088\u0004¢\u0006\u0002\u0010\u0014\"\u0019\u0010\u0000\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0082\u0084\b¢\u0006\u0004\n\u0002\u0010\u0003\"\u000F\u0010\u0004\u001A\u00020\u0005X\u0082Ô\b¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2={"EMPTY", "", "", "[Ljava/lang/Object;", "MAX_SIZE", "", "collectionToArray", "collection", "", "toArray", "(Ljava/util/Collection;)[Ljava/lang/Object;", "a", "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "toArrayImpl", "empty", "Lkotlin/Function0;", "alloc", "Lkotlin/Function1;", "trim", "Lkotlin/Function2;", "(Ljava/util/Collection;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)[Ljava/lang/Object;", "kotlin-stdlib"}, k=2, mv={2, 3, 0}, xi=0x30) public final class CollectionToArray {
    private static final Object[] EMPTY = null;
    private static final int MAX_SIZE = 0x7FFFFFFD;

    static {
        CollectionToArray.EMPTY = new Object[0];
    }

    @Deprecated(message="This function will be made internal in a future release") @DeprecatedSinceKotlin(errorSince="2.1", warningSince="1.9") public static final Object[] toArray(Collection arg4) {
        Intrinsics.checkNotNullParameter(arg4, "collection");
        int v0 = arg4.size();
        if(v0 == 0) {
            return CollectionToArray.EMPTY;
        }

        Iterator v4 = arg4.iterator();
        if(!v4.hasNext()) {
            return CollectionToArray.EMPTY;
        }

        Object[] v0_1 = new Object[v0];
        int v1;
        for(v1 = 0; true; v1 = v2) {
            int v2 = v1 + 1;
            v0_1[v1] = v4.next();
            String v3 = "copyOf(...)";
            if(v2 < v0_1.length) {
                if(v4.hasNext()) {
                    goto label_40;
                }

                Object[] v4_1 = Arrays.copyOf(v0_1, v2);
                Intrinsics.checkNotNullExpressionValue(v4_1, v3);
                return v4_1;
            }
            else if(!v4.hasNext()) {
                return v0_1;
            }
            else {
                v1 = v2 * 3 + 1 >>> 1;
                if(v1 <= v2) {
                    v1 = 0x7FFFFFFD;
                    if(v2 < v1) {
                    }
                    else {
                        throw new OutOfMemoryError();
                    }
                }

                v0_1 = Arrays.copyOf(v0_1, v1);
                Intrinsics.checkNotNullExpressionValue(v0_1, v3);
            }

        label_40:
        }
    }

    @Deprecated(message="This function will be made internal in a future release") @DeprecatedSinceKotlin(errorSince="2.1", warningSince="1.9") public static final Object[] toArray(Collection arg5, Object[] arg6) {
        Object[] v0_1;
        Iterator v5;
        Intrinsics.checkNotNullParameter(arg5, "collection");
        arg6.getClass();
        int v0 = arg5.size();
        Object v1 = null;
        int v2 = 0;
        if(v0 != 0) {
            v5 = arg5.iterator();
            if(v5.hasNext()) {
                goto label_18;
            }
            else if(arg6.length > 0) {
                arg6[0] = v1;
            }
        }
        else if(arg6.length > 0) {
            arg6[0] = v1;
            return arg6;
        }

        return arg6;
    label_18:
        if(v0 <= arg6.length) {
            v0_1 = arg6;
        }
        else {
            Object v0_2 = Array.newInstance(arg6.getClass().getComponentType(), v0);
            Intrinsics.checkNotNull(v0_2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        }

        while(true) {
            int v3 = v2 + 1;
            v0_1[v2] = v5.next();
            String v4 = "copyOf(...)";
            if(v3 < v0_1.length) {
                if(v5.hasNext()) {
                    goto label_57;
                }

                if(v0_1 == arg6) {
                    arg6[v3] = v1;
                    return arg6;
                }

                Object[] v5_1 = Arrays.copyOf(v0_1, v3);
                Intrinsics.checkNotNullExpressionValue(v5_1, v4);
                return v5_1;
            }
            else if(!v5.hasNext()) {
                return v0_1;
            }
            else {
                v2 = v3 * 3 + 1 >>> 1;
                if(v2 <= v3) {
                    v2 = 0x7FFFFFFD;
                    if(v3 < v2) {
                    }
                    else {
                        throw new OutOfMemoryError();
                    }
                }

                v0_1 = Arrays.copyOf(v0_1, v2);
                Intrinsics.checkNotNullExpressionValue(v0_1, v4);
            }

        label_57:
            v2 = v3;
        }
    }

    private static final Object[] toArrayImpl(Collection arg2, Function0 arg3, Function1 arg4, Function2 arg5) {
        Object[] v3_1;
        int v0 = arg2.size();
        if(v0 == 0) {
            return arg3.invoke();
        }

        Iterator v2 = arg2.iterator();
        if(!v2.hasNext()) {
            return arg3.invoke();
        }

        Object v3 = arg4.invoke(Integer.valueOf(v0));
        int v4;
        for(v4 = 0; true; v4 = v0) {
            v0 = v4 + 1;
            v3[v4] = v2.next();
            if(v0 < v3.length) {
                if(v2.hasNext()) {
                    goto label_39;
                }

                return arg5.invoke(v3_1, Integer.valueOf(v0));
            }
            else if(!v2.hasNext()) {
                return ((Object[])v3);
            }
            else {
                v4 = v0 * 3 + 1 >>> 1;
                if(v4 <= v0) {
                    v4 = 0x7FFFFFFD;
                    if(v0 < v4) {
                    }
                    else {
                        throw new OutOfMemoryError();
                    }
                }

                v3_1 = Arrays.copyOf(v3_1, v4);
                Intrinsics.checkNotNullExpressionValue(v3_1, "copyOf(...)");
            }

        label_39:
        }
    }
}

