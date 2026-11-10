package com.TryJeanPc.goldenmouse.graphicsui;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u000E\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000E\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000F\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001A\u00020\u0006HÆ\u0003J\'\u0010\u0011\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001A\u00020\u00032\b\u0010\u0013\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001A\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001A\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\nR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\r¨\u0006\u0017"}, d2={"Lcom/TryJeanPc/goldenmouse/graphicsui/GraphicsButtonState;", "", "apply", "", "restore", "explanation", "", "<init>", "(ZZLjava/lang/String;)V", "getApply", "()Z", "getRestore", "getExplanation", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GraphicsButtonState {
    public static final int $stable;
    private final boolean apply;
    private final String explanation;
    private final boolean restore;

    static {
    }

    public GraphicsButtonState(boolean arg2, boolean arg3, String arg4) {
        Intrinsics.checkNotNullParameter(arg4, "explanation");
        super();
        this.apply = arg2;
        this.restore = arg3;
        this.explanation = arg4;
    }

    public final boolean component1() {
        return this.apply;
    }

    public final boolean component2() {
        return this.restore;
    }

    public final String component3() {
        return this.explanation;
    }

    public final GraphicsButtonState copy(boolean arg1, boolean arg2, String arg3) {
        Intrinsics.checkNotNullParameter(arg3, "explanation");
        return new GraphicsButtonState(arg1, arg2, arg3);
    }

    public static GraphicsButtonState copy$default(GraphicsButtonState arg0, boolean arg1, boolean arg2, String arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = arg0.apply;
        }

        if((arg4 & 2) != 0) {
            arg2 = arg0.restore;
        }

        if((arg4 & 4) != 0) {
            arg3 = arg0.explanation;
        }

        return arg0.copy(arg1, arg2, arg3);
    }

    public boolean equals(Object arg5) {
        if(this == (((GraphicsButtonState)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof GraphicsButtonState)) {
            return 0;
        }

        if(this.apply != ((GraphicsButtonState)arg5).apply) {
            return 0;
        }

        if(this.restore != ((GraphicsButtonState)arg5).restore) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.explanation, ((GraphicsButtonState)arg5).explanation)) {
            return 0;
        }

        return 1;
    }

    public final boolean getApply() {
        return this.apply;
    }

    public final String getExplanation() {
        return this.explanation;
    }

    public final boolean getRestore() {
        return this.restore;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.apply) * 0x1F + Boolean.hashCode(this.restore)) * 0x1F + this.explanation.hashCode();
    }

    public String toString() {
        return "GraphicsButtonState(apply=" + this.apply + ", restore=" + this.restore + ", explanation=" + this.explanation + ")";
    }
}

