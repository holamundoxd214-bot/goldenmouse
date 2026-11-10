package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000.\n\u0000\n\u0002\u0010\u0005\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0002\u001A\u0015\u0010\u0000\u001A\u0004\u0018\u00010\u0001*\u00020\u0002H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0003\u001A\u001D\u0010\u0000\u001A\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0004\u001A\u00020\u0005H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0006\u001A\u0015\u0010\u0007\u001A\u0004\u0018\u00010\b*\u00020\u0002H\u0087\u0080\u0004¢\u0006\u0002\u0010\t\u001A\u001D\u0010\u0007\u001A\u0004\u0018\u00010\b*\u00020\u00022\u0006\u0010\u0004\u001A\u00020\u0005H\u0087\u0080\u0004¢\u0006\u0002\u0010\n\u001A\u0015\u0010\u000B\u001A\u0004\u0018\u00010\u0005*\u00020\u0002H\u0087\u0080\u0004¢\u0006\u0002\u0010\f\u001A\u001D\u0010\u000B\u001A\u0004\u0018\u00010\u0005*\u00020\u00022\u0006\u0010\u0004\u001A\u00020\u0005H\u0087\u0080\u0004¢\u0006\u0002\u0010\r\u001A\u0015\u0010\u000E\u001A\u0004\u0018\u00010\u000F*\u00020\u0002H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0010\u001A\u001D\u0010\u000E\u001A\u0004\u0018\u00010\u000F*\u00020\u00022\u0006\u0010\u0004\u001A\u00020\u0005H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0011\u001A\u0012\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u0002H\u0080\u0080\u0004¨\u0006\u0015"}, d2={"toByteOrNull", "", "", "(Ljava/lang/String;)Ljava/lang/Byte;", "radix", "", "(Ljava/lang/String;I)Ljava/lang/Byte;", "toShortOrNull", "", "(Ljava/lang/String;)Ljava/lang/Short;", "(Ljava/lang/String;I)Ljava/lang/Short;", "toIntOrNull", "(Ljava/lang/String;)Ljava/lang/Integer;", "(Ljava/lang/String;I)Ljava/lang/Integer;", "toLongOrNull", "", "(Ljava/lang/String;)Ljava/lang/Long;", "(Ljava/lang/String;I)Ljava/lang/Long;", "numberFormatError", "", "input", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/text/StringsKt") class StringsKt__StringNumberConversionsKt extends StringsKt__StringNumberConversionsJVMKt {
    public StringsKt__StringNumberConversionsKt() {
        super();
    }

    public static final Void numberFormatError(String arg3) {
        Intrinsics.checkNotNullParameter(arg3, "input");
        throw new NumberFormatException("Invalid number format: \'" + arg3 + '\'');
    }

    public static final Byte toByteOrNull(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return StringsKt.toByteOrNull(arg1, 10);
    }

    public static final Byte toByteOrNull(String arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Integer v1 = StringsKt.toIntOrNull(arg1, arg2);
        Byte v2 = null;
        if(v1 != null) {
            int v1_1 = v1.intValue();
            if(v1_1 >= 0xFFFFFF80) {
                if(v1_1 > 0x7F) {
                }
                else {
                    return Byte.valueOf(((byte)v1_1));
                }
            }
        }

        return v2;
    }

    public static final Integer toIntOrNull(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return StringsKt.toIntOrNull(arg1, 10);
    }

    public static final Integer toIntOrNull(String arg10, int arg11) {
        int v4;
        Intrinsics.checkNotNullParameter(arg10, "<this>");
        CharsKt.checkRadix(arg11);
        int v0 = arg10.length();
        Integer v1 = null;
        if(v0 == 0) {
            return v1;
        }

        int v2 = 0;
        int v3 = arg10.charAt(0);
        int v5 = 0x80000001;
        if(Intrinsics.compare(v3, 0x30) < 0) {
            v4 = 1;
            if(v0 == 1) {
                return v1;
            }
            else if(v3 == 43) {
                v3 = 0;
            }
            else if(v3 != 45) {
                return v1;
            }
            else {
                v5 = 0x80000000;
                v3 = 1;
            }
        }
        else {
            v3 = 0;
            v4 = 0;
        }

        int v6 = 0xFC71C71D;
        int v7 = v6;
        while(v4 < v0) {
            int v8 = CharsKt.digitOf(arg10.charAt(v4), arg11);
            if(v8 < 0) {
                return v1;
            }

            if(v2 < v7) {
                if(v7 == v6) {
                    v7 = v5 / arg11;
                    if(v2 < v7) {
                        return v1;
                    }

                    goto label_40;
                }

                return v1;
            }

        label_40:
            v2 *= arg11;
            if(v2 < v5 + v8) {
                return v1;
            }

            v2 -= v8;
            ++v4;
        }

        if(v3 != 0) {
            return Integer.valueOf(v2);
        }

        return Integer.valueOf(-v2);
    }

    public static final Long toLongOrNull(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return StringsKt.toLongOrNull(arg1, 10);
    }

    public static final Long toLongOrNull(String arg20, int arg21) {
        int v6;
        String v0 = arg20;
        int v1 = arg21;
        Intrinsics.checkNotNullParameter(v0, "<this>");
        CharsKt.checkRadix(v1);
        int v2 = v0.length();
        Long v3 = null;
        if(v2 == 0) {
            return v3;
        }

        int v4 = 0;
        int v5 = v0.charAt(0);
        long v7 = -9223372036854775807L;
        if(Intrinsics.compare(v5, 0x30) < 0) {
            v6 = 1;
            if(v2 == 1) {
                return v3;
            }
            else if(v5 == 43) {
                v6 = 0;
                v4 = 1;
            }
            else if(v5 != 45) {
                return v3;
            }
            else {
                v7 = -9223372036854775808L;
                v4 = 1;
            }
        }
        else {
            v6 = 0;
        }

        long v9 = -256204778801521550L;
        long v11 = 0;
        long v13 = v9;
        while(v4 < v2) {
            v5 = CharsKt.digitOf(v0.charAt(v4), v1);
            if(v5 < 0) {
                return v3;
            }

            if(v11 < v13) {
                if(v13 == v9) {
                    v13 = v7 / (((long)v1));
                    if(v11 < v13) {
                        return v3;
                    }

                    goto label_45;
                }

                return v3;
            }

        label_45:
            Long v15 = v3;
            int v16 = v4;
            v11 *= ((long)v1);
            long v3_1 = ((long)v5);
            if(v11 < v7 + v3_1) {
                return v15;
            }

            v11 -= v3_1;
            v4 = v16 + 1;
            v3 = v15;
        }

        if(v6 != 0) {
            return Long.valueOf(v11);
        }

        return Long.valueOf(-v11);
    }

    public static final Short toShortOrNull(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return StringsKt.toShortOrNull(arg1, 10);
    }

    public static final Short toShortOrNull(String arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Integer v1 = StringsKt.toIntOrNull(arg1, arg2);
        Short v2 = null;
        if(v1 != null) {
            int v1_1 = v1.intValue();
            if(v1_1 >= 0xFFFF8000) {
                if(v1_1 > 0x7FFF) {
                }
                else {
                    return Short.valueOf(((short)v1_1));
                }
            }
        }

        return v2;
    }
}

