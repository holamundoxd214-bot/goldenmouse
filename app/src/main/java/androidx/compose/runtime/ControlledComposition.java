package androidx.compose.runtime;

import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J \u0010\u0007\u001A\u00020\b2\u0011\u0010\t\u001A\r\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0002\b\u000BH&¢\u0006\u0002\u0010\fJ\u0016\u0010\r\u001A\u00020\b2\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00100\u000FH&J\u0016\u0010\u0011\u001A\u00020\u00032\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00100\u000FH&J\u0016\u0010\u0012\u001A\u00020\b2\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\b0\nH&J\u0010\u0010\u0014\u001A\u00020\b2\u0006\u0010\u0015\u001A\u00020\u0010H&J\u0010\u0010\u0016\u001A\u00020\b2\u0006\u0010\u0015\u001A\u00020\u0010H&J\b\u0010\u0017\u001A\u00020\u0003H&J$\u0010\u0018\u001A\u00020\b2\u001A\u0010\u0019\u001A\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u001C\u0012\u0006\u0012\u0004\u0018\u00010\u001C0\u001B0\u001AH\'J\u0010\u0010\u001D\u001A\u00020\b2\u0006\u0010\u001E\u001A\u00020\u001FH\'J\b\u0010 \u001A\u00020\bH&J\b\u0010!\u001A\u00020\bH&J\b\u0010\"\u001A\u00020\bH&J\b\u0010#\u001A\u00020\bH&J\b\u0010$\u001A\u00020\bH&J\b\u0010%\u001A\u00020\bH\'J3\u0010&\u001A\u0002H\'\"\u0004\b\u0000\u0010\'2\b\u0010(\u001A\u0004\u0018\u00010\u00002\u0006\u0010)\u001A\u00020*2\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u0002H\'0\nH&¢\u0006\u0002\u0010+J\u0014\u0010,\u001A\u0004\u0018\u00010-2\b\u0010.\u001A\u0004\u0018\u00010-H&R\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0002\u0010\u0004R\u0012\u0010\u0005\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0004\u0082\u0001\u0001/ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u00060À\u0006\u0001"}, d2={"Landroidx/compose/runtime/ControlledComposition;", "Landroidx/compose/runtime/Composition;", "isComposing", "", "()Z", "hasPendingChanges", "getHasPendingChanges", "composeContent", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;)V", "recordModificationsOf", "values", "", "", "observesAnyOf", "prepareCompose", "block", "recordReadOf", "value", "recordWriteOf", "recompose", "insertMovableContent", "references", "", "Lkotlin/Pair;", "Landroidx/compose/runtime/MovableContentStateReference;", "disposeUnusedMovableContent", "state", "Landroidx/compose/runtime/MovableContentState;", "applyChanges", "applyLateChanges", "changesApplied", "abandonChanges", "invalidateAll", "verifyConsistent", "delegateInvalidations", "R", "to", "groupIndex", "", "(Landroidx/compose/runtime/ControlledComposition;ILkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getAndSetShouldPauseCallback", "Landroidx/compose/runtime/ShouldPauseCallback;", "shouldPause", "Landroidx/compose/runtime/CompositionImpl;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public interface ControlledComposition extends Composition {
    void abandonChanges();

    void applyChanges();

    void applyLateChanges();

    void changesApplied();

    void composeContent(Function2 arg1);

    Object delegateInvalidations(ControlledComposition arg1, int arg2, Function0 arg3);

    void disposeUnusedMovableContent(MovableContentState arg1);

    ShouldPauseCallback getAndSetShouldPauseCallback(ShouldPauseCallback arg1);

    boolean getHasPendingChanges();

    void insertMovableContent(List arg1);

    void invalidateAll();

    boolean isComposing();

    boolean observesAnyOf(Set arg1);

    void prepareCompose(Function0 arg1);

    boolean recompose();

    void recordModificationsOf(Set arg1);

    void recordReadOf(Object arg1);

    void recordWriteOf(Object arg1);

    void verifyConsistent();
}

