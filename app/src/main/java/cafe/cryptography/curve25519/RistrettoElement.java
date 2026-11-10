package cafe.cryptography.curve25519;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Arrays;

public class RistrettoElement implements Serializable {
    public static final RistrettoElement IDENTITY = null;
    transient EdwardsPoint repr;
    private static final long serialVersionUID = 1;

    static {
        RistrettoElement.IDENTITY = new RistrettoElement(EdwardsPoint.IDENTITY);
    }

    RistrettoElement(EdwardsPoint arg1) {
        super();
        this.repr = arg1;
    }

    public RistrettoElement add(RistrettoElement arg2) {
        return new RistrettoElement(this.repr.add(arg2.repr));
    }

    public CompressedRistretto compress() {
        FieldElement v0 = this.repr.Z.add(this.repr.Y).multiply(this.repr.Z.subtract(this.repr.Y));
        FieldElement v1 = this.repr.X.multiply(this.repr.Y);
        SqrtRatioM1Result v2 = FieldElement.sqrtRatioM1(FieldElement.ONE, v0.multiply(v1.square()));
        v0 = v2.result.multiply(v0);
        v1 = v2.result.multiply(v1);
        FieldElement v2_1 = v0.multiply(v1).multiply(this.repr.T);
        FieldElement v3 = this.repr.X.multiply(Constants.SQRT_M1);
        FieldElement v4 = this.repr.Y.multiply(Constants.SQRT_M1);
        v0 = v0.multiply(Constants.INVSQRT_A_MINUS_D);
        int v5 = this.repr.T.multiply(v2_1).isNegative();
        v4 = this.repr.X.ctSelect(v4, v5);
        v3 = this.repr.Y.ctSelect(v3, v5);
        FieldElement v7 = v1.ctSelect(v0, v5).multiply(this.repr.Z.subtract(v3.ctSelect(v3.negate(), v4.multiply(v2_1).isNegative())));
        return new CompressedRistretto(v7.ctSelect(v7.negate(), v7.isNegative()).toByteArray());
    }

    public int ctEquals(RistrettoElement arg5) {
        return this.repr.Y.multiply(arg5.repr.Y).ctEquals(this.repr.X.multiply(arg5.repr.X)) | this.repr.X.multiply(arg5.repr.Y).ctEquals(this.repr.Y.multiply(arg5.repr.X));
    }

    public RistrettoElement ctSelect(RistrettoElement arg2, int arg3) {
        return new RistrettoElement(this.repr.ctSelect(arg2.repr, arg3));
    }

    public RistrettoElement dbl() {
        return new RistrettoElement(this.repr.dbl());
    }

    public boolean equals(Object arg3) {
        if(!(arg3 instanceof RistrettoElement)) {
            return 0;
        }

        if(this.ctEquals(((RistrettoElement)arg3)) == 1) {
            return 1;
        }

        return 0;
    }

    public static RistrettoElement fromUniformBytes(byte[] arg3) {
        return RistrettoElement.map(FieldElement.fromByteArray(Arrays.copyOfRange(arg3, 0, 0x20))).add(RistrettoElement.map(FieldElement.fromByteArray(Arrays.copyOfRange(arg3, 0x20, 0x40))));
    }

    public int hashCode() {
        return this.compress().hashCode();
    }

    static RistrettoElement map(FieldElement arg7) {
        FieldElement v0 = arg7.square().multiply(Constants.SQRT_M1);
        FieldElement v1 = v0.add(FieldElement.ONE).multiply(Constants.ONE_MINUS_D_SQ);
        FieldElement v2 = FieldElement.MINUS_ONE.subtract(v0.multiply(Constants.EDWARDS_D)).multiply(v0.add(Constants.EDWARDS_D));
        SqrtRatioM1Result v1_1 = FieldElement.sqrtRatioM1(v1, v2);
        arg7 = v1_1.result.multiply(arg7).ctAbs().negate().ctSelect(v1_1.result, v1_1.wasSquare);
        v0 = v0.ctSelect(FieldElement.MINUS_ONE, v1_1.wasSquare).multiply(v0.subtract(FieldElement.ONE)).multiply(Constants.D_MINUS_ONE_SQ).subtract(v2);
        v1 = arg7.square();
        arg7 = arg7.add(arg7).multiply(v2);
        v0 = v0.multiply(Constants.SQRT_AD_MINUS_ONE);
        v2 = FieldElement.ONE.subtract(v1);
        v1 = FieldElement.ONE.add(v1);
        return new RistrettoElement(new EdwardsPoint(arg7.multiply(v1), v2.multiply(v0), v0.multiply(v1), arg7.multiply(v2)));
    }

    public RistrettoElement multiply(Scalar arg2) {
        return new RistrettoElement(this.repr.multiply(arg2));
    }

    public RistrettoElement negate() {
        return new RistrettoElement(this.repr.negate());
    }

    String printInternalRepresentation() {
        return "RistrettoElement(" + this.repr.printInternalRepresentation() + ")";
    }

    private void readObject(ObjectInputStream arg2) throws IOException, ClassNotFoundException {
        byte[] v0 = new byte[0x20];
        arg2.readFully(v0);
        try {
            this.repr = new CompressedRistretto(v0).decompress().repr;
            return;
        }
        catch(InvalidEncodingException v1) {
            throw new InvalidObjectException(v1.getMessage());
        }
    }

    private void readObjectNoData() throws ObjectStreamException {
        throw new InvalidObjectException("Cannot deserialize RistrettoElement from no data");
    }

    public RistrettoElement subtract(RistrettoElement arg2) {
        return new RistrettoElement(this.repr.subtract(arg2.repr));
    }

    private void writeObject(ObjectOutputStream arg1) throws IOException {
        arg1.write(this.compress().toByteArray());
    }
}

