package com.TryJeanPc.goldenmouse.cursor;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Property;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout$LayoutParams;
import android.widget.GridLayout;
import android.widget.Toast;
import androidx.activity.ComponentActivity;
import com.TryJeanPc.goldenmouse.R$id;
import com.TryJeanPc.goldenmouse.R$layout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job$DefaultImpls;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

@Metadata(d1={"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001D\u001A\u00020\u001A2\b\u0010\u001E\u001A\u0004\u0018\u00010\u001FH\u0014J\b\u0010 \u001A\u00020\u001AH\u0002J\u0010\u0010!\u001A\u00020\u001A2\u0006\u0010\"\u001A\u00020\fH\u0002J\u001C\u0010#\u001A\u000E\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%0$2\u0006\u0010&\u001A\u00020\u0010H\u0002J\u0010\u0010\'\u001A\u00020\u001A2\u0006\u0010(\u001A\u00020\u0007H\u0002J\b\u0010)\u001A\u00020\u001AH\u0016J\u0010\u0010*\u001A\u00020\u00072\u0006\u0010+\u001A\u00020,H\u0016J\b\u0010-\u001A\u00020\u001AH\u0002J\b\u0010.\u001A\u00020\u001AH\u0002J\"\u0010/\u001A\u00020\u001A2\u0006\u00100\u001A\u0002012\u0006\u00102\u001A\u0002012\b\u00103\u001A\u0004\u0018\u000104H\u0015J2\u00105\u001A\u00020\u001A2\b\b\u0002\u00106\u001A\u00020\u00072\u0010\b\u0002\u00107\u001A\n\u0012\u0004\u0012\u00020\u001A\u0018\u00010\u00192\f\u00108\u001A\b\u0012\u0004\u0012\u00020\u001A0\u0019H\u0002J\u0010\u00109\u001A\u00020\u001A2\u0006\u0010:\u001A\u00020\u001FH\u0014J\b\u0010;\u001A\u00020\u001AH\u0014R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001A\u0004\u0018\u00010\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u000B\u001A\u0004\u0018\u00010\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u000EX\u0082.¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00100\u0012X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001A\u0004\u0018\u00010\u0014X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0016\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001A\u0004\u0018\u00010\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001A\n\u0012\u0004\u0012\u00020\u001A\u0018\u00010\u0019X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u001B\u001A\u0004\u0018\u00010\u0014X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u001C\u001A\u0004\u0018\u00010\nX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006<"}, d2={"Lcom/TryJeanPc/goldenmouse/cursor/CursorImagePickerActivity;", "Landroidx/activity/ComponentActivity;", "<init>", "()V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "waitingForPicker", "", "busy", "galleryJob", "Lkotlinx/coroutines/Job;", "activeId", "", "grid", "Landroid/widget/GridLayout;", "galleryWindow", "Landroid/view/View;", "cornerViews", "", "galleryAnimation", "Landroid/animation/AnimatorSet;", "closingGallery", "closeCompleted", "deleteConfirmation", "deleteCloseAction", "Lkotlin/Function0;", "", "deleteAnimation", "deletePreviewJob", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "refreshGallery", "confirmDelete", "id", "desplazamientoEsquina", "Lkotlin/Pair;", "", "view", "animarGaleria", "entrada", "finish", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "terminarGaleria", "openPicker", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "saveSelection", "closeAfter", "onComplete", "save", "onSaveInstanceState", "outState", "onDestroy", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class CursorImagePickerActivity extends ComponentActivity {
    public static final int $stable = 8;
    private String activeId;
    private boolean busy;
    private boolean closeCompleted;
    private boolean closingGallery;
    private List cornerViews;
    private AnimatorSet deleteAnimation;
    private Function0 deleteCloseAction;
    private View deleteConfirmation;
    private Job deletePreviewJob;
    private AnimatorSet galleryAnimation;
    private Job galleryJob;
    private View galleryWindow;
    private GridLayout grid;
    private final CoroutineScope scope;
    private boolean waitingForPicker;

    static {
    }

    public CursorImagePickerActivity() {
        super();
        this.scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain()));
        this.cornerViews = CollectionsKt.emptyList();
    }

    public static final void access$confirmDelete(CursorImagePickerActivity arg0, String arg1) {
        arg0.confirmDelete(arg1);
    }

    public static final String access$getActiveId$p(CursorImagePickerActivity arg0) {
        return arg0.activeId;
    }

    public static final boolean access$getBusy$p(CursorImagePickerActivity arg0) {
        return arg0.busy;
    }

    public static final View access$getDeleteConfirmation$p(CursorImagePickerActivity arg0) {
        return arg0.deleteConfirmation;
    }

    public static final AnimatorSet access$getGalleryAnimation$p(CursorImagePickerActivity arg0) {
        return arg0.galleryAnimation;
    }

    public static final GridLayout access$getGrid$p(CursorImagePickerActivity arg0) {
        return arg0.grid;
    }

    public static final void access$refreshGallery(CursorImagePickerActivity arg0) {
        arg0.refreshGallery();
    }

    public static final void access$setActiveId$p(CursorImagePickerActivity arg0, String arg1) {
        arg0.activeId = arg1;
    }

    public static final void access$setBusy$p(CursorImagePickerActivity arg0, boolean arg1) {
        arg0.busy = arg1;
    }

    public static final void access$setGalleryAnimation$p(CursorImagePickerActivity arg0, AnimatorSet arg1) {
        arg0.galleryAnimation = arg1;
    }

    public static final void access$terminarGaleria(CursorImagePickerActivity arg0) {
        arg0.terminarGaleria();
    }

    private final void animarGaleria(boolean arg13) {
        DecelerateInterpolator v1_4;
        Object v4_1;
        AnimatorSet v0 = this.galleryAnimation;
        if(v0 != null) {
            v0.cancel();
        }

        float v0_1 = 1f;
        float v1 = arg13 ? v0_1 : 0.9f;
        if(arg13) {
        }
        else {
            v0_1 = 0f;
        }

        Animator[] v3 = new Animator[3];
        View v4 = this.galleryWindow;
        Object v5 = null;
        String v6 = "galleryWindow";
        if(v4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v6);
            v4_1 = v5;
        }

        ObjectAnimator v4_2 = ObjectAnimator.ofFloat(v4_1, View.SCALE_X, new float[]{v1});
        String v7 = "ofFloat(...)";
        Intrinsics.checkNotNullExpressionValue(v4_2, v7);
        v3[0] = ((Animator)v4_2);
        v4 = this.galleryWindow;
        if(v4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v6);
            v4_1 = v5;
        }

        ObjectAnimator v1_1 = ObjectAnimator.ofFloat(v4_1, View.SCALE_Y, new float[]{v1});
        Intrinsics.checkNotNullExpressionValue(v1_1, v7);
        v3[1] = ((Animator)v1_1);
        View v1_2 = this.galleryWindow;
        if(v1_2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v6);
        }
        else {
            View v5_1 = v1_2;
        }

        v1_1 = ObjectAnimator.ofFloat(v5, View.ALPHA, new float[]{v0_1});
        Intrinsics.checkNotNullExpressionValue(v1_1, v7);
        v3[2] = ((Animator)v1_1);
        List v1_3 = CollectionsKt.mutableListOf(((Object[])v3));
        Iterator v3_1 = this.cornerViews.iterator();
        while(v3_1.hasNext()) {
            v4_1 = v3_1.next();
            Pair v5_2 = this.desplazamientoEsquina(((View)v4_1));
            float v6_1 = v5_2.component1().floatValue();
            float v5_3 = v5_2.component2().floatValue();
            List v7_1 = v1_3;
            Property v9 = View.TRANSLATION_X;
            if(arg13) {
                v6_1 = 0f;
            }

            ((Collection)v7_1).add(ObjectAnimator.ofFloat(v4_1, v9, new float[]{v6_1}));
            Property v6_2 = View.TRANSLATION_Y;
            if(arg13) {
                v5_3 = 0f;
            }

            ((Collection)v7_1).add(ObjectAnimator.ofFloat(v4_1, v6_2, new float[]{v5_3}));
            ((Collection)v7_1).add(ObjectAnimator.ofFloat(v4_1, View.ALPHA, new float[]{v0_1}));
        }

        v0 = new AnimatorSet();
        v0.playTogether(((Collection)v1_3));
        v0.setDuration(0xF0);
        if(arg13) {
            v1_4 = new DecelerateInterpolator();
        }
        else {
            AccelerateInterpolator v1_5 = new AccelerateInterpolator();
        }

        v0.setInterpolator(((TimeInterpolator)v1_4));
        v0.addListener(new CursorImagePickerActivity$animarGaleria$animation$1$1(this, arg13));
        this.galleryAnimation = v0;
        v0.start();
    }

    private final void confirmDelete(String arg17) {
        CursorImagePickerActivity v2 = this;
        String v8 = arg17;
        if(Intrinsics.areEqual(v8, v2.activeId)) {
            Toast.makeText(v2, "Selecciona otro cursor o restablece el predeterminado antes de eliminar el activo", 1).show();
            return;
        }

        if(v2.deleteConfirmation == null && !v2.busy) {
            if(v2.closingGallery) {
            }
            else {
                View v0 = v2.galleryWindow;
                if(v0 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("galleryWindow");
                    v0 = null;
                }

                ViewParent v0_1 = v0.getParent();
                Intrinsics.checkNotNull(v0_1, "null cannot be cast to non-null type android.view.ViewGroup");
                ViewParent v6 = v0_1;
                View v3 = v2.getLayoutInflater().inflate(layout.cursor_delete, ((ViewGroup)v6), false);
                View v7 = v3.findViewById(id.ventanaEliminarImagen);
                View v4 = v3.findViewById(id.btnCancelarEliminar);
                View v5 = v3.findViewById(id.btnConfirmarEliminar);
                View v9 = v3.findViewById(id.imgImagenEliminar);
                BooleanRef v0_2 = new BooleanRef();
                v3.setClickable(true);
                v7.setAlpha(0f);
                v7.setScaleX(0.9f);
                v7.setScaleY(0.9f);
                v2.deleteConfirmation = v3;
                ((ViewGroup)v6).addView(v3);
                v2.deleteCloseAction = new CursorImagePickerActivity$$ExternalSyntheticLambda5(v0_2, v2, v3, v4, v5, ((ViewGroup)v6), v7);
                v4.setOnClickListener(new CursorImagePickerActivity$$ExternalSyntheticLambda6(v0_2, v2, v3, v4, v5, ((ViewGroup)v6), v7));
                v5.setOnClickListener(new CursorImagePickerActivity$$ExternalSyntheticLambda7(v0_2, this, v4, v5, v3, ((ViewGroup)v6), v7, v8));
                v3.post(new CursorImagePickerActivity$$ExternalSyntheticLambda8(v0_2, this, v7));
                this.deletePreviewJob = BuildersKt.launch$default(this.scope, null, null, new CursorImagePickerActivity$confirmDelete$5(v0_2, this, v3, v9, arg17, null), 3, null);
            }
        }
    }

    private static final void confirmDelete$animatePanel(CursorImagePickerActivity arg9, View arg10, boolean arg11, Function0 arg12) {
        AccelerateInterpolator v10_1;
        AnimatorSet v0 = arg9.deleteAnimation;
        if(v0 != null) {
            v0.cancel();
        }

        v0 = new AnimatorSet();
        Animator[] v1 = new Animator[3];
        Property v2 = View.SCALE_X;
        float v3 = 0.9f;
        float v4 = 1f;
        float v5 = arg11 ? v4 : v3;
        v1[0] = ObjectAnimator.ofFloat(arg10, v2, new float[]{v5});
        v2 = View.SCALE_Y;
        if(arg11) {
            v3 = v4;
        }

        v1[1] = ObjectAnimator.ofFloat(arg10, v2, new float[]{v3});
        v2 = View.ALPHA;
        if(arg11) {
        }
        else {
            v4 = 0f;
        }

        v1[2] = ObjectAnimator.ofFloat(arg10, v2, new float[]{v4});
        v0.playTogether(v1);
        v0.setDuration(0xF0);
        if(arg11) {
            DecelerateInterpolator v10 = new DecelerateInterpolator();
        }
        else {
            v10_1 = new AccelerateInterpolator();
        }

        v0.setInterpolator(((TimeInterpolator)v10_1));
        if(arg12 != null) {
            v0.addListener(new CursorImagePickerActivity$confirmDelete$animatePanel$1$1(arg12));
        }

        v0.start();
        arg9.deleteAnimation = v0;
    }

    static void confirmDelete$animatePanel$default(CursorImagePickerActivity arg0, View arg1, boolean arg2, Function0 arg3, int arg4, Object arg5) {
        if((arg4 & 8) != 0) {
            arg3 = null;
        }

        CursorImagePickerActivity.confirmDelete$animatePanel(arg0, arg1, arg2, arg3);
    }

    private static final void confirmDelete$closeConfirmation(BooleanRef arg1, CursorImagePickerActivity arg2, View arg3, View arg4, View arg5, ViewGroup arg6, View arg7) {
        if(!arg1.element) {
            if(arg2.deleteConfirmation != arg3) {
            }
            else {
                arg1.element = true;
                arg4.setEnabled(false);
                arg5.setEnabled(false);
                Job v4 = arg2.deletePreviewJob;
                if(v4 != null) {
                    DefaultImpls.cancel$default(v4, null, 1, null);
                }

                CursorImagePickerActivity.confirmDelete$animatePanel(arg2, arg7, false, new CursorImagePickerActivity$$ExternalSyntheticLambda9(arg6, arg3, arg2));
            }
        }
    }

    static final Unit confirmDelete$closeConfirmation$lambda$11(ViewGroup arg0, View arg1, CursorImagePickerActivity arg2) {
        arg0.removeView(arg1);
        if(arg2.deleteConfirmation == arg1) {
            arg2.deleteConfirmation = null;
            arg2.deleteCloseAction = null;
            arg2.deleteAnimation = null;
        }

        return Unit.INSTANCE;
    }

    static final Unit confirmDelete$lambda$12(BooleanRef arg0, CursorImagePickerActivity arg1, View arg2, View arg3, View arg4, ViewGroup arg5, View arg6) {
        CursorImagePickerActivity.confirmDelete$closeConfirmation(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
        return Unit.INSTANCE;
    }

    static final void confirmDelete$lambda$13(BooleanRef arg0, CursorImagePickerActivity arg1, View arg2, View arg3, View arg4, ViewGroup arg5, View arg6, View arg7) {
        CursorImagePickerActivity.confirmDelete$closeConfirmation(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }

    static final void confirmDelete$lambda$16(BooleanRef arg9, CursorImagePickerActivity arg10, View arg11, View arg12, View arg13, ViewGroup arg14, View arg15, String arg16, View arg17) {
        if(!arg9.element && !arg10.busy) {
            arg11.setEnabled(false);
            arg12.setEnabled(false);
            arg10.saveSelection(false, new CursorImagePickerActivity$$ExternalSyntheticLambda3(arg9, arg10, arg13, arg11, arg12, arg14, arg15), new CursorImagePickerActivity$$ExternalSyntheticLambda4(arg10, arg16));
        }
    }

    static final Unit confirmDelete$lambda$16$lambda$14(BooleanRef arg0, CursorImagePickerActivity arg1, View arg2, View arg3, View arg4, ViewGroup arg5, View arg6) {
        CursorImagePickerActivity.confirmDelete$closeConfirmation(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
        return Unit.INSTANCE;
    }

    static final Unit confirmDelete$lambda$16$lambda$15(CursorImagePickerActivity arg2, String arg3) {
        CursorImageStore v0 = CursorImageStore.INSTANCE;
        Context v2 = arg2.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(v2, "getApplicationContext(...)");
        v0.deleteImage(v2, arg3);
        return Unit.INSTANCE;
    }

    static final void confirmDelete$lambda$17(BooleanRef arg6, CursorImagePickerActivity arg7, View arg8) {
        if(!arg6.element && !arg7.isDestroyed()) {
            CursorImagePickerActivity.confirmDelete$animatePanel$default(arg7, arg8, true, null, 8, null);
        }
    }

    private final Pair desplazamientoEsquina(View arg5) {
        ViewGroup$LayoutParams v4 = arg5.getLayoutParams();
        Intrinsics.checkNotNull(v4, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        int v4_1 = Gravity.getAbsoluteGravity(((FrameLayout$LayoutParams)v4).gravity, arg5.getLayoutDirection());
        int v2 = 1;
        int v0 = (v4_1 & 7) == 3 ? 1 : 0;
        if((v4_1 & 0x70) == 0x30) {
        }
        else {
            v2 = 0;
        }

        float v4_2 = ((float)arg5.getWidth());
        if(v0 != 0) {
            v4_2 = -v4_2;
        }

        Float v4_3 = Float.valueOf(v4_2);
        float v5 = ((float)arg5.getHeight());
        if(v2 != 0) {
            v5 = -v5;
        }

        return TuplesKt.to(v4_3, Float.valueOf(v5));
    }

    public boolean dispatchTouchEvent(MotionEvent arg2) {
        Intrinsics.checkNotNullParameter(arg2, "event");
        if(this.closingGallery) {
            return 1;
        }

        return super.dispatchTouchEvent(arg2);
    }

    public void finish() {
        if(this.deleteConfirmation != null) {
            Function0 v2 = this.deleteCloseAction;
            if(v2 != null) {
                v2.invoke();
                return;
            }
        }
        else if(!this.closingGallery && !this.isFinishing()) {
            if(this.isDestroyed()) {
            }
            else {
                this.closingGallery = true;
                View v0 = this.galleryWindow;
                if(v0 != null) {
                    if(v0 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("galleryWindow");
                        v0 = null;
                    }

                    if(!v0.isAttachedToWindow()) {
                        goto label_30;
                    }

                    this.findViewById(id.btnCancelarGaleria).setEnabled(false);
                    this.animarGaleria(false);
                    return;
                }

            label_30:
                this.terminarGaleria();
            }
        }
    }

    @Deprecated(message="Uses the platform activity result API") protected void onActivityResult(int arg7, int arg8, Intent arg9) {
        super.onActivityResult(arg7, arg8, arg9);
        if(arg7 != 1) {
            return;
        }

        this.waitingForPicker = false;
        if(arg8 != -1) {
            this.finish();
            return;
        }

        Uri v7 = arg9 != null ? arg9.getData() : null;
        if(v7 == null) {
            Toast.makeText(this, "El selector no devolvió una imagen", 1).show();
            this.finish();
            return;
        }

        CursorImagePickerActivity.saveSelection$default(this, false, null, new CursorImagePickerActivity$$ExternalSyntheticLambda2(this, v7), 3, null);
    }

    static final Unit onActivityResult$lambda$21(CursorImagePickerActivity arg2, Uri arg3) {
        CursorImageStore v0 = CursorImageStore.INSTANCE;
        Context v2 = arg2.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(v2, "getApplicationContext(...)");
        v0.importImage(v2, arg3);
        return Unit.INSTANCE;
    }

    protected void onCreate(Bundle arg9) {
        super.onCreate(arg9);
        boolean v9 = arg9 != null ? arg9.getBoolean("waiting") : false;
        this.waitingForPicker = v9;
        this.setContentView(layout.cursor_gallery);
        this.overridePendingTransition(0, 0);
        View v9_1 = this.findViewById(id.ventanaGaleria);
        String v1 = "findViewById(...)";
        Intrinsics.checkNotNullExpressionValue(v9_1, v1);
        this.galleryWindow = v9_1;
        String v2 = "galleryWindow";
        GridLayout v3 = null;
        if(v9_1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v2);
            v9_1 = ((View)v3);
        }

        ViewParent v9_2 = v9_1.getParent();
        Intrinsics.checkNotNull(v9_2, "null cannot be cast to non-null type android.view.ViewGroup");
        IntRange v0 = RangesKt.until(0, ((ViewGroup)v9_2).getChildCount());
        ArrayList v4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v0), 10));
        Iterator v0_1 = ((Iterable)v0).iterator();
        while(v0_1.hasNext()) {
            ((Collection)v4).add(((ViewGroup)v9_2).getChildAt(v0_1.nextInt()));
        }

        ArrayList v0_2 = new ArrayList();
        Iterator v4_1 = ((Iterable)v4).iterator();
        while(v4_1.hasNext()) {
            Object v5 = v4_1.next();
            Object v6 = v5;
            View v7 = this.galleryWindow;
            if(v7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v2);
                Object v7_1 = v3;
            }

            if(v6 == v7_1) {
                continue;
            }

            ((Collection)v0_2).add(v5);
        }

        this.cornerViews = ((List)v0_2);
        View v0_3 = this.galleryWindow;
        if(v0_3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v2);
            v0_3 = ((View)v3);
        }

        v0_3.setAlpha(0f);
        v0_3 = this.galleryWindow;
        if(v0_3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v2);
            v0_3 = ((View)v3);
        }

        float v5_1 = 0.9f;
        v0_3.setScaleX(v5_1);
        v0_3 = this.galleryWindow;
        if(v0_3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v2);
            v0_3 = ((View)v3);
        }

        v0_3.setScaleY(v5_1);
        v0_1 = this.cornerViews.iterator();
        while(v0_1.hasNext()) {
            v0_1.next().setAlpha(0f);
        }

        ((ViewGroup)v9_2).post(new CursorImagePickerActivity$$ExternalSyntheticLambda10(this));
        this.getOnBackPressedDispatcher().addCallback(this, new CursorImagePickerActivity$onCreate$5(this));
        v9_1 = this.findViewById(id.gridImagenes);
        Intrinsics.checkNotNullExpressionValue(v9_1, v1);
        this.grid = ((GridLayout)v9_1);
        this.findViewById(id.btnAgregarImagen).setOnClickListener(new CursorImagePickerActivity$$ExternalSyntheticLambda11(this));
        this.findViewById(id.btnRestaurarPredeterminado).setOnClickListener(new CursorImagePickerActivity$$ExternalSyntheticLambda12(this));
        this.findViewById(id.btnCancelarGaleria).setOnClickListener(new CursorImagePickerActivity$$ExternalSyntheticLambda13(this));
        GridLayout v9_3 = this.grid;
        if(v9_3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("grid");
        }
        else {
            v3 = v9_3;
        }

        v3.post(new CursorImagePickerActivity$$ExternalSyntheticLambda1(this));
    }

    static final void onCreate$lambda$4(CursorImagePickerActivity arg4) {
        if(!arg4.closingGallery && !arg4.isDestroyed()) {
            Iterator v0 = arg4.cornerViews.iterator();
            while(v0.hasNext()) {
                Object v1 = v0.next();
                Pair v2 = arg4.desplazamientoEsquina(((View)v1));
                float v3 = v2.component1().floatValue();
                float v2_1 = v2.component2().floatValue();
                ((View)v1).setTranslationX(v3);
                ((View)v1).setTranslationY(v2_1);
            }

            arg4.animarGaleria(true);
        }
    }

    static final void onCreate$lambda$5(CursorImagePickerActivity arg0, View arg1) {
        if(!arg0.busy) {
            arg0.openPicker();
        }
    }

    static final void onCreate$lambda$7(CursorImagePickerActivity arg6, View arg7) {
        if(!arg6.busy) {
            CursorImagePickerActivity.saveSelection$default(arg6, false, null, new CursorImagePickerActivity$$ExternalSyntheticLambda0(arg6), 3, null);
        }
    }

    static final Unit onCreate$lambda$7$lambda$6(CursorImagePickerActivity arg2) {
        CursorImageStore v0 = CursorImageStore.INSTANCE;
        Context v2 = arg2.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(v2, "getApplicationContext(...)");
        v0.restoreDefault(v2);
        return Unit.INSTANCE;
    }

    static final void onCreate$lambda$8(CursorImagePickerActivity arg0, View arg1) {
        arg0.finish();
    }

    static final void onCreate$lambda$9(CursorImagePickerActivity arg0) {
        arg0.refreshGallery();
    }

    protected void onDestroy() {
        Job v0 = this.deletePreviewJob;
        CancellationException v2 = null;
        if(v0 != null) {
            DefaultImpls.cancel$default(v0, v2, 1, v2);
        }

        AnimatorSet v0_1 = this.deleteAnimation;
        if(v0_1 != null) {
            v0_1.cancel();
        }

        View v0_2 = this.deleteConfirmation;
        if(v0_2 != null) {
            ViewParent v3 = v0_2.getParent();
            if((v3 instanceof ViewGroup)) {
            }
            else {
                v3 = ((ViewParent)v2);
            }

            if(v3 == null) {
                goto label_17;
            }

            ((ViewGroup)v3).removeView(v0_2);
        }

    label_17:
        this.deleteConfirmation = ((View)v2);
        this.deleteCloseAction = ((Function0)v2);
        this.deleteAnimation = ((AnimatorSet)v2);
        v0_1 = this.galleryAnimation;
        if(v0_1 != null) {
            v0_1.cancel();
        }

        this.galleryAnimation = ((AnimatorSet)v2);
        if((this.isFinishing()) && !this.isChangingConfigurations()) {
            this.sendBroadcast(new Intent("com.TryJeanPc.goldenmouse.CURSOR_PICKER_FINISHED").setPackage(this.getPackageName()));
        }

        CoroutineScopeKt.cancel$default(this.scope, v2, 1, v2);
        super.onDestroy();
    }

    protected void onSaveInstanceState(Bundle arg3) {
        Intrinsics.checkNotNullParameter(arg3, "outState");
        arg3.putBoolean("waiting", this.waitingForPicker);
        super.onSaveInstanceState(arg3);
    }

    private final void openPicker() {
        try {
            this.waitingForPicker = true;
            Intent v1 = new Intent("android.intent.action.OPEN_DOCUMENT");
            v1.addCategory("android.intent.category.OPENABLE");
            v1.setType("image/*");
            v1.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/png", "image/jpeg"});
            v1.addFlags(1);
            this.startActivityForResult(v1, 1);
            return;
        }
        catch(Exception ) {
            Toast.makeText(this, "No se pudo abrir el selector de imágenes", 1).show();
            this.finish();
            return;
        }
    }

    private final void refreshGallery() {
        Job v0 = this.galleryJob;
        CancellationException v1 = null;
        if(v0 != null) {
            DefaultImpls.cancel$default(v0, v1, 1, v1);
        }

        this.galleryJob = BuildersKt.launch$default(this.scope, null, null, new CursorImagePickerActivity$refreshGallery$1(this, ((Continuation)v1)), 3, null);
    }

    private final void saveSelection(boolean arg10, Function0 arg11, Function0 arg12) {
        if(this.busy) {
            return;
        }

        this.busy = true;
        Job v1 = this.galleryJob;
        if(v1 != null) {
            DefaultImpls.cancel$default(v1, null, 1, null);
        }

        this.findViewById(id.btnAgregarImagen).setEnabled(false);
        this.findViewById(id.btnRestaurarPredeterminado).setEnabled(false);
        BuildersKt.launch$default(this.scope, null, null, new CursorImagePickerActivity$saveSelection$1(this, arg10, arg11, arg12, null), 3, null);
    }

    static void saveSelection$default(CursorImagePickerActivity arg0, boolean arg1, Function0 arg2, Function0 arg3, int arg4, Object arg5) {
        if((arg4 & 2) != 0) {
            arg2 = null;
        }

        arg0.saveSelection(true, arg2, arg3);
    }

    private final void terminarGaleria() {
        if(this.closeCompleted) {
            return;
        }

        this.closeCompleted = true;
        if(this.isTaskRoot()) {
            this.finishAndRemoveTask();
        }
        else {
            super.finish();
        }

        this.overridePendingTransition(0, 0);
    }
}

