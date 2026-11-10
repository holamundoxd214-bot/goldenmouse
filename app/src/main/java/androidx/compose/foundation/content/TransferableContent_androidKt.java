package androidx.compose.foundation.content;

import android.content.ClipData$Item;
import android.content.ClipData;
import android.content.ClipDescription;
import androidx.compose.ui.platform.AndroidClipboardManager_androidKt;
import androidx.compose.ui.platform.ClipEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0000\u001A\"\u0010\u0000\u001A\u0004\u0018\u00010\u0001*\u00020\u00012\u0012\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0007\u001A\u0014\u0010\u0006\u001A\u00020\u0005*\u00020\u00012\u0006\u0010\u0007\u001A\u00020\bH\u0007\u001A\u000E\u0010\t\u001A\u0004\u0018\u00010\n*\u00020\u000BH\u0000¨\u0006\f"}, d2={"consume", "Landroidx/compose/foundation/content/TransferableContent;", "predicate", "Lkotlin/Function1;", "Landroid/content/ClipData$Item;", "", "hasMediaType", "mediaType", "Landroidx/compose/foundation/content/MediaType;", "readPlainText", "", "Landroidx/compose/ui/platform/ClipEntry;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TransferableContent_androidKt {
    public static final TransferableContent consume(TransferableContent arg12, Function1 arg13) {
        ClipDescription v13_1;
        ClipData v0 = arg12.getClipEntry().getClipData();
        int v2 = 0;
        TransferableContent v3 = null;
        int v4 = 1;
        if(v0.getItemCount() != 1) {
            int v1 = v0.getItemCount();
            ArrayList v5 = ((ArrayList)v3);
            while(v2 < v1) {
                ClipData$Item v6 = v0.getItemAt(v2);
                if(!arg13.invoke(v6).booleanValue()) {
                    if(v5 == null) {
                        v5 = new ArrayList();
                    }

                    ((List)v5).add(v6);
                }

                ++v2;
            }

            ArrayList v13 = v5;
            if(v13 != null) {
                if(((Collection)v13).isEmpty()) {
                }
                else if(((List)v5).size() != v0.getItemCount()) {
                    v13_1 = new ClipDescription(arg12.getClipMetadata().getClipDescription());
                    v0 = new ClipData(v13_1, CollectionsKt.first(((List)v5)));
                    v1 = ((List)v5).size();
                    goto label_43;
                }
                else {
                    return arg12;
                }
            }

            return v3;
        label_43:
            while(v4 < v1) {
                v0.addItem(((List)v5).get(v4));
                ++v4;
            }

            return new TransferableContent(AndroidClipboardManager_androidKt.toClipEntry(v0), AndroidClipboardManager_androidKt.toClipMetadata(v13_1), arg12.getSource-kB6V9T0(), arg12.getPlatformTransferableContent(), null);
        }
        else if(!arg13.invoke(v0.getItemAt(0)).booleanValue()) {
        }
        else {
            return v3;
        }

        return arg12;
    }

    public static final boolean hasMediaType(TransferableContent arg0, MediaType arg1) {
        return arg0.getClipMetadata().getClipDescription().hasMimeType(arg1.getRepresentation());
    }

    public static final String readPlainText(ClipEntry arg6) {
        StringBuilder v0_1;
        int v0 = arg6.getClipData().getItemCount();
        int v1 = 0;
        int v2 = 0;
        int v3 = 0;
        while(v2 < v0) {
            v3 = v3 != 0 || arg6.getClipData().getItemAt(v2).getText() != null ? 1 : 0;
            ++v2;
        }

        if(v3 != 0) {
            v0_1 = new StringBuilder();
            v2 = arg6.getClipData().getItemCount();
            v3 = 0;
        }
        else {
            return null;
        }

        while(v1 < v2) {
            CharSequence v5 = arg6.getClipData().getItemAt(v1).getText();
            if(v5 != null) {
                if(v3 != 0) {
                    v0_1.append("\n");
                }

                v0_1.append(v5);
                v3 = 1;
            }

            ++v1;
        }

        String v6 = v0_1.toString();
        Intrinsics.checkNotNullExpressionValue(v6, "toString(...)");
        return v6;
    }
}

