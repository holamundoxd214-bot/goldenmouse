package androidx.compose.material3;

import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000E\u0010\u000E\u001A\u00020\u00052\u0006\u0010\u000F\u001A\u00020\u0010J\u000E\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u0014J&\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0017\u001A\u00020\u00142\u0006\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u001A\u001A\u00020\u001BR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0006\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\f¨\u0006\u001C"}, d2={"Landroidx/compose/material3/RangeSliderLogic;", "", "state", "Landroidx/compose/material3/RangeSliderState;", "startInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "endInteractionSource", "<init>", "(Landroidx/compose/material3/RangeSliderState;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;)V", "getState", "()Landroidx/compose/material3/RangeSliderState;", "getStartInteractionSource", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "getEndInteractionSource", "activeInteraction", "draggingStart", "", "compareOffsets", "", "eventX", "", "captureThumb", "", "posX", "interaction", "Landroidx/compose/foundation/interaction/Interaction;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class RangeSliderLogic {
    private final MutableInteractionSource endInteractionSource;
    private final MutableInteractionSource startInteractionSource;
    private final RangeSliderState state;

    public RangeSliderLogic(RangeSliderState arg1, MutableInteractionSource arg2, MutableInteractionSource arg3) {
        super();
        this.state = arg1;
        this.startInteractionSource = arg2;
        this.endInteractionSource = arg3;
    }

    public final MutableInteractionSource activeInteraction(boolean arg1) {
        if(arg1) {
            return this.startInteractionSource;
        }

        return this.endInteractionSource;
    }

    public final void captureThumb(boolean arg8, float arg9, Interaction arg10, CoroutineScope arg11) {
        RangeSliderState v0 = this.state;
        float v1 = arg8 ? v0.getRawOffsetStart$material3() : v0.getRawOffsetEnd$material3();
        v0.onDrag$material3(arg8, arg9 - v1);
        BuildersKt.launch$default(arg11, null, null, new RangeSliderLogic$captureThumb$1(this, arg8, arg10, null), 3, null);
    }

    public final int compareOffsets(float arg2) {
        return Float.compare(Math.abs(this.state.getRawOffsetStart$material3() - arg2), Math.abs(this.state.getRawOffsetEnd$material3() - arg2));
    }

    public final MutableInteractionSource getEndInteractionSource() {
        return this.endInteractionSource;
    }

    public final MutableInteractionSource getStartInteractionSource() {
        return this.startInteractionSource;
    }

    public final RangeSliderState getState() {
        return this.state;
    }
}

