package androidx.appcompat.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$bool;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$styleable;

public class ActionBarPolicy {
    private Context mContext;

    private ActionBarPolicy(Context arg1) {
        super();
        this.mContext = arg1;
    }

    public boolean enableHomeButtonByDefault() {
        if(this.mContext.getApplicationInfo().targetSdkVersion < 14) {
            return 1;
        }

        return 0;
    }

    public static ActionBarPolicy get(Context arg1) {
        return new ActionBarPolicy(arg1);
    }

    public int getEmbeddedMenuWidthLimit() {
        return this.mContext.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public int getMaxActionButtons() {
        Configuration v3 = this.mContext.getResources().getConfiguration();
        int v0 = v3.screenWidthDp;
        int v1 = v3.screenHeightDp;
        int v2 = 600;
        if(v3.smallestScreenWidthDp <= v2 && v0 <= v2) {
            int v3_1 = 720;
            v2 = 960;
            if(v0 > v2 && v1 > v3_1) {
                return 5;
            }

            if(v0 > v3_1 && v1 > v2) {
                return 5;
            }

            if(v0 < 500) {
                v3_1 = 480;
                v2 = 640;
                if(v0 > v2 && v1 > v3_1) {
                    return 4;
                }

                if(v0 > v3_1 && v1 > v2) {
                    return 4;
                }

                if(v0 >= 360) {
                    return 3;
                }

                return 2;
            }

            return 4;
        }

        return 5;
    }

    public int getStackedTabMaxWidth() {
        return this.mContext.getResources().getDimensionPixelSize(dimen.abc_action_bar_stacked_tab_max_width);
    }

    public int getTabContainerHeight() {
        TypedArray v0 = this.mContext.obtainStyledAttributes(null, styleable.ActionBar, attr.actionBarStyle, 0);
        int v1 = v0.getLayoutDimension(styleable.ActionBar_height, 0);
        Resources v2 = this.mContext.getResources();
        if(!this.hasEmbeddedTabs()) {
            v1 = Math.min(v1, v2.getDimensionPixelSize(dimen.abc_action_bar_stacked_max_height));
        }

        v0.recycle();
        return v1;
    }

    public boolean hasEmbeddedTabs() {
        return this.mContext.getResources().getBoolean(bool.abc_action_bar_embed_tabs);
    }

    public boolean showsOverflowMenuButton() {
        return 1;
    }
}

