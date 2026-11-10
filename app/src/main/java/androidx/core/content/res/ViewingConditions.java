package androidx.core.content.res;

final class ViewingConditions {
    static final ViewingConditions DEFAULT;
    private final float mAw;
    private final float mC;
    private final float mFl;
    private final float mFlRoot;
    private final float mN;
    private final float mNbb;
    private final float mNc;
    private final float mNcb;
    private final float[] mRgbD;
    private final float mZ;

    static {
        ViewingConditions.DEFAULT = ViewingConditions.make(CamUtils.WHITE_POINT_D65, ((float)((((double)CamUtils.yFromLStar(50f))) * 63.661977 / 100)), 50f, 2f, false);
    }

    private ViewingConditions(float arg1, float arg2, float arg3, float arg4, float arg5, float arg6, float[] arg7, float arg8, float arg9, float arg10) {
        super();
        this.mN = arg1;
        this.mAw = arg2;
        this.mNbb = arg3;
        this.mNcb = arg4;
        this.mC = arg5;
        this.mNc = arg6;
        this.mRgbD = arg7;
        this.mFl = arg8;
        this.mFlRoot = arg9;
        this.mZ = arg10;
    }

    float getAw() {
        return this.mAw;
    }

    float getC() {
        return this.mC;
    }

    float getFl() {
        return this.mFl;
    }

    float getFlRoot() {
        return this.mFlRoot;
    }

    float getN() {
        return this.mN;
    }

    float getNbb() {
        return this.mNbb;
    }

    float getNc() {
        return this.mNc;
    }

    float getNcb() {
        return this.mNcb;
    }

    float[] getRgbD() {
        return this.mRgbD;
    }

    float getZ() {
        return this.mZ;
    }

    static ViewingConditions make(float[] arg22, float arg23, float arg24, float arg25, boolean arg26) {
        float v0 = arg23;
        float[][] v1 = CamUtils.XYZ_TO_CAM16RGB;
        float v3 = arg22[0];
        float[] v4 = v1[0];
        float v5 = v4[0] * v3;
        float v7 = arg22[1];
        v5 += v4[1] * v7;
        int v8 = 2;
        float v9 = arg22[v8];
        v5 += v4[v8] * v9;
        float v10 = v1[1][0] * v3 + v1[1][1] * v7 + v1[1][v8] * v9;
        v3 = v3 * v1[v8][0] + v7 * v1[v8][1] + v9 * v1[v8][v8];
        float v1_1 = 10f;
        v7 = 0.8f;
        float v4_1 = arg25 / v1_1 + v7;
        float v11 = 0.59f;
        v1_1 = Double.compare(((double)v4_1), 0.9) >= 0 ? CamUtils.lerp(v11, 0.69f, (v4_1 - 0.9f) * v1_1) : CamUtils.lerp(0.525f, v11, (v4_1 - v7) * v1_1);
        float v16 = v1_1;
        v1_1 = 1f;
        v7 = arg26 ? v1_1 : (v1_1 - (((float)Math.exp(((double)((-v0 - 42f) / 92f))))) * 0.277778f) * v4_1;
        double v11_1 = ((double)v7);
        if(v11_1 > 1) {
            v7 = v1_1;
        }
        else if(v11_1 < 0) {
            v7 = 0f;
        }

        float[] v13 = new float[3];
        v13[0] = 100f / v5 * v7 + v1_1 - v7;
        v13[1] = 100f / v10 * v7 + v1_1 - v7;
        v13[v8] = 100f / v3 * v7 + v1_1 - v7;
        v9 = v1_1 / (5f * v0 + v1_1);
        v11 = v9 * v9 * v9 * v9;
        v1_1 -= v11;
        v11 = v11 * v0 + 0.1f * v1_1 * v1_1 * (((float)Math.cbrt((((double)v0)) * 5)));
        float v12 = CamUtils.yFromLStar(arg24) / arg22[1];
        double v0_1 = ((double)v12);
        float v21 = (((float)Math.sqrt(v0_1))) + 1.48f;
        float v14 = 0.725f / (((float)Math.pow(v0_1, 0.2)));
        v0 = ((float)Math.pow((((double)(v13[0] * v11 * v5))) / 100, 0.42));
        v1_1 = ((float)Math.pow((((double)(v13[1] * v11 * v10))) / 100, 0.42));
        float v2 = ((float)Math.pow((((double)(v13[v8] * v11 * v3))) / 100, 0.42));
        float[] v3_1 = new float[3];
        v3_1[0] = v0;
        v3_1[1] = v1_1;
        v3_1[v8] = v2;
        v2 = v3_1[0] * 400f / (v3_1[0] + 27.129999f);
        float v6 = v3_1[1] * 400f / (v3_1[1] + 27.129999f);
        v1_1 = 400f * v3_1[v8] / (v3_1[v8] + 27.129999f);
        float[] v0_2 = new float[3];
        v0_2[0] = v2;
        v0_2[1] = v6;
        v0_2[v8] = v1_1;
        return new ViewingConditions(v12, (v0_2[0] * 2f + v0_2[1] + v0_2[v8] * 0.05f) * v14, v14, v14, v16, v4_1, v13, v11, ((float)Math.pow(((double)v11), 0.25)), v21);
    }
}

