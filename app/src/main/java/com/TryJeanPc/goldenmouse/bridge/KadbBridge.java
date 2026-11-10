package com.TryJeanPc.goldenmouse.bridge;

import com.flyfishxu.kadb.Kadb$Companion;
import com.flyfishxu.kadb.Kadb;
import com.flyfishxu.kadb.shell.AdbShellResponse;
import com.flyfishxu.kadb.shell.AdbShellStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\r\u001A\u00020\b2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u000FH\u0086@¢\u0006\u0002\u0010\u0013J\u0016\u0010\u0014\u001A\u00020\b2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u0011J\u0006\u0010\u0015\u001A\u00020\bJ\u000E\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u000FJ\u000E\u0010\u0019\u001A\u00020\u000F2\u0006\u0010\u001A\u001A\u00020\u000FJ\u0006\u0010\u001B\u001A\u00020\u001CR\u0010\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001A\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\f¨\u0006\u001D"}, d2={"Lcom/TryJeanPc/goldenmouse/bridge/KadbBridge;", "", "<init>", "()V", "kadb", "Lcom/flyfishxu/kadb/Kadb;", "_conectado", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "conectado", "Lkotlinx/coroutines/flow/StateFlow;", "getConectado", "()Lkotlinx/coroutines/flow/StateFlow;", "emparejar", "host", "", "puerto", "", "codigo", "(Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "conectar", "estaConectado", "abrirShell", "Lcom/flyfishxu/kadb/shell/AdbShellStream;", "command", "ejecutar", "comando", "cerrar", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class KadbBridge {
    public static final int $stable;
    public static final KadbBridge INSTANCE;
    private static final MutableStateFlow _conectado;
    private static final StateFlow conectado;
    private static Kadb kadb;

    static {
        KadbBridge.INSTANCE = new KadbBridge();
        MutableStateFlow v0 = StateFlowKt.MutableStateFlow(Boolean.valueOf(false));
        KadbBridge._conectado = v0;
        KadbBridge.conectado = FlowKt.asStateFlow(v0);
        KadbBridge.$stable = 8;
    }

    private KadbBridge() {
        super();
    }

    public final AdbShellStream abrirShell(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "command");
        Kadb v0 = KadbBridge.kadb;
        if(v0 != null) {
            AdbShellStream v0_1 = v0.openShell(arg1);
            if(v0_1 != null) {
                return v0_1;
            }
        }

        throw new IllegalStateException("KADB no conectado");
    }

    public final void cerrar() {
        Kadb v1 = KadbBridge.kadb;
        if(v1 != null) {
            v1.close();
        }

        KadbBridge.kadb = null;
        KadbBridge._conectado.setValue(Boolean.valueOf(false));
    }

    public final boolean conectar(String arg11, int arg12) {
        Intrinsics.checkNotNullParameter(arg11, "host");
        try {
            Kadb v11 = Companion.create$default(Kadb.Companion, arg11, arg12, 0, 0, null, 28, null);
            v11.shell("echo GOLDEN_KADB_READY");
            if(v11.connectionCheck()) {
                Kadb v12 = KadbBridge.kadb;
                if(v12 != null) {
                    v12.close();
                }

                KadbBridge.kadb = v11;
                KadbBridge._conectado.setValue(Boolean.valueOf(true));
                return 1;
            }

            v11.close();
            this.estaConectado();
            return 0;
        }
        catch(Exception v0) {
            v0.printStackTrace();
            this.estaConectado();
            return 0;
        }
    }

    public final String ejecutar(String arg1) {
        String v0_3;
        Intrinsics.checkNotNullParameter(arg1, "comando");
        try {
            Kadb v0_1 = KadbBridge.kadb;
            if(v0_1 != null) {
                AdbShellResponse v0_2 = v0_1.shell(arg1);
                if(v0_2 != null) {
                    v0_3 = v0_2.getAllOutput();
                    if(v0_3 != null) {
                        return v0_3;
                    }
                }
            }

            return "SIN CONEXIÓN";
        }
        catch(Exception v0) {
            v0_3 = v0.getMessage();
            if(v0_3 == null) {
                v0_3 = "ERROR";
            }

            return v0_3;
        }
    }

    public final Object emparejar(String arg11, int arg12, String arg13, Continuation arg14) {
        KadbBridge$emparejar$1 v0_1;
        if((arg14 instanceof KadbBridge$emparejar$1)) {
            Continuation v0 = arg14;
            int v2 = 0x80000000;
            if((((KadbBridge$emparejar$1)v0).label & v2) != 0) {
                ((KadbBridge$emparejar$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new KadbBridge$emparejar$1(this, arg14);
        }

        Continuation v6 = ((Continuation)v0_1);
        Object v10 = ((KadbBridge$emparejar$1)v6).result;
        Object v14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int v0_2 = ((KadbBridge$emparejar$1)v6).label;
        boolean v9 = true;
        if(v0_2 != 0) {
            if(v0_2 == 1) {
                try {
                    ResultKt.throwOnFailure(v10);
                    goto label_50;
                }
                catch(Exception v0_3) {
                    goto label_48;
                }
            }

            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        ResultKt.throwOnFailure(v10);
        try {
            Companion v1 = Kadb.Companion;
            ((KadbBridge$emparejar$1)v6).L$0 = SpillingKt.nullOutSpilledVariable(arg11);
            ((KadbBridge$emparejar$1)v6).L$1 = SpillingKt.nullOutSpilledVariable(arg13);
            ((KadbBridge$emparejar$1)v6).I$0 = arg12;
            ((KadbBridge$emparejar$1)v6).label = 1;
            if(Companion.pair$default(v1, arg11, arg12, arg13, null, v6, 8, null) != v14) {
                goto label_50;
            }
        }
        catch(Exception v0_3) {
        label_48:
            v0_3.printStackTrace();
            v9 = false;
            goto label_50;
        }

        return v14;
    label_50:
        return Boxing.boxBoolean(v9);
    }

    public final boolean estaConectado() {
        boolean v2 = false;
        try {
            Kadb v0 = KadbBridge.kadb;
            if(v0 != null && (v0.connectionCheck())) {
                goto label_6;
            }
        }
        catch(Exception ) {
        }

        goto label_7;
    label_6:
        v2 = true;
    label_7:
        KadbBridge._conectado.setValue(Boolean.valueOf(v2));
        return v2;
    }

    public final StateFlow getConectado() {
        return KadbBridge.conectado;
    }
}

