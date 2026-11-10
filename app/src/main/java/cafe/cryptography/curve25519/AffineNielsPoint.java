package cafe.cryptography.curve25519;

import cafe.cryptography.subtle.ConstantTime;

class AffineNielsPoint {
    class LookupTable {
        private final AffineNielsPoint[] table;

        LookupTable(AffineNielsPoint[] arg1) {
            super();
            this.table = arg1;
        }

        AffineNielsPoint select(int arg6) {
            if(arg6 >= -8 && arg6 <= 8) {
                int v0 = ConstantTime.isNegative(arg6);
                int v2 = 1;
                arg6 -= (-v0 & arg6) << 1;
                AffineNielsPoint v1 = AffineNielsPoint.IDENTITY;
                while(v2 < 9) {
                    v1 = v1.ctSelect(this.table[v2 - 1], ConstantTime.equal(arg6, v2));
                    ++v2;
                }

                return v1.ctSelect(v1.negate(), v0);
            }

            throw new IllegalArgumentException("x is not in range -8 <= x <= 8");
        }
    }

    class NafLookupTable {
        private final AffineNielsPoint[] table;

        NafLookupTable(AffineNielsPoint[] arg1) {
            super();
            this.table = arg1;
        }

        AffineNielsPoint select(int arg2) {
            if(arg2 % 2 != 0 && arg2 < 16) {
                return this.table[arg2 / 2];
            }

            throw new IllegalArgumentException("invalid x");
        }
    }

    static final AffineNielsPoint IDENTITY;
    final FieldElement xy2D;
    final FieldElement yMinusx;
    final FieldElement yPlusx;

    static {
        AffineNielsPoint.IDENTITY = new AffineNielsPoint(FieldElement.ONE, FieldElement.ONE, FieldElement.ZERO);
    }

    AffineNielsPoint(FieldElement arg1, FieldElement arg2, FieldElement arg3) {
        super();
        this.yPlusx = arg1;
        this.yMinusx = arg2;
        this.xy2D = arg3;
    }

    static LookupTable buildLookupTable(EdwardsPoint arg3) {
        AffineNielsPoint[] v0 = new AffineNielsPoint[8];
        int v2 = 0;
        v0[0] = arg3.toAffineNiels();
        while(v2 < 7) {
            int v1 = v2 + 1;
            v0[v1] = arg3.add(v0[v2]).toExtended().toAffineNiels();
            v2 = v1;
        }

        return new LookupTable(v0);
    }

    static NafLookupTable buildNafLookupTable(EdwardsPoint arg3) {
        AffineNielsPoint[] v0 = new AffineNielsPoint[8];
        int v2 = 0;
        v0[0] = arg3.toAffineNiels();
        arg3 = arg3.dbl();
        while(v2 < 7) {
            int v1 = v2 + 1;
            v0[v1] = arg3.add(v0[v2]).toExtended().toAffineNiels();
            v2 = v1;
        }

        return new NafLookupTable(v0);
    }

    public AffineNielsPoint ctSelect(AffineNielsPoint arg5, int arg6) {
        return new AffineNielsPoint(this.yPlusx.ctSelect(arg5.yPlusx, arg6), this.yMinusx.ctSelect(arg5.yMinusx, arg6), this.xy2D.ctSelect(arg5.xy2D, arg6));
    }

    public AffineNielsPoint negate() {
        return new AffineNielsPoint(this.yMinusx, this.yPlusx, this.xy2D.negate());
    }
}

