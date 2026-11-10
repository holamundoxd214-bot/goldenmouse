package androidx.compose.ui.contentcapture;

import androidx.compose.ui.platform.coreshims.ViewStructureCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\b\u0010\b\u001A\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000BJ\t\u0010\u0014\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001A\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001A\u00020\u0007HÆ\u0003J\u000B\u0010\u0017\u001A\u0004\u0018\u00010\tHÆ\u0003J3\u0010\u0018\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0019\u001A\u00020\u001A2\b\u0010\u001B\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001C\u001A\u00020\u0003HÖ\u0001J\t\u0010\u001D\u001A\u00020\u001EHÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001A\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013¨\u0006\u001F"}, d2={"Landroidx/compose/ui/contentcapture/ContentCaptureEvent;", "", "id", "", "timestamp", "", "type", "Landroidx/compose/ui/contentcapture/ContentCaptureEventType;", "structureCompat", "Landroidx/compose/ui/platform/coreshims/ViewStructureCompat;", "<init>", "(IJLandroidx/compose/ui/contentcapture/ContentCaptureEventType;Landroidx/compose/ui/platform/coreshims/ViewStructureCompat;)V", "getId", "()I", "getTimestamp", "()J", "getType", "()Landroidx/compose/ui/contentcapture/ContentCaptureEventType;", "getStructureCompat", "()Landroidx/compose/ui/platform/coreshims/ViewStructureCompat;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class ContentCaptureEvent {
    private final int id;
    private final ViewStructureCompat structureCompat;
    private final long timestamp;
    private final ContentCaptureEventType type;

    public ContentCaptureEvent(int arg1, long arg2, ContentCaptureEventType arg4, ViewStructureCompat arg5) {
        super();
        this.id = arg1;
        this.timestamp = arg2;
        this.type = arg4;
        this.structureCompat = arg5;
    }

    public final int component1() {
        return this.id;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final ContentCaptureEventType component3() {
        return this.type;
    }

    public final ViewStructureCompat component4() {
        return this.structureCompat;
    }

    public final ContentCaptureEvent copy(int arg1, long arg2, ContentCaptureEventType arg4, ViewStructureCompat arg5) {
        return new ContentCaptureEvent(arg1, arg2, arg4, arg5);
    }

    public static ContentCaptureEvent copy$default(ContentCaptureEvent arg0, int arg1, long arg2, ContentCaptureEventType arg4, ViewStructureCompat arg5, int arg6, Object arg7) {
        if((arg6 & 1) != 0) {
            arg1 = arg0.id;
        }

        if((arg6 & 2) != 0) {
            arg2 = arg0.timestamp;
        }

        if((arg6 & 4) != 0) {
            arg4 = arg0.type;
        }

        if((arg6 & 8) != 0) {
            arg5 = arg0.structureCompat;
        }

        return arg0.copy(arg1, arg2, arg4, arg5);
    }

    public boolean equals(Object arg8) {
        if(this == (((ContentCaptureEvent)arg8))) {
            return 1;
        }

        if(!(arg8 instanceof ContentCaptureEvent)) {
            return 0;
        }

        if(this.id != ((ContentCaptureEvent)arg8).id) {
            return 0;
        }

        if(this.timestamp != ((ContentCaptureEvent)arg8).timestamp) {
            return 0;
        }

        if(this.type != ((ContentCaptureEvent)arg8).type) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.structureCompat, ((ContentCaptureEvent)arg8).structureCompat)) {
            return 0;
        }

        return 1;
    }

    public final int getId() {
        return this.id;
    }

    public final ViewStructureCompat getStructureCompat() {
        return this.structureCompat;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final ContentCaptureEventType getType() {
        return this.type;
    }

    public int hashCode() {
        int v0 = ((Integer.hashCode(this.id) * 0x1F + Long.hashCode(this.timestamp)) * 0x1F + this.type.hashCode()) * 0x1F;
        ViewStructureCompat v3 = this.structureCompat;
        int v3_1 = v3 == null ? 0 : v3.hashCode();
        return v0 + v3_1;
    }

    public String toString() {
        return "ContentCaptureEvent(id=" + this.id + ", timestamp=" + this.timestamp + ", type=" + this.type + ", structureCompat=" + this.structureCompat + ')';
    }
}

