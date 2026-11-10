package androidx.compose.animation;

import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;

@Metadata(d1={"\u0000,\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001A \u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\u000B\u001A\u00020\fH\u0002\u001A\u001A\u0010\r\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u000E\"\u0004\b\u0000\u0010\u000F2\u0006\u0010\u0010\u001A\u00020\u0011\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0002\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0003\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0004\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0005\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2={"Inflection", "", "StartTension", "EndTension", "P1", "P2", "computeSplineInfo", "", "splinePositions", "", "splineTimes", "nbSamples", "", "splineBasedDecay", "Landroidx/compose/animation/core/DecayAnimationSpec;", "T", "density", "Landroidx/compose/ui/unit/Density;", "animation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SplineBasedDecayKt {
    private static final float EndTension = 1f;
    private static final float Inflection = 0.35f;
    private static final float P1 = 0.175f;
    private static final float P2 = 0.35f;
    private static final float StartTension = 0.5f;

    public static final void access$computeSplineInfo(float[] arg0, float[] arg1, int arg2) {
        SplineBasedDecayKt.computeSplineInfo(arg0, arg1, arg2);
    }

    private static final void computeSplineInfo(float[] arg21, float[] arg22, int arg23) {
        float v9;
        float v8;
        float v18;
        float v16;
        float v17;
        float v15;
        float v14;
        float v12;
        float v10;
        float v11;
        float v7;
        float v4;
        int v0 = arg23;
        float v1 = 0f;
        int v3 = 0;
        float v2 = 0f;
        while(true) {
            v4 = 1f;
            if(v3 >= v0) {
                break;
            }

            float v5 = (((float)v3)) / (((float)v0));
            float v6 = v4;
            while(true) {
                v7 = (v6 - v1) / 2f + v1;
                v11 = v4 - v7;
                v10 = v7 * 3f * v11;
                v12 = 0.175f;
                v14 = 0.35f;
                v15 = v7 * v7 * v7;
                float v13 = (v11 * v12 + v7 * v14) * v10 + v15;
                v17 = v4;
                v16 = 2f;
                v18 = 3f;
                double v19 = 0.00001;
                if((((double)Math.abs(v13 - v5))) < v19) {
                    break;
                }

                if(v13 > v5) {
                    v6 = v7;
                }
                else {
                    v1 = v7;
                }

                v4 = v17;
            }

            v4 = 0.5f;
            arg21[v3] = v10 * (v11 * v4 + v7) + v15;
            v6 = v17;
            while(true) {
                v7 = (v6 - v2) / v16 + v2;
                v8 = v17 - v7;
                v9 = v7 * v18 * v8;
                v11 = v7 * v7 * v7;
                v10 = (v8 * v4 + v7) * v9 + v11;
                v15 = v5;
                if((((double)Math.abs(v10 - v5))) < v19) {
                    break;
                }

                if(v10 > v15) {
                    v6 = v7;
                }
                else {
                    v2 = v7;
                }

                v5 = v15;
                v4 = 0.5f;
            }

            arg22[v3] = v9 * (v8 * v12 + v7 * v14) + v11;
            ++v3;
        }

        arg22[v0] = v4;
        arg21[v0] = v4;
    }

    public static final DecayAnimationSpec splineBasedDecay(Density arg1) {
        return DecayAnimationSpecKt.generateDecayAnimationSpec(new SplineBasedFloatDecayAnimationSpec(arg1));
    }
}

