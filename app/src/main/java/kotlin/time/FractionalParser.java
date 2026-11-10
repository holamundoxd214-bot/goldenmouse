package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J@\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2!\u0010\n\u001A\u001D\u0012\u0013\u0012\u00110\t¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000E\u0012\u0004\u0012\u00020\u000F0\u000BH\u0086\u0088\u0004ø\u0001\u0000JA\u0010\u0010\u001A\u00020\t*\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\u0011\u001A\u00020\t2!\u0010\n\u001A\u001D\u0012\u0013\u0012\u00110\t¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000E\u0012\u0004\u0012\u00020\u000F0\u000BH\u0082\u0088\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0012"}, d2={"Lkotlin/time/FractionalParser;", "", "<init>", "()V", "parse", "", "value", "", "startIndex", "", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "endIndex", "", "parseDigits", "maxDigits", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class FractionalParser {
    public static final FractionalParser INSTANCE;

    static {
        FractionalParser.INSTANCE = new FractionalParser();
    }

    private FractionalParser() {
        super();
    }

    public final long parse(String arg9, int arg10, Function1 arg11) {
        int v5;
        Intrinsics.checkNotNullParameter(arg9, "value");
        Intrinsics.checkNotNullParameter(arg11, "callback");
        int v8 = Math.min(arg10 + 6, arg9.length());
        int v0 = 0;
        int v1 = arg10;
        int v2 = 0;
        while(true) {
            int v3 = 58;
            int v4 = 0x30;
            if(v1 < v8) {
                v5 = arg9.charAt(v1);
                if(v4 <= v5 && v5 < v3) {
                    v2 = (v2 << 3) + (v2 << 1) + (v5 - 0x30);
                    ++v1;
                    continue;
                }
            }

            break;
        }

        v8 = 6 - (v1 - arg10);
        for(arg10 = 0; arg10 < v8; ++arg10) {
            v2 = (v2 << 1) + (v2 << 3);
        }

        v8 = Math.min(v1 + 9, arg9.length());
        v5 = 0;
        for(arg10 = v1; arg10 < v8; ++arg10) {
            int v6 = arg9.charAt(arg10);
            if(v4 > v6) {
                break;
            }

            if(v6 >= v3) {
                break;
            }

            v5 = (v5 << 3) + (v5 << 1) + (v6 - 0x30);
        }

        v8 = 9 - (arg10 - v1);
        while(v0 < v8) {
            v5 = (v5 << 1) + (v5 << 3);
            ++v0;
        }

        while(arg10 < arg9.length()) {
            v8 = arg9.charAt(arg10);
            if(v4 > v8) {
                break;
            }

            if(v8 >= v3) {
                break;
            }

            ++arg10;
        }

        arg11.invoke(Integer.valueOf(arg10));
        return (((long)v2)) * 1000000000 + (((long)v5));
    }

    private final int parseDigits(String arg6, int arg7, int arg8, Function1 arg9) {
        int v5 = Math.min(arg7 + arg8, arg6.length());
        int v0 = 0;
        int v1 = arg7;
        int v2 = 0;
        while(v1 < v5) {
            int v3 = arg6.charAt(v1);
            if(0x30 > v3) {
                break;
            }

            if(v3 >= 58) {
                break;
            }

            v2 = (v2 << 3) + (v2 << 1) + (v3 - 0x30);
            ++v1;
        }

        arg8 -= v1 - arg7;
        while(v0 < arg8) {
            v2 = (v2 << 3) + (v2 << 1);
            ++v0;
        }

        arg9.invoke(Integer.valueOf(v1));
        return v2;
    }
}

