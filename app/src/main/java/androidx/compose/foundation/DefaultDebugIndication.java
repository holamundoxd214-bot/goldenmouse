package androidx.compose.foundation;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DrawModifierNode;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001:\u0001\u000EB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0016J\b\u0010\b\u001A\u00020\tH\u0016J\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\rH\u0096\u0002¨\u0006\u000F"}, d2={"Landroidx/compose/foundation/DefaultDebugIndication;", "Landroidx/compose/foundation/IndicationNodeFactory;", "<init>", "()V", "create", "Landroidx/compose/ui/node/DelegatableNode;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "hashCode", "", "equals", "", "other", "", "DefaultDebugIndicationInstance", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class DefaultDebugIndication implements IndicationNodeFactory {
    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u000B\u001A\u00020\fH\u0016J\f\u0010\r\u001A\u00020\f*\u00020\u000EH\u0016R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\bX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2={"Landroidx/compose/foundation/DefaultDebugIndication$DefaultDebugIndicationInstance;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "<init>", "(Landroidx/compose/foundation/interaction/InteractionSource;)V", "isPressed", "", "isHovered", "isFocused", "onAttach", "", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class DefaultDebugIndicationInstance extends Node implements DrawModifierNode {
        private final InteractionSource interactionSource;
        private boolean isFocused;
        private boolean isHovered;
        private boolean isPressed;

        public DefaultDebugIndicationInstance(InteractionSource arg1) {
            super();
            this.interactionSource = arg1;
        }

        public static final InteractionSource access$getInteractionSource$p(DefaultDebugIndicationInstance arg0) {
            return arg0.interactionSource;
        }

        public static final boolean access$isFocused$p(DefaultDebugIndicationInstance arg0) {
            return arg0.isFocused;
        }

        public static final boolean access$isHovered$p(DefaultDebugIndicationInstance arg0) {
            return arg0.isHovered;
        }

        public static final boolean access$isPressed$p(DefaultDebugIndicationInstance arg0) {
            return arg0.isPressed;
        }

        public static final void access$setFocused$p(DefaultDebugIndicationInstance arg0, boolean arg1) {
            arg0.isFocused = arg1;
        }

        public static final void access$setHovered$p(DefaultDebugIndicationInstance arg0, boolean arg1) {
            arg0.isHovered = arg1;
        }

        public static final void access$setPressed$p(DefaultDebugIndicationInstance arg0, boolean arg1) {
            arg0.isPressed = arg1;
        }

        public void draw(ContentDrawScope arg15) {
            arg15.drawContent();
            if(this.isPressed) {
                DrawScope.drawRect-n-J9OG0$default(arg15, Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.3f, 0f, 0f, 0f, 14, null), 0, arg15.getSize-NH-jbRc(), 0f, null, null, 0, 0x7A, null);
                return;
            }

            if(!this.isHovered) {
                if(this.isFocused) {
                }
                else {
                    return;
                }
            }

            DrawScope.drawRect-n-J9OG0$default(arg15, Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.1f, 0f, 0f, 0f, 14, null), 0, arg15.getSize-NH-jbRc(), 0f, null, null, 0, 0x7A, null);
        }

        public void onAttach() {
            BuildersKt.launch$default(this.getCoroutineScope(), null, null, new DefaultDebugIndication$DefaultDebugIndicationInstance$onAttach$1(this, null), 3, null);
        }
    }

    public static final DefaultDebugIndication INSTANCE;

    static {
        DefaultDebugIndication.INSTANCE = new DefaultDebugIndication();
    }

    private DefaultDebugIndication() {
        super();
    }

    public DelegatableNode create(InteractionSource arg1) {
        return new DefaultDebugIndicationInstance(arg1);
    }

    public boolean equals(Object arg1) {
        if((((DefaultDebugIndication)arg1)) == this) {
            return 1;
        }

        return 0;
    }

    public int hashCode() {
        return -1;
    }
}

