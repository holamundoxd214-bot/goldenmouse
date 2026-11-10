package androidx.compose.ui.text;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000E\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000F\u001A\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001A\u00020\u0005HÆ\u0003J\'\u0010\u0011\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001A\u00020\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001A\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001A\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0006\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\f¨\u0006\u0018"}, d2={"Landroidx/compose/ui/text/ParagraphIntrinsicInfo;", "", "intrinsics", "Landroidx/compose/ui/text/ParagraphIntrinsics;", "startIndex", "", "endIndex", "<init>", "(Landroidx/compose/ui/text/ParagraphIntrinsics;II)V", "getIntrinsics", "()Landroidx/compose/ui/text/ParagraphIntrinsics;", "getStartIndex", "()I", "getEndIndex", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ParagraphIntrinsicInfo {
    public static final int $stable = 8;
    private final int endIndex;
    private final ParagraphIntrinsics intrinsics;
    private final int startIndex;

    static {
    }

    public ParagraphIntrinsicInfo(ParagraphIntrinsics arg1, int arg2, int arg3) {
        super();
        this.intrinsics = arg1;
        this.startIndex = arg2;
        this.endIndex = arg3;
    }

    public final ParagraphIntrinsics component1() {
        return this.intrinsics;
    }

    public final int component2() {
        return this.startIndex;
    }

    public final int component3() {
        return this.endIndex;
    }

    public final ParagraphIntrinsicInfo copy(ParagraphIntrinsics arg1, int arg2, int arg3) {
        return new ParagraphIntrinsicInfo(arg1, arg2, arg3);
    }

    public static ParagraphIntrinsicInfo copy$default(ParagraphIntrinsicInfo arg0, ParagraphIntrinsics arg1, int arg2, int arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = arg0.intrinsics;
        }

        if((arg4 & 2) != 0) {
            arg2 = arg0.startIndex;
        }

        if((arg4 & 4) != 0) {
            arg3 = arg0.endIndex;
        }

        return arg0.copy(arg1, arg2, arg3);
    }

    public boolean equals(Object arg5) {
        if(this == (((ParagraphIntrinsicInfo)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof ParagraphIntrinsicInfo)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.intrinsics, ((ParagraphIntrinsicInfo)arg5).intrinsics)) {
            return 0;
        }

        if(this.startIndex != ((ParagraphIntrinsicInfo)arg5).startIndex) {
            return 0;
        }

        if(this.endIndex != ((ParagraphIntrinsicInfo)arg5).endIndex) {
            return 0;
        }

        return 1;
    }

    public final int getEndIndex() {
        return this.endIndex;
    }

    public final ParagraphIntrinsics getIntrinsics() {
        return this.intrinsics;
    }

    public final int getStartIndex() {
        return this.startIndex;
    }

    public int hashCode() {
        return (this.intrinsics.hashCode() * 0x1F + Integer.hashCode(this.startIndex)) * 0x1F + Integer.hashCode(this.endIndex);
    }

    public String toString() {
        return "ParagraphIntrinsicInfo(intrinsics=" + this.intrinsics + ", startIndex=" + this.startIndex + ", endIndex=" + this.endIndex + ')';
    }
}

