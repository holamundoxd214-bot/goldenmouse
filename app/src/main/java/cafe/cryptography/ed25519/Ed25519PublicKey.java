package cafe.cryptography.ed25519;

import cafe.cryptography.curve25519.CompressedEdwardsY;
import cafe.cryptography.curve25519.EdwardsPoint;
import cafe.cryptography.curve25519.InvalidEncodingException;
import cafe.cryptography.curve25519.Scalar;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Ed25519PublicKey {
    private final EdwardsPoint A;
    private final CompressedEdwardsY Aenc;

    Ed25519PublicKey(EdwardsPoint arg1) {
        super();
        this.A = arg1;
        this.Aenc = arg1.compress();
    }

    private Ed25519PublicKey(CompressedEdwardsY arg1) throws InvalidEncodingException {
        super();
        this.Aenc = arg1;
        this.A = arg1.decompress();
    }

    public boolean equals(Object arg2) {
        if(!(arg2 instanceof Ed25519PublicKey)) {
            return 0;
        }

        return this.Aenc.equals(((Ed25519PublicKey)arg2).Aenc);
    }

    public static Ed25519PublicKey fromByteArray(byte[] arg1) throws InvalidEncodingException {
        return new Ed25519PublicKey(new CompressedEdwardsY(arg1));
    }

    public int hashCode() {
        return this.Aenc.hashCode();
    }

    public byte[] toByteArray() {
        return this.Aenc.toByteArray();
    }

    public boolean verify(byte[] arg3, int arg4, int arg5, Ed25519Signature arg6) {
        MessageDigest v0;
        try {
            v0 = MessageDigest.getInstance("SHA-512");
        }
        catch(NoSuchAlgorithmException v2) {
            throw new RuntimeException(((Throwable)v2));
        }

        v0.update(arg6.R.toByteArray());
        v0.update(this.Aenc.toByteArray());
        v0.update(arg3, arg4, arg5);
        return EdwardsPoint.vartimeDoubleScalarMultiplyBasepoint(Scalar.fromBytesModOrderWide(v0.digest()), this.A.negate(), arg6.S).compress().equals(arg6.R);
    }

    public boolean verify(byte[] arg3, Ed25519Signature arg4) {
        return this.verify(arg3, 0, arg3.length, arg4);
    }
}

