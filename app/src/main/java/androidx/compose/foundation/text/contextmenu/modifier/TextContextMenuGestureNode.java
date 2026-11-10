package androidx.compose.foundation.text.contextmenu.modifier;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuData;
import androidx.compose.foundation.text.contextmenu.gestures.RightClickGesturesKt;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuProvider;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuProviderKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0002\u0018\u0000  2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002 !B<\u00123\u0010\u0004\u001A/\b\u0001\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000B0\n\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u0005¢\u0006\u0004\b\r\u0010\u000EJ@\u0010\u0019\u001A\u00020\u000B23\u0010\u0004\u001A/\b\u0001\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000B0\n\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u0005¢\u0006\u0002\u0010\u000EJ\u0010\u0010\u001A\u001A\u00020\u000B2\u0006\u0010\u001B\u001A\u00020\u0011H\u0016J\u0017\u0010\u001C\u001A\u00020\u000B2\u0006\u0010\u001D\u001A\u00020\u0006H\u0002¢\u0006\u0004\b\u001E\u0010\u001FR=\u0010\u0004\u001A/\b\u0001\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000B0\n\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u000FR/\u0010\u0012\u001A\u0004\u0018\u00010\u00112\b\u0010\u0010\u001A\u0004\u0018\u00010\u00118B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001A\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2={"Landroidx/compose/foundation/text/contextmenu/modifier/TextContextMenuGestureNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "onPreShowContextMenu", "Lkotlin/Function2;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ParameterName;", "name", "clickLocation", "Lkotlin/coroutines/Continuation;", "", "", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "<set-?>", "Landroidx/compose/ui/layout/LayoutCoordinates;", "localCoordinates", "getLocalCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setLocalCoordinates", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "localCoordinates$delegate", "Landroidx/compose/runtime/MutableState;", "update", "onGloballyPositioned", "coordinates", "tryShowContextMenu", "localClickOffset", "tryShowContextMenu-k-4lQ0M", "(J)V", "Companion", "ClickTextContextMenuDataProvider", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class TextContextMenuGestureNode extends DelegatingNode implements CompositionLocalConsumerModifierNode, GlobalPositionAwareModifierNode {
    @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001A\u00020\u00032\u0006\u0010\b\u001A\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000BJ\u0010\u0010\f\u001A\u00020\r2\u0006\u0010\b\u001A\u00020\tH\u0016J\b\u0010\u000E\u001A\u00020\u000FH\u0016R\u0010\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0010"}, d2={"Landroidx/compose/foundation/text/contextmenu/modifier/TextContextMenuGestureNode$ClickTextContextMenuDataProvider;", "Landroidx/compose/foundation/text/contextmenu/provider/TextContextMenuDataProvider;", "localClickOffset", "Landroidx/compose/ui/geometry/Offset;", "<init>", "(Landroidx/compose/foundation/text/contextmenu/modifier/TextContextMenuGestureNode;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "position", "destinationCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "position-tuRUvjQ", "(Landroidx/compose/ui/layout/LayoutCoordinates;)J", "contentBounds", "Landroidx/compose/ui/geometry/Rect;", "data", "Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuData;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class ClickTextContextMenuDataProvider implements TextContextMenuDataProvider {
        private final long localClickOffset;

        public ClickTextContextMenuDataProvider(TextContextMenuGestureNode arg1, long arg2, DefaultConstructorMarker arg4) {
            this(arg1, arg2);
        }

        private ClickTextContextMenuDataProvider(TextContextMenuGestureNode arg1, long arg2) {
            TextContextMenuGestureNode.this = arg1;
            super();
            this.localClickOffset = arg2;
        }

        public Rect contentBounds(LayoutCoordinates arg3) {
            return RectKt.Rect-tz77jQw(this.position-tuRUvjQ(arg3), Size.Companion.getZero-NH-jbRc());
        }

        public TextContextMenuData data() {
            return TextContextMenuModifierKt.collectTextContextMenuData(TextContextMenuGestureNode.this);
        }

        public long position-tuRUvjQ(LayoutCoordinates arg4) {
            LayoutCoordinates v0 = TextContextMenuGestureNode.this.getLocalCoordinates();
            if(v0 != null) {
                return arg4.localPositionOf-R5De75A(v0, this.localClickOffset);
            }

            InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Tried to open context menu before the anchor was placed.");
            throw new KotlinNothingValueException();
        }
    }

    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2={"Landroidx/compose/foundation/text/contextmenu/modifier/TextContextMenuGestureNode$Companion;", "", "<init>", "()V", "MESSAGE", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    private static final Companion Companion = null;
    private static final String MESSAGE = "Tried to open context menu before the anchor was placed.";
    private final MutableState localCoordinates$delegate;
    private Function2 onPreShowContextMenu;

    static {
        TextContextMenuGestureNode.Companion = new Companion(null);
    }

    public TextContextMenuGestureNode(Function2 arg2) {
        super();
        this.onPreShowContextMenu = arg2;
        this.localCoordinates$delegate = SnapshotStateKt.mutableStateOf(null, SnapshotStateKt.neverEqualPolicy());
        this.delegate(SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new PointerInputEventHandler() {
            public final Object invoke(PointerInputScope arg2, Continuation arg3) {
                Object v1 = RightClickGesturesKt.onRightClickDown(arg2, new Function1() {
                    public Object invoke(Object arg3) {
                        this.invoke-k-4lQ0M(((Offset)arg3).unbox-impl());
                        return Unit.INSTANCE;
                    }

                    public final void invoke-k-4lQ0M(long arg1) {
                        TextContextMenuGestureNode.access$tryShowContextMenu-k-4lQ0M(this.receiver, arg1);
                    }
                }, arg3);
                if(v1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return v1;
                }

                return Unit.INSTANCE;
            }
        }));
    }

    public static final LayoutCoordinates access$getLocalCoordinates(TextContextMenuGestureNode arg0) {
        return arg0.getLocalCoordinates();
    }

    public static final Function2 access$getOnPreShowContextMenu$p(TextContextMenuGestureNode arg0) {
        return arg0.onPreShowContextMenu;
    }

    public static final void access$tryShowContextMenu-k-4lQ0M(TextContextMenuGestureNode arg0, long arg1) {
        arg0.tryShowContextMenu-k-4lQ0M(arg1);
    }

    private final LayoutCoordinates getLocalCoordinates() {
        return this.localCoordinates$delegate.getValue();
    }

    public void onGloballyPositioned(LayoutCoordinates arg1) {
        this.setLocalCoordinates(arg1);
    }

    private final void setLocalCoordinates(LayoutCoordinates arg1) {
        this.localCoordinates$delegate.setValue(arg1);
    }

    private final void tryShowContextMenu-k-4lQ0M(long arg14) {
        Object v5 = CompositionLocalConsumerModifierNodeKt.currentValueOf(this, TextContextMenuProviderKt.getLocalTextContextMenuDropdownProvider());
        if(v5 == null) {
            return;
        }

        BuildersKt.launch$default(this.getCoroutineScope(), null, null, new TextContextMenuGestureNode$tryShowContextMenu$1(this, arg14, ((TextContextMenuProvider)v5), new ClickTextContextMenuDataProvider(this, arg14, null), null), 3, null);
    }

    public final void update(Function2 arg1) {
        this.onPreShowContextMenu = arg1;
    }
}

