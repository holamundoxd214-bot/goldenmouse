package androidx.compose.foundation.text.input.internal;

import android.content.ClipDescription;
import androidx.compose.foundation.content.MediaType;
import androidx.compose.ui.draganddrop.DragAndDropEvent;
import androidx.compose.ui.draganddrop.DragAndDropNodeKt;
import androidx.compose.ui.draganddrop.DragAndDropTargetModifierNode;
import androidx.compose.ui.draganddrop.DragAndDrop_androidKt;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001AÒ\u0002\u0010\u0000\u001A\u00020\u00012\u0012\u0010\u0002\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u000326\u0010\u0006\u001A2\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000B\u0012\u0013\u0012\u00110\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000E0\u00072\u0012\u0010\u000F\u001A\u000E\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00102%\b\u0002\u0010\u0013\u001A\u001F\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00102%\b\u0002\u0010\u0015\u001A\u001F\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00102%\b\u0002\u0010\u0016\u001A\u001F\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00102%\b\u0002\u0010\u0019\u001A\u001F\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00102%\b\u0002\u0010\u001A\u001A\u001F\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00102%\b\u0002\u0010\u001B\u001A\u001F\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0010H\u0000¨\u0006\u001C"}, d2={"textFieldDragAndDropNode", "Landroidx/compose/ui/draganddrop/DragAndDropTargetModifierNode;", "hintMediaTypes", "Lkotlin/Function0;", "", "Landroidx/compose/foundation/content/MediaType;", "onDrop", "Lkotlin/Function2;", "Landroidx/compose/ui/platform/ClipEntry;", "Lkotlin/ParameterName;", "name", "clipEntry", "Landroidx/compose/ui/platform/ClipMetadata;", "clipMetadata", "", "dragAndDropRequestPermission", "Lkotlin/Function1;", "Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "", "onStarted", "event", "onEntered", "onMoved", "Landroidx/compose/ui/geometry/Offset;", "position", "onChanged", "onExited", "onEnded", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TextFieldDragAndDropNode_androidKt {
    public static final DragAndDropTargetModifierNode textFieldDragAndDropNode(Function0 arg2, Function2 arg3, Function1 arg4, Function1 arg5, Function1 arg6, Function1 arg7, Function1 arg8, Function1 arg9, Function1 arg10) {
        return DragAndDropNodeKt.DragAndDropTargetModifierNode(new TextFieldDragAndDropNode_androidKt$$ExternalSyntheticLambda0(arg2), new TextFieldDragAndDropNode_androidKt$textFieldDragAndDropNode$2(arg4, arg3, arg5, arg6, arg7, arg9, arg8, arg10));
    }

    public static DragAndDropTargetModifierNode textFieldDragAndDropNode$default(Function0 arg1, Function2 arg2, Function1 arg3, Function1 arg4, Function1 arg5, Function1 arg6, Function1 arg7, Function1 arg8, Function1 arg9, int arg10, Object arg11) {
        Function1 v0 = null;
        if((arg10 & 8) != 0) {
            arg4 = v0;
        }

        if((arg10 & 16) != 0) {
            arg5 = v0;
        }

        if((arg10 & 0x20) != 0) {
            arg6 = v0;
        }

        if((arg10 & 0x40) != 0) {
            arg7 = v0;
        }

        if((arg10 & 0x80) != 0) {
            arg8 = v0;
        }

        if((arg10 & 0x100) != 0) {
            arg9 = v0;
        }

        return TextFieldDragAndDropNode_androidKt.textFieldDragAndDropNode(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
    }

    static final boolean textFieldDragAndDropNode$lambda$0(Function0 arg3, DragAndDropEvent arg4) {
        ClipDescription v4 = DragAndDrop_androidKt.toAndroidDragEvent(arg4).getClipDescription();
        Object v3 = arg3.invoke();
        if(((v3 instanceof Collection)) && (v3.isEmpty())) {
            return 0;
        }

        Iterator v3_1 = ((Iterable)v3).iterator();
        do {
            if(!v3_1.hasNext()) {
                return 0;
            }

            Object v0 = v3_1.next();
            if(Intrinsics.areEqual(v0, MediaType.Companion.getAll())) {
                return 1;
            }
        }
        while(!v4.hasMimeType(((MediaType)v0).getRepresentation()));

        return 1;
    }
}

