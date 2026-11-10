package okio;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Deprecated(message="changed in Okio 2.x") @Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0007J \u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\tH\u0007¨\u0006\u000B"}, d2={"Lokio/-DeprecatedUtf8;", "", "<init>", "()V", "size", "", "string", "", "beginIndex", "", "endIndex", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) public final class -DeprecatedUtf8 {
    public static final -DeprecatedUtf8 INSTANCE;

    static {
        -DeprecatedUtf8.INSTANCE = new -DeprecatedUtf8();
    }

    private -DeprecatedUtf8() {
        super();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith="<_subannotation>") public final long size(String arg3) {
        Intrinsics.checkNotNullParameter(arg3, "string");
        return Utf8.size$default(arg3, 0, 0, 3, null);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith="<_subannotation>") public final long size(String arg1, int arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg1, "string");
        return Utf8.size(arg1, arg2, arg3);
    }
}

