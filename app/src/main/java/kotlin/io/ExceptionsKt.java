package kotlin.io;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A&\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\u0010\u0004\u001A\u0004\u0018\u00010\u00032\b\u0010\u0005\u001A\u0004\u0018\u00010\u0001H\u0082\u0080\u0004¨\u0006\u0006"}, d2={"constructMessage", "", "file", "Ljava/io/File;", "other", "reason", "kotlin-stdlib"}, k=2, mv={2, 3, 0}, xi=0x30) public final class ExceptionsKt {
    public static final String access$constructMessage(File arg0, File arg1, String arg2) {
        return ExceptionsKt.constructMessage(arg0, arg1, arg2);
    }

    private static final String constructMessage(File arg2, File arg3, String arg4) {
        StringBuilder v0 = new StringBuilder(arg2.toString());
        if(arg3 != null) {
            v0.append(" -> " + arg3);
        }

        if(arg4 != null) {
            v0.append(": " + arg4);
        }

        String v2 = v0.toString();
        Intrinsics.checkNotNullExpressionValue(v2, "toString(...)");
        return v2;
    }
}

