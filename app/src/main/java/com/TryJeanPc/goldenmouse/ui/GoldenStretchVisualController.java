package com.TryJeanPc.goldenmouse.ui;

import android.app.AlertDialog$Builder;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface$OnDismissListener;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.hardware.display.DisplayManager;
import android.os.Build$VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.View$OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager$LayoutParams;
import android.widget.SeekBar;
import android.widget.TextView;
import com.TryJeanPc.goldenmouse.R$drawable;
import com.TryJeanPc.goldenmouse.R$id;
import com.TryJeanPc.goldenmouse.service.SessionOverlayWindowsKt;
import com.TryJeanPc.goldenmouse.stretch.GoldenStretchDisplayReader;
import com.TryJeanPc.goldenmouse.stretch.StretchSize;
import com.TryJeanPc.goldenmouse.stretch.physical.GoldenStretchPhysicalController;
import com.google.android.material.R$style;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000]\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u001A\b\u0007\u0018\u0000 &2\u00020\u0001:\u0001&B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u000E\b\u0002\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u001C\u001A\u00020\u0006H\u0002J\u0006\u0010\u001D\u001A\u00020\nJ\u0010\u0010\u001E\u001A\u00020\u00062\u0006\u0010\u001F\u001A\u00020\fH\u0002J\u0006\u0010 \u001A\u00020\u0006J\u001E\u0010!\u001A\u0010\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020#\u0018\u00010\"2\u0006\u0010\u001F\u001A\u00020\fH\u0002J\b\u0010$\u001A\u00020\u0006H\u0002J\u0006\u0010%\u001A\u00020\u0006R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001A\u0004\u0018\u00010\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u000B\u001A\u0004\u0018\u00010\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u000EX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000F\u001A\u0004\u0018\u00010\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001A\u0004\u0018\u00010\u0011X\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001A\n \u0014*\u0004\u0018\u00010\u00130\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001A\u0004\u0018\u00010\u0018X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001A\u00020\u001AX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001B¨\u0006\'"}, d2={"Lcom/TryJeanPc/goldenmouse/ui/GoldenStretchVisualController;", "", "context", "Landroid/content/Context;", "onClosed", "Lkotlin/Function0;", "", "<init>", "(Landroid/content/Context;Lkotlin/jvm/functions/Function0;)V", "dialog", "Landroid/app/Dialog;", "root", "Landroid/view/View;", "selection", "Lcom/TryJeanPc/goldenmouse/ui/GoldenStretchSelection;", "confirmation", "physical", "Lcom/TryJeanPc/goldenmouse/stretch/physical/GoldenStretchPhysicalController;", "displays", "Landroid/hardware/display/DisplayManager;", "kotlin.jvm.PlatformType", "observingDisplay", "", "visibilityObserver", "Lcom/TryJeanPc/goldenmouse/ui/VisualVisibilityObserver;", "displayListener", "com/TryJeanPc/goldenmouse/ui/GoldenStretchVisualController$displayListener$1", "Lcom/TryJeanPc/goldenmouse/ui/GoldenStretchVisualController$displayListener$1;", "reconcileDisplayObservation", "show", "bindControls", "content", "refreshResolution", "readDisplaySize", "Lkotlin/Pair;", "", "stopObservingDisplay", "close", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GoldenStretchVisualController {
    @Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001C\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00050\t¨\u0006\n"}, d2={"Lcom/TryJeanPc/goldenmouse/ui/GoldenStretchVisualController$Companion;", "", "<init>", "()V", "bindEntry", "", "hud", "Landroid/view/View;", "open", "Lkotlin/Function0;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final void bindEntry(View arg4, Function0 arg5) {
            Intrinsics.checkNotNullParameter(arg4, "hud");
            Intrinsics.checkNotNullParameter(arg5, "open");
            int[] v3 = new int[]{id.bgRefreshRateAuto, id.txtRefreshRateAuto};
            int v0;
            for(v0 = 0; v0 < 2; ++v0) {
                View v1 = arg4.findViewById(v3[v0]);
                if(v1 != null) {
                    v1.setOnClickListener(new GoldenStretchVisualController$Companion$$ExternalSyntheticLambda0(arg5));
                }
            }
        }

        static final void bindEntry$lambda$0(Function0 arg0, View arg1) {
            arg0.invoke();
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private Dialog confirmation;
    private final Context context;
    private Dialog dialog;
    private final GoldenStretchVisualController$displayListener$1 displayListener;
    private final DisplayManager displays;
    private boolean observingDisplay;
    private final Function0 onClosed;
    private GoldenStretchPhysicalController physical;
    private View root;
    private final GoldenStretchSelection selection;
    private VisualVisibilityObserver visibilityObserver;

    static {
        GoldenStretchVisualController.Companion = new Companion(null);
        GoldenStretchVisualController.$stable = 8;
    }

    public GoldenStretchVisualController(Context arg2, Function0 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "context");
        Intrinsics.checkNotNullParameter(arg3, "onClosed");
        super();
        this.context = arg2;
        this.onClosed = arg3;
        this.selection = new GoldenStretchSelection();
        this.displays = arg2.getSystemService(DisplayManager.class);
        this.displayListener = new GoldenStretchVisualController$displayListener$1(this);
    }

    public GoldenStretchVisualController(Context arg1, Function0 arg2, int arg3, DefaultConstructorMarker arg4) {
        GoldenStretchVisualController$$ExternalSyntheticLambda10 v2;
        if((arg3 & 2) != 0) {
            v2 = new GoldenStretchVisualController$$ExternalSyntheticLambda10();
        }

        this(arg1, ((Function0)v2));
    }

    static final Unit _init_$lambda$0() {
        return Unit.INSTANCE;
    }

    public static final void access$bindControls$render(SeekBar arg0, GoldenStretchVisualController arg1, TextView arg2, List arg3, View arg4, ColorStateList arg5, ColorStateList arg6, Typeface arg7, Typeface arg8) {
        GoldenStretchVisualController.bindControls$render(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }

    public static final GoldenStretchSelection access$getSelection$p(GoldenStretchVisualController arg0) {
        return arg0.selection;
    }

    private final void bindControls(View arg16) {
        View v1_3;
        View v4 = arg16;
        GoldenStretchVisualController.bindControls$newController(this);
        View v0 = v4.findViewById(id.seekGoldenStretch);
        View v2 = v4.findViewById(id.txtValorGoldenStretch);
        List v1 = CollectionsKt.listOf(new Pair[]{TuplesKt.to(Integer.valueOf(5), Integer.valueOf(id.btnStretch105)), TuplesKt.to(Integer.valueOf(10), Integer.valueOf(id.btnStretch110)), TuplesKt.to(Integer.valueOf(11), Integer.valueOf(id.btnStretch111)), TuplesKt.to(Integer.valueOf(15), Integer.valueOf(id.btnStretch115))});
        ArrayList v5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v1), 10));
        Iterator v1_1 = ((Iterable)v1).iterator();
        while(v1_1.hasNext()) {
            Object v3 = v1_1.next();
            ((Collection)v5).add(TuplesKt.to(Integer.valueOf(((Pair)v3).component1().intValue()), v4.findViewById(((Pair)v3).component2().intValue())));
        }

        ArrayList v3_1 = v5;
        Object v1_2 = CollectionsKt.first(((List)v3_1)).getSecond();
        Object v5_1 = ((List)v3_1).get(1).getSecond();
        ColorStateList v6 = ((TextView)v1_2).getTextColors();
        ColorStateList v7 = ((TextView)v5_1).getTextColors();
        Typeface v8 = ((TextView)v1_2).getTypeface();
        Typeface v9 = ((TextView)v5_1).getTypeface();
        Iterator v12 = v3_1.iterator();
        while(v12.hasNext()) {
            v1_2 = v12.next();
            int v5_2 = ((Pair)v1_2).component1().intValue();
            Object v13 = ((Pair)v1_2).component2();
            v1_3 = v2;
            int v2_1 = v5_2;
            v5 = v3_1;
            View v3_2 = v0;
            GoldenStretchVisualController$$ExternalSyntheticLambda6 v0_1 = new GoldenStretchVisualController$$ExternalSyntheticLambda6(this, v2_1, ((SeekBar)v3_2), v1_3, ((List)v5), v4, v7, v6, v9, v8);
            v6 = v6;
            v8 = v8;
            ((TextView)v13).setOnClickListener(((View$OnClickListener)v0_1));
            v4 = arg16;
            v2 = v1_3;
            v0 = v3_2;
            v3_1 = v5;
        }

        v1_3 = v2;
        ColorStateList v2_2 = v7;
        v7 = v6;
        v6 = v2_2;
        Typeface v2_3 = v9;
        v9 = v8;
        v8 = v2_3;
        v2 = v0;
        v2.setOnSeekBarChangeListener(new GoldenStretchVisualController$bindControls$2(this, ((SeekBar)v2), v1_3, v3_1, arg16, v6, v7, v8, v9));
        arg16.findViewById(id.txtEstadoGoldenStretch).setText("Aplicación manual según capacidades; originales y rescate obligatorios\nAPLICAR requiere confirmación y originales recuperables; RESTAURAR permanece disponible.");
        v0 = arg16.findViewById(id.btnAplicarGoldenStretch);
        View v10 = arg16.findViewById(id.btnRestaurarGoldenStretch);
        v10.setEnabled(true);
        v0.setEnabled(true);
        v0.setOnClickListener(new GoldenStretchVisualController$$ExternalSyntheticLambda7(this, arg16, v10));
        v10.setOnClickListener(new GoldenStretchVisualController$$ExternalSyntheticLambda8(this));
        arg16.findViewById(id.btnCerrarGoldenStretch).setOnClickListener(new GoldenStretchVisualController$$ExternalSyntheticLambda9(this));
        GoldenStretchVisualController.bindControls$render(v2, this, v1_3, v3_1, arg16, v6, v7, v8, v9);
    }

    static final void bindControls$lambda$10$lambda$9(GoldenStretchVisualController arg0, int arg1, SeekBar arg2, TextView arg3, List arg4, View arg5, ColorStateList arg6, ColorStateList arg7, Typeface arg8, Typeface arg9, View arg10) {
        arg0.selection.select(arg1);
        GoldenStretchVisualController.bindControls$render(arg2, arg0, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
    }

    static final void bindControls$lambda$15(GoldenStretchVisualController arg8, View arg9, View arg10, View arg11) {
        int v11 = arg8.selection.getProgress();
        if(1 <= v11) {
            int v1 = 100;
            if(v11 < v1) {
                GoldenStretchPhysicalController v11_1 = arg8.physical;
                if(v11_1 != null && (v11_1.isBusy())) {
                    arg9.findViewById(id.txtEstadoGoldenStretch).setText("APLICAR bloqueado: hay una operación Stretch activa. Espera su resultado o pulsa RESTAURAR.");
                    return;
                }

                v11_1 = arg8.physical;
                if(v11_1 != null) {
                    v11_1.close();
                }

                GoldenStretchPhysicalController v7 = GoldenStretchVisualController.bindControls$newController(arg8);
                v7.prepare(arg8.selection.getProgress() + v1, new GoldenStretchVisualController$$ExternalSyntheticLambda3(arg9, arg8.selection.getLabel(), arg8, arg10, v7));
                return;
            }
        }

        arg9.findViewById(id.txtEstadoGoldenStretch).setText("Selecciona un factor entre 1.01× y 1.99×. No se modificó la pantalla.");
    }

    static final Unit bindControls$lambda$15$lambda$14(View arg2, String arg3, GoldenStretchVisualController arg4, View arg5, GoldenStretchPhysicalController arg6) {
        AlertDialog v2 = new AlertDialog$Builder(arg2.getContext()).setTitle("Autorizar estiramiento " + arg3).setMessage("Display 0 en horizontal. Se verificarán los originales y el ejecutor de rescate antes de aplicar " + arg3 + ". Autorizas también restaurar al salir del juego y volver a aplicar " + arg3 + " al regresar al mismo juego, con una sesión nueva y originales verificados. RESTAURAR manual cancela este ciclo; cerrar un panel no lo cancela. El permiso de retorno termina si se reinicia el proceso de Golden. Una aplicación incompleta conserva el rescate de 15 segundos. Si se pierden los permisos del sistema, la recuperación queda pendiente hasta volver a disponer de privilegios.").setPositiveButton("Autorizar " + arg3, new GoldenStretchVisualController$$ExternalSyntheticLambda11(arg5, arg6)).setNegativeButton("Cancelar", new GoldenStretchVisualController$$ExternalSyntheticLambda1(arg6)).create();
        AlertDialog v3 = v2;
        arg4.confirmation = ((Dialog)v3);
        Window v4 = v2.getWindow();
        if(v4 != null) {
            v4.setType(0x7F6);
        }

        v2.setCanceledOnTouchOutside(false);
        v2.setOnCancelListener(new GoldenStretchVisualController$$ExternalSyntheticLambda2(arg6));
        Intrinsics.checkNotNull(v2);
        SessionOverlayWindowsKt.showSessionDialog(((Dialog)v3));
        return Unit.INSTANCE;
    }

    static final void bindControls$lambda$15$lambda$14$lambda$11(View arg0, GoldenStretchPhysicalController arg1, DialogInterface arg2, int arg3) {
        arg0.setEnabled(true);
        arg1.applyConfirmed();
    }

    static final void bindControls$lambda$15$lambda$14$lambda$12(GoldenStretchPhysicalController arg0, DialogInterface arg1, int arg2) {
        arg0.close();
    }

    static final void bindControls$lambda$15$lambda$14$lambda$13(GoldenStretchPhysicalController arg0, DialogInterface arg1) {
        arg0.close();
    }

    static final void bindControls$lambda$16(GoldenStretchVisualController arg7, View arg8) {
        GoldenStretchPhysicalController v8 = arg7.physical;
        if(v8 == null || !v8.isBusy()) {
            v8 = arg7.physical;
            if(v8 != null) {
                v8.close();
            }

            GoldenStretchVisualController.bindControls$newController(arg7);
        }
        else {
        }

        GoldenStretchPhysicalController v0 = arg7.physical;
        if(v0 != null) {
            GoldenStretchPhysicalController.restore$default(v0, false, null, null, null, 15, null);
        }
    }

    static final void bindControls$lambda$17(GoldenStretchVisualController arg0, View arg1) {
        arg0.close();
    }

    private static final GoldenStretchPhysicalController bindControls$newController(GoldenStretchVisualController arg6) {
        GoldenStretchPhysicalController v0 = new GoldenStretchPhysicalController(arg6.context, null, new GoldenStretchVisualController$$ExternalSyntheticLambda0(arg6), 2, null);
        arg6.physical = v0;
        return v0;
    }

    static final Unit bindControls$newController$lambda$5(GoldenStretchVisualController arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "text");
        View v1 = arg1.root;
        if(v1 != null) {
            v1 = v1.findViewById(id.txtEstadoGoldenStretch);
            if(v1 != null) {
                ((TextView)v1).setText(((CharSequence)arg2));
            }
        }

        return Unit.INSTANCE;
    }

    private static final void bindControls$render(SeekBar arg1, GoldenStretchVisualController arg2, TextView arg3, List arg4, View arg5, ColorStateList arg6, ColorStateList arg7, Typeface arg8, Typeface arg9) {
        boolean v4_1;
        arg1.setProgress(arg2.selection.getProgress());
        arg3.setText(arg2.selection.getLabel());
        Iterator v1 = ((Iterable)arg4).iterator();
        while(v1.hasNext()) {
            Object v3 = v1.next();
            int v4 = ((Pair)v3).component1().intValue();
            v3 = ((Pair)v3).component2();
            Integer v0 = arg2.selection.getPreset();
            if(v0 == null) {
                goto label_21;
            }
            else if(v0.intValue() == v4) {
                v4_1 = true;
            }
            else {
            label_21:
                v4_1 = false;
            }

            ((TextView)v3).setSelected(v4_1);
            int v0_1 = v4_1 ? drawable.bg_view_button_gold : drawable.bg_setting;
            ((TextView)v3).setBackgroundResource(v0_1);
            ColorStateList v0_2 = v4_1 ? arg6 : arg7;
            ((TextView)v3).setTextColor(v0_2);
            Typeface v4_2 = v4_1 ? arg8 : arg9;
            ((TextView)v3).setTypeface(v4_2);
        }

        GoldenStretchPanelFactory.stylePresets(arg5);
    }

    public final void close() {
        Dialog v0 = this.dialog;
        if(v0 == null) {
            return;
        }

        Dialog v1 = null;
        this.dialog = v1;
        Dialog v2 = this.confirmation;
        if(v2 != null) {
            v2.dismiss();
        }

        this.confirmation = v1;
        GoldenStretchPhysicalController v2_1 = this.physical;
        if(v2_1 != null) {
            v2_1.close();
        }

        this.physical = ((GoldenStretchPhysicalController)v1);
        this.stopObservingDisplay();
        VisualVisibilityObserver v2_2 = this.visibilityObserver;
        if(v2_2 != null) {
            v2_2.close();
        }

        this.visibilityObserver = ((VisualVisibilityObserver)v1);
        this.root = ((View)v1);
        v0.setOnDismissListener(((DialogInterface$OnDismissListener)v1));
        v0.dismiss();
        this.onClosed.invoke();
    }

    private final Pair readDisplaySize(View arg3) {
        Pair v0 = null;
        try {
            StretchSize v2_1 = new GoldenStretchDisplayReader(this.context).readLogicalSize(arg3.getDisplay());
            if(v2_1 == null) {
                return v0;
            }

            return TuplesKt.to(Integer.valueOf(v2_1.getWidth()), Integer.valueOf(v2_1.getHeight()));
        }
        catch(RuntimeException v2) {
            Log.w("GOLDEN_UI", "No se pudo leer la resolución para la vista previa", ((Throwable)v2));
            return v0;
        }

        return v0;
    }

    private final void reconcileDisplayObservation() {
        VisualVisibilityObserver v0 = this.visibilityObserver;
        if(v0 != null && (v0.getVisible())) {
            if(!this.observingDisplay) {
                DisplayManager v0_1 = this.displays;
                if(v0_1 != null) {
                    v0_1.registerDisplayListener(this.displayListener, new Handler(Looper.getMainLooper()));
                    this.observingDisplay = true;
                }
            }

            this.refreshResolution();
            return;
        }

        this.stopObservingDisplay();
    }

    public final void refreshResolution() {
        View v0 = this.root;
        if(v0 == null) {
            return;
        }

        VisualVisibilityObserver v1 = this.visibilityObserver;
        if(v1 != null && (v1.getVisible())) {
            Pair v3 = this.readDisplaySize(v0);
            v0 = v0.findViewById(id.txtResolucionGoldenStretch);
            String v3_1 = v3 == null ? "No disponible" : v3.getFirst() + " × " + v3.getSecond() + " px";
            ((TextView)v0).setText(((CharSequence)v3_1));
        }
    }

    public final Dialog show() {
        Dialog v0 = this.dialog;
        if(v0 != null) {
            return v0;
        }

        ContextThemeWrapper v0_1 = new ContextThemeWrapper(this.context, style.Theme_MaterialComponents_DayNight_NoActionBar);
        Dialog v1 = new Dialog(v0_1);
        this.dialog = v1;
        try {
            v1.requestWindowFeature(1);
            View v0_3 = GoldenStretchPanelFactory.create(((Context)v0_1));
            this.root = v0_3;
            Intrinsics.checkNotNull(v0_3);
            this.bindControls(v0_3);
            v1.setContentView(v0_3);
            Window v3 = v1.getWindow();
            if(v3 != null) {
                v3.setType(0x7F6);
                v3.setBackgroundDrawable(new ColorDrawable(0));
                v3.clearFlags(2);
                v3.addFlags(0x100);
                v3.setWindowAnimations(0);
                if(Build$VERSION.SDK_INT >= 28) {
                    WindowManager$LayoutParams v4 = v3.getAttributes();
                    int v6 = Build$VERSION.SDK_INT >= 30 ? 3 : 1;
                    v4.layoutInDisplayCutoutMode = v6;
                    v3.setAttributes(v4);
                }

                v3.setGravity(17);
                v3.getDecorView().setPadding(0, 0, 0, 0);
                v3.getDecorView().setSystemUiVisibility(0x1706);
                v1.setCancelable(true);
                v1.setCanceledOnTouchOutside(false);
                v1.setOnDismissListener(new GoldenStretchVisualController$$ExternalSyntheticLambda4(this));
                v0_3 = v0_3.findViewById(id.panelGoldenStretch);
                Intrinsics.checkNotNullExpressionValue(v0_3, "findViewById(...)");
                this.visibilityObserver = new VisualVisibilityObserver(((ViewGroup)v0_3), new GoldenStretchVisualController$$ExternalSyntheticLambda5(this));
                SessionOverlayWindowsKt.showSessionDialog(v1);
                v3.setLayout(-1, -1);
                this.refreshResolution();
                return v1;
            }

            throw new IllegalStateException("Required value was null.".toString());
        }
        catch(Exception v0_2) {
            this.close();
            throw v0_2;
        }
    }

    static final void show$lambda$3(GoldenStretchVisualController arg0, DialogInterface arg1) {
        arg0.close();
    }

    static final Unit show$lambda$4(GoldenStretchVisualController arg0, boolean arg1) {
        arg0.reconcileDisplayObservation();
        return Unit.INSTANCE;
    }

    private final void stopObservingDisplay() {
        if(this.observingDisplay) {
            DisplayManager v0 = this.displays;
            if(v0 != null) {
                v0.unregisterDisplayListener(this.displayListener);
            }
        }

        this.observingDisplay = false;
    }
}

