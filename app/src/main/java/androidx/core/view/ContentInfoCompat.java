package androidx.core.view;

import android.content.ClipData$Item;
import android.content.ClipData;
import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.util.Pair;
import android.view.ContentInfo$Builder;
import android.view.ContentInfo;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public final class ContentInfoCompat {
    final class Api31Impl {
        private Api31Impl() {
            super();
        }

        public static Pair partition(ContentInfo arg4, Predicate arg5) {
            Object v4;
            ContentInfo v0_1;
            ClipData v0 = arg4.getClip();
            Object v3 = null;
            if(v0.getItemCount() == 1) {
                boolean v5 = arg5.test(v0.getItemAt(0));
                if(v5) {
                    v0_1 = arg4;
                }
                else {
                    Object v0_2 = v3;
                }

                if(v5) {
                    v4 = v3;
                }

                return Pair.create(v0_1, v4);
            }

            Objects.requireNonNull(arg5);
            Pair v5_1 = ContentInfoCompat.partition(v0, new ContentInfoCompat$Api31Impl$$ExternalSyntheticLambda0(arg5));
            if(v5_1.first == null) {
                return Pair.create(v3, arg4);
            }

            if(v5_1.second == null) {
                return Pair.create(arg4, v3);
            }

            return Pair.create(new ContentInfo$Builder(arg4).setClip(v5_1.first).build(), new ContentInfo$Builder(arg4).setClip(v5_1.second).build());
        }
    }

    public final class Builder {
        private final BuilderCompat mBuilderCompat;

        public Builder(ClipData arg3, int arg4) {
            super();
            if(Build$VERSION.SDK_INT >= 0x1F) {
                this.mBuilderCompat = new BuilderCompat31Impl(arg3, arg4);
                return;
            }

            this.mBuilderCompat = new BuilderCompatImpl(arg3, arg4);
        }

        public Builder(ContentInfoCompat arg3) {
            super();
            if(Build$VERSION.SDK_INT >= 0x1F) {
                this.mBuilderCompat = new BuilderCompat31Impl(arg3);
                return;
            }

            this.mBuilderCompat = new BuilderCompatImpl(arg3);
        }

        public ContentInfoCompat build() {
            return this.mBuilderCompat.build();
        }

        public Builder setClip(ClipData arg2) {
            this.mBuilderCompat.setClip(arg2);
            return this;
        }

        public Builder setExtras(Bundle arg2) {
            this.mBuilderCompat.setExtras(arg2);
            return this;
        }

        public Builder setFlags(int arg2) {
            this.mBuilderCompat.setFlags(arg2);
            return this;
        }

        public Builder setLinkUri(Uri arg2) {
            this.mBuilderCompat.setLinkUri(arg2);
            return this;
        }

        public Builder setSource(int arg2) {
            this.mBuilderCompat.setSource(arg2);
            return this;
        }
    }

    final class BuilderCompat31Impl implements BuilderCompat {
        private final ContentInfo$Builder mPlatformBuilder;

        BuilderCompat31Impl(ClipData arg2, int arg3) {
            super();
            this.mPlatformBuilder = new ContentInfo$Builder(arg2, arg3);
        }

        BuilderCompat31Impl(ContentInfoCompat arg2) {
            super();
            this.mPlatformBuilder = new ContentInfo$Builder(arg2.toContentInfo());
        }

        public ContentInfoCompat build() {
            return new ContentInfoCompat(new Compat31Impl(this.mPlatformBuilder.build()));
        }

        public void setClip(ClipData arg1) {
            this.mPlatformBuilder.setClip(arg1);
        }

        public void setExtras(Bundle arg1) {
            this.mPlatformBuilder.setExtras(arg1);
        }

        public void setFlags(int arg1) {
            this.mPlatformBuilder.setFlags(arg1);
        }

        public void setLinkUri(Uri arg1) {
            this.mPlatformBuilder.setLinkUri(arg1);
        }

        public void setSource(int arg1) {
            this.mPlatformBuilder.setSource(arg1);
        }
    }

    interface BuilderCompat {
        ContentInfoCompat build();

        void setClip(ClipData arg1);

        void setExtras(Bundle arg1);

        void setFlags(int arg1);

        void setLinkUri(Uri arg1);

        void setSource(int arg1);
    }

    final class BuilderCompatImpl implements BuilderCompat {
        ClipData mClip;
        Bundle mExtras;
        int mFlags;
        Uri mLinkUri;
        int mSource;

        BuilderCompatImpl(ClipData arg1, int arg2) {
            super();
            this.mClip = arg1;
            this.mSource = arg2;
        }

        BuilderCompatImpl(ContentInfoCompat arg2) {
            super();
            this.mClip = arg2.getClip();
            this.mSource = arg2.getSource();
            this.mFlags = arg2.getFlags();
            this.mLinkUri = arg2.getLinkUri();
            this.mExtras = arg2.getExtras();
        }

        public ContentInfoCompat build() {
            return new ContentInfoCompat(new CompatImpl(this));
        }

        public void setClip(ClipData arg1) {
            this.mClip = arg1;
        }

        public void setExtras(Bundle arg1) {
            this.mExtras = arg1;
        }

        public void setFlags(int arg1) {
            this.mFlags = arg1;
        }

        public void setLinkUri(Uri arg1) {
            this.mLinkUri = arg1;
        }

        public void setSource(int arg1) {
            this.mSource = arg1;
        }
    }

    final class Compat31Impl implements Compat {
        private final ContentInfo mWrapped;

        Compat31Impl(ContentInfo arg1) {
            super();
            this.mWrapped = Preconditions.checkNotNull(arg1);
        }

        public ClipData getClip() {
            return this.mWrapped.getClip();
        }

        public Bundle getExtras() {
            return this.mWrapped.getExtras();
        }

        public int getFlags() {
            return this.mWrapped.getFlags();
        }

        public Uri getLinkUri() {
            return this.mWrapped.getLinkUri();
        }

        public int getSource() {
            return this.mWrapped.getSource();
        }

        public ContentInfo getWrapped() {
            return this.mWrapped;
        }

        public String toString() {
            return "ContentInfoCompat{" + this.mWrapped + "}";
        }
    }

    interface Compat {
        ClipData getClip();

        Bundle getExtras();

        int getFlags();

        Uri getLinkUri();

        int getSource();

        ContentInfo getWrapped();
    }

    final class CompatImpl implements Compat {
        private final ClipData mClip;
        private final Bundle mExtras;
        private final int mFlags;
        private final Uri mLinkUri;
        private final int mSource;

        CompatImpl(BuilderCompatImpl arg5) {
            super();
            this.mClip = Preconditions.checkNotNull(arg5.mClip);
            this.mSource = Preconditions.checkArgumentInRange(arg5.mSource, 0, 5, "source");
            this.mFlags = Preconditions.checkFlagsArgument(arg5.mFlags, 1);
            this.mLinkUri = arg5.mLinkUri;
            this.mExtras = arg5.mExtras;
        }

        public ClipData getClip() {
            return this.mClip;
        }

        public Bundle getExtras() {
            return this.mExtras;
        }

        public int getFlags() {
            return this.mFlags;
        }

        public Uri getLinkUri() {
            return this.mLinkUri;
        }

        public int getSource() {
            return this.mSource;
        }

        public ContentInfo getWrapped() {
            return null;
        }

        public String toString() {
            StringBuilder v0 = new StringBuilder("ContentInfoCompat{clip=").append(this.mClip.getDescription()).append(", source=").append(ContentInfoCompat.sourceToString(this.mSource)).append(", flags=").append(ContentInfoCompat.flagsToString(this.mFlags));
            String v2 = "";
            String v1 = this.mLinkUri == null ? v2 : ", hasLinkUri(" + this.mLinkUri.toString().length() + ")";
            v0 = v0.append(v1);
            if(this.mExtras == null) {
            }
            else {
                v2 = ", hasExtras";
            }

            return v0.append(v2).append("}").toString();
        }
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface Flags {
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface Source {
    }

    public static final int FLAG_CONVERT_TO_PLAIN_TEXT = 1;
    public static final int SOURCE_APP = 0;
    public static final int SOURCE_AUTOFILL = 4;
    public static final int SOURCE_CLIPBOARD = 1;
    public static final int SOURCE_DRAG_AND_DROP = 3;
    public static final int SOURCE_INPUT_METHOD = 2;
    public static final int SOURCE_PROCESS_TEXT = 5;
    private final Compat mCompat;

    ContentInfoCompat(Compat arg1) {
        super();
        this.mCompat = arg1;
    }

    static ClipData buildClipData(ClipDescription arg2, List arg3) {
        ClipData v0 = new ClipData(new ClipDescription(arg2), arg3.get(0));
        int v2;
        for(v2 = 1; v2 < arg3.size(); ++v2) {
            v0.addItem(arg3.get(v2));
        }

        return v0;
    }

    static String flagsToString(int arg1) {
        if((arg1 & 1) != 0) {
            return "FLAG_CONVERT_TO_PLAIN_TEXT";
        }

        return String.valueOf(arg1);
    }

    public ClipData getClip() {
        return this.mCompat.getClip();
    }

    public Bundle getExtras() {
        return this.mCompat.getExtras();
    }

    public int getFlags() {
        return this.mCompat.getFlags();
    }

    public Uri getLinkUri() {
        return this.mCompat.getLinkUri();
    }

    public int getSource() {
        return this.mCompat.getSource();
    }

    static Pair partition(ClipData arg6, androidx.core.util.Predicate arg7) {
        Object v0 = null;
        int v1 = 0;
        ArrayList v2 = ((ArrayList)v0);
        ArrayList v3 = v2;
        while(v1 < arg6.getItemCount()) {
            ClipData$Item v4 = arg6.getItemAt(v1);
            if(arg7.test(v4)) {
                if(v2 == null) {
                    v2 = new ArrayList();
                }

                v2.add(v4);
            }
            else {
                if(v3 == null) {
                    v3 = new ArrayList();
                }

                v3.add(v4);
            }

            ++v1;
        }

        if(v2 == null) {
            return Pair.create(v0, arg6);
        }

        if(v3 == null) {
            return Pair.create(arg6, v0);
        }

        return Pair.create(ContentInfoCompat.buildClipData(arg6.getDescription(), ((List)v2)), ContentInfoCompat.buildClipData(arg6.getDescription(), ((List)v3)));
    }

    public static Pair partition(ContentInfo arg0, Predicate arg1) {
        return Api31Impl.partition(arg0, arg1);
    }

    public Pair partition(androidx.core.util.Predicate arg5) {
        Object v4;
        Object v0_2;
        ClipData v0 = this.mCompat.getClip();
        Object v3 = null;
        if(v0.getItemCount() == 1) {
            boolean v5 = arg5.test(v0.getItemAt(0));
            if(v5) {
                ContentInfoCompat v0_1 = this;
            }
            else {
                v0_2 = v3;
            }

            if(v5) {
                v4 = v3;
            }

            return Pair.create(v0_2, v4);
        }

        Pair v5_1 = ContentInfoCompat.partition(v0, arg5);
        if(v5_1.first == null) {
            return Pair.create(v3, this);
        }

        if(v5_1.second == null) {
            return Pair.create(this, v3);
        }

        return Pair.create(new Builder(this).setClip(v5_1.first).build(), new Builder(this).setClip(v5_1.second).build());
    }

    static String sourceToString(int arg1) {
        if(arg1 != 0) {
            if(arg1 != 1) {
                if(arg1 != 2) {
                    if(arg1 != 3) {
                        if(arg1 != 4) {
                            if(arg1 != 5) {
                                return String.valueOf(arg1);
                            }

                            return "SOURCE_PROCESS_TEXT";
                        }

                        return "SOURCE_AUTOFILL";
                    }

                    return "SOURCE_DRAG_AND_DROP";
                }

                return "SOURCE_INPUT_METHOD";
            }

            return "SOURCE_CLIPBOARD";
        }

        return "SOURCE_APP";
    }

    public ContentInfo toContentInfo() {
        return Objects.requireNonNull(this.mCompat.getWrapped());
    }

    public static ContentInfoCompat toContentInfoCompat(ContentInfo arg2) {
        return new ContentInfoCompat(new Compat31Impl(arg2));
    }

    public String toString() {
        return this.mCompat.toString();
    }
}

