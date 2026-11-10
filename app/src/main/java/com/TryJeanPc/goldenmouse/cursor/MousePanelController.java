package com.TryJeanPc.goldenmouse.cursor;

import android.app.AlertDialog$Builder;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface$OnClickListener;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.text.InputFilter$LengthFilter;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import com.TryJeanPc.goldenmouse.R$id;
import com.TryJeanPc.goldenmouse.engine.GoldenCoreController;
import com.TryJeanPc.goldenmouse.input.InputDeviceStatus;
import com.TryJeanPc.goldenmouse.input.InputEvent$Scroll;
import com.TryJeanPc.goldenmouse.input.InputSnapshot;
import com.TryJeanPc.goldenmouse.input.InputState;
import com.TryJeanPc.goldenmouse.input.MousePollingSelection;
import com.TryJeanPc.goldenmouse.service.SessionOverlayWindowsKt;
import com.TryJeanPc.goldenmouse.ui.VisualVisibilityObserver;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job$DefaultImpls;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

@Metadata(d1={"\u0000\u009E\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u001A\u0010\b\u001A\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u000B\u0018\u00010\n0\t\u0012\f\u0010\f\u001A\b\u0012\u0004\u0012\u00020\r0\t¢\u0006\u0004\b\u000E\u0010\u000FJ\u000E\u0010(\u001A\u00020\r2\u0006\u0010)\u001A\u00020\u001CJ\b\u0010*\u001A\u00020\rH\u0002J\u000E\u0010+\u001A\u00020\r2\u0006\u0010,\u001A\u00020\u0016J\u0006\u0010-\u001A\u00020\rJ\u0006\u0010.\u001A\u00020\rJ\u001E\u0010/\u001A\u00020\r2\u0006\u00100\u001A\u0002012\u0006\u00102\u001A\u00020\"2\u0006\u00103\u001A\u00020\"J\u0010\u00104\u001A\u00020\r2\u0006\u00105\u001A\u000206H\u0002J\b\u00107\u001A\u00020\rH\u0002J\u0014\u00108\u001A\u00020\r*\u0002092\u0006\u00105\u001A\u00020:H\u0002J\b\u0010;\u001A\u00020\rH\u0002J\b\u0010<\u001A\u00020\rH\u0002J\b\u0010=\u001A\u00020\rH\u0002J\u001A\u0010>\u001A\u00020\r2\u0006\u0010?\u001A\u00020@2\b\u0010A\u001A\u0004\u0018\u00010:H\u0002J\u0018\u0010B\u001A\u00020\r2\u0006\u0010C\u001A\u00020:2\u0006\u0010D\u001A\u00020:H\u0002J\u0010\u0010E\u001A\u00020\r2\u0006\u0010F\u001A\u00020\u001AH\u0002J\u0010\u0010G\u001A\u00020\r2\u0006\u0010D\u001A\u00020:H\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\b\u001A\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u000B\u0018\u00010\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001A\b\u0012\u0004\u0012\u00020\r0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001A\n \u0012*\u0004\u0018\u00010\u00110\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001A\u0004\u0018\u00010\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001A\u0004\u0018\u00010\u0018X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001A\u0004\u0018\u00010\u001AX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001B\u001A\u00020\u001CX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001D\u001A\u00020\u001CX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001E\u001A\u00020\u001FX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010 \u001A\u0016\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\"\u0018\u00010!X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010#\u001A\u0004\u0018\u00010$X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010%\u001A\u00020\u001CX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010&\u001A\u0004\u0018\u00010\'X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006H"}, d2={"Lcom/TryJeanPc/goldenmouse/cursor/MousePanelController;", "", "context", "Landroid/content/Context;", "core", "Lcom/TryJeanPc/goldenmouse/engine/GoldenCoreController;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "hotspot", "Lkotlin/Function0;", "Lkotlin/Pair;", "", "applyVisualSettings", "", "<init>", "(Landroid/content/Context;Lcom/TryJeanPc/goldenmouse/engine/GoldenCoreController;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "prefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "profiles", "Lcom/TryJeanPc/goldenmouse/cursor/MouseProfileStore;", "root", "Landroid/view/View;", "monitor", "Lkotlinx/coroutines/Job;", "dialog", "Landroid/app/AlertDialog;", "applying", "", "busy", "wheel", "Lcom/TryJeanPc/goldenmouse/cursor/WheelMotion;", "scrollContext", "Lkotlin/Triple;", "", "pollingControls", "Lcom/TryJeanPc/goldenmouse/cursor/MousePollingControls;", "sessionVisible", "visibilityObserver", "Lcom/TryJeanPc/goldenmouse/ui/VisualVisibilityObserver;", "setSessionVisible", "visible", "reconcileMonitor", "open", "view", "close", "destroy", "onScroll", "event", "Lcom/TryJeanPc/goldenmouse/input/InputEvent$Scroll;", "sessionId", "modeEpoch", "applyPolling", "value", "Lcom/TryJeanPc/goldenmouse/input/MousePollingSelection;", "refresh", "setTextIfChanged", "Landroid/widget/TextView;", "", "showProfiles", "saveDialog", "loadDialog", "applyProfile", "profile", "Lcom/TryJeanPc/goldenmouse/cursor/MouseProfileStore$Profile;", "name", "message", "title", "text", "show", "next", "toast", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class MousePanelController {
    public static final int $stable = 8;
    private final Function0 applyVisualSettings;
    private boolean applying;
    private boolean busy;
    private final Context context;
    private final GoldenCoreController core;
    private AlertDialog dialog;
    private final Function0 hotspot;
    private Job monitor;
    private MousePollingControls pollingControls;
    private final SharedPreferences prefs;
    private final MouseProfileStore profiles;
    private volatile View root;
    private final CoroutineScope scope;
    private Triple scrollContext;
    private boolean sessionVisible;
    private VisualVisibilityObserver visibilityObserver;
    private final WheelMotion wheel;

    static {
    }

    public MousePanelController(Context arg2, GoldenCoreController arg3, CoroutineScope arg4, Function0 arg5, Function0 arg6) {
        Intrinsics.checkNotNullParameter(arg2, "context");
        Intrinsics.checkNotNullParameter(arg3, "core");
        Intrinsics.checkNotNullParameter(arg4, "scope");
        Intrinsics.checkNotNullParameter(arg5, "hotspot");
        Intrinsics.checkNotNullParameter(arg6, "applyVisualSettings");
        super();
        this.context = arg2;
        this.core = arg3;
        this.hotspot = arg5;
        this.applyVisualSettings = arg6;
        this.scope = CoroutineScopeKt.CoroutineScope(arg4.getCoroutineContext().plus(SupervisorKt.SupervisorJob(arg4.getCoroutineContext().get(Job.Key))));
        this.prefs = arg2.getSharedPreferences("mouse_settings", 0);
        SharedPreferences v2 = arg2.getSharedPreferences("mouse_profiles", 0);
        Intrinsics.checkNotNullExpressionValue(v2, "getSharedPreferences(...)");
        this.profiles = new MouseProfileStore(v2);
        this.wheel = new WheelMotion();
        this.sessionVisible = true;
    }

    public static final void access$applyPolling(MousePanelController arg0, MousePollingSelection arg1) {
        arg0.applyPolling(arg1);
    }

    public static final Function0 access$getApplyVisualSettings$p(MousePanelController arg0) {
        return arg0.applyVisualSettings;
    }

    public static final boolean access$getApplying$p(MousePanelController arg0) {
        return arg0.applying;
    }

    public static final boolean access$getBusy$p(MousePanelController arg0) {
        return arg0.busy;
    }

    public static final Context access$getContext$p(MousePanelController arg0) {
        return arg0.context;
    }

    public static final GoldenCoreController access$getCore$p(MousePanelController arg0) {
        return arg0.core;
    }

    public static final AlertDialog access$getDialog$p(MousePanelController arg0) {
        return arg0.dialog;
    }

    public static final Function0 access$getHotspot$p(MousePanelController arg0) {
        return arg0.hotspot;
    }

    public static final MousePollingControls access$getPollingControls$p(MousePanelController arg0) {
        return arg0.pollingControls;
    }

    public static final SharedPreferences access$getPrefs$p(MousePanelController arg0) {
        return arg0.prefs;
    }

    public static final MouseProfileStore access$getProfiles$p(MousePanelController arg0) {
        return arg0.profiles;
    }

    public static final View access$getRoot$p(MousePanelController arg0) {
        return arg0.root;
    }

    public static final Triple access$getScrollContext$p(MousePanelController arg0) {
        return arg0.scrollContext;
    }

    public static final boolean access$getSessionVisible$p(MousePanelController arg0) {
        return arg0.sessionVisible;
    }

    public static final VisualVisibilityObserver access$getVisibilityObserver$p(MousePanelController arg0) {
        return arg0.visibilityObserver;
    }

    public static final WheelMotion access$getWheel$p(MousePanelController arg0) {
        return arg0.wheel;
    }

    public static final void access$refresh(MousePanelController arg0) {
        arg0.refresh();
    }

    public static final void access$setApplying$p(MousePanelController arg0, boolean arg1) {
        arg0.applying = arg1;
    }

    public static final void access$setBusy$p(MousePanelController arg0, boolean arg1) {
        arg0.busy = arg1;
    }

    public static final void access$setScrollContext$p(MousePanelController arg0, Triple arg1) {
        arg0.scrollContext = arg1;
    }

    public static final void access$toast(MousePanelController arg0, String arg1) {
        arg0.toast(arg1);
    }

    private final void applyPolling(MousePollingSelection arg9) {
        if(this.busy) {
            return;
        }

        this.busy = true;
        MousePollingControls v1 = this.pollingControls;
        if(v1 != null) {
            v1.setBusy(true);
        }

        BuildersKt.launch$default(this.scope, null, null, new MousePanelController$applyPolling$1(this, arg9, null), 3, null);
    }

    private final void applyProfile(Profile arg8, String arg9) {
        this.busy = true;
        MousePollingControls v1 = this.pollingControls;
        if(v1 != null) {
            v1.setBusy(true);
        }

        this.wheel.reset();
        BuildersKt.launch$default(this.scope, null, null, new MousePanelController$applyProfile$1(this, arg9, arg8, null), 3, null);
    }

    public final void close() {
        MousePollingControls v0 = null;
        this.pollingControls = v0;
        this.root = ((View)v0);
        VisualVisibilityObserver v1 = this.visibilityObserver;
        if(v1 != null) {
            v1.close();
        }

        this.visibilityObserver = ((VisualVisibilityObserver)v0);
        Job v1_1 = this.monitor;
        if(v1_1 != null) {
            DefaultImpls.cancel$default(v1_1, ((CancellationException)v0), 1, v0);
        }

        this.monitor = ((Job)v0);
        AlertDialog v1_2 = this.dialog;
        if(v1_2 != null) {
            v1_2.dismiss();
        }

        this.dialog = ((AlertDialog)v0);
        this.wheel.reset();
        this.scrollContext = ((Triple)v0);
    }

    public final void destroy() {
        this.close();
        CoroutineScopeKt.cancel$default(this.scope, null, 1, null);
    }

    private final void loadDialog() {
        Context v2_1;
        List v0 = this.profiles.names();
        if(v0.isEmpty()) {
            this.toast("Todavía no hay perfiles guardados");
            return;
        }

        View v2 = this.root;
        if(v2 != null) {
            v2_1 = v2.getContext();
            if(v2_1 == null) {
                goto label_12;
            }
        }
        else {
        label_12:
            v2_1 = this.context;
        }

        AlertDialog v0_1 = new AlertDialog$Builder(v2_1).setTitle("Cargar perfil").setItems(v0.toArray(new String[0]), new MousePanelController$$ExternalSyntheticLambda2(this, v0)).setNegativeButton("Cancelar", null).create();
        Intrinsics.checkNotNullExpressionValue(v0_1, "create(...)");
        this.show(v0_1);
    }

    static final void loadDialog$lambda$12(MousePanelController arg1, List arg2, DialogInterface arg3, int arg4) {
        Profile v3 = arg1.profiles.load(arg2.get(arg4));
        if(v3 == null) {
            arg1.toast("El perfil no es válido");
            return;
        }

        arg1.applyProfile(v3, arg2.get(arg4));
    }

    private final void message(String arg3, String arg4) {
        Context v1_1;
        View v1 = this.root;
        if(v1 != null) {
            v1_1 = v1.getContext();
            if(v1_1 == null) {
                goto label_5;
            }
        }
        else {
        label_5:
            v1_1 = this.context;
        }

        AlertDialog v3 = new AlertDialog$Builder(v1_1).setTitle(((CharSequence)arg3)).setMessage(((CharSequence)arg4)).setPositiveButton("Cerrar", null).create();
        Intrinsics.checkNotNullExpressionValue(v3, "create(...)");
        this.show(v3);
    }

    public final void onScroll(Scroll arg14, long arg15, long arg17) {
        Intrinsics.checkNotNullParameter(arg14, "event");
        View v3 = this.root;
        if(v3 == null) {
            return;
        }

        BuildersKt.launch$default(this.scope, Dispatchers.getMain().getImmediate(), null, new MousePanelController$onScroll$1(this, v3, arg17, arg15, MouseWheelSettings.INSTANCE.getRevision(), arg14, null), 2, null);
    }

    public final void open(View arg4) {
        Intrinsics.checkNotNullParameter(arg4, "view");
        this.close();
        this.root = arg4;
        View v0 = arg4.findViewById(id.seekSensibilidadRueda);
        ((SeekBar)v0).setProgress(MouseWheelSettings.INSTANCE.getPercent());
        ((SeekBar)v0).setOnSeekBarChangeListener(new MousePanelController$open$1$1(arg4, this));
        arg4.findViewById(id.txtSensibilidadRueda).setText(MouseWheelSettings.INSTANCE.getPercent() + "%");
        arg4.findViewById(id.seekSensibilidadRueda).setOnLongClickListener(new MousePanelController$$ExternalSyntheticLambda3(this));
        MousePollingControls v0_1 = new MousePollingControls(arg4, new MousePanelController$$ExternalSyntheticLambda4(this), new MousePanelController$open$4(this));
        v0_1.setBusy(this.busy);
        this.pollingControls = v0_1;
        arg4.findViewById(id.btnGuardarPerfil).setOnClickListener(new MousePanelController$$ExternalSyntheticLambda5(this));
        arg4.findViewById(id.btnRestablecerMouse).setOnClickListener(new MousePanelController$$ExternalSyntheticLambda6(this, arg4));
        arg4 = arg4.findViewById(id.panelContainer);
        Intrinsics.checkNotNullExpressionValue(arg4, "findViewById(...)");
        this.visibilityObserver = new VisualVisibilityObserver(((ViewGroup)arg4), new MousePanelController$$ExternalSyntheticLambda7(this));
        this.reconcileMonitor();
    }

    static final boolean open$lambda$1(MousePanelController arg1, View arg2) {
        arg1.message("Sensibilidad de rueda", "Ajusta el desplazamiento de este panel. La rueda mapeada conserva sus acciones. El backend actual no permite enviar rueda normal a otras aplicaciones.");
        return 1;
    }

    static final MousePollingSelection open$lambda$2(MousePanelController arg0) {
        return arg0.core.getMousePollingSelection();
    }

    static final void open$lambda$4(MousePanelController arg0, View arg1) {
        if(!arg0.busy) {
            arg0.showProfiles();
        }
    }

    static final void open$lambda$6(MousePanelController arg1, View arg2, View arg3) {
        if(!arg1.busy) {
            AlertDialog v2 = new AlertDialog$Builder(arg2.getContext()).setTitle("Restablecer mouse").setMessage("Restaurar cursor predeterminado, tamaño y transparencia al 100 %, velocidad y rueda al 50 %, frecuencia Nativo y aceleración desactivada. Se conservan la galería y los perfiles guardados.").setNegativeButton("Cancelar", null).setPositiveButton("Restablecer", new MousePanelController$$ExternalSyntheticLambda8(arg1)).create();
            Intrinsics.checkNotNullExpressionValue(v2, "create(...)");
            arg1.show(v2);
        }
    }

    static final void open$lambda$6$lambda$5(MousePanelController arg10, DialogInterface arg11, int arg12) {
        arg10.applyProfile(new Profile(null, 0, 0, 0, false, 0, null, 0x7F, null), null);
    }

    static final Unit open$lambda$7(MousePanelController arg0, boolean arg1) {
        arg0.reconcileMonitor();
        return Unit.INSTANCE;
    }

    private final void reconcileMonitor() {
        View v0 = this.root;
        Continuation v3 = null;
        if((this.sessionVisible) && v0 != null) {
            VisualVisibilityObserver v1 = this.visibilityObserver;
            if(v1 != null && (v1.getVisible())) {
                Job v1_1 = this.monitor;
                if(v1_1 != null && (v1_1.isActive())) {
                    return;
                }

                this.monitor = BuildersKt.launch$default(this.scope, null, null, new MousePanelController$reconcileMonitor$1(this, v0, v3), 3, null);
                return;
            }
        }

        Job v0_1 = this.monitor;
        if(v0_1 != null) {
            DefaultImpls.cancel$default(v0_1, ((CancellationException)v3), 1, v3);
        }

        this.monitor = ((Job)v3);
    }

    private final void refresh() {
        String v1_2;
        View v0 = this.root;
        if(v0 == null) {
        }
        else if(this.sessionVisible) {
            VisualVisibilityObserver v1 = this.visibilityObserver;
            if(v1 != null && (v1.getVisible())) {
                Object v1_1 = this.core.getInputSnapshotFlow().getValue();
                InputDeviceStatus v2 = ((InputSnapshot)v1_1).getMouse();
                v0 = v0.findViewById(id.txtEstadoMouse);
                Intrinsics.checkNotNullExpressionValue(v0, "findViewById(...)");
                if(v2.getConnected()) {
                    v1_2 = "CONECTADO";
                }
                else if(((InputSnapshot)v1_1).getState() == InputState.WAITING) {
                    v1_2 = "BUSCANDO";
                }
                else {
                    v1_2 = "SIN CAPTURA";
                }

                this.setTextIfChanged(((TextView)v0), v1_2);
            }
        }
    }

    private final void saveDialog() {
        View v0 = this.root;
        if(v0 == null) {
            return;
        }

        EditText v1 = new EditText(v0.getContext());
        v1.setSingleLine();
        v1.setHint("Nombre del perfil");
        v1.setFilters(new InputFilter$LengthFilter[]{new InputFilter$LengthFilter(0x40)});
        v1.setText(this.prefs.getString("perfil_mouse_activo", "Mouse"));
        AlertDialog v0_1 = new AlertDialog$Builder(v0.getContext()).setTitle("Guardar perfil").setMessage("Se guardan los ajustes actuales. Un nombre existente reemplaza ese perfil.").setView(v1).setNegativeButton("Cancelar", null).setPositiveButton("Guardar", null).create();
        Intrinsics.checkNotNull(v0_1);
        this.show(v0_1);
        v0_1.getButton(-1).setOnClickListener(new MousePanelController$$ExternalSyntheticLambda9(v1, v0_1, this));
    }

    static final void saveDialog$lambda$11(EditText arg6, AlertDialog arg7, MousePanelController arg8, View arg9) {
        String v9 = StringsKt.trim(arg6.getText().toString()).toString();
        if(v9.length() == 0) {
            arg6.setError("Escribe un nombre");
            return;
        }

        arg7.dismiss();
        arg8.busy = true;
        BuildersKt.launch$default(arg8.scope, null, null, new MousePanelController$saveDialog$1$1(arg8, v9, null), 3, null);
    }

    public final void setSessionVisible(boolean arg1) {
        this.sessionVisible = arg1;
        this.reconcileMonitor();
    }

    private final void setTextIfChanged(TextView arg1, String arg2) {
        if(!Intrinsics.areEqual(arg1.getText().toString(), arg2)) {
            arg1.setText(((CharSequence)arg2));
        }
    }

    private final void show(AlertDialog arg3) {
        AlertDialog v0 = this.dialog;
        if(v0 != null) {
            v0.dismiss();
        }

        this.dialog = arg3;
        Window v0_1 = arg3.getWindow();
        if(v0_1 != null) {
            v0_1.setType(0x7F6);
        }

        arg3.setOnDismissListener(new MousePanelController$$ExternalSyntheticLambda1(this, arg3));
        SessionOverlayWindowsKt.showSessionDialog(arg3);
        Context v2 = arg3.getContext();
        Intrinsics.checkNotNullExpressionValue(v2, "getContext(...)");
        CursorOverlayOrderKt.bringCursorAboveWindow(v2);
    }

    static final void show$lambda$13(MousePanelController arg0, AlertDialog arg1, DialogInterface arg2) {
        if(arg0.dialog == arg1) {
            arg0.dialog = null;
        }
    }

    private final void showProfiles() {
        Context v3_1;
        String v2 = null;
        String v0 = this.prefs.getString("perfil_mouse_activo", v2);
        View v3 = this.root;
        if(v3 != null) {
            v3_1 = v3.getContext();
            if(v3_1 == null) {
                goto label_9;
            }
        }
        else {
        label_9:
            v3_1 = this.context;
        }

        AlertDialog$Builder v1 = new AlertDialog$Builder(v3_1).setTitle("Perfiles del mouse");
        String[] v3_2 = new String[2];
        if(v0 != null) {
            v0 = " (" + v0 + ")";
            if(v0 == null) {
                goto label_24;
            }
        }
        else {
        label_24:
            v0 = "";
        }

        v3_2[0] = "Guardar perfil" + v0;
        v3_2[1] = "Cargar perfil";
        AlertDialog v0_1 = v1.setItems(((CharSequence[])v3_2), new MousePanelController$$ExternalSyntheticLambda0(this)).setNegativeButton("Cerrar", ((DialogInterface$OnClickListener)v2)).create();
        Intrinsics.checkNotNullExpressionValue(v0_1, "create(...)");
        this.show(v0_1);
    }

    static final void showProfiles$lambda$9(MousePanelController arg0, DialogInterface arg1, int arg2) {
        if(arg2 == 0) {
            arg0.saveDialog();
            return;
        }

        arg0.loadDialog();
    }

    private final void toast(String arg2) {
        Toast.makeText(this.context, ((CharSequence)arg2), 1).show();
    }
}

