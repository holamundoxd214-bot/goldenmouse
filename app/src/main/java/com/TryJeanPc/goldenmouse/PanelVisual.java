package com.TryJeanPc.goldenmouse;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint$Join;
import android.graphics.Paint$Style;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.WindowManager$LayoutParams;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.CompoundButton;
import android.widget.FrameLayout$LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout$LayoutParams;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\n\b\u0007\u0018\u0000 =2\u00020\u0001:\u0002=>B)\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001A\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u001E\u001A\u00020\u00182\u0006\u0010\u001F\u001A\u00020\u0018H\u0002J\u0006\u0010 \u001A\u00020\bJ\u0018\u0010!\u001A\u00020\b2\u0006\u0010\"\u001A\u00020#2\u0006\u0010$\u001A\u00020%H\u0002J\u0010\u0010&\u001A\u00020\b2\u0006\u0010\"\u001A\u00020#H\u0002J4\u0010\'\u001A\u00020\b2\u0006\u0010\"\u001A\u00020#2\u0006\u0010(\u001A\u00020%2\u0006\u0010)\u001A\u00020\u00132\u0012\u0010*\u001A\u000E\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\b0+H\u0002JL\u0010,\u001A\u00020-2\u0006\u0010\"\u001A\u00020#2\u0006\u0010(\u001A\u00020%2\u0006\u0010.\u001A\u00020\u00182\u0006\u0010/\u001A\u00020\u00182\u0006\u00100\u001A\u00020\u00182\u0006\u00101\u001A\u00020%2\u0012\u0010*\u001A\u000E\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\b0+H\u0002JR\u00102\u001A\u00020\b2\u0006\u0010\"\u001A\u00020#2\u0006\u0010(\u001A\u00020%2\u0006\u00103\u001A\u00020%2\u000E\b\u0002\u00104\u001A\b\u0012\u0004\u0012\u00020%052\b\b\u0002\u00106\u001A\u00020\u00132\u0016\b\u0002\u0010*\u001A\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\b\u0018\u00010+H\u0002J&\u00107\u001A\u00020\b2\u0006\u0010\"\u001A\u00020#2\u0006\u0010(\u001A\u00020%2\f\u00108\u001A\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\u0006\u00109\u001A\u00020\bJ\u0010\u0010:\u001A\u00020\b2\u0006\u0010;\u001A\u00020\u0013H\u0002J\u0006\u0010<\u001A\u00020\bR\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001A\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000B\u001A\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR\u0010\u0010\u0010\u001A\u0004\u0018\u00010\u0011X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0013X\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001A\n \u0016*\u0004\u0018\u00010\u00150\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0017\u001A\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0019\u001A\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001A\u001A\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001B\u001A\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001C\u001A\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001D\u001A\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, d2={"Lcom/TryJeanPc/goldenmouse/PanelVisual;", "", "context", "Landroid/content/Context;", "windowManager", "Landroid/view/WindowManager;", "onCerrar", "Lkotlin/Function0;", "", "<init>", "(Landroid/content/Context;Landroid/view/WindowManager;Lkotlin/jvm/functions/Function0;)V", "onAjustesBotonesChange", "getOnAjustesBotonesChange", "()Lkotlin/jvm/functions/Function0;", "setOnAjustesBotonesChange", "(Lkotlin/jvm/functions/Function0;)V", "vistaPanel", "Landroid/view/View;", "cerrando", "", "prefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "oro", "", "oroTransparente", "blanco", "secundario", "linea", "fondo", "dp", "valor", "mostrar", "agregarSeccion", "parent", "Landroid/widget/LinearLayout;", "texto", "", "agregarSeparador", "agregarSwitch", "titulo", "activo", "cambio", "Lkotlin/Function1;", "agregarSlider", "Landroid/widget/SeekBar;", "min", "max", "inicial", "sufijo", "agregarSelector", "valorActual", "opciones", "", "colorearSegunTema", "agregarBotonAccion", "accion", "cerrar", "cerrarPanel", "notificar", "destruir", "Companion", "FondoPanel", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class PanelVisual {
    @Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\n\u001A\u0004\u0018\u00010\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\rR\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\t¨\u0006\u000E"}, d2={"Lcom/TryJeanPc/goldenmouse/PanelVisual$Companion;", "", "<init>", "()V", "PREFS_NAME", "", "TEMAS_BOTONES", "", "getTEMAS_BOTONES", "()Ljava/util/List;", "resolverColorTema", "", "tema", "(Ljava/lang/String;)Ljava/lang/Integer;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final List getTEMAS_BOTONES() {
            return PanelVisual.TEMAS_BOTONES;
        }

        public final Integer resolverColorTema(String arg2) {
            String v1 = "#FFD700";
            if(arg2 != null) {
                switch(arg2.hashCode()) {
                    case 236717922: {
                        goto label_26;
                    }
                    case 686321725: {
                        goto label_18;
                    }
                    case 1443687921: {
                        goto label_12;
                    }
                    case 2052785701: {
                        goto label_5;
                    }
                    case -1803051307: {
                        goto label_42;
                    }
                    case -1225860224: {
                        goto label_34;
                    }
                }

                goto label_50;
            label_18:
                if(!arg2.equals("Verde Matrix")) {
                }
                else {
                    return Integer.valueOf(Color.parseColor("#00E676"));
                label_34:
                    if(!arg2.equals("Rojo Fuego")) {
                    }
                    else {
                        return Integer.valueOf(Color.parseColor("#FF1744"));
                    label_5:
                        if(!arg2.equals("Dorado")) {
                        }
                        else {
                            return Integer.valueOf(Color.parseColor(v1));
                        label_42:
                            if(!arg2.equals("Morado Cyber")) {
                            }
                            else {
                                return Integer.valueOf(Color.parseColor("#D500F9"));
                            label_26:
                                if(!arg2.equals("Azul Neón")) {
                                }
                                else {
                                    return Integer.valueOf(Color.parseColor("#00E5FF"));
                                label_12:
                                    if(!arg2.equals("Original")) {
                                    }
                                    else {
                                        return null;
                                    }
                                }
                            }
                        }
                    }
                }
            }

        label_50:
            return Integer.valueOf(Color.parseColor(v1));
        }
    }

    @Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0012H\u0016J\u0010\u0010\u0013\u001A\u00020\u00102\u0006\u0010\u0014\u001A\u00020\u0003H\u0016J\u0012\u0010\u0015\u001A\u00020\u00102\b\u0010\u0016\u001A\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001A\u00020\u0003H\u0017R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2={"Lcom/TryJeanPc/goldenmouse/PanelVisual$FondoPanel;", "Landroid/graphics/drawable/Drawable;", "colorFondo", "", "colorBorde", "corte", "", "grosor", "<init>", "(IIFF)V", "ruta", "Landroid/graphics/Path;", "pinturaFondo", "Landroid/graphics/Paint;", "pinturaBorde", "draw", "", "canvas", "Landroid/graphics/Canvas;", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "getOpacity", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class FondoPanel extends Drawable {
        private final int colorBorde;
        private final int colorFondo;
        private final float corte;
        private final float grosor;
        private final Paint pinturaBorde;
        private final Paint pinturaFondo;
        private final Path ruta;

        public FondoPanel(int arg3, int arg4, float arg5, float arg6) {
            super();
            this.colorFondo = arg3;
            this.colorBorde = arg4;
            this.corte = arg5;
            this.grosor = arg6;
            this.ruta = new Path();
            Paint v5 = new Paint(1);
            v5.setStyle(Paint$Style.FILL);
            v5.setColor(arg3);
            this.pinturaFondo = v5;
            Paint v3 = new Paint(1);
            v3.setStyle(Paint$Style.STROKE);
            v3.setStrokeWidth(arg6);
            v3.setStrokeJoin(Paint$Join.MITER);
            v3.setColor(arg4);
            this.pinturaBorde = v3;
        }

        public void draw(Canvas arg7) {
            Intrinsics.checkNotNullParameter(arg7, "canvas");
            float v0 = this.grosor / 2f;
            float v1 = (((float)this.getBounds().left)) + v0;
            float v2 = (((float)this.getBounds().top)) + v0;
            float v3 = (((float)this.getBounds().right)) - v0;
            float v4 = (((float)this.getBounds().bottom)) - v0;
            this.ruta.reset();
            this.ruta.moveTo(this.corte + v1, v2);
            this.ruta.lineTo(v3, v2);
            this.ruta.lineTo(v3, v4);
            this.ruta.lineTo(this.corte + v1, v4);
            this.ruta.lineTo(v1, v4 - this.corte);
            this.ruta.lineTo(v1, v2 + this.corte);
            this.ruta.close();
            arg7.drawPath(this.ruta, this.pinturaFondo);
            arg7.drawPath(this.ruta, this.pinturaBorde);
        }

        @Deprecated(message="Deprecated in Java") public int getOpacity() {
            return -3;
        }

        public void setAlpha(int arg2) {
            this.pinturaFondo.setAlpha(arg2);
            this.pinturaBorde.setAlpha(arg2);
            this.invalidateSelf();
        }

        public void setColorFilter(ColorFilter arg2) {
            this.pinturaFondo.setColorFilter(arg2);
            this.pinturaBorde.setColorFilter(arg2);
            this.invalidateSelf();
        }
    }

    public static final int $stable = 0;
    public static final Companion Companion = null;
    public static final String PREFS_NAME = "GoldenMouseVisual";
    private static final List TEMAS_BOTONES;
    private final int blanco;
    private boolean cerrando;
    private final Context context;
    private final int fondo;
    private final int linea;
    private Function0 onAjustesBotonesChange;
    private final Function0 onCerrar;
    private final int oro;
    private final int oroTransparente;
    private final SharedPreferences prefs;
    private final int secundario;
    private View vistaPanel;
    private final WindowManager windowManager;

    static {
        PanelVisual.Companion = new Companion(null);
        PanelVisual.$stable = 8;
        PanelVisual.TEMAS_BOTONES = CollectionsKt.listOf(new String[]{"Dorado", "Azul Neón", "Rojo Fuego", "Verde Matrix", "Morado Cyber", "Original"});
    }

    public PanelVisual(Context arg2, WindowManager arg3, Function0 arg4) {
        Intrinsics.checkNotNullParameter(arg2, "context");
        Intrinsics.checkNotNullParameter(arg3, "windowManager");
        super();
        this.context = arg2;
        this.windowManager = arg3;
        this.onCerrar = arg4;
        this.prefs = arg2.getSharedPreferences("GoldenMouseVisual", 0);
        this.oro = Color.parseColor("#FFD700");
        this.oroTransparente = Color.parseColor("#66FFD700");
        this.blanco = Color.parseColor("#F1F3F6");
        this.secundario = Color.parseColor("#9099A8");
        this.linea = Color.parseColor("#303846");
        this.fondo = Color.parseColor("#F0141822");
    }

    public PanelVisual(Context arg1, WindowManager arg2, Function0 arg3, int arg4, DefaultConstructorMarker arg5) {
        if((arg4 & 4) != 0) {
            arg3 = null;
        }

        this(arg1, arg2, arg3);
    }

    public static final List access$getTEMAS_BOTONES$cp() {
        return PanelVisual.TEMAS_BOTONES;
    }

    private final void agregarBotonAccion(LinearLayout arg8, String arg9, Function0 arg10) {
        LinearLayout v0 = new LinearLayout(this.context);
        v0.setOrientation(0);
        v0.setPadding(this.dp(4), this.dp(16), this.dp(4), this.dp(12));
        TextView v3 = new TextView(this.context);
        v3.setText(((CharSequence)arg9));
        v3.setTextSize(12f);
        v3.setGravity(17);
        v3.setTextColor(Color.parseColor("#000000"));
        v3.setTypeface(null, 1);
        v3.setPadding(0, this.dp(10), 0, this.dp(10));
        GradientDrawable v9 = new GradientDrawable();
        v9.setColor(this.oro);
        v9.setCornerRadius(((float)this.dp(4)));
        v3.setBackground(((Drawable)v9));
        v3.setClickable(true);
        v3.setFocusable(true);
        v3.setOnClickListener(new PanelVisual$$ExternalSyntheticLambda10(arg10));
        v3.setLayoutParams(new LinearLayout$LayoutParams(-1, -2));
        v0.addView(((View)v3));
        arg8.addView(((View)v0));
        this.agregarSeparador(arg8);
    }

    static final void agregarBotonAccion$lambda$51$lambda$50(Function0 arg0, View arg1) {
        arg0.invoke();
    }

    private final void agregarSeccion(LinearLayout arg7, String arg8) {
        LinearLayout v0 = new LinearLayout(this.context);
        v0.setOrientation(0);
        v0.setGravity(16);
        TextView v2 = new TextView(this.context);
        v2.setText(((CharSequence)arg8));
        v2.setTextSize(11f);
        v2.setLetterSpacing(0.075f);
        v2.setIncludeFontPadding(false);
        v2.setTextColor(this.oro);
        v2.setTypeface(null, 1);
        View v8 = new View(this.context);
        v8.setBackgroundColor(this.linea);
        v0.addView(((View)v2), new LinearLayout$LayoutParams(-2, -2));
        LinearLayout$LayoutParams v2_1 = new LinearLayout$LayoutParams(0, this.dp(1), 1f);
        v2_1.setMarginStart(this.dp(12));
        v0.addView(v8, ((ViewGroup$LayoutParams)v2_1));
        LinearLayout$LayoutParams v8_1 = new LinearLayout$LayoutParams(-1, -2);
        v8_1.topMargin = this.dp(17);
        v8_1.bottomMargin = this.dp(7);
        arg7.addView(((View)v0), ((ViewGroup$LayoutParams)v8_1));
    }

    private final void agregarSelector(LinearLayout arg10, String arg11, String arg12, List arg13, boolean arg14, Function1 arg15) {
        int v0_1;
        LinearLayout v7 = new LinearLayout(this.context);
        v7.setOrientation(0);
        v7.setGravity(16);
        v7.setPadding(this.dp(4), this.dp(12), this.dp(4), this.dp(12));
        TextView v8 = new TextView(this.context);
        v8.setText(arg11);
        v8.setTextSize(13f);
        v8.setIncludeFontPadding(false);
        v8.setTextColor(this.blanco);
        v8.setLayoutParams(new LinearLayout$LayoutParams(0, -2, 1f));
        ObjectRef v2 = new ObjectRef();
        v2.element = arg12;
        TextView v3 = new TextView(this.context);
        v3.setText(v2.element + "  ›");
        v3.setTextSize(12f);
        v3.setIncludeFontPadding(false);
        if(arg14) {
            Integer v0 = PanelVisual.Companion.resolverColorTema(v2.element);
            v0_1 = v0 != null ? v0.intValue() : this.blanco;
        }
        else {
            v0_1 = this.oro;
        }

        v3.setTextColor(v0_1);
        v3.setTypeface(null, 1);
        if(!arg13.isEmpty() && arg15 != null) {
            v7.setClickable(true);
            v7.setFocusable(true);
            v7.setOnClickListener(new PanelVisual$$ExternalSyntheticLambda11(arg13, v2, v3, arg14, this, arg15));
        }

        v7.addView(((View)v8));
        v7.addView(((View)v3));
        arg10.addView(((View)v7));
        this.agregarSeparador(arg10);
    }

    static void agregarSelector$default(PanelVisual arg7, LinearLayout arg8, String arg9, String arg10, List arg11, boolean arg12, Function1 arg13, int arg14, Object arg15) {
        if((arg14 & 8) != 0) {
            arg11 = CollectionsKt.emptyList();
        }

        List v4 = arg11;
        if((arg14 & 0x20) != 0) {
            arg13 = null;
        }

        arg7.agregarSelector(arg8, arg9, arg10, v4, false, arg13);
    }

    static final void agregarSelector$lambda$47(List arg1, ObjectRef arg2, TextView arg3, boolean arg4, PanelVisual arg5, Function1 arg6, View arg7) {
        int v7 = arg1.indexOf(arg2.element);
        v7 = v7 >= 0 ? (v7 + 1) % arg1.size() : 0;
        arg2.element = arg1.get(v7);
        arg3.setText(arg2.element + "  ›");
        if(arg4) {
            Integer v1 = PanelVisual.Companion.resolverColorTema(arg2.element);
            int v1_1 = v1 != null ? v1.intValue() : arg5.blanco;
            arg3.setTextColor(v1_1);
        }

        arg6.invoke(arg2.element);
    }

    private final void agregarSeparador(LinearLayout arg5) {
        View v0 = new View(this.context);
        v0.setBackgroundColor(this.linea);
        LinearLayout$LayoutParams v1 = new LinearLayout$LayoutParams(-1, this.dp(1));
        v1.leftMargin = this.dp(4);
        v1.rightMargin = this.dp(4);
        arg5.addView(v0, ((ViewGroup$LayoutParams)v1));
    }

    private final SeekBar agregarSlider(LinearLayout arg9, String arg10, int arg11, int arg12, int arg13, String arg14, Function1 arg15) {
        LinearLayout v0 = new LinearLayout(this.context);
        v0.setOrientation(1);
        v0.setPadding(this.dp(4), this.dp(10), this.dp(4), this.dp(6));
        LinearLayout v3 = new LinearLayout(this.context);
        v3.setOrientation(0);
        v3.setGravity(16);
        TextView v5 = new TextView(this.context);
        v5.setText(((CharSequence)arg10));
        v5.setTextSize(13f);
        v5.setIncludeFontPadding(false);
        v5.setTextColor(this.blanco);
        v5.setLayoutParams(new LinearLayout$LayoutParams(0, -2, 1f));
        TextView v10 = new TextView(this.context);
        v10.setText(arg13 + arg14);
        v10.setTextSize(12f);
        v10.setIncludeFontPadding(false);
        v10.setTextColor(this.oro);
        v10.setTypeface(null, 1);
        SeekBar v1 = new SeekBar(this.context);
        v1.setMax(arg12 - arg11);
        v1.setProgress(RangesKt.coerceIn(arg13, arg11, arg12) - arg11);
        v1.setSplitTrack(false);
        v1.setPadding(0, this.dp(4), 0, 0);
        v1.setProgressTintList(ColorStateList.valueOf(this.oro));
        v1.setProgressBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#424A57")));
        v1.setThumbTintList(ColorStateList.valueOf(Color.parseColor("#D7DAE0")));
        v1.setOnSeekBarChangeListener(new PanelVisual$agregarSlider$slider$1$1(arg11, v10, arg14, arg15));
        v3.addView(((View)v5));
        v3.addView(((View)v10));
        v0.addView(((View)v3));
        v0.addView(v1, new LinearLayout$LayoutParams(-1, -2));
        arg9.addView(((View)v0));
        this.agregarSeparador(arg9);
        return v1;
    }

    private final void agregarSwitch(LinearLayout arg7, String arg8, boolean arg9, Function1 arg10) {
        LinearLayout v0 = new LinearLayout(this.context);
        v0.setOrientation(0);
        v0.setGravity(16);
        v0.setPadding(this.dp(4), this.dp(10), this.dp(4), this.dp(10));
        TextView v2 = new TextView(this.context);
        v2.setText(((CharSequence)arg8));
        v2.setTextSize(13f);
        v2.setIncludeFontPadding(false);
        v2.setTextColor(this.blanco);
        v2.setLayoutParams(new LinearLayout$LayoutParams(0, -2, 1f));
        int[][] v8 = new int[][]{new int[]{0x10100A0}, new int[]{0xFEFEFF60}};
        Switch v3 = new Switch(this.context);
        v3.setChecked(arg9);
        v3.setShowText(false);
        v3.setThumbTintList(new ColorStateList(v8, new int[]{this.oro, Color.parseColor("#9EA4AE")}));
        v3.setTrackTintList(new ColorStateList(v8, new int[]{this.oroTransparente, Color.parseColor("#3A414D")}));
        v3.setOnCheckedChangeListener(new PanelVisual$$ExternalSyntheticLambda12(arg10));
        v0.addView(((View)v2));
        v0.addView(((View)v3));
        arg7.addView(((View)v0));
        this.agregarSeparador(arg7);
    }

    static final void agregarSwitch$lambda$38$lambda$37(Function1 arg1, CompoundButton arg2, boolean arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<unused var>");
        arg1.invoke(Boolean.valueOf(arg3));
    }

    public final void cerrar() {
        this.cerrarPanel(true);
    }

    private final void cerrarPanel(boolean arg5) {
        View v1;
        View v0;
        if(this.cerrando) {
        }
        else {
            v0 = this.vistaPanel;
            if((v0 instanceof FrameLayout)) {
            }
            else {
                v0 = null;
            }

            if(v0 == null) {
                return;
            }

            v1 = ((FrameLayout)v0).getChildAt(0);
            if(v1 != null) {
                goto label_14;
            }
        }

        return;
    label_14:
        this.cerrando = true;
        v1.animate().translationX((((float)v1.getWidth())) + (((float)this.dp(50)))).setDuration(220).setInterpolator(new AccelerateInterpolator()).withEndAction(new PanelVisual$$ExternalSyntheticLambda0(((FrameLayout)v0), this, arg5)).start();
    }

    static final void cerrarPanel$lambda$52(FrameLayout arg1, PanelVisual arg2, boolean arg3) {
        try {
            if(arg1.isAttachedToWindow()) {
                arg2.windowManager.removeView(((View)arg1));
            }

            goto label_4;
        }
        catch(Exception ) {
        label_4:
            arg2.vistaPanel = null;
            arg2.cerrando = false;
            if(arg3) {
                Function0 v1 = arg2.onCerrar;
                if(v1 != null) {
                    v1.invoke();
                }
            }

            return;
        }
    }

    public final void destruir() {
        View v0 = this.vistaPanel;
        View v2 = null;
        if((v0 instanceof FrameLayout)) {
        }
        else {
            v0 = v2;
        }

        if(v0 != null) {
            try {
                View v3 = ((FrameLayout)v0).getChildAt(0);
                if(v3 != null) {
                    ViewPropertyAnimator v3_1 = v3.animate();
                    if(v3_1 != null) {
                        v3_1.cancel();
                    }
                }

            label_13:
                if(v0 != null && (((FrameLayout)v0).isAttachedToWindow())) {
                    this.windowManager.removeView(v0);
                }

                goto label_18;
            }
            catch(Exception ) {
            label_18:
                this.vistaPanel = v2;
                this.cerrando = false;
                return;
            }
        }

        goto label_13;
    }

    private final int dp(int arg1) {
        return ((int)((((float)arg1)) * this.context.getResources().getDisplayMetrics().density));
    }

    public final Function0 getOnAjustesBotonesChange() {
        return this.onAjustesBotonesChange;
    }

    public final void mostrar() {
        PanelVisual v0 = this;
        if(v0.vistaPanel != null) {
            return;
        }

        v0.cerrando = false;
        int v10 = ((int)((((float)v0.context.getResources().getDisplayMetrics().widthPixels)) * 0.43f));
        FrameLayout v11 = new FrameLayout(v0.context);
        v11.setBackgroundColor(0);
        LinearLayout v12 = new LinearLayout(v0.context);
        v12.setOrientation(1);
        v12.setPadding(v0.dp(0x1F), v0.dp(16), v0.dp(18), v0.dp(16));
        v12.setBackground(new FondoPanel(v0.fondo, v0.oro, ((float)v0.dp(22)), ((float)v0.dp(1))));
        v12.setElevation(((float)v0.dp(8)));
        v12.setTranslationX((((float)v10)) + (((float)v0.dp(30))));
        LinearLayout v4 = new LinearLayout(v0.context);
        v4.setOrientation(0);
        v4.setGravity(16);
        View v5 = new View(v0.context);
        v5.setBackgroundColor(v0.oro);
        LinearLayout v6 = new LinearLayout(v0.context);
        v6.setOrientation(1);
        v6.setPadding(v0.dp(10), 0, v0.dp(8), 0);
        v6.setLayoutParams(new LinearLayout$LayoutParams(0, -2, 1f));
        TextView v2 = new TextView(v0.context);
        v2.setText("AJUSTES VISUALES");
        v2.setTextSize(17f);
        v2.setLetterSpacing(0.035f);
        v2.setIncludeFontPadding(false);
        v2.setTextColor(v0.blanco);
        v2.setTypeface(null, 1);
        TextView v7 = new TextView(v0.context);
        v7.setText("Visual y controles");
        v7.setTextSize(10f);
        v7.setLetterSpacing(0.02f);
        v7.setIncludeFontPadding(false);
        v7.setTextColor(v0.secundario);
        v7.setPadding(0, v0.dp(3), 0, 0);
        v6.addView(((View)v2));
        v6.addView(((View)v7));
        v2 = new TextView(v0.context);
        v2.setText("×");
        v2.setTextSize(27f);
        v2.setGravity(17);
        v2.setIncludeFontPadding(false);
        v2.setTextColor(v0.blanco);
        v2.setPadding(v0.dp(9), v0.dp(4), v0.dp(9), v0.dp(4));
        v2.setOnClickListener(new PanelVisual$$ExternalSyntheticLambda13(v0));
        v4.addView(v5, new LinearLayout$LayoutParams(v0.dp(3), v0.dp(33)));
        v4.addView(((View)v6));
        v4.addView(((View)v2), new LinearLayout$LayoutParams(v0.dp(44), v0.dp(44)));
        v12.addView(((View)v4));
        View v2_1 = new View(v0.context);
        v2_1.setBackgroundColor(v0.oro);
        v2_1.setAlpha(0.55f);
        int v13 = -1;
        LinearLayout$LayoutParams v3 = new LinearLayout$LayoutParams(v13, v0.dp(1));
        v3.topMargin = v0.dp(12);
        v3.bottomMargin = v0.dp(4);
        v12.addView(v2_1, ((ViewGroup$LayoutParams)v3));
        ScrollView v14 = new ScrollView(v0.context);
        v14.setFillViewport(true);
        v14.setVerticalScrollBarEnabled(false);
        v14.setOverScrollMode(2);
        LinearLayout v2_2 = new LinearLayout(v0.context);
        v2_2.setOrientation(1);
        v2_2.setPadding(0, 0, 0, v0.dp(16));
        v0.agregarSeccion(v2_2, "AJUSTES DE LOS BOTONES");
        v0.agregarSwitch(v2_2, "Mostrar controles en pantalla", v0.prefs.getBoolean("mostrar_controles", true), new PanelVisual$$ExternalSyntheticLambda1(v0));
        int v8 = 100;
        LinearLayout v1 = v2_2;
        v0.agregarSlider(v1, "Transparencia de los botones", 0, 100, v0.prefs.getInt("alpha_botones", v8), "%", new PanelVisual$$ExternalSyntheticLambda2(v0));
        String v4_1 = "Dorado";
        String v2_3 = v0.prefs.getString("tema_botones", v4_1);
        String v3_1 = v2_3 == null ? v4_1 : v2_3;
        v0.agregarSelector(v1, "Color / Tema de los botones", v3_1, PanelVisual.TEMAS_BOTONES, true, new PanelVisual$$ExternalSyntheticLambda3(v0));
        v0.agregarSeccion(v1, "TAMAÑO DE BOTONES");
        SeekBar v15 = v0.agregarSlider(v1, "Tamaño botón Tap (Tocar)", 50, 150, v0.prefs.getInt("tamano_boton_tap", v8), "%", new PanelVisual$$ExternalSyntheticLambda4(v0));
        SeekBar v16 = v0.agregarSlider(v1, "Tamaño Joystick (No se Recomienda Modificar)", 50, 150, v0.prefs.getInt("tamano_boton_joystick", v8), "%", new PanelVisual$$ExternalSyntheticLambda5(v0));
        SeekBar v17 = v0.agregarSlider(v1, "Tamaño botón Vista (No se Recomienda Modificar)", 50, 150, v0.prefs.getInt("tamano_boton_vista", v8), "%", new PanelVisual$$ExternalSyntheticLambda6(v0));
        SeekBar v5_1 = v0.agregarSlider(v1, "Tamaño botón Disparo (No se Recomienda Modificar)", 50, 150, v0.prefs.getInt("tamano_boton_disparo", v8), "%", new PanelVisual$$ExternalSyntheticLambda7(v0));
        v0 = this;
        v0.agregarBotonAccion(v1, "RESTABLECER TAMAÑOS", new PanelVisual$$ExternalSyntheticLambda8(this, v15, v16, v17, v5_1));
        v0.agregarSeccion(v1, "ICONO FLOTANTE");
        v1 = v1;
        v0.agregarSlider(v1, "Transparencia del logo", 0, 100, v0.prefs.getInt("alpha_logo", v8), "%", new PanelVisual$$ExternalSyntheticLambda9(v0));
        v0.agregarSlider(v1, "Tamaño del logo", 50, 150, v0.prefs.getInt("tamano_logo", v8), "%", new PanelVisual$$ExternalSyntheticLambda14(v0));
        v0.agregarSeccion(v1, "ATAJOS Y AVANZADOS");
        v4_1 = "F9";
        v2_3 = v0.prefs.getString("tecla_ocultar", v4_1);
        v3_1 = v2_3 == null ? v4_1 : v2_3;
        PanelVisual.agregarSelector$default(v0, v1, "Tecla rápida para ocultar mapeo", v3_1, null, false, null, 56, null);
        v0.agregarSwitch(v1, "Mostrar toques en pantalla", v0.prefs.getBoolean("mostrar_toques", false), new PanelVisual$$ExternalSyntheticLambda15(v0));
        v14.addView(v1);
        v12.addView(((View)v14), new LinearLayout$LayoutParams(v13, 0, 1f));
        FrameLayout$LayoutParams v2_4 = new FrameLayout$LayoutParams(v10, v13);
        v2_4.gravity = 0x800005;
        v2_4.topMargin = v0.dp(7);
        v2_4.bottomMargin = v0.dp(7);
        v2_4.setMarginEnd(0);
        v11.addView(v12, ((ViewGroup$LayoutParams)v2_4));
        v11.setOnClickListener(new PanelVisual$$ExternalSyntheticLambda16(v0));
        v12.setOnClickListener(new PanelVisual$$ExternalSyntheticLambda17());
        v0.windowManager.addView(((View)v11), new WindowManager$LayoutParams(-1, -1, 0x7F6, 0x108, -3));
        v0.vistaPanel = ((View)v11);
        v12.post(new PanelVisual$$ExternalSyntheticLambda18(v12));
    }

    static final Unit mostrar$lambda$13(PanelVisual arg2, boolean arg3) {
        arg2.prefs.edit().putBoolean("mostrar_controles", arg3).apply();
        Function0 v2 = arg2.onAjustesBotonesChange;
        if(v2 != null) {
            v2.invoke();
        }

        return Unit.INSTANCE;
    }

    static final Unit mostrar$lambda$14(PanelVisual arg2, int arg3) {
        arg2.prefs.edit().putInt("alpha_botones", arg3).apply();
        Function0 v2 = arg2.onAjustesBotonesChange;
        if(v2 != null) {
            v2.invoke();
        }

        return Unit.INSTANCE;
    }

    static final Unit mostrar$lambda$15(PanelVisual arg2, String arg3) {
        Intrinsics.checkNotNullParameter(arg3, "nuevoTema");
        arg2.prefs.edit().putString("tema_botones", arg3).apply();
        Function0 v2 = arg2.onAjustesBotonesChange;
        if(v2 != null) {
            v2.invoke();
        }

        return Unit.INSTANCE;
    }

    static final Unit mostrar$lambda$16(PanelVisual arg2, int arg3) {
        arg2.prefs.edit().putInt("tamano_boton_tap", arg3).apply();
        Function0 v2 = arg2.onAjustesBotonesChange;
        if(v2 != null) {
            v2.invoke();
        }

        return Unit.INSTANCE;
    }

    static final Unit mostrar$lambda$17(PanelVisual arg2, int arg3) {
        arg2.prefs.edit().putInt("tamano_boton_joystick", arg3).apply();
        Function0 v2 = arg2.onAjustesBotonesChange;
        if(v2 != null) {
            v2.invoke();
        }

        return Unit.INSTANCE;
    }

    static final Unit mostrar$lambda$18(PanelVisual arg2, int arg3) {
        arg2.prefs.edit().putInt("tamano_boton_vista", arg3).apply();
        Function0 v2 = arg2.onAjustesBotonesChange;
        if(v2 != null) {
            v2.invoke();
        }

        return Unit.INSTANCE;
    }

    static final Unit mostrar$lambda$19(PanelVisual arg2, int arg3) {
        arg2.prefs.edit().putInt("tamano_boton_disparo", arg3).apply();
        Function0 v2 = arg2.onAjustesBotonesChange;
        if(v2 != null) {
            v2.invoke();
        }

        return Unit.INSTANCE;
    }

    static final Unit mostrar$lambda$20(PanelVisual arg3, SeekBar arg4, SeekBar arg5, SeekBar arg6, SeekBar arg7) {
        arg3.prefs.edit().putInt("tamano_boton_tap", 100).putInt("tamano_boton_joystick", 100).putInt("tamano_boton_vista", 100).putInt("tamano_boton_disparo", 100).apply();
        arg4.setProgress(50);
        arg5.setProgress(50);
        arg6.setProgress(50);
        arg7.setProgress(50);
        Function0 v3 = arg3.onAjustesBotonesChange;
        if(v3 != null) {
            v3.invoke();
        }

        return Unit.INSTANCE;
    }

    static final Unit mostrar$lambda$21(PanelVisual arg1, int arg2) {
        arg1.prefs.edit().putInt("alpha_logo", arg2).apply();
        return Unit.INSTANCE;
    }

    static final Unit mostrar$lambda$22(PanelVisual arg1, int arg2) {
        arg1.prefs.edit().putInt("tamano_logo", arg2).apply();
        return Unit.INSTANCE;
    }

    static final Unit mostrar$lambda$23(PanelVisual arg1, boolean arg2) {
        arg1.prefs.edit().putBoolean("mostrar_toques", arg2).apply();
        return Unit.INSTANCE;
    }

    static final void mostrar$lambda$25(PanelVisual arg0, View arg1) {
        arg0.cerrar();
    }

    static final void mostrar$lambda$26(View arg0) {
    }

    static final void mostrar$lambda$27(LinearLayout arg2) {
        arg2.animate().translationX(0f).setDuration(270).setInterpolator(new DecelerateInterpolator()).start();
    }

    static final void mostrar$lambda$8$lambda$7(PanelVisual arg0, View arg1) {
        arg0.cerrar();
    }

    public final void setOnAjustesBotonesChange(Function0 arg1) {
        this.onAjustesBotonesChange = arg1;
    }
}

