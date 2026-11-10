package com.TryJeanPc.goldenmouse.controls;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B)\u0012\u0006\u0010\u0003\u001A\u00028\u0000\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000E\u0010\u0013\u001A\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0014\u001A\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001A\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001A\u00020\bHÆ\u0003J<\u0010\u0017\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001A\u00028\u00002\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\bHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001A\u00020\b2\b\u0010\u001A\u001A\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001B\u001A\u00020\u001CHÖ\u0001J\t\u0010\u001D\u001A\u00020\u001EHÖ\u0001R\u0013\u0010\u0003\u001A\u00028\u0000¢\u0006\n\n\u0002\u0010\r\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0006\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u000FR\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012¨\u0006\u001F"}, d2={"Lcom/TryJeanPc/goldenmouse/controls/EditorHitCandidate;", "T", "", "target", "distance", "", "tolerance", "visible", "", "<init>", "(Ljava/lang/Object;FFZ)V", "getTarget", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getDistance", "()F", "getTolerance", "getVisible", "()Z", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Object;FFZ)Lcom/TryJeanPc/goldenmouse/controls/EditorHitCandidate;", "equals", "other", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class EditorHitCandidate {
    public static final int $stable;
    private final float distance;
    private final Object target;
    private final float tolerance;
    private final boolean visible;

    static {
    }

    public EditorHitCandidate(Object arg1, float arg2, float arg3, boolean arg4) {
        super();
        this.target = arg1;
        this.distance = arg2;
        this.tolerance = arg3;
        this.visible = arg4;
    }

    public EditorHitCandidate(Object arg1, float arg2, float arg3, boolean arg4, int arg5, DefaultConstructorMarker arg6) {
        this(arg1, arg2, arg3, true);
    }

    public final Object component1() {
        return this.target;
    }

    public final float component2() {
        return this.distance;
    }

    public final float component3() {
        return this.tolerance;
    }

    public final boolean component4() {
        return this.visible;
    }

    public final EditorHitCandidate copy(Object arg1, float arg2, float arg3, boolean arg4) {
        return new EditorHitCandidate(arg1, arg2, arg3, arg4);
    }

    public static EditorHitCandidate copy$default(EditorHitCandidate arg0, Object arg1, float arg2, float arg3, boolean arg4, int arg5, Object arg6) {
        if((arg5 & 1) != 0) {
            arg1 = arg0.target;
        }

        if((arg5 & 2) != 0) {
            arg2 = arg0.distance;
        }

        if((arg5 & 4) != 0) {
            arg3 = arg0.tolerance;
        }

        if((arg5 & 8) != 0) {
            arg4 = arg0.visible;
        }

        return arg0.copy(arg1, arg2, arg3, arg4);
    }

    public boolean equals(Object arg5) {
        if(this == (((EditorHitCandidate)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof EditorHitCandidate)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.target, ((EditorHitCandidate)arg5).target)) {
            return 0;
        }

        if(Float.compare(this.distance, ((EditorHitCandidate)arg5).distance) != 0) {
            return 0;
        }

        if(Float.compare(this.tolerance, ((EditorHitCandidate)arg5).tolerance) != 0) {
            return 0;
        }

        if(this.visible != ((EditorHitCandidate)arg5).visible) {
            return 0;
        }

        return 1;
    }

    public final float getDistance() {
        return this.distance;
    }

    public final Object getTarget() {
        return this.target;
    }

    public final float getTolerance() {
        return this.tolerance;
    }

    public final boolean getVisible() {
        return this.visible;
    }

    public int hashCode() {
        Object v0 = this.target;
        int v0_1 = v0 == null ? 0 : v0.hashCode();
        return ((v0_1 * 0x1F + Float.hashCode(this.distance)) * 0x1F + Float.hashCode(this.tolerance)) * 0x1F + Boolean.hashCode(this.visible);
    }

    public String toString() {
        return "EditorHitCandidate(target=" + this.target + ", distance=" + this.distance + ", tolerance=" + this.tolerance + ", visible=" + this.visible + ")";
    }
}

