package androidx.core.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class MenuHostHelper {
    class LifecycleContainer {
        final Lifecycle mLifecycle;
        private LifecycleEventObserver mObserver;

        LifecycleContainer(Lifecycle arg1, LifecycleEventObserver arg2) {
            super();
            this.mLifecycle = arg1;
            this.mObserver = arg2;
            arg1.addObserver(((LifecycleObserver)arg2));
        }

        void clearObservers() {
            this.mLifecycle.removeObserver(this.mObserver);
            this.mObserver = null;
        }
    }

    private final CopyOnWriteArrayList mMenuProviders;
    private final Runnable mOnInvalidateMenuCallback;
    private final Map mProviderToLifecycleContainers;

    public MenuHostHelper(Runnable arg2) {
        super();
        this.mMenuProviders = new CopyOnWriteArrayList();
        this.mProviderToLifecycleContainers = new HashMap();
        this.mOnInvalidateMenuCallback = arg2;
    }

    public void addMenuProvider(MenuProvider arg2) {
        this.mMenuProviders.add(arg2);
        this.mOnInvalidateMenuCallback.run();
    }

    public void addMenuProvider(MenuProvider arg3, LifecycleOwner arg4) {
        this.addMenuProvider(arg3);
        Lifecycle v4 = arg4.getLifecycle();
        Object v0 = this.mProviderToLifecycleContainers.remove(arg3);
        if(v0 != null) {
            ((LifecycleContainer)v0).clearObservers();
        }

        this.mProviderToLifecycleContainers.put(arg3, new LifecycleContainer(v4, new MenuHostHelper$$ExternalSyntheticLambda1(this, arg3)));
    }

    public void addMenuProvider(MenuProvider arg2, LifecycleOwner arg3, State arg4) {
        Lifecycle v3 = arg3.getLifecycle();
        Object v0 = this.mProviderToLifecycleContainers.remove(arg2);
        if(v0 != null) {
            ((LifecycleContainer)v0).clearObservers();
        }

        this.mProviderToLifecycleContainers.put(arg2, new LifecycleContainer(v3, new MenuHostHelper$$ExternalSyntheticLambda0(this, arg4, arg2)));
    }

    void lambda$addMenuProvider$0$androidx-core-view-MenuHostHelper(MenuProvider arg1, LifecycleOwner arg2, Event arg3) {
        if(arg3 == Event.ON_DESTROY) {
            this.removeMenuProvider(arg1);
        }
    }

    void lambda$addMenuProvider$1$androidx-core-view-MenuHostHelper(State arg1, MenuProvider arg2, LifecycleOwner arg3, Event arg4) {
        if(arg4 == Event.upTo(arg1)) {
            this.addMenuProvider(arg2);
            return;
        }

        if(arg4 == Event.ON_DESTROY) {
            this.removeMenuProvider(arg2);
            return;
        }

        if(arg4 == Event.downFrom(arg1)) {
            this.mMenuProviders.remove(arg2);
            this.mOnInvalidateMenuCallback.run();
        }
    }

    public void onCreateMenu(Menu arg2, MenuInflater arg3) {
        Iterator v1 = this.mMenuProviders.iterator();
        while(v1.hasNext()) {
            v1.next().onCreateMenu(arg2, arg3);
        }
    }

    public void onMenuClosed(Menu arg2) {
        Iterator v1 = this.mMenuProviders.iterator();
        while(v1.hasNext()) {
            v1.next().onMenuClosed(arg2);
        }
    }

    public boolean onMenuItemSelected(MenuItem arg2) {
        Iterator v1 = this.mMenuProviders.iterator();
        do {
            if(!v1.hasNext()) {
                return 0;
            }
        }
        while(!v1.next().onMenuItemSelected(arg2));

        return 1;
    }

    public void onPrepareMenu(Menu arg2) {
        Iterator v1 = this.mMenuProviders.iterator();
        while(v1.hasNext()) {
            v1.next().onPrepareMenu(arg2);
        }
    }

    public void removeMenuProvider(MenuProvider arg2) {
        this.mMenuProviders.remove(arg2);
        Object v2 = this.mProviderToLifecycleContainers.remove(arg2);
        if(v2 != null) {
            ((LifecycleContainer)v2).clearObservers();
        }

        this.mOnInvalidateMenuCallback.run();
    }
}

