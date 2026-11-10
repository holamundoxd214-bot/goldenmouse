package androidx.compose.foundation.text.contextmenu;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import androidx.compose.ui.text.TextRange;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;

@Metadata(d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010 \u001A\u00020!H\u0002J\u0016\u0010\"\u001A\u00020!2\u0006\u0010#\u001A\u00020\u000B2\u0006\u0010\u0015\u001A\u00020\u0014J\u0014\u0010$\u001A\b\u0012\u0004\u0012\u00020\u000B0\n2\u0006\u0010\t\u001A\u00020\u0006J\u0014\u0010%\u001A\u00020\u0014*\u00020\u000B2\u0006\u0010\t\u001A\u00020\u0006H\u0002J\u0014\u0010%\u001A\u00020\u0014*\u00020&2\u0006\u0010\t\u001A\u00020\u0006H\u0002RE\u0010\u0004\u001A#\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000B0\n0\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u0014\n\u0000\u0012\u0004\b\f\u0010\u0003\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010R\u0093\u0001\u0010\u0011\u001Aq\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u000B¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001A0\u00128\u0006@\u0006X\u0087\u000E¢\u0006\u0014\n\u0000\u0012\u0004\b\u001B\u0010\u0003\u001A\u0004\b\u001C\u0010\u001D\"\u0004\b\u001E\u0010\u001F¨\u0006\'"}, d2={"Landroidx/compose/foundation/text/contextmenu/ProcessTextApi23Impl;", "", "<init>", "()V", "processTextActivitiesQuery", "Lkotlin/Function1;", "Landroid/content/Context;", "Lkotlin/ParameterName;", "name", "context", "", "Landroid/content/pm/ResolveInfo;", "getProcessTextActivitiesQuery$annotations", "getProcessTextActivitiesQuery", "()Lkotlin/jvm/functions/Function1;", "setProcessTextActivitiesQuery", "(Lkotlin/jvm/functions/Function1;)V", "onClickProcessTextItem", "Lkotlin/Function5;", "resolveInfo", "", "editable", "", "text", "Landroidx/compose/ui/text/TextRange;", "textRange", "", "getOnClickProcessTextItem$annotations", "getOnClickProcessTextItem", "()Lkotlin/jvm/functions/Function5;", "setOnClickProcessTextItem", "(Lkotlin/jvm/functions/Function5;)V", "createProcessTextIntent", "Landroid/content/Intent;", "createProcessTextIntentForResolveInfo", "info", "queryProcessTextActivities", "hasPermission", "Landroid/content/pm/ActivityInfo;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ProcessTextApi23Impl {
    public static final int $stable;
    public static final ProcessTextApi23Impl INSTANCE;
    private static Function5 onClickProcessTextItem;
    private static Function1 processTextActivitiesQuery;

    static {
        ProcessTextApi23Impl.INSTANCE = new ProcessTextApi23Impl();
        ProcessTextApi23Impl.processTextActivitiesQuery = new ProcessTextApi23Impl$$ExternalSyntheticLambda0();
        ProcessTextApi23Impl.onClickProcessTextItem = new ProcessTextApi23Impl$$ExternalSyntheticLambda1();
        ProcessTextApi23Impl.$stable = 8;
    }

    private ProcessTextApi23Impl() {
        super();
    }

    private final Intent createProcessTextIntent() {
        return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
    }

    public final Intent createProcessTextIntentForResolveInfo(ResolveInfo arg2, boolean arg3) {
        return this.createProcessTextIntent().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", arg3).setClassName(arg2.activityInfo.packageName, arg2.activityInfo.name);
    }

    public final Function5 getOnClickProcessTextItem() {
        return ProcessTextApi23Impl.onClickProcessTextItem;
    }

    public static void getOnClickProcessTextItem$annotations() {
    }

    public final Function1 getProcessTextActivitiesQuery() {
        return ProcessTextApi23Impl.processTextActivitiesQuery;
    }

    public static void getProcessTextActivitiesQuery$annotations() {
    }

    private final boolean hasPermission(ActivityInfo arg1, Context arg2) {
        if((arg1.exported) && (arg1.permission == null || arg2.checkSelfPermission(arg1.permission) == 0)) {
            return 1;
        }

        return 0;
    }

    private final boolean hasPermission(ResolveInfo arg3, Context arg4) {
        if(!arg4.getPackageName().equals(arg3.activityInfo.packageName)) {
            if(this.hasPermission(arg3.activityInfo, arg4)) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    static final Unit onClickProcessTextItem$lambda$0(Context arg3, ResolveInfo arg4, boolean arg5, CharSequence arg6, TextRange arg7) {
        String v6 = arg6.subSequence(TextRange.getMin-impl(arg7.unbox-impl()), TextRange.getMax-impl(arg7.unbox-impl())).toString();
        Intent v4 = ProcessTextApi23Impl.INSTANCE.createProcessTextIntentForResolveInfo(arg4, arg5);
        v4.putExtra("android.intent.extra.PROCESS_TEXT", v6);
        arg3.startActivity(v4);
        return Unit.INSTANCE;
    }

    static final List processTextActivitiesQuery$lambda$0(Context arg7) {
        int v2 = 0;
        List v0 = arg7.getPackageManager().queryIntentActivities(ProcessTextApi23Impl.INSTANCE.createProcessTextIntent(), 0);
        ArrayList v1 = new ArrayList(v0.size());
        int v3 = v0.size();
        while(v2 < v3) {
            Object v4 = v0.get(v2);
            if(ProcessTextApi23Impl.INSTANCE.hasPermission(v4, arg7)) {
                v1.add(v4);
            }

            ++v2;
        }

        return ((List)v1);
    }

    public final List queryProcessTextActivities(Context arg1) {
        return ProcessTextApi23Impl.processTextActivitiesQuery.invoke(arg1);
    }

    public final void setOnClickProcessTextItem(Function5 arg1) {
        ProcessTextApi23Impl.onClickProcessTextItem = arg1;
    }

    public final void setProcessTextActivitiesQuery(Function1 arg1) {
        ProcessTextApi23Impl.processTextActivitiesQuery = arg1;
    }
}

