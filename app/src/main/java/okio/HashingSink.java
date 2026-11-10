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

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 \u001B2\u00020\u00012\u00020\u0002:\u0001\u001BB\u0019\b\u0010\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0010\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0004\b\u0006\u0010\nB\u0019\b\u0010\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u000B\u001A\u00020\f¢\u0006\u0004\b\u0006\u0010\rB!\b\u0010\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u000E\u001A\u00020\u000F\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0004\b\u0006\u0010\u0010J\u0018\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0017H\u0016J\r\u0010\u0018\u001A\u00020\u000FH\u0007¢\u0006\u0002\b\u001AR\u0010\u0010\u0011\u001A\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000B\u001A\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0018\u001A\u00020\u000F8G¢\u0006\u0006\u001A\u0004\b\u0018\u0010\u0019¨\u0006\u001C"}, d2={"Lokio/HashingSink;", "Lokio/ForwardingSink;", "Lokio/Sink;", "sink", "digest", "Ljava/security/MessageDigest;", "<init>", "(Lokio/Sink;Ljava/security/MessageDigest;)V", "algorithm", "", "(Lokio/Sink;Ljava/lang/String;)V", "mac", "Ljavax/crypto/Mac;", "(Lokio/Sink;Ljavax/crypto/Mac;)V", "key", "Lokio/ByteString;", "(Lokio/Sink;Lokio/ByteString;Ljava/lang/String;)V", "messageDigest", "write", "", "source", "Lokio/Buffer;", "byteCount", "", "hash", "()Lokio/ByteString;", "-deprecated_hash", "Companion", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) public final class HashingSink extends ForwardingSink implements Sink {
    @Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0007J\u0010\u0010\b\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0007J\u0010\u0010\t\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0007J\u0010\u0010\n\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0007J\u0018\u0010\u000B\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\rH\u0007J\u0018\u0010\u000E\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\rH\u0007J\u0018\u0010\u000F\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\rH\u0007¨\u0006\u0010"}, d2={"Lokio/HashingSink$Companion;", "", "<init>", "()V", "md5", "Lokio/HashingSink;", "sink", "Lokio/Sink;", "sha1", "sha256", "sha512", "hmacSha1", "key", "Lokio/ByteString;", "hmacSha256", "hmacSha512", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        @JvmStatic public final HashingSink hmacSha1(Sink arg2, ByteString arg3) {
            Intrinsics.checkNotNullParameter(arg2, "sink");
            Intrinsics.checkNotNullParameter(arg3, "key");
            return new HashingSink(arg2, arg3, "HmacSHA1");
        }

        @JvmStatic public final HashingSink hmacSha256(Sink arg2, ByteString arg3) {
            Intrinsics.checkNotNullParameter(arg2, "sink");
            Intrinsics.checkNotNullParameter(arg3, "key");
            return new HashingSink(arg2, arg3, "HmacSHA256");
        }

        @JvmStatic public final HashingSink hmacSha512(Sink arg2, ByteString arg3) {
            Intrinsics.checkNotNullParameter(arg2, "sink");
            Intrinsics.checkNotNullParameter(arg3, "key");
            return new HashingSink(arg2, arg3, "HmacSHA512");
        }

        @JvmStatic public final HashingSink md5(Sink arg2) {
            Intrinsics.checkNotNullParameter(arg2, "sink");
            return new HashingSink(arg2, "MD5");
        }

        @JvmStatic public final HashingSink sha1(Sink arg2) {
            Intrinsics.checkNotNullParameter(arg2, "sink");
            return new HashingSink(arg2, "SHA-1");
        }

        @JvmStatic public final HashingSink sha256(Sink arg2) {
            Intrinsics.checkNotNullParameter(arg2, "sink");
            return new HashingSink(arg2, "SHA-256");
        }

        @JvmStatic public final HashingSink sha512(Sink arg2) {
            Intrinsics.checkNotNullParameter(arg2, "sink");
            return new HashingSink(arg2, "SHA-512");
        }
    }

    public static final Companion Companion;
    private final Mac mac;
    private final MessageDigest messageDigest;

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith="<_subannotation>") public final ByteString -deprecated_hash() {
        return this.hash();
    }

    static {
        HashingSink.Companion = new Companion(null);
    }

    public HashingSink(Sink arg2, String arg3) {
        Intrinsics.checkNotNullParameter(arg2, "sink");
        Intrinsics.checkNotNullParameter(arg3, "algorithm");
        MessageDigest v3 = MessageDigest.getInstance(arg3);
        Intrinsics.checkNotNullExpressionValue(v3, "getInstance(...)");
        this(arg2, v3);
    }

    public HashingSink(Sink arg2, MessageDigest arg3) {
        Intrinsics.checkNotNullParameter(arg2, "sink");
        Intrinsics.checkNotNullParameter(arg3, "digest");
        super(arg2);
        this.messageDigest = arg3;
        this.mac = null;
    }

    public HashingSink(Sink arg2, Mac arg3) {
        Intrinsics.checkNotNullParameter(arg2, "sink");
        Intrinsics.checkNotNullParameter(arg3, "mac");
        super(arg2);
        this.mac = arg3;
        this.messageDigest = null;
    }

    public HashingSink(Sink arg3, ByteString arg4, String arg5) {
        Mac v0;
        Intrinsics.checkNotNullParameter(arg3, "sink");
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

    @JvmStatic public static final HashingSink hmacSha1(Sink arg1, ByteString arg2) {
        return HashingSink.Companion.hmacSha1(arg1, arg2);
    }

    @JvmStatic public static final HashingSink hmacSha256(Sink arg1, ByteString arg2) {
        return HashingSink.Companion.hmacSha256(arg1, arg2);
    }

    @JvmStatic public static final HashingSink hmacSha512(Sink arg1, ByteString arg2) {
        return HashingSink.Companion.hmacSha512(arg1, arg2);
    }

    @JvmStatic public static final HashingSink md5(Sink arg1) {
        return HashingSink.Companion.md5(arg1);
    }

    @JvmStatic public static final HashingSink sha1(Sink arg1) {
        return HashingSink.Companion.sha1(arg1);
    }

    @JvmStatic public static final HashingSink sha256(Sink arg1) {
        return HashingSink.Companion.sha256(arg1);
    }

    @JvmStatic public static final HashingSink sha512(Sink arg1) {
        return HashingSink.Companion.sha512(arg1);
    }

    public void write(Buffer arg10, long arg11) throws IOException {
        Intrinsics.checkNotNullParameter(arg10, "source");
        long v5 = arg11;
        -SegmentedByteString.checkOffsetAndCount(arg10.size(), 0, v5);
        Segment v11 = arg10.head;
        Intrinsics.checkNotNull(v11);
        long v0 = 0;
        while(v0 < v5) {
            int v12 = ((int)Math.min(v5 - v0, ((long)(v11.limit - v11.pos))));
            MessageDigest v2 = this.messageDigest;
            if(v2 != null) {
                v2.update(v11.data, v11.pos, v12);
            }
            else {
                Mac v2_1 = this.mac;
                Intrinsics.checkNotNull(v2_1);
                v2_1.update(v11.data, v11.pos, v12);
            }

            v0 += ((long)v12);
            v11 = v11.next;
            Intrinsics.checkNotNull(v11);
        }

        super.write(arg10, v5);
    }
}

