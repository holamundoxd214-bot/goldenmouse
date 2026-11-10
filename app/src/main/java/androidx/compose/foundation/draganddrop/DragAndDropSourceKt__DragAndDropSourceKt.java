package androidx.compose.foundation.draganddrop;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A \u0010\u0007\u001A\u00020\b*\u00020\b2\u0014\u0010\t\u001A\u0010\u0012\u0004\u0012\u00020\u000B\u0012\u0006\u0012\u0004\u0018\u00010\f0\n\u001A9\u0010\u0007\u001A\u00020\b*\u00020\b2\u0017\u0010\r\u001A\u0013\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u00040\n¢\u0006\u0002\b\u00062\u0014\u0010\t\u001A\u0010\u0012\u0004\u0012\u00020\u000B\u0012\u0006\u0012\u0004\u0018\u00010\f0\n*N\b\u0000\u0010\u0000\"#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001¢\u0006\u0002\b\u00062#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001¢\u0006\u0002\b\u0006¨\u0006\u000F"}, d2={"DragAndDropStartDetector", "Lkotlin/Function2;", "Landroidx/compose/foundation/draganddrop/DragAndDropStartDetectorScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "dragAndDropSource", "Landroidx/compose/ui/Modifier;", "transferData", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/ui/draganddrop/DragAndDropTransferData;", "drawDragDecoration", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "foundation"}, k=5, mv={2, 0, 0}, xi=0x30, xs="androidx/compose/foundation/draganddrop/DragAndDropSourceKt") final class DragAndDropSourceKt__DragAndDropSourceKt {
    public static final Modifier dragAndDropSource(Modifier arg2, Function1 arg3) {
        return arg2.then(new DragAndDropSourceWithDefaultShadowElement(DragAndDropSourceDefaults.INSTANCE.getDefaultStartDetector(), arg3));
    }

    public static final Modifier dragAndDropSource(Modifier arg2, Function1 arg3, Function1 arg4) {
        return arg2.then(new DragAndDropSourceElement(arg3, DragAndDropSourceDefaults.INSTANCE.getDefaultStartDetector(), arg4));
    }
}

