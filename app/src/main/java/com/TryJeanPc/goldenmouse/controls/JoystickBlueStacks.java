package com.TryJeanPc.goldenmouse.controls;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff$Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.widget.FrameLayout$LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView$ScaleType;
import android.widget.ImageView;
import android.widget.TextView;
import com.TryJeanPc.goldenmouse.R$drawable;
import com.TryJeanPc.goldenmouse.mapper.InputBinding;
import com.TryJeanPc.goldenmouse.profile.ControlComponent;
import com.TryJeanPc.goldenmouse.profile.JoystickComponent;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0007\u0018\u0000 x2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0001xB\u000F\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000E\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\u0010\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u001AH\u0016J\u0010\u0010\u001B\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u001AH\u0016J(\u0010>\u001A\u00020\u001E2\u0006\u0010?\u001A\u00020=2\u0006\u0010@\u001A\u00020=2\u0006\u0010A\u001A\u00020=2\u0006\u0010B\u001A\u00020=H\u0014J\u0010\u0010C\u001A\u00020\u001E2\u0006\u0010D\u001A\u00020=H\u0002J\b\u0010E\u001A\u00020\u001EH\u0016J\b\u0010F\u001A\u00020\u001EH\u0016J\u0010\u0010G\u001A\u00020\u001E2\u0006\u0010H\u001A\u00020)H\u0016J\b\u0010I\u001A\u00020)H\u0016J\u000E\u0010J\u001A\b\u0012\u0004\u0012\u00020)0\u0010H\u0016J\u0018\u0010K\u001A\u00020\u001E2\u0006\u0010L\u001A\u00020)2\u0006\u0010M\u001A\u00020*H\u0016J\u000E\u0010O\u001A\u00020\u001E2\u0006\u0010P\u001A\u00020\u0018J\u0006\u0010Q\u001A\u00020\u0018J\u000E\u0010R\u001A\u00020\u001E2\u0006\u0010S\u001A\u00020TJ\u0014\u0010U\u001A\u000E\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020*0VH\u0016J\b\u0010W\u001A\u00020XH\u0016J\u0010\u0010Y\u001A\u00020\u001E2\u0006\u0010!\u001A\u00020XH\u0016J\u0018\u0010Z\u001A\u00020\u001E2\u000E\u0010[\u001A\n\u0012\u0004\u0012\u00020\u001E\u0018\u00010\u001DH\u0016J\u0018\u0010\\\u001A\u00020\u001E2\u000E\u0010[\u001A\n\u0012\u0004\u0012\u00020\u001E\u0018\u00010\u001DH\u0016J\b\u0010]\u001A\u00020)H\u0016J\b\u0010^\u001A\u00020\u001EH\u0016J\b\u0010_\u001A\u00020\u001EH\u0016J\b\u0010c\u001A\u00020dH\u0016J\u001F\u0010e\u001A\u00020\u001E2\u0006\u0010f\u001A\u00020T2\b\u0010g\u001A\u0004\u0018\u00010=H\u0016¢\u0006\u0002\u0010hJ\n\u0010i\u001A\u0004\u0018\u00010.H\u0016J\u0018\u0010j\u001A\u00020\u001E2\u000E\u0010[\u001A\n\u0012\u0004\u0012\u00020\u001E\u0018\u00010\u001DH\u0016J\b\u0010k\u001A\u00020\u001EH\u0016J\b\u0010l\u001A\u00020\u001EH\u0016J\u0010\u0010m\u001A\u0002002\u0006\u0010n\u001A\u00020)H\u0002J\u0010\u0010o\u001A\u00020\u001E2\u0006\u0010D\u001A\u00020=H\u0002J\u0010\u0010p\u001A\u00020\u001E2\u0006\u0010D\u001A\u00020=H\u0002J(\u0010q\u001A\u00020\u001E2\u0006\u0010r\u001A\u00020.2\u0006\u0010s\u001A\u00020=2\u0006\u0010t\u001A\u00020=2\u0006\u0010u\u001A\u00020=H\u0002J\u0010\u0010v\u001A\u00020\u001E2\u0006\u0010w\u001A\u00020\u0018H\u0002R\u0014\u0010\u000B\u001A\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER!\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00110\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001A\u0004\b\u0012\u0010\u0013R\u0016\u0010\u001C\u001A\n\u0012\u0004\u0012\u00020\u001E\u0018\u00010\u001DX\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010\u001F\u001A\n\u0012\u0004\u0012\u00020\u001E\u0018\u00010\u001DX\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010 \u001A\n\u0012\u0004\u0012\u00020\u001E\u0018\u00010\u001DX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010!\u001A\u00020\"X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010#\u001A\u00020$X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b%\u0010&R*\u0010\'\u001A\u001E\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020*0(j\u000E\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020*`+X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010,\u001A\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010-\u001A\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010/\u001A\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u00101\u001A\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u00102\u001A\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u00103\u001A\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u00104\u001A\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u00105\u001A\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u00106\u001A\u00020\u0018X\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b7\u00108\"\u0004\b9\u0010:R\u001A\u0010;\u001A\u000E\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020=0<X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010N\u001A\u00020\u0018X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010`\u001A\u00020TX\u0082\u000E¢\u0006\u0002\n\u0000R\u0012\u0010a\u001A\u0004\u0018\u00010=X\u0082\u000E¢\u0006\u0004\n\u0002\u0010b¨\u0006y"}, d2={"Lcom/TryJeanPc/goldenmouse/controls/JoystickBlueStacks;", "Landroid/widget/FrameLayout;", "Lcom/TryJeanPc/goldenmouse/controls/BotonEditable;", "Lcom/TryJeanPc/goldenmouse/controls/ControlVisual;", "Lcom/TryJeanPc/goldenmouse/controls/ProfileComponentControl;", "Lcom/TryJeanPc/goldenmouse/controls/ControlEliminable;", "Lcom/TryJeanPc/goldenmouse/controls/EditorHitRegionProvider;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "editorHitDispatcher", "Lcom/TryJeanPc/goldenmouse/controls/EditorHitDispatcher;", "getEditorHitDispatcher", "()Lcom/TryJeanPc/goldenmouse/controls/EditorHitDispatcher;", "editorRegions", "", "Lcom/TryJeanPc/goldenmouse/controls/EditorHitRegion;", "getEditorRegions", "()Ljava/util/List;", "editorRegions$delegate", "Lkotlin/Lazy;", "editorHitRegions", "dispatchTouchEvent", "", "event", "Landroid/view/MotionEvent;", "onInterceptTouchEvent", "onEliminar", "Lkotlin/Function0;", "", "onConfigure", "onComponentChanged", "component", "Lcom/TryJeanPc/goldenmouse/profile/JoystickComponent;", "botonCerrarX", "Landroid/widget/ImageView;", "getBotonCerrarX", "()Landroid/widget/ImageView;", "bindings", "Ljava/util/LinkedHashMap;", "", "Lcom/TryJeanPc/goldenmouse/mapper/InputBinding;", "Lkotlin/collections/LinkedHashMap;", "joystickImage", "bordeSeleccion", "Landroid/view/View;", "teclaW", "Landroid/widget/TextView;", "teclaA", "teclaS", "teclaD", "botonConfigurar", "botonRedimensionar", "estaEnModoEdicion", "getEstaEnModoEdicion", "()Z", "setEstaEnModoEdicion", "(Z)V", "dp", "Lkotlin/Function1;", "", "onSizeChanged", "w", "h", "oldw", "oldh", "actualizarDiseno", "sizePx", "activarEdicion", "desactivarEdicion", "actualizarTecla", "nuevaTecla", "obtenerTeclaActual", "bindingSlots", "updateBinding", "slot", "binding", "keysVisible", "setKeysVisible", "visible", "areKeysVisible", "updateRadiusLive", "radius", "", "currentBindings", "", "currentComponent", "Lcom/TryJeanPc/goldenmouse/profile/ControlComponent;", "applyComponent", "setOnConfigure", "listener", "setOnComponentChanged", "obtenerTipo", "seleccionar", "deseleccionar", "escalaVisual", "colorTemaActual", "Ljava/lang/Integer;", "obtenerEstado", "Lcom/TryJeanPc/goldenmouse/controls/ControlVisualState;", "aplicarEstiloVisual", "escala", "colorTema", "(FLjava/lang/Integer;)V", "obtenerVistaEliminar", "establecerOnEliminar", "mostrarEliminar", "ocultarEliminar", "crearTeclaVisual", "texto", "posicionarTeclas", "ajustarBotonesFlotantes", "colocar", "view", "x", "y", "size", "resizeQuick", "grow", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class JoystickBlueStacks extends FrameLayout implements BotonEditable, ControlEliminable, ControlVisual, EditorHitRegionProvider, ProfileComponentControl {
    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2={"Lcom/TryJeanPc/goldenmouse/controls/JoystickBlueStacks$Companion;", "", "<init>", "()V", "TAG", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    public static final int $stable = 0;
    private static final Companion Companion = null;
    @Deprecated public static final String TAG = "GOLDEN_UI";
    private final LinkedHashMap bindings;
    private final View bordeSeleccion;
    private final ImageView botonCerrarX;
    private final ImageView botonConfigurar;
    private final TextView botonRedimensionar;
    private Integer colorTemaActual;
    private JoystickComponent component;
    private final Function1 dp;
    private final EditorHitDispatcher editorHitDispatcher;
    private final Lazy editorRegions$delegate;
    private float escalaVisual;
    private boolean estaEnModoEdicion;
    private final ImageView joystickImage;
    private boolean keysVisible;
    private Function0 onComponentChanged;
    private Function0 onConfigure;
    private Function0 onEliminar;
    private final TextView teclaA;
    private final TextView teclaD;
    private final TextView teclaS;
    private final TextView teclaW;

    static {
        JoystickBlueStacks.Companion = new Companion(null);
        JoystickBlueStacks.$stable = 8;
    }

    public JoystickBlueStacks(Context arg24) {
        Intrinsics.checkNotNullParameter(arg24, "context");
        super(arg24);
        this.editorHitDispatcher = new EditorHitDispatcher(this);
        this.editorRegions$delegate = LazyKt.lazy(new JoystickBlueStacks$$ExternalSyntheticLambda0(this));
        this.component = new JoystickComponent(0f, 0f, 0f, 0f, 0f, 0f, 0, 0f, false, 0f, 0, false, null, 0f, false, 0x7FFF, null);
        ImageView v2 = new ImageView(arg24);
        v2.setImageResource(0x1080038);
        v2.setColorFilter(-1);
        v2.setScaleType(ImageView$ScaleType.CENTER_INSIDE);
        v2.setPadding(4, 4, 4, 4);
        GradientDrawable v5 = new GradientDrawable();
        v5.setShape(1);
        v5.setColor(0xFF000000);
        v2.setBackground(((Drawable)v5));
        FrameLayout$LayoutParams v5_1 = new FrameLayout$LayoutParams(0, 0);
        v5_1.gravity = 0x800035;
        v2.setLayoutParams(((ViewGroup$LayoutParams)v5_1));
        v2.setVisibility(8);
        v2.setContentDescription("Eliminar joystick");
        v2.setOnClickListener(new JoystickBlueStacks$$ExternalSyntheticLambda1(this));
        this.botonCerrarX = v2;
        this.bindings = MapsKt.linkedMapOf(new Pair[]{TuplesKt.to("UP", InputBinding.Companion.keyboard("W")), TuplesKt.to("LEFT", InputBinding.Companion.keyboard("A")), TuplesKt.to("DOWN", InputBinding.Companion.keyboard("S")), TuplesKt.to("RIGHT", InputBinding.Companion.keyboard("D"))});
        v2 = new ImageView(arg24);
        this.joystickImage = v2;
        View v4 = new View(arg24);
        this.bordeSeleccion = v4;
        TextView v8 = this.crearTeclaVisual("W");
        this.teclaW = v8;
        TextView v9 = this.crearTeclaVisual("A");
        this.teclaA = v9;
        TextView v10 = this.crearTeclaVisual("S");
        this.teclaS = v10;
        TextView v12 = this.crearTeclaVisual("D");
        this.teclaD = v12;
        ImageView v13 = new ImageView(arg24);
        this.botonConfigurar = v13;
        TextView v14 = new TextView(arg24);
        this.botonRedimensionar = v14;
        JoystickBlueStacks$$ExternalSyntheticLambda2 v15 = new JoystickBlueStacks$$ExternalSyntheticLambda2(arg24);
        this.dp = ((Function1)v15);
        this.setClipChildren(false);
        this.setClipToPadding(false);
        int v1 = ((Function1)v15).invoke(Integer.valueOf(150)).intValue();
        FrameLayout$LayoutParams v11 = new FrameLayout$LayoutParams(v1, v1);
        v11.gravity = 17;
        this.setLayoutParams(((ViewGroup$LayoutParams)v11));
        v2.setImageResource(drawable.joystick_component);
        v2.setScaleType(ImageView$ScaleType.FIT_CENTER);
        v2.setLayoutParams(new FrameLayout$LayoutParams(-1, -1));
        GradientDrawable v11_1 = new GradientDrawable();
        v11_1.setShape(1);
        v11_1.setColor(0);
        v11_1.setStroke(((Function1)v15).invoke(Integer.valueOf(2)).intValue(), Color.parseColor("#2196F3"));
        v4.setBackground(((Drawable)v11_1));
        v4.setLayoutParams(new FrameLayout$LayoutParams(-1, -1));
        v4.setVisibility(8);
        v4.setClickable(false);
        v4.setFocusable(false);
        this.addView(((View)v2));
        this.addView(((View)v8));
        this.addView(((View)v9));
        this.addView(((View)v10));
        this.addView(((View)v12));
        this.addView(v4);
        v13.setImageResource(drawable.settingsbt);
        v13.setBackground(null);
        v13.setScaleType(ImageView$ScaleType.FIT_CENTER);
        v13.setElevation(16f);
        v13.setTranslationZ(16f);
        v13.setContentDescription("Configurar joystick");
        v13.setOnClickListener(new JoystickBlueStacks$$ExternalSyntheticLambda3(this));
        v13.setVisibility(8);
        this.addView(((View)v13));
        v14.setText("◇");
        v14.setGravity(17);
        v14.setTextColor(-1);
        GradientDrawable v2_1 = new GradientDrawable();
        v2_1.setShape(1);
        v2_1.setColor(Color.parseColor("#CC16366F"));
        v14.setBackground(((Drawable)v2_1));
        v14.setContentDescription("Cambiar tamaño");
        v14.setOnClickListener(new JoystickBlueStacks$$ExternalSyntheticLambda4(this));
        v14.setOnLongClickListener(new JoystickBlueStacks$$ExternalSyntheticLambda5(this));
        v14.setVisibility(8);
        this.addView(((View)v14));
        this.addView(this.getBotonCerrarX());
        this.actualizarDiseno(v1);
        Log.d("GOLDEN_UI", "Joystick WASD adaptativo matemático creado");
        this.keysVisible = true;
        this.escalaVisual = 1f;
    }

    public void activarEdicion() {
        this.setEstaEnModoEdicion(true);
        this.bordeSeleccion.setVisibility(0);
        this.botonConfigurar.setVisibility(0);
        this.botonRedimensionar.setVisibility(0);
        this.mostrarEliminar();
    }

    private final void actualizarDiseno(int arg1) {
        this.posicionarTeclas(arg1);
        this.ajustarBotonesFlotantes(arg1);
    }

    public void actualizarTecla(String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "nuevaTecla");
        InputBinding v2 = InputBinding.Companion.fromDisplayName(arg2);
        if(v2 != null) {
            this.updateBinding("UP", v2);
        }
    }

    private final void ajustarBotonesFlotantes(int arg5) {
        float v5 = this.getContext().getResources().getDisplayMetrics().density;
        int v0 = ((int)(26f * v5));
        arg5 = ((int)(-4f * v5));
        ImageView v1 = this.getBotonCerrarX();
        FrameLayout$LayoutParams v2 = new FrameLayout$LayoutParams(v0, v0);
        v2.gravity = 0x800035;
        v2.topMargin = arg5;
        v2.setMarginEnd(arg5);
        v1.setLayoutParams(((ViewGroup$LayoutParams)v2));
        v1 = this.botonConfigurar;
        v2 = new FrameLayout$LayoutParams(v0, v0);
        v2.gravity = 0x800053;
        v2.bottomMargin = arg5;
        v2.setMarginStart(arg5);
        v1.setLayoutParams(((ViewGroup$LayoutParams)v2));
        this.botonConfigurar.setPadding(0, 0, 0, 0);
        TextView v1_1 = this.botonRedimensionar;
        v2 = new FrameLayout$LayoutParams(v0, v0);
        v2.gravity = 0x800055;
        v2.bottomMargin = arg5;
        v2.setMarginEnd(arg5);
        v1_1.setLayoutParams(((ViewGroup$LayoutParams)v2));
        this.botonRedimensionar.setTextSize(2, 13f);
    }

    public void aplicarEstiloVisual(float arg3, Integer arg4) {
        int v3_1;
        arg3 = RangesKt.coerceIn(arg3, 0.5f, 1.5f);
        this.escalaVisual = arg3;
        this.colorTemaActual = arg4;
        this.joystickImage.setScaleX(arg3);
        this.joystickImage.setScaleY(arg3);
        this.bordeSeleccion.setScaleX(arg3);
        this.bordeSeleccion.setScaleY(arg3);
        ImageView v3 = this.joystickImage;
        if(arg4 != null) {
            v3.setColorFilter(arg4.intValue(), PorterDuff$Mode.MULTIPLY);
        }
        else {
            v3.clearColorFilter();
        }

        if(this.getWidth() <= 0 || this.getHeight() <= 0) {
            ViewGroup$LayoutParams v3_2 = this.getLayoutParams();
            Integer v3_3 = v3_2 != null ? Integer.valueOf(v3_2.width) : null;
            if(v3_3 != null && this.getLayoutParams().width > 0) {
                v3_1 = this.getLayoutParams().width;
                goto label_46;
            }

            v3_1 = this.dp.invoke(Integer.valueOf(150)).intValue();
        }
        else {
            v3_1 = Math.min(this.getWidth(), this.getHeight());
        }

    label_46:
        this.posicionarTeclas(v3_1);
        this.requestLayout();
    }

    public void applyComponent(ControlComponent arg2) {
        Intrinsics.checkNotNullParameter(arg2, "component");
        if((arg2 instanceof JoystickComponent)) {
            this.component = ((JoystickComponent)arg2);
        }
    }

    public final boolean areKeysVisible() {
        return this.keysVisible;
    }

    public List bindingSlots() {
        return CollectionsKt.listOf(new String[]{"UP", "LEFT", "DOWN", "RIGHT"});
    }

    static final void botonCerrarX$lambda$5$lambda$4(JoystickBlueStacks arg0, View arg1) {
        Function0 v0 = arg0.onEliminar;
        if(v0 != null) {
            v0.invoke();
        }
    }

    private final void colocar(View arg1, int arg2, int arg3, int arg4) {
        FrameLayout$LayoutParams v0 = new FrameLayout$LayoutParams(arg4, arg4);
        v0.leftMargin = arg2;
        v0.topMargin = arg3;
        arg1.setLayoutParams(((ViewGroup$LayoutParams)v0));
    }

    private final TextView crearTeclaVisual(String arg2) {
        TextView v0 = new TextView(this.getContext());
        v0.setText(((CharSequence)arg2));
        v0.setGravity(17);
        v0.setTextColor(0xFF000000);
        v0.setTypeface(Typeface.DEFAULT_BOLD);
        v0.setIncludeFontPadding(false);
        v0.setPadding(0, 0, 0, 0);
        v0.setClickable(false);
        v0.setFocusable(false);
        return v0;
    }

    public Map currentBindings() {
        return MapsKt.toMap(this.bindings);
    }

    public ControlComponent currentComponent() {
        return this.component;
    }

    public void desactivarEdicion() {
        this.setEstaEnModoEdicion(false);
        this.bordeSeleccion.setVisibility(8);
        this.botonConfigurar.setVisibility(8);
        this.botonRedimensionar.setVisibility(8);
        this.ocultarEliminar();
    }

    public void deseleccionar() {
        this.desactivarEdicion();
    }

    public boolean dispatchTouchEvent(MotionEvent arg3) {
        Intrinsics.checkNotNullParameter(arg3, "event");
        return this.getEditorHitDispatcher().dispatch(arg3, new JoystickBlueStacks$$ExternalSyntheticLambda6(this));
    }

    static final boolean dispatchTouchEvent$lambda$1(JoystickBlueStacks arg1, MotionEvent arg2) {
        Intrinsics.checkNotNullParameter(arg2, "it");
        return super.dispatchTouchEvent(arg2);
    }

    static final int dp$lambda$6(Context arg0, int arg1) {
        return ((int)((((float)arg1)) * arg0.getResources().getDisplayMetrics().density));
    }

    public List editorHitRegions() {
        return this.getEditorRegions();
    }

    static final List editorRegions_delegate$lambda$0(JoystickBlueStacks arg18) {
        return CollectionsKt.listOf(new EditorHitRegion[]{new EditorHitRegion(arg18.joystickImage, EditorHitShapes.INSTANCE.getCircle(), null, 0f, false, 28, null), new EditorHitRegion(arg18.teclaW, null, null, 0f, false, 30, null), new EditorHitRegion(arg18.teclaA, null, null, 0f, false, 30, null), new EditorHitRegion(arg18.teclaS, null, null, 0f, false, 30, null), new EditorHitRegion(arg18.teclaD, null, null, 0f, false, 30, null), new EditorHitRegion(arg18.botonConfigurar, EditorHitShapes.INSTANCE.getOval(), arg18.botonConfigurar, 0f, false, 24, null), new EditorHitRegion(arg18.getBotonCerrarX(), EditorHitShapes.INSTANCE.getOval(), arg18.getBotonCerrarX(), 0f, false, 24, null), new EditorHitRegion(arg18.botonRedimensionar, EditorHitShapes.INSTANCE.getOval(), arg18.botonRedimensionar, 0f, false, 24, null)});
    }

    public void establecerOnEliminar(Function0 arg1) {
        this.onEliminar = arg1;
    }

    public ImageView getBotonCerrarX() {
        return this.botonCerrarX;
    }

    public EditorHitDispatcher getEditorHitDispatcher() {
        return this.editorHitDispatcher;
    }

    private final List getEditorRegions() {
        return this.editorRegions$delegate.getValue();
    }

    public boolean getEstaEnModoEdicion() {
        return this.estaEnModoEdicion;
    }

    static final void lambda$12$lambda$11(JoystickBlueStacks arg0, View arg1) {
        Function0 v0 = arg0.onConfigure;
        if(v0 != null) {
            v0.invoke();
        }
    }

    static final void lambda$16$lambda$14(JoystickBlueStacks arg0, View arg1) {
        arg0.resizeQuick(true);
    }

    static final boolean lambda$16$lambda$15(JoystickBlueStacks arg0, View arg1) {
        arg0.resizeQuick(false);
        return 1;
    }

    public void mostrarEliminar() {
        this.getBotonCerrarX().setVisibility(0);
    }

    public ControlVisualState obtenerEstado() {
        return new ControlVisualState(this.obtenerTipo(), this.getX(), this.getY(), this.getWidth(), this.getHeight(), null);
    }

    public String obtenerTeclaActual() {
        Object v1 = this.bindings.get("UP");
        String v1_1 = v1 != null ? ((InputBinding)v1).displayName() : null;
        if(v1_1 == null) {
            v1_1 = "";
        }

        return v1_1;
    }

    public String obtenerTipo() {
        return "JOYSTICK";
    }

    public View obtenerVistaEliminar() {
        return this.getBotonCerrarX();
    }

    public void ocultarEliminar() {
        this.getBotonCerrarX().setVisibility(8);
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

    protected void onSizeChanged(int arg1, int arg2, int arg3, int arg4) {
        super.onSizeChanged(arg1, arg2, arg3, arg4);
        if(arg1 > 0 && arg2 > 0 && arg1 != arg3) {
            this.post(new JoystickBlueStacks$$ExternalSyntheticLambda7(this, Math.min(arg1, arg2)));
        }
    }

    static final void onSizeChanged$lambda$17(JoystickBlueStacks arg0, int arg1) {
        arg0.actualizarDiseno(arg1);
        arg0.requestLayout();
    }

    private final void posicionarTeclas(int arg9) {
        float v0 = this.getContext().getResources().getDisplayMetrics().density;
        float v9 = ((float)arg9);
        int v1 = RangesKt.coerceAtLeast(((int)(0.24f * v9 * this.escalaVisual)), this.dp.invoke(Integer.valueOf(14)).intValue());
        float v2 = 0.265f * v9 * this.escalaVisual;
        v9 /= 2f;
        float v5 = ((float)v1);
        float v3 = v5 / 2f;
        int v6 = ((int)(v9 - v3));
        int v7 = ((int)(v9 - v2 - v3));
        this.colocar(this.teclaW, v6, v7, v1);
        this.colocar(this.teclaA, v7, v6, v1);
        arg9 = ((int)(v9 + v2 - v3));
        this.colocar(this.teclaD, arg9, v6, v1);
        this.colocar(this.teclaS, v6, arg9, v1);
        v9 = 0.45f * v5 / v0;
        this.teclaW.setTextSize(2, v9);
        this.teclaA.setTextSize(2, v9);
        this.teclaS.setTextSize(2, v9);
        this.teclaD.setTextSize(2, v9);
        v5 *= 0.15f;
        Integer v9_1 = this.colorTemaActual;
        this.teclaW.setBackground(JoystickBlueStacks.posicionarTeclas$crearFondo(v5, v9_1, this));
        this.teclaA.setBackground(JoystickBlueStacks.posicionarTeclas$crearFondo(v5, v9_1, this));
        this.teclaS.setBackground(JoystickBlueStacks.posicionarTeclas$crearFondo(v5, v9_1, this));
        this.teclaD.setBackground(JoystickBlueStacks.posicionarTeclas$crearFondo(v5, v9_1, this));
    }

    private static final GradientDrawable posicionarTeclas$crearFondo(float arg2, Integer arg3, JoystickBlueStacks arg4) {
        GradientDrawable v0 = new GradientDrawable();
        v0.setShape(0);
        v0.setCornerRadius(arg2);
        v0.setColor(Color.argb(230, 0xFF, 0xFF, 0xFF));
        if(arg3 != null) {
            v0.setStroke(RangesKt.coerceAtLeast(arg4.dp.invoke(Integer.valueOf(2)).intValue(), 2), arg3.intValue());
            return v0;
        }

        v0.setStroke(1, Color.parseColor("#CCCCCC"));
        return v0;
    }

    private final void resizeQuick(boolean arg24) {
        int v6;
        JoystickBlueStacks v0 = this;
        float v1 = v0.getContext().getResources().getDisplayMetrics().density;
        int v2 = ((int)((((float)v0.getWidth())) / v1));
        int[] v3 = new int[]{90, 130, 170, 210, 260};
        int v5 = 0;
        while(true) {
            v6 = 5;
            if(v5 >= v6) {
                break;
            }
            else if(v3[v5] >= v2) {
            }
            else {
                ++v5;
                continue;
            }

            goto label_25;
        }

        v5 = -1;
    label_25:
        v2 = RangesKt.coerceAtLeast(v5, 0);
        if(arg24) {
            v2 = (v2 + 1) % v6;
        }
        else {
            --v2;
            if(v2 < 0) {
                v2 = ArraysKt.getLastIndex(v3);
            }
        }

        int v1_1 = ((int)((((float)v3[v2])) * v1));
        ViewGroup$LayoutParams v2_1 = v0.getLayoutParams();
        v2_1.width = v1_1;
        v2_1.height = v1_1;
        v0.setLayoutParams(v2_1);
        v0.component = JoystickComponent.copy$default(v0.component, 0.32f * (((float)v1_1)), 0f, 0f, 0f, 0f, 0f, 0, 0f, false, 0f, 0, false, null, 0f, false, 0x7FFE, null);
        v0.actualizarDiseno(v1_1);
        v0.requestLayout();
        Function0 v0_1 = v0.onComponentChanged;
        if(v0_1 != null) {
            v0_1.invoke();
        }
    }

    public void seleccionar() {
        this.activarEdicion();
    }

    public void setEstaEnModoEdicion(boolean arg1) {
        this.estaEnModoEdicion = arg1;
    }

    public final void setKeysVisible(boolean arg2) {
        this.keysVisible = arg2;
        int v2 = arg2 ? 0 : 8;
        this.teclaW.setVisibility(v2);
        this.teclaA.setVisibility(v2);
        this.teclaS.setVisibility(v2);
        this.teclaD.setVisibility(v2);
    }

    public void setOnComponentChanged(Function0 arg1) {
        this.onComponentChanged = arg1;
    }

    public void setOnConfigure(Function0 arg1) {
        this.onConfigure = arg1;
    }

    public void updateBinding(String arg3, InputBinding arg4) {
        Intrinsics.checkNotNullParameter(arg3, "slot");
        Intrinsics.checkNotNullParameter(arg4, "binding");
        if(!this.bindingSlots().contains(arg3)) {
        }
        else {
            this.bindings.put(arg3, arg4);
            int v0 = arg3.hashCode();
            if(v0 != 0xA9B) {
                if(v0 != 0x201CA2) {
                    if(v0 != 0x239807) {
                        if(v0 != 0x4A5C9FC) {
                        }
                        else if(!arg3.equals("RIGHT")) {
                        }
                        else {
                            this.teclaD.setText(arg4.displayName());
                            return;
                        }
                    }
                    else if(!arg3.equals("LEFT")) {
                    }
                    else {
                        this.teclaA.setText(arg4.displayName());
                        return;
                    }
                }
                else if(!arg3.equals("DOWN")) {
                }
                else {
                    this.teclaS.setText(arg4.displayName());
                    return;
                }
            }
            else if(arg3.equals("UP")) {
                this.teclaW.setText(arg4.displayName());
            }
        }
    }

    public final void updateRadiusLive(float arg24) {
        int v1 = RangesKt.coerceAtLeast(((int)(3f * arg24)), this.dp.invoke(Integer.valueOf(40)).intValue());
        ViewGroup$LayoutParams v2 = this.getLayoutParams();
        v2.width = v1;
        v2.height = v1;
        this.setLayoutParams(v2);
        this.component = JoystickComponent.copy$default(this.component, arg24, 0f, 0f, 0f, 0f, 0f, 0, 0f, false, 0f, 0, false, null, 0f, false, 0x7FFE, null);
        this.actualizarDiseno(v1);
        this.requestLayout();
        Function0 v0 = this.onComponentChanged;
        if(v0 != null) {
            v0.invoke();
        }
    }
}

