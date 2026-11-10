package okio;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001C\u0010\u0000\u001A\u00020\u0001*\u00020\u00028Æ\u0002¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001A\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2={"SYSTEM", "Lokio/FileSystem;", "Lokio/FileSystem$Companion;", "getSYSTEM$annotations", "(Lokio/FileSystem$Companion;)V", "getSYSTEM", "(Lokio/FileSystem$Companion;)Lokio/FileSystem;", "okio"}, k=2, mv={2, 1, 0}, xi=0x30) public final class SystemFileSystem {
    public static final FileSystem getSYSTEM(Companion arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return FileSystem.SYSTEM;
    }

    public static void getSYSTEM$annotations(Companion arg0) {
    }
}

