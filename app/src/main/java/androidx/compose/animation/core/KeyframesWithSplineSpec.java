package androidx.compose.animation.core;

import androidx.collection.IntObjectMap;
import androidx.collection.MutableIntList;
import androidx.collection.MutableIntObjectMap;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u0012B\u0015\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006B!\b\u0016\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\b\b\u0001\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\u0005\u0010\tJ,\u0010\f\u001A\b\u0012\u0004\u0012\u0002H\u000E0\r\"\b\b\u0001\u0010\u000E*\u00020\u000F2\u0012\u0010\u0010\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u000E0\u0011H\u0016R\u0017\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u000E\u0010\u0007\u001A\u00020\bX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2={"Landroidx/compose/animation/core/KeyframesWithSplineSpec;", "T", "Landroidx/compose/animation/core/DurationBasedAnimationSpec;", "config", "Landroidx/compose/animation/core/KeyframesWithSplineSpec$KeyframesWithSplineSpecConfig;", "<init>", "(Landroidx/compose/animation/core/KeyframesWithSplineSpec$KeyframesWithSplineSpecConfig;)V", "periodicBias", "", "(Landroidx/compose/animation/core/KeyframesWithSplineSpec$KeyframesWithSplineSpecConfig;F)V", "getConfig", "()Landroidx/compose/animation/core/KeyframesWithSplineSpec$KeyframesWithSplineSpecConfig;", "vectorize", "Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "converter", "Landroidx/compose/animation/core/TwoWayConverter;", "KeyframesWithSplineSpecConfig", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class KeyframesWithSplineSpec implements DurationBasedAnimationSpec {
    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000*\u0004\b\u0001\u0010\u00012\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001D\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u0007\u001A\u00028\u0001H\u0010¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2={"Landroidx/compose/animation/core/KeyframesWithSplineSpec$KeyframesWithSplineSpecConfig;", "T", "Landroidx/compose/animation/core/KeyframesSpecBaseConfig;", "Landroidx/compose/animation/core/KeyframesSpec$KeyframeEntity;", "<init>", "()V", "createEntityFor", "value", "createEntityFor$animation_core", "(Ljava/lang/Object;)Landroidx/compose/animation/core/KeyframesSpec$KeyframeEntity;", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class KeyframesWithSplineSpecConfig extends KeyframesSpecBaseConfig {
        public static final int $stable = 8;

        static {
        }

        public KeyframesWithSplineSpecConfig() {
            super(null);
        }

        public KeyframeBaseEntity createEntityFor$animation_core(Object arg1) {
            return this.createEntityFor$animation_core(arg1);
        }

        public KeyframeEntity createEntityFor$animation_core(Object arg7) {
            return new KeyframeEntity(arg7, null, 0, 6, null);
        }
    }

    public static final int $stable;
    private final KeyframesWithSplineSpecConfig config;
    private float periodicBias;

    static {
    }

    public KeyframesWithSplineSpec(KeyframesWithSplineSpecConfig arg1, float arg2) {
        this(arg1);
        this.periodicBias = arg2;
    }

    public KeyframesWithSplineSpec(KeyframesWithSplineSpecConfig arg1) {
        super();
        this.config = arg1;
        this.periodicBias = NaNf;
    }

    public final KeyframesWithSplineSpecConfig getConfig() {
        return this.config;
    }

    public VectorizedAnimationSpec vectorize(TwoWayConverter arg1) {
        return this.vectorize(arg1);
    }

    public VectorizedDurationBasedAnimationSpec vectorize(TwoWayConverter arg21) {
        Object[] v19;
        int[] v18;
        int v17;
        KeyframesWithSplineSpec v0 = this;
        MutableIntObjectMap v1 = v0.config.getKeyframes$animation_core();
        MutableIntList v2 = new MutableIntList(v1.getSize() + 2);
        MutableIntObjectMap v3 = new MutableIntObjectMap(v1.getSize());
        int[] v4 = ((IntObjectMap)v1).keys;
        Object[] v5 = ((IntObjectMap)v1).values;
        long[] v6 = ((IntObjectMap)v1).metadata;
        int v7 = v6.length - 2;
        if(v7 >= 0) {
            int v9 = 0;
            while(true) {
                long v10 = v6[v9];
                if((~v10 << 7 & v10 & -9187201950435737472L) != -9187201950435737472L) {
                    int v13 = 8;
                    int v12 = 8 - (~(v9 - v7) >>> 0x1F);
                    int v14 = 0;
                    while(v14 < v12) {
                        if((0xFF & v10) < 0x80) {
                            int v15 = (v9 << 3) + v14;
                            int v8 = v4[v15];
                            Object v15_1 = v5[v15];
                            v2.add(v8);
                            v17 = v13;
                            v18 = v4;
                            v19 = v5;
                            v3.set(v8, new Pair(arg21.getConvertToVector().invoke(((KeyframeEntity)v15_1).getValue$animation_core()), ((KeyframeEntity)v15_1).getEasing$animation_core()));
                        }
                        else {
                            v18 = v4;
                            v19 = v5;
                            v17 = v13;
                        }

                        v10 >>= v17;
                        ++v14;
                        v13 = v17;
                        v4 = v18;
                        v5 = v19;
                    }

                    v18 = v4;
                    v19 = v5;
                    if(v12 != v13) {
                        break;
                    }
                }
                else {
                    v18 = v4;
                    v19 = v5;
                }

                if(v9 == v7) {
                    break;
                }

                ++v9;
                v4 = v18;
                v5 = v19;
            }
        }

        if(!((IntObjectMap)v1).containsKey(0)) {
            v2.add(0, 0);
        }

        if(!((IntObjectMap)v1).containsKey(v0.config.getDurationMillis())) {
            v2.add(v0.config.getDurationMillis());
        }

        v2.sort();
        return new VectorizedMonoSplineKeyframesSpec(v2, v3, v0.config.getDurationMillis(), v0.config.getDelayMillis(), v0.periodicBias);
    }

    public VectorizedFiniteAnimationSpec vectorize(TwoWayConverter arg1) {
        return this.vectorize(arg1);
    }
}

