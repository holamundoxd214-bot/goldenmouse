package com.TryJeanPc.goldenmouse.controls;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint$Align;
import android.graphics.Paint$Cap;
import android.graphics.Paint$Join;
import android.graphics.Paint$Style;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout$LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView$ScaleType;
import android.widget.ImageView;
import com.TryJeanPc.goldenmouse.R$drawable;
import com.TryJeanPc.goldenmouse.mapper.InputBinding;
import com.TryJeanPc.goldenmouse.profile.ControlComponent;
import com.TryJeanPc.goldenmouse.profile.ViewComponent;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000ß\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001=\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\u0002}~B\u000F\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BJ\u000E\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016J\u0018\u0010?\u001A\u0002082\u0006\u0010@\u001A\u00020A2\u0006\u0010B\u001A\u00020AH\u0002J\u0018\u0010C\u001A\u00020$2\u0006\u0010D\u001A\u0002082\u0006\u0010E\u001A\u00020AH\u0002J\b\u0010F\u001A\u00020$H\u0002J\b\u0010G\u001A\u00020$H\u0014J\u0015\u0010H\u001A\u0002002\u0006\u0010I\u001A\u00020JH\u0000¢\u0006\u0002\bKJ\u0010\u0010L\u001A\u0002002\u0006\u0010I\u001A\u00020JH\u0016J\u0010\u0010M\u001A\u0002002\u0006\u0010I\u001A\u00020JH\u0016J\u0010\u0010N\u001A\u0002002\u0006\u0010I\u001A\u00020JH\u0016J\u000E\u0010O\u001A\u00020$2\u0006\u0010P\u001A\u000200J\u0012\u0010Q\u001A\u00020$2\b\u0010R\u001A\u0004\u0018\u00010SH\u0016J\b\u0010T\u001A\u00020$H\u0016J\b\u0010U\u001A\u00020$H\u0016J\u0010\u0010V\u001A\u00020$2\u0006\u0010W\u001A\u00020*H\u0016J\b\u0010X\u001A\u00020*H\u0016J\u000E\u0010Y\u001A\b\u0012\u0004\u0012\u00020*0\u0013H\u0016J\u0018\u0010Z\u001A\u00020$2\u0006\u0010[\u001A\u00020*2\u0006\u0010\\\u001A\u00020]H\u0016J\u0014\u0010^\u001A\u000E\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020]0_H\u0016J\b\u0010`\u001A\u00020aH\u0016J\u0010\u0010b\u001A\u00020$2\u0006\u0010\'\u001A\u00020aH\u0016J\u0018\u0010c\u001A\u00020$2\u000E\u0010d\u001A\n\u0012\u0004\u0012\u00020$\u0018\u00010#H\u0016J\u0018\u0010e\u001A\u00020$2\u000E\u0010d\u001A\n\u0012\u0004\u0012\u00020$\u0018\u00010#H\u0016J\u0016\u0010f\u001A\u00020$2\u0006\u0010@\u001A\u00020A2\u0006\u0010B\u001A\u00020AJ\b\u0010g\u001A\u00020*H\u0016J\b\u0010h\u001A\u00020$H\u0016J\b\u0010i\u001A\u00020$H\u0016J\b\u0010j\u001A\u00020kH\u0016J\u001F\u0010l\u001A\u00020$2\u0006\u0010m\u001A\u00020A2\b\u0010n\u001A\u0004\u0018\u00010oH\u0016¢\u0006\u0002\u0010pJ\u0010\u0010q\u001A\u0002002\u0006\u0010r\u001A\u00020oH\u0014J\u0018\u0010s\u001A\u00020$2\u0006\u0010t\u001A\u00020u2\u0006\u0010D\u001A\u00020uH\u0016J\u0010\u0010v\u001A\u00020$2\u0006\u0010w\u001A\u00020xH\u0014J\n\u0010y\u001A\u0004\u0018\u00010uH\u0016J\u0018\u0010z\u001A\u00020$2\u000E\u0010d\u001A\n\u0012\u0004\u0012\u00020$\u0018\u00010#H\u0016J\b\u0010{\u001A\u00020$H\u0016J\b\u0010|\u001A\u00020$H\u0016R\u0014\u0010\f\u001A\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u000E\u0010\u0010\u001A\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u00140\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001A\u0004\b\u0015\u0010\u0016R\u001A\u0010\u001A\u001A\u00020\u001BX\u0096.¢\u0006\u000E\n\u0000\u001A\u0004\b\u001C\u0010\u001D\"\u0004\b\u001E\u0010\u001FR\u000E\u0010 \u001A\u00020\u001BX\u0082.¢\u0006\u0002\n\u0000R\u000E\u0010!\u001A\u00020\u0001X\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010\"\u001A\n\u0012\u0004\u0012\u00020$\u0018\u00010#X\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010%\u001A\n\u0012\u0004\u0012\u00020$\u0018\u00010#X\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010&\u001A\n\u0012\u0004\u0012\u00020$\u0018\u00010#X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\'\u001A\u00020(X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010)\u001A\u00020*X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010+\u001A\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010-\u001A\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010/\u001A\u000200X\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b1\u00102\"\u0004\b3\u00104R\u000E\u00105\u001A\u000206X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u00107\u001A\u000208X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u00109\u001A\u000200X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010:\u001A\u00020;X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010<\u001A\u00020=X\u0082\u0004¢\u0006\u0004\n\u0002\u0010>¨\u0006\u007F"}, d2={"Lcom/TryJeanPc/goldenmouse/controls/BotonVistaBlueStacks;", "Landroid/widget/FrameLayout;", "Lcom/TryJeanPc/goldenmouse/controls/BotonEditable;", "Lcom/TryJeanPc/goldenmouse/controls/ControlVisual;", "Lcom/TryJeanPc/goldenmouse/controls/ControlConTecla;", "Lcom/TryJeanPc/goldenmouse/controls/ProfileComponentControl;", "Lcom/TryJeanPc/goldenmouse/controls/ControlEliminable;", "Lcom/TryJeanPc/goldenmouse/controls/EditorHitRegionProvider;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "editorHitDispatcher", "Lcom/TryJeanPc/goldenmouse/controls/EditorHitDispatcher;", "getEditorHitDispatcher", "()Lcom/TryJeanPc/goldenmouse/controls/EditorHitDispatcher;", "editorBodyShape", "Lcom/TryJeanPc/goldenmouse/controls/EditorHitShape;", "editorRegions", "", "Lcom/TryJeanPc/goldenmouse/controls/EditorHitRegion;", "getEditorRegions", "()Ljava/util/List;", "editorRegions$delegate", "Lkotlin/Lazy;", "editorHitRegions", "botonCerrarX", "Landroid/widget/ImageView;", "getBotonCerrarX", "()Landroid/widget/ImageView;", "setBotonCerrarX", "(Landroid/widget/ImageView;)V", "botonConfigurar", "miraContainer", "onEliminar", "Lkotlin/Function0;", "", "onConfigure", "onComponentChanged", "component", "Lcom/TryJeanPc/goldenmouse/profile/ViewComponent;", "teclaActual", "", "technicalCameraView", "Lcom/TryJeanPc/goldenmouse/controls/BotonVistaBlueStacks$TechnicalCameraView;", "cachedTextBounds", "Landroid/graphics/Rect;", "estaEnModoEdicion", "", "getEstaEnModoEdicion", "()Z", "setEstaEnModoEdicion", "(Z)V", "repeatHandler", "Landroid/os/Handler;", "activeTarget", "Lcom/TryJeanPc/goldenmouse/controls/BotonVistaBlueStacks$ArrowTarget;", "arrowGesture", "pressStartTime", "", "repeatRunnable", "com/TryJeanPc/goldenmouse/controls/BotonVistaBlueStacks$repeatRunnable$1", "Lcom/TryJeanPc/goldenmouse/controls/BotonVistaBlueStacks$repeatRunnable$1;", "detectArrowTarget", "x", "", "y", "applyArrowDelta", "target", "delta", "stopRepeating", "onDetachedFromWindow", "handleSensitivityArrowTouch", "ev", "Landroid/view/MotionEvent;", "handleSensitivityArrowTouch$app", "onInterceptTouchEvent", "onTouchEvent", "dispatchTouchEvent", "activarEdicionTecla", "activar", "setLayoutParams", "params", "Landroid/view/ViewGroup$LayoutParams;", "activarEdicion", "desactivarEdicion", "actualizarTecla", "nuevaTecla", "obtenerTeclaActual", "bindingSlots", "updateBinding", "slot", "binding", "Lcom/TryJeanPc/goldenmouse/mapper/InputBinding;", "currentBindings", "", "currentComponent", "Lcom/TryJeanPc/goldenmouse/profile/ControlComponent;", "applyComponent", "setOnConfigure", "listener", "setOnComponentChanged", "updateCoordinates", "obtenerTipo", "seleccionar", "deseleccionar", "obtenerEstado", "Lcom/TryJeanPc/goldenmouse/controls/ControlVisualState;", "aplicarEstiloVisual", "escala", "colorTema", "", "(FLjava/lang/Integer;)V", "onSetAlpha", "alpha", "onDescendantInvalidated", "child", "Landroid/view/View;", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "obtenerVistaEliminar", "establecerOnEliminar", "mostrarEliminar", "ocultarEliminar", "ArrowTarget", "TechnicalCameraView", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class BotonVistaBlueStacks extends FrameLayout implements BotonEditable, ControlConTecla, ControlEliminable, ControlVisual, EditorHitRegionProvider, ProfileComponentControl {
    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2={"Lcom/TryJeanPc/goldenmouse/controls/BotonVistaBlueStacks$ArrowTarget;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "LEFT_UP", "LEFT_DOWN", "RIGHT_UP", "RIGHT_DOWN", "app"}, k=1, mv={2, 2, 0}, xi=0x30) enum ArrowTarget {
        public static final enum ArrowTarget LEFT_DOWN;
        public static final enum ArrowTarget LEFT_UP;
        public static final enum ArrowTarget NONE;
        public static final enum ArrowTarget RIGHT_DOWN;
        public static final enum ArrowTarget RIGHT_UP;

        private static final ArrowTarget[] $values() {
            return new ArrowTarget[]{ArrowTarget.NONE, ArrowTarget.LEFT_UP, ArrowTarget.LEFT_DOWN, ArrowTarget.RIGHT_UP, ArrowTarget.RIGHT_DOWN};
        }

        static {
            ArrowTarget.NONE = new ArrowTarget("NONE", 0);
            ArrowTarget.LEFT_UP = new ArrowTarget("LEFT_UP", 1);
            ArrowTarget.LEFT_DOWN = new ArrowTarget("LEFT_DOWN", 2);
            ArrowTarget.RIGHT_UP = new ArrowTarget("RIGHT_UP", 3);
            ArrowTarget.RIGHT_DOWN = new ArrowTarget("RIGHT_DOWN", 4);
            ArrowTarget[] v0 = ArrowTarget.$values();
            ArrowTarget.$VALUES = v0;
            ArrowTarget.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
        }

        private ArrowTarget(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static EnumEntries getEntries() {
            return ArrowTarget.$ENTRIES;
        }

        public static ArrowTarget valueOf(String arg1) {
            return Enum.valueOf(ArrowTarget.class, arg1);
        }

        public static ArrowTarget[] values() {
            return ArrowTarget.$VALUES.clone();
        }
    }

    @Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000E\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u0007J\u0016\u0010\u0018\u001A\u00020\u00162\u0006\u0010\u0019\u001A\u00020\t2\u0006\u0010\u001A\u001A\u00020\tJ\u0015\u0010\u001B\u001A\u00020\u00162\b\u0010\u001C\u001A\u0004\u0018\u00010\u001D¢\u0006\u0002\u0010\u001EJ\u0010\u0010\'\u001A\u00020\u00162\u0006\u0010(\u001A\u00020)H\u0014R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u000E\u001A\u00020\u000F@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000E\u0010\u001F\u001A\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010!\u001A\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\"\u001A\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010#\u001A\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010$\u001A\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010%\u001A\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010&\u001A\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2={"Lcom/TryJeanPc/goldenmouse/controls/BotonVistaBlueStacks$TechnicalCameraView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "keyText", "", "sensX", "", "sensY", "density", "cachedTextBounds", "Landroid/graphics/Rect;", "value", "", "estaEditandoTecla", "getEstaEditandoTecla", "()Z", "setEstaEditandoTecla", "(Z)V", "setKeyText", "", "text", "setSensitivities", "x", "y", "setThemeColor", "color", "", "(Ljava/lang/Integer;)V", "circleBgPaint", "Landroid/graphics/Paint;", "reticlePaint", "editRingPaint", "crossPaint", "textKeyPaint", "textValuePaint", "arrowPaint", "onDraw", "canvas", "Landroid/graphics/Canvas;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class TechnicalCameraView extends View {
        private final Paint arrowPaint;
        private final Rect cachedTextBounds;
        private final Paint circleBgPaint;
        private final Paint crossPaint;
        private final float density;
        private final Paint editRingPaint;
        private boolean estaEditandoTecla;
        private String keyText;
        private final Paint reticlePaint;
        private float sensX;
        private float sensY;
        private final Paint textKeyPaint;
        private final Paint textValuePaint;

        public TechnicalCameraView(Context arg7) {
            Intrinsics.checkNotNullParameter(arg7, "context");
            super(arg7);
            this.keyText = "F1";
            this.sensX = 2f;
            this.sensY = 2f;
            float v7 = arg7.getResources().getDisplayMetrics().density;
            this.density = v7;
            this.cachedTextBounds = new Rect();
            Paint v0 = new Paint(1);
            v0.setColor(Color.parseColor("#EBF0F5"));
            v0.setStyle(Paint$Style.FILL);
            this.circleBgPaint = v0;
            v0 = new Paint(1);
            v0.setColor(Color.parseColor("#EEFFFFFF"));
            v0.setStyle(Paint$Style.STROKE);
            v0.setStrokeWidth(1.3f * v7);
            this.reticlePaint = v0;
            v0 = new Paint(1);
            v0.setColor(Color.parseColor("#2196F3"));
            v0.setStyle(Paint$Style.STROKE);
            v0.setStrokeWidth(2.5f * v7);
            this.editRingPaint = v0;
            v0 = new Paint(1);
            v0.setColor(Color.parseColor("#CCFFFFFF"));
            v0.setStyle(Paint$Style.STROKE);
            v0.setStrokeWidth(1.1f * v7);
            this.crossPaint = v0;
            v0 = new Paint(1);
            v0.setColor(Color.parseColor("#151515"));
            v0.setTextAlign(Paint$Align.CENTER);
            v0.setTextSize(12f * v7);
            v0.setFakeBoldText(true);
            this.textKeyPaint = v0;
            v0 = new Paint(1);
            v0.setColor(-1);
            v0.setTextAlign(Paint$Align.CENTER);
            v0.setTextSize(9.5f * v7);
            v0.setFakeBoldText(true);
            v0.setShadowLayer(3f * v7, 0f, 1f * v7, Color.parseColor("#99000000"));
            this.textValuePaint = v0;
            v0 = new Paint(1);
            v0.setColor(Color.parseColor("#B0FFFFFF"));
            v0.setStyle(Paint$Style.STROKE);
            v0.setStrokeWidth(v7 * 1.2f);
            v0.setStrokeCap(Paint$Cap.ROUND);
            v0.setStrokeJoin(Paint$Join.ROUND);
            this.arrowPaint = v0;
        }

        public final boolean getEstaEditandoTecla() {
            return this.estaEditandoTecla;
        }

        protected void onDraw(Canvas arg14) {
            Intrinsics.checkNotNullParameter(arg14, "canvas");
            super.onDraw(arg14);
            float v2 = 2f;
            float v1 = (((float)this.getWidth())) / v2;
            float v6 = (((float)this.getHeight())) / v2;
            float v4 = 12.5f * this.density;
            float v7 = this.density * 16.5f;
            arg14.drawCircle(v1, v6, v4, this.circleBgPaint);
            if(this.estaEditandoTecla) {
                arg14.drawCircle(v1, v6, v4 + this.density * 1.8f, this.editRingPaint);
            }

            this.textKeyPaint.getTextBounds(this.keyText, 0, this.keyText.length(), this.cachedTextBounds);
            arg14.drawText(this.keyText, v1, (((float)this.cachedTextBounds.height())) / v2 + v6 - this.density * 0.5f, this.textKeyPaint);
            arg14.drawCircle(v1, v6, v7, this.reticlePaint);
            float v8 = this.density * 5f;
            v4 = v6 - v7;
            arg14.drawLine(v1, v4 - v8, v1, v4, this.crossPaint);
            v2 = v6 + v7;
            arg14.drawLine(v1, v2, v1, v2 + v8, this.crossPaint);
            float v9 = v1;
            float v3 = v9 - v7;
            arg14.drawLine(v3 - v8, v6, v3, v6, this.crossPaint);
            v1 = v9 + v7;
            arg14.drawLine(v1, v6, v1 + v8, v6, this.crossPaint);
            v1 = v9 - this.density * 36f;
            v8 = v6 + this.textValuePaint.getTextSize() / 3f;
            arg14.drawText("X " + this.sensX, v1, v8, this.textValuePaint);
            v4 = v6 - this.density * 9f;
            arg14.drawLine(v1 - this.density * 3.5f, this.density * 2.5f + v4, v1, v4, this.arrowPaint);
            arg14.drawLine(v1, v4, this.density * 3.5f + v1, v4 + this.density * 2.5f, this.arrowPaint);
            v2 = this.density * 9f + v6;
            arg14.drawLine(v1 - this.density * 3.5f, v2 - this.density * 2.5f, v1, v2, this.arrowPaint);
            arg14.drawLine(v1, v2, this.density * 3.5f + v1, v2 - this.density * 2.5f, this.arrowPaint);
            v1 = this.density * 36f + v9;
            arg14.drawText(this.sensY + " Y", v1, v8, this.textValuePaint);
            v4 = v6 - this.density * 9f;
            arg14.drawLine(v1 - this.density * 3.5f, this.density * 2.5f + v4, v1, v4, this.arrowPaint);
            arg14.drawLine(v1, v4, this.density * 3.5f + v1, v4 + this.density * 2.5f, this.arrowPaint);
            v2 = v6 + 9f * this.density;
            arg14.drawLine(v1 - this.density * 3.5f, v2 - this.density * 2.5f, v1, v2, this.arrowPaint);
            arg14.drawLine(v1, v2, v1 + 3.5f * this.density, v2 - this.density * 2.5f, this.arrowPaint);
        }

        public final void setEstaEditandoTecla(boolean arg1) {
            this.estaEditandoTecla = arg1;
            this.invalidate();
        }

        public final void setKeyText(String arg2) {
            Intrinsics.checkNotNullParameter(arg2, "text");
            if(((CharSequence)arg2).length() == 0) {
                arg2 = "F1";
            }

            this.keyText = arg2;
            this.invalidate();
        }

        public final void setSensitivities(float arg1, float arg2) {
            this.sensX = arg1;
            this.sensY = arg2;
            this.invalidate();
        }

        public final void setThemeColor(Integer arg3) {
            Paint v0 = this.reticlePaint;
            if(arg3 != null) {
                v0.setColor(arg3.intValue());
                this.crossPaint.setColor(arg3.intValue());
                this.arrowPaint.setColor(arg3.intValue());
            }
            else {
                v0.setColor(Color.parseColor("#EEFFFFFF"));
                this.crossPaint.setColor(Color.parseColor("#CCFFFFFF"));
                this.arrowPaint.setColor(Color.parseColor("#B0FFFFFF"));
            }

            this.invalidate();
        }
    }

    @Metadata(k=3, mv={2, 2, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[ArrowTarget.values().length];
            try {
                v0[ArrowTarget.LEFT_UP.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[ArrowTarget.LEFT_DOWN.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[ArrowTarget.RIGHT_UP.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_15:
                            v0[ArrowTarget.RIGHT_DOWN.ordinal()] = 4;
                            goto label_19;
                        }
                        catch(NoSuchFieldError ) {
                            try {
                            label_19:
                                v0[ArrowTarget.NONE.ordinal()] = 5;
                                goto label_23;
                            }
                            catch(NoSuchFieldError ) {
                            label_23:
                                WhenMappings.$EnumSwitchMapping$0 = v0;
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    public static final int $stable = 8;
    private ArrowTarget activeTarget;
    private boolean arrowGesture;
    public ImageView botonCerrarX;
    private ImageView botonConfigurar;
    private final Rect cachedTextBounds;
    private ViewComponent component;
    private final EditorHitShape editorBodyShape;
    private final EditorHitDispatcher editorHitDispatcher;
    private final Lazy editorRegions$delegate;
    private boolean estaEnModoEdicion;
    private FrameLayout miraContainer;
    private Function0 onComponentChanged;
    private Function0 onConfigure;
    private Function0 onEliminar;
    private long pressStartTime;
    private final Handler repeatHandler;
    private final BotonVistaBlueStacks$repeatRunnable$1 repeatRunnable;
    private final TechnicalCameraView technicalCameraView;
    private String teclaActual;

    static {
    }

    public BotonVistaBlueStacks(Context arg27) {
        BotonVistaBlueStacks v0 = this;
        Context v1 = arg27;
        Intrinsics.checkNotNullParameter(v1, "context");
        super(arg27);
        v0.editorHitDispatcher = new EditorHitDispatcher(v0);
        v0.editorBodyShape = new BotonVistaBlueStacks$$ExternalSyntheticLambda1(v0);
        v0.editorRegions$delegate = LazyKt.lazy(new BotonVistaBlueStacks$$ExternalSyntheticLambda2(v0));
        v0.component = new ViewComponent(false, 0f, 0f, false, false, 0f, 0f, 0f, 0f, null, false, null, 0f, null, null, false, null, 0, false, 0x7FFFF, null);
        v0.teclaActual = "F1";
        TechnicalCameraView v2 = new TechnicalCameraView(v1);
        v2.setLayoutParams(new FrameLayout$LayoutParams(-1, -1));
        v2.setKeyText(v0.teclaActual);
        v0.technicalCameraView = v2;
        v0.cachedTextBounds = new Rect();
        v0.repeatHandler = new Handler(Looper.getMainLooper());
        v0.activeTarget = ArrowTarget.NONE;
        v0.repeatRunnable = new BotonVistaBlueStacks$repeatRunnable$1(v0);
        BotonVistaBlueStacks$$ExternalSyntheticLambda3 v5 = new BotonVistaBlueStacks$$ExternalSyntheticLambda3(v1.getResources().getDisplayMetrics().density);
        v0.setClipChildren(false);
        v0.setClipToPadding(false);
        FrameLayout$LayoutParams v6 = new FrameLayout$LayoutParams(((Function1)v5).invoke(Integer.valueOf(120)).intValue(), ((Function1)v5).invoke(Integer.valueOf(50)).intValue());
        v6.gravity = 17;
        v0.setLayoutParams(((ViewGroup$LayoutParams)v6));
        v0.addView(((View)v2));
        FrameLayout v2_1 = new FrameLayout(v1);
        v2_1.setClipChildren(false);
        v2_1.setClipToPadding(false);
        Integer v6_1 = Integer.valueOf(44);
        int v8 = ((Function1)v5).invoke(v6_1).intValue();
        Integer v9 = Integer.valueOf(40);
        FrameLayout$LayoutParams v3 = new FrameLayout$LayoutParams(v8 + ((Function1)v5).invoke(v9).intValue(), ((Function1)v5).invoke(v6_1).intValue() + ((Function1)v5).invoke(v9).intValue());
        v3.gravity = 17;
        v2_1.setLayoutParams(((ViewGroup$LayoutParams)v3));
        v0.miraContainer = v2_1;
        ImageView v2_2 = new ImageView(v1);
        v2_2.setImageResource(0x1080038);
        v2_2.setColorFilter(-1);
        v2_2.setScaleType(ImageView$ScaleType.CENTER_INSIDE);
        Integer v3_1 = Integer.valueOf(2);
        v2_2.setPadding(((Function1)v5).invoke(v3_1).intValue(), ((Function1)v5).invoke(v3_1).intValue(), ((Function1)v5).invoke(v3_1).intValue(), ((Function1)v5).invoke(v3_1).intValue());
        GradientDrawable v3_2 = new GradientDrawable();
        v3_2.setShape(1);
        v3_2.setColor(0xFF000000);
        v2_2.setBackground(((Drawable)v3_2));
        Integer v4 = Integer.valueOf(22);
        v3 = new FrameLayout$LayoutParams(((Function1)v5).invoke(v4).intValue(), ((Function1)v5).invoke(v4).intValue());
        v3.gravity = 0x800035;
        v4 = Integer.valueOf(6);
        v3.topMargin = ((Function1)v5).invoke(v4).intValue();
        v3.setMarginEnd(((Function1)v5).invoke(v4).intValue());
        v2_2.setLayoutParams(((ViewGroup$LayoutParams)v3));
        int v3_3 = 8;
        v2_2.setVisibility(v3_3);
        v2_2.setContentDescription("Eliminar vista");
        v2_2.setOnClickListener(new BotonVistaBlueStacks$$ExternalSyntheticLambda4(v0));
        v0.setBotonCerrarX(v2_2);
        v2_1 = v0.miraContainer;
        String v6_2 = "miraContainer";
        Drawable v7 = null;
        if(v2_1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v6_2);
            v2_1 = ((FrameLayout)v7);
        }

        v2_1.addView(v0.getBotonCerrarX());
        v2_2 = new ImageView(v1);
        v2_2.setImageResource(drawable.settingsbt);
        v2_2.setBackground(v7);
        v2_2.setScaleType(ImageView$ScaleType.FIT_CENTER);
        v2_2.setElevation(16f);
        v2_2.setTranslationZ(16f);
        v2_2.setContentDescription("Configurar vista");
        FrameLayout$LayoutParams v1_1 = new FrameLayout$LayoutParams(((Function1)v5).invoke(Integer.valueOf(24)).intValue(), ((Function1)v5).invoke(Integer.valueOf(24)).intValue());
        v1_1.gravity = 0x800053;
        v1_1.bottomMargin = ((Function1)v5).invoke(v4).intValue();
        v1_1.setMarginStart(((Function1)v5).invoke(v4).intValue());
        v2_2.setLayoutParams(((ViewGroup$LayoutParams)v1_1));
        v2_2.setVisibility(v3_3);
        v2_2.setOnClickListener(new BotonVistaBlueStacks$$ExternalSyntheticLambda5(v0));
        v0.botonConfigurar = v2_2;
        FrameLayout v1_2 = v0.miraContainer;
        if(v1_2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v6_2);
            v1_2 = ((FrameLayout)v7);
        }

        v2_2 = v0.botonConfigurar;
        if(v2_2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("botonConfigurar");
            View v2_3 = ((View)v7);
        }

        v1_2.addView(((View)v2_2));
        v1_2 = v0.miraContainer;
        if(v1_2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v6_2);
        }
        else {
            FrameLayout v7_1 = v1_2;
        }

        v0.addView(((View)v7));
    }

    static final int _init_$lambda$3(float arg0, int arg1) {
        return ((int)((((float)arg1)) * arg0));
    }

    public static final void access$applyArrowDelta(BotonVistaBlueStacks arg0, ArrowTarget arg1, float arg2) {
        arg0.applyArrowDelta(arg1, arg2);
    }

    public static final ArrowTarget access$getActiveTarget$p(BotonVistaBlueStacks arg0) {
        return arg0.activeTarget;
    }

    public static final long access$getPressStartTime$p(BotonVistaBlueStacks arg2) {
        return arg2.pressStartTime;
    }

    public static final Handler access$getRepeatHandler$p(BotonVistaBlueStacks arg0) {
        return arg0.repeatHandler;
    }

    public void activarEdicion() {
        this.setEstaEnModoEdicion(true);
        this.getBotonCerrarX().setVisibility(0);
        ImageView v2 = this.botonConfigurar;
        if(v2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("botonConfigurar");
            v2 = null;
        }

        v2.setVisibility(0);
    }

    public final void activarEdicionTecla(boolean arg1) {
        this.technicalCameraView.setEstaEditandoTecla(arg1);
    }

    public void actualizarTecla(String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "nuevaTecla");
        arg2 = StringsKt.trim(((CharSequence)arg2)).toString().toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(arg2, "toUpperCase(...)");
        if(((CharSequence)arg2).length() == 0) {
            arg2 = "F1";
        }

        this.teclaActual = arg2;
        this.technicalCameraView.setKeyText(arg2);
    }

    public void aplicarEstiloVisual(float arg4, Integer arg5) {
        arg4 = RangesKt.coerceIn(arg4, 0.5f, 1.5f);
        this.technicalCameraView.setScaleX(arg4);
        this.technicalCameraView.setScaleY(arg4);
        FrameLayout v0 = this.miraContainer;
        FrameLayout v1 = null;
        String v2 = "miraContainer";
        if(v0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v2);
            v0 = v1;
        }

        v0.setScaleX(arg4);
        v0 = this.miraContainer;
        if(v0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v2);
        }
        else {
            v1 = v0;
        }

        v1.setScaleY(arg4);
        this.technicalCameraView.setThemeColor(arg5);
    }

    private final void applyArrowDelta(ArrowTarget arg28, float arg29) {
        float v6;
        float v7;
        BotonVistaBlueStacks v0 = this;
        float v1 = arg29;
        float v2 = v0.component.getSensitivityX();
        float v3 = v0.component.getSensitivityY();
        int v4 = WhenMappings.$EnumSwitchMapping$0[arg28.ordinal()];
        if(v4 == 1) {
            v2 = BotonVistaBlueStacksKt.stepVistaSensitivity(v2, v1);
            if(v0.component.getLinkedSensitivities()) {
            label_45:
                v6 = v2;
            label_46:
                v7 = v6;
            }
            else {
            label_48:
                v6 = v2;
                v7 = v3;
            }

            v0.component = ViewComponent.copy$default(v0.component, false, v6, v7, false, false, 0f, 0f, 0f, 0f, null, false, null, 0f, null, null, false, null, 0, false, 0x7FFF9, null);
            v0.technicalCameraView.setSensitivities(v6, v7);
            Function0 v0_1 = v0.onComponentChanged;
            if(v0_1 == null) {
                return;
            }

            v0_1.invoke();
        }
        else if(v4 != 2) {
            if(v4 == 3) {
                v3 = BotonVistaBlueStacksKt.stepVistaSensitivity(v3, v1);
                if(v0.component.getLinkedSensitivities()) {
                    goto label_33;
                }

                goto label_48;
            }
            else if(v4 == 4) {
                v3 = BotonVistaBlueStacksKt.stepVistaSensitivity(v3, -v1);
                if(v0.component.getLinkedSensitivities()) {
                }
                else {
                    goto label_48;
                }
            }
            else if(v4 == 5) {
                return;
            }
            else {
                throw new NoWhenBranchMatchedException();
            }

        label_33:
            v6 = v3;
            goto label_46;
        }
        else {
            v2 = BotonVistaBlueStacksKt.stepVistaSensitivity(v2, -v1);
            if(!v0.component.getLinkedSensitivities()) {
                goto label_48;
            }

            goto label_45;
        }
    }

    public void applyComponent(ControlComponent arg2) {
        Intrinsics.checkNotNullParameter(arg2, "component");
        if((arg2 instanceof ViewComponent)) {
            this.component = ((ViewComponent)arg2);
            this.technicalCameraView.setSensitivities(((ViewComponent)arg2).getSensitivityX(), ((ViewComponent)arg2).getSensitivityY());
        }
    }

    public List bindingSlots() {
        return CollectionsKt.listOf("PRIMARY");
    }

    public Map currentBindings() {
        InputBinding v1 = InputBinding.Companion.fromDisplayName(this.teclaActual);
        if(v1 == null) {
            return MapsKt.emptyMap();
        }

        return MapsKt.mapOf(TuplesKt.to("PRIMARY", v1));
    }

    public ControlComponent currentComponent() {
        return this.component;
    }

    public void desactivarEdicion() {
        this.setEstaEnModoEdicion(false);
        this.activarEdicionTecla(false);
        int v1 = 8;
        this.getBotonCerrarX().setVisibility(v1);
        ImageView v2 = this.botonConfigurar;
        if(v2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("botonConfigurar");
            v2 = null;
        }

        v2.setVisibility(v1);
    }

    public void deseleccionar() {
        this.desactivarEdicion();
    }

    private final ArrowTarget detectArrowTarget(float arg8, float arg9) {
        Matrix v0 = new Matrix();
        Matrix v1 = EditorHitDispatcher.Companion.matrixTo$app(this, this.technicalCameraView);
        if(v1 != null && (v1.invert(v0))) {
            float[] v1_1 = new float[]{arg8, arg9};
            v0.mapPoints(v1_1);
            arg8 = this.getResources().getDisplayMetrics().density;
            arg9 = (((float)this.technicalCameraView.getWidth())) / 2f;
            float v7 = (((float)this.technicalCameraView.getHeight())) / 2f;
            float v0_1 = 36f * arg8;
            float v4 = arg9 - v0_1;
            arg9 += v0_1;
            v0_1 = 9f * arg8;
            float v5 = v7 - v0_1;
            v7 += v0_1;
            v0_1 = 16f * arg8;
            arg8 *= 10f;
            if(Math.abs(v1_1[0] - v4) <= v0_1 && Math.abs(v1_1[1] - v5) <= arg8) {
                return ArrowTarget.LEFT_UP;
            }

            if(Math.abs(v1_1[0] - v4) <= v0_1 && Math.abs(v1_1[1] - v7) <= arg8) {
                return ArrowTarget.LEFT_DOWN;
            }

            if(Math.abs(v1_1[0] - arg9) <= v0_1 && Math.abs(v1_1[1] - v5) <= arg8) {
                return ArrowTarget.RIGHT_UP;
            }

            if(Math.abs(v1_1[0] - arg9) <= v0_1 && Math.abs(v1_1[1] - v7) <= arg8) {
                return ArrowTarget.RIGHT_DOWN;
            }

            return ArrowTarget.NONE;
        }

        return ArrowTarget.NONE;
    }

    protected void dispatchDraw(Canvas arg9) {
        Intrinsics.checkNotNullParameter(arg9, "canvas");
        int v0 = ((int)(this.getAlpha() * 255f));
        if(v0 == 0) {
            return;
        }

        if(v0 == 0xFF) {
            super.dispatchDraw(arg9);
            return;
        }

        RectF v1 = new RectF(0f, 0f, ((float)this.getWidth()), ((float)this.getHeight()));
        Iterator v2 = this.editorHitRegions().iterator();
        while(v2.hasNext()) {
            Object v3 = v2.next();
            if(!((EditorHitRegion)v3).getVisibleFigure()) {
                continue;
            }

            if(((EditorHitRegion)v3).getView().getVisibility() != 0) {
                continue;
            }

            RectF v5 = new RectF(0f, 0f, ((float)((EditorHitRegion)v3).getView().getWidth()), ((float)((EditorHitRegion)v3).getView().getHeight()));
            Matrix v3_1 = EditorHitDispatcher.Companion.matrixTo$app(this, ((EditorHitRegion)v3).getView());
            if(v3_1 == null) {
                continue;
            }

            v3_1.mapRect(v5);
            v1.union(v5);
        }

        v0 = arg9.saveLayerAlpha(v1, v0);
        try {
            super.dispatchDraw(arg9);
        }
        catch(Throwable v8) {
            arg9.restoreToCount(v0);
            throw v8;
        }

        arg9.restoreToCount(v0);
    }

    public boolean dispatchTouchEvent(MotionEvent arg3) {
        Intrinsics.checkNotNullParameter(arg3, "ev");
        return this.getEditorHitDispatcher().dispatch(arg3, new BotonVistaBlueStacks$$ExternalSyntheticLambda0(this));
    }

    static final boolean dispatchTouchEvent$lambda$14(BotonVistaBlueStacks arg1, MotionEvent arg2) {
        Intrinsics.checkNotNullParameter(arg2, "it");
        return super.dispatchTouchEvent(arg2);
    }

    static final float editorBodyShape$lambda$0(BotonVistaBlueStacks arg3, float arg4, float arg5, float arg6, float arg7) {
        float v3 = arg3.getResources().getDisplayMetrics().density;
        arg4 -= arg6 / 2f;
        arg6 = 20f * v3;
        arg5 -= arg7 / 2f;
        arg7 = 40f * v3;
        return Math.min(EditorHitShapes.INSTANCE.getOval().distance(arg4 + arg6, arg6 + arg5, arg7, arg7), EditorHitShapes.INSTANCE.getRectangle().distance(arg4 + 56f * v3, arg5 + 16f * v3, 112f * v3, v3 * 32f));
    }

    public List editorHitRegions() {
        return this.getEditorRegions();
    }

    static final List editorRegions_delegate$lambda$1(BotonVistaBlueStacks arg13) {
        EditorHitRegion[] v0 = new EditorHitRegion[4];
        v0[0] = new EditorHitRegion(arg13.technicalCameraView, arg13.editorBodyShape, null, 0f, false, 28, null);
        ImageView v1 = arg13.botonConfigurar;
        ImageView v2 = null;
        String v4 = "botonConfigurar";
        if(v1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v4);
            v1 = v2;
        }

        EditorHitShape v5 = EditorHitShapes.INSTANCE.getOval();
        ImageView v6 = arg13.botonConfigurar;
        if(v6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v4);
        }
        else {
            v2 = v6;
        }

        v0[1] = new EditorHitRegion(v1, v5, v2, 0f, false, 24, null);
        v0[2] = new EditorHitRegion(arg13.getBotonCerrarX(), EditorHitShapes.INSTANCE.getOval(), arg13.getBotonCerrarX(), 0f, false, 24, null);
        v0[3] = new EditorHitRegion(arg13, arg13.editorBodyShape, null, 0f, false, 4, null);
        return CollectionsKt.listOf(((Object[])v0));
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

    public final boolean handleSensitivityArrowTouch$app(MotionEvent arg5) {
        boolean v0;
        Intrinsics.checkNotNullParameter(arg5, "ev");
        if(arg5.getActionMasked() == 0) {
            if(arg5.getPointerCount() == 1) {
                if((arg5.isFromSource(0x2002)) && arg5.getButtonState() != 1) {
                    goto label_20;
                }

                if(this.detectArrowTarget(arg5.getX(), arg5.getY()) == ArrowTarget.NONE) {
                    goto label_20;
                }

                v0 = true;
            }
            else {
            label_20:
                v0 = false;
            }

            this.arrowGesture = v0;
        }

        if(!this.arrowGesture) {
            return 0;
        }

        this.onTouchEvent(arg5);
        if(arg5.getActionMasked() == 1 || arg5.getActionMasked() == 3) {
            this.arrowGesture = false;
        }

        return 1;
    }

    static final void lambda$10$lambda$9(BotonVistaBlueStacks arg0, View arg1) {
        Function0 v0 = arg0.onEliminar;
        if(v0 != null) {
            v0.invoke();
        }
    }

    static final void lambda$13$lambda$12(BotonVistaBlueStacks arg0, View arg1) {
        Function0 v0 = arg0.onConfigure;
        if(v0 != null) {
            v0.invoke();
        }
    }

    public void mostrarEliminar() {
        this.getBotonCerrarX().setVisibility(0);
        ImageView v2 = this.botonConfigurar;
        if(v2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("botonConfigurar");
            v2 = null;
        }

        v2.setVisibility(0);
    }

    public ControlVisualState obtenerEstado() {
        float v0 = this.getContext().getResources().getDisplayMetrics().density;
        String v2 = this.obtenerTipo();
        float v3 = this.getX();
        float v4 = this.getY();
        int v5 = ((int)(120f * v0));
        int v6 = ((int)(50f * v0));
        String v8 = this.teclaActual;
        if(((CharSequence)v8).length() == 0) {
            v8 = null;
        }

        return new ControlVisualState(v2, v3, v4, v5, v6, v8);
    }

    public String obtenerTeclaActual() {
        return this.teclaActual;
    }

    public String obtenerTipo() {
        return "CAMARA";
    }

    public View obtenerVistaEliminar() {
        return this.getBotonCerrarX();
    }

    public void ocultarEliminar() {
        int v1 = 8;
        this.getBotonCerrarX().setVisibility(v1);
        ImageView v2 = this.botonConfigurar;
        if(v2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("botonConfigurar");
            v2 = null;
        }

        v2.setVisibility(v1);
    }

    public void onDescendantInvalidated(View arg2, View arg3) {
        Intrinsics.checkNotNullParameter(arg2, "child");
        Intrinsics.checkNotNullParameter(arg3, "target");
        super.onDescendantInvalidated(arg2, arg3);
        if(this.getAlpha() > 0f && this.getAlpha() < 1f) {
            this.invalidate();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.stopRepeating();
        this.arrowGesture = false;
        ViewParent v1 = this.getParent();
        if(v1 != null) {
            v1.requestDisallowInterceptTouchEvent(false);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent arg4) {
        Intrinsics.checkNotNullParameter(arg4, "ev");
        if(arg4.getActionMasked() == 0 && this.detectArrowTarget(arg4.getX(), arg4.getY()) != ArrowTarget.NONE) {
            return 1;
        }

        if(!this.getEditorHitDispatcher().isBodyGesture()) {
            if(super.onInterceptTouchEvent(arg4)) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    protected boolean onSetAlpha(int arg1) {
        return 1;
    }

    public boolean onTouchEvent(MotionEvent arg5) {
        ViewParent v4;
        Intrinsics.checkNotNullParameter(arg5, "ev");
        int v0 = arg5.getActionMasked();
        if(v0 != 0) {
            if(v0 != 1) {
                if(v0 != 2) {
                    if(v0 != 3 && v0 != 5 && v0 != 6) {
                        goto label_58;
                    }
                }
                else if(this.activeTarget != ArrowTarget.NONE) {
                    if(this.detectArrowTarget(arg5.getX(), arg5.getY()) != this.activeTarget) {
                        this.stopRepeating();
                        v4 = this.getParent();
                        if(v4 != null) {
                            v4.requestDisallowInterceptTouchEvent(false);
                        }
                    }

                    return 1;
                }
                else {
                    goto label_58;
                }
            }

            if(this.activeTarget == ArrowTarget.NONE) {
                goto label_58;
            }

            this.stopRepeating();
            v4 = this.getParent();
            if(v4 != null) {
                v4.requestDisallowInterceptTouchEvent(false);
            }

            return 1;
        }
        else {
            ArrowTarget v0_1 = this.detectArrowTarget(arg5.getX(), arg5.getY());
            if(v0_1 == ArrowTarget.NONE) {
                goto label_58;
            }

            ViewParent v5 = this.getParent();
            if(v5 != null) {
                v5.requestDisallowInterceptTouchEvent(true);
            }

            this.activeTarget = v0_1;
            this.pressStartTime = SystemClock.uptimeMillis();
            this.applyArrowDelta(v0_1, 0.1f);
            this.repeatHandler.removeCallbacks(this.repeatRunnable);
            this.repeatHandler.postDelayed(this.repeatRunnable, 100);
            return 1;
        }

    label_58:
        return super.onTouchEvent(arg5);
    }

    public void seleccionar() {
        this.activarEdicion();
    }

    public void setBotonCerrarX(ImageView arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<set-?>");
        this.botonCerrarX = arg2;
    }

    public void setEstaEnModoEdicion(boolean arg1) {
        this.estaEnModoEdicion = arg1;
    }

    public void setLayoutParams(ViewGroup$LayoutParams arg3) {
        float v0 = this.getContext().getResources().getDisplayMetrics().density;
        if(arg3 != null) {
            arg3.width = ((int)(120f * v0));
            arg3.height = ((int)(50f * v0));
        }

        super.setLayoutParams(arg3);
    }

    public void setOnComponentChanged(Function0 arg1) {
        this.onComponentChanged = arg1;
    }

    public void setOnConfigure(Function0 arg1) {
        this.onConfigure = arg1;
    }

    private final void stopRepeating() {
        this.repeatHandler.removeCallbacks(this.repeatRunnable);
        this.activeTarget = ArrowTarget.NONE;
    }

    public void updateBinding(String arg2, InputBinding arg3) {
        Intrinsics.checkNotNullParameter(arg2, "slot");
        Intrinsics.checkNotNullParameter(arg3, "binding");
        if(!Intrinsics.areEqual(arg2, "PRIMARY")) {
            return;
        }

        this.actualizarTecla(arg3.displayName());
    }

    public final void updateCoordinates(float arg1, float arg2) {
    }
}

