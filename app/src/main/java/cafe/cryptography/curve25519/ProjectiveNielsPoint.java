package cafe.cryptography.curve25519;

import cafe.cryptography.subtle.ConstantTime;

class ProjectiveNielsPoint {
    class LookupTable {
        private final ProjectiveNielsPoint[] table;

        LookupTable(ProjectiveNielsPoint[] arg1) {
            super();
            this.table = arg1;
        }

        ProjectiveNielsPoint select(int arg6) {
            if(arg6 >= -8 && arg6 <= 8) {
                int v0 = ConstantTime.isNegative(arg6);
                int v2 = 1;
                arg6 -= (-v0 & arg6) << 1;
                ProjectiveNielsPoint v1 = ProjectiveNielsPoint.IDENTITY;
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
        private final ProjectiveNielsPoint[] table;

        NafLookupTable(ProjectiveNielsPoint[] arg1) {
            super();
            this.table = arg1;
        }

        ProjectiveNielsPoint select(int arg2) {
            if(arg2 % 2 != 0 && arg2 < 16) {
                return this.table[arg2 / 2];
            }

            throw new IllegalArgumentException("invalid x");
        }
    }

    static final ProjectiveNielsPoint IDENTITY;
    final FieldElement T2D;
    final FieldElement YMinusX;
    final FieldElement YPlusX;
    final FieldElement Z;

    static {
        ProjectiveNielsPoint.IDENTITY = new ProjectiveNielsPoint(FieldElement.ONE, FieldElement.ONE, FieldElement.ONE, FieldElement.ZERO);
    }

    ProjectiveNielsPoint(FieldElement arg1, FieldElement arg2, FieldElement arg3, FieldElement arg4) {
        super();
        this.YPlusX = arg1;
        this.YMinusX = arg2;
        this.Z = arg3;
        this.T2D = arg4;
    }

    static LookupTable buildLookupTable(EdwardsPoint arg3) {
        ProjectiveNielsPoint[] v0 = new ProjectiveNielsPoint[8];
        int v2 = 0;
        v0[0] = arg3.toProjectiveNiels();
        while(v2 < 7) {
            int v1 = v2 + 1;
            v0[v1] = arg3.add(v0[v2]).toExtended().toProjectiveNiels();
            v2 = v1;
        }

        return new LookupTable(v0);
    }

    static NafLookupTable buildNafLookupTable(EdwardsPoint arg3) {
        ProjectiveNielsPoint[] v0 = new ProjectiveNielsPoint[8];
        int v2 = 0;
        v0[0] = arg3.toProjectiveNiels();
        arg3 = arg3.dbl();
        while(v2 < 7) {
            int v1 = v2 + 1;
            v0[v1] = arg3.add(v0[v2]).toExtended().toProjectiveNiels();
            v2 = v1;
        }

        return new NafLookupTable(v0);
    }

    public ProjectiveNielsPoint ctSelect(ProjectiveNielsPoint arg6, int arg7) {
        return new ProjectiveNielsPoint(this.YPlusX.ctSelect(arg6.YPlusX, arg7), this.YMinusX.ctSelect(arg6.YMinusX, arg7), this.Z.ctSelect(arg6.Z, arg7), this.T2D.ctSelect(arg6.T2D, arg7));
    }

    public ProjectiveNielsPoint negate() {
        return new ProjectiveNielsPoint(this.YMinusX, this.YPlusX, this.Z, this.T2D.negate());
    }
}

