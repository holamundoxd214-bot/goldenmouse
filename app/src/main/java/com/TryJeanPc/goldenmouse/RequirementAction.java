package com.TryJeanPc.goldenmouse;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u001D\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001A\u00020\u0003HÆ\u0003J\u000F\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000F\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\u000E\b\u0002\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001A\u00020\u00062\b\u0010\u0011\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001A\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\f¨\u0006\u0015"}, d2={"Lcom/TryJeanPc/goldenmouse/RequirementAction;", "", "label", "", "open", "Lkotlin/Function0;", "", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getLabel", "()Ljava/lang/String;", "getOpen", "()Lkotlin/jvm/functions/Function0;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class RequirementAction {
    public static final int $stable;
    private final String label;
    private final Function0 open;

    static {
    }

    public RequirementAction(String arg2, Function0 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "label");
        Intrinsics.checkNotNullParameter(arg3, "open");
        super();
        this.label = arg2;
        this.open = arg3;
    }

    public final String component1() {
        return this.label;
    }

    public final Function0 component2() {
        return this.open;
    }

    public final RequirementAction copy(String arg1, Function0 arg2) {
        Intrinsics.checkNotNullParameter(arg1, "label");
        Intrinsics.checkNotNullParameter(arg2, "open");
        return new RequirementAction(arg1, arg2);
    }

    public static RequirementAction copy$default(RequirementAction arg0, String arg1, Function0 arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = arg0.label;
        }

        if((arg3 & 2) != 0) {
            arg2 = arg0.open;
        }

        return arg0.copy(arg1, arg2);
    }

    public boolean equals(Object arg5) {
        if(this == (((RequirementAction)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof RequirementAction)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.label, ((RequirementAction)arg5).label)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.open, ((RequirementAction)arg5).open)) {
            return 0;
        }

        return 1;
    }

    public final String getLabel() {
        return this.label;
    }

    public final Function0 getOpen() {
        return this.open;
    }

    public int hashCode() {
        return this.label.hashCode() * 0x1F + this.open.hashCode();
    }

    public String toString() {
        return "RequirementAction(label=" + this.label + ", open=" + this.open + ")";
    }
}

