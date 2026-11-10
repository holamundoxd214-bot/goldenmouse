package com.TryJeanPc.goldenmouse.stretch.backend;

import com.TryJeanPc.goldenmouse.bridge.KadbBridge;
import com.flyfishxu.kadb.shell.AdbShellStream;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001A\u00020\tH\u0016J\u0010\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\rH\u0016R\u0014\u0010\u0004\u001A\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u000E"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/backend/KadbQueryTransport;", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchQueryTransport;", "<init>", "()V", "backend", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchBackendType;", "getBackend", "()Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchBackendType;", "status", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchBackendStatus;", "open", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchQueryChannel;", "query", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchQuery;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class KadbQueryTransport implements StretchQueryTransport {
    public static final int $stable;
    private final StretchBackendType backend;

    static {
    }

    public KadbQueryTransport() {
        super();
        this.backend = StretchBackendType.KADB;
    }

    public StretchBackendType getBackend() {
        return this.backend;
    }

    public StretchQueryChannel open(StretchQuery arg10) {
        StretchTransportError v9_4;
        AdbShellStream v9_1;
        Intrinsics.checkNotNullParameter(arg10, "query");
        List v9 = arg10.getArguments$app();
        if(v9 != null) {
            try {
                v9_1 = KadbBridge.INSTANCE.abrirShell(CollectionsKt.joinToString$default(v9, " ", null, null, 0, null, null, 62, null));
            }
            catch(IllegalStateException v0) {
                IllegalStateException v9_2 = v0;
                if(KadbBridge.INSTANCE.estaConectado()) {
                    String v9_3 = v9_2.getMessage();
                    if(v9_3 == null) {
                        v9_3 = "";
                    }

                    if(StringsKt.contains(((CharSequence)v9_3), "shell", true)) {
                        v9_4 = StretchTransportError.UNSUPPORTED;
                        goto label_38;
                    }

                    v9_4 = StretchTransportError.TRANSPORT_FAILURE;
                }
                else {
                    v9_4 = StretchTransportError.DISCONNECTED;
                }

            label_38:
                throw new StretchTransportException(v9_4);
            }

            return new KadbQueryChannel(v9_1);
        }

        throw new UnsupportedOperationException();
    }

    public StretchBackendStatus status() {
        if(KadbBridge.INSTANCE.estaConectado()) {
            return new StretchBackendStatus(this.getBackend(), StretchBackendState.AVAILABLE, Boolean.valueOf(true), null, null, "Existing connection open; effective permission and shell v2 not yet verified", 24, null);
        }

        return new StretchBackendStatus(this.getBackend(), StretchBackendState.DISCONNECTED, Boolean.valueOf(false), null, null, null, 56, null);
    }
}

