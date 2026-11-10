package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0019\b\u0004\u0012\u0006\u0010\u0003\u001A\u00028\u0000\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J7\u0010\u000F\u001A\u000E\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u00020\u00050\u0010\"\b\b\u0001\u0010\u0011*\u00020\u00122\u0012\u0010\u0013\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u00110\u0014H\u0000¢\u0006\u0002\b\u0015R\u0016\u0010\u0003\u001A\u00028\u0000X\u0080\u0004¢\u0006\n\n\u0002\u0010\n\u001A\u0004\b\b\u0010\tR\u001A\u0010\u0004\u001A\u00020\u0005X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000E\u0082\u0001\u0001\u0016¨\u0006\u0017"}, d2={"Landroidx/compose/animation/core/KeyframeBaseEntity;", "T", "", "value", "easing", "Landroidx/compose/animation/core/Easing;", "<init>", "(Ljava/lang/Object;Landroidx/compose/animation/core/Easing;)V", "getValue$animation_core", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getEasing$animation_core", "()Landroidx/compose/animation/core/Easing;", "setEasing$animation_core", "(Landroidx/compose/animation/core/Easing;)V", "toPair", "Lkotlin/Pair;", "V", "Landroidx/compose/animation/core/AnimationVector;", "convertToVector", "Lkotlin/Function1;", "toPair$animation_core", "Landroidx/compose/animation/core/KeyframesSpec$KeyframeEntity;", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class KeyframeBaseEntity {
    public static final int $stable = 8;
    private Easing easing;
    private final Object value;

    static {
    }

    private KeyframeBaseEntity(Object arg1, Easing arg2) {
        super();
        this.value = arg1;
        this.easing = arg2;
    }

    public KeyframeBaseEntity(Object arg1, Easing arg2, DefaultConstructorMarker arg3) {
        this(arg1, arg2);
    }

    public final Easing getEasing$animation_core() {
        return this.easing;
    }

    public final Object getValue$animation_core() {
        return this.value;
    }

    public final void setEasing$animation_core(Easing arg1) {
        this.easing = arg1;
    }

    public final Pair toPair$animation_core(Function1 arg2) {
        return TuplesKt.to(arg2.invoke(this.value), this.easing);
    }
}

