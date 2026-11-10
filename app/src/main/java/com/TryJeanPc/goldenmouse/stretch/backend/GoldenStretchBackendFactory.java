package com.TryJeanPc.goldenmouse.stretch.backend;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001A\u00020\u0005¨\u0006\u0006"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/backend/GoldenStretchBackendFactory;", "", "<init>", "()V", "create", "Lcom/TryJeanPc/goldenmouse/stretch/backend/GoldenStretchBackendAdapter;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GoldenStretchBackendFactory {
    public static final int $stable;
    public static final GoldenStretchBackendFactory INSTANCE;

    static {
        GoldenStretchBackendFactory.INSTANCE = new GoldenStretchBackendFactory();
    }

    private GoldenStretchBackendFactory() {
        super();
    }

    public final GoldenStretchBackendAdapter create() {
        return new GoldenStretchBackendAdapter(CollectionsKt.listOf(new StretchQueryTransport[]{new ShizukuQueryTransport(), new KadbQueryTransport()}));
    }
}

