package com.TryJeanPc.goldenmouse.controls;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff$Mode;
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
import com.TryJeanPc.goldenmouse.R$drawable;
import com.TryJeanPc.goldenmouse.input.InputEvent$Button;
import com.TryJeanPc.goldenmouse.mapper.InputBinding;
import com.TryJeanPc.goldenmouse.profile.ControlComponent;
import com.TryJeanPc.goldenmouse.profile.FireComponent;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0002\b\u0007\u0018\u0000 [2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0001[B\u000F\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000E\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\u0010\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u001AH\u0016J\u0010\u0010\u001B\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u001AH\u0016J\u0010\u0010;\u001A\u00020<2\u0006\u0010=\u001A\u00020<H\u0002J\b\u0010>\u001A\u00020\'H\u0016J\b\u0010?\u001A\u00020\'H\u0016J\u0010\u0010@\u001A\u00020\'2\u0006\u0010A\u001A\u00020*H\u0016J\b\u0010B\u001A\u00020*H\u0016J\b\u0010C\u001A\u00020*H\u0016J\b\u0010D\u001A\u00020\'H\u0016J\b\u0010E\u001A\u00020\'H\u0016J\b\u0010F\u001A\u00020GH\u0016J\u001F\u0010H\u001A\u00020\'2\u0006\u0010I\u001A\u00020:2\b\u0010J\u001A\u0004\u0018\u00010<H\u0016¢\u0006\u0002\u0010KJ\n\u0010L\u001A\u0004\u0018\u00010-H\u0016J\u0018\u0010M\u001A\u00020\'2\u000E\u0010N\u001A\n\u0012\u0004\u0012\u00020\'\u0018\u00010&H\u0016J\b\u0010O\u001A\u00020\'H\u0016J\b\u0010P\u001A\u00020\'H\u0016J\u0018\u0010Q\u001A\u00020\'2\u000E\u0010N\u001A\n\u0012\u0004\u0012\u00020\'\u0018\u00010&H\u0016J\u0010\u0010R\u001A\u00020\'2\u0006\u00104\u001A\u00020SH\u0016J\b\u0010T\u001A\u00020SH\u0016J\u000E\u0010U\u001A\b\u0012\u0004\u0012\u00020*0\u0010H\u0016J\u0018\u0010V\u001A\u00020\'2\u0006\u0010W\u001A\u00020*2\u0006\u0010X\u001A\u000208H\u0016J\u0014\u0010Y\u001A\u000E\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u0002080ZH\u0016R\u0014\u0010\u000B\u001A\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER!\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00110\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001A\u0004\b\u0012\u0010\u0013R\u000E\u0010\u001C\u001A\u00020\u0001X\u0082.¢\u0006\u0002\n\u0000R\u001A\u0010\u001D\u001A\u00020\u001EX\u0096.¢\u0006\u000E\n\u0000\u001A\u0004\b\u001F\u0010 \"\u0004\b!\u0010\"R\u000E\u0010#\u001A\u00020\u0001X\u0082.¢\u0006\u0002\n\u0000R\u000E\u0010$\u001A\u00020\u001EX\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010%\u001A\n\u0012\u0004\u0012\u00020\'\u0018\u00010&X\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010(\u001A\n\u0012\u0004\u0012\u00020\'\u0018\u00010&X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010)\u001A\u00020*X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010+\u001A\u00020\u001EX\u0082.¢\u0006\u0002\n\u0000R\u000E\u0010,\u001A\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010.\u001A\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010/\u001A\u00020\u0018X\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b0\u00101\"\u0004\b2\u00103R\u000E\u00104\u001A\u000205X\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u00106\u001A\u000E\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020807X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u00109\u001A\u00020:X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\\"}, d2={"Lcom/TryJeanPc/goldenmouse/controls/BotonDisparoBlueStacks;", "Landroid/widget/FrameLayout;", "Lcom/TryJeanPc/goldenmouse/controls/BotonEditable;", "Lcom/TryJeanPc/goldenmouse/controls/ControlVisual;", "Lcom/TryJeanPc/goldenmouse/controls/ProfileComponentControl;", "Lcom/TryJeanPc/goldenmouse/controls/ControlEliminable;", "Lcom/TryJeanPc/goldenmouse/controls/EditorHitRegionProvider;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "editorHitDispatcher", "Lcom/TryJeanPc/goldenmouse/controls/EditorHitDispatcher;", "getEditorHitDispatcher", "()Lcom/TryJeanPc/goldenmouse/controls/EditorHitDispatcher;", "editorRegions", "", "Lcom/TryJeanPc/goldenmouse/controls/EditorHitRegion;", "getEditorRegions", "()Ljava/util/List;", "editorRegions$delegate", "Lkotlin/Lazy;", "editorHitRegions", "dispatchTouchEvent", "", "event", "Landroid/view/MotionEvent;", "onInterceptTouchEvent", "xWrapper", "botonCerrarX", "Landroid/widget/ImageView;", "getBotonCerrarX", "()Landroid/widget/ImageView;", "setBotonCerrarX", "(Landroid/widget/ImageView;)V", "configWrapper", "botonConfigurar", "onEliminar", "Lkotlin/Function0;", "", "onConfigure", "teclaActual", "", "imgDisparo", "anilloTema", "Landroid/view/View;", "bordeSeleccion", "estaEnModoEdicion", "getEstaEnModoEdicion", "()Z", "setEstaEnModoEdicion", "(Z)V", "component", "Lcom/TryJeanPc/goldenmouse/profile/FireComponent;", "bindings", "", "Lcom/TryJeanPc/goldenmouse/mapper/InputBinding;", "density", "", "dp", "", "value", "activarEdicion", "desactivarEdicion", "actualizarTecla", "nuevaTecla", "obtenerTeclaActual", "obtenerTipo", "seleccionar", "deseleccionar", "obtenerEstado", "Lcom/TryJeanPc/goldenmouse/controls/ControlVisualState;", "aplicarEstiloVisual", "escala", "colorTema", "(FLjava/lang/Integer;)V", "obtenerVistaEliminar", "establecerOnEliminar", "listener", "mostrarEliminar", "ocultarEliminar", "setOnConfigure", "applyComponent", "Lcom/TryJeanPc/goldenmouse/profile/ControlComponent;", "currentComponent", "bindingSlots", "updateBinding", "slot", "binding", "currentBindings", "", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class BotonDisparoBlueStacks extends FrameLayout implements BotonEditable, ControlEliminable, ControlVisual, EditorHitRegionProvider, ProfileComponentControl {
    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2={"Lcom/TryJeanPc/goldenmouse/controls/BotonDisparoBlueStacks$Companion;", "", "<init>", "()V", "TAG", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class Companion {
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
    private final View anilloTema;
    private final Map bindings;
    private final View bordeSeleccion;
    public ImageView botonCerrarX;
    private ImageView botonConfigurar;
    private FireComponent component;
    private FrameLayout configWrapper;
    private final float density;
    private final EditorHitDispatcher editorHitDispatcher;
    private final Lazy editorRegions$delegate;
    private boolean estaEnModoEdicion;
    private ImageView imgDisparo;
    private Function0 onConfigure;
    private Function0 onEliminar;
    private String teclaActual;
    private FrameLayout xWrapper;

    static {
        BotonDisparoBlueStacks.Companion = new Companion(null);
        BotonDisparoBlueStacks.$stable = 8;
    }

    public BotonDisparoBlueStacks(Context arg14) {
        Intrinsics.checkNotNullParameter(arg14, "context");
        super(arg14);
        this.editorHitDispatcher = new EditorHitDispatcher(this);
        this.editorRegions$delegate = LazyKt.lazy(new BotonDisparoBlueStacks$$ExternalSyntheticLambda1(this));
        this.teclaActual = "";
        View v0 = new View(arg14);
        this.anilloTema = v0;
        View v1 = new View(arg14);
        this.bordeSeleccion = v1;
        DefaultConstructorMarker v5 = null;
        this.component = new FireComponent(false, 1, v5);
        LinkedHashMap v2 = new LinkedHashMap();
        this.bindings = ((Map)v2);
        this.density = arg14.getResources().getDisplayMetrics().density;
        this.setClipChildren(false);
        this.setClipToPadding(false);
        int v6 = this.dp(90);
        FrameLayout$LayoutParams v7 = new FrameLayout$LayoutParams(v6, v6);
        v6 = 17;
        v7.gravity = v6;
        this.setLayoutParams(((ViewGroup$LayoutParams)v7));
        ImageView v7_1 = new ImageView(arg14);
        v7_1.setImageResource(drawable.icono_mouse_disparo);
        v7_1.setScaleType(ImageView$ScaleType.FIT_CENTER);
        FrameLayout$LayoutParams v8 = new FrameLayout$LayoutParams(this.dp(38), this.dp(38));
        v8.gravity = v6;
        v7_1.setLayoutParams(((ViewGroup$LayoutParams)v8));
        v7_1.setElevation(6f);
        this.imgDisparo = v7_1;
        this.addView(((View)v7_1));
        v7 = new FrameLayout$LayoutParams(this.dp(34), this.dp(34));
        v7.gravity = v6;
        v0.setLayoutParams(((ViewGroup$LayoutParams)v7));
        int v7_2 = 8;
        v0.setVisibility(v7_2);
        v0.setClickable(false);
        v0.setFocusable(false);
        v0.setElevation(7f);
        this.addView(v0);
        GradientDrawable v0_1 = new GradientDrawable();
        v0_1.setShape(1);
        v0_1.setColor(0);
        int v8_1 = 2;
        v0_1.setStroke(this.dp(v8_1), Color.parseColor("#2196F3"));
        v1.setBackground(((Drawable)v0_1));
        FrameLayout$LayoutParams v0_2 = new FrameLayout$LayoutParams(this.dp(28), this.dp(28));
        v0_2.gravity = v6;
        v1.setLayoutParams(((ViewGroup$LayoutParams)v0_2));
        v1.setVisibility(v7_2);
        v1.setClickable(false);
        v1.setFocusable(false);
        v1.setElevation(8f);
        this.addView(v1);
        FrameLayout v0_3 = new FrameLayout(arg14);
        int v9 = 0x30;
        FrameLayout$LayoutParams v1_1 = new FrameLayout$LayoutParams(this.dp(v9), this.dp(v9));
        v1_1.gravity = 0x800053;
        v1_1.bottomMargin = 0;
        v1_1.setMarginStart(0);
        v0_3.setLayoutParams(((ViewGroup$LayoutParams)v1_1));
        v0_3.setVisibility(v7_2);
        v0_3.setOnTouchListener(new BotonDisparoBlueStacks$$ExternalSyntheticLambda2(this));
        this.configWrapper = v0_3;
        ImageView v0_4 = new ImageView(arg14);
        v0_4.setImageResource(drawable.settingsbt);
        v0_4.setBackground(((Drawable)v5));
        v0_4.setBackgroundResource(0);
        v0_4.setScaleType(ImageView$ScaleType.FIT_CENTER);
        float v1_2 = 20f;
        v0_4.setElevation(v1_2);
        v0_4.setTranslationZ(v1_2);
        v0_4.setContentDescription("Configurar disparo");
        FrameLayout$LayoutParams v10 = new FrameLayout$LayoutParams(this.dp(24), this.dp(24));
        v10.gravity = v6;
        v0_4.setLayoutParams(((ViewGroup$LayoutParams)v10));
        this.botonConfigurar = v0_4;
        v0_3 = this.configWrapper;
        String v10_1 = "configWrapper";
        if(v0_3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v10_1);
            v0_3 = ((FrameLayout)v5);
        }

        ImageView v11 = this.botonConfigurar;
        if(v11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("botonConfigurar");
            View v11_1 = ((View)v5);
        }

        v0_3.addView(((View)v11));
        v0_3 = this.configWrapper;
        if(v0_3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v10_1);
            v0 = ((View)v5);
        }

        this.addView(v0);
        v0_3 = new FrameLayout(arg14);
        v10 = new FrameLayout$LayoutParams(this.dp(v9), this.dp(v9));
        v10.gravity = 0x800035;
        v10.topMargin = 0;
        v10.setMarginEnd(0);
        v0_3.setLayoutParams(((ViewGroup$LayoutParams)v10));
        v0_3.setVisibility(v7_2);
        v0_3.setOnTouchListener(new BotonDisparoBlueStacks$$ExternalSyntheticLambda3(this));
        this.xWrapper = v0_3;
        v0_4 = new ImageView(arg14);
        v0_4.setImageResource(0x1080038);
        v0_4.setColorFilter(-1);
        GradientDrawable v14 = new GradientDrawable();
        v14.setShape(1);
        v14.setColor(Color.parseColor("#99000000"));
        v0_4.setBackground(((Drawable)v14));
        v0_4.setScaleType(ImageView$ScaleType.CENTER_INSIDE);
        v0_4.setPadding(this.dp(v8_1), this.dp(v8_1), this.dp(v8_1), this.dp(v8_1));
        v0_4.setElevation(v1_2);
        v0_4.setTranslationZ(v1_2);
        FrameLayout$LayoutParams v14_1 = new FrameLayout$LayoutParams(this.dp(18), this.dp(18));
        v14_1.gravity = v6;
        v0_4.setLayoutParams(((ViewGroup$LayoutParams)v14_1));
        v0_4.setContentDescription("Eliminar botón Disparo");
        this.setBotonCerrarX(v0_4);
        FrameLayout v14_2 = this.xWrapper;
        String v0_5 = "xWrapper";
        if(v14_2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v0_5);
            v14_2 = ((FrameLayout)v5);
        }

        v14_2.addView(this.getBotonCerrarX());
        v14_2 = this.xWrapper;
        if(v14_2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v0_5);
        }
        else {
            FrameLayout v5_1 = v14_2;
        }

        this.addView(((View)v5));
        InputBinding v14_3 = InputBinding.Companion.mouse(Button.LEFT);
        ((Map)v2).put("PRIMARY", v14_3);
        String v14_4 = v14_3.displayName();
        this.teclaActual = v14_4;
        Log.d("GOLDEN_UI", "Disparo convertido a ControlVisual y ProfileComponent (default=" + v14_4 + ")");
    }

    public void activarEdicion() {
        this.setEstaEnModoEdicion(true);
        this.bordeSeleccion.setVisibility(0);
        this.mostrarEliminar();
    }

    public void actualizarTecla(String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "nuevaTecla");
        if(StringsKt.isBlank(arg2)) {
            arg2 = "MOUSE_LEFT";
        }

        this.teclaActual = arg2;
        InputBinding v2 = InputBinding.Companion.fromDisplayName(this.teclaActual);
        if(v2 == null) {
            v2 = InputBinding.Companion.mouse(Button.LEFT);
        }

        this.bindings.put("PRIMARY", v2);
    }

    public void aplicarEstiloVisual(float arg4, Integer arg5) {
        arg4 = RangesKt.coerceIn(arg4, 0.5f, 1.5f);
        ImageView v0 = this.imgDisparo;
        ImageView v1 = null;
        String v2 = "imgDisparo";
        if(v0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v2);
            v0 = v1;
        }

        v0.setScaleX(arg4);
        v0 = this.imgDisparo;
        if(v0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v2);
            v0 = v1;
        }

        v0.setScaleY(arg4);
        this.anilloTema.setScaleX(arg4);
        this.anilloTema.setScaleY(arg4);
        this.bordeSeleccion.setScaleX(arg4);
        this.bordeSeleccion.setScaleY(arg4);
        ImageView v4 = this.imgDisparo;
        if(arg5 != null) {
            if(v4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v2);
            }
            else {
                v1 = v4;
            }

            v1.setColorFilter(arg5.intValue(), PorterDuff$Mode.MULTIPLY);
            View v4_1 = this.anilloTema;
            GradientDrawable v0_1 = new GradientDrawable();
            v0_1.setShape(1);
            v0_1.setColor(0);
            v0_1.setStroke(this.dp(2), arg5.intValue());
            v4_1.setBackground(((Drawable)v0_1));
            this.anilloTema.setVisibility(0);
            return;
        }

        if(v4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v2);
        }
        else {
            v1 = v4;
        }

        v1.clearColorFilter();
        this.anilloTema.setVisibility(8);
    }

    public void applyComponent(ControlComponent arg2) {
        Intrinsics.checkNotNullParameter(arg2, "component");
        if((arg2 instanceof FireComponent)) {
            this.component = ((FireComponent)arg2);
        }
    }

    public List bindingSlots() {
        return CollectionsKt.listOf("PRIMARY");
    }

    public Map currentBindings() {
        String v1 = "PRIMARY";
        Object v0 = this.bindings.get(v1);
        if(v0 == null) {
            InputBinding v0_1 = InputBinding.Companion.fromDisplayName(this.teclaActual);
            if(v0_1 == null) {
                v0_1 = InputBinding.Companion.mouse(Button.LEFT);
            }
        }

        return MapsKt.mapOf(TuplesKt.to(v1, v0));
    }

    public ControlComponent currentComponent() {
        return this.component;
    }

    public void desactivarEdicion() {
        this.setEstaEnModoEdicion(false);
        this.bordeSeleccion.setVisibility(8);
        this.ocultarEliminar();
    }

    public void deseleccionar() {
        this.desactivarEdicion();
    }

    public boolean dispatchTouchEvent(MotionEvent arg3) {
        Intrinsics.checkNotNullParameter(arg3, "event");
        return this.getEditorHitDispatcher().dispatch(arg3, new BotonDisparoBlueStacks$$ExternalSyntheticLambda0(this));
    }

    static final boolean dispatchTouchEvent$lambda$1(BotonDisparoBlueStacks arg1, MotionEvent arg2) {
        Intrinsics.checkNotNullParameter(arg2, "it");
        return super.dispatchTouchEvent(arg2);
    }

    private final int dp(int arg1) {
        return ((int)((((float)arg1)) * this.density));
    }

    public List editorHitRegions() {
        return this.getEditorRegions();
    }

    static final List editorRegions_delegate$lambda$0(BotonDisparoBlueStacks arg20) {
        BotonDisparoBlueStacks v0 = arg20;
        EditorHitRegion[] v1 = new EditorHitRegion[3];
        ImageView v3 = v0.imgDisparo;
        FrameLayout v10 = null;
        if(v3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imgDisparo");
            View v3_1 = ((View)v10);
        }

        v1[0] = new EditorHitRegion(((View)v3), EditorHitShapes.INSTANCE.getCircle(), null, 0f, false, 28, null);
        ImageView v2 = v0.botonConfigurar;
        if(v2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("botonConfigurar");
            v2 = ((ImageView)v10);
        }

        ImageView v12 = v2;
        EditorHitShape v13 = EditorHitShapes.INSTANCE.getOval();
        FrameLayout v2_1 = v0.configWrapper;
        if(v2_1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("configWrapper");
            v2_1 = v10;
        }

        v1[1] = new EditorHitRegion(((View)v12), v13, v2_1, 0f, false, 24, null);
        ImageView v13_1 = v0.getBotonCerrarX();
        EditorHitShape v14 = EditorHitShapes.INSTANCE.getOval();
        FrameLayout v0_1 = v0.xWrapper;
        if(v0_1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("xWrapper");
        }
        else {
            v10 = v0_1;
        }

        v1[2] = new EditorHitRegion(((View)v13_1), v14, v10, 0f, false, 24, null);
        return CollectionsKt.listOf(((Object[])v1));
    }

    public void establecerOnEliminar(Function0 arg1) {
        this.onEliminar = arg1;
    }

    public ImageView getBotonCerrarX() {
        ImageView v0 = this.botonCerrarX;
        if(v0 != null) {
            return v0;
        }

        Intrinsics.throwUninitializedPropertyAccessException("botonCerrarX");
        return null;
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

    static final boolean lambda$12$lambda$11(BotonDisparoBlueStacks arg4, View arg5, MotionEvent arg6) {
        float v5 = ((float)arg4.dp(24));
        if((((float)Math.hypot(((double)(arg6.getX() - v5)), ((double)(arg6.getY() - v5))))) > (((float)arg4.dp(20)))) {
            return 0;
        }

        if(arg6.getAction() != 1) {
        }
        else {
            Function0 v4 = arg4.onConfigure;
            if(v4 != null) {
                v4.invoke();
            }
        }

        return 1;
    }

    static final boolean lambda$17$lambda$16(BotonDisparoBlueStacks arg4, View arg5, MotionEvent arg6) {
        float v5 = ((float)arg4.dp(24));
        if((((float)Math.hypot(((double)(arg6.getX() - v5)), ((double)(arg6.getY() - v5))))) > (((float)arg4.dp(20)))) {
            return 0;
        }

        if(arg6.getAction() != 1) {
        }
        else {
            Function0 v4 = arg4.onEliminar;
            if(v4 != null) {
                v4.invoke();
            }
        }

        return 1;
    }

    public void mostrarEliminar() {
        FrameLayout v0 = this.xWrapper;
        String v1 = "xWrapper";
        FrameLayout v2 = null;
        if(v0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v1);
            v0 = v2;
        }

        if(v0.getVisibility() != 0) {
            Log.d("GOLDEN_UI", "X mostrar tipo=" + this.obtenerTipo());
        }

        v0 = this.xWrapper;
        if(v0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v1);
            v0 = v2;
        }

        v0.setVisibility(0);
        FrameLayout v5 = this.configWrapper;
        if(v5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("configWrapper");
        }
        else {
            v2 = v5;
        }

        v2.setVisibility(0);
    }

    public ControlVisualState obtenerEstado() {
        String v1 = this.obtenerTipo();
        float v2 = this.getX();
        float v3 = this.getY();
        int v4 = this.getWidth();
        int v5 = this.getHeight();
        String v7 = this.teclaActual;
        if(StringsKt.isBlank(((CharSequence)v7))) {
            v7 = "MOUSE_LEFT";
        }

        return new ControlVisualState(v1, v2, v3, v4, v5, v7);
    }

    public String obtenerTeclaActual() {
        String v1 = this.teclaActual;
        if(StringsKt.isBlank(((CharSequence)v1))) {
            v1 = "MOUSE_LEFT";
        }

        return v1;
    }

    public String obtenerTipo() {
        return "DISPARO";
    }

    public View obtenerVistaEliminar() {
        FrameLayout v0 = this.xWrapper;
        if(v0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("xWrapper");
            View v0_1 = null;
        }

        return ((View)v0);
    }

    public void ocultarEliminar() {
        FrameLayout v0 = this.xWrapper;
        FrameLayout v1 = null;
        if(v0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("xWrapper");
            v0 = v1;
        }

        int v2 = 8;
        v0.setVisibility(v2);
        FrameLayout v3 = this.configWrapper;
        if(v3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("configWrapper");
        }
        else {
            v1 = v3;
        }

        v1.setVisibility(v2);
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

    public void seleccionar() {
        this.bringToFront();
        FrameLayout v0 = this.xWrapper;
        FrameLayout v1 = null;
        if(v0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("xWrapper");
            v0 = v1;
        }

        v0.bringToFront();
        v0 = this.configWrapper;
        if(v0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("configWrapper");
        }
        else {
            v1 = v0;
        }

        v1.bringToFront();
        this.activarEdicion();
    }

    public void setBotonCerrarX(ImageView arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<set-?>");
        this.botonCerrarX = arg2;
    }

    public void setEstaEnModoEdicion(boolean arg1) {
        this.estaEnModoEdicion = arg1;
    }

    public void setOnComponentChanged(Function0 arg1) {
        ProfileComponentControl.super.setOnComponentChanged(arg1);
    }

    public void setOnConfigure(Function0 arg1) {
        this.onConfigure = arg1;
    }

    public void updateBinding(String arg3, InputBinding arg4) {
        Intrinsics.checkNotNullParameter(arg3, "slot");
        Intrinsics.checkNotNullParameter(arg4, "binding");
        this.bindings.put("PRIMARY", arg4);
        if(!Intrinsics.areEqual(arg3, "PRIMARY")) {
            this.bindings.put(arg3, arg4);
        }

        arg3 = arg4.displayName();
        if(StringsKt.isBlank(((CharSequence)arg3))) {
            arg3 = "MOUSE_LEFT";
        }

        this.teclaActual = arg3;
    }
}

