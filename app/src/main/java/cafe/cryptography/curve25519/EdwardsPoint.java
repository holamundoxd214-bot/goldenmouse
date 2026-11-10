package cafe.cryptography.curve25519;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;

public class EdwardsPoint implements Serializable {
    public static final EdwardsPoint IDENTITY = null;
    transient FieldElement T;
    transient FieldElement X;
    transient FieldElement Y;
    transient FieldElement Z;
    private static final long serialVersionUID = 1;

    static {
        EdwardsPoint.IDENTITY = new EdwardsPoint(FieldElement.ZERO, FieldElement.ONE, FieldElement.ONE, FieldElement.ZERO);
    }

    EdwardsPoint(FieldElement arg1, FieldElement arg2, FieldElement arg3, FieldElement arg4) {
        super();
        this.X = arg1;
        this.Y = arg2;
        this.Z = arg3;
        this.T = arg4;
    }

    CompletedPoint add(AffineNielsPoint arg5) {
        FieldElement v0 = this.Y.add(this.X);
        FieldElement v1 = this.Y.subtract(this.X);
        v0 = v0.multiply(arg5.yPlusx);
        v1 = v1.multiply(arg5.yMinusx);
        FieldElement v5 = this.T.multiply(arg5.xy2D);
        FieldElement v4 = this.Z.add(this.Z);
        return new CompletedPoint(v0.subtract(v1), v0.add(v1), v4.add(v5), v4.subtract(v5));
    }

    CompletedPoint add(ProjectiveNielsPoint arg5) {
        FieldElement v0 = this.Y.add(this.X);
        FieldElement v1 = this.Y.subtract(this.X);
        v0 = v0.multiply(arg5.YPlusX);
        v1 = v1.multiply(arg5.YMinusX);
        FieldElement v2 = this.T.multiply(arg5.T2D);
        FieldElement v4 = this.Z.multiply(arg5.Z);
        v4 = v4.add(v4);
        return new CompletedPoint(v0.subtract(v1), v0.add(v1), v4.add(v2), v4.subtract(v2));
    }

    public EdwardsPoint add(EdwardsPoint arg1) {
        return this.add(arg1.toProjectiveNiels()).toExtended();
    }

    public CompressedEdwardsY compress() {
        FieldElement v0 = this.Z.invert();
        FieldElement v1 = this.X.multiply(v0);
        byte[] v3 = this.Y.multiply(v0).toByteArray();
        v3[0x1F] = ((byte)(v1.isNegative() << 7 | v3[0x1F]));
        return new CompressedEdwardsY(v3);
    }

    public int ctEquals(EdwardsPoint arg1) {
        return this.compress().ctEquals(arg1.compress());
    }

    public EdwardsPoint ctSelect(EdwardsPoint arg6, int arg7) {
        return new EdwardsPoint(this.X.ctSelect(arg6.X, arg7), this.Y.ctSelect(arg6.Y, arg7), this.Z.ctSelect(arg6.Z, arg7), this.T.ctSelect(arg6.T, arg7));
    }

    public EdwardsPoint dbl() {
        return this.toProjective().dbl().toExtended();
    }

    public boolean equals(Object arg3) {
        if(!(arg3 instanceof EdwardsPoint)) {
            return 0;
        }

        if(this.ctEquals(((EdwardsPoint)arg3)) == 1) {
            return 1;
        }

        return 0;
    }

    public int hashCode() {
        return this.compress().hashCode();
    }

    public boolean isIdentity() {
        if(this.ctEquals(EdwardsPoint.IDENTITY) == 1) {
            return 1;
        }

        return 0;
    }

    public boolean isSmallOrder() {
        return this.multiplyByCofactor().isIdentity();
    }

    public boolean isTorsionFree() {
        return this.multiply(Constants.BASEPOINT_ORDER).isIdentity();
    }

    public EdwardsPoint multiply(Scalar arg4) {
        LookupTable v3 = ProjectiveNielsPoint.buildLookupTable(this);
        byte[] v4 = arg4.toRadix16();
        EdwardsPoint v0 = EdwardsPoint.IDENTITY;
        int v1;
        for(v1 = 0x3F; v1 >= 0; --v1) {
            v0 = v0.multiplyByPow2(4).add(v3.select(v4[v1])).toExtended();
        }

        return v0;
    }

    public EdwardsPoint multiplyByCofactor() {
        return this.multiplyByPow2(3);
    }

    EdwardsPoint multiplyByPow2(int arg3) {
        if(arg3 > 0) {
            ProjectivePoint v2 = this.toProjective();
            int v0;
            for(v0 = 0; v0 < arg3 - 1; ++v0) {
                v2 = v2.dbl().toProjective();
            }

            return v2.dbl().toExtended();
        }

        throw new IllegalArgumentException("Exponent must be positive and non-zero");
    }

    public EdwardsPoint negate() {
        return new EdwardsPoint(this.X.negate(), this.Y, this.Z, this.T.negate());
    }

    String printInternalRepresentation() {
        return "EdwardsPoint(\n    X: " + this.X.printInternalRepresentation() + ",\n" + "    Y: " + this.Y.printInternalRepresentation() + ",\n" + "    Z: " + this.Z.printInternalRepresentation() + ",\n" + "    T: " + this.T.printInternalRepresentation() + ",\n" + ")";
    }

    private void readObject(ObjectInputStream arg2) throws IOException, ClassNotFoundException {
        byte[] v0 = new byte[0x20];
        arg2.readFully(v0);
        try {
            EdwardsPoint v2 = new CompressedEdwardsY(v0).decompress();
            this.X = v2.X;
            this.Y = v2.Y;
            this.Z = v2.Z;
            this.T = v2.T;
            return;
        }
        catch(InvalidEncodingException v1) {
            throw new InvalidObjectException(v1.getMessage());
        }
    }

    private void readObjectNoData() throws ObjectStreamException {
        throw new InvalidObjectException("Cannot deserialize EdwardsPoint from no data");
    }

    CompletedPoint subtract(ProjectiveNielsPoint arg5) {
        FieldElement v0 = this.Y.add(this.X);
        FieldElement v1 = this.Y.subtract(this.X);
        v0 = v0.multiply(arg5.YMinusX);
        v1 = v1.multiply(arg5.YPlusX);
        FieldElement v2 = this.T.multiply(arg5.T2D);
        FieldElement v4 = this.Z.multiply(arg5.Z);
        v4 = v4.add(v4);
        return new CompletedPoint(v0.subtract(v1), v0.add(v1), v4.subtract(v2), v4.add(v2));
    }

    CompletedPoint subtract(AffineNielsPoint arg5) {
        FieldElement v0 = this.Y.add(this.X);
        FieldElement v1 = this.Y.subtract(this.X);
        v0 = v0.multiply(arg5.yMinusx);
        v1 = v1.multiply(arg5.yPlusx);
        FieldElement v5 = this.T.multiply(arg5.xy2D);
        FieldElement v4 = this.Z.add(this.Z);
        return new CompletedPoint(v0.subtract(v1), v0.add(v1), v4.subtract(v5), v4.add(v5));
    }

    public EdwardsPoint subtract(EdwardsPoint arg1) {
        return this.subtract(arg1.toProjectiveNiels()).toExtended();
    }

    AffineNielsPoint toAffineNiels() {
        FieldElement v0 = this.Z.invert();
        FieldElement v1 = this.X.multiply(v0);
        FieldElement v4 = this.Y.multiply(v0);
        return new AffineNielsPoint(v4.add(v1), v4.subtract(v1), v1.multiply(v4).multiply(Constants.EDWARDS_2D));
    }

    ProjectivePoint toProjective() {
        return new ProjectivePoint(this.X, this.Y, this.Z);
    }

    ProjectiveNielsPoint toProjectiveNiels() {
        return new ProjectiveNielsPoint(this.Y.add(this.X), this.Y.subtract(this.X), this.Z, this.T.multiply(Constants.EDWARDS_2D));
    }

    public static EdwardsPoint vartimeDoubleScalarMultiplyBasepoint(Scalar arg4, EdwardsPoint arg5, Scalar arg6) {
        byte[] v4 = arg4.nonAdjacentForm();
        byte[] v6 = arg6.nonAdjacentForm();
        NafLookupTable v5 = ProjectiveNielsPoint.buildNafLookupTable(arg5);
        cafe.cryptography.curve25519.AffineNielsPoint$NafLookupTable v0 = Constants.AFFINE_ODD_MULTIPLES_OF_BASEPOINT;
        int v1 = 0xFF;
        while(v1 >= 0) {
            if(v4[v1] != 0) {
                break;
            }

            if(v6[v1] != 0) {
            }
            else {
                --v1;
                continue;
            }

            break;
        }

        ProjectivePoint v2 = EdwardsPoint.IDENTITY.toProjective();
        while(v1 >= 0) {
            CompletedPoint v2_1 = v2.dbl();
            int v3 = v4[v1];
            if(v3 > 0) {
                v2_1 = v2_1.toExtended().add(v5.select(v4[v1]));
            }
            else if(v3 < 0) {
                v2_1 = v2_1.toExtended().subtract(v5.select(-v4[v1]));
            }

            v3 = v6[v1];
            if(v3 > 0) {
                v2_1 = v2_1.toExtended().add(v0.select(v6[v1]));
            }
            else if(v3 < 0) {
                v2_1 = v2_1.toExtended().subtract(v0.select(-v6[v1]));
            }

            v2 = v2_1.toProjective();
            --v1;
        }

        return v2.toExtended();
    }

    private void writeObject(ObjectOutputStream arg1) throws IOException {
        arg1.write(this.compress().toByteArray());
    }
}

