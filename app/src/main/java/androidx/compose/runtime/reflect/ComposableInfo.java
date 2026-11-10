package androidx.compose.runtime.reflect;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000E\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\u0007\u001A\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000F\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001A\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001A\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001A\u00020\u0005HÆ\u0003J1\u0010\u0013\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\u0005HÆ\u0001J\u0014\u0010\u0014\u001A\u00020\u00032\b\u0010\u0015\u001A\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001A\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0017\u001A\u00020\u0018HÖ\u0081\u0004R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0002\u0010\nR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0006\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\fR\u0011\u0010\u0007\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\f¨\u0006\u0019"}, d2={"Landroidx/compose/runtime/reflect/ComposableInfo;", "", "isComposable", "", "realParamsCount", "", "changedParams", "defaultParams", "<init>", "(ZIII)V", "()Z", "getRealParamsCount", "()I", "getChangedParams", "getDefaultParams", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ComposableInfo {
    public static final int $stable;
    private final int changedParams;
    private final int defaultParams;
    private final boolean isComposable;
    private final int realParamsCount;

    static {
    }

    public ComposableInfo(boolean arg1, int arg2, int arg3, int arg4) {
        super();
        this.isComposable = arg1;
        this.realParamsCount = arg2;
        this.changedParams = arg3;
        this.defaultParams = arg4;
    }

    public final boolean component1() {
        return this.isComposable;
    }

    public final int component2() {
        return this.realParamsCount;
    }

    public final int component3() {
        return this.changedParams;
    }

    public final int component4() {
        return this.defaultParams;
    }

    public final ComposableInfo copy(boolean arg1, int arg2, int arg3, int arg4) {
        return new ComposableInfo(arg1, arg2, arg3, arg4);
    }

    public static ComposableInfo copy$default(ComposableInfo arg0, boolean arg1, int arg2, int arg3, int arg4, int arg5, Object arg6) {
        if((arg5 & 1) != 0) {
            arg1 = arg0.isComposable;
        }

        if((arg5 & 2) != 0) {
            arg2 = arg0.realParamsCount;
        }

        if((arg5 & 4) != 0) {
            arg3 = arg0.changedParams;
        }

        if((arg5 & 8) != 0) {
            arg4 = arg0.defaultParams;
        }

        return arg0.copy(arg1, arg2, arg3, arg4);
    }

    public boolean equals(Object arg5) {
        if(this == (((ComposableInfo)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof ComposableInfo)) {
            return 0;
        }

        if(this.isComposable != ((ComposableInfo)arg5).isComposable) {
            return 0;
        }

        if(this.realParamsCount != ((ComposableInfo)arg5).realParamsCount) {
            return 0;
        }

        if(this.changedParams != ((ComposableInfo)arg5).changedParams) {
            return 0;
        }

        if(this.defaultParams != ((ComposableInfo)arg5).defaultParams) {
            return 0;
        }

        return 1;
    }

    public final int getChangedParams() {
        return this.changedParams;
    }

    public final int getDefaultParams() {
        return this.defaultParams;
    }

    public final int getRealParamsCount() {
        return this.realParamsCount;
    }

    public int hashCode() {
        return ((Boolean.hashCode(this.isComposable) * 0x1F + Integer.hashCode(this.realParamsCount)) * 0x1F + Integer.hashCode(this.changedParams)) * 0x1F + Integer.hashCode(this.defaultParams);
    }

    public final boolean isComposable() {
        return this.isComposable;
    }

    public String toString() {
        return "ComposableInfo(isComposable=" + this.isComposable + ", realParamsCount=" + this.realParamsCount + ", changedParams=" + this.changedParams + ", defaultParams=" + this.defaultParams + ')';
    }
}

