package androidx.window.embedding;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build$VERSION;
import android.view.WindowMetrics;
import androidx.core.util.Preconditions;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0016\u0018\u0000 ,2\u00020\u0001:\u0004,-./BO\b\u0000\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\b\b\u0003\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0003\u0010\u0006\u001A\u00020\u0005\u0012\b\b\u0003\u0010\u0007\u001A\u00020\u0005\u0012\b\b\u0002\u0010\b\u001A\u00020\t\u0012\b\b\u0002\u0010\n\u001A\u00020\t\u0012\u0006\u0010\u000B\u001A\u00020\f¢\u0006\u0004\b\r\u0010\u000EJ\u001D\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u001DH\u0000¢\u0006\u0002\b\u001EJ\u001D\u0010\u001F\u001A\u00020\u00192\u0006\u0010 \u001A\u00020!2\u0006\u0010\"\u001A\u00020#H\u0000¢\u0006\u0002\b$J\u001A\u0010%\u001A\u00020\u00052\u0006\u0010 \u001A\u00020!2\b\b\u0001\u0010&\u001A\u00020\u0005H\u0002J\u0013\u0010\'\u001A\u00020\u00192\b\u0010(\u001A\u0004\u0018\u00010)H\u0096\u0002J\b\u0010*\u001A\u00020\u0005H\u0016J\b\u0010+\u001A\u00020\u0003H\u0016R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\u0006\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0010R\u0011\u0010\b\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0014R\u0011\u0010\u000B\u001A\u00020\f¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017¨\u00060"}, d2={"Landroidx/window/embedding/SplitRule;", "Landroidx/window/embedding/EmbeddingRule;", "tag", "", "minWidthDp", "", "minHeightDp", "minSmallestWidthDp", "maxAspectRatioInPortrait", "Landroidx/window/embedding/EmbeddingAspectRatio;", "maxAspectRatioInLandscape", "defaultSplitAttributes", "Landroidx/window/embedding/SplitAttributes;", "<init>", "(Ljava/lang/String;IIILandroidx/window/embedding/EmbeddingAspectRatio;Landroidx/window/embedding/EmbeddingAspectRatio;Landroidx/window/embedding/SplitAttributes;)V", "getMinWidthDp", "()I", "getMinHeightDp", "getMinSmallestWidthDp", "getMaxAspectRatioInPortrait", "()Landroidx/window/embedding/EmbeddingAspectRatio;", "getMaxAspectRatioInLandscape", "getDefaultSplitAttributes", "()Landroidx/window/embedding/SplitAttributes;", "checkParentMetrics", "", "context", "Landroid/content/Context;", "parentMetrics", "Landroid/view/WindowMetrics;", "checkParentMetrics$window_release", "checkParentBounds", "density", "", "bounds", "Landroid/graphics/Rect;", "checkParentBounds$window_release", "convertDpToPx", "dimensionDp", "equals", "other", "", "hashCode", "toString", "Companion", "FinishBehavior", "Api30Impl", "Api34Impl", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public class SplitRule extends EmbeddingRule {
    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007¨\u0006\b"}, d2={"Landroidx/window/embedding/SplitRule$Api30Impl;", "", "<init>", "()V", "getBounds", "Landroid/graphics/Rect;", "windowMetrics", "Landroid/view/WindowMetrics;", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Api30Impl {
        public static final Api30Impl INSTANCE;

        static {
            Api30Impl.INSTANCE = new Api30Impl();
        }

        private Api30Impl() {
            super();
        }

        public final Rect getBounds(WindowMetrics arg1) {
            Intrinsics.checkNotNullParameter(arg1, "windowMetrics");
            Rect v0 = arg1.getBounds();
            Intrinsics.checkNotNullExpressionValue(v0, "getBounds(...)");
            return v0;
        }
    }

    @Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t¨\u0006\n"}, d2={"Landroidx/window/embedding/SplitRule$Api34Impl;", "", "<init>", "()V", "getDensity", "", "windowMetrics", "Landroid/view/WindowMetrics;", "context", "Landroid/content/Context;", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Api34Impl {
        public static final Api34Impl INSTANCE;

        static {
            Api34Impl.INSTANCE = new Api34Impl();
        }

        private Api34Impl() {
            super();
        }

        public final float getDensity(WindowMetrics arg1, Context arg2) {
            Intrinsics.checkNotNullParameter(arg1, "windowMetrics");
            Intrinsics.checkNotNullParameter(arg2, "context");
            try {
                return arg1.getDensity();
            }
            catch(NoSuchMethodError ) {
                return arg2.getResources().getDisplayMetrics().density;
            }
        }
    }

    @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001A\u00020\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001A\u00020\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2={"Landroidx/window/embedding/SplitRule$Companion;", "", "<init>", "()V", "SPLIT_MIN_DIMENSION_ALWAYS_ALLOW", "", "SPLIT_MIN_DIMENSION_DP_DEFAULT", "SPLIT_MAX_ASPECT_RATIO_PORTRAIT_DEFAULT", "Landroidx/window/embedding/EmbeddingAspectRatio;", "SPLIT_MAX_ASPECT_RATIO_LANDSCAPE_DEFAULT", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0019\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\n\u001A\u00020\u0003H\u0016J\b\u0010\u000B\u001A\u00020\u0005H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001A\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\t¨\u0006\r"}, d2={"Landroidx/window/embedding/SplitRule$FinishBehavior;", "", "description", "", "value", "", "<init>", "(Ljava/lang/String;I)V", "getValue$window_release", "()I", "toString", "hashCode", "Companion", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class FinishBehavior {
        @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\b\u001A\u00020\u00052\b\b\u0001\u0010\t\u001A\u00020\nH\u0001¢\u0006\u0002\b\u000BR\u0010\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2={"Landroidx/window/embedding/SplitRule$FinishBehavior$Companion;", "", "<init>", "()V", "NEVER", "Landroidx/window/embedding/SplitRule$FinishBehavior;", "ALWAYS", "ADJACENT", "getFinishBehaviorFromValue", "value", "", "getFinishBehaviorFromValue$window_release", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class androidx.window.embedding.SplitRule$FinishBehavior$Companion {
            public androidx.window.embedding.SplitRule$FinishBehavior$Companion(DefaultConstructorMarker arg1) {
                this();
            }

            private androidx.window.embedding.SplitRule$FinishBehavior$Companion() {
                super();
            }

            @JvmStatic public final FinishBehavior getFinishBehaviorFromValue$window_release(int arg3) {
                if(arg3 == FinishBehavior.NEVER.getValue$window_release()) {
                    return FinishBehavior.NEVER;
                }

                if(arg3 == FinishBehavior.ALWAYS.getValue$window_release()) {
                    return FinishBehavior.ALWAYS;
                }

                if(arg3 == FinishBehavior.ADJACENT.getValue$window_release()) {
                    return FinishBehavior.ADJACENT;
                }

                throw new IllegalArgumentException("Unknown finish behavior:" + arg3);
            }
        }

        public static final FinishBehavior ADJACENT;
        public static final FinishBehavior ALWAYS;
        public static final androidx.window.embedding.SplitRule$FinishBehavior$Companion Companion;
        public static final FinishBehavior NEVER;
        private final String description;
        private final int value;

        static {
            FinishBehavior.Companion = new androidx.window.embedding.SplitRule$FinishBehavior$Companion(null);
            FinishBehavior.NEVER = new FinishBehavior("NEVER", 0);
            FinishBehavior.ALWAYS = new FinishBehavior("ALWAYS", 1);
            FinishBehavior.ADJACENT = new FinishBehavior("ADJACENT", 2);
        }

        private FinishBehavior(String arg1, int arg2) {
            super();
            this.description = arg1;
            this.value = arg2;
        }

        @JvmStatic public static final FinishBehavior getFinishBehaviorFromValue$window_release(int arg1) {
            return FinishBehavior.Companion.getFinishBehaviorFromValue$window_release(arg1);
        }

        public final int getValue$window_release() {
            return this.value;
        }

        public int hashCode() {
            return this.description.hashCode() * 0x1F + this.value;
        }

        public String toString() {
            return this.description;
        }
    }

    public static final Companion Companion = null;
    public static final EmbeddingAspectRatio SPLIT_MAX_ASPECT_RATIO_LANDSCAPE_DEFAULT = null;
    public static final EmbeddingAspectRatio SPLIT_MAX_ASPECT_RATIO_PORTRAIT_DEFAULT = null;
    public static final int SPLIT_MIN_DIMENSION_ALWAYS_ALLOW = 0;
    public static final int SPLIT_MIN_DIMENSION_DP_DEFAULT = 600;
    private final SplitAttributes defaultSplitAttributes;
    private final EmbeddingAspectRatio maxAspectRatioInLandscape;
    private final EmbeddingAspectRatio maxAspectRatioInPortrait;
    private final int minHeightDp;
    private final int minSmallestWidthDp;
    private final int minWidthDp;

    static {
        SplitRule.Companion = new Companion(null);
        SplitRule.SPLIT_MAX_ASPECT_RATIO_PORTRAIT_DEFAULT = EmbeddingAspectRatio.Companion.ratio(1.4f);
        SplitRule.SPLIT_MAX_ASPECT_RATIO_LANDSCAPE_DEFAULT = EmbeddingAspectRatio.ALWAYS_ALLOW;
    }

    public SplitRule(String arg2, int arg3, int arg4, int arg5, EmbeddingAspectRatio arg6, EmbeddingAspectRatio arg7, SplitAttributes arg8) {
        Intrinsics.checkNotNullParameter(arg6, "maxAspectRatioInPortrait");
        Intrinsics.checkNotNullParameter(arg7, "maxAspectRatioInLandscape");
        Intrinsics.checkNotNullParameter(arg8, "defaultSplitAttributes");
        super(arg2);
        this.minWidthDp = arg3;
        this.minHeightDp = arg4;
        this.minSmallestWidthDp = arg5;
        this.maxAspectRatioInPortrait = arg6;
        this.maxAspectRatioInLandscape = arg7;
        this.defaultSplitAttributes = arg8;
        Preconditions.checkArgumentNonnegative(arg3, "minWidthDp must be non-negative");
        Preconditions.checkArgumentNonnegative(arg4, "minHeightDp must be non-negative");
        Preconditions.checkArgumentNonnegative(arg5, "minSmallestWidthDp must be non-negative");
    }

    public SplitRule(String arg2, int arg3, int arg4, int arg5, EmbeddingAspectRatio arg6, EmbeddingAspectRatio arg7, SplitAttributes arg8, int arg9, DefaultConstructorMarker arg10) {
        if((arg9 & 1) != 0) {
            arg2 = null;
        }

        int v0 = 600;
        if((arg9 & 2) != 0) {
            arg3 = v0;
        }

        if((arg9 & 4) != 0) {
            arg4 = v0;
        }

        if((arg9 & 8) != 0) {
            arg5 = v0;
        }

        if((arg9 & 16) != 0) {
            arg6 = SplitRule.SPLIT_MAX_ASPECT_RATIO_PORTRAIT_DEFAULT;
        }

        if((arg9 & 0x20) != 0) {
            arg7 = SplitRule.SPLIT_MAX_ASPECT_RATIO_LANDSCAPE_DEFAULT;
        }

        this(arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }

    public final boolean checkParentBounds$window_release(float arg9, Rect arg10) {
        int v8;
        Intrinsics.checkNotNullParameter(arg10, "bounds");
        int v0 = arg10.width();
        int v10 = arg10.height();
        if(v0 != 0) {
            if(v10 == 0) {
            }
            else {
                int v2 = this.convertDpToPx(arg9, this.minWidthDp);
                int v3 = this.convertDpToPx(arg9, this.minHeightDp);
                int v9 = this.convertDpToPx(arg9, this.minSmallestWidthDp);
                v2 = this.minWidthDp == 0 || v0 >= v2 ? 1 : 0;
                v3 = this.minHeightDp == 0 || v10 >= v3 ? 1 : 0;
                v9 = this.minSmallestWidthDp == 0 || Math.min(v0, v10) >= v9 ? 1 : 0;
                float v4 = 1f;
                if(v10 >= v0) {
                    if(Intrinsics.areEqual(this.maxAspectRatioInPortrait, EmbeddingAspectRatio.ALWAYS_ALLOW)) {
                        goto label_65;
                    }
                    else if((((float)v10)) * v4 / (((float)v0)) <= this.maxAspectRatioInPortrait.getValue$window_release()) {
                        goto label_65;
                    }
                    else {
                        goto label_63;
                    }
                }
                else if((Intrinsics.areEqual(this.maxAspectRatioInLandscape, EmbeddingAspectRatio.ALWAYS_ALLOW)) || (((float)v0)) * v4 / (((float)v10)) <= this.maxAspectRatioInLandscape.getValue$window_release()) {
                label_65:
                    v8 = 1;
                }
                else {
                label_63:
                    v8 = 0;
                }

                if(v2 == 0) {
                    return 0;
                }

                if(v3 == 0) {
                    return 0;
                }

                if(v9 == 0) {
                    return 0;
                }

                if(v8 == 0) {
                    return 0;
                }

                return 1;
            }
        }

        return 0;
    }

    public final boolean checkParentMetrics$window_release(Context arg4, WindowMetrics arg5) {
        Intrinsics.checkNotNullParameter(arg4, "context");
        Intrinsics.checkNotNullParameter(arg5, "parentMetrics");
        if(Build$VERSION.SDK_INT <= 30) {
            return 0;
        }

        Rect v0 = Api30Impl.INSTANCE.getBounds(arg5);
        float v4 = Build$VERSION.SDK_INT <= 33 ? arg4.getResources().getDisplayMetrics().density : Api34Impl.INSTANCE.getDensity(arg5, arg4);
        return this.checkParentBounds$window_release(v4, v0);
    }

    private final int convertDpToPx(float arg1, int arg2) {
        return ((int)((((float)arg2)) * arg1 + 0.5f));
    }

    public boolean equals(Object arg5) {
        if(this == (((SplitRule)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof SplitRule)) {
            return 0;
        }

        if(!super.equals(arg5)) {
            return 0;
        }

        if(this.minWidthDp != ((SplitRule)arg5).minWidthDp) {
            return 0;
        }

        if(this.minHeightDp != ((SplitRule)arg5).minHeightDp) {
            return 0;
        }

        if(this.minSmallestWidthDp != ((SplitRule)arg5).minSmallestWidthDp) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.maxAspectRatioInPortrait, ((SplitRule)arg5).maxAspectRatioInPortrait)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.maxAspectRatioInLandscape, ((SplitRule)arg5).maxAspectRatioInLandscape)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.defaultSplitAttributes, ((SplitRule)arg5).defaultSplitAttributes)) {
            return 0;
        }

        return 1;
    }

    public final SplitAttributes getDefaultSplitAttributes() {
        return this.defaultSplitAttributes;
    }

    public final EmbeddingAspectRatio getMaxAspectRatioInLandscape() {
        return this.maxAspectRatioInLandscape;
    }

    public final EmbeddingAspectRatio getMaxAspectRatioInPortrait() {
        return this.maxAspectRatioInPortrait;
    }

    public final int getMinHeightDp() {
        return this.minHeightDp;
    }

    public final int getMinSmallestWidthDp() {
        return this.minSmallestWidthDp;
    }

    public final int getMinWidthDp() {
        return this.minWidthDp;
    }

    public int hashCode() {
        return (((((super.hashCode() * 0x1F + this.minWidthDp) * 0x1F + this.minHeightDp) * 0x1F + this.minSmallestWidthDp) * 0x1F + this.maxAspectRatioInPortrait.hashCode()) * 0x1F + this.maxAspectRatioInLandscape.hashCode()) * 0x1F + this.defaultSplitAttributes.hashCode();
    }

    public String toString() {
        return "SplitRule{ tag=" + this.getTag() + ", defaultSplitAttributes=" + this.defaultSplitAttributes + ", minWidthDp=" + this.minWidthDp + ", minHeightDp=" + this.minHeightDp + ", minSmallestWidthDp=" + this.minSmallestWidthDp + ", maxAspectRatioInPortrait=" + this.maxAspectRatioInPortrait + ", maxAspectRatioInLandscape=" + this.maxAspectRatioInLandscape + '}';
    }
}

