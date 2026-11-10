package com.TryJeanPc.goldenmouse.graphicsui;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000E\n\u0002\b\r\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000Bj\u0002\b\fj\u0002\b\rj\u0002\b\u000Ej\u0002\b\u000F¨\u0006\u0010"}, d2={"Lcom/TryJeanPc/goldenmouse/graphicsui/GraphicsLoadingOperation;", "", "label", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getLabel", "()Ljava/lang/String;", "CHECK", "SAVE", "APPLY", "RESTORE", "PREPARE", "ACTIVATE", "RECOVER", "LAUNCH_RECEIPT", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum GraphicsLoadingOperation {
    public static final enum GraphicsLoadingOperation ACTIVATE;
    public static final enum GraphicsLoadingOperation APPLY;
    public static final enum GraphicsLoadingOperation CHECK;
    public static final enum GraphicsLoadingOperation LAUNCH_RECEIPT;
    public static final enum GraphicsLoadingOperation PREPARE;
    public static final enum GraphicsLoadingOperation RECOVER;
    public static final enum GraphicsLoadingOperation RESTORE;
    public static final enum GraphicsLoadingOperation SAVE;
    private final String label;

    private static final GraphicsLoadingOperation[] $values() {
        return new GraphicsLoadingOperation[]{GraphicsLoadingOperation.CHECK, GraphicsLoadingOperation.SAVE, GraphicsLoadingOperation.APPLY, GraphicsLoadingOperation.RESTORE, GraphicsLoadingOperation.PREPARE, GraphicsLoadingOperation.ACTIVATE, GraphicsLoadingOperation.RECOVER, GraphicsLoadingOperation.LAUNCH_RECEIPT};
    }

    static {
        GraphicsLoadingOperation.CHECK = new GraphicsLoadingOperation("CHECK", 0, "Comprobando compatibilidad…");
        GraphicsLoadingOperation.SAVE = new GraphicsLoadingOperation("SAVE", 1, "Guardando configuración…");
        GraphicsLoadingOperation.APPLY = new GraphicsLoadingOperation("APPLY", 2, "Aplicando optimización…");
        GraphicsLoadingOperation.RESTORE = new GraphicsLoadingOperation("RESTORE", 3, "Restaurando configuración…");
        GraphicsLoadingOperation.PREPARE = new GraphicsLoadingOperation("PREPARE", 4, "Preparando gráficos del juego…");
        GraphicsLoadingOperation.ACTIVATE = new GraphicsLoadingOperation("ACTIVATE", 5, "Activando…");
        GraphicsLoadingOperation.RECOVER = new GraphicsLoadingOperation("RECOVER", 6, "Comprobando sesión gráfica…");
        GraphicsLoadingOperation.LAUNCH_RECEIPT = new GraphicsLoadingOperation("LAUNCH_RECEIPT", 7, "Comprobando el inicio solicitado…");
        GraphicsLoadingOperation[] v0 = GraphicsLoadingOperation.$values();
        GraphicsLoadingOperation.$VALUES = v0;
        GraphicsLoadingOperation.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private GraphicsLoadingOperation(String arg1, int arg2, String arg3) {
        super(arg1, arg2);
        this.label = arg3;
    }

    public static EnumEntries getEntries() {
        return GraphicsLoadingOperation.$ENTRIES;
    }

    public final String getLabel() {
        return this.label;
    }

    public static GraphicsLoadingOperation valueOf(String arg1) {
        return Enum.valueOf(GraphicsLoadingOperation.class, arg1);
    }

    public static GraphicsLoadingOperation[] values() {
        return GraphicsLoadingOperation.$VALUES.clone();
    }
}

