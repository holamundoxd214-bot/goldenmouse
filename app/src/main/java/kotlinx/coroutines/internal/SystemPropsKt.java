package kotlinx.coroutines.internal;

import kotlin.Metadata;

@Metadata(d1={"kotlinx/coroutines/internal/SystemPropsKt__SystemPropsKt", "kotlinx/coroutines/internal/SystemPropsKt__SystemProps_commonKt"}, k=4, mv={2, 1, 0}, xi=0x30) public final class SystemPropsKt {
    public static final int getAVAILABLE_PROCESSORS() {
        return SystemPropsKt__SystemPropsKt.getAVAILABLE_PROCESSORS();
    }

    public static final String systemProp(String arg0) {
        return SystemPropsKt__SystemPropsKt.systemProp(arg0);
    }

    public static final boolean systemProp(String arg0, boolean arg1) {
        return SystemPropsKt__SystemProps_commonKt.systemProp(arg0, arg1);
    }

    public static final int systemProp(String arg0, int arg1, int arg2, int arg3) {
        return SystemPropsKt__SystemProps_commonKt.systemProp(arg0, arg1, arg2, arg3);
    }

    public static final long systemProp(String arg0, long arg1, long arg3, long arg5) {
        return SystemPropsKt__SystemProps_commonKt.systemProp(arg0, arg1, arg3, arg5);
    }

    public static final String systemProp(String arg0, String arg1) {
        return SystemPropsKt__SystemProps_commonKt.systemProp(arg0, arg1);
    }

    public static int systemProp$default(String arg0, int arg1, int arg2, int arg3, int arg4, Object arg5) {
        return SystemPropsKt__SystemProps_commonKt.systemProp$default(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    public static long systemProp$default(String arg0, long arg1, long arg3, long arg5, int arg7, Object arg8) {
        return SystemPropsKt__SystemProps_commonKt.systemProp$default(arg0, arg1, arg3, arg5, arg7, arg8);
    }
}

