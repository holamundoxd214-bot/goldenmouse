package cafe.cryptography.curve25519;

class ProjectivePoint {
    final FieldElement X;
    final FieldElement Y;
    final FieldElement Z;

    ProjectivePoint(FieldElement arg1, FieldElement arg2, FieldElement arg3) {
        super();
        this.X = arg1;
        this.Y = arg2;
        this.Z = arg3;
    }

    CompletedPoint dbl() {
        FieldElement v0 = this.X.square();
        FieldElement v1 = this.Y.square();
        FieldElement v2 = this.Z.squareAndDouble();
        FieldElement v4 = this.X.add(this.Y).square();
        FieldElement v3 = v1.add(v0);
        v0 = v1.subtract(v0);
        return new CompletedPoint(v4.subtract(v3), v3, v0, v2.subtract(v0));
    }

    EdwardsPoint toExtended() {
        return new EdwardsPoint(this.X.multiply(this.Z), this.Y.multiply(this.Z), this.Z.square(), this.X.multiply(this.Y));
    }
}

