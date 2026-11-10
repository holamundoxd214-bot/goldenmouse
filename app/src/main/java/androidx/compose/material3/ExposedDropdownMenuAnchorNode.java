package androidx.compose.material3;

import androidx.compose.ui.Modifier$Node;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\n\u001A\u00020\u0004H\u0016R \u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u000B"}, d2={"Landroidx/compose/material3/ExposedDropdownMenuAnchorNode;", "Landroidx/compose/ui/Modifier$Node;", "updateStateOnAttach", "Lkotlin/Function0;", "", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "getUpdateStateOnAttach", "()Lkotlin/jvm/functions/Function0;", "setUpdateStateOnAttach", "onAttach", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class ExposedDropdownMenuAnchorNode extends Node {
    private Function0 updateStateOnAttach;

    public ExposedDropdownMenuAnchorNode(Function0 arg1) {
        super();
        this.updateStateOnAttach = arg1;
    }

    public final Function0 getUpdateStateOnAttach() {
        return this.updateStateOnAttach;
    }

    public void onAttach() {
        this.updateStateOnAttach.invoke();
    }

    public final void setUpdateStateOnAttach(Function0 arg1) {
        this.updateStateOnAttach = arg1;
    }
}

