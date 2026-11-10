package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

public abstract class FragmentContainer {
    public FragmentContainer() {
        super();
    }

    @Deprecated public Fragment instantiate(Context arg1, String arg2, Bundle arg3) {
        return Fragment.instantiate(arg1, arg2, arg3);
    }

    public abstract View onFindViewById(int arg1);

    public abstract boolean onHasView();
}

