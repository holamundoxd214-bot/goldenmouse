package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.Regex;

@Metadata(d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u000F\n\u0000\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000E\n\u0002\b\u001A\n\u0002\u0010\u000B\n\u0002\b\u000B\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0081@\u0018\u0000 O2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001OB\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\u0006\u001A\u00020\t¢\u0006\u0004\b\u0004\u0010\nJ\r\u0010\r\u001A\u00020\u000E¢\u0006\u0004\b\u000F\u0010\u0010J\r\u0010\u0011\u001A\u00020\u0003¢\u0006\u0004\b\u0012\u0010\u0005J\r\u0010\u0013\u001A\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001A\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u001AJ\r\u0010\u001B\u001A\u00020\u0007¢\u0006\u0004\b\u001C\u0010\u001DJ\r\u0010\u001E\u001A\u00020\t¢\u0006\u0004\b\u001F\u0010 J\r\u0010!\u001A\u00020\u0014¢\u0006\u0004\b\"\u0010\u0016J\r\u0010#\u001A\u00020\u0014¢\u0006\u0004\b$\u0010\u0016J\u000F\u0010%\u001A\u00020&H\u0016¢\u0006\u0004\b\'\u0010(J\u0018\u0010)\u001A\u00020\u00142\u0006\u0010*\u001A\u00020\u0000H\u0096\u0002¢\u0006\u0004\b+\u0010,J\u0015\u0010/\u001A\u00020\u00002\u0006\u0010-\u001A\u00020\u0000¢\u0006\u0004\b0\u00101J\r\u00102\u001A\u00020\u0000¢\u0006\u0004\b3\u0010\u0005J\r\u00104\u001A\u00020\u0000¢\u0006\u0004\b5\u0010\u0005J\r\u00106\u001A\u00020\u0000¢\u0006\u0004\b7\u0010\u0005J\r\u00108\u001A\u00020\u0000¢\u0006\u0004\b9\u0010\u0005J\r\u0010:\u001A\u00020\u0000¢\u0006\u0004\b;\u0010\u0005J\r\u0010@\u001A\u00020A¢\u0006\u0004\bB\u0010CJ\r\u0010D\u001A\u00020A¢\u0006\u0004\bE\u0010CJ\r\u0010F\u001A\u00020A¢\u0006\u0004\bG\u0010CJ\r\u0010H\u001A\u00020A¢\u0006\u0004\bI\u0010CJ\r\u0010J\u001A\u00020&¢\u0006\u0004\bK\u0010(J\u0013\u0010L\u001A\u00020A2\b\u0010*\u001A\u0004\u0018\u00010MHÖ\u0003J\t\u0010N\u001A\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010-\u001A\u00020\u00008F¢\u0006\u0006\u001A\u0004\b.\u0010\u0005R\u0011\u0010<\u001A\u00020\u00148F¢\u0006\u0006\u001A\u0004\b=\u0010\u0016R\u0011\u0010>\u001A\u00020\u00148F¢\u0006\u0006\u001A\u0004\b?\u0010\u0016\u0088\u0001\u0002¨\u0006P"}, d2={"Landroidx/compose/ui/graphics/Float16;", "", "halfValue", "", "constructor-impl", "(S)S", "value", "", "(F)S", "", "(D)S", "getHalfValue", "()S", "toByte", "", "toByte-impl", "(S)B", "toShort", "toShort-impl", "toInt", "", "toInt-impl", "(S)I", "toLong", "", "toLong-impl", "(S)J", "toFloat", "toFloat-impl", "(S)F", "toDouble", "toDouble-impl", "(S)D", "toBits", "toBits-impl", "toRawBits", "toRawBits-impl", "toString", "", "toString-impl", "(S)Ljava/lang/String;", "compareTo", "other", "compareTo-41bOqos", "(SS)I", "sign", "getSign-slo4al4", "withSign", "withSign-qCeQghg", "(SS)S", "absoluteValue", "absoluteValue-slo4al4", "round", "round-slo4al4", "ceil", "ceil-slo4al4", "floor", "floor-slo4al4", "trunc", "trunc-slo4al4", "exponent", "getExponent-impl", "significand", "getSignificand-impl", "isNaN", "", "isNaN-impl", "(S)Z", "isInfinite", "isInfinite-impl", "isFinite", "isFinite-impl", "isNormalized", "isNormalized-impl", "toHexString", "toHexString-impl", "equals", "", "hashCode", "Companion", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class Float16 implements Comparable {
    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001A\u00020\u0007¢\u0006\n\n\u0002\u0010\n\u001A\u0004\b\b\u0010\tR\u000E\u0010\u000B\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\r\u001A\u00020\u0007¢\u0006\n\n\u0002\u0010\n\u001A\u0004\b\u000E\u0010\tR\u0013\u0010\u000F\u001A\u00020\u0007¢\u0006\n\n\u0002\u0010\n\u001A\u0004\b\u0010\u0010\tR\u0013\u0010\u0011\u001A\u00020\u0007¢\u0006\n\n\u0002\u0010\n\u001A\u0004\b\u0012\u0010\tR\u0013\u0010\u0013\u001A\u00020\u0007¢\u0006\n\n\u0002\u0010\n\u001A\u0004\b\u0014\u0010\tR\u0013\u0010\u0015\u001A\u00020\u0007¢\u0006\n\n\u0002\u0010\n\u001A\u0004\b\u0016\u0010\tR\u0013\u0010\u0017\u001A\u00020\u0007¢\u0006\n\n\u0002\u0010\n\u001A\u0004\b\u0018\u0010\tR\u0013\u0010\u0019\u001A\u00020\u0007¢\u0006\n\n\u0002\u0010\n\u001A\u0004\b\u001A\u0010\tR\u0013\u0010\u001B\u001A\u00020\u0007¢\u0006\n\n\u0002\u0010\n\u001A\u0004\b\u001C\u0010\tR\u0013\u0010\u001D\u001A\u00020\u0007¢\u0006\n\n\u0002\u0010\n\u001A\u0004\b\u001E\u0010\t¨\u0006\u001F"}, d2={"Landroidx/compose/ui/graphics/Float16$Companion;", "", "<init>", "()V", "Size", "", "Epsilon", "Landroidx/compose/ui/graphics/Float16;", "getEpsilon-slo4al4", "()S", "S", "MaxExponent", "MinExponent", "LowestValue", "getLowestValue-slo4al4", "MaxValue", "getMaxValue-slo4al4", "MinNormal", "getMinNormal-slo4al4", "MinValue", "getMinValue-slo4al4", "NaN", "getNaN-slo4al4", "NegativeInfinity", "getNegativeInfinity-slo4al4", "NegativeZero", "getNegativeZero-slo4al4", "PositiveInfinity", "getPositiveInfinity-slo4al4", "PositiveZero", "getPositiveZero-slo4al4", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final short getEpsilon-slo4al4() {
            return Float16.Epsilon;
        }

        public final short getLowestValue-slo4al4() {
            return Float16.LowestValue;
        }

        public final short getMaxValue-slo4al4() {
            return Float16.MaxValue;
        }

        public final short getMinNormal-slo4al4() {
            return Float16.MinNormal;
        }

        public final short getMinValue-slo4al4() {
            return Float16.MinValue;
        }

        public final short getNaN-slo4al4() {
            return Float16.NaN;
        }

        public final short getNegativeInfinity-slo4al4() {
            return Float16.NegativeInfinity;
        }

        public final short getNegativeZero-slo4al4() {
            return Float16.NegativeZero;
        }

        public final short getPositiveInfinity-slo4al4() {
            return Float16.PositiveInfinity;
        }

        public final short getPositiveZero-slo4al4() {
            return Float16.PositiveZero;
        }
    }

    public static final Companion Companion = null;
    private static final short Epsilon = 0;
    private static final short LowestValue = 0;
    public static final int MaxExponent = 15;
    private static final short MaxValue = 0;
    public static final int MinExponent = -14;
    private static final short MinNormal = 0;
    private static final short MinValue = 0;
    private static final short NaN = 0;
    private static final short NegativeInfinity = 0;
    private static final short NegativeZero = 0;
    private static final short PositiveInfinity = 0;
    private static final short PositiveZero = 0;
    public static final int Size = 16;
    private final short halfValue;

    static {
        Float16.Companion = new Companion(null);
        Float16.Epsilon = Float16.constructor-impl(0x1400);
        Float16.LowestValue = Float16.constructor-impl(-1025);
        Float16.MaxValue = Float16.constructor-impl(0x7BFF);
        Float16.MinNormal = Float16.constructor-impl(0x400);
        Float16.MinValue = Float16.constructor-impl(1);
        Float16.NaN = Float16.constructor-impl(0x7E00);
        Float16.NegativeInfinity = Float16.constructor-impl(-1024);
        Float16.NegativeZero = Float16.constructor-impl(-32768);
        Float16.PositiveInfinity = Float16.constructor-impl(0x7C00);
        Float16.PositiveZero = Float16.constructor-impl(0);
    }

    private Float16(short arg1) {
        super();
        this.halfValue = arg1;
    }

    public static final short absoluteValue-slo4al4(short arg0) {
        return Float16.constructor-impl(((short)(arg0 & 0x7FFF)));
    }

    public static final short access$getEpsilon$cp() {
        return Float16.Epsilon;
    }

    public static final short access$getLowestValue$cp() {
        return Float16.LowestValue;
    }

    public static final short access$getMaxValue$cp() {
        return Float16.MaxValue;
    }

    public static final short access$getMinNormal$cp() {
        return Float16.MinNormal;
    }

    public static final short access$getMinValue$cp() {
        return Float16.MinValue;
    }

    public static final short access$getNaN$cp() {
        return Float16.NaN;
    }

    public static final short access$getNegativeInfinity$cp() {
        return Float16.NegativeInfinity;
    }

    public static final short access$getNegativeZero$cp() {
        return Float16.NegativeZero;
    }

    public static final short access$getPositiveInfinity$cp() {
        return Float16.PositiveInfinity;
    }

    public static final short access$getPositiveZero$cp() {
        return Float16.PositiveZero;
    }

    public static final Float16 box-impl(short arg1) {
        return new Float16(arg1);
    }

    public static final short ceil-slo4al4(short arg5) {
        int v5;
        int v0 = 0xFFFF & arg5;
        int v1 = arg5 & 0x7FFF;
        int v2 = 1;
        int v3 = 0x3C00;
        if(v1 < v3) {
            v5 = arg5 & 0x8000;
            v0 = ~(v0 >> 15);
            if(v1 != 0) {
            }
            else {
                v2 = 0;
            }

            v0 = -(v0 & v2) & v3 | v5;
        }
        else {
            if(v1 >= 0x6400) {
                goto label_30;
            }

            v5 = (1 << 25 - (v1 >> 10)) - 1;
            v0 = v0 + ((v0 >> 15) - 1 & v5) & ~v5;
        }

    label_30:
        return Float16.constructor-impl(((short)v0));
    }

    public int compareTo(Object arg1) {
        return this.compareTo-41bOqos(((Float16)arg1).unbox-impl());
    }

    public static int compareTo-41bOqos(short arg3, short arg4) {
        if(Float16.isNaN-impl(arg3)) {
            return Float16.isNaN-impl(arg4) ^ 1;
        }

        if(Float16.isNaN-impl(arg4)) {
            return -1;
        }

        int v0 = 0x8000;
        int v2 = 0xFFFF;
        int v3 = (arg3 & v0) != 0 ? v0 - (arg3 & v2) : arg3 & v2;
        if((arg4 & v0) != 0) {
            v0 -= arg4 & v2;
        }
        else {
            v0 = arg4 & v2;
        }

        return Intrinsics.compare(v3, v0);
    }

    public int compareTo-41bOqos(short arg1) {
        return Float16.compareTo-41bOqos(this.halfValue, arg1);
    }

    public static short constructor-impl(short arg0) {
        return arg0;
    }

    public static short constructor-impl(double arg0) {
        return Float16.constructor-impl(((float)arg0));
    }

    public static short constructor-impl(float arg6) {
        int v6 = Float.floatToRawIntBits(arg6);
        int v0 = v6 >>> 0x1F;
        int v1 = v6 >>> 23 & 0xFF;
        int v3 = 0x7FFFFF & v6;
        int v4 = 0x1F;
        int v5 = 0;
        if(v1 != 0xFF) {
            v1 += 0xFFFFFF90;
            if(v1 >= v4) {
                v4 = 49;
                goto label_43;
            }
            else if(v1 <= 0) {
                if(v1 >= -10) {
                    v6 = (0x800000 | v3) >> 1 - v1;
                    if((v6 & 0x1000) != 0) {
                        v6 += 0x2000;
                    }

                    v6 >>= 13;
                    v4 = 0;
                label_29:
                    v5 = v6;
                }
                else {
                    v4 = 0;
                }

                goto label_43;
            }
            else {
                v5 = v3 >> 13;
                if((v6 & 0x1000) != 0) {
                    v6 = (v1 << 10 | v5) + 1 | v0 << 15;
                    goto label_47;
                }

                v4 = v1;
            label_43:
                v6 = v0 << 15 | v4 << 10 | v5;
            }
        }
        else if(v3 != 0) {
            v6 = 0x200;
            goto label_29;
        }
        else {
            goto label_43;
        }

    label_47:
        return Float16.constructor-impl(((short)v6));
    }

    public boolean equals(Object arg1) {
        return Float16.equals-impl(this.halfValue, arg1);
    }

    public static boolean equals-impl(short arg2, Object arg3) {
        if(!(arg3 instanceof Float16)) {
            return 0;
        }

        if(arg2 != ((Float16)arg3).unbox-impl()) {
            return 0;
        }

        return 1;
    }

    public static final boolean equals-impl0(short arg0, short arg1) {
        if(arg0 == arg1) {
            return 1;
        }

        return 0;
    }

    public static final short floor-slo4al4(short arg4) {
        int v4;
        int v0 = 0xFFFF;
        int v1 = arg4 & v0;
        int v2 = arg4 & 0x7FFF;
        int v3 = 0x3C00;
        if(v2 < v3) {
            v4 = arg4 & 0x8000;
            if(v1 > 0x8000) {
            }
            else {
                v0 = 0;
            }

            v1 = v4 | v0 & v3;
        }
        else {
            if(v2 >= 0x6400) {
                goto label_26;
            }

            v4 = (1 << 25 - (v2 >> 10)) - 1;
            v1 = v1 + (-(v1 >> 15) & v4) & ~v4;
        }

    label_26:
        return Float16.constructor-impl(((short)v1));
    }

    public static final int getExponent-impl(short arg0) {
        return (arg0 >>> 10 & 0x1F) - 15;
    }

    public final short getHalfValue() {
        return this.halfValue;
    }

    public static final short getSign-slo4al4(short arg4) {
        int v0 = arg4 & 0x7FFF;
        int v2 = 1;
        int v1 = v0 > 0x7C00 ? 1 : 0;
        if(v0 == 0) {
        }
        else {
            v2 = 0;
        }

        if((v1 | v2) != 0) {
        }
        else {
            v0 = arg4 & 0x8000 | 0x3C00;
        }

        return Float16.constructor-impl(((short)v0));
    }

    public static final int getSignificand-impl(short arg0) {
        return arg0 & 0x3FF;
    }

    public int hashCode() {
        return Float16.hashCode-impl(this.halfValue);
    }

    public static int hashCode-impl(short arg0) {
        return Short.hashCode(arg0);
    }

    public static final boolean isFinite-impl(short arg1) {
        if((arg1 & 0x7FFF) != 0x7C00) {
            return 1;
        }

        return 0;
    }

    public static final boolean isInfinite-impl(short arg1) {
        if((arg1 & 0x7FFF) == 0x7C00) {
            return 1;
        }

        return 0;
    }

    public static final boolean isNaN-impl(short arg1) {
        if((arg1 & 0x7FFF) > 0x7C00) {
            return 1;
        }

        return 0;
    }

    public static final boolean isNormalized-impl(short arg4) {
        int v0 = 0x7C00;
        int v4 = arg4 & v0;
        int v1 = 1;
        int v3 = v4 != 0 ? 1 : 0;
        if(v4 != v0) {
        }
        else {
            v1 = 0;
        }

        return v3 & v1;
    }

    public static final short round-slo4al4(short arg4) {
        int v4;
        int v0 = 0xFFFF;
        int v1 = arg4 & v0;
        int v2 = arg4 & 0x7FFF;
        int v3 = 0x3C00;
        if(v2 < v3) {
            v4 = arg4 & 0x8000;
            if(v2 >= 0x3800) {
            }
            else {
                v0 = 0;
            }

            v1 = v4 | v0 & v3;
        }
        else {
            if(v2 >= 0x6400) {
                goto label_26;
            }

            v4 = v2 >> 10;
            v1 = v1 + (1 << 24 - v4) & ~((1 << 25 - v4) - 1);
        }

    label_26:
        return Float16.constructor-impl(((short)v1));
    }

    public static final int toBits-impl(short arg1) {
        if(Float16.isNaN-impl(arg1)) {
            return 0x7E00;
        }

        return arg1 & 0xFFFF;
    }

    public static final byte toByte-impl(short arg0) {
        return ((byte)(((int)Float16.toFloat-impl(arg0))));
    }

    public static final double toDouble-impl(short arg2) {
        return ((double)Float16.toFloat-impl(arg2));
    }

    public static final float toFloat-impl(short arg4) {
        int v1 = 0x8000 & arg4;
        int v2 = 0x1F;
        int v0 = (0xFFFF & arg4) >>> 10 & v2;
        int v4 = arg4 & 0x3FF;
        if(v0 != 0) {
            v4 <<= 13;
            if(v0 == v2) {
                v0 = 0xFF;
                if(v4 != 0) {
                    v4 |= 0x400000;
                }
            }
            else {
                v0 += 0x70;
            }

            int v3 = v0;
            v0 = v4;
            v4 = v3;
        }
        else if(v4 != 0) {
            float v4_1 = Float.intBitsToFloat(v4 + 0x3F000000) - Float16Kt.access$getFp32DenormalFloat$p();
            if(v1 == 0) {
                return v4_1;
            }
            else {
                return -v4_1;
            }
        }
        else {
            v4 = 0;
            v0 = 0;
        }

        return Float.intBitsToFloat(v4 << 23 | v1 << 16 | v0);
    }

    public static final String toHexString-impl(short arg7) {
        String v7_1;
        StringBuilder v0 = new StringBuilder();
        int v1 = 0xFFFF & arg7;
        int v2 = v1 >>> 15;
        v1 = v1 >>> 10 & 0x1F;
        int v7 = arg7 & 0x3FF;
        char v4 = '-';
        if(v1 != 0x1F) {
            if(v2 == 1) {
                v0.append(v4);
            }

            String v2_1 = "";
            String v3 = "0{2,}$";
            String v4_1 = "toString(...)";
            int v5 = 16;
            if(v1 == 0) {
                if(v7 == 0) {
                    v0.append("0x0.0p0");
                    goto label_58;
                }

                v0.append("0x0.");
                v7_1 = Integer.toString(v7, CharsKt.checkRadix(v5));
                Intrinsics.checkNotNullExpressionValue(v7_1, v4_1);
                v0.append(new Regex(v3).replaceFirst(((CharSequence)v7_1), v2_1));
                v0.append("p-14");
                goto label_58;
            }

            v0.append("0x1.");
            v7_1 = Integer.toString(v7, CharsKt.checkRadix(v5));
            Intrinsics.checkNotNullExpressionValue(v7_1, v4_1);
            v0.append(new Regex(v3).replaceFirst(((CharSequence)v7_1), v2_1));
            v0.append('p');
            v0.append(String.valueOf(v1 - 15));
        }
        else if(v7 == 0) {
            if(v2 != 0) {
                v0.append(v4);
            }

            v0.append("Infinity");
        }
        else {
            v0.append("NaN");
        }

    label_58:
        return v0.toString();
    }

    public static final int toInt-impl(short arg0) {
        return ((int)Float16.toFloat-impl(arg0));
    }

    public static final long toLong-impl(short arg2) {
        return ((long)Float16.toFloat-impl(arg2));
    }

    public static final int toRawBits-impl(short arg1) {
        return arg1 & 0xFFFF;
    }

    public static final short toShort-impl(short arg0) {
        return ((short)(((int)Float16.toFloat-impl(arg0))));
    }

    public String toString() {
        return Float16.toString-impl(this.halfValue);
    }

    public static String toString-impl(short arg0) {
        return String.valueOf(Float16.toFloat-impl(arg0));
    }

    public static final short trunc-slo4al4(short arg3) {
        int v0 = 0xFFFF & arg3;
        int v1 = arg3 & 0x7FFF;
        if(v1 < 0x3C00) {
            v0 = 0x8000 & arg3;
        }
        else if(v1 < 0x6400) {
            v0 &= ~((1 << 25 - (v1 >> 10)) - 1);
        }

        return Float16.constructor-impl(((short)v0));
    }

    public final short unbox-impl() {
        return this.halfValue;
    }

    public static final short withSign-qCeQghg(short arg1, short arg2) {
        return Float16.constructor-impl(((short)(arg1 & 0x7FFF | arg2 & 0x8000)));
    }
}

