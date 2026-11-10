package com.TryJeanPc.goldenmouse.activation;

import android.content.Context;
import com.TryJeanPc.goldenmouse.bridge.KadbBridge;
import com.TryJeanPc.goldenmouse.bridge.ShizukuBridge;
import com.TryJeanPc.goldenmouse.bridge.WirelessBridge$Endpoint;
import com.TryJeanPc.goldenmouse.bridge.WirelessBridge;
import com.flyfishxu.kadb.cert.KadbCert;
import com.flyfishxu.kadb.cert.OkioFilePrivateKeyStore;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import okio.FileSystem;
import okio.Path$Companion;
import okio.Path;

@Metadata(d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\'B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u0015J\u000E\u0010\u001C\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u0015J\u000E\u0010\u001D\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u0015J\u0006\u0010\u001E\u001A\u00020\u001AJ\u000E\u0010\u001F\u001A\u00020\rH\u0086@¢\u0006\u0002\u0010 J\u001E\u0010!\u001A\u00020\"2\u0006\u0010\u001B\u001A\u00020\u00152\u0006\u0010#\u001A\u00020\u0005H\u0086@¢\u0006\u0002\u0010$J\u000E\u0010%\u001A\u00020\u001AH\u0082@¢\u0006\u0002\u0010 J\b\u0010&\u001A\u00020\u001AH\u0002R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\r0\u000F¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u000E\u0010\u0012\u001A\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000E\u0010\u0016\u001A\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000E\u0010\u0017\u001A\u00020\u0018X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006("}, d2={"Lcom/TryJeanPc/goldenmouse/activation/ActivationManager;", "", "<init>", "()V", "KADB_KEY_FILE", "", "initializationLock", "operationMutex", "Lkotlinx/coroutines/sync/Mutex;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "_status", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/TryJeanPc/goldenmouse/activation/ActivationStatus;", "status", "Lkotlinx/coroutines/flow/StateFlow;", "getStatus", "()Lkotlinx/coroutines/flow/StateFlow;", "storage", "Lcom/TryJeanPc/goldenmouse/activation/ActivationStorage;", "applicationContext", "Landroid/content/Context;", "keyFilePath", "initialized", "", "initialize", "", "context", "selectKadb", "selectShizuku", "refresh", "validateForStart", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pairKadb", "Lcom/TryJeanPc/goldenmouse/activation/ActivationManager$PairingResult;", "pairingCode", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "restoreKadb", "refreshShizuku", "PairingResult", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class ActivationManager {
    @Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001A\u00020\u0003HÆ\u0003J\t\u0010\r\u001A\u00020\u0005HÆ\u0003J\u001D\u0010\u000E\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\u000F\u001A\u00020\u00032\b\u0010\u0010\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001A\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001A\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u0014"}, d2={"Lcom/TryJeanPc/goldenmouse/activation/ActivationManager$PairingResult;", "", "connected", "", "message", "", "<init>", "(ZLjava/lang/String;)V", "getConnected", "()Z", "getMessage", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class PairingResult {
        public static final int $stable;
        private final boolean connected;
        private final String message;

        static {
        }

        public PairingResult(boolean arg2, String arg3) {
            Intrinsics.checkNotNullParameter(arg3, "message");
            super();
            this.connected = arg2;
            this.message = arg3;
        }

        public final boolean component1() {
            return this.connected;
        }

        public final String component2() {
            return this.message;
        }

        public final PairingResult copy(boolean arg1, String arg2) {
            Intrinsics.checkNotNullParameter(arg2, "message");
            return new PairingResult(arg1, arg2);
        }

        public static PairingResult copy$default(PairingResult arg0, boolean arg1, String arg2, int arg3, Object arg4) {
            if((arg3 & 1) != 0) {
                arg1 = arg0.connected;
            }

            if((arg3 & 2) != 0) {
                arg2 = arg0.message;
            }

            return arg0.copy(arg1, arg2);
        }

        public boolean equals(Object arg5) {
            if(this == (((PairingResult)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof PairingResult)) {
                return 0;
            }

            if(this.connected != ((PairingResult)arg5).connected) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.message, ((PairingResult)arg5).message)) {
                return 0;
            }

            return 1;
        }

        public final boolean getConnected() {
            return this.connected;
        }

        public final String getMessage() {
            return this.message;
        }

        public int hashCode() {
            return Boolean.hashCode(this.connected) * 0x1F + this.message.hashCode();
        }

        public String toString() {
            return "PairingResult(connected=" + this.connected + ", message=" + this.message + ")";
        }
    }

    public static final int $stable = 0;
    public static final ActivationManager INSTANCE = null;
    private static final String KADB_KEY_FILE = "golden_kadb_identity.pem";
    private static final MutableStateFlow _status;
    private static Context applicationContext;
    private static final Object initializationLock;
    private static volatile boolean initialized;
    private static String keyFilePath;
    private static final Mutex operationMutex;
    private static final CoroutineScope scope;
    private static final StateFlow status;
    private static ActivationStorage storage;

    static {
        ActivationManager.INSTANCE = new ActivationManager();
        ActivationManager.initializationLock = new Object();
        ActivationManager.operationMutex = MutexKt.Mutex$default(false, 1, null);
        ActivationManager.scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        MutableStateFlow v0 = StateFlowKt.MutableStateFlow(ActivationStatus.UNCONFIGURED);
        ActivationManager._status = v0;
        ActivationManager.status = FlowKt.asStateFlow(v0);
        ActivationManager.$stable = 8;
    }

    private ActivationManager() {
        super();
    }

    public static final boolean access$getInitialized$p() {
        return ActivationManager.initialized;
    }

    public static final Mutex access$getOperationMutex$p() {
        return ActivationManager.operationMutex;
    }

    public static final ActivationStorage access$getStorage$p() {
        return ActivationManager.storage;
    }

    public static final MutableStateFlow access$get_status$p() {
        return ActivationManager._status;
    }

    public static final void access$refreshShizuku(ActivationManager arg0) {
        arg0.refreshShizuku();
    }

    public static final Object access$restoreKadb(ActivationManager arg0, Continuation arg1) {
        return arg0.restoreKadb(arg1);
    }

    public final StateFlow getStatus() {
        return ActivationManager.status;
    }

    public final void initialize(Context arg11) {
        Intrinsics.checkNotNullParameter(arg11, "context");
        if(ActivationManager.initialized) {
            return;
        }

        Object v1 = ActivationManager.initializationLock;
        __monitor_enter(v1);
        try {
            if(!ActivationManager.initialized) {
                goto label_11;
            }
        }
        catch(Throwable v0) {
            goto label_64;
        }

        __monitor_exit(v1);
        return;
        try {
        label_11:
            arg11 = arg11.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(arg11, "getApplicationContext(...)");
            ActivationManager.applicationContext = arg11;
            Context v0_1 = ActivationManager.applicationContext;
            Object v2 = null;
            if(v0_1 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
                v0_1 = ((Context)v2);
            }

            ActivationManager.storage = new ActivationStorage(v0_1);
            arg11 = ActivationManager.applicationContext;
            if(arg11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
                arg11 = ((Context)v2);
            }

            File v11 = arg11.getNoBackupFilesDir();
            Intrinsics.checkNotNullExpressionValue(v11, "getNoBackupFilesDir(...)");
            String v11_1 = FilesKt.resolve(v11, "golden_kadb_identity.pem").getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(v11_1, "getAbsolutePath(...)");
            ActivationManager.keyFilePath = v11_1;
            KadbCert v3 = KadbCert.INSTANCE;
            Companion v0_2 = Path.Companion;
            String v4 = ActivationManager.keyFilePath;
            if(v4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("keyFilePath");
                v4 = ((String)v2);
            }

            KadbCert.configure$default(v3, new OkioFilePrivateKeyStore(Companion.get$default(v0_2, v4, false, 1, v2), ((FileSystem)v2), 2, ((DefaultConstructorMarker)v2)), null, null, 6, null);
            ActivationManager.initialized = true;
        }
        catch(Throwable v0) {
        label_64:
            __monitor_exit(v1);
            throw v0;
        }

        __monitor_exit(v1);
        this.refresh();
    }

    public final Object pairKadb(Context arg18, String arg19, Continuation arg20) {
        Object v2;
        int v16;
        Object v13;
        Object v8;
        Object v7_1;
        Object v6_1;
        int v2_1;
        int v0_3;
        Object v4_1;
        Object v1_2;
        Context v14_1;
        WirelessBridge v8_3;
        PairingResult v0_5;
        Context v15;
        MutableStateFlow v8_2;
        ActivationStorage v8_1;
        Mutex v4_2;
        ActivationManager$pairKadb$1 v1_1;
        Continuation v0 = arg20;
        if((v0 instanceof ActivationManager$pairKadb$1)) {
            Continuation v1 = v0;
            int v3 = 0x80000000;
            if((((ActivationManager$pairKadb$1)v1).label & v3) != 0) {
                ((ActivationManager$pairKadb$1)v1).label -= v3;
            }
            else {
                goto label_13;
            }
        }
        else {
        label_13:
            v1_1 = new ActivationManager$pairKadb$1(this, v0);
        }

        Object v0_1 = v1_1.result;
        Object v3_1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int v4 = v1_1.label;
        int v5 = 4;
        int v6 = 3;
        int v7 = 2;
        String v9 = "applicationContext";
        String v10 = "storage";
        Object v12 = null;
        if(v4 == 0) {
            ResultKt.throwOnFailure(v0_1);
            this.initialize(arg18);
            Mutex v0_4 = ActivationManager.operationMutex;
            v1_1.L$0 = SpillingKt.nullOutSpilledVariable(arg18);
            String v2_3 = arg19;
            v1_1.L$1 = v2_3;
            v1_1.L$2 = v0_4;
            v1_1.I$0 = 0;
            v1_1.label = 1;
            if(v0_4.lock(v12, ((Continuation)v1_1)) == v3_1) {
                return v3_1;
            }
            else {
                Context v13_1 = arg18;
                v4_2 = v0_4;
                v0_3 = 0;
                try {
                label_98:
                    v8_1 = ActivationManager.storage;
                    if(v8_1 == null) {
                        goto label_100;
                    }

                    goto label_106;
                }
                catch(Throwable v0_2) {
                    goto label_250;
                }

                try {
                label_100:
                    Intrinsics.throwUninitializedPropertyAccessException(v10);
                    v8_1 = ((ActivationStorage)v12);
                }
                catch(Throwable v0_2) {
                    goto label_104;
                }

                try {
                label_106:
                    v8_1.saveActiveMethod("KADB");
                    v8_2 = ActivationManager._status;
                    v8_2.setValue(ActivationStatus.PAIRING);
                    WirelessBridge v14 = WirelessBridge.INSTANCE;
                    v15 = ActivationManager.applicationContext;
                    if(v15 == null) {
                        goto label_114;
                    }

                    goto label_116;
                }
                catch(Throwable v0_2) {
                    goto label_250;
                }

                try {
                label_114:
                    Intrinsics.throwUninitializedPropertyAccessException(v9);
                    v15 = ((Context)v12);
                }
                catch(Throwable v0_2) {
                    goto label_104;
                }

                try {
                label_116:
                    if(v14.permisoRedLocalConcedido(v15)) {
                        goto label_124;
                    }
                }
                catch(Throwable v0_2) {
                    goto label_250;
                }

                try {
                    v8_2.setValue(ActivationStatus.UNAVAILABLE);
                    v0_5 = new PairingResult(false, "Concede permiso de red local para buscar Wireless Debugging");
                    goto label_153;
                }
                catch(Throwable v0_2) {
                    goto label_104;
                }

                try {
                label_124:
                    v8_3 = WirelessBridge.INSTANCE;
                    v14_1 = ActivationManager.applicationContext;
                    if(v14_1 == null) {
                        goto label_127;
                    }

                    goto label_129;
                }
                catch(Throwable v0_2) {
                    goto label_250;
                }

                try {
                label_127:
                    Intrinsics.throwUninitializedPropertyAccessException(v9);
                    v14_1 = ((Context)v12);
                }
                catch(Throwable v0_2) {
                label_104:
                    v2 = v4_2;
                    goto label_72;
                }

                try {
                label_129:
                    v1_1.L$0 = SpillingKt.nullOutSpilledVariable(v13_1);
                    v1_1.L$1 = v2_3;
                    v1_1.L$2 = v4_2;
                    v1_1.I$0 = v0_3;
                    v1_1.I$1 = 0;
                    v1_1.label = v7;
                    v7_1 = v8_3.descubrirEndpointEmparejamiento(v14_1, ((Continuation)v1_1));
                    if(v7_1 != v3_1) {
                        goto label_139;
                    }
                }
                catch(Throwable v0_2) {
                label_250:
                    v2 = v4_2;
                    goto label_251;
                }

                return v3_1;
            label_139:
                v8 = v7_1;
                v7 = v0_3;
                v0_1 = v8;
                v8 = v2_3;
                v2 = v4_2;
                v4 = 0;
            label_145:
                if(v0_1 != null) {
                    goto label_155;
                }

                try {
                    ActivationManager._status.setValue(ActivationStatus.PAIRING_REQUIRED);
                    v0_5 = new PairingResult(false, "No se encontró el servicio de emparejamiento. Mantén abierta la pantalla del código WiFi");
                    v4_1 = v2;
                    goto label_153;
                }
                catch(Throwable v0_2) {
                label_42:
                }

            label_72:
                v1_2 = v12;
                goto label_252;
            label_153:
                v1_2 = v12;
                goto label_245;
                try {
                label_155:
                    KadbBridge v14_2 = KadbBridge.INSTANCE;
                    String v15_1 = ((Endpoint)v0_1).getHost();
                    int v12_1 = ((Endpoint)v0_1).getPort();
                    v1_1.L$0 = SpillingKt.nullOutSpilledVariable(v13_1);
                    v1_1.L$1 = SpillingKt.nullOutSpilledVariable(v8);
                    v1_1.L$2 = v2;
                    v1_1.L$3 = SpillingKt.nullOutSpilledVariable(v0_1);
                    v1_1.I$0 = v7;
                    v1_1.I$1 = v4;
                    v1_1.label = v6;
                    Object v5_1 = v14_2.emparejar(v15_1, v12_1, ((String)v8), ((Continuation)v1_1));
                    if(v5_1 == v3_1) {
                        return v3_1;
                    }

                    v6_1 = v0_1;
                    v0_1 = v5_1;
                label_173:
                    boolean v0_6 = ((Boolean)v0_1).booleanValue();
                    if(!v0_6) {
                        ActivationManager._status.setValue(ActivationStatus.PAIRING_REQUIRED);
                        v0_5 = new PairingResult(false, "No se pudo emparejar. Verifica el código de 6 dígitos");
                        goto label_217;
                    }

                    ActivationStorage v5_2 = ActivationManager.storage;
                    if(v5_2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(v10);
                        v5_2 = null;
                    }

                    v5_2.markKadbPaired();
                    ActivationManager._status.setValue(ActivationStatus.RECONNECTING);
                    WirelessBridge v5_3 = WirelessBridge.INSTANCE;
                    Context v12_2 = ActivationManager.applicationContext;
                    if(v12_2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(v9);
                        v12_2 = null;
                    }

                    v1_1.L$0 = SpillingKt.nullOutSpilledVariable(v13_1);
                    v1_1.L$1 = SpillingKt.nullOutSpilledVariable(v8);
                    v1_1.L$2 = v2;
                    v1_1.L$3 = SpillingKt.nullOutSpilledVariable(v6_1);
                    v1_1.I$0 = v7;
                    v1_1.I$1 = v4;
                    v1_1.Z$0 = v0_6;
                    v1_1.label = 4;
                    v0_1 = v5_3.descubrirEndpointConexion(v12_2, ((Continuation)v1_1));
                    if(v0_1 == v3_1) {
                        return v3_1;
                    }

                label_210:
                    if(v0_1 == null) {
                        ActivationManager._status.setValue(ActivationStatus.UNAVAILABLE);
                        v0_5 = new PairingResult(false, "Emparejado, pero no se encontró el servicio de conexión ADB");
                        goto label_217;
                    }

                    ActivationStorage v1_3 = ActivationManager.storage;
                    if(v1_3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(v10);
                        v1_3 = null;
                    }

                    v1_3.saveKadbConfiguration(((Endpoint)v0_1).getHost(), ((Endpoint)v0_1).getPort());
                    v0_6 = KadbBridge.INSTANCE.conectar(((Endpoint)v0_1).getHost(), ((Endpoint)v0_1).getPort());
                    MutableStateFlow v1_4 = ActivationManager._status;
                    ActivationStatus v3_2 = v0_6 ? ActivationStatus.ACTIVE_KADB : ActivationStatus.UNAVAILABLE;
                    v1_4.setValue(v3_2);
                    String v3_3 = v0_6 ? "Golden Core conectado mediante KADB" : "Se encontró ADB, pero Golden Core no pudo conectarse";
                    v0_5 = new PairingResult(v0_6, v3_3);
                label_217:
                    v4_1 = v2;
                    v1_2 = null;
                    goto label_245;
                }
                catch(Throwable v0_2) {
                }

            label_251:
                v1_2 = null;
            label_252:
                ((Mutex)v2_3).unlock(v1_2);
                throw v0_2;
            }
        }
        else if(v4 == 1) {
            v2_1 = v1_1.I$0;
            v4_1 = v1_1.L$2;
            v8 = v1_1.L$1;
            v13 = v1_1.L$0;
            ResultKt.throwOnFailure(v0_1);
            v0_3 = v2_1;
            v2 = v8;
            goto label_98;
        }
        else if(v4 == v7) {
            v2_1 = v1_1.I$1;
            v4 = v1_1.I$0;
            v7_1 = v1_1.L$2;
            v8 = v1_1.L$1;
            v13 = v1_1.L$0;
            try {
                ResultKt.throwOnFailure(v0_1);
                v16 = v4;
                v4 = v2_1;
                v2 = v7_1;
                v7 = v16;
                goto label_145;
            }
            catch(Throwable v0_2) {
            label_71:
                Mutex v2_2 = ((Mutex)v7);
                goto label_72;
            }
        }
        else if(v4 == v6) {
            v2_1 = v1_1.I$1;
            v4 = v1_1.I$0;
            v6_1 = v1_1.L$3;
            v7_1 = v1_1.L$2;
            v8 = v1_1.L$1;
            v13 = v1_1.L$0;
            try {
                ResultKt.throwOnFailure(v0_1);
                v16 = v4;
                v4 = v2_1;
                v2 = v7_1;
                v7 = v16;
                goto label_173;
            }
            catch(Throwable v0_2) {
                goto label_71;
            }
        }
        else if(v4 == v5) {
            v2 = v1_1.L$2;
            try {
                ResultKt.throwOnFailure(v0_1);
                goto label_210;
            }
            catch(Throwable v0_2) {
                goto label_42;
            }
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_245:
        v4_2.unlock(v1_2);
        return v0_5;
    }

    public final void refresh() {
        if(!ActivationManager.initialized) {
            return;
        }

        BuildersKt.launch$default(ActivationManager.scope, null, null, new ActivationManager$refresh$1(null), 3, null);
    }

    private final void refreshShizuku() {
        MutableStateFlow v1 = ActivationManager._status;
        ActivationStatus v0 = !ShizukuBridge.INSTANCE.servidorActivo() || !ShizukuBridge.INSTANCE.permisoConcedido() ? ActivationStatus.UNAVAILABLE : ActivationStatus.ACTIVE_SHIZUKU;
        v1.setValue(v0);
    }

    private final Object restoreKadb(Continuation arg9) {
        ActivationStorage v8_1;
        Continuation v0;
        if((arg9 instanceof ActivationManager$restoreKadb$1)) {
            v0 = arg9;
            int v2 = 0x80000000;
            if((((ActivationManager$restoreKadb$1)v0).label & v2) != 0) {
                ((ActivationManager$restoreKadb$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            ActivationManager$restoreKadb$1 v0_1 = new ActivationManager$restoreKadb$1(this, arg9);
        }

        Object v8 = ((ActivationManager$restoreKadb$1)v0).result;
        Object v9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int v1 = ((ActivationManager$restoreKadb$1)v0).label;
        String v3 = "storage";
        ActivationStorage v4 = null;
        if(v1 == 0) {
            ResultKt.throwOnFailure(v8);
            if(KadbBridge.INSTANCE.estaConectado()) {
                ActivationManager._status.setValue(ActivationStatus.ACTIVE_KADB);
                return Unit.INSTANCE;
            }
            else {
                v8_1 = ActivationManager.storage;
                if(v8_1 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v3);
                    v8_1 = v4;
                }

                KadbConfiguration v8_2 = v8_1.kadbConfiguration();
                ActivationStorage v1_1 = ActivationManager.storage;
                if(v1_1 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v3);
                    v1_1 = v4;
                }

                if(v1_1.isKadbPaired()) {
                    String v5 = ActivationManager.keyFilePath;
                    if(v5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("keyFilePath");
                        v5 = ((String)v4);
                    }

                    if(!new File(v5).isFile()) {
                        goto label_109;
                    }

                    MutableStateFlow v1_2 = ActivationManager._status;
                    v1_2.setValue(ActivationStatus.RECONNECTING);
                    if(v8_2 != null && (KadbBridge.INSTANCE.conectar(v8_2.getHost(), v8_2.getConnectPort()))) {
                        v1_2.setValue(ActivationStatus.ACTIVE_KADB);
                        return Unit.INSTANCE;
                    }

                    WirelessBridge v1_3 = WirelessBridge.INSTANCE;
                    Context v5_1 = ActivationManager.applicationContext;
                    if(v5_1 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
                        v5_1 = ((Context)v4);
                    }

                    ((ActivationManager$restoreKadb$1)v0).L$0 = SpillingKt.nullOutSpilledVariable(v8_2);
                    ((ActivationManager$restoreKadb$1)v0).label = 1;
                    v8 = v1_3.descubrirEndpointConexion(v5_1, v0);
                    if(v8 != v9) {
                        goto label_83;
                    }

                    return v9;
                }

                goto label_109;
            }
        }
        else if(v1 == 1) {
            ResultKt.throwOnFailure(v8);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_83:
        if(v8 == null) {
            ActivationManager._status.setValue(ActivationStatus.UNAVAILABLE);
            return Unit.INSTANCE;
        }

        ActivationStorage v9_1 = ActivationManager.storage;
        if(v9_1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v3);
        }
        else {
            v4 = v9_1;
        }

        v4.saveKadbConfiguration(((Endpoint)v8).getHost(), ((Endpoint)v8).getPort());
        MutableStateFlow v9_2 = ActivationManager._status;
        ActivationStatus v8_3 = KadbBridge.INSTANCE.conectar(((Endpoint)v8).getHost(), ((Endpoint)v8).getPort()) ? ActivationStatus.ACTIVE_KADB : ActivationStatus.UNAVAILABLE;
        v9_2.setValue(v8_3);
        return Unit.INSTANCE;
    label_109:
        v8_1 = ActivationManager.storage;
        if(v8_1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v3);
        }
        else {
            v4 = v8_1;
        }

        v4.clearKadbPairing();
        ActivationManager._status.setValue(ActivationStatus.PAIRING_REQUIRED);
        return Unit.INSTANCE;
    }

    public final void selectKadb(Context arg2) {
        Intrinsics.checkNotNullParameter(arg2, "context");
        this.initialize(arg2);
        ActivationStorage v2 = ActivationManager.storage;
        if(v2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storage");
            v2 = null;
        }

        v2.saveActiveMethod("KADB");
        this.refresh();
    }

    public final void selectShizuku(Context arg2) {
        Intrinsics.checkNotNullParameter(arg2, "context");
        this.initialize(arg2);
        ActivationStorage v2 = ActivationManager.storage;
        if(v2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storage");
            v2 = null;
        }

        v2.saveActiveMethod("SHIZUKU");
        this.refresh();
    }

    public final Object validateForStart(Continuation arg3) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ActivationManager$validateForStart$2(null), arg3);
    }
}

