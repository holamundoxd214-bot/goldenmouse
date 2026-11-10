package androidx.core.os;

import android.os.PersistableBundle;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\t2\b\u0010\n\u001A\u0004\u0018\u00010\u0001H\u0007¨\u0006\u000B"}, d2={"Landroidx/core/os/PersistableBundleApi21ImplKt;", "", "<init>", "()V", "putValue", "", "persistableBundle", "Landroid/os/PersistableBundle;", "key", "", "value", "core"}, k=1, mv={2, 1, 0}, xi=0x30) final class PersistableBundleApi21ImplKt {
    public static final PersistableBundleApi21ImplKt INSTANCE;

    static {
        PersistableBundleApi21ImplKt.INSTANCE = new PersistableBundleApi21ImplKt();
    }

    private PersistableBundleApi21ImplKt() {
        super();
    }

    @JvmStatic public static final void putValue(PersistableBundle arg4, String arg5, Object arg6) {
        Intrinsics.checkNotNullParameter(arg4, "persistableBundle");
        if(arg6 == null) {
            arg4.putString(arg5, null);
            return;
        }

        if((arg6 instanceof Boolean)) {
            arg4.putBoolean(arg5, ((Boolean)arg6).booleanValue());
            return;
        }

        if((arg6 instanceof Double)) {
            arg4.putDouble(arg5, ((Number)arg6).doubleValue());
            return;
        }

        if((arg6 instanceof Integer)) {
            arg4.putInt(arg5, ((Number)arg6).intValue());
            return;
        }

        if((arg6 instanceof Long)) {
            arg4.putLong(arg5, ((Number)arg6).longValue());
            return;
        }

        if((arg6 instanceof String)) {
            arg4.putString(arg5, ((String)arg6));
            return;
        }

        if((arg6 instanceof PersistableBundle)) {
            arg4.putPersistableBundle(arg5, ((PersistableBundle)arg6));
            return;
        }

        if((arg6 instanceof boolean[])) {
            arg4.putBooleanArray(arg5, ((boolean[])arg6));
            return;
        }

        if((arg6 instanceof double[])) {
            arg4.putDoubleArray(arg5, ((double[])arg6));
            return;
        }

        if((arg6 instanceof int[])) {
            arg4.putIntArray(arg5, ((int[])arg6));
            return;
        }

        if((arg6 instanceof long[])) {
            arg4.putLongArray(arg5, ((long[])arg6));
            return;
        }

        String v1 = "\"";
        String v2 = " for key \"";
        if((arg6 instanceof Object[])) {
            Class v0 = arg6.getClass().getComponentType();
            Intrinsics.checkNotNull(v0);
            if(String.class.isAssignableFrom(v0)) {
                Intrinsics.checkNotNull(arg6, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                arg4.putStringArray(arg5, ((String[])arg6));
                return;
            }

            throw new IllegalArgumentException("Unsupported value array type " + v0.getCanonicalName() + v2 + arg5 + v1);
        }

        throw new IllegalArgumentException("Unsupported value type " + arg6.getClass().getCanonicalName() + v2 + arg5 + v1);
    }
}

