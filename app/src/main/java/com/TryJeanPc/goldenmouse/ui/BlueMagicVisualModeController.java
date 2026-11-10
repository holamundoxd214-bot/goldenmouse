package com.TryJeanPc.goldenmouse.ui;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.view.View$OnAttachStateChangeListener;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import com.TryJeanPc.goldenmouse.CpuIndicatorView;
import com.TryJeanPc.goldenmouse.R$id;
import com.TryJeanPc.goldenmouse.RamIndicatorView;
import com.google.android.material.card.MaterialCardView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\b\u0001\u0018\u0000 62\u00020\u0001:\u00016B%\b\u0007\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010&\u001A\u00020$2\u0006\u0010\'\u001A\u00020(H\u0002J\b\u0010)\u001A\u00020*H\u0002J\u0006\u0010+\u001A\u00020*J\u0006\u0010,\u001A\u00020*J\b\u0010-\u001A\u00020*H\u0002J\b\u0010.\u001A\u00020*H\u0002J(\u0010/\u001A\u00020*2\u0006\u00100\u001A\u0002012\u0006\u00102\u001A\u0002032\u0006\u00104\u001A\u0002032\u0006\u00105\u001A\u000201H\u0002R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001A\n \u000B*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001A\n \u000B*\u0004\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000E\u001A\n \u000B*\u0004\u0018\u00010\u000F0\u000FX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001A\n \u000B*\u0004\u0018\u00010\u00110\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u00030\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\r0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u00160\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001A\n \u000B*\u0004\u0018\u00010\u00180\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001A\n \u000B*\u0004\u0018\u00010\u001A0\u001AX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001B\u001A\u00020\u001CX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u001D\u001A\u0004\u0018\u00010\u001EX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u001F\u001A\u0004\u0018\u00010 X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010!\u001A\u0004\u0018\u00010 X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001A\u0004\u0018\u00010 X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010#\u001A\u00020$X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010%\u001A\u00020$X\u0082\u000E¢\u0006\u0002\n\u0000¨\u00067"}, d2={"Lcom/TryJeanPc/goldenmouse/ui/BlueMagicVisualModeController;", "", "root", "Landroid/view/View;", "preferences", "Landroid/content/SharedPreferences;", "animationOptions", "Lcom/TryJeanPc/goldenmouse/ui/DecorativeAnimationPreferences;", "<init>", "(Landroid/view/View;Landroid/content/SharedPreferences;Lcom/TryJeanPc/goldenmouse/ui/DecorativeAnimationPreferences;)V", "button", "kotlin.jvm.PlatformType", "text", "Landroid/widget/TextView;", "selector", "Lcom/TryJeanPc/goldenmouse/ui/GoldenModeSelectorView;", "notificationButton", "Lcom/TryJeanPc/goldenmouse/ui/GoldenNotificationModeButton;", "backgrounds", "", "labels", "cards", "Lcom/google/android/material/card/MaterialCardView;", "cpu", "Lcom/TryJeanPc/goldenmouse/CpuIndicatorView;", "ram", "Lcom/TryJeanPc/goldenmouse/RamIndicatorView;", "mode", "Lcom/TryJeanPc/goldenmouse/ui/BlueMagicVisualMode;", "transition", "Landroid/animation/AnimatorSet;", "movementAnimator", "Landroid/animation/ValueAnimator;", "colorAnimator", "sweepAnimator", "cpuSweepEnabled", "", "ramSweepEnabled", "enabled", "effect", "Lcom/TryJeanPc/goldenmouse/ui/DecorativeEffect;", "selectNext", "", "updateAnimationOptions", "cancelAnimation", "restoreSelector", "restoreClosedSelector", "applyTheme", "color", "", "fill", "", "glow", "cardColor", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class BlueMagicVisualModeController {
    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2={"Lcom/TryJeanPc/goldenmouse/ui/BlueMagicVisualModeController$Companion;", "", "<init>", "()V", "PREFERENCES", "", "SELECTED_MODE", "INACTIVE_CARD_COLOR", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final int INACTIVE_CARD_COLOR = -870834658;
    public static final String PREFERENCES = "blue_magic_visual_mode";
    public static final String SELECTED_MODE = "selected_mode";
    private final DecorativeAnimationPreferences animationOptions;
    private final List backgrounds;
    private final View button;
    private final List cards;
    private ValueAnimator colorAnimator;
    private final CpuIndicatorView cpu;
    private boolean cpuSweepEnabled;
    private final List labels;
    private BlueMagicVisualMode mode;
    private ValueAnimator movementAnimator;
    private final GoldenNotificationModeButton notificationButton;
    private final SharedPreferences preferences;
    private final RamIndicatorView ram;
    private boolean ramSweepEnabled;
    private final GoldenModeSelectorView selector;
    private ValueAnimator sweepAnimator;
    private final TextView text;
    private AnimatorSet transition;

    static {
        BlueMagicVisualModeController.Companion = new Companion(null);
        BlueMagicVisualModeController.$stable = 8;
    }

    public BlueMagicVisualModeController(View arg7, SharedPreferences arg8, DecorativeAnimationPreferences arg9) {
        View v5;
        Intrinsics.checkNotNullParameter(arg7, "root");
        Intrinsics.checkNotNullParameter(arg8, "preferences");
        super();
        this.preferences = arg8;
        this.animationOptions = arg9;
        this.button = arg7.findViewById(id.btnSwitchMode);
        this.text = arg7.findViewById(id.txtModeSwitch);
        this.selector = arg7.findViewById(id.bgModeShapeLeft);
        this.notificationButton = arg7.findViewById(id.btnSwitchNotificationMode);
        int v8 = 4;
        Integer[] v9 = new Integer[v8];
        v9[0] = Integer.valueOf(id.bgCircleCpuCountTop);
        v9[1] = Integer.valueOf(id.bgCircleCpuCountBottom);
        int v3 = 2;
        v9[v3] = Integer.valueOf(id.bgCircleRamCountTop);
        int v4 = 3;
        v9[v4] = Integer.valueOf(id.bgCircleRamCountBottom);
        List v9_1 = CollectionsKt.listOf(((Object[])v9));
        ArrayList v0 = new ArrayList();
        Iterator v9_2 = ((Iterable)v9_1).iterator();
        while(v9_2.hasNext()) {
            v5 = arg7.findViewById(v9_2.next().intValue());
            if(v5 == null) {
                continue;
            }

            ((Collection)v0).add(v5);
        }

        this.backgrounds = ((List)v0);
        v9 = new Integer[v3];
        v9[0] = Integer.valueOf(id.txtLabelCPU);
        v9[1] = Integer.valueOf(id.txtLabelRAM);
        v9_1 = CollectionsKt.listOf(((Object[])v9));
        v0 = new ArrayList();
        v9_2 = ((Iterable)v9_1).iterator();
        while(v9_2.hasNext()) {
            v5 = arg7.findViewById(v9_2.next().intValue());
            if(v5 == null) {
                continue;
            }

            ((Collection)v0).add(v5);
        }

        this.labels = ((List)v0);
        v9 = new Integer[9];
        v9[0] = Integer.valueOf(id.btnCrosshairAssistant);
        v9[1] = Integer.valueOf(id.btnMonitoringInfo);
        v9[v3] = Integer.valueOf(id.btnMonitoringEmulator);
        v9[v4] = Integer.valueOf(id.btnSmartDPISwitch);
        v9[v8] = Integer.valueOf(id.bgOptimize);
        v9[5] = Integer.valueOf(id.bgTouchUp);
        v9[6] = Integer.valueOf(id.bgBrightnessAuto);
        v9[7] = Integer.valueOf(id.bgRefreshRateAuto);
        v9[8] = Integer.valueOf(id.bgScreenshot);
        List v8_1 = CollectionsKt.listOf(((Object[])v9));
        ArrayList v9_3 = new ArrayList();
        Iterator v8_2 = ((Iterable)v8_1).iterator();
        while(v8_2.hasNext()) {
            View v0_1 = arg7.findViewById(v8_2.next().intValue());
            if(v0_1 == null) {
                continue;
            }

            ((Collection)v9_3).add(v0_1);
        }

        this.cards = ((List)v9_3);
        this.cpu = arg7.findViewById(id.cpuView);
        this.ram = arg7.findViewById(id.ramView);
        this.mode = BlueMagicVisualMode.Companion.fromPreference(this.preferences.getAll().get("selected_mode"));
        this.cpuSweepEnabled = true;
        this.ramSweepEnabled = true;
        v8_2 = this.backgrounds.iterator();
        while(v8_2.hasNext()) {
            Drawable v9_4 = v8_2.next().getBackground();
            if(v9_4 == null) {
                continue;
            }

            v9_4.mutate();
        }

        this.restoreClosedSelector();
        this.updateAnimationOptions();
        this.button.setOnClickListener(new BlueMagicVisualModeController$$ExternalSyntheticLambda0(this));
        arg7.addOnAttachStateChangeListener(new View$OnAttachStateChangeListener() {
            public void onViewAttachedToWindow(View arg1) {
                Intrinsics.checkNotNullParameter(arg1, "view");
            }

            public void onViewDetachedFromWindow(View arg2) {
                Intrinsics.checkNotNullParameter(arg2, "view");
                BlueMagicVisualModeController.this.cancelAnimation();
            }
        });
    }

    public BlueMagicVisualModeController(View arg8, SharedPreferences arg9) {
        Intrinsics.checkNotNullParameter(arg8, "root");
        Intrinsics.checkNotNullParameter(arg9, "preferences");
        this(arg8, arg9, null, 4, null);
    }

    public BlueMagicVisualModeController(View arg1, SharedPreferences arg2, DecorativeAnimationPreferences arg3, int arg4, DefaultConstructorMarker arg5) {
        if((arg4 & 4) != 0) {
            arg3 = null;
        }

        this(arg1, arg2, arg3);
    }

    static final void _init_$lambda$4(BlueMagicVisualModeController arg0, View arg1) {
        arg0.selectNext();
    }

    public static final AnimatorSet access$getTransition$p(BlueMagicVisualModeController arg0) {
        return arg0.transition;
    }

    public static final void access$restoreClosedSelector(BlueMagicVisualModeController arg0) {
        arg0.restoreClosedSelector();
    }

    public static final void access$setTransition$p(BlueMagicVisualModeController arg0, AnimatorSet arg1) {
        arg0.transition = arg1;
    }

    private final void applyTheme(int arg4, int[] arg5, int[] arg6, int arg7) {
        this.notificationButton.applyAccentColor$app(arg4);
        this.selector.setAccentColor$app(arg4);
        Iterator v0 = this.backgrounds.iterator();
        while(v0.hasNext()) {
            Object v1 = v0.next();
            Drawable v2 = ((View)v1).getBackground();
            if(v2 != null) {
                v2.setTint(arg4);
            }

            ((View)v1).invalidate();
        }

        v0 = this.labels.iterator();
        while(v0.hasNext()) {
            v0.next().setTextColor(arg4);
        }

        CpuIndicatorView v0_1 = this.cpu;
        if(v0_1 != null) {
            v0_1.d(arg5, arg6);
        }

        RamIndicatorView v0_2 = this.ram;
        if(v0_2 != null) {
            v0_2.d(arg5, arg6);
        }

        CpuIndicatorView v5 = this.cpu;
        if(v5 != null) {
            v5.invalidate();
        }

        RamIndicatorView v5_1 = this.ram;
        if(v5_1 != null) {
            v5_1.invalidate();
        }

        Iterator v3 = this.cards.iterator();
        while(v3.hasNext()) {
            Object v5_2 = v3.next();
            int v0_3 = -870834658;
            int v6 = ((MaterialCardView)v5_2).getCardBackgroundColor().getDefaultColor() == v0_3 ? 1 : 0;
            if(v6 != 0) {
            }
            else {
                v0_3 = arg7;
            }

            ((MaterialCardView)v5_2).setCardBackgroundColor(v0_3);
            v6 = v6 != 0 ? 0xFF181E1E : arg4;
            ((MaterialCardView)v5_2).setStrokeColor(v6);
        }
    }

    public final void cancelAnimation() {
        this.notificationButton.cancelVisualAnimation$app();
        AnimatorSet v0 = this.transition;
        if(v0 == null) {
            return;
        }

        this.transition = null;
        v0.cancel();
        this.restoreClosedSelector();
    }

    private final boolean enabled(DecorativeEffect arg1) {
        DecorativeAnimationPreferences v0 = this.animationOptions;
        if(v0 != null) {
            return v0.isEnabled(arg1);
        }

        return 1;
    }

    private final void restoreClosedSelector() {
        this.restoreSelector();
        this.button.setEnabled(true);
        CpuIndicatorView v0 = this.cpu;
        if(v0 != null) {
            v0.clearModeSweep();
        }

        RamIndicatorView v0_1 = this.ram;
        if(v0_1 != null) {
            v0_1.clearModeSweep();
        }

        this.applyTheme(this.mode.getTint(), this.mode.getFill(), this.mode.getGlow(), this.mode.getActiveCardColor());
    }

    private final void restoreSelector() {
        this.selector.setFrame$app(BlueMagicModeAnimation.INSTANCE.frameAt(900));
        this.selector.setSelectedMode$app(this.mode.ordinal());
        this.text.setAlpha(1f);
        this.text.setTranslationY(0f);
        this.text.setText(this.mode.getLabel());
        this.button.setContentDescription(this.mode.getLabel());
    }

    private final void selectNext() {
        ValueAnimator v5;
        ValueAnimator v1;
        if(this.transition == null) {
            if(!this.button.isEnabled()) {
            }
            else {
                BlueMagicVisualMode v0 = this.mode;
                this.mode = v0.next();
                this.preferences.edit().putInt("selected_mode", this.mode.ordinal()).apply();
                this.button.setEnabled(false);
                this.button.setContentDescription(this.mode.getLabel());
                ValueAnimator v3 = null;
                if(this.enabled(DecorativeEffect.MODE_MOVEMENT)) {
                    v1 = ValueAnimator.ofInt(new int[]{0, 900});
                    v1.setDuration(900);
                    v1.setInterpolator(new LinearInterpolator());
                    v1.addUpdateListener(new BlueMagicVisualModeController$$ExternalSyntheticLambda1(this));
                }
                else {
                    v1 = v3;
                }

                this.movementAnimator = v1;
                if(v1 == null) {
                    this.restoreSelector();
                }

                int[] v4 = v0.getFill();
                v4 = Arrays.copyOf(v4, v4.length);
                Intrinsics.checkNotNullExpressionValue(v4, "copyOf(...)");
                int[] v6 = v0.getGlow();
                v6 = Arrays.copyOf(v6, v6.length);
                Intrinsics.checkNotNullExpressionValue(v6, "copyOf(...)");
                int v7 = 2;
                if(this.enabled(DecorativeEffect.MODE_COLOR)) {
                    v5 = ValueAnimator.ofFloat(new float[]{0f, 1f});
                    v5.setDuration(1500);
                    v5.addUpdateListener(new BlueMagicVisualModeController$$ExternalSyntheticLambda2(v4, v0, this, v6));
                }
                else {
                    v5 = v3;
                }

                this.colorAnimator = v5;
                if(v5 == null) {
                    this.applyTheme(this.mode.getTint(), this.mode.getFill(), this.mode.getGlow(), this.mode.getActiveCardColor());
                }

                CpuIndicatorView v0_1 = this.cpu;
                float v4_1 = 0f;
                float v0_2 = v0_1 != null ? v0_1.getDisplayedProgress() : 0f;
                RamIndicatorView v6_1 = this.ram;
                if(v6_1 != null) {
                    v4_1 = v6_1.getDisplayedProgress();
                }

                if((this.cpuSweepEnabled) || (this.ramSweepEnabled)) {
                    v3 = ValueAnimator.ofInt(new int[]{0, 2600});
                    v3.setDuration(2600);
                    v3.setInterpolator(new LinearInterpolator());
                    v3.addUpdateListener(new BlueMagicVisualModeController$$ExternalSyntheticLambda3(this, v0_2, v4_1));
                }

                this.sweepAnimator = v3;
                ValueAnimator[] v0_3 = new ValueAnimator[3];
                v0_3[0] = v1;
                v0_3[1] = v5;
                v0_3[v7] = v3;
                List v0_4 = CollectionsKt.listOfNotNull(((Object[])v0_3));
                if(v0_4.isEmpty()) {
                    this.restoreClosedSelector();
                    return;
                }

                AnimatorSet v1_1 = new AnimatorSet();
                v1_1.playTogether(((Collection)v0_4));
                v1_1.addListener(new BlueMagicVisualModeController$selectNext$set$1$1(this));
                this.transition = v1_1;
                v1_1.start();
            }
        }
    }

    static final void selectNext$lambda$10$lambda$9(BlueMagicVisualModeController arg6, float arg7, float arg8, ValueAnimator arg9) {
        Intrinsics.checkNotNullParameter(arg9, "it");
        Object v9 = arg9.getAnimatedValue();
        Intrinsics.checkNotNull(v9, "null cannot be cast to non-null type kotlin.Int");
        long v1 = ((long)((Integer)v9).intValue());
        if(arg6.cpuSweepEnabled) {
            CpuIndicatorView v9_1 = arg6.cpu;
            if(v9_1 != null) {
                v9_1.setModeSweepProgress(BlueMagicIndicatorSweep.INSTANCE.progressAt(v1, arg7, arg6.cpu.j, false));
            }
        }

        if(arg6.ramSweepEnabled) {
            RamIndicatorView v7 = arg6.ram;
            if(v7 != null) {
                v7.setModeSweepProgress(BlueMagicIndicatorSweep.INSTANCE.progressAt(v1, arg8, arg6.ram.j, true));
            }
        }
    }

    static final void selectNext$lambda$6$lambda$5(BlueMagicVisualModeController arg3, ValueAnimator arg4) {
        Intrinsics.checkNotNullParameter(arg4, "it");
        BlueMagicModeAnimation v0 = BlueMagicModeAnimation.INSTANCE;
        Object v4 = arg4.getAnimatedValue();
        Intrinsics.checkNotNull(v4, "null cannot be cast to non-null type kotlin.Int");
        Frame v4_1 = v0.frameAt(((long)((Integer)v4).intValue()));
        arg3.selector.setFrame$app(v4_1);
        arg3.text.setAlpha(v4_1.getLabelAlpha());
        arg3.text.setTranslationY(v4_1.getLabelOffset() * (((float)arg3.button.getHeight())));
        if((v4_1.getShowNewLabel()) && !Intrinsics.areEqual(arg3.text.getText().toString(), arg3.mode.getLabel())) {
            arg3.text.setText(arg3.mode.getLabel());
            arg3.selector.setSelectedMode$app(arg3.mode.ordinal());
        }
    }

    static final void selectNext$lambda$8$lambda$7(int[] arg4, BlueMagicVisualMode arg5, BlueMagicVisualModeController arg6, int[] arg7, ValueAnimator arg8) {
        Intrinsics.checkNotNullParameter(arg8, "it");
        Object v8 = arg8.getAnimatedValue();
        Intrinsics.checkNotNull(v8, "null cannot be cast to non-null type kotlin.Float");
        float v8_1 = ((Float)v8).floatValue();
        int v0 = arg4.length;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            arg4[v1] = BlueMagicVisualModeKt.blendBlueMagicColor(arg5.getFill()[v1], arg6.mode.getFill()[v1], v8_1);
            arg7[v1] = BlueMagicVisualModeKt.blendBlueMagicColor(arg5.getGlow()[v1], arg6.mode.getGlow()[v1], v8_1);
        }

        arg6.applyTheme(BlueMagicVisualModeKt.blendBlueMagicColor(arg5.getTint(), arg6.mode.getTint(), v8_1), arg4, arg7, BlueMagicVisualModeKt.blendBlueMagicColor(arg5.getActiveCardColor(), arg6.mode.getActiveCardColor(), v8_1));
    }

    public final void updateAnimationOptions() {
        ValueAnimator v0;
        this.cpuSweepEnabled = this.enabled(DecorativeEffect.CPU_MODE_SWEEP);
        this.ramSweepEnabled = this.enabled(DecorativeEffect.RAM_MODE_SWEEP);
        this.notificationButton.setFeedbackAnimationEnabled$app(this.enabled(DecorativeEffect.NOTIFICATION_FEEDBACK));
        if(!this.enabled(DecorativeEffect.MODE_MOVEMENT)) {
            v0 = this.movementAnimator;
            if(v0 != null && (v0.isStarted())) {
                v0 = this.movementAnimator;
                if(v0 != null) {
                    v0.cancel();
                }

                this.restoreSelector();
            }
        }

        if(!this.enabled(DecorativeEffect.MODE_COLOR)) {
            v0 = this.colorAnimator;
            if(v0 != null && (v0.isStarted())) {
                v0 = this.colorAnimator;
                if(v0 != null) {
                    v0.cancel();
                }

                this.applyTheme(this.mode.getTint(), this.mode.getFill(), this.mode.getGlow(), this.mode.getActiveCardColor());
            }
        }

        if(!this.cpuSweepEnabled) {
            CpuIndicatorView v0_1 = this.cpu;
            if(v0_1 != null) {
                v0_1.clearModeSweep();
            }
        }

        if(!this.ramSweepEnabled) {
            RamIndicatorView v0_2 = this.ram;
            if(v0_2 != null) {
                v0_2.clearModeSweep();
            }
        }

        if(!this.cpuSweepEnabled && !this.ramSweepEnabled) {
            v0 = this.sweepAnimator;
            if(v0 != null) {
                v0.cancel();
            }
        }

        if(this.transition != null) {
            List v0_3 = CollectionsKt.listOfNotNull(new ValueAnimator[]{this.movementAnimator, this.colorAnimator, this.sweepAnimator});
            if(!(v0_3 instanceof Collection) || !v0_3.isEmpty()) {
                Iterator v0_4 = ((Iterable)v0_3).iterator();
                do {
                    if(v0_4.hasNext()) {
                        if(!v0_4.next().isStarted()) {
                            continue;
                        }

                        return;
                    }

                    goto label_84;
                }
                while(true);

                return;
            }
            else {
            }

        label_84:
            AnimatorSet v0_5 = this.transition;
            this.transition = null;
            if(v0_5 != null) {
                v0_5.cancel();
            }

            this.restoreClosedSelector();
        }
    }
}

