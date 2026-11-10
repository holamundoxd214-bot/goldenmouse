package androidx.activity.result.contract;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.media.ApplicationMediaCapabilities$Builder;
import android.media.ApplicationMediaCapabilities;
import android.net.Uri;
import android.os.Build$VERSION;
import android.os.Parcelable;
import android.os.ext.SdkExtensions;
import android.provider.MediaStore;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.core.content.ContextCompat;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0014\u0018\u00002\u00020\u0001:\u0011\u0004\u0005\u0006\u0007\b\t\n\u000B\f\r\u000E\u000F\u0010\u0011\u0012\u0013\u0014B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0015"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts;", "", "<init>", "()V", "StartActivityForResult", "StartIntentSenderForResult", "RequestMultiplePermissions", "RequestPermission", "TakePicturePreview", "TakePicture", "TakeVideo", "CaptureVideo", "PickContact", "GetContent", "GetMultipleContents", "OpenDocument", "OpenMultipleDocuments", "OpenDocumentTree", "CreateDocument", "PickVisualMedia", "PickMultipleVisualMedia", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ActivityResultContracts {
    @Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0002H\u0017J\u001E\u0010\u000B\u001A\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f2\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0002J\u001D\u0010\r\u001A\u00020\u00032\u0006\u0010\u000E\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$CaptureVideo;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroid/net/Uri;", "", "<init>", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "(ILandroid/content/Intent;)Ljava/lang/Boolean;", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public class CaptureVideo extends ActivityResultContract {
        public CaptureVideo() {
            super();
        }

        public Intent createIntent(Context arg1, Uri arg2) {
            Intrinsics.checkNotNullParameter(arg1, "context");
            Intrinsics.checkNotNullParameter(arg2, "input");
            Intent v0 = new Intent("android.media.action.VIDEO_CAPTURE").putExtra("output", ((Parcelable)arg2)).addFlags(1).addFlags(2);
            Intrinsics.checkNotNullExpressionValue(v0, "addFlags(...)");
            return v0;
        }

        public Intent createIntent(Context arg1, Object arg2) {
            return this.createIntent(arg1, ((Uri)arg2));
        }

        public final SynchronousResult getSynchronousResult(Context arg1, Uri arg2) {
            Intrinsics.checkNotNullParameter(arg1, "context");
            Intrinsics.checkNotNullParameter(arg2, "input");
            return null;
        }

        public SynchronousResult getSynchronousResult(Context arg1, Object arg2) {
            return this.getSynchronousResult(arg1, ((Uri)arg2));
        }

        public final Boolean parseResult(int arg1, Intent arg2) {
            boolean v0 = arg1 == -1 ? true : false;
            return Boolean.valueOf(v0);
        }

        public Object parseResult(int arg1, Intent arg2) {
            return this.parseResult(arg1, arg2);
        }
    }

    @Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0016\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006B\t\b\u0017¢\u0006\u0004\b\u0005\u0010\u0007J\u0018\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u0002H\u0017J \u0010\r\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000E2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u0002J\u001A\u0010\u000F\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u0010\u001A\u00020\u00112\b\u0010\u0012\u001A\u0004\u0018\u00010\tR\u000E\u0010\u0004\u001A\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$CreateDocument;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "Landroid/net/Uri;", "mimeType", "<init>", "(Ljava/lang/String;)V", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public class CreateDocument extends ActivityResultContract {
        private final String mimeType;

        @Deprecated(message="Using a wildcard mime type with CreateDocument is not recommended as it breaks the automatic handling of file extensions. Instead, specify the mime type by using the constructor that takes an concrete mime type (e.g.., CreateDocument(\"image/png\")).", replaceWith="<_subannotation>") public CreateDocument() {
            this("*/*");
        }

        public CreateDocument(String arg2) {
            Intrinsics.checkNotNullParameter(arg2, "mimeType");
            super();
            this.mimeType = arg2;
        }

        public Intent createIntent(Context arg1, Object arg2) {
            return this.createIntent(arg1, ((String)arg2));
        }

        public Intent createIntent(Context arg2, String arg3) {
            Intrinsics.checkNotNullParameter(arg2, "context");
            Intrinsics.checkNotNullParameter(arg3, "input");
            Intent v1 = new Intent("android.intent.action.CREATE_DOCUMENT").setType(this.mimeType).putExtra("android.intent.extra.TITLE", arg3);
            Intrinsics.checkNotNullExpressionValue(v1, "putExtra(...)");
            return v1;
        }

        public SynchronousResult getSynchronousResult(Context arg1, Object arg2) {
            return this.getSynchronousResult(arg1, ((String)arg2));
        }

        public final SynchronousResult getSynchronousResult(Context arg1, String arg2) {
            Intrinsics.checkNotNullParameter(arg1, "context");
            Intrinsics.checkNotNullParameter(arg2, "input");
            return null;
        }

        public final Uri parseResult(int arg2, Intent arg3) {
            Uri v0 = null;
            if(arg2 == -1) {
            }
            else {
                arg3 = ((Intent)v0);
            }

            if(arg3 != null) {
                return arg3.getData();
            }

            return v0;
        }

        public Object parseResult(int arg1, Intent arg2) {
            return this.parseResult(arg1, arg2);
        }
    }

    @Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0016\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0002H\u0017J \u0010\u000B\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\f2\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0002J\u001A\u0010\r\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u000E\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0007¨\u0006\u0011"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$GetContent;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "Landroid/net/Uri;", "<init>", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public class GetContent extends ActivityResultContract {
        public GetContent() {
            super();
        }

        public Intent createIntent(Context arg1, Object arg2) {
            return this.createIntent(arg1, ((String)arg2));
        }

        public Intent createIntent(Context arg1, String arg2) {
            Intrinsics.checkNotNullParameter(arg1, "context");
            Intrinsics.checkNotNullParameter(arg2, "input");
            Intent v0 = new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(arg2);
            Intrinsics.checkNotNullExpressionValue(v0, "setType(...)");
            return v0;
        }

        public SynchronousResult getSynchronousResult(Context arg1, Object arg2) {
            return this.getSynchronousResult(arg1, ((String)arg2));
        }

        public final SynchronousResult getSynchronousResult(Context arg1, String arg2) {
            Intrinsics.checkNotNullParameter(arg1, "context");
            Intrinsics.checkNotNullParameter(arg2, "input");
            return null;
        }

        public final Uri parseResult(int arg2, Intent arg3) {
            Uri v0 = null;
            if(arg2 == -1) {
            }
            else {
                arg3 = ((Intent)v0);
            }

            if(arg3 != null) {
                return arg3.getData();
            }

            return v0;
        }

        public Object parseResult(int arg1, Intent arg2) {
            return this.parseResult(arg1, arg2);
        }
    }

    @Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00132\u0019\u0012\u0004\u0012\u00020\u0002\u0012\u000F\u0012\r\u0012\t\u0012\u00070\u0004¢\u0006\u0002\b\u00050\u00030\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u0002H\u0017J$\u0010\r\u001A\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u000E2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u0002J\u001E\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0010\u001A\u00020\u00112\b\u0010\u0012\u001A\u0004\u0018\u00010\t¨\u0006\u0014"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$GetMultipleContents;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "", "Landroid/net/Uri;", "Lkotlin/jvm/JvmSuppressWildcards;", "<init>", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "Companion", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public class GetMultipleContents extends ActivityResultContract {
        @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u0007H\u0000¢\u0006\u0002\b\b¨\u0006\t"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$GetMultipleContents$Companion;", "", "<init>", "()V", "getClipDataUris", "", "Landroid/net/Uri;", "Landroid/content/Intent;", "getClipDataUris$activity", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
            public Companion(DefaultConstructorMarker arg1) {
                this();
            }

            private Companion() {
                super();
            }

            public final List getClipDataUris$activity(Intent arg4) {
                Intrinsics.checkNotNullParameter(arg4, "<this>");
                LinkedHashSet v3 = new LinkedHashSet();
                Uri v0 = arg4.getData();
                if(v0 != null) {
                    v3.add(v0);
                }

                ClipData v4 = arg4.getClipData();
                if(v4 == null && (v3.isEmpty())) {
                    return CollectionsKt.emptyList();
                }

                if(v4 != null) {
                    int v0_1 = v4.getItemCount();
                    int v1;
                    for(v1 = 0; v1 < v0_1; ++v1) {
                        Uri v2 = v4.getItemAt(v1).getUri();
                        if(v2 != null) {
                            v3.add(v2);
                        }
                    }
                }

                return new ArrayList(((Collection)v3));
            }
        }

        public static final Companion Companion;

        static {
            GetMultipleContents.Companion = new Companion(null);
        }

        public GetMultipleContents() {
            super();
        }

        public Intent createIntent(Context arg1, Object arg2) {
            return this.createIntent(arg1, ((String)arg2));
        }

        public Intent createIntent(Context arg1, String arg2) {
            Intrinsics.checkNotNullParameter(arg1, "context");
            Intrinsics.checkNotNullParameter(arg2, "input");
            Intent v0 = new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(arg2).putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
            Intrinsics.checkNotNullExpressionValue(v0, "putExtra(...)");
            return v0;
        }

        public SynchronousResult getSynchronousResult(Context arg1, Object arg2) {
            return this.getSynchronousResult(arg1, ((String)arg2));
        }

        public final SynchronousResult getSynchronousResult(Context arg1, String arg2) {
            Intrinsics.checkNotNullParameter(arg1, "context");
            Intrinsics.checkNotNullParameter(arg2, "input");
            return null;
        }

        public Object parseResult(int arg1, Intent arg2) {
            return this.parseResult(arg1, arg2);
        }

        public final List parseResult(int arg1, Intent arg2) {
            if(arg1 == -1) {
            }
            else {
                arg2 = null;
            }

            if(0 != 0) {
                List v0 = GetMultipleContents.Companion.getClipDataUris$activity(arg2);
                if(v0 == null) {
                }
                else {
                    return v0;
                }
            }

            return CollectionsKt.emptyList();
        }
    }

    @Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0016\u0018\u00002\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0017¢\u0006\u0002\u0010\fJ+\u0010\r\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u000E2\u0006\u0010\t\u001A\u00020\n2\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\u0010\u000FJ\u001A\u0010\u0010\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001A\u00020\u00122\b\u0010\u0013\u001A\u0004\u0018\u00010\b¨\u0006\u0014"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$OpenDocument;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "", "Landroid/net/Uri;", "<init>", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "(Landroid/content/Context;[Ljava/lang/String;)Landroid/content/Intent;", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "(Landroid/content/Context;[Ljava/lang/String;)Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public class OpenDocument extends ActivityResultContract {
        public OpenDocument() {
            super();
        }

        public Intent createIntent(Context arg1, Object arg2) {
            return this.createIntent(arg1, ((String[])arg2));
        }

        public Intent createIntent(Context arg1, String[] arg2) {
            Intrinsics.checkNotNullParameter(arg1, "context");
            Intrinsics.checkNotNullParameter(arg2, "input");
            Intent v0 = new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", arg2).setType("*/*");
            Intrinsics.checkNotNullExpressionValue(v0, "setType(...)");
            return v0;
        }

        public SynchronousResult getSynchronousResult(Context arg1, Object arg2) {
            return this.getSynchronousResult(arg1, ((String[])arg2));
        }

        public final SynchronousResult getSynchronousResult(Context arg1, String[] arg2) {
            Intrinsics.checkNotNullParameter(arg1, "context");
            Intrinsics.checkNotNullParameter(arg2, "input");
            return null;
        }

        public final Uri parseResult(int arg2, Intent arg3) {
            Uri v0 = null;
            if(arg2 == -1) {
            }
            else {
                arg3 = ((Intent)v0);
            }

            if(arg3 != null) {
                return arg3.getData();
            }

            return v0;
        }

        public Object parseResult(int arg1, Intent arg2) {
            return this.parseResult(arg1, arg2);
        }
    }

    @Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0016\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001A\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\b\u0010\t\u001A\u0004\u0018\u00010\u0002H\u0017J\"\u0010\n\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u000B2\u0006\u0010\u0007\u001A\u00020\b2\b\u0010\t\u001A\u0004\u0018\u00010\u0002J\u001A\u0010\f\u001A\u0004\u0018\u00010\u00022\u0006\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0006¨\u0006\u0010"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$OpenDocumentTree;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroid/net/Uri;", "<init>", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public class OpenDocumentTree extends ActivityResultContract {
        public OpenDocumentTree() {
            super();
        }

        public Intent createIntent(Context arg1, Uri arg2) {
            Intrinsics.checkNotNullParameter(arg1, "context");
            Intent v0 = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
            if(arg2 != null) {
                v0.putExtra("android.provider.extra.INITIAL_URI", ((Parcelable)arg2));
            }

            return v0;
        }

        public Intent createIntent(Context arg1, Object arg2) {
            return this.createIntent(arg1, ((Uri)arg2));
        }

        public final SynchronousResult getSynchronousResult(Context arg1, Uri arg2) {
            Intrinsics.checkNotNullParameter(arg1, "context");
            return null;
        }

        public SynchronousResult getSynchronousResult(Context arg1, Object arg2) {
            return this.getSynchronousResult(arg1, ((Uri)arg2));
        }

        public final Uri parseResult(int arg2, Intent arg3) {
            Uri v0 = null;
            if(arg2 == -1) {
            }
            else {
                arg3 = ((Intent)v0);
            }

            if(arg3 != null) {
                return arg3.getData();
            }

            return v0;
        }

        public Object parseResult(int arg1, Intent arg2) {
            return this.parseResult(arg1, arg2);
        }
    }

    @Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000E\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0016\u0018\u00002\u001F\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000F\u0012\r\u0012\t\u0012\u00070\u0005¢\u0006\u0002\b\u00060\u00040\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\f\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0017¢\u0006\u0002\u0010\u000EJ/\u0010\u000F\u001A\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u00102\u0006\u0010\u000B\u001A\u00020\f2\f\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\u0010\u0011J\u001E\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0013\u001A\u00020\u00142\b\u0010\u0015\u001A\u0004\u0018\u00010\n¨\u0006\u0016"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$OpenMultipleDocuments;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "", "", "Landroid/net/Uri;", "Lkotlin/jvm/JvmSuppressWildcards;", "<init>", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "(Landroid/content/Context;[Ljava/lang/String;)Landroid/content/Intent;", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "(Landroid/content/Context;[Ljava/lang/String;)Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public class OpenMultipleDocuments extends ActivityResultContract {
        public OpenMultipleDocuments() {
            super();
        }

        public Intent createIntent(Context arg1, Object arg2) {
            return this.createIntent(arg1, ((String[])arg2));
        }

        public Intent createIntent(Context arg1, String[] arg2) {
            Intrinsics.checkNotNullParameter(arg1, "context");
            Intrinsics.checkNotNullParameter(arg2, "input");
            Intent v0 = new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", arg2).putExtra("android.intent.extra.ALLOW_MULTIPLE", true).setType("*/*");
            Intrinsics.checkNotNullExpressionValue(v0, "setType(...)");
            return v0;
        }

        public SynchronousResult getSynchronousResult(Context arg1, Object arg2) {
            return this.getSynchronousResult(arg1, ((String[])arg2));
        }

        public final SynchronousResult getSynchronousResult(Context arg1, String[] arg2) {
            Intrinsics.checkNotNullParameter(arg1, "context");
            Intrinsics.checkNotNullParameter(arg2, "input");
            return null;
        }

        public Object parseResult(int arg1, Intent arg2) {
            return this.parseResult(arg1, arg2);
        }

        public final List parseResult(int arg1, Intent arg2) {
            if(arg1 == -1) {
            }
            else {
                arg2 = null;
            }

            if(0 != 0) {
                List v0 = GetMultipleContents.Companion.getClipDataUris$activity(arg2);
                if(v0 == null) {
                }
                else {
                    return v0;
                }
            }

            return CollectionsKt.emptyList();
        }
    }

    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001A\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\b\u0010\n\u001A\u0004\u0018\u00010\u0002H\u0016J\u001C\u0010\u000B\u001A\u0004\u0018\u00010\u00032\u0006\u0010\f\u001A\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u0007H\u0016¨\u0006\u000F"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$PickContact;", "Landroidx/activity/result/contract/ActivityResultContract;", "Ljava/lang/Void;", "Landroid/net/Uri;", "<init>", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "parseResult", "resultCode", "", "intent", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public final class PickContact extends ActivityResultContract {
        public PickContact() {
            super();
        }

        public Intent createIntent(Context arg1, Object arg2) {
            return this.createIntent(arg1, ((Void)arg2));
        }

        public Intent createIntent(Context arg1, Void arg2) {
            Intrinsics.checkNotNullParameter(arg1, "context");
            Intent v0 = new Intent("android.intent.action.PICK").setType("vnd.android.cursor.dir/contact");
            Intrinsics.checkNotNullExpressionValue(v0, "setType(...)");
            return v0;
        }

        public Uri parseResult(int arg2, Intent arg3) {
            Uri v0 = null;
            if(arg2 == -1) {
            }
            else {
                arg3 = ((Intent)v0);
            }

            if(arg3 != null) {
                return arg3.getData();
            }

            return v0;
        }

        public Object parseResult(int arg1, Intent arg2) {
            return this.parseResult(arg1, arg2);
        }
    }

    @Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \u00142\u0019\u0012\u0004\u0012\u00020\u0002\u0012\u000F\u0012\r\u0012\t\u0012\u00070\u0004¢\u0006\u0002\b\u00050\u00030\u0001:\u0001\u0014B\u0011\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u0002H\u0017J)\u0010\u000F\u001A\u0015\u0012\u000F\u0012\r\u0012\t\u0012\u00070\u0004¢\u0006\u0002\b\u00050\u0003\u0018\u00010\u00102\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u0002J\u001E\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0012\u001A\u00020\u00072\b\u0010\u0013\u001A\u0004\u0018\u00010\u000BR\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$PickMultipleVisualMedia;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroidx/activity/result/PickVisualMediaRequest;", "", "Landroid/net/Uri;", "Lkotlin/jvm/JvmSuppressWildcards;", "maxItems", "", "<init>", "(I)V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "intent", "Companion", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public class PickMultipleVisualMedia extends ActivityResultContract {
        @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001A\u00020\u0005H\u0001¢\u0006\u0002\b\u0006¨\u0006\u0007"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$PickMultipleVisualMedia$Companion;", "", "<init>", "()V", "getMaxItems", "", "getMaxItems$activity", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public final class androidx.activity.result.contract.ActivityResultContracts$PickMultipleVisualMedia$Companion {
            public androidx.activity.result.contract.ActivityResultContracts$PickMultipleVisualMedia$Companion(DefaultConstructorMarker arg1) {
                this();
            }

            private androidx.activity.result.contract.ActivityResultContracts$PickMultipleVisualMedia$Companion() {
                super();
            }

            public final int getMaxItems$activity() {
                if(PickVisualMedia.Companion.isSystemPickerAvailable$activity()) {
                    return MediaStore.getPickImagesMaxLimit();
                }

                return 0x7FFFFFFF;
            }
        }

        public static final androidx.activity.result.contract.ActivityResultContracts$PickMultipleVisualMedia$Companion Companion;
        private final int maxItems;

        static {
            PickMultipleVisualMedia.Companion = new androidx.activity.result.contract.ActivityResultContracts$PickMultipleVisualMedia$Companion(null);
        }

        public PickMultipleVisualMedia() {
            this(0, 1, null);
        }

        public PickMultipleVisualMedia(int arg1, int arg2, DefaultConstructorMarker arg3) {
            if((arg2 & 1) != 0) {
                arg1 = PickMultipleVisualMedia.Companion.getMaxItems$activity();
            }

            this(arg1);
        }

        public PickMultipleVisualMedia(int arg1) {
            super();
            this.maxItems = arg1;
            if(arg1 > 1) {
                return;
            }

            throw new IllegalArgumentException("Max items must be higher than 1".toString());
        }

        public Intent createIntent(Context arg4, PickVisualMediaRequest arg5) {
            int v3;
            Intrinsics.checkNotNullParameter(arg4, "context");
            Intrinsics.checkNotNullParameter(arg5, "input");
            if(PickVisualMedia.Companion.isSystemPickerAvailable$activity()) {
                Intent v4 = new Intent("android.provider.action.PICK_IMAGES");
                v4.setType(PickVisualMedia.Companion.getVisualMimeType$activity(arg5.getMediaType()));
                v3 = Math.min(this.maxItems, arg5.getMaxItems());
                if(v3 > 1 && v3 <= MediaStore.getPickImagesMaxLimit()) {
                    v4.putExtra("android.provider.extra.PICK_IMAGES_MAX", v3);
                    v4.putExtra("android.provider.extra.PICK_IMAGES_LAUNCH_TAB", arg5.getDefaultTab().getValue());
                    v4.putExtra("android.provider.extra.PICK_IMAGES_IN_ORDER", arg5.isOrderedSelection());
                    if(arg5.isCustomAccentColorApplied()) {
                        v4.putExtra("android.provider.extra.PICK_IMAGES_ACCENT_COLOR", arg5.getAccentColor());
                    }

                    if(Build$VERSION.SDK_INT >= 33) {
                        MediaCapabilities v3_1 = arg5.getMediaCapabilitiesForTranscoding();
                        if(v3_1 != null) {
                            v4.putExtra("android.provider.extra.MEDIA_CAPABILITIES", v3_1.toApplicationMediaCapabilities$activity());
                        }
                    }

                    return v4;
                }

                throw new IllegalArgumentException("Max items must be greater than 1 and lesser than or equal to MediaStore.getPickImagesMaxLimit()".toString());
            }

            if(PickVisualMedia.Companion.isSystemFallbackPickerAvailable$activity(arg4)) {
                ResolveInfo v4_1 = PickVisualMedia.Companion.getSystemFallbackPicker$activity(arg4);
                if(v4_1 != null) {
                    ActivityInfo v4_2 = v4_1.activityInfo;
                    Intent v0 = new Intent("androidx.activity.result.contract.action.PICK_IMAGES");
                    v0.setClassName(v4_2.applicationInfo.packageName, v4_2.name);
                    v0.setType(PickVisualMedia.Companion.getVisualMimeType$activity(arg5.getMediaType()));
                    v3 = Math.min(this.maxItems, arg5.getMaxItems());
                    if(v3 > 1) {
                        v0.putExtra("androidx.activity.result.contract.extra.PICK_IMAGES_MAX", v3);
                        v0.putExtra("androidx.activity.result.contract.extra.PICK_IMAGES_LAUNCH_TAB", arg5.getDefaultTab().getValue());
                        v0.putExtra("androidx.activity.result.contract.extra.PICK_IMAGES_IN_ORDER", arg5.isOrderedSelection());
                        if(arg5.isCustomAccentColorApplied()) {
                            v0.putExtra("androidx.activity.result.contract.extra.PICK_IMAGES_ACCENT_COLOR", arg5.getAccentColor());
                        }

                        return v0;
                    }

                    throw new IllegalArgumentException("Max items must be greater than 1".toString());
                }

                throw new IllegalStateException("Required value was null.".toString());
            }

            Intent v3_2 = new Intent("android.intent.action.OPEN_DOCUMENT");
            v3_2.setType(PickVisualMedia.Companion.getVisualMimeType$activity(arg5.getMediaType()));
            v3_2.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
            if(v3_2.getType() == null) {
                v3_2.setType("*/*");
                v3_2.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
            }

            return v3_2;
        }

        public Intent createIntent(Context arg1, Object arg2) {
            return this.createIntent(arg1, ((PickVisualMediaRequest)arg2));
        }

        public final SynchronousResult getSynchronousResult(Context arg1, PickVisualMediaRequest arg2) {
            Intrinsics.checkNotNullParameter(arg1, "context");
            Intrinsics.checkNotNullParameter(arg2, "input");
            return null;
        }

        public SynchronousResult getSynchronousResult(Context arg1, Object arg2) {
            return this.getSynchronousResult(arg1, ((PickVisualMediaRequest)arg2));
        }

        public Object parseResult(int arg1, Intent arg2) {
            return this.parseResult(arg1, arg2);
        }

        public final List parseResult(int arg1, Intent arg2) {
            if(arg1 == -1) {
            }
            else {
                arg2 = null;
            }

            if(0 != 0) {
                List v0 = GetMultipleContents.Companion.getClipDataUris$activity(arg2);
                if(v0 == null) {
                }
                else {
                    return v0;
                }
            }

            return CollectionsKt.emptyList();
        }
    }

    @Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0016\u0018\u0000 \u00112\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001:\b\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0002H\u0017J \u0010\u000B\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\f2\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0002J\u001A\u0010\r\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u000E\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0007¨\u0006\u0019"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroidx/activity/result/PickVisualMediaRequest;", "Landroid/net/Uri;", "<init>", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "Companion", "VisualMediaType", "ImageOnly", "VideoOnly", "ImageAndVideo", "SingleMimeType", "MediaCapabilities", "DefaultTab", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public class PickVisualMedia extends ActivityResultContract {
        @Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001A\u00020\u0005H\u0007J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u000E\u001A\u00020\u000FH\u0007J\r\u0010\u0010\u001A\u00020\u0005H\u0001¢\u0006\u0002\b\u0011J\u0015\u0010\u0012\u001A\u00020\u00052\u0006\u0010\u000E\u001A\u00020\u000FH\u0001¢\u0006\u0002\b\u0013J\u0017\u0010\u0014\u001A\u0004\u0018\u00010\u00152\u0006\u0010\u000E\u001A\u00020\u000FH\u0001¢\u0006\u0002\b\u0016J\u0017\u0010\u0017\u001A\u0004\u0018\u00010\u00072\u0006\u0010\u0018\u001A\u00020\u0019H\u0000¢\u0006\u0002\b\u001AR\u000E\u0010\u0006\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0080T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0007X\u0080T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001B"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$Companion;", "", "<init>", "()V", "isPhotoPickerAvailable", "", "ACTION_SYSTEM_FALLBACK_PICK_IMAGES", "", "GMS_ACTION_PICK_IMAGES", "GMS_EXTRA_PICK_IMAGES_MAX", "EXTRA_SYSTEM_FALLBACK_PICK_IMAGES_MAX", "EXTRA_SYSTEM_FALLBACK_PICK_IMAGES_LAUNCH_TAB", "EXTRA_SYSTEM_FALLBACK_PICK_IMAGES_IN_ORDER", "EXTRA_SYSTEM_FALLBACK_PICK_IMAGES_ACCENT_COLOR", "context", "Landroid/content/Context;", "isSystemPickerAvailable", "isSystemPickerAvailable$activity", "isSystemFallbackPickerAvailable", "isSystemFallbackPickerAvailable$activity", "getSystemFallbackPicker", "Landroid/content/pm/ResolveInfo;", "getSystemFallbackPicker$activity", "getVisualMimeType", "input", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VisualMediaType;", "getVisualMimeType$activity", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public final class androidx.activity.result.contract.ActivityResultContracts$PickVisualMedia$Companion {
            public androidx.activity.result.contract.ActivityResultContracts$PickVisualMedia$Companion(DefaultConstructorMarker arg1) {
                this();
            }

            private androidx.activity.result.contract.ActivityResultContracts$PickVisualMedia$Companion() {
                super();
            }

            @JvmStatic public final ResolveInfo getSystemFallbackPicker$activity(Context arg2) {
                Intrinsics.checkNotNullParameter(arg2, "context");
                return arg2.getPackageManager().resolveActivity(new Intent("androidx.activity.result.contract.action.PICK_IMAGES"), 0x110000);
            }

            public final String getVisualMimeType$activity(VisualMediaType arg1) {
                Intrinsics.checkNotNullParameter(arg1, "input");
                if((arg1 instanceof ImageOnly)) {
                    return "image/*";
                }

                if((arg1 instanceof VideoOnly)) {
                    return "video/*";
                }

                if((arg1 instanceof SingleMimeType)) {
                    return ((SingleMimeType)arg1).getMimeType();
                }

                if((arg1 instanceof ImageAndVideo)) {
                    return null;
                }

                throw new NoWhenBranchMatchedException();
            }

            @Deprecated(message="This method is deprecated in favor of isPhotoPickerAvailable(context) to support the picker provided by updatable system apps", replaceWith="<_subannotation>") @JvmStatic public final boolean isPhotoPickerAvailable() {
                return this.isSystemPickerAvailable$activity();
            }

            @JvmStatic public final boolean isPhotoPickerAvailable(Context arg2) {
                Intrinsics.checkNotNullParameter(arg2, "context");
                if(!this.isSystemPickerAvailable$activity()) {
                    if(this.isSystemFallbackPickerAvailable$activity(arg2)) {
                    }
                    else {
                        return 0;
                    }
                }

                return 1;
            }

            @JvmStatic public final boolean isSystemFallbackPickerAvailable$activity(Context arg2) {
                Intrinsics.checkNotNullParameter(arg2, "context");
                if(this.getSystemFallbackPicker$activity(arg2) != null) {
                    return 1;
                }

                return 0;
            }

            @JvmStatic public final boolean isSystemPickerAvailable$activity() {
                if(Build$VERSION.SDK_INT >= 33) {
                    return 1;
                }

                int v2 = 30;
                if(Build$VERSION.SDK_INT >= v2 && SdkExtensions.getExtensionVersion(v2) >= 2) {
                    return 1;
                }

                return 0;
            }
        }

        @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001:\u0002\b\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001A\u00020\u0005X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$DefaultTab;", "", "<init>", "()V", "value", "", "getValue", "()I", "PhotosTab", "AlbumsTab", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public abstract class DefaultTab {
            @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001A\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$DefaultTab$AlbumsTab;", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$DefaultTab;", "<init>", "()V", "value", "", "getValue", "()I", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public final class AlbumsTab extends DefaultTab {
                public static final AlbumsTab INSTANCE;
                private static final int value;

                static {
                    AlbumsTab.INSTANCE = new AlbumsTab();
                }

                private AlbumsTab() {
                    super(null);
                }

                public int getValue() {
                    return AlbumsTab.value;
                }
            }

            @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001A\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$DefaultTab$PhotosTab;", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$DefaultTab;", "<init>", "()V", "value", "", "getValue", "()I", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public final class PhotosTab extends DefaultTab {
                public static final PhotosTab INSTANCE;
                private static final int value;

                static {
                    PhotosTab.INSTANCE = new PhotosTab();
                    PhotosTab.value = 1;
                }

                private PhotosTab() {
                    super(null);
                }

                public int getValue() {
                    return PhotosTab.value;
                }
            }

            private DefaultTab() {
                super();
            }

            public DefaultTab(DefaultConstructorMarker arg1) {
                this();
            }

            public abstract int getValue();
        }

        @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$ImageAndVideo;", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VisualMediaType;", "<init>", "()V", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ImageAndVideo implements VisualMediaType {
            public static final ImageAndVideo INSTANCE;

            static {
                ImageAndVideo.INSTANCE = new ImageAndVideo();
            }

            private ImageAndVideo() {
                super();
            }
        }

        @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$ImageOnly;", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VisualMediaType;", "<init>", "()V", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ImageOnly implements VisualMediaType {
            public static final ImageOnly INSTANCE;

            static {
                ImageOnly.INSTANCE = new ImageOnly();
            }

            private ImageOnly() {
                super();
            }
        }

        @Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000F2\u00020\u0001:\u0002\u000F\u0010B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\f\u001A\u00020\rH\u0001¢\u0006\u0002\b\u000ER0\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005@@X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000B¨\u0006\u0011"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$MediaCapabilities;", "", "<init>", "()V", "value", "", "", "supportedHdrTypes", "getSupportedHdrTypes", "()Ljava/util/Set;", "setSupportedHdrTypes$activity", "(Ljava/util/Set;)V", "toApplicationMediaCapabilities", "Landroid/media/ApplicationMediaCapabilities;", "toApplicationMediaCapabilities$activity", "Companion", "Builder", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public final class MediaCapabilities {
            @Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0007\u001A\u00020\u00002\u0006\u0010\b\u001A\u00020\u0006J\u0006\u0010\t\u001A\u00020\nR\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$MediaCapabilities$Builder;", "", "<init>", "()V", "supportedHdrTypes", "", "", "addSupportedHdrType", "hdrType", "build", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$MediaCapabilities;", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Builder {
                private Set supportedHdrTypes;

                public Builder() {
                    super();
                    this.supportedHdrTypes = new LinkedHashSet();
                }

                public final Builder addSupportedHdrType(int arg2) {
                    this.supportedHdrTypes.add(Integer.valueOf(arg2));
                    return this;
                }

                public final MediaCapabilities build() {
                    MediaCapabilities v0 = new MediaCapabilities();
                    v0.setSupportedHdrTypes$activity(this.supportedHdrTypes);
                    return v0;
                }
            }

            @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$MediaCapabilities$Companion;", "", "<init>", "()V", "TYPE_HLG10", "", "TYPE_HDR10", "TYPE_HDR10_PLUS", "TYPE_DOLBY_VISION", "HdrType", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public final class androidx.activity.result.contract.ActivityResultContracts$PickVisualMedia$MediaCapabilities$Companion {
                @Retention(value=RetentionPolicy.SOURCE) @Target(value={ElementType.PARAMETER, ElementType.TYPE_USE}) @Metadata(d1={"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001B\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$MediaCapabilities$Companion$HdrType;", "", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) @kotlin.annotation.Retention(value=AnnotationRetention.SOURCE) @kotlin.annotation.Target(allowedTargets={AnnotationTarget.TYPE, AnnotationTarget.PROPERTY, AnnotationTarget.VALUE_PARAMETER}) @public interface HdrType {
                }

                public androidx.activity.result.contract.ActivityResultContracts$PickVisualMedia$MediaCapabilities$Companion(DefaultConstructorMarker arg1) {
                    this();
                }

                private androidx.activity.result.contract.ActivityResultContracts$PickVisualMedia$MediaCapabilities$Companion() {
                    super();
                }
            }

            public static final androidx.activity.result.contract.ActivityResultContracts$PickVisualMedia$MediaCapabilities$Companion Companion = null;
            public static final int TYPE_DOLBY_VISION = 3;
            public static final int TYPE_HDR10 = 1;
            public static final int TYPE_HDR10_PLUS = 2;
            public static final int TYPE_HLG10;
            private Set supportedHdrTypes;

            static {
                MediaCapabilities.Companion = new androidx.activity.result.contract.ActivityResultContracts$PickVisualMedia$MediaCapabilities$Companion(null);
            }

            public MediaCapabilities() {
                super();
                this.supportedHdrTypes = SetsKt.emptySet();
            }

            public final Set getSupportedHdrTypes() {
                return this.supportedHdrTypes;
            }

            public final void setSupportedHdrTypes$activity(Set arg2) {
                Intrinsics.checkNotNullParameter(arg2, "<set-?>");
                this.supportedHdrTypes = arg2;
            }

            public final ApplicationMediaCapabilities toApplicationMediaCapabilities$activity() {
                ApplicationMediaCapabilities$Builder v0 = new ApplicationMediaCapabilities$Builder();
                v0.addSupportedVideoMimeType("video/hevc");
                Iterator v3 = this.supportedHdrTypes.iterator();
                while(v3.hasNext()) {
                    int v1 = v3.next().intValue();
                    if(v1 != 0) {
                        if(v1 != 1) {
                            if(v1 != 2) {
                                if(v1 != 3) {
                                    continue;
                                }

                                v0.addSupportedHdrType("android.media.feature.hdr.dolby_vision");
                                continue;
                            }

                            v0.addSupportedHdrType("android.media.feature.hdr.hdr10_plus");
                            continue;
                        }

                        v0.addSupportedHdrType("android.media.feature.hdr.hdr10");
                        continue;
                    }

                    v0.addSupportedHdrType("android.media.feature.hdr.hlg");
                }

                ApplicationMediaCapabilities v3_1 = v0.build();
                Intrinsics.checkNotNullExpressionValue(v3_1, "build(...)");
                return v3_1;
            }
        }

        @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$SingleMimeType;", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VisualMediaType;", "mimeType", "", "<init>", "(Ljava/lang/String;)V", "getMimeType", "()Ljava/lang/String;", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public final class SingleMimeType implements VisualMediaType {
            private final String mimeType;

            public SingleMimeType(String arg2) {
                Intrinsics.checkNotNullParameter(arg2, "mimeType");
                super();
                this.mimeType = arg2;
            }

            public final String getMimeType() {
                return this.mimeType;
            }
        }

        @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VideoOnly;", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VisualMediaType;", "<init>", "()V", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public final class VideoOnly implements VisualMediaType {
            public static final VideoOnly INSTANCE;

            static {
                VideoOnly.INSTANCE = new VideoOnly();
            }

            private VideoOnly() {
                super();
            }
        }

        @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001\u0082\u0001\u0004\u0002\u0003\u0004\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VisualMediaType;", "", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$ImageAndVideo;", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$ImageOnly;", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$SingleMimeType;", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VideoOnly;", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public interface VisualMediaType {
        }

        public static final String ACTION_SYSTEM_FALLBACK_PICK_IMAGES = "androidx.activity.result.contract.action.PICK_IMAGES";
        public static final androidx.activity.result.contract.ActivityResultContracts$PickVisualMedia$Companion Companion = null;
        public static final String EXTRA_SYSTEM_FALLBACK_PICK_IMAGES_ACCENT_COLOR = "androidx.activity.result.contract.extra.PICK_IMAGES_ACCENT_COLOR";
        public static final String EXTRA_SYSTEM_FALLBACK_PICK_IMAGES_IN_ORDER = "androidx.activity.result.contract.extra.PICK_IMAGES_IN_ORDER";
        public static final String EXTRA_SYSTEM_FALLBACK_PICK_IMAGES_LAUNCH_TAB = "androidx.activity.result.contract.extra.PICK_IMAGES_LAUNCH_TAB";
        public static final String EXTRA_SYSTEM_FALLBACK_PICK_IMAGES_MAX = "androidx.activity.result.contract.extra.PICK_IMAGES_MAX";
        public static final String GMS_ACTION_PICK_IMAGES = "com.google.android.gms.provider.action.PICK_IMAGES";
        public static final String GMS_EXTRA_PICK_IMAGES_MAX = "com.google.android.gms.provider.extra.PICK_IMAGES_MAX";

        static {
            PickVisualMedia.Companion = new androidx.activity.result.contract.ActivityResultContracts$PickVisualMedia$Companion(null);
        }

        public PickVisualMedia() {
            super();
        }

        public Intent createIntent(Context arg3, PickVisualMediaRequest arg4) {
            Intent v3;
            Intrinsics.checkNotNullParameter(arg3, "context");
            Intrinsics.checkNotNullParameter(arg4, "input");
            androidx.activity.result.contract.ActivityResultContracts$PickVisualMedia$Companion v2 = PickVisualMedia.Companion;
            if(v2.isSystemPickerAvailable$activity()) {
                v3 = new Intent("android.provider.action.PICK_IMAGES");
                v3.setType(v2.getVisualMimeType$activity(arg4.getMediaType()));
                v3.putExtra("android.provider.extra.PICK_IMAGES_LAUNCH_TAB", arg4.getDefaultTab().getValue());
                if(arg4.isCustomAccentColorApplied()) {
                    v3.putExtra("android.provider.extra.PICK_IMAGES_ACCENT_COLOR", arg4.getAccentColor());
                }

                if(Build$VERSION.SDK_INT >= 33) {
                    MediaCapabilities v2_1 = arg4.getMediaCapabilitiesForTranscoding();
                    if(v2_1 != null) {
                        v3.putExtra("android.provider.extra.MEDIA_CAPABILITIES", v2_1.toApplicationMediaCapabilities$activity());
                    }
                }

                return v3;
            }

            if(v2.isSystemFallbackPickerAvailable$activity(arg3)) {
                ResolveInfo v3_1 = v2.getSystemFallbackPicker$activity(arg3);
                if(v3_1 != null) {
                    ActivityInfo v3_2 = v3_1.activityInfo;
                    Intent v0 = new Intent("androidx.activity.result.contract.action.PICK_IMAGES");
                    v0.setClassName(v3_2.applicationInfo.packageName, v3_2.name);
                    v0.setType(v2.getVisualMimeType$activity(arg4.getMediaType()));
                    v0.putExtra("androidx.activity.result.contract.extra.PICK_IMAGES_LAUNCH_TAB", arg4.getDefaultTab().getValue());
                    if(arg4.isCustomAccentColorApplied()) {
                        v0.putExtra("androidx.activity.result.contract.extra.PICK_IMAGES_ACCENT_COLOR", arg4.getAccentColor());
                    }

                    return v0;
                }

                throw new IllegalStateException("Required value was null.".toString());
            }

            v3 = new Intent("android.intent.action.OPEN_DOCUMENT");
            v3.setType(v2.getVisualMimeType$activity(arg4.getMediaType()));
            if(v3.getType() == null) {
                v3.setType("*/*");
                v3.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
            }

            return v3;
        }

        public Intent createIntent(Context arg1, Object arg2) {
            return this.createIntent(arg1, ((PickVisualMediaRequest)arg2));
        }

        public final SynchronousResult getSynchronousResult(Context arg1, PickVisualMediaRequest arg2) {
            Intrinsics.checkNotNullParameter(arg1, "context");
            Intrinsics.checkNotNullParameter(arg2, "input");
            return null;
        }

        public SynchronousResult getSynchronousResult(Context arg1, Object arg2) {
            return this.getSynchronousResult(arg1, ((PickVisualMediaRequest)arg2));
        }

        @JvmStatic public static final ResolveInfo getSystemFallbackPicker$activity(Context arg1) {
            return PickVisualMedia.Companion.getSystemFallbackPicker$activity(arg1);
        }

        @Deprecated(message="This method is deprecated in favor of isPhotoPickerAvailable(context) to support the picker provided by updatable system apps", replaceWith="<_subannotation>") @JvmStatic public static final boolean isPhotoPickerAvailable() {
            return PickVisualMedia.Companion.isPhotoPickerAvailable();
        }

        @JvmStatic public static final boolean isPhotoPickerAvailable(Context arg1) {
            return PickVisualMedia.Companion.isPhotoPickerAvailable(arg1);
        }

        @JvmStatic public static final boolean isSystemFallbackPickerAvailable$activity(Context arg1) {
            return PickVisualMedia.Companion.isSystemFallbackPickerAvailable$activity(arg1);
        }

        @JvmStatic public static final boolean isSystemPickerAvailable$activity() {
            return PickVisualMedia.Companion.isSystemPickerAvailable$activity();
        }

        public final Uri parseResult(int arg2, Intent arg3) {
            Uri v0 = null;
            if(arg2 == -1) {
            }
            else {
                arg3 = ((Intent)v0);
            }

            if(arg3 != null) {
                Uri v1 = arg3.getData();
                if(v1 == null) {
                    Object v1_1 = CollectionsKt.firstOrNull(GetMultipleContents.Companion.getClipDataUris$activity(arg3));
                }

                return v1;
            }

            return v0;
        }

        public Object parseResult(int arg1, Intent arg2) {
            return this.parseResult(arg1, arg2);
        }
    }

    @Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000E\n\u0002\u0010$\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00162%\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0003\u0012\t\u0012\u00070\u0005¢\u0006\u0002\b\u00060\u00040\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\f\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0002\u0010\u000EJ7\u0010\u000F\u001A\u0016\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u00102\u0006\u0010\u000B\u001A\u00020\f2\f\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0002\u0010\u0011J&\u0010\u0012\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0013\u001A\u00020\u00142\b\u0010\u0015\u001A\u0004\u0018\u00010\nH\u0016¨\u0006\u0017"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$RequestMultiplePermissions;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "", "", "", "Lkotlin/jvm/JvmSuppressWildcards;", "<init>", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "(Landroid/content/Context;[Ljava/lang/String;)Landroid/content/Intent;", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "(Landroid/content/Context;[Ljava/lang/String;)Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "Companion", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public final class RequestMultiplePermissions extends ActivityResultContract {
        @Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001D\u0010\b\u001A\u00020\t2\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00050\u000BH\u0000¢\u0006\u0004\b\f\u0010\rR\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$RequestMultiplePermissions$Companion;", "", "<init>", "()V", "ACTION_REQUEST_PERMISSIONS", "", "EXTRA_PERMISSIONS", "EXTRA_PERMISSION_GRANT_RESULTS", "createIntent", "Landroid/content/Intent;", "input", "", "createIntent$activity", "([Ljava/lang/String;)Landroid/content/Intent;", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public final class androidx.activity.result.contract.ActivityResultContracts$RequestMultiplePermissions$Companion {
            public androidx.activity.result.contract.ActivityResultContracts$RequestMultiplePermissions$Companion(DefaultConstructorMarker arg1) {
                this();
            }

            private androidx.activity.result.contract.ActivityResultContracts$RequestMultiplePermissions$Companion() {
                super();
            }

            public final Intent createIntent$activity(String[] arg2) {
                Intrinsics.checkNotNullParameter(arg2, "input");
                Intent v1 = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", arg2);
                Intrinsics.checkNotNullExpressionValue(v1, "putExtra(...)");
                return v1;
            }
        }

        public static final String ACTION_REQUEST_PERMISSIONS = "androidx.activity.result.contract.action.REQUEST_PERMISSIONS";
        public static final androidx.activity.result.contract.ActivityResultContracts$RequestMultiplePermissions$Companion Companion = null;
        public static final String EXTRA_PERMISSIONS = "androidx.activity.result.contract.extra.PERMISSIONS";
        public static final String EXTRA_PERMISSION_GRANT_RESULTS = "androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS";

        static {
            RequestMultiplePermissions.Companion = new androidx.activity.result.contract.ActivityResultContracts$RequestMultiplePermissions$Companion(null);
        }

        public RequestMultiplePermissions() {
            super();
        }

        public Intent createIntent(Context arg1, Object arg2) {
            return this.createIntent(arg1, ((String[])arg2));
        }

        public Intent createIntent(Context arg1, String[] arg2) {
            Intrinsics.checkNotNullParameter(arg1, "context");
            Intrinsics.checkNotNullParameter(arg2, "input");
            return RequestMultiplePermissions.Companion.createIntent$activity(arg2);
        }

        public SynchronousResult getSynchronousResult(Context arg1, Object arg2) {
            return this.getSynchronousResult(arg1, ((String[])arg2));
        }

        public SynchronousResult getSynchronousResult(Context arg4, String[] arg5) {
            Intrinsics.checkNotNullParameter(arg4, "context");
            Intrinsics.checkNotNullParameter(arg5, "input");
            if(arg5.length == 0) {
                return new SynchronousResult(MapsKt.emptyMap());
            }

            int v3 = arg5.length;
            int v0 = 0;
            int v1;
            for(v1 = 0; true; ++v1) {
                if(v1 >= v3) {
                    goto label_21;
                }

                if(ContextCompat.checkSelfPermission(arg4, arg5[v1]) != 0) {
                    return null;
                }
            }

            return null;
        label_21:
            LinkedHashMap v4 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(arg5.length), 16));
            v3 = arg5.length;
            while(v0 < v3) {
                Pair v1_1 = TuplesKt.to(arg5[v0], Boolean.valueOf(true));
                ((Map)v4).put(v1_1.getFirst(), v1_1.getSecond());
                ++v0;
            }

            return new SynchronousResult(v4);
        }

        public Object parseResult(int arg1, Intent arg2) {
            return this.parseResult(arg1, arg2);
        }

        public Map parseResult(int arg5, Intent arg6) {
            if(arg5 != -1) {
                return MapsKt.emptyMap();
            }

            if(arg6 == null) {
                return MapsKt.emptyMap();
            }

            String[] v4 = arg6.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            int[] v5 = arg6.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
            if(v5 != null) {
                if(v4 == null) {
                }
                else {
                    ArrayList v6 = new ArrayList(v5.length);
                    int v0 = v5.length;
                    int v2;
                    for(v2 = 0; v2 < v0; ++v2) {
                        boolean v3 = v5[v2] == 0 ? true : false;
                        ((Collection)v6).add(Boolean.valueOf(v3));
                    }

                    return MapsKt.toMap(CollectionsKt.zip(ArraysKt.filterNotNull(((Object[])v4)), ((Iterable)v6)));
                }
            }

            return MapsKt.emptyMap();
        }
    }

    @Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0002H\u0016J\u001F\u0010\u000B\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010\u000FJ \u0010\u0010\u001A\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00112\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0002H\u0016¨\u0006\u0012"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$RequestPermission;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "", "<init>", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "parseResult", "resultCode", "", "intent", "(ILandroid/content/Intent;)Ljava/lang/Boolean;", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public final class RequestPermission extends ActivityResultContract {
        public RequestPermission() {
            super();
        }

        public Intent createIntent(Context arg1, Object arg2) {
            return this.createIntent(arg1, ((String)arg2));
        }

        public Intent createIntent(Context arg2, String arg3) {
            Intrinsics.checkNotNullParameter(arg2, "context");
            Intrinsics.checkNotNullParameter(arg3, "input");
            return RequestMultiplePermissions.Companion.createIntent$activity(new String[]{arg3});
        }

        public SynchronousResult getSynchronousResult(Context arg1, Object arg2) {
            return this.getSynchronousResult(arg1, ((String)arg2));
        }

        public SynchronousResult getSynchronousResult(Context arg1, String arg2) {
            Intrinsics.checkNotNullParameter(arg1, "context");
            Intrinsics.checkNotNullParameter(arg2, "input");
            if(ContextCompat.checkSelfPermission(arg1, arg2) == 0) {
                return new SynchronousResult(Boolean.valueOf(true));
            }

            return null;
        }

        public Boolean parseResult(int arg3, Intent arg4) {
            boolean v2 = false;
            if(arg4 != null) {
                if(arg3 != -1) {
                }
                else {
                    int[] v3 = arg4.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
                    if(v3 != null) {
                        int v4 = v3.length;
                        int v0 = 0;
                        while(v0 < v4) {
                            if(v3[v0] == 0) {
                                v2 = true;
                            }
                            else {
                                ++v0;
                                continue;
                            }

                            break;
                        }
                    }

                    return Boolean.valueOf(v2);
                }
            }

            return Boolean.valueOf(false);
        }

        public Object parseResult(int arg1, Intent arg2) {
            return this.parseResult(arg1, arg2);
        }
    }

    @Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u000E2\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000EB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001A\u00020\u00022\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\u0002H\u0016J\u001A\u0010\n\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00020\f2\b\u0010\r\u001A\u0004\u0018\u00010\u0002H\u0016¨\u0006\u000F"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$StartActivityForResult;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroid/content/Intent;", "Landroidx/activity/result/ActivityResult;", "<init>", "()V", "createIntent", "context", "Landroid/content/Context;", "input", "parseResult", "resultCode", "", "intent", "Companion", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public final class StartActivityForResult extends ActivityResultContract {
        @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$StartActivityForResult$Companion;", "", "<init>", "()V", "EXTRA_ACTIVITY_OPTIONS_BUNDLE", "", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public final class androidx.activity.result.contract.ActivityResultContracts$StartActivityForResult$Companion {
            public androidx.activity.result.contract.ActivityResultContracts$StartActivityForResult$Companion(DefaultConstructorMarker arg1) {
                this();
            }

            private androidx.activity.result.contract.ActivityResultContracts$StartActivityForResult$Companion() {
                super();
            }
        }

        public static final androidx.activity.result.contract.ActivityResultContracts$StartActivityForResult$Companion Companion = null;
        public static final String EXTRA_ACTIVITY_OPTIONS_BUNDLE = "androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE";

        static {
            StartActivityForResult.Companion = new androidx.activity.result.contract.ActivityResultContracts$StartActivityForResult$Companion(null);
        }

        public StartActivityForResult() {
            super();
        }

        public Intent createIntent(Context arg1, Intent arg2) {
            Intrinsics.checkNotNullParameter(arg1, "context");
            Intrinsics.checkNotNullParameter(arg2, "input");
            return arg2;
        }

        public Intent createIntent(Context arg1, Object arg2) {
            return this.createIntent(arg1, ((Intent)arg2));
        }

        public ActivityResult parseResult(int arg1, Intent arg2) {
            return new ActivityResult(arg1, arg2);
        }

        public Object parseResult(int arg1, Intent arg2) {
            return this.parseResult(arg1, arg2);
        }
    }

    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u000F2\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000FB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0002H\u0016J\u001A\u0010\u000B\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u0007H\u0016¨\u0006\u0010"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$StartIntentSenderForResult;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroidx/activity/result/IntentSenderRequest;", "Landroidx/activity/result/ActivityResult;", "<init>", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "parseResult", "resultCode", "", "intent", "Companion", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public final class StartIntentSenderForResult extends ActivityResultContract {
        @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$StartIntentSenderForResult$Companion;", "", "<init>", "()V", "ACTION_INTENT_SENDER_REQUEST", "", "EXTRA_INTENT_SENDER_REQUEST", "EXTRA_SEND_INTENT_EXCEPTION", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public final class androidx.activity.result.contract.ActivityResultContracts$StartIntentSenderForResult$Companion {
            public androidx.activity.result.contract.ActivityResultContracts$StartIntentSenderForResult$Companion(DefaultConstructorMarker arg1) {
                this();
            }

            private androidx.activity.result.contract.ActivityResultContracts$StartIntentSenderForResult$Companion() {
                super();
            }
        }

        public static final String ACTION_INTENT_SENDER_REQUEST = "androidx.activity.result.contract.action.INTENT_SENDER_REQUEST";
        public static final androidx.activity.result.contract.ActivityResultContracts$StartIntentSenderForResult$Companion Companion = null;
        public static final String EXTRA_INTENT_SENDER_REQUEST = "androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST";
        public static final String EXTRA_SEND_INTENT_EXCEPTION = "androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION";

        static {
            StartIntentSenderForResult.Companion = new androidx.activity.result.contract.ActivityResultContracts$StartIntentSenderForResult$Companion(null);
        }

        public StartIntentSenderForResult() {
            super();
        }

        public Intent createIntent(Context arg1, IntentSenderRequest arg2) {
            Intrinsics.checkNotNullParameter(arg1, "context");
            Intrinsics.checkNotNullParameter(arg2, "input");
            Intent v0 = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", ((Parcelable)arg2));
            Intrinsics.checkNotNullExpressionValue(v0, "putExtra(...)");
            return v0;
        }

        public Intent createIntent(Context arg1, Object arg2) {
            return this.createIntent(arg1, ((IntentSenderRequest)arg2));
        }

        public ActivityResult parseResult(int arg1, Intent arg2) {
            return new ActivityResult(arg1, arg2);
        }

        public Object parseResult(int arg1, Intent arg2) {
            return this.parseResult(arg1, arg2);
        }
    }

    @Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0002H\u0017J\u001E\u0010\u000B\u001A\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f2\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0002J\u001D\u0010\r\u001A\u00020\u00032\u0006\u0010\u000E\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$TakePicture;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroid/net/Uri;", "", "<init>", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "(ILandroid/content/Intent;)Ljava/lang/Boolean;", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public class TakePicture extends ActivityResultContract {
        public TakePicture() {
            super();
        }

        public Intent createIntent(Context arg1, Uri arg2) {
            Intrinsics.checkNotNullParameter(arg1, "context");
            Intrinsics.checkNotNullParameter(arg2, "input");
            Intent v0 = new Intent("android.media.action.IMAGE_CAPTURE").putExtra("output", ((Parcelable)arg2)).addFlags(1).addFlags(2);
            Intrinsics.checkNotNullExpressionValue(v0, "addFlags(...)");
            return v0;
        }

        public Intent createIntent(Context arg1, Object arg2) {
            return this.createIntent(arg1, ((Uri)arg2));
        }

        public final SynchronousResult getSynchronousResult(Context arg1, Uri arg2) {
            Intrinsics.checkNotNullParameter(arg1, "context");
            Intrinsics.checkNotNullParameter(arg2, "input");
            return null;
        }

        public SynchronousResult getSynchronousResult(Context arg1, Object arg2) {
            return this.getSynchronousResult(arg1, ((Uri)arg2));
        }

        public final Boolean parseResult(int arg1, Intent arg2) {
            boolean v0 = arg1 == -1 ? true : false;
            return Boolean.valueOf(v0);
        }

        public Object parseResult(int arg1, Intent arg2) {
            return this.parseResult(arg1, arg2);
        }
    }

    @Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0016\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001A\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\b\u0010\n\u001A\u0004\u0018\u00010\u0002H\u0017J\"\u0010\u000B\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\f2\u0006\u0010\b\u001A\u00020\t2\b\u0010\n\u001A\u0004\u0018\u00010\u0002J\u001A\u0010\r\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u000E\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0007¨\u0006\u0011"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$TakePicturePreview;", "Landroidx/activity/result/contract/ActivityResultContract;", "Ljava/lang/Void;", "Landroid/graphics/Bitmap;", "<init>", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public class TakePicturePreview extends ActivityResultContract {
        public TakePicturePreview() {
            super();
        }

        public Intent createIntent(Context arg1, Object arg2) {
            return this.createIntent(arg1, ((Void)arg2));
        }

        public Intent createIntent(Context arg1, Void arg2) {
            Intrinsics.checkNotNullParameter(arg1, "context");
            Intent v0 = new Intent("android.media.action.IMAGE_CAPTURE").addFlags(1).addFlags(2);
            Intrinsics.checkNotNullExpressionValue(v0, "addFlags(...)");
            return v0;
        }

        public SynchronousResult getSynchronousResult(Context arg1, Object arg2) {
            return this.getSynchronousResult(arg1, ((Void)arg2));
        }

        public final SynchronousResult getSynchronousResult(Context arg1, Void arg2) {
            Intrinsics.checkNotNullParameter(arg1, "context");
            return null;
        }

        public final Bitmap parseResult(int arg2, Intent arg3) {
            Bitmap v0 = null;
            if(arg2 == -1) {
            }
            else {
                arg3 = ((Intent)v0);
            }

            if(arg3 != null) {
                return arg3.getParcelableExtra("data");
            }

            return v0;
        }

        public Object parseResult(int arg1, Intent arg2) {
            return this.parseResult(arg1, arg2);
        }
    }

    @Deprecated(message="The thumbnail bitmap is rarely returned and is not a good signal to determine\n      whether the video was actually successfully captured. Use {@link CaptureVideo} instead.") @Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0017\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0002H\u0017J \u0010\u000B\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\f2\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0002J\u001A\u0010\r\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u000E\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0007¨\u0006\u0011"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$TakeVideo;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroid/net/Uri;", "Landroid/graphics/Bitmap;", "<init>", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public class TakeVideo extends ActivityResultContract {
        public TakeVideo() {
            super();
        }

        public Intent createIntent(Context arg1, Uri arg2) {
            Intrinsics.checkNotNullParameter(arg1, "context");
            Intrinsics.checkNotNullParameter(arg2, "input");
            Intent v0 = new Intent("android.media.action.VIDEO_CAPTURE").putExtra("output", ((Parcelable)arg2)).addFlags(1).addFlags(2);
            Intrinsics.checkNotNullExpressionValue(v0, "addFlags(...)");
            return v0;
        }

        public Intent createIntent(Context arg1, Object arg2) {
            return this.createIntent(arg1, ((Uri)arg2));
        }

        public final SynchronousResult getSynchronousResult(Context arg1, Uri arg2) {
            Intrinsics.checkNotNullParameter(arg1, "context");
            Intrinsics.checkNotNullParameter(arg2, "input");
            return null;
        }

        public SynchronousResult getSynchronousResult(Context arg1, Object arg2) {
            return this.getSynchronousResult(arg1, ((Uri)arg2));
        }

        public final Bitmap parseResult(int arg2, Intent arg3) {
            Bitmap v0 = null;
            if(arg2 == -1) {
            }
            else {
                arg3 = ((Intent)v0);
            }

            if(arg3 != null) {
                return arg3.getParcelableExtra("data");
            }

            return v0;
        }

        public Object parseResult(int arg1, Intent arg2) {
            return this.parseResult(arg1, arg2);
        }
    }

    private ActivityResultContracts() {
        super();
    }
}

