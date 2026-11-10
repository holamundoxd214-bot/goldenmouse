package com.TryJeanPc.goldenmouse.graphics;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\f\u001A\u00020\u00062\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u000EJ\u0016\u0010\u0010\u001A\u00020\u00062\u0006\u0010\u0011\u001A\u00020\u000E2\u0006\u0010\u0012\u001A\u00020\u0013J\u0006\u0010\u0014\u001A\u00020\u0006R\u001A\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001E\u0010\t\u001A\u00020\u00032\u0006\u0010\t\u001A\u00020\u0003@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u0015"}, d2={"Lcom/TryJeanPc/goldenmouse/graphics/GraphicsAttemptLog;", "", "initial", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsAttempt;", "persist", "Lkotlin/Function1;", "", "<init>", "(Lcom/TryJeanPc/goldenmouse/graphics/GraphicsAttempt;Lkotlin/jvm/functions/Function1;)V", "value", "getValue", "()Lcom/TryJeanPc/goldenmouse/graphics/GraphicsAttempt;", "event", "phase", "", "detail", "backend", "identity", "uid", "", "saved", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GraphicsAttemptLog {
    public static final int $stable = 8;
    private final Function1 persist;
    private GraphicsAttempt value;

    static {
    }

    public GraphicsAttemptLog(GraphicsAttempt arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "initial");
        Intrinsics.checkNotNullParameter(arg3, "persist");
        super();
        this.persist = arg3;
        this.value = arg2;
        if(GraphicsProfileKt.validGraphicsPackage(arg2.getPkg())) {
            arg3.invoke(this.value);
            return;
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final void backend(String arg14, int arg15) {
        Intrinsics.checkNotNullParameter(arg14, "identity");
        this.value = GraphicsAttempt.copy$default(this.value, null, null, 0, null, null, arg14, arg15, false, null, 0x19F, null);
        this.event("CANAL", arg14 + " · UID efectivo " + arg15);
    }

    public final void event(String arg15, String arg16) {
        Intrinsics.checkNotNullParameter(arg15, "phase");
        Intrinsics.checkNotNullParameter(arg16, "detail");
        GraphicsAttempt v1 = GraphicsAttempt.copy$default(this.value, null, null, 0, arg15, StringsKt.take(arg16, 800), null, 0, false, CollectionsKt.takeLast(CollectionsKt.plus(this.value.getEvents(), System.currentTimeMillis() + " " + arg15 + " " + StringsKt.take(arg16, 600)), 0x30), 0xE7, null);
        this.value = v1;
        this.persist.invoke(v1);
    }

    public final GraphicsAttempt getValue() {
        return this.value;
    }

    public final void saved() {
        this.value = GraphicsAttempt.copy$default(this.value, null, null, 0, null, null, null, 0, true, null, 0x17F, null);
        this.event("GUARDADO", "Perfil local confirmado; efecto aún no verificado");
    }
}

