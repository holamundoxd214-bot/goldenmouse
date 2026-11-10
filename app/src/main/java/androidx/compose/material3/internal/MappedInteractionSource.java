package androidx.compose.material3.internal;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction$Press;
import androidx.compose.ui.geometry.Offset;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0001\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0010\u001A\u00020\n2\u0006\u0010\u0011\u001A\u00020\nH\u0002R\u0010\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u001A\u0010\b\u001A\u000E\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\r0\fX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u0012"}, d2={"Landroidx/compose/material3/internal/MappedInteractionSource;", "Landroidx/compose/foundation/interaction/InteractionSource;", "underlyingInteractionSource", "delta", "Landroidx/compose/ui/geometry/Offset;", "<init>", "(Landroidx/compose/foundation/interaction/InteractionSource;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "mappedPresses", "", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "interactions", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/compose/foundation/interaction/Interaction;", "getInteractions", "()Lkotlinx/coroutines/flow/Flow;", "mapPress", "press", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class MappedInteractionSource implements InteractionSource {
    public static final int $stable;
    private final long delta;
    private final Flow interactions;
    private final Map mappedPresses;

    static {
    }

    public MappedInteractionSource(InteractionSource arg1, long arg2, DefaultConstructorMarker arg4) {
        this(arg1, arg2);
    }

    private MappedInteractionSource(InteractionSource arg1, long arg2) {
        super();
        this.delta = arg2;
        this.mappedPresses = new LinkedHashMap();
        this.interactions = new MappedInteractionSource$special$$inlined$map$1(arg1.getInteractions(), this);
    }

    public static final Map access$getMappedPresses$p(MappedInteractionSource arg0) {
        return arg0.mappedPresses;
    }

    public static final Press access$mapPress(MappedInteractionSource arg0, Press arg1) {
        return arg0.mapPress(arg1);
    }

    public Flow getInteractions() {
        return this.interactions;
    }

    private final Press mapPress(Press arg4) {
        return new Press(Offset.minus-MK-Hz9U(arg4.getPressPosition-F1C5BW0(), this.delta), null);
    }
}

