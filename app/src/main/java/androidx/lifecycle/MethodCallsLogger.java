package androidx.lifecycle;

import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000E\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u00062\u0006\u0010\u000B\u001A\u00020\u0007H\u0017R\u001A\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2={"Landroidx/lifecycle/MethodCallsLogger;", "", "<init>", "()V", "calledMethods", "", "", "", "approveCall", "", "name", "type", "lifecycle-common"}, k=1, mv={2, 1, 0}, xi=0x30) public class MethodCallsLogger {
    private final Map calledMethods;

    public MethodCallsLogger() {
        super();
        this.calledMethods = new HashMap();
    }

    public boolean approveCall(String arg5, int arg6) {
        Intrinsics.checkNotNullParameter(arg5, "name");
        Object v0 = this.calledMethods.get(arg5);
        int v1 = 0;
        int v0_1 = v0 != null ? ((Integer)v0).intValue() : 0;
        if((v0_1 & arg6) != 0) {
            v1 = 1;
        }

        this.calledMethods.put(arg5, Integer.valueOf(arg6 | v0_1));
        return v1 ^ 1;
    }
}

