package androidx.window.embedding;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0017BW\b\u0000\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\b\b\u0003\u0010\b\u001A\u00020\t\u0012\b\b\u0003\u0010\n\u001A\u00020\t\u0012\b\b\u0003\u0010\u000B\u001A\u00020\t\u0012\b\b\u0002\u0010\f\u001A\u00020\r\u0012\b\b\u0002\u0010\u000E\u001A\u00020\r¢\u0006\u0004\b\u000F\u0010\u0010J\u0013\u0010\u0012\u001A\u00020\u00072\b\u0010\u0013\u001A\u0004\u0018\u00010\u0014H\u0096\u0002J\b\u0010\u0015\u001A\u00020\tH\u0016J\b\u0010\u0016\u001A\u00020\u0003H\u0016R\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0011¨\u0006\u0018"}, d2={"Landroidx/window/embedding/SplitPinRule;", "Landroidx/window/embedding/SplitRule;", "tag", "", "defaultSplitAttributes", "Landroidx/window/embedding/SplitAttributes;", "isSticky", "", "minWidthDp", "", "minHeightDp", "minSmallestWidthDp", "maxAspectRatioInPortrait", "Landroidx/window/embedding/EmbeddingAspectRatio;", "maxAspectRatioInLandscape", "<init>", "(Ljava/lang/String;Landroidx/window/embedding/SplitAttributes;ZIIILandroidx/window/embedding/EmbeddingAspectRatio;Landroidx/window/embedding/EmbeddingAspectRatio;)V", "()Z", "equals", "other", "", "hashCode", "toString", "Builder", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SplitPinRule extends SplitRule {
    @Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0011\u001A\u00020\u00002\b\b\u0001\u0010\u0006\u001A\u00020\u0007J\u0010\u0010\u0012\u001A\u00020\u00002\b\b\u0001\u0010\b\u001A\u00020\u0007J\u0010\u0010\u0013\u001A\u00020\u00002\b\b\u0001\u0010\t\u001A\u00020\u0007J\u000E\u0010\u0014\u001A\u00020\u00002\u0006\u0010\u0015\u001A\u00020\u000BJ\u000E\u0010\u0016\u001A\u00020\u00002\u0006\u0010\u0015\u001A\u00020\u000BJ\u000E\u0010\u0017\u001A\u00020\u00002\u0006\u0010\r\u001A\u00020\u000EJ\u0010\u0010\u0018\u001A\u00020\u00002\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005J\u000E\u0010\u0019\u001A\u00020\u00002\u0006\u0010\u000F\u001A\u00020\u0010J\u0006\u0010\u001A\u001A\u00020\u001BR\u0010\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001A\u00020\u00078\u0002@\u0002X\u0083\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001A\u00020\u00078\u0002@\u0002X\u0083\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001A\u00020\u00078\u0002@\u0002X\u0083\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0010X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u001C"}, d2={"Landroidx/window/embedding/SplitPinRule$Builder;", "", "<init>", "()V", "tag", "", "minWidthDp", "", "minHeightDp", "minSmallestWidthDp", "maxAspectRatioInPortrait", "Landroidx/window/embedding/EmbeddingAspectRatio;", "maxAspectRatioInLandscape", "defaultSplitAttributes", "Landroidx/window/embedding/SplitAttributes;", "isSticky", "", "setMinWidthDp", "setMinHeightDp", "setMinSmallestWidthDp", "setMaxAspectRatioInPortrait", "aspectRatio", "setMaxAspectRatioInLandscape", "setDefaultSplitAttributes", "setTag", "setSticky", "build", "Landroidx/window/embedding/SplitPinRule;", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Builder {
        private SplitAttributes defaultSplitAttributes;
        private boolean isSticky;
        private EmbeddingAspectRatio maxAspectRatioInLandscape;
        private EmbeddingAspectRatio maxAspectRatioInPortrait;
        private int minHeightDp;
        private int minSmallestWidthDp;
        private int minWidthDp;
        private String tag;

        public Builder() {
            super();
            this.minWidthDp = 600;
            this.minHeightDp = 600;
            this.minSmallestWidthDp = 600;
            this.maxAspectRatioInPortrait = SplitRule.SPLIT_MAX_ASPECT_RATIO_PORTRAIT_DEFAULT;
            this.maxAspectRatioInLandscape = SplitRule.SPLIT_MAX_ASPECT_RATIO_LANDSCAPE_DEFAULT;
            this.defaultSplitAttributes = new androidx.window.embedding.SplitAttributes$Builder().build();
        }

        public final SplitPinRule build() {
            return new SplitPinRule(this.tag, this.defaultSplitAttributes, this.isSticky, this.minWidthDp, this.minHeightDp, this.minSmallestWidthDp, this.maxAspectRatioInPortrait, this.maxAspectRatioInLandscape);
        }

        public final Builder setDefaultSplitAttributes(SplitAttributes arg2) {
            Intrinsics.checkNotNullParameter(arg2, "defaultSplitAttributes");
            this.defaultSplitAttributes = arg2;
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

    private final boolean isSticky;

    public SplitPinRule(String arg10, SplitAttributes arg11, boolean arg12, int arg13, int arg14, int arg15, EmbeddingAspectRatio arg16, EmbeddingAspectRatio arg17) {
        Intrinsics.checkNotNullParameter(arg11, "defaultSplitAttributes");
        Intrinsics.checkNotNullParameter(arg16, "maxAspectRatioInPortrait");
        Intrinsics.checkNotNullParameter(arg17, "maxAspectRatioInLandscape");
        super(arg10, arg13, arg14, arg15, arg16, arg17, arg11);
        this.isSticky = arg12;
    }

    public SplitPinRule(String arg2, SplitAttributes arg3, boolean arg4, int arg5, int arg6, int arg7, EmbeddingAspectRatio arg8, EmbeddingAspectRatio arg9, int arg10, DefaultConstructorMarker arg11) {
        if((arg10 & 1) != 0) {
            arg2 = null;
        }

        int v0 = 600;
        if((arg10 & 8) != 0) {
            arg5 = v0;
        }

        if((arg10 & 16) != 0) {
            arg6 = v0;
        }

        if((arg10 & 0x20) != 0) {
            arg7 = v0;
        }

        if((arg10 & 0x40) != 0) {
            arg8 = SplitRule.SPLIT_MAX_ASPECT_RATIO_PORTRAIT_DEFAULT;
        }

        if((arg10 & 0x80) != 0) {
            arg9 = SplitRule.SPLIT_MAX_ASPECT_RATIO_LANDSCAPE_DEFAULT;
        }

        this(arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
    }

    public boolean equals(Object arg4) {
        if(this == (((SplitPinRule)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof SplitPinRule)) {
            return 0;
        }

        if(!super.equals(arg4)) {
            return 0;
        }

        if(this.isSticky != ((SplitPinRule)arg4).isSticky) {
            return 0;
        }

        return 1;
    }

    public int hashCode() {
        return super.hashCode() * 0x1F + Boolean.hashCode(this.isSticky);
    }

    public final boolean isSticky() {
        return this.isSticky;
    }

    public String toString() {
        return "SplitPinRule{tag=" + this.getTag() + ", defaultSplitAttributes=" + this.getDefaultSplitAttributes() + ", isSticky=" + this.isSticky + '}';
    }
}

