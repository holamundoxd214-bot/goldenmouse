package androidx.compose.animation.core;

import androidx.collection.IntList;
import androidx.collection.IntObjectMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\b\u0001\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003BA\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0018\u0010\u0006\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\b0\u0007\u0012\u0006\u0010\n\u001A\u00020\u000B\u0012\u0006\u0010\f\u001A\u00020\u000B\u0012\u0006\u0010\r\u001A\u00020\u000E¢\u0006\u0004\b\u000F\u0010\u0010J%\u0010 \u001A\u00020!2\u0006\u0010\"\u001A\u00028\u00002\u0006\u0010#\u001A\u00028\u00002\u0006\u0010$\u001A\u00028\u0000H\u0002¢\u0006\u0002\u0010%J-\u0010&\u001A\u00028\u00002\u0006\u0010\'\u001A\u00020(2\u0006\u0010\"\u001A\u00028\u00002\u0006\u0010#\u001A\u00028\u00002\u0006\u0010$\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010)J-\u0010*\u001A\u00028\u00002\u0006\u0010\'\u001A\u00020(2\u0006\u0010\"\u001A\u00028\u00002\u0006\u0010#\u001A\u00028\u00002\u0006\u0010$\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010)J\u0010\u0010+\u001A\u00020\t2\u0006\u0010,\u001A\u00020\u000BH\u0002J\u0018\u0010-\u001A\u00020\u000E2\u0006\u0010,\u001A\u00020\u000B2\u0006\u0010.\u001A\u00020\u000BH\u0002J\u0010\u0010/\u001A\u00020\u000B2\u0006\u0010.\u001A\u00020\u000BH\u0002R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0006\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001A\u00020\u000BX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0014\u0010\f\u001A\u00020\u000BX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0012R\u000E\u0010\r\u001A\u00020\u000EX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001A\u0004\u0018\u00018\u0000X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0015R\u0012\u0010\u0016\u001A\u0004\u0018\u00018\u0000X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0015R\u000E\u0010\u0017\u001A\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001A\u0004\u0018\u00010\u001AX\u0082\u000E¢\u0006\u0002\n\u0000R\u0018\u0010\u001B\u001A\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001CX\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u001DR\u0012\u0010\u001E\u001A\u0004\u0018\u00018\u0000X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0015R\u0012\u0010\u001F\u001A\u0004\u0018\u00018\u0000X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0015¨\u00060"}, d2={"Landroidx/compose/animation/core/VectorizedMonoSplineKeyframesSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;", "timestamps", "Landroidx/collection/IntList;", "keyframes", "Landroidx/collection/IntObjectMap;", "Lkotlin/Pair;", "Landroidx/compose/animation/core/Easing;", "durationMillis", "", "delayMillis", "periodicBias", "", "<init>", "(Landroidx/collection/IntList;Landroidx/collection/IntObjectMap;IIF)V", "getDurationMillis", "()I", "getDelayMillis", "valueVector", "Landroidx/compose/animation/core/AnimationVector;", "velocityVector", "times", "", "monoSpline", "Landroidx/compose/animation/core/MonoSpline;", "values", "", "[[F", "lastInitialValue", "lastTargetValue", "init", "", "initialValue", "targetValue", "initialVelocity", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)V", "getValueFromNanos", "playTimeNanos", "", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getVelocityFromNanos", "getEasing", "index", "getEasedTimeFromIndex", "timeMillis", "findEntryForTimeMillis", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class VectorizedMonoSplineKeyframesSpec implements VectorizedDurationBasedAnimationSpec {
    public static final int $stable = 8;
    private final int delayMillis;
    private final int durationMillis;
    private final IntObjectMap keyframes;
    private AnimationVector lastInitialValue;
    private AnimationVector lastTargetValue;
    private MonoSpline monoSpline;
    private final float periodicBias;
    private float[] times;
    private final IntList timestamps;
    private AnimationVector valueVector;
    private float[][] values;
    private AnimationVector velocityVector;

    static {
    }

    public VectorizedMonoSplineKeyframesSpec(IntList arg1, IntObjectMap arg2, int arg3, int arg4, float arg5) {
        super();
        this.timestamps = arg1;
        this.keyframes = arg2;
        this.durationMillis = arg3;
        this.delayMillis = arg4;
        this.periodicBias = arg5;
    }

    private final int findEntryForTimeMillis(int arg7) {
        int v6 = IntList.binarySearch$default(this.timestamps, arg7, 0, 0, 6, null);
        if(v6 < -1) {
            v6 = -(v6 + 2);
        }

        return v6;
    }

    public int getDelayMillis() {
        return this.delayMillis;
    }

    public int getDurationMillis() {
        return this.durationMillis;
    }

    private final float getEasedTimeFromIndex(int arg5, int arg6) {
        int v2;
        int v0;
        float v4;
        float v1 = 1000f;
        if(arg5 >= this.timestamps._size - 1) {
            v4 = ((float)arg6);
        }
        else {
            v0 = this.timestamps.get(arg5);
            v2 = this.timestamps.get(arg5 + 1);
            if(arg6 == v0) {
                v4 = ((float)v0);
            }
            else {
                goto label_16;
            }
        }

        return v4 / v1;
    label_16:
        Easing v4_1 = this.getEasing(arg5);
        float v5 = ((float)(arg6 - v0));
        float v6 = ((float)(v2 - v0));
        return (v6 * v4_1.transform(v5 / v6) + (((float)v0))) / v1;
    }

    private final Easing getEasing(int arg2) {
        Object v1 = this.keyframes.get(this.timestamps.get(arg2));
        if(v1 != null) {
            v1 = ((Pair)v1).getSecond();
            if(v1 == null) {
            }
            else {
                return ((Easing)v1);
            }
        }

        return EasingKt.getLinearEasing();
    }

    public AnimationVector getValueFromNanos(long arg3, AnimationVector arg5, AnimationVector arg6, AnimationVector arg7) {
        int v3 = ((int)VectorizedAnimationSpecKt.clampPlayTime(this, arg3 / 1000000));
        Object v4 = this.keyframes.get(v3);
        if(v4 != null) {
            return ((Pair)v4).getFirst();
        }

        if(v3 >= this.getDurationMillis()) {
            return arg6;
        }

        if(v3 <= 0) {
            return arg5;
        }

        this.init(arg5, arg6, arg7);
        int v4_1 = this.findEntryForTimeMillis(v3);
        arg5 = this.valueVector;
        Intrinsics.checkNotNull(arg5);
        MonoSpline v6 = this.monoSpline;
        Intrinsics.checkNotNull(v6);
        v6.getPos(this.getEasedTimeFromIndex(v4_1, v3), arg5, v4_1);
        return arg5;
    }

    public AnimationVector getVelocityFromNanos(long arg3, AnimationVector arg5, AnimationVector arg6, AnimationVector arg7) {
        int v3 = ((int)VectorizedAnimationSpecKt.clampPlayTime(this, arg3 / 1000000));
        this.init(arg5, arg6, arg7);
        int v4 = this.findEntryForTimeMillis(v3);
        arg5 = this.velocityVector;
        Intrinsics.checkNotNull(arg5);
        MonoSpline v6 = this.monoSpline;
        Intrinsics.checkNotNull(v6);
        v6.getSlope(this.getEasedTimeFromIndex(v4, v3), arg5, v4);
        return arg5;
    }

    private final void init(AnimationVector arg11, AnimationVector arg12, AnimationVector arg13) {
        float[] v4_1;
        int v13;
        int v1 = 0;
        if(this.valueVector == null) {
            this.valueVector = AnimationVectorsKt.newInstance(arg11);
            this.velocityVector = AnimationVectorsKt.newInstance(arg13);
            v13 = this.timestamps._size;
            float[] v0 = new float[v13];
            int v2;
            for(v2 = 0; v2 < v13; ++v2) {
                v0[v2] = (((float)this.timestamps.get(v2))) / 1000f;
            }

            this.times = v0;
        }

        if(this.monoSpline != null && (Intrinsics.areEqual(this.lastInitialValue, arg11))) {
            if(!Intrinsics.areEqual(this.lastTargetValue, arg12)) {
            }
            else {
                return;
            }
        }

        boolean v13_1 = Intrinsics.areEqual(this.lastInitialValue, arg11);
        boolean v0_1 = Intrinsics.areEqual(this.lastTargetValue, arg12);
        this.lastInitialValue = arg11;
        this.lastTargetValue = arg12;
        v2 = arg11.getSize$animation_core();
        float[][] v3 = this.values;
        if(v3 == null) {
            v13 = this.timestamps._size;
            v3 = new float[v13][];
            int v0_2;
            for(v0_2 = 0; v0_2 < v13; ++v0_2) {
                int v4 = this.timestamps.get(v0_2);
                Object v5 = this.keyframes.get(v4);
                if(v4 != 0 || v5 != null) {
                    if(v4 == this.getDurationMillis() && v5 == null) {
                        v4_1 = new float[v2];
                        v5_1 = 0;
                        while(true) {
                            if(v5_1 < v2) {
                                v4_1[v5_1] = arg12.get$animation_core(v5_1);
                                ++v5_1;
                                continue;
                            }
                            else {
                                goto label_78;
                            }
                        }
                    }

                    Intrinsics.checkNotNull(v5);
                    Object v4_2 = ((Pair)v5).getFirst();
                    float[] v5_2 = new float[v2];
                    int v6;
                    for(v6 = 0; v6 < v2; ++v6) {
                        v5_2[v6] = ((AnimationVector)v4_2).get$animation_core(v6);
                    }

                    v4_1 = v5_2;
                }
                else {
                    v4_1 = new float[v2];
                    int v5_1;
                    for(v5_1 = 0; v5_1 < v2; ++v5_1) {
                        v4_1[v5_1] = arg11.get$animation_core(v5_1);
                    }
                }

            label_78:
                v3[v0_2] = v4_1;
            }

            this.values = v3;
        }
        else {
            if(!v13_1 && !this.keyframes.containsKey(0)) {
                v13 = IntList.binarySearch$default(this.timestamps, 0, 0, 0, 6, null);
                v4_1 = new float[v2];
                for(v5_1 = 0; v5_1 < v2; ++v5_1) {
                    v4_1[v5_1] = arg11.get$animation_core(v5_1);
                }

                v3[v13] = v4_1;
            }

            if(v0_1) {
                goto label_121;
            }

            if(this.keyframes.containsKey(this.getDurationMillis())) {
                goto label_121;
            }

            int v11 = IntList.binarySearch$default(this.timestamps, this.getDurationMillis(), 0, 0, 6, null);
            float[] v13_2 = new float[v2];
            while(v1 < v2) {
                v13_2[v1] = arg12.get$animation_core(v1);
                ++v1;
            }

            v3[v11] = v13_2;
        }

    label_121:
        float[] v12 = this.times;
        if(v12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("times");
            v12 = null;
        }

        this.monoSpline = new MonoSpline(v12, v3, this.periodicBias);
    }
}

