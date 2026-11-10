package kotlin.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShortArray;
import kotlin.collections.unsigned.UArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000H\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\u001A/\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u000E\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00030\u0003H\u0086\u0080\u0004¢\u0006\u0002\u0010\u0004\u001AK\u0010\u0005\u001A\u001A\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u00010\u0006\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0007*\u0016\u0012\u0012\b\u0001\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00070\u00060\u0003H\u0086\u0080\u0004¢\u0006\u0002\u0010\b\u001A*\u0010\t\u001A\u00020\n*\b\u0012\u0002\b\u0003\u0018\u00010\u0003H\u0087\u0088\u0004\u0082\u0002\u000E\n\f\b\u0000\u0012\u0002\u0018\u0001\u001A\u0004\b\u0003\u0010\u0000¢\u0006\u0002\u0010\u000B\u001AI\u0010\f\u001A\u0002H\u0007\"\u0010\b\u0000\u0010\r*\u0006\u0012\u0002\b\u00030\u0003*\u0002H\u0007\"\u0004\b\u0001\u0010\u0007*\u0002H\r2\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u0002H\u00070\u000FH\u0087\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010\u0010\u001A7\u0010\u0011\u001A\u00020\n\"\u0004\b\u0000\u0010\u0002*\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u00032\u0010\u0010\u0012\u001A\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u0003H\u0081\u0080\u0004¢\u0006\u0004\b\u0013\u0010\u0014\u001A%\u0010\u0015\u001A\u00020\u0016\"\u0004\b\u0000\u0010\u0002*\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u0003H\u0081\u0080\u0004¢\u0006\u0004\b\u0017\u0010\u0018\u001AA\u0010\u0019\u001A\u00020\u001A\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\n\u0010\u001B\u001A\u00060\u001Cj\u0002`\u001D2\u0010\u0010\u001E\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u001FH\u0082\u0080\u0004¢\u0006\u0004\b \u0010!\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\""}, d2={"flatten", "", "T", "", "([[Ljava/lang/Object;)Ljava/util/List;", "unzip", "Lkotlin/Pair;", "R", "([Lkotlin/Pair;)Lkotlin/Pair;", "isNullOrEmpty", "", "([Ljava/lang/Object;)Z", "ifEmpty", "C", "defaultValue", "Lkotlin/Function0;", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "contentDeepEqualsImpl", "other", "contentDeepEquals", "([Ljava/lang/Object;[Ljava/lang/Object;)Z", "contentDeepToStringImpl", "", "contentDeepToString", "([Ljava/lang/Object;)Ljava/lang/String;", "contentDeepToStringInternal", "", "result", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "processed", "", "contentDeepToStringInternal$ArraysKt__ArraysKt", "([Ljava/lang/Object;Ljava/lang/StringBuilder;Ljava/util/List;)V", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/collections/ArraysKt") class ArraysKt__ArraysKt extends ArraysKt__ArraysJVMKt {
    public ArraysKt__ArraysKt() {
        super();
    }

    public static final boolean contentDeepEquals(Object[] arg7, Object[] arg8) {
        if(arg7 == arg8) {
            return 1;
        }

        if(arg7 != null && arg8 != null) {
            if(arg7.length != arg8.length) {
            }
            else {
                int v2 = arg7.length;
                int v3 = 0;
                while(true) {
                    if(v3 < v2) {
                        Object v4 = arg7[v3];
                        Object v5 = arg8[v3];
                        if(v4 == v5) {
                        }
                        else {
                            if(v4 != null) {
                                if(v5 == null) {
                                }
                                else {
                                    if(((v4 instanceof Object[])) && ((v5 instanceof Object[]))) {
                                        if(!ArraysKt.contentDeepEquals(((Object[])v4), ((Object[])v5))) {
                                            return 0;
                                        }
                                        else {
                                            goto label_122;
                                        }
                                    }

                                    if(((v4 instanceof byte[])) && ((v5 instanceof byte[]))) {
                                        if(!Arrays.equals(((byte[])v4), ((byte[])v5))) {
                                            return 0;
                                        }
                                        else {
                                            goto label_122;
                                        }
                                    }

                                    if(((v4 instanceof short[])) && ((v5 instanceof short[]))) {
                                        if(!Arrays.equals(((short[])v4), ((short[])v5))) {
                                            return 0;
                                        }
                                        else {
                                            goto label_122;
                                        }
                                    }

                                    if(((v4 instanceof int[])) && ((v5 instanceof int[]))) {
                                        if(!Arrays.equals(((int[])v4), ((int[])v5))) {
                                            return 0;
                                        }
                                        else {
                                            goto label_122;
                                        }
                                    }

                                    if(((v4 instanceof long[])) && ((v5 instanceof long[]))) {
                                        if(!Arrays.equals(((long[])v4), ((long[])v5))) {
                                            return 0;
                                        }
                                        else {
                                            goto label_122;
                                        }
                                    }

                                    if(((v4 instanceof float[])) && ((v5 instanceof float[]))) {
                                        if(!Arrays.equals(((float[])v4), ((float[])v5))) {
                                            return 0;
                                        }
                                        else {
                                            goto label_122;
                                        }
                                    }

                                    if(((v4 instanceof double[])) && ((v5 instanceof double[]))) {
                                        if(!Arrays.equals(((double[])v4), ((double[])v5))) {
                                            return 0;
                                        }
                                        else {
                                            goto label_122;
                                        }
                                    }

                                    if(((v4 instanceof char[])) && ((v5 instanceof char[]))) {
                                        if(!Arrays.equals(((char[])v4), ((char[])v5))) {
                                            return 0;
                                        }
                                        else {
                                            goto label_122;
                                        }
                                    }

                                    if(((v4 instanceof boolean[])) && ((v5 instanceof boolean[]))) {
                                        if(!Arrays.equals(((boolean[])v4), ((boolean[])v5))) {
                                            return 0;
                                        }
                                        else {
                                            goto label_122;
                                        }
                                    }

                                    if(((v4 instanceof UByteArray)) && ((v5 instanceof UByteArray))) {
                                        if(!UArraysKt.contentEquals-kV0jMPg(((UByteArray)v4).unbox-impl(), ((UByteArray)v5).unbox-impl())) {
                                            return 0;
                                        }
                                        else {
                                            goto label_122;
                                        }
                                    }

                                    if(((v4 instanceof UShortArray)) && ((v5 instanceof UShortArray))) {
                                        if(!UArraysKt.contentEquals-FGO6Aew(((UShortArray)v4).unbox-impl(), ((UShortArray)v5).unbox-impl())) {
                                            return 0;
                                        }
                                        else {
                                            goto label_122;
                                        }
                                    }

                                    if(((v4 instanceof UIntArray)) && ((v5 instanceof UIntArray))) {
                                        if(!UArraysKt.contentEquals-KJPZfPQ(((UIntArray)v4).unbox-impl(), ((UIntArray)v5).unbox-impl())) {
                                            return 0;
                                        }
                                        else {
                                            goto label_122;
                                        }
                                    }

                                    if(((v4 instanceof ULongArray)) && ((v5 instanceof ULongArray))) {
                                        if(!UArraysKt.contentEquals-lec5QzE(((ULongArray)v4).unbox-impl(), ((ULongArray)v5).unbox-impl())) {
                                            return 0;
                                        }
                                        else {
                                            goto label_122;
                                        }
                                    }

                                    if(Intrinsics.areEqual(v4, v5)) {
                                        goto label_122;
                                    }

                                    return 0;
                                }
                            }

                            return 0;
                        }

                    label_122:
                        ++v3;
                        continue;
                    }
                    else {
                        return 1;
                    }
                }

                return 0;
            }
        }

        return 0;
    }

    public static final String contentDeepToString(Object[] arg2) {
        if(arg2 == null) {
            return "null";
        }

        StringBuilder v1 = new StringBuilder(RangesKt.coerceAtMost(arg2.length, 0x19999999) * 5 + 2);
        ArraysKt__ArraysKt.contentDeepToStringInternal$ArraysKt__ArraysKt(arg2, v1, new ArrayList());
        return v1.toString();
    }

    private static final void contentDeepToStringInternal$ArraysKt__ArraysKt(Object[] arg5, StringBuilder arg6, List arg7) {
        String v2_1;
        if(arg7.contains(arg5)) {
            arg6.append("[...]");
            return;
        }

        arg7.add(arg5);
        arg6.append('[');
        int v0 = arg5.length;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            if(v1 != 0) {
                arg6.append(", ");
            }

            Object v2 = arg5[v1];
            if(v2 == null) {
                arg6.append("null");
            }
            else if((v2 instanceof Object[])) {
                ArraysKt__ArraysKt.contentDeepToStringInternal$ArraysKt__ArraysKt(((Object[])v2), arg6, arg7);
            }
            else {
                String v4 = "toString(...)";
                if((v2 instanceof byte[])) {
                    v2_1 = Arrays.toString(((byte[])v2));
                    Intrinsics.checkNotNullExpressionValue(v2_1, v4);
                    arg6.append(v2_1);
                }
                else if((v2 instanceof short[])) {
                    v2_1 = Arrays.toString(((short[])v2));
                    Intrinsics.checkNotNullExpressionValue(v2_1, v4);
                    arg6.append(v2_1);
                }
                else if((v2 instanceof int[])) {
                    v2_1 = Arrays.toString(((int[])v2));
                    Intrinsics.checkNotNullExpressionValue(v2_1, v4);
                    arg6.append(v2_1);
                }
                else if((v2 instanceof long[])) {
                    v2_1 = Arrays.toString(((long[])v2));
                    Intrinsics.checkNotNullExpressionValue(v2_1, v4);
                    arg6.append(v2_1);
                }
                else if((v2 instanceof float[])) {
                    v2_1 = Arrays.toString(((float[])v2));
                    Intrinsics.checkNotNullExpressionValue(v2_1, v4);
                    arg6.append(v2_1);
                }
                else if((v2 instanceof double[])) {
                    v2_1 = Arrays.toString(((double[])v2));
                    Intrinsics.checkNotNullExpressionValue(v2_1, v4);
                    arg6.append(v2_1);
                }
                else if((v2 instanceof char[])) {
                    v2_1 = Arrays.toString(((char[])v2));
                    Intrinsics.checkNotNullExpressionValue(v2_1, v4);
                    arg6.append(v2_1);
                }
                else if((v2 instanceof boolean[])) {
                    v2_1 = Arrays.toString(((boolean[])v2));
                    Intrinsics.checkNotNullExpressionValue(v2_1, v4);
                    arg6.append(v2_1);
                }
                else {
                    byte[] v4_1 = null;
                    if((v2 instanceof UByteArray)) {
                        if(v2 != null) {
                            v4_1 = ((UByteArray)v2).unbox-impl();
                        }

                        arg6.append(UArraysKt.contentToString-2csIQuQ(v4_1));
                    }
                    else {
                        if((v2 instanceof UShortArray)) {
                            if(v2 != null) {
                                short[] v4_2 = ((UShortArray)v2).unbox-impl();
                            }

                            arg6.append(UArraysKt.contentToString-d-6D3K8(((short[])v4_1)));
                            goto label_104;
                        }

                        if((v2 instanceof UIntArray)) {
                            if(v2 != null) {
                                int[] v4_3 = ((UIntArray)v2).unbox-impl();
                            }

                            arg6.append(UArraysKt.contentToString-XUkPCBk(((int[])v4_1)));
                            goto label_104;
                        }

                        if((v2 instanceof ULongArray)) {
                            if(v2 != null) {
                                long[] v4_4 = ((ULongArray)v2).unbox-impl();
                            }

                            arg6.append(UArraysKt.contentToString-uLth9ew(((long[])v4_1)));
                            goto label_104;
                        }

                        arg6.append(v2.toString());
                    }
                }
            }

        label_104:
        }

        arg6.append(']');
        arg7.remove(CollectionsKt.getLastIndex(arg7));
    }

    public static final List flatten(Object[][] arg12) {
        int v7;
        Object[] v6_1;
        Intrinsics.checkNotNullParameter(arg12, "<this>");
        Object[][] v0 = arg12;
        int v1 = v0.length;
        long v2 = 0;
        int v4 = 0;
        long v6 = v2;
        int v5;
        for(v5 = 0; v5 < v1; ++v5) {
            v6 += ((long)v0[v5].length);
        }

        if(v6 == v2) {
            return CollectionsKt.emptyList();
        }

        if(v6 <= 0x7FFFFFFF) {
            v6_1 = new Object[((int)v6)];
            int v0_1 = v0.length;
            v7 = 0;
        }
        else {
            throw new IllegalArgumentException("Sum of all arrays lengths (" + v6 + ") exceeds maximum list size (2147483647)".toString());
        }

        while(v4 < v0_1) {
            Object[] v5_1 = arg12[v4];
            ArraysKt.copyInto$default(v5_1, v6_1, v7, 0, 0, 12, null);
            v7 += v5_1.length;
            ++v4;
        }

        List v12 = ArraysKt.asList(v6_1);
        Intrinsics.checkNotNull(v12, "null cannot be cast to non-null type kotlin.collections.List<T of kotlin.collections.ArraysKt__ArraysKt.flatten>");
        return v12;
    }

    private static final Object ifEmpty(Object[] arg1, Function0 arg2) {
        Object v1;
        Intrinsics.checkNotNullParameter(arg2, "defaultValue");
        if(arg1.length == 0) {
            v1 = arg2.invoke();
        }

        return ((Object[])v1);
    }

    private static final boolean isNullOrEmpty(Object[] arg0) {
        if(arg0 != null) {
            if(arg0.length == 0) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public static final Pair unzip(Pair[] arg6) {
        Intrinsics.checkNotNullParameter(arg6, "<this>");
        ArrayList v0 = new ArrayList(arg6.length);
        ArrayList v1 = new ArrayList(arg6.length);
        int v2 = arg6.length;
        int v3;
        for(v3 = 0; v3 < v2; ++v3) {
            Pair v4 = arg6[v3];
            v0.add(v4.getFirst());
            v1.add(v4.getSecond());
        }

        return TuplesKt.to(v0, v1);
    }
}

