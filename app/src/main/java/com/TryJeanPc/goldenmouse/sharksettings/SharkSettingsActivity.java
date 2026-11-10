package com.TryJeanPc.goldenmouse.sharksettings;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.DisplayCutoutCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat$Type;
import androidx.core.view.WindowInsetsCompat;
import com.TryJeanPc.goldenmouse.GoldenSharkGameSwitch;
import com.TryJeanPc.goldenmouse.R$anim;
import com.TryJeanPc.goldenmouse.R$color;
import com.TryJeanPc.goldenmouse.R$drawable;
import com.TryJeanPc.goldenmouse.R$id;
import com.TryJeanPc.goldenmouse.R$layout;
import com.TryJeanPc.goldenmouse.R$string;
import com.TryJeanPc.goldenmouse.ui.DecorativeAnimationPreferences;
import com.TryJeanPc.goldenmouse.ui.DecorativeEffect;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\tH\u0014J\u0010\u0010\n\u001A\u00020\u00072\u0006\u0010\u000B\u001A\u00020\tH\u0014R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\f"}, d2={"Lcom/TryJeanPc/goldenmouse/sharksettings/SharkSettingsActivity;", "Lcom/TryJeanPc/goldenmouse/sharksettings/SharkSettingsScreen;", "<init>", "()V", "optimizationSelected", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "outState", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class SharkSettingsActivity extends SharkSettingsScreen {
    public static final int $stable = 8;
    private boolean optimizationSelected;

    static {
    }

    public SharkSettingsActivity() {
        super(layout.shark_settings_center, string.shark_settings_center_title);
    }

    protected void onCreate(Bundle arg13) {
        Object v3_1;
        super.onCreate(arg13);
        View v0 = this.findViewById(id.shark_settings_center_header);
        int v1 = v0.getBackground().getMinimumHeight();
        v0.setBackgroundColor(Color.rgb(20, 22, 0x1F));
        v0.setMinimumHeight(v1);
        ViewCompat.setOnApplyWindowInsetsListener(v0, new SharkSettingsActivity$$ExternalSyntheticLambda0(v1, v0));
        int v0_1 = this.getColor(color.picker_background);
        Drawable v1_1 = this.findViewById(id.shark_settings_center_grid).getBackground().mutate();
        float v3 = ((float)(Color.red(v0_1) - 30));
        float v5 = ((float)(Color.green(v0_1) - 0x20));
        float v0_2 = ((float)(Color.blue(v0_1) - 35));
        float[] v4 = new float[20];
        boolean v6 = false;
        v4[0] = 1f;
        v4[1] = 0f;
        int v10 = 2;
        v4[v10] = 0f;
        v4[3] = 0f;
        v4[4] = v3;
        v4[5] = 0f;
        v4[6] = 1f;
        v4[7] = 0f;
        v4[8] = 0f;
        v4[9] = v5;
        v4[10] = 0f;
        v4[11] = 0f;
        v4[12] = 1f;
        v4[13] = 0f;
        v4[14] = v0_2;
        v4[15] = 0f;
        v4[16] = 0f;
        v4[17] = 0f;
        v4[18] = 1f;
        v4[19] = 0f;
        v1_1.setColorFilter(new ColorMatrixColorFilter(v4));
        this.overridePendingTransition(anim.shark_settings_activity_up_in, anim.shark_settings_activity_up_out);
        SharedPreferences v1_2 = this.getSharedPreferences("decorative_animations", 0);
        Intrinsics.checkNotNullExpressionValue(v1_2, "getSharedPreferences(...)");
        DecorativeAnimationPreferences v0_3 = new DecorativeAnimationPreferences(v1_2);
        View v1_3 = this.findViewById(id.shark_settings_optimization_content);
        Iterator v2 = DecorativeEffect.getEntries().iterator();
        while(v2.hasNext()) {
            v3_1 = v2.next();
            View v4_1 = this.getLayoutInflater().inflate(layout.shark_settings_animation_option, v1_3, false);
            v4_1.setTag(((DecorativeEffect)v3_1).getKey());
            v4_1.findViewById(id.shark_settings_effect_title).setText(((DecorativeEffect)v3_1).getTitle());
            View v5_1 = v4_1.findViewById(id.shark_settings_effect_switch);
            ((GoldenSharkGameSwitch)v5_1).setContentDescription(this.getString(((DecorativeEffect)v3_1).getTitle()));
            ((GoldenSharkGameSwitch)v5_1).setSaveEnabled(false);
            ((GoldenSharkGameSwitch)v5_1).setChecked(v0_3.isEnabled(((DecorativeEffect)v3_1)));
            ((GoldenSharkGameSwitch)v5_1).setOnCheckedChangeListener(new SharkSettingsActivity$$ExternalSyntheticLambda1(v0_3, ((DecorativeEffect)v3_1)));
            ((LinearLayout)v1_3).addView(v4_1);
        }

        v0 = this.findViewById(id.shark_settings_basic_tab);
        v1_3 = this.findViewById(id.shark_settings_optimization_tab);
        v1_3.findViewById(id.shark_settings_titleview).setText(string.shark_settings_optimization_title);
        v1_3.findViewById(id.shark_settings_lefticon).setImageResource(drawable.shark_settings_optimization_icon);
        v0.findViewById(id.shark_settings_lefticon).setImageResource(drawable.shark_settings_svg_basic_setting_icon_checked);
        View[] v2_1 = new View[v10];
        v2_1[0] = v0;
        v2_1[1] = v1_3;
        v2 = CollectionsKt.listOf(((Object[])v2_1)).iterator();
        while(v2.hasNext()) {
            v3_1 = v2.next();
            ((View)v3_1).findViewById(id.shark_settings_lefticon).setImportantForAccessibility(v10);
            ((View)v3_1).findViewById(id.shark_settings_righticon).setImportantForAccessibility(v10);
            ((View)v3_1).setFocusable(true);
        }

        v0.setOnClickListener(new SharkSettingsActivity$$ExternalSyntheticLambda2(this, v0, v1_3));
        v1_3.setOnClickListener(new SharkSettingsActivity$$ExternalSyntheticLambda3(this, v0, v1_3));
        if(arg13 != null) {
            v6 = arg13.getBoolean("optimizationSelected");
        }

        SharkSettingsActivity.onCreate$showSection(this, v0, v1_3, v6);
        this.findViewById(id.shark_settings_desktops).setOnClickListener(new SharkSettingsActivity$$ExternalSyntheticLambda4(this));
    }

    static final WindowInsetsCompat onCreate$lambda$2(int arg10, View arg11, View arg12, WindowInsetsCompat arg13) {
        int v0_2;
        int v6_2;
        int v3_2;
        Object v6;
        Intrinsics.checkNotNullParameter(arg12, "<unused var>");
        Intrinsics.checkNotNullParameter(arg13, "insets");
        Insets v12 = arg13.getInsets(Type.displayCutout() | Type.systemBars());
        Intrinsics.checkNotNullExpressionValue(v12, "getInsets(...)");
        Insets v1 = arg13.getInsets(Type.systemBars());
        Intrinsics.checkNotNullExpressionValue(v1, "getInsets(...)");
        DisplayCutoutCompat v0 = arg13.getDisplayCutout();
        List v2 = v0 != null ? v0.getBoundingRects() : null;
        if(v2 == null) {
            v2 = CollectionsKt.emptyList();
        }

        arg10 += v12.top;
        int v4 = 1;
        if(!v2.isEmpty()) {
            List v3 = v2;
            if(!(v3 instanceof Collection) || !v3.isEmpty()) {
                Iterator v3_1 = ((Iterable)v3).iterator();
                do {
                    if(v3_1.hasNext()) {
                        v6 = v3_1.next();
                        if(((Rect)v6).left >= v12.left) {
                            continue;
                        }

                        if(((Rect)v6).top >= arg10) {
                            continue;
                        }

                        if(((Rect)v6).bottom <= 0) {
                            continue;
                        }

                        break;
                    }

                    goto label_45;
                }
                while(true);

                goto label_47;
            }
            else {
            }

        label_45:
            v3_2 = 0;
        }
        else {
        label_47:
            v3_2 = 1;
        }

        if(arg11.getWidth() != 0 && !v2.isEmpty()) {
            if(!(v2 instanceof Collection) || !v2.isEmpty()) {
                Iterator v2_1 = ((Iterable)v2).iterator();
                do {
                    if(v2_1.hasNext()) {
                        v6 = v2_1.next();
                        if(((Rect)v6).right <= arg11.getWidth() - v12.right) {
                            continue;
                        }

                        if(((Rect)v6).top >= arg10) {
                            continue;
                        }

                        if(((Rect)v6).bottom <= 0) {
                            continue;
                        }

                        break;
                    }

                    goto label_72;
                }
                while(true);

                goto label_73;
            }
            else {
            }

        label_72:
            v4 = 0;
        }

    label_73:
        int v2_2 = v1.left;
        if(v0 != null) {
            Insets v6_1 = v0.getWaterfallInsets();
            if(v6_1 != null) {
                v6_2 = v6_1.left;
            }
            else {
                goto label_79;
            }
        }
        else {
        label_79:
            v6_2 = 0;
        }

        v3_2 = v3_2 != 0 ? v12.left : 0;
        v2_2 = Math.max(v2_2, Math.max(v6_2, v3_2));
        v3_2 = v12.top;
        int v1_1 = v1.right;
        if(v0 != null) {
            Insets v0_1 = v0.getWaterfallInsets();
            if(v0_1 != null) {
                v0_2 = v0_1.right;
            }
            else {
                goto label_93;
            }
        }
        else {
        label_93:
            v0_2 = 0;
        }

        int v12_1 = v4 != 0 ? v12.right : 0;
        arg11.setPadding(v2_2, v3_2, Math.max(v1_1, Math.max(v0_2, v12_1)), 0);
        arg11.setMinimumHeight(arg10);
        return arg13;
    }

    static final void onCreate$lambda$4$lambda$3(DecorativeAnimationPreferences arg1, DecorativeEffect arg2, CompoundButton arg3, boolean arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<unused var>");
        arg1.setEnabled(arg2, arg4);
    }

    static final void onCreate$lambda$5(SharkSettingsActivity arg0, View arg1, View arg2, View arg3) {
        SharkSettingsActivity.onCreate$showSection(arg0, arg1, arg2, false);
    }

    static final void onCreate$lambda$6(SharkSettingsActivity arg0, View arg1, View arg2, View arg3) {
        SharkSettingsActivity.onCreate$showSection(arg0, arg1, arg2, true);
    }

    static final void onCreate$lambda$7(SharkSettingsActivity arg3, View arg4) {
        arg3.startActivity(new Intent(arg3, SharkThemesActivity.class), ActivityOptions.makeCustomAnimation(arg3, anim.shark_settings_activity_up_in, anim.shark_settings_activity_alpha_out).toBundle());
    }

    private static final void onCreate$showSection(SharkSettingsActivity arg2, View arg3, View arg4, boolean arg5) {
        arg2.optimizationSelected = arg5;
        arg3.setSelected((((int)arg5)) ^ 1);
        arg4.setSelected(arg5);
        arg3 = arg2.findViewById(id.shark_settings_basic_content);
        int v4 = 8;
        int v1 = arg5 ? v4 : 0;
        arg3.setVisibility(v1);
        View v2 = arg2.findViewById(id.shark_settings_optimization_content);
        if(arg5) {
            v4 = 0;
        }

        v2.setVisibility(v4);
    }

    protected void onSaveInstanceState(Bundle arg3) {
        Intrinsics.checkNotNullParameter(arg3, "outState");
        arg3.putBoolean("optimizationSelected", this.optimizationSelected);
        super.onSaveInstanceState(arg3);
    }
}

