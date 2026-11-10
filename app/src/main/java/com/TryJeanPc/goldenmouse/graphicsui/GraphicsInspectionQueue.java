package com.TryJeanPc.goldenmouse.graphicsui;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00052\b\b\u0002\u0010\u0012\u001A\u00020\fJ\u0010\u0010\u0013\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001A\u00020\fJ\u0016\u0010\u0015\u001A\u00020\f2\u0006\u0010\u0011\u001A\u00020\u00052\u0006\u0010\u0016\u001A\u00020\u0005J\u000E\u0010\u0017\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0005R\u0010\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u0004\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001A\u0004\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u0011\u0010\u000B\u001A\u00020\f8F¢\u0006\u0006\u001A\u0004\b\r\u0010\u000E¨\u0006\u0018"}, d2={"Lcom/TryJeanPc/goldenmouse/graphicsui/GraphicsInspectionQueue;", "", "<init>", "()V", "requested", "Lcom/TryJeanPc/goldenmouse/graphicsui/GraphicsInspectionKey;", "completed", "active", "generation", "", "activeGeneration", "pending", "", "getPending", "()Z", "request", "", "key", "force", "begin", "blocked", "accepts", "current", "finish", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GraphicsInspectionQueue {
    public static final int $stable = 8;
    private GraphicsInspectionKey active;
    private long activeGeneration;
    private GraphicsInspectionKey completed;
    private long generation;
    private GraphicsInspectionKey requested;

    static {
    }

    public GraphicsInspectionQueue() {
        super();
    }

    public final boolean accepts(GraphicsInspectionKey arg5, GraphicsInspectionKey arg6) {
        Intrinsics.checkNotNullParameter(arg5, "key");
        Intrinsics.checkNotNullParameter(arg6, "current");
        if((Intrinsics.areEqual(this.active, arg5)) && this.activeGeneration == this.generation && (Intrinsics.areEqual(arg5, arg6))) {
            return 1;
        }

        return 0;
    }

    public final GraphicsInspectionKey begin(boolean arg3) {
        GraphicsInspectionKey v0 = null;
        if(!arg3) {
            if(this.active != null) {
            }
            else {
                GraphicsInspectionKey v3 = this.requested;
                if(v3 == null) {
                    return v0;
                }
                else {
                    this.requested = v0;
                    this.active = v3;
                    this.activeGeneration = this.generation;
                    return v3;
                }
            }
        }

        return v0;
    }

    public final void finish(GraphicsInspectionKey arg5) {
        Intrinsics.checkNotNullParameter(arg5, "key");
        if(Intrinsics.areEqual(this.active, arg5)) {
            if(this.activeGeneration == this.generation) {
                this.completed = arg5;
            }

            this.active = null;
            return;
        }

        throw new IllegalStateException("Check failed.");
    }

    public final boolean getPending() {
        if(this.requested != null) {
            return 1;
        }

        return 0;
    }

    public final void request(GraphicsInspectionKey arg3, boolean arg4) {
        Intrinsics.checkNotNullParameter(arg3, "key");
        if(!arg4) {
            if(!Intrinsics.areEqual(arg3, this.requested)) {
                if(this.requested != null) {
                    goto label_15;
                }
                else if(!Intrinsics.areEqual(arg3, this.active)) {
                    if(Intrinsics.areEqual(arg3, this.completed)) {
                        return;
                    }

                    goto label_15;
                }
            }

            return;
        }

    label_15:
        this.requested = arg3;
        ++this.generation;
    }

    public static void request$default(GraphicsInspectionQueue arg0, GraphicsInspectionKey arg1, boolean arg2, int arg3, Object arg4) {
        arg0.request(arg1, false);
    }
}

