package com.flyfishxu.kadb.cert;

import com.flyfishxu.kadb.pair.PairingAuthCtxKt;
import java.io.Closeable;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.InvalidKeyException;
import java.security.interfaces.RSAPublicKey;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.io.encoding.Base64$Default;
import kotlin.io.encoding.Base64;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okio.Buffer;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u000E\u001A\u00020\t2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0012H\u0007J\u0010\u0010\u0013\u001A\u00020\t2\u0006\u0010\u0011\u001A\u00020\u0012H\u0007J\u000E\u0010\u0014\u001A\u00020\t2\u0006\u0010\u000F\u001A\u00020\u0010J\u001A\u0010\u0015\u001A\u0004\u0018\u00010\t2\u0006\u0010\u0016\u001A\u00020\u00052\u0006\u0010\u0017\u001A\u00020\u0018H\u0002J \u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\t2\u0006\u0010\u001C\u001A\u00020\u00052\u0006\u0010\u0016\u001A\u00020\u0005H\u0002J\u0010\u0010\u001D\u001A\u00020\t2\u0006\u0010\u001B\u001A\u00020\tH\u0002R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001A\u00020\t¢\u0006\u000E\n\u0000\u0012\u0004\b\n\u0010\u0003\u001A\u0004\b\u000B\u0010\fR\u000E\u0010\r\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001E"}, d2={"Lcom/flyfishxu/kadb/cert/AndroidPubkey;", "", "<init>", "()V", "ANDROID_PUBKEY_MODULUS_SIZE", "", "ANDROID_PUBKEY_ENCODED_SIZE", "ANDROID_PUBKEY_MODULUS_SIZE_WORDS", "SIGNATURE_PADDING", "", "getSIGNATURE_PADDING$annotations", "getSIGNATURE_PADDING", "()[B", "RSA_SHA_PKCS1_SIGNATURE_PADDING", "encodeWithName", "publicKey", "Ljava/security/interfaces/RSAPublicKey;", "name", "", "getUserInfo", "encode", "igbEndianToLittleEndianPadded", "len", "in", "Ljava/math/BigInteger;", "fitsInBytes", "", "bytes", "numBytes", "swapEndianness", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public final class AndroidPubkey {
    private static final int ANDROID_PUBKEY_ENCODED_SIZE = 0x20C;
    private static final int ANDROID_PUBKEY_MODULUS_SIZE = 0x100;
    private static final int ANDROID_PUBKEY_MODULUS_SIZE_WORDS = 0x40;
    public static final AndroidPubkey INSTANCE;
    private static final byte[] RSA_SHA_PKCS1_SIGNATURE_PADDING;
    private static final byte[] SIGNATURE_PADDING;

    static {
        AndroidPubkey.INSTANCE = new AndroidPubkey();
        byte[] v0 = Arrays.copyOf(new byte[]{0, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0x30, 33, 0x30, 9, 6, 5, 43, 14, 3, 2, 26, 5, 0, 4, 20}, 0xEC);
        Intrinsics.checkNotNullExpressionValue(v0, "copyOf(...)");
        AndroidPubkey.SIGNATURE_PADDING = v0;
        v0 = new byte[v0.length];
        AndroidPubkey.RSA_SHA_PKCS1_SIGNATURE_PADDING = v0;
        int v0_1 = v0.length;
        int v1;
        for(v1 = 0; v1 < v0_1; ++v1) {
            AndroidPubkey.RSA_SHA_PKCS1_SIGNATURE_PADDING[v1] = AndroidPubkey.SIGNATURE_PADDING[v1];
        }
    }

    private AndroidPubkey() {
        super();
    }

    public final byte[] encode(RSAPublicKey arg7) throws InvalidKeyException {
        Intrinsics.checkNotNullParameter(arg7, "publicKey");
        int v1 = 0x100;
        if(arg7.getModulus().toByteArray().length >= v1) {
            ByteBuffer v0 = ByteBuffer.allocate(0x20C).order(ByteOrder.LITTLE_ENDIAN);
            v0.putInt(0x40);
            BigInteger v2 = BigInteger.ZERO.setBit(0x20);
            Intrinsics.checkNotNullExpressionValue(v2, "setBit(...)");
            BigInteger v4 = arg7.getModulus().mod(v2);
            Intrinsics.checkNotNullExpressionValue(v4, "mod(...)");
            v4 = v4.modInverse(v2);
            Intrinsics.checkNotNullExpressionValue(v4, "modInverse(...)");
            v2 = v2.subtract(v4);
            Intrinsics.checkNotNullExpressionValue(v2, "subtract(...)");
            v0.putInt(v2.intValue());
            v2 = arg7.getModulus();
            Intrinsics.checkNotNullExpressionValue(v2, "getModulus(...)");
            v0.put(Objects.requireNonNull(this.igbEndianToLittleEndianPadded(v1, v2)));
            v2 = BigInteger.ZERO.setBit(0x800);
            Intrinsics.checkNotNullExpressionValue(v2, "setBit(...)");
            v2 = v2.modPow(BigInteger.valueOf(2), arg7.getModulus());
            Intrinsics.checkNotNullExpressionValue(v2, "modPow(...)");
            v0.put(Objects.requireNonNull(this.igbEndianToLittleEndianPadded(v1, v2)));
            v0.putInt(arg7.getPublicExponent().intValue());
            byte[] v6 = v0.array();
            Intrinsics.checkNotNullExpressionValue(v6, "array(...)");
            return v6;
        }

        throw new InvalidKeyException("Invalid key length " + arg7.getModulus().toByteArray().length);
    }

    @JvmStatic public static final byte[] encodeWithName(RSAPublicKey arg10, String arg11) {
        Buffer v10_1;
        Intrinsics.checkNotNullParameter(arg10, "publicKey");
        Intrinsics.checkNotNullParameter(arg11, "name");
        int v0 = (((int)Math.ceil(174.666667))) * 4;
        Buffer v1 = new Buffer();
        try {
            Default v4 = Base64.Default;
            AndroidPubkey v3 = AndroidPubkey.INSTANCE;
            byte[] v10 = Base64.encode$default(((Base64)v4), v3.encode(arg10), 0, 0, 6, null).getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(v10, "getBytes(...)");
            v1.write(v10);
            v10_1 = v1.write(v3.getUserInfo(arg11));
        }
        catch(Throwable v0_1) {
            Throwable v10_2 = v0_1;
            try {
                throw v10_2;
            }
            catch(Throwable v0_1) {
                CloseableKt.closeFinally(((Closeable)v1), v10_2);
                throw v0_1;
            }
        }

        CloseableKt.closeFinally(((Closeable)v1), null);
        return v10_1.readByteArray(((long)(v0 + arg11.length() + 2)));
    }

    private final boolean fitsInBytes(byte[] arg3, int arg4, int arg5) {
        boolean v2 = false;
        int v0 = 0;
        while(arg5 < arg4) {
            byte v0_1 = ((byte)(v0_1 | arg3[arg5]));
            ++arg5;
        }

        if(v0_1 == 0) {
            v2 = true;
        }

        return v2;
    }

    public final byte[] getSIGNATURE_PADDING() {
        return AndroidPubkey.SIGNATURE_PADDING;
    }

    public static void getSIGNATURE_PADDING$annotations() {
    }

    public final byte[] getUserInfo(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "name");
        String v0 = String.format(" %s\u0000", Arrays.copyOf(new Object[]{arg1}, 1));
        Intrinsics.checkNotNullExpressionValue(v0, "format(...)");
        return PairingAuthCtxKt.getBytes(v0, "UTF-8");
    }

    private final byte[] igbEndianToLittleEndianPadded(int arg3, BigInteger arg4) {
        byte[] v0 = new byte[arg3];
        byte[] v4 = arg4.toByteArray();
        Intrinsics.checkNotNullExpressionValue(v4, "toByteArray(...)");
        v4 = this.swapEndianness(v4);
        int v1 = v4.length;
        if(arg3 >= v1) {
            arg3 = v1;
        }
        else if(!this.fitsInBytes(v4, v1, arg3)) {
            return null;
        }

        System.arraycopy(v4, 0, v0, 0, arg3);
        return v0;
    }

    private final byte[] swapEndianness(byte[] arg4) {
        int v3 = arg4.length;
        byte[] v0 = new byte[v3];
        int v1;
        for(v1 = 0; v1 < v3; ++v1) {
            v0[v1] = arg4[v3 - v1 - 1];
        }

        return v0;
    }
}

