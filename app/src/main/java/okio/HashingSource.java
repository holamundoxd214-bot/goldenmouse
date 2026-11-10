package okio;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001A2\u00020\u00012\u00020\u0002:\u0001\u001AB\u0019\b\u0010\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0010\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0004\b\u0006\u0010\nB\u0019\b\u0010\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u000B\u001A\u00020\f¢\u0006\u0004\b\u0006\u0010\rB!\b\u0010\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u000E\u001A\u00020\u000F\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0004\b\u0006\u0010\u0010J\u0018\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0013H\u0016J\r\u0010\u0017\u001A\u00020\u000FH\u0007¢\u0006\u0002\b\u0019R\u0010\u0010\u0011\u001A\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000B\u001A\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001A\u00020\u000F8G¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0018¨\u0006\u001B"}, d2={"Lokio/HashingSource;", "Lokio/ForwardingSource;", "Lokio/Source;", "source", "digest", "Ljava/security/MessageDigest;", "<init>", "(Lokio/Source;Ljava/security/MessageDigest;)V", "algorithm", "", "(Lokio/Source;Ljava/lang/String;)V", "mac", "Ljavax/crypto/Mac;", "(Lokio/Source;Ljavax/crypto/Mac;)V", "key", "Lokio/ByteString;", "(Lokio/Source;Lokio/ByteString;Ljava/lang/String;)V", "messageDigest", "read", "", "sink", "Lokio/Buffer;", "byteCount", "hash", "()Lokio/ByteString;", "-deprecated_hash", "Companion", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) public final class HashingSource extends ForwardingSource implements Source {
    @Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0007J\u0010\u0010\b\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0007J\u0010\u0010\t\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0007J\u0010\u0010\n\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0007J\u0018\u0010\u000B\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\rH\u0007J\u0018\u0010\u000E\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\rH\u0007J\u0018\u0010\u000F\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\rH\u0007¨\u0006\u0010"}, d2={"Lokio/HashingSource$Companion;", "", "<init>", "()V", "md5", "Lokio/HashingSource;", "source", "Lokio/Source;", "sha1", "sha256", "sha512", "hmacSha1", "key", "Lokio/ByteString;", "hmacSha256", "hmacSha512", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        @JvmStatic public final HashingSource hmacSha1(Source arg2, ByteString arg3) {
            Intrinsics.checkNotNullParameter(arg2, "source");
            Intrinsics.checkNotNullParameter(arg3, "key");
            return new HashingSource(arg2, arg3, "HmacSHA1");
        }

        @JvmStatic public final HashingSource hmacSha256(Source arg2, ByteString arg3) {
            Intrinsics.checkNotNullParameter(arg2, "source");
            Intrinsics.checkNotNullParameter(arg3, "key");
            return new HashingSource(arg2, arg3, "HmacSHA256");
        }

        @JvmStatic public final HashingSource hmacSha512(Source arg2, ByteString arg3) {
            Intrinsics.checkNotNullParameter(arg2, "source");
            Intrinsics.checkNotNullParameter(arg3, "key");
            return new HashingSource(arg2, arg3, "HmacSHA512");
        }

        @JvmStatic public final HashingSource md5(Source arg2) {
            Intrinsics.checkNotNullParameter(arg2, "source");
            return new HashingSource(arg2, "MD5");
        }

        @JvmStatic public final HashingSource sha1(Source arg2) {
            Intrinsics.checkNotNullParameter(arg2, "source");
            return new HashingSource(arg2, "SHA-1");
        }

        @JvmStatic public final HashingSource sha256(Source arg2) {
            Intrinsics.checkNotNullParameter(arg2, "source");
            return new HashingSource(arg2, "SHA-256");
        }

        @JvmStatic public final HashingSource sha512(Source arg2) {
            Intrinsics.checkNotNullParameter(arg2, "source");
            return new HashingSource(arg2, "SHA-512");
        }
    }

    public static final Companion Companion;
    private final Mac mac;
    private final MessageDigest messageDigest;

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith="<_subannotation>") public final ByteString -deprecated_hash() {
        return this.hash();
    }

    static {
        HashingSource.Companion = new Companion(null);
    }

    public HashingSource(Source arg2, String arg3) {
        Intrinsics.checkNotNullParameter(arg2, "source");
        Intrinsics.checkNotNullParameter(arg3, "algorithm");
        MessageDigest v3 = MessageDigest.getInstance(arg3);
        Intrinsics.checkNotNullExpressionValue(v3, "getInstance(...)");
        this(arg2, v3);
    }

    public HashingSource(Source arg2, MessageDigest arg3) {
        Intrinsics.checkNotNullParameter(arg2, "source");
        Intrinsics.checkNotNullParameter(arg3, "digest");
        super(arg2);
        this.messageDigest = arg3;
        this.mac = null;
    }

    public HashingSource(Source arg2, Mac arg3) {
        Intrinsics.checkNotNullParameter(arg2, "source");
        Intrinsics.checkNotNullParameter(arg3, "mac");
        super(arg2);
        this.mac = arg3;
        this.messageDigest = null;
    }

    public HashingSource(Source arg3, ByteString arg4, String arg5) {
        Mac v0;
        Intrinsics.checkNotNullParameter(arg3, "source");
        Intrinsics.checkNotNullParameter(arg4, "key");
        Intrinsics.checkNotNullParameter(arg5, "algorithm");
        try {
            v0 = Mac.getInstance(arg5);
            v0.init(new SecretKeySpec(arg4.toByteArray(), arg5));
        }
        catch(InvalidKeyException v2) {
            throw new IllegalArgumentException(((Throwable)v2));
        }

        Intrinsics.checkNotNull(v0);
        this(arg3, v0);
    }

    public final ByteString hash() {
        byte[] v1;
        MessageDigest v0 = this.messageDigest;
        if(v0 != null) {
            v1 = v0.digest();
        }
        else {
            Mac v1_1 = this.mac;
            Intrinsics.checkNotNull(v1_1);
            v1 = v1_1.doFinal();
        }

        Intrinsics.checkNotNull(v1);
        return new ByteString(v1);
    }

    @JvmStatic public static final HashingSource hmacSha1(Source arg1, ByteString arg2) {
        return HashingSource.Companion.hmacSha1(arg1, arg2);
    }

    @JvmStatic public static final HashingSource hmacSha256(Source arg1, ByteString arg2) {
        return HashingSource.Companion.hmacSha256(arg1, arg2);
    }

    @JvmStatic public static final HashingSource hmacSha512(Source arg1, ByteString arg2) {
        return HashingSource.Companion.hmacSha512(arg1, arg2);
    }

    @JvmStatic public static final HashingSource md5(Source arg1) {
        return HashingSource.Companion.md5(arg1);
    }

    public long read(Buffer arg8, long arg9) throws IOException {
        Intrinsics.checkNotNullParameter(arg8, "sink");
        arg9 = super.read(arg8, arg9);
        if(arg9 != -1) {
            long v0 = arg8.size() - arg9;
            long v2 = arg8.size();
            Segment v4 = arg8.head;
            Intrinsics.checkNotNull(v4);
            while(v2 > v0) {
                v4 = v4.prev;
                Intrinsics.checkNotNull(v4);
                v2 -= ((long)(v4.limit - v4.pos));
            }

            while(v2 < arg8.size()) {
                int v0_1 = ((int)((((long)v4.pos)) + v0 - v2));
                MessageDigest v1 = this.messageDigest;
                if(v1 != null) {
                    v1.update(v4.data, v0_1, v4.limit - v0_1);
                }
                else {
                    Mac v1_1 = this.mac;
                    Intrinsics.checkNotNull(v1_1);
                    v1_1.update(v4.data, v0_1, v4.limit - v0_1);
                }

                v2 += ((long)(v4.limit - v4.pos));
                v4 = v4.next;
                Intrinsics.checkNotNull(v4);
                v0 = v2;
            }
        }

        return arg9;
    }

    @JvmStatic public static final HashingSource sha1(Source arg1) {
        return HashingSource.Companion.sha1(arg1);
    }

    @JvmStatic public static final HashingSource sha256(Source arg1) {
        return HashingSource.Companion.sha256(arg1);
    }

    @JvmStatic public static final HashingSource sha512(Source arg1) {
        return HashingSource.Companion.sha512(arg1);
    }
}

