package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BJ\t\u0010\u0015\u001A\u00020\u0003HÆ\u0003J\u0010\u0010\u0016\u001A\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u000FJ\t\u0010\u0018\u001A\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001A\u00020\tHÆ\u0003J8\u0010\u001A\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\tHÆ\u0001¢\u0006\u0004\b\u001B\u0010\u001CJ\u0013\u0010\u001D\u001A\u00020\t2\b\u0010\u001E\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001F\u001A\u00020 HÖ\u0001J\t\u0010!\u001A\u00020\"HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\u0010\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014¨\u0006#"}, d2={"Landroidx/compose/foundation/text/selection/SelectionHandleInfo;", "", "handle", "Landroidx/compose/foundation/text/Handle;", "position", "Landroidx/compose/ui/geometry/Offset;", "anchor", "Landroidx/compose/foundation/text/selection/SelectionHandleAnchor;", "visible", "", "<init>", "(Landroidx/compose/foundation/text/Handle;JLandroidx/compose/foundation/text/selection/SelectionHandleAnchor;ZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getHandle", "()Landroidx/compose/foundation/text/Handle;", "getPosition-F1C5BW0", "()J", "J", "getAnchor", "()Landroidx/compose/foundation/text/selection/SelectionHandleAnchor;", "getVisible", "()Z", "component1", "component2", "component2-F1C5BW0", "component3", "component4", "copy", "copy-ubNVwUQ", "(Landroidx/compose/foundation/text/Handle;JLandroidx/compose/foundation/text/selection/SelectionHandleAnchor;Z)Landroidx/compose/foundation/text/selection/SelectionHandleInfo;", "equals", "other", "hashCode", "", "toString", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SelectionHandleInfo {
    public static final int $stable;
    private final SelectionHandleAnchor anchor;
    private final Handle handle;
    private final long position;
    private final boolean visible;

    static {
    }

    public SelectionHandleInfo(Handle arg1, long arg2, SelectionHandleAnchor arg4, boolean arg5, DefaultConstructorMarker arg6) {
        this(arg1, arg2, arg4, arg5);
    }

    private SelectionHandleInfo(Handle arg1, long arg2, SelectionHandleAnchor arg4, boolean arg5) {
        super();
        this.handle = arg1;
        this.position = arg2;
        this.anchor = arg4;
        this.visible = arg5;
    }

    public final Handle component1() {
        return this.handle;
    }

    public final long component2-F1C5BW0() {
        return this.position;
    }

    public final SelectionHandleAnchor component3() {
        return this.anchor;
    }

    public final boolean component4() {
        return this.visible;
    }

    public final SelectionHandleInfo copy-ubNVwUQ(Handle arg8, long arg9, SelectionHandleAnchor arg11, boolean arg12) {
        return new SelectionHandleInfo(arg8, arg9, arg11, arg12, null);
    }

    public static SelectionHandleInfo copy-ubNVwUQ$default(SelectionHandleInfo arg0, Handle arg1, long arg2, SelectionHandleAnchor arg4, boolean arg5, int arg6, Object arg7) {
        if((arg6 & 1) != 0) {
            arg1 = arg0.handle;
        }

        if((arg6 & 2) != 0) {
            arg2 = arg0.position;
        }

        if((arg6 & 4) != 0) {
            arg4 = arg0.anchor;
        }

        if((arg6 & 8) != 0) {
            arg5 = arg0.visible;
        }

        return arg0.copy-ubNVwUQ(arg1, arg2, arg4, arg5);
    }

    public boolean equals(Object arg8) {
        if(this == (((SelectionHandleInfo)arg8))) {
            return 1;
        }

        if(!(arg8 instanceof SelectionHandleInfo)) {
            return 0;
        }

        if(this.handle != ((SelectionHandleInfo)arg8).handle) {
            return 0;
        }

        if(!Offset.equals-impl0(this.position, ((SelectionHandleInfo)arg8).position)) {
            return 0;
        }

        if(this.anchor != ((SelectionHandleInfo)arg8).anchor) {
            return 0;
        }

        if(this.visible != ((SelectionHandleInfo)arg8).visible) {
            return 0;
        }

        return 1;
    }

    public final SelectionHandleAnchor getAnchor() {
        return this.anchor;
    }

    public final Handle getHandle() {
        return this.handle;
    }

    public final long getPosition-F1C5BW0() {
        return this.position;
    }

    public final boolean getVisible() {
        return this.visible;
    }

    public int hashCode() {
        return ((this.handle.hashCode() * 0x1F + Offset.hashCode-impl(this.position)) * 0x1F + this.anchor.hashCode()) * 0x1F + Boolean.hashCode(this.visible);
    }

    public String toString() {
        return "SelectionHandleInfo(handle=" + this.handle + ", position=" + Offset.toString-impl(this.position) + ", anchor=" + this.anchor + ", visible=" + this.visible + ')';
    }
}

