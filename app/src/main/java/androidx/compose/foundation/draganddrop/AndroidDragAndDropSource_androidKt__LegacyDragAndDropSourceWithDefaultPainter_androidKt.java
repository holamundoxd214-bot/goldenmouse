package androidx.compose.foundation.draganddrop;

import androidx.compose.ui.Modifier;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A:\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\'\u0010\u0002\u001A#\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003¢\u0006\u0002\b\bH\u0007¢\u0006\u0002\u0010\t¨\u0006\n"}, d2={"dragAndDropSource", "Landroidx/compose/ui/Modifier;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/draganddrop/DragAndDropSourceScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;)Landroidx/compose/ui/Modifier;", "foundation"}, k=5, mv={2, 0, 0}, xi=0x30, xs="androidx/compose/foundation/draganddrop/AndroidDragAndDropSource_androidKt") final class AndroidDragAndDropSource_androidKt__LegacyDragAndDropSourceWithDefaultPainter_androidKt {
    @Deprecated(message="Replaced by overload with a callback for obtain a transfer data,start detection is performed by Compose itself", replaceWith="<_subannotation>") public static final Modifier dragAndDropSource(Modifier arg1, Function2 arg2) {
        return arg1.then(new LegacyDragAndDropSourceWithDefaultShadowElement(arg2));
    }
}

