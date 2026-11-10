package com.TryJeanPc.goldenmouse.controls;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.widget.FrameLayout$LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView$ScaleType;
import android.widget.ImageView;
import com.TryJeanPc.goldenmouse.R$drawable;
import com.TryJeanPc.goldenmouse.mapper.InputBinding;
import com.TryJeanPc.goldenmouse.profile.ControlComponent;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
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

@Metadata(d1={"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010$\n\u0002\b\u0002\b\u0017\u0018\u0000 i2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\u0001iB1\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u000B\u0012\u0006\u0010\f\u001A\u00020\r\u0012\u0006\u0010\u000E\u001A\u00020\u000F\u0012\b\b\u0002\u0010\u0010\u001A\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u000E\u0010\u001F\u001A\b\u0012\u0004\u0012\u00020\u001A0\u0019H\u0016J\u0010\u0010 \u001A\u00020!2\u0006\u0010\"\u001A\u00020#H\u0016J\u0010\u0010$\u001A\u00020!2\u0006\u0010\"\u001A\u00020#H\u0016J\u0010\u0010I\u001A\u00020\r2\u0006\u0010J\u001A\u00020\rH\u0002J\b\u0010K\u001A\u00020;H\u0016J\b\u0010L\u001A\u00020;H\u0016J\b\u0010M\u001A\u00020;H\u0016J\u0010\u0010N\u001A\u00020;2\u0006\u0010O\u001A\u00020\u000BH\u0016J\b\u0010P\u001A\u00020\u000BH\u0016J\b\u0010Q\u001A\u00020\u000BH\u0016J\b\u0010R\u001A\u00020;H\u0016J\b\u0010S\u001A\u00020TH\u0016J\u001F\u0010U\u001A\u00020;2\u0006\u0010V\u001A\u00020H2\b\u0010W\u001A\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u0010XJ\n\u0010Y\u001A\u0004\u0018\u000100H\u0016J\u0018\u0010Z\u001A\u00020;2\u000E\u0010[\u001A\n\u0012\u0004\u0012\u00020;\u0018\u00010:H\u0016J\b\u0010\\\u001A\u00020;H\u0016J\b\u0010]\u001A\u00020;H\u0016J\u0006\u0010^\u001A\u00020\'J\u0006\u0010_\u001A\u00020;J\u0018\u0010`\u001A\u00020;2\u000E\u0010[\u001A\n\u0012\u0004\u0012\u00020;\u0018\u00010:H\u0016J\u0010\u0010a\u001A\u00020;2\u0006\u0010B\u001A\u00020\u000FH\u0016J\b\u0010b\u001A\u00020\u000FH\u0016J\u000E\u0010c\u001A\b\u0012\u0004\u0012\u00020\u000B0\u0019H\u0016J\u0018\u0010d\u001A\u00020;2\u0006\u0010e\u001A\u00020\u000B2\u0006\u0010f\u001A\u00020EH\u0016J\u0014\u0010g\u001A\u000E\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020E0hH\u0016R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001A\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017R!\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020\u001A0\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001D\u0010\u001E\u001A\u0004\b\u001B\u0010\u001CR\u000E\u0010%\u001A\u00020\u0001X\u0082.¢\u0006\u0002\n\u0000R\u001A\u0010&\u001A\u00020\'X\u0096.¢\u0006\u000E\n\u0000\u001A\u0004\b(\u0010)\"\u0004\b*\u0010+R\u000E\u0010,\u001A\u00020\u0001X\u0082.¢\u0006\u0002\n\u0000R\u000E\u0010-\u001A\u00020\'X\u0082.¢\u0006\u0002\n\u0000R\u000E\u0010.\u001A\u00020\'X\u0082.¢\u0006\u0002\n\u0000R\u000E\u0010/\u001A\u000200X\u0082.¢\u0006\u0002\n\u0000R\u000E\u00101\u001A\u000202X\u0082.¢\u0006\u0002\n\u0000R\u000E\u00103\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u00104\u001A\u00020!X\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b5\u00106\"\u0004\b7\u00108R\"\u00109\u001A\n\u0012\u0004\u0012\u00020;\u0018\u00010:X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0016\u0010@\u001A\n\u0012\u0004\u0012\u00020;\u0018\u00010:X\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010A\u001A\n\u0012\u0004\u0012\u00020;\u0018\u00010:X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010B\u001A\u00020\u000FX\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u0010C\u001A\u000E\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020E0DX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010F\u001A\u00020!X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010G\u001A\u00020HX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006j"}, d2={"Lcom/TryJeanPc/goldenmouse/controls/BotonEditableVisual;", "Landroid/widget/FrameLayout;", "Lcom/TryJeanPc/goldenmouse/controls/BotonEditable;", "Lcom/TryJeanPc/goldenmouse/controls/ControlVisual;", "Lcom/TryJeanPc/goldenmouse/controls/ProfileComponentControl;", "Lcom/TryJeanPc/goldenmouse/controls/ControlEliminable;", "Lcom/TryJeanPc/goldenmouse/controls/ControlConTecla;", "Lcom/TryJeanPc/goldenmouse/controls/EditorHitRegionProvider;", "context", "Landroid/content/Context;", "controlType", "", "imageResource", "", "initialComponent", "Lcom/TryJeanPc/goldenmouse/profile/ControlComponent;", "editorBodyShape", "Lcom/TryJeanPc/goldenmouse/controls/EditorHitShape;", "<init>", "(Landroid/content/Context;Ljava/lang/String;ILcom/TryJeanPc/goldenmouse/profile/ControlComponent;Lcom/TryJeanPc/goldenmouse/controls/EditorHitShape;)V", "editorHitDispatcher", "Lcom/TryJeanPc/goldenmouse/controls/EditorHitDispatcher;", "getEditorHitDispatcher", "()Lcom/TryJeanPc/goldenmouse/controls/EditorHitDispatcher;", "editorRegions", "", "Lcom/TryJeanPc/goldenmouse/controls/EditorHitRegion;", "getEditorRegions", "()Ljava/util/List;", "editorRegions$delegate", "Lkotlin/Lazy;", "editorHitRegions", "dispatchTouchEvent", "", "event", "Landroid/view/MotionEvent;", "onInterceptTouchEvent", "xWrapper", "botonCerrarX", "Landroid/widget/ImageView;", "getBotonCerrarX", "()Landroid/widget/ImageView;", "setBotonCerrarX", "(Landroid/widget/ImageView;)V", "configWrapper", "botonConfigurar", "imagenFondo", "anilloTema", "Landroid/view/View;", "textoTecla", "Lcom/TryJeanPc/goldenmouse/controls/MarkerLabelView;", "teclaActual", "estaEnModoEdicion", "getEstaEnModoEdicion", "()Z", "setEstaEnModoEdicion", "(Z)V", "onClickEditar", "Lkotlin/Function0;", "", "getOnClickEditar", "()Lkotlin/jvm/functions/Function0;", "setOnClickEditar", "(Lkotlin/jvm/functions/Function0;)V", "onDeleteClick", "onConfigure", "component", "bindings", "", "Lcom/TryJeanPc/goldenmouse/mapper/InputBinding;", "esArrastre", "density", "", "dp", "value", "seleccionar", "activarEdicion", "desactivarEdicion", "actualizarTecla", "nuevaTecla", "obtenerTeclaActual", "obtenerTipo", "deseleccionar", "obtenerEstado", "Lcom/TryJeanPc/goldenmouse/controls/ControlVisualState;", "aplicarEstiloVisual", "escala", "colorTema", "(FLjava/lang/Integer;)V", "obtenerVistaEliminar", "establecerOnEliminar", "listener", "mostrarEliminar", "ocultarEliminar", "mostrarBotonEliminar", "ocultarBotonEliminar", "setOnConfigure", "applyComponent", "currentComponent", "bindingSlots", "updateBinding", "slot", "binding", "currentBindings", "", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public class BotonEditableVisual extends FrameLayout implements BotonEditable, ControlConTecla, ControlEliminable, ControlVisual, EditorHitRegionProvider, ProfileComponentControl {
    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2={"Lcom/TryJeanPc/goldenmouse/controls/BotonEditableVisual$Companion;", "", "<init>", "()V", "TAG", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class Companion {
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
    private View anilloTema;
    private final Map bindings;
    public ImageView botonCerrarX;
    private ImageView botonConfigurar;
    private ControlComponent component;
    private FrameLayout configWrapper;
    private final String controlType;
    private final float density;
    private final EditorHitShape editorBodyShape;
    private final EditorHitDispatcher editorHitDispatcher;
    private final Lazy editorRegions$delegate;
    private boolean esArrastre;
    private boolean estaEnModoEdicion;
    private final int imageResource;
    private ImageView imagenFondo;
    private Function0 onClickEditar;
    private Function0 onConfigure;
    private Function0 onDeleteClick;
    private String teclaActual;
    private MarkerLabelView textoTecla;
    private FrameLayout xWrapper;

    static {
        BotonEditableVisual.Companion = new Companion(null);
        BotonEditableVisual.$stable = 8;
    }

    public BotonEditableVisual(Context arg8, String arg9, int arg10, ControlComponent arg11, EditorHitShape arg12) {
        Intrinsics.checkNotNullParameter(arg8, "context");
        Intrinsics.checkNotNullParameter(arg9, "controlType");
        Intrinsics.checkNotNullParameter(arg11, "initialComponent");
        Intrinsics.checkNotNullParameter(arg12, "editorBodyShape");
        super(arg8);
        this.controlType = arg9;
        this.imageResource = arg10;
        this.editorBodyShape = arg12;
        this.editorHitDispatcher = new EditorHitDispatcher(this);
        this.editorRegions$delegate = LazyKt.lazy(new BotonEditableVisual$$ExternalSyntheticLambda1(this));
        this.teclaActual = "";
        this.component = arg11;
        this.bindings = new LinkedHashMap();
        this.density = arg8.getResources().getDisplayMetrics().density;
        this.setClipChildren(false);
        this.setClipToPadding(false);
        int v12 = this.dp(90);
        FrameLayout$LayoutParams v0 = new FrameLayout$LayoutParams(v12, v12);
        v12 = 17;
        v0.gravity = v12;
        this.setLayoutParams(((ViewGroup$LayoutParams)v0));
        ImageView v0_1 = new ImageView(arg8);
        v0_1.setImageResource(arg10);
        FrameLayout$LayoutParams v10 = new FrameLayout$LayoutParams(this.dp(38), this.dp(38));
        v10.gravity = v12;
        v0_1.setLayoutParams(((ViewGroup$LayoutParams)v10));
        v0_1.setScaleType(ImageView$ScaleType.FIT_CENTER);
        v0_1.setClickable(false);
        v0_1.setFocusable(false);
        this.imagenFondo = v0_1;
        this.addView(((View)v0_1));
        View v10_1 = new View(arg8);
        v0 = new FrameLayout$LayoutParams(this.dp(38), this.dp(38));
        v0.gravity = v12;
        v10_1.setLayoutParams(((ViewGroup$LayoutParams)v0));
        int v0_2 = 8;
        v10_1.setVisibility(v0_2);
        v10_1.setClickable(false);
        v10_1.setFocusable(false);
        this.anilloTema = v10_1;
        this.addView(v10_1);
        MarkerLabelView v10_2 = new MarkerLabelView(arg8);
        v10_2.setClickable(false);
        v10_2.setFocusable(false);
        FrameLayout$LayoutParams v2 = new FrameLayout$LayoutParams(this.dp(38), this.dp(38));
        v2.gravity = v12;
        v10_2.setLayoutParams(((ViewGroup$LayoutParams)v2));
        this.textoTecla = v10_2;
        this.addView(((View)v10_2));
        FrameLayout v10_3 = new FrameLayout(arg8);
        int v2_1 = 0x30;
        FrameLayout$LayoutParams v1 = new FrameLayout$LayoutParams(this.dp(v2_1), this.dp(v2_1));
        v1.gravity = 0x800053;
        v1.bottomMargin = 0;
        v1.setMarginStart(0);
        v10_3.setLayoutParams(((ViewGroup$LayoutParams)v1));
        v10_3.setVisibility(v0_2);
        v10_3.setOnTouchListener(new BotonEditableVisual$$ExternalSyntheticLambda2(this));
        this.configWrapper = v10_3;
        ImageView v10_4 = new ImageView(arg8);
        v10_4.setImageResource(drawable.settingsbt);
        Drawable v1_1 = null;
        v10_4.setBackground(v1_1);
        v10_4.setBackgroundResource(0);
        v10_4.setScaleType(ImageView$ScaleType.FIT_CENTER);
        float v3 = 20f;
        v10_4.setElevation(v3);
        v10_4.setTranslationZ(v3);
        FrameLayout$LayoutParams v4 = new FrameLayout$LayoutParams(this.dp(24), this.dp(24));
        v4.gravity = v12;
        v10_4.setLayoutParams(((ViewGroup$LayoutParams)v4));
        this.botonConfigurar = v10_4;
        v10_3 = this.configWrapper;
        String v4_1 = "configWrapper";
        if(v10_3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v4_1);
            v10_3 = ((FrameLayout)v1_1);
        }

        ImageView v5 = this.botonConfigurar;
        if(v5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("botonConfigurar");
            View v5_1 = ((View)v1_1);
        }

        v10_3.addView(((View)v5));
        v10_3 = this.configWrapper;
        if(v10_3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v4_1);
            v10_1 = ((View)v1_1);
        }

        this.addView(((View)v10_3));
        v10_3 = new FrameLayout(arg8);
        v4 = new FrameLayout$LayoutParams(this.dp(v2_1), this.dp(v2_1));
        v4.gravity = 0x800035;
        v4.topMargin = 0;
        v4.setMarginEnd(0);
        v10_3.setLayoutParams(((ViewGroup$LayoutParams)v4));
        v10_3.setVisibility(v0_2);
        v10_3.setOnTouchListener(new BotonEditableVisual$$ExternalSyntheticLambda3(this));
        this.xWrapper = v10_3;
        v10_4 = new ImageView(arg8);
        v10_4.setImageResource(0x1080038);
        v10_4.setBackground(v1_1);
        v10_4.setBackgroundResource(0);
        v10_4.setColorFilter(-1);
        v10_4.setScaleType(ImageView$ScaleType.CENTER_INSIDE);
        v10_4.setPadding(0, 0, 0, 0);
        v10_4.setElevation(v3);
        v10_4.setTranslationZ(v3);
        FrameLayout$LayoutParams v8 = new FrameLayout$LayoutParams(this.dp(18), this.dp(18));
        v8.gravity = v12;
        v10_4.setLayoutParams(((ViewGroup$LayoutParams)v8));
        v10_4.setContentDescription("Eliminar botón " + arg9);
        this.setBotonCerrarX(v10_4);
        FrameLayout v8_1 = this.xWrapper;
        arg9 = "xWrapper";
        if(v8_1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(arg9);
            v8_1 = ((FrameLayout)v1_1);
        }

        v8_1.addView(this.getBotonCerrarX());
        v8_1 = this.xWrapper;
        if(v8_1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(arg9);
        }
        else {
            FrameLayout v1_2 = v8_1;
        }

        this.addView(((View)v1_1));
        this.setClickable(true);
        this.setFocusable(true);
        this.setOnTouchListener(new BotonEditableVisual$$ExternalSyntheticLambda4(this));
    }

    public BotonEditableVisual(Context arg7, String arg8, int arg9, ControlComponent arg10, EditorHitShape arg11, int arg12, DefaultConstructorMarker arg13) {
        if((arg12 & 16) != 0) {
            arg11 = EditorHitShapes.INSTANCE.getCircle();
        }

        this(arg7, arg8, arg9, arg10, arg11);
    }

    static final boolean _init_$lambda$19(BotonEditableVisual arg0, View arg1, MotionEvent arg2) {
        int v1 = arg2.getAction();
        if(v1 != 0) {
            if(v1 != 1) {
                if(v1 != 2) {
                    return 0;
                }
                else {
                    return 1;
                }
            }
            else if(!arg0.esArrastre) {
                Function0 v0 = arg0.onClickEditar;
                if(v0 != null) {
                    v0.invoke();
                }
            }
        }

        return 1;
    }

    public void activarEdicion() {
        this.setEstaEnModoEdicion(true);
        this.mostrarEliminar();
    }

    public void actualizarTecla(String arg3) {
        Intrinsics.checkNotNullParameter(arg3, "nuevaTecla");
        arg3 = StringsKt.trim(((CharSequence)arg3)).toString().toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(arg3, "toUpperCase(...)");
        this.teclaActual = arg3;
        MarkerLabelView v0 = this.textoTecla;
        if(v0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textoTecla");
            v0 = null;
        }

        v0.setLabel(InputBinding.Companion.fromDisplayName(arg3), arg3);
        String v1 = "PRIMARY";
        if(arg3.length() > 0) {
            InputBinding v3 = InputBinding.Companion.fromDisplayName(arg3);
            if(v3 != null) {
                this.bindings.put(v1, v3);
            }

            return;
        }

        this.bindings.remove(v1);
    }

    public void aplicarEstiloVisual(float arg6, Integer arg7) {
        View v5;
        arg6 = RangesKt.coerceIn(arg6, 0.5f, 1.5f);
        ImageView v0 = this.imagenFondo;
        String v1 = "imagenFondo";
        View v2 = null;
        if(v0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v1);
            v0 = ((ImageView)v2);
        }

        v0.setScaleX(arg6);
        v0 = this.imagenFondo;
        if(v0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v1);
            v0 = ((ImageView)v2);
        }

        v0.setScaleY(arg6);
        View v0_1 = this.anilloTema;
        v1 = "anilloTema";
        if(v0_1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v1);
            v0_1 = v2;
        }

        v0_1.setScaleX(arg6);
        v0_1 = this.anilloTema;
        if(v0_1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v1);
            v0_1 = v2;
        }

        v0_1.setScaleY(arg6);
        MarkerLabelView v0_2 = this.textoTecla;
        String v3 = "textoTecla";
        if(v0_2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v3);
            v0_2 = ((MarkerLabelView)v2);
        }

        v0_2.setScaleX(arg6);
        v0_2 = this.textoTecla;
        if(v0_2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v3);
            v0_2 = ((MarkerLabelView)v2);
        }

        v0_2.setScaleY(arg6);
        v0_2 = this.textoTecla;
        if(v0_2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v3);
            v0_2 = ((MarkerLabelView)v2);
        }

        v0_2.setMarkerScale(arg6);
        if(arg7 != null) {
            int v6 = Color.argb(42, Color.red(arg7.intValue()), Color.green(arg7.intValue()), Color.blue(arg7.intValue()));
            v0_1 = this.anilloTema;
            if(v0_1 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v1);
                v0_1 = v2;
            }

            GradientDrawable v3_1 = new GradientDrawable();
            v3_1.setShape(1);
            v3_1.setColor(v6);
            v3_1.setStroke(this.dp(2), arg7.intValue());
            v0_1.setBackground(((Drawable)v3_1));
            v5 = this.anilloTema;
            if(v5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v1);
            }
            else {
                v2 = v5;
            }

            v2.setVisibility(0);
            return;
        }

        v5 = this.anilloTema;
        if(v5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v1);
        }
        else {
            v2 = v5;
        }

        v2.setVisibility(8);
    }

    public void applyComponent(ControlComponent arg3) {
        Intrinsics.checkNotNullParameter(arg3, "component");
        if(Intrinsics.areEqual(arg3.getType(), this.controlType)) {
            this.component = arg3;
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
        }

        if(v0 != null) {
            return MapsKt.mapOf(TuplesKt.to(v1, v0));
        }

        return this.bindings;
    }

    public ControlComponent currentComponent() {
        return this.component;
    }

    public void desactivarEdicion() {
        this.setEstaEnModoEdicion(false);
        this.ocultarEliminar();
    }

    public void deseleccionar() {
        this.desactivarEdicion();
    }

    public boolean dispatchTouchEvent(MotionEvent arg3) {
        Intrinsics.checkNotNullParameter(arg3, "event");
        return this.getEditorHitDispatcher().dispatch(arg3, new BotonEditableVisual$$ExternalSyntheticLambda0(this));
    }

    static final boolean dispatchTouchEvent$lambda$1(BotonEditableVisual arg1, MotionEvent arg2) {
        Intrinsics.checkNotNullParameter(arg2, "it");
        return super.dispatchTouchEvent(arg2);
    }

    private final int dp(int arg1) {
        return ((int)((((float)arg1)) * this.density));
    }

    public List editorHitRegions() {
        return this.getEditorRegions();
    }

    static final List editorRegions_delegate$lambda$0(BotonEditableVisual arg20) {
        BotonEditableVisual v0 = arg20;
        EditorHitRegion[] v1 = new EditorHitRegion[3];
        ImageView v3 = v0.imagenFondo;
        FrameLayout v10 = null;
        if(v3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imagenFondo");
            View v3_1 = ((View)v10);
        }

        v1[0] = new EditorHitRegion(((View)v3), v0.editorBodyShape, null, 0f, false, 28, null);
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
        this.onDeleteClick = arg1;
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

    public final Function0 getOnClickEditar() {
        return this.onClickEditar;
    }

    static final boolean lambda$11$lambda$10(BotonEditableVisual arg4, View arg5, MotionEvent arg6) {
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

    static final boolean lambda$16$lambda$15(BotonEditableVisual arg4, View arg5, MotionEvent arg6) {
        float v5 = ((float)arg4.dp(24));
        if((((float)Math.hypot(((double)(arg6.getX() - v5)), ((double)(arg6.getY() - v5))))) > (((float)arg4.dp(20)))) {
            return 0;
        }

        if(arg6.getAction() != 1) {
        }
        else {
            Function0 v4 = arg4.onDeleteClick;
            if(v4 != null) {
                v4.invoke();
            }
        }

        return 1;
    }

    public final ImageView mostrarBotonEliminar() {
        this.mostrarEliminar();
        return this.getBotonCerrarX();
    }

    public void mostrarEliminar() {
        FrameLayout v0 = this.xWrapper;
        FrameLayout v1 = null;
        if(v0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("xWrapper");
            v0 = v1;
        }

        v0.setVisibility(0);
        FrameLayout v3 = this.configWrapper;
        if(v3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("configWrapper");
        }
        else {
            v1 = v3;
        }

        v1.setVisibility(0);
    }

    public ControlVisualState obtenerEstado() {
        String v1 = this.obtenerTipo();
        float v2 = this.getX();
        float v3 = this.getY();
        int v4 = this.getWidth();
        int v5 = this.getHeight();
        String v7 = this.teclaActual;
        if(StringsKt.isBlank(((CharSequence)v7))) {
            v7 = null;
        }

        return new ControlVisualState(v1, v2, v3, v4, v5, v7);
    }

    public String obtenerTeclaActual() {
        return this.teclaActual;
    }

    public String obtenerTipo() {
        return this.controlType;
    }

    public View obtenerVistaEliminar() {
        FrameLayout v0 = this.xWrapper;
        if(v0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("xWrapper");
            View v0_1 = null;
        }

        return ((View)v0);
    }

    public final void ocultarBotonEliminar() {
        this.ocultarEliminar();
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

    public final void setOnClickEditar(Function0 arg1) {
        this.onClickEditar = arg1;
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
        this.teclaActual = arg3;
        MarkerLabelView v2 = this.textoTecla;
        if(v2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textoTecla");
            v2 = null;
        }

        v2.setLabel(arg4, arg3);
    }
}

