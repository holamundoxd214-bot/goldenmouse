package okio.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.-Base64;
import okio.-SegmentedByteString;
import okio.Buffer;
import okio.ByteString;
import okio._JvmPlatformKt;

@Metadata(d1={"\u0000N\n\u0000\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u001A\r\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0080\b\u001A\r\u0010\u0003\u001A\u00020\u0001*\u00020\u0002H\u0080\b\u001A\r\u0010\u0004\u001A\u00020\u0001*\u00020\u0002H\u0080\b\u001A\r\u0010\t\u001A\u00020\u0001*\u00020\u0002H\u0080\b\u001A\r\u0010\n\u001A\u00020\u0002*\u00020\u0002H\u0080\b\u001A\r\u0010\u000B\u001A\u00020\u0002*\u00020\u0002H\u0080\b\u001A\u001D\u0010\f\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u000EH\u0080\b\u001A\u0015\u0010\u0010\u001A\u00020\u0011*\u00020\u00022\u0006\u0010\u0012\u001A\u00020\u000EH\u0080\b\u001A\r\u0010\u0013\u001A\u00020\u000E*\u00020\u0002H\u0080\b\u001A\r\u0010\u0014\u001A\u00020\u0015*\u00020\u0002H\u0080\b\u001A\r\u0010\u0016\u001A\u00020\u0015*\u00020\u0002H\u0080\b\u001A-\u0010\u0017\u001A\u00020\u0018*\u00020\u00022\u0006\u0010\u0019\u001A\u00020\u000E2\u0006\u0010\u001A\u001A\u00020\u00022\u0006\u0010\u001B\u001A\u00020\u000E2\u0006\u0010\u001C\u001A\u00020\u000EH\u0080\b\u001A-\u0010\u0017\u001A\u00020\u0018*\u00020\u00022\u0006\u0010\u0019\u001A\u00020\u000E2\u0006\u0010\u001A\u001A\u00020\u00152\u0006\u0010\u001B\u001A\u00020\u000E2\u0006\u0010\u001C\u001A\u00020\u000EH\u0080\b\u001A-\u0010\u001D\u001A\u00020\u001E*\u00020\u00022\u0006\u0010\u0019\u001A\u00020\u000E2\u0006\u0010\u001F\u001A\u00020\u00152\u0006\u0010 \u001A\u00020\u000E2\u0006\u0010\u001C\u001A\u00020\u000EH\u0080\b\u001A\u0015\u0010!\u001A\u00020\u0018*\u00020\u00022\u0006\u0010\"\u001A\u00020\u0002H\u0080\b\u001A\u0015\u0010!\u001A\u00020\u0018*\u00020\u00022\u0006\u0010\"\u001A\u00020\u0015H\u0080\b\u001A\u0015\u0010#\u001A\u00020\u0018*\u00020\u00022\u0006\u0010$\u001A\u00020\u0002H\u0080\b\u001A\u0015\u0010#\u001A\u00020\u0018*\u00020\u00022\u0006\u0010$\u001A\u00020\u0015H\u0080\b\u001A\u001D\u0010%\u001A\u00020\u000E*\u00020\u00022\u0006\u0010\u001A\u001A\u00020\u00152\u0006\u0010&\u001A\u00020\u000EH\u0080\b\u001A\u001D\u0010\'\u001A\u00020\u000E*\u00020\u00022\u0006\u0010\u001A\u001A\u00020\u00022\u0006\u0010&\u001A\u00020\u000EH\u0080\b\u001A\u001D\u0010\'\u001A\u00020\u000E*\u00020\u00022\u0006\u0010\u001A\u001A\u00020\u00152\u0006\u0010&\u001A\u00020\u000EH\u0080\b\u001A\u0017\u0010(\u001A\u00020\u0018*\u00020\u00022\b\u0010\u001A\u001A\u0004\u0018\u00010)H\u0080\b\u001A\r\u0010*\u001A\u00020\u000E*\u00020\u0002H\u0080\b\u001A\u0015\u0010+\u001A\u00020\u000E*\u00020\u00022\u0006\u0010\u001A\u001A\u00020\u0002H\u0080\b\u001A\u0011\u0010,\u001A\u00020\u00022\u0006\u0010-\u001A\u00020\u0015H\u0080\b\u001A\u001D\u0010.\u001A\u00020\u0002*\u00020\u00152\u0006\u0010\u0019\u001A\u00020\u000E2\u0006\u0010\u001C\u001A\u00020\u000EH\u0080\b\u001A\r\u0010/\u001A\u00020\u0002*\u00020\u0001H\u0080\b\u001A\u000F\u00100\u001A\u0004\u0018\u00010\u0002*\u00020\u0001H\u0080\b\u001A$\u00101\u001A\u00020\u001E*\u00020\u00022\u0006\u00102\u001A\u0002032\u0006\u0010\u0019\u001A\u00020\u000E2\u0006\u0010\u001C\u001A\u00020\u000EH\u0000\u001A\r\u00104\u001A\u00020\u0001*\u00020\u0002H\u0080\b\u001A\u0018\u00105\u001A\u00020\u000E2\u0006\u00106\u001A\u00020\u00152\u0006\u00107\u001A\u00020\u000EH\u0002\"\u0014\u0010\u0005\u001A\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u00068"}, d2={"commonUtf8", "", "Lokio/ByteString;", "commonBase64", "commonBase64Url", "HEX_DIGIT_CHARS", "", "getHEX_DIGIT_CHARS", "()[C", "commonHex", "commonToAsciiLowercase", "commonToAsciiUppercase", "commonSubstring", "beginIndex", "", "endIndex", "commonGetByte", "", "pos", "commonGetSize", "commonToByteArray", "", "commonInternalArray", "commonRangeEquals", "", "offset", "other", "otherOffset", "byteCount", "commonCopyInto", "", "target", "targetOffset", "commonStartsWith", "prefix", "commonEndsWith", "suffix", "commonIndexOf", "fromIndex", "commonLastIndexOf", "commonEquals", "", "commonHashCode", "commonCompareTo", "commonOf", "data", "commonToByteString", "commonEncodeUtf8", "commonDecodeBase64", "commonWrite", "buffer", "Lokio/Buffer;", "commonToString", "codePointIndexToCharIndex", "s", "codePointCount", "okio"}, k=2, mv={2, 1, 0}, xi=0x30) public final class -ByteString {
    private static final char[] HEX_DIGIT_CHARS;

    static {
        -ByteString.HEX_DIGIT_CHARS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public static final int access$codePointIndexToCharIndex(byte[] arg0, int arg1) {
        return -ByteString.codePointIndexToCharIndex(arg0, arg1);
    }

    private static final int codePointIndexToCharIndex(byte[] arg18, int arg19) {
        int v17;
        int v16;
        int v13;
        int v6;
        byte[] v0 = arg18;
        int v1 = arg19;
        int v2 = v0.length;
        int v3 = 0;
        int v4 = 0;
        int v5 = 0;
        while(true) {
        label_6:
            if(v3 < v2) {
                v6 = v0[v3];
                int v7 = 0xA0;
                int v8 = 0x7F;
                int v9 = 0x20;
                int v10 = 13;
                int v11 = 0xFFFD;
                int v12 = 10;
                v13 = 0x10000;
                v16 = -1;
                if(v6 >= 0) {
                    v17 = v5 + 1;
                    if(v5 == v1) {
                    }
                    else {
                        if(v6 == v12 || v6 == v10) {
                        label_28:
                            if(v6 != v11) {
                                goto label_30;
                            }
                        }
                        else {
                            if(v6 >= 0 && v6 < v9) {
                                return v16;
                            }

                            if(v8 > v6) {
                                goto label_28;
                            }

                            if(v6 >= v7) {
                                goto label_28;
                            }
                        }

                        return v16;
                    label_30:
                        v5 = v6 < v13 ? 1 : 2;
                        v4 += v5;
                        ++v3;
                        goto label_36;
                    }
                }
                else {
                    int v15 = -2;
                    v13 = 0x80;
                    if(v6 >> 5 != v15) {
                        goto label_108;
                    }

                    int v14 = v3 + 1;
                    if(v2 <= v14) {
                        if(v5 == v1) {
                            return v4;
                        }

                        return v16;
                    }

                    v14 = v0[v14];
                    if((v14 & 0xC0) != v13) {
                        goto label_105;
                    }

                    v6 = v6 << 6 ^ (v14 ^ 0xF80);
                    if(v6 < v13) {
                        if(v5 == v1) {
                            return v4;
                        }

                        return v16;
                    }

                    v13 = v5 + 1;
                    if(v5 == v1) {
                        return v4;
                    }

                    if(v6 == v12 || v6 == v10) {
                    label_92:
                        if(v6 != v11) {
                            goto label_94;
                        }
                    }
                    else {
                        if(v6 >= 0 && v6 < v9) {
                            return v16;
                        }

                        if(v8 > v6) {
                            goto label_92;
                        }

                        if(v6 >= v7) {
                            goto label_92;
                        }
                    }

                    return v16;
                label_94:
                    v14 = v6 < 0x10000 ? 1 : 2;
                    v4 += v14;
                    v3 += 2;
                    v5 = v13;
                    continue;
                label_105:
                    if(v5 == v1) {
                        return v4;
                    }

                    return v16;
                label_108:
                    v11 = 0xE000;
                    v7 = 0xD800;
                    if(v6 >> 4 == v15) {
                        v14 = v3 + 2;
                        if(v2 > v14) {
                            v15 = v0[v3 + 1];
                            if((v15 & 0xC0) == v13) {
                                v8 = v0[v14];
                                if((v8 & 0xC0) == v13) {
                                    v6 = v6 << 12 ^ (v8 ^ 0xFFFE1F80 ^ v15 << 6);
                                    if(v6 >= 0x800) {
                                        if(v7 <= v6 && v6 < v11) {
                                            if(v5 == v1) {
                                                return v4;
                                            }
                                            else {
                                                return v16;
                                            }
                                        }

                                        v7 = v5 + 1;
                                        if(v5 == v1) {
                                            return v4;
                                        }

                                        if(v6 == v12 || v6 == v10) {
                                        label_153:
                                            if(v6 != 0xFFFD) {
                                                goto label_156;
                                            }
                                        }
                                        else {
                                            if(v6 >= 0 && v6 < v9) {
                                                return v16;
                                            }

                                            if(0x7F > v6) {
                                                goto label_153;
                                            }

                                            if(v6 >= 0xA0) {
                                                goto label_153;
                                            }
                                        }

                                        return v16;
                                    label_156:
                                        v14 = v6 < 0x10000 ? 1 : 2;
                                        v4 += v14;
                                        v3 += 3;
                                    }
                                    else if(v5 == v1) {
                                        return v4;
                                    }
                                    else {
                                        return v16;
                                    }
                                }
                                else {
                                    if(v5 == v1) {
                                        return v4;
                                    }

                                    return v16;
                                }
                            }
                            else {
                                if(v5 == v1) {
                                    return v4;
                                }

                                return v16;
                            }
                        }
                        else if(v5 == v1) {
                            return v4;
                        }
                        else {
                            return v16;
                        }
                    }
                    else {
                        if(v6 >> 3 != v15) {
                            goto label_250;
                        }

                        v8 = v3 + 3;
                        if(v2 <= v8) {
                            if(v5 == v1) {
                                return v4;
                            }

                            return v16;
                        }

                        v14 = v0[v3 + 1];
                        if((v14 & 0xC0) != v13) {
                            goto label_247;
                        }

                        v15 = v0[v3 + 2];
                        if((v15 & 0xC0) != v13) {
                            goto label_244;
                        }

                        v8 = v0[v8];
                        if((v8 & 0xC0) != v13) {
                            break;
                        }

                        v6 = v6 << 18 ^ (v8 ^ 0x381F80 ^ v15 << 6 ^ v14 << 12);
                        if(v6 > 0x10FFFF) {
                            if(v5 == v1) {
                                return v4;
                            }

                            return v16;
                        }

                        if(v7 <= v6 && v6 < v11) {
                            if(v5 == v1) {
                                return v4;
                            }
                            else {
                                return v16;
                            }
                        }

                        if(v6 < 0x10000) {
                            if(v5 == v1) {
                                return v4;
                            }

                            return v16;
                        }

                        v7 = v5 + 1;
                        if(v5 == v1) {
                            return v4;
                        }

                        if(v6 == v12 || v6 == v10) {
                        label_228:
                            if(v6 != 0xFFFD) {
                                goto label_231;
                            }
                        }
                        else {
                            if(v6 >= 0 && v6 < 0x20) {
                                return v16;
                            }

                            if(0x7F > v6) {
                                goto label_228;
                            }

                            if(v6 >= 0xA0) {
                                goto label_228;
                            }
                        }

                        return v16;
                    label_231:
                        v14 = v6 < 0x10000 ? 1 : 2;
                        v4 += v14;
                        v3 += 4;
                    }

                    v5 = v7;
                    continue;
                }
            }

            return v4;
        }

        if(v5 == v1) {
            return v4;
        }

        return v16;
    label_244:
        if(v5 == v1) {
            return v4;
        }

        return v16;
    label_247:
        if(v5 == v1) {
            return v4;
        }

        return v16;
    label_250:
        if(v5 == v1) {
        }
        else {
            return v16;
        }

        return v4;
        while(true) {
        label_36:
            v5 = v17;
            if(v3 >= v2) {
                goto label_6;
            }

            v6 = v0[v3];
            if(v6 < 0) {
                goto label_6;
            }

            ++v3;
            v17 = v5 + 1;
            if(v5 == v1) {
                return v4;
            }

            if(v6 == v12 || v6 == v10) {
            label_52:
                if(v6 != v11) {
                    goto label_54;
                }
            }
            else {
                if(v6 >= 0 && v6 < v9) {
                    return v16;
                }

                if(v8 > v6) {
                    goto label_52;
                }

                if(v6 >= v7) {
                    goto label_52;
                }
            }

            return v16;
        label_54:
            v5 = v6 < v13 ? 1 : 2;
            v4 += v5;
        }
    }

    public static final String commonBase64(ByteString arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        return -Base64.encodeBase64$default(arg2.getData$okio(), null, 1, null);
    }

    public static final String commonBase64Url(ByteString arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return -Base64.encodeBase64(arg1.getData$okio(), -Base64.getBASE64_URL_SAFE());
    }

    public static final int commonCompareTo(ByteString arg9, ByteString arg10) {
        int v5;
        Intrinsics.checkNotNullParameter(arg9, "<this>");
        Intrinsics.checkNotNullParameter(arg10, "other");
        int v0 = arg9.size();
        int v1 = arg10.size();
        int v2 = Math.min(v0, v1);
        int v4;
        for(v4 = 0; true; ++v4) {
            v5 = -1;
            if(v4 >= v2) {
                goto label_22;
            }

            int v7 = arg9.getByte(v4) & 0xFF;
            int v8 = arg10.getByte(v4) & 0xFF;
            if(v7 != v8) {
                break;
            }
        }

        if(v7 < v8) {
            return v5;
        }

        return 1;
    label_22:
        if(v0 == v1) {
            return 0;
        }

        if(v0 < v1) {
            return v5;
        }

        return 1;
    }

    public static final void commonCopyInto(ByteString arg1, int arg2, byte[] arg3, int arg4, int arg5) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "target");
        ArraysKt.copyInto(arg1.getData$okio(), arg3, arg4, arg2, arg5 + arg2);
    }

    public static final ByteString commonDecodeBase64(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        byte[] v1 = -Base64.decodeBase64ToArray(arg1);
        if(v1 != null) {
            return new ByteString(v1);
        }

        return null;
    }

    public static final ByteString commonEncodeUtf8(String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        ByteString v0 = new ByteString(_JvmPlatformKt.asUtf8ToByteArray(arg2));
        v0.setUtf8$okio(arg2);
        return v0;
    }

    public static final boolean commonEndsWith(ByteString arg3, ByteString arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "suffix");
        return arg3.rangeEquals(arg3.size() - arg4.size(), arg4, 0, arg4.size());
    }

    public static final boolean commonEndsWith(ByteString arg3, byte[] arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "suffix");
        return arg3.rangeEquals(arg3.size() - arg4.length, arg4, 0, arg4.length);
    }

    public static final boolean commonEquals(ByteString arg4, Object arg5) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        if((((ByteString)arg5)) == arg4) {
            return 1;
        }

        if(((arg5 instanceof ByteString)) && ((ByteString)arg5).size() == arg4.getData$okio().length && (((ByteString)arg5).rangeEquals(0, arg4.getData$okio(), 0, arg4.getData$okio().length))) {
            return 1;
        }

        return 0;
    }

    public static final byte commonGetByte(ByteString arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.getData$okio()[arg2];
    }

    public static final int commonGetSize(ByteString arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.getData$okio().length;
    }

    public static final int commonHashCode(ByteString arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        int v0 = arg1.getHashCode$okio();
        if(v0 != 0) {
            return v0;
        }

        v0 = Arrays.hashCode(arg1.getData$okio());
        arg1.setHashCode$okio(v0);
        return v0;
    }

    public static final String commonHex(ByteString arg8) {
        Intrinsics.checkNotNullParameter(arg8, "<this>");
        char[] v0 = new char[arg8.getData$okio().length * 2];
        byte[] v8 = arg8.getData$okio();
        int v1 = v8.length;
        int v2 = 0;
        int v3 = 0;
        while(v2 < v1) {
            int v4 = v8[v2];
            int v5 = v3 + 1;
            v0[v3] = -ByteString.getHEX_DIGIT_CHARS()[v4 >> 4 & 15];
            v3 += 2;
            v0[v5] = -ByteString.getHEX_DIGIT_CHARS()[v4 & 15];
            ++v2;
        }

        return StringsKt.concatToString(v0);
    }

    public static final int commonIndexOf(ByteString arg4, byte[] arg5, int arg6) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        Intrinsics.checkNotNullParameter(arg5, "other");
        int v0 = arg4.getData$okio().length - arg5.length;
        arg6 = Math.max(arg6, 0);
        if(arg6 <= v0) {
            while(true) {
                if(-SegmentedByteString.arrayRangeEquals(arg4.getData$okio(), arg6, arg5, 0, arg5.length)) {
                    return arg6;
                }
                else if(arg6 != v0) {
                    ++arg6;
                    continue;
                }

                return -1;
            }

            return arg6;
        }

        return -1;
    }

    public static final byte[] commonInternalArray(ByteString arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.getData$okio();
    }

    public static final int commonLastIndexOf(ByteString arg1, ByteString arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "other");
        return arg1.lastIndexOf(arg2.internalArray$okio(), arg3);
    }

    public static final int commonLastIndexOf(ByteString arg3, byte[] arg4, int arg5) {
        int v0;
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "other");
        for(arg5 = Math.min(arg5, arg3.getData$okio().length - arg4.length); true; --arg5) {
            v0 = -1;
            if(v0 >= arg5) {
                return v0;
            }

            if(-SegmentedByteString.arrayRangeEquals(arg3.getData$okio(), arg5, arg4, 0, arg4.length)) {
                return arg5;
            }
        }

        return v0;
    }

    public static final ByteString commonOf(byte[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "data");
        arg2 = Arrays.copyOf(arg2, arg2.length);
        Intrinsics.checkNotNullExpressionValue(arg2, "copyOf(...)");
        return new ByteString(arg2);
    }

    public static final boolean commonRangeEquals(ByteString arg1, int arg2, ByteString arg3, int arg4, int arg5) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "other");
        return arg3.rangeEquals(arg4, arg1.getData$okio(), arg2, arg5);
    }

    public static final boolean commonRangeEquals(ByteString arg1, int arg2, byte[] arg3, int arg4, int arg5) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "other");
        if(arg2 >= 0 && arg2 <= arg1.getData$okio().length - arg5 && arg4 >= 0 && arg4 <= arg3.length - arg5 && (-SegmentedByteString.arrayRangeEquals(arg1.getData$okio(), arg2, arg3, arg4, arg5))) {
            return 1;
        }

        return 0;
    }

    public static final boolean commonStartsWith(ByteString arg2, ByteString arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "prefix");
        return arg2.rangeEquals(0, arg3, 0, arg3.size());
    }

    public static final boolean commonStartsWith(ByteString arg2, byte[] arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "prefix");
        return arg2.rangeEquals(0, arg3, 0, arg3.length);
    }

    public static final ByteString commonSubstring(ByteString arg1, int arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg2 >= 0) {
            if(arg3 <= arg1.getData$okio().length) {
                if(arg3 - arg2 >= 0) {
                    if(arg2 == 0 && arg3 == arg1.getData$okio().length) {
                        return arg1;
                    }

                    return new ByteString(ArraysKt.copyOfRange(arg1.getData$okio(), arg2, arg3));
                }

                throw new IllegalArgumentException("endIndex < beginIndex".toString());
            }

            throw new IllegalArgumentException("endIndex > length(" + arg1.getData$okio().length + ')'.toString());
        }

        throw new IllegalArgumentException("beginIndex < 0".toString());
    }

    public static final ByteString commonToAsciiLowercase(ByteString arg5) {
        int v4;
        byte[] v5;
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        int v0;
        for(v0 = 0; v0 < arg5.getData$okio().length; ++v0) {
            int v1 = arg5.getData$okio()[v0];
            int v2 = 65;
            if(v1 >= v2) {
                int v3 = 90;
                if(v1 > v3) {
                }
                else {
                    v5 = arg5.getData$okio();
                    v5 = Arrays.copyOf(v5, v5.length);
                    Intrinsics.checkNotNullExpressionValue(v5, "copyOf(...)");
                    v4 = v0 + 1;
                    v5[v0] = ((byte)(v1 + 0x20));
                    goto label_22;
                }
            }
        }

        return arg5;
    label_22:
        while(v4 < v5.length) {
            v0 = v5[v4];
            if(v0 >= v2) {
                if(v0 > v3) {
                }
                else {
                    v5[v4] = ((byte)(v0 + 0x20));
                }
            }

            ++v4;
        }

        return new ByteString(v5);
    }

    public static final ByteString commonToAsciiUppercase(ByteString arg5) {
        int v4;
        byte[] v5;
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        int v0;
        for(v0 = 0; v0 < arg5.getData$okio().length; ++v0) {
            int v1 = arg5.getData$okio()[v0];
            int v2 = 97;
            if(v1 >= v2) {
                int v3 = 0x7A;
                if(v1 > v3) {
                }
                else {
                    v5 = arg5.getData$okio();
                    v5 = Arrays.copyOf(v5, v5.length);
                    Intrinsics.checkNotNullExpressionValue(v5, "copyOf(...)");
                    v4 = v0 + 1;
                    v5[v0] = ((byte)(v1 - 0x20));
                    goto label_22;
                }
            }
        }

        return arg5;
    label_22:
        while(v4 < v5.length) {
            v0 = v5[v4];
            if(v0 >= v2) {
                if(v0 > v3) {
                }
                else {
                    v5[v4] = ((byte)(v0 - 0x20));
                }
            }

            ++v4;
        }

        return new ByteString(v5);
    }

    public static final byte[] commonToByteArray(ByteString arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        byte[] v1 = arg1.getData$okio();
        v1 = Arrays.copyOf(v1, v1.length);
        Intrinsics.checkNotNullExpressionValue(v1, "copyOf(...)");
        return v1;
    }

    public static final ByteString commonToByteString(byte[] arg7, int arg8, int arg9) {
        Intrinsics.checkNotNullParameter(arg7, "<this>");
        -SegmentedByteString.checkOffsetAndCount(((long)arg7.length), ((long)arg8), ((long)arg9));
        return new ByteString(ArraysKt.copyOfRange(arg7, arg8, arg9 + arg8));
    }

    public static final String commonToString(ByteString arg20) {
        ByteString v1 = arg20;
        Intrinsics.checkNotNullParameter(v1, "<this>");
        if(v1.getData$okio().length == 0) {
            return "[size=0]";
        }

        int v2 = 0x40;
        int v0 = -ByteString.codePointIndexToCharIndex(v1.getData$okio(), v2);
        String v4 = "…]";
        String v5 = "[size=";
        char v6 = ']';
        if(v0 == -1) {
            if(v1.getData$okio().length <= v2) {
                return "[hex=" + v1.hex() + v6;
            }

            StringBuilder v0_1 = new StringBuilder(v5).append(v1.getData$okio().length).append(" hex=");
            if(v2 <= v1.getData$okio().length) {
                if(v2 == v1.getData$okio().length) {
                }
                else {
                    v1 = new ByteString(ArraysKt.copyOfRange(v1.getData$okio(), 0, v2));
                }

                return v0_1.append(v1.hex()).append(v4).toString();
            }

            throw new IllegalArgumentException("endIndex > length(" + v1.getData$okio().length + ')'.toString());
        }

        String v2_1 = v1.utf8();
        String v8 = v2_1.substring(0, v0);
        Intrinsics.checkNotNullExpressionValue(v8, "substring(...)");
        String v3 = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(v8, "\\", "\\\\", false, 4, null), "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null);
        if(v0 < v2_1.length()) {
            return v5 + v1.getData$okio().length + " text=" + v3 + v4;
        }

        return "[text=" + v3 + v6;
    }

    public static final String commonUtf8(ByteString arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        String v0 = arg1.getUtf8$okio();
        if(v0 == null) {
            v0 = _JvmPlatformKt.toUtf8String(arg1.internalArray$okio());
            arg1.setUtf8$okio(v0);
        }

        return v0;
    }

    public static final void commonWrite(ByteString arg1, Buffer arg2, int arg3, int arg4) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "buffer");
        arg2.write(arg1.getData$okio(), arg3, arg4);
    }

    public static final char[] getHEX_DIGIT_CHARS() {
        return -ByteString.HEX_DIGIT_CHARS;
    }
}

