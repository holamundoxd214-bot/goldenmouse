package androidx.compose.ui.input.indirect;

import java.util.List;
import kotlin.Metadata;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001A\u00020\bX¦\u0004¢\u0006\u0006\u001A\u0004\b\t\u0010\nR\u0012\u0010\u000B\u001A\u00020\fX¦\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\n\u0082\u0001\u0001\u000Eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000FÀ\u0006\u0001"}, d2={"Landroidx/compose/ui/input/indirect/IndirectPointerEvent;", "", "changes", "", "Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;", "getChanges", "()Ljava/util/List;", "type", "Landroidx/compose/ui/input/indirect/IndirectPointerEventType;", "getType-4ZHQPSE", "()I", "primaryDirectionalMotionAxis", "Landroidx/compose/ui/input/indirect/IndirectPointerEventPrimaryDirectionalMotionAxis;", "getPrimaryDirectionalMotionAxis-nZO2Niw", "Landroidx/compose/ui/input/indirect/PlatformIndirectPointerEvent;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface IndirectPointerEvent {
    List getChanges();

    int getPrimaryDirectionalMotionAxis-nZO2Niw();

    int getType-4ZHQPSE();
}

