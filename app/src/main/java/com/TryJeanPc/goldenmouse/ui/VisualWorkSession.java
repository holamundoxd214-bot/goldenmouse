package com.TryJeanPc.goldenmouse.ui;

import kotlin.Metadata;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\b\u001A\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\u0006\u0010\n\u001A\u00020\u000BJ\u000E\u0010\n\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\u0005J\u000E\u0010\r\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\u0005R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2={"Lcom/TryJeanPc/goldenmouse/ui/VisualWorkSession;", "", "<init>", "()V", "generation", "", "active", "", "begin", "()Ljava/lang/Long;", "stop", "", "token", "isCurrent", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class VisualWorkSession {
    public static final int $stable = 8;
    private boolean active;
    private long generation;

    static {
    }

    public VisualWorkSession() {
        super();
    }

    public final Long begin() {
        if(this.active) {
            return null;
        }

        this.active = true;
        long v0 = this.generation + 1;
        this.generation = v0;
        return Long.valueOf(v0);
    }

    public final boolean isCurrent(long arg3) {
        if((this.active) && this.generation == arg3) {
            return 1;
        }

        return 0;
    }

    public final void stop() {
        this.active = false;
        ++this.generation;
    }

    public final boolean stop(long arg1) {
        if(!this.isCurrent(arg1)) {
            return 0;
        }

        this.stop();
        return 1;
    }
}

