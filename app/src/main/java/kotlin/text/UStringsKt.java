package kotlin.text;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000,\n\u0000\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u001A\u001D\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0087\u0080\u0004¢\u0006\u0004\b\u0005\u0010\u0006\u001A\u001D\u0010\u0000\u001A\u00020\u0001*\u00020\u00072\u0006\u0010\u0003\u001A\u00020\u0004H\u0087\u0080\u0004¢\u0006\u0004\b\b\u0010\t\u001A\u001D\u0010\u0000\u001A\u00020\u0001*\u00020\n2\u0006\u0010\u0003\u001A\u00020\u0004H\u0087\u0080\u0004¢\u0006\u0004\b\u000B\u0010\f\u001A\u001D\u0010\u0000\u001A\u00020\u0001*\u00020\r2\u0006\u0010\u0003\u001A\u00020\u0004H\u0087\u0080\u0004¢\u0006\u0004\b\u000E\u0010\u000F\u001A\u0013\u0010\u0010\u001A\u00020\u0002*\u00020\u0001H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0011\u001A\u001B\u0010\u0010\u001A\u00020\u0002*\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u0004H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0012\u001A\u0013\u0010\u0013\u001A\u00020\u0007*\u00020\u0001H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0014\u001A\u001B\u0010\u0013\u001A\u00020\u0007*\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u0004H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0015\u001A\u0013\u0010\u0016\u001A\u00020\n*\u00020\u0001H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0017\u001A\u001B\u0010\u0016\u001A\u00020\n*\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u0004H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0018\u001A\u0013\u0010\u0019\u001A\u00020\r*\u00020\u0001H\u0087\u0080\u0004¢\u0006\u0002\u0010\u001A\u001A\u001B\u0010\u0019\u001A\u00020\r*\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u0004H\u0087\u0080\u0004¢\u0006\u0002\u0010\u001B\u001A\u0010\u0010\u001C\u001A\u0004\u0018\u00010\u0002*\u00020\u0001H\u0087\u0080\u0004\u001A\u0018\u0010\u001C\u001A\u0004\u0018\u00010\u0002*\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u0004H\u0087\u0080\u0004\u001A\u0010\u0010\u001D\u001A\u0004\u0018\u00010\u0007*\u00020\u0001H\u0087\u0080\u0004\u001A\u0018\u0010\u001D\u001A\u0004\u0018\u00010\u0007*\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u0004H\u0087\u0080\u0004\u001A\u0010\u0010\u001E\u001A\u0004\u0018\u00010\n*\u00020\u0001H\u0087\u0080\u0004\u001A\u0018\u0010\u001E\u001A\u0004\u0018\u00010\n*\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u0004H\u0087\u0080\u0004\u001A\u0010\u0010\u001F\u001A\u0004\u0018\u00010\r*\u00020\u0001H\u0087\u0080\u0004\u001A\u0018\u0010\u001F\u001A\u0004\u0018\u00010\r*\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u0004H\u0087\u0080\u0004¨\u0006 "}, d2={"toString", "", "Lkotlin/UByte;", "radix", "", "toString-LxnNnR4", "(BI)Ljava/lang/String;", "Lkotlin/UShort;", "toString-olVBNx4", "(SI)Ljava/lang/String;", "Lkotlin/UInt;", "toString-V7xB4Y4", "(II)Ljava/lang/String;", "Lkotlin/ULong;", "toString-JSWoG40", "(JI)Ljava/lang/String;", "toUByte", "(Ljava/lang/String;)B", "(Ljava/lang/String;I)B", "toUShort", "(Ljava/lang/String;)S", "(Ljava/lang/String;I)S", "toUInt", "(Ljava/lang/String;)I", "(Ljava/lang/String;I)I", "toULong", "(Ljava/lang/String;)J", "(Ljava/lang/String;I)J", "toUByteOrNull", "toUShortOrNull", "toUIntOrNull", "toULongOrNull", "kotlin-stdlib"}, k=2, mv={2, 3, 0}, xi=0x30) public final class UStringsKt {
    public static final String toString-JSWoG40(long arg0, int arg2) {
        return UnsignedKt.ulongToString(arg0, CharsKt.checkRadix(arg2));
    }

    public static final String toString-LxnNnR4(byte arg0, int arg1) {
        String v0 = Integer.toString(arg0 & 0xFF, CharsKt.checkRadix(arg1));
        Intrinsics.checkNotNullExpressionValue(v0, "toString(...)");
        return v0;
    }

    public static final String toString-V7xB4Y4(int arg4, int arg5) {
        return UnsignedKt.ulongToString((((long)arg4)) & 0xFFFFFFFFL, CharsKt.checkRadix(arg5));
    }

    public static final String toString-olVBNx4(short arg1, int arg2) {
        String v1 = Integer.toString(arg1 & 0xFFFF, CharsKt.checkRadix(arg2));
        Intrinsics.checkNotNullExpressionValue(v1, "toString(...)");
        return v1;
    }

    public static final byte toUByte(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        UByte v0 = UStringsKt.toUByteOrNull(arg1);
        if(v0 != null) {
            return v0.unbox-impl();
        }

        StringsKt.numberFormatError(arg1);
        throw new KotlinNothingValueException();
    }

    public static final byte toUByte(String arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        UByte v2 = UStringsKt.toUByteOrNull(arg1, arg2);
        if(v2 != null) {
            return v2.unbox-impl();
        }

        StringsKt.numberFormatError(arg1);
        throw new KotlinNothingValueException();
    }

    public static final UByte toUByteOrNull(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return UStringsKt.toUByteOrNull(arg1, 10);
    }

    public static final UByte toUByteOrNull(String arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        UInt v1 = UStringsKt.toUIntOrNull(arg1, arg2);
        UByte v2 = null;
        if(v1 != null) {
            int v1_1 = v1.unbox-impl();
            if(Integer.compareUnsigned(v1_1, UInt.constructor-impl(0xFF)) > 0) {
                return v2;
            }

            return UByte.box-impl(UByte.constructor-impl(((byte)v1_1)));
        }

        return v2;
    }

    public static final int toUInt(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        UInt v0 = UStringsKt.toUIntOrNull(arg1);
        if(v0 != null) {
            return v0.unbox-impl();
        }

        StringsKt.numberFormatError(arg1);
        throw new KotlinNothingValueException();
    }

    public static final int toUInt(String arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        UInt v2 = UStringsKt.toUIntOrNull(arg1, arg2);
        if(v2 != null) {
            return v2.unbox-impl();
        }

        StringsKt.numberFormatError(arg1);
        throw new KotlinNothingValueException();
    }

    public static final UInt toUIntOrNull(String arg9, int arg10) {
        int v4;
        Intrinsics.checkNotNullParameter(arg9, "<this>");
        CharsKt.checkRadix(arg10);
        int v0 = arg9.length();
        UInt v1 = null;
        if(v0 == 0) {
            return v1;
        }

        int v2 = 0;
        int v3 = arg9.charAt(0);
        if(Intrinsics.compare(v3, 0x30) < 0) {
            v4 = 1;
            if(v0 != 1 && v3 == 43) {
                goto label_18;
            }

            return v1;
        }
        else {
            v4 = 0;
        }

    label_18:
        v3 = UInt.constructor-impl(arg10);
        int v5 = 119304647;
        int v6 = v5;
        while(v4 < v0) {
            int v7 = CharsKt.digitOf(arg9.charAt(v4), arg10);
            if(v7 < 0) {
                return v1;
            }

            if(Integer.compareUnsigned(v2, v6) > 0) {
                if(v6 == v5) {
                    v6 = Integer.divideUnsigned(-1, v3);
                    if(Integer.compareUnsigned(v2, v6) > 0) {
                        return v1;
                    }

                    goto label_34;
                }

                return v1;
            }

        label_34:
            v2 = UInt.constructor-impl(v2 * v3);
            v7 = UInt.constructor-impl(UInt.constructor-impl(v7) + v2);
            if(Integer.compareUnsigned(v7, v2) < 0) {
                return v1;
            }

            ++v4;
            v2 = v7;
        }

        return UInt.box-impl(v2);
    }

    public static final UInt toUIntOrNull(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return UStringsKt.toUIntOrNull(arg1, 10);
    }

    public static final long toULong(String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        ULong v0 = UStringsKt.toULongOrNull(arg2);
        if(v0 != null) {
            return v0.unbox-impl();
        }

        StringsKt.numberFormatError(arg2);
        throw new KotlinNothingValueException();
    }

    public static final long toULong(String arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        ULong v2 = UStringsKt.toULongOrNull(arg1, arg2);
        if(v2 != null) {
            return v2.unbox-impl();
        }

        StringsKt.numberFormatError(arg1);
        throw new KotlinNothingValueException();
    }

    public static final ULong toULongOrNull(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return UStringsKt.toULongOrNull(arg1, 10);
    }

    public static final ULong toULongOrNull(String arg17, int arg18) {
        String v0 = arg17;
        int v1 = arg18;
        Intrinsics.checkNotNullParameter(v0, "<this>");
        CharsKt.checkRadix(v1);
        int v2 = v0.length();
        ULong v3 = null;
        if(v2 == 0) {
            return v3;
        }

        int v4 = 0;
        int v5 = v0.charAt(0);
        if(Intrinsics.compare(v5, 0x30) < 0) {
            v4 = 1;
            if(v2 != 1 && v5 == 43) {
                goto label_19;
            }

            return v3;
        }

    label_19:
        long v5_1 = ULong.constructor-impl(((long)v1));
        long v7 = 512409557603043100L;
        long v9 = 0;
        long v11 = v7;
        while(v4 < v2) {
            int v13 = CharsKt.digitOf(v0.charAt(v4), v1);
            if(v13 < 0) {
                return v3;
            }

            if(Long.compareUnsigned(v9, v11) > 0) {
                if(v11 == v7) {
                    v11 = Long.divideUnsigned(-1, v5_1);
                    if(Long.compareUnsigned(v9, v11) > 0) {
                        return v3;
                    }

                    goto label_37;
                }

                return v3;
            }

        label_37:
            v9 = ULong.constructor-impl(v9 * v5_1);
            long v13_1 = ULong.constructor-impl(ULong.constructor-impl((((long)UInt.constructor-impl(v13))) & 0xFFFFFFFFL) + v9);
            if(Long.compareUnsigned(v13_1, v9) < 0) {
                return v3;
            }

            ++v4;
            v9 = v13_1;
        }

        return ULong.box-impl(v9);
    }

    public static final short toUShort(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        UShort v0 = UStringsKt.toUShortOrNull(arg1);
        if(v0 != null) {
            return v0.unbox-impl();
        }

        StringsKt.numberFormatError(arg1);
        throw new KotlinNothingValueException();
    }

    public static final short toUShort(String arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        UShort v2 = UStringsKt.toUShortOrNull(arg1, arg2);
        if(v2 != null) {
            return v2.unbox-impl();
        }

        StringsKt.numberFormatError(arg1);
        throw new KotlinNothingValueException();
    }

    public static final UShort toUShortOrNull(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return UStringsKt.toUShortOrNull(arg1, 10);
    }

    public static final UShort toUShortOrNull(String arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        UInt v1 = UStringsKt.toUIntOrNull(arg1, arg2);
        UShort v2 = null;
        if(v1 != null) {
            int v1_1 = v1.unbox-impl();
            if(Integer.compareUnsigned(v1_1, UInt.constructor-impl(0xFFFF)) > 0) {
                return v2;
            }

            return UShort.box-impl(UShort.constructor-impl(((short)v1_1)));
        }

        return v2;
    }
}

