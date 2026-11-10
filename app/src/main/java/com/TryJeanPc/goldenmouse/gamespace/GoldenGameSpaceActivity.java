package com.TryJeanPc.goldenmouse.gamespace;

import android.app.AlertDialog$Builder;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager$LayoutParams;
import android.widget.Toast;
import androidx.activity.ComponentActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat$Type;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.TryJeanPc.goldenmouse.GameInfo;
import com.TryJeanPc.goldenmouse.R$id;
import com.TryJeanPc.goldenmouse.R$layout;
import com.TryJeanPc.goldenmouse.StartEvaluation;
import com.TryJeanPc.goldenmouse.activation.ActivationManager;
import com.TryJeanPc.goldenmouse.graphics.GraphicsRuntime;
import com.TryJeanPc.goldenmouse.graphicsui.GoldenGraphicsLoadingView;
import com.TryJeanPc.goldenmouse.graphicsui.GraphicsCenterActivity;
import com.TryJeanPc.goldenmouse.sharksettings.SharkSettingsActivity;
import com.TryJeanPc.goldenmouse.zayonvisual.GoldenZayonVisualActivity;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job$DefaultImpls;
import kotlinx.coroutines.Job;

@Metadata(d1={"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0011\u001A\u00020\u00122\b\u0010\u0013\u001A\u0004\u0018\u00010\u0014H\u0014J\n\u0010\u0015\u001A\u0004\u0018\u00010\u0016H\u0002J\b\u0010\u0017\u001A\u00020\u0012H\u0002J\u0010\u0010\u0018\u001A\u00020\u00122\u0006\u0010\u0019\u001A\u00020\u001AH\u0002J\u0010\u0010\u001B\u001A\u00020\u00122\u0006\u0010\u001C\u001A\u00020\u001DH\u0002J\b\u0010\u001E\u001A\u00020\u0012H\u0014J\b\u0010\u001F\u001A\u00020\u0012H\u0014J\b\u0010 \u001A\u00020\u0012H\u0014J\u0010\u0010!\u001A\u00020\u00122\u0006\u0010\"\u001A\u00020#H\u0016J\b\u0010$\u001A\u00020\u0012H\u0002R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001A\u0004\u0018\u00010\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001A\u0004\u0018\u00010\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001A\u0004\u0018\u00010\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000¨\u0006%"}, d2={"Lcom/TryJeanPc/goldenmouse/gamespace/GoldenGameSpaceActivity;", "Landroidx/activity/ComponentActivity;", "<init>", "()V", "scene", "Lcom/TryJeanPc/goldenmouse/gamespace/GoldenSpaceLayout;", "carouselSound", "Lcom/TryJeanPc/goldenmouse/gamespace/GoldenCarouselSound;", "refreshJob", "Lkotlinx/coroutines/Job;", "startJob", "carousel", "Landroidx/recyclerview/widget/RecyclerView;", "startDialog", "Landroid/app/AlertDialog;", "graphicsLoading", "Lcom/TryJeanPc/goldenmouse/graphicsui/GoldenGraphicsLoadingView;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "selectedGame", "Lcom/TryJeanPc/goldenmouse/GameInfo;", "startSelectedGame", "openSection", "section", "", "showStartRequirements", "requirements", "Lcom/TryJeanPc/goldenmouse/StartEvaluation;", "onResume", "onPause", "onDestroy", "onWindowFocusChanged", "hasFocus", "", "hideSystemBars", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GoldenGameSpaceActivity extends ComponentActivity {
    public static final int $stable = 8;
    private RecyclerView carousel;
    private GoldenCarouselSound carouselSound;
    private GoldenGraphicsLoadingView graphicsLoading;
    private Job refreshJob;
    private GoldenSpaceLayout scene;
    private AlertDialog startDialog;
    private Job startJob;

    static {
    }

    public GoldenGameSpaceActivity() {
        super();
    }

    public static final RecyclerView access$getCarousel$p(GoldenGameSpaceActivity arg0) {
        return arg0.carousel;
    }

    public static final GoldenGraphicsLoadingView access$getGraphicsLoading$p(GoldenGameSpaceActivity arg0) {
        return arg0.graphicsLoading;
    }

    public static final GoldenSpaceLayout access$getScene$p(GoldenGameSpaceActivity arg0) {
        return arg0.scene;
    }

    public static final AlertDialog access$getStartDialog$p(GoldenGameSpaceActivity arg0) {
        return arg0.startDialog;
    }

    public static final Job access$getStartJob$p(GoldenGameSpaceActivity arg0) {
        return arg0.startJob;
    }

    public static final void access$openSection(GoldenGameSpaceActivity arg0, int arg1) {
        arg0.openSection(arg1);
    }

    public static final GameInfo access$selectedGame(GoldenGameSpaceActivity arg0) {
        return arg0.selectedGame();
    }

    public static final void access$setStartJob$p(GoldenGameSpaceActivity arg0, Job arg1) {
        arg0.startJob = arg1;
    }

    public static final void access$showStartRequirements(GoldenGameSpaceActivity arg0, StartEvaluation arg1) {
        arg0.showStartRequirements(arg1);
    }

    private final void hideSystemBars() {
        WindowInsetsControllerCompat v1 = WindowCompat.getInsetsController(this.getWindow(), this.getWindow().getDecorView());
        v1.setSystemBarsBehavior(2);
        v1.hide(Type.systemBars());
    }

    protected void onCreate(Bundle arg9) {
        RecyclerView v9_4;
        GoldenSpaceLayout v9_3;
        super.onCreate(arg9);
        ActivationManager v9 = ActivationManager.INSTANCE;
        Context v0 = this.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(v0, "getApplicationContext(...)");
        v9.initialize(v0);
        WindowCompat.setDecorFitsSystemWindows(this.getWindow(), false);
        if(Build$VERSION.SDK_INT >= 28) {
            Window v9_1 = this.getWindow();
            WindowManager$LayoutParams v1 = this.getWindow().getAttributes();
            int v2 = Build$VERSION.SDK_INT >= 30 ? 3 : 1;
            v1.layoutInDisplayCutoutMode = v2;
            v9_1.setAttributes(v1);
        }

        this.setContentView(layout.golden_game_space);
        this.findViewById(id.gspace_shark_user).setOnClickListener(new GoldenGameSpaceActivity$$ExternalSyntheticLambda0(this));
        View v9_2 = this.findViewById(0x1020002).getChildAt(0);
        Intrinsics.checkNotNull(v9_2, "null cannot be cast to non-null type com.TryJeanPc.goldenmouse.gamespace.GoldenSpaceLayout");
        this.scene = ((GoldenSpaceLayout)v9_2);
        String v0_1 = "scene";
        Continuation v1_1 = null;
        if(v9_2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v0_1);
            v9_3 = ((GoldenSpaceLayout)v1_1);
        }

        ((GoldenSpaceLayout)v9_2).setOnAddGame(new GoldenGameSpaceActivity$$ExternalSyntheticLambda1(this));
        this.carouselSound = new GoldenCarouselSound(this);
        v9_3 = this.scene;
        if(v9_3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v0_1);
            v9_3 = ((GoldenSpaceLayout)v1_1);
        }

        v9_3.setOnSelectionChanged(new GoldenGameSpaceActivity$$ExternalSyntheticLambda2(this));
        v9_2 = this.findViewById(id.gspace_carousel);
        Intrinsics.checkNotNullExpressionValue(v9_2, "findViewById(...)");
        this.carousel = ((RecyclerView)v9_2);
        String v2_1 = "carousel";
        if(v9_2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v2_1);
            v9_4 = ((RecyclerView)v1_1);
        }

        ((RecyclerView)v9_2).addOnScrollListener(new GoldenGameSpaceActivity$onCreate$5(this));
        v9_4 = this.carousel;
        if(v9_4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v2_1);
            v9_4 = ((RecyclerView)v1_1);
        }

        LayoutManager v9_5 = v9_4.getLayoutManager();
        Intrinsics.checkNotNull(v9_5, "null cannot be cast to non-null type com.TryJeanPc.goldenmouse.gamespace.GoldenCarouselLayoutManager");
        ((GoldenCarouselLayoutManager)v9_5).setOnGameClick(new GoldenGameSpaceActivity$$ExternalSyntheticLambda3(this));
        v9_3 = this.scene;
        if(v9_3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v0_1);
            v9_3 = ((GoldenSpaceLayout)v1_1);
        }

        v9_3.setOnCompactGameClick(new GoldenGameSpaceActivity$$ExternalSyntheticLambda4(this));
        this.findViewById(id.gspace_fan).setOnClickListener(new GoldenGameSpaceActivity$$ExternalSyntheticLambda5(this));
        this.graphicsLoading = GoldenGraphicsLoadingView.Companion.attach(this);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new GoldenGameSpaceActivity$onCreate$9(this, v1_1), 3, null);
        GoldenSpaceLayout v8 = this.scene;
        if(v8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v0_1);
        }
        else {
            GoldenSpaceLayout v1_2 = v8;
        }

        ViewCompat.requestApplyInsets(((View)v1_1));
    }

    static final void onCreate$lambda$1(GoldenGameSpaceActivity arg2, View arg3) {
        arg2.startActivity(new Intent(arg2, SharkSettingsActivity.class));
    }

    static final Unit onCreate$lambda$2(GoldenGameSpaceActivity arg3) {
        arg3.startActivity(new Intent(arg3, GoldenGamePickerActivity.class));
        return Unit.INSTANCE;
    }

    static final Unit onCreate$lambda$3(GoldenGameSpaceActivity arg0) {
        GoldenCarouselSound v0 = arg0.carouselSound;
        if(v0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("carouselSound");
            v0 = null;
        }

        v0.play();
        return Unit.INSTANCE;
    }

    static final Unit onCreate$lambda$4(GoldenGameSpaceActivity arg0) {
        arg0.startSelectedGame();
        return Unit.INSTANCE;
    }

    static final Unit onCreate$lambda$5(GoldenGameSpaceActivity arg0) {
        arg0.startSelectedGame();
        return Unit.INSTANCE;
    }

    static final void onCreate$lambda$6(GoldenGameSpaceActivity arg3, View arg4) {
        Job v4 = arg3.refreshJob;
        if(v4 != null && (v4.isActive())) {
            return;
        }

        RecyclerView v4_1 = arg3.carousel;
        RecyclerView v0 = null;
        String v1 = "carousel";
        if(v4_1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v1);
            v4_1 = v0;
        }

        if(!v4_1.hasPendingAdapterUpdates()) {
            v4_1 = arg3.carousel;
            if(v4_1 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v1);
            }
            else {
                v0 = v4_1;
            }

            if(v0.getScrollState() != 0) {
                return;
            }

            GameInfo v4_2 = arg3.selectedGame();
            if(v4_2 == null) {
                Toast.makeText(((Context)arg3), "Selecciona un juego antes de optimizar", 0).show();
                return;
            }

            arg3.startActivity(new Intent(arg3, GraphicsCenterActivity.class).putExtra("graphics_game_package", v4_2.getPackageName()));
        }
    }

    protected void onDestroy() {
        GoldenCarouselSound v1_1;
        AlertDialog v0 = this.startDialog;
        if(v0 != null) {
            v0.dismiss();
        }

        GoldenSpaceLayout v0_1 = this.scene;
        Function0 v1 = null;
        if(v0_1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scene");
            v0_1 = ((GoldenSpaceLayout)v1);
        }

        v0_1.setOnSelectionChanged(v1);
        GoldenCarouselSound v0_2 = this.carouselSound;
        if(v0_2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("carouselSound");
        }
        else {
            v1_1 = v0_2;
        }

        v1_1.release();
        super.onDestroy();
    }

    protected void onPause() {
        Job v0 = this.startJob;
        CancellationException v2 = null;
        if(v0 != null) {
            DefaultImpls.cancel$default(v0, v2, 1, v2);
        }

        GoldenCarouselSound v0_1 = this.carouselSound;
        if(v0_1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("carouselSound");
            v0_1 = ((GoldenCarouselSound)v2);
        }

        v0_1.setActive(false);
        v0 = this.refreshJob;
        if(v0 != null) {
            DefaultImpls.cancel$default(v0, v2, 1, v2);
        }

        GoldenSpaceLayout v0_2 = this.scene;
        if(v0_2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scene");
        }
        else {
            GoldenSpaceLayout v2_1 = v0_2;
        }

        ((GoldenSpaceLayout)v2).setRunning(false);
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
        GraphicsRuntime v0 = GraphicsRuntime.INSTANCE;
        Context v1 = this.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(v1, "getApplicationContext(...)");
        v0.refresh(v1);
        GoldenCarouselSound v0_1 = this.carouselSound;
        Continuation v1_1 = null;
        if(v0_1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("carouselSound");
            v0_1 = ((GoldenCarouselSound)v1_1);
        }

        v0_1.setActive(true);
        GoldenSpaceLayout v0_2 = this.scene;
        if(v0_2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scene");
            v0_2 = ((GoldenSpaceLayout)v1_1);
        }

        v0_2.setRunning(true);
        this.hideSystemBars();
        this.refreshJob = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new GoldenGameSpaceActivity$onResume$1(this, v1_1), 3, null);
    }

    public void onWindowFocusChanged(boolean arg1) {
        super.onWindowFocusChanged(arg1);
        if(arg1) {
            this.hideSystemBars();
        }
    }

    private final void openSection(int arg4) {
        this.startActivity(new Intent(this, GoldenZayonVisualActivity.class).putExtra("golden_section", arg4).addFlags(0x24000000));
    }

    private final GameInfo selectedGame() {
        RecyclerView v0 = this.carousel;
        RecyclerView v1 = null;
        String v2 = "carousel";
        if(v0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v2);
            v0 = v1;
        }

        Adapter v0_1 = v0.getAdapter();
        Intrinsics.checkNotNull(v0_1, "null cannot be cast to non-null type com.TryJeanPc.goldenmouse.gamespace.GoldenGameAdapter");
        RecyclerView v4 = this.carousel;
        if(v4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v2);
        }
        else {
            v1 = v4;
        }

        LayoutManager v4_1 = v1.getLayoutManager();
        Intrinsics.checkNotNull(v4_1, "null cannot be cast to non-null type com.TryJeanPc.goldenmouse.gamespace.GoldenCarouselLayoutManager");
        return ((GoldenGameAdapter)v0_1).gameAt(((GoldenCarouselLayoutManager)v4_1).getSelectedPosition());
    }

    private final void showStartRequirements(StartEvaluation arg12) {
        AlertDialog$Builder v0 = new AlertDialog$Builder(this).setTitle("Requisitos pendientes").setMessage(CollectionsKt.joinToString$default(arg12.getExplanations(), "\n", null, null, 0, null, null, 62, null));
        String v1 = !arg12.getCoreActive() ? "Activar Golden Core" : "Aceptar";
        v0 = v0.setPositiveButton(((CharSequence)v1), new GoldenGameSpaceActivity$$ExternalSyntheticLambda6(arg12, this));
        if(!arg12.getBlockedRequirements().isEmpty()) {
            v0.setNeutralButton("Ver permisos", new GoldenGameSpaceActivity$$ExternalSyntheticLambda7(this));
        }

        AlertDialog v12 = v0.create();
        v12.setOnDismissListener(new GoldenGameSpaceActivity$$ExternalSyntheticLambda8(this));
        v12.show();
        this.startDialog = v12;
    }

    static final void showStartRequirements$lambda$10$lambda$9(GoldenGameSpaceActivity arg0, DialogInterface arg1) {
        arg0.startDialog = null;
    }

    static final void showStartRequirements$lambda$7(StartEvaluation arg0, GoldenGameSpaceActivity arg1, DialogInterface arg2, int arg3) {
        if(!arg0.getCoreActive()) {
            arg1.openSection(1);
        }
    }

    static final void showStartRequirements$lambda$8(GoldenGameSpaceActivity arg0, DialogInterface arg1, int arg2) {
        arg0.openSection(2);
    }

    private final void startSelectedGame() {
        Job v0 = this.startJob;
        if(v0 != null && (v0.isActive())) {
            return;
        }

        v0 = this.refreshJob;
        if(v0 != null && (v0.isActive())) {
            return;
        }

        RecyclerView v0_1 = this.carousel;
        String v2 = "carousel";
        Continuation v3 = null;
        if(v0_1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v2);
            v0_1 = ((RecyclerView)v3);
        }

        if(!v0_1.hasPendingAdapterUpdates() && (this.getLifecycle().getCurrentState().isAtLeast(State.RESUMED))) {
            AlertDialog v0_2 = this.startDialog;
            if(v0_2 != null && (v0_2.isShowing())) {
                return;
            }

            v0_1 = this.carousel;
            if(v0_1 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v2);
                v0_1 = ((RecyclerView)v3);
            }

            if(v0_1.getScrollState() == 0) {
                v0_1 = this.carousel;
                if(v0_1 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v2);
                    v0_1 = ((RecyclerView)v3);
                }

                LayoutManager v0_3 = v0_1.getLayoutManager();
                Intrinsics.checkNotNull(v0_3, "null cannot be cast to non-null type com.TryJeanPc.goldenmouse.gamespace.GoldenCarouselLayoutManager");
                if(((GoldenCarouselLayoutManager)v0_3).getEntrance() != 0f) {
                    goto label_65;
                }

                GameInfo v0_4 = this.selectedGame();
                if(v0_4 == null) {
                    Toast.makeText(((Context)this), "Selecciona un juego antes de iniciar", 0).show();
                    return;
                }

                this.startJob = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new GoldenGameSpaceActivity$startSelectedGame$1(this, v0_4, v3), 3, null);
                return;
            }

        label_65:
            Toast.makeText(((Context)this), "Espera a que termine de girar el carrusel", 0).show();
        }
    }
}

