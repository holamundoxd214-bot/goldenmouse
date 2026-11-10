package com.TryJeanPc.goldenmouse.stretch.physical;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u0000 \u000B2\u00020\u0001:\u0001\u000BB\u001F\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\n\u001A\u00020\u0003R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/physical/StretchPhysicalCommandPermit;", "", "restoreOnly", "", "valid", "Lkotlin/Function0;", "<init>", "(ZLkotlin/jvm/functions/Function0;)V", "getRestoreOnly", "()Z", "active", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchPhysicalCommandPermit {
    @Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001A\u00020\u00052\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007J\u0014\u0010\t\u001A\u00020\u00052\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007¨\u0006\n"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/physical/StretchPhysicalCommandPermit$Companion;", "", "<init>", "()V", "forRestoration", "Lcom/TryJeanPc/goldenmouse/stretch/physical/StretchPhysicalCommandPermit;", "valid", "Lkotlin/Function0;", "", "forApplication", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final StretchPhysicalCommandPermit forApplication(Function0 arg3) {
            Intrinsics.checkNotNullParameter(arg3, "valid");
            return new StretchPhysicalCommandPermit(false, arg3, null);
        }

        public final StretchPhysicalCommandPermit forRestoration(Function0 arg3) {
            Intrinsics.checkNotNullParameter(arg3, "valid");
            return new StretchPhysicalCommandPermit(true, arg3, null);
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private final boolean restoreOnly;
    private final Function0 valid;

    static {
        StretchPhysicalCommandPermit.Companion = new Companion(null);
    }

    private StretchPhysicalCommandPermit(boolean arg1, Function0 arg2) {
        super();
        this.restoreOnly = arg1;
        this.valid = arg2;
    }

    public StretchPhysicalCommandPermit(boolean arg1, Function0 arg2, DefaultConstructorMarker arg3) {
        this(arg1, arg2);
    }

    public final boolean active() {
        return this.valid.invoke().booleanValue();
    }

    public final boolean getRestoreOnly() {
        return this.restoreOnly;
    }
}

