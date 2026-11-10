package com.TryJeanPc.goldenmouse.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint$Cap;
import android.graphics.Paint$Join;
import android.graphics.Paint$Style;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.widget.FrameLayout$LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView$ScaleType;
import android.widget.ImageView;
import android.widget.LinearLayout$LayoutParams;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import com.TryJeanPc.goldenmouse.R$color;
import com.TryJeanPc.goldenmouse.R$drawable;
import com.TryJeanPc.goldenmouse.R$id;

public final class SettingsPanelFactory {
    final class CloseIcon extends Drawable {
        private final Paint paint;

        CloseIcon() {
            super();
            Paint v0 = new Paint(1);
            this.paint = v0;
            v0.setColor(-11750);
            v0.setStyle(Paint$Style.STROKE);
            v0.setStrokeWidth(1.7f);
            v0.setStrokeCap(Paint$Cap.ROUND);
            v0.setStrokeJoin(Paint$Join.ROUND);
        }

        public void draw(Canvas arg9) {
            Rect v2 = this.getBounds();
            int v7 = arg9.save();
            arg9.translate(((float)v2.left), ((float)v2.top));
            arg9.scale((((float)v2.width())) / 32f, (((float)v2.height())) / 32f);
            arg9.drawLine(8f, 8f, 24f, 24f, this.paint);
            arg9.drawLine(24f, 8f, 8f, 24f, this.paint);
            arg9.restoreToCount(v7);
        }

        public int getIntrinsicHeight() {
            return 0x20;
        }

        public int getIntrinsicWidth() {
            return 0x20;
        }

        public int getOpacity() {
            return -3;
        }

        public void setAlpha(int arg2) {
            this.paint.setAlpha(arg2);
            this.invalidateSelf();
        }

        public void setColorFilter(ColorFilter arg2) {
            this.paint.setColorFilter(arg2);
            this.invalidateSelf();
        }
    }

    private static final int BORDER = 0xFF343840;
    private static final int GOLD = -11750;
    private static final int MUTED = -6906713;
    private static final int TEXT = 0xFFF5F5F6;
    private final Context context;
    private final float density;

    private SettingsPanelFactory(Context arg1) {
        super();
        this.context = arg1;
        this.density = arg1.getResources().getDisplayMetrics().density;
    }

    private void action(LinearLayout arg7, String arg8, String arg9, String arg10, int arg11, int arg12) {
        LinearLayout v0 = this.row();
        v0.setId(arg11);
        v0.setMinimumHeight(this.dp(0x30));
        v0.setPadding(this.dp(12), this.dp(8), this.dp(12), this.dp(8));
        v0.setClickable(true);
        v0.setFocusable(true);
        v0.setBackground(this.actionBackground());
        this.labels(v0, arg8, arg9);
        TextView v8 = this.text(arg10, 12, -11750);
        v8.setId(arg12);
        v8.setMaxWidth(this.dp(120));
        v8.setMaxLines(2);
        v8.setGravity(0x800005);
        LinearLayout$LayoutParams v9 = new LinearLayout$LayoutParams(-2, -2);
        v9.setMarginStart(this.dp(8));
        v0.addView(((View)v8), ((ViewGroup$LayoutParams)v9));
        this.add(arg7, ((View)v0), -2, 6);
    }

    private Drawable actionBackground() {
        return new RippleDrawable(ColorStateList.valueOf(0x28FFD21A), this.surface(0xFF191C23, 11), null);
    }

    private void add(LinearLayout arg3, View arg4, int arg5, int arg6) {
        if(arg5 < 0) {
        }
        else {
            arg5 = this.dp(arg5);
        }

        LinearLayout$LayoutParams v0 = new LinearLayout$LayoutParams(-1, arg5);
        v0.topMargin = this.dp(arg6);
        arg3.addView(arg4, ((ViewGroup$LayoutParams)v0));
    }

    private View build() {
        FrameLayout v7 = new FrameLayout(this.context);
        v7.setLayoutParams(new FrameLayout$LayoutParams(-1, -1));
        v7.setClickable(true);
        v7.setClipChildren(false);
        v7.setClipToPadding(false);
        LinearLayout v3 = this.column();
        v3.setId(id.panelContainer);
        v3.setClickable(true);
        v3.setBackground(this.surface(0xFF111318, 20));
        FrameLayout$LayoutParams v4 = new FrameLayout$LayoutParams(this.dp(300), -1, 0x800005);
        v4.topMargin = this.dp(8);
        v4.bottomMargin = this.dp(8);
        v7.addView(((View)v3), ((ViewGroup$LayoutParams)v4));
        FrameLayout v4_1 = new FrameLayout(this.context);
        TextView v5 = this.text("AJUSTES", 18, -11750);
        v5.setTypeface(null, 1);
        FrameLayout$LayoutParams v11 = new FrameLayout$LayoutParams(-1, -1);
        v11.setMarginStart(this.dp(18));
        v11.topMargin = this.dp(16);
        v11.setMarginEnd(this.dp(54));
        v5.setGravity(16);
        v4_1.addView(((View)v5), ((ViewGroup$LayoutParams)v11));
        ImageView v5_1 = new ImageView(this.context);
        v5_1.setId(id.btnCloseSettings);
        v5_1.setImageDrawable(new CloseIcon());
        v5_1.setScaleType(ImageView$ScaleType.FIT_CENTER);
        v5_1.setPadding(this.dp(3), this.dp(3), this.dp(3), this.dp(3));
        v5_1.setContentDescription("Cerrar ajustes");
        v5_1.setFocusable(true);
        v5_1.setBackground(new RippleDrawable(ColorStateList.valueOf(0x22FFD21A), null, this.surface(-1, 9)));
        v11 = new FrameLayout$LayoutParams(this.dp(34), this.dp(34), 0x800035);
        v11.setMarginEnd(this.dp(10));
        v11.topMargin = this.dp(17);
        v4_1.addView(((View)v5_1), ((ViewGroup$LayoutParams)v11));
        v3.addView(((View)v4_1), new LinearLayout$LayoutParams(-1, this.dp(52)));
        View v4_2 = new View(this.context);
        v4_2.setBackgroundColor(0xFF343840);
        v3.addView(v4_2, new LinearLayout$LayoutParams(-1, this.dp(1)));
        ScrollView v4_3 = new ScrollView(this.context);
        v4_3.setFillViewport(true);
        v4_3.setVerticalScrollBarEnabled(false);
        v4_3.setOverScrollMode(2);
        LinearLayout v5_2 = this.column();
        v5_2.setPadding(this.dp(14), this.dp(10), this.dp(14), this.dp(16));
        v4_3.addView(((View)v5_2), new FrameLayout$LayoutParams(-1, -2));
        v3.addView(((View)v4_3), new LinearLayout$LayoutParams(-1, 0, 1f));
        this.toggle(v5_2, "Mostrar controles", "Visualización del mapeo", id.switchMostrarControles, true);
        this.slider(v5_2, "Transparencia de los botones", null, id.seekTransparenciaBotones, id.txtTransparenciaBotones, 100);
        this.action(v5_2, "Color / Tema", null, "Verde Matrix  ›", id.btnTemaBotones, id.txtTemaBotones);
        this.section(v5_2, "Tamaño de botones");
        this.slider(v5_2, "Tamaño botón Tap", null, id.seekTamanoTap, id.txtTamanoTap, 50);
        this.slider(v5_2, "Tamaño Joystick", "No se recomienda modificar", id.seekTamanoJoystick, id.txtTamanoJoystick, 50);
        this.slider(v5_2, "Tamaño botón Vista", "No se recomienda modificar", id.seekTamanoVista, id.txtTamanoVista, 50);
        this.slider(v5_2, "Tamaño botón Disparo", "No se recomienda modificar", id.seekTamanoDisparo, id.txtTamanoDisparo, 50);
        TextView v2 = this.text("Restablecer tamaños", 12, -11750);
        v2.setId(id.btnRestablecerTamanos);
        v2.setGravity(17);
        v2.setTypeface(null, 1);
        v2.setMinimumHeight(this.dp(0x30));
        v2.setFocusable(true);
        v2.setClickable(true);
        v2.setBackground(this.actionBackground());
        this.add(v5_2, ((View)v2), -2, 7);
        this.section(v5_2, "Logo");
        this.slider(v5_2, "Transparencia del logo", null, id.seekTransparenciaLogo, id.txtTransparenciaLogo, 100);
        this.slider(v5_2, "Tamaño del logo", null, id.seekTamanoLogo, id.txtTamanoLogo, 50);
        this.section(v5_2, "Accesos");
        this.action(v5_2, "Ocultar mapeo", "Tecla rápida", "F9  ›", id.btnTeclaOcultarMapeo, id.txtTeclaOcultarMapeo);
        this.toggle(v5_2, "Mostrar toques en pantalla", "Visualiza las pulsaciones táctiles", id.switchMostrarToques, false);
        this.decoration(v7, drawable.bg_top_point, 0x800033);
        this.decoration(v7, drawable.bg_bottom_point, 0x800053);
        return ((View)v7);
    }

    private LinearLayout column() {
        LinearLayout v0 = new LinearLayout(this.context);
        v0.setOrientation(1);
        return v0;
    }

    public static View create(Context arg1) {
        return new SettingsPanelFactory(arg1).build();
    }

    private void decoration(FrameLayout arg4, int arg5, int arg6) {
        View v0 = new View(this.context);
        v0.setBackground(this.context.getDrawable(arg5));
        arg4.addView(v0, new FrameLayout$LayoutParams(this.dp(92), this.dp(12), arg6));
    }

    private int dp(int arg1) {
        return Math.round((((float)arg1)) * this.density);
    }

    private void labels(LinearLayout arg6, String arg7, String arg8) {
        LinearLayout v0 = this.column();
        int v2 = -1;
        int v3 = -2;
        v0.addView(this.text(arg7, 12, 0xFFF5F5F6), new LinearLayout$LayoutParams(v2, v3));
        if(arg8 != null) {
            TextView v8 = this.text(arg8, 10, -6906713);
            v8.setPadding(0, this.dp(4), 0, 0);
            v0.addView(((View)v8), new LinearLayout$LayoutParams(v2, v3));
        }

        arg6.addView(((View)v0), new LinearLayout$LayoutParams(0, v3, 1f));
    }

    private LinearLayout row() {
        LinearLayout v0 = new LinearLayout(this.context);
        v0.setGravity(16);
        return v0;
    }

    private void section(LinearLayout arg4, String arg5) {
        View v0 = new View(this.context);
        v0.setBackgroundColor(0xFF343840);
        this.add(arg4, v0, 1, 14);
        TextView v5 = this.text(arg5, 11, -6906713);
        v5.setTypeface(null, 1);
        this.add(arg4, ((View)v5), -2, 10);
    }

    private void slider(LinearLayout arg9, String arg10, String arg11, int arg12, int arg13, int arg14) {
        LinearLayout v0 = this.column();
        v0.setPadding(this.dp(12), this.dp(9), this.dp(12), this.dp(5));
        v0.setBackground(this.surface(0xFF191C22, 9));
        LinearLayout v2 = this.row();
        this.labels(v2, arg10, arg11);
        TextView v11 = this.text("100%", 12, -11750);
        v11.setId(arg13);
        v11.setTypeface(null, 1);
        LinearLayout$LayoutParams v13 = new LinearLayout$LayoutParams(-2, -2);
        v13.setMarginStart(this.dp(8));
        v2.addView(((View)v11), ((ViewGroup$LayoutParams)v13));
        v0.addView(((View)v2), new LinearLayout$LayoutParams(-1, -2));
        SeekBar v11_1 = new SeekBar(this.context);
        v11_1.setId(arg12);
        v11_1.setMax(100);
        v11_1.setProgress(arg14);
        v11_1.setContentDescription(((CharSequence)arg10));
        v11_1.setSplitTrack(false);
        v11_1.setPadding(this.dp(5), 0, this.dp(5), 0);
        v11_1.setProgressTintList(ColorStateList.valueOf(-11750));
        v11_1.setProgressBackgroundTintList(ColorStateList.valueOf(0xFF363941));
        GradientDrawable v10 = new GradientDrawable();
        v10.setShape(1);
        v10.setColor(-11750);
        v10.setSize(this.dp(13), this.dp(13));
        v11_1.setThumb(((Drawable)v10));
        v11_1.setThumbOffset(this.dp(6));
        v0.addView(((View)v11_1), new LinearLayout$LayoutParams(-1, this.dp(36)));
        this.add(arg9, ((View)v0), -2, 6);
    }

    private GradientDrawable surface(int arg2, int arg3) {
        GradientDrawable v0 = new GradientDrawable();
        v0.setColor(arg2);
        v0.setCornerRadius(((float)this.dp(arg3)));
        v0.setStroke(Math.max(1, this.dp(1)), 0xFF343840);
        return v0;
    }

    private TextView text(String arg2, int arg3, int arg4) {
        TextView v0 = new TextView(this.context);
        v0.setText(((CharSequence)arg2));
        v0.setTextSize(2, ((float)arg3));
        v0.setTextColor(arg4);
        v0.setIncludeFontPadding(false);
        return v0;
    }

    private void toggle(LinearLayout arg7, String arg8, String arg9, int arg10, boolean arg11) {
        LinearLayout v0 = this.row();
        v0.setPadding(this.dp(12), this.dp(6), this.dp(6), this.dp(6));
        v0.setMinimumHeight(this.dp(52));
        this.labels(v0, arg8, arg9);
        Switch v9 = new Switch(this.context);
        v9.setId(arg10);
        v9.setChecked(arg11);
        v9.setContentDescription(((CharSequence)arg8));
        v9.setThumbTintList(this.context.getColorStateList(color.switch_thumb));
        v9.setTrackTintList(this.context.getColorStateList(color.switch_track));
        v9.setScaleX(0.7f);
        v9.setScaleY(0.7f);
        v0.addView(((View)v9), new LinearLayout$LayoutParams(-2, -2));
        v0.setBackground(this.surface(0xFF191C22, 9));
        this.add(arg7, ((View)v0), -2, 6);
    }
}

