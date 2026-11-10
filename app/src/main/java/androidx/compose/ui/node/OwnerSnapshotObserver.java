package androidx.compose.ui.node;

import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\r\b\u0001\u0018\u00002\u00020\u0001B0\u0012\'\u0010\u0002\u001A#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\t\u0010\nJ&\u0010\u0015\u001A\u00020\u00052\u0006\u0010\u0016\u001A\u00020\u000E2\u000E\b\b\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0080\b¢\u0006\u0002\b\u0018J&\u0010\u0019\u001A\u00020\u00052\u0006\u0010\u0016\u001A\u00020\u000E2\u000E\b\b\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0080\b¢\u0006\u0002\b\u001AJ&\u0010\u001B\u001A\u00020\u00052\u0006\u0010\u0016\u001A\u00020\u000E2\u000E\b\b\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0080\b¢\u0006\u0002\b\u001CJ&\u0010\u001D\u001A\u00020\u00052\u0006\u0010\u0016\u001A\u00020\u000E2\u000E\b\b\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0080\b¢\u0006\u0002\b\u001EJ&\u0010\u001F\u001A\u00020\u00052\u0006\u0010\u0016\u001A\u00020\u000E2\u000E\b\b\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0080\b¢\u0006\u0002\b J&\u0010!\u001A\u00020\u00052\u0006\u0010\u0016\u001A\u00020\u000E2\u000E\b\b\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0080\b¢\u0006\u0002\b\"J&\u0010#\u001A\u00020\u00052\u0006\u0010\u0016\u001A\u00020\u000E2\u000E\b\b\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0080\b¢\u0006\u0002\b$JH\u0010%\u001A\u00020\u0005\"\b\b\u0000\u0010&*\u00020\'2\u0006\u0010(\u001A\u0002H&2\u0014\b\b\u0010)\u001A\u000E\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u00020\u00050\u00032\u000E\b\b\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0080\b¢\u0006\u0004\b*\u0010+J\r\u0010,\u001A\u00020\u0005H\u0000¢\u0006\u0002\b-J\u0015\u0010.\u001A\u00020\u00052\u0006\u0010(\u001A\u00020\u0001H\u0000¢\u0006\u0002\b/J\r\u00100\u001A\u00020\u0005H\u0000¢\u0006\u0002\b1J\r\u00102\u001A\u00020\u0005H\u0000¢\u0006\u0002\b3R\u000E\u0010\u000B\u001A\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\r\u001A\u000E\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u000F\u001A\u000E\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0010\u001A\u000E\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0011\u001A\u000E\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0012\u001A\u000E\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0013\u001A\u000E\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0014\u001A\u000E\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2={"Landroidx/compose/ui/node/OwnerSnapshotObserver;", "", "onChangedExecutor", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "Lkotlin/ParameterName;", "name", "callback", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "observer", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "onCommitAffectingLookaheadMeasure", "Landroidx/compose/ui/node/LayoutNode;", "onCommitAffectingMeasure", "onCommitAffectingSemantics", "onCommitAffectingLayout", "onCommitAffectingLayoutModifier", "onCommitAffectingLayoutModifierInLookahead", "onCommitAffectingLookahead", "observeLayoutSnapshotReads", "node", "block", "observeLayoutSnapshotReads$ui", "observeLayoutSnapshotReadsAffectingLookahead", "observeLayoutSnapshotReadsAffectingLookahead$ui", "observeLayoutModifierSnapshotReads", "observeLayoutModifierSnapshotReads$ui", "observeLayoutModifierSnapshotReadsAffectingLookahead", "observeLayoutModifierSnapshotReadsAffectingLookahead$ui", "observeMeasureSnapshotReads", "observeMeasureSnapshotReads$ui", "observeMeasureSnapshotReadsAffectingLookahead", "observeMeasureSnapshotReadsAffectingLookahead$ui", "observeSemanticsReads", "observeSemanticsReads$ui", "observeReads", "T", "Landroidx/compose/ui/node/OwnerScope;", "target", "onChanged", "observeReads$ui", "(Landroidx/compose/ui/node/OwnerScope;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "clearInvalidObservations", "clearInvalidObservations$ui", "clear", "clear$ui", "startObserving", "startObserving$ui", "stopObserving", "stopObserving$ui", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class OwnerSnapshotObserver {
    public static final int $stable;
    private final SnapshotStateObserver observer;
    private final Function1 onCommitAffectingLayout;
    private final Function1 onCommitAffectingLayoutModifier;
    private final Function1 onCommitAffectingLayoutModifierInLookahead;
    private final Function1 onCommitAffectingLookahead;
    private final Function1 onCommitAffectingLookaheadMeasure;
    private final Function1 onCommitAffectingMeasure;
    private final Function1 onCommitAffectingSemantics;

    static {
        OwnerSnapshotObserver.$stable = SnapshotStateObserver.$stable;
    }

    public OwnerSnapshotObserver(Function1 arg2) {
        super();
        this.observer = new SnapshotStateObserver(arg2);
        this.onCommitAffectingLookaheadMeasure = OwnerSnapshotObserver$onCommitAffectingLookaheadMeasure$1.INSTANCE;
        this.onCommitAffectingMeasure = OwnerSnapshotObserver$onCommitAffectingMeasure$1.INSTANCE;
        this.onCommitAffectingSemantics = OwnerSnapshotObserver$onCommitAffectingSemantics$1.INSTANCE;
        this.onCommitAffectingLayout = OwnerSnapshotObserver$onCommitAffectingLayout$1.INSTANCE;
        this.onCommitAffectingLayoutModifier = OwnerSnapshotObserver$onCommitAffectingLayoutModifier$1.INSTANCE;
        this.onCommitAffectingLayoutModifierInLookahead = OwnerSnapshotObserver$onCommitAffectingLayoutModifierInLookahead$1.INSTANCE;
        this.onCommitAffectingLookahead = OwnerSnapshotObserver$onCommitAffectingLookahead$1.INSTANCE;
    }

    public static final SnapshotStateObserver access$getObserver$p(OwnerSnapshotObserver arg0) {
        return arg0.observer;
    }

    public static final Function1 access$getOnCommitAffectingLayout$p(OwnerSnapshotObserver arg0) {
        return arg0.onCommitAffectingLayout;
    }

    public static final Function1 access$getOnCommitAffectingLayoutModifier$p(OwnerSnapshotObserver arg0) {
        return arg0.onCommitAffectingLayoutModifier;
    }

    public static final Function1 access$getOnCommitAffectingLayoutModifierInLookahead$p(OwnerSnapshotObserver arg0) {
        return arg0.onCommitAffectingLayoutModifierInLookahead;
    }

    public static final Function1 access$getOnCommitAffectingLookahead$p(OwnerSnapshotObserver arg0) {
        return arg0.onCommitAffectingLookahead;
    }

    public static final Function1 access$getOnCommitAffectingLookaheadMeasure$p(OwnerSnapshotObserver arg0) {
        return arg0.onCommitAffectingLookaheadMeasure;
    }

    public static final Function1 access$getOnCommitAffectingMeasure$p(OwnerSnapshotObserver arg0) {
        return arg0.onCommitAffectingMeasure;
    }

    public static final Function1 access$getOnCommitAffectingSemantics$p(OwnerSnapshotObserver arg0) {
        return arg0.onCommitAffectingSemantics;
    }

    public final void clear$ui(Object arg1) {
        this.observer.clear(arg1);
    }

    public final void clearInvalidObservations$ui() {
        this.observer.clearIf(OwnerSnapshotObserver$clearInvalidObservations$1.INSTANCE);
    }

    public final void observeLayoutModifierSnapshotReads$ui(LayoutNode arg2, Function0 arg3) {
        this.observer.observeReads(arg2, this.onCommitAffectingLayoutModifier, arg3);
    }

    public final void observeLayoutModifierSnapshotReadsAffectingLookahead$ui(LayoutNode arg2, Function0 arg3) {
        this.observer.observeReads(arg2, this.onCommitAffectingLayoutModifierInLookahead, arg3);
    }

    public final void observeLayoutSnapshotReads$ui(LayoutNode arg2, Function0 arg3) {
        this.observer.observeReads(arg2, this.onCommitAffectingLayout, arg3);
    }

    public final void observeLayoutSnapshotReadsAffectingLookahead$ui(LayoutNode arg2, Function0 arg3) {
        this.observer.observeReads(arg2, this.onCommitAffectingLookahead, arg3);
    }

    public final void observeMeasureSnapshotReads$ui(LayoutNode arg2, Function0 arg3) {
        this.observer.observeReads(arg2, this.onCommitAffectingMeasure, arg3);
    }

    public final void observeMeasureSnapshotReadsAffectingLookahead$ui(LayoutNode arg2, Function0 arg3) {
        this.observer.observeReads(arg2, this.onCommitAffectingLookaheadMeasure, arg3);
    }

    public final void observeReads$ui(OwnerScope arg1, Function1 arg2, Function0 arg3) {
        this.observer.observeReads(arg1, arg2, arg3);
    }

    public final void observeSemanticsReads$ui(LayoutNode arg2, Function0 arg3) {
        this.observer.observeReads(arg2, this.onCommitAffectingSemantics, arg3);
    }

    public final void startObserving$ui() {
        this.observer.start();
    }

    public final void stopObserving$ui() {
        this.observer.stop();
        this.observer.clear();
    }
}

