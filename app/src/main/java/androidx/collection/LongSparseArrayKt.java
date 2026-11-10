package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import androidx.collection.internal.RuntimeHelpersKt;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.LongIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000X\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u001D\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010(\n\u0000\u001A.\u0010\n\u001A\u00020\u000B\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u00052\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u0002H\fH\u0080\b¢\u0006\u0002\u0010\u0010\u001A\u0019\u0010\u0011\u001A\u00020\u000B\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u0005H\u0080\b\u001A!\u0010\u0012\u001A\u00020\u0013\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u00052\u0006\u0010\r\u001A\u00020\u000EH\u0080\b\u001A&\u0010\u0014\u001A\u00020\u0013\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u00052\u0006\u0010\u000F\u001A\u0002H\fH\u0080\b¢\u0006\u0002\u0010\u0015\u001A\u0019\u0010\u0016\u001A\u00020\u000B\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u0005H\u0080\b\u001A(\u0010\u0017\u001A\u0004\u0018\u0001H\f\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u00052\u0006\u0010\r\u001A\u00020\u000EH\u0080\b¢\u0006\u0002\u0010\u0018\u001A.\u0010\u0017\u001A\u0002H\f\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u00052\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u0019\u001A\u0002H\fH\u0080\b¢\u0006\u0002\u0010\u001A\u001A%\u0010\u001B\u001A\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\r\u001A\u00020\u000E2\b\u0010\u0019\u001A\u0004\u0018\u00010\u0001H\u0080\b\u001A!\u0010\u001C\u001A\u00020\u0003\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u00052\u0006\u0010\r\u001A\u00020\u000EH\u0080\b\u001A&\u0010\u001D\u001A\u00020\u0003\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u00052\u0006\u0010\u000F\u001A\u0002H\fH\u0080\b¢\u0006\u0002\u0010\u001E\u001A\u0019\u0010\u001F\u001A\u00020\u0013\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u0005H\u0080\b\u001A!\u0010 \u001A\u00020\u000E\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u00052\u0006\u0010!\u001A\u00020\u0003H\u0080\b\u001A.\u0010\"\u001A\u00020\u000B\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u00052\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u0002H\fH\u0080\b¢\u0006\u0002\u0010\u0010\u001A)\u0010#\u001A\u00020\u000B\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u00052\u000E\u0010$\u001A\n\u0012\u0006\b\u0001\u0012\u0002H\f0\u0005H\u0080\b\u001A0\u0010%\u001A\u0004\u0018\u0001H\f\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u00052\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u0002H\fH\u0080\b¢\u0006\u0002\u0010\u001A\u001A!\u0010&\u001A\u00020\u000B\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u00052\u0006\u0010\r\u001A\u00020\u000EH\u0080\b\u001A.\u0010&\u001A\u00020\u0013\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u00052\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u0002H\fH\u0080\b¢\u0006\u0002\u0010\'\u001A!\u0010(\u001A\u00020\u000B\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u00052\u0006\u0010!\u001A\u00020\u0003H\u0080\b\u001A0\u0010)\u001A\u0004\u0018\u0001H\f\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u00052\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u0002H\fH\u0080\b¢\u0006\u0002\u0010\u001A\u001A6\u0010)\u001A\u00020\u0013\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u00052\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010*\u001A\u0002H\f2\u0006\u0010+\u001A\u0002H\fH\u0080\b¢\u0006\u0002\u0010,\u001A.\u0010-\u001A\u00020\u000B\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u00052\u0006\u0010!\u001A\u00020\u00032\u0006\u0010\u000F\u001A\u0002H\fH\u0080\b¢\u0006\u0002\u0010.\u001A\u0019\u0010/\u001A\u00020\u0003\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u0005H\u0080\b\u001A\u0019\u00100\u001A\u000201\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u0005H\u0080\b\u001A&\u00102\u001A\u0002H\f\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u00052\u0006\u0010!\u001A\u00020\u0003H\u0080\b¢\u0006\u0002\u00103\u001A!\u00104\u001A\u00020\u0013\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\r\u001A\u00020\u000EH\u0086\n\u001AT\u00105\u001A\u00020\u000B\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u000526\u00106\u001A2\u0012\u0013\u0012\u00110\u000E¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(\r\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(\u000F\u0012\u0004\u0012\u00020\u000B07H\u0086\bø\u0001\u0000\u001A.\u0010:\u001A\u0002H\u0004\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u0019\u001A\u0002H\u0004H\u0086\b¢\u0006\u0002\u0010\u001A\u001A7\u0010;\u001A\u0002H\u0004\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\r\u001A\u00020\u000E2\f\u0010\u0019\u001A\b\u0012\u0004\u0012\u0002H\u00040<H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010=\u001A\u0019\u0010>\u001A\u00020\u0013\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005H\u0086\b\u001A\u0016\u0010?\u001A\u00020@\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005\u001A-\u0010A\u001A\b\u0012\u0004\u0012\u0002H\u00040\u0005\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\f\u0010$\u001A\b\u0012\u0004\u0012\u0002H\u00040\u0005H\u0086\u0002\u001A-\u0010B\u001A\u00020\u0013\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u0002H\u0004H\u0007¢\u0006\u0002\u0010\'\u001A.\u0010C\u001A\u00020\u000B\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u0002H\u0004H\u0086\n¢\u0006\u0002\u0010\u0010\u001A\u001C\u0010D\u001A\b\u0012\u0004\u0012\u0002H\u00040E\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"(\u0010\u0002\u001A\u00020\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00058Æ\u0002¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001A\u0004\b\b\u0010\t\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006F"}, d2={"DELETED", "", "size", "", "T", "Landroidx/collection/LongSparseArray;", "getSize$annotations", "(Landroidx/collection/LongSparseArray;)V", "getSize", "(Landroidx/collection/LongSparseArray;)I", "commonAppend", "", "E", "key", "", "value", "(Landroidx/collection/LongSparseArray;JLjava/lang/Object;)V", "commonClear", "commonContainsKey", "", "commonContainsValue", "(Landroidx/collection/LongSparseArray;Ljava/lang/Object;)Z", "commonGc", "commonGet", "(Landroidx/collection/LongSparseArray;J)Ljava/lang/Object;", "defaultValue", "(Landroidx/collection/LongSparseArray;JLjava/lang/Object;)Ljava/lang/Object;", "commonGetInternal", "commonIndexOfKey", "commonIndexOfValue", "(Landroidx/collection/LongSparseArray;Ljava/lang/Object;)I", "commonIsEmpty", "commonKeyAt", "index", "commonPut", "commonPutAll", "other", "commonPutIfAbsent", "commonRemove", "(Landroidx/collection/LongSparseArray;JLjava/lang/Object;)Z", "commonRemoveAt", "commonReplace", "oldValue", "newValue", "(Landroidx/collection/LongSparseArray;JLjava/lang/Object;Ljava/lang/Object;)Z", "commonSetValueAt", "(Landroidx/collection/LongSparseArray;ILjava/lang/Object;)V", "commonSize", "commonToString", "", "commonValueAt", "(Landroidx/collection/LongSparseArray;I)Ljava/lang/Object;", "contains", "forEach", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "getOrDefault", "getOrElse", "Lkotlin/Function0;", "(Landroidx/collection/LongSparseArray;JLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isNotEmpty", "keyIterator", "Lkotlin/collections/LongIterator;", "plus", "remove", "set", "valueIterator", "", "collection"}, k=2, mv={1, 9, 0}, xi=0x30) public final class LongSparseArrayKt {
    private static final Object DELETED;

    static {
        LongSparseArrayKt.DELETED = new Object();
    }

    public static final Object access$getDELETED$p() {
        return LongSparseArrayKt.DELETED;
    }

    public static final void commonAppend(LongSparseArray arg9, long arg10, Object arg12) {
        int v0;
        Intrinsics.checkNotNullParameter(arg9, "<this>");
        if(arg9.size != 0 && arg10 <= arg9.keys[arg9.size - 1]) {
            arg9.put(arg10, arg12);
            return;
        }

        if((arg9.garbage) && arg9.size >= arg9.keys.length) {
            v0 = arg9.size;
            long[] v1 = arg9.keys;
            Object[] v2 = arg9.values;
            int v4 = 0;
            int v5 = 0;
            while(v4 < v0) {
                Object v6 = v2[v4];
                if(v6 != LongSparseArrayKt.DELETED) {
                    if(v4 != v5) {
                        v1[v5] = v1[v4];
                        v2[v5] = v6;
                        v2[v4] = null;
                    }

                    ++v5;
                }

                ++v4;
            }

            arg9.garbage = false;
            arg9.size = v5;
        }

        v0 = arg9.size;
        if(v0 >= arg9.keys.length) {
            int v1_1 = ContainerHelpersKt.idealLongArraySize(v0 + 1);
            long[] v2_1 = Arrays.copyOf(arg9.keys, v1_1);
            Intrinsics.checkNotNullExpressionValue(v2_1, "copyOf(...)");
            arg9.keys = v2_1;
            Object[] v1_2 = Arrays.copyOf(arg9.values, v1_1);
            Intrinsics.checkNotNullExpressionValue(v1_2, "copyOf(...)");
            arg9.values = v1_2;
        }

        arg9.keys[v0] = arg10;
        arg9.values[v0] = arg12;
        arg9.size = v0 + 1;
    }

    public static final void commonClear(LongSparseArray arg5) {
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

    public static final boolean commonContainsKey(LongSparseArray arg1, long arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.indexOfKey(arg2) >= 0) {
            return 1;
        }

        return 0;
    }

    public static final boolean commonContainsValue(LongSparseArray arg1, Object arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.indexOfValue(arg2) >= 0) {
            return 1;
        }

        return 0;
    }

    public static final void commonGc(LongSparseArray arg9) {
        Intrinsics.checkNotNullParameter(arg9, "<this>");
        int v0 = arg9.size;
        long[] v1 = arg9.keys;
        Object[] v2 = arg9.values;
        int v4 = 0;
        int v5 = 0;
        while(v4 < v0) {
            Object v6 = v2[v4];
            if(v6 != LongSparseArrayKt.DELETED) {
                if(v4 != v5) {
                    v1[v5] = v1[v4];
                    v2[v5] = v6;
                    v2[v4] = null;
                }

                ++v5;
            }

            ++v4;
        }

        arg9.garbage = false;
        arg9.size = v5;
    }

    public static final Object commonGet(LongSparseArray arg2, long arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        int v3 = ContainerHelpersKt.binarySearch(arg2.keys, arg2.size, arg3);
        if(v3 >= 0) {
            if(arg2.values[v3] == LongSparseArrayKt.DELETED) {
            }
            else {
                return arg2.values[v3];
            }
        }

        return null;
    }

    public static final Object commonGet(LongSparseArray arg2, long arg3, Object arg5) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        int v3 = ContainerHelpersKt.binarySearch(arg2.keys, arg2.size, arg3);
        if(v3 >= 0) {
            if(arg2.values[v3] == LongSparseArrayKt.DELETED) {
            }
            else {
                return arg2.values[v3];
            }
        }

        return arg5;
    }

    public static final Object commonGetInternal(LongSparseArray arg2, long arg3, Object arg5) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        int v3 = ContainerHelpersKt.binarySearch(arg2.keys, arg2.size, arg3);
        if(v3 >= 0) {
            if(arg2.values[v3] == LongSparseArrayKt.DELETED) {
            }
            else {
                return arg2.values[v3];
            }
        }

        return arg5;
    }

    public static final int commonIndexOfKey(LongSparseArray arg9, long arg10) {
        Intrinsics.checkNotNullParameter(arg9, "<this>");
        if(arg9.garbage) {
            int v0 = arg9.size;
            long[] v1 = arg9.keys;
            Object[] v2 = arg9.values;
            int v4 = 0;
            int v5 = 0;
            while(v4 < v0) {
                Object v6 = v2[v4];
                if(v6 != LongSparseArrayKt.DELETED) {
                    if(v4 != v5) {
                        v1[v5] = v1[v4];
                        v2[v5] = v6;
                        v2[v4] = null;
                    }

                    ++v5;
                }

                ++v4;
            }

            arg9.garbage = false;
            arg9.size = v5;
        }

        return ContainerHelpersKt.binarySearch(arg9.keys, arg9.size, arg10);
    }

    public static final int commonIndexOfValue(LongSparseArray arg9, Object arg10) {
        int v0;
        Intrinsics.checkNotNullParameter(arg9, "<this>");
        int v1 = 0;
        if(arg9.garbage) {
            v0 = arg9.size;
            long[] v2 = arg9.keys;
            Object[] v3 = arg9.values;
            int v4 = 0;
            int v5 = 0;
            while(v4 < v0) {
                Object v6 = v3[v4];
                if(v6 != LongSparseArrayKt.DELETED) {
                    if(v4 != v5) {
                        v2[v5] = v2[v4];
                        v3[v5] = v6;
                        v3[v4] = null;
                    }

                    ++v5;
                }

                ++v4;
            }

            arg9.garbage = false;
            arg9.size = v5;
        }

        v0 = arg9.size;
        while(v1 < v0) {
            if(arg9.values[v1] == arg10) {
                return v1;
            }

            ++v1;
        }

        return -1;
    }

    public static final boolean commonIsEmpty(LongSparseArray arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.size() == 0) {
            return 1;
        }

        return 0;
    }

    public static final long commonKeyAt(LongSparseArray arg9, int arg10) {
        Intrinsics.checkNotNullParameter(arg9, "<this>");
        int v1 = arg10 < 0 || arg10 >= arg9.size ? 0 : 1;
        if(v1 == 0) {
            RuntimeHelpersKt.throwIllegalArgumentException("Expected index to be within 0..size()-1, but was " + arg10);
        }

        if(arg9.garbage) {
            v1 = arg9.size;
            long[] v2 = arg9.keys;
            Object[] v3 = arg9.values;
            int v4 = 0;
            int v5 = 0;
            while(v4 < v1) {
                Object v6 = v3[v4];
                if(v6 != LongSparseArrayKt.DELETED) {
                    if(v4 != v5) {
                        v2[v5] = v2[v4];
                        v3[v5] = v6;
                        v3[v4] = null;
                    }

                    ++v5;
                }

                ++v4;
            }

            arg9.garbage = false;
            arg9.size = v5;
        }

        return arg9.keys[arg10];
    }

    public static final void commonPut(LongSparseArray arg9, long arg10, Object arg12) {
        Intrinsics.checkNotNullParameter(arg9, "<this>");
        int v0 = ContainerHelpersKt.binarySearch(arg9.keys, arg9.size, arg10);
        if(v0 >= 0) {
            arg9.values[v0] = arg12;
            return;
        }

        v0 = ~v0;
        if(v0 < arg9.size && arg9.values[v0] == LongSparseArrayKt.DELETED) {
            arg9.keys[v0] = arg10;
            arg9.values[v0] = arg12;
            return;
        }

        if((arg9.garbage) && arg9.size >= arg9.keys.length) {
            v0 = arg9.size;
            long[] v1 = arg9.keys;
            Object[] v2 = arg9.values;
            int v4 = 0;
            int v5 = 0;
            while(v4 < v0) {
                Object v6 = v2[v4];
                if(v6 != LongSparseArrayKt.DELETED) {
                    if(v4 != v5) {
                        v1[v5] = v1[v4];
                        v2[v5] = v6;
                        v2[v4] = null;
                    }

                    ++v5;
                }

                ++v4;
            }

            arg9.garbage = false;
            arg9.size = v5;
            v0 = ~ContainerHelpersKt.binarySearch(arg9.keys, arg9.size, arg10);
        }

        if(arg9.size >= arg9.keys.length) {
            int v1_1 = ContainerHelpersKt.idealLongArraySize(arg9.size + 1);
            long[] v2_1 = Arrays.copyOf(arg9.keys, v1_1);
            Intrinsics.checkNotNullExpressionValue(v2_1, "copyOf(...)");
            arg9.keys = v2_1;
            Object[] v1_2 = Arrays.copyOf(arg9.values, v1_1);
            Intrinsics.checkNotNullExpressionValue(v1_2, "copyOf(...)");
            arg9.values = v1_2;
        }

        if(arg9.size - v0 != 0) {
            int v3 = v0 + 1;
            ArraysKt.copyInto(arg9.keys, arg9.keys, v3, v0, arg9.size);
            ArraysKt.copyInto(arg9.values, arg9.values, v3, v0, arg9.size);
        }

        arg9.keys[v0] = arg10;
        arg9.values[v0] = arg12;
        ++arg9.size;
    }

    public static final void commonPutAll(LongSparseArray arg5, LongSparseArray arg6) {
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        Intrinsics.checkNotNullParameter(arg6, "other");
        int v0 = arg6.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            arg5.put(arg6.keyAt(v1), arg6.valueAt(v1));
        }
    }

    public static final Object commonPutIfAbsent(LongSparseArray arg1, long arg2, Object arg4) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Object v0 = arg1.get(arg2);
        if(v0 == null) {
            arg1.put(arg2, arg4);
        }

        return v0;
    }

    public static final void commonRemove(LongSparseArray arg2, long arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        int v3 = ContainerHelpersKt.binarySearch(arg2.keys, arg2.size, arg3);
        if(v3 >= 0 && arg2.values[v3] != LongSparseArrayKt.DELETED) {
            arg2.values[v3] = LongSparseArrayKt.DELETED;
            arg2.garbage = true;
        }
    }

    public static final boolean commonRemove(LongSparseArray arg1, long arg2, Object arg4) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        int v2 = arg1.indexOfKey(arg2);
        if(v2 >= 0 && (Intrinsics.areEqual(arg4, arg1.valueAt(v2)))) {
            arg1.removeAt(v2);
            return 1;
        }

        return 0;
    }

    public static final void commonRemoveAt(LongSparseArray arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        if(arg2.values[arg3] != LongSparseArrayKt.DELETED) {
            arg2.values[arg3] = LongSparseArrayKt.DELETED;
            arg2.garbage = true;
        }
    }

    public static final Object commonReplace(LongSparseArray arg1, long arg2, Object arg4) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        int v2 = arg1.indexOfKey(arg2);
        if(v2 >= 0) {
            Object v3 = arg1.values[v2];
            arg1.values[v2] = arg4;
            return v3;
        }

        return null;
    }

    public static final boolean commonReplace(LongSparseArray arg1, long arg2, Object arg4, Object arg5) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        int v2 = arg1.indexOfKey(arg2);
        if(v2 >= 0 && (Intrinsics.areEqual(arg1.values[v2], arg4))) {
            arg1.values[v2] = arg5;
            return 1;
        }

        return 0;
    }

    public static final void commonSetValueAt(LongSparseArray arg9, int arg10, Object arg11) {
        Intrinsics.checkNotNullParameter(arg9, "<this>");
        int v1 = arg10 < 0 || arg10 >= arg9.size ? 0 : 1;
        if(v1 == 0) {
            RuntimeHelpersKt.throwIllegalArgumentException("Expected index to be within 0..size()-1, but was " + arg10);
        }

        if(arg9.garbage) {
            v1 = arg9.size;
            long[] v2 = arg9.keys;
            Object[] v3 = arg9.values;
            int v4 = 0;
            int v5 = 0;
            while(v4 < v1) {
                Object v6 = v3[v4];
                if(v6 != LongSparseArrayKt.DELETED) {
                    if(v4 != v5) {
                        v2[v5] = v2[v4];
                        v3[v5] = v6;
                        v3[v4] = null;
                    }

                    ++v5;
                }

                ++v4;
            }

            arg9.garbage = false;
            arg9.size = v5;
        }

        arg9.values[arg10] = arg11;
    }

    public static final int commonSize(LongSparseArray arg9) {
        Intrinsics.checkNotNullParameter(arg9, "<this>");
        if(arg9.garbage) {
            int v0 = arg9.size;
            long[] v1 = arg9.keys;
            Object[] v2 = arg9.values;
            int v4 = 0;
            int v5 = 0;
            while(v4 < v0) {
                Object v6 = v2[v4];
                if(v6 != LongSparseArrayKt.DELETED) {
                    if(v4 != v5) {
                        v1[v5] = v1[v4];
                        v2[v5] = v6;
                        v2[v4] = null;
                    }

                    ++v5;
                }

                ++v4;
            }

            arg9.garbage = false;
            arg9.size = v5;
        }

        return arg9.size;
    }

    public static final String commonToString(LongSparseArray arg5) {
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        if(arg5.size() <= 0) {
            return "{}";
        }

        StringBuilder v1 = new StringBuilder(arg5.size * 28);
        v1.append('{');
        int v0 = arg5.size;
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            if(v2 > 0) {
                v1.append(", ");
            }

            v1.append(arg5.keyAt(v2));
            v1.append('=');
            Object v3 = arg5.valueAt(v2);
            if((((StringBuilder)v3)) != v1) {
                v1.append(v3);
            }
            else {
                v1.append("(this Map)");
            }
        }

        v1.append('}');
        String v5 = v1.toString();
        Intrinsics.checkNotNullExpressionValue(v5, "toString(...)");
        return v5;
    }

    public static final Object commonValueAt(LongSparseArray arg9, int arg10) {
        Intrinsics.checkNotNullParameter(arg9, "<this>");
        int v1 = arg10 < 0 || arg10 >= arg9.size ? 0 : 1;
        if(v1 == 0) {
            RuntimeHelpersKt.throwIllegalArgumentException("Expected index to be within 0..size()-1, but was " + arg10);
        }

        if(arg9.garbage) {
            v1 = arg9.size;
            long[] v2 = arg9.keys;
            Object[] v3 = arg9.values;
            int v4 = 0;
            int v5 = 0;
            while(v4 < v1) {
                Object v6 = v3[v4];
                if(v6 != LongSparseArrayKt.DELETED) {
                    if(v4 != v5) {
                        v2[v5] = v2[v4];
                        v3[v5] = v6;
                        v3[v4] = null;
                    }

                    ++v5;
                }

                ++v4;
            }

            arg9.garbage = false;
            arg9.size = v5;
        }

        return arg9.values[arg10];
    }

    public static final boolean contains(LongSparseArray arg1, long arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.containsKey(arg2);
    }

    public static final void forEach(LongSparseArray arg4, Function2 arg5) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        Intrinsics.checkNotNullParameter(arg5, "action");
        int v0 = arg4.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            arg5.invoke(Long.valueOf(arg4.keyAt(v1)), arg4.valueAt(v1));
        }
    }

    public static final Object getOrDefault(LongSparseArray arg1, long arg2, Object arg4) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.get(arg2, arg4);
    }

    public static final Object getOrElse(LongSparseArray arg1, long arg2, Function0 arg4) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "defaultValue");
        Object v1 = arg1.get(arg2);
        if(v1 == null) {
            v1 = arg4.invoke();
        }

        return v1;
    }

    public static final int getSize(LongSparseArray arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.size();
    }

    public static void getSize$annotations(LongSparseArray arg0) {
    }

    public static final boolean isNotEmpty(LongSparseArray arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.isEmpty() ^ 1;
    }

    public static final LongIterator keyIterator(LongSparseArray arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return new LongSparseArrayKt$keyIterator$1(arg1);
    }

    public static final LongSparseArray plus(LongSparseArray arg3, LongSparseArray arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "other");
        LongSparseArray v0 = new LongSparseArray(arg3.size() + arg4.size());
        v0.putAll(arg3);
        v0.putAll(arg4);
        return v0;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Replaced with member function. Remove extension import!") public static final boolean remove(LongSparseArray arg1, long arg2, Object arg4) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.remove(arg2, arg4);
    }

    public static final void set(LongSparseArray arg1, long arg2, Object arg4) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1.put(arg2, arg4);
    }

    public static final Iterator valueIterator(LongSparseArray arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return new LongSparseArrayKt$valueIterator$1(arg1);
    }
}

