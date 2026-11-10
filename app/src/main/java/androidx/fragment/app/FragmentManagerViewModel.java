package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider$Factory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map$Entry;
import java.util.Map;

final class FragmentManagerViewModel extends ViewModel {
    class androidx.fragment.app.FragmentManagerViewModel$1 implements Factory {
        androidx.fragment.app.FragmentManagerViewModel$1() {
            super();
        }

        public ViewModel create(Class arg1) {
            return new FragmentManagerViewModel(true);
        }
    }

    private static final Factory FACTORY = null;
    private static final String TAG = "FragmentManager";
    private final HashMap mChildNonConfigs;
    private boolean mHasBeenCleared;
    private boolean mHasSavedSnapshot;
    private boolean mIsStateSaved;
    private final HashMap mRetainedFragments;
    private final boolean mStateAutomaticallySaved;
    private final HashMap mViewModelStores;

    static {
        FragmentManagerViewModel.FACTORY = new androidx.fragment.app.FragmentManagerViewModel$1();
    }

    FragmentManagerViewModel(boolean arg2) {
        super();
        this.mRetainedFragments = new HashMap();
        this.mChildNonConfigs = new HashMap();
        this.mViewModelStores = new HashMap();
        this.mHasBeenCleared = false;
        this.mHasSavedSnapshot = false;
        this.mIsStateSaved = false;
        this.mStateAutomaticallySaved = arg2;
    }

    void addRetainedFragment(Fragment arg5) {
        String v1 = "FragmentManager";
        int v2 = 2;
        if(this.mIsStateSaved) {
            if(FragmentManager.isLoggingEnabled(v2)) {
                Log.v(v1, "Ignoring addRetainedFragment as the state is already saved");
                return;
            }
        }
        else if(this.mRetainedFragments.containsKey(arg5.mWho)) {
        }
        else {
            this.mRetainedFragments.put(arg5.mWho, arg5);
            if(FragmentManager.isLoggingEnabled(v2)) {
                Log.v(v1, "Updating retained Fragments: Added " + arg5);
            }
        }
    }

    void clearNonConfigState(Fragment arg3) {
        if(FragmentManager.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + arg3);
        }

        Object v0 = this.mChildNonConfigs.get(arg3.mWho);
        if(v0 != null) {
            ((FragmentManagerViewModel)v0).onCleared();
            this.mChildNonConfigs.remove(arg3.mWho);
        }

        v0 = this.mViewModelStores.get(arg3.mWho);
        if(v0 != null) {
            ((ViewModelStore)v0).clear();
            this.mViewModelStores.remove(arg3.mWho);
        }
    }

    public boolean equals(Object arg5) {
        if(this == (((FragmentManagerViewModel)arg5))) {
            return 1;
        }

        if(arg5 != null) {
            if(this.getClass() != arg5.getClass()) {
            }
            else if((this.mRetainedFragments.equals(((FragmentManagerViewModel)arg5).mRetainedFragments)) && (this.mChildNonConfigs.equals(((FragmentManagerViewModel)arg5).mChildNonConfigs)) && (this.mViewModelStores.equals(((FragmentManagerViewModel)arg5).mViewModelStores))) {
                return 1;
            }
        }

        return 0;
    }

    Fragment findRetainedFragmentByWho(String arg1) {
        return this.mRetainedFragments.get(arg1);
    }

    FragmentManagerViewModel getChildNonConfig(Fragment arg3) {
        Object v0 = this.mChildNonConfigs.get(arg3.mWho);
        if(v0 == null) {
            FragmentManagerViewModel v0_1 = new FragmentManagerViewModel(this.mStateAutomaticallySaved);
            this.mChildNonConfigs.put(arg3.mWho, v0_1);
        }

        return ((FragmentManagerViewModel)v0);
    }

    static FragmentManagerViewModel getInstance(ViewModelStore arg2) {
        return new ViewModelProvider(arg2, FragmentManagerViewModel.FACTORY).get(FragmentManagerViewModel.class);
    }

    Collection getRetainedFragments() {
        return new ArrayList(this.mRetainedFragments.values());
    }

    @Deprecated FragmentManagerNonConfig getSnapshot() {
        FragmentManagerNonConfig v1 = null;
        if((this.mRetainedFragments.isEmpty()) && (this.mChildNonConfigs.isEmpty()) && (this.mViewModelStores.isEmpty())) {
            return v1;
        }

        HashMap v0 = new HashMap();
        Iterator v2 = this.mChildNonConfigs.entrySet().iterator();
        while(v2.hasNext()) {
            Object v3 = v2.next();
            FragmentManagerNonConfig v4 = ((Map$Entry)v3).getValue().getSnapshot();
            if(v4 == null) {
                continue;
            }

            v0.put(((Map$Entry)v3).getKey(), v4);
        }

        this.mHasSavedSnapshot = true;
        if((this.mRetainedFragments.isEmpty()) && (v0.isEmpty()) && (this.mViewModelStores.isEmpty())) {
            return v1;
        }

        return new FragmentManagerNonConfig(new ArrayList(this.mRetainedFragments.values()), ((Map)v0), new HashMap(this.mViewModelStores));
    }

    ViewModelStore getViewModelStore(Fragment arg3) {
        ViewModelStore v0_1;
        Object v0 = this.mViewModelStores.get(arg3.mWho);
        if(v0 == null) {
            v0_1 = new ViewModelStore();
            this.mViewModelStores.put(arg3.mWho, v0_1);
        }

        return v0_1;
    }

    public int hashCode() {
        return (this.mRetainedFragments.hashCode() * 0x1F + this.mChildNonConfigs.hashCode()) * 0x1F + this.mViewModelStores.hashCode();
    }

    boolean isCleared() {
        return this.mHasBeenCleared;
    }

    protected void onCleared() {
        if(FragmentManager.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }

        this.mHasBeenCleared = true;
    }

    void removeRetainedFragment(Fragment arg4) {
        String v1 = "FragmentManager";
        int v2 = 2;
        if(this.mIsStateSaved) {
            if(FragmentManager.isLoggingEnabled(v2)) {
                Log.v(v1, "Ignoring removeRetainedFragment as the state is already saved");
                return;
            }
        }
        else if(this.mRetainedFragments.remove(arg4.mWho) != null && (FragmentManager.isLoggingEnabled(v2))) {
            Log.v(v1, "Updating retained Fragments: Removed " + arg4);
        }
    }

    @Deprecated void restoreFromSnapshot(FragmentManagerNonConfig arg5) {
        Object v1;
        Iterator v0_1;
        this.mRetainedFragments.clear();
        this.mChildNonConfigs.clear();
        this.mViewModelStores.clear();
        if(arg5 != null) {
            Collection v0 = arg5.getFragments();
            if(v0 != null) {
                v0_1 = v0.iterator();
                while(v0_1.hasNext()) {
                    v1 = v0_1.next();
                    if(v1 == null) {
                        continue;
                    }

                    this.mRetainedFragments.put(((Fragment)v1).mWho, v1);
                }
            }

            Map v0_2 = arg5.getChildNonConfigs();
            if(v0_2 != null) {
                v0_1 = v0_2.entrySet().iterator();
                while(v0_1.hasNext()) {
                    v1 = v0_1.next();
                    FragmentManagerViewModel v2 = new FragmentManagerViewModel(this.mStateAutomaticallySaved);
                    v2.restoreFromSnapshot(((Map$Entry)v1).getValue());
                    this.mChildNonConfigs.put(((Map$Entry)v1).getKey(), v2);
                }
            }

            Map v5 = arg5.getViewModelStores();
            if(v5 == null) {
                goto label_38;
            }

            this.mViewModelStores.putAll(v5);
        }

    label_38:
        this.mHasSavedSnapshot = false;
    }

    void setIsStateSaved(boolean arg1) {
        this.mIsStateSaved = arg1;
    }

    boolean shouldDestroy(Fragment arg2) {
        if(!this.mRetainedFragments.containsKey(arg2.mWho)) {
            return 1;
        }

        if(this.mStateAutomaticallySaved) {
            return this.mHasBeenCleared;
        }

        return this.mHasSavedSnapshot ^ 1;
    }

    public String toString() {
        String v3;
        StringBuilder v0 = new StringBuilder("FragmentManagerViewModel{");
        v0.append(Integer.toHexString(System.identityHashCode(this)));
        v0.append("} Fragments (");
        Iterator v1 = this.mRetainedFragments.values().iterator();
        while(true) {
            v3 = ", ";
            if(!v1.hasNext()) {
                break;
            }

            v0.append(v1.next());
            if(!v1.hasNext()) {
                continue;
            }

            v0.append(v3);
        }

        v0.append(") Child Non Config (");
        v1 = this.mChildNonConfigs.keySet().iterator();
        while(v1.hasNext()) {
            v0.append(v1.next());
            if(!v1.hasNext()) {
                continue;
            }

            v0.append(v3);
        }

        v0.append(") ViewModelStores (");
        Iterator v4 = this.mViewModelStores.keySet().iterator();
        while(v4.hasNext()) {
            v0.append(v4.next());
            if(!v4.hasNext()) {
                continue;
            }

            v0.append(v3);
        }

        v0.append(')');
        return v0.toString();
    }
}

