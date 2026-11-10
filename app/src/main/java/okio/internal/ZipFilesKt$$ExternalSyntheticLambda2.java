package okio.internal;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import okio.BufferedSource;

public final class ZipFilesKt$$ExternalSyntheticLambda2 implements Function2 {
    public ZipFilesKt$$ExternalSyntheticLambda2(BufferedSource arg1, ObjectRef arg2, ObjectRef arg3, ObjectRef arg4) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
    }

    public final Object invoke(Object arg8, Object arg9) {
        return ZipFilesKt.readOrSkipLocalHeader$lambda$0(this.f$0, this.f$1, this.f$2, this.f$3, ((Integer)arg8).intValue(), ((Long)arg9).longValue());
    }
}

