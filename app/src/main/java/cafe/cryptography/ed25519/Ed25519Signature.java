package cafe.cryptography.ed25519;

import cafe.cryptography.curve25519.CompressedEdwardsY;
import cafe.cryptography.curve25519.Scalar;
import java.util.Arrays;

public class Ed25519Signature {
    final CompressedEdwardsY R;
    final Scalar S;

    Ed25519Signature(CompressedEdwardsY arg1, Scalar arg2) {
        super();
        this.R = arg1;
        this.S = arg2;
    }

    public boolean equals(Object arg4) {
        if(!(arg4 instanceof Ed25519Signature)) {
            return 0;
        }

        if((this.R.equals(((Ed25519Signature)arg4).R)) && (this.S.equals(((Ed25519Signature)arg4).S))) {
            return 1;
        }

        return 0;
    }

    public static Ed25519Signature fromByteArray(byte[] arg4) {
        int v1 = 0x40;
        if(arg4.length == v1) {
            int v3 = 0x20;
            CompressedEdwardsY v0 = new CompressedEdwardsY(Arrays.copyOfRange(arg4, 0, v3));
            Scalar v4 = (arg4[0x3F] & 0xF0) == 0 ? Scalar.fromBits(Arrays.copyOfRange(arg4, v3, v1)) : Scalar.fromCanonicalBytes(Arrays.copyOfRange(arg4, v3, v1));
            return new Ed25519Signature(v0, v4);
        }

        throw new IllegalArgumentException("signature length is wrong");
    }

    public int hashCode() {
        return this.S.hashCode() ^ this.R.hashCode();
    }

    public byte[] toByteArray() {
        byte[] v0 = this.R.toByteArray();
        byte[] v4 = this.S.toByteArray();
        byte[] v1 = new byte[v0.length + v4.length];
        System.arraycopy(v0, 0, v1, 0, v0.length);
        System.arraycopy(v4, 0, v1, v0.length, v4.length);
        return v1;
    }
}

