package com.TryJeanPc.goldenmouse.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.text.method.DigitsKeyListener;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.widget.EditText;
import android.widget.FrameLayout$LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout$LayoutParams;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup$LayoutParams;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import com.TryJeanPc.goldenmouse.R$color;
import com.TryJeanPc.goldenmouse.R$drawable;
import com.TryJeanPc.goldenmouse.R$id;

public final class RecoilPanelFactory {
    private static final int BORDER = 0xFF343840;
    private static final int GOLD = -11750;
    private static final int MUTED = -6906713;
    private static final int TEXT = 0xFFF5F5F6;
    private final Context context;
    private final float density;

    private RecoilPanelFactory(Context arg1) {
        super();
        this.context = arg1;
        this.density = arg1.getResources().getDisplayMetrics().density;
    }

    private RippleDrawable actionBackground() {
        return new RippleDrawable(ColorStateList.valueOf(0x28FFD21A), this.surface(0xFF191C23), null);
    }

    private void add(LinearLayout arg4, View arg5) {
        LinearLayout$LayoutParams v0 = new LinearLayout$LayoutParams(-1, -2);
        v0.topMargin = this.dp(6);
        arg4.addView(arg5, ((ViewGroup$LayoutParams)v0));
    }

    private View build() {
        FrameLayout v8 = new FrameLayout(this.context);
        v8.setLayoutParams(new FrameLayout$LayoutParams(-1, -1));
        v8.setClipChildren(false);
        v8.setClipToPadding(false);
        LinearLayout v11 = this.column();
        v11.setId(id.panelContainer);
        v11.setClickable(true);
        v11.setBackgroundResource(drawable.bg_gamer_panel);
        FrameLayout$LayoutParams v1 = new FrameLayout$LayoutParams(this.dp(300), -1, 0x800005);
        v1.topMargin = this.dp(8);
        v1.bottomMargin = this.dp(8);
        v8.addView(((View)v11), ((ViewGroup$LayoutParams)v1));
        FrameLayout v1_1 = new FrameLayout(this.context);
        TextView v2 = this.text("CONTROL DE RETROCESO", 14, -11750);
        v2.setTypeface(null, 1);
        v2.setGravity(16);
        FrameLayout$LayoutParams v4 = new FrameLayout$LayoutParams(-1, this.dp(34));
        v4.setMarginStart(this.dp(18));
        v4.setMarginEnd(this.dp(54));
        v4.topMargin = this.dp(17);
        v1_1.addView(((View)v2), ((ViewGroup$LayoutParams)v4));
        v2 = this.text("×", 22, -11750);
        v2.setId(id.btnCloseRetroceso);
        v2.setIncludeFontPadding(true);
        v2.setTypeface(null, 1);
        v2.setGravity(17);
        v2.setBackgroundResource(drawable.exit);
        v2.setContentDescription("Cerrar control de retroceso");
        v2.setClickable(true);
        v2.setFocusable(true);
        FrameLayout$LayoutParams v3 = new FrameLayout$LayoutParams(this.dp(34), this.dp(34), 0x800035);
        v3.topMargin = this.dp(17);
        v3.setMarginEnd(this.dp(10));
        v1_1.addView(((View)v2), ((ViewGroup$LayoutParams)v3));
        v11.addView(((View)v1_1), new LinearLayout$LayoutParams(-1, this.dp(52)));
        this.rule(v11);
        ScrollView v1_2 = new ScrollView(this.context);
        v1_2.setId(id.scrollViewRetroceso);
        v1_2.setFillViewport(true);
        v1_2.setVerticalScrollBarEnabled(false);
        v1_2.setOverScrollMode(2);
        LinearLayout v2_1 = this.column();
        v2_1.setPadding(this.dp(14), this.dp(4), this.dp(14), this.dp(14));
        v1_2.addView(((View)v2_1), new FrameLayout$LayoutParams(-1, -2));
        v11.addView(((View)v1_2), new LinearLayout$LayoutParams(-1, 0, 1f));
        this.toggle(v2_1, "Habilitar", id.switchHabilitarRetroceso, true);
        this.toggle(v2_1, "Mostrar panel", id.switchMostrarPanelRetroceso, false);
        this.toggle(v2_1, "Panel fijo", id.switchPanelFijoRetroceso, false);
        LinearLayout v1_3 = v2_1;
        this.slider(v1_3, "Transparencia del panel", null, id.seekTransparenciaPanelRetroceso, id.txtTransparenciaPanelRetroceso, 10, 100);
        this.slider(v1_3, "Porcentaje global", "Ajusta todos los valores", id.seekPorcentajeGlobalRetroceso, id.txtPorcentajeGlobalRetroceso, 40, 200);
        v2_1 = this.card();
        v2_1.addView(this.text("Modo de duración", 12, 0xFFF5F5F6));
        RadioGroup v3_1 = new RadioGroup(this.context);
        v3_1.setId(id.radioGroupDuracionRetroceso);
        v3_1.setOrientation(1);
        this.radio(v3_1, "Mientras mantengo clic izquierdo", id.radioDuracionMantenerRetroceso);
        this.radio(v3_1, "Duración máxima en segundos", id.radioDuracionMaximaRetroceso);
        v3_1.check(id.radioDuracionMantenerRetroceso);
        v2_1.addView(((View)v3_1), new LinearLayout$LayoutParams(-1, -2));
        LinearLayout v3_2 = this.row();
        v3_2.setId(id.groupDuracionMaxRetroceso);
        v3_2.setVisibility(8);
        v3_2.addView(this.text("Tiempo máximo (s)", 11, -6906713), new LinearLayout$LayoutParams(0, -2, 1f));
        EditText v6 = new EditText(this.context);
        v6.setId(id.editDuracionMaxRetroceso);
        v6.setKeyListener(DigitsKeyListener.getInstance("0123456789."));
        v6.setRawInputType(0x2002);
        v6.setSingleLine(true);
        v6.setSelectAllOnFocus(true);
        v6.setGravity(17);
        v6.setHint("2.5");
        v6.setTextSize(12f);
        v6.setTextColor(0xFFF5F5F6);
        v6.setHintTextColor(0xFF777777);
        v6.setPadding(this.dp(5), this.dp(5), this.dp(5), this.dp(5));
        v6.setBackground(this.surface(0xFF111318));
        v3_2.addView(((View)v6), new LinearLayout$LayoutParams(this.dp(86), this.dp(40)));
        v2_1.addView(((View)v3_2), new LinearLayout$LayoutParams(-1, this.dp(46)));
        this.add(v1_3, ((View)v2_1));
        v2_1 = this.row();
        v2_1.setId(id.btnEditarCurvasRetroceso);
        v2_1.setMinimumHeight(this.dp(56));
        v2_1.setPadding(this.dp(12), this.dp(8), this.dp(12), this.dp(8));
        v2_1.setBackground(this.actionBackground());
        v2_1.setClickable(true);
        v2_1.setFocusable(true);
        v3_2 = this.column();
        v3_2.addView(this.text("Editar curvas X/Y", 12, 0xFFF5F5F6));
        TextView v4_1 = this.text("Movimiento vertical y horizontal", 10, -6906713);
        v4_1.setPadding(0, this.dp(4), 0, 0);
        v3_2.addView(((View)v4_1));
        v2_1.addView(((View)v3_2), new LinearLayout$LayoutParams(0, -2, 1f));
        v2_1.addView(this.text("›", 20, -11750));
        this.add(v1_3, ((View)v2_1));
        this.rule(v11);
        v1_3 = this.row();
        v1_3.setPadding(this.dp(14), 0, this.dp(14), 0);
        this.button(v1_3, "RESTABLECER", id.btnRestablecerRetroceso, false);
        this.button(v1_3, "GUARDAR", id.btnGuardarRetroceso, true);
        v11.addView(((View)v1_3), new LinearLayout$LayoutParams(-1, this.dp(59)));
        this.decoration(v8, drawable.bg_top_point, 0x800033);
        this.decoration(v8, drawable.bg_bottom_point, 0x800053);
        return ((View)v8);
    }

    private void button(LinearLayout arg4, String arg5, int arg6, boolean arg7) {
        int v0 = arg7 ? 11 : 10;
        int v1 = -11750;
        int v2 = arg7 ? 0xFF181208 : v1;
        TextView v5 = this.text(arg5, v0, v2);
        v5.setId(arg6);
        v5.setGravity(17);
        Typeface v6 = null;
        v5.setTypeface(v6, 1);
        v5.setClickable(true);
        v5.setFocusable(true);
        RippleDrawable v0_1 = arg7 ? new RippleDrawable(ColorStateList.valueOf(0x28000000), this.surface(v1), ((Drawable)v6)) : this.actionBackground();
        v5.setBackground(((Drawable)v0_1));
        LinearLayout$LayoutParams v6_1 = new LinearLayout$LayoutParams(0, this.dp(40), 1f);
        int v3 = this.dp(6);
        if(arg7) {
            v6_1.setMarginStart(v3);
        }
        else {
            v6_1.setMarginEnd(v3);
        }

        arg4.addView(((View)v5), ((ViewGroup$LayoutParams)v6_1));
    }

    private LinearLayout card() {
        LinearLayout v0 = this.column();
        v0.setPadding(this.dp(12), this.dp(9), this.dp(12), this.dp(5));
        v0.setBackground(this.surface(0xFF191C22));
        return v0;
    }

    private LinearLayout column() {
        LinearLayout v0 = new LinearLayout(this.context);
        v0.setOrientation(1);
        return v0;
    }

    public static View create(Context arg1) {
        return new RecoilPanelFactory(arg1).build();
    }

    private void decoration(FrameLayout arg4, int arg5, int arg6) {
        View v0 = new View(this.context);
        v0.setBackgroundResource(arg5);
        arg4.addView(v0, new FrameLayout$LayoutParams(this.dp(92), this.dp(12), arg6));
    }

    private int dp(int arg1) {
        return Math.round((((float)arg1)) * this.density);
    }

    private void radio(RadioGroup arg3, String arg4, int arg5) {
        RadioButton v0 = new RadioButton(this.context);
        v0.setId(arg5);
        v0.setText(((CharSequence)arg4));
        v0.setTextSize(10f);
        v0.setTextColor(0xFFF5F5F6);
        v0.setMinHeight(this.dp(36));
        v0.setButtonTintList(ColorStateList.valueOf(-11750));
        arg3.addView(((View)v0), new RadioGroup$LayoutParams(-1, -2));
    }

    private LinearLayout row() {
        LinearLayout v0 = new LinearLayout(this.context);
        v0.setGravity(16);
        return v0;
    }

    private void rule(LinearLayout arg4) {
        View v0 = new View(this.context);
        v0.setBackgroundColor(0xFF343840);
        arg4.addView(v0, new LinearLayout$LayoutParams(-1, this.dp(1)));
    }

    private void slider(LinearLayout arg8, String arg9, String arg10, int arg11, int arg12, int arg13, int arg14) {
        TextView v10;
        LinearLayout v0 = this.card();
        LinearLayout v1 = this.row();
        LinearLayout v2 = this.column();
        int v4 = 12;
        v2.addView(this.text(arg9, v4, 0xFFF5F5F6));
        if(arg10 != null) {
            v10 = this.text(arg10, 10, -6906713);
            v10.setPadding(0, this.dp(4), 0, 0);
            v2.addView(((View)v10));
        }

        v1.addView(((View)v2), new LinearLayout$LayoutParams(0, -2, 1f));
        v10 = this.text("100%", v4, -11750);
        v10.setId(arg12);
        v1.addView(((View)v10));
        v0.addView(((View)v1), new LinearLayout$LayoutParams(-1, -2));
        SeekBar v10_1 = new SeekBar(this.context);
        v10_1.setId(arg11);
        v10_1.setMin(arg13);
        v10_1.setMax(arg14);
        v10_1.setProgress(100);
        v10_1.setContentDescription(((CharSequence)arg9));
        v10_1.setProgressTintList(ColorStateList.valueOf(-11750));
        v10_1.setProgressBackgroundTintList(ColorStateList.valueOf(0xFF343840));
        v10_1.setThumbTintList(ColorStateList.valueOf(-11750));
        v0.addView(((View)v10_1), new LinearLayout$LayoutParams(-1, this.dp(36)));
        this.add(arg8, ((View)v0));
    }

    private GradientDrawable surface(int arg2) {
        GradientDrawable v0 = new GradientDrawable();
        v0.setColor(arg2);
        v0.setCornerRadius(((float)this.dp(9)));
        v0.setStroke(Math.max(1, this.dp(1)), 0xFF343840);
        return v0;
    }

    private TextView text(String arg2, int arg3, int arg4) {
        TextView v0 = new TextView(this.context);
        v0.setText(((CharSequence)arg2));
        v0.setTextSize(((float)arg3));
        v0.setTextColor(arg4);
        v0.setIncludeFontPadding(false);
        return v0;
    }

    private void toggle(LinearLayout arg7, String arg8, int arg9, boolean arg10) {
        LinearLayout v0 = this.row();
        v0.setPadding(this.dp(12), this.dp(6), this.dp(6), this.dp(6));
        v0.setMinimumHeight(this.dp(0x30));
        v0.setBackground(this.surface(0xFF191C22));
        LinearLayout v2 = this.column();
        v2.addView(this.text(arg8, 12, 0xFFF5F5F6));
        if(arg10) {
            TextView v10 = this.text("DESACTIVADO", 10, -6906713);
            v10.setId(id.txtEstadoRetroceso);
            v10.setPadding(0, this.dp(4), 0, 0);
            v2.addView(((View)v10));
        }

        v0.addView(((View)v2), new LinearLayout$LayoutParams(0, -2, 1f));
        Switch v10_1 = new Switch(this.context);
        v10_1.setId(arg9);
        v10_1.setContentDescription(((CharSequence)arg8));
        v10_1.setScaleX(0.7f);
        v10_1.setScaleY(0.7f);
        v10_1.setThumbTintList(this.context.getColorStateList(color.switch_thumb));
        v10_1.setTrackTintList(this.context.getColorStateList(color.switch_track));
        v0.addView(((View)v10_1), new LinearLayout$LayoutParams(-2, -2));
        this.add(arg7, ((View)v0));
    }
}

