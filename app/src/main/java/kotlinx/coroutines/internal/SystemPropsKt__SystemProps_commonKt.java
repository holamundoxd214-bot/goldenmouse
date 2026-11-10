package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000\u001C\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u001A\u0018\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0001H\u0000\u001A,\u0010\u0000\u001A\u00020\u00052\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\u0005H\u0000\u001A,\u0010\u0000\u001A\u00020\b2\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\b2\b\b\u0002\u0010\u0006\u001A\u00020\b2\b\b\u0002\u0010\u0007\u001A\u00020\bH\u0000\u001A\u0018\u0010\u0000\u001A\u00020\u00032\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0003H\u0000¨\u0006\t"}, d2={"systemProp", "", "propertyName", "", "defaultValue", "", "minValue", "maxValue", "", "kotlinx-coroutines-core"}, k=5, mv={2, 1, 0}, xi=0x30, xs="kotlinx/coroutines/internal/SystemPropsKt") final class SystemPropsKt__SystemProps_commonKt {
    public static final int systemProp(String arg7, int arg8, int arg9, int arg10) {
        return ((int)SystemPropsKt.systemProp(arg7, ((long)arg8), ((long)arg9), ((long)arg10)));
    }

    public static final long systemProp(String arg4, long arg5, long arg7, long arg9) {
        String v0 = SystemPropsKt.systemProp(arg4);
        if(v0 == null) {
            return arg5;
        }

        Long v5 = StringsKt.toLongOrNull(v0);
        char v6 = '\'';
        String v1 = "System property \'";
        if(v5 != null) {
            long v2 = v5.longValue();
            if(arg7 <= v2 && v2 <= arg9) {
                return v2;
            }

            throw new IllegalStateException(v1 + arg4 + "\' should be in range " + arg7 + ".." + arg9 + ", but is \'" + v2 + v6.toString());
        }

        throw new IllegalStateException(v1 + arg4 + "\' has unrecognized value \'" + v0 + v6.toString());
    }

    public static final String systemProp(String arg0, String arg1) {
        arg0 = SystemPropsKt.systemProp(arg0);
        if(arg0 == null) {
            return arg1;
        }

        return arg0;
    }

    public static final boolean systemProp(String arg0, boolean arg1) {
        arg0 = SystemPropsKt.systemProp(arg0);
        if(arg0 != null) {
            return Boolean.parseBoolean(arg0);
        }

        return arg1;
    }

    public static int systemProp$default(String arg0, int arg1, int arg2, int arg3, int arg4, Object arg5) {
        if((arg4 & 8) != 0) {
            arg3 = 0x7FFFFFFF;
        }

        return SystemPropsKt.systemProp(arg0, arg1, 1, arg3);
    }

    public static long systemProp$default(String arg7, long arg8, long arg10, long arg12, int arg14, Object arg15) {
        if((arg14 & 4) != 0) {
            arg10 = 1;
        }

        long v3 = arg10;
        if((arg14 & 8) != 0) {
            arg12 = 0x7FFFFFFFFFFFFFFFL;
        }

        return SystemPropsKt.systemProp(arg7, arg8, v3, arg12);
    }
}

