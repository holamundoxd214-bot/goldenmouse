package androidx.appcompat.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources$Theme;
import android.content.res.Resources;
import android.view.LayoutInflater;
import androidx.appcompat.R$style;

public class ContextThemeWrapper extends ContextWrapper {
    class Api17Impl {
        private Api17Impl() {
            super();
        }

        static Context createConfigurationContext(ContextThemeWrapper arg0, Configuration arg1) {
            return arg0.createConfigurationContext(arg1);
        }
    }

    private LayoutInflater mInflater;
    private Configuration mOverrideConfiguration;
    private Resources mResources;
    private Resources$Theme mTheme;
    private int mThemeResource;
    private static Configuration sEmptyConfig;

    public ContextThemeWrapper(Context arg1, int arg2) {
        super(arg1);
        this.mThemeResource = arg2;
    }

    public ContextThemeWrapper() {
        super(null);
    }

    public ContextThemeWrapper(Context arg1, Resources$Theme arg2) {
        super(arg1);
        this.mTheme = arg2;
    }

    public void applyOverrideConfiguration(Configuration arg2) {
        if(this.mResources == null) {
            if(this.mOverrideConfiguration == null) {
                this.mOverrideConfiguration = new Configuration(arg2);
                return;
            }

            throw new IllegalStateException("Override configuration has already been set");
        }

        throw new IllegalStateException("getResources() or getAssets() has already been called");
    }

    protected void attachBaseContext(Context arg1) {
        super.attachBaseContext(arg1);
    }

    public AssetManager getAssets() {
        return this.getResources().getAssets();
    }

    public Resources getResources() {
        return this.getResourcesInternal();
    }

    private Resources getResourcesInternal() {
        Resources v0 = this.mResources;
        if(v0 == null) {
            if(this.mOverrideConfiguration != null) {
                if(ContextThemeWrapper.isEmptyConfiguration(this.mOverrideConfiguration)) {
                }
                else {
                    v0 = Api17Impl.createConfigurationContext(this, this.mOverrideConfiguration).getResources();
                    this.mResources = v0;
                    return v0;
                }
            }

            v0 = super.getResources();
            this.mResources = v0;
        }

        return v0;
    }

    public Object getSystemService(String arg2) {
        if("layout_inflater".equals(arg2)) {
            LayoutInflater v2 = this.mInflater;
            if(v2 == null) {
                v2 = LayoutInflater.from(this.getBaseContext()).cloneInContext(((Context)this));
                this.mInflater = v2;
            }

            return v2;
        }

        return this.getBaseContext().getSystemService(arg2);
    }

    public Resources$Theme getTheme() {
        Resources$Theme v0 = this.mTheme;
        if(v0 != null) {
            return v0;
        }

        if(this.mThemeResource == 0) {
            this.mThemeResource = style.Theme_AppCompat_Light;
        }

        this.initializeTheme();
        return this.mTheme;
    }

    public int getThemeResId() {
        return this.mThemeResource;
    }

    private void initializeTheme() {
        boolean v0 = this.mTheme == null ? true : false;
        if(v0) {
            this.mTheme = this.getResources().newTheme();
            Resources$Theme v1 = this.getBaseContext().getTheme();
            if(v1 != null) {
                this.mTheme.setTo(v1);
            }
        }

        this.onApplyThemeResource(this.mTheme, this.mThemeResource, v0);
    }

    private static boolean isEmptyConfiguration(Configuration arg2) {
        if(arg2 == null) {
            return 1;
        }

        Configuration v0 = ContextThemeWrapper.sEmptyConfig;
        if(v0 == null) {
            v0 = new Configuration();
            v0.fontScale = 0f;
            ContextThemeWrapper.sEmptyConfig = v0;
        }

        return arg2.equals(v0);
    }

    protected void onApplyThemeResource(Resources$Theme arg1, int arg2, boolean arg3) {
        arg1.applyStyle(arg2, true);
    }

    public void setTheme(int arg2) {
        if(this.mThemeResource != arg2) {
            this.mThemeResource = arg2;
            this.initializeTheme();
        }
    }
}

