package androidx.compose.animation;

import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\b\u001A\u00020\u00002\u0006\u0010\t\u001A\u00020\u0000H\u0087\u0002J\b\u0010\n\u001A\u00020\u000BH\u0016J\u0013\u0010\f\u001A\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000F\u001A\u00020\u0010H\u0016R\u0012\u0010\u0004\u001A\u00020\u0005X \u0004¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007\u0082\u0001\u0001\u0012¨\u0006\u0013"}, d2={"Landroidx/compose/animation/EnterTransition;", "", "<init>", "()V", "data", "Landroidx/compose/animation/TransitionData;", "getData$animation", "()Landroidx/compose/animation/TransitionData;", "plus", "enter", "toString", "", "equals", "", "other", "hashCode", "", "Companion", "Landroidx/compose/animation/EnterTransitionImpl;", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class EnterTransition {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"Landroidx/compose/animation/EnterTransition$Companion;", "", "<init>", "()V", "None", "Landroidx/compose/animation/EnterTransition;", "getNone", "()Landroidx/compose/animation/EnterTransition;", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final EnterTransition getNone() {
            return EnterTransition.None;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final EnterTransition None;

    static {
        EnterTransition.Companion = new Companion(null);
        EnterTransition.None = new EnterTransitionImpl(new TransitionData(null, null, null, null, null, false, null, 0x7F, null));
    }

    private EnterTransition() {
        super();
    }

    public EnterTransition(DefaultConstructorMarker arg1) {
        this();
    }

    public static final EnterTransition access$getNone$cp() {
        return EnterTransition.None;
    }

    public boolean equals(Object arg2) {
        if(((arg2 instanceof EnterTransition)) && (Intrinsics.areEqual(((EnterTransition)arg2).getData$animation(), this.getData$animation()))) {
            return 1;
        }

        return 0;
    }

    public abstract TransitionData getData$animation();

    public int hashCode() {
        return this.getData$animation().hashCode();
    }

    public final EnterTransition plus(EnterTransition arg12) {
        Fade v2 = arg12.getData$animation().getFade();
        if(v2 == null) {
            v2 = this.getData$animation().getFade();
        }

        Slide v3 = arg12.getData$animation().getSlide();
        if(v3 == null) {
            v3 = this.getData$animation().getSlide();
        }

        ChangeSize v4 = arg12.getData$animation().getChangeSize();
        if(v4 == null) {
            v4 = this.getData$animation().getChangeSize();
        }

        Scale v5 = arg12.getData$animation().getScale();
        if(v5 == null) {
            v5 = this.getData$animation().getScale();
        }

        Veil v6 = arg12.getData$animation().getVeil();
        if(v6 == null) {
            v6 = this.getData$animation().getVeil();
        }

        return new EnterTransitionImpl(new TransitionData(v2, v3, v4, v5, v6, false, MapsKt.plus(this.getData$animation().getEffectsMap(), arg12.getData$animation().getEffectsMap()), 0x20, null));
    }

    public String toString() {
        if(Intrinsics.areEqual(this, EnterTransition.None)) {
            return "EnterTransition.None";
        }

        TransitionData v3 = this.getData$animation();
        StringBuilder v0 = new StringBuilder("EnterTransition: \nFade - ");
        Fade v1 = v3.getFade();
        String v2 = null;
        String v1_1 = v1 != null ? v1.toString() : v2;
        v0 = v0.append(v1_1).append(",\nSlide - ");
        Slide v1_2 = v3.getSlide();
        v1_1 = v1_2 != null ? v1_2.toString() : v2;
        v0 = v0.append(v1_1).append(",\nShrink - ");
        ChangeSize v1_3 = v3.getChangeSize();
        v1_1 = v1_3 != null ? v1_3.toString() : v2;
        v0 = v0.append(v1_1).append(",\nScale - ");
        Scale v3_1 = v3.getScale();
        if(v3_1 != null) {
            v2 = v3_1.toString();
        }

        return v0.append(v2).toString();
    }
}

