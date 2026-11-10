package androidx.compose.runtime;

import androidx.collection.ObjectList;
import androidx.collection.ScatterMap;
import androidx.compose.runtime.composer.RememberManager;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u001C\n\u0000\b!\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\nH&J\b\u0010\u000B\u001A\u00020\bH&J\b\u0010\f\u001A\u00020\bH&J\u0010\u0010\r\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\nH&J\b\u0010\u000E\u001A\u00020\bH&J.\u0010\u000F\u001A\u000E\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00102\n\u0010\u0013\u001A\u0006\u0012\u0002\b\u00030\u00142\f\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u00110\u0016H&J\u0018\u0010\u0017\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u0018\u001A\u00020\u0012H&J\b\u0010\u0019\u001A\u00020\bH&J\u0018\u0010\u001A\u001A\n\u0012\u0004\u0012\u00020\u001C\u0018\u00010\u001B2\u0006\u0010\u001D\u001A\u00020\u001EH&J\u0010\u0010\u001F\u001A\u00020\u00052\u0006\u0010 \u001A\u00020\u001CH&J\u0018\u0010!\u001A\u00020\u00052\u0006\u0010\"\u001A\u00020\u001E2\u0006\u0010#\u001A\u00020$H&J\u0018\u0010%\u001A\u00020\u00052\u0006\u0010&\u001A\u00020$2\u0006\u0010\'\u001A\u00020$H&J\b\u0010(\u001A\u00020)H&J\b\u0010*\u001A\u00020\bH\'J\u0010\u0010+\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010,H\'R\u0012\u0010\u0004\u001A\u00020\u0005X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0006¨\u0006-"}, d2={"Landroidx/compose/runtime/SlotStorage;", "", "<init>", "()V", "isEmpty", "", "()Z", "clear", "", "rememberManager", "Landroidx/compose/runtime/composer/RememberManager;", "collectCalledByInformation", "collectSourceInformation", "deactivateAll", "dispose", "extractNestedStates", "Landroidx/collection/ScatterMap;", "Landroidx/compose/runtime/MovableContentStateReference;", "Landroidx/compose/runtime/MovableContentState;", "applier", "Landroidx/compose/runtime/Applier;", "references", "Landroidx/collection/ObjectList;", "disposeUnusedMovableContent", "state", "invalidateAll", "invalidateGroupsWithKey", "", "Landroidx/compose/runtime/RecomposeScopeImpl;", "target", "", "ownsRecomposeScope", "scope", "groupContainsAnchor", "group", "anchor", "Landroidx/compose/runtime/Anchor;", "inGroup", "parent", "child", "toDebugString", "", "verifyWellFormed", "getSlots", "", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public abstract class SlotStorage {
    public static final int $stable;

    static {
    }

    public SlotStorage() {
        super();
    }

    public abstract void clear(RememberManager arg1);

    public abstract void collectCalledByInformation();

    public abstract void collectSourceInformation();

    public abstract void deactivateAll(RememberManager arg1);

    public abstract void dispose();

    public abstract void disposeUnusedMovableContent(RememberManager arg1, MovableContentState arg2);

    public abstract ScatterMap extractNestedStates(Applier arg1, ObjectList arg2);

    public abstract Iterable getSlots();

    public abstract boolean groupContainsAnchor(int arg1, Anchor arg2);

    public abstract boolean inGroup(Anchor arg1, Anchor arg2);

    public abstract void invalidateAll();

    public abstract List invalidateGroupsWithKey(int arg1);

    public abstract boolean isEmpty();

    public abstract boolean ownsRecomposeScope(RecomposeScopeImpl arg1);

    public abstract String toDebugString();

    public abstract void verifyWellFormed();
}

