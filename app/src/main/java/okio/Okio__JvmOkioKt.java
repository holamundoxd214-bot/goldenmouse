package okio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.internal.DefaultSocket;
import okio.internal.PipeSocket;
import okio.internal.ResourceFileSystem;
import okio.internal.SocketAsyncTimeout;

@Metadata(d1={"\u0000|\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001A\n\u0010\u0000\u001A\u00020\u0001*\u00020\u0002\u001A\n\u0010\u0003\u001A\u00020\u0004*\u00020\u0005\u001A\n\u0010\u0000\u001A\u00020\u0001*\u00020\u0006\u001A\n\u0010\u0003\u001A\u00020\u0004*\u00020\u0006\u001A\u0011\u0010\u0007\u001A\u00020\b*\u00020\u0006H\u0007¢\u0006\u0002\b\t\u001A\u0019\u0010\n\u001A\b\u0012\u0004\u0012\u00020\b0\u000B2\u0006\u0010\f\u001A\u00020\r¢\u0006\u0002\u0010\u000E\u001A\u0016\u0010\u0000\u001A\u00020\u0001*\u00020\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u0011H\u0007\u001A\n\u0010\u0012\u001A\u00020\u0001*\u00020\u000F\u001A\n\u0010\u0003\u001A\u00020\u0004*\u00020\u000F\u001A#\u0010\u0000\u001A\u00020\u0001*\u00020\u00132\u0012\u0010\u0014\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u000B\"\u00020\u0015¢\u0006\u0002\u0010\u0016\u001A#\u0010\u0003\u001A\u00020\u0004*\u00020\u00132\u0012\u0010\u0014\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u000B\"\u00020\u0015¢\u0006\u0002\u0010\u0017\u001A\u0012\u0010\u0018\u001A\u00020\u0019*\u00020\u00012\u0006\u0010\u001A\u001A\u00020\u001B\u001A\u0012\u0010\u001C\u001A\u00020\u001D*\u00020\u00042\u0006\u0010\u001A\u001A\u00020\u001B\u001A\u0012\u0010\u001E\u001A\u00020\u001F*\u00020\u00012\u0006\u0010 \u001A\u00020!\u001A\u0012\u0010\"\u001A\u00020#*\u00020\u00042\u0006\u0010 \u001A\u00020!\u001A\u0012\u0010\u001E\u001A\u00020\u001F*\u00020\u00012\u0006\u0010$\u001A\u00020%\u001A\u0012\u0010\"\u001A\u00020#*\u00020\u00042\u0006\u0010$\u001A\u00020%\u001A\n\u0010&\u001A\u00020\'*\u00020(¨\u0006)"}, d2={"sink", "Lokio/Sink;", "Ljava/io/OutputStream;", "source", "Lokio/Source;", "Ljava/io/InputStream;", "Ljava/net/Socket;", "asOkioSocket", "Lokio/Socket;", "socket", "inMemorySocketPair", "", "maxBufferSize", "", "(J)[Lokio/Socket;", "Ljava/io/File;", "append", "", "appendingSink", "Ljava/nio/file/Path;", "options", "Ljava/nio/file/OpenOption;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Sink;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Source;", "cipherSink", "Lokio/CipherSink;", "cipher", "Ljavax/crypto/Cipher;", "cipherSource", "Lokio/CipherSource;", "hashingSink", "Lokio/HashingSink;", "mac", "Ljavax/crypto/Mac;", "hashingSource", "Lokio/HashingSource;", "digest", "Ljava/security/MessageDigest;", "asResourceFileSystem", "Lokio/FileSystem;", "Ljava/lang/ClassLoader;", "okio"}, k=5, mv={2, 1, 0}, xi=0x30, xs="okio/Okio") final class Okio__JvmOkioKt {
    public static final Sink appendingSink(File arg2) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        return Okio.sink(new FileOutputStream(arg2, true));
    }

    public static final FileSystem asResourceFileSystem(ClassLoader arg7) {
        Intrinsics.checkNotNullParameter(arg7, "<this>");
        return new ResourceFileSystem(arg7, true, null, 4, null);
    }

    public static final CipherSink cipherSink(Sink arg1, Cipher arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "cipher");
        return new CipherSink(Okio.buffer(arg1), arg2);
    }

    public static final CipherSource cipherSource(Source arg1, Cipher arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "cipher");
        return new CipherSource(Okio.buffer(arg1), arg2);
    }

    public static final HashingSink hashingSink(Sink arg1, MessageDigest arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "digest");
        return new HashingSink(arg1, arg2);
    }

    public static final HashingSink hashingSink(Sink arg1, Mac arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "mac");
        return new HashingSink(arg1, arg2);
    }

    public static final HashingSource hashingSource(Source arg1, MessageDigest arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "digest");
        return new HashingSource(arg1, arg2);
    }

    public static final HashingSource hashingSource(Source arg1, Mac arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "mac");
        return new HashingSource(arg1, arg2);
    }

    public static final Socket[] inMemorySocketPair(long arg3) {
        Pipe v0 = new Pipe(arg3);
        Pipe v1 = new Pipe(arg3);
        return new Socket[]{new PipeSocket(v0, v1), new PipeSocket(v1, v0)};
    }

    public static final Sink sink(File arg3) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        return Okio.sink$default(arg3, false, 1, null);
    }

    public static final Sink sink(File arg1, boolean arg2) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return Okio.sink(new FileOutputStream(arg1, arg2));
    }

    public static final Sink sink(OutputStream arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        return new OutputStreamSink(arg2, new Timeout());
    }

    public static final Sink sink(java.net.Socket arg3) throws IOException {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        SocketAsyncTimeout v0 = new SocketAsyncTimeout(arg3);
        OutputStream v3 = arg3.getOutputStream();
        Intrinsics.checkNotNullExpressionValue(v3, "getOutputStream(...)");
        return v0.sink(new OutputStreamSink(v3, v0));
    }

    public static final Sink sink(Path arg1, OpenOption[] arg2) throws IOException {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "options");
        OutputStream v1 = Files.newOutputStream(arg1, Arrays.copyOf(((Object[])arg2), arg2.length));
        Intrinsics.checkNotNullExpressionValue(v1, "newOutputStream(...)");
        return Okio.sink(v1);
    }

    public static Sink sink$default(File arg0, boolean arg1, int arg2, Object arg3) throws FileNotFoundException {
        return Okio.sink(arg0, false);
    }

    public static final Socket socket(java.net.Socket arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return new DefaultSocket(arg1);
    }

    public static final Source source(File arg2) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        return new InputStreamSource(new FileInputStream(arg2), Timeout.NONE);
    }

    public static final Source source(InputStream arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        return new InputStreamSource(arg2, new Timeout());
    }

    public static final Source source(java.net.Socket arg3) throws IOException {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        SocketAsyncTimeout v0 = new SocketAsyncTimeout(arg3);
        InputStream v3 = arg3.getInputStream();
        Intrinsics.checkNotNullExpressionValue(v3, "getInputStream(...)");
        return v0.source(new InputStreamSource(v3, v0));
    }

    public static final Source source(Path arg1, OpenOption[] arg2) throws IOException {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "options");
        InputStream v1 = Files.newInputStream(arg1, Arrays.copyOf(((Object[])arg2), arg2.length));
        Intrinsics.checkNotNullExpressionValue(v1, "newInputStream(...)");
        return Okio.source(v1);
    }
}

