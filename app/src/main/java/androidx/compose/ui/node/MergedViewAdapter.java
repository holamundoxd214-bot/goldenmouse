package androidx.compose.ui.node;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\f\u001A\u0002H\r\"\b\b\u0000\u0010\r*\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u00052\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u0002H\r0\u000FH\u0086\b¢\u0006\u0002\u0010\u0010J\u0018\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u0016H\u0016J\u0018\u0010\u0017\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u0016H\u0016J\u0018\u0010\u0018\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u0016H\u0016R\u0014\u0010\u0004\u001A\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00010\t¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u0019"}, d2={"Landroidx/compose/ui/node/MergedViewAdapter;", "Landroidx/compose/ui/node/ViewAdapter;", "<init>", "()V", "id", "", "getId", "()I", "adapters", "", "getAdapters", "()Ljava/util/List;", "get", "T", "factory", "Lkotlin/Function0;", "(ILkotlin/jvm/functions/Function0;)Landroidx/compose/ui/node/ViewAdapter;", "willInsert", "", "view", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "didInsert", "didUpdate", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class MergedViewAdapter implements ViewAdapter {
    public static final int $stable = 8;
    private final List adapters;
    private final int id;

    static {
    }

    public MergedViewAdapter() {
        super();
        this.adapters = new ArrayList();
    }

    public void didInsert(View arg4, ViewGroup arg5) {
        List v3 = this.adapters;
        int v0 = v3.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            v3.get(v1).didInsert(arg4, arg5);
        }
    }

    public void didUpdate(View arg4, ViewGroup arg5) {
        List v3 = this.adapters;
        int v0 = v3.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            v3.get(v1).didUpdate(arg4, arg5);
        }
    }

    public final ViewAdapter get(int arg7, Function0 arg8) {
        Object v4;
        Object v3;
        List v0 = this.getAdapters();
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

            goto label_14;
        }

        v4 = v3;
    label_14:
        if((v4 instanceof ViewAdapter)) {
            v3 = v4;
        }

        if(v3 != null) {
            return ((ViewAdapter)v3);
        }

        Object v7 = arg8.invoke();
        this.getAdapters().add(v7);
        return ((ViewAdapter)v7);
    }

    public final List getAdapters() {
        return this.adapters;
    }

    public int getId() {
        return this.id;
    }

    public void willInsert(View arg4, ViewGroup arg5) {
        List v3 = this.adapters;
        int v0 = v3.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            v3.get(v1).willInsert(arg4, arg5);
        }
    }
}

