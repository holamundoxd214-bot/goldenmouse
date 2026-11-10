package cafe.cryptography.ed25519;

import cafe.cryptography.curve25519.CompressedEdwardsY;
import cafe.cryptography.curve25519.Constants;
import cafe.cryptography.curve25519.Scalar;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Ed25519ExpandedPrivateKey {
    private final byte[] prefix;
    private final Scalar s;

    Ed25519ExpandedPrivateKey(Scalar arg1, byte[] arg2) {
        super();
        this.s = arg1;
        this.prefix = arg2;
    }

    public Ed25519PublicKey derivePublic() {
        return new Ed25519PublicKey(Constants.ED25519_BASEPOINT_TABLE.multiply(this.s));
    }

    public Ed25519Signature sign(byte[] arg5, int arg6, int arg7, Ed25519PublicKey arg8) {
        MessageDigest v0;
        try {
            v0 = MessageDigest.getInstance("SHA-512");
        }
        catch(NoSuchAlgorithmException v4) {
            throw new RuntimeException(((Throwable)v4));
        }

        v0.update(this.prefix);
        v0.update(arg5, arg6, arg7);
        Scalar v1 = Scalar.fromBytesModOrderWide(v0.digest());
        CompressedEdwardsY v2 = Constants.ED25519_BASEPOINT_TABLE.multiply(v1).compress();
        v0.reset();
        v0.update(v2.toByteArray());
        v0.update(arg8.toByteArray());
        v0.update(arg5, arg6, arg7);
        return new Ed25519Signature(v2, v1.add(Scalar.fromBytesModOrderWide(v0.digest()).multiply(this.s)));
    }

    public Ed25519Signature sign(byte[] arg3, Ed25519PublicKey arg4) {
        return this.sign(arg3, 0, arg3.length, arg4);
    }
}

