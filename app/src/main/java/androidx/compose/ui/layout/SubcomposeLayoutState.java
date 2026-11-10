package androidx.compose.ui.layout;

import androidx.compose.runtime.ShouldPauseCallback;
import androidx.compose.ui.unit.IntSize;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0002*+B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0006B\u0011\b\u0017\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\u0004\u0010\tJ(\u0010\u001E\u001A\u00020\u001F2\b\u0010 \u001A\u0004\u0018\u00010\u00012\u0011\u0010!\u001A\r\u0012\u0004\u0012\u00020\u00120\"¢\u0006\u0002\b#¢\u0006\u0002\u0010$J(\u0010%\u001A\u00020&2\b\u0010 \u001A\u0004\u0018\u00010\u00012\u0011\u0010!\u001A\r\u0012\u0004\u0012\u00020\u00120\"¢\u0006\u0002\b#¢\u0006\u0002\u0010\'J\r\u0010(\u001A\u00020\u0012H\u0000¢\u0006\u0002\b)R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001A\u0004\u0018\u00010\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001A\u00020\u000B8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\u000ER+\u0010\u000F\u001A\u0019\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00120\u0010¢\u0006\u0002\b\u0013X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R+\u0010\u0016\u001A\u0019\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00120\u0010¢\u0006\u0002\b\u0013X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0015RB\u0010\u0019\u001A0\u0012\u0004\u0012\u00020\u0011\u0012\u001B\u0012\u0019\u0012\u0004\u0012\u00020\u001A\u0012\u0004\u0012\u00020\u001B\u0012\u0004\u0012\u00020\u001C0\u0010¢\u0006\u0002\b\u0013\u0012\u0004\u0012\u00020\u00120\u0010¢\u0006\u0002\b\u0013X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u0015¨\u0006,"}, d2={"Landroidx/compose/ui/layout/SubcomposeLayoutState;", "", "slotReusePolicy", "Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;", "<init>", "(Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;)V", "()V", "maxSlotsToRetainForReuse", "", "(I)V", "_state", "Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;", "state", "getState", "()Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;", "setRoot", "Lkotlin/Function2;", "Landroidx/compose/ui/node/LayoutNode;", "", "Lkotlin/ExtensionFunctionType;", "getSetRoot$ui", "()Lkotlin/jvm/functions/Function2;", "setCompositionContext", "Landroidx/compose/runtime/CompositionContext;", "getSetCompositionContext$ui", "setMeasurePolicy", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "getSetMeasurePolicy$ui", "precompose", "Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "slotId", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "createPausedPrecomposition", "Landroidx/compose/ui/layout/SubcomposeLayoutState$PausedPrecomposition;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Landroidx/compose/ui/layout/SubcomposeLayoutState$PausedPrecomposition;", "forceRecomposeChildren", "forceRecomposeChildren$ui", "PausedPrecomposition", "PrecomposedSlotHandle", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SubcomposeLayoutState {
    @Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001A\u00020\u00032\u0006\u0010\u0006\u001A\u00020\u0007H&J\b\u0010\b\u001A\u00020\tH&J\b\u0010\n\u001A\u00020\u000BH&R\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0002\u0010\u0004\u0082\u0001\u0001\fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2={"Landroidx/compose/ui/layout/SubcomposeLayoutState$PausedPrecomposition;", "", "isComplete", "", "()Z", "resume", "shouldPause", "Landroidx/compose/runtime/ShouldPauseCallback;", "apply", "Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "cancel", "", "Landroidx/compose/ui/layout/PausedPrecompositionImpl;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface PausedPrecomposition {
        PrecomposedSlotHandle apply();

        void cancel();

        boolean isComplete();

        boolean resume(ShouldPauseCallback arg1);
    }

    @Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001A\u00020\u0003H&J\u001F\u0010\b\u001A\u00020\u00032\u0006\u0010\t\u001A\u00020\u00052\u0006\u0010\n\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\f\u0010\rJ&\u0010\u000E\u001A\u00020\u00032\b\u0010\u000F\u001A\u0004\u0018\u00010\u00012\u0012\u0010\u0010\u001A\u000E\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011H\u0016J\u0017\u0010\u0014\u001A\u00020\u00152\u0006\u0010\t\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0004\u001A\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0018À\u0006\u0001"}, d2={"Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "", "dispose", "", "placeablesCount", "", "getPlaceablesCount", "()I", "premeasure", "index", "constraints", "Landroidx/compose/ui/unit/Constraints;", "premeasure-0kLqBqw", "(IJ)V", "traverseDescendants", "key", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/node/TraversableNode;", "Landroidx/compose/ui/node/TraversableNode$Companion$TraverseDescendantsAction;", "getSize", "Landroidx/compose/ui/unit/IntSize;", "getSize-YEO4UFw", "(I)J", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface PrecomposedSlotHandle {
        void dispose();

        default int getPlaceablesCount() {
            return 0;
        }

        default long getSize-YEO4UFw(int arg1) {
            return IntSize.Companion.getZero-YbymL2g();
        }

        default void premeasure-0kLqBqw(int arg1, long arg2) {
        }

        default void traverseDescendants(Object arg1, Function1 arg2) {
        }
    }

    public static final int $stable = 8;
    private LayoutNodeSubcompositionsState _state;
    private final Function2 setCompositionContext;
    private final Function2 setMeasurePolicy;
    private final Function2 setRoot;
    private final SubcomposeSlotReusePolicy slotReusePolicy;

    static {
    }

    public SubcomposeLayoutState(SubcomposeSlotReusePolicy arg1) {
        super();
        this.slotReusePolicy = arg1;
        this.setRoot = new SubcomposeLayoutState$setRoot$1(this);
        this.setCompositionContext = new SubcomposeLayoutState$setCompositionContext$1(this);
        this.setMeasurePolicy = new SubcomposeLayoutState$setMeasurePolicy$1(this);
    }

    public SubcomposeLayoutState() {
        this(NoOpSubcomposeSlotReusePolicy.INSTANCE);
    }

    @Deprecated(message="This constructor is deprecated", replaceWith="<_subannotation>") public SubcomposeLayoutState(int arg1) {
        this(SubcomposeLayoutKt.SubcomposeSlotReusePolicy(arg1));
    }

    public static final SubcomposeSlotReusePolicy access$getSlotReusePolicy$p(SubcomposeLayoutState arg0) {
        return arg0.slotReusePolicy;
    }

    public static final LayoutNodeSubcompositionsState access$getState(SubcomposeLayoutState arg0) {
        return arg0.getState();
    }

    public static final void access$set_state$p(SubcomposeLayoutState arg0, LayoutNodeSubcompositionsState arg1) {
        arg0._state = arg1;
    }

    public final PausedPrecomposition createPausedPrecomposition(Object arg1, Function2 arg2) {
        return this.getState().precomposePaused(arg1, arg2);
    }

    public final void forceRecomposeChildren$ui() {
        this.getState().forceRecomposeChildren();
    }

    public final Function2 getSetCompositionContext$ui() {
        return this.setCompositionContext;
    }

    public final Function2 getSetMeasurePolicy$ui() {
        return this.setMeasurePolicy;
    }

    public final Function2 getSetRoot$ui() {
        return this.setRoot;
    }

    private final LayoutNodeSubcompositionsState getState() {
        LayoutNodeSubcompositionsState v1 = this._state;
        if(v1 != null) {
            return v1;
        }

        throw new IllegalArgumentException("SubcomposeLayoutState is not attached to SubcomposeLayout".toString());
    }

    public final PrecomposedSlotHandle precompose(Object arg1, Function2 arg2) {
        return this.getState().precompose(arg1, arg2);
    }
}

