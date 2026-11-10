package androidx.window.embedding;

import android.content.Intent;
import androidx.core.util.Preconditions;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\'Bw\b\u0010\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n\u0012\b\b\u0002\u0010\u000B\u001A\u00020\f\u0012\b\b\u0003\u0010\r\u001A\u00020\u000E\u0012\b\b\u0003\u0010\u000F\u001A\u00020\u000E\u0012\b\b\u0003\u0010\u0010\u001A\u00020\u000E\u0012\b\b\u0002\u0010\u0011\u001A\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001A\u00020\u0012\u0012\u0006\u0010\u0014\u001A\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u001F\u001A\u00020\u00002\u0006\u0010 \u001A\u00020\u0006H\u0080\u0002¢\u0006\u0002\b!J\u0013\u0010\"\u001A\u00020\n2\b\u0010#\u001A\u0004\u0018\u00010$H\u0096\u0002J\b\u0010%\u001A\u00020\u000EH\u0016J\b\u0010&\u001A\u00020\u0003H\u0016R\u0017\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u001BR\u0011\u0010\t\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\u001CR\u0011\u0010\u000B\u001A\u00020\f¢\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u001E¨\u0006("}, d2={"Landroidx/window/embedding/SplitPlaceholderRule;", "Landroidx/window/embedding/SplitRule;", "tag", "", "filters", "", "Landroidx/window/embedding/ActivityFilter;", "placeholderIntent", "Landroid/content/Intent;", "isSticky", "", "finishPrimaryWithPlaceholder", "Landroidx/window/embedding/SplitRule$FinishBehavior;", "minWidthDp", "", "minHeightDp", "minSmallestWidthDp", "maxAspectRatioInPortrait", "Landroidx/window/embedding/EmbeddingAspectRatio;", "maxAspectRatioInLandscape", "defaultSplitAttributes", "Landroidx/window/embedding/SplitAttributes;", "<init>", "(Ljava/lang/String;Ljava/util/Set;Landroid/content/Intent;ZLandroidx/window/embedding/SplitRule$FinishBehavior;IIILandroidx/window/embedding/EmbeddingAspectRatio;Landroidx/window/embedding/EmbeddingAspectRatio;Landroidx/window/embedding/SplitAttributes;)V", "getFilters", "()Ljava/util/Set;", "getPlaceholderIntent", "()Landroid/content/Intent;", "()Z", "getFinishPrimaryWithPlaceholder", "()Landroidx/window/embedding/SplitRule$FinishBehavior;", "plus", "filter", "plus$window_release", "equals", "other", "", "hashCode", "toString", "Builder", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SplitPlaceholderRule extends SplitRule {
    @Metadata(d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u001D\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0010\u0012\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\b\u0007\u0010\u000BJ\u0010\u0010\u001B\u001A\u00020\u00002\b\b\u0001\u0010\u000E\u001A\u00020\u000FJ\u0010\u0010\u001C\u001A\u00020\u00002\b\b\u0001\u0010\u0010\u001A\u00020\u000FJ\u0010\u0010\u001D\u001A\u00020\u00002\b\b\u0001\u0010\u0011\u001A\u00020\u000FJ\u000E\u0010\u001E\u001A\u00020\u00002\u0006\u0010\u001F\u001A\u00020\u0013J\u000E\u0010 \u001A\u00020\u00002\u0006\u0010\u001F\u001A\u00020\u0013J\u000E\u0010!\u001A\u00020\u00002\u0006\u0010\u0015\u001A\u00020\u0016J\u000E\u0010\"\u001A\u00020\u00002\u0006\u0010\u0017\u001A\u00020\u0018J\u000E\u0010#\u001A\u00020\u00002\u0006\u0010\u0019\u001A\u00020\u001AJ\u0010\u0010$\u001A\u00020\u00002\b\u0010\f\u001A\u0004\u0018\u00010\rJ\u0006\u0010%\u001A\u00020\nR\u0014\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001A\u0004\u0018\u00010\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\u000E\u001A\u00020\u000F8\u0002@\u0002X\u0083\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001A\u00020\u000F8\u0002@\u0002X\u0083\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001A\u00020\u000F8\u0002@\u0002X\u0083\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0013X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\u0013X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0017\u001A\u00020\u0018X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0019\u001A\u00020\u001AX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006&"}, d2={"Landroidx/window/embedding/SplitPlaceholderRule$Builder;", "", "filters", "", "Landroidx/window/embedding/ActivityFilter;", "placeholderIntent", "Landroid/content/Intent;", "<init>", "(Ljava/util/Set;Landroid/content/Intent;)V", "original", "Landroidx/window/embedding/SplitPlaceholderRule;", "(Landroidx/window/embedding/SplitPlaceholderRule;)V", "tag", "", "minWidthDp", "", "minHeightDp", "minSmallestWidthDp", "maxAspectRatioInPortrait", "Landroidx/window/embedding/EmbeddingAspectRatio;", "maxAspectRatioInLandscape", "finishPrimaryWithPlaceholder", "Landroidx/window/embedding/SplitRule$FinishBehavior;", "isSticky", "", "defaultSplitAttributes", "Landroidx/window/embedding/SplitAttributes;", "setMinWidthDp", "setMinHeightDp", "setMinSmallestWidthDp", "setMaxAspectRatioInPortrait", "aspectRatio", "setMaxAspectRatioInLandscape", "setFinishPrimaryWithPlaceholder", "setSticky", "setDefaultSplitAttributes", "setTag", "build", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Builder {
        private SplitAttributes defaultSplitAttributes;
        private final Set filters;
        private FinishBehavior finishPrimaryWithPlaceholder;
        private boolean isSticky;
        private EmbeddingAspectRatio maxAspectRatioInLandscape;
        private EmbeddingAspectRatio maxAspectRatioInPortrait;
        private int minHeightDp;
        private int minSmallestWidthDp;
        private int minWidthDp;
        private final Intent placeholderIntent;
        private String tag;

        public Builder(Set arg2, Intent arg3) {
            Intrinsics.checkNotNullParameter(arg2, "filters");
            Intrinsics.checkNotNullParameter(arg3, "placeholderIntent");
            super();
            this.filters = arg2;
            this.placeholderIntent = arg3;
            this.minWidthDp = 600;
            this.minHeightDp = 600;
            this.minSmallestWidthDp = 600;
            this.maxAspectRatioInPortrait = SplitRule.SPLIT_MAX_ASPECT_RATIO_PORTRAIT_DEFAULT;
            this.maxAspectRatioInLandscape = SplitRule.SPLIT_MAX_ASPECT_RATIO_LANDSCAPE_DEFAULT;
            this.finishPrimaryWithPlaceholder = FinishBehavior.ALWAYS;
            this.defaultSplitAttributes = new androidx.window.embedding.SplitAttributes$Builder().build();
        }

        public Builder(SplitPlaceholderRule arg3) {
            Intrinsics.checkNotNullParameter(arg3, "original");
            this(arg3.getFilters(), arg3.getPlaceholderIntent());
            this.setTag(arg3.getTag()).setMinWidthDp(arg3.getMinWidthDp()).setMinHeightDp(arg3.getMinHeightDp()).setMinSmallestWidthDp(arg3.getMinSmallestWidthDp()).setMaxAspectRatioInPortrait(arg3.getMaxAspectRatioInPortrait()).setMaxAspectRatioInLandscape(arg3.getMaxAspectRatioInLandscape()).setFinishPrimaryWithPlaceholder(arg3.getFinishPrimaryWithPlaceholder()).setSticky(arg3.isSticky()).setDefaultSplitAttributes(arg3.getDefaultSplitAttributes());
        }

        public final SplitPlaceholderRule build() {
            return new SplitPlaceholderRule(this.tag, this.filters, this.placeholderIntent, this.isSticky, this.finishPrimaryWithPlaceholder, this.minWidthDp, this.minHeightDp, this.minSmallestWidthDp, this.maxAspectRatioInPortrait, this.maxAspectRatioInLandscape, this.defaultSplitAttributes);
        }

        public final Builder setDefaultSplitAttributes(SplitAttributes arg2) {
            Intrinsics.checkNotNullParameter(arg2, "defaultSplitAttributes");
            this.defaultSplitAttributes = arg2;
            return this;
        }

        public final Builder setFinishPrimaryWithPlaceholder(FinishBehavior arg2) {
            Intrinsics.checkNotNullParameter(arg2, "finishPrimaryWithPlaceholder");
            this.finishPrimaryWithPlaceholder = arg2;
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

        public final Builder setSticky(boolean arg2) {
            this.isSticky = arg2;
            return this;
        }

        public final Builder setTag(String arg2) {
            this.tag = arg2;
            return this;
        }
    }

    private final Set filters;
    private final FinishBehavior finishPrimaryWithPlaceholder;
    private final boolean isSticky;
    private final Intent placeholderIntent;

    public SplitPlaceholderRule(String arg10, Set arg11, Intent arg12, boolean arg13, FinishBehavior arg14, int arg15, int arg16, int arg17, EmbeddingAspectRatio arg18, EmbeddingAspectRatio arg19, SplitAttributes arg20) {
        Intrinsics.checkNotNullParameter(arg11, "filters");
        Intrinsics.checkNotNullParameter(arg12, "placeholderIntent");
        Intrinsics.checkNotNullParameter(arg14, "finishPrimaryWithPlaceholder");
        Intrinsics.checkNotNullParameter(arg18, "maxAspectRatioInPortrait");
        Intrinsics.checkNotNullParameter(arg19, "maxAspectRatioInLandscape");
        Intrinsics.checkNotNullParameter(arg20, "defaultSplitAttributes");
        super(arg10, arg15, arg16, arg17, arg18, arg19, arg20);
        Preconditions.checkArgument(Intrinsics.areEqual(arg14, FinishBehavior.NEVER) ^ 1, "NEVER is not a valid configuration for SplitPlaceholderRule. Please use FINISH_ALWAYS or FINISH_ADJACENT instead or refer to the current API.", new Object[0]);
        this.filters = CollectionsKt.toSet(((Iterable)arg11));
        this.placeholderIntent = arg12;
        this.isSticky = arg13;
        this.finishPrimaryWithPlaceholder = arg14;
    }

    public SplitPlaceholderRule(String arg2, Set arg3, Intent arg4, boolean arg5, FinishBehavior arg6, int arg7, int arg8, int arg9, EmbeddingAspectRatio arg10, EmbeddingAspectRatio arg11, SplitAttributes arg12, int arg13, DefaultConstructorMarker arg14) {
        if((arg13 & 1) != 0) {
            arg2 = null;
        }

        if((arg13 & 16) != 0) {
            arg6 = FinishBehavior.ALWAYS;
        }

        int v0 = 600;
        if((arg13 & 0x20) != 0) {
            arg7 = v0;
        }

        if((arg13 & 0x40) != 0) {
            arg8 = v0;
        }

        if((arg13 & 0x80) != 0) {
            arg9 = v0;
        }

        if((arg13 & 0x100) != 0) {
            arg10 = SplitRule.SPLIT_MAX_ASPECT_RATIO_PORTRAIT_DEFAULT;
        }

        if((arg13 & 0x200) != 0) {
            arg11 = SplitRule.SPLIT_MAX_ASPECT_RATIO_LANDSCAPE_DEFAULT;
        }

        this(arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12);
    }

    public boolean equals(Object arg5) {
        if(this == (((SplitPlaceholderRule)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof SplitPlaceholderRule)) {
            return 0;
        }

        if(!super.equals(arg5)) {
            return 0;
        }

        if(!this.placeholderIntent.filterEquals(((SplitPlaceholderRule)arg5).placeholderIntent)) {
            return 0;
        }

        if(this.isSticky != ((SplitPlaceholderRule)arg5).isSticky) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.finishPrimaryWithPlaceholder, ((SplitPlaceholderRule)arg5).finishPrimaryWithPlaceholder)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.filters, ((SplitPlaceholderRule)arg5).filters)) {
            return 0;
        }

        return 1;
    }

    public final Set getFilters() {
        return this.filters;
    }

    public final FinishBehavior getFinishPrimaryWithPlaceholder() {
        return this.finishPrimaryWithPlaceholder;
    }

    public final Intent getPlaceholderIntent() {
        return this.placeholderIntent;
    }

    public int hashCode() {
        return (((super.hashCode() * 0x1F + this.placeholderIntent.filterHashCode()) * 0x1F + Boolean.hashCode(this.isSticky)) * 0x1F + this.finishPrimaryWithPlaceholder.hashCode()) * 0x1F + this.filters.hashCode();
    }

    public final boolean isSticky() {
        return this.isSticky;
    }

    public final SplitPlaceholderRule plus$window_release(ActivityFilter arg3) {
        Intrinsics.checkNotNullParameter(arg3, "filter");
        LinkedHashSet v0 = new LinkedHashSet();
        ((Set)v0).addAll(this.filters);
        ((Set)v0).add(arg3);
        return new Builder(CollectionsKt.toSet(((Iterable)v0)), this.placeholderIntent).setTag(this.getTag()).setMinWidthDp(this.getMinWidthDp()).setMinHeightDp(this.getMinHeightDp()).setMinSmallestWidthDp(this.getMinSmallestWidthDp()).setMaxAspectRatioInPortrait(this.getMaxAspectRatioInPortrait()).setMaxAspectRatioInLandscape(this.getMaxAspectRatioInLandscape()).setSticky(this.isSticky).setFinishPrimaryWithPlaceholder(this.finishPrimaryWithPlaceholder).setDefaultSplitAttributes(this.getDefaultSplitAttributes()).build();
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder("SplitPlaceholderRule{tag=");
        v0.append(this.getTag()).append(", defaultSplitAttributes=").append(this.getDefaultSplitAttributes()).append(", minWidthDp=").append(this.getMinWidthDp()).append(", minHeightDp=").append(this.getMinHeightDp()).append(", minSmallestWidthDp=").append(this.getMinSmallestWidthDp()).append(", maxAspectRatioInPortrait=").append(this.getMaxAspectRatioInPortrait()).append(", maxAspectRatioInLandscape=").append(this.getMaxAspectRatioInLandscape()).append(", placeholderIntent=").append(this.placeholderIntent).append(", isSticky=").append(this.isSticky).append(", finishPrimaryWithPlaceholder=").append(this.finishPrimaryWithPlaceholder).append(", filters=").append(this.filters).append('}');
        return v0.toString();
    }
}

