package com.TryJeanPc.goldenmouse.recoil;

import kotlin.Metadata;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000B\u001A\u00020\u0003HÆ\u0003J\u001D\u0010\f\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001A\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001A\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\b¨\u0006\u0013"}, d2={"Lcom/TryJeanPc/goldenmouse/recoil/RecoilDelta;", "", "horizontal", "", "vertical", "<init>", "(II)V", "getHorizontal", "()I", "getVertical", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class RecoilDelta {
    public static final int $stable;
    private final int horizontal;
    private final int vertical;

    static {
    }

    public RecoilDelta(int arg1, int arg2) {
        super();
        this.horizontal = arg1;
        this.vertical = arg2;
    }

    public final int component1() {
        return this.horizontal;
    }

    public final int component2() {
        return this.vertical;
    }

    public final RecoilDelta copy(int arg1, int arg2) {
        return new RecoilDelta(arg1, arg2);
    }

    public static RecoilDelta copy$default(RecoilDelta arg0, int arg1, int arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = arg0.horizontal;
        }

        if((arg3 & 2) != 0) {
            arg2 = arg0.vertical;
        }

        return arg0.copy(arg1, arg2);
    }

    public boolean equals(Object arg5) {
        if(this == (((RecoilDelta)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof RecoilDelta)) {
            return 0;
        }

        if(this.horizontal != ((RecoilDelta)arg5).horizontal) {
            return 0;
        }

        if(this.vertical != ((RecoilDelta)arg5).vertical) {
            return 0;
        }

        return 1;
    }

    public final int getHorizontal() {
        return this.horizontal;
    }

    public final int getVertical() {
        return this.vertical;
    }

    public int hashCode() {
        return Integer.hashCode(this.horizontal) * 0x1F + Integer.hashCode(this.vertical);
    }

    public String toString() {
        return "RecoilDelta(horizontal=" + this.horizontal + ", vertical=" + this.vertical + ")";
    }
}

