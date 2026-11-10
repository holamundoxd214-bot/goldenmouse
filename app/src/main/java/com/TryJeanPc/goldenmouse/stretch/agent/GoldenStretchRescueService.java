package com.TryJeanPc.goldenmouse.stretch.agent;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0015\b\u0007\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/GoldenStretchRescueService;", "Lcom/TryJeanPc/goldenmouse/stretch/agent/GoldenStretchDisplayService;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GoldenStretchRescueService extends GoldenStretchDisplayService {
    public static final int $stable = 8;

    static {
    }

    public GoldenStretchRescueService() {
        this(null, 1, null);
    }

    public GoldenStretchRescueService(Context arg1, int arg2, DefaultConstructorMarker arg3) {
        if((arg2 & 1) != 0) {
            arg1 = null;
        }

        this(arg1);
    }

    public GoldenStretchRescueService(Context arg2) {
        super(arg2, true);
    }
}

