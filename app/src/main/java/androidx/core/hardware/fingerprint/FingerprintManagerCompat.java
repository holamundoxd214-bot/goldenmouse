package androidx.core.hardware.fingerprint;

import android.content.Context;
import android.os.CancellationSignal;
import android.os.Handler;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

@Deprecated public class FingerprintManagerCompat {
    public abstract class AuthenticationCallback {
        public AuthenticationCallback() {
            super();
        }

        public void onAuthenticationError(int arg1, CharSequence arg2) {
        }

        public void onAuthenticationFailed() {
        }

        public void onAuthenticationHelp(int arg1, CharSequence arg2) {
        }

        public void onAuthenticationSucceeded(AuthenticationResult arg1) {
        }
    }

    public final class AuthenticationResult {
        private final CryptoObject mCryptoObject;

        public AuthenticationResult(CryptoObject arg1) {
            super();
            this.mCryptoObject = arg1;
        }

        public CryptoObject getCryptoObject() {
            return this.mCryptoObject;
        }
    }

    public class CryptoObject {
        private final Cipher mCipher;
        private final Mac mMac;
        private final Signature mSignature;

        public CryptoObject(Signature arg1) {
            super();
            this.mSignature = arg1;
            this.mCipher = null;
            this.mMac = null;
        }

        public CryptoObject(Cipher arg1) {
            super();
            this.mCipher = arg1;
            this.mSignature = null;
            this.mMac = null;
        }

        public CryptoObject(Mac arg1) {
            super();
            this.mMac = arg1;
            this.mCipher = null;
            this.mSignature = null;
        }

        public Cipher getCipher() {
            return this.mCipher;
        }

        public Mac getMac() {
            return this.mMac;
        }

        public Signature getSignature() {
            return this.mSignature;
        }
    }

    private FingerprintManagerCompat() {
        super();
    }

    public void authenticate(CryptoObject arg1, int arg2, CancellationSignal arg3, AuthenticationCallback arg4, Handler arg5) {
    }

    @Deprecated public void authenticate(CryptoObject arg1, int arg2, androidx.core.os.CancellationSignal arg3, AuthenticationCallback arg4, Handler arg5) {
    }

    public static FingerprintManagerCompat from(Context arg0) {
        return new FingerprintManagerCompat();
    }

    public boolean hasEnrolledFingerprints() {
        return 0;
    }

    public boolean isHardwareDetected() {
        return 0;
    }
}

