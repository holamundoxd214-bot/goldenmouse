package cafe.cryptography.ed25519;

import cafe.cryptography.curve25519.Scalar;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

public class Ed25519PrivateKey {
    private final byte[] secret;

    private Ed25519PrivateKey(byte[] arg3) {
        super();
        if(arg3.length == 0x20) {
            this.secret = Arrays.copyOf(arg3, arg3.length);
            return;
        }

        throw new IllegalArgumentException("Invalid private key");
    }

    public Ed25519PublicKey derivePublic() {
        return this.expand().derivePublic();
    }

    public Ed25519ExpandedPrivateKey expand() {
        MessageDigest v0;
        try {
            v0 = MessageDigest.getInstance("SHA-512");
        }
        catch(NoSuchAlgorithmException v4) {
            throw new RuntimeException(((Throwable)v4));
        }

        v0.update(this.secret);
        byte[] v4_1 = v0.digest();
        byte[] v2 = Arrays.copyOfRange(v4_1, 0, 0x20);
        v4_1 = Arrays.copyOfRange(v4_1, 0x20, 0x40);
        v2[0] = ((byte)(v2[0] & 0xF8));
        byte v1 = ((byte)(v2[0x1F] & 0x3F));
        v2[0x1F] = v1;
        v2[0x1F] = ((byte)(v1 | 0x40));
        return new Ed25519ExpandedPrivateKey(Scalar.fromBits(v2), v4_1);
    }

    public static Ed25519PrivateKey fromByteArray(byte[] arg1) {
        return new Ed25519PrivateKey(arg1);
    }

    public static Ed25519PrivateKey generate(SecureRandom arg1) {
        byte[] v0 = new byte[0x20];
        arg1.nextBytes(v0);
        return new Ed25519PrivateKey(v0);
    }

    public byte[] toByteArray() {
        return Arrays.copyOf(this.secret, this.secret.length);
    }
}

