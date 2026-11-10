package androidx.compose.ui.platform;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A\u001B\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0002H\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"invertTo", "", "Landroidx/compose/ui/graphics/Matrix;", "other", "invertTo-JiSxe2E", "([F[F)Z", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class InvertMatrixKt {
    public static final boolean invertTo-JiSxe2E(float[] arg49, float[] arg50) {
        float[] v0 = arg49;
        float[] v1 = arg50;
        int v4 = 16;
        if(v0.length >= v4) {
            if(v1.length < v4) {
            }
            else {
                float v2 = v0[0];
                float v5 = v0[1];
                float v7 = v0[2];
                int v8 = 3;
                float v9 = v0[v8];
                int v10 = 4;
                float v11 = v0[v10];
                int v12 = 5;
                float v13 = v0[v12];
                int v14 = 6;
                float v15 = v0[v14];
                int v16 = 7;
                float v17 = v0[v16];
                int v18 = 8;
                float v3 = v0[v18];
                int v20 = 9;
                float v4_1 = v0[v20];
                int v22 = 10;
                float v23 = v0[v22];
                int v24 = 11;
                float v25 = v0[v24];
                int v26 = 12;
                int v27 = 2;
                float v6 = v0[v26];
                int v28 = 13;
                float v29 = v0[v28];
                int v30 = 14;
                float v31 = v0[v30];
                int v32 = 15;
                float v0_1 = v0[v32];
                float v33 = v2 * v13 - v5 * v11;
                float v34 = v2 * v15 - v7 * v11;
                float v35 = v2 * v17 - v9 * v11;
                float v36 = v5 * v15 - v7 * v13;
                float v37 = v5 * v17 - v9 * v13;
                float v38 = v7 * v17 - v9 * v15;
                float v39 = v3 * v29 - v4_1 * v6;
                float v40 = v3 * v31 - v23 * v6;
                float v41 = v3 * v0_1 - v25 * v6;
                float v42 = v4_1 * v31 - v23 * v29;
                float v43 = v4_1 * v0_1 - v25 * v29;
                float v44 = v23 * v0_1 - v25 * v31;
                float v45 = v33 * v44 - v34 * v43 + v35 * v42 + v36 * v41 - v37 * v40 + v38 * v39;
                int v46 = Float.compare(v45, 0f);
                if(v46 == 0) {
                }
                else {
                    float v47 = 1f / v45;
                    v1[0] = (v13 * v44 - v15 * v43 + v17 * v42) * v47;
                    v1[1] = (-v5 * v44 + v7 * v43 - v9 * v42) * v47;
                    v1[v27] = (v29 * v38 - v31 * v37 + v0_1 * v36) * v47;
                    v1[v8] = (-v4_1 * v38 + v23 * v37 - v25 * v36) * v47;
                    float v8_1 = -v11;
                    v1[v10] = (v8_1 * v44 + v15 * v41 - v17 * v40) * v47;
                    v1[v12] = (v44 * v2 - v7 * v41 + v9 * v40) * v47;
                    float v10_1 = -v6;
                    v1[v14] = (v10_1 * v38 + v31 * v35 - v0_1 * v34) * v47;
                    v1[v16] = (v38 * v3 - v23 * v35 + v25 * v34) * v47;
                    v1[v18] = (v11 * v43 - v13 * v41 + v17 * v39) * v47;
                    v1[v20] = (-v2 * v43 + v41 * v5 - v9 * v39) * v47;
                    v1[v22] = (v6 * v37 - v29 * v35 + v0_1 * v33) * v47;
                    v1[v24] = (-v3 * v37 + v35 * v4_1 - v25 * v33) * v47;
                    v1[v26] = (v8_1 * v42 + v13 * v40 - v15 * v39) * v47;
                    v1[v28] = (v2 * v42 - v5 * v40 + v7 * v39) * v47;
                    v1[v30] = (v10_1 * v36 + v29 * v34 - v31 * v33) * v47;
                    v1[v32] = (v3 * v36 - v4_1 * v34 + v23 * v33) * v47;
                }

                int v3_1 = v46 == 0 ? 1 : 0;
                return v3_1 ^ 1;
            }
        }

        return 0;
    }
}

