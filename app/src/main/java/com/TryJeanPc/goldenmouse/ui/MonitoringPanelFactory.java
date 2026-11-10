package com.TryJeanPc.goldenmouse.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.widget.FrameLayout$LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout$LayoutParams;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;
import com.TryJeanPc.goldenmouse.R$color;
import com.TryJeanPc.goldenmouse.R$drawable;
import com.TryJeanPc.goldenmouse.R$id;

public final class MonitoringPanelFactory {
    private static final int BORDER = 0xFF343840;
    private static final int GOLD = -11750;
    private static final int MUTED = -6906713;
    private static final int TEXT = 0xFFF5F5F6;
    private final Context context;
    private final float density;

    private MonitoringPanelFactory(Context arg1) {
        super();
        this.context = arg1;
        this.density = arg1.getResources().getDisplayMetrics().density;
    }

    private View build() {
        FrameLayout v0 = new FrameLayout(this.context);
        v0.setLayoutParams(new FrameLayout$LayoutParams(-1, -1));
        v0.setClickable(true);
        v0.setClipChildren(false);
        v0.setClipToPadding(false);
        LinearLayout v4 = this.column();
        v4.setId(id.panelContainer);
        v4.setClickable(true);
        v4.setBackgroundResource(drawable.bg_gamer_panel);
        FrameLayout$LayoutParams v5 = new FrameLayout$LayoutParams(this.dp(300), -1, 0x800005);
        v5.topMargin = this.dp(8);
        v5.bottomMargin = this.dp(8);
        v0.addView(((View)v4), ((ViewGroup$LayoutParams)v5));
        FrameLayout v5_1 = new FrameLayout(this.context);
        TextView v6 = this.text("MONITOREO", 18, -11750);
        v6.setTypeface(null, 1);
        v6.setGravity(16);
        FrameLayout$LayoutParams v10 = new FrameLayout$LayoutParams(-1, this.dp(34));
        v10.topMargin = this.dp(17);
        v10.setMarginStart(this.dp(18));
        v10.setMarginEnd(this.dp(54));
        v5_1.addView(((View)v6), ((ViewGroup$LayoutParams)v10));
        v6 = this.text("×", 22, -11750);
        v6.setId(id.btnCloseMonitoreo);
        v6.setIncludeFontPadding(true);
        v6.setTypeface(null, 1);
        v6.setGravity(17);
        v6.setBackgroundResource(drawable.exit);
        v6.setContentDescription("Cerrar monitoreo");
        FrameLayout$LayoutParams v7 = new FrameLayout$LayoutParams(this.dp(34), this.dp(34), 0x800035);
        v7.topMargin = this.dp(17);
        v7.setMarginEnd(this.dp(10));
        v5_1.addView(((View)v6), ((ViewGroup$LayoutParams)v7));
        v4.addView(((View)v5_1), new LinearLayout$LayoutParams(-1, this.dp(52)));
        View v5_2 = new View(this.context);
        v5_2.setBackgroundColor(0xFF343840);
        v4.addView(v5_2, new LinearLayout$LayoutParams(-1, this.dp(1)));
        ScrollView v5_3 = new ScrollView(this.context);
        v5_3.setId(id.scrollViewMonitoreo);
        v5_3.setFillViewport(true);
        v5_3.setVerticalScrollBarEnabled(false);
        v5_3.setOverScrollMode(2);
        LinearLayout v1 = this.column();
        v1.setPadding(this.dp(14), this.dp(4), this.dp(14), this.dp(14));
        v5_3.addView(((View)v1), new FrameLayout$LayoutParams(-1, -2));
        v4.addView(((View)v5_3), new LinearLayout$LayoutParams(-1, 0, 1f));
        this.toggle(v1, "Estilo BlueStacks", "Interfaz de rendimiento", id.switchEstiloBluestacks);
        this.toggle(v1, "FPS", "Fotogramas por segundo", id.switchFps);
        this.toggle(v1, "PING", "Latencia de conexión", id.switchPing);
        this.toggle(v1, "CPU", "Uso del procesador", id.switchCpu);
        this.toggle(v1, "RAM", "Uso de memoria", id.switchRam);
        this.toggle(v1, "TEMPERATURA", "Temperatura del dispositivo", id.switchTemp);
        this.toggle(v1, "HORA", "Hora actual del sistema", id.switchHora);
        this.decoration(v0, drawable.bg_top_point, 0x800033);
        this.decoration(v0, drawable.bg_bottom_point, 0x800053);
        return ((View)v0);
    }

    private LinearLayout column() {
        LinearLayout v0 = new LinearLayout(this.context);
        v0.setOrientation(1);
        return v0;
    }

    public static View create(Context arg1) {
        return new MonitoringPanelFactory(arg1).build();
    }

    private void decoration(FrameLayout arg4, int arg5, int arg6) {
        View v0 = new View(this.context);
        v0.setBackgroundResource(arg5);
        arg4.addView(v0, new FrameLayout$LayoutParams(this.dp(92), this.dp(12), arg6));
    }

    private int dp(int arg1) {
        return Math.round((((float)arg1)) * this.density);
    }

    private TextView text(String arg2, int arg3, int arg4) {
        TextView v0 = new TextView(this.context);
        v0.setText(((CharSequence)arg2));
        v0.setTextSize(((float)arg3));
        v0.setTextColor(arg4);
        v0.setIncludeFontPadding(false);
        return v0;
    }

    private void toggle(LinearLayout arg8, String arg9, String arg10, int arg11) {
        LinearLayout v0 = new LinearLayout(this.context);
        v0.setGravity(16);
        v0.setMinimumHeight(this.dp(52));
        v0.setPadding(this.dp(12), this.dp(6), this.dp(6), this.dp(6));
        GradientDrawable v2 = new GradientDrawable();
        v2.setColor(0xFF191C22);
        v2.setCornerRadius(((float)this.dp(9)));
        v2.setStroke(Math.max(1, this.dp(1)), 0xFF343840);
        v0.setBackground(((Drawable)v2));
        LinearLayout v2_1 = this.column();
        v2_1.addView(this.text(arg9, 12, 0xFFF5F5F6));
        TextView v10 = this.text(arg10, 10, -6906713);
        v10.setPadding(0, this.dp(4), 0, 0);
        v2_1.addView(((View)v10));
        v0.addView(((View)v2_1), new LinearLayout$LayoutParams(0, -2, 1f));
        Switch v10_1 = new Switch(this.context);
        v10_1.setId(arg11);
        v10_1.setContentDescription(((CharSequence)arg9));
        v10_1.setScaleX(0.7f);
        v10_1.setScaleY(0.7f);
        v10_1.setThumbTintList(this.context.getColorStateList(color.switch_thumb));
        v10_1.setTrackTintList(this.context.getColorStateList(color.switch_track));
        v0.addView(((View)v10_1), new LinearLayout$LayoutParams(-2, -2));
        LinearLayout$LayoutParams v9 = new LinearLayout$LayoutParams(-1, -2);
        v9.topMargin = this.dp(6);
        arg8.addView(((View)v0), ((ViewGroup$LayoutParams)v9));
    }
}

