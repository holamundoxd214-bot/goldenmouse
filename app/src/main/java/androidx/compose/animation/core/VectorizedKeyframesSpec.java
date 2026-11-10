package androidx.compose.animation.core;

import androidx.collection.IntList;
import androidx.collection.IntObjectMap;
import androidx.collection.MutableIntList;
import androidx.collection.MutableIntObjectMap;
import java.util.Iterator;
import java.util.Map$Entry;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000v\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0002\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003BE\b\u0000\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0012\u0010\u0006\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\u0007\u0012\u0006\u0010\t\u001A\u00020\n\u0012\u0006\u0010\u000B\u001A\u00020\n\u0012\u0006\u0010\f\u001A\u00020\r\u0012\u0006\u0010\u000E\u001A\u00020\u000F¢\u0006\u0004\b\u0010\u0010\u0011B;\b\u0016\u0012\u001E\u0010\u0006\u001A\u001A\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r0\u00130\u0012\u0012\u0006\u0010\t\u001A\u00020\n\u0012\b\b\u0002\u0010\u000B\u001A\u00020\n¢\u0006\u0004\b\u0010\u0010\u0014J%\u0010&\u001A\u00020\'2\u0006\u0010(\u001A\u00028\u00002\u0006\u0010)\u001A\u00028\u00002\u0006\u0010*\u001A\u00028\u0000H\u0002¢\u0006\u0002\u0010+J-\u0010,\u001A\u00028\u00002\u0006\u0010-\u001A\u00020.2\u0006\u0010(\u001A\u00028\u00002\u0006\u0010)\u001A\u00028\u00002\u0006\u0010*\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010/J-\u00100\u001A\u00028\u00002\u0006\u0010-\u001A\u00020.2\u0006\u0010(\u001A\u00028\u00002\u0006\u0010)\u001A\u00028\u00002\u0006\u0010*\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010/J\u0010\u00101\u001A\u0002022\u0006\u00103\u001A\u00020\nH\u0002J \u00104\u001A\u0002022\u0006\u00105\u001A\u00020\n2\u0006\u00103\u001A\u00020\n2\u0006\u00106\u001A\u000207H\u0002J\u0010\u00108\u001A\u00020\n2\u0006\u00103\u001A\u00020\nH\u0002R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0006\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001A\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016R\u0014\u0010\u000B\u001A\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0016R\u000E\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000E\u001A\u00020\u000FX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018R\u000E\u0010\u0019\u001A\u00020\u001AX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001B\u001A\u00020\u001CX\u0082\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\u001D\u001A\u0004\u0018\u00018\u0000X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u001ER\u0012\u0010\u001F\u001A\u0004\u0018\u00018\u0000X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u001ER\u0012\u0010 \u001A\u0004\u0018\u00018\u0000X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u001ER\u0012\u0010!\u001A\u0004\u0018\u00018\u0000X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u001ER\u000E\u0010\"\u001A\u00020\u001CX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010#\u001A\u00020\u001CX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010$\u001A\u00020%X\u0082\u000E¢\u0006\u0002\n\u0000¨\u00069"}, d2={"Landroidx/compose/animation/core/VectorizedKeyframesSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;", "timestamps", "Landroidx/collection/IntList;", "keyframes", "Landroidx/collection/IntObjectMap;", "Landroidx/compose/animation/core/VectorizedKeyframeSpecElementInfo;", "durationMillis", "", "delayMillis", "defaultEasing", "Landroidx/compose/animation/core/Easing;", "initialArcMode", "Landroidx/compose/animation/core/ArcMode;", "<init>", "(Landroidx/collection/IntList;Landroidx/collection/IntObjectMap;IILandroidx/compose/animation/core/Easing;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "", "Lkotlin/Pair;", "(Ljava/util/Map;II)V", "getDurationMillis", "()I", "getDelayMillis", "I", "modes", "", "times", "", "valueVector", "Landroidx/compose/animation/core/AnimationVector;", "velocityVector", "lastInitialValue", "lastTargetValue", "posArray", "slopeArray", "arcSpline", "Landroidx/compose/animation/core/ArcSpline;", "init", "", "initialValue", "targetValue", "initialVelocity", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)V", "getValueFromNanos", "playTimeNanos", "", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getVelocityFromNanos", "getEasedTime", "", "timeMillis", "getEasedTimeFromIndex", "index", "asFraction", "", "findEntryForTimeMillis", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class VectorizedKeyframesSpec implements VectorizedDurationBasedAnimationSpec {
    public static final int $stable = 8;
    private ArcSpline arcSpline;
    private final Easing defaultEasing;
    private final int delayMillis;
    private final int durationMillis;
    private final int initialArcMode;
    private final IntObjectMap keyframes;
    private AnimationVector lastInitialValue;
    private AnimationVector lastTargetValue;
    private int[] modes;
    private float[] posArray;
    private float[] slopeArray;
    private float[] times;
    private final IntList timestamps;
    private AnimationVector valueVector;
    private AnimationVector velocityVector;

    static {
    }

    public VectorizedKeyframesSpec(IntList arg1, IntObjectMap arg2, int arg3, int arg4, Easing arg5, int arg6, DefaultConstructorMarker arg7) {
        this(arg1, arg2, arg3, arg4, arg5, arg6);
    }

    private VectorizedKeyframesSpec(IntList arg1, IntObjectMap arg2, int arg3, int arg4, Easing arg5, int arg6) {
        super();
        this.timestamps = arg1;
        this.keyframes = arg2;
        this.durationMillis = arg3;
        this.delayMillis = arg4;
        this.defaultEasing = arg5;
        this.initialArcMode = arg6;
        this.modes = VectorizedAnimationSpecKt.EmptyIntArray;
        this.times = VectorizedAnimationSpecKt.EmptyFloatArray;
        this.posArray = VectorizedAnimationSpecKt.EmptyFloatArray;
        this.slopeArray = VectorizedAnimationSpecKt.EmptyFloatArray;
        this.arcSpline = VectorizedAnimationSpecKt.EmptyArcSpline;
    }

    public VectorizedKeyframesSpec(Map arg12, int arg13, int arg14) {
        MutableIntList v0 = new MutableIntList(arg12.size() + 2);
        Iterator v1 = arg12.entrySet().iterator();
        while(v1.hasNext()) {
            v0.add(v1.next().getKey().intValue());
        }

        if(!arg12.containsKey(Integer.valueOf(0))) {
            v0.add(0, 0);
        }

        if(!arg12.containsKey(Integer.valueOf(arg13))) {
            v0.add(arg13);
        }

        v0.sort();
        MutableIntList v4 = v0;
        DefaultConstructorMarker v3 = null;
        MutableIntObjectMap v0_1 = new MutableIntObjectMap(0, 1, v3);
        Iterator v12 = arg12.entrySet().iterator();
        while(v12.hasNext()) {
            Object v1_1 = v12.next();
            int v2 = ((Map$Entry)v1_1).getKey().intValue();
            v1_1 = ((Map$Entry)v1_1).getValue();
            v0_1.set(v2, new VectorizedKeyframeSpecElementInfo(((Pair)v1_1).getFirst(), ((Pair)v1_1).getSecond(), ArcMode.Companion.getArcLinear--9T-Mq4(), v3));
        }

        this(((IntList)v4), v0_1, arg13, arg14, EasingKt.getLinearEasing(), ArcMode.Companion.getArcLinear--9T-Mq4(), null);
    }

    public VectorizedKeyframesSpec(Map arg1, int arg2, int arg3, int arg4, DefaultConstructorMarker arg5) {
        this(arg1, arg2, 0);
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

    private final float getEasedTime(int arg3) {
        return this.getEasedTimeFromIndex(this.findEntryForTimeMillis(arg3), arg3, false);
    }

    private final float getEasedTimeFromIndex(int arg4, int arg5, boolean arg6) {
        Easing v2_1;
        int v0;
        float v3;
        float v1 = 1000f;
        if(arg4 >= this.timestamps._size - 1) {
            v3 = ((float)arg5);
        }
        else {
            v0 = this.timestamps.get(arg4);
            arg4 = this.timestamps.get(arg4 + 1);
            if(arg5 == v0) {
                v3 = ((float)v0);
            }
            else {
                goto label_16;
            }
        }

        return v3 / v1;
    label_16:
        arg4 -= v0;
        Object v2 = this.keyframes.get(v0);
        if(v2 != null) {
            v2_1 = ((VectorizedKeyframeSpecElementInfo)v2).getEasing();
            if(v2_1 == null) {
                goto label_22;
            }
        }
        else {
        label_22:
            v2_1 = this.defaultEasing;
        }

        float v4 = ((float)arg4);
        v3 = v2_1.transform((((float)(arg5 - v0))) / v4);
        if(arg6) {
            return v3;
        }

        return (v4 * v3 + (((float)v0))) / v1;
    }

    public AnimationVector getValueFromNanos(long arg5, AnimationVector arg7, AnimationVector arg8, AnimationVector arg9) {
        int v4;
        float v5_1;
        int v5 = ((int)VectorizedAnimationSpecKt.clampPlayTime(this, arg5 / 1000000));
        Object v6 = this.keyframes.get(v5);
        if(v6 != null) {
            return ((VectorizedKeyframeSpecElementInfo)v6).getVectorValue();
        }

        if(v5 >= this.getDurationMillis()) {
            return arg8;
        }

        if(v5 <= 0) {
            return arg7;
        }

        this.init(arg7, arg8, arg9);
        AnimationVector v6_1 = this.valueVector;
        Intrinsics.checkNotNull(v6_1);
        int v1 = 0;
        if(this.arcSpline != VectorizedAnimationSpecKt.EmptyArcSpline) {
            v5_1 = this.getEasedTime(v5);
            float[] v7 = this.posArray;
            this.arcSpline.getPos(v5_1, v7);
            v4 = v7.length;
            while(v1 < v4) {
                v6_1.set$animation_core(v1, v7[v1]);
                ++v1;
            }
        }
        else {
            int v9 = this.findEntryForTimeMillis(v5);
            v5_1 = this.getEasedTimeFromIndex(v9, v5, true);
            Object v2 = this.keyframes.get(this.timestamps.get(v9));
            if(v2 != null) {
                AnimationVector v2_1 = ((VectorizedKeyframeSpecElementInfo)v2).getVectorValue();
                if(v2_1 == null) {
                }
                else {
                    arg7 = v2_1;
                }
            }

            Object v4_1 = this.keyframes.get(this.timestamps.get(v9 + 1));
            if(v4_1 != null) {
                AnimationVector v4_2 = ((VectorizedKeyframeSpecElementInfo)v4_1).getVectorValue();
                if(v4_2 == null) {
                }
                else {
                    arg8 = v4_2;
                }
            }

            v4 = v6_1.getSize$animation_core();
            while(v1 < v4) {
                v6_1.set$animation_core(v1, arg7.get$animation_core(v1) * (1f - v5_1) + arg8.get$animation_core(v1) * v5_1);
                ++v1;
            }
        }

        return v6_1;
    }

    public AnimationVector getVelocityFromNanos(long arg9, AnimationVector arg11, AnimationVector arg12, AnimationVector arg13) {
        arg9 = VectorizedAnimationSpecKt.clampPlayTime(this, arg9 / 1000000);
        if(arg9 < 0) {
            return arg13;
        }

        this.init(arg11, arg12, arg13);
        AnimationVector v6 = this.velocityVector;
        Intrinsics.checkNotNull(v6);
        int v7 = 0;
        if(this.arcSpline != VectorizedAnimationSpecKt.EmptyArcSpline) {
            float v9 = this.getEasedTime(((int)arg9));
            float[] v10 = this.slopeArray;
            this.arcSpline.getSlope(v9, v10);
            int v8 = v10.length;
            while(v7 < v8) {
                v6.set$animation_core(v7, v10[v7]);
                ++v7;
            }
        }
        else {
            VectorizedKeyframesSpec v0 = this;
            AnimationVector v8_1 = VectorizedAnimationSpecKt.getValueFromMillis(((VectorizedAnimationSpec)v0), arg9 - 1, arg11, arg12, arg13);
            AnimationVector v9_1 = VectorizedAnimationSpecKt.getValueFromMillis(((VectorizedAnimationSpec)v0), arg9, arg11, arg12, arg13);
            int v10_1 = v8_1.getSize$animation_core();
            while(v7 < v10_1) {
                v6.set$animation_core(v7, (v8_1.get$animation_core(v7) - v9_1.get$animation_core(v7)) * 1000f);
                ++v7;
            }
        }

        return v6;
    }

    private final void init(AnimationVector arg9, AnimationVector arg10, AnimationVector arg11) {
        float[] v4_1;
        int v5_1;
        Object v5;
        int v11;
        int v0 = this.arcSpline != VectorizedAnimationSpecKt.EmptyArcSpline ? 1 : 0;
        if(this.valueVector == null) {
            this.valueVector = AnimationVectorsKt.newInstance(arg9);
            this.velocityVector = AnimationVectorsKt.newInstance(arg11);
            v11 = this.timestamps._size;
            float[] v1 = new float[v11];
            int v4;
            for(v4 = 0; v4 < v11; ++v4) {
                v1[v4] = (((float)this.timestamps.get(v4))) / 1000f;
            }

            this.times = v1;
            v11 = this.timestamps._size;
            int[] v1_1 = new int[v11];
            for(v4 = 0; v4 < v11; ++v4) {
                v5 = this.keyframes.get(this.timestamps.get(v4));
                v5_1 = v5 != null ? ((VectorizedKeyframeSpecElementInfo)v5).getArcMode--9T-Mq4() : this.initialArcMode;
                if(!ArcMode.equals-impl0(v5_1, ArcMode.Companion.getArcLinear--9T-Mq4())) {
                    v0 = 1;
                }

                v1_1[v4] = v5_1;
            }

            this.modes = v1_1;
        }

        if(v0 == 0) {
        }
        else {
            if(this.arcSpline != VectorizedAnimationSpecKt.EmptyArcSpline && (Intrinsics.areEqual(this.lastInitialValue, arg9))) {
                if(!Intrinsics.areEqual(this.lastTargetValue, arg10)) {
                }
                else {
                    return;
                }
            }

            goto label_63;
        }

        return;
    label_63:
        this.lastInitialValue = arg9;
        this.lastTargetValue = arg10;
        v11 = arg9.getSize$animation_core() % 2 + arg9.getSize$animation_core();
        this.posArray = new float[v11];
        this.slopeArray = new float[v11];
        v0 = this.timestamps._size;
        float[][] v1_2 = new float[v0][];
        int v3;
        for(v3 = 0; v3 < v0; ++v3) {
            v4 = this.timestamps.get(v3);
            v5 = this.keyframes.get(v4);
            if(v4 != 0 || v5 != null) {
                if(v4 == this.getDurationMillis() && v5 == null) {
                    v4_1 = new float[v11];
                    v5_1 = 0;
                    while(true) {
                        if(v5_1 < v11) {
                            v4_1[v5_1] = arg10.get$animation_core(v5_1);
                            ++v5_1;
                            continue;
                        }
                        else {
                            goto label_111;
                        }
                    }
                }

                Intrinsics.checkNotNull(v5);
                AnimationVector v4_2 = ((VectorizedKeyframeSpecElementInfo)v5).getVectorValue();
                float[] v5_2 = new float[v11];
                int v6;
                for(v6 = 0; v6 < v11; ++v6) {
                    v5_2[v6] = v4_2.get$animation_core(v6);
                }

                v4_1 = v5_2;
            }
            else {
                v4_1 = new float[v11];
                for(v5_1 = 0; v5_1 < v11; ++v5_1) {
                    v4_1[v5_1] = arg9.get$animation_core(v5_1);
                }
            }

        label_111:
            v1_2[v3] = v4_1;
        }

        this.arcSpline = new ArcSpline(this.modes, this.times, v1_2);
    }
}

