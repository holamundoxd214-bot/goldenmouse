package androidx.compose.ui.input.pointer;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\u001A%\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00032\u0006\u0010\u0005\u001A\u00020\u0003H\u0000¢\u0006\u0002\u0010\u0006\u001A\r\u0010\u0007\u001A\u00020\b*\u00020\u0003H\u0082\b¨\u0006\t"}, d2={"ProcessResult", "Landroidx/compose/ui/input/pointer/ProcessResult;", "dispatchedToAPointerInputModifier", "", "anyMovementConsumed", "anyChangeConsumed", "(ZZZ)I", "toInt", "", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class PointerInputEventProcessorKt {
    public static final int ProcessResult(boolean arg0, boolean arg1, boolean arg2) {
        return ProcessResult.constructor-impl((((int)arg0)) | (((int)arg1)) << 1 | (((int)arg2)) << 2);
    }

    private static final int toInt(boolean arg0) {
        return arg0;
    }
}

