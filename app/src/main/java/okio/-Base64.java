package okio;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0012\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0003\u001A\u000E\u0010\u0006\u001A\u0004\u0018\u00010\u0001*\u00020\u0007H\u0000\u001A\u0016\u0010\b\u001A\u00020\u0007*\u00020\u00012\b\b\u0002\u0010\t\u001A\u00020\u0001H\u0000\"\u0014\u0010\u0000\u001A\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001A\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0003¨\u0006\n"}, d2={"BASE64", "", "getBASE64", "()[B", "BASE64_URL_SAFE", "getBASE64_URL_SAFE", "decodeBase64ToArray", "", "encodeBase64", "map", "okio"}, k=2, mv={2, 1, 0}, xi=0x30) public final class -Base64 {
    private static final byte[] BASE64;
    private static final byte[] BASE64_URL_SAFE;

    static {
        -Base64.BASE64 = ByteString.Companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").getData$okio();
        -Base64.BASE64_URL_SAFE = ByteString.Companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").getData$okio();
    }

    public static final byte[] decodeBase64ToArray(String arg14) {
        byte[] v11;
        int v5;
        Intrinsics.checkNotNullParameter(arg14, "<this>");
        int v0 = arg14.length();
        while(true) {
            int v1 = 9;
            int v2 = 0x20;
            int v3 = 13;
            int v4 = 10;
            if(v0 > 0) {
                v5 = arg14.charAt(v0 - 1);
                if(v5 != 61 && v5 != v4 && v5 != v3 && v5 != v2 && v5 != v1) {
                    break;
                }

                --v0;
                continue;
            }

            break;
        }

        v5 = ((int)((((long)v0)) * 6 / 8));
        byte[] v6 = new byte[v5];
        int v7 = 0;
        int v8 = 0;
        int v9 = 0;
        int v10 = 0;
        while(true) {
            v11 = null;
            if(v7 >= v0) {
                break;
            }

            int v12 = arg14.charAt(v7);
            if(65 > v12 || v12 >= 91) {
                if(97 <= v12 && v12 < 0x7B) {
                    v12 += -71;
                    goto label_70;
                }

                if(0x30 <= v12 && v12 < 58) {
                    v12 += 4;
                    goto label_70;
                }

                if(v12 != 43) {
                    if(v12 == 45) {
                    }
                    else {
                        if(v12 != 0x2F) {
                            if(v12 == 0x5F) {
                            }
                            else if(v12 == v4) {
                                goto label_86;
                            }
                            else if(v12 == v3) {
                                goto label_86;
                            }
                            else if(v12 == v2) {
                                goto label_86;
                            }
                            else if(v12 == v1) {
                                goto label_86;
                            }
                            else {
                                return v11;
                            }
                        }

                        v12 = 0x3F;
                        goto label_70;
                    }
                }

                v12 = 62;
            label_70:
                v9 = v9 << 6 | v12;
                ++v8;
                if(v8 % 4 != 0) {
                    goto label_86;
                }

                v6[v10] = ((byte)(v9 >> 16));
                v12 = v10 + 2;
                v6[v10 + 1] = ((byte)(v9 >> 8));
                v10 += 3;
                v6[v12] = ((byte)v9);
            }
            else {
                v12 += -65;
                goto label_70;
            }

        label_86:
            ++v7;
        }

        v8 %= 4;
        if(v8 != 1) {
            if(v8 == 2) {
                v6[v10] = ((byte)(v9 << 12 >> 16));
                ++v10;
            }
            else if(v8 != 3) {
            }
            else {
                int v14 = v9 << 6;
                v0 = v10 + 1;
                v6[v10] = ((byte)(v14 >> 16));
                v10 += 2;
                v6[v0] = ((byte)(v14 >> 8));
            }

            if(v10 == v5) {
                return v6;
            }

            byte[] v14_1 = Arrays.copyOf(v6, v10);
            Intrinsics.checkNotNullExpressionValue(v14_1, "copyOf(...)");
            return v14_1;
        }

        return v11;
    }

    public static final String encodeBase64(byte[] arg11, byte[] arg12) {
        int v11;
        int v5;
        Intrinsics.checkNotNullParameter(arg11, "<this>");
        Intrinsics.checkNotNullParameter(arg12, "map");
        int v1 = 2;
        byte[] v0 = new byte[(arg11.length + v1) / 3 * 4];
        int v2 = arg11.length - arg11.length % 3;
        int v3 = 0;
        int v4 = 0;
        while(v3 < v2) {
            int v6 = arg11[v3];
            int v7 = v3 + 2;
            v5 = arg11[v3 + 1];
            v3 += 3;
            v7 = arg11[v7];
            v0[v4] = arg12[(v6 & 0xFF) >> v1];
            v0[v4 + 1] = arg12[(v6 & 3) << 4 | (v5 & 0xFF) >> 4];
            v6 = v4 + 3;
            v0[v4 + 2] = arg12[(v5 & 15) << v1 | (v7 & 0xFF) >> 6];
            v4 += 4;
            v0[v6] = arg12[v7 & 0x3F];
        }

        v5 = arg11.length - v2;
        byte v2_1 = 61;
        if(v5 == 1) {
            v11 = arg11[v3];
            v0[v4] = arg12[(v11 & 0xFF) >> 2];
            v0[v4 + 1] = arg12[(v11 & 3) << 4];
            v0[v4 + 2] = v2_1;
            v0[v4 + 3] = v2_1;
        }
        else if(v5 != v1) {
        }
        else {
            v5 = v3 + 1;
            v3 = arg11[v3];
            v11 = arg11[v5];
            v0[v4] = arg12[(v3 & 0xFF) >> v1];
            v0[v4 + 1] = arg12[(v3 & 3) << 4 | (v11 & 0xFF) >> 4];
            v0[v4 + 2] = arg12[(v11 & 15) << v1];
            v0[v4 + 3] = v2_1;
        }

        return _JvmPlatformKt.toUtf8String(v0);
    }

    public static String encodeBase64$default(byte[] arg0, byte[] arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = -Base64.BASE64;
        }

        return -Base64.encodeBase64(arg0, arg1);
    }

    public static final byte[] getBASE64() {
        return -Base64.BASE64;
    }

    public static final byte[] getBASE64_URL_SAFE() {
        return -Base64.BASE64_URL_SAFE;
    }
}

