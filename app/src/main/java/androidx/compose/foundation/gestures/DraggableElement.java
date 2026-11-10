package androidx.compose.foundation.gestures;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000B\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 \'2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\'Bµ\u0001\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\b\u0010\t\u001A\u0004\u0018\u00010\n\u0012\u0006\u0010\u000B\u001A\u00020\b\u0012<\u0010\f\u001A8\b\u0001\u0012\u0004\u0012\u00020\u000E\u0012\u0013\u0012\u00110\u000F¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00150\r¢\u0006\u0002\b\u0016\u0012<\u0010\u0017\u001A8\b\u0001\u0012\u0004\u0012\u00020\u000E\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00150\r¢\u0006\u0002\b\u0016\u0012\u0006\u0010\u001A\u001A\u00020\b¢\u0006\u0004\b\u001B\u0010\u001CJ\b\u0010\u001E\u001A\u00020\u0002H\u0016J\u0010\u0010\u001F\u001A\u00020\u00142\u0006\u0010 \u001A\u00020\u0002H\u0016J\u0013\u0010!\u001A\u00020\b2\b\u0010\"\u001A\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010#\u001A\u00020$H\u0016J\f\u0010%\u001A\u00020\u0014*\u00020&H\u0016R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001A\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000RF\u0010\f\u001A8\b\u0001\u0012\u0004\u0012\u00020\u000E\u0012\u0013\u0012\u00110\u000F¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00150\r¢\u0006\u0002\b\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001DRF\u0010\u0017\u001A8\b\u0001\u0012\u0004\u0012\u00020\u000E\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00150\r¢\u0006\u0002\b\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001DR\u000E\u0010\u001A\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2={"Landroidx/compose/foundation/gestures/DraggableElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/gestures/DraggableNode;", "state", "Landroidx/compose/foundation/gestures/DraggableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "startDragImmediately", "onDragStarted", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ParameterName;", "name", "startedPosition", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "onDragStopped", "", "velocity", "reverseDirection", "<init>", "(Landroidx/compose/foundation/gestures/DraggableState;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;ZLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Z)V", "Lkotlin/jvm/functions/Function3;", "create", "update", "node", "equals", "other", "hashCode", "", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "Companion", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DraggableElement extends ModifierNodeElement {
    @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001D\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\t¨\u0006\n"}, d2={"Landroidx/compose/foundation/gestures/DraggableElement$Companion;", "", "<init>", "()V", "CanDrag", "Lkotlin/Function1;", "Landroidx/compose/ui/input/pointer/PointerType;", "", "getCanDrag", "()Lkotlin/jvm/functions/Function1;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final Function1 getCanDrag() {
            return DraggableElement.CanDrag;
        }
    }

    public static final int $stable;
    private static final Function1 CanDrag;
    public static final Companion Companion;
    private final boolean enabled;
    private final MutableInteractionSource interactionSource;
    private final Function3 onDragStarted;
    private final Function3 onDragStopped;
    private final Orientation orientation;
    private final boolean reverseDirection;
    private final boolean startDragImmediately;
    private final DraggableState state;

    static {
        DraggableElement.Companion = new Companion(null);
        DraggableElement.CanDrag = new DraggableElement$$ExternalSyntheticLambda0();
    }

    public DraggableElement(DraggableState arg1, Orientation arg2, boolean arg3, MutableInteractionSource arg4, boolean arg5, Function3 arg6, Function3 arg7, boolean arg8) {
        super();
        this.state = arg1;
        this.orientation = arg2;
        this.enabled = arg3;
        this.interactionSource = arg4;
        this.startDragImmediately = arg5;
        this.onDragStarted = arg6;
        this.onDragStopped = arg7;
        this.reverseDirection = arg8;
    }

    static final boolean CanDrag$lambda$0(PointerType arg0) {
        return 1;
    }

    public static final Function1 access$getCanDrag$cp() {
        return DraggableElement.CanDrag;
    }

    public DraggableNode create() {
        return new DraggableNode(this.state, DraggableElement.CanDrag, this.orientation, this.enabled, this.interactionSource, this.startDragImmediately, this.onDragStarted, this.onDragStopped, this.reverseDirection);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg5) {
        if(this == (((DraggableElement)arg5))) {
            return 1;
        }

        if(arg5 == null) {
            return 0;
        }

        if(this.getClass() != arg5.getClass()) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.state, ((DraggableElement)arg5).state)) {
            return 0;
        }

        if(this.orientation != ((DraggableElement)arg5).orientation) {
            return 0;
        }

        if(this.enabled != ((DraggableElement)arg5).enabled) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.interactionSource, ((DraggableElement)arg5).interactionSource)) {
            return 0;
        }

        if(this.startDragImmediately != ((DraggableElement)arg5).startDragImmediately) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.onDragStarted, ((DraggableElement)arg5).onDragStarted)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.onDragStopped, ((DraggableElement)arg5).onDragStopped)) {
            return 0;
        }

        if(this.reverseDirection != ((DraggableElement)arg5).reverseDirection) {
            return 0;
        }

        return 1;
    }

    public int hashCode() {
        int v0 = ((this.state.hashCode() * 0x1F + this.orientation.hashCode()) * 0x1F + Boolean.hashCode(this.enabled)) * 0x1F;
        MutableInteractionSource v1 = this.interactionSource;
        int v1_1 = v1 != null ? v1.hashCode() : 0;
        return ((((v0 + v1_1) * 0x1F + Boolean.hashCode(this.startDragImmediately)) * 0x1F + this.onDragStarted.hashCode()) * 0x1F + this.onDragStopped.hashCode()) * 0x1F + Boolean.hashCode(this.reverseDirection);
    }

    public void inspectableProperties(InspectorInfo arg4) {
        arg4.setName("draggable");
        arg4.getProperties().set("orientation", this.orientation);
        arg4.getProperties().set("enabled", Boolean.valueOf(this.enabled));
        arg4.getProperties().set("reverseDirection", Boolean.valueOf(this.reverseDirection));
        arg4.getProperties().set("interactionSource", this.interactionSource);
        arg4.getProperties().set("startDragImmediately", Boolean.valueOf(this.startDragImmediately));
        arg4.getProperties().set("onDragStarted", this.onDragStarted);
        arg4.getProperties().set("onDragStopped", this.onDragStopped);
        arg4.getProperties().set("state", this.state);
    }

    public void update(DraggableNode arg11) {
        arg11.update(this.state, DraggableElement.CanDrag, this.orientation, this.enabled, this.interactionSource, this.startDragImmediately, this.onDragStarted, this.onDragStopped, this.reverseDirection);
    }

    public void update(Node arg1) {
        this.update(((DraggableNode)arg1));
    }
}

