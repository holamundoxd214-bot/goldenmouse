package androidx.compose.animation.core;

import androidx.collection.IntObjectMap;
import androidx.collection.MutableIntList;
import androidx.collection.MutableIntObjectMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0002\u000F\u0010B\u0015\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006J,\u0010\t\u001A\b\u0012\u0004\u0012\u0002H\u000B0\n\"\b\b\u0001\u0010\u000B*\u00020\f2\u0012\u0010\r\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u000B0\u000EH\u0016R\u0017\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2={"Landroidx/compose/animation/core/KeyframesSpec;", "T", "Landroidx/compose/animation/core/DurationBasedAnimationSpec;", "config", "Landroidx/compose/animation/core/KeyframesSpec$KeyframesSpecConfig;", "<init>", "(Landroidx/compose/animation/core/KeyframesSpec$KeyframesSpecConfig;)V", "getConfig", "()Landroidx/compose/animation/core/KeyframesSpec$KeyframesSpecConfig;", "vectorize", "Landroidx/compose/animation/core/VectorizedKeyframesSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "converter", "Landroidx/compose/animation/core/TwoWayConverter;", "KeyframesSpecConfig", "KeyframeEntity", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class KeyframesSpec implements DurationBasedAnimationSpec {
    @Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B%\b\u0000\u0012\u0006\u0010\u0003\u001A\u00028\u0001\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001A\u00020\u0014H\u0016R\u001C\u0010\u0006\u001A\u00020\u0007X\u0080\u000E¢\u0006\u0010\n\u0002\u0010\u000E\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\r¨\u0006\u0015"}, d2={"Landroidx/compose/animation/core/KeyframesSpec$KeyframeEntity;", "T", "Landroidx/compose/animation/core/KeyframeBaseEntity;", "value", "easing", "Landroidx/compose/animation/core/Easing;", "arcMode", "Landroidx/compose/animation/core/ArcMode;", "<init>", "(Ljava/lang/Object;Landroidx/compose/animation/core/Easing;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getArcMode--9T-Mq4$animation_core", "()I", "setArcMode-Rur9ykg$animation_core", "(I)V", "I", "equals", "", "other", "", "hashCode", "", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class KeyframeEntity extends KeyframeBaseEntity {
        public static final int $stable = 8;
        private int arcMode;

        static {
        }

        private KeyframeEntity(Object arg2, Easing arg3, int arg4) {
            super(arg2, arg3, null);
            this.arcMode = arg4;
        }

        public KeyframeEntity(Object arg1, Easing arg2, int arg3, int arg4, DefaultConstructorMarker arg5) {
            if((arg4 & 2) != 0) {
                arg2 = EasingKt.getLinearEasing();
            }

            if((arg4 & 4) != 0) {
                arg3 = ArcMode.Companion.getArcLinear--9T-Mq4();
            }

            this(arg1, arg2, arg3, null);
        }

        public KeyframeEntity(Object arg1, Easing arg2, int arg3, DefaultConstructorMarker arg4) {
            this(arg1, arg2, arg3);
        }

        public boolean equals(Object arg5) {
            if((((KeyframeEntity)arg5)) == this) {
                return 1;
            }

            if(!(arg5 instanceof KeyframeEntity)) {
                return 0;
            }

            if((Intrinsics.areEqual(((KeyframeEntity)arg5).getValue$animation_core(), this.getValue$animation_core())) && (Intrinsics.areEqual(((KeyframeEntity)arg5).getEasing$animation_core(), this.getEasing$animation_core())) && (ArcMode.equals-impl0(((KeyframeEntity)arg5).arcMode, this.arcMode))) {
                return 1;
            }

            return 0;
        }

        public final int getArcMode--9T-Mq4$animation_core() {
            return this.arcMode;
        }

        public int hashCode() {
            Object v0 = this.getValue$animation_core();
            int v0_1 = v0 != null ? v0.hashCode() : 0;
            return (v0_1 * 0x1F + ArcMode.hashCode-impl(this.arcMode)) * 0x1F + this.getEasing$animation_core().hashCode();
        }

        public final void setArcMode-Rur9ykg$animation_core(int arg1) {
            this.arcMode = arg1;
        }
    }

    @Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\u0004\b\u0001\u0010\u00012\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001D\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u0007\u001A\u00028\u0001H\u0010¢\u0006\u0004\b\b\u0010\tJ\"\u0010\n\u001A\b\u0012\u0004\u0012\u00028\u00010\u0003*\u00028\u00012\b\b\u0001\u0010\u000B\u001A\u00020\fH\u0096\u0004¢\u0006\u0002\u0010\rJ\"\u0010\u000E\u001A\b\u0012\u0004\u0012\u00028\u00010\u0003*\u00028\u00012\b\b\u0001\u0010\u000F\u001A\u00020\u0010H\u0096\u0004¢\u0006\u0002\u0010\u0011J\u001B\u0010\u0012\u001A\u00020\u0013*\b\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u0014\u001A\u00020\u0015H\u0087\u0004J(\u0010\u0016\u001A\b\u0012\u0004\u0012\u00028\u00010\u0003*\b\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u0017\u001A\u00020\u0018H\u0086\u0004¢\u0006\u0004\b\u0019\u0010\u001A¨\u0006\u001B"}, d2={"Landroidx/compose/animation/core/KeyframesSpec$KeyframesSpecConfig;", "T", "Landroidx/compose/animation/core/KeyframesSpecBaseConfig;", "Landroidx/compose/animation/core/KeyframesSpec$KeyframeEntity;", "<init>", "()V", "createEntityFor", "value", "createEntityFor$animation_core", "(Ljava/lang/Object;)Landroidx/compose/animation/core/KeyframesSpec$KeyframeEntity;", "at", "timeStamp", "", "(Ljava/lang/Object;I)Landroidx/compose/animation/core/KeyframesSpec$KeyframeEntity;", "atFraction", "fraction", "", "(Ljava/lang/Object;F)Landroidx/compose/animation/core/KeyframesSpec$KeyframeEntity;", "with", "", "easing", "Landroidx/compose/animation/core/Easing;", "using", "arcMode", "Landroidx/compose/animation/core/ArcMode;", "using-ngzHuyU", "(Landroidx/compose/animation/core/KeyframesSpec$KeyframeEntity;I)Landroidx/compose/animation/core/KeyframesSpec$KeyframeEntity;", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class KeyframesSpecConfig extends KeyframesSpecBaseConfig {
        public static final int $stable = 8;

        static {
        }

        public KeyframesSpecConfig() {
            super(null);
        }

        public KeyframeBaseEntity at(Object arg1, int arg2) {
            return this.at(arg1, arg2);
        }

        public KeyframeEntity at(Object arg7, int arg8) {
            KeyframeEntity v0 = new KeyframeEntity(arg7, null, 0, 6, null);
            this.getKeyframes$animation_core().set(arg8, v0);
            return v0;
        }

        public KeyframeBaseEntity atFraction(Object arg1, float arg2) {
            return this.atFraction(arg1, arg2);
        }

        public KeyframeEntity atFraction(Object arg2, float arg3) {
            return this.at(arg2, Math.round((((float)this.getDurationMillis())) * arg3));
        }

        public KeyframeBaseEntity createEntityFor$animation_core(Object arg1) {
            return this.createEntityFor$animation_core(arg1);
        }

        public KeyframeEntity createEntityFor$animation_core(Object arg7) {
            return new KeyframeEntity(arg7, null, 0, 6, null);
        }

        public final KeyframeEntity using-ngzHuyU(KeyframeEntity arg1, int arg2) {
            arg1.setArcMode-Rur9ykg$animation_core(arg2);
            return arg1;
        }

        @Deprecated(message="Use version that returns an instance of the entity so it can be re-used in other keyframe builders.", replaceWith="<_subannotation>") public final void with(KeyframeEntity arg1, Easing arg2) {
            arg1.setEasing$animation_core(arg2);
        }
    }

    public static final int $stable;
    private final KeyframesSpecConfig config;

    static {
    }

    public KeyframesSpec(KeyframesSpecConfig arg1) {
        super();
        this.config = arg1;
    }

    public final KeyframesSpecConfig getConfig() {
        return this.config;
    }

    public VectorizedAnimationSpec vectorize(TwoWayConverter arg1) {
        return this.vectorize(arg1);
    }

    public VectorizedKeyframesSpec vectorize(TwoWayConverter arg21) {
        int[] v19;
        long[] v18;
        int v17;
        KeyframesSpec v0 = this;
        MutableIntList v1 = new MutableIntList(v0.config.getKeyframes$animation_core().getSize() + 2);
        MutableIntObjectMap v2 = new MutableIntObjectMap(v0.config.getKeyframes$animation_core().getSize());
        MutableIntObjectMap v3 = v0.config.getKeyframes$animation_core();
        int[] v4 = ((IntObjectMap)v3).keys;
        Object[] v5 = ((IntObjectMap)v3).values;
        long[] v3_1 = ((IntObjectMap)v3).metadata;
        int v6 = v3_1.length - 2;
        if(v6 >= 0) {
            int v8 = 0;
            while(true) {
                long v9 = v3_1[v8];
                if((~v9 << 7 & v9 & -9187201950435737472L) != -9187201950435737472L) {
                    int v12 = 8;
                    int v11 = 8 - (~(v8 - v6) >>> 0x1F);
                    int v13 = 0;
                    while(v13 < v11) {
                        if((0xFF & v9) < 0x80) {
                            int v14 = (v8 << 3) + v13;
                            int v15 = v4[v14];
                            Object v14_1 = v5[v14];
                            v1.add(v15);
                            v17 = v12;
                            v18 = v3_1;
                            v19 = v4;
                            v2.set(v15, new VectorizedKeyframeSpecElementInfo(arg21.getConvertToVector().invoke(((KeyframeEntity)v14_1).getValue$animation_core()), ((KeyframeEntity)v14_1).getEasing$animation_core(), ((KeyframeEntity)v14_1).getArcMode--9T-Mq4$animation_core(), null));
                        }
                        else {
                            v18 = v3_1;
                            v19 = v4;
                            v17 = v12;
                        }

                        v9 >>= v17;
                        ++v13;
                        v12 = v17;
                        v3_1 = v18;
                        v4 = v19;
                    }

                    v18 = v3_1;
                    v19 = v4;
                    if(v11 != v12) {
                        break;
                    }
                }
                else {
                    v18 = v3_1;
                    v19 = v4;
                }

                if(v8 == v6) {
                    break;
                }

                ++v8;
                v3_1 = v18;
                v4 = v19;
            }
        }

        if(!v0.config.getKeyframes$animation_core().containsKey(0)) {
            v1.add(0, 0);
        }

        if(!v0.config.getKeyframes$animation_core().containsKey(v0.config.getDurationMillis())) {
            v1.add(v0.config.getDurationMillis());
        }

        v1.sort();
        return new VectorizedKeyframesSpec(v1, v2, v0.config.getDurationMillis(), v0.config.getDelayMillis(), EasingKt.getLinearEasing(), ArcMode.Companion.getArcLinear--9T-Mq4(), null);
    }

    public VectorizedDurationBasedAnimationSpec vectorize(TwoWayConverter arg1) {
        return this.vectorize(arg1);
    }

    public VectorizedFiniteAnimationSpec vectorize(TwoWayConverter arg1) {
        return this.vectorize(arg1);
    }
}

