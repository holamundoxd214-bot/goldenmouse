package okio.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000\u0014\n\u0000\n\u0002\u0010\u000E\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001A\u001E\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001A\u00020\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u0004\u001A\n\u0010\u0006\u001A\u00020\u0002*\u00020\u0001¨\u0006\u0007"}, d2={"commonToUtf8String", "", "", "beginIndex", "", "endIndex", "commonAsUtf8ToByteArray", "okio"}, k=2, mv={2, 1, 0}, xi=0x30) public final class _Utf8Kt {
    public static final byte[] commonAsUtf8ToByteArray(String arg12) {
        int v8;
        int v7;
        int v5;
        int v4;
        String v3;
        Intrinsics.checkNotNullParameter(arg12, "<this>");
        byte[] v0 = new byte[arg12.length() * 4];
        int v1 = arg12.length();
        int v2;
        for(v2 = 0; true; ++v2) {
            v3 = "copyOf(...)";
            if(v2 >= v1) {
                break;
            }

            v4 = arg12.charAt(v2);
            v5 = 0x80;
            if(Intrinsics.compare(v4, v5) >= 0) {
                v1 = arg12.length();
                v4 = v2;
                goto label_15;
            }

            v0[v2] = ((byte)v4);
        }

        byte[] v12 = Arrays.copyOf(v0, arg12.length());
        Intrinsics.checkNotNullExpressionValue(v12, v3);
        return v12;
    label_15:
        while(v2 < v1) {
            int v6 = arg12.charAt(v2);
            if(Intrinsics.compare(v6, v5) < 0) {
                v7 = v4 + 1;
                v0[v4] = ((byte)v6);
                ++v2;
                goto label_23;
            }

            if(Intrinsics.compare(v6, 0x800) < 0) {
                v8 = v4 + 1;
                v0[v4] = ((byte)(v6 >> 6 | 0xC0));
                v4 += 2;
                v0[v8] = ((byte)(v6 & 0x3F | v5));
            }
            else {
                byte v8_1 = 0x3F;
                if(0xD800 <= v6) {
                    v7 = 0xE000;
                    if(v6 < v7) {
                        if(Intrinsics.compare(v6, 0xDBFF) <= 0) {
                            int v9 = v2 + 1;
                            if(v1 > v9) {
                                int v10 = arg12.charAt(v9);
                                if(0xDC00 <= v10 && v10 < v7) {
                                    v6 = (v6 << 10) + arg12.charAt(v9) - 0x35FDC00;
                                    v0[v4] = ((byte)(v6 >> 18 | 0xF0));
                                    v0[v4 + 1] = ((byte)(v6 >> 12 & v8_1 | v5));
                                    v9 = v4 + 3;
                                    v0[v4 + 2] = ((byte)(v6 >> 6 & v8_1 | v5));
                                    v4 += 4;
                                    v0[v9] = ((byte)(v6 & v8_1 | v5));
                                    v2 += 2;
                                    continue;
                                }
                            }
                        }

                        v0[v4] = v8_1;
                        ++v2;
                        ++v4;
                        continue;
                    }
                }

                v0[v4] = ((byte)(v6 >> 12 | 0xE0));
                byte v7_1 = ((byte)(v6 >> 6 & v8_1 | v5));
                v8 = v4 + 2;
                v0[v4 + 1] = v7_1;
                v4 += 3;
                v0[v8] = ((byte)(v6 & 0x3F | v5));
            }

            ++v2;
        }

        v12 = Arrays.copyOf(v0, v4);
        Intrinsics.checkNotNullExpressionValue(v12, v3);
        return v12;
        while(true) {
        label_23:
            v4 = v7;
            if(v2 >= v1) {
                goto label_15;
            }

            if(Intrinsics.compare(arg12.charAt(v2), v5) >= 0) {
                goto label_15;
            }

            v7 = v4 + 1;
            v0[v4] = ((byte)arg12.charAt(v2));
            ++v2;
        }
    }

    public static final String commonToUtf8String(byte[] arg16, int arg17, int arg18) {
        int v9;
        int v7;
        byte[] v0 = arg16;
        int v1 = arg17;
        int v2 = arg18;
        Intrinsics.checkNotNullParameter(v0, "<this>");
        if(v1 >= 0 && v2 <= v0.length && v1 <= v2) {
            char[] v3 = new char[v2 - v1];
            int v5 = 0;
            while(true) {
            label_13:
                if(v1 < v2) {
                    int v6 = v0[v1];
                    if(v6 >= 0) {
                        v7 = v5 + 1;
                        v3[v5] = ((char)v6);
                        ++v1;
                        goto label_20;
                    }
                    else {
                        int v8 = -2;
                        int v10 = 0x80;
                        char v11 = '\uFFFD';
                        if(v6 >> 5 == v8) {
                            v7 = v1 + 1;
                            if(v2 <= v7) {
                                v6 = v5 + 1;
                                v3[v5] = v11;
                                goto label_42;
                            }
                            else {
                                v7 = v0[v7];
                                if((v7 & 0xC0) == v10) {
                                    v6 = v6 << 6 ^ (v7 ^ 0xF80);
                                    if(v6 < v10) {
                                        v6 = v5 + 1;
                                        v3[v5] = v11;
                                    }
                                    else {
                                        v3[v5] = ((char)v6);
                                        v6 = v5 + 1;
                                    }

                                    v9 = 2;
                                }
                                else {
                                    v6 = v5 + 1;
                                    v3[v5] = v11;
                                label_42:
                                    v9 = 1;
                                }
                            }

                            v1 += v9;
                        }
                        else {
                            int v13 = 0xE000;
                            int v14 = 0xD800;
                            int v15 = 3;
                            if(v6 >> 4 == v8) {
                                v7 = v1 + 2;
                                if(v2 <= v7) {
                                    v6 = v5 + 1;
                                    v3[v5] = v11;
                                    v5 = v1 + 1;
                                    if(v2 > v5) {
                                        if((v0[v5] & 0xC0) != v10) {
                                            goto label_86;
                                        }

                                        goto label_84;
                                    }
                                    else {
                                        goto label_86;
                                    }
                                }
                                else {
                                    v8 = v0[v1 + 1];
                                    if((v8 & 0xC0) == v10) {
                                        v7 = v0[v7];
                                        if((v7 & 0xC0) == v10) {
                                            v6 = v6 << 12 ^ (v7 ^ 0xFFFE1F80 ^ v8 << 6);
                                            if(v6 < 0x800) {
                                                v6 = v5 + 1;
                                                v3[v5] = v11;
                                            }
                                            else {
                                                if(v14 <= v6 && v6 < v13) {
                                                    v6 = v5 + 1;
                                                    v3[v5] = v11;
                                                    goto label_117;
                                                }

                                                v3[v5] = ((char)v6);
                                                v6 = v5 + 1;
                                            }

                                        label_117:
                                            v9 = v15;
                                        }
                                        else {
                                            v6 = v5 + 1;
                                            v3[v5] = v11;
                                        label_84:
                                            v9 = 2;
                                        }
                                    }
                                    else {
                                        v6 = v5 + 1;
                                        v3[v5] = v11;
                                    label_86:
                                        v9 = 1;
                                    }
                                }

                                v1 += v9;
                                goto label_229;
                            }

                            if(v6 >> 3 == v8) {
                                v7 = v1 + 3;
                                if(v2 <= v7) {
                                    v6 = v5 + 1;
                                    v3[v5] = v11;
                                    v5 = v1 + 1;
                                    if(v2 <= v5) {
                                        goto label_151;
                                    }
                                    else if((v0[v5] & 0xC0) == v10) {
                                        v5 = v1 + 2;
                                        if(v2 > v5) {
                                            if((v0[v5] & 0xC0) != v10) {
                                                goto label_149;
                                            }

                                            goto label_147;
                                        }
                                        else {
                                            goto label_149;
                                        }
                                    }
                                    else {
                                        goto label_151;
                                    }
                                }
                                else {
                                    v8 = v0[v1 + 1];
                                    if((v8 & 0xC0) == v10) {
                                        v9 = v0[v1 + 2];
                                        if((v9 & 0xC0) == v10) {
                                            v7 = v0[v7];
                                            if((v7 & 0xC0) == v10) {
                                                v6 = v6 << 18 ^ (v7 ^ 0x381F80 ^ v9 << 6 ^ v8 << 12);
                                                if(v6 > 0x10FFFF) {
                                                    v6 = v5 + 1;
                                                    v3[v5] = v11;
                                                }
                                                else {
                                                    if(v14 <= v6 && v6 < v13) {
                                                        v6 = v5 + 1;
                                                        v3[v5] = v11;
                                                        goto label_207;
                                                    }

                                                    if(v6 < 0x10000) {
                                                        v6 = v5 + 1;
                                                        v3[v5] = v11;
                                                        goto label_207;
                                                    }

                                                    if(v6 != v11) {
                                                        v8 = v5 + 1;
                                                        v3[v5] = ((char)((v6 >>> 10) + 0xD7C0));
                                                        v5 += 2;
                                                        v3[v8] = ((char)((v6 & 0x3FF) + 0xDC00));
                                                    }
                                                    else {
                                                        v3[v5] = v11;
                                                        ++v5;
                                                    }

                                                    v6 = v5;
                                                }

                                            label_207:
                                                v9 = 4;
                                            }
                                            else {
                                                v6 = v5 + 1;
                                                v3[v5] = v11;
                                            label_147:
                                                v9 = v15;
                                            }
                                        }
                                        else {
                                            v6 = v5 + 1;
                                            v3[v5] = v11;
                                        label_149:
                                            v9 = 2;
                                        }
                                    }
                                    else {
                                        v6 = v5 + 1;
                                        v3[v5] = v11;
                                    label_151:
                                        v9 = 1;
                                    }
                                }

                                v1 += v9;
                                goto label_229;
                            }

                            v6 = v5 + 1;
                            v3[v5] = v11;
                            Integer.valueOf(v1);
                            ++v1;
                        }

                    label_229:
                        v5 = v6;
                        continue;
                    }
                }
                else {
                    break;
                }

                goto label_233;
            }

            return StringsKt.concatToString(v3, 0, v5);
        label_20:
            while(v1 < v2) {
                v5 = v0[v1];
                if(v5 < 0) {
                    break;
                }

                ++v1;
                v3[v7] = ((char)v5);
                ++v7;
            }

            v5 = v7;
            goto label_13;
        }

    label_233:
        throw new ArrayIndexOutOfBoundsException("size=" + v0.length + " beginIndex=" + v1 + " endIndex=" + v2);
    }

    public static String commonToUtf8String$default(byte[] arg0, int arg1, int arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = arg0.length;
        }

        return _Utf8Kt.commonToUtf8String(arg0, 0, arg2);
    }
}

