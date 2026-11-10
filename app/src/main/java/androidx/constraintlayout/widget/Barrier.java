package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.HelperWidget;

public class Barrier extends ConstraintHelper {
    public static final int BOTTOM = 3;
    public static final int END = 6;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int START = 5;
    public static final int TOP = 2;
    private androidx.constraintlayout.solver.widgets.Barrier mBarrier;
    private int mIndicatedType;
    private int mResolvedType;

    public Barrier(Context arg1) {
        super(arg1);
        super.setVisibility(8);
    }

    public Barrier(Context arg1, AttributeSet arg2) {
        super(arg1, arg2);
        super.setVisibility(8);
    }

    public Barrier(Context arg1, AttributeSet arg2, int arg3) {
        super(arg1, arg2, arg3);
        super.setVisibility(8);
    }

    public boolean allowsGoneWidget() {
        return this.mBarrier.allowsGoneWidget();
    }

    public int getMargin() {
        return this.mBarrier.getMargin();
    }

    public int getType() {
        return this.mIndicatedType;
    }

    protected void init(AttributeSet arg7) {
        super.init(arg7);
        this.mBarrier = new androidx.constraintlayout.solver.widgets.Barrier();
        if(arg7 != null) {
            TypedArray v7 = this.getContext().obtainStyledAttributes(arg7, styleable.ConstraintLayout_Layout);
            int v0 = v7.getIndexCount();
            int v2;
            for(v2 = 0; v2 < v0; ++v2) {
                int v3 = v7.getIndex(v2);
                if(v3 == styleable.ConstraintLayout_Layout_barrierDirection) {
                    this.setType(v7.getInt(v3, 0));
                }
                else if(v3 == styleable.ConstraintLayout_Layout_barrierAllowsGoneWidgets) {
                    this.mBarrier.setAllowsGoneWidget(v7.getBoolean(v3, true));
                }
                else if(v3 == styleable.ConstraintLayout_Layout_barrierMargin) {
                    this.mBarrier.setMargin(v7.getDimensionPixelSize(v3, 0));
                }
            }
        }

        this.mHelperWidget = this.mBarrier;
        this.validateParams();
    }

    public void loadParameters(Constraint arg1, HelperWidget arg2, LayoutParams arg3, SparseArray arg4) {
        super.loadParameters(arg1, arg2, arg3, arg4);
        if((arg2 instanceof androidx.constraintlayout.solver.widgets.Barrier)) {
            this.updateType(arg2, arg1.layout.mBarrierDirection, arg2.getParent().isRtl());
            arg2.setAllowsGoneWidget(arg1.layout.mBarrierAllowsGoneWidgets);
            arg2.setMargin(arg1.layout.mBarrierMargin);
        }
    }

    public void resolveRtl(ConstraintWidget arg2, boolean arg3) {
        this.updateType(arg2, this.mIndicatedType, arg3);
    }

    public void setAllowsGoneWidget(boolean arg1) {
        this.mBarrier.setAllowsGoneWidget(arg1);
    }

    public void setDpMargin(int arg2) {
        this.mBarrier.setMargin(((int)((((float)arg2)) * this.getResources().getDisplayMetrics().density + 0.5f)));
    }

    public void setMargin(int arg1) {
        this.mBarrier.setMargin(arg1);
    }

    public void setType(int arg1) {
        this.mIndicatedType = arg1;
    }

    private void updateType(ConstraintWidget arg5, int arg6, boolean arg7) {
        this.mResolvedType = arg6;
        arg6 = this.mIndicatedType;
        int v2 = 6;
        int v3 = 5;
        if(arg7) {
            if(arg6 == v3) {
                this.mResolvedType = 1;
            }
            else if(arg6 == v2) {
                this.mResolvedType = 0;
            }
        }
        else if(arg6 == v3) {
            this.mResolvedType = 0;
        }
        else if(arg6 == v2) {
            this.mResolvedType = 1;
        }

        if((arg5 instanceof androidx.constraintlayout.solver.widgets.Barrier)) {
            ((androidx.constraintlayout.solver.widgets.Barrier)arg5).setBarrierType(this.mResolvedType);
        }
    }
}

