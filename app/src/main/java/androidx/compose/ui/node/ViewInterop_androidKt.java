package androidx.compose.ui.node;

import android.view.View;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000,\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A1\u0010\u0000\u001A\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u0002H\u00010\u0007H\u0007¢\u0006\u0002\u0010\b\u001A\u0010\u0010\t\u001A\u00020\u00052\u0006\u0010\n\u001A\u00020\u000BH\u0000\u001A\u000E\u0010\r\u001A\u0004\u0018\u00010\u000E*\u00020\u0003H\u0000\u001A\f\u0010\u000F\u001A\u00020\u000E*\u00020\u0003H\u0000\"\u000E\u0010\f\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2={"getOrAddAdapter", "T", "Landroidx/compose/ui/node/ViewAdapter;", "Landroid/view/View;", "id", "", "factory", "Lkotlin/Function0;", "(Landroid/view/View;ILkotlin/jvm/functions/Function0;)Landroidx/compose/ui/node/ViewAdapter;", "tagKey", "key", "", "viewAdaptersKey", "getViewAdapterIfExists", "Landroidx/compose/ui/node/MergedViewAdapter;", "getViewAdapter", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ViewInterop_androidKt {
    private static final int viewAdaptersKey;

    static {
        ViewInterop_androidKt.viewAdaptersKey = ViewInterop_androidKt.tagKey("ViewAdapter");
    }

    public static final ViewAdapter getOrAddAdapter(View arg6, int arg7, Function0 arg8) {
        Object v4;
        Object v3;
        MergedViewAdapter v6 = ViewInterop_androidKt.getViewAdapter(arg6);
        List v0 = v6.getAdapters();
        int v1 = v0.size();
        int v2 = 0;
        while(true) {
            v3 = null;
            if(v2 < v1) {
                v4 = v0.get(v2);
                if(v4.getId() == arg7) {
                }
                else {
                    ++v2;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_15;
        }

        v4 = v3;
    label_15:
        if((v4 instanceof ViewAdapter)) {
            v3 = v4;
        }

        if(v3 == null) {
            Object v7 = arg8.invoke();
            v6.getAdapters().add(v7);
            return ((ViewAdapter)v7);
        }

        return ((ViewAdapter)v3);
    }

    public static final MergedViewAdapter getViewAdapter(View arg3) {
        int v0 = ViewInterop_androidKt.viewAdaptersKey;
        Object v1 = arg3.getTag(v0);
        if((v1 instanceof MergedViewAdapter)) {
        }
        else {
            v1 = null;
        }

        if(v1 == null) {
            MergedViewAdapter v1_1 = new MergedViewAdapter();
            arg3.setTag(v0, v1_1);
        }

        return ((MergedViewAdapter)v1);
    }

    public static final MergedViewAdapter getViewAdapterIfExists(View arg1) {
        Object v1 = arg1.getTag(ViewInterop_androidKt.viewAdaptersKey);
        if((v1 instanceof MergedViewAdapter)) {
            return ((MergedViewAdapter)v1);
        }

        return null;
    }

    public static final int tagKey(String arg1) {
        return arg1.hashCode() | 0x3000000;
    }
}

