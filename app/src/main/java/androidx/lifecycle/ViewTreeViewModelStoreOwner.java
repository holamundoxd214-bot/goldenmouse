package androidx.lifecycle;

import android.view.View;
import android.view.ViewParent;
import androidx.core.viewtree.ViewTree;
import androidx.lifecycle.viewmodel.R$id;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A\u001B\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001A\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0002\b\u0005\u001A\u0013\u0010\u0006\u001A\u0004\u0018\u00010\u0004*\u00020\u0002H\u0007¢\u0006\u0002\b\u0007¨\u0006\b"}, d2={"setViewTreeViewModelStoreOwner", "", "Landroid/view/View;", "viewModelStoreOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "set", "findViewTreeViewModelStoreOwner", "get", "lifecycle-viewmodel"}, k=2, mv={2, 1, 0}, xi=0x30) public final class ViewTreeViewModelStoreOwner {
    public static final ViewModelStoreOwner get(View arg3) {
        View v0;
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        while(true) {
            v0 = null;
            if(arg3 == null) {
                break;
            }

            Object v1 = arg3.getTag(id.view_tree_view_model_store_owner);
            if((v1 instanceof ViewModelStoreOwner)) {
            }
            else {
                v1 = v0;
            }

            if(v1 != null) {
                return ((ViewModelStoreOwner)v1);
            }

            ViewParent v3 = ViewTree.getParentOrViewTreeDisjointParent(((View)v3));
            if((v3 instanceof View)) {
                continue;
            }

            arg3 = v0;
        }

        return ((ViewModelStoreOwner)v0);
    }

    public static final void set(View arg1, ViewModelStoreOwner arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1.setTag(id.view_tree_view_model_store_owner, arg2);
    }
}

