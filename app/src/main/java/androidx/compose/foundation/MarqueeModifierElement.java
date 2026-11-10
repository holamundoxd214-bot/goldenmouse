package androidx.compose.foundation;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B7\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\u0004\u0012\u0006\u0010\b\u001A\u00020\u0004\u0012\u0006\u0010\t\u001A\u00020\n\u0012\u0006\u0010\u000B\u001A\u00020\f¢\u0006\u0004\b\r\u0010\u000EJ\b\u0010\u0011\u001A\u00020\u0002H\u0016J\u0010\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u0002H\u0016J\f\u0010\u0015\u001A\u00020\u0013*\u00020\u0016H\u0016J\t\u0010\u0017\u001A\u00020\u0004HÂ\u0003J\u0010\u0010\u0018\u001A\u00020\u0006HÂ\u0003¢\u0006\u0004\b\u0019\u0010\u001AJ\t\u0010\u001B\u001A\u00020\u0004HÂ\u0003J\t\u0010\u001C\u001A\u00020\u0004HÂ\u0003J\t\u0010\u001D\u001A\u00020\nHÂ\u0003J\u0010\u0010\u001E\u001A\u00020\fHÂ\u0003¢\u0006\u0004\b\u001F\u0010 JL\u0010!\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\u00042\b\b\u0002\u0010\b\u001A\u00020\u00042\b\b\u0002\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\fHÆ\u0001¢\u0006\u0004\b\"\u0010#J\u0013\u0010$\u001A\u00020%2\b\u0010&\u001A\u0004\u0018\u00010\'HÖ\u0003J\t\u0010(\u001A\u00020\u0004HÖ\u0001J\t\u0010)\u001A\u00020*HÖ\u0001R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000FR\u000E\u0010\u0007\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000B\u001A\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006+"}, d2={"Landroidx/compose/foundation/MarqueeModifierElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/MarqueeModifierNode;", "iterations", "", "animationMode", "Landroidx/compose/foundation/MarqueeAnimationMode;", "delayMillis", "initialDelayMillis", "spacing", "Landroidx/compose/foundation/MarqueeSpacing;", "velocity", "Landroidx/compose/ui/unit/Dp;", "<init>", "(IIIILandroidx/compose/foundation/MarqueeSpacing;FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "I", "F", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "component1", "component2", "component2-ZbEOnfQ", "()I", "component3", "component4", "component5", "component6", "component6-D9Ej5fM", "()F", "copy", "copy-lWfNwf4", "(IIIILandroidx/compose/foundation/MarqueeSpacing;F)Landroidx/compose/foundation/MarqueeModifierElement;", "equals", "", "other", "", "hashCode", "toString", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class MarqueeModifierElement extends ModifierNodeElement {
    private final int animationMode;
    private final int delayMillis;
    private final int initialDelayMillis;
    private final int iterations;
    private final MarqueeSpacing spacing;
    private final float velocity;

    public MarqueeModifierElement(int arg1, int arg2, int arg3, int arg4, MarqueeSpacing arg5, float arg6, DefaultConstructorMarker arg7) {
        this(arg1, arg2, arg3, arg4, arg5, arg6);
    }

    private MarqueeModifierElement(int arg1, int arg2, int arg3, int arg4, MarqueeSpacing arg5, float arg6) {
        super();
        this.iterations = arg1;
        this.animationMode = arg2;
        this.delayMillis = arg3;
        this.initialDelayMillis = arg4;
        this.spacing = arg5;
        this.velocity = arg6;
    }

    private final int component1() {
        return this.iterations;
    }

    private final int component2-ZbEOnfQ() {
        return this.animationMode;
    }

    private final int component3() {
        return this.delayMillis;
    }

    private final int component4() {
        return this.initialDelayMillis;
    }

    private final MarqueeSpacing component5() {
        return this.spacing;
    }

    private final float component6-D9Ej5fM() {
        return this.velocity;
    }

    public final MarqueeModifierElement copy-lWfNwf4(int arg9, int arg10, int arg11, int arg12, MarqueeSpacing arg13, float arg14) {
        return new MarqueeModifierElement(arg9, arg10, arg11, arg12, arg13, arg14, null);
    }

    public static MarqueeModifierElement copy-lWfNwf4$default(MarqueeModifierElement arg0, int arg1, int arg2, int arg3, int arg4, MarqueeSpacing arg5, float arg6, int arg7, Object arg8) {
        if((arg7 & 1) != 0) {
            arg1 = arg0.iterations;
        }

        if((arg7 & 2) != 0) {
            arg2 = arg0.animationMode;
        }

        if((arg7 & 4) != 0) {
            arg3 = arg0.delayMillis;
        }

        if((arg7 & 8) != 0) {
            arg4 = arg0.initialDelayMillis;
        }

        if((arg7 & 16) != 0) {
            arg5 = arg0.spacing;
        }

        if((arg7 & 0x20) != 0) {
            arg6 = arg0.velocity;
        }

        return arg0.copy-lWfNwf4(arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public MarqueeModifierNode create() {
        return new MarqueeModifierNode(this.iterations, this.animationMode, this.delayMillis, this.initialDelayMillis, this.spacing, this.velocity, null);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg5) {
        if(this == (((MarqueeModifierElement)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof MarqueeModifierElement)) {
            return 0;
        }

        if(this.iterations != ((MarqueeModifierElement)arg5).iterations) {
            return 0;
        }

        if(!MarqueeAnimationMode.equals-impl0(this.animationMode, ((MarqueeModifierElement)arg5).animationMode)) {
            return 0;
        }

        if(this.delayMillis != ((MarqueeModifierElement)arg5).delayMillis) {
            return 0;
        }

        if(this.initialDelayMillis != ((MarqueeModifierElement)arg5).initialDelayMillis) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.spacing, ((MarqueeModifierElement)arg5).spacing)) {
            return 0;
        }

        if(!Dp.equals-impl0(this.velocity, ((MarqueeModifierElement)arg5).velocity)) {
            return 0;
        }

        return 1;
    }

    public int hashCode() {
        return ((((Integer.hashCode(this.iterations) * 0x1F + MarqueeAnimationMode.hashCode-impl(this.animationMode)) * 0x1F + Integer.hashCode(this.delayMillis)) * 0x1F + Integer.hashCode(this.initialDelayMillis)) * 0x1F + this.spacing.hashCode()) * 0x1F + Dp.hashCode-impl(this.velocity);
    }

    public void inspectableProperties(InspectorInfo arg4) {
        arg4.setName("basicMarquee");
        arg4.getProperties().set("iterations", Integer.valueOf(this.iterations));
        arg4.getProperties().set("animationMode", MarqueeAnimationMode.box-impl(this.animationMode));
        arg4.getProperties().set("delayMillis", Integer.valueOf(this.delayMillis));
        arg4.getProperties().set("initialDelayMillis", Integer.valueOf(this.initialDelayMillis));
        arg4.getProperties().set("spacing", this.spacing);
        arg4.getProperties().set("velocity", Dp.box-impl(this.velocity));
    }

    public String toString() {
        return "MarqueeModifierElement(iterations=" + this.iterations + ", animationMode=" + MarqueeAnimationMode.toString-impl(this.animationMode) + ", delayMillis=" + this.delayMillis + ", initialDelayMillis=" + this.initialDelayMillis + ", spacing=" + this.spacing + ", velocity=" + Dp.toString-impl(this.velocity) + ')';
    }

    public void update(MarqueeModifierNode arg8) {
        arg8.update-lWfNwf4(this.iterations, this.animationMode, this.delayMillis, this.initialDelayMillis, this.spacing, this.velocity);
    }

    public void update(Node arg1) {
        this.update(((MarqueeModifierNode)arg1));
    }
}

