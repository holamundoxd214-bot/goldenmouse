package okio;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.internal.ZipFilesKt;

@Metadata(d1={"\u0000\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\u0012\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003¨\u0006\u0004"}, d2={"openZip", "Lokio/FileSystem;", "zipPath", "Lokio/Path;", "okio"}, k=5, mv={2, 1, 0}, xi=0x30, xs="okio/Okio") final class Okio__ZlibOkioKt {
    public static final FileSystem openZip(FileSystem arg2, Path arg3) throws IOException {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "zipPath");
        return ZipFilesKt.openZip$default(arg3, arg2, null, 4, null);
    }
}

