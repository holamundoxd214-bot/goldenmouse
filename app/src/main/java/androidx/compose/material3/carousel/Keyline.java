package androidx.compose.material3.carousel;

import kotlin.Metadata;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\u0007\u0012\u0006\u0010\t\u001A\u00020\u0007\u0012\u0006\u0010\n\u001A\u00020\u0003¢\u0006\u0004\b\u000B\u0010\fJ\t\u0010\u0013\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001A\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001A\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001A\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001A\u00020\u0003HÆ\u0003JO\u0010\u001A\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u00072\b\b\u0002\u0010\t\u001A\u00020\u00072\b\b\u0002\u0010\n\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\u001B\u001A\u00020\u00072\b\u0010\u001C\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001D\u001A\u00020\u001EHÖ\u0001J\t\u0010\u001F\u001A\u00020 HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u000ER\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u000ER\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0011R\u0011\u0010\b\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\u0011R\u0011\u0010\t\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\u0011R\u0011\u0010\n\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u000E¨\u0006!"}, d2={"Landroidx/compose/material3/carousel/Keyline;", "", "size", "", "offset", "unadjustedOffset", "isFocal", "", "isAnchor", "isPivot", "cutoff", "<init>", "(FFFZZZF)V", "getSize", "()F", "getOffset", "getUnadjustedOffset", "()Z", "getCutoff", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Keyline {
    public static final int $stable;
    private final float cutoff;
    private final boolean isAnchor;
    private final boolean isFocal;
    private final boolean isPivot;
    private final float offset;
    private final float size;
    private final float unadjustedOffset;

    static {
    }

    public Keyline(float arg1, float arg2, float arg3, boolean arg4, boolean arg5, boolean arg6, float arg7) {
        super();
        this.size = arg1;
        this.offset = arg2;
        this.unadjustedOffset = arg3;
        this.isFocal = arg4;
        this.isAnchor = arg5;
        this.isPivot = arg6;
        this.cutoff = arg7;
    }

    public final float component1() {
        return this.size;
    }

    public final float component2() {
        return this.offset;
    }

    public final float component3() {
        return this.unadjustedOffset;
    }

    public final boolean component4() {
        return this.isFocal;
    }

    public final boolean component5() {
        return this.isAnchor;
    }

    public final boolean component6() {
        return this.isPivot;
    }

    public final float component7() {
        return this.cutoff;
    }

    public final Keyline copy(float arg1, float arg2, float arg3, boolean arg4, boolean arg5, boolean arg6, float arg7) {
        return new Keyline(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public static Keyline copy$default(Keyline arg0, float arg1, float arg2, float arg3, boolean arg4, boolean arg5, boolean arg6, float arg7, int arg8, Object arg9) {
        if((arg8 & 1) != 0) {
            arg1 = arg0.size;
        }

        if((arg8 & 2) != 0) {
            arg2 = arg0.offset;
        }

        if((arg8 & 4) != 0) {
            arg3 = arg0.unadjustedOffset;
        }

        if((arg8 & 8) != 0) {
            arg4 = arg0.isFocal;
        }

        if((arg8 & 16) != 0) {
            arg5 = arg0.isAnchor;
        }

        if((arg8 & 0x20) != 0) {
            arg6 = arg0.isPivot;
        }

        if((arg8 & 0x40) != 0) {
            arg7 = arg0.cutoff;
        }

        return arg0.copy(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public boolean equals(Object arg5) {
        if(this == (((Keyline)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof Keyline)) {
            return 0;
        }

        if(Float.compare(this.size, ((Keyline)arg5).size) != 0) {
            return 0;
        }

        if(Float.compare(this.offset, ((Keyline)arg5).offset) != 0) {
            return 0;
        }

        if(Float.compare(this.unadjustedOffset, ((Keyline)arg5).unadjustedOffset) != 0) {
            return 0;
        }

        if(this.isFocal != ((Keyline)arg5).isFocal) {
            return 0;
        }

        if(this.isAnchor != ((Keyline)arg5).isAnchor) {
            return 0;
        }

        if(this.isPivot != ((Keyline)arg5).isPivot) {
            return 0;
        }

        if(Float.compare(this.cutoff, ((Keyline)arg5).cutoff) != 0) {
            return 0;
        }

        return 1;
    }

    public final float getCutoff() {
        return this.cutoff;
    }

    public final float getOffset() {
        return this.offset;
    }

    public final float getSize() {
        return this.size;
    }

    public final float getUnadjustedOffset() {
        return this.unadjustedOffset;
    }

    public int hashCode() {
        return (((((Float.hashCode(this.size) * 0x1F + Float.hashCode(this.offset)) * 0x1F + Float.hashCode(this.unadjustedOffset)) * 0x1F + Boolean.hashCode(this.isFocal)) * 0x1F + Boolean.hashCode(this.isAnchor)) * 0x1F + Boolean.hashCode(this.isPivot)) * 0x1F + Float.hashCode(this.cutoff);
    }

    public final boolean isAnchor() {
        return this.isAnchor;
    }

    public final boolean isFocal() {
        return this.isFocal;
    }

    public final boolean isPivot() {
        return this.isPivot;
    }

    public String toString() {
        return "Keyline(size=" + this.size + ", offset=" + this.offset + ", unadjustedOffset=" + this.unadjustedOffset + ", isFocal=" + this.isFocal + ", isAnchor=" + this.isAnchor + ", isPivot=" + this.isPivot + ", cutoff=" + this.cutoff + ')';
    }
}

