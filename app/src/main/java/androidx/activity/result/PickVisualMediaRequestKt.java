package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContracts$PickMultipleVisualMedia;
import androidx.activity.result.contract.ActivityResultContracts$PickVisualMedia$DefaultTab$PhotosTab;
import androidx.activity.result.contract.ActivityResultContracts$PickVisualMedia$DefaultTab;
import androidx.activity.result.contract.ActivityResultContracts$PickVisualMedia$ImageAndVideo;
import androidx.activity.result.contract.ActivityResultContracts$PickVisualMedia$MediaCapabilities;
import androidx.activity.result.contract.ActivityResultContracts$PickVisualMedia$VisualMediaType;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\u0012\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u0003H\u0007\u001A\u001C\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0003\u0010\u0004\u001A\u00020\u0005H\u0007\u001A.\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0003\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t\u001A6\u0010\u0000\u001A\u00020\u00012\u0006\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0003\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t\u001A:\u0010\u0000\u001A\u00020\u00012\b\u0010\f\u001A\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0003\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\tH\u0007\u001AB\u0010\u0000\u001A\u00020\u00012\b\u0010\f\u001A\u0004\u0018\u00010\r2\u0006\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0003\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\tH\u0007¨\u0006\u000E"}, d2={"PickVisualMediaRequest", "Landroidx/activity/result/PickVisualMediaRequest;", "mediaType", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VisualMediaType;", "maxItems", "", "isOrderedSelection", "", "defaultTab", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$DefaultTab;", "accentColor", "", "mediaCapabilitiesForTranscoding", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$MediaCapabilities;", "activity"}, k=2, mv={2, 1, 0}, xi=0x30) public final class PickVisualMediaRequestKt {
    public static final PickVisualMediaRequest PickVisualMediaRequest(long arg1, VisualMediaType arg3, int arg4, boolean arg5, DefaultTab arg6) {
        Intrinsics.checkNotNullParameter(arg3, "mediaType");
        Intrinsics.checkNotNullParameter(arg6, "defaultTab");
        return new Builder().setMediaType(arg3).setMaxItems(arg4).setOrderedSelection(arg5).setDefaultTab(arg6).setAccentColor(arg1).build();
    }

    public static final PickVisualMediaRequest PickVisualMediaRequest(MediaCapabilities arg1, long arg2, VisualMediaType arg4, int arg5, boolean arg6, DefaultTab arg7) {
        Intrinsics.checkNotNullParameter(arg4, "mediaType");
        Intrinsics.checkNotNullParameter(arg7, "defaultTab");
        return new Builder().setMediaType(arg4).setMaxItems(arg5).setOrderedSelection(arg6).setDefaultTab(arg7).setAccentColor(arg2).setMediaCapabilitiesForTranscoding(arg1).build();
    }

    public static final PickVisualMediaRequest PickVisualMediaRequest(MediaCapabilities arg1, VisualMediaType arg2, int arg3, boolean arg4, DefaultTab arg5) {
        Intrinsics.checkNotNullParameter(arg2, "mediaType");
        Intrinsics.checkNotNullParameter(arg5, "defaultTab");
        return new Builder().setMediaType(arg2).setMaxItems(arg3).setOrderedSelection(arg4).setDefaultTab(arg5).setMediaCapabilitiesForTranscoding(arg1).build();
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Superseded by PickVisualMediaRequest that takes an optional maxItems") public static final PickVisualMediaRequest PickVisualMediaRequest(VisualMediaType arg1) {
        Intrinsics.checkNotNullParameter(arg1, "mediaType");
        return new Builder().setMediaType(arg1).build();
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Superseded by PickVisualMediaRequest that take optional isOrderedSelection and defaultTab") public static final PickVisualMediaRequest PickVisualMediaRequest(VisualMediaType arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "mediaType");
        return new Builder().setMediaType(arg1).setMaxItems(arg2).build();
    }

    public static final PickVisualMediaRequest PickVisualMediaRequest(VisualMediaType arg1, int arg2, boolean arg3, DefaultTab arg4) {
        Intrinsics.checkNotNullParameter(arg1, "mediaType");
        Intrinsics.checkNotNullParameter(arg4, "defaultTab");
        return new Builder().setMediaType(arg1).setMaxItems(arg2).setOrderedSelection(arg3).setDefaultTab(arg4).build();
    }

    public static PickVisualMediaRequest PickVisualMediaRequest$default(long arg6, VisualMediaType arg8, int arg9, boolean arg10, DefaultTab arg11, int arg12, Object arg13) {
        PhotosTab v11;
        ImageAndVideo v8;
        if((arg12 & 2) != 0) {
            v8 = ImageAndVideo.INSTANCE;
        }

        VisualMediaType v2 = ((VisualMediaType)v8);
        if((arg12 & 4) != 0) {
            arg9 = PickMultipleVisualMedia.Companion.getMaxItems$activity();
        }

        int v3 = arg9;
        if((arg12 & 16) != 0) {
            v11 = PhotosTab.INSTANCE;
        }

        return PickVisualMediaRequestKt.PickVisualMediaRequest(arg6, v2, v3, false, ((DefaultTab)v11));
    }

    public static PickVisualMediaRequest PickVisualMediaRequest$default(MediaCapabilities arg7, long arg8, VisualMediaType arg10, int arg11, boolean arg12, DefaultTab arg13, int arg14, Object arg15) {
        PhotosTab v13;
        ImageAndVideo v10;
        if((arg14 & 4) != 0) {
            v10 = ImageAndVideo.INSTANCE;
        }

        VisualMediaType v3 = ((VisualMediaType)v10);
        if((arg14 & 8) != 0) {
            arg11 = PickMultipleVisualMedia.Companion.getMaxItems$activity();
        }

        int v4 = arg11;
        if((arg14 & 0x20) != 0) {
            v13 = PhotosTab.INSTANCE;
        }

        return PickVisualMediaRequestKt.PickVisualMediaRequest(arg7, arg8, v3, v4, false, ((DefaultTab)v13));
    }

    public static PickVisualMediaRequest PickVisualMediaRequest$default(MediaCapabilities arg0, VisualMediaType arg1, int arg2, boolean arg3, DefaultTab arg4, int arg5, Object arg6) {
        PhotosTab v4;
        ImageAndVideo v1;
        if((arg5 & 2) != 0) {
            v1 = ImageAndVideo.INSTANCE;
        }

        if((arg5 & 4) != 0) {
            arg2 = PickMultipleVisualMedia.Companion.getMaxItems$activity();
        }

        if((arg5 & 16) != 0) {
            v4 = PhotosTab.INSTANCE;
        }

        return PickVisualMediaRequestKt.PickVisualMediaRequest(arg0, ((VisualMediaType)v1), arg2, false, ((DefaultTab)v4));
    }

    public static PickVisualMediaRequest PickVisualMediaRequest$default(VisualMediaType arg0, int arg1, int arg2, Object arg3) {
        ImageAndVideo v0;
        if((arg2 & 1) != 0) {
            v0 = ImageAndVideo.INSTANCE;
        }

        if((arg2 & 2) != 0) {
            arg1 = PickMultipleVisualMedia.Companion.getMaxItems$activity();
        }

        return PickVisualMediaRequestKt.PickVisualMediaRequest(((VisualMediaType)v0), arg1);
    }

    public static PickVisualMediaRequest PickVisualMediaRequest$default(VisualMediaType arg0, int arg1, Object arg2) {
        ImageAndVideo v0;
        if((arg1 & 1) != 0) {
            v0 = ImageAndVideo.INSTANCE;
        }

        return PickVisualMediaRequestKt.PickVisualMediaRequest(((VisualMediaType)v0));
    }

    public static PickVisualMediaRequest PickVisualMediaRequest$default(VisualMediaType arg0, int arg1, boolean arg2, DefaultTab arg3, int arg4, Object arg5) {
        PhotosTab v3;
        ImageAndVideo v0;
        if((arg4 & 1) != 0) {
            v0 = ImageAndVideo.INSTANCE;
        }

        if((arg4 & 2) != 0) {
            arg1 = PickMultipleVisualMedia.Companion.getMaxItems$activity();
        }

        if((arg4 & 8) != 0) {
            v3 = PhotosTab.INSTANCE;
        }

        return PickVisualMediaRequestKt.PickVisualMediaRequest(((VisualMediaType)v0), arg1, false, ((DefaultTab)v3));
    }
}

