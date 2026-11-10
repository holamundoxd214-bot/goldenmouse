package com.TryJeanPc.goldenmouse.stretch.recovery;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u001D*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0001\u001DB!\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\b\u0010\u0007\u001A\u0004\u0018\u00018\u0000¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0011\u001A\u00020\u0004HÆ\u0003J\t\u0010\u0012\u001A\u00020\u0006HÆ\u0003J\u0010\u0010\u0013\u001A\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\u000FJ4\u0010\u0014\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u00062\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00018\u0000HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001A\u00020\u00172\b\u0010\u0018\u001A\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0019\u001A\u00020\u001AHÖ\u0001J\t\u0010\u001B\u001A\u00020\u001CHÖ\u0001R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0015\u0010\u0007\u001A\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\u0010\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u001E"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryDatum;", "T", "", "state", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryDatumState;", "source", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoverySource;", "value", "<init>", "(Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryDatumState;Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoverySource;Ljava/lang/Object;)V", "getState", "()Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryDatumState;", "getSource", "()Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoverySource;", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "component3", "copy", "(Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryDatumState;Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoverySource;Ljava/lang/Object;)Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryDatum;", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class RecoveryDatum {
    @Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u0004\u001A\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0001\u0010\u0006*\u00020\u00012\u0006\u0010\u0007\u001A\u0002H\u00062\u0006\u0010\b\u001A\u00020\t¢\u0006\u0002\u0010\nJ\u0014\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\f0\u00052\u0006\u0010\b\u001A\u00020\tJ\u0016\u0010\r\u001A\b\u0012\u0004\u0012\u00020\f0\u00052\b\b\u0002\u0010\b\u001A\u00020\tJ\u0014\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\f0\u00052\u0006\u0010\b\u001A\u00020\tJ\u0014\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\f0\u00052\u0006\u0010\b\u001A\u00020\t¨\u0006\u0010"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryDatum$Companion;", "", "<init>", "()V", "known", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryDatum;", "T", "value", "source", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoverySource;", "(Ljava/lang/Object;Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoverySource;)Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryDatum;", "absent", "", "unknown", "unsupported", "failed", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final RecoveryDatum absent(RecoverySource arg3) {
            Intrinsics.checkNotNullParameter(arg3, "source");
            return new RecoveryDatum(RecoveryDatumState.ABSENT, arg3, null);
        }

        public final RecoveryDatum failed(RecoverySource arg3) {
            Intrinsics.checkNotNullParameter(arg3, "source");
            return new RecoveryDatum(RecoveryDatumState.READ_FAILED, arg3, null);
        }

        public final RecoveryDatum known(Object arg2, RecoverySource arg3) {
            Intrinsics.checkNotNullParameter(arg2, "value");
            Intrinsics.checkNotNullParameter(arg3, "source");
            return new RecoveryDatum(RecoveryDatumState.KNOWN, arg3, arg2);
        }

        public final RecoveryDatum unknown(RecoverySource arg3) {
            Intrinsics.checkNotNullParameter(arg3, "source");
            return new RecoveryDatum(RecoveryDatumState.UNKNOWN, arg3, null);
        }

        public static RecoveryDatum unknown$default(Companion arg0, RecoverySource arg1, int arg2, Object arg3) {
            if((arg2 & 1) != 0) {
                arg1 = RecoverySource.UNKNOWN;
            }

            return arg0.unknown(arg1);
        }

        public final RecoveryDatum unsupported(RecoverySource arg3) {
            Intrinsics.checkNotNullParameter(arg3, "source");
            return new RecoveryDatum(RecoveryDatumState.UNSUPPORTED, arg3, null);
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private final RecoverySource source;
    private final RecoveryDatumState state;
    private final Object value;

    static {
        RecoveryDatum.Companion = new Companion(null);
    }

    public RecoveryDatum(RecoveryDatumState arg2, RecoverySource arg3, Object arg4) {
        Intrinsics.checkNotNullParameter(arg2, "state");
        Intrinsics.checkNotNullParameter(arg3, "source");
        super();
        this.state = arg2;
        this.source = arg3;
        this.value = arg4;
        int v3 = 1;
        int v1 = arg2 == RecoveryDatumState.KNOWN ? 1 : 0;
        if(arg4 != null) {
        }
        else {
            v3 = 0;
        }

        if(v1 == v3) {
            return;
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final RecoveryDatumState component1() {
        return this.state;
    }

    public final RecoverySource component2() {
        return this.source;
    }

    public final Object component3() {
        return this.value;
    }

    public final RecoveryDatum copy(RecoveryDatumState arg1, RecoverySource arg2, Object arg3) {
        Intrinsics.checkNotNullParameter(arg1, "state");
        Intrinsics.checkNotNullParameter(arg2, "source");
        return new RecoveryDatum(arg1, arg2, arg3);
    }

    public static RecoveryDatum copy$default(RecoveryDatum arg0, RecoveryDatumState arg1, RecoverySource arg2, Object arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = arg0.state;
        }

        if((arg4 & 2) != 0) {
            arg2 = arg0.source;
        }

        if((arg4 & 4) != 0) {
            arg3 = arg0.value;
        }

        return arg0.copy(arg1, arg2, arg3);
    }

    public boolean equals(Object arg5) {
        if(this == (((RecoveryDatum)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof RecoveryDatum)) {
            return 0;
        }

        if(this.state != ((RecoveryDatum)arg5).state) {
            return 0;
        }

        if(this.source != ((RecoveryDatum)arg5).source) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.value, ((RecoveryDatum)arg5).value)) {
            return 0;
        }

        return 1;
    }

    public final RecoverySource getSource() {
        return this.source;
    }

    public final RecoveryDatumState getState() {
        return this.state;
    }

    public final Object getValue() {
        return this.value;
    }

    public int hashCode() {
        int v0 = (this.state.hashCode() * 0x1F + this.source.hashCode()) * 0x1F;
        Object v2 = this.value;
        int v2_1 = v2 == null ? 0 : v2.hashCode();
        return v0 + v2_1;
    }

    public String toString() {
        return "RecoveryDatum(state=" + this.state + ", source=" + this.source + ", value=" + this.value + ")";
    }
}

