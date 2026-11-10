package androidx.compose.material3.internal;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.interaction.DragInteraction$Start;
import androidx.compose.foundation.interaction.FocusInteraction$Focus;
import androidx.compose.foundation.interaction.HoverInteraction$Enter;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.PressInteraction$Press;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0007\u001A\u00020\bJ\u0016\u0010\t\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0007\u001A\u00020\b¨\u0006\n"}, d2={"Landroidx/compose/material3/internal/ElevationDefaults;", "", "<init>", "()V", "incomingAnimationSpecForInteraction", "Landroidx/compose/animation/core/AnimationSpec;", "Landroidx/compose/ui/unit/Dp;", "interaction", "Landroidx/compose/foundation/interaction/Interaction;", "outgoingAnimationSpecForInteraction", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class ElevationDefaults {
    public static final ElevationDefaults INSTANCE;

    static {
        ElevationDefaults.INSTANCE = new ElevationDefaults();
    }

    private ElevationDefaults() {
        super();
    }

    public final AnimationSpec incomingAnimationSpecForInteraction(Interaction arg1) {
        if((arg1 instanceof Press)) {
            return ElevationKt.access$getDefaultIncomingSpec$p();
        }

        if((arg1 instanceof Start)) {
            return ElevationKt.access$getDefaultIncomingSpec$p();
        }

        if((arg1 instanceof Enter)) {
            return ElevationKt.access$getDefaultIncomingSpec$p();
        }

        if((arg1 instanceof Focus)) {
            return ElevationKt.access$getDefaultIncomingSpec$p();
        }

        return null;
    }

    public final AnimationSpec outgoingAnimationSpecForInteraction(Interaction arg1) {
        if((arg1 instanceof Press)) {
            return ElevationKt.access$getDefaultOutgoingSpec$p();
        }

        if((arg1 instanceof Start)) {
            return ElevationKt.access$getDefaultOutgoingSpec$p();
        }

        if((arg1 instanceof Enter)) {
            return ElevationKt.access$getHoveredOutgoingSpec$p();
        }

        if((arg1 instanceof Focus)) {
            return ElevationKt.access$getDefaultOutgoingSpec$p();
        }

        return null;
    }
}

