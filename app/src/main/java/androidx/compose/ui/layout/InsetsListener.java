package androidx.compose.ui.layout;

import android.os.Build$VERSION;
import android.view.View$OnAttachStateChangeListener;
import android.view.View;
import android.view.ViewParent;
import androidx.collection.IntObjectMap;
import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMap;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.core.graphics.Insets;
import androidx.core.view.DisplayCutoutCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat$BoundsCompat;
import androidx.core.view.WindowInsetsAnimationCompat$Callback;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat$Type;
import androidx.core.view.WindowInsetsCompat;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u000F\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010&\u001A\u00020\'2\u0006\u0010(\u001A\u00020)H\u0016J\u0018\u0010*\u001A\u00020+2\u0006\u0010(\u001A\u00020)2\u0006\u0010,\u001A\u00020+H\u0016J\u0018\u0010-\u001A\u00020\'2\u0006\u0010.\u001A\u00020\u00142\u0006\u0010(\u001A\u00020)H\u0002J\u001E\u0010/\u001A\u00020\u00102\u0006\u00100\u001A\u00020\u00102\f\u00101\u001A\b\u0012\u0004\u0012\u00020)02H\u0016J\u0010\u00103\u001A\u00020\'2\u0006\u0010(\u001A\u00020)H\u0016J\u0010\u00104\u001A\u00020\'2\u0006\u0010.\u001A\u00020\u0014H\u0002J\u0018\u00105\u001A\u00020\u00102\u0006\u00106\u001A\u0002072\u0006\u00100\u001A\u00020\u0010H\u0016J\u0010\u00108\u001A\u00020\'2\u0006\u00100\u001A\u00020\u0010H\u0002J\b\u00109\u001A\u00020\'H\u0016J\u0010\u0010:\u001A\u00020\'2\u0006\u00106\u001A\u000207H\u0016J\u0010\u0010;\u001A\u00020\'2\u0006\u00106\u001A\u000207H\u0016R\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u000E\u0010\u000B\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u000F\u001A\u0004\u0018\u00010\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R\u001D\u0010\u0011\u001A\u000E\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001A\u00020\u0018¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u001AR\u001D\u0010\u001B\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001E0\u001D0\u001C¢\u0006\b\n\u0000\u001A\u0004\b\u001F\u0010 R\u0017\u0010!\u001A\b\u0012\u0004\u0012\u00020#0\"¢\u0006\b\n\u0000\u001A\u0004\b$\u0010%¨\u0006<"}, d2={"Landroidx/compose/ui/layout/InsetsListener;", "Landroidx/core/view/WindowInsetsAnimationCompat$Callback;", "Ljava/lang/Runnable;", "Landroidx/core/view/OnApplyWindowInsetsListener;", "Landroid/view/View$OnAttachStateChangeListener;", "composeView", "Landroidx/compose/ui/platform/AndroidComposeView;", "<init>", "(Landroidx/compose/ui/platform/AndroidComposeView;)V", "getComposeView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "prepared", "", "runningAnimationMask", "", "savedInsets", "Landroidx/core/view/WindowInsetsCompat;", "insetsValues", "Landroidx/collection/ScatterMap;", "", "Landroidx/compose/ui/layout/WindowWindowInsetsAnimationValues;", "getInsetsValues", "()Landroidx/collection/ScatterMap;", "generation", "Landroidx/compose/runtime/MutableIntState;", "getGeneration", "()Landroidx/compose/runtime/MutableIntState;", "displayCutouts", "Landroidx/collection/MutableObjectList;", "Landroidx/compose/runtime/MutableState;", "Landroid/graphics/Rect;", "getDisplayCutouts", "()Landroidx/collection/MutableObjectList;", "displayCutoutRulers", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Landroidx/compose/ui/layout/RectRulers;", "getDisplayCutoutRulers", "()Landroidx/compose/runtime/snapshots/SnapshotStateList;", "onPrepare", "", "animation", "Landroidx/core/view/WindowInsetsAnimationCompat;", "onStart", "Landroidx/core/view/WindowInsetsAnimationCompat$BoundsCompat;", "bounds", "updateInsetAnimationInfo", "insetsValue", "onProgress", "insets", "runningAnimations", "", "onEnd", "stopAnimationForRuler", "onApplyWindowInsets", "view", "Landroid/view/View;", "updateInsets", "run", "onViewAttachedToWindow", "onViewDetachedFromWindow", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class InsetsListener extends Callback implements View$OnAttachStateChangeListener, OnApplyWindowInsetsListener, Runnable {
    public static final int $stable = 8;
    private final AndroidComposeView composeView;
    private final SnapshotStateList displayCutoutRulers;
    private final MutableObjectList displayCutouts;
    private final MutableIntState generation;
    private final ScatterMap insetsValues;
    private boolean prepared;
    private int runningAnimationMask;
    private WindowInsetsCompat savedInsets;

    static {
    }

    public InsetsListener(AndroidComposeView arg4) {
        super(1);
        this.composeView = arg4;
        MutableScatterMap v4 = new MutableScatterMap(9);
        v4.set(WindowInsetsRulers.Companion.getCaptionBar(), new WindowWindowInsetsAnimationValues("caption bar"));
        v4.set(WindowInsetsRulers.Companion.getDisplayCutout(), new WindowWindowInsetsAnimationValues("display cutout"));
        v4.set(WindowInsetsRulers.Companion.getIme(), new WindowWindowInsetsAnimationValues("ime"));
        v4.set(WindowInsetsRulers.Companion.getMandatorySystemGestures(), new WindowWindowInsetsAnimationValues("mandatory system gestures"));
        v4.set(WindowInsetsRulers.Companion.getNavigationBars(), new WindowWindowInsetsAnimationValues("navigation bars"));
        v4.set(WindowInsetsRulers.Companion.getStatusBars(), new WindowWindowInsetsAnimationValues("status bars"));
        v4.set(WindowInsetsRulers.Companion.getSystemGestures(), new WindowWindowInsetsAnimationValues("system gestures"));
        v4.set(WindowInsetsRulers.Companion.getTappableElement(), new WindowWindowInsetsAnimationValues("tappable element"));
        v4.set(WindowInsetsRulers.Companion.getWaterfall(), new WindowWindowInsetsAnimationValues("waterfall"));
        this.insetsValues = ((ScatterMap)v4);
        this.generation = SnapshotIntStateKt.mutableIntStateOf(0);
        this.displayCutouts = new MutableObjectList(4);
        this.displayCutoutRulers = SnapshotStateKt.mutableStateListOf();
    }

    public final AndroidComposeView getComposeView() {
        return this.composeView;
    }

    public final SnapshotStateList getDisplayCutoutRulers() {
        return this.displayCutoutRulers;
    }

    public final MutableObjectList getDisplayCutouts() {
        return this.displayCutouts;
    }

    public final MutableIntState getGeneration() {
        return this.generation;
    }

    public final ScatterMap getInsetsValues() {
        return this.insetsValues;
    }

    public WindowInsetsCompat onApplyWindowInsets(View arg3, WindowInsetsCompat arg4) {
        if(this.prepared) {
            this.savedInsets = arg4;
            if(Build$VERSION.SDK_INT == 30) {
                arg3.post(((Runnable)this));
                return arg4;
            }
        }
        else if(this.runningAnimationMask == 0) {
            this.updateInsets(arg4);
        }

        return arg4;
    }

    public void onEnd(WindowInsetsAnimationCompat arg5) {
        this.prepared = false;
        int v0 = arg5.getTypeMask();
        this.runningAnimationMask &= ~v0;
        this.savedInsets = null;
        Object v0_1 = WindowInsetsRulers_androidKt.access$getWindowInsetsTypeMap$p().get(v0);
        if(v0_1 != null) {
            v0_1 = this.insetsValues.get(v0_1);
            Intrinsics.checkNotNull(v0_1);
            ((WindowWindowInsetsAnimationValues)v0_1).setFraction(0f);
            ((WindowWindowInsetsAnimationValues)v0_1).setAlpha(1f);
            ((WindowWindowInsetsAnimationValues)v0_1).setDurationMillis(0);
            ((WindowWindowInsetsAnimationValues)v0_1).setFraction(0f);
            this.stopAnimationForRuler(((WindowWindowInsetsAnimationValues)v0_1));
            this.generation.setIntValue(this.generation.getIntValue() + 1);
            Snapshot.Companion.sendApplyNotifications();
        }

        super.onEnd(arg5);
    }

    public void onPrepare(WindowInsetsAnimationCompat arg2) {
        this.prepared = true;
        super.onPrepare(arg2);
    }

    public WindowInsetsCompat onProgress(WindowInsetsCompat arg6, List arg7) {
        int v0 = arg7.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            Object v2 = arg7.get(v1);
            Object v3 = WindowInsetsRulers_androidKt.access$getWindowInsetsTypeMap$p().get(((WindowInsetsAnimationCompat)v2).getTypeMask());
            if(v3 != null) {
                v3 = this.insetsValues.get(v3);
                Intrinsics.checkNotNull(v3);
                if(((WindowWindowInsetsAnimationValues)v3).isAnimating()) {
                    this.updateInsetAnimationInfo(((WindowWindowInsetsAnimationValues)v3), ((WindowInsetsAnimationCompat)v2));
                }
            }
        }

        this.updateInsets(arg6);
        return arg6;
    }

    public BoundsCompat onStart(WindowInsetsAnimationCompat arg8, BoundsCompat arg9) {
        WindowInsetsCompat v0 = this.savedInsets;
        this.prepared = false;
        this.savedInsets = null;
        if(arg8.getDurationMillis() > 0 && v0 != null) {
            int v1 = arg8.getTypeMask();
            this.runningAnimationMask |= v1;
            Object v2 = WindowInsetsRulers_androidKt.access$getWindowInsetsTypeMap$p().get(v1);
            if(v2 != null) {
                v2 = this.insetsValues.get(v2);
                Intrinsics.checkNotNull(v2);
                Insets v0_1 = v0.getInsets(v1);
                long v0_2 = ValueInsets.constructor-impl((((long)v0_1.bottom)) | ((((long)v0_1.left)) << 0x30 | (((long)v0_1.top)) << 0x20 | (((long)v0_1.right)) << 16));
                long v3 = ((WindowWindowInsetsAnimationValues)v2).getCurrent-hdzbrEE();
                if(!ValueInsets.equals-impl0(v0_2, v3)) {
                    ((WindowWindowInsetsAnimationValues)v2).setSourceValueInsets-Ynlvx88(v3);
                    ((WindowWindowInsetsAnimationValues)v2).setTargetValueInsets-Ynlvx88(v0_2);
                    ((WindowWindowInsetsAnimationValues)v2).setAnimating(true);
                    this.updateInsetAnimationInfo(((WindowWindowInsetsAnimationValues)v2), arg8);
                    this.generation.setIntValue(this.generation.getIntValue() + 1);
                    Snapshot.Companion.sendApplyNotifications();
                }
            }
        }

        return super.onStart(arg8, arg9);
    }

    public void onViewAttachedToWindow(View arg3) {
        ViewParent v3;
        ViewParent v0 = arg3.getParent();
        if((v0 instanceof View)) {
        }
        else {
            v0 = null;
        }

        if(v0 == null) {
        }
        else {
            v3 = v0;
        }

        ViewCompat.setOnApplyWindowInsetsListener(((View)v3), this);
        ViewCompat.setWindowInsetsAnimationCallback(((View)v3), ((Callback)this));
    }

    public void onViewDetachedFromWindow(View arg3) {
        ViewParent v3;
        ViewParent v2 = arg3.getParent();
        OnApplyWindowInsetsListener v1 = null;
        if((v2 instanceof View)) {
        }
        else {
            v2 = ((ViewParent)v1);
        }

        if(v2 == null) {
        }
        else {
            v3 = v2;
        }

        ViewCompat.setOnApplyWindowInsetsListener(((View)v3), v1);
        ViewCompat.setWindowInsetsAnimationCallback(((View)v3), ((Callback)v1));
    }

    public void run() {
        if(this.prepared) {
            this.runningAnimationMask = 0;
            this.prepared = false;
            WindowInsetsCompat v0 = this.savedInsets;
            if(v0 != null) {
                this.updateInsets(v0);
                this.savedInsets = null;
            }
        }
    }

    private final void stopAnimationForRuler(WindowWindowInsetsAnimationValues arg3) {
        arg3.setAnimating(false);
        arg3.setSourceValueInsets-Ynlvx88(ValueInsets_androidKt.getUnsetValueInsets());
        arg3.setTargetValueInsets-Ynlvx88(ValueInsets_androidKt.getUnsetValueInsets());
    }

    private final void updateInsetAnimationInfo(WindowWindowInsetsAnimationValues arg3, WindowInsetsAnimationCompat arg4) {
        arg3.setFraction(arg4.getInterpolatedFraction());
        arg3.setAlpha(arg4.getAlpha());
        arg3.setDurationMillis(arg4.getDurationMillis());
    }

    private final void updateInsets(WindowInsetsCompat arg28) {
        int v3_1;
        int v2_4;
        Object[] v10_2;
        Insets v2_3;
        long v25;
        long v2_2;
        int[] v24;
        long[] v23;
        int v21;
        int v20;
        int v11;
        int v18;
        int v17;
        int v16;
        int v14;
        int v13;
        InsetsListener v0 = this;
        WindowInsetsCompat v1 = arg28;
        IntObjectMap v2 = WindowInsetsRulers_androidKt.access$getWindowInsetsTypeMap$p();
        int[] v3 = v2.keys;
        Object[] v4 = v2.values;
        long[] v2_1 = v2.metadata;
        int v5 = v2_1.length - 2;
        if(v5 >= 0) {
            int v12 = 0;
            v13 = 0;
            v14 = 0;
            int v15 = 16;
            v16 = 0x20;
            while(true) {
                long v7 = v2_1[v12];
                v17 = 0x30;
                v18 = 1;
                if((~v7 << 7 & v7 & -9187201950435737472L) != -9187201950435737472L) {
                    int v10 = 8;
                    int v9 = 8 - (~(v12 - v5) >>> 0x1F);
                    v11 = 0;
                    while(v11 < v9) {
                        if((v7 & 0xFF) < 0x80) {
                            v20 = (v12 << 3) + v11;
                            v21 = v15;
                            v15 = v3[v20];
                            Object v6 = v4[v20];
                            v20 = v10;
                            Insets v10_1 = v1.getInsets(v15);
                            v23 = v2_1;
                            v24 = v3;
                            v2_2 = ValueInsets.constructor-impl((((long)v10_1.left)) << v17 | (((long)v10_1.top)) << v16 | (((long)v10_1.right)) << v21 | (((long)v10_1.bottom)));
                            v6 = v0.insetsValues.get(v6);
                            Intrinsics.checkNotNull(v6);
                            v25 = v7;
                            if(!ValueInsets.equals-impl0(v2_2, ((WindowWindowInsetsAnimationValues)v6).getCurrent-hdzbrEE())) {
                                ((WindowWindowInsetsAnimationValues)v6).setCurrent-Ynlvx88(v2_2);
                                v13 = 1;
                                if(!ValueInsets.equals-impl0(v2_2, ValueInsets_androidKt.getZeroValueInsets())) {
                                    v14 = 1;
                                }
                            }

                            if(v15 != Type.ime()) {
                                v2_3 = v1.getInsetsIgnoringVisibility(v15);
                                v10_2 = v4;
                                v2_2 = ValueInsets.constructor-impl((((long)v2_3.top)) << v16 | (((long)v2_3.left)) << v17 | (((long)v2_3.right)) << v21 | (((long)v2_3.bottom)));
                                if(!ValueInsets.equals-impl0(((WindowWindowInsetsAnimationValues)v6).getMaximum-hdzbrEE(), v2_2)) {
                                    ((WindowWindowInsetsAnimationValues)v6).setMaximum-Ynlvx88(v2_2);
                                    v13 = 1;
                                    if(!ValueInsets.equals-impl0(v2_2, ValueInsets_androidKt.getZeroValueInsets())) {
                                        v14 = 1;
                                    }
                                }
                            }
                            else {
                                v10_2 = v4;
                            }

                            ((WindowWindowInsetsAnimationValues)v6).setVisible(v1.isVisible(v15));
                        }
                        else {
                            v23 = v2_1;
                            v24 = v3;
                            v25 = v7;
                            v20 = v10;
                            v21 = v15;
                            v10_2 = v4;
                        }

                        v7 = v25 >> v20;
                        ++v11;
                        v4 = v10_2;
                        v10 = v20;
                        v15 = v21;
                        v2_1 = v23;
                        v3 = v24;
                    }

                    v23 = v2_1;
                    v24 = v3;
                    v2_4 = v10;
                    v21 = v15;
                    v10_2 = v4;
                    if(v9 != v2_4) {
                        break;
                    }
                }
                else {
                    v23 = v2_1;
                    v24 = v3;
                    v10_2 = v4;
                    v21 = v15;
                }

                if(v12 == v5) {
                    break;
                }

                ++v12;
                v4 = v10_2;
                v15 = v21;
                v2_1 = v23;
                v3 = v24;
            }
        }
        else {
            v16 = 0x20;
            v17 = 0x30;
            v18 = 1;
            v21 = 16;
            v13 = 0;
            v14 = 0;
        }

        DisplayCutoutCompat v1_1 = v1.getDisplayCutout();
        if(v1_1 == null) {
            v2_2 = ValueInsets_androidKt.getZeroValueInsets();
        }
        else {
            v2_3 = v1_1.getWaterfallInsets();
            v2_2 = ValueInsets.constructor-impl((((long)v2_3.left)) << v17 | (((long)v2_3.top)) << v16 | (((long)v2_3.right)) << v21 | (((long)v2_3.bottom)));
        }

        Object v4_1 = v0.insetsValues.get(WindowInsetsRulers.Companion.getWaterfall());
        Intrinsics.checkNotNull(v4_1);
        ((WindowWindowInsetsAnimationValues)v4_1).setVisible(ValueInsets.equals-impl0(v2_2, ValueInsets_androidKt.getZeroValueInsets()) ^ 1);
        if(!ValueInsets.equals-impl0(((WindowWindowInsetsAnimationValues)v4_1).getCurrent-hdzbrEE(), v2_2)) {
            ((WindowWindowInsetsAnimationValues)v4_1).setCurrent-Ynlvx88(v2_2);
            ((WindowWindowInsetsAnimationValues)v4_1).setMaximum-Ynlvx88(v2_2);
            v13 = v18;
            if(!ValueInsets.equals-impl0(v2_2, ValueInsets_androidKt.getZeroValueInsets())) {
                v14 = v13;
            }
        }

        if(v1_1 != null) {
            List v1_2 = v1_1.getBoundingRects();
            if(v1_2.size() < v0.displayCutouts.getSize()) {
                v0.displayCutouts.removeRange(v1_2.size(), v0.displayCutouts.getSize());
                v0.displayCutoutRulers.removeRange(v1_2.size(), v0.displayCutoutRulers.size());
                v13 = v18;
            }
            else {
                v2_4 = v1_2.size() - v0.displayCutouts.getSize();
                v3_1 = 0;
                while(v3_1 < v2_4) {
                    v0.displayCutouts.add(SnapshotStateKt.mutableStateOf$default(v1_2.get(v0.displayCutouts.getSize()), null, 2, null));
                    v0.displayCutoutRulers.add(RectRulersKt.RectRulers("display cutout rect " + v0.displayCutouts.getSize()));
                    ++v3_1;
                    v13 = v18;
                }
            }

            List v2_5 = v1_2;
            v3_1 = ((Collection)v2_5).size();
            for(v11 = 0; v11 < v3_1; ++v11) {
                v4_1 = v1_2.get(v11);
                Object v5_1 = v0.displayCutouts.get(v11);
                if(!Intrinsics.areEqual(((MutableState)v5_1).getValue(), v4_1)) {
                    ((MutableState)v5_1).setValue(v4_1);
                    v13 = v18;
                }
            }

            if(((Collection)v2_5).isEmpty()) {
                goto label_259;
            }

            v14 = v18;
        }
        else if(v0.displayCutouts.getSize() > 0) {
            v0.displayCutouts.clear();
            v0.displayCutoutRulers.clear();
            v13 = v18;
        }

    label_259:
        if((v14 != 0 || v0.generation.getIntValue() != 0) && v13 != 0) {
            v0.generation.setIntValue(v0.generation.getIntValue() + 1);
            Snapshot.Companion.sendApplyNotifications();
        }
    }
}

