package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0081\b\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u001F\u0012\u0006\u0010\u0004\u001A\u00028\u0000\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000E\u0010\u0013\u001A\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0014\u001A\u00020\u0006HÆ\u0003J\u0010\u0010\u0015\u001A\u00020\bHÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0011J4\u0010\u0017\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0004\u001A\u00028\u00002\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\bHÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u001A\u001A\u00020\u001B2\b\u0010\u001C\u001A\u0004\u0018\u00010\u0003HÖ\u0003J\t\u0010\u001D\u001A\u00020\u001EHÖ\u0001J\t\u0010\u001F\u001A\u00020 HÖ\u0001R\u0013\u0010\u0004\u001A\u00028\u0000¢\u0006\n\n\u0002\u0010\r\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0013\u0010\u0007\u001A\u00020\b¢\u0006\n\n\u0002\u0010\u0012\u001A\u0004\b\u0010\u0010\u0011¨\u0006!"}, d2={"Landroidx/compose/animation/core/VectorizedKeyframeSpecElementInfo;", "V", "Landroidx/compose/animation/core/AnimationVector;", "", "vectorValue", "easing", "Landroidx/compose/animation/core/Easing;", "arcMode", "Landroidx/compose/animation/core/ArcMode;", "<init>", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/Easing;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getVectorValue", "()Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/AnimationVector;", "getEasing", "()Landroidx/compose/animation/core/Easing;", "getArcMode--9T-Mq4", "()I", "I", "component1", "component2", "component3", "component3--9T-Mq4", "copy", "copy-2NF0KzA", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/Easing;I)Landroidx/compose/animation/core/VectorizedKeyframeSpecElementInfo;", "equals", "", "other", "hashCode", "", "toString", "", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class VectorizedKeyframeSpecElementInfo {
    public static final int $stable;
    private final int arcMode;
    private final Easing easing;
    private final AnimationVector vectorValue;

    static {
    }

    public VectorizedKeyframeSpecElementInfo(AnimationVector arg1, Easing arg2, int arg3, DefaultConstructorMarker arg4) {
        this(arg1, arg2, arg3);
    }

    private VectorizedKeyframeSpecElementInfo(AnimationVector arg1, Easing arg2, int arg3) {
        super();
        this.vectorValue = arg1;
        this.easing = arg2;
        this.arcMode = arg3;
    }

    public final AnimationVector component1() {
        return this.vectorValue;
    }

    public final Easing component2() {
        return this.easing;
    }

    public final int component3--9T-Mq4() {
        return this.arcMode;
    }

    public final VectorizedKeyframeSpecElementInfo copy-2NF0KzA(AnimationVector arg2, Easing arg3, int arg4) {
        return new VectorizedKeyframeSpecElementInfo(arg2, arg3, arg4, null);
    }

    public static VectorizedKeyframeSpecElementInfo copy-2NF0KzA$default(VectorizedKeyframeSpecElementInfo arg0, AnimationVector arg1, Easing arg2, int arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = arg0.vectorValue;
        }

        if((arg4 & 2) != 0) {
            arg2 = arg0.easing;
        }

        if((arg4 & 4) != 0) {
            arg3 = arg0.arcMode;
        }

        return arg0.copy-2NF0KzA(arg1, arg2, arg3);
    }

    public boolean equals(Object arg5) {
        if(this == (((VectorizedKeyframeSpecElementInfo)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof VectorizedKeyframeSpecElementInfo)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.vectorValue, ((VectorizedKeyframeSpecElementInfo)arg5).vectorValue)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.easing, ((VectorizedKeyframeSpecElementInfo)arg5).easing)) {
            return 0;
        }

        if(!ArcMode.equals-impl0(this.arcMode, ((VectorizedKeyframeSpecElementInfo)arg5).arcMode)) {
            return 0;
        }

        return 1;
    }

    public final int getArcMode--9T-Mq4() {
        return this.arcMode;
    }

    public final Easing getEasing() {
        return this.easing;
    }

    public final AnimationVector getVectorValue() {
        return this.vectorValue;
    }

    public int hashCode() {
        return (this.vectorValue.hashCode() * 0x1F + this.easing.hashCode()) * 0x1F + ArcMode.hashCode-impl(this.arcMode);
    }

    public String toString() {
        return "VectorizedKeyframeSpecElementInfo(vectorValue=" + this.vectorValue + ", easing=" + this.easing + ", arcMode=" + ArcMode.toString-impl(this.arcMode) + ')';
    }
}

