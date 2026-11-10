package com.TryJeanPc.goldenmouse.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.text.TextUtils$TruncateAt;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.widget.FrameLayout$LayoutParams;
import android.widget.LinearLayout$LayoutParams;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Space;
import android.widget.TextView;
import com.TryJeanPc.goldenmouse.R$drawable;
import com.TryJeanPc.goldenmouse.R$id;

public final class GoldenStretchPanelFactory {
    private static final int BORDER = 0xFF343840;
    private static final int GOLD = -11750;
    private static final int MUTED = -6906713;
    private static final int[] PRESETS = null;
    private static final int TEXT = 0xFFF5F5F6;
    private final Context context;
    private final float density;

    static {
        GoldenStretchPanelFactory.PRESETS = new int[]{id.btnStretch105, id.btnStretch110, id.btnStretch111, id.btnStretch115};
    }

    private GoldenStretchPanelFactory(Context arg1) {
        super();
        this.context = arg1;
        this.density = arg1.getResources().getDisplayMetrics().density;
    }

    private void add(LinearLayout arg4, View arg5, int arg6) {
        LinearLayout$LayoutParams v0 = new LinearLayout$LayoutParams(-1, -2);
        v0.topMargin = this.dp(arg6);
        arg4.addView(arg5, ((ViewGroup$LayoutParams)v0));
    }

    private View build() {
        GoldenStretchPanelFactory v0 = this;
        LinearLayout v1 = v0.row();
        v1.setGravity(16);
        v1.setLayoutParams(new LinearLayout$LayoutParams(-1, -1));
        float v8 = 1f;
        v1.addView(new Space(v0.context), new LinearLayout$LayoutParams(0, v0.dp(1), v8));
        LinearLayout v2 = v0.column();
        v2.setId(id.panelGoldenStretch);
        v2.setBackgroundResource(drawable.bg_gamer_panel);
        LinearLayout$LayoutParams v4 = new LinearLayout$LayoutParams(0, -1, 2f);
        v4.topMargin = v0.dp(8);
        v4.bottomMargin = v0.dp(8);
        v1.addView(((View)v2), ((ViewGroup$LayoutParams)v4));
        v1.addView(new Space(v0.context), new LinearLayout$LayoutParams(0, v0.dp(1), v8));
        LinearLayout v4_1 = v0.row();
        v4_1.setPadding(v0.dp(14), 0, v0.dp(9), 0);
        TextView v10 = v0.text("GOLDEN STRETCH", 17, -11750);
        v10.setTypeface(null, 1);
        v10.setSingleLine(true);
        v10.setEllipsize(TextUtils$TruncateAt.END);
        v4_1.addView(((View)v10), new LinearLayout$LayoutParams(0, -2, v8));
        v10 = v0.text("×", 20, 0xFFB0B0B0);
        v10.setId(id.btnCerrarGoldenStretch);
        v10.setIncludeFontPadding(true);
        v10.setGravity(17);
        v10.setContentDescription("Cerrar Golden Stretch");
        v10.setClickable(true);
        v10.setFocusable(true);
        v4_1.addView(((View)v10), new LinearLayout$LayoutParams(v0.dp(36), v0.dp(36)));
        v2.addView(((View)v4_1), new LinearLayout$LayoutParams(-1, v0.dp(56)));
        v0.rule(v2);
        ScrollView v4_2 = new ScrollView(v0.context);
        v4_2.setId(id.scrollGoldenStretch);
        v4_2.setFillViewport(false);
        v4_2.setVerticalScrollBarEnabled(false);
        v4_2.setOverScrollMode(2);
        LinearLayout v13 = v0.column();
        int v17 = 1;
        v13.setPadding(v0.dp(12), v0.dp(8), v0.dp(12), v0.dp(14));
        v4_2.addView(((View)v13), new FrameLayout$LayoutParams(-1, -2));
        v2.addView(((View)v4_2), new LinearLayout$LayoutParams(-1, 0, v8));
        v4_1 = v0.card();
        int v6 = 11;
        v4_1.addView(v0.text("Resolución actual", v6, -6906713));
        TextView v5 = v0.text("Lectura del dispositivo", 12, 0xFFF5F5F6);
        v5.setId(id.txtResolucionGoldenStretch);
        v0.add(v4_1, ((View)v5), 4);
        v0.add(v4_1, v0.text("Estado de la pantalla", v6, -6906713), 10);
        v5 = v0.text("Normal (ejemplo)", v6, 0xFFF5F5F6);
        v5.setId(id.txtEstadoGoldenStretch);
        v5.setLineSpacing(((float)v0.dp(2)), v8);
        v0.add(v4_1, ((View)v5), 4);
        v0.add(v13, ((View)v4_1), 0);
        v4_1 = v0.card();
        v4_1.addView(v0.text("Intensidad de estiramiento", 12, 0xFFF5F5F6));
        LinearLayout v5_1 = v0.row();
        String[] v3 = new String[4];
        v3[0] = "1.05×";
        String v9 = "1.10×";
        v3[1] = v9;
        v3[2] = "1.11×";
        v3[3] = "1.15×";
        int v10_1 = 0;
        while(true) {
            int[] v15 = GoldenStretchPanelFactory.PRESETS;
            if(v10_1 >= v15.length) {
                break;
            }

            String v14 = v3[v10_1];
            int v11 = v17;
            int v12 = v10_1 == v11 ? 0xFF161109 : 0xFFF5F5F6;
            TextView v12_1 = v0.text(v14, v6, v12);
            v12_1.setId(v15[v10_1]);
            v12_1.setGravity(17);
            if(v10_1 == v11) {
                v12_1.setTypeface(null, v11);
            }

            v12_1.setClickable(((boolean)v11));
            v12_1.setFocusable(((boolean)v11));
            ColorStateList v14_1 = ColorStateList.valueOf(0x28FFD21A);
            v11 = v10_1 == v11 ? -11750 : 0xFF191C22;
            v12_1.setBackground(new RippleDrawable(v14_1, v0.surface(v11), null));
            LinearLayout$LayoutParams v6_1 = new LinearLayout$LayoutParams(0, v0.dp(40), v8);
            if(v10_1 > 0) {
                v6_1.setMarginStart(v0.dp(6));
            }

            v5_1.addView(((View)v12_1), ((ViewGroup$LayoutParams)v6_1));
            ++v10_1;
            v6 = 11;
            v17 = 1;
        }

        v0.add(v4_1, ((View)v5_1), 8);
        LinearLayout v3_1 = v0.row();
        v3_1.addView(v0.text("Ajuste personalizado", 11, -6906713), new LinearLayout$LayoutParams(0, -2, v8));
        v5 = v0.text(v9, 14, -11750);
        v5.setId(id.txtValorGoldenStretch);
        v5.setTypeface(null, 1);
        v3_1.addView(((View)v5));
        v0.add(v4_1, ((View)v3_1), 12);
        SeekBar v3_2 = new SeekBar(v0.context);
        v3_2.setId(id.seekGoldenStretch);
        v3_2.setMin(1);
        v3_2.setMax(99);
        v3_2.setProgress(10);
        v3_2.setKeyProgressIncrement(1);
        v3_2.setContentDescription("Ajuste personalizado de estiramiento");
        v3_2.setSplitTrack(false);
        v3_2.setPadding(v0.dp(5), 0, v0.dp(5), 0);
        v3_2.setProgressTintList(ColorStateList.valueOf(-11750));
        v3_2.setProgressBackgroundTintList(ColorStateList.valueOf(0xFF343840));
        GradientDrawable v5_2 = new GradientDrawable();
        v5_2.setShape(1);
        v5_2.setColor(-11750);
        v5_2.setSize(v0.dp(13), v0.dp(13));
        v3_2.setThumb(((Drawable)v5_2));
        v3_2.setThumbOffset(v0.dp(6));
        v4_1.addView(((View)v3_2), new LinearLayout$LayoutParams(-1, v0.dp(40)));
        v3_1 = v0.row();
        v3_1.addView(v0.text("1.01×", 9, -6906713), new LinearLayout$LayoutParams(0, -2, v8));
        v3_1.addView(v0.text("1.99×", 9, -6906713));
        v4_1.addView(((View)v3_1), new LinearLayout$LayoutParams(-1, -2));
        v0.add(v13, ((View)v4_1), 8);
        v0.rule(v2);
        v3_1 = v0.row();
        v3_1.setPadding(v0.dp(12), 0, v0.dp(12), 0);
        v0.button(v3_1, "RESTAURAR", id.btnRestaurarGoldenStretch, false);
        v0.button(v3_1, "APLICAR", id.btnAplicarGoldenStretch, true);
        v2.addView(((View)v3_1), new LinearLayout$LayoutParams(-1, v0.dp(62)));
        return ((View)v1);
    }

    private void button(LinearLayout arg4, String arg5, int arg6, boolean arg7) {
        int v0 = -11750;
        int v1 = arg7 ? 0xFF161109 : v0;
        TextView v5 = this.text(arg5, 11, v1);
        v5.setId(arg6);
        v5.setGravity(17);
        Typeface v6 = null;
        v5.setTypeface(v6, 1);
        v5.setClickable(true);
        v5.setFocusable(true);
        ColorStateList v2 = ColorStateList.valueOf(0x28FFD21A);
        if(arg7) {
        }
        else {
            v0 = 0xFF191C22;
        }

        v5.setBackground(new RippleDrawable(v2, this.surface(v0), ((Drawable)v6)));
        LinearLayout$LayoutParams v6_1 = new LinearLayout$LayoutParams(0, this.dp(42), 1f);
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
        v0.setPadding(this.dp(10), this.dp(10), this.dp(10), this.dp(10));
        v0.setBackground(this.surface(0xFF191C22));
        return v0;
    }

    private LinearLayout column() {
        LinearLayout v0 = new LinearLayout(this.context);
        v0.setOrientation(1);
        return v0;
    }

    public static View create(Context arg1) {
        return new GoldenStretchPanelFactory(arg1).build();
    }

    private int dp(int arg1) {
        return Math.round((((float)arg1)) * this.density);
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

    public static void stylePresets(View arg9) {
        GoldenStretchPanelFactory v0 = new GoldenStretchPanelFactory(arg9.getContext());
        int[] v1 = GoldenStretchPanelFactory.PRESETS;
        int v2 = v1.length;
        int v3;
        for(v3 = 0; v3 < v2; ++v3) {
            View v4 = arg9.findViewById(v1[v3]);
            ColorStateList v6 = ColorStateList.valueOf(0x28FFD21A);
            int v7 = v4.isSelected() ? -11750 : 0xFF191C22;
            v4.setBackground(new RippleDrawable(v6, v0.surface(v7), null));
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

