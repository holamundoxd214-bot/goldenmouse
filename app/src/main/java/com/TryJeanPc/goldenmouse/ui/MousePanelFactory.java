package com.TryJeanPc.goldenmouse.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.widget.EditText;
import android.widget.FrameLayout$LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout$LayoutParams;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import com.TryJeanPc.goldenmouse.R$color;
import com.TryJeanPc.goldenmouse.R$drawable;
import com.TryJeanPc.goldenmouse.R$id;

public final class MousePanelFactory {
    private static final int BORDER = 0xFF343840;
    private static final int GOLD = -11750;
    private static final int MUTED = -6906713;
    private static final int[] POLLING_IDS = null;
    private static final int TEXT = 0xFFF5F5F6;
    private final Context context;
    private final float density;

    static {
        MousePanelFactory.POLLING_IDS = new int[]{id.btnPollingNativo, id.btnPolling125, id.btnPolling250, id.btnPolling500, id.btnPolling1000, id.btnPollingPersonalizado};
    }

    private MousePanelFactory(Context arg1) {
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
        FrameLayout v7 = new FrameLayout(this.context);
        v7.setLayoutParams(new FrameLayout$LayoutParams(-1, -1));
        v7.setClickable(true);
        v7.setClipChildren(false);
        v7.setClipToPadding(false);
        LinearLayout v11 = this.column();
        v11.setId(id.panelContainer);
        v11.setClickable(true);
        v11.setBackgroundResource(drawable.bg_gamer_panel);
        FrameLayout$LayoutParams v1 = new FrameLayout$LayoutParams(this.dp(300), -1, 0x800005);
        v1.topMargin = this.dp(8);
        v1.bottomMargin = this.dp(8);
        v7.addView(((View)v11), ((ViewGroup$LayoutParams)v1));
        FrameLayout v1_1 = new FrameLayout(this.context);
        TextView v3 = this.text("MOUSE", 18, -11750);
        v3.setTypeface(null, 1);
        FrameLayout$LayoutParams v12 = new FrameLayout$LayoutParams(-1, this.dp(24));
        v12.topMargin = this.dp(17);
        v12.setMarginStart(this.dp(18));
        v12.setMarginEnd(this.dp(54));
        v1_1.addView(((View)v3), ((ViewGroup$LayoutParams)v12));
        v3 = this.text("CONECTADO", 10, -6906713);
        v3.setId(id.txtEstadoMouse);
        v12 = new FrameLayout$LayoutParams(-1, this.dp(14));
        v12.topMargin = this.dp(43);
        v12.setMarginStart(this.dp(18));
        v12.setMarginEnd(this.dp(54));
        v1_1.addView(((View)v3), ((ViewGroup$LayoutParams)v12));
        v3 = this.text("×", 22, -11750);
        v3.setId(id.btnCloseMouse);
        v3.setIncludeFontPadding(true);
        v3.setTypeface(null, 1);
        v3.setGravity(17);
        v3.setBackgroundResource(drawable.exit);
        v3.setContentDescription("Cerrar mouse");
        FrameLayout$LayoutParams v4 = new FrameLayout$LayoutParams(this.dp(34), this.dp(34), 0x800035);
        v4.topMargin = this.dp(17);
        v4.setMarginEnd(this.dp(10));
        v1_1.addView(((View)v3), ((ViewGroup$LayoutParams)v4));
        v11.addView(((View)v1_1), new LinearLayout$LayoutParams(-1, this.dp(0x40)));
        this.rule(v11);
        ScrollView v1_2 = new ScrollView(this.context);
        v1_2.setId(id.scrollViewMouse);
        v1_2.setFillViewport(true);
        v1_2.setVerticalScrollBarEnabled(false);
        v1_2.setOverScrollMode(2);
        LinearLayout v3_1 = this.column();
        v3_1.setPadding(this.dp(14), this.dp(4), this.dp(14), this.dp(14));
        v1_2.addView(((View)v3_1), new FrameLayout$LayoutParams(-1, -2));
        v11.addView(((View)v1_2), new LinearLayout$LayoutParams(-1, 0, 1f));
        LinearLayout v1_3 = this.row();
        v1_3.setId(id.btnImagenPuntero);
        v1_3.setMinimumHeight(this.dp(0x30));
        v1_3.setPadding(this.dp(12), this.dp(8), this.dp(12), this.dp(8));
        v1_3.setBackground(this.actionBackground());
        v1_3.setClickable(true);
        v1_3.setFocusable(true);
        v1_3.addView(this.text("Imagen del puntero", 12, 0xFFF5F5F6), new LinearLayout$LayoutParams(0, -2, 1f));
        TextView v2 = this.text("Default  ›", 11, -11750);
        v2.setId(id.txtImagenPuntero);
        v1_3.addView(((View)v2));
        this.add(v3_1, ((View)v1_3));
        this.slider(v3_1, "Tamaño del puntero", id.seekTamanoPuntero, id.txtTamanoPuntero, 200, 100);
        this.slider(v3_1, "Transparencia", id.seekTransparenciaPuntero, id.txtTransparenciaPuntero, 100, 100);
        this.slider(v3_1, "Velocidad del puntero", id.seekVelocidadPuntero, id.txtVelocidadPuntero, 100, 50);
        LinearLayout v2_1 = this.row();
        v2_1.setMinimumHeight(this.dp(0x30));
        v2_1.setPadding(this.dp(12), this.dp(6), this.dp(6), this.dp(6));
        v2_1.setBackground(this.surface(0xFF191C22));
        v2_1.addView(this.text("Aceleración", 12, 0xFFF5F5F6), new LinearLayout$LayoutParams(0, -2, 1f));
        Switch v4_1 = new Switch(this.context);
        v4_1.setId(id.switchAceleracion);
        v4_1.setContentDescription("Aceleración");
        v4_1.setScaleX(0.7f);
        v4_1.setScaleY(0.7f);
        v4_1.setThumbTintList(this.context.getColorStateList(color.switch_thumb));
        v4_1.setTrackTintList(this.context.getColorStateList(color.switch_track));
        v2_1.addView(((View)v4_1), new LinearLayout$LayoutParams(-2, -2));
        this.add(v3_1, ((View)v2_1));
        this.polling(v3_1);
        this.slider(v3_1, "Sensibilidad de rueda", id.seekSensibilidadRueda, id.txtSensibilidadRueda, 100, 50);
        this.rule(v11);
        v1_3 = this.row();
        v1_3.setPadding(this.dp(14), 0, this.dp(14), 0);
        this.button(v1_3, "RESTABLECER", id.btnRestablecerMouse, false);
        this.button(v1_3, "GUARDAR", id.btnGuardarPerfil, true);
        v11.addView(((View)v1_3), new LinearLayout$LayoutParams(-1, this.dp(59)));
        this.decoration(v7, drawable.bg_top_point, 0x800033);
        this.decoration(v7, drawable.bg_bottom_point, 0x800053);
        MousePanelFactory.stylePolling(((View)v7));
        return ((View)v7);
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
        return new MousePanelFactory(arg1).build();
    }

    private void decoration(FrameLayout arg4, int arg5, int arg6) {
        View v0 = new View(this.context);
        v0.setBackgroundResource(arg5);
        arg4.addView(v0, new FrameLayout$LayoutParams(this.dp(92), this.dp(12), arg6));
    }

    private int dp(int arg1) {
        return Math.round((((float)arg1)) * this.density);
    }

    private void polling(LinearLayout arg18) {
        int v3;
        int v14;
        float v13;
        MousePanelFactory v0 = this;
        LinearLayout v1 = v0.card();
        v1.setId(id.groupPollingRateOpciones);
        int v4 = 0xFFF5F5F6;
        v1.addView(v0.text("Frecuencia Hz", 12, v4));
        int v2 = 6;
        String[] v5 = new String[v2];
        v5[0] = "Nativo";
        v5[1] = "125 Hz";
        int v9 = 2;
        v5[v9] = "250 Hz";
        v5[3] = "500 Hz";
        v5[4] = "1000 Hz";
        int v10 = 5;
        v5[v10] = "Personalizado";
        int v6 = 0;
        while(true) {
            int v12 = 17;
            v13 = 1f;
            v14 = 10;
            if(v6 >= MousePanelFactory.POLLING_IDS.length) {
                break;
            }

            LinearLayout v11 = v0.row();
            int v15 = v6;
            while(true) {
                v3 = v6 + 3;
                if(v15 >= v3) {
                    break;
                }

                String v3_1 = v5[v15];
                v10 = v15 == v10 ? 9 : v14;
                TextView v3_2 = v0.text(v3_1, v10, v4);
                v3_2.setId(MousePanelFactory.POLLING_IDS[v15]);
                v3_2.setGravity(v12);
                v3_2.setClickable(true);
                v3_2.setFocusable(true);
                LinearLayout$LayoutParams v10_1 = new LinearLayout$LayoutParams(0, v0.dp(42), v13);
                if(v15 > v6) {
                    v10_1.setMarginStart(v0.dp(v2));
                }

                v11.addView(((View)v3_2), ((ViewGroup$LayoutParams)v10_1));
                ++v15;
                v10 = 5;
                v12 = 17;
            }

            v0.add(v1, ((View)v11));
            v6 = v3;
            v10 = 5;
        }

        LinearLayout v3_3 = v0.column();
        v3_3.setId(id.groupPollingPersonalizado);
        v3_3.setVisibility(8);
        TextView v6_1 = v0.text("Frecuencia personalizada", 11, v4);
        v6_1.setLabelFor(id.editPollingPersonalizado);
        v3_3.addView(((View)v6_1));
        LinearLayout v6_2 = v0.row();
        EditText v11_1 = new EditText(v0.context);
        v11_1.setId(id.editPollingPersonalizado);
        v11_1.setInputType(v9);
        v11_1.setSingleLine(true);
        v11_1.setSelectAllOnFocus(true);
        v11_1.setImeOptions(v2);
        v11_1.setHint("100–1000");
        v11_1.setText("400");
        v11_1.setTextSize(12f);
        v11_1.setTextColor(v4);
        v11_1.setHintTextColor(0xFFA0A0A0);
        v11_1.setPadding(v0.dp(v14), v0.dp(v14), v0.dp(v14), v0.dp(v14));
        v11_1.setMinHeight(v0.dp(0x30));
        v11_1.setBackground(v0.surface(0xFF111318));
        v6_2.addView(((View)v11_1), new LinearLayout$LayoutParams(0, -2, v13));
        TextView v4_1 = v0.text("Hz", 11, v4);
        v4_1.setPadding(v0.dp(8), v0.dp(8), v0.dp(8), v0.dp(8));
        v6_2.addView(((View)v4_1));
        v4_1 = v0.text("Aplicar", 11, -11750);
        v4_1.setId(id.btnAplicarPollingPersonalizado);
        v4_1.setGravity(17);
        v4_1.setPadding(v0.dp(12), 0, v0.dp(12), 0);
        v4_1.setBackground(v0.actionBackground());
        v4_1.setClickable(true);
        v4_1.setFocusable(true);
        v6_2.addView(((View)v4_1), new LinearLayout$LayoutParams(-2, v0.dp(0x30)));
        v0.add(v3_3, ((View)v6_2));
        v0.add(v3_3, v0.text("Pulsa Aplicar para confirmar el valor.", v14, -6906713));
        v0.add(v1, ((View)v3_3));
        TextView v2_1 = v0.text("Entrega configurada: Nativo", 11, -11750);
        v2_1.setId(id.txtPollingAplicado);
        v2_1.setAccessibilityLiveRegion(1);
        v0.add(v1, ((View)v2_1));
        v0.add(v1, v0.text("Regula el movimiento entregado; no cambia la frecuencia física del mouse.", v14, -6906713));
        v0.add(arg18, ((View)v1));
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

    private void slider(LinearLayout arg9, String arg10, int arg11, int arg12, int arg13, int arg14) {
        LinearLayout v0 = this.card();
        LinearLayout v1 = this.row();
        v1.addView(this.text(arg10, 12, 0xFFF5F5F6), new LinearLayout$LayoutParams(0, -2, 1f));
        TextView v2 = this.text(arg14 + "%", 12, -11750);
        v2.setId(arg12);
        v1.addView(((View)v2));
        v0.addView(((View)v1), new LinearLayout$LayoutParams(-1, -2));
        SeekBar v12 = new SeekBar(this.context);
        v12.setId(arg11);
        v12.setMax(arg13);
        v12.setProgress(arg14);
        v12.setContentDescription(((CharSequence)arg10));
        v12.setSplitTrack(false);
        v12.setPadding(this.dp(5), 0, this.dp(5), 0);
        v12.setProgressTintList(ColorStateList.valueOf(-11750));
        v12.setProgressBackgroundTintList(ColorStateList.valueOf(0xFF343840));
        GradientDrawable v10 = new GradientDrawable();
        v10.setShape(1);
        v10.setColor(-11750);
        v10.setSize(this.dp(13), this.dp(13));
        v12.setThumb(((Drawable)v10));
        v12.setThumbOffset(this.dp(6));
        v0.addView(((View)v12), new LinearLayout$LayoutParams(-1, this.dp(36)));
        this.add(arg9, ((View)v0));
    }

    public static void stylePolling(View arg10) {
        MousePanelFactory v0 = new MousePanelFactory(arg10.getContext());
        int[] v1 = MousePanelFactory.POLLING_IDS;
        int v2 = v1.length;
        int v4;
        for(v4 = 0; v4 < v2; ++v4) {
            int v5 = v1[v4];
            StateListDrawable v6 = new StateListDrawable();
            v6.addState(new int[]{0x10100A1}, v0.surface(-11750));
            v6.addState(new int[0], v0.surface(0xFF191C22));
            View v5_1 = arg10.findViewById(v5);
            ((TextView)v5_1).setBackground(new RippleDrawable(ColorStateList.valueOf(0x28FFD21A), ((Drawable)v6), null));
            ((TextView)v5_1).setTextColor(v0.context.getColorStateList(color.mouse_polling_text));
        }
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
}

