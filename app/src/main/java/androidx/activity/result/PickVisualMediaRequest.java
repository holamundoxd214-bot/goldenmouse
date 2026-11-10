package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContracts$PickMultipleVisualMedia;
import androidx.activity.result.contract.ActivityResultContracts$PickVisualMedia$DefaultTab$PhotosTab;
import androidx.activity.result.contract.ActivityResultContracts$PickVisualMedia$DefaultTab;
import androidx.activity.result.contract.ActivityResultContracts$PickVisualMedia$ImageAndVideo;
import androidx.activity.result.contract.ActivityResultContracts$PickVisualMedia$MediaCapabilities;
import androidx.activity.result.contract.ActivityResultContracts$PickVisualMedia$VisualMediaType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001*B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0004\u001A\u00020\u0005@@X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\f\u001A\u00020\u000B2\u0006\u0010\u0004\u001A\u00020\u000B@@X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010R$\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0004\u001A\u00020\u0011@@X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0004\u001A\u00020\u0016@@X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0018\u0010\u0019\"\u0004\b\u001A\u0010\u001BR$\u0010\u001C\u001A\u00020\u00112\u0006\u0010\u0004\u001A\u00020\u0011@@X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001C\u0010\u0013\"\u0004\b\u001D\u0010\u0015R$\u0010\u001F\u001A\u00020\u001E2\u0006\u0010\u0004\u001A\u00020\u001E@@X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b \u0010!\"\u0004\b\"\u0010#R(\u0010%\u001A\u0004\u0018\u00010$2\b\u0010\u0004\u001A\u0004\u0018\u00010$@@X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b&\u0010\'\"\u0004\b(\u0010)¨\u0006+"}, d2={"Landroidx/activity/result/PickVisualMediaRequest;", "", "<init>", "()V", "value", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VisualMediaType;", "mediaType", "getMediaType", "()Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VisualMediaType;", "setMediaType$activity", "(Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VisualMediaType;)V", "", "maxItems", "getMaxItems", "()I", "setMaxItems$activity", "(I)V", "", "isOrderedSelection", "()Z", "setOrderedSelection$activity", "(Z)V", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$DefaultTab;", "defaultTab", "getDefaultTab", "()Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$DefaultTab;", "setDefaultTab$activity", "(Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$DefaultTab;)V", "isCustomAccentColorApplied", "setCustomAccentColorApplied$activity", "", "accentColor", "getAccentColor", "()J", "setAccentColor$activity", "(J)V", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$MediaCapabilities;", "mediaCapabilitiesForTranscoding", "getMediaCapabilitiesForTranscoding", "()Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$MediaCapabilities;", "setMediaCapabilitiesForTranscoding$activity", "(Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$MediaCapabilities;)V", "Builder", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public final class PickVisualMediaRequest {
    @Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0011\u001A\u00020\u00002\u0006\u0010\u0004\u001A\u00020\u0005J\u0010\u0010\u0012\u001A\u00020\u00002\b\b\u0001\u0010\u0006\u001A\u00020\u0007J\u000E\u0010\u0013\u001A\u00020\u00002\u0006\u0010\b\u001A\u00020\tJ\u000E\u0010\u0014\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u000BJ\u000E\u0010\u0015\u001A\u00020\u00002\u0006\u0010\r\u001A\u00020\u000EJ\u0012\u0010\u0016\u001A\u00020\u00002\b\u0010\u0017\u001A\u0004\u0018\u00010\u0010H\u0007J\u0006\u0010\u0018\u001A\u00020\u0019R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u000F\u001A\u0004\u0018\u00010\u0010X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u001A"}, d2={"Landroidx/activity/result/PickVisualMediaRequest$Builder;", "", "<init>", "()V", "mediaType", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VisualMediaType;", "maxItems", "", "isOrderedSelection", "", "defaultTab", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$DefaultTab;", "isCustomAccentColorApplied", "accentColor", "", "mediaCapabilitiesForTranscoding", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$MediaCapabilities;", "setMediaType", "setMaxItems", "setOrderedSelection", "setDefaultTab", "setAccentColor", "setMediaCapabilitiesForTranscoding", "mediaCapabilities", "build", "Landroidx/activity/result/PickVisualMediaRequest;", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Builder {
        private long accentColor;
        private DefaultTab defaultTab;
        private boolean isCustomAccentColorApplied;
        private boolean isOrderedSelection;
        private int maxItems;
        private MediaCapabilities mediaCapabilitiesForTranscoding;
        private VisualMediaType mediaType;

        public Builder() {
            super();
            this.mediaType = ImageAndVideo.INSTANCE;
            this.maxItems = PickMultipleVisualMedia.Companion.getMaxItems$activity();
            this.defaultTab = PhotosTab.INSTANCE;
        }

        public final PickVisualMediaRequest build() {
            PickVisualMediaRequest v0 = new PickVisualMediaRequest();
            v0.setMediaType$activity(this.mediaType);
            v0.setMaxItems$activity(this.maxItems);
            v0.setOrderedSelection$activity(this.isOrderedSelection);
            v0.setDefaultTab$activity(this.defaultTab);
            v0.setCustomAccentColorApplied$activity(this.isCustomAccentColorApplied);
            v0.setAccentColor$activity(this.accentColor);
            v0.setMediaCapabilitiesForTranscoding$activity(this.mediaCapabilitiesForTranscoding);
            return v0;
        }

        public final Builder setAccentColor(long arg1) {
            this.accentColor = arg1;
            this.isCustomAccentColorApplied = true;
            return this;
        }

        public final Builder setDefaultTab(DefaultTab arg2) {
            Intrinsics.checkNotNullParameter(arg2, "defaultTab");
            this.defaultTab = arg2;
            return this;
        }

        public final Builder setMaxItems(int arg1) {
            this.maxItems = arg1;
            return this;
        }

        public final Builder setMediaCapabilitiesForTranscoding(MediaCapabilities arg1) {
            this.mediaCapabilitiesForTranscoding = arg1;
            return this;
        }

        public final Builder setMediaType(VisualMediaType arg2) {
            Intrinsics.checkNotNullParameter(arg2, "mediaType");
            this.mediaType = arg2;
            return this;
        }

        public final Builder setOrderedSelection(boolean arg1) {
            this.isOrderedSelection = arg1;
            return this;
        }
    }

    private long accentColor;
    private DefaultTab defaultTab;
    private boolean isCustomAccentColorApplied;
    private boolean isOrderedSelection;
    private int maxItems;
    private MediaCapabilities mediaCapabilitiesForTranscoding;
    private VisualMediaType mediaType;

    public PickVisualMediaRequest() {
        super();
        this.mediaType = ImageAndVideo.INSTANCE;
        this.maxItems = PickMultipleVisualMedia.Companion.getMaxItems$activity();
        this.defaultTab = PhotosTab.INSTANCE;
    }

    public final long getAccentColor() {
        return this.accentColor;
    }

    public final DefaultTab getDefaultTab() {
        return this.defaultTab;
    }

    public final int getMaxItems() {
        return this.maxItems;
    }

    public final MediaCapabilities getMediaCapabilitiesForTranscoding() {
        return this.mediaCapabilitiesForTranscoding;
    }

    public final VisualMediaType getMediaType() {
        return this.mediaType;
    }

    public final boolean isCustomAccentColorApplied() {
        return this.isCustomAccentColorApplied;
    }

    public final boolean isOrderedSelection() {
        return this.isOrderedSelection;
    }

    public final void setAccentColor$activity(long arg1) {
        this.accentColor = arg1;
    }

    public final void setCustomAccentColorApplied$activity(boolean arg1) {
        this.isCustomAccentColorApplied = arg1;
    }

    public final void setDefaultTab$activity(DefaultTab arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<set-?>");
        this.defaultTab = arg2;
    }

    public final void setMaxItems$activity(int arg1) {
        this.maxItems = arg1;
    }

    public final void setMediaCapabilitiesForTranscoding$activity(MediaCapabilities arg1) {
        this.mediaCapabilitiesForTranscoding = arg1;
    }

    public final void setMediaType$activity(VisualMediaType arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<set-?>");
        this.mediaType = arg2;
    }

    public final void setOrderedSelection$activity(boolean arg1) {
        this.isOrderedSelection = arg1;
    }
}

