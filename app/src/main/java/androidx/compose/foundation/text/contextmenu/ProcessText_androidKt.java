package androidx.compose.foundation.text.contextmenu;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.text.contextmenu.builder.TextContextMenuBuilderScope;
import androidx.compose.foundation.text.contextmenu.builder.TextContextMenuBuilderScope_androidKt;
import androidx.compose.foundation.text.contextmenu.data.ProcessTextKey;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSession;
import androidx.compose.ui.text.TextRange;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(d1={"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A3\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\nH\u0000¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2={"addProcessedTextContextMenuItems", "", "Landroidx/compose/foundation/text/contextmenu/builder/TextContextMenuBuilderScope;", "context", "Landroid/content/Context;", "editable", "", "text", "", "selection", "Landroidx/compose/ui/text/TextRange;", "addProcessedTextContextMenuItems-UAq72N0", "(Landroidx/compose/foundation/text/contextmenu/builder/TextContextMenuBuilderScope;Landroid/content/Context;ZLjava/lang/CharSequence;J)V", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ProcessText_androidKt {
    public static Unit $r8$lambda$SEhsqHDCZKTOTFjmrotaPzaFt2A(Context arg0, ResolveInfo arg1, boolean arg2, CharSequence arg3, long arg4, TextContextMenuSession arg6) {
        return ProcessText_androidKt.addProcessedTextContextMenuItems_UAq72N0$lambda$0$0(arg0, arg1, arg2, arg3, arg4, arg6);
    }

    public static final void addProcessedTextContextMenuItems-UAq72N0(TextContextMenuBuilderScope arg18, Context arg19, boolean arg20, CharSequence arg21, long arg22) {
        if((ComposeFoundationFlags.isSmartSelectionEnabled) && !TextRange.getCollapsed-impl(arg22)) {
            if(arg21.length() == 0) {
                return;
            }
            else {
                PackageManager v0 = arg19.getPackageManager();
                Context v3 = arg19;
                List v1 = ProcessTextApi23Impl.INSTANCE.queryProcessTextActivities(v3);
                if(v1.isEmpty()) {
                }
                else {
                    arg18.separator();
                    int v9 = v1.size();
                    int v10 = 0;
                    while(v10 < v9) {
                        Object v4 = v1.get(v10);
                        TextContextMenuBuilderScope_androidKt.item$default(arg18, new ProcessTextKey(v10), ((ResolveInfo)v4).loadLabel(v0).toString(), 0, new ProcessText_androidKt$$ExternalSyntheticLambda0(v3, ((ResolveInfo)v4), arg20, arg21, arg22), 4, null);
                        ++v10;
                        v3 = arg19;
                    }

                    arg18.separator();
                }
            }
        }
    }

    private static final Unit addProcessedTextContextMenuItems_UAq72N0$lambda$0$0(Context arg1, ResolveInfo arg2, boolean arg3, CharSequence arg4, long arg5, TextContextMenuSession arg7) {
        ProcessTextApi23Impl.INSTANCE.getOnClickProcessTextItem().invoke(arg1, arg2, Boolean.valueOf(arg3), arg4, TextRange.box-impl(arg5));
        arg7.close();
        return Unit.INSTANCE;
    }
}

