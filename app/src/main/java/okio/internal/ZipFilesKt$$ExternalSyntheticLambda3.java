package okio.internal;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import okio.BufferedSource;

public final class ZipFilesKt$$ExternalSyntheticLambda3 implements Function2 {
    public ZipFilesKt$$ExternalSyntheticLambda3(BooleanRef arg1, long arg2, LongRef arg4, BufferedSource arg5, LongRef arg6, LongRef arg7, ObjectRef arg8, ObjectRef arg9, ObjectRef arg10) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg4;
        this.f$3 = arg5;
        this.f$4 = arg6;
        this.f$5 = arg7;
        this.f$6 = arg8;
        this.f$7 = arg9;
        this.f$8 = arg10;
    }

    public final Object invoke(Object arg14, Object arg15) {
        return ZipFilesKt.readCentralDirectoryZipEntry$lambda$1(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, ((Integer)arg14).intValue(), ((Long)arg15).longValue());
    }
}

