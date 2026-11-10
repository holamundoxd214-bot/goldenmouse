package kotlin.uuid;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.HexExtensionsKt;

@Metadata(d1={"\u0000D\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0002\b\n\u001A\n\u0010\u0003\u001A\u00020\u0004H\u0081\u0080\u0004\u001A\u0012\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u0007H\u0081\u0080\u0004\u001A\u0016\u0010\b\u001A\u00020\t*\u00020\u00072\u0006\u0010\n\u001A\u00020\u0001H\u0080\u0080\u0004\u001A.\u0010\u000B\u001A\u00020\f*\u00020\t2\u0006\u0010\r\u001A\u00020\u00072\u0006\u0010\u000E\u001A\u00020\u00012\u0006\u0010\u000F\u001A\u00020\u00012\u0006\u0010\u0010\u001A\u00020\u0001H\u0081\u0080\u0004\u001A\u001E\u0010\u0011\u001A\u00020\f*\u00020\u00072\u0006\u0010\n\u001A\u00020\u00012\u0006\u0010\u0012\u001A\u00020\tH\u0080\u0080\u0004\u001A\u0012\u0010\u0013\u001A\u00020\u00042\u0006\u0010\u0014\u001A\u00020\u0015H\u0081\u0080\u0004\u001A\u0014\u0010\u0016\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001A\u00020\u0015H\u0081\u0080\u0004\u001Af\u0010\u0017\u001A\u00020\f*\u00020\u00152\u0006\u0010\n\u001A\u00020\u00012K\u0010\u0018\u001AG\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u001A\u0012\b\b\u001B\u0012\u0004\b\b(\u001C\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u001A\u0012\b\b\u001B\u0012\u0004\b\b(\u001D\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u001A\u0012\b\b\u001B\u0012\u0004\b\b(\u001E\u0012\u0004\u0012\u00020\f0\u0019H\u0080\u0088\u0004ø\u0001\u0000\u001Ab\u0010\u0013\u001A\u00020\u00042\u0006\u0010\u0014\u001A\u00020\u00152K\u0010\u0018\u001AG\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u001A\u0012\b\b\u001B\u0012\u0004\b\b(\u001C\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u001A\u0012\b\b\u001B\u0012\u0004\b\b(\u001D\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u001A\u0012\b\b\u001B\u0012\u0004\b\b(\u001E\u0012\u0004\u0012\u00020\u001F0\u0019H\u0081\u0088\u0004ø\u0001\u0000\u001A\u0012\u0010 \u001A\u00020\u00042\u0006\u0010!\u001A\u00020\u0015H\u0081\u0080\u0004\u001A\u0014\u0010\"\u001A\u0004\u0018\u00010\u00042\u0006\u0010!\u001A\u00020\u0015H\u0081\u0080\u0004\u001Ab\u0010 \u001A\u00020\u00042\u0006\u0010!\u001A\u00020\u00152K\u0010\u0018\u001AG\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u001A\u0012\b\b\u001B\u0012\u0004\b\b(\u001C\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u001A\u0012\b\b\u001B\u0012\u0004\b\b(\u001D\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u001A\u0012\b\b\u001B\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u001F0\u0019H\u0081\u0088\u0004ø\u0001\u0000\u001A\u001B\u0010$\u001A\u00020\u0015*\u00020\u00152\u0006\u0010%\u001A\u00020\u0001H\u0082\u0080\u0004¢\u0006\u0002\b&\u001A\u001B\u0010$\u001A\u00020\u0015*\u00020\u00072\u0006\u0010\'\u001A\u00020\u0001H\u0082\u0080\u0004¢\u0006\u0002\b&\u001A\"\u0010(\u001A\u00020\u001F2\u0006\u0010\u001C\u001A\u00020\u00152\u0006\u0010\u001D\u001A\u00020\u00152\u0006\u0010#\u001A\u00020\u0001H\u0080\u0080\u0004\"\u000F\u0010\u0000\u001A\u00020\u0001X\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000F\u0010\u0002\u001A\u00020\u0001X\u0082Ô\b¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006)"}, d2={"UUID_HEX_LENGTH", "", "UUID_HEX_DASH_LENGTH", "secureRandomUuid", "Lkotlin/uuid/Uuid;", "uuidFromRandomBytes", "randomBytes", "", "getLongAtCommonImpl", "", "index", "formatBytesIntoCommonImpl", "", "dst", "dstOffset", "startIndex", "endIndex", "setLongAtCommonImpl", "value", "uuidParseHexDashCommonImpl", "hexDashString", "", "uuidParseHexDashOrNullCommonImpl", "uuidCheckHyphenAt", "onError", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "inputString", "errorDescription", "errorPosition", "", "uuidParseHexCommonImpl", "hexString", "uuidParseHexOrNullCommonImpl", "errorIndex", "truncateForErrorMessage", "maxLength", "truncateForErrorMessage$UuidKt__UuidKt", "maxSize", "uuidThrowUnexpectedCharacterException", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/uuid/UuidKt") class UuidKt__UuidKt extends UuidKt__UuidJVMKt {
    private static final int UUID_HEX_DASH_LENGTH = 36;
    private static final int UUID_HEX_LENGTH = 0x20;

    public UuidKt__UuidKt() {
        super();
    }

    public static final String access$truncateForErrorMessage(byte[] arg0, int arg1) {
        return UuidKt__UuidKt.truncateForErrorMessage$UuidKt__UuidKt(arg0, arg1);
    }

    public static final String access$truncateForErrorMessage(String arg0, int arg1) {
        return UuidKt__UuidKt.truncateForErrorMessage$UuidKt__UuidKt(arg0, arg1);
    }

    public static final void formatBytesIntoCommonImpl(long arg4, byte[] arg6, int arg7, int arg8, int arg9) {
        Intrinsics.checkNotNullParameter(arg6, "dst");
        arg8 = 7 - arg8;
        arg9 = 8 - arg9;
        if(arg9 <= arg8) {
            while(true) {
                int v0 = HexExtensionsKt.getBYTE_TO_LOWER_CASE_HEX_DIGITS()[((int)(arg4 >> (arg8 << 3) & 0xFF))];
                int v1 = arg7 + 1;
                arg6[arg7] = ((byte)(v0 >> 8));
                arg7 += 2;
                arg6[v1] = ((byte)v0);
                if(arg8 != arg9) {
                    --arg8;
                    continue;
                }

                return;
            }
        }
    }

    public static final long getLongAtCommonImpl(byte[] arg7, int arg8) {
        Intrinsics.checkNotNullParameter(arg7, "<this>");
        return (((long)arg7[arg8 + 7])) & 0xFF | (((((long)arg7[arg8])) & 0xFF) << 56 | ((((long)arg7[arg8 + 1])) & 0xFF) << 0x30 | ((((long)arg7[arg8 + 2])) & 0xFF) << 40 | ((((long)arg7[arg8 + 3])) & 0xFF) << 0x20 | ((((long)arg7[arg8 + 4])) & 0xFF) << 24 | ((((long)arg7[arg8 + 5])) & 0xFF) << 16 | ((((long)arg7[arg8 + 6])) & 0xFF) << 8);
    }

    public static final Uuid secureRandomUuid() {
        byte[] v0 = new byte[16];
        UuidKt.secureRandomBytes(v0);
        return UuidKt.uuidFromRandomBytes(v0);
    }

    public static final void setLongAtCommonImpl(byte[] arg5, int arg6, long arg7) {
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        int v0 = 7;
        while(-1 < v0) {
            arg5[arg6] = ((byte)(((int)(arg7 >> (v0 << 3)))));
            --v0;
            ++arg6;
        }
    }

    private static final String truncateForErrorMessage$UuidKt__UuidKt(String arg2, int arg3) {
        if(arg2.length() <= arg3) {
            return arg2;
        }

        StringBuilder v0 = new StringBuilder();
        Intrinsics.checkNotNull(arg2, "null cannot be cast to non-null type java.lang.String");
        arg2 = arg2.substring(0, arg3);
        Intrinsics.checkNotNullExpressionValue(arg2, "substring(...)");
        return v0.append(arg2).append("...").toString();
    }

    private static final String truncateForErrorMessage$UuidKt__UuidKt(byte[] arg10, int arg11) {
        return ArraysKt.joinToString$default(arg10, null, "[", "]", arg11, null, null, 49, null);
    }

    public static final void uuidCheckHyphenAt(String arg2, int arg3, Function3 arg4) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "onError");
        if(arg2.charAt(arg3) != 45) {
            arg4.invoke(arg2, "\'-\' (hyphen)", Integer.valueOf(arg3));
        }
    }

    public static final Uuid uuidFromRandomBytes(byte[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "randomBytes");
        byte v1 = ((byte)(arg2[6] & 15));
        arg2[6] = v1;
        arg2[6] = ((byte)(v1 | 0x40));
        v1 = ((byte)(arg2[8] & 0x3F));
        arg2[8] = v1;
        arg2[8] = ((byte)(v1 | 0x80));
        return Uuid.Companion.fromByteArray(arg2);
    }

    public static final Uuid uuidParseHexCommonImpl(String arg13) {
        int v7;
        int v6;
        String v5;
        Intrinsics.checkNotNullParameter(arg13, "hexString");
        int v0 = 0;
        long v1 = 0;
        long v3 = v1;
        while(true) {
            v5 = "a hexadecimal digit";
            v6 = 4;
            v7 = 16;
            if(v0 >= v7) {
                goto label_25;
            }

            v3 <<= v6;
            v6 = arg13.charAt(v0);
            if(v6 >>> 8 == 0 && HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[v6] >= v1) {
                v3 |= HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[v6];
                ++v0;
                continue;
            }

            break;
        }

        UuidKt.uuidThrowUnexpectedCharacterException(arg13, v5, v0);
        throw new KotlinNothingValueException();
    label_25:
        long v8 = v1;
        while(true) {
            if(v7 >= 0x20) {
                goto label_44;
            }

            v8 <<= v6;
            v0 = arg13.charAt(v7);
            if(v0 >>> 8 == 0 && HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[v0] >= v1) {
                v8 |= HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[v0];
                ++v7;
                continue;
            }

            break;
        }

        UuidKt.uuidThrowUnexpectedCharacterException(arg13, v5, v7);
        throw new KotlinNothingValueException();
    label_44:
        return Uuid.Companion.fromLongs(v3, v8);
    }

    public static final Uuid uuidParseHexCommonImpl(String arg13, Function3 arg14) {
        int v7;
        int v6;
        String v5;
        Intrinsics.checkNotNullParameter(arg13, "hexString");
        Intrinsics.checkNotNullParameter(arg14, "onError");
        int v0 = 0;
        long v1 = 0;
        long v3 = v1;
        while(true) {
            v5 = "a hexadecimal digit";
            v6 = 4;
            v7 = 16;
            if(v0 >= v7) {
                goto label_28;
            }

            v3 <<= v6;
            v6 = arg13.charAt(v0);
            if(v6 >>> 8 == 0 && HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[v6] >= v1) {
                v3 |= HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[v6];
                ++v0;
                continue;
            }

            break;
        }

        arg14.invoke(arg13, v5, Integer.valueOf(v0));
        throw new KotlinNothingValueException();
    label_28:
        long v8 = v1;
        while(true) {
            if(v7 >= 0x20) {
                goto label_48;
            }

            v8 <<= v6;
            v0 = arg13.charAt(v7);
            if(v0 >>> 8 == 0 && HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[v0] >= v1) {
                v8 |= HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[v0];
                ++v7;
                continue;
            }

            break;
        }

        arg14.invoke(arg13, v5, Integer.valueOf(v7));
        throw new KotlinNothingValueException();
    label_48:
        return Uuid.Companion.fromLongs(v3, v8);
    }

    public static final Uuid uuidParseHexDashCommonImpl(String arg20) {
        long v8_1;
        long v15;
        long v13;
        long v11;
        int v8;
        String v7;
        int v6;
        String v0 = arg20;
        Intrinsics.checkNotNullParameter(v0, "hexDashString");
        int v1 = 0;
        long v2 = 0;
        long v4 = v2;
        while(true) {
            v6 = 4;
            v7 = "a hexadecimal digit";
            v8 = 8;
            if(v1 >= v8) {
                goto label_26;
            }

            v4 <<= v6;
            v6 = v0.charAt(v1);
            if(v6 >>> 8 == 0 && HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[v6] >= v2) {
                v4 |= HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[v6];
                ++v1;
                continue;
            }

            break;
        }

        UuidKt.uuidThrowUnexpectedCharacterException(v0, v7, v1);
        throw new KotlinNothingValueException();
    label_26:
        String v9 = "\'-\' (hyphen)";
        int v10 = 45;
        if(v0.charAt(v8) == v10) {
            v1 = 9;
            v11 = v2;
            goto label_32;
        }

        UuidKt.uuidThrowUnexpectedCharacterException(v0, v9, v8);
        throw new KotlinNothingValueException();
        while(true) {
        label_32:
            v8 = 13;
            if(v1 >= v8) {
                goto label_50;
            }

            v11 <<= v6;
            v8 = v0.charAt(v1);
            if(v8 >>> 8 == 0 && HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[v8] >= v2) {
                v11 |= HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[v8];
                ++v1;
                continue;
            }

            break;
        }

        UuidKt.uuidThrowUnexpectedCharacterException(v0, v7, v1);
        throw new KotlinNothingValueException();
    label_50:
        if(v0.charAt(v8) == v10) {
            v1 = 14;
            v13 = v2;
            goto label_54;
        }

        UuidKt.uuidThrowUnexpectedCharacterException(v0, v9, v8);
        throw new KotlinNothingValueException();
        while(true) {
        label_54:
            v8 = 18;
            if(v1 >= v8) {
                goto label_72;
            }

            v13 <<= v6;
            v8 = v0.charAt(v1);
            if(v8 >>> 8 == 0 && HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[v8] >= v2) {
                v13 |= HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[v8];
                ++v1;
                continue;
            }

            break;
        }

        UuidKt.uuidThrowUnexpectedCharacterException(v0, v7, v1);
        throw new KotlinNothingValueException();
    label_72:
        if(v0.charAt(v8) == v10) {
            v1 = 19;
            v15 = v2;
            goto label_76;
        }

        UuidKt.uuidThrowUnexpectedCharacterException(v0, v9, v8);
        throw new KotlinNothingValueException();
        while(true) {
        label_76:
            v8 = 23;
            if(v1 >= v8) {
                goto label_94;
            }

            v15 <<= v6;
            v8 = v0.charAt(v1);
            if(v8 >>> 8 == 0 && HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[v8] >= v2) {
                v15 |= HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[v8];
                ++v1;
                continue;
            }

            break;
        }

        UuidKt.uuidThrowUnexpectedCharacterException(v0, v7, v1);
        throw new KotlinNothingValueException();
    label_94:
        if(v0.charAt(v8) == v10) {
            v1 = 24;
            v8_1 = v2;
            goto label_98;
        }

        UuidKt.uuidThrowUnexpectedCharacterException(v0, v9, v8);
        throw new KotlinNothingValueException();
        while(true) {
        label_98:
            if(v1 >= 36) {
                goto label_116;
            }

            v8_1 <<= v6;
            v10 = v0.charAt(v1);
            if(v10 >>> 8 == 0 && HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[v10] >= v2) {
                v8_1 |= HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[v10];
                ++v1;
                continue;
            }

            break;
        }

        UuidKt.uuidThrowUnexpectedCharacterException(v0, v7, v1);
        throw new KotlinNothingValueException();
    label_116:
        return Uuid.Companion.fromLongs(v4 << 0x20 | v11 << 16 | v13, v15 << 0x30 | v8_1);
    }

    public static final Uuid uuidParseHexDashCommonImpl(String arg21, Function3 arg22) {
        int v9;
        String v8;
        int v7;
        String v0 = arg21;
        Function3 v1 = arg22;
        Intrinsics.checkNotNullParameter(v0, "hexDashString");
        Intrinsics.checkNotNullParameter(v1, "onError");
        int v2 = 0;
        long v3 = 0;
        long v5 = v3;
        while(true) {
            v7 = 4;
            v8 = "a hexadecimal digit";
            v9 = 8;
            if(v2 >= v9) {
                goto label_30;
            }

            v5 <<= v7;
            v7 = v0.charAt(v2);
            if(v7 >>> 8 == 0 && HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[v7] >= v3) {
                v5 |= HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[v7];
                ++v2;
                continue;
            }

            break;
        }

        v1.invoke(v0, v8, Integer.valueOf(v2));
        throw new KotlinNothingValueException();
    label_30:
        String v10 = "\'-\' (hyphen)";
        int v11 = 45;
        if(v0.charAt(v9) != v11) {
            v1.invoke(v0, v10, Integer.valueOf(v9));
        }

        v2 = 9;
        long v12 = v3;
        while(true) {
            v9 = 13;
            if(v2 >= v9) {
                goto label_57;
            }

            v12 <<= v7;
            v9 = v0.charAt(v2);
            if(v9 >>> 8 == 0 && HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[v9] >= v3) {
                v12 |= HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[v9];
                ++v2;
                continue;
            }

            break;
        }

        v1.invoke(v0, v8, Integer.valueOf(v2));
        throw new KotlinNothingValueException();
    label_57:
        if(v0.charAt(v9) != v11) {
            v1.invoke(v0, v10, Integer.valueOf(v9));
        }

        v2 = 14;
        long v14 = v3;
        while(true) {
            v9 = 18;
            if(v2 >= v9) {
                goto label_82;
            }

            v14 <<= v7;
            v9 = v0.charAt(v2);
            if(v9 >>> 8 == 0 && HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[v9] >= v3) {
                v14 |= HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[v9];
                ++v2;
                continue;
            }

            break;
        }

        v1.invoke(v0, v8, Integer.valueOf(v2));
        throw new KotlinNothingValueException();
    label_82:
        if(v0.charAt(v9) != v11) {
            v1.invoke(v0, v10, Integer.valueOf(v9));
        }

        v2 = 19;
        long v16 = v3;
        while(true) {
            v9 = 23;
            if(v2 >= v9) {
                goto label_107;
            }

            v16 <<= v7;
            v9 = v0.charAt(v2);
            if(v9 >>> 8 == 0 && HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[v9] >= v3) {
                v16 |= HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[v9];
                ++v2;
                continue;
            }

            break;
        }

        v1.invoke(v0, v8, Integer.valueOf(v2));
        throw new KotlinNothingValueException();
    label_107:
        if(v0.charAt(v9) != v11) {
            v1.invoke(v0, v10, Integer.valueOf(v9));
        }

        v2 = 24;
        long v9_1 = v3;
        while(true) {
            if(v2 >= 36) {
                goto label_132;
            }

            v9_1 <<= v7;
            v11 = v0.charAt(v2);
            if(v11 >>> 8 == 0 && HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[v11] >= v3) {
                v9_1 |= HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[v11];
                ++v2;
                continue;
            }

            break;
        }

        v1.invoke(v0, v8, Integer.valueOf(v2));
        throw new KotlinNothingValueException();
    label_132:
        return Uuid.Companion.fromLongs(v5 << 0x20 | v12 << 16 | v14, v16 << 0x30 | v9_1);
    }

    public static final Uuid uuidParseHexDashOrNullCommonImpl(String arg20) {
        int v8;
        Uuid v7;
        int v6;
        String v0 = arg20;
        Intrinsics.checkNotNullParameter(v0, "hexDashString");
        int v1 = 0;
        long v2 = 0;
        long v4 = v2;
        while(true) {
            v6 = 4;
            v7 = null;
            v8 = 8;
            if(v1 >= v8) {
                goto label_23;
            }

            v4 <<= v6;
            v6 = v0.charAt(v1);
            if(v6 >>> 8 == 0 && HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[v6] >= v2) {
                v4 |= HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[v6];
                ++v1;
                continue;
            }

            return v7;
        }

        return v7;
    label_23:
        v1 = v0.charAt(v8);
        v8 = 45;
        if(v1 != v8) {
            return v7;
        }

        v1 = 9;
        long v9 = v2;
        while(true) {
            int v11 = 13;
            if(v1 >= v11) {
                goto label_44;
            }

            v9 <<= v6;
            v11 = v0.charAt(v1);
            if(v11 >>> 8 == 0 && HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[v11] >= v2) {
                v9 |= HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[v11];
                ++v1;
                continue;
            }

            return v7;
        }

        return v7;
    label_44:
        if(v0.charAt(v11) != v8) {
            return v7;
        }

        v1 = 14;
        long v11_1 = v2;
        while(true) {
            int v13 = 18;
            if(v1 >= v13) {
                goto label_64;
            }

            v11_1 <<= v6;
            v13 = v0.charAt(v1);
            if(v13 >>> 8 == 0 && HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[v13] >= v2) {
                v11_1 |= HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[v13];
                ++v1;
                continue;
            }

            return v7;
        }

        return v7;
    label_64:
        if(v0.charAt(v13) != v8) {
            return v7;
        }

        v1 = 19;
        long v13_1 = v2;
        while(true) {
            int v15 = 23;
            if(v1 >= v15) {
                goto label_84;
            }

            v13_1 <<= v6;
            v15 = v0.charAt(v1);
            if(v15 >>> 8 == 0 && HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[v15] >= v2) {
                v13_1 |= HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[v15];
                ++v1;
                continue;
            }

            return v7;
        }

        return v7;
    label_84:
        if(v0.charAt(v15) != v8) {
            return v7;
        }

        v1 = 24;
        long v15_1 = v2;
        while(true) {
            if(v1 >= 36) {
                goto label_104;
            }

            v15_1 <<= v6;
            v8 = v0.charAt(v1);
            if(v8 >>> 8 == 0 && HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[v8] >= v2) {
                v15_1 |= HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[v8];
                ++v1;
                continue;
            }

            return v7;
        }

        return v7;
    label_104:
        return Uuid.Companion.fromLongs(v4 << 0x20 | v9 << 16 | v11_1, v13_1 << 0x30 | v15_1);
    }

    public static final Uuid uuidParseHexOrNullCommonImpl(String arg13) {
        int v7;
        int v6;
        Uuid v5;
        Intrinsics.checkNotNullParameter(arg13, "hexString");
        int v0 = 0;
        long v1 = 0;
        long v3 = v1;
        while(true) {
            v5 = null;
            v6 = 4;
            v7 = 16;
            if(v0 >= v7) {
                goto label_22;
            }

            v3 <<= v6;
            v6 = arg13.charAt(v0);
            if(v6 >>> 8 == 0 && HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[v6] >= v1) {
                v3 |= HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[v6];
                ++v0;
                continue;
            }

            return v5;
        }

        return v5;
    label_22:
        long v8 = v1;
        while(true) {
            if(v7 >= 0x20) {
                goto label_38;
            }

            v8 <<= v6;
            v0 = arg13.charAt(v7);
            if(v0 >>> 8 == 0 && HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[v0] >= v1) {
                v8 |= HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[v0];
                ++v7;
                continue;
            }

            return v5;
        }

        return v5;
    label_38:
        return Uuid.Companion.fromLongs(v3, v8);
    }

    public static final Void uuidThrowUnexpectedCharacterException(String arg3, String arg4, int arg5) {
        Intrinsics.checkNotNullParameter(arg3, "inputString");
        Intrinsics.checkNotNullParameter(arg4, "errorDescription");
        throw new IllegalArgumentException("Expected " + arg4 + " at index " + arg5 + ", but was \'" + arg3.charAt(arg5) + '\'');
    }
}

