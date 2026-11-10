package androidx.compose.animation.core;

import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntObjectMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u000E\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00020\u0004B\t\b\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0015\u001A\u00028\u00012\u0006\u0010\u0007\u001A\u00028\u0000H ¢\u0006\u0004\b\u0016\u0010\u0017J\u001C\u0010\u0018\u001A\u00028\u0001*\u00028\u00002\b\b\u0001\u0010\u0019\u001A\u00020\bH\u0096\u0004¢\u0006\u0002\u0010\u001AJ\u001C\u0010\u001B\u001A\u00028\u0001*\u00028\u00002\b\b\u0001\u0010\u001C\u001A\u00020\u001DH\u0096\u0004¢\u0006\u0002\u0010\u001EJ\u001A\u0010\u001F\u001A\u00028\u0001*\u00028\u00012\u0006\u0010 \u001A\u00020!H\u0086\u0004¢\u0006\u0002\u0010\"R(\u0010\t\u001A\u00020\b2\b\b\u0001\u0010\u0007\u001A\u00020\b8\u0007@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\rR(\u0010\u000E\u001A\u00020\b2\b\b\u0001\u0010\u0007\u001A\u00020\b8\u0007@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\u000B\"\u0004\b\u0010\u0010\rR\u001A\u0010\u0011\u001A\b\u0012\u0004\u0012\u00028\u00010\u0012X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014\u0082\u0001\u0002#$¨\u0006%"}, d2={"Landroidx/compose/animation/core/KeyframesSpecBaseConfig;", "T", "E", "Landroidx/compose/animation/core/KeyframeBaseEntity;", "", "<init>", "()V", "value", "", "durationMillis", "getDurationMillis", "()I", "setDurationMillis", "(I)V", "delayMillis", "getDelayMillis", "setDelayMillis", "keyframes", "Landroidx/collection/MutableIntObjectMap;", "getKeyframes$animation_core", "()Landroidx/collection/MutableIntObjectMap;", "createEntityFor", "createEntityFor$animation_core", "(Ljava/lang/Object;)Landroidx/compose/animation/core/KeyframeBaseEntity;", "at", "timeStamp", "(Ljava/lang/Object;I)Landroidx/compose/animation/core/KeyframeBaseEntity;", "atFraction", "fraction", "", "(Ljava/lang/Object;F)Landroidx/compose/animation/core/KeyframeBaseEntity;", "using", "easing", "Landroidx/compose/animation/core/Easing;", "(Landroidx/compose/animation/core/KeyframeBaseEntity;Landroidx/compose/animation/core/Easing;)Landroidx/compose/animation/core/KeyframeBaseEntity;", "Landroidx/compose/animation/core/KeyframesSpec$KeyframesSpecConfig;", "Landroidx/compose/animation/core/KeyframesWithSplineSpec$KeyframesWithSplineSpecConfig;", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class KeyframesSpecBaseConfig {
    public static final int $stable = 8;
    private int delayMillis;
    private int durationMillis;
    private final MutableIntObjectMap keyframes;

    static {
    }

    private KeyframesSpecBaseConfig() {
        super();
        this.durationMillis = 300;
        this.keyframes = IntObjectMapKt.mutableIntObjectMapOf();
    }

    public KeyframesSpecBaseConfig(DefaultConstructorMarker arg1) {
        this();
    }

    public KeyframeBaseEntity at(Object arg1, int arg2) {
        KeyframeBaseEntity v1 = this.createEntityFor$animation_core(arg1);
        this.keyframes.set(arg2, v1);
        return v1;
    }

    public KeyframeBaseEntity atFraction(Object arg2, float arg3) {
        return this.at(arg2, Math.round((((float)this.durationMillis)) * arg3));
    }

    public abstract KeyframeBaseEntity createEntityFor$animation_core(Object arg1);

    public final int getDelayMillis() {
        return this.delayMillis;
    }

    public final int getDurationMillis() {
        return this.durationMillis;
    }

    public final MutableIntObjectMap getKeyframes$animation_core() {
        return this.keyframes;
    }

    public final void setDelayMillis(int arg1) {
        this.delayMillis = arg1;
    }

    public final void setDurationMillis(int arg1) {
        this.durationMillis = arg1;
    }

    public final KeyframeBaseEntity using(KeyframeBaseEntity arg1, Easing arg2) {
        arg1.setEasing$animation_core(arg2);
        return arg1;
    }
}

