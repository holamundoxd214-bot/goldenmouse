package androidx.compose.ui.semantics;

import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u000B\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000*\u000E\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004B\u001B\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001A\u0004\u0018\u00018\u0000¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u000F\u001A\u00020\u00032\b\u0010\u0010\u001A\u0004\u0018\u00010\u0004H\u0096\u0002J\b\u0010\u0011\u001A\u00020\u0012H\u0016J\b\u0010\u0013\u001A\u00020\u0006H\u0016R\u0013\u0010\u0005\u001A\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0015\u0010\u0007\u001A\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\u000E\u001A\u0004\b\f\u0010\r¨\u0006\u0014"}, d2={"Landroidx/compose/ui/semantics/AccessibilityAction;", "T", "Lkotlin/Function;", "", "", "label", "", "action", "<init>", "(Ljava/lang/String;Lkotlin/Function;)V", "getLabel", "()Ljava/lang/String;", "getAction", "()Lkotlin/Function;", "Lkotlin/Function;", "equals", "other", "hashCode", "", "toString", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AccessibilityAction {
    public static final int $stable;
    private final Function action;
    private final String label;

    static {
    }

    public AccessibilityAction(String arg1, Function arg2) {
        super();
        this.label = arg1;
        this.action = arg2;
    }

    public boolean equals(Object arg5) {
        if(this == (((AccessibilityAction)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof AccessibilityAction)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.label, ((AccessibilityAction)arg5).label)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.action, ((AccessibilityAction)arg5).action)) {
            return 0;
        }

        return 1;
    }

    public final Function getAction() {
        return this.action;
    }

    public final String getLabel() {
        return this.label;
    }

    public int hashCode() {
        String v0 = this.label;
        int v1 = 0;
        int v0_1 = v0 != null ? v0.hashCode() : 0;
        v0_1 *= 0x1F;
        Function v2 = this.action;
        if(v2 != null) {
            v1 = v2.hashCode();
        }

        return v0_1 + v1;
    }

    public String toString() {
        return "AccessibilityAction(label=" + this.label + ", action=" + this.action + ')';
    }
}

