package cafe.cryptography.curve25519;

public class EdwardsBasepointTable {
    final LookupTable[] tables;

    public EdwardsBasepointTable(EdwardsPoint arg5) {
        super();
        int v0 = 0x20;
        this.tables = new LookupTable[v0];
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            this.tables[v1] = AffineNielsPoint.buildLookupTable(arg5);
            arg5 = arg5.multiplyByPow2(8);
        }
    }

    public EdwardsPoint multiply(Scalar arg6) {
        byte[] v6 = arg6.toRadix16();
        EdwardsPoint v0 = EdwardsPoint.IDENTITY;
        int v1;
        for(v1 = 1; true; v1 += 2) {
            int v2 = 0x40;
            if(v1 >= v2) {
                break;
            }

            v0 = v0.add(this.tables[v1 / 2].select(v6[v1])).toExtended();
        }

        v0 = v0.multiplyByPow2(4);
        for(v1 = 0; v1 < v2; v1 += 2) {
            v0 = v0.add(this.tables[v1 / 2].select(v6[v1])).toExtended();
        }

        return v0;
    }
}

