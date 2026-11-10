package cafe.cryptography.curve25519;

public final class Constants {
    static final NafLookupTable AFFINE_ODD_MULTIPLES_OF_BASEPOINT = null;
    static final Scalar BASEPOINT_ORDER = null;
    static final FieldElement D_MINUS_ONE_SQ = null;
    public static final EdwardsPoint ED25519_BASEPOINT = null;
    public static final EdwardsBasepointTable ED25519_BASEPOINT_TABLE = null;
    static final FieldElement EDWARDS_2D = null;
    static final FieldElement EDWARDS_D = null;
    static final FieldElement INVSQRT_A_MINUS_D = null;
    static final UnpackedScalar L = null;
    static final int LFACTOR = 307527195;
    static final FieldElement NEG_EDWARDS_D;
    static final FieldElement ONE_MINUS_D_SQ;
    static final UnpackedScalar R;
    public static final RistrettoElement RISTRETTO_GENERATOR;
    public static final RistrettoGeneratorTable RISTRETTO_GENERATOR_TABLE;
    static final UnpackedScalar RR;
    static final FieldElement SQRT_AD_MINUS_ONE;
    static final FieldElement SQRT_M1;

    static {
        Scalar v0 = new Scalar(new byte[]{-19, -45, -11, 92, 26, 99, 18, 88, -42, -100, -9, -94, -34, -7, -34, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16});
        Constants.BASEPOINT_ORDER = v0;
        Constants.L = UnpackedScalar.fromByteArray(v0.toByteArray());
        Constants.R = new UnpackedScalar(new int[]{0x114DF9ED, 0x1A617303, 0xF7C098C, 377041255, 536700270, 0x1FFFFFFF, 0x1FFFFFFF, 0x1FFFFFFF, 0xFFFFF});
        Constants.RR = new UnpackedScalar(new int[]{190815506, 504634135, 0x158D7F3D, 0x143F3757, 0x1972D781, 70249340, 485410621, 504909086, 0x5046D});
        FieldElement v0_1 = new FieldElement(new int[]{-10913610, 0xD37285, 0xFF156EBD, 0x6A0A0F, 0x1C029, 0xFF79E898, 0xFFA03CBC, 0xFFCE7199, 0xFEE2B700, 0xFF480DB4});
        Constants.EDWARDS_D = v0_1;
        Constants.NEG_EDWARDS_D = v0_1.negate();
        Constants.EDWARDS_2D = new FieldElement(new int[]{0xFEB2F159, 0xFFA6E50A, -30745221, 0xD4141E, 0x38052, 0xF3D130, 0xFF407977, 0xFF9CE332, 0x1C56E00, 0x901B67});
        Constants.ONE_MINUS_D_SQ = FieldElement.ONE.subtract(v0_1.square());
        Constants.D_MINUS_ONE_SQ = v0_1.subtract(FieldElement.ONE).square();
        Constants.SQRT_AD_MINUS_ONE = new FieldElement(new int[]{0x17B2E1B, 0xFFFDA812, 0xFE97AFD3, 0x60DBC3, -21072328, 0xFFF5D1FE, 0xFE7E6499, -15367704, -870347, 0xDDA4C7});
        Constants.INVSQRT_A_MINUS_D = new FieldElement(new int[]{0x5D40FD, 0x3F6AA0, 0xFE57D339, 0xBAD20C, -25904040, 120897, 0x13DC8FF, -7060776, 0x5CFB00, -1986012});
        Constants.SQRT_M1 = new FieldElement(new int[]{0xFE0EA0B0, 0xFF86C9D3, 0x8F189E, 3500415, 0xBD0C60, 0xFFFBD7A7, 0xFE804C9F, -2005654, 0x4FC1E, 0xAE0C92});
        EdwardsPoint v0_2 = new EdwardsPoint(new FieldElement(new int[]{-14297830, 0xFF8B5824, 0xF6592B, 0xFF04A92D, 27570974, -2696100, 0xFE7118FF, 0x7FD815, 20764389, 0x85A4DB}), new FieldElement(new int[]{0xFE66666B, -6710886, 0xCCCCCD, 0xFF333333, 0x199999A, 6710886, 0xFF333333, 0xCCCCCD, 0xFE666666, -6710886}), new FieldElement(new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}), new FieldElement(new int[]{28827062, 0xFFA2ACE9, 0xFE5EADBC, 0x3BA8B, 8635006, 0xABE37D, 0x1274732, 0xCCACDD, 0xFD78B7, -6414980}));
        Constants.ED25519_BASEPOINT = v0_2;
        Constants.ED25519_BASEPOINT_TABLE = new EdwardsBasepointTable(v0_2);
        Constants.AFFINE_ODD_MULTIPLES_OF_BASEPOINT = AffineNielsPoint.buildNafLookupTable(v0_2);
        RistrettoElement v1 = new RistrettoElement(v0_2);
        Constants.RISTRETTO_GENERATOR = v1;
        Constants.RISTRETTO_GENERATOR_TABLE = new RistrettoGeneratorTable(v1);
    }

    public Constants() {
        super();
    }
}

