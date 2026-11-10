package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider$Factory;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;

class FragmentViewLifecycleOwner implements HasDefaultViewModelProviderFactory, ViewModelStoreOwner, SavedStateRegistryOwner {
    private Factory mDefaultFactory;
    private final Fragment mFragment;
    private LifecycleRegistry mLifecycleRegistry;
    private SavedStateRegistryController mSavedStateRegistryController;
    private final ViewModelStore mViewModelStore;

    FragmentViewLifecycleOwner(Fragment arg2, ViewModelStore arg3) {
        super();
        this.mLifecycleRegistry = null;
        this.mSavedStateRegistryController = null;
        this.mFragment = arg2;
        this.mViewModelStore = arg3;
    }

    public Factory getDefaultViewModelProviderFactory() {
        Factory v0 = this.mFragment.getDefaultViewModelProviderFactory();
        if(!v0.equals(this.mFragment.mDefaultFactory)) {
            this.mDefaultFactory = v0;
            return v0;
        }

        if(this.mDefaultFactory == null) {
            Context v0_1 = this.mFragment.requireContext().getApplicationContext();
            while(true) {
                if(!(v0_1 instanceof ContextWrapper)) {
                    break;
                }
                else if((v0_1 instanceof Application)) {
                }
                else {
                    v0_1 = ((ContextWrapper)v0_1).getBaseContext();
                    continue;
                }

                goto label_21;
            }

            Application v0_2 = null;
        label_21:
            this.mDefaultFactory = new SavedStateViewModelFactory(v0_2, ((SavedStateRegistryOwner)this), this.mFragment.getArguments());
        }

        return this.mDefaultFactory;
    }

    public Lifecycle getLifecycle() {
        this.initialize();
        return this.mLifecycleRegistry;
    }

    public SavedStateRegistry getSavedStateRegistry() {
        this.initialize();
        return this.mSavedStateRegistryController.getSavedStateRegistry();
    }

    public ViewModelStore getViewModelStore() {
        this.initialize();
        return this.mViewModelStore;
    }

    void handleLifecycleEvent(Event arg1) {
        this.mLifecycleRegistry.handleLifecycleEvent(arg1);
    }

    void initialize() {
        if(this.mLifecycleRegistry == null) {
            this.mLifecycleRegistry = new LifecycleRegistry(((LifecycleOwner)this));
            this.mSavedStateRegistryController = SavedStateRegistryController.create(((SavedStateRegistryOwner)this));
        }
    }

    boolean isInitialized() {
        if(this.mLifecycleRegistry != null) {
            return 1;
        }

        return 0;
    }

    void performRestore(Bundle arg1) {
        this.mSavedStateRegistryController.performRestore(arg1);
    }

    void performSave(Bundle arg1) {
        this.mSavedStateRegistryController.performSave(arg1);
    }

    void setCurrentState(State arg1) {
        this.mLifecycleRegistry.setCurrentState(arg1);
    }
}

