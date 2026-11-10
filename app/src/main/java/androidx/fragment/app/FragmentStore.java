package androidx.fragment.app;

import android.util.Log;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class FragmentStore {
    private static final String TAG = "FragmentManager";
    private final HashMap mActive;
    private final ArrayList mAdded;
    private FragmentManagerViewModel mNonConfig;

    FragmentStore() {
        super();
        this.mAdded = new ArrayList();
        this.mActive = new HashMap();
    }

    void addFragment(Fragment arg3) {
        if(!this.mAdded.contains(arg3)) {
            ArrayList v0 = this.mAdded;
            __monitor_enter(v0);
            try {
                this.mAdded.add(arg3);
                __monitor_exit(v0);
            }
            catch(Throwable v2) {
                try {
                label_12:
                    __monitor_exit(v0);
                }
                catch(Throwable v2) {
                    goto label_12;
                }

                throw v2;
            }

            arg3.mAdded = true;
            return;
        }

        throw new IllegalStateException("Fragment already added: " + arg3);
    }

    void burpActive() {
        this.mActive.values().removeAll(Collections.singleton(null));
    }

    boolean containsActiveFragment(String arg1) {
        if(this.mActive.get(arg1) != null) {
            return 1;
        }

        return 0;
    }

    void dispatchStateChange(int arg2) {
        Iterator v1 = this.mActive.values().iterator();
        while(v1.hasNext()) {
            Object v0 = v1.next();
            if(v0 == null) {
                continue;
            }

            ((FragmentStateManager)v0).setFragmentManagerState(arg2);
        }
    }

    void dump(String arg4, FileDescriptor arg5, PrintWriter arg6, String[] arg7) {
        String v0 = arg4 + "    ";
        if(!this.mActive.isEmpty()) {
            arg6.print(arg4);
            arg6.println("Active Fragments:");
            Iterator v1 = this.mActive.values().iterator();
            while(v1.hasNext()) {
                Object v2 = v1.next();
                arg6.print(arg4);
                if(v2 != null) {
                    Fragment v2_1 = ((FragmentStateManager)v2).getFragment();
                    arg6.println(v2_1);
                    v2_1.dump(v0, arg5, arg6, arg7);
                }
                else {
                    arg6.println("null");
                }
            }
        }

        int v5 = this.mAdded.size();
        if(v5 > 0) {
            arg6.print(arg4);
            arg6.println("Added Fragments:");
            int v7;
            for(v7 = 0; v7 < v5; ++v7) {
                Object v0_1 = this.mAdded.get(v7);
                arg6.print(arg4);
                arg6.print("  #");
                arg6.print(v7);
                arg6.print(": ");
                arg6.println(((Fragment)v0_1).toString());
            }
        }
    }

    Fragment findActiveFragment(String arg1) {
        Object v0 = this.mActive.get(arg1);
        if(v0 != null) {
            return ((FragmentStateManager)v0).getFragment();
        }

        return null;
    }

    Fragment findFragmentById(int arg4) {
        Fragment v0_2;
        int v0;
        for(v0 = this.mAdded.size() - 1; v0 >= 0; --v0) {
            Object v1 = this.mAdded.get(v0);
            if(v1 != null && ((Fragment)v1).mFragmentId == arg4) {
                return ((Fragment)v1);
            }
        }

        Iterator v3 = this.mActive.values().iterator();
        do {
        label_15:
            if(!v3.hasNext()) {
                return null;
            }

            Object v0_1 = v3.next();
            if(v0_1 == null) {
                goto label_15;
            }

            v0_2 = ((FragmentStateManager)v0_1).getFragment();
        }
        while(v0_2.mFragmentId != arg4);

        return v0_2;
    }

    Fragment findFragmentByTag(String arg4) {
        Fragment v0_2;
        if(arg4 != null) {
            int v0;
            for(v0 = this.mAdded.size() - 1; v0 >= 0; --v0) {
                Object v1 = this.mAdded.get(v0);
                if(v1 != null && (arg4.equals(((Fragment)v1).mTag))) {
                    return ((Fragment)v1);
                }
            }
        }

        if(arg4 != null) {
            Iterator v3 = this.mActive.values().iterator();
            do {
                if(v3.hasNext()) {
                    Object v0_1 = v3.next();
                    if(v0_1 == null) {
                        continue;
                    }

                    v0_2 = ((FragmentStateManager)v0_1).getFragment();
                    if(!arg4.equals(v0_2.mTag)) {
                        continue;
                    }

                    return v0_2;
                }

                return null;
            }
            while(true);

            return v0_2;
        }

        return null;
    }

    Fragment findFragmentByWho(String arg2) {
        Fragment v0_1;
        Iterator v1 = this.mActive.values().iterator();
        do {
        label_3:
            if(!v1.hasNext()) {
                return null;
            }

            Object v0 = v1.next();
            if(v0 == null) {
                goto label_3;
            }

            v0_1 = ((FragmentStateManager)v0).getFragment().findFragmentByWho(arg2);
        }
        while(v0_1 == null);

        return v0_1;
    }

    int findFragmentIndexInContainer(Fragment arg6) {
        Object v2_1;
        ViewGroup v0 = arg6.mContainer;
        int v1 = -1;
        if(v0 == null) {
            return v1;
        }

        int v6 = this.mAdded.indexOf(arg6);
        int v2;
        for(v2 = v6 - 1; v2 >= 0; --v2) {
            Object v3 = this.mAdded.get(v2);
            if(((Fragment)v3).mContainer == v0 && ((Fragment)v3).mView != null) {
                return v0.indexOfChild(((Fragment)v3).mView) + 1;
            }
        }

        do {
        label_20:
            ++v6;
            if(v6 >= this.mAdded.size()) {
                return v1;
            }

            v2_1 = this.mAdded.get(v6);
            if(((Fragment)v2_1).mContainer != v0) {
                goto label_20;
            }
        }
        while(((Fragment)v2_1).mView == null);

        return v0.indexOfChild(((Fragment)v2_1).mView);
    }

    int getActiveFragmentCount() {
        return this.mActive.size();
    }

    List getActiveFragmentStateManagers() {
        ArrayList v0 = new ArrayList();
        Iterator v2 = this.mActive.values().iterator();
        while(v2.hasNext()) {
            Object v1 = v2.next();
            if(v1 == null) {
                continue;
            }

            v0.add(v1);
        }

        return ((List)v0);
    }

    List getActiveFragments() {
        ArrayList v0 = new ArrayList();
        Iterator v2 = this.mActive.values().iterator();
        while(v2.hasNext()) {
            Object v1 = v2.next();
            if(v1 != null) {
                v0.add(((FragmentStateManager)v1).getFragment());
                continue;
            }

            v0.add(null);
        }

        return ((List)v0);
    }

    FragmentStateManager getFragmentStateManager(String arg1) {
        return this.mActive.get(arg1);
    }

    List getFragments() {
        if(this.mAdded.isEmpty()) {
            return Collections.emptyList();
        }

        ArrayList v0 = this.mAdded;
        __monitor_enter(v0);
        try {
            __monitor_exit(v0);
            return new ArrayList(this.mAdded);
        label_13:
            __monitor_exit(v0);
        }
        catch(Throwable v2) {
            goto label_13;
        }

        throw v2;
    }

    FragmentManagerViewModel getNonConfig() {
        return this.mNonConfig;
    }

    void makeActive(FragmentStateManager arg4) {
        Fragment v0 = arg4.getFragment();
        if(this.containsActiveFragment(v0.mWho)) {
        }
        else {
            this.mActive.put(v0.mWho, arg4);
            if(v0.mRetainInstanceChangedWhileDetached) {
                boolean v4 = v0.mRetainInstance;
                FragmentManagerViewModel v3 = this.mNonConfig;
                if(v4) {
                    v3.addRetainedFragment(v0);
                }
                else {
                    v3.removeRetainedFragment(v0);
                }

                v0.mRetainInstanceChangedWhileDetached = false;
            }

            if(!FragmentManager.isLoggingEnabled(2)) {
                return;
            }

            Log.v("FragmentManager", "Added fragment to active set " + v0);
        }
    }

    void makeInactive(FragmentStateManager arg3) {
        Fragment v3 = arg3.getFragment();
        if(v3.mRetainInstance) {
            this.mNonConfig.removeRetainedFragment(v3);
        }

        if(this.mActive.put(v3.mWho, null) == null) {
        }
        else if(FragmentManager.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + v3);
        }
    }

    void moveToExpectedState() {
        Object v1;
        Iterator v0 = this.mAdded.iterator();
        while(v0.hasNext()) {
            v1 = this.mActive.get(v0.next().mWho);
            if(v1 == null) {
                continue;
            }

            ((FragmentStateManager)v1).moveToExpectedState();
        }

        v0 = this.mActive.values().iterator();
        while(v0.hasNext()) {
            v1 = v0.next();
            if(v1 == null) {
                continue;
            }

            ((FragmentStateManager)v1).moveToExpectedState();
            Fragment v2 = ((FragmentStateManager)v1).getFragment();
            if(!v2.mRemoving) {
                continue;
            }

            if(v2.isInBackStack()) {
                continue;
            }

            this.makeInactive(((FragmentStateManager)v1));
        }
    }

    void removeFragment(Fragment arg2) {
        ArrayList v0 = this.mAdded;
        __monitor_enter(v0);
        try {
            this.mAdded.remove(arg2);
            __monitor_exit(v0);
        }
        catch(Throwable v1) {
            try {
            label_9:
                __monitor_exit(v0);
            }
            catch(Throwable v1) {
                goto label_9;
            }

            throw v1;
        }

        arg2.mAdded = false;
    }

    void resetActiveFragments() {
        this.mActive.clear();
    }

    void restoreAddedFragments(List arg5) {
        Object v0;
        this.mAdded.clear();
        if(arg5 != null) {
            Iterator v5 = arg5.iterator();
            while(true) {
                if(v5.hasNext()) {
                    v0 = v5.next();
                    Fragment v1 = this.findActiveFragment(((String)v0));
                    if(v1 != null) {
                        if(FragmentManager.isLoggingEnabled(2)) {
                            Log.v("FragmentManager", "restoreSaveState: added (" + (((String)v0)) + "): " + v1);
                        }

                        this.addFragment(v1);
                        continue;
                    }
                    else {
                        break;
                    }
                }

                return;
            }

            throw new IllegalStateException("No instantiated fragment for (" + (((String)v0)) + ")");
        }
    }

    ArrayList saveActiveFragments() {
        ArrayList v0 = new ArrayList(this.mActive.size());
        Iterator v5 = this.mActive.values().iterator();
        while(v5.hasNext()) {
            Object v1 = v5.next();
            if(v1 == null) {
                continue;
            }

            Fragment v2 = ((FragmentStateManager)v1).getFragment();
            FragmentState v1_1 = ((FragmentStateManager)v1).saveState();
            v0.add(v1_1);
            if(!FragmentManager.isLoggingEnabled(2)) {
                continue;
            }

            Log.v("FragmentManager", "Saved state of " + v2 + ": " + v1_1.mSavedFragmentState);
        }

        return v0;
    }

    ArrayList saveAddedFragments() {
        ArrayList v0 = this.mAdded;
        __monitor_enter(v0);
        try {
            if(this.mAdded.isEmpty()) {
                __monitor_exit(v0);
                return null;
            }

            ArrayList v1 = new ArrayList(this.mAdded.size());
            Iterator v6_1 = this.mAdded.iterator();
            while(v6_1.hasNext()) {
                Object v2 = v6_1.next();
                v1.add(((Fragment)v2).mWho);
                if(!FragmentManager.isLoggingEnabled(2)) {
                    continue;
                }

                Log.v("FragmentManager", "saveAllState: adding fragment (" + ((Fragment)v2).mWho + "): " + v2);
            }

            __monitor_exit(v0);
            return v1;
        label_38:
            __monitor_exit(v0);
        }
        catch(Throwable v6) {
            goto label_38;
        }

        throw v6;
    }

    void setNonConfig(FragmentManagerViewModel arg1) {
        this.mNonConfig = arg1;
    }
}

