package androidx.window.embedding;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.view.WindowMetrics;
import androidx.window.WindowSdkExtensions;
import androidx.window.core.Bounds;
import androidx.window.core.PredicateAdapter;
import androidx.window.extensions.core.util.function.Predicate;
import androidx.window.extensions.embedding.ActivityRule$Builder;
import androidx.window.extensions.embedding.ActivityRule;
import androidx.window.extensions.embedding.ActivityStack;
import androidx.window.extensions.embedding.AnimationBackground$ColorBackground;
import androidx.window.extensions.embedding.AnimationBackground;
import androidx.window.extensions.embedding.AnimationParams$Builder;
import androidx.window.extensions.embedding.AnimationParams;
import androidx.window.extensions.embedding.DividerAttributes$Builder;
import androidx.window.extensions.embedding.SplitAttributes$Builder;
import androidx.window.extensions.embedding.SplitAttributes$SplitType$ExpandContainersSplitType;
import androidx.window.extensions.embedding.SplitAttributes$SplitType$HingeSplitType;
import androidx.window.extensions.embedding.SplitAttributes$SplitType$RatioSplitType;
import androidx.window.extensions.embedding.SplitAttributes$SplitType;
import androidx.window.extensions.embedding.SplitInfo$Token;
import androidx.window.extensions.embedding.SplitInfo;
import androidx.window.extensions.embedding.SplitPairRule$Builder;
import androidx.window.extensions.embedding.SplitPairRule;
import androidx.window.extensions.embedding.SplitPinRule$Builder;
import androidx.window.extensions.embedding.SplitPinRule;
import androidx.window.extensions.embedding.SplitPlaceholderRule$Builder;
import androidx.window.extensions.embedding.SplitPlaceholderRule;
import androidx.window.extensions.embedding.WindowAttributes;
import androidx.window.extensions.layout.WindowLayoutInfo;
import androidx.window.layout.WindowMetricsCalculator;
import androidx.window.layout.adapter.extensions.ExtensionsWindowLayoutInfoAdapter;
import androidx.window.layout.util.DensityCompatHelper;
import androidx.window.reflection.JFunction2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000\u0086\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 d2\u00020\u0001:\u0004abcdB\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001A\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020\u001A0\u00192\f\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u001C0\u0019J\u0010\u0010\u0018\u001A\u00020\u001A2\u0006\u0010\u001D\u001A\u00020\u001CH\u0002J\u0015\u0010\u0018\u001A\u00020\u001E2\u0006\u0010\u001F\u001A\u00020 H\u0000¢\u0006\u0002\b!J!\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020\u001E0\u00192\f\u0010\"\u001A\b\u0012\u0004\u0012\u00020 0\u0019H\u0000¢\u0006\u0002\b!J\u0015\u0010\u0018\u001A\u00020#2\u0006\u0010$\u001A\u00020%H\u0000¢\u0006\u0002\b!J\u0015\u0010\u0018\u001A\u00020&2\u0006\u0010\'\u001A\u00020(H\u0001¢\u0006\u0002\b!J&\u0010)\u001A\u000E\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020%0*2\u0012\u0010,\u001A\u000E\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020#0-J\u0010\u0010\u0018\u001A\u00020.2\u0006\u0010/\u001A\u00020+H\u0007J$\u00100\u001A\u0002012\u0006\u00102\u001A\u0002032\u0006\u00104\u001A\u0002052\n\u00106\u001A\u0006\u0012\u0002\b\u000307H\u0002J\u0016\u00108\u001A\u0002092\u0006\u00102\u001A\u0002032\u0006\u0010:\u001A\u00020;J\u000E\u0010<\u001A\u00020%2\u0006\u0010$\u001A\u00020#J\r\u0010=\u001A\u00020>H\u0000¢\u0006\u0002\b?J\u0010\u0010@\u001A\u00020A2\u0006\u0010B\u001A\u00020CH\u0002J$\u0010D\u001A\u00020E2\u0006\u00102\u001A\u0002032\u0006\u00104\u001A\u00020F2\n\u00106\u001A\u0006\u0012\u0002\b\u000307H\u0002J\u000E\u0010G\u001A\u00020\u00072\u0006\u0010H\u001A\u00020IJ\u001C\u0010J\u001A\u00020K2\u0006\u00104\u001A\u00020L2\n\u00106\u001A\u0006\u0012\u0002\b\u000307H\u0002J\"\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020N0M2\u0006\u00102\u001A\u0002032\f\u0010O\u001A\b\u0012\u0004\u0012\u00020P0MJ\u0010\u0010Q\u001A\u00020R2\u0006\u0010S\u001A\u00020TH\u0003J\u0010\u0010U\u001A\u00020T2\u0006\u0010S\u001A\u00020RH\u0003J\u0010\u0010V\u001A\u00020\u00072\u0006\u0010W\u001A\u00020XH\u0003J\u0010\u0010Y\u001A\u00020X2\u0006\u0010Z\u001A\u00020\u0007H\u0003J\u0012\u0010[\u001A\u0004\u0018\u00010\\2\u0006\u0010]\u001A\u00020^H\u0007J\u0012\u0010_\u001A\u00020^2\b\u0010`\u001A\u0004\u0018\u00010\\H\u0007R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001A\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\tR\u0012\u0010\n\u001A\u00060\u000BR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001A\u00060\rR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000E\u001A\u00060\u000FR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0010\u001A\u0004\u0018\u00010\u0011X\u0086\u000E¢\u0006\u0014\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006e"}, d2={"Landroidx/window/embedding/EmbeddingAdapter;", "", "predicateAdapter", "Landroidx/window/core/PredicateAdapter;", "<init>", "(Landroidx/window/core/PredicateAdapter;)V", "extensionVersion", "", "getExtensionVersion", "()I", "api1Impl", "Landroidx/window/embedding/EmbeddingAdapter$VendorApiLevel1Impl;", "api2Impl", "Landroidx/window/embedding/EmbeddingAdapter$VendorApiLevel2Impl;", "api3Impl", "Landroidx/window/embedding/EmbeddingAdapter$VendorApiLevel3Impl;", "embeddingConfiguration", "Landroidx/window/embedding/EmbeddingConfiguration;", "getEmbeddingConfiguration$annotations", "()V", "getEmbeddingConfiguration", "()Landroidx/window/embedding/EmbeddingConfiguration;", "setEmbeddingConfiguration", "(Landroidx/window/embedding/EmbeddingConfiguration;)V", "translate", "", "Landroidx/window/embedding/SplitInfo;", "splitInfoList", "Landroidx/window/extensions/embedding/SplitInfo;", "splitInfo", "Landroidx/window/embedding/ActivityStack;", "activityStack", "Landroidx/window/extensions/embedding/ActivityStack;", "translate$window_release", "activityStacks", "Landroidx/window/embedding/SplitAttributes;", "splitAttributes", "Landroidx/window/extensions/embedding/SplitAttributes;", "Landroidx/window/embedding/ParentContainerInfo;", "parentContainerInfo", "Landroidx/window/extensions/embedding/ParentContainerInfo;", "translateSplitAttributesCalculator", "Landroidx/window/reflection/JFunction2;", "Landroidx/window/extensions/embedding/SplitAttributesCalculatorParams;", "calculator", "Lkotlin/Function1;", "Landroidx/window/embedding/SplitAttributesCalculatorParams;", "params", "translateSplitPairRule", "Landroidx/window/extensions/embedding/SplitPairRule;", "context", "Landroid/content/Context;", "rule", "Landroidx/window/embedding/SplitPairRule;", "predicateClass", "Ljava/lang/Class;", "translateSplitPinRule", "Landroidx/window/extensions/embedding/SplitPinRule;", "splitPinRule", "Landroidx/window/embedding/SplitPinRule;", "translateSplitAttributes", "translateWindowAttributes", "Landroidx/window/extensions/embedding/WindowAttributes;", "translateWindowAttributes$window_release", "translateSplitType", "Landroidx/window/extensions/embedding/SplitAttributes$SplitType;", "splitType", "Landroidx/window/embedding/SplitAttributes$SplitType;", "translateSplitPlaceholderRule", "Landroidx/window/extensions/embedding/SplitPlaceholderRule;", "Landroidx/window/embedding/SplitPlaceholderRule;", "translateFinishBehavior", "behavior", "Landroidx/window/embedding/SplitRule$FinishBehavior;", "translateActivityRule", "Landroidx/window/extensions/embedding/ActivityRule;", "Landroidx/window/embedding/ActivityRule;", "", "Landroidx/window/extensions/embedding/EmbeddingRule;", "rules", "Landroidx/window/embedding/EmbeddingRule;", "translateToOemAnimationBackground", "Landroidx/window/extensions/embedding/AnimationBackground;", "animationBackground", "Landroidx/window/embedding/EmbeddingAnimationBackground;", "translateToJetpackAnimationBackground", "translateToOemAnimationResId", "animationSpec", "Landroidx/window/embedding/EmbeddingAnimationParams$AnimationSpec;", "translateToJetpackAnimationSpec", "animationResId", "translateToOemDividerAttributes", "Landroidx/window/extensions/embedding/DividerAttributes;", "dividerAttributes", "Landroidx/window/embedding/DividerAttributes;", "translateToJetpackDividerAttributes", "oemDividerAttributes", "VendorApiLevel3Impl", "VendorApiLevel2Impl", "VendorApiLevel1Impl", "Companion", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class EmbeddingAdapter {
    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\r\u001A\u00020\u00052\u0006\u0010\u000E\u001A\u00020\u000FJ\u000E\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0005R\u0010\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001A\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\f¨\u0006\u0013"}, d2={"Landroidx/window/embedding/EmbeddingAdapter$Companion;", "", "<init>", "()V", "TAG", "", "RULE_TAG_PREFIX", "getRULE_TAG_PREFIX", "()Ljava/lang/String;", "INVALID_SPLIT_INFO_TOKEN", "Landroid/os/Binder;", "getINVALID_SPLIT_INFO_TOKEN", "()Landroid/os/Binder;", "generateTag", "rule", "Landroidx/window/embedding/EmbeddingRule;", "isTagGenerated", "", "tag", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final String generateTag(EmbeddingRule arg2) {
            Intrinsics.checkNotNullParameter(arg2, "rule");
            return this.getRULE_TAG_PREFIX() + Integer.toHexString(arg2.hashCode());
        }

        public final Binder getINVALID_SPLIT_INFO_TOKEN() {
            return EmbeddingAdapter.INVALID_SPLIT_INFO_TOKEN;
        }

        public final String getRULE_TAG_PREFIX() {
            return EmbeddingAdapter.RULE_TAG_PREFIX;
        }

        public final boolean isTagGenerated(String arg2) {
            Intrinsics.checkNotNullParameter(arg2, "tag");
            String v1 = StringsKt.removePrefix(arg2, this.getRULE_TAG_PREFIX());
            if(!Intrinsics.areEqual(v1, arg2) && StringsKt.toIntOrNull(v1, 16) != null) {
                return 1;
            }

            return 0;
        }
    }

    @Metadata(d1={"\u0000\u009A\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000E\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BJ\u001A\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\n\u0010\u0010\u001A\u0006\u0012\u0002\b\u00030\u0011J\"\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u000E\u001A\u00020\u00162\n\u0010\u0010\u001A\u0006\u0012\u0002\b\u00030\u0011J\u0014\u0010\u0017\u001A\u00020\u0018*\u00020\u00182\u0006\u0010\u0019\u001A\u00020\tH\u0002J\"\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u000E\u001A\u00020\u001C2\n\u0010\u0010\u001A\u0006\u0012\u0002\b\u00030\u0011J\u0016\u0010\u001D\u001A\u00020\u00012\f\u0010\u001E\u001A\b\u0012\u0004\u0012\u00020 0\u001FH\u0003J\u0016\u0010!\u001A\u00020\u00012\f\u0010\u001E\u001A\b\u0012\u0004\u0012\u00020 0\u001FH\u0003J\u0014\u0010\u0017\u001A\u00020\"*\u00020\"2\u0006\u0010\u0019\u001A\u00020\tH\u0002J\u001C\u0010#\u001A\u000E\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0$2\u0006\u0010\'\u001A\u00020\tH\u0002J\u0010\u0010(\u001A\u00020)2\u0006\u0010\'\u001A\u00020\tH\u0002J\u0016\u0010*\u001A\u00020\u00012\f\u0010+\u001A\b\u0012\u0004\u0012\u00020,0\u001FH\u0003J\u0016\u0010-\u001A\u00020\u00012\f\u0010+\u001A\b\u0012\u0004\u0012\u00020,0\u001FH\u0003J\u0018\u0010.\u001A\u00020\u00012\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010/\u001A\u000200H\u0003J\u000E\u00101\u001A\u0002022\u0006\u0010\n\u001A\u00020\u000BJ\u000E\u00101\u001A\u0002032\u0006\u00104\u001A\u000205R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u00066"}, d2={"Landroidx/window/embedding/EmbeddingAdapter$VendorApiLevel1Impl;", "", "predicateAdapter", "Landroidx/window/core/PredicateAdapter;", "<init>", "(Landroidx/window/embedding/EmbeddingAdapter;Landroidx/window/core/PredicateAdapter;)V", "getPredicateAdapter", "()Landroidx/window/core/PredicateAdapter;", "getSplitAttributesCompat", "Landroidx/window/embedding/SplitAttributes;", "splitInfo", "Landroidx/window/extensions/embedding/SplitInfo;", "translateActivityRuleCompat", "Landroidx/window/extensions/embedding/ActivityRule;", "rule", "Landroidx/window/embedding/ActivityRule;", "predicateClass", "Ljava/lang/Class;", "translateSplitPlaceholderRuleCompat", "Landroidx/window/extensions/embedding/SplitPlaceholderRule;", "context", "Landroid/content/Context;", "Landroidx/window/embedding/SplitPlaceholderRule;", "setDefaultSplitAttributesCompat", "Landroidx/window/extensions/embedding/SplitPlaceholderRule$Builder;", "defaultAttrs", "translateSplitPairRuleCompat", "Landroidx/window/extensions/embedding/SplitPairRule;", "Landroidx/window/embedding/SplitPairRule;", "translateActivityPairPredicates", "splitPairFilters", "", "Landroidx/window/embedding/SplitPairFilter;", "translateActivityIntentPredicates", "Landroidx/window/extensions/embedding/SplitPairRule$Builder;", "translateSplitAttributesCompatInternal", "Lkotlin/Pair;", "", "", "attrs", "isSplitAttributesSupported", "", "translateActivityPredicates", "activityFilters", "Landroidx/window/embedding/ActivityFilter;", "translateIntentPredicates", "translateParentMetricsPredicate", "splitRule", "Landroidx/window/embedding/SplitRule;", "translateCompat", "Landroidx/window/embedding/SplitInfo;", "Landroidx/window/embedding/ActivityStack;", "activityStack", "Landroidx/window/extensions/embedding/ActivityStack;", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) final class VendorApiLevel1Impl {
        private final PredicateAdapter predicateAdapter;

        public VendorApiLevel1Impl(EmbeddingAdapter arg2, PredicateAdapter arg3) {
            Intrinsics.checkNotNullParameter(arg3, "predicateAdapter");
            EmbeddingAdapter.this = arg2;
            super();
            this.predicateAdapter = arg3;
        }

        public final PredicateAdapter getPredicateAdapter() {
            return this.predicateAdapter;
        }

        public final SplitAttributes getSplitAttributesCompat(SplitInfo arg2) {
            Intrinsics.checkNotNullParameter(arg2, "splitInfo");
            return new Builder().setSplitType(SplitType.Companion.buildSplitTypeFromValue$window_release(arg2.getSplitRatio())).setLayoutDirection(LayoutDirection.LOCALE).build();
        }

        private final boolean isSplitAttributesSupported(SplitAttributes arg6) {
            double v0 = ((double)arg6.getSplitType().getValue$window_release());
            if(Double.compare(0, v0) <= 0 && v0 <= 1) {
                if(arg6.getSplitType().getValue$window_release() == 1f) {
                }
                else if(ArraysKt.contains(new LayoutDirection[]{LayoutDirection.LEFT_TO_RIGHT, LayoutDirection.RIGHT_TO_LEFT, LayoutDirection.LOCALE}, arg6.getLayoutDirection())) {
                    return 1;
                }
            }

            return 0;
        }

        private final SplitPairRule$Builder setDefaultSplitAttributesCompat(SplitPairRule$Builder arg1, SplitAttributes arg2) {
            Pair v0 = this.translateSplitAttributesCompatInternal(arg2);
            float v2 = v0.component1().floatValue();
            int v0_1 = v0.component2().intValue();
            arg1.setSplitRatio(v2);
            arg1.setLayoutDirection(v0_1);
            return arg1;
        }

        private final SplitPlaceholderRule$Builder setDefaultSplitAttributesCompat(SplitPlaceholderRule$Builder arg1, SplitAttributes arg2) {
            Pair v0 = this.translateSplitAttributesCompatInternal(arg2);
            float v2 = v0.component1().floatValue();
            int v0_1 = v0.component2().intValue();
            arg1.setSplitRatio(v2);
            arg1.setLayoutDirection(v0_1);
            return arg1;
        }

        private final Object translateActivityIntentPredicates(Set arg4) {
            return this.predicateAdapter.buildPairPredicate(Reflection.getOrCreateKotlinClass(Activity.class), Reflection.getOrCreateKotlinClass(Intent.class), new EmbeddingAdapter$VendorApiLevel1Impl$$ExternalSyntheticLambda2(arg4));
        }

        static final boolean translateActivityIntentPredicates$lambda$4(Set arg2, Activity arg3, Intent arg4) {
            Intrinsics.checkNotNullParameter(arg3, "first");
            Intrinsics.checkNotNullParameter(arg4, "second");
            if(((arg2 instanceof Collection)) && (arg2.isEmpty())) {
                return 0;
            }

            Iterator v2 = ((Iterable)arg2).iterator();
            do {
                if(!v2.hasNext()) {
                    return 0;
                }
            }
            while(!v2.next().matchesActivityIntentPair(arg3, arg4));

            return 1;
        }

        private final Object translateActivityPairPredicates(Set arg4) {
            return this.predicateAdapter.buildPairPredicate(Reflection.getOrCreateKotlinClass(Activity.class), Reflection.getOrCreateKotlinClass(Activity.class), new EmbeddingAdapter$VendorApiLevel1Impl$$ExternalSyntheticLambda3(arg4));
        }

        static final boolean translateActivityPairPredicates$lambda$2(Set arg2, Activity arg3, Activity arg4) {
            Intrinsics.checkNotNullParameter(arg3, "first");
            Intrinsics.checkNotNullParameter(arg4, "second");
            if(((arg2 instanceof Collection)) && (arg2.isEmpty())) {
                return 0;
            }

            Iterator v2 = ((Iterable)arg2).iterator();
            do {
                if(!v2.hasNext()) {
                    return 0;
                }
            }
            while(!v2.next().matchesActivityPair(arg3, arg4));

            return 1;
        }

        private final Object translateActivityPredicates(Set arg3) {
            return this.predicateAdapter.buildPredicate(Reflection.getOrCreateKotlinClass(Activity.class), new EmbeddingAdapter$VendorApiLevel1Impl$$ExternalSyntheticLambda4(arg3));
        }

        static final boolean translateActivityPredicates$lambda$7(Set arg2, Activity arg3) {
            Intrinsics.checkNotNullParameter(arg3, "activity");
            if(((arg2 instanceof Collection)) && (arg2.isEmpty())) {
                return 0;
            }

            Iterator v2 = ((Iterable)arg2).iterator();
            do {
                if(!v2.hasNext()) {
                    return 0;
                }
            }
            while(!v2.next().matchesActivity(arg3));

            return 1;
        }

        public final ActivityRule translateActivityRuleCompat(androidx.window.embedding.ActivityRule arg4, Class arg5) {
            Intrinsics.checkNotNullParameter(arg4, "rule");
            Intrinsics.checkNotNullParameter(arg5, "predicateClass");
            ActivityRule v3 = ActivityRule$Builder.class.getConstructor(arg5, arg5).newInstance(this.translateActivityPredicates(arg4.getFilters()), this.translateIntentPredicates(arg4.getFilters())).setShouldAlwaysExpand(arg4.getAlwaysExpand()).build();
            Intrinsics.checkNotNullExpressionValue(v3, "build(...)");
            return v3;
        }

        public final androidx.window.embedding.SplitInfo translateCompat(SplitInfo arg5) {
            Intrinsics.checkNotNullParameter(arg5, "splitInfo");
            ActivityStack v1 = arg5.getPrimaryActivityStack();
            Intrinsics.checkNotNullExpressionValue(v1, "getPrimaryActivityStack(...)");
            androidx.window.embedding.ActivityStack v1_1 = this.translateCompat(v1);
            ActivityStack v2 = arg5.getSecondaryActivityStack();
            Intrinsics.checkNotNullExpressionValue(v2, "getSecondaryActivityStack(...)");
            return new androidx.window.embedding.SplitInfo(v1_1, this.translateCompat(v2), this.getSplitAttributesCompat(arg5));
        }

        public final androidx.window.embedding.ActivityStack translateCompat(ActivityStack arg3) {
            Intrinsics.checkNotNullParameter(arg3, "activityStack");
            List v0 = arg3.getActivities();
            Intrinsics.checkNotNullExpressionValue(v0, "getActivities(...)");
            return new androidx.window.embedding.ActivityStack(v0, arg3.isEmpty());
        }

        private final Object translateIntentPredicates(Set arg3) {
            return this.predicateAdapter.buildPredicate(Reflection.getOrCreateKotlinClass(Intent.class), new EmbeddingAdapter$VendorApiLevel1Impl$$ExternalSyntheticLambda0(arg3));
        }

        static final boolean translateIntentPredicates$lambda$9(Set arg2, Intent arg3) {
            Intrinsics.checkNotNullParameter(arg3, "intent");
            if(((arg2 instanceof Collection)) && (arg2.isEmpty())) {
                return 0;
            }

            Iterator v2 = ((Iterable)arg2).iterator();
            do {
                if(!v2.hasNext()) {
                    return 0;
                }
            }
            while(!v2.next().matchesIntent(arg3));

            return 1;
        }

        private final Object translateParentMetricsPredicate(Context arg3, SplitRule arg4) {
            return this.predicateAdapter.buildPredicate(Reflection.getOrCreateKotlinClass(WindowMetrics.class), new EmbeddingAdapter$VendorApiLevel1Impl$$ExternalSyntheticLambda1(arg4, arg3));
        }

        static final boolean translateParentMetricsPredicate$lambda$10(SplitRule arg1, Context arg2, WindowMetrics arg3) {
            Intrinsics.checkNotNullParameter(arg3, "windowMetrics");
            return arg1.checkParentMetrics$window_release(arg2, arg3);
        }

        private final Pair translateSplitAttributesCompatInternal(SplitAttributes arg4) {
            int v0 = 3;
            if(!this.isSplitAttributesSupported(arg4)) {
                return new Pair(Float.valueOf(0f), Integer.valueOf(v0));
            }

            Float v1 = Float.valueOf(arg4.getSplitType().getValue$window_release());
            LayoutDirection v4 = arg4.getLayoutDirection();
            if(Intrinsics.areEqual(v4, LayoutDirection.LOCALE)) {
            }
            else if(Intrinsics.areEqual(v4, LayoutDirection.LEFT_TO_RIGHT)) {
                v0 = 0;
            }
            else if(Intrinsics.areEqual(v4, LayoutDirection.RIGHT_TO_LEFT)) {
                v0 = 1;
            }
            else {
                goto label_30;
            }

            return new Pair(v1, Integer.valueOf(v0));
        label_30:
            throw new IllegalStateException("Unsupported layout direction must be covered in @isSplitAttributesSupported!");
        }

        public final SplitPairRule translateSplitPairRuleCompat(Context arg4, androidx.window.embedding.SplitPairRule arg5, Class arg6) {
            Intrinsics.checkNotNullParameter(arg4, "context");
            Intrinsics.checkNotNullParameter(arg5, "rule");
            Intrinsics.checkNotNullParameter(arg6, "predicateClass");
            Object v4 = SplitPairRule$Builder.class.getConstructor(arg6, arg6, arg6).newInstance(this.translateActivityPairPredicates(arg5.getFilters()), this.translateActivityIntentPredicates(arg5.getFilters()), this.translateParentMetricsPredicate(arg4, arg5));
            Intrinsics.checkNotNullExpressionValue(v4, "newInstance(...)");
            SplitPairRule v3 = this.setDefaultSplitAttributesCompat(((SplitPairRule$Builder)v4), arg5.getDefaultSplitAttributes()).setShouldClearTop(arg5.getClearTop()).setFinishPrimaryWithSecondary(EmbeddingAdapter.this.translateFinishBehavior(arg5.getFinishPrimaryWithSecondary())).setFinishSecondaryWithPrimary(EmbeddingAdapter.this.translateFinishBehavior(arg5.getFinishSecondaryWithPrimary())).build();
            Intrinsics.checkNotNullExpressionValue(v3, "build(...)");
            return v3;
        }

        public final SplitPlaceholderRule translateSplitPlaceholderRuleCompat(Context arg5, androidx.window.embedding.SplitPlaceholderRule arg6, Class arg7) {
            Intrinsics.checkNotNullParameter(arg5, "context");
            Intrinsics.checkNotNullParameter(arg6, "rule");
            Intrinsics.checkNotNullParameter(arg7, "predicateClass");
            SplitPlaceholderRule$Builder v5 = SplitPlaceholderRule$Builder.class.getConstructor(Intent.class, arg7, arg7, arg7).newInstance(arg6.getPlaceholderIntent(), this.translateActivityPredicates(arg6.getFilters()), this.translateIntentPredicates(arg6.getFilters()), this.translateParentMetricsPredicate(arg5, arg6)).setSticky(arg6.isSticky()).setFinishPrimaryWithSecondary(EmbeddingAdapter.this.translateFinishBehavior(arg6.getFinishPrimaryWithPlaceholder()));
            Intrinsics.checkNotNullExpressionValue(v5, "setFinishPrimaryWithSecondary(...)");
            SplitPlaceholderRule v4 = this.setDefaultSplitAttributesCompat(v5, arg6.getDefaultSplitAttributes()).build();
            Intrinsics.checkNotNullExpressionValue(v4, "build(...)");
            return v4;
        }
    }

    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007¨\u0006\b"}, d2={"Landroidx/window/embedding/EmbeddingAdapter$VendorApiLevel2Impl;", "", "<init>", "(Landroidx/window/embedding/EmbeddingAdapter;)V", "translateCompat", "Landroidx/window/embedding/SplitInfo;", "splitInfo", "Landroidx/window/extensions/embedding/SplitInfo;", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) final class VendorApiLevel2Impl {
        public VendorApiLevel2Impl(EmbeddingAdapter arg1) {
            EmbeddingAdapter.this = arg1;
            super();
        }

        public final androidx.window.embedding.SplitInfo translateCompat(SplitInfo arg6) {
            Intrinsics.checkNotNullParameter(arg6, "splitInfo");
            VendorApiLevel1Impl v1 = EmbeddingAdapter.this.api1Impl;
            ActivityStack v2 = arg6.getPrimaryActivityStack();
            Intrinsics.checkNotNullExpressionValue(v2, "getPrimaryActivityStack(...)");
            androidx.window.embedding.ActivityStack v1_1 = v1.translateCompat(v2);
            VendorApiLevel1Impl v2_1 = EmbeddingAdapter.this.api1Impl;
            ActivityStack v3 = arg6.getSecondaryActivityStack();
            Intrinsics.checkNotNullExpressionValue(v3, "getSecondaryActivityStack(...)");
            androidx.window.embedding.ActivityStack v2_2 = v2_1.translateCompat(v3);
            EmbeddingAdapter v5 = EmbeddingAdapter.this;
            androidx.window.extensions.embedding.SplitAttributes v6 = arg6.getSplitAttributes();
            Intrinsics.checkNotNullExpressionValue(v6, "getSplitAttributes(...)");
            return new androidx.window.embedding.SplitInfo(v1_1, v2_2, v5.translate$window_release(v6));
        }
    }

    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007¨\u0006\b"}, d2={"Landroidx/window/embedding/EmbeddingAdapter$VendorApiLevel3Impl;", "", "<init>", "(Landroidx/window/embedding/EmbeddingAdapter;)V", "translateCompat", "Landroidx/window/embedding/SplitInfo;", "splitInfo", "Landroidx/window/extensions/embedding/SplitInfo;", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) final class VendorApiLevel3Impl {
        public VendorApiLevel3Impl(EmbeddingAdapter arg1) {
            EmbeddingAdapter.this = arg1;
            super();
        }

        public final androidx.window.embedding.SplitInfo translateCompat(SplitInfo arg6) {
            Intrinsics.checkNotNullParameter(arg6, "splitInfo");
            VendorApiLevel1Impl v1 = EmbeddingAdapter.this.api1Impl;
            ActivityStack v2 = arg6.getPrimaryActivityStack();
            Intrinsics.checkNotNullExpressionValue(v2, "getPrimaryActivityStack(...)");
            androidx.window.embedding.ActivityStack v1_1 = v1.translateCompat(v2);
            VendorApiLevel1Impl v2_1 = EmbeddingAdapter.this.api1Impl;
            ActivityStack v3 = arg6.getSecondaryActivityStack();
            Intrinsics.checkNotNullExpressionValue(v3, "getSecondaryActivityStack(...)");
            androidx.window.embedding.ActivityStack v2_2 = v2_1.translateCompat(v3);
            EmbeddingAdapter v5 = EmbeddingAdapter.this;
            androidx.window.extensions.embedding.SplitAttributes v3_1 = arg6.getSplitAttributes();
            Intrinsics.checkNotNullExpressionValue(v3_1, "getSplitAttributes(...)");
            SplitAttributes v5_1 = v5.translate$window_release(v3_1);
            IBinder v6 = arg6.getToken();
            Intrinsics.checkNotNullExpressionValue(v6, "getToken(...)");
            return new androidx.window.embedding.SplitInfo(v1_1, v2_2, v5_1, v6);
        }
    }

    public static final Companion Companion;
    private static final Binder INVALID_SPLIT_INFO_TOKEN;
    private static final String RULE_TAG_PREFIX;
    private static final String TAG;
    private final VendorApiLevel1Impl api1Impl;
    private final VendorApiLevel2Impl api2Impl;
    private final VendorApiLevel3Impl api3Impl;
    private EmbeddingConfiguration embeddingConfiguration;
    private final PredicateAdapter predicateAdapter;

    static {
        EmbeddingAdapter.Companion = new Companion(null);
        EmbeddingAdapter.TAG = Reflection.getOrCreateKotlinClass(EmbeddingAdapter.class).getSimpleName();
        EmbeddingAdapter.RULE_TAG_PREFIX = "ae-gen:";
        EmbeddingAdapter.INVALID_SPLIT_INFO_TOKEN = new Binder();
    }

    public EmbeddingAdapter(PredicateAdapter arg2) {
        Intrinsics.checkNotNullParameter(arg2, "predicateAdapter");
        super();
        this.predicateAdapter = arg2;
        this.api1Impl = new VendorApiLevel1Impl(this, arg2);
        this.api2Impl = new VendorApiLevel2Impl(this);
        this.api3Impl = new VendorApiLevel3Impl(this);
    }

    public static final VendorApiLevel1Impl access$getApi1Impl$p(EmbeddingAdapter arg0) {
        return arg0.api1Impl;
    }

    public static final Binder access$getINVALID_SPLIT_INFO_TOKEN$cp() {
        return EmbeddingAdapter.INVALID_SPLIT_INFO_TOKEN;
    }

    public static final String access$getRULE_TAG_PREFIX$cp() {
        return EmbeddingAdapter.RULE_TAG_PREFIX;
    }

    public final EmbeddingConfiguration getEmbeddingConfiguration() {
        return this.embeddingConfiguration;
    }

    public static void getEmbeddingConfiguration$annotations() {
    }

    private final int getExtensionVersion() {
        return WindowSdkExtensions.Companion.getInstance().getExtensionVersion();
    }

    public final void setEmbeddingConfiguration(EmbeddingConfiguration arg1) {
        this.embeddingConfiguration = arg1;
    }

    private final androidx.window.embedding.SplitInfo translate(SplitInfo arg6) {
        int v0 = this.getExtensionVersion();
        if(v0 == 1) {
            return this.api1Impl.translateCompat(arg6);
        }

        if(v0 == 2) {
            return this.api2Impl.translateCompat(arg6);
        }

        if(3 <= v0 && v0 < 5) {
            return this.api3Impl.translateCompat(arg6);
        }

        ActivityStack v1 = arg6.getPrimaryActivityStack();
        Intrinsics.checkNotNullExpressionValue(v1, "getPrimaryActivityStack(...)");
        androidx.window.embedding.ActivityStack v1_1 = this.translate$window_release(v1);
        ActivityStack v2 = arg6.getSecondaryActivityStack();
        Intrinsics.checkNotNullExpressionValue(v2, "getSecondaryActivityStack(...)");
        androidx.window.embedding.ActivityStack v2_1 = this.translate$window_release(v2);
        androidx.window.extensions.embedding.SplitAttributes v3 = arg6.getSplitAttributes();
        Intrinsics.checkNotNullExpressionValue(v3, "getSplitAttributes(...)");
        SplitAttributes v5 = this.translate$window_release(v3);
        SplitInfo$Token v6 = arg6.getSplitInfoToken();
        Intrinsics.checkNotNullExpressionValue(v6, "getSplitInfoToken(...)");
        return new androidx.window.embedding.SplitInfo(v1_1, v2_1, v5, v6);
    }

    public final SplitAttributesCalculatorParams translate(androidx.window.extensions.embedding.SplitAttributesCalculatorParams arg10) {
        String v10;
        Intrinsics.checkNotNullParameter(arg10, "params");
        WindowMetrics v0 = arg10.getParentWindowMetrics();
        Intrinsics.checkNotNullExpressionValue(v0, "getParentWindowMetrics(...)");
        Configuration v4 = arg10.getParentConfiguration();
        Intrinsics.checkNotNullExpressionValue(v4, "getParentConfiguration(...)");
        WindowLayoutInfo v1 = arg10.getParentWindowLayoutInfo();
        Intrinsics.checkNotNullExpressionValue(v1, "getParentWindowLayoutInfo(...)");
        androidx.window.extensions.embedding.SplitAttributes v2 = arg10.getDefaultSplitAttributes();
        Intrinsics.checkNotNullExpressionValue(v2, "getDefaultSplitAttributes(...)");
        boolean v7 = arg10.areDefaultConstraintsSatisfied();
        if(arg10.getSplitRuleTag() != null) {
            Companion v3 = EmbeddingAdapter.Companion;
            String v5 = arg10.getSplitRuleTag();
            Intrinsics.checkNotNull(v5);
            if(v3.isTagGenerated(v5)) {
                goto label_26;
            }
            else {
                v10 = arg10.getSplitRuleTag();
            }
        }
        else {
        label_26:
            v10 = null;
        }

        androidx.window.layout.WindowMetrics v3_1 = WindowMetricsCalculator.Companion.translateWindowMetrics$window_release(v0, DensityCompatHelper.Companion.getInstance().density(v4, v0));
        return new SplitAttributesCalculatorParams(v3_1, v4, ExtensionsWindowLayoutInfoAdapter.INSTANCE.translate$window_release(v3_1, v1), this.translate$window_release(v2), v7, v10);
    }

    public final List translate(List arg3) {
        Intrinsics.checkNotNullParameter(arg3, "splitInfoList");
        ArrayList v0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)arg3), 10));
        Iterator v3 = ((Iterable)arg3).iterator();
        while(v3.hasNext()) {
            ((Collection)v0).add(this.translate(v3.next()));
        }

        return ((List)v0);
    }

    public final Set translate(Context arg5, Set arg6) {
        ActivityRule v2_3;
        Intrinsics.checkNotNullParameter(arg5, "context");
        Intrinsics.checkNotNullParameter(arg6, "rules");
        Class v0 = this.predicateAdapter.predicateClassOrNull$window_release();
        if(v0 == null) {
            return SetsKt.emptySet();
        }

        ArrayList v1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)arg6), 10));
        Iterator v6 = ((Iterable)arg6).iterator();
        while(true) {
            if(!v6.hasNext()) {
                goto label_34;
            }

            Object v2 = v6.next();
            if((v2 instanceof androidx.window.embedding.SplitPairRule)) {
                SplitPairRule v2_1 = this.translateSplitPairRule(arg5, ((androidx.window.embedding.SplitPairRule)v2), v0);
            }
            else if((v2 instanceof androidx.window.embedding.SplitPlaceholderRule)) {
                SplitPlaceholderRule v2_2 = this.translateSplitPlaceholderRule(arg5, ((androidx.window.embedding.SplitPlaceholderRule)v2), v0);
            }
            else if((v2 instanceof androidx.window.embedding.ActivityRule)) {
                v2_3 = this.translateActivityRule(((androidx.window.embedding.ActivityRule)v2), v0);
            }
            else {
                break;
            }

            ((Collection)v1).add(v2_3);
        }

        throw new IllegalArgumentException("Unsupported rule type");
    label_34:
        return CollectionsKt.toSet(((Iterable)v1));
    }

    public final List translate$window_release(List arg3) {
        Intrinsics.checkNotNullParameter(arg3, "activityStacks");
        ArrayList v0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)arg3), 10));
        Iterator v3 = ((Iterable)arg3).iterator();
        while(v3.hasNext()) {
            ((Collection)v0).add(this.translate$window_release(v3.next()));
        }

        return ((List)v0);
    }

    public final androidx.window.embedding.ActivityStack translate$window_release(ActivityStack arg3) {
        Intrinsics.checkNotNullParameter(arg3, "activityStack");
        int v0 = this.getExtensionVersion();
        if(1 <= v0 && v0 < 5) {
            return this.api1Impl.translateCompat(arg3);
        }

        List v0_1 = arg3.getActivities();
        Intrinsics.checkNotNullExpressionValue(v0_1, "getActivities(...)");
        return new androidx.window.embedding.ActivityStack(v0_1, arg3.isEmpty(), arg3.getActivityStackToken());
    }

    public final SplitAttributes translate$window_release(androidx.window.extensions.embedding.SplitAttributes arg6) {
        AnimationBackground v2_1;
        androidx.window.embedding.EmbeddingAnimationParams$Builder v1_4;
        LayoutDirection v1_3;
        SplitType v1_1;
        Intrinsics.checkNotNullParameter(arg6, "splitAttributes");
        Builder v0 = new Builder();
        SplitAttributes$SplitType v1 = arg6.getSplitType();
        Intrinsics.checkNotNullExpressionValue(v1, "getSplitType(...)");
        if((v1 instanceof SplitAttributes$SplitType$HingeSplitType)) {
            v1_1 = SplitType.SPLIT_TYPE_HINGE;
        }
        else if((v1 instanceof SplitAttributes$SplitType$ExpandContainersSplitType)) {
            v1_1 = SplitType.SPLIT_TYPE_EXPAND;
        }
        else if((v1 instanceof SplitAttributes$SplitType$RatioSplitType)) {
            v1_1 = SplitType.Companion.ratio(((SplitAttributes$SplitType$RatioSplitType)v1).getRatio());
        }
        else {
            goto label_93;
        }

        v0 = v0.setSplitType(v1_1);
        int v1_2 = arg6.getLayoutDirection();
        int v2 = 5;
        if(v1_2 == 0) {
            v1_3 = LayoutDirection.LEFT_TO_RIGHT;
        }
        else if(v1_2 == 1) {
            v1_3 = LayoutDirection.RIGHT_TO_LEFT;
        }
        else if(v1_2 == 3) {
            v1_3 = LayoutDirection.LOCALE;
        }
        else if(v1_2 == 4) {
            v1_3 = LayoutDirection.TOP_TO_BOTTOM;
        }
        else if(v1_2 == v2) {
            v1_3 = LayoutDirection.BOTTOM_TO_TOP;
        }
        else {
            throw new IllegalArgumentException("Unknown layout direction: " + v1_2);
        }

        v0 = v0.setLayoutDirection(v1_3);
        v1_2 = this.getExtensionVersion();
        String v3 = "getAnimationBackground(...)";
        int v4 = 7;
        if(v2 <= v1_2 && v1_2 < v4) {
            v1_4 = new androidx.window.embedding.EmbeddingAnimationParams$Builder();
            v2_1 = arg6.getAnimationBackground();
            Intrinsics.checkNotNullExpressionValue(v2_1, v3);
            v0.setAnimationParams(v1_4.setAnimationBackground(this.translateToJetpackAnimationBackground(v2_1)).build());
        }

        if(this.getExtensionVersion() >= v4) {
            v1_4 = new androidx.window.embedding.EmbeddingAnimationParams$Builder();
            v2_1 = arg6.getAnimationParams().getAnimationBackground();
            Intrinsics.checkNotNullExpressionValue(v2_1, v3);
            v0.setAnimationParams(v1_4.setAnimationBackground(this.translateToJetpackAnimationBackground(v2_1)).setOpenAnimation(this.translateToJetpackAnimationSpec(arg6.getAnimationParams().getOpenAnimationResId())).setCloseAnimation(this.translateToJetpackAnimationSpec(arg6.getAnimationParams().getCloseAnimationResId())).setChangeAnimation(this.translateToJetpackAnimationSpec(arg6.getAnimationParams().getChangeAnimationResId())).build());
        }

        if(this.getExtensionVersion() >= 6) {
            v0.setDividerAttributes(this.translateToJetpackDividerAttributes(arg6.getDividerAttributes()));
        }

        return v0.build();
    label_93:
        throw new IllegalArgumentException("Unknown split type: " + v1);
    }

    public final ParentContainerInfo translate$window_release(androidx.window.extensions.embedding.ParentContainerInfo arg7) {
        Intrinsics.checkNotNullParameter(arg7, "parentContainerInfo");
        Configuration v6 = arg7.getConfiguration();
        Intrinsics.checkNotNullExpressionValue(v6, "getConfiguration(...)");
        DensityCompatHelper v1 = DensityCompatHelper.Companion.getInstance();
        Configuration v2 = arg7.getConfiguration();
        Intrinsics.checkNotNullExpressionValue(v2, "getConfiguration(...)");
        WindowMetrics v0 = arg7.getWindowMetrics();
        Intrinsics.checkNotNullExpressionValue(v0, "getWindowMetrics(...)");
        float v0_1 = v1.density(v2, v0);
        androidx.window.layout.WindowMetricsCalculator$Companion v1_1 = WindowMetricsCalculator.Companion;
        WindowMetrics v2_1 = arg7.getWindowMetrics();
        Intrinsics.checkNotNullExpressionValue(v2_1, "getWindowMetrics(...)");
        androidx.window.layout.WindowMetrics v1_2 = v1_1.translateWindowMetrics$window_release(v2_1, v0_1);
        Bounds v3 = new Bounds(v1_2.getBounds());
        ExtensionsWindowLayoutInfoAdapter v4 = ExtensionsWindowLayoutInfoAdapter.INSTANCE;
        WindowLayoutInfo v7 = arg7.getWindowLayoutInfo();
        Intrinsics.checkNotNullExpressionValue(v7, "getWindowLayoutInfo(...)");
        return new ParentContainerInfo(v3, v4.translate$window_release(v1_2, v7), v6, v0_1);
    }

    private final ActivityRule translateActivityRule(androidx.window.embedding.ActivityRule arg3, Class arg4) {
        if(this.getExtensionVersion() < 2) {
            return this.api1Impl.translateActivityRuleCompat(arg3, arg4);
        }

        ActivityRule$Builder v2 = new ActivityRule$Builder(new EmbeddingAdapter$$ExternalSyntheticLambda8(arg3), new EmbeddingAdapter$$ExternalSyntheticLambda9(arg3)).setShouldAlwaysExpand(arg3.getAlwaysExpand());
        Intrinsics.checkNotNullExpressionValue(v2, "setShouldAlwaysExpand(...)");
        String v4 = arg3.getTag();
        if(v4 == null) {
            v4 = EmbeddingAdapter.Companion.generateTag(((EmbeddingRule)arg3));
        }

        v2.setTag(v4);
        ActivityRule v2_1 = v2.build();
        Intrinsics.checkNotNullExpressionValue(v2_1, "build(...)");
        return v2_1;
    }

    static final boolean translateActivityRule$lambda$16(androidx.window.embedding.ActivityRule arg2, Activity arg3) {
        Intrinsics.checkNotNullParameter(arg3, "activity");
        Set v2 = arg2.getFilters();
        if(((v2 instanceof Collection)) && (v2.isEmpty())) {
            return 0;
        }

        Iterator v2_1 = ((Iterable)v2).iterator();
        do {
            if(!v2_1.hasNext()) {
                return 0;
            }
        }
        while(!v2_1.next().matchesActivity(arg3));

        return 1;
    }

    static final boolean translateActivityRule$lambda$18(androidx.window.embedding.ActivityRule arg2, Intent arg3) {
        Intrinsics.checkNotNullParameter(arg3, "intent");
        Set v2 = arg2.getFilters();
        if(((v2 instanceof Collection)) && (v2.isEmpty())) {
            return 0;
        }

        Iterator v2_1 = ((Iterable)v2).iterator();
        do {
            if(!v2_1.hasNext()) {
                return 0;
            }
        }
        while(!v2_1.next().matchesIntent(arg3));

        return 1;
    }

    public final int translateFinishBehavior(FinishBehavior arg3) {
        Intrinsics.checkNotNullParameter(arg3, "behavior");
        if(Intrinsics.areEqual(arg3, FinishBehavior.NEVER)) {
            return 0;
        }

        if(Intrinsics.areEqual(arg3, FinishBehavior.ALWAYS)) {
            return 1;
        }

        if(Intrinsics.areEqual(arg3, FinishBehavior.ADJACENT)) {
            return 2;
        }

        throw new IllegalArgumentException("Unknown finish behavior:" + arg3);
    }

    public final androidx.window.extensions.embedding.SplitAttributes translateSplitAttributes(SplitAttributes arg5) {
        int v1_1;
        Intrinsics.checkNotNullParameter(arg5, "splitAttributes");
        if(this.getExtensionVersion() < 2) {
            goto label_94;
        }

        SplitAttributes$Builder v0 = new SplitAttributes$Builder().setSplitType(this.translateSplitType(arg5.getSplitType()));
        LayoutDirection v1 = arg5.getLayoutDirection();
        int v3 = 5;
        if(Intrinsics.areEqual(v1, LayoutDirection.LOCALE)) {
            v1_1 = 3;
        }
        else if(Intrinsics.areEqual(v1, LayoutDirection.LEFT_TO_RIGHT)) {
            v1_1 = 0;
        }
        else if(Intrinsics.areEqual(v1, LayoutDirection.RIGHT_TO_LEFT)) {
            v1_1 = 1;
        }
        else if(Intrinsics.areEqual(v1, LayoutDirection.TOP_TO_BOTTOM)) {
            v1_1 = 4;
        }
        else if(Intrinsics.areEqual(v1, LayoutDirection.BOTTOM_TO_TOP)) {
            v1_1 = v3;
        }
        else {
            goto label_84;
        }

        v0 = v0.setLayoutDirection(v1_1);
        Intrinsics.checkNotNullExpressionValue(v0, "setLayoutDirection(...)");
        if(this.getExtensionVersion() >= v3) {
            v0.setWindowAttributes(this.translateWindowAttributes$window_release());
        }

        v1_1 = this.getExtensionVersion();
        int v2 = 7;
        if(v3 <= v1_1 && v1_1 < v2) {
            v0.setAnimationBackground(this.translateToOemAnimationBackground(arg5.getAnimationParams().getAnimationBackground()));
        }

        String v3_1 = "build(...)";
        if(this.getExtensionVersion() >= v2) {
            AnimationParams v1_2 = new AnimationParams$Builder().setAnimationBackground(this.translateToOemAnimationBackground(arg5.getAnimationParams().getAnimationBackground())).setOpenAnimationResId(this.translateToOemAnimationResId(arg5.getAnimationParams().getOpenAnimation())).setCloseAnimationResId(this.translateToOemAnimationResId(arg5.getAnimationParams().getCloseAnimation())).setChangeAnimationResId(this.translateToOemAnimationResId(arg5.getAnimationParams().getChangeAnimation())).build();
            Intrinsics.checkNotNullExpressionValue(v1_2, v3_1);
            v0.setAnimationParams(v1_2);
        }

        if(this.getExtensionVersion() >= 6) {
            v0.setDividerAttributes(this.translateToOemDividerAttributes(arg5.getDividerAttributes()));
        }

        androidx.window.extensions.embedding.SplitAttributes v4 = v0.build();
        Intrinsics.checkNotNullExpressionValue(v4, v3_1);
        return v4;
    label_84:
        throw new IllegalArgumentException("Unsupported layoutDirection:" + arg5 + ".layoutDirection");
    label_94:
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final JFunction2 translateSplitAttributesCalculator(Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "calculator");
        return new EmbeddingAdapter$$ExternalSyntheticLambda1(this, arg2);
    }

    static final androidx.window.extensions.embedding.SplitAttributes translateSplitAttributesCalculator$lambda$1(EmbeddingAdapter arg1, Function1 arg2, androidx.window.extensions.embedding.SplitAttributesCalculatorParams arg3) {
        Intrinsics.checkNotNullParameter(arg3, "oemParams");
        return arg1.translateSplitAttributes(arg2.invoke(arg1.translate(arg3)));
    }

    private final SplitPairRule translateSplitPairRule(Context arg4, androidx.window.embedding.SplitPairRule arg5, Class arg6) {
        if(this.getExtensionVersion() < 2) {
            return this.api1Impl.translateSplitPairRuleCompat(arg4, arg5, arg6);
        }

        EmbeddingAdapter$$ExternalSyntheticLambda5 v6 = new EmbeddingAdapter$$ExternalSyntheticLambda5(arg5);
        EmbeddingAdapter$$ExternalSyntheticLambda6 v0 = new EmbeddingAdapter$$ExternalSyntheticLambda6(arg5);
        EmbeddingAdapter$$ExternalSyntheticLambda7 v1 = new EmbeddingAdapter$$ExternalSyntheticLambda7(arg5, arg4);
        String v4 = arg5.getTag();
        SplitPairRule$Builder v3 = new SplitPairRule$Builder(((Predicate)v6), ((Predicate)v0), ((Predicate)v1)).setDefaultSplitAttributes(this.translateSplitAttributes(arg5.getDefaultSplitAttributes())).setFinishPrimaryWithSecondary(this.translateFinishBehavior(arg5.getFinishPrimaryWithSecondary())).setFinishSecondaryWithPrimary(this.translateFinishBehavior(arg5.getFinishSecondaryWithPrimary())).setShouldClearTop(arg5.getClearTop());
        Intrinsics.checkNotNullExpressionValue(v3, "setShouldClearTop(...)");
        if(v4 == null) {
            v4 = EmbeddingAdapter.Companion.generateTag(((EmbeddingRule)arg5));
        }

        v3.setTag(v4);
        SplitPairRule v3_1 = v3.build();
        Intrinsics.checkNotNullExpressionValue(v3_1, "build(...)");
        return v3_1;
    }

    static final boolean translateSplitPairRule$lambda$4(androidx.window.embedding.SplitPairRule arg5, android.util.Pair arg6) {
        Intrinsics.checkNotNullParameter(arg6, "activitiesPair");
        Set v5 = arg5.getFilters();
        if(((v5 instanceof Collection)) && (v5.isEmpty())) {
            return 0;
        }

        Iterator v5_1 = ((Iterable)v5).iterator();
        do {
            if(!v5_1.hasNext()) {
                return 0;
            }

            Object v0 = v5_1.next();
            Object v2 = arg6.first;
            Intrinsics.checkNotNullExpressionValue(v2, "first");
            Object v3 = arg6.second;
            Intrinsics.checkNotNullExpressionValue(v3, "second");
        }
        while(!((SplitPairFilter)v0).matchesActivityPair(((Activity)v2), ((Activity)v3)));

        return 1;
    }

    static final boolean translateSplitPairRule$lambda$6(androidx.window.embedding.SplitPairRule arg5, android.util.Pair arg6) {
        Intrinsics.checkNotNullParameter(arg6, "activityIntentPair");
        Set v5 = arg5.getFilters();
        if(((v5 instanceof Collection)) && (v5.isEmpty())) {
            return 0;
        }

        Iterator v5_1 = ((Iterable)v5).iterator();
        do {
            if(!v5_1.hasNext()) {
                return 0;
            }

            Object v0 = v5_1.next();
            Object v2 = arg6.first;
            Intrinsics.checkNotNullExpressionValue(v2, "first");
            Object v3 = arg6.second;
            Intrinsics.checkNotNullExpressionValue(v3, "second");
        }
        while(!((SplitPairFilter)v0).matchesActivityIntentPair(((Activity)v2), ((Intent)v3)));

        return 1;
    }

    static final boolean translateSplitPairRule$lambda$7(androidx.window.embedding.SplitPairRule arg1, Context arg2, WindowMetrics arg3) {
        Intrinsics.checkNotNullParameter(arg3, "windowMetrics");
        return arg1.checkParentMetrics$window_release(arg2, arg3);
    }

    public final SplitPinRule translateSplitPinRule(Context arg3, androidx.window.embedding.SplitPinRule arg4) {
        Intrinsics.checkNotNullParameter(arg3, "context");
        Intrinsics.checkNotNullParameter(arg4, "splitPinRule");
        WindowSdkExtensions.Companion.getInstance().requireExtensionVersion$window_release(5);
        SplitPinRule$Builder v3 = new SplitPinRule$Builder(this.translateSplitAttributes(arg4.getDefaultSplitAttributes()), new EmbeddingAdapter$$ExternalSyntheticLambda0(arg4, arg3));
        v3.setSticky(arg4.isSticky());
        String v2 = arg4.getTag();
        if(v2 == null) {
            v2 = EmbeddingAdapter.Companion.generateTag(((EmbeddingRule)arg4));
        }

        v3.setTag(v2);
        SplitPinRule v2_1 = v3.build();
        Intrinsics.checkNotNullExpressionValue(v2_1, "build(...)");
        return v2_1;
    }

    static final boolean translateSplitPinRule$lambda$8(androidx.window.embedding.SplitPinRule arg1, Context arg2, WindowMetrics arg3) {
        Intrinsics.checkNotNullParameter(arg3, "windowMetrics");
        return arg1.checkParentMetrics$window_release(arg2, arg3);
    }

    private final SplitPlaceholderRule translateSplitPlaceholderRule(Context arg5, androidx.window.embedding.SplitPlaceholderRule arg6, Class arg7) {
        if(this.getExtensionVersion() < 2) {
            return this.api1Impl.translateSplitPlaceholderRuleCompat(arg5, arg6, arg7);
        }

        EmbeddingAdapter$$ExternalSyntheticLambda2 v7 = new EmbeddingAdapter$$ExternalSyntheticLambda2(arg6);
        EmbeddingAdapter$$ExternalSyntheticLambda3 v0 = new EmbeddingAdapter$$ExternalSyntheticLambda3(arg6);
        EmbeddingAdapter$$ExternalSyntheticLambda4 v1 = new EmbeddingAdapter$$ExternalSyntheticLambda4(arg6, arg5);
        String v5 = arg6.getTag();
        SplitPlaceholderRule$Builder v4 = new SplitPlaceholderRule$Builder(arg6.getPlaceholderIntent(), ((Predicate)v7), ((Predicate)v0), ((Predicate)v1)).setSticky(arg6.isSticky()).setDefaultSplitAttributes(this.translateSplitAttributes(arg6.getDefaultSplitAttributes())).setFinishPrimaryWithPlaceholder(this.translateFinishBehavior(arg6.getFinishPrimaryWithPlaceholder()));
        Intrinsics.checkNotNullExpressionValue(v4, "setFinishPrimaryWithPlaceholder(...)");
        if(v5 == null) {
            v5 = EmbeddingAdapter.Companion.generateTag(((EmbeddingRule)arg6));
        }

        v4.setTag(v5);
        SplitPlaceholderRule v4_1 = v4.build();
        Intrinsics.checkNotNullExpressionValue(v4_1, "build(...)");
        return v4_1;
    }

    static final boolean translateSplitPlaceholderRule$lambda$11(androidx.window.embedding.SplitPlaceholderRule arg2, Activity arg3) {
        Intrinsics.checkNotNullParameter(arg3, "activity");
        Set v2 = arg2.getFilters();
        if(((v2 instanceof Collection)) && (v2.isEmpty())) {
            return 0;
        }

        Iterator v2_1 = ((Iterable)v2).iterator();
        do {
            if(!v2_1.hasNext()) {
                return 0;
            }
        }
        while(!v2_1.next().matchesActivity(arg3));

        return 1;
    }

    static final boolean translateSplitPlaceholderRule$lambda$13(androidx.window.embedding.SplitPlaceholderRule arg2, Intent arg3) {
        Intrinsics.checkNotNullParameter(arg3, "intent");
        Set v2 = arg2.getFilters();
        if(((v2 instanceof Collection)) && (v2.isEmpty())) {
            return 0;
        }

        Iterator v2_1 = ((Iterable)v2).iterator();
        do {
            if(!v2_1.hasNext()) {
                return 0;
            }
        }
        while(!v2_1.next().matchesIntent(arg3));

        return 1;
    }

    static final boolean translateSplitPlaceholderRule$lambda$14(androidx.window.embedding.SplitPlaceholderRule arg1, Context arg2, WindowMetrics arg3) {
        Intrinsics.checkNotNullParameter(arg3, "windowMetrics");
        return arg1.checkParentMetrics$window_release(arg2, arg3);
    }

    private final SplitAttributes$SplitType translateSplitType(SplitType arg5) {
        if(this.getExtensionVersion() >= 2) {
            if(Intrinsics.areEqual(arg5, SplitType.SPLIT_TYPE_HINGE)) {
                return new SplitAttributes$SplitType$HingeSplitType(this.translateSplitType(SplitType.SPLIT_TYPE_EQUAL));
            }

            if(Intrinsics.areEqual(arg5, SplitType.SPLIT_TYPE_EXPAND)) {
                return new SplitAttributes$SplitType$ExpandContainersSplitType();
            }

            float v4 = arg5.getValue$window_release();
            double v0 = ((double)v4);
            if(v0 > 0 && v0 < 1) {
                return new SplitAttributes$SplitType$RatioSplitType(v4);
            }

            throw new IllegalArgumentException("Unsupported SplitType: " + arg5 + " with value: " + arg5.getValue$window_release());
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private final EmbeddingAnimationBackground translateToJetpackAnimationBackground(AnimationBackground arg2) {
        WindowSdkExtensions.Companion.getInstance().requireExtensionVersion$window_release(5);
        if((arg2 instanceof AnimationBackground$ColorBackground)) {
            return EmbeddingAnimationBackground.Companion.createColorBackground(((AnimationBackground$ColorBackground)arg2).getColor());
        }

        return EmbeddingAnimationBackground.DEFAULT;
    }

    private final AnimationSpec translateToJetpackAnimationSpec(int arg2) {
        WindowSdkExtensions.Companion.getInstance().requireExtensionVersion$window_release(7);
        if(arg2 == 0) {
            return AnimationSpec.JUMP_CUT;
        }

        return AnimationSpec.DEFAULT;
    }

    public final DividerAttributes translateToJetpackDividerAttributes(androidx.window.extensions.embedding.DividerAttributes arg6) {
        SplitRatioDragRange v2_1;
        WindowSdkExtensions.Companion.getInstance().requireExtensionVersion$window_release(6);
        if(arg6 == null) {
            return DividerAttributes.NO_DIVIDER;
        }

        int v0 = arg6.getDividerType();
        boolean v1 = true;
        if(v0 != 1) {
            if(v0 != 2) {
                Log.w(EmbeddingAdapter.TAG, "Unknown divider type " + arg6 + ".dividerType, default to fixed divider type");
                return new androidx.window.embedding.DividerAttributes$FixedDividerAttributes$Builder().setWidthDp(arg6.getWidthDp()).setColor(arg6.getDividerColor()).build();
            }

            androidx.window.embedding.DividerAttributes$DraggableDividerAttributes$Builder v0_1 = new androidx.window.embedding.DividerAttributes$DraggableDividerAttributes$Builder().setWidthDp(arg6.getWidthDp()).setColor(arg6.getDividerColor());
            float v3 = -1f;
            if(arg6.getPrimaryMinRatio() != v3 || arg6.getPrimaryMaxRatio() != v3) {
                v2_1 = new SplitRatioDragRange(arg6.getPrimaryMinRatio(), arg6.getPrimaryMaxRatio());
            }
            else {
                DragRange v2 = DragRange.DRAG_RANGE_SYSTEM_DEFAULT;
            }

            v0_1 = v0_1.setDragRange(((DragRange)v2_1));
            if(this.getExtensionVersion() < 7 || !arg6.isDraggingToFullscreenAllowed()) {
                v1 = false;
            }
            else {
            }

            return v0_1.setDraggingToFullscreenAllowed(v1).build();
        }

        return new androidx.window.embedding.DividerAttributes$FixedDividerAttributes$Builder().setWidthDp(arg6.getWidthDp()).setColor(arg6.getDividerColor()).build();
    }

    private final AnimationBackground translateToOemAnimationBackground(EmbeddingAnimationBackground arg2) {
        WindowSdkExtensions.Companion.getInstance().requireExtensionVersion$window_release(5);
        if((arg2 instanceof ColorBackground)) {
            AnimationBackground$ColorBackground v1 = AnimationBackground.createColorBackground(((ColorBackground)arg2).getColor());
            Intrinsics.checkNotNull(v1);
            return ((AnimationBackground)v1);
        }

        AnimationBackground v1_1 = AnimationBackground.ANIMATION_BACKGROUND_DEFAULT;
        Intrinsics.checkNotNull(v1_1);
        return v1_1;
    }

    private final int translateToOemAnimationResId(AnimationSpec arg2) {
        WindowSdkExtensions.Companion.getInstance().requireExtensionVersion$window_release(7);
        if(Intrinsics.areEqual(arg2, AnimationSpec.JUMP_CUT)) {
            return 0;
        }

        return -1;
    }

    public final androidx.window.extensions.embedding.DividerAttributes translateToOemDividerAttributes(DividerAttributes arg7) {
        int v1;
        Intrinsics.checkNotNullParameter(arg7, "dividerAttributes");
        WindowSdkExtensions.Companion.getInstance().requireExtensionVersion$window_release(6);
        if(arg7 == DividerAttributes.NO_DIVIDER) {
            return null;
        }

        if((arg7 instanceof FixedDividerAttributes)) {
            v1 = 1;
        }
        else if((arg7 instanceof DraggableDividerAttributes)) {
            v1 = 2;
        }
        else {
            goto label_50;
        }

        DividerAttributes$Builder v0 = new DividerAttributes$Builder(v1).setDividerColor(arg7.getColor()).setWidthDp(arg7.getWidthDp());
        Intrinsics.checkNotNullExpressionValue(v0, "setWidthDp(...)");
        int v3 = 7;
        if((arg7 instanceof DraggableDividerAttributes)) {
            DividerAttributes v1_1 = arg7;
            if((((DraggableDividerAttributes)v1_1).getDragRange() instanceof SplitRatioDragRange)) {
                v0.setPrimaryMinRatio(((DraggableDividerAttributes)v1_1).getDragRange().getMinRatio()).setPrimaryMaxRatio(((DraggableDividerAttributes)v1_1).getDragRange().getMaxRatio());
            }

            if(this.getExtensionVersion() < v3) {
                goto label_43;
            }

            v0.setDraggingToFullscreenAllowed(((DraggableDividerAttributes)v1_1).isDraggingToFullscreenAllowed());
        }

    label_43:
        if(this.getExtensionVersion() == v3 && arg7.getWidthDp() == 0) {
            v0.setWidthDp(1);
        }

        return v0.build();
    label_50:
        throw new IllegalArgumentException("Unknown divider attributes " + arg7);
    }

    public final WindowAttributes translateWindowAttributes$window_release() {
        DimAreaBehavior v2_1;
        WindowSdkExtensions.Companion.getInstance().requireExtensionVersion$window_release(5);
        EmbeddingConfiguration v2 = this.embeddingConfiguration;
        if(v2 != null) {
            v2_1 = v2.getDimAreaBehavior();
        }
        else {
            Object v2_2 = null;
        }

        int v2_3 = Intrinsics.areEqual(v2_1, DimAreaBehavior.ON_ACTIVITY_STACK) ? 1 : 2;
        return new WindowAttributes(v2_3);
    }
}

