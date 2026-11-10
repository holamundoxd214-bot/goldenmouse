package androidx.appcompat.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.TypedValue;
import android.view.MenuItem$OnMenuItemClickListener;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$string;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ActionProvider;

public class ShareActionProvider extends ActionProvider {
    public interface OnShareTargetSelectedListener {
        boolean onShareTargetSelected(ShareActionProvider arg1, Intent arg2);
    }

    class ShareActivityChooserModelPolicy implements OnChooseActivityListener {
        ShareActivityChooserModelPolicy(ShareActionProvider arg1) {
            ShareActionProvider.this = arg1;
            super();
        }

        public boolean onChooseActivity(ActivityChooserModel arg1, Intent arg2) {
            if(ShareActionProvider.this.mOnShareTargetSelectedListener != null) {
                ShareActionProvider.this.mOnShareTargetSelectedListener.onShareTargetSelected(ShareActionProvider.this, arg2);
            }

            return 0;
        }
    }

    class ShareMenuItemOnMenuItemClickListener implements MenuItem$OnMenuItemClickListener {
        ShareMenuItemOnMenuItemClickListener(ShareActionProvider arg1) {
            ShareActionProvider.this = arg1;
            super();
        }

        public boolean onMenuItemClick(MenuItem arg3) {
            Intent v3 = ActivityChooserModel.get(ShareActionProvider.this.mContext, ShareActionProvider.this.mShareHistoryFileName).chooseActivity(arg3.getItemId());
            if(v3 != null) {
                String v0 = v3.getAction();
                if(("android.intent.action.SEND".equals(v0)) || ("android.intent.action.SEND_MULTIPLE".equals(v0))) {
                    ShareActionProvider.this.updateIntent(v3);
                }

                ShareActionProvider.this.mContext.startActivity(v3);
            }

            return 1;
        }
    }

    private static final int DEFAULT_INITIAL_ACTIVITY_COUNT = 4;
    public static final String DEFAULT_SHARE_HISTORY_FILE_NAME = "share_history.xml";
    final Context mContext;
    private int mMaxShownActivityCount;
    private OnChooseActivityListener mOnChooseActivityListener;
    private final ShareMenuItemOnMenuItemClickListener mOnMenuItemClickListener;
    OnShareTargetSelectedListener mOnShareTargetSelectedListener;
    String mShareHistoryFileName;

    public ShareActionProvider(Context arg2) {
        super(arg2);
        this.mMaxShownActivityCount = 4;
        this.mOnMenuItemClickListener = new ShareMenuItemOnMenuItemClickListener(this);
        this.mShareHistoryFileName = "share_history.xml";
        this.mContext = arg2;
    }

    public boolean hasSubMenu() {
        return 1;
    }

    public View onCreateActionView() {
        ActivityChooserView v0 = new ActivityChooserView(this.mContext);
        if(!v0.isInEditMode()) {
            v0.setActivityChooserModel(ActivityChooserModel.get(this.mContext, this.mShareHistoryFileName));
        }

        TypedValue v1 = new TypedValue();
        this.mContext.getTheme().resolveAttribute(attr.actionModeShareDrawable, v1, true);
        v0.setExpandActivityOverflowButtonDrawable(AppCompatResources.getDrawable(this.mContext, v1.resourceId));
        v0.setProvider(((ActionProvider)this));
        v0.setDefaultActionButtonContentDescription(string.abc_shareactionprovider_share_with_application);
        v0.setExpandActivityOverflowButtonContentDescription(string.abc_shareactionprovider_share_with);
        return ((View)v0);
    }

    public void onPrepareSubMenu(SubMenu arg9) {
        arg9.clear();
        ActivityChooserModel v0 = ActivityChooserModel.get(this.mContext, this.mShareHistoryFileName);
        PackageManager v1 = this.mContext.getPackageManager();
        int v2 = v0.getActivityCount();
        int v3 = Math.min(v2, this.mMaxShownActivityCount);
        int v5;
        for(v5 = 0; v5 < v3; ++v5) {
            ResolveInfo v6 = v0.getActivity(v5);
            arg9.add(0, v5, v5, v6.loadLabel(v1)).setIcon(v6.loadIcon(v1)).setOnMenuItemClickListener(this.mOnMenuItemClickListener);
        }

        if(v3 < v2) {
            arg9 = arg9.addSubMenu(0, v3, v3, this.mContext.getString(string.abc_activity_chooser_view_see_all));
            for(v3 = 0; v3 < v2; ++v3) {
                ResolveInfo v5_1 = v0.getActivity(v3);
                arg9.add(0, v3, v3, v5_1.loadLabel(v1)).setIcon(v5_1.loadIcon(v1)).setOnMenuItemClickListener(this.mOnMenuItemClickListener);
            }
        }
    }

    private void setActivityChooserPolicyIfNeeded() {
        if(this.mOnShareTargetSelectedListener == null) {
            return;
        }

        if(this.mOnChooseActivityListener == null) {
            this.mOnChooseActivityListener = new ShareActivityChooserModelPolicy(this);
        }

        ActivityChooserModel.get(this.mContext, this.mShareHistoryFileName).setOnChooseActivityListener(this.mOnChooseActivityListener);
    }

    public void setOnShareTargetSelectedListener(OnShareTargetSelectedListener arg1) {
        this.mOnShareTargetSelectedListener = arg1;
        this.setActivityChooserPolicyIfNeeded();
    }

    public void setShareHistoryFileName(String arg1) {
        this.mShareHistoryFileName = arg1;
        this.setActivityChooserPolicyIfNeeded();
    }

    public void setShareIntent(Intent arg3) {
        if(arg3 != null) {
            String v0 = arg3.getAction();
            if(!"android.intent.action.SEND".equals(v0) && !"android.intent.action.SEND_MULTIPLE".equals(v0)) {
                goto label_9;
            }

            this.updateIntent(arg3);
        }

    label_9:
        ActivityChooserModel.get(this.mContext, this.mShareHistoryFileName).setIntent(arg3);
    }

    void updateIntent(Intent arg1) {
        arg1.addFlags(0x8080000);
    }
}

