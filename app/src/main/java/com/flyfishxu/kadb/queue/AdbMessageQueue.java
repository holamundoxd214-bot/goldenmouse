package com.flyfishxu.kadb.queue;

import com.flyfishxu.kadb.core.AdbMessage;
import com.flyfishxu.kadb.core.AdbReader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B\u000F\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001A\u00020\u0004H\u0014J\u0010\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u0004H\u0014J\u0010\u0010\r\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u0004H\u0014J\b\u0010\u000E\u001A\u00020\u000FH\u0016J\u0010\u0010\u0010\u001A\u00020\u00112\u0006\u0010\f\u001A\u00020\u0004H\u0014R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2={"Lcom/flyfishxu/kadb/queue/AdbMessageQueue;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "Lcom/flyfishxu/kadb/queue/MessageQueue;", "Lcom/flyfishxu/kadb/core/AdbMessage;", "adbReader", "Lcom/flyfishxu/kadb/core/AdbReader;", "<init>", "(Lcom/flyfishxu/kadb/core/AdbReader;)V", "readMessage", "getLocalId", "", "message", "getCommand", "close", "", "isCloseCommand", "", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public final class AdbMessageQueue extends MessageQueue implements AutoCloseable {
    private final AdbReader adbReader;

    public AdbMessageQueue(AdbReader arg2) {
        Intrinsics.checkNotNullParameter(arg2, "adbReader");
        super();
        this.adbReader = arg2;
    }

    public void close() {
        this.adbReader.close();
    }

    protected int getCommand(AdbMessage arg1) {
        Intrinsics.checkNotNullParameter(arg1, "message");
        return arg1.getCommand();
    }

    public int getCommand(Object arg1) {
        return this.getCommand(((AdbMessage)arg1));
    }

    protected int getLocalId(AdbMessage arg1) {
        Intrinsics.checkNotNullParameter(arg1, "message");
        return arg1.getArg1();
    }

    public int getLocalId(Object arg1) {
        return this.getLocalId(((AdbMessage)arg1));
    }

    protected boolean isCloseCommand(AdbMessage arg1) {
        Intrinsics.checkNotNullParameter(arg1, "message");
        if(arg1.getCommand() == 1163086915) {
            return 1;
        }

        return 0;
    }

    public boolean isCloseCommand(Object arg1) {
        return this.isCloseCommand(((AdbMessage)arg1));
    }

    protected AdbMessage readMessage() {
        return this.adbReader.readMessage();
    }

    public Object readMessage() {
        return this.readMessage();
    }
}

