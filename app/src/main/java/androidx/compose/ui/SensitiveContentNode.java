package androidx.compose.ui;

import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000B\u001A\u00020\fH\u0016J\b\u0010\r\u001A\u00020\fH\u0016J\t\u0010\u000E\u001A\u00020\u0003HÂ\u0003J\u0013\u0010\u000F\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001A\u00020\u00032\b\u0010\u0011\u001A\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001A\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001A\u00020\u0016HÖ\u0001R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0003X\u0082\u000E¢\u0006\u0002\n\u0000R$\u0010\b\u001A\u00020\u00032\u0006\u0010\u0007\u001A\u00020\u0003@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0005¨\u0006\u0017"}, d2={"Landroidx/compose/ui/SensitiveContentNode;", "Landroidx/compose/ui/Modifier$Node;", "_isContentSensitive", "", "<init>", "(Z)V", "isCountedSensitive", "value", "isContentSensitive", "()Z", "setContentSensitive", "onAttach", "", "onDetach", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class SensitiveContentNode extends Node {
    private boolean _isContentSensitive;
    private boolean isContentSensitive;
    private boolean isCountedSensitive;

    public SensitiveContentNode(boolean arg1) {
        super();
        this._isContentSensitive = arg1;
        this.isContentSensitive = arg1;
    }

    private final boolean component1() {
        return this._isContentSensitive;
    }

    public final SensitiveContentNode copy(boolean arg1) {
        return new SensitiveContentNode(arg1);
    }

    public static SensitiveContentNode copy$default(SensitiveContentNode arg0, boolean arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = arg0._isContentSensitive;
        }

        return arg0.copy(arg1);
    }

    public boolean equals(Object arg4) {
        if(this == (((SensitiveContentNode)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof SensitiveContentNode)) {
            return 0;
        }

        if(this._isContentSensitive != ((SensitiveContentNode)arg4)._isContentSensitive) {
            return 0;
        }

        return 1;
    }

    public int hashCode() {
        return Boolean.hashCode(this._isContentSensitive);
    }

    public final boolean isContentSensitive() {
        return this.isContentSensitive;
    }

    public void onAttach() {
        super.onAttach();
        if(this.isContentSensitive) {
            if(this.isCountedSensitive) {
                InlineClassHelperKt.throwIllegalStateException("invalid sensitive content state");
            }

            DelegatableNodeKt.requireOwner(this).incrementSensitiveComponentCount();
            this.isCountedSensitive = true;
        }
    }

    public void onDetach() {
        if(this.isCountedSensitive) {
            DelegatableNodeKt.requireOwner(this).decrementSensitiveComponentCount();
            this.isCountedSensitive = false;
        }

        super.onDetach();
    }

    public final void setContentSensitive(boolean arg2) {
        this.isContentSensitive = arg2;
        if((arg2) && !this.isCountedSensitive) {
            DelegatableNodeKt.requireOwner(this).incrementSensitiveComponentCount();
            this.isCountedSensitive = true;
            return;
        }

        if(!arg2 && (this.isCountedSensitive)) {
            DelegatableNodeKt.requireOwner(this).decrementSensitiveComponentCount();
            this.isCountedSensitive = false;
        }
    }

    public String toString() {
        return "SensitiveContentNode(_isContentSensitive=" + this._isContentSensitive + ')';
    }
}

