package com.TryJeanPc.goldenmouse.stretch.physical;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001A\u00020\u00052\n\u0010\u0006\u001A\u0006\u0012\u0002\b\u00030\u0007J\u000E\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0001¨\u0006\u000B"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/physical/StretchProjectionApply;", "", "<init>", "()V", "method", "Ljava/lang/reflect/Method;", "type", "Ljava/lang/Class;", "invoke", "", "transaction", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchProjectionApply {
    public static final int $stable;
    public static final StretchProjectionApply INSTANCE;

    static {
        StretchProjectionApply.INSTANCE = new StretchProjectionApply();
    }

    private StretchProjectionApply() {
        super();
    }

    public final void invoke(Object arg3) {
        Intrinsics.checkNotNullParameter(arg3, "transaction");
        Method v2 = this.method(arg3.getClass());
        if(v2.getParameterCount() == 1) {
            v2.invoke(arg3, Boolean.valueOf(true));
            return;
        }

        v2.invoke(arg3);
    }

    public final Method method(Class arg4) {
        String v3 = "apply";
        Intrinsics.checkNotNullParameter(arg4, "type");
        try {
            Method v1 = arg4.getMethod(v3, Boolean.TYPE);
            Intrinsics.checkNotNull(v1);
            return v1;
        }
        catch(NoSuchMethodException ) {
            Method v3_1 = arg4.getMethod(v3);
            Intrinsics.checkNotNull(v3_1);
            return v3_1;
        }
    }
}

