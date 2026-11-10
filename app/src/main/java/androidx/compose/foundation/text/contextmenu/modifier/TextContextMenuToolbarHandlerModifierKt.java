package androidx.compose.foundation.text.contextmenu.modifier;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000<\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001A\u0082\u0001\u0010\u0002\u001A\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052 \b\u0002\u0010\u0006\u001A\u001A\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u00072 \b\u0002\u0010\u000B\u001A\u001A\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u00072#\u0010\f\u001A\u001F\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000E\u0012\b\b\u000F\u0012\u0004\b\b(\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0007H\u0000¢\u0006\u0002\u0010\u0012\u001A \u0010\u0013\u001A\u00020\u00112\u0006\u0010\u0014\u001A\u00020\u00112\u0006\u0010\u0015\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\rH\u0000\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2={"ToolbarRequesterNotInitialized", "", "textContextMenuToolbarHandler", "Landroidx/compose/ui/Modifier;", "requester", "Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;", "onShow", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "", "onHide", "computeContentBounds", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Lkotlin/ParameterName;", "name", "destinationCoordinates", "Landroidx/compose/ui/geometry/Rect;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Landroidx/compose/ui/Modifier;", "translateRootToDestination", "rootContentBounds", "localCoordinates", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TextContextMenuToolbarHandlerModifierKt {
    private static final String ToolbarRequesterNotInitialized = "ToolbarRequester is not initialized.";

    public static final Modifier textContextMenuToolbarHandler(Modifier arg1, ToolbarRequester arg2, Function1 arg3, Function1 arg4, Function1 arg5) {
        return arg1.then(new TextContextMenuToolbarHandlerElement(arg2, arg3, arg4, arg5));
    }

    public static Modifier textContextMenuToolbarHandler$default(Modifier arg1, ToolbarRequester arg2, Function1 arg3, Function1 arg4, Function1 arg5, int arg6, Object arg7) {
        Function1 v0 = null;
        if((arg6 & 2) != 0) {
            arg3 = v0;
        }

        if((arg6 & 4) != 0) {
            arg4 = v0;
        }

        return TextContextMenuToolbarHandlerModifierKt.textContextMenuToolbarHandler(arg1, arg2, arg3, arg4, arg5);
    }

    public static final Rect translateRootToDestination(Rect arg2, LayoutCoordinates arg3, LayoutCoordinates arg4) {
        if(arg3.isAttached()) {
            if(!arg4.isAttached()) {
            }
            else {
                return RectKt.Rect-tz77jQw(arg4.localPositionOf-R5De75A(LayoutCoordinatesKt.findRootCoordinates(arg3), arg2.getTopLeft-F1C5BW0()), arg2.getSize-NH-jbRc());
            }
        }

        return Rect.Companion.getZero();
    }
}

