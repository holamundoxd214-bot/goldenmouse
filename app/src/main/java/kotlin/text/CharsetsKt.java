package kotlin.text;

import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\u001A\u0012\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0087\u0088\u0004¨\u0006\u0004"}, d2={"charset", "Ljava/nio/charset/Charset;", "charsetName", "", "kotlin-stdlib"}, k=2, mv={2, 3, 0}, xi=0x30) public final class CharsetsKt {
    private static final Charset charset(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "charsetName");
        Charset v1 = Charset.forName(arg1);
        Intrinsics.checkNotNullExpressionValue(v1, "forName(...)");
        return v1;
    }
}

