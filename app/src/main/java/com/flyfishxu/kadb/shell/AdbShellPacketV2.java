package com.flyfishxu.kadb.shell;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2={"Lcom/flyfishxu/kadb/shell/AdbShellPacketV2;", "", "<init>", "()V", "Companion", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public final class AdbShellPacketV2 {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2={"Lcom/flyfishxu/kadb/shell/AdbShellPacketV2$Companion;", "", "<init>", "()V", "ID_STDIN", "", "ID_STDOUT", "ID_STDERR", "ID_EXIT", "ID_CLOSE_STDIN", "ID_WINDOW_SIZE_CHANGE", "ID_INVALID", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    public static final Companion Companion = null;
    public static final int ID_CLOSE_STDIN = 4;
    public static final int ID_EXIT = 3;
    public static final int ID_INVALID = 0xFF;
    public static final int ID_STDERR = 2;
    public static final int ID_STDIN = 0;
    public static final int ID_STDOUT = 1;
    public static final int ID_WINDOW_SIZE_CHANGE = 5;

    static {
        AdbShellPacketV2.Companion = new Companion(null);
    }

    public AdbShellPacketV2() {
        super();
    }
}

