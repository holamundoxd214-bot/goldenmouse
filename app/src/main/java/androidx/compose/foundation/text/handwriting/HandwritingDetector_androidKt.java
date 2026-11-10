package androidx.compose.foundation.text.handwriting;

import androidx.compose.foundation.text.TextPointerIcon_androidKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerIconKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u001A\u0018\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¨\u0006\u0005"}, d2={"handwritingDetector", "Landroidx/compose/ui/Modifier;", "callback", "Lkotlin/Function0;", "", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class HandwritingDetector_androidKt {
    public static final Modifier handwritingDetector(Modifier arg3, Function0 arg4) {
        if(StylusHandwriting_androidKt.isStylusHandwritingSupported()) {
            arg3 = PointerIconKt.stylusHoverIcon(arg3, TextPointerIcon_androidKt.getHandwritingPointerIcon(), false, StylusHandwritingKt.getHandwritingBoundsExpansion()).then(new HandwritingDetectorElement(arg4));
        }

        return arg3;
    }
}

