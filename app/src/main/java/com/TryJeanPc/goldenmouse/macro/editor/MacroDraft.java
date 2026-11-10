package com.TryJeanPc.goldenmouse.macro.editor;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007\u0012\b\b\u0002\u0010\b\u001A\u00020\t\u0012\u000E\b\u0002\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00070\u000B\u0012\u000E\b\u0002\u0010\f\u001A\b\u0012\u0004\u0012\u00020\r0\u000B¢\u0006\u0004\b\u000E\u0010\u000FJ\t\u0010\u001B\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001C\u001A\u00020\u0005HÆ\u0003J\t\u0010\u001D\u001A\u00020\u0007HÆ\u0003J\t\u0010\u001E\u001A\u00020\tHÆ\u0003J\u000F\u0010\u001F\u001A\b\u0012\u0004\u0012\u00020\u00070\u000BHÆ\u0003J\u000F\u0010 \u001A\b\u0012\u0004\u0012\u00020\r0\u000BHÆ\u0003JQ\u0010!\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\u000E\b\u0002\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00070\u000B2\u000E\b\u0002\u0010\f\u001A\b\u0012\u0004\u0012\u00020\r0\u000BHÆ\u0001J\u0013\u0010\"\u001A\u00020#2\b\u0010$\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001A\u00020\u0007HÖ\u0001J\t\u0010&\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017R\u0017\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00070\u000B¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0019R\u0017\u0010\f\u001A\b\u0012\u0004\u0012\u00020\r0\u000B¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u0019¨\u0006\'"}, d2={"Lcom/TryJeanPc/goldenmouse/macro/editor/MacroDraft;", "", "name", "", "mode", "Lcom/TryJeanPc/goldenmouse/macro/editor/MacroRunMode;", "repetitions", "", "intervalMs", "", "tracks", "", "actions", "Lcom/TryJeanPc/goldenmouse/macro/editor/MacroEditAction;", "<init>", "(Ljava/lang/String;Lcom/TryJeanPc/goldenmouse/macro/editor/MacroRunMode;IJLjava/util/List;Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "getMode", "()Lcom/TryJeanPc/goldenmouse/macro/editor/MacroRunMode;", "getRepetitions", "()I", "getIntervalMs", "()J", "getTracks", "()Ljava/util/List;", "getActions", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class MacroDraft {
    public static final int $stable = 8;
    private final List actions;
    private final long intervalMs;
    private final MacroRunMode mode;
    private final String name;
    private final int repetitions;
    private final List tracks;

    static {
    }

    public MacroDraft() {
        this(null, null, 0, 0, null, null, 0x3F, null);
    }

    public MacroDraft(String arg2, MacroRunMode arg3, int arg4, long arg5, List arg7, List arg8, int arg9, DefaultConstructorMarker arg10) {
        if((arg9 & 1) != 0) {
            arg2 = "Macro 1";
        }

        if((arg9 & 2) != 0) {
            arg3 = MacroRunMode.ONCE;
        }

        if((arg9 & 8) != 0) {
            arg5 = 0;
        }

        if((arg9 & 16) != 0) {
            arg7 = CollectionsKt.listOf(Integer.valueOf(1));
        }

        if((arg9 & 0x20) != 0) {
            arg8 = CollectionsKt.emptyList();
        }

        this(arg2, arg3, 1, arg5, arg7, arg8);
    }

    public MacroDraft(String arg2, MacroRunMode arg3, int arg4, long arg5, List arg7, List arg8) {
        Intrinsics.checkNotNullParameter(arg2, "name");
        Intrinsics.checkNotNullParameter(arg3, "mode");
        Intrinsics.checkNotNullParameter(arg7, "tracks");
        Intrinsics.checkNotNullParameter(arg8, "actions");
        super();
        this.name = arg2;
        this.mode = arg3;
        this.repetitions = arg4;
        this.intervalMs = arg5;
        this.tracks = arg7;
        this.actions = arg8;
    }

    public final String component1() {
        return this.name;
    }

    public final MacroRunMode component2() {
        return this.mode;
    }

    public final int component3() {
        return this.repetitions;
    }

    public final long component4() {
        return this.intervalMs;
    }

    public final List component5() {
        return this.tracks;
    }

    public final List component6() {
        return this.actions;
    }

    public final MacroDraft copy(String arg9, MacroRunMode arg10, int arg11, long arg12, List arg14, List arg15) {
        Intrinsics.checkNotNullParameter(arg9, "name");
        Intrinsics.checkNotNullParameter(arg10, "mode");
        Intrinsics.checkNotNullParameter(arg14, "tracks");
        Intrinsics.checkNotNullParameter(arg15, "actions");
        return new MacroDraft(arg9, arg10, arg11, arg12, arg14, arg15);
    }

    public static MacroDraft copy$default(MacroDraft arg0, String arg1, MacroRunMode arg2, int arg3, long arg4, List arg6, List arg7, int arg8, Object arg9) {
        if((arg8 & 1) != 0) {
            arg1 = arg0.name;
        }

        if((arg8 & 2) != 0) {
            arg2 = arg0.mode;
        }

        if((arg8 & 4) != 0) {
            arg3 = arg0.repetitions;
        }

        if((arg8 & 8) != 0) {
            arg4 = arg0.intervalMs;
        }

        if((arg8 & 16) != 0) {
            arg6 = arg0.tracks;
        }

        if((arg8 & 0x20) != 0) {
            arg7 = arg0.actions;
        }

        return arg0.copy(arg1, arg2, arg3, arg4, arg6, arg7);
    }

    public boolean equals(Object arg8) {
        if(this == (((MacroDraft)arg8))) {
            return 1;
        }

        if(!(arg8 instanceof MacroDraft)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.name, ((MacroDraft)arg8).name)) {
            return 0;
        }

        if(this.mode != ((MacroDraft)arg8).mode) {
            return 0;
        }

        if(this.repetitions != ((MacroDraft)arg8).repetitions) {
            return 0;
        }

        if(this.intervalMs != ((MacroDraft)arg8).intervalMs) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.tracks, ((MacroDraft)arg8).tracks)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.actions, ((MacroDraft)arg8).actions)) {
            return 0;
        }

        return 1;
    }

    public final List getActions() {
        return this.actions;
    }

    public final long getIntervalMs() {
        return this.intervalMs;
    }

    public final MacroRunMode getMode() {
        return this.mode;
    }

    public final String getName() {
        return this.name;
    }

    public final int getRepetitions() {
        return this.repetitions;
    }

    public final List getTracks() {
        return this.tracks;
    }

    public int hashCode() {
        return ((((this.name.hashCode() * 0x1F + this.mode.hashCode()) * 0x1F + Integer.hashCode(this.repetitions)) * 0x1F + Long.hashCode(this.intervalMs)) * 0x1F + this.tracks.hashCode()) * 0x1F + this.actions.hashCode();
    }

    public String toString() {
        return "MacroDraft(name=" + this.name + ", mode=" + this.mode + ", repetitions=" + this.repetitions + ", intervalMs=" + this.intervalMs + ", tracks=" + this.tracks + ", actions=" + this.actions + ")";
    }
}

