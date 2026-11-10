package androidx.window.embedding;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001&B{\b\u0000\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001A\u00020\n\u0012\b\b\u0002\u0010\u000B\u001A\u00020\n\u0012\b\b\u0002\u0010\f\u001A\u00020\r\u0012\b\b\u0003\u0010\u000E\u001A\u00020\u000F\u0012\b\b\u0003\u0010\u0010\u001A\u00020\u000F\u0012\b\b\u0003\u0010\u0011\u001A\u00020\u000F\u0012\b\b\u0002\u0010\u0012\u001A\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001A\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u001E\u001A\u00020\u00002\u0006\u0010\u001F\u001A\u00020\u0004H\u0080\u0002¢\u0006\u0002\b J\u0013\u0010!\u001A\u00020\r2\b\u0010\"\u001A\u0004\u0018\u00010#H\u0096\u0002J\b\u0010$\u001A\u00020\u000FH\u0016J\b\u0010%\u001A\u00020\bH\u0016R\u0017\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0018R\u0011\u0010\t\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u001AR\u0011\u0010\u000B\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\u001B\u0010\u001AR\u0011\u0010\f\u001A\u00020\r¢\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u001D¨\u0006\'"}, d2={"Landroidx/window/embedding/SplitPairRule;", "Landroidx/window/embedding/SplitRule;", "filters", "", "Landroidx/window/embedding/SplitPairFilter;", "defaultSplitAttributes", "Landroidx/window/embedding/SplitAttributes;", "tag", "", "finishPrimaryWithSecondary", "Landroidx/window/embedding/SplitRule$FinishBehavior;", "finishSecondaryWithPrimary", "clearTop", "", "minWidthDp", "", "minHeightDp", "minSmallestWidthDp", "maxAspectRatioInPortrait", "Landroidx/window/embedding/EmbeddingAspectRatio;", "maxAspectRatioInLandscape", "<init>", "(Ljava/util/Set;Landroidx/window/embedding/SplitAttributes;Ljava/lang/String;Landroidx/window/embedding/SplitRule$FinishBehavior;Landroidx/window/embedding/SplitRule$FinishBehavior;ZIIILandroidx/window/embedding/EmbeddingAspectRatio;Landroidx/window/embedding/EmbeddingAspectRatio;)V", "getFilters", "()Ljava/util/Set;", "getFinishPrimaryWithSecondary", "()Landroidx/window/embedding/SplitRule$FinishBehavior;", "getFinishSecondaryWithPrimary", "getClearTop", "()Z", "plus", "filter", "plus$window_release", "equals", "other", "", "hashCode", "toString", "Builder", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SplitPairRule extends SplitRule {
    @Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0010\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\u0005\u0010\tJ\u0010\u0010\u001A\u001A\u00020\u00002\b\b\u0001\u0010\f\u001A\u00020\rJ\u0010\u0010\u001B\u001A\u00020\u00002\b\b\u0001\u0010\u000E\u001A\u00020\rJ\u0010\u0010\u001C\u001A\u00020\u00002\b\b\u0001\u0010\u000F\u001A\u00020\rJ\u000E\u0010\u001D\u001A\u00020\u00002\u0006\u0010\u001E\u001A\u00020\u0011J\u000E\u0010\u001F\u001A\u00020\u00002\u0006\u0010\u001E\u001A\u00020\u0011J\u000E\u0010 \u001A\u00020\u00002\u0006\u0010\u0013\u001A\u00020\u0014J\u000E\u0010!\u001A\u00020\u00002\u0006\u0010\u0015\u001A\u00020\u0014J\u000E\u0010\"\u001A\u00020\u00002\u0006\u0010\u0016\u001A\u00020\u0017J\u000E\u0010#\u001A\u00020\u00002\u0006\u0010\u0018\u001A\u00020\u0019J\u0010\u0010$\u001A\u00020\u00002\b\u0010\n\u001A\u0004\u0018\u00010\u000BJ\u0006\u0010%\u001A\u00020\bR\u0014\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001A\u0004\u0018\u00010\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001A\u00020\r8\u0002@\u0002X\u0083\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\u000E\u001A\u00020\r8\u0002@\u0002X\u0083\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\u000F\u001A\u00020\r8\u0002@\u0002X\u0083\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0011X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0011X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0014X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\u0014X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0016\u001A\u00020\u0017X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0018\u001A\u00020\u0019X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006&"}, d2={"Landroidx/window/embedding/SplitPairRule$Builder;", "", "filters", "", "Landroidx/window/embedding/SplitPairFilter;", "<init>", "(Ljava/util/Set;)V", "original", "Landroidx/window/embedding/SplitPairRule;", "(Landroidx/window/embedding/SplitPairRule;)V", "tag", "", "minWidthDp", "", "minHeightDp", "minSmallestWidthDp", "maxAspectRatioInPortrait", "Landroidx/window/embedding/EmbeddingAspectRatio;", "maxAspectRatioInLandscape", "finishPrimaryWithSecondary", "Landroidx/window/embedding/SplitRule$FinishBehavior;", "finishSecondaryWithPrimary", "clearTop", "", "defaultSplitAttributes", "Landroidx/window/embedding/SplitAttributes;", "setMinWidthDp", "setMinHeightDp", "setMinSmallestWidthDp", "setMaxAspectRatioInPortrait", "aspectRatio", "setMaxAspectRatioInLandscape", "setFinishPrimaryWithSecondary", "setFinishSecondaryWithPrimary", "setClearTop", "setDefaultSplitAttributes", "setTag", "build", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Builder {
        private boolean clearTop;
        private SplitAttributes defaultSplitAttributes;
        private final Set filters;
        private FinishBehavior finishPrimaryWithSecondary;
        private FinishBehavior finishSecondaryWithPrimary;
        private EmbeddingAspectRatio maxAspectRatioInLandscape;
        private EmbeddingAspectRatio maxAspectRatioInPortrait;
        private int minHeightDp;
        private int minSmallestWidthDp;
        private int minWidthDp;
        private String tag;

        public Builder(Set arg2) {
            Intrinsics.checkNotNullParameter(arg2, "filters");
            super();
            this.filters = arg2;
            this.minWidthDp = 600;
            this.minHeightDp = 600;
            this.minSmallestWidthDp = 600;
            this.maxAspectRatioInPortrait = SplitRule.SPLIT_MAX_ASPECT_RATIO_PORTRAIT_DEFAULT;
            this.maxAspectRatioInLandscape = SplitRule.SPLIT_MAX_ASPECT_RATIO_LANDSCAPE_DEFAULT;
            this.finishPrimaryWithSecondary = FinishBehavior.NEVER;
            this.finishSecondaryWithPrimary = FinishBehavior.ALWAYS;
            this.defaultSplitAttributes = new androidx.window.embedding.SplitAttributes$Builder().build();
        }

        public Builder(SplitPairRule arg2) {
            Intrinsics.checkNotNullParameter(arg2, "original");
            this(arg2.getFilters());
            this.setTag(arg2.getTag()).setMinWidthDp(arg2.getMinWidthDp()).setMinHeightDp(arg2.getMinHeightDp()).setMinSmallestWidthDp(arg2.getMinSmallestWidthDp()).setMaxAspectRatioInPortrait(arg2.getMaxAspectRatioInPortrait()).setMaxAspectRatioInLandscape(arg2.getMaxAspectRatioInLandscape()).setFinishPrimaryWithSecondary(arg2.getFinishPrimaryWithSecondary()).setFinishSecondaryWithPrimary(arg2.getFinishSecondaryWithPrimary()).setClearTop(arg2.getClearTop()).setDefaultSplitAttributes(arg2.getDefaultSplitAttributes());
        }

        public final SplitPairRule build() {
            return new SplitPairRule(this.filters, this.defaultSplitAttributes, this.tag, this.finishPrimaryWithSecondary, this.finishSecondaryWithPrimary, this.clearTop, this.minWidthDp, this.minHeightDp, this.minSmallestWidthDp, this.maxAspectRatioInPortrait, this.maxAspectRatioInLandscape);
        }

        public final Builder setClearTop(boolean arg2) {
            this.clearTop = arg2;
            return this;
        }

        public final Builder setDefaultSplitAttributes(SplitAttributes arg2) {
            Intrinsics.checkNotNullParameter(arg2, "defaultSplitAttributes");
            this.defaultSplitAttributes = arg2;
            return this;
        }

        public final Builder setFinishPrimaryWithSecondary(FinishBehavior arg2) {
            Intrinsics.checkNotNullParameter(arg2, "finishPrimaryWithSecondary");
            this.finishPrimaryWithSecondary = arg2;
            return this;
        }

        public final Builder setFinishSecondaryWithPrimary(FinishBehavior arg2) {
            Intrinsics.checkNotNullParameter(arg2, "finishSecondaryWithPrimary");
            this.finishSecondaryWithPrimary = arg2;
            return this;
        }

        public final Builder setMaxAspectRatioInLandscape(EmbeddingAspectRatio arg2) {
            Intrinsics.checkNotNullParameter(arg2, "aspectRatio");
            this.maxAspectRatioInLandscape = arg2;
            return this;
        }

        public final Builder setMaxAspectRatioInPortrait(EmbeddingAspectRatio arg2) {
            Intrinsics.checkNotNullParameter(arg2, "aspectRatio");
            this.maxAspectRatioInPortrait = arg2;
            return this;
        }

        public final Builder setMinHeightDp(int arg2) {
            this.minHeightDp = arg2;
            return this;
        }

        public final Builder setMinSmallestWidthDp(int arg2) {
            this.minSmallestWidthDp = arg2;
            return this;
        }

        public final Builder setMinWidthDp(int arg2) {
            this.minWidthDp = arg2;
            return this;
        }

        public final Builder setTag(String arg2) {
            this.tag = arg2;
            return this;
        }
    }

    private final boolean clearTop;
    private final Set filters;
    private final FinishBehavior finishPrimaryWithSecondary;
    private final FinishBehavior finishSecondaryWithPrimary;

    public SplitPairRule(Set arg10, SplitAttributes arg11, String arg12, FinishBehavior arg13, FinishBehavior arg14, boolean arg15, int arg16, int arg17, int arg18, EmbeddingAspectRatio arg19, EmbeddingAspectRatio arg20) {
        Intrinsics.checkNotNullParameter(arg10, "filters");
        Intrinsics.checkNotNullParameter(arg11, "defaultSplitAttributes");
        Intrinsics.checkNotNullParameter(arg13, "finishPrimaryWithSecondary");
        Intrinsics.checkNotNullParameter(arg14, "finishSecondaryWithPrimary");
        Intrinsics.checkNotNullParameter(arg19, "maxAspectRatioInPortrait");
        Intrinsics.checkNotNullParameter(arg20, "maxAspectRatioInLandscape");
        super(arg12, arg16, arg17, arg18, arg19, arg20, arg11);
        this.filters = arg10;
        this.finishPrimaryWithSecondary = arg13;
        this.finishSecondaryWithPrimary = arg14;
        this.clearTop = arg15;
    }

    public SplitPairRule(Set arg15, SplitAttributes arg16, String arg17, FinishBehavior arg18, FinishBehavior arg19, boolean arg20, int arg21, int arg22, int arg23, EmbeddingAspectRatio arg24, EmbeddingAspectRatio arg25, int arg26, DefaultConstructorMarker arg27) {
        int v0 = arg26;
        String v5 = (v0 & 4) != 0 ? null : arg17;
        FinishBehavior v6 = (v0 & 8) != 0 ? FinishBehavior.NEVER : arg18;
        FinishBehavior v7 = (v0 & 16) != 0 ? FinishBehavior.ALWAYS : arg19;
        boolean v8 = (v0 & 0x20) != 0 ? false : arg20;
        int v2 = 600;
        int v9 = (v0 & 0x40) != 0 ? v2 : arg21;
        int v10 = (v0 & 0x80) != 0 ? v2 : arg22;
        int v11 = (v0 & 0x100) != 0 ? v2 : arg23;
        EmbeddingAspectRatio v12 = (v0 & 0x200) != 0 ? SplitRule.SPLIT_MAX_ASPECT_RATIO_PORTRAIT_DEFAULT : arg24;
        EmbeddingAspectRatio v13 = (v0 & 0x400) != 0 ? SplitRule.SPLIT_MAX_ASPECT_RATIO_LANDSCAPE_DEFAULT : arg25;
        this(arg15, arg16, v5, v6, v7, v8, v9, v10, v11, v12, v13);
    }

    public boolean equals(Object arg5) {
        if(this == (((SplitPairRule)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof SplitPairRule)) {
            return 0;
        }

        if(!super.equals(arg5)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.filters, ((SplitPairRule)arg5).filters)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.finishPrimaryWithSecondary, ((SplitPairRule)arg5).finishPrimaryWithSecondary)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.finishSecondaryWithPrimary, ((SplitPairRule)arg5).finishSecondaryWithPrimary)) {
            return 0;
        }

        if(this.clearTop != ((SplitPairRule)arg5).clearTop) {
            return 0;
        }

        return 1;
    }

    public final boolean getClearTop() {
        return this.clearTop;
    }

    public final Set getFilters() {
        return this.filters;
    }

    public final FinishBehavior getFinishPrimaryWithSecondary() {
        return this.finishPrimaryWithSecondary;
    }

    public final FinishBehavior getFinishSecondaryWithPrimary() {
        return this.finishSecondaryWithPrimary;
    }

    public int hashCode() {
        return (((super.hashCode() * 0x1F + this.filters.hashCode()) * 0x1F + this.finishPrimaryWithSecondary.hashCode()) * 0x1F + this.finishSecondaryWithPrimary.hashCode()) * 0x1F + Boolean.hashCode(this.clearTop);
    }

    public final SplitPairRule plus$window_release(SplitPairFilter arg3) {
        Intrinsics.checkNotNullParameter(arg3, "filter");
        LinkedHashSet v0 = new LinkedHashSet();
        ((Set)v0).addAll(this.filters);
        ((Set)v0).add(arg3);
        return new Builder(CollectionsKt.toSet(((Iterable)v0))).setTag(this.getTag()).setMinWidthDp(this.getMinWidthDp()).setMinHeightDp(this.getMinHeightDp()).setMinSmallestWidthDp(this.getMinSmallestWidthDp()).setMaxAspectRatioInPortrait(this.getMaxAspectRatioInPortrait()).setMaxAspectRatioInLandscape(this.getMaxAspectRatioInLandscape()).setFinishPrimaryWithSecondary(this.finishPrimaryWithSecondary).setFinishSecondaryWithPrimary(this.finishSecondaryWithPrimary).setClearTop(this.clearTop).setDefaultSplitAttributes(this.getDefaultSplitAttributes()).build();
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder("SplitPairRule{tag=");
        v0.append(this.getTag()).append(", defaultSplitAttributes=").append(this.getDefaultSplitAttributes()).append(", minWidthDp=").append(this.getMinWidthDp()).append(", minHeightDp=").append(this.getMinHeightDp()).append(", minSmallestWidthDp=").append(this.getMinSmallestWidthDp()).append(", maxAspectRatioInPortrait=").append(this.getMaxAspectRatioInPortrait()).append(", maxAspectRatioInLandscape=").append(this.getMaxAspectRatioInLandscape()).append(", clearTop=").append(this.clearTop).append(", finishPrimaryWithSecondary=").append(this.finishPrimaryWithSecondary).append(", finishSecondaryWithPrimary=").append(this.finishSecondaryWithPrimary).append(", filters=").append(this.filters);
        v0.append('}');
        return v0.toString();
    }
}

