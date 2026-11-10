package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import okio.internal.-ByteString;
import okio.internal.-ByteStringNonJs;

@Metadata(d1={"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000F\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0005\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 ^2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001^B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u000F\u001A\u00020\u0010H\u0016J\u0010\u0010\u0015\u001A\u00020\u00102\u0006\u0010\u0016\u001A\u00020\u0017H\u0016J\b\u0010\u0018\u001A\u00020\u0010H\u0016J\u0006\u0010\u0019\u001A\u00020\u0000J\u0006\u0010\u001A\u001A\u00020\u0000J\u0006\u0010\u001B\u001A\u00020\u0000J\u0006\u0010\u001C\u001A\u00020\u0000J\u0015\u0010\u001D\u001A\u00020\u00002\u0006\u0010\u001E\u001A\u00020\u0010H\u0010¢\u0006\u0002\b\u001FJ\u0010\u0010 \u001A\u00020\u00002\u0006\u0010!\u001A\u00020\u0000H\u0016J\u0010\u0010\"\u001A\u00020\u00002\u0006\u0010!\u001A\u00020\u0000H\u0016J\u0010\u0010#\u001A\u00020\u00002\u0006\u0010!\u001A\u00020\u0000H\u0016J\u001D\u0010$\u001A\u00020\u00002\u0006\u0010\u001E\u001A\u00020\u00102\u0006\u0010!\u001A\u00020\u0000H\u0010¢\u0006\u0002\b%J\b\u0010&\u001A\u00020\u0010H\u0016J\b\u0010\'\u001A\u00020\u0010H\u0016J\b\u0010(\u001A\u00020\u0000H\u0016J\b\u0010)\u001A\u00020\u0000H\u0016J\u001C\u0010*\u001A\u00020\u00002\b\b\u0002\u0010+\u001A\u00020\n2\b\b\u0002\u0010,\u001A\u00020\nH\u0017J\u0015\u0010-\u001A\u00020.2\u0006\u0010/\u001A\u00020\nH\u0010¢\u0006\u0002\b0J\u0016\u00101\u001A\u00020.2\u0006\u00102\u001A\u00020\nH\u0087\u0002¢\u0006\u0002\b3J\r\u00105\u001A\u00020\nH\u0010¢\u0006\u0002\b6J\b\u00107\u001A\u00020\u0004H\u0016J\r\u00108\u001A\u00020\u0004H\u0010¢\u0006\u0002\b9J\b\u0010:\u001A\u00020;H\u0016J\u0010\u0010<\u001A\u00020=2\u0006\u0010>\u001A\u00020?H\u0016J%\u0010<\u001A\u00020=2\u0006\u0010@\u001A\u00020A2\u0006\u0010B\u001A\u00020\n2\u0006\u0010C\u001A\u00020\nH\u0010¢\u0006\u0002\bDJ(\u0010E\u001A\u00020F2\u0006\u0010B\u001A\u00020\n2\u0006\u0010G\u001A\u00020\u00002\u0006\u0010H\u001A\u00020\n2\u0006\u0010C\u001A\u00020\nH\u0016J(\u0010E\u001A\u00020F2\u0006\u0010B\u001A\u00020\n2\u0006\u0010G\u001A\u00020\u00042\u0006\u0010H\u001A\u00020\n2\u0006\u0010C\u001A\u00020\nH\u0016J,\u0010I\u001A\u00020=2\b\b\u0002\u0010B\u001A\u00020\n2\u0006\u0010J\u001A\u00020\u00042\b\b\u0002\u0010K\u001A\u00020\n2\u0006\u0010C\u001A\u00020\nH\u0016J\u000E\u0010L\u001A\u00020F2\u0006\u0010M\u001A\u00020\u0000J\u000E\u0010L\u001A\u00020F2\u0006\u0010M\u001A\u00020\u0004J\u000E\u0010N\u001A\u00020F2\u0006\u0010O\u001A\u00020\u0000J\u000E\u0010N\u001A\u00020F2\u0006\u0010O\u001A\u00020\u0004J\u001A\u0010P\u001A\u00020\n2\u0006\u0010G\u001A\u00020\u00002\b\b\u0002\u0010Q\u001A\u00020\nH\u0007J\u001A\u0010P\u001A\u00020\n2\u0006\u0010G\u001A\u00020\u00042\b\b\u0002\u0010Q\u001A\u00020\nH\u0017J\u001A\u0010R\u001A\u00020\n2\u0006\u0010G\u001A\u00020\u00002\b\b\u0002\u0010Q\u001A\u00020\nH\u0007J\u001A\u0010R\u001A\u00020\n2\u0006\u0010G\u001A\u00020\u00042\b\b\u0002\u0010Q\u001A\u00020\nH\u0017J\u0013\u0010S\u001A\u00020F2\b\u0010G\u001A\u0004\u0018\u00010TH\u0096\u0002J\b\u0010\t\u001A\u00020\nH\u0016J\u0011\u0010U\u001A\u00020\n2\u0006\u0010G\u001A\u00020\u0000H\u0096\u0002J\b\u0010V\u001A\u00020\u0010H\u0016J\u0010\u0010W\u001A\u00020=2\u0006\u0010X\u001A\u00020YH\u0002J\u0010\u0010Z\u001A\u00020=2\u0006\u0010>\u001A\u00020[H\u0002J\u0015\u00103\u001A\u00020.2\u0006\u00102\u001A\u00020\nH\u0007¢\u0006\u0002\b\\J\r\u00104\u001A\u00020\nH\u0007¢\u0006\u0002\b]R\u0014\u0010\u0003\u001A\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u001A\u0010\t\u001A\u00020\nX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000ER\u001C\u0010\u000F\u001A\u0004\u0018\u00010\u0010X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u00104\u001A\u00020\n8G¢\u0006\u0006\u001A\u0004\b4\u0010\f¨\u0006_"}, d2={"Lokio/ByteString;", "Ljava/io/Serializable;", "", "data", "", "<init>", "([B)V", "getData$okio", "()[B", "hashCode", "", "getHashCode$okio", "()I", "setHashCode$okio", "(I)V", "utf8", "", "getUtf8$okio", "()Ljava/lang/String;", "setUtf8$okio", "(Ljava/lang/String;)V", "string", "charset", "Ljava/nio/charset/Charset;", "base64", "md5", "sha1", "sha256", "sha512", "digest", "algorithm", "digest$okio", "hmacSha1", "key", "hmacSha256", "hmacSha512", "hmac", "hmac$okio", "base64Url", "hex", "toAsciiLowercase", "toAsciiUppercase", "substring", "beginIndex", "endIndex", "internalGet", "", "pos", "internalGet$okio", "get", "index", "getByte", "size", "getSize", "getSize$okio", "toByteArray", "internalArray", "internalArray$okio", "asByteBuffer", "Ljava/nio/ByteBuffer;", "write", "", "out", "Ljava/io/OutputStream;", "buffer", "Lokio/Buffer;", "offset", "byteCount", "write$okio", "rangeEquals", "", "other", "otherOffset", "copyInto", "target", "targetOffset", "startsWith", "prefix", "endsWith", "suffix", "indexOf", "fromIndex", "lastIndexOf", "equals", "", "compareTo", "toString", "readObject", "in", "Ljava/io/ObjectInputStream;", "writeObject", "Ljava/io/ObjectOutputStream;", "-deprecated_getByte", "-deprecated_size", "Companion", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) public class ByteString implements Serializable, Comparable {
    @Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\b\u001A\u00020\u00072\n\u0010\t\u001A\u00020\n\"\u00020\u000BH\u0007J%\u0010\f\u001A\u00020\u0007*\u00020\n2\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\u000EH\u0007¢\u0006\u0002\b\bJ\u0011\u0010\f\u001A\u00020\u0007*\u00020\u0010H\u0007¢\u0006\u0002\b\bJ\f\u0010\u0011\u001A\u00020\u0007*\u00020\u0012H\u0007J\u001B\u0010\u0013\u001A\u00020\u0007*\u00020\u00122\b\b\u0002\u0010\u0014\u001A\u00020\u0015H\u0007¢\u0006\u0002\b\u0016J\u000E\u0010\u0017\u001A\u0004\u0018\u00010\u0007*\u00020\u0012H\u0007J\f\u0010\u0018\u001A\u00020\u0007*\u00020\u0012H\u0007J\u0019\u0010\u0019\u001A\u00020\u0007*\u00020\u001A2\u0006\u0010\u000F\u001A\u00020\u000EH\u0007¢\u0006\u0002\b\u001BJ\u0017\u0010\u0017\u001A\u0004\u0018\u00010\u00072\u0006\u0010\u001C\u001A\u00020\u0012H\u0007¢\u0006\u0002\b\u001DJ\u0015\u0010\u0018\u001A\u00020\u00072\u0006\u0010\u001C\u001A\u00020\u0012H\u0007¢\u0006\u0002\b\u001EJ\u001D\u0010\u0016\u001A\u00020\u00072\u0006\u0010\u001C\u001A\u00020\u00122\u0006\u0010\u0014\u001A\u00020\u0015H\u0007¢\u0006\u0002\b\u001FJ\u0015\u0010\u0011\u001A\u00020\u00072\u0006\u0010\u001C\u001A\u00020\u0012H\u0007¢\u0006\u0002\b J\u0015\u0010\b\u001A\u00020\u00072\u0006\u0010!\u001A\u00020\u0010H\u0007¢\u0006\u0002\b\"J%\u0010\b\u001A\u00020\u00072\u0006\u0010#\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u000EH\u0007¢\u0006\u0002\b\"J\u001D\u0010\u001B\u001A\u00020\u00072\u0006\u0010$\u001A\u00020\u001A2\u0006\u0010\u000F\u001A\u00020\u000EH\u0007¢\u0006\u0002\b%R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2={"Lokio/ByteString$Companion;", "", "<init>", "()V", "serialVersionUID", "", "EMPTY", "Lokio/ByteString;", "of", "data", "", "", "toByteString", "offset", "", "byteCount", "Ljava/nio/ByteBuffer;", "encodeUtf8", "", "encode", "charset", "Ljava/nio/charset/Charset;", "encodeString", "decodeBase64", "decodeHex", "readByteString", "Ljava/io/InputStream;", "read", "string", "-deprecated_decodeBase64", "-deprecated_decodeHex", "-deprecated_encodeString", "-deprecated_encodeUtf8", "buffer", "-deprecated_of", "array", "inputstream", "-deprecated_read", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
        @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith="<_subannotation>") public final ByteString -deprecated_decodeBase64(String arg2) {
            Intrinsics.checkNotNullParameter(arg2, "string");
            return this.decodeBase64(arg2);
        }

        @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith="<_subannotation>") public final ByteString -deprecated_decodeHex(String arg2) {
            Intrinsics.checkNotNullParameter(arg2, "string");
            return this.decodeHex(arg2);
        }

        @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith="<_subannotation>") public final ByteString -deprecated_encodeString(String arg2, Charset arg3) {
            Intrinsics.checkNotNullParameter(arg2, "string");
            Intrinsics.checkNotNullParameter(arg3, "charset");
            return this.encodeString(arg2, arg3);
        }

        @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith="<_subannotation>") public final ByteString -deprecated_encodeUtf8(String arg2) {
            Intrinsics.checkNotNullParameter(arg2, "string");
            return this.encodeUtf8(arg2);
        }

        @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith="<_subannotation>") public final ByteString -deprecated_of(ByteBuffer arg2) {
            Intrinsics.checkNotNullParameter(arg2, "buffer");
            return this.of(arg2);
        }

        @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith="<_subannotation>") public final ByteString -deprecated_of(byte[] arg2, int arg3, int arg4) {
            Intrinsics.checkNotNullParameter(arg2, "array");
            return this.of(arg2, arg3, arg4);
        }

        @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith="<_subannotation>") public final ByteString -deprecated_read(InputStream arg2, int arg3) {
            Intrinsics.checkNotNullParameter(arg2, "inputstream");
            return this.read(arg2, arg3);
        }

        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        @JvmStatic public final ByteString decodeBase64(String arg1) {
            Intrinsics.checkNotNullParameter(arg1, "<this>");
            byte[] v0 = -Base64.decodeBase64ToArray(arg1);
            if(v0 != null) {
                return new ByteString(v0);
            }

            return null;
        }

        @JvmStatic public final ByteString decodeHex(String arg5) {
            Intrinsics.checkNotNullParameter(arg5, "<this>");
            if(arg5.length() % 2 == 0) {
                int v4 = arg5.length() / 2;
                byte[] v0 = new byte[v4];
                int v1;
                for(v1 = 0; v1 < v4; ++v1) {
                    int v2 = v1 * 2;
                    v0[v1] = ((byte)((-ByteStringNonJs.access$decodeHexDigit(arg5.charAt(v2)) << 4) + -ByteStringNonJs.access$decodeHexDigit(arg5.charAt(v2 + 1))));
                }

                return new ByteString(v0);
            }

            throw new IllegalArgumentException("Unexpected hex string: " + arg5.toString());
        }

        @JvmStatic public final ByteString encodeString(String arg1, Charset arg2) {
            Intrinsics.checkNotNullParameter(arg1, "<this>");
            Intrinsics.checkNotNullParameter(arg2, "charset");
            byte[] v1 = arg1.getBytes(arg2);
            Intrinsics.checkNotNullExpressionValue(v1, "getBytes(...)");
            return new ByteString(v1);
        }

        public static ByteString encodeString$default(Companion arg0, String arg1, Charset arg2, int arg3, Object arg4) {
            if((arg3 & 1) != 0) {
                arg2 = Charsets.UTF_8;
            }

            return arg0.encodeString(arg1, arg2);
        }

        @JvmStatic public final ByteString encodeUtf8(String arg2) {
            Intrinsics.checkNotNullParameter(arg2, "<this>");
            ByteString v1 = new ByteString(_JvmPlatformKt.asUtf8ToByteArray(arg2));
            v1.setUtf8$okio(arg2);
            return v1;
        }

        @JvmStatic public final ByteString of(ByteBuffer arg1) {
            Intrinsics.checkNotNullParameter(arg1, "<this>");
            byte[] v0 = new byte[arg1.remaining()];
            arg1.get(v0);
            return new ByteString(v0);
        }

        @JvmStatic public final ByteString of(byte[] arg2) {
            Intrinsics.checkNotNullParameter(arg2, "data");
            arg2 = Arrays.copyOf(arg2, arg2.length);
            Intrinsics.checkNotNullExpressionValue(arg2, "copyOf(...)");
            return new ByteString(arg2);
        }

        @JvmStatic public final ByteString of(byte[] arg7, int arg8, int arg9) {
            Intrinsics.checkNotNullParameter(arg7, "<this>");
            -SegmentedByteString.checkOffsetAndCount(((long)arg7.length), ((long)arg8), ((long)arg9));
            return new ByteString(ArraysKt.copyOfRange(arg7, arg8, arg9 + arg8));
        }

        public static ByteString of$default(Companion arg0, byte[] arg1, int arg2, int arg3, int arg4, Object arg5) {
            if((arg4 & 2) != 0) {
                arg3 = arg1.length;
            }

            return arg0.of(arg1, 0, arg3);
        }

        @JvmStatic public final ByteString read(InputStream arg4, int arg5) throws IOException {
            Intrinsics.checkNotNullParameter(arg4, "<this>");
            if(arg5 < 0) {
                goto label_18;
            }

            byte[] v3 = new byte[arg5];
            int v0;
            for(v0 = 0; true; v0 += v1) {
                if(v0 >= arg5) {
                    goto label_15;
                }

                int v1 = arg4.read(v3, v0, arg5 - v0);
                if(v1 == -1) {
                    break;
                }
            }

            throw new EOFException();
        label_15:
            return new ByteString(v3);
        label_18:
            throw new IllegalArgumentException("byteCount < 0: " + arg5.toString());
        }
    }

    public static final Companion Companion = null;
    public static final ByteString EMPTY = null;
    private final byte[] data;
    private transient int hashCode;
    private static final long serialVersionUID = 1;
    private transient String utf8;

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to operator function", replaceWith="<_subannotation>") public final byte -deprecated_getByte(int arg1) {
        return this.getByte(arg1);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith="<_subannotation>") public final int -deprecated_size() {
        return this.size();
    }

    static {
        ByteString.Companion = new Companion(null);
        ByteString.EMPTY = new ByteString(new byte[0]);
    }

    public ByteString(byte[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "data");
        super();
        this.data = arg2;
    }

    public ByteBuffer asByteBuffer() {
        ByteBuffer v1 = ByteBuffer.wrap(this.data).asReadOnlyBuffer();
        Intrinsics.checkNotNullExpressionValue(v1, "asReadOnlyBuffer(...)");
        return v1;
    }

    public String base64() {
        return -Base64.encodeBase64$default(this.getData$okio(), null, 1, null);
    }

    public String base64Url() {
        return -Base64.encodeBase64(this.getData$okio(), -Base64.getBASE64_URL_SAFE());
    }

    public int compareTo(Object arg1) {
        return this.compareTo(((ByteString)arg1));
    }

    public int compareTo(ByteString arg10) {
        int v5;
        Intrinsics.checkNotNullParameter(arg10, "other");
        int v0 = this.size();
        int v1 = arg10.size();
        int v2 = Math.min(v0, v1);
        int v4;
        for(v4 = 0; true; ++v4) {
            v5 = -1;
            if(v4 >= v2) {
                goto label_20;
            }

            int v7 = this.getByte(v4) & 0xFF;
            int v8 = arg10.getByte(v4) & 0xFF;
            if(v7 != v8) {
                break;
            }
        }

        if(v7 < v8) {
            return v5;
        }

        return 1;
    label_20:
        if(v0 == v1) {
            return 0;
        }

        if(v0 < v1) {
            return v5;
        }

        return 1;
    }

    public void copyInto(int arg2, byte[] arg3, int arg4, int arg5) {
        Intrinsics.checkNotNullParameter(arg3, "target");
        ArraysKt.copyInto(this.getData$okio(), arg3, arg4, arg2, arg5 + arg2);
    }

    public static void copyInto$default(ByteString arg1, int arg2, byte[] arg3, int arg4, int arg5, int arg6, Object arg7) {
        if(arg7 == null) {
            arg1.copyInto(0, arg3, 0, arg5);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copyInto");
    }

    @JvmStatic public static final ByteString decodeBase64(String arg1) {
        return ByteString.Companion.decodeBase64(arg1);
    }

    @JvmStatic public static final ByteString decodeHex(String arg1) {
        return ByteString.Companion.decodeHex(arg1);
    }

    public ByteString digest$okio(String arg3) {
        Intrinsics.checkNotNullParameter(arg3, "algorithm");
        MessageDigest v3 = MessageDigest.getInstance(arg3);
        v3.update(this.data, 0, this.size());
        byte[] v2 = v3.digest();
        Intrinsics.checkNotNull(v2);
        return new ByteString(v2);
    }

    @JvmStatic public static final ByteString encodeString(String arg1, Charset arg2) {
        return ByteString.Companion.encodeString(arg1, arg2);
    }

    @JvmStatic public static final ByteString encodeUtf8(String arg1) {
        return ByteString.Companion.encodeUtf8(arg1);
    }

    public final boolean endsWith(ByteString arg4) {
        Intrinsics.checkNotNullParameter(arg4, "suffix");
        return this.rangeEquals(this.size() - arg4.size(), arg4, 0, arg4.size());
    }

    public final boolean endsWith(byte[] arg4) {
        Intrinsics.checkNotNullParameter(arg4, "suffix");
        return this.rangeEquals(this.size() - arg4.length, arg4, 0, arg4.length);
    }

    public boolean equals(Object arg5) {
        if((((ByteString)arg5)) == this) {
            return 1;
        }

        if(((arg5 instanceof ByteString)) && ((ByteString)arg5).size() == this.getData$okio().length && (((ByteString)arg5).rangeEquals(0, this.getData$okio(), 0, this.getData$okio().length))) {
            return 1;
        }

        return 0;
    }

    public final byte getByte(int arg1) {
        return this.internalGet$okio(arg1);
    }

    public final byte[] getData$okio() {
        return this.data;
    }

    public final int getHashCode$okio() {
        return this.hashCode;
    }

    public int getSize$okio() {
        return this.getData$okio().length;
    }

    public final String getUtf8$okio() {
        return this.utf8;
    }

    public int hashCode() {
        int v0 = this.getHashCode$okio();
        if(v0 != 0) {
            return v0;
        }

        v0 = Arrays.hashCode(this.getData$okio());
        this.setHashCode$okio(v0);
        return v0;
    }

    public String hex() {
        char[] v0 = new char[this.getData$okio().length * 2];
        byte[] v8 = this.getData$okio();
        int v1 = v8.length;
        int v2 = 0;
        int v3 = 0;
        while(v2 < v1) {
            int v4 = v8[v2];
            int v5 = v3 + 1;
            v0[v3] = -ByteString.getHEX_DIGIT_CHARS()[v4 >> 4 & 15];
            v3 += 2;
            v0[v5] = -ByteString.getHEX_DIGIT_CHARS()[v4 & 15];
            ++v2;
        }

        return StringsKt.concatToString(v0);
    }

    public ByteString hmac$okio(String arg3, ByteString arg4) {
        Intrinsics.checkNotNullParameter(arg3, "algorithm");
        Intrinsics.checkNotNullParameter(arg4, "key");
        try {
            Mac v0 = Mac.getInstance(arg3);
            v0.init(new SecretKeySpec(arg4.toByteArray(), arg3));
            byte[] v2_1 = v0.doFinal(this.data);
            Intrinsics.checkNotNullExpressionValue(v2_1, "doFinal(...)");
            return new ByteString(v2_1);
        }
        catch(InvalidKeyException v2) {
            throw new IllegalArgumentException(((Throwable)v2));
        }
    }

    public ByteString hmacSha1(ByteString arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        return this.hmac$okio("HmacSHA1", arg2);
    }

    public ByteString hmacSha256(ByteString arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        return this.hmac$okio("HmacSHA256", arg2);
    }

    public ByteString hmacSha512(ByteString arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        return this.hmac$okio("HmacSHA512", arg2);
    }

    public final int indexOf(ByteString arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "other");
        return this.indexOf(arg2.internalArray$okio(), arg3);
    }

    public int indexOf(byte[] arg5, int arg6) {
        Intrinsics.checkNotNullParameter(arg5, "other");
        int v0 = this.getData$okio().length - arg5.length;
        arg6 = Math.max(arg6, 0);
        if(arg6 <= v0) {
            while(true) {
                if(-SegmentedByteString.arrayRangeEquals(this.getData$okio(), arg6, arg5, 0, arg5.length)) {
                    return arg6;
                }
                else if(arg6 != v0) {
                    ++arg6;
                    continue;
                }

                return -1;
            }

            return arg6;
        }

        return -1;
    }

    public final int indexOf(ByteString arg4) {
        Intrinsics.checkNotNullParameter(arg4, "other");
        return ByteString.indexOf$default(this, arg4, 0, 2, null);
    }

    public final int indexOf(byte[] arg4) {
        Intrinsics.checkNotNullParameter(arg4, "other");
        return ByteString.indexOf$default(this, arg4, 0, 2, null);
    }

    public static int indexOf$default(ByteString arg0, ByteString arg1, int arg2, int arg3, Object arg4) {
        if(arg4 == null) {
            return arg0.indexOf(arg1, 0);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
    }

    public static int indexOf$default(ByteString arg0, byte[] arg1, int arg2, int arg3, Object arg4) {
        if(arg4 == null) {
            return arg0.indexOf(arg1, 0);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
    }

    public byte[] internalArray$okio() {
        return this.getData$okio();
    }

    public byte internalGet$okio(int arg1) {
        return this.getData$okio()[arg1];
    }

    public final int lastIndexOf(ByteString arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "other");
        return this.lastIndexOf(arg2.internalArray$okio(), arg3);
    }

    public int lastIndexOf(byte[] arg4, int arg5) {
        int v0;
        Intrinsics.checkNotNullParameter(arg4, "other");
        for(arg5 = Math.min(arg5, this.getData$okio().length - arg4.length); true; --arg5) {
            v0 = -1;
            if(v0 >= arg5) {
                return v0;
            }

            if(-SegmentedByteString.arrayRangeEquals(this.getData$okio(), arg5, arg4, 0, arg4.length)) {
                return arg5;
            }
        }

        return v0;
    }

    public final int lastIndexOf(ByteString arg4) {
        Intrinsics.checkNotNullParameter(arg4, "other");
        return ByteString.lastIndexOf$default(this, arg4, 0, 2, null);
    }

    public final int lastIndexOf(byte[] arg4) {
        Intrinsics.checkNotNullParameter(arg4, "other");
        return ByteString.lastIndexOf$default(this, arg4, 0, 2, null);
    }

    public static int lastIndexOf$default(ByteString arg0, ByteString arg1, int arg2, int arg3, Object arg4) {
        if(arg4 == null) {
            if((arg3 & 2) != 0) {
                arg2 = arg0.size();
            }

            return arg0.lastIndexOf(arg1, arg2);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
    }

    public static int lastIndexOf$default(ByteString arg0, byte[] arg1, int arg2, int arg3, Object arg4) {
        if(arg4 == null) {
            if((arg3 & 2) != 0) {
                arg2 = arg0.size();
            }

            return arg0.lastIndexOf(arg1, arg2);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
    }

    public final ByteString md5() {
        return this.digest$okio("MD5");
    }

    @JvmStatic public static final ByteString of(ByteBuffer arg1) {
        return ByteString.Companion.of(arg1);
    }

    @JvmStatic public static final ByteString of(byte[] arg1) {
        return ByteString.Companion.of(arg1);
    }

    @JvmStatic public static final ByteString of(byte[] arg1, int arg2, int arg3) {
        return ByteString.Companion.of(arg1, arg2, arg3);
    }

    public boolean rangeEquals(int arg2, ByteString arg3, int arg4, int arg5) {
        Intrinsics.checkNotNullParameter(arg3, "other");
        return arg3.rangeEquals(arg4, this.getData$okio(), arg2, arg5);
    }

    public boolean rangeEquals(int arg2, byte[] arg3, int arg4, int arg5) {
        Intrinsics.checkNotNullParameter(arg3, "other");
        if(arg2 >= 0 && arg2 <= this.getData$okio().length - arg5 && arg4 >= 0 && arg4 <= arg3.length - arg5 && (-SegmentedByteString.arrayRangeEquals(this.getData$okio(), arg2, arg3, arg4, arg5))) {
            return 1;
        }

        return 0;
    }

    @JvmStatic public static final ByteString read(InputStream arg1, int arg2) throws IOException {
        return ByteString.Companion.read(arg1, arg2);
    }

    private final void readObject(ObjectInputStream arg3) throws IOException {
        ByteString v3 = ByteString.Companion.read(((InputStream)arg3), arg3.readInt());
        Field v0 = ByteString.class.getDeclaredField("data");
        v0.setAccessible(true);
        v0.set(this, v3.data);
    }

    public final void setHashCode$okio(int arg1) {
        this.hashCode = arg1;
    }

    public final void setUtf8$okio(String arg1) {
        this.utf8 = arg1;
    }

    public final ByteString sha1() {
        return this.digest$okio("SHA-1");
    }

    public final ByteString sha256() {
        return this.digest$okio("SHA-256");
    }

    public final ByteString sha512() {
        return this.digest$okio("SHA-512");
    }

    public final int size() {
        return this.getSize$okio();
    }

    public final boolean startsWith(ByteString arg3) {
        Intrinsics.checkNotNullParameter(arg3, "prefix");
        return this.rangeEquals(0, arg3, 0, arg3.size());
    }

    public final boolean startsWith(byte[] arg3) {
        Intrinsics.checkNotNullParameter(arg3, "prefix");
        return this.rangeEquals(0, arg3, 0, arg3.length);
    }

    public String string(Charset arg2) {
        Intrinsics.checkNotNullParameter(arg2, "charset");
        return new String(this.data, arg2);
    }

    public ByteString substring(int arg2, int arg3) {
        if(arg2 >= 0) {
            if(arg3 <= this.getData$okio().length) {
                if(arg3 - arg2 >= 0) {
                    if(arg2 == 0 && arg3 == this.getData$okio().length) {
                        return this;
                    }

                    return new ByteString(ArraysKt.copyOfRange(this.getData$okio(), arg2, arg3));
                }

                throw new IllegalArgumentException("endIndex < beginIndex".toString());
            }

            throw new IllegalArgumentException("endIndex > length(" + this.getData$okio().length + ')'.toString());
        }

        throw new IllegalArgumentException("beginIndex < 0".toString());
    }

    public final ByteString substring() {
        return ByteString.substring$default(this, 0, 0, 3, null);
    }

    public final ByteString substring(int arg4) {
        return ByteString.substring$default(this, arg4, 0, 2, null);
    }

    public static ByteString substring$default(ByteString arg0, int arg1, int arg2, int arg3, Object arg4) {
        if(arg4 == null) {
            if((arg3 & 2) != 0) {
                arg2 = arg0.size();
            }

            return arg0.substring(0, arg2);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: substring");
    }

    public ByteString toAsciiLowercase() {
        int v4;
        byte[] v5;
        int v0;
        for(v0 = 0; v0 < this.getData$okio().length; ++v0) {
            int v1 = this.getData$okio()[v0];
            int v2 = 65;
            if(v1 >= v2) {
                int v3 = 90;
                if(v1 > v3) {
                }
                else {
                    v5 = this.getData$okio();
                    v5 = Arrays.copyOf(v5, v5.length);
                    Intrinsics.checkNotNullExpressionValue(v5, "copyOf(...)");
                    v4 = v0 + 1;
                    v5[v0] = ((byte)(v1 + 0x20));
                    goto label_20;
                }
            }
        }

        return this;
    label_20:
        while(v4 < v5.length) {
            v0 = v5[v4];
            if(v0 >= v2) {
                if(v0 > v3) {
                }
                else {
                    v5[v4] = ((byte)(v0 + 0x20));
                }
            }

            ++v4;
        }

        return new ByteString(v5);
    }

    public ByteString toAsciiUppercase() {
        int v4;
        byte[] v5;
        int v0;
        for(v0 = 0; v0 < this.getData$okio().length; ++v0) {
            int v1 = this.getData$okio()[v0];
            int v2 = 97;
            if(v1 >= v2) {
                int v3 = 0x7A;
                if(v1 > v3) {
                }
                else {
                    v5 = this.getData$okio();
                    v5 = Arrays.copyOf(v5, v5.length);
                    Intrinsics.checkNotNullExpressionValue(v5, "copyOf(...)");
                    v4 = v0 + 1;
                    v5[v0] = ((byte)(v1 - 0x20));
                    goto label_20;
                }
            }
        }

        return this;
    label_20:
        while(v4 < v5.length) {
            v0 = v5[v4];
            if(v0 >= v2) {
                if(v0 > v3) {
                }
                else {
                    v5[v4] = ((byte)(v0 - 0x20));
                }
            }

            ++v4;
        }

        return new ByteString(v5);
    }

    public byte[] toByteArray() {
        byte[] v1 = this.getData$okio();
        v1 = Arrays.copyOf(v1, v1.length);
        Intrinsics.checkNotNullExpressionValue(v1, "copyOf(...)");
        return v1;
    }

    public String toString() {
        if(this.getData$okio().length == 0) {
            return "[size=0]";
        }

        int v1 = 0x40;
        int v0 = -ByteString.access$codePointIndexToCharIndex(this.getData$okio(), v1);
        String v3 = "…]";
        String v4 = "[size=";
        char v5 = ']';
        if(v0 == -1) {
            if(this.getData$okio().length <= v1) {
                return "[hex=" + this.hex() + v5;
            }

            StringBuilder v0_1 = new StringBuilder(v4).append(this.getData$okio().length).append(" hex=");
            if(v1 <= this.getData$okio().length) {
                ByteString v2 = v1 == this.getData$okio().length ? this : new ByteString(ArraysKt.copyOfRange(this.getData$okio(), 0, v1));
                return v0_1.append(v2.hex()).append(v3).toString();
            }

            throw new IllegalArgumentException("endIndex > length(" + this.getData$okio().length + ')'.toString());
        }

        String v1_1 = this.utf8();
        String v7 = v1_1.substring(0, v0);
        Intrinsics.checkNotNullExpressionValue(v7, "substring(...)");
        String v2_1 = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(v7, "\\", "\\\\", false, 4, null), "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null);
        if(v0 < v1_1.length()) {
            return v4 + this.getData$okio().length + " text=" + v2_1 + v3;
        }

        return "[text=" + v2_1 + v5;
    }

    public String utf8() {
        String v0 = this.getUtf8$okio();
        if(v0 == null) {
            v0 = _JvmPlatformKt.toUtf8String(this.internalArray$okio());
            this.setUtf8$okio(v0);
        }

        return v0;
    }

    public void write(OutputStream arg2) throws IOException {
        Intrinsics.checkNotNullParameter(arg2, "out");
        arg2.write(this.data);
    }

    public void write$okio(Buffer arg2, int arg3, int arg4) {
        Intrinsics.checkNotNullParameter(arg2, "buffer");
        -ByteString.commonWrite(this, arg2, arg3, arg4);
    }

    private final void writeObject(ObjectOutputStream arg2) throws IOException {
        arg2.writeInt(this.data.length);
        arg2.write(this.data);
    }
}

