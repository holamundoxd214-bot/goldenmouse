package androidx.compose.animation.core;

import kotlin.Metadata;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0012\u001A\u00020\u00032\u0006\u0010\u0013\u001A\u00020\u00032\u0006\u0010\u0014\u001A\u00020\u0003J\'\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0013\u001A\u00020\u00032\u0006\u0010\u0014\u001A\u00020\u00032\u0006\u0010\u0017\u001A\u00020\u0018H\u0000¢\u0006\u0004\b\u0019\u0010\u001AR\u001A\u0010\u0002\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u000E\u0010\t\u001A\u00020\nX\u0082\u000E¢\u0006\u0002\n\u0000R$\u0010\f\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00020\u00038F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b\r\u0010\u0007\"\u0004\b\u000E\u0010\u0005R$\u0010\u000F\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00020\u0003@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\u0005¨\u0006\u001B"}, d2={"Landroidx/compose/animation/core/SpringSimulation;", "", "finalPosition", "", "<init>", "(F)V", "getFinalPosition", "()F", "setFinalPosition", "naturalFreq", "", "value", "stiffness", "getStiffness", "setStiffness", "dampingRatio", "getDampingRatio", "setDampingRatio", "getAcceleration", "lastDisplacement", "lastVelocity", "updateValues", "Landroidx/compose/animation/core/Motion;", "timeElapsed", "", "updateValues-IJZedt4$animation_core", "(FFJ)J", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SpringSimulation {
    public static final int $stable = 8;
    private float dampingRatio;
    private float finalPosition;
    private double naturalFreq;

    static {
    }

    public SpringSimulation(float arg3) {
        super();
        this.finalPosition = arg3;
        this.naturalFreq = Math.sqrt(50);
        this.dampingRatio = 1f;
    }

    public final float getAcceleration(float arg7, float arg8) {
        return ((float)(-(this.naturalFreq * this.naturalFreq) * (((double)(arg7 - this.finalPosition))) - this.naturalFreq * 2 * (((double)this.dampingRatio)) * (((double)arg8))));
    }

    public final float getDampingRatio() {
        return this.dampingRatio;
    }

    public final float getFinalPosition() {
        return this.finalPosition;
    }

    public final float getStiffness() {
        return ((float)(this.naturalFreq * this.naturalFreq));
    }

    public final void setDampingRatio(float arg2) {
        if(arg2 < 0f) {
            PreconditionsKt.throwIllegalArgumentException("Damping ratio must be non-negative");
        }

        this.dampingRatio = arg2;
    }

    public final void setFinalPosition(float arg1) {
        this.finalPosition = arg1;
    }

    public final void setStiffness(float arg3) {
        if(this.getStiffness() <= 0f) {
            PreconditionsKt.throwIllegalArgumentException("Spring stiffness constant must be positive.");
        }

        this.naturalFreq = Math.sqrt(((double)arg3));
    }

    public final long updateValues-IJZedt4$animation_core(float arg21, float arg22, long arg23) {
        double v1_1;
        double v12_1;
        double v5_1;
        SpringSimulation v0 = this;
        float v1 = arg22;
        float v2 = arg21 - v0.finalPosition;
        double v3 = (((double)arg23)) / 1000;
        float v5 = v0.dampingRatio;
        double v6 = (((double)v5)) * (((double)v5));
        double v10 = v0.naturalFreq;
        double v8 = (((double)(-v5))) * v10;
        float v12 = 1f;
        double v14 = 1;
        if(Float.compare(v5, v12) > 0) {
            v10 *= Math.sqrt(v6 - v14);
            v5_1 = v8 + v10;
            v8 -= v10;
            v10 = ((double)v2);
            v12_1 = (v8 * v10 - (((double)v1))) / (v8 - v5_1);
            v10 -= v12_1;
            v1_1 = v8 * v3;
            v3 *= v5_1;
            v14 = Math.exp(v1_1) * v10 + Math.exp(v3) * v12_1;
            v10 = v10 * v8 * Math.exp(v1_1) + v12_1 * v5_1 * Math.exp(v3);
        }
        else if(v5 == v12) {
            v5_1 = ((double)v1);
            v1_1 = ((double)v2);
            v5_1 += v10 * v1_1;
            double v7 = -v10 * v3;
            v1_1 += v3 * v5_1;
            v14 = v1_1 * Math.exp(v7);
            v10 = v1_1 * Math.exp(v7) * -v0.naturalFreq + v5_1 * Math.exp(v7);
        }
        else {
            v10 *= Math.sqrt(v14 - v6);
            v12_1 = ((double)v2);
            v14 = v14 / v10 * (-v8 * v12_1 + (((double)v1)));
            v1_1 = v10 * v3;
            v3 *= v8;
            v5_1 = Math.exp(v3) * (Math.cos(v1_1) * v12_1 + Math.sin(v1_1) * v14);
            v10 = v8 * v5_1 + Math.exp(v3) * (-v10 * v12_1 * Math.sin(v1_1) + v10 * v14 * Math.cos(v1_1));
            v14 = v5_1;
        }

        return Motion.constructor-impl((((long)Float.floatToRawIntBits(((float)v10)))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(((float)(v14 + (((double)v0.finalPosition))))))) << 0x20);
    }
}

