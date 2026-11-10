package okio;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Deprecated(message="changed in Okio 2.x") @Metadata(d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0007J\u0010\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0005H\u0007J\u0010\u0010\b\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\rH\u0007J\u0010\u0010\n\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0007J\u0010\u0010\n\u001A\u00020\u00052\u0006\u0010\u000E\u001A\u00020\u000FH\u0007J)\u0010\n\u001A\u00020\u00052\u0006\u0010\u0010\u001A\u00020\u00112\u0012\u0010\u0012\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0007¢\u0006\u0002\u0010\u0015J\u0010\u0010\n\u001A\u00020\u00052\u0006\u0010\u0016\u001A\u00020\u0017H\u0007J\u0010\u0010\f\u001A\u00020\r2\u0006\u0010\u0006\u001A\u00020\u0007H\u0007J\u0010\u0010\f\u001A\u00020\r2\u0006\u0010\u0018\u001A\u00020\u0019H\u0007J)\u0010\f\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\u00112\u0012\u0010\u0012\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0007¢\u0006\u0002\u0010\u001AJ\u0010\u0010\f\u001A\u00020\r2\u0006\u0010\u0016\u001A\u00020\u0017H\u0007J\b\u0010\u001B\u001A\u00020\u0005H\u0007¨\u0006\u001C"}, d2={"Lokio/-DeprecatedOkio;", "", "<init>", "()V", "appendingSink", "Lokio/Sink;", "file", "Ljava/io/File;", "buffer", "Lokio/BufferedSink;", "sink", "Lokio/BufferedSource;", "source", "Lokio/Source;", "outputStream", "Ljava/io/OutputStream;", "path", "Ljava/nio/file/Path;", "options", "", "Ljava/nio/file/OpenOption;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Sink;", "socket", "Ljava/net/Socket;", "inputStream", "Ljava/io/InputStream;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Source;", "blackhole", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) public final class -DeprecatedOkio {
    public static final -DeprecatedOkio INSTANCE;

    static {
        -DeprecatedOkio.INSTANCE = new -DeprecatedOkio();
    }

    private -DeprecatedOkio() {
        super();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith="<_subannotation>") public final Sink appendingSink(File arg1) {
        Intrinsics.checkNotNullParameter(arg1, "file");
        return Okio.appendingSink(arg1);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith="<_subannotation>") public final Sink blackhole() {
        return Okio.blackhole();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith="<_subannotation>") public final BufferedSink buffer(Sink arg1) {
        Intrinsics.checkNotNullParameter(arg1, "sink");
        return Okio.buffer(arg1);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith="<_subannotation>") public final BufferedSource buffer(Source arg1) {
        Intrinsics.checkNotNullParameter(arg1, "source");
        return Okio.buffer(arg1);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith="<_subannotation>") public final Sink sink(File arg3) {
        Intrinsics.checkNotNullParameter(arg3, "file");
        return Okio.sink$default(arg3, false, 1, null);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith="<_subannotation>") public final Sink sink(OutputStream arg1) {
        Intrinsics.checkNotNullParameter(arg1, "outputStream");
        return Okio.sink(arg1);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith="<_subannotation>") public final Sink sink(Socket arg1) {
        Intrinsics.checkNotNullParameter(arg1, "socket");
        return Okio.sink(arg1);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith="<_subannotation>") public final Sink sink(Path arg1, OpenOption[] arg2) {
        Intrinsics.checkNotNullParameter(arg1, "path");
        Intrinsics.checkNotNullParameter(arg2, "options");
        return Okio.sink(arg1, Arrays.copyOf(((Object[])arg2), arg2.length));
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith="<_subannotation>") public final Source source(File arg1) {
        Intrinsics.checkNotNullParameter(arg1, "file");
        return Okio.source(arg1);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith="<_subannotation>") public final Source source(InputStream arg1) {
        Intrinsics.checkNotNullParameter(arg1, "inputStream");
        return Okio.source(arg1);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith="<_subannotation>") public final Source source(Socket arg1) {
        Intrinsics.checkNotNullParameter(arg1, "socket");
        return Okio.source(arg1);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith="<_subannotation>") public final Source source(Path arg1, OpenOption[] arg2) {
        Intrinsics.checkNotNullParameter(arg1, "path");
        Intrinsics.checkNotNullParameter(arg2, "options");
        return Okio.source(arg1, Arrays.copyOf(((Object[])arg2), arg2.length));
    }
}

