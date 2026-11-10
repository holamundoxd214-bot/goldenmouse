package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$animator;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.animation.Positioning;
import java.util.HashMap;
import java.util.Map;

@Deprecated public class FabTransformationSheetBehavior extends FabTransformationBehavior {
    private Map importantForAccessibilityMap;

    public FabTransformationSheetBehavior() {
        super();
    }

    public FabTransformationSheetBehavior(Context arg1, AttributeSet arg2) {
        super(arg1, arg2);
    }

    protected FabTransformationSpec onCreateMotionSpec(Context arg2, boolean arg3) {
        int v1 = arg3 ? animator.mtrl_fab_transformation_sheet_expand_spec : animator.mtrl_fab_transformation_sheet_collapse_spec;
        FabTransformationSpec v3 = new FabTransformationSpec();
        v3.timings = MotionSpec.createFromResource(arg2, v1);
        v3.positioning = new Positioning(17, 0f, 0f);
        return v3;
    }

    protected boolean onExpandedStateChange(View arg1, View arg2, boolean arg3, boolean arg4) {
        this.updateImportantForAccessibility(arg2, arg3);
        return super.onExpandedStateChange(arg1, arg2, arg3, arg4);
    }

    private void updateImportantForAccessibility(View arg8, boolean arg9) {
        ViewParent v0 = arg8.getParent();
        if(!(v0 instanceof CoordinatorLayout)) {
        }
        else {
            int v1 = ((CoordinatorLayout)v0).getChildCount();
            if(arg9) {
                this.importantForAccessibilityMap = new HashMap(v1);
            }

            int v3;
            for(v3 = 0; v3 < v1; ++v3) {
                View v4 = ((CoordinatorLayout)v0).getChildAt(v3);
                int v5 = !(v4.getLayoutParams() instanceof LayoutParams) || !(v4.getLayoutParams().getBehavior() instanceof FabTransformationScrimBehavior) ? 0 : 1;
                if(v4 != arg8) {
                    if(v5 != 0) {
                    }
                    else {
                        Map v5_1 = this.importantForAccessibilityMap;
                        if(arg9) {
                            v5_1.put(v4, Integer.valueOf(v4.getImportantForAccessibility()));
                            ViewCompat.setImportantForAccessibility(v4, 4);
                        }
                        else if(v5_1 != null && (v5_1.containsKey(v4))) {
                            ViewCompat.setImportantForAccessibility(v4, this.importantForAccessibilityMap.get(v4).intValue());
                        }
                    }
                }
            }

            if(arg9) {
                return;
            }

            this.importantForAccessibilityMap = null;
        }
    }
}

