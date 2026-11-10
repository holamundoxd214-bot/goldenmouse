package com.TryJeanPc.goldenmouse.zayonvisual;

import android.app.NotificationManager;
import android.os.Build$VERSION;
import android.widget.Toast;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts$RequestPermission;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.lifecycle.ViewModelProvider;
import com.TryJeanPc.goldenmouse.activation.ActivationManager;
import com.TryJeanPc.goldenmouse.activation.ActivationStatus;
import com.TryJeanPc.goldenmouse.bridge.ShizukuBridge;
import com.TryJeanPc.goldenmouse.bridge.WirelessBridge;
import com.TryJeanPc.goldenmouse.notification.GoldenPairingNotification;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\b\u0001\u0018\u0000 \"2\u00020\u0001:\u0001\"B7\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0012\u0010\b\u001A\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\n\u0010\u000BJ\u000E\u0010\u0011\u001A\u00020\u00062\u0006\u0010\u0012\u001A\u00020\u0013J\u0006\u0010\u0014\u001A\u00020\u0006J\u000E\u0010\u0015\u001A\u00020\u00062\u0006\u0010\u0012\u001A\u00020\u0013J\u0016\u0010\u0016\u001A\u00020\u00072\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0017\u001A\u00020\u0013J\u0010\u0010\u0018\u001A\u00020\u00072\u0006\u0010\u0017\u001A\u00020\u0013H\u0002J\u0010\u0010\u0019\u001A\u00020\u00072\u0006\u0010\u001A\u001A\u00020\u0006H\u0002J\b\u0010\u001B\u001A\u00020\u0007H\u0002J\b\u0010\u001C\u001A\u00020\u0007H\u0002J\u0010\u0010\u001D\u001A\u00020\u00072\u0006\u0010\u001E\u001A\u00020\tH\u0002J\b\u0010\u001F\u001A\u00020\u0007H\u0002J\u0010\u0010 \u001A\u00020\u00072\u0006\u0010!\u001A\u00020\u0006H\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\b\u001A\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00060\u000FX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00060\u000FX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2={"Lcom/TryJeanPc/goldenmouse/zayonvisual/GoldenActivationActions;", "", "activity", "Landroidx/activity/ComponentActivity;", "feedback", "Lkotlin/Function1;", "", "", "loading", "", "<init>", "(Landroidx/activity/ComponentActivity;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "coreCheck", "Lcom/TryJeanPc/goldenmouse/zayonvisual/GoldenActivationCheck;", "localPermission", "Landroidx/activity/result/ActivityResultLauncher;", "notificationPermission", "description", "method", "", "coreStatus", "status", "execute", "step", "executeShizuku", "openShizuku", "instruction", "requestShizukuPermission", "activateShizuku", "checkCore", "kadb", "startWirelessPairing", "message", "text", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GoldenActivationActions {
    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\t"}, d2={"Lcom/TryJeanPc/goldenmouse/zayonvisual/GoldenActivationActions$Companion;", "", "<init>", "()V", "METHOD_NAMES", "", "", "getMETHOD_NAMES", "()Ljava/util/List;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final List getMETHOD_NAMES() {
            return GoldenActivationActions.METHOD_NAMES;
        }
    }

    @Metadata(k=3, mv={2, 2, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[ActivationStatus.values().length];
            try {
                v0[ActivationStatus.UNCONFIGURED.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[ActivationStatus.PAIRING_REQUIRED.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[ActivationStatus.PAIRING.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_15:
                            v0[ActivationStatus.RECONNECTING.ordinal()] = 4;
                            goto label_19;
                        }
                        catch(NoSuchFieldError ) {
                            try {
                            label_19:
                                v0[ActivationStatus.ACTIVE_KADB.ordinal()] = 5;
                                goto label_23;
                            }
                            catch(NoSuchFieldError ) {
                                try {
                                label_23:
                                    v0[ActivationStatus.ACTIVE_SHIZUKU.ordinal()] = 6;
                                    goto label_27;
                                }
                                catch(NoSuchFieldError ) {
                                    try {
                                    label_27:
                                        v0[ActivationStatus.UNAVAILABLE.ordinal()] = 7;
                                        goto label_31;
                                    }
                                    catch(NoSuchFieldError ) {
                                    label_31:
                                        WhenMappings.$EnumSwitchMapping$0 = v0;
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final List METHOD_NAMES;
    private final ComponentActivity activity;
    private final GoldenActivationCheck coreCheck;
    private final Function1 feedback;
    private final Function1 loading;
    private final ActivityResultLauncher localPermission;
    private final ActivityResultLauncher notificationPermission;

    static {
        GoldenActivationActions.Companion = new Companion(null);
        GoldenActivationActions.$stable = 8;
        GoldenActivationActions.METHOD_NAMES = CollectionsKt.listOf(new String[]{"Shizuku", "Inalámbrica", "Root", "PC / Cable"});
    }

    public GoldenActivationActions(ComponentActivity arg7, Function1 arg8, Function1 arg9) {
        Intrinsics.checkNotNullParameter(arg7, "activity");
        Intrinsics.checkNotNullParameter(arg8, "feedback");
        Intrinsics.checkNotNullParameter(arg9, "loading");
        super();
        this.activity = arg7;
        this.feedback = arg8;
        this.loading = arg9;
        this.coreCheck = new ViewModelProvider(arg7).get(GoldenActivationCheck.class);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(arg7), null, null, new Function2(null) {
            int label;

            public final Continuation create(Object arg1, Continuation arg2) {
                return new com.TryJeanPc.goldenmouse.zayonvisual.GoldenActivationActions$1(GoldenActivationActions.this, arg2);
            }

            public Object invoke(Object arg1, Object arg2) {
                return this.invoke(((CoroutineScope)arg1), ((Continuation)arg2));
            }

            public final Object invoke(CoroutineScope arg1, Continuation arg2) {
                return this.create(arg1, arg2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object arg7) {
                Object v0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int v1 = this.label;
                if(v1 == 0) {
                    ResultKt.throwOnFailure(arg7);
                    ComponentActivity v7 = GoldenActivationActions.access$getActivity$p(GoldenActivationActions.this);
                    State v1_1 = State.STARTED;
                    com.TryJeanPc.goldenmouse.zayonvisual.GoldenActivationActions$1$1 v3 = new Function2(null) {
                        int label;

                        public final Continuation create(Object arg1, Continuation arg2) {
                            return new com.TryJeanPc.goldenmouse.zayonvisual.GoldenActivationActions$1$1(GoldenActivationActions.this, arg2);
                        }

                        public Object invoke(Object arg1, Object arg2) {
                            return this.invoke(((CoroutineScope)arg1), ((Continuation)arg2));
                        }

                        public final Object invoke(CoroutineScope arg1, Continuation arg2) {
                            return this.create(arg1, arg2).invokeSuspend(Unit.INSTANCE);
                        }

                        public final Object invokeSuspend(Object arg5) {
                            Object v0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int v1 = this.label;
                            if(v1 == 0) {
                                ResultKt.throwOnFailure(arg5);
                                StateFlow v5 = GoldenActivationActions.access$getCoreCheck$p(GoldenActivationActions.this).getStatus();
                                com.TryJeanPc.goldenmouse.zayonvisual.GoldenActivationActions$1$1$1 v1_1 = new FlowCollector() {
                                    public final Object emit(GoldenActivationCheckState arg2, Continuation arg3) {
                                        GoldenActivationActions.access$getLoading$p(GoldenActivationActions.this).invoke(Boxing.boxBoolean(arg2.getBusy()));
                                        String v2 = arg2.getMessage();
                                        if(v2 != null) {
                                            GoldenActivationActions.access$getFeedback$p(GoldenActivationActions.this).invoke(v2);
                                        }

                                        return Unit.INSTANCE;
                                    }

                                    public Object emit(Object arg1, Continuation arg2) {
                                        return this.emit(((GoldenActivationCheckState)arg1), arg2);
                                    }
                                };
                                this.label = 1;
                                if(v5.collect(((FlowCollector)v1_1), this) == v0) {
                                    return v0;
                                }
                            }
                            else if(v1 != 1) {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                            else {
                                ResultKt.throwOnFailure(arg5);
                            }

                            throw new KotlinNothingValueException();
                        }
                    };
                    this.label = 1;
                    if(RepeatOnLifecycleKt.repeatOnLifecycle(((LifecycleOwner)v7), v1_1, ((Function2)v3), this) == v0) {
                        return v0;
                    }
                }
                else if(v1 == 1) {
                    ResultKt.throwOnFailure(arg7);
                }
                else {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }

                return Unit.INSTANCE;
            }
        }, 3, null);
        this.localPermission = arg7.registerForActivityResult(new RequestPermission(), new GoldenActivationActions$$ExternalSyntheticLambda1(this));
        this.notificationPermission = arg7.registerForActivityResult(new RequestPermission(), new GoldenActivationActions$$ExternalSyntheticLambda2(this));
    }

    public static final ComponentActivity access$getActivity$p(GoldenActivationActions arg0) {
        return arg0.activity;
    }

    public static final GoldenActivationCheck access$getCoreCheck$p(GoldenActivationActions arg0) {
        return arg0.coreCheck;
    }

    public static final Function1 access$getFeedback$p(GoldenActivationActions arg0) {
        return arg0.feedback;
    }

    public static final Function1 access$getLoading$p(GoldenActivationActions arg0) {
        return arg0.loading;
    }

    public static final List access$getMETHOD_NAMES$cp() {
        return GoldenActivationActions.METHOD_NAMES;
    }

    private final void activateShizuku() {
        ActivationManager.INSTANCE.selectShizuku(this.activity);
        if(!ShizukuBridge.INSTANCE.servidorActivo()) {
            this.message("Shizuku está apagado.");
            return;
        }

        if(!ShizukuBridge.INSTANCE.permisoConcedido()) {
            this.message("Primero concede permiso a Golden Mouse.");
            return;
        }

        this.checkCore(false);
    }

    private final void checkCore(boolean arg1) {
        this.coreCheck.check(arg1);
    }

    public final String coreStatus() {
        switch(WhenMappings.$EnumSwitchMapping$0[ActivationManager.INSTANCE.getStatus().getValue().ordinal()]) {
            case 1: {
                return "SIN CONFIGURAR";
            }
            case 2: {
                return "REQUIERE EMPAREJAR";
            }
            case 3: {
                return "EMPAREJANDO";
            }
            case 4: {
                return "RECONECTANDO";
            }
            case 5: {
                return "ACTIVADO · KADB";
            }
            case 6: {
                return "ACTIVADO · SHIZUKU";
            }
            case 7: {
                return "NO DISPONIBLE";
            }
        }

        throw new NoWhenBranchMatchedException();
        return "EMPAREJANDO";
    }

    public final String description(int arg1) {
        if(arg1 != 1) {
            if(arg1 != 2) {
                if(arg1 != 3) {
                    return "Inicia Shizuku, concede el permiso del sistema y comprueba Golden Core.";
                }

                return "PC / Cable no tiene un activador implementado en esta versión. Usa Shizuku.";
            }

            return "Root no tiene acciones de activación implementadas en esta versión. Usa Shizuku.";
        }

        return "Flujo KADB existente, sin validación física en esta migración. Android 11+: el código se envía desde la notificación Golden Core.";
    }

    public final void execute(int arg2, int arg3) {
        String v2_1;
        if(this.coreCheck.getStatus().getValue().getBusy()) {
        }
        else if(arg2 == 0) {
            goto label_32;
        }
        else if(arg2 != 1) {
        }
        else if(arg3 == 1) {
            goto label_23;
        }
        else if(arg3 != 2) {
            if(arg3 != 3) {
                return;
            }

            goto label_16;
        }
        else {
            goto label_21;
        }

        return;
        try {
        label_16:
            ActivationManager.INSTANCE.selectKadb(this.activity);
            this.checkCore(true);
            return;
        label_21:
            this.startWirelessPairing();
            return;
        label_23:
            v2_1 = WirelessBridge.INSTANCE.abrirEmparejamiento(this.activity) ? "Abriendo depuración inalámbrica. Vuelve a Golden al terminar." : "No se pudo abrir la configuración inalámbrica.";
            this.message(v2_1);
            return;
        label_32:
            this.executeShizuku(arg3);
            return;
        }
        catch(Exception v2) {
            v2_1 = v2.getMessage();
            if(v2_1 == null) {
                v2_1 = "No se pudo completar la acción. Revisa los requisitos e inténtalo de nuevo.";
            }

            this.message(v2_1);
            return;
        }
    }

    private final void executeShizuku(int arg3) {
        if(arg3 != 1) {
            if(arg3 != 2) {
                if(arg3 != 3) {
                    return;
                }

                this.activateShizuku();
                return;
            }

            this.requestShizukuPermission();
            return;
        }

        ActivationManager.INSTANCE.selectShizuku(this.activity);
        if(ShizukuBridge.INSTANCE.servidorActivo()) {
            this.message("Servidor Shizuku activo · " + ShizukuBridge.INSTANCE.modoServidor());
            return;
        }

        this.openShizuku("Inicia Shizuku y vuelve a Golden Mouse.");
    }

    static final void localPermission$lambda$0(GoldenActivationActions arg0, boolean arg1) {
        if(arg1) {
            arg0.startWirelessPairing();
            return;
        }

        arg0.message("Permiso de red local denegado. No se inició el emparejamiento.");
    }

    private final void message(String arg2) {
        if(!this.activity.isDestroyed()) {
            if(this.activity.isFinishing()) {
            }
            else {
                this.feedback.invoke(arg2);
                Toast.makeText(this.activity, ((CharSequence)arg2), 1).show();
            }
        }
    }

    static final void notificationPermission$lambda$1(GoldenActivationActions arg0, boolean arg1) {
        if(arg1) {
            arg0.startWirelessPairing();
            return;
        }

        arg0.message("Notificaciones denegadas. Habilítalas en Ajustes para utilizar el flujo de emparejamiento existente.");
    }

    private final void openShizuku(String arg3) {
        if(ShizukuBridge.INSTANCE.abrirShizuku(this.activity)) {
        }
        else {
            arg3 = "Shizuku no está instalado o Android no permitió abrirlo.";
        }

        this.message(arg3);
    }

    private final void requestShizukuPermission() {
        ActivationManager.INSTANCE.selectShizuku(this.activity);
        if(!ShizukuBridge.INSTANCE.servidorActivo()) {
            this.message("Primero inicia Shizuku. No se solicitó ningún permiso.");
            return;
        }

        ShizukuBridge.INSTANCE.solicitarPermiso(new GoldenActivationActions$$ExternalSyntheticLambda0(this));
    }

    static final Unit requestShizukuPermission$lambda$2(GoldenActivationActions arg1, boolean arg2) {
        ActivationManager.INSTANCE.refresh();
        String v2 = arg2 ? "Permiso Shizuku concedido. Pulsa ACTIVAR para comprobar Golden Core." : "Permiso Shizuku no concedido. Revisa la autorización de Golden en Shizuku y vuelve a intentar.";
        arg1.message(v2);
        return Unit.INSTANCE;
    }

    private final void startWirelessPairing() {
        String v1;
        if(!WirelessBridge.INSTANCE.esCompatible()) {
            this.message("La depuración inalámbrica requiere Android 11 o superior.");
            return;
        }

        if(Build$VERSION.SDK_INT >= 37) {
            v1 = "android.permission.ACCESS_LOCAL_NETWORK";
            if(this.activity.checkSelfPermission(v1) != 0) {
                this.localPermission.launch(v1);
                return;
            }
        }

        if(Build$VERSION.SDK_INT >= 33) {
            v1 = "android.permission.POST_NOTIFICATIONS";
            if(this.activity.checkSelfPermission(v1) != 0) {
                this.notificationPermission.launch(v1);
                return;
            }
        }

        if(!this.activity.getSystemService(NotificationManager.class).areNotificationsEnabled()) {
            this.message("Las notificaciones están desactivadas. Habilítalas en Ajustes para emparejar desde Golden Core.");
            return;
        }

        GoldenPairingNotification.INSTANCE.mostrar(this.activity);
        String v0 = WirelessBridge.INSTANCE.abrirCodigoVinculacion(this.activity) ? "Abre Emparejar con código y responde en la notificación Golden Core." : "No se pudo abrir el código. Abre la depuración inalámbrica en Ajustes; la notificación sigue disponible.";
        this.message(v0);
    }

    public final String status(int arg4) {
        if(arg4 != 1) {
            if(arg4 != 2 && arg4 != 3) {
                String v4 = ShizukuBridge.INSTANCE.modoServidor();
                String v0 = ShizukuBridge.INSTANCE.permisoConcedido() ? "CONCEDIDO" : "PENDIENTE";
                return "Servidor: " + v4 + " · Permiso: " + v0 + " · Core: " + this.coreStatus();
            }

            return "NO DISPONIBLE · SIN IMPLEMENTACIÓN";
        }

        arg4 = WhenMappings.$EnumSwitchMapping$0[ActivationManager.INSTANCE.getStatus().getValue().ordinal()];
        if(arg4 != 5) {
            if(arg4 != 6) {
                return "KADB: " + this.coreStatus();
            }

            return "KADB NO SELECCIONADO · Shizuku activo";
        }

        return "KADB CONECTADO · Entrada física sin comprobar";
    }
}

