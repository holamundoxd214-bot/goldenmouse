package com.TryJeanPc.goldenmouse.graphics;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u000B\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000Bj\u0002\b\fj\u0002\b\r¨\u0006\u000E"}, d2={"Lcom/TryJeanPc/goldenmouse/graphics/GraphicsLaunchOutcome;", "", "phase", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getPhase", "()Ljava/lang/String;", "REQUESTED", "REJECTED", "NO_RESULT", "CHANGED", "CANCELLED", "ERROR", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum GraphicsLaunchOutcome {
    public static final enum GraphicsLaunchOutcome CANCELLED;
    public static final enum GraphicsLaunchOutcome CHANGED;
    public static final enum GraphicsLaunchOutcome ERROR;
    public static final enum GraphicsLaunchOutcome NO_RESULT;
    public static final enum GraphicsLaunchOutcome REJECTED;
    public static final enum GraphicsLaunchOutcome REQUESTED;
    private final String phase;

    private static final GraphicsLaunchOutcome[] $values() {
        return new GraphicsLaunchOutcome[]{GraphicsLaunchOutcome.REQUESTED, GraphicsLaunchOutcome.REJECTED, GraphicsLaunchOutcome.NO_RESULT, GraphicsLaunchOutcome.CHANGED, GraphicsLaunchOutcome.CANCELLED, GraphicsLaunchOutcome.ERROR};
    }

    static {
        GraphicsLaunchOutcome.REQUESTED = new GraphicsLaunchOutcome("REQUESTED", 0, "LANZAMIENTO SOLICITADO");
        GraphicsLaunchOutcome.REJECTED = new GraphicsLaunchOutcome("REJECTED", 1, "LANZAMIENTO RECHAZADO");
        GraphicsLaunchOutcome.NO_RESULT = new GraphicsLaunchOutcome("NO_RESULT", 2, "LANZAMIENTO SIN RESULTADO");
        GraphicsLaunchOutcome.CHANGED = new GraphicsLaunchOutcome("CHANGED", 3, "LANZAMIENTO DESCARTADO");
        GraphicsLaunchOutcome.CANCELLED = new GraphicsLaunchOutcome("CANCELLED", 4, "LANZAMIENTO CANCELADO");
        GraphicsLaunchOutcome.ERROR = new GraphicsLaunchOutcome("ERROR", 5, "ERROR DE LANZAMIENTO");
        GraphicsLaunchOutcome[] v0 = GraphicsLaunchOutcome.$values();
        GraphicsLaunchOutcome.$VALUES = v0;
        GraphicsLaunchOutcome.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private GraphicsLaunchOutcome(String arg1, int arg2, String arg3) {
        super(arg1, arg2);
        this.phase = arg3;
    }

    public static EnumEntries getEntries() {
        return GraphicsLaunchOutcome.$ENTRIES;
    }

    public final String getPhase() {
        return this.phase;
    }

    public static GraphicsLaunchOutcome valueOf(String arg1) {
        return Enum.valueOf(GraphicsLaunchOutcome.class, arg1);
    }

    public static GraphicsLaunchOutcome[] values() {
        return GraphicsLaunchOutcome.$VALUES.clone();
    }
}

