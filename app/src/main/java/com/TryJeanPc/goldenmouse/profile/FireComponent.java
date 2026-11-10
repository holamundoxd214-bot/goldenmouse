package com.TryJeanPc.goldenmouse.profile;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\f\u001A\u00020\u0003HÆ\u0003J\u0013\u0010\r\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\u000E\u001A\u00020\u00032\b\u0010\u000F\u001A\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001A\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001A\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001A\u00020\tX\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u0014"}, d2={"Lcom/TryJeanPc/goldenmouse/profile/FireComponent;", "Lcom/TryJeanPc/goldenmouse/profile/ControlComponent;", "continuous", "", "<init>", "(Z)V", "getContinuous", "()Z", "type", "", "getType", "()Ljava/lang/String;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class FireComponent implements ControlComponent {
    public static final int $stable;
    private final boolean continuous;
    private final String type;

    static {
    }

    public FireComponent(boolean arg1, int arg2, DefaultConstructorMarker arg3) {
        this(true);
    }

    public FireComponent() {
        this(false, 1, null);
    }

    public FireComponent(boolean arg1) {
        super();
        this.continuous = arg1;
        this.type = "DISPARO";
    }

    public final boolean component1() {
        return this.continuous;
    }

    public final FireComponent copy(boolean arg1) {
        return new FireComponent(arg1);
    }

    public static FireComponent copy$default(FireComponent arg0, boolean arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = arg0.continuous;
        }

        return arg0.copy(arg1);
    }

    public boolean equals(Object arg4) {
        if(this == (((FireComponent)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof FireComponent)) {
            return 0;
        }

        if(this.continuous != ((FireComponent)arg4).continuous) {
            return 0;
        }

        return 1;
    }

    public final boolean getContinuous() {
        return this.continuous;
    }

    public String getType() {
        return this.type;
    }

    public int hashCode() {
        return Boolean.hashCode(this.continuous);
    }

    public String toString() {
        return "FireComponent(continuous=" + this.continuous + ")";
    }
}

