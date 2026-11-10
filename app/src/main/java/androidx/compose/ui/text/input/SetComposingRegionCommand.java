package androidx.compose.ui.text.input;

import kotlin.Metadata;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\rH\u0016J\u0013\u0010\u000E\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001A\u00020\u0003H\u0016J\b\u0010\u0013\u001A\u00020\u0014H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\b¨\u0006\u0015"}, d2={"Landroidx/compose/ui/text/input/SetComposingRegionCommand;", "Landroidx/compose/ui/text/input/EditCommand;", "start", "", "end", "<init>", "(II)V", "getStart", "()I", "getEnd", "applyTo", "", "buffer", "Landroidx/compose/ui/text/input/EditingBuffer;", "equals", "", "other", "", "hashCode", "toString", "", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SetComposingRegionCommand implements EditCommand {
    public static final int $stable;
    private final int end;
    private final int start;

    static {
    }

    public SetComposingRegionCommand(int arg1, int arg2) {
        super();
        this.start = arg1;
        this.end = arg2;
    }

    public void applyTo(EditingBuffer arg4) {
        if(arg4.hasComposition$ui_text()) {
            arg4.commitComposition$ui_text();
        }

        int v0 = RangesKt.coerceIn(this.start, 0, arg4.getLength$ui_text());
        int v3 = RangesKt.coerceIn(this.end, 0, arg4.getLength$ui_text());
        if(v0 != v3) {
            if(v0 < v3) {
                arg4.setComposition$ui_text(v0, v3);
                return;
            }
            else {
                arg4.setComposition$ui_text(v3, v0);
            }
        }
    }

    public boolean equals(Object arg5) {
        if(this == (((SetComposingRegionCommand)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof SetComposingRegionCommand)) {
            return 0;
        }

        if(this.start != ((SetComposingRegionCommand)arg5).start) {
            return 0;
        }

        if(this.end != ((SetComposingRegionCommand)arg5).end) {
            return 0;
        }

        return 1;
    }

    public final int getEnd() {
        return this.end;
    }

    public final int getStart() {
        return this.start;
    }

    public int hashCode() {
        return this.start * 0x1F + this.end;
    }

    public String toString() {
        return "SetComposingRegionCommand(start=" + this.start + ", end=" + this.end + ')';
    }
}

