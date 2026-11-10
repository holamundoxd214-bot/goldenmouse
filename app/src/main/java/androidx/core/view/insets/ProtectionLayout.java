package androidx.core.view.insets;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import android.widget.FrameLayout$LayoutParams;
import android.widget.FrameLayout;
import androidx.core.R$id;
import androidx.core.graphics.Insets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProtectionLayout extends FrameLayout {
    private static final Object PROTECTION_VIEW;
    private ProtectionGroup mGroup;
    private final List mProtections;

    static {
        ProtectionLayout.PROTECTION_VIEW = new Object();
    }

    public ProtectionLayout(Context arg1, List arg2) {
        super(arg1);
        this.mProtections = new ArrayList();
        this.setProtections(arg2);
    }

    public ProtectionLayout(Context arg1) {
        super(arg1);
        this.mProtections = new ArrayList();
    }

    public ProtectionLayout(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, 0);
    }

    public ProtectionLayout(Context arg2, AttributeSet arg3, int arg4) {
        this(arg2, arg3, arg4, 0);
    }

    public ProtectionLayout(Context arg1, AttributeSet arg2, int arg3, int arg4) {
        super(arg1, arg2, arg3, arg4);
        this.mProtections = new ArrayList();
    }

    private void addProtectionView(Context arg7, int arg8, Protection arg9) {
        int v9;
        Attributes v0 = arg9.getAttributes();
        int v1 = arg9.getSide();
        int v3 = 8;
        int v4 = -1;
        if(v1 == 1) {
            v9 = v0.getWidth();
            v1 = 3;
        label_31:
            int v5 = v4;
            v4 = v9;
            v9 = v5;
        }
        else if(v1 == 2) {
            v9 = v0.getHeight();
            v1 = 0x30;
        }
        else if(v1 == 4) {
            v9 = v0.getWidth();
            v1 = 5;
            goto label_31;
        }
        else if(v1 == v3) {
            v9 = v0.getHeight();
            v1 = 80;
        }
        else {
            throw new IllegalArgumentException("Unexpected side: " + arg9.getSide());
        }

        FrameLayout$LayoutParams v2 = new FrameLayout$LayoutParams(v4, v9, v1);
        Insets v9_1 = v0.getMargin();
        v2.leftMargin = v9_1.left;
        v2.topMargin = v9_1.top;
        v2.rightMargin = v9_1.right;
        v2.bottomMargin = v9_1.bottom;
        View v9_2 = new View(arg7);
        v9_2.setTag(ProtectionLayout.PROTECTION_VIEW);
        v9_2.setTranslationX(v0.getTranslationX());
        v9_2.setTranslationY(v0.getTranslationY());
        v9_2.setAlpha(v0.getAlpha());
        if(v0.isVisible()) {
            v3 = 0;
        }

        v9_2.setVisibility(v3);
        v9_2.setBackground(v0.getDrawable());
        v0.setCallback(new Callback(v2, v9_2) {
            public void onAlphaChanged(float arg1) {
                this.val$view.setAlpha(arg1);
            }

            public void onDrawableChanged(Drawable arg1) {
                this.val$view.setBackground(arg1);
            }

            public void onHeightChanged(int arg2) {
                this.val$params.height = arg2;
                this.val$view.setLayoutParams(this.val$params);
            }

            public void onMarginChanged(Insets arg3) {
                this.val$params.leftMargin = arg3.left;
                this.val$params.topMargin = arg3.top;
                this.val$params.rightMargin = arg3.right;
                this.val$params.bottomMargin = arg3.bottom;
                this.val$view.setLayoutParams(this.val$params);
            }

            public void onTranslationXChanged(float arg1) {
                this.val$view.setTranslationX(arg1);
            }

            public void onTranslationYChanged(float arg1) {
                this.val$view.setTranslationY(arg1);
            }

            public void onVisibilityChanged(boolean arg1) {
                View v0 = this.val$view;
                int v1 = arg1 ? 0 : 8;
                v0.setVisibility(v1);
            }

            public void onWidthChanged(int arg2) {
                this.val$params.width = arg2;
                this.val$view.setLayoutParams(this.val$params);
            }
        });
        this.addView(v9_2, arg8, ((ViewGroup$LayoutParams)v2));
    }

    private void addProtectionViews() {
        if(this.mProtections.isEmpty()) {
            this.removeProtectionViews();
            return;
        }

        SystemBarStateMonitor v0 = this.getOrInstallSystemBarStateMonitor();
        this.removeProtectionViews();
        this.mGroup = new ProtectionGroup(v0, this.mProtections);
        int v0_1 = this.getChildCount();
        int v1 = this.mGroup.size();
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            this.addProtectionView(this.getContext(), v2 + v0_1, this.mGroup.getProtection(v2));
        }
    }

    public void addView(View arg3, int arg4, ViewGroup$LayoutParams arg5) {
        if(arg3 != null && arg3.getTag() != ProtectionLayout.PROTECTION_VIEW) {
            ProtectionGroup v0 = this.mGroup;
            int v0_1 = v0 != null ? v0.size() : 0;
            int v1 = this.getChildCount() - v0_1;
            if(arg4 <= v1 && arg4 >= 0) {
                goto label_14;
            }

            arg4 = v1;
        }

    label_14:
        super.addView(arg3, arg4, arg5);
    }

    private SystemBarStateMonitor getOrInstallSystemBarStateMonitor() {
        View v2 = this.getRootView();
        Object v0 = ((ViewGroup)v2).getTag(id.tag_system_bar_state_monitor);
        if((v0 instanceof SystemBarStateMonitor)) {
            return ((SystemBarStateMonitor)v0);
        }

        SystemBarStateMonitor v0_1 = new SystemBarStateMonitor(((ViewGroup)v2));
        ((ViewGroup)v2).setTag(id.tag_system_bar_state_monitor, v0_1);
        return v0_1;
    }

    private void maybeUninstallSystemBarStateMonitor() {
        View v2 = this.getRootView();
        Object v0 = ((ViewGroup)v2).getTag(id.tag_system_bar_state_monitor);
        if(!(v0 instanceof SystemBarStateMonitor)) {
        }
        else {
            if(((SystemBarStateMonitor)v0).hasCallback()) {
                return;
            }

            goto label_9;
        }

        return;
    label_9:
        ((SystemBarStateMonitor)v0).detachFromWindow();
        ((ViewGroup)v2).setTag(id.tag_system_bar_state_monitor, null);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.addProtectionViews();
        this.requestApplyInsets();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.removeProtectionViews();
        this.maybeUninstallSystemBarStateMonitor();
    }

    private void removeProtectionViews() {
        Callback v3;
        ProtectionGroup v2;
        if(this.mGroup != null) {
            this.removeViews(this.getChildCount() - this.mGroup.size(), this.mGroup.size());
            int v0 = this.mGroup.size();
            int v1;
            for(v1 = 0; true; ++v1) {
                v2 = this.mGroup;
                v3 = null;
                if(v1 >= v0) {
                    break;
                }

                v2.getProtection(v1).getAttributes().setCallback(v3);
            }

            v2.dispose();
            this.mGroup = ((ProtectionGroup)v3);
        }
    }

    public void setProtections(List arg2) {
        this.mProtections.clear();
        this.mProtections.addAll(((Collection)arg2));
        if(this.isAttachedToWindow()) {
            this.addProtectionViews();
            this.requestApplyInsets();
        }
    }
}

