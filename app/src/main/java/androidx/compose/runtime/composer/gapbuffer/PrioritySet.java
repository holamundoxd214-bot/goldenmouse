package androidx.compose.runtime.composer.gapbuffer;

import androidx.collection.IntList;
import androidx.collection.MutableIntList;
import androidx.compose.runtime.PreconditionsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0010\n\u0002\u0010\u000E\n\u0000\b\u0081@\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BJ\r\u0010\f\u001A\u00020\r¢\u0006\u0004\b\u000E\u0010\u000FJ\r\u0010\u0010\u001A\u00020\r¢\u0006\u0004\b\u0011\u0010\u000FJ\r\u0010\u0012\u001A\u00020\t¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001A\u00020\t¢\u0006\u0004\b\u0016\u0010\u0014J\r\u0010\u0017\u001A\u00020\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0014\u0010\u001A\u001A\u00020\r2\b\u0010\u001B\u001A\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001C\u001A\u00020\tHÖ\u0081\u0004J\n\u0010\u001D\u001A\u00020\u001EHÖ\u0081\u0004R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u001F"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/PrioritySet;", "", "list", "Landroidx/collection/MutableIntList;", "constructor-impl", "(Landroidx/collection/MutableIntList;)Landroidx/collection/MutableIntList;", "add", "", "value", "", "add-impl", "(Landroidx/collection/MutableIntList;I)V", "isEmpty", "", "isEmpty-impl", "(Landroidx/collection/MutableIntList;)Z", "isNotEmpty", "isNotEmpty-impl", "peek", "peek-impl", "(Landroidx/collection/MutableIntList;)I", "takeMax", "takeMax-impl", "validateHeap", "validateHeap-impl", "(Landroidx/collection/MutableIntList;)V", "equals", "other", "hashCode", "toString", "", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) @JvmInline public final class PrioritySet {
    private final MutableIntList list;

    private PrioritySet(MutableIntList arg1) {
        super();
        this.list = arg1;
    }

    public static final void add-impl(MutableIntList arg3, int arg4) {
        MutableIntList v0 = arg3;
        if(((IntList)v0)._size != 0 && (arg3.get(0) == arg4 || arg3.get(((IntList)v0)._size - 1) == arg4)) {
            return;
        }

        int v0_1 = ((IntList)v0)._size;
        arg3.add(arg4);
        while(v0_1 > 0) {
            int v1 = (v0_1 + 1 >>> 1) - 1;
            int v2 = arg3.get(v1);
            if(arg4 <= v2) {
                break;
            }

            arg3.set(v0_1, v2);
            v0_1 = v1;
        }

        arg3.set(v0_1, arg4);
    }

    public static final PrioritySet box-impl(MutableIntList arg1) {
        return new PrioritySet(arg1);
    }

    public static MutableIntList constructor-impl(MutableIntList arg0) {
        return arg0;
    }

    public static MutableIntList constructor-impl$default(MutableIntList arg1, int arg2, DefaultConstructorMarker arg3) {
        if((arg2 & 1) != 0) {
            arg1 = new MutableIntList(0, 1, null);
        }

        return PrioritySet.constructor-impl(arg1);
    }

    public boolean equals(Object arg1) {
        return PrioritySet.equals-impl(this.list, arg1);
    }

    public static boolean equals-impl(MutableIntList arg2, Object arg3) {
        if(!(arg3 instanceof PrioritySet)) {
            return 0;
        }

        if(!Intrinsics.areEqual(arg2, ((PrioritySet)arg3).unbox-impl())) {
            return 0;
        }

        return 1;
    }

    public static final boolean equals-impl0(MutableIntList arg0, MutableIntList arg1) {
        return Intrinsics.areEqual(arg0, arg1);
    }

    public int hashCode() {
        return PrioritySet.hashCode-impl(this.list);
    }

    public static int hashCode-impl(MutableIntList arg0) {
        return arg0.hashCode();
    }

    public static final boolean isEmpty-impl(MutableIntList arg0) {
        if(((IntList)arg0)._size == 0) {
            return 1;
        }

        return 0;
    }

    public static final boolean isNotEmpty-impl(MutableIntList arg0) {
        if(((IntList)arg0)._size != 0) {
            return 1;
        }

        return 0;
    }

    public static final int peek-impl(MutableIntList arg0) {
        return arg0.first();
    }

    public static final int takeMax-impl(MutableIntList arg11) {
        int v9;
        int v8;
        int v6;
        int v5;
        MutableIntList v0 = arg11;
        int v2 = arg11.get(0);
        do {
        label_4:
            if(((IntList)v0)._size != 0 && arg11.get(0) == v2) {
                arg11.set(0, arg11.last());
                arg11.removeAt(((IntList)v0)._size - 1);
                int v3 = ((IntList)v0)._size;
                int v4 = ((IntList)v0)._size >>> 1;
                v5 = 0;
                while(true) {
                label_17:
                    if(v5 >= v4) {
                        goto label_4;
                    }

                    v6 = arg11.get(v5);
                    int v7 = (v5 + 1) * 2;
                    v8 = v7 - 1;
                    v9 = arg11.get(v8);
                    if(v7 < v3) {
                        int v10 = arg11.get(v7);
                        if(v10 > v9) {
                            if(v10 <= v6) {
                                goto label_4;
                            }

                            arg11.set(v5, v10);
                            arg11.set(v7, v6);
                            v5 = v7;
                            continue;
                        }
                    }

                    if(v9 <= v6) {
                        goto label_4;
                    }

                    goto label_32;
                }
            }

            return v2;
        }
        while(true);

    label_32:
        arg11.set(v5, v9);
        arg11.set(v8, v6);
        v5 = v8;
        goto label_17;
        return v2;
    }

    public String toString() {
        return PrioritySet.toString-impl(this.list);
    }

    public static String toString-impl(MutableIntList arg2) {
        return "PrioritySet(list=" + arg2 + ')';
    }

    public final MutableIntList unbox-impl() {
        return this.list;
    }

    public static final void validateHeap-impl(MutableIntList arg9) {
        int v0 = arg9._size;
        int v1 = v0 / 2;
        int v3;
        for(v3 = 0; v3 < v1; v3 = v4) {
            int v4 = v3 + 1;
            int v5 = v4 * 2;
            int v8 = 1;
            int v6 = arg9.get(v3) >= arg9.get(v5 - 1) ? 1 : 0;
            String v7 = "Check failed.";
            if(v6 == 0) {
                PreconditionsKt.throwIllegalStateException(v7);
            }

            if(v5 < v0) {
                if(arg9.get(v3) >= arg9.get(v5)) {
                }
                else {
                    v8 = 0;
                }
            }

            if(v8 == 0) {
                PreconditionsKt.throwIllegalStateException(v7);
            }
        }
    }
}

