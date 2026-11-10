package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class FragmentLifecycleCallbacksDispatcher {
    final class FragmentLifecycleCallbacksHolder {
        final FragmentLifecycleCallbacks mCallback;
        final boolean mRecursive;

        FragmentLifecycleCallbacksHolder(FragmentLifecycleCallbacks arg1, boolean arg2) {
            super();
            this.mCallback = arg1;
            this.mRecursive = arg2;
        }
    }

    private final FragmentManager mFragmentManager;
    private final CopyOnWriteArrayList mLifecycleCallbacks;

    FragmentLifecycleCallbacksDispatcher(FragmentManager arg2) {
        super();
        this.mLifecycleCallbacks = new CopyOnWriteArrayList();
        this.mFragmentManager = arg2;
    }

    void dispatchOnFragmentActivityCreated(Fragment arg4, Bundle arg5, boolean arg6) {
        Fragment v0 = this.mFragmentManager.getParent();
        if(v0 != null) {
            v0.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentActivityCreated(arg4, arg5, true);
        }

        Iterator v0_1 = this.mLifecycleCallbacks.iterator();
        while(v0_1.hasNext()) {
            Object v1 = v0_1.next();
            if((arg6) && !((FragmentLifecycleCallbacksHolder)v1).mRecursive) {
                continue;
            }

            ((FragmentLifecycleCallbacksHolder)v1).mCallback.onFragmentActivityCreated(this.mFragmentManager, arg4, arg5);
        }
    }

    void dispatchOnFragmentAttached(Fragment arg5, boolean arg6) {
        Context v0 = this.mFragmentManager.getHost().getContext();
        Fragment v1 = this.mFragmentManager.getParent();
        if(v1 != null) {
            v1.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentAttached(arg5, true);
        }

        Iterator v1_1 = this.mLifecycleCallbacks.iterator();
        while(v1_1.hasNext()) {
            Object v2 = v1_1.next();
            if((arg6) && !((FragmentLifecycleCallbacksHolder)v2).mRecursive) {
                continue;
            }

            ((FragmentLifecycleCallbacksHolder)v2).mCallback.onFragmentAttached(this.mFragmentManager, arg5, v0);
        }
    }

    void dispatchOnFragmentCreated(Fragment arg4, Bundle arg5, boolean arg6) {
        Fragment v0 = this.mFragmentManager.getParent();
        if(v0 != null) {
            v0.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentCreated(arg4, arg5, true);
        }

        Iterator v0_1 = this.mLifecycleCallbacks.iterator();
        while(v0_1.hasNext()) {
            Object v1 = v0_1.next();
            if((arg6) && !((FragmentLifecycleCallbacksHolder)v1).mRecursive) {
                continue;
            }

            ((FragmentLifecycleCallbacksHolder)v1).mCallback.onFragmentCreated(this.mFragmentManager, arg4, arg5);
        }
    }

    void dispatchOnFragmentDestroyed(Fragment arg4, boolean arg5) {
        Fragment v0 = this.mFragmentManager.getParent();
        if(v0 != null) {
            v0.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentDestroyed(arg4, true);
        }

        Iterator v0_1 = this.mLifecycleCallbacks.iterator();
        while(v0_1.hasNext()) {
            Object v1 = v0_1.next();
            if((arg5) && !((FragmentLifecycleCallbacksHolder)v1).mRecursive) {
                continue;
            }

            ((FragmentLifecycleCallbacksHolder)v1).mCallback.onFragmentDestroyed(this.mFragmentManager, arg4);
        }
    }

    void dispatchOnFragmentDetached(Fragment arg4, boolean arg5) {
        Fragment v0 = this.mFragmentManager.getParent();
        if(v0 != null) {
            v0.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentDetached(arg4, true);
        }

        Iterator v0_1 = this.mLifecycleCallbacks.iterator();
        while(v0_1.hasNext()) {
            Object v1 = v0_1.next();
            if((arg5) && !((FragmentLifecycleCallbacksHolder)v1).mRecursive) {
                continue;
            }

            ((FragmentLifecycleCallbacksHolder)v1).mCallback.onFragmentDetached(this.mFragmentManager, arg4);
        }
    }

    void dispatchOnFragmentPaused(Fragment arg4, boolean arg5) {
        Fragment v0 = this.mFragmentManager.getParent();
        if(v0 != null) {
            v0.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentPaused(arg4, true);
        }

        Iterator v0_1 = this.mLifecycleCallbacks.iterator();
        while(v0_1.hasNext()) {
            Object v1 = v0_1.next();
            if((arg5) && !((FragmentLifecycleCallbacksHolder)v1).mRecursive) {
                continue;
            }

            ((FragmentLifecycleCallbacksHolder)v1).mCallback.onFragmentPaused(this.mFragmentManager, arg4);
        }
    }

    void dispatchOnFragmentPreAttached(Fragment arg5, boolean arg6) {
        Context v0 = this.mFragmentManager.getHost().getContext();
        Fragment v1 = this.mFragmentManager.getParent();
        if(v1 != null) {
            v1.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentPreAttached(arg5, true);
        }

        Iterator v1_1 = this.mLifecycleCallbacks.iterator();
        while(v1_1.hasNext()) {
            Object v2 = v1_1.next();
            if((arg6) && !((FragmentLifecycleCallbacksHolder)v2).mRecursive) {
                continue;
            }

            ((FragmentLifecycleCallbacksHolder)v2).mCallback.onFragmentPreAttached(this.mFragmentManager, arg5, v0);
        }
    }

    void dispatchOnFragmentPreCreated(Fragment arg4, Bundle arg5, boolean arg6) {
        Fragment v0 = this.mFragmentManager.getParent();
        if(v0 != null) {
            v0.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentPreCreated(arg4, arg5, true);
        }

        Iterator v0_1 = this.mLifecycleCallbacks.iterator();
        while(v0_1.hasNext()) {
            Object v1 = v0_1.next();
            if((arg6) && !((FragmentLifecycleCallbacksHolder)v1).mRecursive) {
                continue;
            }

            ((FragmentLifecycleCallbacksHolder)v1).mCallback.onFragmentPreCreated(this.mFragmentManager, arg4, arg5);
        }
    }

    void dispatchOnFragmentResumed(Fragment arg4, boolean arg5) {
        Fragment v0 = this.mFragmentManager.getParent();
        if(v0 != null) {
            v0.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentResumed(arg4, true);
        }

        Iterator v0_1 = this.mLifecycleCallbacks.iterator();
        while(v0_1.hasNext()) {
            Object v1 = v0_1.next();
            if((arg5) && !((FragmentLifecycleCallbacksHolder)v1).mRecursive) {
                continue;
            }

            ((FragmentLifecycleCallbacksHolder)v1).mCallback.onFragmentResumed(this.mFragmentManager, arg4);
        }
    }

    void dispatchOnFragmentSaveInstanceState(Fragment arg4, Bundle arg5, boolean arg6) {
        Fragment v0 = this.mFragmentManager.getParent();
        if(v0 != null) {
            v0.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentSaveInstanceState(arg4, arg5, true);
        }

        Iterator v0_1 = this.mLifecycleCallbacks.iterator();
        while(v0_1.hasNext()) {
            Object v1 = v0_1.next();
            if((arg6) && !((FragmentLifecycleCallbacksHolder)v1).mRecursive) {
                continue;
            }

            ((FragmentLifecycleCallbacksHolder)v1).mCallback.onFragmentSaveInstanceState(this.mFragmentManager, arg4, arg5);
        }
    }

    void dispatchOnFragmentStarted(Fragment arg4, boolean arg5) {
        Fragment v0 = this.mFragmentManager.getParent();
        if(v0 != null) {
            v0.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentStarted(arg4, true);
        }

        Iterator v0_1 = this.mLifecycleCallbacks.iterator();
        while(v0_1.hasNext()) {
            Object v1 = v0_1.next();
            if((arg5) && !((FragmentLifecycleCallbacksHolder)v1).mRecursive) {
                continue;
            }

            ((FragmentLifecycleCallbacksHolder)v1).mCallback.onFragmentStarted(this.mFragmentManager, arg4);
        }
    }

    void dispatchOnFragmentStopped(Fragment arg4, boolean arg5) {
        Fragment v0 = this.mFragmentManager.getParent();
        if(v0 != null) {
            v0.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentStopped(arg4, true);
        }

        Iterator v0_1 = this.mLifecycleCallbacks.iterator();
        while(v0_1.hasNext()) {
            Object v1 = v0_1.next();
            if((arg5) && !((FragmentLifecycleCallbacksHolder)v1).mRecursive) {
                continue;
            }

            ((FragmentLifecycleCallbacksHolder)v1).mCallback.onFragmentStopped(this.mFragmentManager, arg4);
        }
    }

    void dispatchOnFragmentViewCreated(Fragment arg4, View arg5, Bundle arg6, boolean arg7) {
        Fragment v0 = this.mFragmentManager.getParent();
        if(v0 != null) {
            v0.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentViewCreated(arg4, arg5, arg6, true);
        }

        Iterator v0_1 = this.mLifecycleCallbacks.iterator();
        while(v0_1.hasNext()) {
            Object v1 = v0_1.next();
            if((arg7) && !((FragmentLifecycleCallbacksHolder)v1).mRecursive) {
                continue;
            }

            ((FragmentLifecycleCallbacksHolder)v1).mCallback.onFragmentViewCreated(this.mFragmentManager, arg4, arg5, arg6);
        }
    }

    void dispatchOnFragmentViewDestroyed(Fragment arg4, boolean arg5) {
        Fragment v0 = this.mFragmentManager.getParent();
        if(v0 != null) {
            v0.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentViewDestroyed(arg4, true);
        }

        Iterator v0_1 = this.mLifecycleCallbacks.iterator();
        while(v0_1.hasNext()) {
            Object v1 = v0_1.next();
            if((arg5) && !((FragmentLifecycleCallbacksHolder)v1).mRecursive) {
                continue;
            }

            ((FragmentLifecycleCallbacksHolder)v1).mCallback.onFragmentViewDestroyed(this.mFragmentManager, arg4);
        }
    }

    public void registerFragmentLifecycleCallbacks(FragmentLifecycleCallbacks arg2, boolean arg3) {
        this.mLifecycleCallbacks.add(new FragmentLifecycleCallbacksHolder(arg2, arg3));
    }

    public void unregisterFragmentLifecycleCallbacks(FragmentLifecycleCallbacks arg5) {
        CopyOnWriteArrayList v0 = this.mLifecycleCallbacks;
        __monitor_enter(v0);
        try {
            int v1 = this.mLifecycleCallbacks.size();
            int v2 = 0;
            while(v2 < v1) {
                if(this.mLifecycleCallbacks.get(v2).mCallback == arg5) {
                    this.mLifecycleCallbacks.remove(v2);
                }
                else {
                    ++v2;
                    continue;
                }

                break;
            }

            __monitor_exit(v0);
            return;
        label_18:
            __monitor_exit(v0);
        }
        catch(Throwable v4) {
            goto label_18;
        }

        throw v4;
    }
}

