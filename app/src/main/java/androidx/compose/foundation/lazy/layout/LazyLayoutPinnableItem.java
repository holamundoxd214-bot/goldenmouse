package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.Snapshot$Companion;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.layout.PinnableContainer$PinnedHandle;
import androidx.compose.ui.layout.PinnableContainer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u000E\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0019\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\"\u001A\u00020\u0002H\u0016J\b\u0010#\u001A\u00020$H\u0016J\u0006\u0010%\u001A\u00020$R\u0016\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\f\u001A\u00020\rX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u000F\"\u0004\b\u0010\u0010\u0011R\u000E\u0010\u0012\u001A\u00020\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001A\u0004\u0018\u00010\u0002X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\u0015X\u0082\u000E¢\u0006\u0002\n\u0000R/\u0010\u0017\u001A\u0004\u0018\u00010\u00012\b\u0010\u0016\u001A\u0004\u0018\u00010\u00018B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\b\u001C\u0010\u001D\u001A\u0004\b\u0018\u0010\u0019\"\u0004\b\u001A\u0010\u001BR(\u0010\u001F\u001A\u0004\u0018\u00010\u00012\b\u0010\u001E\u001A\u0004\u0018\u00010\u00018F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001B¨\u0006&"}, d2={"Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnableItem;", "Landroidx/compose/ui/layout/PinnableContainer;", "Landroidx/compose/ui/layout/PinnableContainer$PinnedHandle;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList$PinnedItem;", "key", "", "pinnedItemList", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "<init>", "(Ljava/lang/Object;Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;)V", "getKey", "()Ljava/lang/Object;", "index", "", "getIndex", "()I", "setIndex", "(I)V", "pinsCount", "parentHandle", "isDisposed", "", "<set-?>", "_parentPinnableContainer", "get_parentPinnableContainer", "()Landroidx/compose/ui/layout/PinnableContainer;", "set_parentPinnableContainer", "(Landroidx/compose/ui/layout/PinnableContainer;)V", "_parentPinnableContainer$delegate", "Landroidx/compose/runtime/MutableState;", "value", "parentPinnableContainer", "getParentPinnableContainer", "setParentPinnableContainer", "pin", "release", "", "onDisposed", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class LazyLayoutPinnableItem implements PinnedItem, PinnedHandle, PinnableContainer {
    private final MutableState _parentPinnableContainer$delegate;
    private int index;
    private boolean isDisposed;
    private final Object key;
    private PinnedHandle parentHandle;
    private final LazyLayoutPinnedItemList pinnedItemList;
    private int pinsCount;

    public LazyLayoutPinnableItem(Object arg1, LazyLayoutPinnedItemList arg2) {
        super();
        this.key = arg1;
        this.pinnedItemList = arg2;
        this.index = -1;
        this._parentPinnableContainer$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
    }

    public int getIndex() {
        return this.index;
    }

    public Object getKey() {
        return this.key;
    }

    public final PinnableContainer getParentPinnableContainer() {
        return this.get_parentPinnableContainer();
    }

    private final PinnableContainer get_parentPinnableContainer() {
        return this._parentPinnableContainer$delegate.getValue();
    }

    public final void onDisposed() {
        this.isDisposed = true;
    }

    public PinnedHandle pin() {
        if(this.isDisposed) {
            InlineClassHelperKt.throwIllegalStateException("Pin should not be called on an already disposed item ");
        }

        if(this.pinsCount == 0) {
            this.pinnedItemList.pin$foundation(this);
            PinnableContainer v0 = this.getParentPinnableContainer();
            PinnedHandle v0_1 = v0 != null ? v0.pin() : null;
            this.parentHandle = v0_1;
        }

        ++this.pinsCount;
        return this;
    }

    public void release() {
        if(this.isDisposed) {
        }
        else {
            int v0 = this.pinsCount > 0 ? 1 : 0;
            if(v0 == 0) {
                InlineClassHelperKt.throwIllegalStateException("Release should only be called once");
            }

            v0 = this.pinsCount - 1;
            this.pinsCount = v0;
            if(v0 != 0) {
                return;
            }

            this.pinnedItemList.release$foundation(this);
            PinnedHandle v0_1 = this.parentHandle;
            if(v0_1 != null) {
                v0_1.release();
            }

            this.parentHandle = null;
        }
    }

    public void setIndex(int arg1) {
        this.index = arg1;
    }

    public final void setParentPinnableContainer(PinnableContainer arg7) {
        Companion v0 = Snapshot.Companion;
        Snapshot v1 = v0.getCurrentThreadSnapshot();
        PinnedHandle v2 = null;
        Function1 v3 = v1 != null ? v1.getReadObserver() : ((Function1)v2);
        Snapshot v4 = v0.makeCurrentNonObservable(v1);
        try {
            if(arg7 != this.get_parentPinnableContainer()) {
                this.set_parentPinnableContainer(arg7);
                if(this.pinsCount > 0) {
                    PinnedHandle v5 = this.parentHandle;
                    if(v5 != null) {
                        v5.release();
                    }

                    if(arg7 != null) {
                        v2 = arg7.pin();
                    }

                    this.parentHandle = v2;
                }
            }
        }
        catch(Throwable v6) {
            v0.restoreNonObservable(v1, v4, v3);
            throw v6;
        }

        v0.restoreNonObservable(v1, v4, v3);
    }

    private final void set_parentPinnableContainer(PinnableContainer arg1) {
        this._parentPinnableContainer$delegate.setValue(arg1);
    }
}

