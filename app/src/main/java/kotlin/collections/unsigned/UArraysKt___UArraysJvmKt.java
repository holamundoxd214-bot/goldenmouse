package kotlin.collections.unsigned;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.UnsignedKt;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000j\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u001F\n\u0002\u0010\u000F\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u001A\u001D\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0087\u0088\u0004¢\u0006\u0004\b\u0005\u0010\u0006\u001A\u001D\u0010\u0000\u001A\u00020\u0007*\u00020\b2\u0006\u0010\u0003\u001A\u00020\u0004H\u0087\u0088\u0004¢\u0006\u0004\b\t\u0010\n\u001A\u001D\u0010\u0000\u001A\u00020\u000B*\u00020\f2\u0006\u0010\u0003\u001A\u00020\u0004H\u0087\u0088\u0004¢\u0006\u0004\b\r\u0010\u000E\u001A\u001D\u0010\u0000\u001A\u00020\u000F*\u00020\u00102\u0006\u0010\u0003\u001A\u00020\u0004H\u0087\u0088\u0004¢\u0006\u0004\b\u0011\u0010\u0012\u001A\u001B\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u00010\u0014*\u00020\u0002H\u0087\u0080\u0004¢\u0006\u0004\b\u0015\u0010\u0016\u001A\u001B\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u00070\u0014*\u00020\bH\u0087\u0080\u0004¢\u0006\u0004\b\u0017\u0010\u0018\u001A\u001B\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u000B0\u0014*\u00020\fH\u0087\u0080\u0004¢\u0006\u0004\b\u0019\u0010\u001A\u001A\u001B\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u000F0\u0014*\u00020\u0010H\u0087\u0080\u0004¢\u0006\u0004\b\u001B\u0010\u001C\u001A1\u0010\u001D\u001A\u00020\u0004*\u00020\u00022\u0006\u0010\u001E\u001A\u00020\u00012\b\b\u0002\u0010\u001F\u001A\u00020\u00042\b\b\u0002\u0010 \u001A\u00020\u0004H\u0087\u0080\u0004¢\u0006\u0004\b!\u0010\"\u001A1\u0010\u001D\u001A\u00020\u0004*\u00020\b2\u0006\u0010\u001E\u001A\u00020\u00072\b\b\u0002\u0010\u001F\u001A\u00020\u00042\b\b\u0002\u0010 \u001A\u00020\u0004H\u0087\u0080\u0004¢\u0006\u0004\b#\u0010$\u001A1\u0010\u001D\u001A\u00020\u0004*\u00020\f2\u0006\u0010\u001E\u001A\u00020\u000B2\b\b\u0002\u0010\u001F\u001A\u00020\u00042\b\b\u0002\u0010 \u001A\u00020\u0004H\u0087\u0080\u0004¢\u0006\u0004\b%\u0010&\u001A1\u0010\u001D\u001A\u00020\u0004*\u00020\u00102\u0006\u0010\u001E\u001A\u00020\u000F2\b\b\u0002\u0010\u001F\u001A\u00020\u00042\b\b\u0002\u0010 \u001A\u00020\u0004H\u0087\u0080\u0004¢\u0006\u0004\b\'\u0010(\u001A\u0017\u0010)\u001A\u0004\u0018\u00010\u0001*\u00020\u0002H\u0087\u0080\u0004¢\u0006\u0004\b*\u0010+\u001A\u0017\u0010)\u001A\u0004\u0018\u00010\u0007*\u00020\bH\u0087\u0080\u0004¢\u0006\u0004\b,\u0010-\u001A\u0017\u0010)\u001A\u0004\u0018\u00010\u000B*\u00020\fH\u0087\u0080\u0004¢\u0006\u0004\b.\u0010/\u001A\u0017\u0010)\u001A\u0004\u0018\u00010\u000F*\u00020\u0010H\u0087\u0080\u0004¢\u0006\u0004\b0\u00101\u001A>\u00102\u001A\u0004\u0018\u00010\u0001\"\u000E\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u00022\u0012\u00105\u001A\u000E\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H306H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0004\b7\u00108\u001A>\u00102\u001A\u0004\u0018\u00010\u0007\"\u000E\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\b2\u0012\u00105\u001A\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H306H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0004\b9\u0010:\u001A>\u00102\u001A\u0004\u0018\u00010\u000B\"\u000E\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\f2\u0012\u00105\u001A\u000E\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u0002H306H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0004\b;\u0010<\u001A>\u00102\u001A\u0004\u0018\u00010\u000F\"\u000E\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u00102\u0012\u00105\u001A\u000E\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u0002H306H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0004\b=\u0010>\u001A3\u0010?\u001A\u0004\u0018\u00010\u0001*\u00020\u00022\u001A\u0010@\u001A\u0016\u0012\u0006\b\u0000\u0012\u00020\u00010Aj\n\u0012\u0006\b\u0000\u0012\u00020\u0001`BH\u0087\u0080\u0004¢\u0006\u0004\bC\u0010D\u001A3\u0010?\u001A\u0004\u0018\u00010\u0007*\u00020\b2\u001A\u0010@\u001A\u0016\u0012\u0006\b\u0000\u0012\u00020\u00070Aj\n\u0012\u0006\b\u0000\u0012\u00020\u0007`BH\u0087\u0080\u0004¢\u0006\u0004\bE\u0010F\u001A3\u0010?\u001A\u0004\u0018\u00010\u000B*\u00020\f2\u001A\u0010@\u001A\u0016\u0012\u0006\b\u0000\u0012\u00020\u000B0Aj\n\u0012\u0006\b\u0000\u0012\u00020\u000B`BH\u0087\u0080\u0004¢\u0006\u0004\bG\u0010H\u001A3\u0010?\u001A\u0004\u0018\u00010\u000F*\u00020\u00102\u001A\u0010@\u001A\u0016\u0012\u0006\b\u0000\u0012\u00020\u000F0Aj\n\u0012\u0006\b\u0000\u0012\u00020\u000F`BH\u0087\u0080\u0004¢\u0006\u0004\bI\u0010J\u001A\u0017\u0010K\u001A\u0004\u0018\u00010\u0001*\u00020\u0002H\u0087\u0080\u0004¢\u0006\u0004\bL\u0010+\u001A\u0017\u0010K\u001A\u0004\u0018\u00010\u0007*\u00020\bH\u0087\u0080\u0004¢\u0006\u0004\bM\u0010-\u001A\u0017\u0010K\u001A\u0004\u0018\u00010\u000B*\u00020\fH\u0087\u0080\u0004¢\u0006\u0004\bN\u0010/\u001A\u0017\u0010K\u001A\u0004\u0018\u00010\u000F*\u00020\u0010H\u0087\u0080\u0004¢\u0006\u0004\bO\u00101\u001A>\u0010P\u001A\u0004\u0018\u00010\u0001\"\u000E\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u00022\u0012\u00105\u001A\u000E\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H306H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0004\bQ\u00108\u001A>\u0010P\u001A\u0004\u0018\u00010\u0007\"\u000E\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\b2\u0012\u00105\u001A\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H306H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0004\bR\u0010:\u001A>\u0010P\u001A\u0004\u0018\u00010\u000B\"\u000E\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\f2\u0012\u00105\u001A\u000E\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u0002H306H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0004\bS\u0010<\u001A>\u0010P\u001A\u0004\u0018\u00010\u000F\"\u000E\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u00102\u0012\u00105\u001A\u000E\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u0002H306H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0004\bT\u0010>\u001A3\u0010U\u001A\u0004\u0018\u00010\u0001*\u00020\u00022\u001A\u0010@\u001A\u0016\u0012\u0006\b\u0000\u0012\u00020\u00010Aj\n\u0012\u0006\b\u0000\u0012\u00020\u0001`BH\u0087\u0080\u0004¢\u0006\u0004\bV\u0010D\u001A3\u0010U\u001A\u0004\u0018\u00010\u0007*\u00020\b2\u001A\u0010@\u001A\u0016\u0012\u0006\b\u0000\u0012\u00020\u00070Aj\n\u0012\u0006\b\u0000\u0012\u00020\u0007`BH\u0087\u0080\u0004¢\u0006\u0004\bW\u0010F\u001A3\u0010U\u001A\u0004\u0018\u00010\u000B*\u00020\f2\u001A\u0010@\u001A\u0016\u0012\u0006\b\u0000\u0012\u00020\u000B0Aj\n\u0012\u0006\b\u0000\u0012\u00020\u000B`BH\u0087\u0080\u0004¢\u0006\u0004\bX\u0010H\u001A3\u0010U\u001A\u0004\u0018\u00010\u000F*\u00020\u00102\u001A\u0010@\u001A\u0016\u0012\u0006\b\u0000\u0012\u00020\u000F0Aj\n\u0012\u0006\b\u0000\u0012\u00020\u000F`BH\u0087\u0080\u0004¢\u0006\u0004\bY\u0010J\u001A,\u0010Z\u001A\u00020[*\u00020\u00022\u0012\u00105\u001A\u000E\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020[06H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0004\b\\\u0010]\u001A,\u0010Z\u001A\u00020[*\u00020\b2\u0012\u00105\u001A\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020[06H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0004\b\\\u0010^\u001A,\u0010Z\u001A\u00020[*\u00020\f2\u0012\u00105\u001A\u000E\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020[06H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0004\b\\\u0010_\u001A,\u0010Z\u001A\u00020[*\u00020\u00102\u0012\u00105\u001A\u000E\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020[06H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0004\b\\\u0010`\u001A,\u0010Z\u001A\u00020a*\u00020\u00022\u0012\u00105\u001A\u000E\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020a06H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0004\bb\u0010c\u001A,\u0010Z\u001A\u00020a*\u00020\b2\u0012\u00105\u001A\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020a06H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0004\bb\u0010d\u001A,\u0010Z\u001A\u00020a*\u00020\f2\u0012\u00105\u001A\u000E\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020a06H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0004\bb\u0010e\u001A,\u0010Z\u001A\u00020a*\u00020\u00102\u0012\u00105\u001A\u000E\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020a06H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0004\bb\u0010f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006g"}, d2={"elementAt", "Lkotlin/UInt;", "Lkotlin/UIntArray;", "index", "", "elementAt-qFRl0hI", "([II)I", "Lkotlin/ULong;", "Lkotlin/ULongArray;", "elementAt-r7IrZao", "([JI)J", "Lkotlin/UByte;", "Lkotlin/UByteArray;", "elementAt-PpDY95g", "([BI)B", "Lkotlin/UShort;", "Lkotlin/UShortArray;", "elementAt-nggk6HY", "([SI)S", "asList", "", "asList--ajY-9A", "([I)Ljava/util/List;", "asList-QwZRm1k", "([J)Ljava/util/List;", "asList-GBYM_sE", "([B)Ljava/util/List;", "asList-rL5Bavg", "([S)Ljava/util/List;", "binarySearch", "element", "fromIndex", "toIndex", "binarySearch-2fe2U9s", "([IIII)I", "binarySearch-K6DWlUc", "([JJII)I", "binarySearch-WpHrYlw", "([BBII)I", "binarySearch-EtDCXyQ", "([SSII)I", "max", "max--ajY-9A", "([I)Lkotlin/UInt;", "max-QwZRm1k", "([J)Lkotlin/ULong;", "max-GBYM_sE", "([B)Lkotlin/UByte;", "max-rL5Bavg", "([S)Lkotlin/UShort;", "maxBy", "R", "", "selector", "Lkotlin/Function1;", "maxBy-jgv0xPQ", "([ILkotlin/jvm/functions/Function1;)Lkotlin/UInt;", "maxBy-MShoTSo", "([JLkotlin/jvm/functions/Function1;)Lkotlin/ULong;", "maxBy-JOV_ifY", "([BLkotlin/jvm/functions/Function1;)Lkotlin/UByte;", "maxBy-xTcfx_M", "([SLkotlin/jvm/functions/Function1;)Lkotlin/UShort;", "maxWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "maxWith-YmdZ_VM", "([ILjava/util/Comparator;)Lkotlin/UInt;", "maxWith-zrEWJaI", "([JLjava/util/Comparator;)Lkotlin/ULong;", "maxWith-XMRcp5o", "([BLjava/util/Comparator;)Lkotlin/UByte;", "maxWith-eOHTfZs", "([SLjava/util/Comparator;)Lkotlin/UShort;", "min", "min--ajY-9A", "min-QwZRm1k", "min-GBYM_sE", "min-rL5Bavg", "minBy", "minBy-jgv0xPQ", "minBy-MShoTSo", "minBy-JOV_ifY", "minBy-xTcfx_M", "minWith", "minWith-YmdZ_VM", "minWith-zrEWJaI", "minWith-XMRcp5o", "minWith-eOHTfZs", "sumOf", "Ljava/math/BigDecimal;", "sumOfBigDecimal", "([ILkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([JLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([BLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([SLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "Ljava/math/BigInteger;", "sumOfBigInteger", "([ILkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([JLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([BLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([SLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, pn="kotlin.collections", xi=49, xs="kotlin/collections/unsigned/UArraysKt") class UArraysKt___UArraysJvmKt {
    public UArraysKt___UArraysJvmKt() {
        super();
    }

    public static final List asList--ajY-9A(int[] arg1) {
        Intrinsics.checkNotNullParameter(arg1, "$this$asList");
        return new UArraysKt___UArraysJvmKt$asList$1(arg1);
    }

    public static final List asList-GBYM_sE(byte[] arg1) {
        Intrinsics.checkNotNullParameter(arg1, "$this$asList");
        return new UArraysKt___UArraysJvmKt$asList$3(arg1);
    }

    public static final List asList-QwZRm1k(long[] arg1) {
        Intrinsics.checkNotNullParameter(arg1, "$this$asList");
        return new UArraysKt___UArraysJvmKt$asList$2(arg1);
    }

    public static final List asList-rL5Bavg(short[] arg1) {
        Intrinsics.checkNotNullParameter(arg1, "$this$asList");
        return new UArraysKt___UArraysJvmKt$asList$4(arg1);
    }

    public static final int binarySearch-2fe2U9s(int[] arg2, int arg3, int arg4, int arg5) {
        int v0;
        Intrinsics.checkNotNullParameter(arg2, "$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(arg4, arg5, UIntArray.getSize-impl(arg2));
        --arg5;
        while(true) {
            if(arg4 > arg5) {
                goto label_18;
            }

            v0 = arg4 + arg5 >>> 1;
            int v1 = UnsignedKt.uintCompare(arg2[v0], arg3);
            if(v1 < 0) {
                arg4 = v0 + 1;
                continue;
            }

            if(v1 <= 0) {
                return v0;
            }

            arg5 = v0 - 1;
        }

        return v0;
    label_18:
        return -(arg4 + 1);
    }

    public static int binarySearch-2fe2U9s$default(int[] arg0, int arg1, int arg2, int arg3, int arg4, Object arg5) {
        if((arg4 & 4) != 0) {
            arg3 = UIntArray.getSize-impl(arg0);
        }

        return UArraysKt.binarySearch-2fe2U9s(arg0, arg1, 0, arg3);
    }

    public static final int binarySearch-EtDCXyQ(short[] arg2, short arg3, int arg4, int arg5) {
        int v0;
        Intrinsics.checkNotNullParameter(arg2, "$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(arg4, arg5, UShortArray.getSize-impl(arg2));
        int v3 = arg3 & 0xFFFF;
        --arg5;
        while(true) {
            if(arg4 > arg5) {
                goto label_20;
            }

            v0 = arg4 + arg5 >>> 1;
            int v1 = UnsignedKt.uintCompare(arg2[v0], v3);
            if(v1 < 0) {
                arg4 = v0 + 1;
                continue;
            }

            if(v1 <= 0) {
                return v0;
            }

            arg5 = v0 - 1;
        }

        return v0;
    label_20:
        return -(arg4 + 1);
    }

    public static int binarySearch-EtDCXyQ$default(short[] arg0, short arg1, int arg2, int arg3, int arg4, Object arg5) {
        if((arg4 & 4) != 0) {
            arg3 = UShortArray.getSize-impl(arg0);
        }

        return UArraysKt.binarySearch-EtDCXyQ(arg0, arg1, 0, arg3);
    }

    public static final int binarySearch-K6DWlUc(long[] arg3, long arg4, int arg6, int arg7) {
        int v0;
        Intrinsics.checkNotNullParameter(arg3, "$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(arg6, arg7, ULongArray.getSize-impl(arg3));
        --arg7;
        while(true) {
            if(arg6 > arg7) {
                goto label_18;
            }

            v0 = arg6 + arg7 >>> 1;
            int v1 = UnsignedKt.ulongCompare(arg3[v0], arg4);
            if(v1 < 0) {
                arg6 = v0 + 1;
                continue;
            }

            if(v1 <= 0) {
                return v0;
            }

            arg7 = v0 - 1;
        }

        return v0;
    label_18:
        return -(arg6 + 1);
    }

    public static int binarySearch-K6DWlUc$default(long[] arg0, long arg1, int arg3, int arg4, int arg5, Object arg6) {
        if((arg5 & 4) != 0) {
            arg4 = ULongArray.getSize-impl(arg0);
        }

        return UArraysKt.binarySearch-K6DWlUc(arg0, arg1, 0, arg4);
    }

    public static final int binarySearch-WpHrYlw(byte[] arg2, byte arg3, int arg4, int arg5) {
        int v0;
        Intrinsics.checkNotNullParameter(arg2, "$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(arg4, arg5, UByteArray.getSize-impl(arg2));
        int v3 = arg3 & 0xFF;
        --arg5;
        while(true) {
            if(arg4 > arg5) {
                goto label_19;
            }

            v0 = arg4 + arg5 >>> 1;
            int v1 = UnsignedKt.uintCompare(arg2[v0], v3);
            if(v1 < 0) {
                arg4 = v0 + 1;
                continue;
            }

            if(v1 <= 0) {
                return v0;
            }

            arg5 = v0 - 1;
        }

        return v0;
    label_19:
        return -(arg4 + 1);
    }

    public static int binarySearch-WpHrYlw$default(byte[] arg0, byte arg1, int arg2, int arg3, int arg4, Object arg5) {
        if((arg4 & 4) != 0) {
            arg3 = UByteArray.getSize-impl(arg0);
        }

        return UArraysKt.binarySearch-WpHrYlw(arg0, arg1, 0, arg3);
    }

    private static final byte elementAt-PpDY95g(byte[] arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "$this$elementAt");
        return UByteArray.get-w2LRezQ(arg1, arg2);
    }

    private static final short elementAt-nggk6HY(short[] arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "$this$elementAt");
        return UShortArray.get-Mh2AYeg(arg1, arg2);
    }

    private static final int elementAt-qFRl0hI(int[] arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "$this$elementAt");
        return UIntArray.get-pVg5ArA(arg1, arg2);
    }

    private static final long elementAt-r7IrZao(long[] arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "$this$elementAt");
        return ULongArray.get-s-VKNKU(arg1, arg2);
    }

    @Deprecated(message="Use maxOrNull instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="1.5", hiddenSince="1.6", warningSince="1.4") public static final UInt max--ajY-9A(int[] arg1) {
        Intrinsics.checkNotNullParameter(arg1, "$this$max");
        return UArraysKt.maxOrNull--ajY-9A(arg1);
    }

    @Deprecated(message="Use maxOrNull instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="1.5", hiddenSince="1.6", warningSince="1.4") public static final UByte max-GBYM_sE(byte[] arg1) {
        Intrinsics.checkNotNullParameter(arg1, "$this$max");
        return UArraysKt.maxOrNull-GBYM_sE(arg1);
    }

    @Deprecated(message="Use maxOrNull instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="1.5", hiddenSince="1.6", warningSince="1.4") public static final ULong max-QwZRm1k(long[] arg1) {
        Intrinsics.checkNotNullParameter(arg1, "$this$max");
        return UArraysKt.maxOrNull-QwZRm1k(arg1);
    }

    @Deprecated(message="Use maxOrNull instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="1.5", hiddenSince="1.6", warningSince="1.4") public static final UShort max-rL5Bavg(short[] arg1) {
        Intrinsics.checkNotNullParameter(arg1, "$this$max");
        return UArraysKt.maxOrNull-rL5Bavg(arg1);
    }

    @Deprecated(message="Use maxByOrNull instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="1.5", hiddenSince="1.6", warningSince="1.4") private static final UByte maxBy-JOV_ifY(byte[] arg7, Function1 arg8) {
        Intrinsics.checkNotNullParameter(arg7, "$this$maxBy");
        Intrinsics.checkNotNullParameter(arg8, "selector");
        if(UByteArray.isEmpty-impl(arg7)) {
            return null;
        }

        byte v0 = UByteArray.get-w2LRezQ(arg7, 0);
        int v1 = ArraysKt.getLastIndex(arg7);
        if(v1 == 0) {
            return UByte.box-impl(v0);
        }

        Object v2 = arg8.invoke(UByte.box-impl(v0));
        int v3 = 1;
        if(1 <= v1) {
            while(true) {
                byte v4 = UByteArray.get-w2LRezQ(arg7, v3);
                Object v5 = arg8.invoke(UByte.box-impl(v4));
                if(((Comparable)v2).compareTo(v5) < 0) {
                    v0 = v4;
                    v2 = v5;
                }

                if(v3 == v1) {
                    break;
                }

                ++v3;
            }
        }

        return UByte.box-impl(v0);
    }

    @Deprecated(message="Use maxByOrNull instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="1.5", hiddenSince="1.6", warningSince="1.4") private static final ULong maxBy-MShoTSo(long[] arg9, Function1 arg10) {
        Intrinsics.checkNotNullParameter(arg9, "$this$maxBy");
        Intrinsics.checkNotNullParameter(arg10, "selector");
        if(ULongArray.isEmpty-impl(arg9)) {
            return null;
        }

        long v0 = ULongArray.get-s-VKNKU(arg9, 0);
        int v2 = ArraysKt.getLastIndex(arg9);
        if(v2 == 0) {
            return ULong.box-impl(v0);
        }

        Object v3 = arg10.invoke(ULong.box-impl(v0));
        int v4 = 1;
        if(1 <= v2) {
            while(true) {
                long v5 = ULongArray.get-s-VKNKU(arg9, v4);
                Object v7 = arg10.invoke(ULong.box-impl(v5));
                if(((Comparable)v3).compareTo(v7) < 0) {
                    v0 = v5;
                    v3 = v7;
                }

                if(v4 == v2) {
                    break;
                }

                ++v4;
            }
        }

        return ULong.box-impl(v0);
    }

    @Deprecated(message="Use maxByOrNull instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="1.5", hiddenSince="1.6", warningSince="1.4") private static final UInt maxBy-jgv0xPQ(int[] arg7, Function1 arg8) {
        Intrinsics.checkNotNullParameter(arg7, "$this$maxBy");
        Intrinsics.checkNotNullParameter(arg8, "selector");
        if(UIntArray.isEmpty-impl(arg7)) {
            return null;
        }

        int v0 = UIntArray.get-pVg5ArA(arg7, 0);
        int v1 = ArraysKt.getLastIndex(arg7);
        if(v1 == 0) {
            return UInt.box-impl(v0);
        }

        Object v2 = arg8.invoke(UInt.box-impl(v0));
        int v3 = 1;
        if(1 <= v1) {
            while(true) {
                int v4 = UIntArray.get-pVg5ArA(arg7, v3);
                Object v5 = arg8.invoke(UInt.box-impl(v4));
                if(((Comparable)v2).compareTo(v5) < 0) {
                    v0 = v4;
                    v2 = v5;
                }

                if(v3 == v1) {
                    break;
                }

                ++v3;
            }
        }

        return UInt.box-impl(v0);
    }

    @Deprecated(message="Use maxByOrNull instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="1.5", hiddenSince="1.6", warningSince="1.4") private static final UShort maxBy-xTcfx_M(short[] arg7, Function1 arg8) {
        Intrinsics.checkNotNullParameter(arg7, "$this$maxBy");
        Intrinsics.checkNotNullParameter(arg8, "selector");
        if(UShortArray.isEmpty-impl(arg7)) {
            return null;
        }

        short v0 = UShortArray.get-Mh2AYeg(arg7, 0);
        int v1 = ArraysKt.getLastIndex(arg7);
        if(v1 == 0) {
            return UShort.box-impl(v0);
        }

        Object v2 = arg8.invoke(UShort.box-impl(v0));
        int v3 = 1;
        if(1 <= v1) {
            while(true) {
                short v4 = UShortArray.get-Mh2AYeg(arg7, v3);
                Object v5 = arg8.invoke(UShort.box-impl(v4));
                if(((Comparable)v2).compareTo(v5) < 0) {
                    v0 = v4;
                    v2 = v5;
                }

                if(v3 == v1) {
                    break;
                }

                ++v3;
            }
        }

        return UShort.box-impl(v0);
    }

    @Deprecated(message="Use maxWithOrNull instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="1.5", hiddenSince="1.6", warningSince="1.4") public static final UByte maxWith-XMRcp5o(byte[] arg1, Comparator arg2) {
        Intrinsics.checkNotNullParameter(arg1, "$this$maxWith");
        Intrinsics.checkNotNullParameter(arg2, "comparator");
        return UArraysKt.maxWithOrNull-XMRcp5o(arg1, arg2);
    }

    @Deprecated(message="Use maxWithOrNull instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="1.5", hiddenSince="1.6", warningSince="1.4") public static final UInt maxWith-YmdZ_VM(int[] arg1, Comparator arg2) {
        Intrinsics.checkNotNullParameter(arg1, "$this$maxWith");
        Intrinsics.checkNotNullParameter(arg2, "comparator");
        return UArraysKt.maxWithOrNull-YmdZ_VM(arg1, arg2);
    }

    @Deprecated(message="Use maxWithOrNull instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="1.5", hiddenSince="1.6", warningSince="1.4") public static final UShort maxWith-eOHTfZs(short[] arg1, Comparator arg2) {
        Intrinsics.checkNotNullParameter(arg1, "$this$maxWith");
        Intrinsics.checkNotNullParameter(arg2, "comparator");
        return UArraysKt.maxWithOrNull-eOHTfZs(arg1, arg2);
    }

    @Deprecated(message="Use maxWithOrNull instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="1.5", hiddenSince="1.6", warningSince="1.4") public static final ULong maxWith-zrEWJaI(long[] arg1, Comparator arg2) {
        Intrinsics.checkNotNullParameter(arg1, "$this$maxWith");
        Intrinsics.checkNotNullParameter(arg2, "comparator");
        return UArraysKt.maxWithOrNull-zrEWJaI(arg1, arg2);
    }

    @Deprecated(message="Use minOrNull instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="1.5", hiddenSince="1.6", warningSince="1.4") public static final UInt min--ajY-9A(int[] arg1) {
        Intrinsics.checkNotNullParameter(arg1, "$this$min");
        return UArraysKt.minOrNull--ajY-9A(arg1);
    }

    @Deprecated(message="Use minOrNull instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="1.5", hiddenSince="1.6", warningSince="1.4") public static final UByte min-GBYM_sE(byte[] arg1) {
        Intrinsics.checkNotNullParameter(arg1, "$this$min");
        return UArraysKt.minOrNull-GBYM_sE(arg1);
    }

    @Deprecated(message="Use minOrNull instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="1.5", hiddenSince="1.6", warningSince="1.4") public static final ULong min-QwZRm1k(long[] arg1) {
        Intrinsics.checkNotNullParameter(arg1, "$this$min");
        return UArraysKt.minOrNull-QwZRm1k(arg1);
    }

    @Deprecated(message="Use minOrNull instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="1.5", hiddenSince="1.6", warningSince="1.4") public static final UShort min-rL5Bavg(short[] arg1) {
        Intrinsics.checkNotNullParameter(arg1, "$this$min");
        return UArraysKt.minOrNull-rL5Bavg(arg1);
    }

    @Deprecated(message="Use minByOrNull instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="1.5", hiddenSince="1.6", warningSince="1.4") private static final UByte minBy-JOV_ifY(byte[] arg7, Function1 arg8) {
        Intrinsics.checkNotNullParameter(arg7, "$this$minBy");
        Intrinsics.checkNotNullParameter(arg8, "selector");
        if(UByteArray.isEmpty-impl(arg7)) {
            return null;
        }

        byte v0 = UByteArray.get-w2LRezQ(arg7, 0);
        int v1 = ArraysKt.getLastIndex(arg7);
        if(v1 == 0) {
            return UByte.box-impl(v0);
        }

        Object v2 = arg8.invoke(UByte.box-impl(v0));
        int v3 = 1;
        if(1 <= v1) {
            while(true) {
                byte v4 = UByteArray.get-w2LRezQ(arg7, v3);
                Object v5 = arg8.invoke(UByte.box-impl(v4));
                if(((Comparable)v2).compareTo(v5) > 0) {
                    v0 = v4;
                    v2 = v5;
                }

                if(v3 == v1) {
                    break;
                }

                ++v3;
            }
        }

        return UByte.box-impl(v0);
    }

    @Deprecated(message="Use minByOrNull instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="1.5", hiddenSince="1.6", warningSince="1.4") private static final ULong minBy-MShoTSo(long[] arg9, Function1 arg10) {
        Intrinsics.checkNotNullParameter(arg9, "$this$minBy");
        Intrinsics.checkNotNullParameter(arg10, "selector");
        if(ULongArray.isEmpty-impl(arg9)) {
            return null;
        }

        long v0 = ULongArray.get-s-VKNKU(arg9, 0);
        int v2 = ArraysKt.getLastIndex(arg9);
        if(v2 == 0) {
            return ULong.box-impl(v0);
        }

        Object v3 = arg10.invoke(ULong.box-impl(v0));
        int v4 = 1;
        if(1 <= v2) {
            while(true) {
                long v5 = ULongArray.get-s-VKNKU(arg9, v4);
                Object v7 = arg10.invoke(ULong.box-impl(v5));
                if(((Comparable)v3).compareTo(v7) > 0) {
                    v0 = v5;
                    v3 = v7;
                }

                if(v4 == v2) {
                    break;
                }

                ++v4;
            }
        }

        return ULong.box-impl(v0);
    }

    @Deprecated(message="Use minByOrNull instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="1.5", hiddenSince="1.6", warningSince="1.4") private static final UInt minBy-jgv0xPQ(int[] arg7, Function1 arg8) {
        Intrinsics.checkNotNullParameter(arg7, "$this$minBy");
        Intrinsics.checkNotNullParameter(arg8, "selector");
        if(UIntArray.isEmpty-impl(arg7)) {
            return null;
        }

        int v0 = UIntArray.get-pVg5ArA(arg7, 0);
        int v1 = ArraysKt.getLastIndex(arg7);
        if(v1 == 0) {
            return UInt.box-impl(v0);
        }

        Object v2 = arg8.invoke(UInt.box-impl(v0));
        int v3 = 1;
        if(1 <= v1) {
            while(true) {
                int v4 = UIntArray.get-pVg5ArA(arg7, v3);
                Object v5 = arg8.invoke(UInt.box-impl(v4));
                if(((Comparable)v2).compareTo(v5) > 0) {
                    v0 = v4;
                    v2 = v5;
                }

                if(v3 == v1) {
                    break;
                }

                ++v3;
            }
        }

        return UInt.box-impl(v0);
    }

    @Deprecated(message="Use minByOrNull instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="1.5", hiddenSince="1.6", warningSince="1.4") private static final UShort minBy-xTcfx_M(short[] arg7, Function1 arg8) {
        Intrinsics.checkNotNullParameter(arg7, "$this$minBy");
        Intrinsics.checkNotNullParameter(arg8, "selector");
        if(UShortArray.isEmpty-impl(arg7)) {
            return null;
        }

        short v0 = UShortArray.get-Mh2AYeg(arg7, 0);
        int v1 = ArraysKt.getLastIndex(arg7);
        if(v1 == 0) {
            return UShort.box-impl(v0);
        }

        Object v2 = arg8.invoke(UShort.box-impl(v0));
        int v3 = 1;
        if(1 <= v1) {
            while(true) {
                short v4 = UShortArray.get-Mh2AYeg(arg7, v3);
                Object v5 = arg8.invoke(UShort.box-impl(v4));
                if(((Comparable)v2).compareTo(v5) > 0) {
                    v0 = v4;
                    v2 = v5;
                }

                if(v3 == v1) {
                    break;
                }

                ++v3;
            }
        }

        return UShort.box-impl(v0);
    }

    @Deprecated(message="Use minWithOrNull instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="1.5", hiddenSince="1.6", warningSince="1.4") public static final UByte minWith-XMRcp5o(byte[] arg1, Comparator arg2) {
        Intrinsics.checkNotNullParameter(arg1, "$this$minWith");
        Intrinsics.checkNotNullParameter(arg2, "comparator");
        return UArraysKt.minWithOrNull-XMRcp5o(arg1, arg2);
    }

    @Deprecated(message="Use minWithOrNull instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="1.5", hiddenSince="1.6", warningSince="1.4") public static final UInt minWith-YmdZ_VM(int[] arg1, Comparator arg2) {
        Intrinsics.checkNotNullParameter(arg1, "$this$minWith");
        Intrinsics.checkNotNullParameter(arg2, "comparator");
        return UArraysKt.minWithOrNull-YmdZ_VM(arg1, arg2);
    }

    @Deprecated(message="Use minWithOrNull instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="1.5", hiddenSince="1.6", warningSince="1.4") public static final UShort minWith-eOHTfZs(short[] arg1, Comparator arg2) {
        Intrinsics.checkNotNullParameter(arg1, "$this$minWith");
        Intrinsics.checkNotNullParameter(arg2, "comparator");
        return UArraysKt.minWithOrNull-eOHTfZs(arg1, arg2);
    }

    @Deprecated(message="Use minWithOrNull instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="1.5", hiddenSince="1.6", warningSince="1.4") public static final ULong minWith-zrEWJaI(long[] arg1, Comparator arg2) {
        Intrinsics.checkNotNullParameter(arg1, "$this$minWith");
        Intrinsics.checkNotNullParameter(arg2, "comparator");
        return UArraysKt.minWithOrNull-zrEWJaI(arg1, arg2);
    }

    private static final BigDecimal sumOfBigDecimal(byte[] arg4, Function1 arg5) {
        Intrinsics.checkNotNullParameter(arg4, "$this$sumOf");
        Intrinsics.checkNotNullParameter(arg5, "selector");
        BigDecimal v0 = BigDecimal.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(v0, "valueOf(...)");
        int v1 = UByteArray.getSize-impl(arg4);
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            v0 = v0.add(arg5.invoke(UByte.box-impl(UByteArray.get-w2LRezQ(arg4, v2))));
            Intrinsics.checkNotNullExpressionValue(v0, "add(...)");
        }

        return v0;
    }

    private static final BigDecimal sumOfBigDecimal(int[] arg4, Function1 arg5) {
        Intrinsics.checkNotNullParameter(arg4, "$this$sumOf");
        Intrinsics.checkNotNullParameter(arg5, "selector");
        BigDecimal v0 = BigDecimal.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(v0, "valueOf(...)");
        int v1 = UIntArray.getSize-impl(arg4);
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            v0 = v0.add(arg5.invoke(UInt.box-impl(UIntArray.get-pVg5ArA(arg4, v2))));
            Intrinsics.checkNotNullExpressionValue(v0, "add(...)");
        }

        return v0;
    }

    private static final BigDecimal sumOfBigDecimal(long[] arg5, Function1 arg6) {
        Intrinsics.checkNotNullParameter(arg5, "$this$sumOf");
        Intrinsics.checkNotNullParameter(arg6, "selector");
        BigDecimal v0 = BigDecimal.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(v0, "valueOf(...)");
        int v1 = ULongArray.getSize-impl(arg5);
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            v0 = v0.add(arg6.invoke(ULong.box-impl(ULongArray.get-s-VKNKU(arg5, v2))));
            Intrinsics.checkNotNullExpressionValue(v0, "add(...)");
        }

        return v0;
    }

    private static final BigDecimal sumOfBigDecimal(short[] arg4, Function1 arg5) {
        Intrinsics.checkNotNullParameter(arg4, "$this$sumOf");
        Intrinsics.checkNotNullParameter(arg5, "selector");
        BigDecimal v0 = BigDecimal.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(v0, "valueOf(...)");
        int v1 = UShortArray.getSize-impl(arg4);
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            v0 = v0.add(arg5.invoke(UShort.box-impl(UShortArray.get-Mh2AYeg(arg4, v2))));
            Intrinsics.checkNotNullExpressionValue(v0, "add(...)");
        }

        return v0;
    }

    private static final BigInteger sumOfBigInteger(byte[] arg4, Function1 arg5) {
        Intrinsics.checkNotNullParameter(arg4, "$this$sumOf");
        Intrinsics.checkNotNullParameter(arg5, "selector");
        BigInteger v0 = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(v0, "valueOf(...)");
        int v1 = UByteArray.getSize-impl(arg4);
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            v0 = v0.add(arg5.invoke(UByte.box-impl(UByteArray.get-w2LRezQ(arg4, v2))));
            Intrinsics.checkNotNullExpressionValue(v0, "add(...)");
        }

        return v0;
    }

    private static final BigInteger sumOfBigInteger(int[] arg4, Function1 arg5) {
        Intrinsics.checkNotNullParameter(arg4, "$this$sumOf");
        Intrinsics.checkNotNullParameter(arg5, "selector");
        BigInteger v0 = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(v0, "valueOf(...)");
        int v1 = UIntArray.getSize-impl(arg4);
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            v0 = v0.add(arg5.invoke(UInt.box-impl(UIntArray.get-pVg5ArA(arg4, v2))));
            Intrinsics.checkNotNullExpressionValue(v0, "add(...)");
        }

        return v0;
    }

    private static final BigInteger sumOfBigInteger(long[] arg5, Function1 arg6) {
        Intrinsics.checkNotNullParameter(arg5, "$this$sumOf");
        Intrinsics.checkNotNullParameter(arg6, "selector");
        BigInteger v0 = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(v0, "valueOf(...)");
        int v1 = ULongArray.getSize-impl(arg5);
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            v0 = v0.add(arg6.invoke(ULong.box-impl(ULongArray.get-s-VKNKU(arg5, v2))));
            Intrinsics.checkNotNullExpressionValue(v0, "add(...)");
        }

        return v0;
    }

    private static final BigInteger sumOfBigInteger(short[] arg4, Function1 arg5) {
        Intrinsics.checkNotNullParameter(arg4, "$this$sumOf");
        Intrinsics.checkNotNullParameter(arg5, "selector");
        BigInteger v0 = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(v0, "valueOf(...)");
        int v1 = UShortArray.getSize-impl(arg4);
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            v0 = v0.add(arg5.invoke(UShort.box-impl(UShortArray.get-Mh2AYeg(arg4, v2))));
            Intrinsics.checkNotNullExpressionValue(v0, "add(...)");
        }

        return v0;
    }
}

