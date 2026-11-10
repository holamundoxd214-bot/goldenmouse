package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources$NotFoundException;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewParent;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import java.util.Arrays;
import java.util.HashMap;

public abstract class ConstraintHelper extends View {
    protected int mCount;
    protected Helper mHelperWidget;
    protected int[] mIds;
    private HashMap mMap;
    protected String mReferenceIds;
    protected boolean mUseViewMeasure;
    private View[] mViews;
    protected Context myContext;

    public ConstraintHelper(Context arg3) {
        super(arg3);
        this.mIds = new int[0x20];
        this.mUseViewMeasure = false;
        this.mViews = null;
        this.mMap = new HashMap();
        this.myContext = arg3;
        this.init(null);
    }

    public ConstraintHelper(Context arg2, AttributeSet arg3) {
        super(arg2, arg3);
        this.mIds = new int[0x20];
        this.mUseViewMeasure = false;
        this.mViews = null;
        this.mMap = new HashMap();
        this.myContext = arg2;
        this.init(arg3);
    }

    public ConstraintHelper(Context arg1, AttributeSet arg2, int arg3) {
        super(arg1, arg2, arg3);
        this.mIds = new int[0x20];
        this.mUseViewMeasure = false;
        this.mViews = null;
        this.mMap = new HashMap();
        this.myContext = arg1;
        this.init(arg2);
    }

    private void addID(String arg4) {
        if(arg4 != null) {
            if(arg4.length() == 0) {
            }
            else if(this.myContext == null) {
            }
            else {
                arg4 = arg4.trim();
                if((this.getParent() instanceof ConstraintLayout)) {
                    this.getParent();
                }

                int v0 = this.findId(arg4);
                if(v0 != 0) {
                    this.mMap.put(Integer.valueOf(v0), arg4);
                    this.addRscID(v0);
                    return;
                }

                Log.w("ConstraintHelper", "Could not find id of \"" + arg4 + "\"");
            }
        }
    }

    private void addRscID(int arg4) {
        if(arg4 == this.getId()) {
            return;
        }

        int v0 = this.mCount + 1;
        int[] v1 = this.mIds;
        if(v0 > v1.length) {
            v1 = Arrays.copyOf(v1, v1.length * 2);
            this.mIds = v1;
        }

        v0 = this.mCount;
        v1[v0] = arg4;
        this.mCount = v0 + 1;
    }

    public void addView(View arg4) {
        if((((ConstraintHelper)arg4)) == this) {
            return;
        }

        String v2 = "ConstraintHelper";
        if(arg4.getId() == -1) {
            Log.e(v2, "Views added to a ConstraintHelper need to have an id");
            return;
        }

        if(arg4.getParent() == null) {
            Log.e(v2, "Views added to a ConstraintHelper need to have a parent");
            return;
        }

        this.mReferenceIds = null;
        this.addRscID(arg4.getId());
        this.requestLayout();
    }

    protected void applyLayoutFeatures() {
        ViewParent v0 = this.getParent();
        if(v0 != null && ((v0 instanceof ConstraintLayout))) {
            this.applyLayoutFeatures(((ConstraintLayout)v0));
        }
    }

    protected void applyLayoutFeatures(ConstraintLayout arg6) {
        int v0 = this.getVisibility();
        float v1 = this.getElevation();
        int v2;
        for(v2 = 0; v2 < this.mCount; ++v2) {
            View v3 = arg6.getViewById(this.mIds[v2]);
            if(v3 != null) {
                v3.setVisibility(v0);
                if(v1 > 0f) {
                    v3.setTranslationZ(v3.getTranslationZ() + v1);
                }
            }
        }
    }

    private int[] convertReferenceString(View arg5, String arg6) {
        String[] v6 = arg6.split(",");
        arg5.getContext();
        int[] v5 = new int[v6.length];
        int v0 = 0;
        int v1 = 0;
        while(v0 < v6.length) {
            int v2 = this.findId(v6[v0].trim());
            if(v2 != 0) {
                v5[v1] = v2;
                ++v1;
            }

            ++v0;
        }

        if(v1 != v6.length) {
            return Arrays.copyOf(v5, v1);
        }

        return v5;
    }

    private int findId(String arg6) {
        Object v1 = null;
        ViewParent v0 = (this.getParent() instanceof ConstraintLayout) ? this.getParent() : ((ViewParent)v1);
        int v3 = 0;
        if((this.isInEditMode()) && v0 != null) {
            Object v2 = ((ConstraintLayout)v0).getDesignInformation(0, arg6);
            if((v2 instanceof Integer)) {
                v3 = ((Integer)v2).intValue();
            }
        }

        if(v3 == 0 && v0 != null) {
            v3 = this.findId(((ConstraintLayout)v0), arg6);
        }

        if(v3 == 0) {
            try {
                v3 = id.class.getField(arg6).getInt(v1);
                goto label_22;
            }
            catch(Exception ) {
            label_22:
                if(v3 == 0) {
                    v3 = this.myContext.getResources().getIdentifier(arg6, "id", this.myContext.getPackageName());
                }

                return v3;
            }
        }

        goto label_22;
    }

    private int findId(ConstraintLayout arg7, String arg8) {
        if(arg8 != null && arg7 != null) {
            Resources v6 = this.myContext.getResources();
            if(v6 == null) {
                return 0;
            }

            int v1 = arg7.getChildCount();
            int v2;
            for(v2 = 0; v2 < v1; ++v2) {
                View v3 = arg7.getChildAt(v2);
                if(v3.getId() != -1) {
                    try {
                        String v4 = v6.getResourceEntryName(v3.getId());
                    }
                    catch(Resources$NotFoundException ) {
                        Object v4_1 = null;
                    }

                    if(!arg8.equals(v4_1)) {
                        goto label_23;
                    }

                    return v3.getId();
                }

            label_23:
            }
        }

        return 0;
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.mIds, this.mCount);
    }

    protected View[] getViews(ConstraintLayout arg4) {
        View[] v0 = this.mViews;
        if(v0 == null || v0.length != this.mCount) {
            this.mViews = new View[this.mCount];
        }

        int v0_1;
        for(v0_1 = 0; v0_1 < this.mCount; ++v0_1) {
            this.mViews[v0_1] = arg4.getViewById(this.mIds[v0_1]);
        }

        return this.mViews;
    }

    protected void init(AttributeSet arg5) {
        if(arg5 != null) {
            TypedArray v5 = this.getContext().obtainStyledAttributes(arg5, styleable.ConstraintLayout_Layout);
            int v0 = v5.getIndexCount();
            int v1;
            for(v1 = 0; v1 < v0; ++v1) {
                int v2 = v5.getIndex(v1);
                if(v2 == styleable.ConstraintLayout_Layout_constraint_referenced_ids) {
                    String v2_1 = v5.getString(v2);
                    this.mReferenceIds = v2_1;
                    this.setIds(v2_1);
                }
            }
        }
    }

    public void loadParameters(Constraint arg2, HelperWidget arg3, LayoutParams arg4, SparseArray arg5) {
        if(arg2.layout.mReferenceIds != null) {
            this.setReferencedIds(arg2.layout.mReferenceIds);
        }
        else if(arg2.layout.mReferenceIdString != null && arg2.layout.mReferenceIdString.length() > 0) {
            arg2.layout.mReferenceIds = this.convertReferenceString(((View)this), arg2.layout.mReferenceIdString);
        }

        arg3.removeAllIds();
        if(arg2.layout.mReferenceIds != null) {
            int v1;
            for(v1 = 0; v1 < arg2.layout.mReferenceIds.length; ++v1) {
                Object v4 = arg5.get(arg2.layout.mReferenceIds[v1]);
                if(v4 != null) {
                    arg3.add(((ConstraintWidget)v4));
                }
            }
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        String v0 = this.mReferenceIds;
        if(v0 != null) {
            this.setIds(v0);
        }
    }

    public void onDraw(Canvas arg1) {
    }

    protected void onMeasure(int arg2, int arg3) {
        if(this.mUseViewMeasure) {
            super.onMeasure(arg2, arg3);
            return;
        }

        this.setMeasuredDimension(0, 0);
    }

    public void removeView(View arg5) {
        int[] v3;
        int v5 = arg5.getId();
        if(v5 == -1) {
            return;
        }

        this.mReferenceIds = null;
        int v1 = 0;
        while(true) {
            if(v1 < this.mCount) {
                if(this.mIds[v1] != v5) {
                    ++v1;
                    continue;
                }

                break;
            }

            goto label_29;
        }

        while(true) {
            v5 = this.mCount;
            v3 = this.mIds;
            if(v1 >= v5 - 1) {
                break;
            }

            v5 = v1 + 1;
            v3[v1] = v3[v5];
            v1 = v5;
        }

        v3[v5 - 1] = 0;
        this.mCount = v5 - 1;
    label_29:
        this.requestLayout();
    }

    public void resolveRtl(ConstraintWidget arg1, boolean arg2) {
    }

    protected void setIds(String arg4) {
        this.mReferenceIds = arg4;
        if(arg4 == null) {
            return;
        }

        int v0 = 0;
        this.mCount = 0;
        while(true) {
            int v1 = arg4.indexOf(44, v0);
            if(v1 == -1) {
                break;
            }

            this.addID(arg4.substring(v0, v1));
            v0 = v1 + 1;
        }

        this.addID(arg4.substring(v0));
    }

    public void setReferencedIds(int[] arg3) {
        this.mReferenceIds = null;
        int v0 = 0;
        this.mCount = 0;
        while(v0 < arg3.length) {
            this.addRscID(arg3[v0]);
            ++v0;
        }
    }

    public void updatePostConstraints(ConstraintLayout arg1) {
    }

    public void updatePostLayout(ConstraintLayout arg1) {
    }

    public void updatePostMeasure(ConstraintLayout arg1) {
    }

    public void updatePreDraw(ConstraintLayout arg1) {
    }

    public void updatePreLayout(ConstraintWidgetContainer arg2, Helper arg3, SparseArray arg4) {
        arg3.removeAllIds();
        int v2;
        for(v2 = 0; v2 < this.mCount; ++v2) {
            arg3.add(arg4.get(this.mIds[v2]));
        }
    }

    public void updatePreLayout(ConstraintLayout arg6) {
        if(this.isInEditMode()) {
            this.setIds(this.mReferenceIds);
        }

        Helper v0 = this.mHelperWidget;
        if(v0 == null) {
            return;
        }

        v0.removeAllIds();
        int v0_1;
        for(v0_1 = 0; v0_1 < this.mCount; ++v0_1) {
            int v1 = this.mIds[v0_1];
            View v2 = arg6.getViewById(v1);
            if(v2 == null) {
                Object v1_1 = this.mMap.get(Integer.valueOf(v1));
                int v3 = this.findId(arg6, ((String)v1_1));
                if(v3 != 0) {
                    this.mIds[v0_1] = v3;
                    this.mMap.put(Integer.valueOf(v3), v1_1);
                    v2 = arg6.getViewById(v3);
                }
            }

            if(v2 != null) {
                this.mHelperWidget.add(arg6.getViewWidget(v2));
            }
        }

        this.mHelperWidget.updateConstraints(arg6.mLayoutWidget);
    }

    public void validateParams() {
        if(this.mHelperWidget == null) {
        }
        else {
            ViewGroup$LayoutParams v0 = this.getLayoutParams();
            if((v0 instanceof LayoutParams)) {
                ((LayoutParams)v0).widget = this.mHelperWidget;
            }
        }
    }
}

