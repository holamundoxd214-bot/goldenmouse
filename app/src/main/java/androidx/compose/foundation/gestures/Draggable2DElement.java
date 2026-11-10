package androidx.compose.foundation.gestures;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!Bw\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001A\u00020\u0006\u0012!\u0010\n\u001A\u001D\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000E\u0012\u0004\b\b(\u000F\u0012\u0004\u0012\u00020\u00100\u000B\u0012!\u0010\u0011\u001A\u001D\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\r\u0012\b\b\u000E\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00100\u000B\u0012\u0006\u0010\u0014\u001A\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0017\u001A\u00020\u0002H\u0016J\u0010\u0010\u0018\u001A\u00020\u00102\u0006\u0010\u0019\u001A\u00020\u0002H\u0016J\u0013\u0010\u001A\u001A\u00020\u00062\b\u0010\u001B\u001A\u0004\u0018\u00010\u001CH\u0096\u0002J\b\u0010\u001D\u001A\u00020\u001EH\u0016J\f\u0010\u001F\u001A\u00020\u0010*\u00020 H\u0016R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001A\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\n\u001A\u001D\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000E\u0012\u0004\b\b(\u000F\u0012\u0004\u0012\u00020\u00100\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\u0011\u001A\u001D\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\r\u0012\b\b\u000E\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00100\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2={"Landroidx/compose/foundation/gestures/Draggable2DElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/gestures/Draggable2DNode;", "state", "Landroidx/compose/foundation/gestures/Draggable2DState;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "startDragImmediately", "onDragStarted", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ParameterName;", "name", "startedPosition", "", "onDragStopped", "Landroidx/compose/ui/unit/Velocity;", "velocity", "reverseDirection", "<init>", "(Landroidx/compose/foundation/gestures/Draggable2DState;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Z)V", "create", "update", "node", "equals", "other", "", "hashCode", "", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "Companion", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Draggable2DElement extends ModifierNodeElement {
    @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001D\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\t¨\u0006\n"}, d2={"Landroidx/compose/foundation/gestures/Draggable2DElement$Companion;", "", "<init>", "()V", "CanDrag", "Lkotlin/Function1;", "Landroidx/compose/ui/input/pointer/PointerType;", "", "getCanDrag", "()Lkotlin/jvm/functions/Function1;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final Function1 getCanDrag() {
            return Draggable2DElement.CanDrag;
        }
    }

    public static final int $stable;
    private static final Function1 CanDrag;
    public static final Companion Companion;
    private final boolean enabled;
    private final MutableInteractionSource interactionSource;
    private final Function1 onDragStarted;
    private final Function1 onDragStopped;
    private final boolean reverseDirection;
    private final boolean startDragImmediately;
    private final Draggable2DState state;

    static {
        Draggable2DElement.Companion = new Companion(null);
        Draggable2DElement.CanDrag = new Draggable2DElement$$ExternalSyntheticLambda0();
    }

    public Draggable2DElement(Draggable2DState arg1, boolean arg2, MutableInteractionSource arg3, boolean arg4, Function1 arg5, Function1 arg6, boolean arg7) {
        super();
        this.state = arg1;
        this.enabled = arg2;
        this.interactionSource = arg3;
        this.startDragImmediately = arg4;
        this.onDragStarted = arg5;
        this.onDragStopped = arg6;
        this.reverseDirection = arg7;
    }

    static final boolean CanDrag$lambda$0(PointerType arg0) {
        return 1;
    }

    public static final Function1 access$getCanDrag$cp() {
        return Draggable2DElement.CanDrag;
    }

    public Draggable2DNode create() {
        return new Draggable2DNode(this.state, Draggable2DElement.CanDrag, this.enabled, this.interactionSource, this.startDragImmediately, this.reverseDirection, this.onDragStarted, this.onDragStopped);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg5) {
        if(this == (((Draggable2DElement)arg5))) {
            return 1;
        }

        if(arg5 == null) {
            return 0;
        }

        if(this.getClass() != arg5.getClass()) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.state, ((Draggable2DElement)arg5).state)) {
            return 0;
        }

        if(this.enabled != ((Draggable2DElement)arg5).enabled) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.interactionSource, ((Draggable2DElement)arg5).interactionSource)) {
            return 0;
        }

        if(this.startDragImmediately != ((Draggable2DElement)arg5).startDragImmediately) {
            return 0;
        }

        if(this.onDragStarted != ((Draggable2DElement)arg5).onDragStarted) {
            return 0;
        }

        if(this.onDragStopped != ((Draggable2DElement)arg5).onDragStopped) {
            return 0;
        }

        if(this.reverseDirection != ((Draggable2DElement)arg5).reverseDirection) {
            return 0;
        }

        return 1;
    }

    public int hashCode() {
        int v0 = (this.state.hashCode() * 0x1F + Boolean.hashCode(this.enabled)) * 0x1F;
        MutableInteractionSource v1 = this.interactionSource;
        int v1_1 = v1 != null ? v1.hashCode() : 0;
        return ((((v0 + v1_1) * 0x1F + Boolean.hashCode(this.startDragImmediately)) * 0x1F + this.onDragStarted.hashCode()) * 0x1F + this.onDragStopped.hashCode()) * 0x1F + Boolean.hashCode(this.reverseDirection);
    }

    public void inspectableProperties(InspectorInfo arg4) {
        arg4.setName("draggable2D");
        arg4.getProperties().set("enabled", Boolean.valueOf(this.enabled));
        arg4.getProperties().set("interactionSource", this.interactionSource);
        arg4.getProperties().set("startDragImmediately", Boolean.valueOf(this.startDragImmediately));
        arg4.getProperties().set("onDragStarted", this.onDragStarted);
        arg4.getProperties().set("onDragStopped", this.onDragStopped);
        arg4.getProperties().set("reverseDirection", Boolean.valueOf(this.reverseDirection));
        arg4.getProperties().set("state", this.state);
    }

    public void update(Draggable2DNode arg10) {
        arg10.update(this.state, Draggable2DElement.CanDrag, this.enabled, this.interactionSource, this.startDragImmediately, this.reverseDirection, this.onDragStarted, this.onDragStopped);
    }

    public void update(Node arg1) {
        this.update(((Draggable2DNode)arg1));
    }
}

