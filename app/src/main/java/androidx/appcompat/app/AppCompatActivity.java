package androidx.appcompat.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.ViewTreeOnBackPressedDispatcherOwner;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.appcompat.view.ActionMode$Callback;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NavUtils;
import androidx.core.app.TaskStackBuilder$SupportParentable;
import androidx.core.app.TaskStackBuilder;
import androidx.core.os.LocaleListCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistry$SavedStateProvider;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;

public class AppCompatActivity extends FragmentActivity implements DelegateProvider, AppCompatCallback, SupportParentable {
    private static final String DELEGATE_TAG = "androidx:appcompat";
    private AppCompatDelegate mDelegate;
    private Resources mResources;

    public AppCompatActivity() {
        super();
        this.initDelegate();
    }

    public AppCompatActivity(int arg1) {
        super(arg1);
        this.initDelegate();
    }

    public void addContentView(View arg1, ViewGroup$LayoutParams arg2) {
        this.initViewTreeOwners();
        this.getDelegate().addContentView(arg1, arg2);
    }

    protected void attachBaseContext(Context arg2) {
        super.attachBaseContext(this.getDelegate().attachBaseContext2(arg2));
    }

    public void closeOptionsMenu() {
        ActionBar v0 = this.getSupportActionBar();
        if((this.getWindow().hasFeature(0)) && (v0 == null || !v0.closeOptionsMenu())) {
            super.closeOptionsMenu();
        }
    }

    public boolean dispatchKeyEvent(KeyEvent arg4) {
        int v0 = arg4.getKeyCode();
        ActionBar v1 = this.getSupportActionBar();
        if(v0 == 82 && v1 != null && (v1.onMenuKeyEvent(arg4))) {
            return 1;
        }

        return super.dispatchKeyEvent(arg4);
    }

    public View findViewById(int arg1) {
        return this.getDelegate().findViewById(arg1);
    }

    public AppCompatDelegate getDelegate() {
        AppCompatDelegate v0 = this.mDelegate;
        if(v0 == null) {
            v0 = AppCompatDelegate.create(((Activity)this), ((AppCompatCallback)this));
            this.mDelegate = v0;
        }

        return v0;
    }

    public Delegate getDrawerToggleDelegate() {
        return this.getDelegate().getDrawerToggleDelegate();
    }

    public MenuInflater getMenuInflater() {
        return this.getDelegate().getMenuInflater();
    }

    public Resources getResources() {
        if(this.mResources == null && (VectorEnabledTintResources.shouldBeUsed())) {
            this.mResources = new VectorEnabledTintResources(((Context)this), super.getResources());
        }

        Resources v0 = this.mResources;
        if(v0 == null) {
            return super.getResources();
        }

        return v0;
    }

    public ActionBar getSupportActionBar() {
        return this.getDelegate().getSupportActionBar();
    }

    public Intent getSupportParentActivityIntent() {
        return NavUtils.getParentActivityIntent(((Activity)this));
    }

    private void initDelegate() {
        this.getSavedStateRegistry().registerSavedStateProvider("androidx:appcompat", new SavedStateProvider() {
            public Bundle saveState() {
                Bundle v0 = new Bundle();
                AppCompatActivity.this.getDelegate().onSaveInstanceState(v0);
                return v0;
            }
        });
        this.addOnContextAvailableListener(new OnContextAvailableListener() {
            public void onContextAvailable(Context arg2) {
                AppCompatDelegate v2 = AppCompatActivity.this.getDelegate();
                v2.installViewFactory();
                v2.onCreate(AppCompatActivity.this.getSavedStateRegistry().consumeRestoredStateForKey("androidx:appcompat"));
            }
        });
    }

    private void initViewTreeOwners() {
        ViewTreeLifecycleOwner.set(this.getWindow().getDecorView(), ((LifecycleOwner)this));
        ViewTreeViewModelStoreOwner.set(this.getWindow().getDecorView(), ((ViewModelStoreOwner)this));
        ViewTreeSavedStateRegistryOwner.set(this.getWindow().getDecorView(), ((SavedStateRegistryOwner)this));
        ViewTreeOnBackPressedDispatcherOwner.set(this.getWindow().getDecorView(), ((OnBackPressedDispatcherOwner)this));
    }

    public void invalidateOptionsMenu() {
        this.getDelegate().invalidateOptionsMenu();
    }

    public void onConfigurationChanged(Configuration arg2) {
        super.onConfigurationChanged(arg2);
        this.getDelegate().onConfigurationChanged(arg2);
        if(this.mResources != null) {
            this.mResources.updateConfiguration(super.getResources().getConfiguration(), super.getResources().getDisplayMetrics());
        }
    }

    public void onContentChanged() {
        this.onSupportContentChanged();
    }

    public void onCreateSupportNavigateUpTaskStack(TaskStackBuilder arg1) {
        arg1.addParentStack(((Activity)this));
    }

    protected void onDestroy() {
        super.onDestroy();
        this.getDelegate().onDestroy();
    }

    public boolean onKeyDown(int arg2, KeyEvent arg3) {
        if(this.performMenuItemShortcut(arg3)) {
            return 1;
        }

        return super.onKeyDown(arg2, arg3);
    }

    protected void onLocalesChanged(LocaleListCompat arg1) {
    }

    public final boolean onMenuItemSelected(int arg2, MenuItem arg3) {
        if(super.onMenuItemSelected(arg2, arg3)) {
            return 1;
        }

        ActionBar v2 = this.getSupportActionBar();
        if(arg3.getItemId() == 0x102002C && v2 != null && (v2.getDisplayOptions() & 4) != 0) {
            return this.onSupportNavigateUp();
        }

        return 0;
    }

    public boolean onMenuOpened(int arg1, Menu arg2) {
        return super.onMenuOpened(arg1, arg2);
    }

    protected void onNightModeChanged(int arg1) {
    }

    public void onPanelClosed(int arg1, Menu arg2) {
        super.onPanelClosed(arg1, arg2);
    }

    protected void onPostCreate(Bundle arg1) {
        super.onPostCreate(arg1);
        this.getDelegate().onPostCreate(arg1);
    }

    protected void onPostResume() {
        super.onPostResume();
        this.getDelegate().onPostResume();
    }

    public void onPrepareSupportNavigateUpTaskStack(TaskStackBuilder arg1) {
    }

    protected void onStart() {
        super.onStart();
        this.getDelegate().onStart();
    }

    protected void onStop() {
        super.onStop();
        this.getDelegate().onStop();
    }

    public void onSupportActionModeFinished(ActionMode arg1) {
    }

    public void onSupportActionModeStarted(ActionMode arg1) {
    }

    @Deprecated public void onSupportContentChanged() {
    }

    public boolean onSupportNavigateUp() {
        Intent v0 = this.getSupportParentActivityIntent();
        if(v0 != null) {
            if(this.supportShouldUpRecreateTask(v0)) {
                TaskStackBuilder v0_1 = TaskStackBuilder.create(((Context)this));
                this.onCreateSupportNavigateUpTaskStack(v0_1);
                this.onPrepareSupportNavigateUpTaskStack(v0_1);
                v0_1.startActivities();
                try {
                    ActivityCompat.finishAffinity(((Activity)this));
                }
                catch(IllegalStateException ) {
                    this.finish();
                }
            }
            else {
                this.supportNavigateUpTo(v0);
            }

            return 1;
        }

        return 0;
    }

    protected void onTitleChanged(CharSequence arg1, int arg2) {
        super.onTitleChanged(arg1, arg2);
        this.getDelegate().setTitle(arg1);
    }

    public ActionMode onWindowStartingSupportActionMode(Callback arg1) {
        return null;
    }

    public void openOptionsMenu() {
        ActionBar v0 = this.getSupportActionBar();
        if((this.getWindow().hasFeature(0)) && (v0 == null || !v0.openOptionsMenu())) {
            super.openOptionsMenu();
        }
    }

    private boolean performMenuItemShortcut(KeyEvent arg1) {
        return 0;
    }

    public void setContentView(int arg1) {
        this.initViewTreeOwners();
        this.getDelegate().setContentView(arg1);
    }

    public void setContentView(View arg1) {
        this.initViewTreeOwners();
        this.getDelegate().setContentView(arg1);
    }

    public void setContentView(View arg1, ViewGroup$LayoutParams arg2) {
        this.initViewTreeOwners();
        this.getDelegate().setContentView(arg1, arg2);
    }

    public void setSupportActionBar(Toolbar arg1) {
        this.getDelegate().setSupportActionBar(arg1);
    }

    @Deprecated public void setSupportProgress(int arg1) {
    }

    @Deprecated public void setSupportProgressBarIndeterminate(boolean arg1) {
    }

    @Deprecated public void setSupportProgressBarIndeterminateVisibility(boolean arg1) {
    }

    @Deprecated public void setSupportProgressBarVisibility(boolean arg1) {
    }

    public void setTheme(int arg1) {
        super.setTheme(arg1);
        this.getDelegate().setTheme(arg1);
    }

    public ActionMode startSupportActionMode(Callback arg1) {
        return this.getDelegate().startSupportActionMode(arg1);
    }

    public void supportInvalidateOptionsMenu() {
        this.getDelegate().invalidateOptionsMenu();
    }

    public void supportNavigateUpTo(Intent arg1) {
        NavUtils.navigateUpTo(((Activity)this), arg1);
    }

    public boolean supportRequestWindowFeature(int arg1) {
        return this.getDelegate().requestWindowFeature(arg1);
    }

    public boolean supportShouldUpRecreateTask(Intent arg1) {
        return NavUtils.shouldUpRecreateTask(((Activity)this), arg1);
    }
}

