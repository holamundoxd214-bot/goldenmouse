package androidx.compose.foundation.draganddrop;

import androidx.compose.ui.Modifier;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"androidx/compose/foundation/draganddrop/DragAndDropSourceKt__DragAndDropSourceKt", "androidx/compose/foundation/draganddrop/DragAndDropSourceKt__LegacyDragAndDropSource_androidKt"}, k=4, mv={2, 0, 0}, xi=0x30) public final class DragAndDropSourceKt {
    public static final Modifier dragAndDropSource(Modifier arg0, Function1 arg1) {
        return DragAndDropSourceKt__DragAndDropSourceKt.dragAndDropSource(arg0, arg1);
    }

    public static final Modifier dragAndDropSource(Modifier arg0, Function1 arg1, Function1 arg2) {
        return DragAndDropSourceKt__DragAndDropSourceKt.dragAndDropSource(arg0, arg1, arg2);
    }

    @Deprecated(message="Replaced by overload with a callback for obtain a transfer data,start detection is performed by Compose itself", replaceWith="<_subannotation>") public static final Modifier dragAndDropSource(Modifier arg0, Function1 arg1, Function2 arg2) {
        return DragAndDropSourceKt__LegacyDragAndDropSource_androidKt.dragAndDropSource(arg0, arg1, arg2);
    }
}

