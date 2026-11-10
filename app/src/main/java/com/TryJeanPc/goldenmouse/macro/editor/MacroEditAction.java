package com.TryJeanPc.goldenmouse.macro.editor;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0003\u0012\u0006\u0010\u0007\u001A\u00020\u0003\u0012\b\u0010\b\u001A\u0004\u0018\u00010\t\u0012\u000E\b\u0002\u0010\n\u001A\b\u0012\u0004\u0012\u00020\f0\u000B¢\u0006\u0004\b\r\u0010\u000EJ\t\u0010\u001C\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001D\u001A\u00020\u0005HÆ\u0003J\t\u0010\u001E\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001F\u001A\u00020\u0003HÆ\u0003J\u0010\u0010 \u001A\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0016J\u000F\u0010!\u001A\b\u0012\u0004\u0012\u00020\f0\u000BHÆ\u0003JR\u0010\"\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\u00032\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\t2\u000E\b\u0002\u0010\n\u001A\b\u0012\u0004\u0012\u00020\f0\u000BHÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001A\u00020%2\b\u0010&\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\'\u001A\u00020\tHÖ\u0001J\t\u0010(\u001A\u00020)HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0007\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0010R\u0015\u0010\b\u001A\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0017\u001A\u0004\b\u0015\u0010\u0016R\u0017\u0010\n\u001A\b\u0012\u0004\u0012\u00020\f0\u000B¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001A\u001A\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u0010¨\u0006*"}, d2={"Lcom/TryJeanPc/goldenmouse/macro/editor/MacroEditAction;", "", "id", "", "type", "Lcom/TryJeanPc/goldenmouse/macro/editor/MacroActionType;", "startMs", "durationMs", "track", "", "points", "", "Lcom/TryJeanPc/goldenmouse/macro/editor/MacroPoint;", "<init>", "(JLcom/TryJeanPc/goldenmouse/macro/editor/MacroActionType;JJLjava/lang/Integer;Ljava/util/List;)V", "getId", "()J", "getType", "()Lcom/TryJeanPc/goldenmouse/macro/editor/MacroActionType;", "getStartMs", "getDurationMs", "getTrack", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPoints", "()Ljava/util/List;", "endMs", "getEndMs", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(JLcom/TryJeanPc/goldenmouse/macro/editor/MacroActionType;JJLjava/lang/Integer;Ljava/util/List;)Lcom/TryJeanPc/goldenmouse/macro/editor/MacroEditAction;", "equals", "", "other", "hashCode", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class MacroEditAction {
    public static final int $stable = 8;
    private final long durationMs;
    private final long id;
    private final List points;
    private final long startMs;
    private final Integer track;
    private final MacroActionType type;

    static {
    }

    public MacroEditAction(long arg2, MacroActionType arg4, long arg5, long arg7, Integer arg9, List arg10) {
        Intrinsics.checkNotNullParameter(arg4, "type");
        Intrinsics.checkNotNullParameter(arg10, "points");
        super();
        this.id = arg2;
        this.type = arg4;
        this.startMs = arg5;
        this.durationMs = arg7;
        this.track = arg9;
        this.points = arg10;
    }

    public MacroEditAction(long arg12, MacroActionType arg14, long arg15, long arg17, Integer arg19, List arg20, int arg21, DefaultConstructorMarker arg22) {
        List v10 = (arg21 & 0x20) != 0 ? CollectionsKt.emptyList() : arg20;
        this(arg12, arg14, arg15, arg17, arg19, v10);
    }

    public final long component1() {
        return this.id;
    }

    public final MacroActionType component2() {
        return this.type;
    }

    public final long component3() {
        return this.startMs;
    }

    public final long component4() {
        return this.durationMs;
    }

    public final Integer component5() {
        return this.track;
    }

    public final List component6() {
        return this.points;
    }

    public final MacroEditAction copy(long arg11, MacroActionType arg13, long arg14, long arg16, Integer arg18, List arg19) {
        Intrinsics.checkNotNullParameter(arg13, "type");
        Intrinsics.checkNotNullParameter(arg19, "points");
        return new MacroEditAction(arg11, arg13, arg14, arg16, arg18, arg19);
    }

    public static MacroEditAction copy$default(MacroEditAction arg10, long arg11, MacroActionType arg13, long arg14, long arg16, Integer arg18, List arg19, int arg20, Object arg21) {
        if((arg20 & 1) != 0) {
            arg11 = arg10.id;
        }

        long v1 = arg11;
        if((arg20 & 2) != 0) {
            arg13 = arg10.type;
        }

        MacroActionType v3 = arg13;
        if((arg20 & 4) != 0) {
            arg14 = arg10.startMs;
        }

        long v4 = arg14;
        long v6 = (arg20 & 8) != 0 ? arg10.durationMs : arg16;
        Integer v8 = (arg20 & 16) != 0 ? arg10.track : arg18;
        List v9 = (arg20 & 0x20) != 0 ? arg10.points : arg19;
        return arg10.copy(v1, v3, v4, v6, v8, v9);
    }

    public boolean equals(Object arg8) {
        if(this == (((MacroEditAction)arg8))) {
            return 1;
        }

        if(!(arg8 instanceof MacroEditAction)) {
            return 0;
        }

        if(this.id != ((MacroEditAction)arg8).id) {
            return 0;
        }

        if(this.type != ((MacroEditAction)arg8).type) {
            return 0;
        }

        if(this.startMs != ((MacroEditAction)arg8).startMs) {
            return 0;
        }

        if(this.durationMs != ((MacroEditAction)arg8).durationMs) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.track, ((MacroEditAction)arg8).track)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.points, ((MacroEditAction)arg8).points)) {
            return 0;
        }

        return 1;
    }

    public final long getDurationMs() {
        return this.durationMs;
    }

    public final long getEndMs() {
        return this.startMs + this.durationMs;
    }

    public final long getId() {
        return this.id;
    }

    public final List getPoints() {
        return this.points;
    }

    public final long getStartMs() {
        return this.startMs;
    }

    public final Integer getTrack() {
        return this.track;
    }

    public final MacroActionType getType() {
        return this.type;
    }

    public int hashCode() {
        int v0 = (((Long.hashCode(this.id) * 0x1F + this.type.hashCode()) * 0x1F + Long.hashCode(this.startMs)) * 0x1F + Long.hashCode(this.durationMs)) * 0x1F;
        Integer v1 = this.track;
        int v1_1 = v1 == null ? 0 : v1.hashCode();
        return (v0 + v1_1) * 0x1F + this.points.hashCode();
    }

    public String toString() {
        return "MacroEditAction(id=" + this.id + ", type=" + this.type + ", startMs=" + this.startMs + ", durationMs=" + this.durationMs + ", track=" + this.track + ", points=" + this.points + ")";
    }
}

