package okio;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.OpenOption;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"okio/Okio__JvmOkioKt", "okio/Okio__OkioKt", "okio/Okio__ZlibOkioKt"}, k=4, mv={2, 1, 0}, xi=0x30) public final class Okio {
    public static final Sink appendingSink(File arg0) throws FileNotFoundException {
        return Okio__JvmOkioKt.appendingSink(arg0);
    }

    public static final FileSystem asResourceFileSystem(ClassLoader arg0) {
        return Okio__JvmOkioKt.asResourceFileSystem(arg0);
    }

    public static final Sink blackhole() {
        return Okio__OkioKt.blackhole();
    }

    public static final BufferedSource buffer(Source arg0) {
        return Okio__OkioKt.buffer(arg0);
    }

    public static final BufferedSink buffer(Sink arg0) {
        return Okio__OkioKt.buffer(arg0);
    }

    public static final CipherSink cipherSink(Sink arg0, Cipher arg1) {
        return Okio__JvmOkioKt.cipherSink(arg0, arg1);
    }

    public static final CipherSource cipherSource(Source arg0, Cipher arg1) {
        return Okio__JvmOkioKt.cipherSource(arg0, arg1);
    }

    public static final HashingSink hashingSink(Sink arg0, MessageDigest arg1) {
        return Okio__JvmOkioKt.hashingSink(arg0, arg1);
    }

    public static final HashingSink hashingSink(Sink arg0, Mac arg1) {
        return Okio__JvmOkioKt.hashingSink(arg0, arg1);
    }

    public static final HashingSource hashingSource(Source arg0, MessageDigest arg1) {
        return Okio__JvmOkioKt.hashingSource(arg0, arg1);
    }

    public static final HashingSource hashingSource(Source arg0, Mac arg1) {
        return Okio__JvmOkioKt.hashingSource(arg0, arg1);
    }

    public static final Socket[] inMemorySocketPair(long arg0) {
        return Okio__JvmOkioKt.inMemorySocketPair(arg0);
    }

    public static final FileSystem openZip(FileSystem arg0, Path arg1) throws IOException {
        return Okio__ZlibOkioKt.openZip(arg0, arg1);
    }

    public static final Sink sink(File arg0, boolean arg1) throws FileNotFoundException {
        return Okio__JvmOkioKt.sink(arg0, arg1);
    }

    public static final Sink sink(OutputStream arg0) {
        return Okio__JvmOkioKt.sink(arg0);
    }

    public static final Sink sink(java.net.Socket arg0) throws IOException {
        return Okio__JvmOkioKt.sink(arg0);
    }

    public static final Sink sink(java.nio.file.Path arg0, OpenOption[] arg1) throws IOException {
        return Okio__JvmOkioKt.sink(arg0, arg1);
    }

    public static final Sink sink(File arg0) throws FileNotFoundException {
        return Okio__JvmOkioKt.sink(arg0);
    }

    public static Sink sink$default(File arg0, boolean arg1, int arg2, Object arg3) throws FileNotFoundException {
        return Okio__JvmOkioKt.sink$default(arg0, arg1, arg2, arg3);
    }

    public static final Socket socket(java.net.Socket arg0) {
        return Okio__JvmOkioKt.socket(arg0);
    }

    public static final Source source(File arg0) throws FileNotFoundException {
        return Okio__JvmOkioKt.source(arg0);
    }

    public static final Source source(InputStream arg0) {
        return Okio__JvmOkioKt.source(arg0);
    }

    public static final Source source(java.net.Socket arg0) throws IOException {
        return Okio__JvmOkioKt.source(arg0);
    }

    public static final Source source(java.nio.file.Path arg0, OpenOption[] arg1) throws IOException {
        return Okio__JvmOkioKt.source(arg0, arg1);
    }

    public static final Object use(Closeable arg0, Function1 arg1) {
        return Okio__OkioKt.use(arg0, arg1);
    }
}

