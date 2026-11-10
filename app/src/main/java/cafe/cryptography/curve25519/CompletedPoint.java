package cafe.cryptography.curve25519;

class CompletedPoint {
    final FieldElement T;
    final FieldElement X;
    final FieldElement Y;
    final FieldElement Z;

    CompletedPoint(FieldElement arg1, FieldElement arg2, FieldElement arg3, FieldElement arg4) {
        super();
        this.X = arg1;
        this.Y = arg2;
        this.Z = arg3;
        this.T = arg4;
    }

    EdwardsPoint toExtended() {
        return new EdwardsPoint(this.X.multiply(this.T), this.Y.multiply(this.Z), this.Z.multiply(this.T), this.X.multiply(this.Y));
    }

    ProjectivePoint toProjective() {
        return new ProjectivePoint(this.X.multiply(this.T), this.Y.multiply(this.Z), this.Z.multiply(this.T));
    }
}

