package androidx.compose.ui.semantics;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001D\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\r\u001A\u00020\u00062\b\u0010\u000E\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000F\u001A\u00020\u0010H\u0016J\b\u0010\u0011\u001A\u00020\u0003H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\f¨\u0006\u0012"}, d2={"Landroidx/compose/ui/semantics/CustomAccessibilityAction;", "", "label", "", "action", "Lkotlin/Function0;", "", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getLabel", "()Ljava/lang/String;", "getAction", "()Lkotlin/jvm/functions/Function0;", "equals", "other", "hashCode", "", "toString", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class CustomAccessibilityAction {
    public static final int $stable;
    private final Function0 action;
    private final String label;

    static {
    }

    public CustomAccessibilityAction(String arg1, Function0 arg2) {
        super();
        this.label = arg1;
        this.action = arg2;
    }

    public boolean equals(Object arg5) {
        if(this == (((CustomAccessibilityAction)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof CustomAccessibilityAction)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.label, ((CustomAccessibilityAction)arg5).label)) {
            return 0;
        }

        if(this.action != ((CustomAccessibilityAction)arg5).action) {
            return 0;
        }

        return 1;
    }

    public final Function0 getAction() {
        return this.action;
    }

    public final String getLabel() {
        return this.label;
    }

    public int hashCode() {
        return this.label.hashCode() * 0x1F + this.action.hashCode();
    }

    public String toString() {
        return "CustomAccessibilityAction(label=" + this.label + ", action=" + this.action + ')';
    }
}

