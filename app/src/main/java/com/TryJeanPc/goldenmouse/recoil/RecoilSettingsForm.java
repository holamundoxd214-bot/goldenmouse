package com.TryJeanPc.goldenmouse.recoil;

import android.content.res.ColorStateList;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import com.TryJeanPc.goldenmouse.R$drawable;
import com.TryJeanPc.goldenmouse.R$id;
import com.TryJeanPc.goldenmouse.controls.VistaActivationCapture$Companion$$ExternalSyntheticBackportWithForwarding0;
import java.math.BigDecimal;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0012\u0010\t\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000B0\n\u0012\f\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u000B0\r¢\u0006\u0004\b\u000E\u0010\u000FJ\u0006\u0010\"\u001A\u00020\u000BJ\u0010\u0010#\u001A\u00020\u000B2\u0006\u0010$\u001A\u00020\u0006H\u0002J\b\u0010%\u001A\u00020\u000BH\u0002J\b\u0010&\u001A\u00020\u000BH\u0002J\b\u0010\'\u001A\u00020\u0013H\u0002J\u0010\u0010(\u001A\u00020\u000B2\u0006\u0010$\u001A\u00020)H\u0002J\u0010\u0010*\u001A\u00020\u000B2\u0006\u0010$\u001A\u00020)H\u0002J\b\u0010+\u001A\u00020\u000BH\u0002J\'\u0010,\u001A\u0004\u0018\u00010)2\u0006\u0010-\u001A\u00020\u00152\u0006\u0010.\u001A\u00020)2\u0006\u0010/\u001A\u00020)H\u0002¢\u0006\u0002\u00100J$\u00101\u001A\u00020\u000B2\u0006\u00102\u001A\u0002032\u0012\u00104\u001A\u000E\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000B0\nH\u0002J$\u00105\u001A\u00020\u000B2\u0006\u00106\u001A\u00020\u001A2\u0012\u00104\u001A\u000E\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u000B0\nH\u0002J\u001E\u00107\u001A\u00020\u000B2\u0006\u0010-\u001A\u00020\u00152\f\u00104\u001A\b\u0012\u0004\u0012\u00020\u000B0\rH\u0002J\u0016\u00108\u001A\u00020\u000B2\f\u00109\u001A\b\u0012\u0004\u0012\u00020\u000B0\rH\u0002J\u0010\u0010:\u001A\u00020;2\u0006\u0010$\u001A\u00020)H\u0002J\u0010\u0010<\u001A\u00020\u000B2\u0006\u0010=\u001A\u00020;H\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\t\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000B0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u000B0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0013X\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001A\n \u0016*\u0004\u0018\u00010\u00150\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001A\n \u0016*\u0004\u0018\u00010\u00150\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001A\n \u0016*\u0004\u0018\u00010\u00150\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001A\n \u0016*\u0004\u0018\u00010\u001A0\u001AX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001B\u001A\n \u0016*\u0004\u0018\u00010\u001A0\u001AX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001C\u001A\n \u0016*\u0004\u0018\u00010\u001D0\u001DX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001E\u001A\n \u0016*\u0004\u0018\u00010\u001D0\u001DX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001F\u001A\n \u0016*\u0004\u0018\u00010 0 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010!\u001A\n \u0016*\u0004\u0018\u00010 0 X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006>"}, d2={"Lcom/TryJeanPc/goldenmouse/recoil/RecoilSettingsForm;", "", "main", "Landroid/view/View;", "editor", "initial", "Lcom/TryJeanPc/goldenmouse/recoil/RecoilSettings;", "store", "Lcom/TryJeanPc/goldenmouse/recoil/RecoilSettingsStore;", "onChange", "Lkotlin/Function1;", "", "onApplied", "Lkotlin/Function0;", "<init>", "(Landroid/view/View;Landroid/view/View;Lcom/TryJeanPc/goldenmouse/recoil/RecoilSettings;Lcom/TryJeanPc/goldenmouse/recoil/RecoilSettingsStore;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "settings", "draft", "binding", "", "duration", "Landroid/widget/EditText;", "kotlin.jvm.PlatformType", "speedY", "speedX", "sliderY", "Landroid/widget/SeekBar;", "sliderX", "up", "Landroid/widget/TextView;", "down", "selectedColor", "Landroid/content/res/ColorStateList;", "normalColor", "beginEditor", "change", "value", "renderMain", "showDuration", "readDuration", "setY", "", "setX", "renderDirection", "number", "field", "minimum", "maximum", "(Landroid/widget/EditText;DD)Ljava/lang/Double;", "toggle", "id", "", "changed", "slider", "view", "watch", "bind", "action", "format", "", "message", "text", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class RecoilSettingsForm {
    public static final int $stable = 8;
    private boolean binding;
    private final TextView down;
    private RecoilSettings draft;
    private final EditText duration;
    private final View editor;
    private final View main;
    private final ColorStateList normalColor;
    private final Function0 onApplied;
    private final Function1 onChange;
    private final ColorStateList selectedColor;
    private RecoilSettings settings;
    private final SeekBar sliderX;
    private final SeekBar sliderY;
    private final EditText speedX;
    private final EditText speedY;
    private final RecoilSettingsStore store;
    private final TextView up;

    static {
    }

    public RecoilSettingsForm(View arg7, View arg8, RecoilSettings arg9, RecoilSettingsStore arg10, Function1 arg11, Function0 arg12) {
        Intrinsics.checkNotNullParameter(arg7, "main");
        Intrinsics.checkNotNullParameter(arg8, "editor");
        Intrinsics.checkNotNullParameter(arg9, "initial");
        Intrinsics.checkNotNullParameter(arg10, "store");
        Intrinsics.checkNotNullParameter(arg11, "onChange");
        Intrinsics.checkNotNullParameter(arg12, "onApplied");
        super();
        this.main = arg7;
        this.editor = arg8;
        this.store = arg10;
        this.onChange = arg11;
        this.onApplied = arg12;
        this.settings = arg9;
        this.draft = arg9;
        View v9 = arg7.findViewById(id.editDuracionMaxRetroceso);
        this.duration = ((EditText)v9);
        View v10 = arg8.findViewById(id.editVelocidadY);
        this.speedY = ((EditText)v10);
        View v11 = arg8.findViewById(id.editVelocidadX);
        this.speedX = ((EditText)v11);
        View v12 = arg8.findViewById(id.seekVelocidadY);
        this.sliderY = ((SeekBar)v12);
        View v0 = arg8.findViewById(id.seekVelocidadX);
        this.sliderX = ((SeekBar)v0);
        View v1 = arg8.findViewById(id.btnDireccionArribaY);
        this.up = ((TextView)v1);
        View v2 = arg8.findViewById(id.btnDireccionAbajoY);
        this.down = ((TextView)v2);
        this.selectedColor = ((TextView)v1).getTextColors();
        this.normalColor = ((TextView)v2).getTextColors();
        ((SeekBar)v12).setMax(1000);
        ((SeekBar)v12).setMin(0);
        ((SeekBar)v12).setKeyProgressIncrement(1);
        ((SeekBar)v0).setMax(1000);
        ((SeekBar)v0).setMin(-1000);
        ((SeekBar)v0).setKeyProgressIncrement(1);
        this.toggle(id.switchHabilitarRetroceso, new RecoilSettingsForm$$ExternalSyntheticLambda21(this));
        this.toggle(id.switchMostrarPanelRetroceso, new RecoilSettingsForm$$ExternalSyntheticLambda5(this));
        this.toggle(id.switchPanelFijoRetroceso, new RecoilSettingsForm$$ExternalSyntheticLambda7(this));
        View v3 = arg7.findViewById(id.seekTransparenciaPanelRetroceso);
        Intrinsics.checkNotNullExpressionValue(v3, "findViewById(...)");
        this.slider(((SeekBar)v3), new RecoilSettingsForm$$ExternalSyntheticLambda8(this));
        v3 = arg7.findViewById(id.seekPorcentajeGlobalRetroceso);
        Intrinsics.checkNotNullExpressionValue(v3, "findViewById(...)");
        this.slider(((SeekBar)v3), new RecoilSettingsForm$$ExternalSyntheticLambda9(this));
        arg7.findViewById(id.radioGroupDuracionRetroceso).setOnCheckedChangeListener(new RecoilSettingsForm$$ExternalSyntheticLambda11(this));
        Intrinsics.checkNotNullExpressionValue(v9, "duration");
        this.watch(((EditText)v9), new RecoilSettingsForm$$ExternalSyntheticLambda12(this));
        arg7.findViewById(id.btnRestablecerRetroceso).setOnClickListener(new RecoilSettingsForm$$ExternalSyntheticLambda13(this));
        arg7.findViewById(id.btnGuardarRetroceso).setOnClickListener(new RecoilSettingsForm$$ExternalSyntheticLambda14(this));
        ((TextView)v1).setOnClickListener(new RecoilSettingsForm$$ExternalSyntheticLambda15(this));
        ((TextView)v2).setOnClickListener(new RecoilSettingsForm$$ExternalSyntheticLambda22(this));
        Intrinsics.checkNotNullExpressionValue(v10, "speedY");
        this.watch(((EditText)v10), new RecoilSettingsForm$$ExternalSyntheticLambda23(this));
        Intrinsics.checkNotNullExpressionValue(v11, "speedX");
        this.watch(((EditText)v11), new RecoilSettingsForm$$ExternalSyntheticLambda24(this));
        Intrinsics.checkNotNullExpressionValue(v12, "sliderY");
        this.slider(((SeekBar)v12), new RecoilSettingsForm$$ExternalSyntheticLambda25(this));
        Intrinsics.checkNotNullExpressionValue(v0, "sliderX");
        this.slider(((SeekBar)v0), new RecoilSettingsForm$$ExternalSyntheticLambda26(this));
        arg8.findViewById(id.btnDisminuirVelocidadY).setOnClickListener(new RecoilSettingsForm$$ExternalSyntheticLambda0(this));
        arg8.findViewById(id.btnAumentarVelocidadY).setOnClickListener(new RecoilSettingsForm$$ExternalSyntheticLambda1(this));
        arg8.findViewById(id.btnRestablecerY).setOnClickListener(new RecoilSettingsForm$$ExternalSyntheticLambda2(this));
        arg8.findViewById(id.btnRestablecerX).setOnClickListener(new RecoilSettingsForm$$ExternalSyntheticLambda3(this));
        arg8.findViewById(id.btnRestablecerEditorRetroceso).setOnClickListener(new RecoilSettingsForm$$ExternalSyntheticLambda4(this));
        arg8.findViewById(id.btnAplicarEditorRetroceso).setOnClickListener(new RecoilSettingsForm$$ExternalSyntheticLambda6(this));
        this.renderMain();
    }

    static final Unit _init_$lambda$0(RecoilSettingsForm arg17, boolean arg18) {
        RecoilSettingsForm v0 = arg17;
        v0.change(RecoilSettings.copy$default(v0.settings, arg18, false, false, 0, 0, false, 0, 0, false, 0, 0x3FE, null));
        if(arg18) {
            v0.message("Retroceso habilitado: requiere FPS, captura válida y un nuevo clic izquierdo");
        }

        return Unit.INSTANCE;
    }

    static final Unit _init_$lambda$1(RecoilSettingsForm arg17, boolean arg18) {
        RecoilSettingsForm v0 = arg17;
        v0.change(RecoilSettings.copy$default(v0.settings, false, arg18, false, 0, 0, false, 0, 0, false, 0, 0x3FD, null));
        if(arg18) {
            v0.message("Panel flotante pendiente de diseño; se conserva esta preferencia");
        }

        return Unit.INSTANCE;
    }

    static final void _init_$lambda$10(RecoilSettingsForm arg17, View arg18) {
        arg17.draft = RecoilSettings.copy$default(arg17.draft, false, false, false, 0, 0, false, 0, 0, true, 0, 0x2FF, null);
        arg17.renderDirection();
    }

    static final Unit _init_$lambda$12(RecoilSettingsForm arg18) {
        RecoilSettingsForm v0 = arg18;
        EditText v1 = v0.speedY;
        Intrinsics.checkNotNullExpressionValue(v1, "speedY");
        Double v1_1 = v0.number(v1, 0, 100);
        if(v1_1 != null) {
            v0.draft = RecoilSettings.copy$default(v0.draft, false, false, false, 0, 0, false, 0, v1_1.doubleValue(), false, 0, 0x37F, null);
            v0.bind(new RecoilSettingsForm$$ExternalSyntheticLambda19(v0, v1_1));
        }

        return Unit.INSTANCE;
    }

    static final Unit _init_$lambda$14(RecoilSettingsForm arg18) {
        RecoilSettingsForm v0 = arg18;
        EditText v1 = v0.speedX;
        Intrinsics.checkNotNullExpressionValue(v1, "speedX");
        Double v1_1 = v0.number(v1, -100, 100);
        if(v1_1 != null) {
            v0.draft = RecoilSettings.copy$default(v0.draft, false, false, false, 0, 0, false, 0, 0, false, v1_1.doubleValue(), 0x1FF, null);
            v0.bind(new RecoilSettingsForm$$ExternalSyntheticLambda20(v0, v1_1));
        }

        return Unit.INSTANCE;
    }

    static final Unit _init_$lambda$15(RecoilSettingsForm arg2, int arg3) {
        arg2.setY(RecoilSpeedScale.INSTANCE.fromProgress(arg3));
        return Unit.INSTANCE;
    }

    static final Unit _init_$lambda$16(RecoilSettingsForm arg2, int arg3) {
        arg2.setX(RecoilSpeedScale.INSTANCE.fromProgress(arg3));
        return Unit.INSTANCE;
    }

    static final void _init_$lambda$17(RecoilSettingsForm arg6, View arg7) {
        EditText v1 = arg6.speedY;
        Intrinsics.checkNotNullExpressionValue(v1, "speedY");
        RecoilSettingsForm v0 = arg6;
        Double v6 = v0.number(v1, 0, 100);
        if(v6 != null) {
            v0.setY(RecoilSpeedScale.INSTANCE.adjustVertical(v6.doubleValue(), false));
        }
    }

    static final void _init_$lambda$18(RecoilSettingsForm arg6, View arg7) {
        EditText v1 = arg6.speedY;
        Intrinsics.checkNotNullExpressionValue(v1, "speedY");
        RecoilSettingsForm v0 = arg6;
        Double v6 = v0.number(v1, 0, 100);
        if(v6 != null) {
            v0.setY(RecoilSpeedScale.INSTANCE.adjustVertical(v6.doubleValue(), true));
        }
    }

    static final void _init_$lambda$19(RecoilSettingsForm arg2, View arg3) {
        arg2.setY(0);
    }

    static final Unit _init_$lambda$2(RecoilSettingsForm arg17, boolean arg18) {
        arg17.change(RecoilSettings.copy$default(arg17.settings, false, false, arg18, 0, 0, false, 0, 0, false, 0, 0x3FB, null));
        return Unit.INSTANCE;
    }

    static final void _init_$lambda$20(RecoilSettingsForm arg2, View arg3) {
        arg2.setX(0);
    }

    static final void _init_$lambda$21(RecoilSettingsForm arg17, View arg18) {
        arg17.draft = RecoilSettings.copy$default(arg17.draft, false, false, false, 0, 0, false, 0, 0, false, 0, 0x2FF, null);
        arg17.setY(0);
        arg17.setX(0);
        arg17.renderDirection();
    }

    static final void _init_$lambda$22(RecoilSettingsForm arg23, View arg24) {
        RecoilSettingsForm v0 = arg23;
        EditText v1 = v0.speedY;
        Intrinsics.checkNotNullExpressionValue(v1, "speedY");
        Double v6 = v0.number(v1, 0, 100);
        v1 = v0.speedX;
        Intrinsics.checkNotNullExpressionValue(v1, "speedX");
        Double v1_1 = v0.number(v1, -100, 100);
        if(v6 != null && v1_1 != null) {
            v0.change(RecoilSettings.copy$default(v0.settings, false, false, false, 0, 0, false, 0, v6.doubleValue(), v0.draft.getDownward(), v1_1.doubleValue(), 0x7F, null));
            v0.onApplied.invoke();
        }
    }

    static final Unit _init_$lambda$3(RecoilSettingsForm arg17, int arg18) {
        arg17.change(RecoilSettings.copy$default(arg17.settings, false, false, false, arg18, 0, false, 0, 0, false, 0, 0x3F7, null));
        arg17.main.findViewById(id.txtTransparenciaPanelRetroceso).setText(arg18 + "%");
        return Unit.INSTANCE;
    }

    static final Unit _init_$lambda$4(RecoilSettingsForm arg17, int arg18) {
        arg17.change(RecoilSettings.copy$default(arg17.settings, false, false, false, 0, arg18, false, 0, 0, false, 0, 1007, null));
        arg17.main.findViewById(id.txtPorcentajeGlobalRetroceso).setText(arg18 + "%");
        return Unit.INSTANCE;
    }

    static final void _init_$lambda$5(RecoilSettingsForm arg18, RadioGroup arg19, int arg20) {
        RecoilSettingsForm v0 = arg18;
        Intrinsics.checkNotNullParameter(arg19, "<unused var>");
        if(!v0.binding) {
            RecoilSettings v2 = v0.settings;
            boolean v1 = arg20 == id.radioDuracionMaximaRetroceso ? true : false;
            v0.change(RecoilSettings.copy$default(v2, false, false, false, 0, 0, v1, 0, 0, false, 0, 0x3DF, null));
            v0.showDuration();
            v0.readDuration();
        }
    }

    static final Unit _init_$lambda$6(RecoilSettingsForm arg0) {
        arg0.readDuration();
        return Unit.INSTANCE;
    }

    static final void _init_$lambda$7(RecoilSettingsForm arg17, View arg18) {
        arg17.change(new RecoilSettings(false, false, false, 0, 0, false, 0, 0, false, 0, 0x3FF, null));
        arg17.renderMain();
        arg17.message("Valores restablecidos. Pulsa Guardar para conservarlos");
    }

    static final void _init_$lambda$8(RecoilSettingsForm arg1, View arg2) {
        if(arg1.readDuration()) {
            String v2 = arg1.store.save(arg1.settings) ? "Configuración de retroceso guardada" : "No se pudo guardar la configuración de retroceso";
            arg1.message(v2);
        }
    }

    static final void _init_$lambda$9(RecoilSettingsForm arg17, View arg18) {
        arg17.draft = RecoilSettings.copy$default(arg17.draft, false, false, false, 0, 0, false, 0, 0, false, 0, 0x2FF, null);
        arg17.renderDirection();
    }

    public static final boolean access$getBinding$p(RecoilSettingsForm arg0) {
        return arg0.binding;
    }

    public final void beginEditor() {
        RecoilSettings v0 = this.settings;
        this.draft = v0;
        this.setY(v0.getVerticalSpeed());
        this.setX(this.draft.getHorizontalSpeed());
        this.renderDirection();
    }

    private final void bind(Function0 arg3) {
        boolean v0 = this.binding;
        this.binding = true;
        try {
            arg3.invoke();
        }
        catch(Throwable v3) {
            this.binding = v0;
            throw v3;
        }

        this.binding = v0;
    }

    private final void change(RecoilSettings arg3) {
        this.settings = arg3;
        View v0 = this.main.findViewById(id.txtEstadoRetroceso);
        String v1 = arg3.getEnabled() ? "EN ESPERA" : "DESACTIVADO";
        ((TextView)v0).setText(((CharSequence)v1));
        this.onChange.invoke(arg3);
    }

    private final String format(double arg1) {
        String v0 = VistaActivationCapture$Companion$$ExternalSyntheticBackportWithForwarding0.m(BigDecimal.valueOf(arg1)).toPlainString();
        Intrinsics.checkNotNullExpressionValue(v0, "toPlainString(...)");
        return v0;
    }

    static final Unit lambda$12$lambda$11(RecoilSettingsForm arg3, Double arg4) {
        arg3.sliderY.setProgress(RecoilSpeedScale.INSTANCE.toProgress(arg4.doubleValue()));
        return Unit.INSTANCE;
    }

    static final Unit lambda$14$lambda$13(RecoilSettingsForm arg3, Double arg4) {
        arg3.sliderX.setProgress(RecoilSpeedScale.INSTANCE.toProgress(arg4.doubleValue()));
        return Unit.INSTANCE;
    }

    private final void message(String arg2) {
        Toast.makeText(this.main.getContext(), ((CharSequence)arg2), 1).show();
    }

    private final Double number(EditText arg7, double arg8, double arg10) {
        CharSequence v6_1;
        double v2 = arg8;
        double v4 = arg10;
        Double v8 = RecoilSettings.Companion.parseNumber(arg7.getText().toString(), v2, v4);
        if(v8 == null) {
            String v6 = "Introduce un valor entre " + this.format(v2) + " y " + this.format(v4);
        }
        else {
            v6_1 = null;
        }

        arg7.setError(v6_1);
        return v8;
    }

    private final boolean readDuration() {
        String v2_1;
        RecoilSettingsForm v0 = this;
        Double v1 = RecoilSettings.Companion.parseNumber(v0.duration.getText().toString(), 0, 60);
        CharSequence v2 = null;
        if(v1 == null || v1.doubleValue() <= 0) {
            v1 = ((Double)v2);
        }
        else {
        }

        boolean v3 = v1 != null || !v0.settings.getLimitDuration() ? true : false;
        EditText v4 = v0.duration;
        if(v3) {
        }
        else {
            v2_1 = "Introduce segundos mayores que 0 y hasta 60";
        }

        v4.setError(((CharSequence)v2_1));
        if(v1 != null) {
            v0.change(RecoilSettings.copy$default(v0.settings, false, false, false, 0, 0, false, v1.doubleValue(), 0, false, 0, 0x3BF, null));
        }

        return v3;
    }

    private final void renderDirection() {
        this.up.setSelected(this.draft.getDownward() ^ 1);
        this.down.setSelected(this.draft.getDownward());
        TextView v0 = this.up;
        ColorStateList v1 = this.draft.getDownward() ? this.normalColor : this.selectedColor;
        v0.setTextColor(v1);
        v0 = this.down;
        v1 = this.draft.getDownward() ? this.selectedColor : this.normalColor;
        v0.setTextColor(v1);
        v0 = this.up;
        int v1_1 = this.draft.getDownward() ? drawable.bg_setting : drawable.bg_view_button_gold;
        v0.setBackgroundResource(v1_1);
        v0 = this.down;
        int v2 = this.draft.getDownward() ? drawable.bg_view_button_gold : drawable.bg_setting;
        v0.setBackgroundResource(v2);
    }

    private final void renderMain() {
        this.bind(new RecoilSettingsForm$$ExternalSyntheticLambda18(this));
    }

    static final Unit renderMain$lambda$23(RecoilSettingsForm arg4) {
        arg4.main.findViewById(id.switchHabilitarRetroceso).setChecked(arg4.settings.getEnabled());
        arg4.main.findViewById(id.switchMostrarPanelRetroceso).setChecked(arg4.settings.getShowPanel());
        arg4.main.findViewById(id.switchPanelFijoRetroceso).setChecked(arg4.settings.getFixedPanel());
        arg4.main.findViewById(id.seekTransparenciaPanelRetroceso).setProgress(arg4.settings.getPanelOpacity());
        arg4.main.findViewById(id.txtTransparenciaPanelRetroceso).setText(arg4.settings.getPanelOpacity() + "%");
        arg4.main.findViewById(id.seekPorcentajeGlobalRetroceso).setProgress(arg4.settings.getGlobalPercent());
        arg4.main.findViewById(id.txtPorcentajeGlobalRetroceso).setText(arg4.settings.getGlobalPercent() + "%");
        View v0 = arg4.main.findViewById(id.radioGroupDuracionRetroceso);
        int v1 = arg4.settings.getLimitDuration() ? id.radioDuracionMaximaRetroceso : id.radioDuracionMantenerRetroceso;
        ((RadioGroup)v0).check(v1);
        arg4.duration.setText(arg4.format(arg4.settings.getMaxDurationSeconds()));
        arg4.duration.setError(null);
        arg4.showDuration();
        v0 = arg4.main.findViewById(id.txtEstadoRetroceso);
        String v4 = arg4.settings.getEnabled() ? "EN ESPERA" : "DESACTIVADO";
        ((TextView)v0).setText(((CharSequence)v4));
        return Unit.INSTANCE;
    }

    private final void setX(double arg18) {
        this.draft = RecoilSettings.copy$default(this.draft, false, false, false, 0, 0, false, 0, 0, false, arg18, 0x1FF, null);
        this.bind(new RecoilSettingsForm$$ExternalSyntheticLambda17(this, arg18));
    }

    static final Unit setX$lambda$26(RecoilSettingsForm arg2, double arg3) {
        arg2.speedX.setText(arg2.format(arg3));
        arg2.sliderX.setProgress(RecoilSpeedScale.INSTANCE.toProgress(arg3));
        arg2.speedX.setError(null);
        return Unit.INSTANCE;
    }

    private final void setY(double arg18) {
        this.draft = RecoilSettings.copy$default(this.draft, false, false, false, 0, 0, false, 0, arg18, false, 0, 0x37F, null);
        this.bind(new RecoilSettingsForm$$ExternalSyntheticLambda10(this, arg18));
    }

    static final Unit setY$lambda$25(RecoilSettingsForm arg2, double arg3) {
        arg2.speedY.setText(arg2.format(arg3));
        arg2.sliderY.setProgress(RecoilSpeedScale.INSTANCE.toProgress(arg3));
        arg2.speedY.setError(null);
        return Unit.INSTANCE;
    }

    private final void showDuration() {
        View v0 = this.main.findViewById(id.groupDuracionMaxRetroceso);
        int v2 = this.settings.getLimitDuration() ? 0 : 8;
        v0.setVisibility(v2);
    }

    private final void slider(SeekBar arg2, Function1 arg3) {
        arg2.setOnSeekBarChangeListener(new RecoilSettingsForm$slider$1(this, arg3));
    }

    private final void toggle(int arg2, Function1 arg3) {
        this.main.findViewById(arg2).setOnCheckedChangeListener(new RecoilSettingsForm$$ExternalSyntheticLambda16(this, arg3));
    }

    static final void toggle$lambda$27(RecoilSettingsForm arg1, Function1 arg2, CompoundButton arg3, boolean arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<unused var>");
        if(!arg1.binding) {
            arg2.invoke(Boolean.valueOf(arg4));
        }
    }

    private final void watch(EditText arg2, Function0 arg3) {
        arg2.addTextChangedListener(new RecoilSettingsForm$watch$1(this, arg3));
    }
}

