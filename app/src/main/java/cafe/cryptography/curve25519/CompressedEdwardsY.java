package cafe.cryptography.curve25519;

import cafe.cryptography.subtle.ConstantTime;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Arrays;

public class CompressedEdwardsY implements Serializable {
    private transient byte[] data;
    private static final long serialVersionUID = 1;

    public CompressedEdwardsY(byte[] arg3) {
        super();
        if(arg3.length == 0x20) {
            this.data = arg3;
            return;
        }

        throw new IllegalArgumentException("Invalid CompressedEdwardsY encoding");
    }

    public int ctEquals(CompressedEdwardsY arg1) {
        return ConstantTime.equal(this.data, arg1.data);
    }

    public EdwardsPoint decompress() throws InvalidEncodingException {
        FieldElement v0 = FieldElement.fromByteArray(this.data);
        FieldElement v1 = v0.square();
        SqrtRatioM1Result v1_1 = FieldElement.sqrtRatioM1(v1.subtract(FieldElement.ONE), v1.multiply(Constants.EDWARDS_D).add(FieldElement.ONE));
        if(v1_1.wasSquare == 1) {
            FieldElement v5 = v1_1.result.negate().ctSelect(v1_1.result, ConstantTime.equal(v1_1.result.isNegative(), ConstantTime.bit(this.data, 0xFF)));
            return new EdwardsPoint(v5, v0, FieldElement.ONE, v5.multiply(v0));
        }

        throw new InvalidEncodingException("not a valid EdwardsPoint");
    }

    public boolean equals(Object arg3) {
        if(!(arg3 instanceof CompressedEdwardsY)) {
            return 0;
        }

        if(this.ctEquals(((CompressedEdwardsY)arg3)) == 1) {
            return 1;
        }

        return 0;
    }

    public int hashCode() {
        return Arrays.hashCode(this.data);
    }

    private void readObject(ObjectInputStream arg2) throws IOException, ClassNotFoundException {
        byte[] v0 = new byte[0x20];
        arg2.readFully(v0);
        this.data = v0;
    }

    private void readObjectNoData() throws ObjectStreamException {
        throw new InvalidObjectException("Cannot deserialize CompressedEdwardsY from no data");
    }

    public byte[] toByteArray() {
        return this.data;
    }

    private void writeObject(ObjectOutputStream arg1) throws IOException {
        arg1.write(this.toByteArray());
    }
}

