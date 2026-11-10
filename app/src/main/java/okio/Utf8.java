package okio;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000>\n\u0000\n\u0002\u0010\t\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\n\u001A%\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001A\u00020\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0002\b\u0006\u001A\u0011\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u0004H\u0080\b\u001A\u0011\u0010\u000F\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\bH\u0080\b\u001A4\u0010\u0011\u001A\u00020\u0012*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00042\u0012\u0010\u0013\u001A\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00120\u0014H\u0080\bø\u0001\u0000\u001A4\u0010\u0015\u001A\u00020\u0012*\u00020\u00162\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00042\u0012\u0010\u0013\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00120\u0014H\u0080\bø\u0001\u0000\u001A4\u0010\u0019\u001A\u00020\u0012*\u00020\u00162\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00042\u0012\u0010\u0013\u001A\u000E\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00120\u0014H\u0080\bø\u0001\u0000\u001A4\u0010\u001B\u001A\u00020\u0004*\u00020\u00162\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00042\u0012\u0010\u0013\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00120\u0014H\u0080\bø\u0001\u0000\u001A4\u0010\u001D\u001A\u00020\u0004*\u00020\u00162\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00042\u0012\u0010\u0013\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00120\u0014H\u0080\bø\u0001\u0000\u001A4\u0010\u001F\u001A\u00020\u0004*\u00020\u00162\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00042\u0012\u0010\u0013\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00120\u0014H\u0080\bø\u0001\u0000\"\u000E\u0010\u0007\u001A\u00020\bX\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\t\u001A\u00020\nX\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\u000B\u001A\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0017\u001A\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0018\u001A\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\u001A\u001A\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\u001C\u001A\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\u001E\u001A\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006 "}, d2={"utf8Size", "", "", "beginIndex", "", "endIndex", "size", "REPLACEMENT_BYTE", "", "REPLACEMENT_CHARACTER", "", "REPLACEMENT_CODE_POINT", "isIsoControl", "", "codePoint", "isUtf8Continuation", "byte", "processUtf8Bytes", "", "yield", "Lkotlin/Function1;", "processUtf8CodePoints", "", "HIGH_SURROGATE_HEADER", "LOG_SURROGATE_HEADER", "processUtf16Chars", "MASK_2BYTES", "process2Utf8Bytes", "MASK_3BYTES", "process3Utf8Bytes", "MASK_4BYTES", "process4Utf8Bytes", "okio"}, k=2, mv={2, 1, 0}, xi=0x30) public final class Utf8 {
    public static final int HIGH_SURROGATE_HEADER = 0xD7C0;
    public static final int LOG_SURROGATE_HEADER = 0xDC00;
    public static final int MASK_2BYTES = 0xF80;
    public static final int MASK_3BYTES = 0xFFFE1F80;
    public static final int MASK_4BYTES = 0x381F80;
    public static final byte REPLACEMENT_BYTE = 0x3F;
    public static final char REPLACEMENT_CHARACTER = '\uFFFD';
    public static final int REPLACEMENT_CODE_POINT = 0xFFFD;

    public static final boolean isIsoControl(int arg1) {
        if(arg1 < 0 || arg1 >= 0x20) {
            if(0x7F <= arg1 && arg1 < 0xA0) {
                return 1;
            }

            return 0;
        }
        else {
        }

        return 1;
    }

    public static final boolean isUtf8Continuation(byte arg1) {
        if((arg1 & 0xC0) == 0x80) {
            return 1;
        }

        return 0;
    }

    public static final int process2Utf8Bytes(byte[] arg3, int arg4, int arg5, Function1 arg6) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg6, "yield");
        int v0 = arg4 + 1;
        Integer v1 = Integer.valueOf(0xFFFD);
        if(arg5 <= v0) {
            arg6.invoke(v1);
            return 1;
        }

        arg4 = arg3[arg4];
        int v3 = arg3[v0];
        v0 = 0x80;
        if((v3 & 0xC0) == v0) {
            v3 = v3 ^ 0xF80 ^ arg4 << 6;
            if(v3 < v0) {
                arg6.invoke(v1);
            }
            else {
                arg6.invoke(Integer.valueOf(v3));
            }

            return 2;
        }

        arg6.invoke(v1);
        return 1;
    }

    public static final int process3Utf8Bytes(byte[] arg6, int arg7, int arg8, Function1 arg9) {
        Intrinsics.checkNotNullParameter(arg6, "<this>");
        Intrinsics.checkNotNullParameter(arg9, "yield");
        int v0 = arg7 + 2;
        int v1 = 0x80;
        Integer v3 = Integer.valueOf(0xFFFD);
        int v4 = 2;
        if(arg8 <= v0) {
            arg9.invoke(v3);
            ++arg7;
            if(arg8 > arg7 && (arg6[arg7] & 0xC0) == v1) {
                return v4;
            }

            return 1;
        }

        arg8 = arg6[arg7];
        arg7 = arg6[arg7 + 1];
        if((arg7 & 0xC0) == v1) {
            int v6 = arg6[v0];
            if((v6 & 0xC0) == v1) {
                v6 = v6 ^ 0xFFFE1F80 ^ arg7 << 6 ^ arg8 << 12;
                if(v6 < 0x800) {
                    arg9.invoke(v3);
                }
                else {
                    if(0xD800 <= v6 && v6 < 0xE000) {
                        arg9.invoke(v3);
                        return 3;
                    }

                    arg9.invoke(Integer.valueOf(v6));
                }

                return 3;
            }

            arg9.invoke(v3);
            return v4;
        }

        arg9.invoke(v3);
        return 1;
    }

    public static final int process4Utf8Bytes(byte[] arg8, int arg9, int arg10, Function1 arg11) {
        Intrinsics.checkNotNullParameter(arg8, "<this>");
        Intrinsics.checkNotNullParameter(arg11, "yield");
        int v0 = arg9 + 3;
        int v1 = 2;
        int v3 = 0x80;
        Integer v4 = Integer.valueOf(0xFFFD);
        int v5 = 3;
        if(arg10 <= v0) {
            arg11.invoke(v4);
            int v11 = arg9 + 1;
            if(arg10 > v11 && (arg8[v11] & 0xC0) == v3) {
                arg9 += v1;
                if(arg10 > arg9 && (arg8[arg9] & 0xC0) == v3) {
                    return v5;
                }

                return v1;
            }

            return 1;
        }

        arg10 = arg8[arg9];
        int v6 = arg8[arg9 + 1];
        if((v6 & 0xC0) == v3) {
            arg9 = arg8[arg9 + v1];
            if((arg9 & 0xC0) == v3) {
                int v8 = arg8[v0];
                if((v8 & 0xC0) == v3) {
                    v8 = v8 ^ 0x381F80 ^ arg9 << 6 ^ v6 << 12 ^ arg10 << 18;
                    if(v8 > 0x10FFFF) {
                        arg11.invoke(v4);
                    }
                    else {
                        if(0xD800 <= v8 && v8 < 0xE000) {
                            arg11.invoke(v4);
                            return 4;
                        }

                        if(v8 < 0x10000) {
                            arg11.invoke(v4);
                            return 4;
                        }

                        arg11.invoke(Integer.valueOf(v8));
                    }

                    return 4;
                }

                arg11.invoke(v4);
                return v5;
            }

            arg11.invoke(v4);
            return v1;
        }

        arg11.invoke(v4);
        return 1;
    }

    public static final void processUtf16Chars(byte[] arg11, int arg12, int arg13, Function1 arg14) {
        Character v0_1;
        int v1;
        int v0;
        Intrinsics.checkNotNullParameter(arg11, "<this>");
        Intrinsics.checkNotNullParameter(arg14, "yield");
    label_4:
        while(arg12 < arg13) {
            v0 = arg11[arg12];
            if(v0 >= 0) {
                arg14.invoke(Character.valueOf(((char)v0)));
                ++arg12;
                goto label_11;
            }

            int v2 = -2;
            int v3 = 2;
            int v4 = 0x80;
            char v6 = '\uFFFD';
            if(v0 >> 5 == v2) {
                v1 = arg12 + 1;
                if(arg13 > v1) {
                    v1 = arg11[v1];
                    if((v1 & 0xC0) == v4) {
                        v0 = v0 << 6 ^ (v1 ^ 0xF80);
                        v0_1 = v0 < v4 ? Character.valueOf(v6) : Character.valueOf(((char)v0));
                        arg14.invoke(v0_1);
                        goto label_46;
                    }
                }

                arg14.invoke(Character.valueOf(v6));
                goto label_31;
            }
            else {
                int v7 = 0xE000;
                int v8 = 0xD800;
                int v9 = 3;
                if(v0 >> 4 == v2) {
                    v1 = arg12 + 2;
                    if(arg13 <= v1) {
                        arg14.invoke(Character.valueOf(v6));
                        v0 = arg12 + 1;
                        if(arg13 <= v0) {
                            goto label_31;
                        }
                        else if((arg11[v0] & 0xC0) == v4) {
                            goto label_46;
                        }
                        else {
                            goto label_31;
                        }
                    }
                    else {
                        v2 = arg11[arg12 + 1];
                        if((v2 & 0xC0) == v4) {
                            v1 = arg11[v1];
                            if((v1 & 0xC0) == v4) {
                                v0 = v0 << 12 ^ (v1 ^ 0xFFFE1F80 ^ v2 << 6);
                                if(v0 >= 0x800) {
                                    if(v8 <= v0 && v0 < v7) {
                                        goto label_79;
                                    }

                                    goto label_86;
                                }
                                else {
                                label_79:
                                    v0_1 = Character.valueOf(v6);
                                    goto label_80;
                                label_86:
                                    v0_1 = Character.valueOf(((char)v0));
                                }

                            label_80:
                                arg14.invoke(v0_1);
                            }
                            else {
                                arg14.invoke(Character.valueOf(v6));
                                goto label_46;
                            }
                        }
                        else {
                            arg14.invoke(Character.valueOf(v6));
                            goto label_31;
                        }
                    }
                }
                else {
                    if(v0 >> 3 != v2) {
                        goto label_176;
                    }

                    v1 = arg12 + 3;
                    if(arg13 <= v1) {
                        arg14.invoke(Character.valueOf(v6));
                        v0 = arg12 + 1;
                        if(arg13 <= v0) {
                            goto label_31;
                        }

                        if((arg11[v0] & 0xC0) != v4) {
                            goto label_31;
                        }

                        v0 = arg12 + 2;
                        if(arg13 <= v0) {
                            goto label_46;
                        }

                        if((arg11[v0] & 0xC0) != v4) {
                            goto label_46;
                        }

                        goto label_89;
                    }

                    v2 = arg11[arg12 + 1];
                    if((v2 & 0xC0) != v4) {
                        goto label_172;
                    }

                    int v5 = arg11[arg12 + 2];
                    if((v5 & 0xC0) != v4) {
                        goto label_168;
                    }

                    v1 = arg11[v1];
                    if((v1 & 0xC0) == v4) {
                        v0 = v0 << 18 ^ (v1 ^ 0x381F80 ^ v5 << 6 ^ v2 << 12);
                        if(v0 <= 0x10FFFF) {
                            if(v8 <= v0 && v0 < v7) {
                                goto label_138;
                            }

                            if(v0 < 0x10000) {
                                goto label_138;
                            }

                            if(v0 == v6) {
                                goto label_138;
                            }

                            arg14.invoke(Character.valueOf(((char)((v0 >>> 10) + 0xD7C0))));
                            arg14.invoke(Character.valueOf(((char)((v0 & 0x3FF) + 0xDC00))));
                        }
                        else {
                        label_138:
                            arg14.invoke(Character.valueOf(v6));
                        }

                        v3 = 4;
                        goto label_46;
                    }

                    arg14.invoke(Character.valueOf(v6));
                }

            label_89:
                v3 = v9;
                goto label_46;
            label_168:
                arg14.invoke(Character.valueOf(v6));
                goto label_46;
            label_172:
                arg14.invoke(Character.valueOf(v6));
            label_31:
                v3 = 1;
            }

        label_46:
            arg12 += v3;
            continue;
        label_176:
            arg14.invoke(Character.valueOf(v6));
            ++arg12;
        }

        return;
        while(true) {
        label_11:
            if(arg12 >= arg13) {
                goto label_4;
            }

            v0 = arg11[arg12];
            if(v0 < 0) {
                goto label_4;
            }

            ++arg12;
            arg14.invoke(Character.valueOf(((char)v0)));
        }
    }

    public static final void processUtf8Bytes(String arg7, int arg8, int arg9, Function1 arg10) {
        Intrinsics.checkNotNullParameter(arg7, "<this>");
        Intrinsics.checkNotNullParameter(arg10, "yield");
    label_4:
        while(arg8 < arg9) {
            int v0 = arg7.charAt(arg8);
            int v1 = 0x80;
            if(Intrinsics.compare(v0, v1) < 0) {
                arg10.invoke(Byte.valueOf(((byte)v0)));
                ++arg8;
                goto label_13;
            }

            if(Intrinsics.compare(v0, 0x800) < 0) {
                arg10.invoke(Byte.valueOf(((byte)(v0 >> 6 | 0xC0))));
                arg10.invoke(Byte.valueOf(((byte)(v0 & 0x3F | v1))));
            }
            else {
                byte v3 = 0x3F;
                if(0xD800 <= v0) {
                    int v2 = 0xE000;
                    if(v0 < v2) {
                        if(Intrinsics.compare(v0, 0xDBFF) <= 0) {
                            int v4 = arg8 + 1;
                            if(arg9 > v4) {
                                int v5 = arg7.charAt(v4);
                                if(0xDC00 <= v5 && v5 < v2) {
                                    v0 = (v0 << 10) + arg7.charAt(v4) - 0x35FDC00;
                                    arg10.invoke(Byte.valueOf(((byte)(v0 >> 18 | 0xF0))));
                                    arg10.invoke(Byte.valueOf(((byte)(v0 >> 12 & v3 | v1))));
                                    arg10.invoke(Byte.valueOf(((byte)(v0 >> 6 & v3 | v1))));
                                    arg10.invoke(Byte.valueOf(((byte)(v0 & v3 | v1))));
                                    arg8 += 2;
                                    continue;
                                }
                            }
                        }

                        arg10.invoke(Byte.valueOf(v3));
                        goto label_37;
                    }
                }

                arg10.invoke(Byte.valueOf(((byte)(v0 >> 12 | 0xE0))));
                arg10.invoke(Byte.valueOf(((byte)(v0 >> 6 & v3 | v1))));
                arg10.invoke(Byte.valueOf(((byte)(v0 & 0x3F | v1))));
            }

        label_37:
            ++arg8;
        }

        return;
        while(true) {
        label_13:
            if(arg8 >= arg9) {
                goto label_4;
            }

            if(Intrinsics.compare(arg7.charAt(arg8), v1) >= 0) {
                goto label_4;
            }

            arg10.invoke(Byte.valueOf(((byte)arg7.charAt(arg8))));
            ++arg8;
        }
    }

    public static final void processUtf8CodePoints(byte[] arg11, int arg12, int arg13, Function1 arg14) {
        Integer v0_1;
        int v1;
        int v0;
        Intrinsics.checkNotNullParameter(arg11, "<this>");
        Intrinsics.checkNotNullParameter(arg14, "yield");
    label_4:
        while(arg12 < arg13) {
            v0 = arg11[arg12];
            if(v0 >= 0) {
                arg14.invoke(Integer.valueOf(v0));
                ++arg12;
                goto label_10;
            }

            int v2 = -2;
            int v3 = 2;
            int v4 = 0x80;
            int v6 = 0xFFFD;
            if(v0 >> 5 == v2) {
                v1 = arg12 + 1;
                if(arg13 > v1) {
                    v1 = arg11[v1];
                    if((v1 & 0xC0) == v4) {
                        v0 = v0 << 6 ^ (v1 ^ 0xF80);
                        v0_1 = v0 < v4 ? Integer.valueOf(v6) : Integer.valueOf(v0);
                        arg14.invoke(v0_1);
                        goto label_43;
                    }
                }

                arg14.invoke(Integer.valueOf(v6));
                goto label_29;
            }
            else {
                int v7 = 0xE000;
                int v8 = 0xD800;
                int v9 = 3;
                if(v0 >> 4 == v2) {
                    v1 = arg12 + 2;
                    if(arg13 <= v1) {
                        arg14.invoke(Integer.valueOf(v6));
                        v0 = arg12 + 1;
                        if(arg13 <= v0) {
                            goto label_29;
                        }
                        else if((arg11[v0] & 0xC0) == v4) {
                            goto label_43;
                        }
                        else {
                            goto label_29;
                        }
                    }
                    else {
                        v2 = arg11[arg12 + 1];
                        if((v2 & 0xC0) == v4) {
                            v1 = arg11[v1];
                            if((v1 & 0xC0) == v4) {
                                v0 = v0 << 12 ^ (v1 ^ 0xFFFE1F80 ^ v2 << 6);
                                if(v0 >= 0x800) {
                                    if(v8 <= v0 && v0 < v7) {
                                        goto label_76;
                                    }

                                    goto label_83;
                                }
                                else {
                                label_76:
                                    v0_1 = Integer.valueOf(v6);
                                    goto label_77;
                                label_83:
                                    v0_1 = Integer.valueOf(v0);
                                }

                            label_77:
                                arg14.invoke(v0_1);
                            }
                            else {
                                arg14.invoke(Integer.valueOf(v6));
                                goto label_43;
                            }
                        }
                        else {
                            arg14.invoke(Integer.valueOf(v6));
                            goto label_29;
                        }
                    }
                }
                else {
                    if(v0 >> 3 != v2) {
                        goto label_160;
                    }

                    v1 = arg12 + 3;
                    if(arg13 <= v1) {
                        arg14.invoke(Integer.valueOf(v6));
                        v0 = arg12 + 1;
                        if(arg13 <= v0) {
                            goto label_29;
                        }

                        if((arg11[v0] & 0xC0) != v4) {
                            goto label_29;
                        }

                        v0 = arg12 + 2;
                        if(arg13 <= v0) {
                            goto label_43;
                        }

                        if((arg11[v0] & 0xC0) != v4) {
                            goto label_43;
                        }

                        goto label_85;
                    }

                    v2 = arg11[arg12 + 1];
                    if((v2 & 0xC0) != v4) {
                        goto label_156;
                    }

                    int v5 = arg11[arg12 + 2];
                    if((v5 & 0xC0) != v4) {
                        goto label_152;
                    }

                    v1 = arg11[v1];
                    if((v1 & 0xC0) == v4) {
                        v0 = v0 << 18 ^ (v1 ^ 0x381F80 ^ v5 << 6 ^ v2 << 12);
                        if(v0 <= 0x10FFFF) {
                            if(v8 <= v0 && v0 < v7) {
                                goto label_134;
                            }

                            if(v0 >= 0x10000) {
                                goto label_144;
                            }

                            goto label_134;
                        }
                        else {
                        label_134:
                            v0_1 = Integer.valueOf(v6);
                            goto label_135;
                        label_144:
                            v0_1 = Integer.valueOf(v0);
                        }

                    label_135:
                        arg14.invoke(v0_1);
                        v3 = 4;
                        goto label_43;
                    }

                    arg14.invoke(Integer.valueOf(v6));
                }

            label_85:
                v3 = v9;
                goto label_43;
            label_152:
                arg14.invoke(Integer.valueOf(v6));
                goto label_43;
            label_156:
                arg14.invoke(Integer.valueOf(v6));
            label_29:
                v3 = 1;
            }

        label_43:
            arg12 += v3;
            continue;
        label_160:
            arg14.invoke(Integer.valueOf(v6));
            ++arg12;
        }

        return;
        while(true) {
        label_10:
            if(arg12 >= arg13) {
                goto label_4;
            }

            v0 = arg11[arg12];
            if(v0 < 0) {
                goto label_4;
            }

            ++arg12;
            arg14.invoke(Integer.valueOf(v0));
        }
    }

    public static final long size(String arg9, int arg10, int arg11) {
        long v2_1;
        Intrinsics.checkNotNullParameter(arg9, "<this>");
        if(arg10 >= 0) {
            if(arg11 >= arg10) {
                if(arg11 <= arg9.length()) {
                    long v0 = 0;
                    while(arg10 < arg11) {
                        int v2 = arg9.charAt(arg10);
                        long v4 = 1;
                        if(v2 < 0x80) {
                            v0 += v4;
                        }
                        else {
                            if(v2 < 0x800) {
                                v2_1 = 2;
                            }
                            else {
                                if(v2 >= 0xD800) {
                                    int v3 = 0xDFFF;
                                    if(v2 > v3) {
                                    }
                                    else {
                                        int v6 = arg10 + 1;
                                        int v7 = v6 < arg11 ? arg9.charAt(v6) : 0;
                                        if(v2 <= 0xDBFF && v7 >= 0xDC00) {
                                            if(v7 > v3) {
                                            }
                                            else {
                                                v0 += 4;
                                                arg10 += 2;
                                                continue;
                                            }
                                        }

                                        v0 += v4;
                                        arg10 = v6;
                                        continue;
                                    }
                                }

                                v2_1 = 3;
                            }

                            v0 += v2_1;
                        }

                        ++arg10;
                    }

                    return v0;
                }

                throw new IllegalArgumentException("endIndex > string.length: " + arg11 + " > " + arg9.length().toString());
            }

            throw new IllegalArgumentException("endIndex < beginIndex: " + arg11 + " < " + arg10.toString());
        }

        throw new IllegalArgumentException("beginIndex < 0: " + arg10.toString());
    }

    public static final long size(String arg3) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        return Utf8.size$default(arg3, 0, 0, 3, null);
    }

    public static final long size(String arg3, int arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        return Utf8.size$default(arg3, arg4, 0, 2, null);
    }

    public static long size$default(String arg0, int arg1, int arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = arg0.length();
        }

        return Utf8.size(arg0, 0, arg2);
    }
}

