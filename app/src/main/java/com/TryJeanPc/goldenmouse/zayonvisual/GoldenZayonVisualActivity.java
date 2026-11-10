package com.TryJeanPc.goldenmouse.zayonvisual;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.InputDevice;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.ComponentActivity;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.core.graphics.Insets;
import androidx.core.view.DisplayCutoutCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat$Type;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import com.TryJeanPc.goldenmouse.PermissionRequirements;
import com.TryJeanPc.goldenmouse.R$color;
import com.TryJeanPc.goldenmouse.R$id;
import com.TryJeanPc.goldenmouse.R$layout;
import com.TryJeanPc.goldenmouse.R$string;
import com.TryJeanPc.goldenmouse.activation.ActivationManager;
import com.TryJeanPc.goldenmouse.gamespace.GoldenGamePickerActivity;
import com.TryJeanPc.goldenmouse.gamespace.GoldenGameSpaceActivity;
import com.TryJeanPc.goldenmouse.graphicsui.GoldenGraphicsLoadingView;
import com.TryJeanPc.goldenmouse.graphicsui.GraphicsLoadingOperation;
import com.TryJeanPc.goldenmouse.stretch.diagnostics.GoldenStretchDiagnosticsScreenKt;
import com.TryJeanPc.goldenmouse.ui.theme.ThemeKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;

@Metadata(d1={"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u0000 12\u00020\u0001:\u00011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001C\u001A\u00020\u001D2\b\u0010\u001E\u001A\u0004\u0018\u00010\u001FH\u0014J\u0010\u0010 \u001A\u00020\u001D2\u0006\u0010!\u001A\u00020\"H\u0014J\u0010\u0010#\u001A\u00020\u001D2\u0006\u0010$\u001A\u00020\u001FH\u0014J\u0010\u0010%\u001A\u00020\u001D2\u0006\u0010&\u001A\u00020\u0013H\u0002J\b\u0010\'\u001A\u00020\u001DH\u0002J\b\u0010(\u001A\u00020\u001DH\u0002J\b\u0010)\u001A\u00020\u001DH\u0002J\b\u0010*\u001A\u00020\u001DH\u0002J\b\u0010+\u001A\u00020\u001DH\u0002J\b\u0010,\u001A\u00020\u001DH\u0014J\b\u0010-\u001A\u00020\u001DH\u0014J\u0010\u0010.\u001A\u00020\u001D2\u0006\u0010/\u001A\u00020\u000BH\u0016J\b\u00100\u001A\u00020\u001DH\u0002R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001A\u0004\u0018\u00010\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u000E\u001A\u0004\u0018\u00010\u000FX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001A\u0004\u0018\u00010\u0011X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0013X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\u0013X\u0082\u000E¢\u0006\u0002\n\u0000R\"\u0010\u0015\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u00170\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018R\u0016\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u001A0\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001B¨\u00062"}, d2={"Lcom/TryJeanPc/goldenmouse/zayonvisual/GoldenZayonVisualActivity;", "Landroidx/activity/ComponentActivity;", "<init>", "()V", "content", "Landroid/widget/FrameLayout;", "actions", "Lcom/TryJeanPc/goldenmouse/zayonvisual/GoldenActivationActions;", "activationLoading", "Lcom/TryJeanPc/goldenmouse/graphicsui/GoldenGraphicsLoadingView;", "checkingActivation", "", "screen", "Landroid/view/View;", "permissionPanel", "Lcom/TryJeanPc/goldenmouse/zayonvisual/GoldenPermissionPanel;", "diagnosticView", "Landroidx/compose/ui/platform/ComposeView;", "section", "", "method", "tabs", "", "Lkotlin/Pair;", "[Lkotlin/Pair;", "sections", "", "[[I", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "onSaveInstanceState", "outState", "showSection", "index", "configureCenterSurfaces", "renderActivationLoading", "refreshScreen", "openInputSettings", "goHome", "onResume", "onDestroy", "onWindowFocusChanged", "hasFocus", "hideSystemBars", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GoldenZayonVisualActivity extends ComponentActivity {
    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2={"Lcom/TryJeanPc/goldenmouse/zayonvisual/GoldenZayonVisualActivity$Companion;", "", "<init>", "()V", "SECTION", "", "PROFILE", "", "ACTIVATION", "PERMISSIONS", "GRAPHICS", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    public static final int $stable = 0;
    public static final int ACTIVATION = 1;
    public static final Companion Companion = null;
    public static final int GRAPHICS = 3;
    public static final int PERMISSIONS = 2;
    public static final int PROFILE = 0;
    public static final String SECTION = "golden_section";
    private GoldenActivationActions actions;
    private GoldenGraphicsLoadingView activationLoading;
    private boolean checkingActivation;
    private FrameLayout content;
    private ComposeView diagnosticView;
    private int method;
    private GoldenPermissionPanel permissionPanel;
    private View screen;
    private int section;
    private final int[][] sections;
    private final Pair[] tabs;

    static {
        GoldenZayonVisualActivity.Companion = new Companion(null);
        GoldenZayonVisualActivity.$stable = 8;
    }

    public GoldenZayonVisualActivity() {
        super();
        this.tabs = new Pair[]{TuplesKt.to(Integer.valueOf(id.golden_activation_tab_shizuko), Integer.valueOf(layout.golden_shizuko)), TuplesKt.to(Integer.valueOf(id.golden_activation_tab_inalambrica), Integer.valueOf(layout.golden_inalambrica)), TuplesKt.to(Integer.valueOf(id.golden_activation_tab_root), Integer.valueOf(layout.golden_root)), TuplesKt.to(Integer.valueOf(id.golden_activation_tab_pc_cable), Integer.valueOf(layout.golden_pc_cable))};
        this.sections = new int[][]{new int[]{id.golden_zayon_visual_gs_tab_game, id.golden_zayon_visual_gs_tab_game_icon, id.golden_zayon_visual_gs_tab_game_label, id.golden_zayon_visual_gs_tab_game_ind}, new int[]{id.golden_zayon_visual_gs_tab_perf, id.golden_zayon_visual_gs_tab_perf_icon, id.golden_zayon_visual_gs_tab_perf_label, id.golden_zayon_visual_gs_tab_perf_ind}, new int[]{id.golden_zayon_visual_gs_tab_battery, id.golden_zayon_visual_gs_tab_battery_icon, id.golden_zayon_visual_gs_tab_battery_label, id.golden_zayon_visual_gs_tab_battery_ind}, new int[]{id.golden_zayon_visual_gs_tab_settings, id.golden_zayon_visual_gs_tab_settings_icon, id.golden_zayon_visual_gs_tab_settings_label, id.golden_zayon_visual_gs_tab_settings_ind}};
    }

    public static final ComposeView access$getDiagnosticView$p(GoldenZayonVisualActivity arg0) {
        return arg0.diagnosticView;
    }

    public static final void access$goHome(GoldenZayonVisualActivity arg0) {
        arg0.goHome();
    }

    public static final void access$refreshScreen(GoldenZayonVisualActivity arg0) {
        arg0.refreshScreen();
    }

    public static final void access$showSection(GoldenZayonVisualActivity arg0, int arg1) {
        arg0.showSection(arg1);
    }

    private final void configureCenterSurfaces() {
        View v0 = this.findViewById(id.shark_settings_center_header);
        int v1 = v0.getBackground().getMinimumHeight();
        v0.setBackgroundColor(Color.rgb(20, 22, 0x1F));
        v0.setMinimumHeight(v1);
        ViewCompat.setOnApplyWindowInsetsListener(v0, new GoldenZayonVisualActivity$$ExternalSyntheticLambda0(v1, v0));
        int v0_1 = this.getColor(color.picker_background);
        this.findViewById(id.golden_zayon_visual_content_container).getBackground().mutate().setColorFilter(new ColorMatrixColorFilter(new float[]{1f, 0f, 0f, 0f, ((float)(Color.red(v0_1) - 30)), 0f, 1f, 0f, 0f, ((float)(Color.green(v0_1) - 0x20)), 0f, 0f, 1f, 0f, ((float)(Color.blue(v0_1) - 35)), 0f, 0f, 0f, 1f, 0f}));
    }

    static final WindowInsetsCompat configureCenterSurfaces$lambda$24(int arg10, View arg11, View arg12, WindowInsetsCompat arg13) {
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

    private final void goHome() {
        this.startActivity(new Intent(this, GoldenGameSpaceActivity.class).addFlags(0x24000000));
        this.finish();
    }

    private final void hideSystemBars() {
        WindowInsetsControllerCompat v1 = WindowCompat.getInsetsController(this.getWindow(), this.getWindow().getDecorView());
        v1.setSystemBarsBehavior(2);
        v1.hide(Type.systemBars());
    }

    protected void onCreate(Bundle arg8) {
        super.onCreate(arg8);
        ActivationManager v0 = ActivationManager.INSTANCE;
        Context v1 = this.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(v1, "getApplicationContext(...)");
        v0.initialize(v1);
        WindowCompat.setDecorFitsSystemWindows(this.getWindow(), false);
        this.setContentView(layout.golden_zayon_visual_main);
        View v0_1 = this.findViewById(id.golden_zayon_visual_content_container);
        Intrinsics.checkNotNullExpressionValue(v0_1, "findViewById(...)");
        this.content = ((FrameLayout)v0_1);
        this.activationLoading = GoldenGraphicsLoadingView.Companion.attach(this);
        this.actions = new GoldenActivationActions(this, new GoldenZayonVisualActivity$$ExternalSyntheticLambda6(this), new GoldenZayonVisualActivity$$ExternalSyntheticLambda7(this));
        int v0_2 = arg8 != null ? arg8.getInt("section") : this.getIntent().getIntExtra("golden_section", 0);
        this.section = RangesKt.coerceIn(v0_2, 0, 3);
        int v8 = arg8 != null ? arg8.getInt("method") : 0;
        this.method = RangesKt.coerceIn(v8, ArraysKt.getIndices(this.tabs));
        int[][] v8_1 = this.sections;
        v0_2 = v8_1.length;
        int v2 = 0;
        int v3;
        for(v3 = 0; v2 < v0_2; ++v3) {
            this.findViewById(v8_1[v2][0]).setOnClickListener(new GoldenZayonVisualActivity$$ExternalSyntheticLambda8(this, v3));
            ++v2;
        }

        this.findViewById(id.shark_settings_ir4s_toolbar_title).setText(string.shark_settings_center_title);
        this.findViewById(id.shark_settings_ir4s_toolbar_back_hotspot).setOnClickListener(new GoldenZayonVisualActivity$$ExternalSyntheticLambda9(this));
        this.configureCenterSurfaces();
        this.getOnBackPressedDispatcher().addCallback(this, new GoldenZayonVisualActivity$onCreate$5(this));
        this.showSection(this.section);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new GoldenZayonVisualActivity$onCreate$6(this, null), 3, null);
        this.hideSystemBars();
    }

    static final Unit onCreate$lambda$0(GoldenZayonVisualActivity arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "message");
        View v1 = arg1.screen;
        if(v1 != null) {
            v1 = v1.findViewById(id.golden_activation_feedback);
            if(v1 != null) {
                ((TextView)v1).setText(((CharSequence)arg2));
            }
        }

        return Unit.INSTANCE;
    }

    static final Unit onCreate$lambda$1(GoldenZayonVisualActivity arg0, boolean arg1) {
        arg0.checkingActivation = arg1;
        arg0.renderActivationLoading();
        return Unit.INSTANCE;
    }

    static final void onCreate$lambda$3$lambda$2(GoldenZayonVisualActivity arg0, int arg1, View arg2) {
        arg0.showSection(arg1);
    }

    static final void onCreate$lambda$4(GoldenZayonVisualActivity arg0, View arg1) {
        arg0.goHome();
    }

    protected void onDestroy() {
        ComposeView v0 = this.diagnosticView;
        if(v0 != null) {
            v0.disposeComposition();
        }

        super.onDestroy();
    }

    protected void onNewIntent(Intent arg3) {
        Intrinsics.checkNotNullParameter(arg3, "intent");
        super.onNewIntent(arg3);
        this.setIntent(arg3);
        this.showSection(RangesKt.coerceIn(arg3.getIntExtra("golden_section", this.section), 0, 3));
    }

    protected void onResume() {
        super.onResume();
        ActivationManager.INSTANCE.refresh();
        this.refreshScreen();
        this.hideSystemBars();
    }

    protected void onSaveInstanceState(Bundle arg3) {
        Intrinsics.checkNotNullParameter(arg3, "outState");
        arg3.putInt("section", this.section);
        arg3.putInt("method", this.method);
        super.onSaveInstanceState(arg3);
    }

    public void onWindowFocusChanged(boolean arg1) {
        super.onWindowFocusChanged(arg1);
        if(arg1) {
            this.hideSystemBars();
        }
    }

    private final void openInputSettings() {
        Iterator v0 = CollectionsKt.listOf(new String[]{"android.settings.HARD_KEYBOARD_SETTINGS", "android.settings.INPUT_METHOD_SETTINGS", "android.settings.SETTINGS"}).iterator();
    label_13:
        if(v0.hasNext()) {
            Object v1 = v0.next();
            try {
                this.startActivity(new Intent(((String)v1)));
                return;
            }
            catch(SecurityException ) {
                goto label_13;
            }
        }

        Toast.makeText(((Context)this), "No se pudo abrir la configuración de entrada", 1).show();
    }

    private final void refreshScreen() {
        View v0_2;
        this.renderActivationLoading();
        int v0 = this.section;
        GoldenActivationActions v1 = null;
        String v2 = "actions";
        int v3 = 2;
        int v4 = 1;
        if(v0 == 0) {
            int[] v0_3 = InputDevice.getDeviceIds();
            Intrinsics.checkNotNullExpressionValue(v0_3, "getDeviceIds(...)");
            ArrayList v5 = new ArrayList(v0_3.length);
            int v6 = v0_3.length;
            int v8;
            for(v8 = 0; v8 < v6; ++v8) {
                ((Collection)v5).add(InputDevice.getDevice(v0_3[v8]));
            }

            List v0_4 = CollectionsKt.filterNotNull(((Iterable)v5));
            boolean v5_1 = v0_4 instanceof Collection;
            if(!v5_1 || !v0_4.isEmpty()) {
                Iterator v6_1 = ((Iterable)v0_4).iterator();
                do {
                    if(v6_1.hasNext()) {
                        Object v8_1 = v6_1.next();
                        if(((InputDevice)v8_1).isVirtual()) {
                            continue;
                        }

                        if(((InputDevice)v8_1).getKeyboardType() != v3) {
                            continue;
                        }

                        break;
                    }
                    else {
                        goto label_54;
                    }
                }
                while(true);

                v3 = 1;
                goto label_65;
            label_54:
                v3 = 0;
            }
            else {
                goto label_54;
            }

        label_65:
            if(!v5_1 || !v0_4.isEmpty()) {
                Iterator v0_5 = ((Iterable)v0_4).iterator();
                do {
                    if(v0_5.hasNext()) {
                        Object v5_2 = v0_5.next();
                        if(((InputDevice)v5_2).isVirtual()) {
                            continue;
                        }

                        if(!((InputDevice)v5_2).supportsSource(0x2002)) {
                            continue;
                        }
                    }
                    else {
                        break;
                    }

                    goto label_80;
                }
                while(true);

            label_69:
                v4 = 0;
            }
            else {
                goto label_69;
            }

        label_80:
            v0_2 = this.screen;
            if(v0_2 != null) {
                v0_2 = v0_2.findViewById(id.golden_profile_input_status);
                if(v0_2 != null) {
                    String v5_3 = "detectado";
                    String v6_2 = "no detectado";
                    String v3_2 = v3 != 0 ? v5_3 : v6_2;
                    if(v4 != 0) {
                    }
                    else {
                        v5_3 = v6_2;
                    }

                    ((TextView)v0_2).setText("Teclado externo: " + v3_2 + " · Ratón: " + v5_3);
                }
            }

            v0_2 = this.screen;
            if(v0_2 == null) {
                return;
            }

            v0_2 = v0_2.findViewById(id.golden_profile_activation_status);
            if(v0_2 == null) {
                return;
            }

            GoldenActivationActions v10 = this.actions;
            if(v10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v2);
            }
            else {
                v1 = v10;
            }

            ((TextView)v0_2).setText(v1.coreStatus());
        }
        else if(v0 == 1) {
            v0_2 = this.screen;
            if(v0_2 != null) {
                v0_2 = v0_2.findViewById(id.golden_activation_status);
                if(v0_2 != null) {
                    GoldenActivationActions v3_1 = this.actions;
                    if(v3_1 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(v2);
                    }
                    else {
                        v1 = v3_1;
                    }

                    ((TextView)v0_2).setText(v1.status(this.method));
                    return;
                }
            }
        }
        else if(v0 != v3) {
        }
        else {
            GoldenPermissionPanel v0_1 = this.permissionPanel;
            if(v0_1 != null) {
                v0_1.render(PermissionRequirements.INSTANCE.evaluate(this), new GoldenZayonVisualActivity$refreshScreen$1(this));
                return;
            }
        }
    }

    private final void renderActivationLoading() {
        GoldenGraphicsLoadingView v0 = this.activationLoading;
        String v1 = null;
        if(v0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activationLoading");
            v0 = ((GoldenGraphicsLoadingView)v1);
        }

        if(this.section == 1 && (this.checkingActivation)) {
            v1 = GraphicsLoadingOperation.ACTIVATE.getLabel();
        }

        v0.render(v1);
    }

    private final void showSection(int arg14) {
        int v8_1;
        Pair[] v1_2;
        float v6_1;
        View v5_1;
        int v9;
        int v6;
        this.section = arg14;
        ComposeView v14 = this.diagnosticView;
        if(v14 != null) {
            v14.disposeComposition();
        }

        v14 = null;
        this.diagnosticView = v14;
        this.permissionPanel = ((GoldenPermissionPanel)v14);
        FrameLayout v0 = this.content;
        String v1 = "content";
        if(v0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v1);
            v0 = ((FrameLayout)v14);
        }

        v0.removeAllViews();
        int[][] v0_1 = this.sections;
        int v2 = v0_1.length;
        boolean v3 = false;
        int v4 = 0;
        int v5;
        for(v5 = 0; true; v5 = v9) {
            v6 = 3;
            boolean v7 = true;
            if(v4 >= v2) {
                break;
            }

            int[] v8 = v0_1[v4];
            v9 = v5 + 1;
            if(v5 == this.section) {
            }
            else {
                v7 = false;
            }

            this.findViewById(v8[0]).setSelected(v7);
            v5_1 = this.findViewById(v8[v6]);
            v6 = v7 ? 0 : 4;
            v5_1.setVisibility(v6);
            ++v4;
        }

        int v0_2 = this.section;
        v2 = 2;
        if(v0_2 == 1) {
            v0_2 = this.tabs[this.method].getSecond().intValue();
        }
        else if(v0_2 == v2) {
            v0_2 = layout.golden_permisos;
        }
        else if(v0_2 != v6) {
            v0_2 = layout.golden_perfil;
        }
        else {
            v0_2 = layout.golden_graficos;
        }

        LayoutInflater v4_1 = LayoutInflater.from(this);
        FrameLayout v5_2 = this.content;
        if(v5_2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v1);
            ViewGroup v5_3 = ((ViewGroup)v14);
        }

        View v0_3 = v4_1.inflate(v0_2, ((ViewGroup)v5_2), false);
        this.screen = v0_3;
        FrameLayout v4_2 = this.content;
        if(v4_2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v1);
            v4_2 = ((FrameLayout)v14);
        }

        v4_2.addView(v0_3);
        int v1_1 = this.section;
        if(v1_1 == 0) {
            v0_3.findViewById(id.golden_profile_library).setOnClickListener(new GoldenZayonVisualActivity$$ExternalSyntheticLambda14(this));
            v0_3.findViewById(id.golden_profile_input).setOnClickListener(new GoldenZayonVisualActivity$$ExternalSyntheticLambda1(this));
            v0_3.findViewById(id.golden_profile_activation).setOnClickListener(new GoldenZayonVisualActivity$$ExternalSyntheticLambda2(this));
            goto label_211;
        label_90:
            while(v5 < v4) {
                int v10 = v8_1 + 1;
                v9 = v1_2[v5].component1().intValue();
                View v11 = v0_3.findViewById(v9);
                boolean v12 = v8_1 == this.method ? true : false;
                v11.setSelected(v12);
                v0_3.findViewById(v9).setOnClickListener(new GoldenZayonVisualActivity$$ExternalSyntheticLambda10(this, v8_1));
                ++v5;
                v8_1 = v10;
            }

            Integer[] v1_3 = new Integer[v6];
            v1_3[0] = Integer.valueOf(id.golden_activation_step_1);
            v1_3[1] = Integer.valueOf(id.golden_activation_step_2);
            v1_3[v2] = Integer.valueOf(id.golden_activation_step_3);
            Iterator v1_4 = CollectionsKt.listOf(((Object[])v1_3)).iterator();
            for(v4 = 0; true; v4 = v8_1) {
                v6_1 = 0.45f;
                if(!v1_4.hasNext()) {
                    break;
                }

                Object v5_4 = v1_4.next();
                v8_1 = v4 + 1;
                if(v4 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }

                v5_1 = v0_3.findViewById(((Number)v5_4).intValue());
                v5_1.setContentDescription(GoldenActivationActions.Companion.getMETHOD_NAMES().get(this.method) + ": paso " + v8_1);
                boolean v9_1 = this.method < v2 ? true : false;
                v5_1.setEnabled(v9_1);
                if(v5_1.isEnabled()) {
                    v5_1.setOnClickListener(new GoldenZayonVisualActivity$$ExternalSyntheticLambda11(this, v4));
                }
                else {
                    v5_1.setAlpha(v6_1);
                    v5_1.setContentDescription(GoldenActivationActions.Companion.getMETHOD_NAMES().get(this.method) + ": no disponible");
                }
            }

            v0_3.findViewById(id.golden_activation_refresh).setOnClickListener(new GoldenZayonVisualActivity$$ExternalSyntheticLambda12(this));
            View v1_5 = v0_3.findViewById(id.golden_activation_refresh);
            if(this.method < v2) {
                v3 = true;
            }

            v1_5.setEnabled(v3);
            if(v1_5.isEnabled()) {
                v6_1 = 1f;
            }

            v1_5.setAlpha(v6_1);
            v0_3 = v0_3.findViewById(id.golden_activation_feedback);
            GoldenActivationActions v1_6 = this.actions;
            if(v1_6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actions");
            }
            else {
                GoldenActivationActions v14_1 = v1_6;
            }

            ((TextView)v0_3).setText(((GoldenActivationActions)v14).description(this.method));
        }
        else if(v1_1 == 1) {
            v1_2 = this.tabs;
            v4 = v1_2.length;
            v5 = 0;
            v8_1 = 0;
            goto label_90;
        }
        else if(v1_1 == v2) {
            Intrinsics.checkNotNull(v0_3);
            this.permissionPanel = new GoldenPermissionPanel(v0_3);
        }
        else if(v1_1 != v6) {
        }
        else {
            v0_3.findViewById(id.golden_graphics_diagnostics).setOnClickListener(new GoldenZayonVisualActivity$$ExternalSyntheticLambda13(this));
        }

    label_211:
        this.refreshScreen();
    }

    static final void showSection$lambda$10$lambda$9$lambda$8(GoldenZayonVisualActivity arg0, int arg1, View arg2) {
        GoldenActivationActions v2 = arg0.actions;
        if(v2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actions");
            v2 = null;
        }

        v2.execute(arg0.method, arg1 + 1);
    }

    static final void showSection$lambda$11(GoldenZayonVisualActivity arg0, View arg1) {
        ActivationManager.INSTANCE.refresh();
        arg0.refreshScreen();
    }

    static final void showSection$lambda$18(GoldenZayonVisualActivity arg8, View arg9) {
        FrameLayout v9 = arg8.content;
        String v0 = "content";
        View v1 = null;
        if(v9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v0);
            v9 = ((FrameLayout)v1);
        }

        v9.removeAllViews();
        arg8.screen = v1;
        ComposeView v2 = new ComposeView(arg8, null, 0, 6, null);
        v9 = arg8.content;
        if(v9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v0);
        }
        else {
            FrameLayout v1_1 = v9;
        }

        ((FrameLayout)v1).addView(v2);
        v2.setContent(ComposableLambdaKt.composableLambdaInstance(0xBD2BACEF, true, new GoldenZayonVisualActivity$$ExternalSyntheticLambda3(arg8)));
        arg8.diagnosticView = v2;
    }

    static final Unit showSection$lambda$18$lambda$17$lambda$16(GoldenZayonVisualActivity arg6, Composer arg7, int arg8) {
        ComposerKt.sourceInformation(arg7, "C162@8148L122,162@8128L142:GoldenZayonVisualActivity.kt#8yhtom");
        boolean v0 = (arg8 & 3) != 2 ? true : false;
        if(arg7.shouldExecute(v0, arg8 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xBD2BACEF, arg8, -1, "com.TryJeanPc.goldenmouse.zayonvisual.GoldenZayonVisualActivity.showSection.<anonymous>.<anonymous>.<anonymous> (GoldenZayonVisualActivity.kt:162)");
            }

            ThemeKt.GoldenMouseProTheme(false, false, ComposableLambdaKt.rememberComposableLambda(-446051174, true, new GoldenZayonVisualActivity$$ExternalSyntheticLambda4(arg6), arg7, 54), arg7, 0x180, 3);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_36;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg7.skipToGroupEnd();
        }

    label_36:
        return Unit.INSTANCE;
    }

    static final Unit showSection$lambda$18$lambda$17$lambda$16$lambda$15(GoldenZayonVisualActivity arg4, Composer arg5, int arg6) {
        GoldenZayonVisualActivity$$ExternalSyntheticLambda5 v0_2;
        ComposerKt.sourceInformation(arg5, "C163@8218L25,163@8178L66:GoldenZayonVisualActivity.kt#8yhtom");
        boolean v0 = (arg6 & 3) != 2 ? true : false;
        if(arg5.shouldExecute(v0, arg6 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-446051174, arg6, -1, "com.TryJeanPc.goldenmouse.zayonvisual.GoldenZayonVisualActivity.showSection.<anonymous>.<anonymous>.<anonymous>.<anonymous> (GoldenZayonVisualActivity.kt:163)");
            }

            ComposerKt.sourceInformationMarkerStart(arg5, 0x322916F3, "CC(remember):GoldenZayonVisualActivity.kt#9igjgp");
            boolean v6 = arg5.changedInstance(arg4);
            Object v0_1 = arg5.rememberedValue();
            if((v6) || v0_1 == Composer.Companion.getEmpty()) {
                v0_2 = new GoldenZayonVisualActivity$$ExternalSyntheticLambda5(arg4);
                arg5.updateRememberedValue(v0_2);
            }

            ComposerKt.sourceInformationMarkerEnd(arg5);
            GoldenStretchDiagnosticsScreenKt.GoldenStretchDiagnosticsScreen(((Function0)v0_2), arg5, 0);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_37;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg5.skipToGroupEnd();
        }

    label_37:
        return Unit.INSTANCE;
    }

    static final Unit showSection$lambda$18$lambda$17$lambda$16$lambda$15$lambda$14$lambda$13(GoldenZayonVisualActivity arg1) {
        arg1.showSection(3);
        return Unit.INSTANCE;
    }

    static final void showSection$lambda$19(GoldenZayonVisualActivity arg2, View arg3) {
        arg2.startActivity(new Intent(arg2, GoldenGamePickerActivity.class));
    }

    static final void showSection$lambda$20(GoldenZayonVisualActivity arg0, View arg1) {
        arg0.openInputSettings();
    }

    static final void showSection$lambda$21(GoldenZayonVisualActivity arg0, View arg1) {
        arg0.showSection(1);
    }

    static final void showSection$lambda$7$lambda$6(GoldenZayonVisualActivity arg0, int arg1, View arg2) {
        arg0.method = arg1;
        arg0.showSection(1);
    }
}

