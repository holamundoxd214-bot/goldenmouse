package com.TryJeanPc.goldenmouse.controls;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout$LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView$ScaleType;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import com.TryJeanPc.goldenmouse.R$drawable;
import com.TryJeanPc.goldenmouse.R$id;
import com.TryJeanPc.goldenmouse.mapper.FreeLookBindings;
import com.TryJeanPc.goldenmouse.mapper.InputBinding;
import com.TryJeanPc.goldenmouse.profile.VistaLibreMarker;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000\u009E\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 P2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001PB\u000F\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\nH\u0002J\u000E\u0010$\u001A\b\u0012\u0004\u0012\u00020&0%H\u0016JB\u0010\'\u001A\u000E\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u001A0\u001E2\u0006\u0010(\u001A\u00020\n2\u0006\u0010)\u001A\u00020\n2\u0006\u0010*\u001A\u00020\n2\u0006\u0010+\u001A\u00020,2\f\u0010-\u001A\b\u0012\u0004\u0012\u00020\u000E0\rH\u0002J\u0010\u0010.\u001A\u00020\u00162\u0006\u0010/\u001A\u000200H\u0016J\u0010\u00101\u001A\u00020\u00162\u0006\u0010/\u001A\u000200H\u0016J\b\u00102\u001A\u00020,H\u0016J\b\u00103\u001A\u000204H\u0016J\b\u00105\u001A\u00020\u000EH\u0016J\b\u00106\u001A\u00020\u000EH\u0016J\u001F\u00107\u001A\u00020\u000E2\u0006\u00108\u001A\u0002092\b\u0010:\u001A\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010;J\b\u0010<\u001A\u00020\u001CH\u0016J\u0018\u0010=\u001A\u00020\u000E2\u000E\u0010>\u001A\n\u0012\u0004\u0012\u00020\u000E\u0018\u00010\rH\u0016J\b\u0010?\u001A\u00020\u000EH\u0016J\b\u0010@\u001A\u00020\u000EH\u0016J\u000E\u0010A\u001A\u00020B2\u0006\u0010C\u001A\u000204J\u000E\u0010D\u001A\u00020\u000E2\u0006\u0010E\u001A\u00020BJ\u000E\u0010F\u001A\u00020\u000E2\u0006\u0010G\u001A\u00020HJn\u0010I\u001A\u00020\u000E2\u0006\u0010J\u001A\u00020\u001C2\u000E\b\u0002\u0010K\u001A\b\u0012\u0004\u0012\u00020\u00160\r2(\b\u0002\u0010L\u001A\"\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u000E0M\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000E0\r\u0018\u00010M2\u0016\b\u0002\u0010N\u001A\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010,0M2\f\u0010O\u001A\b\u0012\u0004\u0012\u00020\u000E0\rR\u0016\u0010\f\u001A\n\u0012\u0004\u0012\u00020\u000E\u0018\u00010\rX\u0082\u000E¢\u0006\u0002\n\u0000R\"\u0010\u000F\u001A\n\u0012\u0004\u0012\u00020\u000E\u0018\u00010\rX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000E\u0010\u0014\u001A\u00020\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001A\u0004\u0018\u00010\u0018X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0019\u001A\u00020\u001AX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001B\u001A\u00020\u001CX\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u001D\u001A\u000E\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u001A0\u001EX\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u001F\u001A\u000E\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u001A0\u001EX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001A\u00020!X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\"\u0010#¨\u0006Q"}, d2={"Lcom/TryJeanPc/goldenmouse/controls/VistaLibreVisual;", "Landroid/widget/FrameLayout;", "Lcom/TryJeanPc/goldenmouse/controls/ControlVisual;", "Lcom/TryJeanPc/goldenmouse/controls/ControlEliminable;", "Lcom/TryJeanPc/goldenmouse/controls/EditorHitRegionProvider;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "dp", "", "value", "onEliminar", "Lkotlin/Function0;", "", "onConfigure", "getOnConfigure", "()Lkotlin/jvm/functions/Function0;", "setOnConfigure", "(Lkotlin/jvm/functions/Function0;)V", "sensibilidad", "reiniciarBorde", "", "teclaActivacion", "Lcom/TryJeanPc/goldenmouse/mapper/InputBinding;", "icono", "Landroid/widget/ImageView;", "borde", "Landroid/view/View;", "configurar", "Lkotlin/Pair;", "eliminar", "editorHitDispatcher", "Lcom/TryJeanPc/goldenmouse/controls/EditorHitDispatcher;", "getEditorHitDispatcher", "()Lcom/TryJeanPc/goldenmouse/controls/EditorHitDispatcher;", "editorHitRegions", "", "Lcom/TryJeanPc/goldenmouse/controls/EditorHitRegion;", "accesorio", "resource", "size", "gravity", "label", "", "onClick", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "onInterceptTouchEvent", "obtenerTipo", "obtenerEstado", "Lcom/TryJeanPc/goldenmouse/controls/ControlVisualState;", "seleccionar", "deseleccionar", "aplicarEstiloVisual", "escala", "", "colorTema", "(FLjava/lang/Integer;)V", "obtenerVistaEliminar", "establecerOnEliminar", "listener", "mostrarEliminar", "ocultarEliminar", "marcadorGuardado", "Lcom/TryJeanPc/goldenmouse/profile/VistaLibreMarker;", "state", "restaurarMarcador", "marker", "dibujarMarcador", "canvas", "Landroid/graphics/Canvas;", "conectarPanel", "root", "guardar", "capturar", "Lkotlin/Function1;", "conflicto", "cerrar", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class VistaLibreVisual extends FrameLayout implements ControlEliminable, ControlVisual, EditorHitRegionProvider {
    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2={"Lcom/TryJeanPc/goldenmouse/controls/VistaLibreVisual$Companion;", "", "<init>", "()V", "TIPO", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    public static final int $stable = 0;
    public static final Companion Companion = null;
    public static final String TIPO = "VISTA_LIBRE_VISUAL";
    private final View borde;
    private final Pair configurar;
    private final EditorHitDispatcher editorHitDispatcher;
    private final Pair eliminar;
    private final ImageView icono;
    private Function0 onConfigure;
    private Function0 onEliminar;
    private boolean reiniciarBorde;
    private int sensibilidad;
    private InputBinding teclaActivacion;

    static {
        VistaLibreVisual.Companion = new Companion(null);
        VistaLibreVisual.$stable = 8;
    }

    public VistaLibreVisual(Context arg12) {
        Intrinsics.checkNotNullParameter(arg12, "context");
        super(arg12);
        this.sensibilidad = 320;
        ImageView v0 = new ImageView(arg12);
        v0.setImageResource(drawable.vista_libre);
        v0.setScaleType(ImageView$ScaleType.FIT_CENTER);
        v0.setContentDescription("Vista libre");
        this.icono = v0;
        View v1 = new View(arg12);
        GradientDrawable v12 = new GradientDrawable();
        v12.setShape(1);
        v12.setColor(0);
        v12.setStroke(this.dp(2), Color.parseColor("#2196F3"));
        v1.setBackground(((Drawable)v12));
        v1.setVisibility(8);
        this.borde = v1;
        VistaLibreVisual v5 = this;
        Pair v11 = v5.accesorio(drawable.settingsbt, 24, 0x800053, "Configurar Vista libre", new VistaLibreVisual$$ExternalSyntheticLambda2(this));
        v5.configurar = v11;
        Pair v12_1 = v5.accesorio(0x1080038, 18, 0x800035, "Eliminar Vista libre", new VistaLibreVisual$$ExternalSyntheticLambda3(v5));
        v5.eliminar = v12_1;
        v5.editorHitDispatcher = new EditorHitDispatcher(v5);
        v5.setTag("vista_libre_visual-" + UUID.randomUUID());
        v5.setClipChildren(false);
        v5.setClipToPadding(false);
        v5.setLayoutParams(new FrameLayout$LayoutParams(v5.dp(90), v5.dp(90), 17));
        v5.addView(((View)v0), new FrameLayout$LayoutParams(v5.dp(38), v5.dp(38), 17));
        v5.addView(v1, new FrameLayout$LayoutParams(v5.dp(28), v5.dp(28), 17));
        Object v0_1 = v12_1.getSecond();
        ((ImageView)v0_1).setColorFilter(-1);
        GradientDrawable v1_1 = new GradientDrawable();
        v1_1.setShape(1);
        v1_1.setColor(Color.parseColor("#99000000"));
        ((ImageView)v0_1).setBackground(((Drawable)v1_1));
        ((ImageView)v0_1).setScaleType(ImageView$ScaleType.CENTER_INSIDE);
        ((ImageView)v0_1).setPadding(v5.dp(2), v5.dp(2), v5.dp(2), v5.dp(2));
        v5.addView(v11.getFirst());
        v5.addView(v12_1.getFirst());
    }

    private final Pair accesorio(int arg5, int arg6, int arg7, String arg8, Function0 arg9) {
        FrameLayout v0 = new FrameLayout(this.getContext());
        v0.setLayoutParams(new FrameLayout$LayoutParams(this.dp(0x30), this.dp(0x30), arg7));
        v0.setVisibility(8);
        v0.setContentDescription(((CharSequence)arg8));
        v0.setFocusable(true);
        v0.setOnClickListener(new VistaLibreVisual$$ExternalSyntheticLambda11(arg9));
        ImageView v7 = new ImageView(this.getContext());
        v7.setImageResource(arg5);
        v7.setScaleType(ImageView$ScaleType.FIT_CENTER);
        v7.setElevation(20f);
        v7.setTranslationZ(20f);
        v0.addView(v7, new FrameLayout$LayoutParams(this.dp(arg6), this.dp(arg6), 17));
        return TuplesKt.to(v0, v7);
    }

    static final void accesorio$lambda$8$lambda$7(Function0 arg0, View arg1) {
        arg0.invoke();
    }

    public static final void access$conectarPanel$detenerCaptura(BooleanRef arg0, ObjectRef arg1) {
        VistaLibreVisual.conectarPanel$detenerCaptura(arg0, arg1);
    }

    public void aplicarEstiloVisual(float arg2, Integer arg3) {
        arg2 = RangesKt.coerceIn(arg2, 0.5f, 1.5f);
        this.icono.setScaleX(arg2);
        this.icono.setScaleY(arg2);
        this.borde.setScaleX(arg2);
        this.borde.setScaleY(arg2);
    }

    public final void conectarPanel(View arg13, Function0 arg14, Function1 arg15, Function1 arg16, Function0 arg17) {
        Intrinsics.checkNotNullParameter(arg13, "root");
        Intrinsics.checkNotNullParameter(arg14, "guardar");
        Intrinsics.checkNotNullParameter(arg16, "conflicto");
        Intrinsics.checkNotNullParameter(arg17, "cerrar");
        View v2 = arg13.findViewById(id.btnTeclaActivacionVistaLibre);
        ObjectRef v5 = new ObjectRef();
        v5.element = this.teclaActivacion;
        BooleanRef v1 = new BooleanRef();
        BooleanRef v6 = new BooleanRef();
        ObjectRef v4 = new ObjectRef();
        VistaLibreVisual.conectarPanel$mostrarTecla(((TextView)v2), v5);
        v2.setOnClickListener(new VistaLibreVisual$$ExternalSyntheticLambda0(v1, ((TextView)v2), arg13, v4, arg15, v6, arg16, this, v5));
        arg13.setOnKeyListener(new VistaLibreVisual$$ExternalSyntheticLambda4(v1, v6, arg16, this, v5, v4, v2));
        arg13.setOnGenericMotionListener(new VistaLibreVisual$$ExternalSyntheticLambda5(v1, v6, arg16, this, v5, v4, v2));
        arg13.setOnTouchListener(new VistaLibreVisual$$ExternalSyntheticLambda6(v1, v6, arg16, this, v5, v4, v2));
        arg13.addOnAttachStateChangeListener(new VistaLibreVisual$conectarPanel$7(v6, v1, v4));
        View v0 = arg13.findViewById(id.txtSensibilidadVistaLibre);
        View v3 = arg13.findViewById(id.seekSensibilidadVistaLibre);
        View v9 = arg13.findViewById(id.toggleReiniciarBordeVistaLibre);
        ((SeekBar)v3).setMin(50);
        ((SeekBar)v3).setMax(1000);
        ((SeekBar)v3).setProgress(this.sensibilidad);
        ((TextView)v0).setText(String.valueOf(this.sensibilidad));
        ((CompoundButton)v9).setChecked(this.reiniciarBorde);
        ((SeekBar)v3).setOnSeekBarChangeListener(new VistaLibreVisual$conectarPanel$8(((TextView)v0)));
        arg13.findViewById(id.btnCancelarVistaLibre).setOnClickListener(new VistaLibreVisual$$ExternalSyntheticLambda7(v6, arg17, v1, v4));
        arg13.findViewById(id.btnGuardarVistaLibre).setOnClickListener(new VistaLibreVisual$$ExternalSyntheticLambda8(this, v3, v9, v5, arg14, v1, v4, v2, v6, arg17));
    }

    private static final void conectarPanel$cerrarPanel(BooleanRef arg1, Function0 arg2, BooleanRef arg3, ObjectRef arg4) {
        arg1.element = true;
        VistaLibreVisual.conectarPanel$detenerCaptura(arg3, arg4);
        arg2.invoke();
    }

    public static void conectarPanel$default(VistaLibreVisual arg6, View arg7, Function0 arg8, Function1 arg9, Function1 arg10, Function0 arg11, int arg12, Object arg13) {
        VistaLibreVisual$conectarPanel$2 v10;
        VistaLibreVisual$$ExternalSyntheticLambda1 v8;
        if((arg12 & 2) != 0) {
            v8 = new VistaLibreVisual$$ExternalSyntheticLambda1();
        }

        Function0 v2 = ((Function0)v8);
        if((arg12 & 4) != 0) {
            arg9 = null;
        }

        Function1 v3 = arg9;
        if((arg12 & 8) != 0) {
            v10 = VistaLibreVisual$conectarPanel$2.INSTANCE;
        }

        arg6.conectarPanel(arg7, v2, v3, ((Function1)v10), arg11);
    }

    private static final void conectarPanel$detenerCaptura(BooleanRef arg1, ObjectRef arg2) {
        arg1.element = false;
        Object v1 = arg2.element;
        if(v1 != null) {
            ((Function0)v1).invoke();
        }

        arg2.element = null;
    }

    static final boolean conectarPanel$lambda$11() {
        return 1;
    }

    static final void conectarPanel$lambda$14(BooleanRef arg9, TextView arg10, View arg11, ObjectRef arg12, Function1 arg13, BooleanRef arg14, Function1 arg15, VistaLibreVisual arg16, ObjectRef arg17, View arg18) {
        VistaLibreVisual.conectarPanel$detenerCaptura(arg9, arg12);
        arg9.element = true;
        arg10.setText("Pulse una tecla o botón del mouse");
        arg11.setFocusableInTouchMode(true);
        arg11.requestFocus();
        Object v0 = arg13 != null ? arg13.invoke(new VistaLibreVisual$$ExternalSyntheticLambda12(arg11, arg14, arg9, arg15, arg16, arg17, arg12, arg10)) : null;
        arg12.element = v0;
    }

    static final Unit conectarPanel$lambda$14$lambda$13(View arg10, BooleanRef arg11, BooleanRef arg12, Function1 arg13, VistaLibreVisual arg14, ObjectRef arg15, ObjectRef arg16, TextView arg17, InputBinding arg18) {
        InputBinding v2 = arg18;
        Intrinsics.checkNotNullParameter(v2, "binding");
        if(Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            VistaLibreVisual.conectarPanel$recibir(arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18);
        }
        else {
            arg10.post(new VistaLibreVisual$$ExternalSyntheticLambda9(v2, arg11, arg12, arg13, arg14, arg15, arg16, arg17));
        }

        return Unit.INSTANCE;
    }

    static final void conectarPanel$lambda$14$lambda$13$lambda$12(InputBinding arg1, BooleanRef arg2, BooleanRef arg3, Function1 arg4, VistaLibreVisual arg5, ObjectRef arg6, ObjectRef arg7, TextView arg8) {
        VistaLibreVisual.conectarPanel$recibir(arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg1);
    }

    static final boolean conectarPanel$lambda$16(BooleanRef arg9, BooleanRef arg10, Function1 arg11, VistaLibreVisual arg12, ObjectRef arg13, ObjectRef arg14, TextView arg15, View arg16, int arg17, KeyEvent arg18) {
        if(!arg9.element) {
            return 0;
        }

        com.TryJeanPc.goldenmouse.controls.VistaActivationCapture$Companion v0 = VistaActivationCapture.Companion;
        Intrinsics.checkNotNull(arg18);
        InputBinding v7 = v0.fromKeyEvent(arg18);
        if(v7 != null) {
            VistaLibreVisual.conectarPanel$recibir(arg10, arg9, arg11, arg12, arg13, arg14, arg15, v7);
            return 1;
        }

        return 0;
    }

    static final boolean conectarPanel$lambda$18(BooleanRef arg9, BooleanRef arg10, Function1 arg11, VistaLibreVisual arg12, ObjectRef arg13, ObjectRef arg14, TextView arg15, View arg16, MotionEvent arg17) {
        if(!arg9.element) {
            return 0;
        }

        com.TryJeanPc.goldenmouse.controls.VistaActivationCapture$Companion v0 = VistaActivationCapture.Companion;
        Intrinsics.checkNotNull(arg17);
        InputBinding v7 = v0.fromMotionEvent(arg17);
        if(v7 != null) {
            VistaLibreVisual.conectarPanel$recibir(arg10, arg9, arg11, arg12, arg13, arg14, arg15, v7);
            return 1;
        }

        return 0;
    }

    static final boolean conectarPanel$lambda$20(BooleanRef arg9, BooleanRef arg10, Function1 arg11, VistaLibreVisual arg12, ObjectRef arg13, ObjectRef arg14, TextView arg15, View arg16, MotionEvent arg17) {
        MotionEvent v0 = arg17;
        if(arg9.element) {
            if(!v0.isFromSource(0x2002)) {
            }
            else {
                com.TryJeanPc.goldenmouse.controls.VistaActivationCapture$Companion v2 = VistaActivationCapture.Companion;
                Intrinsics.checkNotNull(v0);
                InputBinding v7 = v2.fromMotionEvent(v0);
                if(v7 != null) {
                    VistaLibreVisual.conectarPanel$recibir(arg10, arg9, arg11, arg12, arg13, arg14, arg15, v7);
                    return 1;
                }
            }
        }

        return 0;
    }

    static final void conectarPanel$lambda$21(BooleanRef arg0, Function0 arg1, BooleanRef arg2, ObjectRef arg3, View arg4) {
        VistaLibreVisual.conectarPanel$cerrarPanel(arg0, arg1, arg2, arg3);
    }

    static final void conectarPanel$lambda$22(VistaLibreVisual arg2, SeekBar arg3, CompoundButton arg4, ObjectRef arg5, Function0 arg6, BooleanRef arg7, ObjectRef arg8, TextView arg9, BooleanRef arg10, Function0 arg11, View arg12) {
        VistaLibreVisual.conectarPanel$detenerCaptura(arg7, arg8);
        VistaLibreVisual.conectarPanel$mostrarTecla(arg9, arg5);
        Triple v9 = new Triple(Integer.valueOf(arg2.sensibilidad), Boolean.valueOf(arg2.reiniciarBorde), arg2.teclaActivacion);
        arg2.sensibilidad = arg3.getProgress();
        arg2.reiniciarBorde = arg4.isChecked();
        arg2.teclaActivacion = arg5.element;
        if(arg6.invoke().booleanValue()) {
            VistaLibreVisual.conectarPanel$cerrarPanel(arg10, arg11, arg7, arg8);
            return;
        }

        arg2.sensibilidad = v9.getFirst().intValue();
        arg2.reiniciarBorde = v9.getSecond().booleanValue();
        arg2.teclaActivacion = v9.getThird();
    }

    private static final void conectarPanel$mostrarTecla(TextView arg2, ObjectRef arg3) {
        String v3_1;
        Object v3 = arg3.element;
        if(v3 != null) {
            v3_1 = ((InputBinding)v3).displayName();
            if(v3_1 != null) {
            }
            else {
                goto label_5;
            }
        }
        else {
        label_5:
            v3_1 = "Sin asignar";
        }

        arg2.setText(((CharSequence)v3_1));
        arg2.setContentDescription("Asignar tecla Vista libre: " + arg2.getText());
    }

    private static final void conectarPanel$recibir(BooleanRef arg0, BooleanRef arg1, Function1 arg2, VistaLibreVisual arg3, ObjectRef arg4, ObjectRef arg5, TextView arg6, InputBinding arg7) {
        Object v0_1;
        if(!arg0.element) {
            if(!arg1.element) {
            }
            else {
                if(!FreeLookBindings.INSTANCE.isAllowed(arg7)) {
                    String v0 = "Entrada no válida; LEFT está reservado para FIRE";
                }
                else {
                    v0_1 = arg2.invoke(arg7);
                }

                if((((String)v0_1)) != null) {
                    Toast.makeText(arg3.getContext(), ((CharSequence)v0_1), 1).show();
                    return;
                }

                arg4.element = arg7;
                VistaLibreVisual.conectarPanel$detenerCaptura(arg1, arg5);
                VistaLibreVisual.conectarPanel$mostrarTecla(arg6, arg4);
            }
        }
    }

    static final Unit configurar$lambda$3(VistaLibreVisual arg0) {
        Function0 v0 = arg0.onConfigure;
        if(v0 != null) {
            v0.invoke();
        }

        return Unit.INSTANCE;
    }

    public void deseleccionar() {
        this.borde.setVisibility(8);
        this.ocultarEliminar();
    }

    public final void dibujarMarcador(Canvas arg4) {
        Intrinsics.checkNotNullParameter(arg4, "canvas");
        this.drawChild(arg4, this.icono, this.getDrawingTime());
    }

    public boolean dispatchTouchEvent(MotionEvent arg3) {
        Intrinsics.checkNotNullParameter(arg3, "event");
        return this.getEditorHitDispatcher().dispatch(arg3, new VistaLibreVisual$$ExternalSyntheticLambda10(this));
    }

    static final boolean dispatchTouchEvent$lambda$10(VistaLibreVisual arg1, MotionEvent arg2) {
        Intrinsics.checkNotNullParameter(arg2, "it");
        return super.dispatchTouchEvent(arg2);
    }

    private final int dp(int arg1) {
        return ((int)((((float)arg1)) * this.getResources().getDisplayMetrics().density));
    }

    public List editorHitRegions() {
        return CollectionsKt.listOf(new EditorHitRegion[]{new EditorHitRegion(this.icono, EditorHitShapes.INSTANCE.getCircle(), null, 0f, false, 28, null), new EditorHitRegion(this.configurar.getSecond(), EditorHitShapes.INSTANCE.getOval(), this.configurar.getFirst(), 0f, false, 24, null), new EditorHitRegion(this.eliminar.getSecond(), EditorHitShapes.INSTANCE.getOval(), this.eliminar.getFirst(), 0f, false, 24, null)});
    }

    static final Unit eliminar$lambda$4(VistaLibreVisual arg0) {
        Function0 v0 = arg0.onEliminar;
        if(v0 != null) {
            v0.invoke();
        }

        return Unit.INSTANCE;
    }

    public void establecerOnEliminar(Function0 arg1) {
        this.onEliminar = arg1;
    }

    public EditorHitDispatcher getEditorHitDispatcher() {
        return this.editorHitDispatcher;
    }

    public final Function0 getOnConfigure() {
        return this.onConfigure;
    }

    public final VistaLibreMarker marcadorGuardado(ControlVisualState arg11) {
        Intrinsics.checkNotNullParameter(arg11, "state");
        Object v0 = this.getTag();
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type kotlin.String");
        return new VistaLibreMarker(v0, arg11.getX(), arg11.getY(), arg11.getWidth(), arg11.getHeight(), this.sensibilidad, this.reiniciarBorde, this.teclaActivacion);
    }

    public void mostrarEliminar() {
        this.configurar.getFirst().setVisibility(0);
        this.eliminar.getFirst().setVisibility(0);
    }

    public ControlVisualState obtenerEstado() {
        return new ControlVisualState("VISTA_LIBRE_VISUAL", this.getX(), this.getY(), this.getWidth(), this.getHeight(), null, 0x20, null);
    }

    public String obtenerTipo() {
        return "VISTA_LIBRE_VISUAL";
    }

    public View obtenerVistaEliminar() {
        return this.eliminar.getFirst();
    }

    public void ocultarEliminar() {
        this.configurar.getFirst().setVisibility(8);
        this.eliminar.getFirst().setVisibility(8);
    }

    public boolean onInterceptTouchEvent(MotionEvent arg2) {
        Intrinsics.checkNotNullParameter(arg2, "event");
        if(!this.getEditorHitDispatcher().isBodyGesture()) {
            if(super.onInterceptTouchEvent(arg2)) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public final void restaurarMarcador(VistaLibreMarker arg4) {
        Intrinsics.checkNotNullParameter(arg4, "marker");
        this.setTag(arg4.getId());
        this.sensibilidad = RangesKt.coerceIn(arg4.getSensitivity(), 50, 1000);
        this.reiniciarBorde = arg4.getResetOnEdge();
        this.teclaActivacion = arg4.getActivationBinding();
    }

    public void seleccionar() {
        this.bringToFront();
        this.borde.setVisibility(0);
        this.mostrarEliminar();
    }

    public final void setOnConfigure(Function0 arg1) {
        this.onConfigure = arg1;
    }
}

