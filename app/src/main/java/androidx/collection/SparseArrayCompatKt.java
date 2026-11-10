package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000,\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u001B\n\u0002\u0010\u000E\n\u0002\b\u0005\u001A.\u0010\u0002\u001A\u00020\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u0002H\u0004H\u0080\b¢\u0006\u0002\u0010\t\u001A\u0019\u0010\n\u001A\u00020\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005H\u0080\b\u001A!\u0010\u000B\u001A\u00020\f\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0080\b\u001A&\u0010\r\u001A\u00020\f\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\b\u001A\u0002H\u0004H\u0080\b¢\u0006\u0002\u0010\u000E\u001A\'\u0010\u000F\u001A\u0004\u0018\u0001H\u0004\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0000¢\u0006\u0002\u0010\u0010\u001A-\u0010\u000F\u001A\u0002H\u0004\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u0011\u001A\u0002H\u0004H\u0000¢\u0006\u0002\u0010\u0012\u001A!\u0010\u0013\u001A\u00020\u0007\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0080\b\u001A&\u0010\u0014\u001A\u00020\u0007\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\b\u001A\u0002H\u0004H\u0080\b¢\u0006\u0002\u0010\u0015\u001A\u0019\u0010\u0016\u001A\u00020\f\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005H\u0080\b\u001A!\u0010\u0017\u001A\u00020\u0007\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0018\u001A\u00020\u0007H\u0080\b\u001A.\u0010\u0019\u001A\u00020\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u0002H\u0004H\u0080\b¢\u0006\u0002\u0010\t\u001A)\u0010\u001A\u001A\u00020\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u000E\u0010\u001B\u001A\n\u0012\u0006\b\u0001\u0012\u0002H\u00040\u0005H\u0080\b\u001A0\u0010\u001C\u001A\u0004\u0018\u0001H\u0004\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u0002H\u0004H\u0080\b¢\u0006\u0002\u0010\u0012\u001A \u0010\u001D\u001A\u00020\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0000\u001A+\u0010\u001D\u001A\u00020\f\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0006\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\u0001H\u0080\b\u001A!\u0010\u001E\u001A\u00020\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0018\u001A\u00020\u0007H\u0080\b\u001A)\u0010\u001F\u001A\u00020\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0018\u001A\u00020\u00072\u0006\u0010 \u001A\u00020\u0007H\u0080\b\u001A0\u0010!\u001A\u0004\u0018\u0001H\u0004\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u0002H\u0004H\u0080\b¢\u0006\u0002\u0010\u0012\u001A6\u0010!\u001A\u00020\f\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\"\u001A\u0002H\u00042\u0006\u0010#\u001A\u0002H\u0004H\u0080\b¢\u0006\u0002\u0010$\u001A.\u0010%\u001A\u00020\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0018\u001A\u00020\u00072\u0006\u0010\b\u001A\u0002H\u0004H\u0080\b¢\u0006\u0002\u0010\t\u001A\u0019\u0010&\u001A\u00020\u0007\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005H\u0080\b\u001A\u0019\u0010\'\u001A\u00020(\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005H\u0080\b\u001A&\u0010)\u001A\u0002H\u0004\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0018\u001A\u00020\u0007H\u0080\b¢\u0006\u0002\u0010\u0010\u001A\u0018\u0010*\u001A\u00020\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005H\u0002\u001A:\u0010+\u001A\u0002H,\"\u0004\b\u0000\u0010\u0004\"\n\b\u0001\u0010,*\u0004\u0018\u0001H\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u0011\u001A\u0002H,H\u0082\b¢\u0006\u0002\u0010\u0012\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2={"DELETED", "", "commonAppend", "", "E", "Landroidx/collection/SparseArrayCompat;", "key", "", "value", "(Landroidx/collection/SparseArrayCompat;ILjava/lang/Object;)V", "commonClear", "commonContainsKey", "", "commonContainsValue", "(Landroidx/collection/SparseArrayCompat;Ljava/lang/Object;)Z", "commonGet", "(Landroidx/collection/SparseArrayCompat;I)Ljava/lang/Object;", "defaultValue", "(Landroidx/collection/SparseArrayCompat;ILjava/lang/Object;)Ljava/lang/Object;", "commonIndexOfKey", "commonIndexOfValue", "(Landroidx/collection/SparseArrayCompat;Ljava/lang/Object;)I", "commonIsEmpty", "commonKeyAt", "index", "commonPut", "commonPutAll", "other", "commonPutIfAbsent", "commonRemove", "commonRemoveAt", "commonRemoveAtRange", "size", "commonReplace", "oldValue", "newValue", "(Landroidx/collection/SparseArrayCompat;ILjava/lang/Object;Ljava/lang/Object;)Z", "commonSetValueAt", "commonSize", "commonToString", "", "commonValueAt", "gc", "internalGet", "T", "collection"}, k=2, mv={1, 9, 0}, xi=0x30) public final class SparseArrayCompatKt {
    private static final Object DELETED;

    static {
        SparseArrayCompatKt.DELETED = new Object();
    }

    public static final void access$gc(SparseArrayCompat arg0) {
        SparseArrayCompatKt.gc(arg0);
    }

    public static final Object access$getDELETED$p() {
        return SparseArrayCompatKt.DELETED;
    }

    public static final void commonAppend(SparseArrayCompat arg4, int arg5, Object arg6) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        if(arg4.size != 0 && arg5 <= arg4.keys[arg4.size - 1]) {
            arg4.put(arg5, arg6);
            return;
        }

        if((arg4.garbage) && arg4.size >= arg4.keys.length) {
            SparseArrayCompatKt.gc(arg4);
        }

        int v0 = arg4.size;
        if(v0 >= arg4.keys.length) {
            int v1 = ContainerHelpersKt.idealIntArraySize(v0 + 1);
            int[] v2 = Arrays.copyOf(arg4.keys, v1);
            Intrinsics.checkNotNullExpressionValue(v2, "copyOf(...)");
            arg4.keys = v2;
            Object[] v1_1 = Arrays.copyOf(arg4.values, v1);
            Intrinsics.checkNotNullExpressionValue(v1_1, "copyOf(...)");
            arg4.values = v1_1;
        }

        arg4.keys[v0] = arg5;
        arg4.values[v0] = arg6;
        arg4.size = v0 + 1;
    }

    public static final void commonClear(SparseArrayCompat arg5) {
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        int v0 = arg5.size;
        Object[] v1 = arg5.values;
        int v3;
        for(v3 = 0; v3 < v0; ++v3) {
            v1[v3] = null;
        }

        arg5.size = 0;
        arg5.garbage = false;
    }

    public static final boolean commonContainsKey(SparseArrayCompat arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.indexOfKey(arg2) >= 0) {
            return 1;
        }

        return 0;
    }

    public static final boolean commonContainsValue(SparseArrayCompat arg4, Object arg5) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        if(arg4.garbage) {
            SparseArrayCompatKt.gc(arg4);
        }

        int v0 = arg4.size;
        int v2 = 0;
        while(true) {
            if(v2 >= v0) {
                break;
            }
            else if(arg4.values[v2] == arg5) {
            }
            else {
                ++v2;
                continue;
            }

            goto label_16;
        }

        v2 = -1;
    label_16:
        if(v2 >= 0) {
            return 1;
        }

        return 0;
    }

    public static final Object commonGet(SparseArrayCompat arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        arg3 = ContainerHelpersKt.binarySearch(arg2.keys, arg2.size, arg3);
        if(arg3 >= 0) {
            if(arg2.values[arg3] == SparseArrayCompatKt.DELETED) {
            }
            else {
                return arg2.values[arg3];
            }
        }

        return null;
    }

    public static final Object commonGet(SparseArrayCompat arg2, int arg3, Object arg4) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        arg3 = ContainerHelpersKt.binarySearch(arg2.keys, arg2.size, arg3);
        if(arg3 >= 0) {
            if(arg2.values[arg3] == SparseArrayCompatKt.DELETED) {
            }
            else {
                return arg2.values[arg3];
            }
        }

        return arg4;
    }

    public static final int commonIndexOfKey(SparseArrayCompat arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.garbage) {
            SparseArrayCompatKt.gc(arg1);
        }

        return ContainerHelpersKt.binarySearch(arg1.keys, arg1.size, arg2);
    }

    public static final int commonIndexOfValue(SparseArrayCompat arg3, Object arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        if(arg3.garbage) {
            SparseArrayCompatKt.gc(arg3);
        }

        int v0 = arg3.size;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            if(arg3.values[v1] == arg4) {
                return v1;
            }
        }

        return -1;
    }

    public static final boolean commonIsEmpty(SparseArrayCompat arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.size() == 0) {
            return 1;
        }

        return 0;
    }

    public static final int commonKeyAt(SparseArrayCompat arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.garbage) {
            SparseArrayCompatKt.gc(arg1);
        }

        return arg1.keys[arg2];
    }

    public static final void commonPut(SparseArrayCompat arg5, int arg6, Object arg7) {
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        int v0 = ContainerHelpersKt.binarySearch(arg5.keys, arg5.size, arg6);
        if(v0 >= 0) {
            arg5.values[v0] = arg7;
            return;
        }

        v0 = ~v0;
        if(v0 < arg5.size && arg5.values[v0] == SparseArrayCompatKt.DELETED) {
            arg5.keys[v0] = arg6;
            arg5.values[v0] = arg7;
            return;
        }

        if((arg5.garbage) && arg5.size >= arg5.keys.length) {
            SparseArrayCompatKt.gc(arg5);
            v0 = ~ContainerHelpersKt.binarySearch(arg5.keys, arg5.size, arg6);
        }

        if(arg5.size >= arg5.keys.length) {
            int v1 = ContainerHelpersKt.idealIntArraySize(arg5.size + 1);
            int[] v2 = Arrays.copyOf(arg5.keys, v1);
            Intrinsics.checkNotNullExpressionValue(v2, "copyOf(...)");
            arg5.keys = v2;
            Object[] v1_1 = Arrays.copyOf(arg5.values, v1);
            Intrinsics.checkNotNullExpressionValue(v1_1, "copyOf(...)");
            arg5.values = v1_1;
        }

        if(arg5.size - v0 != 0) {
            int v3 = v0 + 1;
            ArraysKt.copyInto(arg5.keys, arg5.keys, v3, v0, arg5.size);
            ArraysKt.copyInto(arg5.values, arg5.values, v3, v0, arg5.size);
        }

        arg5.keys[v0] = arg6;
        arg5.values[v0] = arg7;
        ++arg5.size;
    }

    public static final void commonPutAll(SparseArrayCompat arg9, SparseArrayCompat arg10) {
        Intrinsics.checkNotNullParameter(arg9, "<this>");
        Intrinsics.checkNotNullParameter(arg10, "other");
        int v0 = arg10.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            int v2 = arg10.keyAt(v1);
            Object v3 = arg10.valueAt(v1);
            int v4 = ContainerHelpersKt.binarySearch(arg9.keys, arg9.size, v2);
            if(v4 >= 0) {
                arg9.values[v4] = v3;
            }
            else {
                v4 = ~v4;
                if(v4 < arg9.size && arg9.values[v4] == SparseArrayCompatKt.DELETED) {
                    arg9.keys[v4] = v2;
                    arg9.values[v4] = v3;
                    goto label_74;
                }

                if((arg9.garbage) && arg9.size >= arg9.keys.length) {
                    SparseArrayCompatKt.gc(arg9);
                    v4 = ~ContainerHelpersKt.binarySearch(arg9.keys, arg9.size, v2);
                }

                if(arg9.size >= arg9.keys.length) {
                    int v5 = ContainerHelpersKt.idealIntArraySize(arg9.size + 1);
                    int[] v6 = Arrays.copyOf(arg9.keys, v5);
                    Intrinsics.checkNotNullExpressionValue(v6, "copyOf(...)");
                    arg9.keys = v6;
                    Object[] v5_1 = Arrays.copyOf(arg9.values, v5);
                    Intrinsics.checkNotNullExpressionValue(v5_1, "copyOf(...)");
                    arg9.values = v5_1;
                }

                if(arg9.size - v4 != 0) {
                    int v7 = v4 + 1;
                    ArraysKt.copyInto(arg9.keys, arg9.keys, v7, v4, arg9.size);
                    ArraysKt.copyInto(arg9.values, arg9.values, v7, v4, arg9.size);
                }

                arg9.keys[v4] = v2;
                arg9.values[v4] = v3;
                ++arg9.size;
            }

        label_74:
        }
    }

    public static final Object commonPutIfAbsent(SparseArrayCompat arg6, int arg7, Object arg8) {
        Intrinsics.checkNotNullParameter(arg6, "<this>");
        Object v0 = SparseArrayCompatKt.commonGet(arg6, arg7);
        if(v0 == null) {
            int v1 = ContainerHelpersKt.binarySearch(arg6.keys, arg6.size, arg7);
            if(v1 >= 0) {
                arg6.values[v1] = arg8;
                return v0;
            }
            else {
                v1 = ~v1;
                if(v1 < arg6.size && arg6.values[v1] == SparseArrayCompatKt.DELETED) {
                    arg6.keys[v1] = arg7;
                    arg6.values[v1] = arg8;
                    return v0;
                }

                if((arg6.garbage) && arg6.size >= arg6.keys.length) {
                    SparseArrayCompatKt.gc(arg6);
                    v1 = ~ContainerHelpersKt.binarySearch(arg6.keys, arg6.size, arg7);
                }

                if(arg6.size >= arg6.keys.length) {
                    int v2 = ContainerHelpersKt.idealIntArraySize(arg6.size + 1);
                    int[] v3 = Arrays.copyOf(arg6.keys, v2);
                    Intrinsics.checkNotNullExpressionValue(v3, "copyOf(...)");
                    arg6.keys = v3;
                    Object[] v2_1 = Arrays.copyOf(arg6.values, v2);
                    Intrinsics.checkNotNullExpressionValue(v2_1, "copyOf(...)");
                    arg6.values = v2_1;
                }

                if(arg6.size - v1 != 0) {
                    int v4 = v1 + 1;
                    ArraysKt.copyInto(arg6.keys, arg6.keys, v4, v1, arg6.size);
                    ArraysKt.copyInto(arg6.values, arg6.values, v4, v1, arg6.size);
                }

                arg6.keys[v1] = arg7;
                arg6.values[v1] = arg8;
                ++arg6.size;
            }
        }

        return v0;
    }

    public static final void commonRemove(SparseArrayCompat arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        arg3 = ContainerHelpersKt.binarySearch(arg2.keys, arg2.size, arg3);
        if(arg3 >= 0) {
            Object v0 = arg2.values[arg3];
            Object v1 = SparseArrayCompatKt.DELETED;
            if(v0 != v1) {
                arg2.values[arg3] = v1;
                arg2.garbage = true;
            }
        }
    }

    public static final boolean commonRemove(SparseArrayCompat arg1, int arg2, Object arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg2 = arg1.indexOfKey(arg2);
        if(arg2 >= 0 && (Intrinsics.areEqual(arg3, arg1.valueAt(arg2)))) {
            arg1.removeAt(arg2);
            return 1;
        }

        return 0;
    }

    public static final void commonRemoveAt(SparseArrayCompat arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        if(arg2.values[arg3] != SparseArrayCompatKt.DELETED) {
            arg2.values[arg3] = SparseArrayCompatKt.DELETED;
            arg2.garbage = true;
        }
    }

    public static final void commonRemoveAtRange(SparseArrayCompat arg1, int arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg3 = Math.min(arg3, arg2 + arg3);
        while(arg2 < arg3) {
            arg1.removeAt(arg2);
            ++arg2;
        }
    }

    public static final Object commonReplace(SparseArrayCompat arg1, int arg2, Object arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg2 = arg1.indexOfKey(arg2);
        if(arg2 >= 0) {
            Object v0 = arg1.values[arg2];
            arg1.values[arg2] = arg3;
            return v0;
        }

        return null;
    }

    public static final boolean commonReplace(SparseArrayCompat arg1, int arg2, Object arg3, Object arg4) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg2 = arg1.indexOfKey(arg2);
        if(arg2 >= 0 && (Intrinsics.areEqual(arg1.values[arg2], arg3))) {
            arg1.values[arg2] = arg4;
            return 1;
        }

        return 0;
    }

    public static final void commonSetValueAt(SparseArrayCompat arg1, int arg2, Object arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.garbage) {
            SparseArrayCompatKt.gc(arg1);
        }

        arg1.values[arg2] = arg3;
    }

    public static final int commonSize(SparseArrayCompat arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.garbage) {
            SparseArrayCompatKt.gc(arg1);
        }

        return arg1.size;
    }

    public static final String commonToString(SparseArrayCompat arg4) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        if(arg4.size() <= 0) {
            return "{}";
        }

        StringBuilder v0 = new StringBuilder(arg4.size * 28);
        v0.append('{');
        int v1 = arg4.size;
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            if(v2 > 0) {
                v0.append(", ");
            }

            v0.append(arg4.keyAt(v2));
            v0.append('=');
            Object v3 = arg4.valueAt(v2);
            if((((SparseArrayCompat)v3)) != arg4) {
                v0.append(v3);
            }
            else {
                v0.append("(this Map)");
            }
        }

        v0.append('}');
        String v4 = v0.toString();
        Intrinsics.checkNotNullExpressionValue(v4, "toString(...)");
        return v4;
    }

    public static final Object commonValueAt(SparseArrayCompat arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.garbage) {
            SparseArrayCompatKt.gc(arg1);
        }

        if(arg2 < arg1.values.length) {
            return arg1.values[arg2];
        }

        throw new ArrayIndexOutOfBoundsException();
    }

    private static final void gc(SparseArrayCompat arg8) {
        int v0 = arg8.size;
        int[] v1 = arg8.keys;
        Object[] v2 = arg8.values;
        int v4 = 0;
        int v5 = 0;
        while(v4 < v0) {
            Object v6 = v2[v4];
            if(v6 != SparseArrayCompatKt.DELETED) {
                if(v4 != v5) {
                    v1[v5] = v1[v4];
                    v2[v5] = v6;
                    v2[v4] = null;
                }

                ++v5;
            }

            ++v4;
        }

        arg8.garbage = false;
        arg8.size = v5;
    }

    private static final Object internalGet(SparseArrayCompat arg2, int arg3, Object arg4) {
        arg3 = ContainerHelpersKt.binarySearch(arg2.keys, arg2.size, arg3);
        if(arg3 >= 0) {
            if(arg2.values[arg3] == SparseArrayCompatKt.DELETED) {
            }
            else {
                return arg2.values[arg3];
            }
        }

        return arg4;
    }
}

