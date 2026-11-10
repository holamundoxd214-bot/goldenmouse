package okio;

import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A \u0010\u0000\u001A\u00020\u0001*\u00020\u00022\f\b\u0002\u0010\u0003\u001A\u00060\u0004j\u0002`\u0005H\u0086\b¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2={"inflate", "Lokio/InflaterSource;", "Lokio/Source;", "inflater", "Ljava/util/zip/Inflater;", "Lokio/Inflater;", "(Lokio/Source;Ljava/util/zip/Inflater;)Lokio/InflaterSource;", "okio"}, k=2, mv={2, 1, 0}, xi=0x30) public final class -InflaterSourceExtensions {
    public static final InflaterSource inflate(Source arg1, Inflater arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "inflater");
        return new InflaterSource(arg1, arg2);
    }

    public static InflaterSource inflate$default(Source arg0, Inflater arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = new Inflater();
        }

        Intrinsics.checkNotNullParameter(arg0, "<this>");
        Intrinsics.checkNotNullParameter(arg1, "inflater");
        return new InflaterSource(arg0, arg1);
    }
}

