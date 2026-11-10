package com.flyfishxu.kadb.pair;

import com.flyfish233.crypto.spake2.Spake2Context;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import javax.security.auth.Destroyable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.generators.HKDFBytesGenerator;
import org.bouncycastle.crypto.modes.GCMBlockCipher;
import org.bouncycastle.crypto.modes.GCMModeCipher;
import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.HKDFParameters;
import org.bouncycastle.crypto.params.KeyParameter;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u001D2\u00020\u0001:\u0001\u001DB\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0011\u001A\u00020\u00102\b\u0010\u0012\u001A\u0004\u0018\u00010\u0005J\u0010\u0010\u0013\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001A\u00020\u0005J\u0010\u0010\u0015\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001A\u00020\u0005J\b\u0010\u0016\u001A\u00020\u0010H\u0016J\b\u0010\u0017\u001A\u00020\u0018H\u0016J\"\u0010\u0019\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u001A\u001A\u00020\u00102\u0006\u0010\u001B\u001A\u00020\u00052\u0006\u0010\u001C\u001A\u00020\u0005H\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u000E\u0010\u000B\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0010X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u001E"}, d2={"Lcom/flyfishxu/kadb/pair/PairingAuthCtx;", "Ljavax/security/auth/Destroyable;", "mSpake2Ctx", "Lcom/flyfish233/crypto/spake2/Spake2Context;", "password", "", "<init>", "(Lcom/flyfish233/crypto/spake2/Spake2Context;[B)V", "msg", "getMsg", "()[B", "mSecretKey", "mDecIv", "", "mEncIv", "mIsDestroyed", "", "initCipher", "theirMsg", "encrypt", "input", "decrypt", "isDestroyed", "destroy", "", "encryptDecrypt", "forEncryption", "in", "iv", "Companion", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public final class PairingAuthCtx implements Destroyable {
    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2={"Lcom/flyfishxu/kadb/pair/PairingAuthCtx$Companion;", "", "<init>", "()V", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    public static final Companion Companion;
    private long mDecIv;
    private long mEncIv;
    private boolean mIsDestroyed;
    private final byte[] mSecretKey;
    private final Spake2Context mSpake2Ctx;
    private final byte[] msg;

    static {
        PairingAuthCtx.Companion = new Companion(null);
    }

    public PairingAuthCtx(Spake2Context arg2, byte[] arg3) {
        Intrinsics.checkNotNullParameter(arg2, "mSpake2Ctx");
        Intrinsics.checkNotNullParameter(arg3, "password");
        super();
        this.mSpake2Ctx = arg2;
        byte[] v2 = arg2.generateMessage(arg3);
        Intrinsics.checkNotNullExpressionValue(v2, "generateMessage(...)");
        this.msg = v2;
        this.mSecretKey = new byte[PairingAuthCtx_androidKt.getHKDF_KEY_LENGTH()];
    }

    public final byte[] decrypt(byte[] arg6) {
        Intrinsics.checkNotNullParameter(arg6, "input");
        ByteBuffer v0 = ByteBuffer.allocate(PairingAuthCtx_androidKt.access$getGCM_IV_LENGTH()).order(ByteOrder.LITTLE_ENDIAN);
        long v1 = this.mDecIv;
        this.mDecIv = 1 + v1;
        byte[] v0_1 = v0.putLong(v1).array();
        Intrinsics.checkNotNullExpressionValue(v0_1, "array(...)");
        return this.encryptDecrypt(false, arg6, v0_1);
    }

    public void destroy() {
        this.mIsDestroyed = true;
        Arrays.fill(this.mSecretKey, 0);
        this.mSpake2Ctx.destroy();
    }

    public final byte[] encrypt(byte[] arg6) {
        Intrinsics.checkNotNullParameter(arg6, "input");
        ByteBuffer v0 = ByteBuffer.allocate(PairingAuthCtx_androidKt.access$getGCM_IV_LENGTH()).order(ByteOrder.LITTLE_ENDIAN);
        long v1 = this.mEncIv;
        this.mEncIv = 1 + v1;
        byte[] v0_1 = v0.putLong(v1).array();
        Intrinsics.checkNotNullExpressionValue(v0_1, "array(...)");
        return this.encryptDecrypt(true, arg6, v0_1);
    }

    private final byte[] encryptDecrypt(boolean arg9, byte[] arg10, byte[] arg11) {
        byte[] v1 = null;
        if(this.mIsDestroyed) {
            return v1;
        }

        AEADParameters v0 = new AEADParameters(new KeyParameter(this.mSecretKey), this.mSecretKey.length * 8, arg11);
        GCMModeCipher v2 = GCMBlockCipher.newInstance(AESEngine.newInstance());
        v2.init(arg9, ((CipherParameters)v0));
        byte[] v6 = new byte[v2.getOutputSize(arg10.length)];
        int v8 = v2.processBytes(arg10, 0, arg10.length, v6, 0);
        try {
            v2.doFinal(v6, v8);
            return v6;
        }
        catch(InvalidCipherTextException ) {
            return v1;
        }
    }

    public final byte[] getMsg() {
        return this.msg;
    }

    public final boolean initCipher(byte[] arg6) {
        if(this.mIsDestroyed) {
            return 0;
        }

        arg6 = this.mSpake2Ctx.processMessage(arg6);
        if(arg6 == null) {
            return 0;
        }

        HKDFBytesGenerator v0 = new HKDFBytesGenerator(new SHA256Digest());
        v0.init(new HKDFParameters(arg6, null, PairingAuthCtx_androidKt.getINFO()));
        v0.generateBytes(this.mSecretKey, 0, this.mSecretKey.length);
        return 1;
    }

    public boolean isDestroyed() {
        return this.mIsDestroyed;
    }
}

