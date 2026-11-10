package cafe.cryptography.curve25519;

import cafe.cryptography.subtle.ConstantTime;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Arrays;

public class CompressedRistretto implements Serializable {
    private transient byte[] data;
    private static final long serialVersionUID = 1;

    public CompressedRistretto(byte[] arg3) {
        super();
        if(arg3.length == 0x20) {
            this.data = arg3;
            return;
        }

        throw new IllegalArgumentException("Invalid CompressedRistretto encoding");
    }

    public int ctEquals(CompressedRistretto arg1) {
        return ConstantTime.equal(this.data, arg1.data);
    }

    public RistrettoElement decompress() throws InvalidEncodingException {
        FieldElement v0 = FieldElement.fromByteArray(this.data);
        String v1 = "Invalid ristretto255 encoding";
        if(ConstantTime.equal(this.data, v0.toByteArray()) != 0 && v0.isNegative() != 1) {
            FieldElement v7 = v0.square();
            FieldElement v3 = FieldElement.ONE.subtract(v7);
            v7 = FieldElement.ONE.add(v7);
            FieldElement v4 = v7.square();
            FieldElement v5 = Constants.NEG_EDWARDS_D.multiply(v3.square()).subtract(v4);
            SqrtRatioM1Result v4_1 = FieldElement.sqrtRatioM1(FieldElement.ONE, v5.multiply(v4));
            v7 = v4_1.result.multiply(v7);
            v5 = v4_1.result.multiply(v7).multiply(v5);
            v7 = v0.add(v0).multiply(v7).ctAbs();
            v0 = v3.multiply(v5);
            v3 = v7.multiply(v0);
            if(v4_1.wasSquare != 0 && v3.isNegative() != 1 && v0.isZero() != 1) {
                return new RistrettoElement(new EdwardsPoint(v7, v0, FieldElement.ONE, v3));
            }

            throw new InvalidEncodingException(v1);
        }

        throw new InvalidEncodingException(v1);
    }

    public boolean equals(Object arg3) {
        if(!(arg3 instanceof CompressedRistretto)) {
            return 0;
        }

        if(this.ctEquals(((CompressedRistretto)arg3)) == 1) {
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
        throw new InvalidObjectException("Cannot deserialize CompressedRistretto from no data");
    }

    public byte[] toByteArray() {
        return this.data;
    }

    private void writeObject(ObjectOutputStream arg1) throws IOException {
        arg1.write(this.toByteArray());
    }
}

