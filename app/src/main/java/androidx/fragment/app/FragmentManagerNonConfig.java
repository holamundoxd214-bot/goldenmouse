package androidx.fragment.app;

import java.util.Collection;
import java.util.Map;

@Deprecated public class FragmentManagerNonConfig {
    private final Map mChildNonConfigs;
    private final Collection mFragments;
    private final Map mViewModelStores;

    FragmentManagerNonConfig(Collection arg1, Map arg2, Map arg3) {
        super();
        this.mFragments = arg1;
        this.mChildNonConfigs = arg2;
        this.mViewModelStores = arg3;
    }

    Map getChildNonConfigs() {
        return this.mChildNonConfigs;
    }

    Collection getFragments() {
        return this.mFragments;
    }

    Map getViewModelStores() {
        return this.mViewModelStores;
    }

    boolean isRetaining(Fragment arg1) {
        Collection v0 = this.mFragments;
        if(v0 == null) {
            return 0;
        }

        return v0.contains(arg1);
    }
}

