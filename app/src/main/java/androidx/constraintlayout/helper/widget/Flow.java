package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View$MeasureSpec;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import androidx.constraintlayout.widget.ConstraintLayout$LayoutParams;
import androidx.constraintlayout.widget.ConstraintSet$Constraint;
import androidx.constraintlayout.widget.R$styleable;
import androidx.constraintlayout.widget.VirtualLayout;

public class Flow extends VirtualLayout {
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static final int HORIZONTAL = 0;
    public static final int HORIZONTAL_ALIGN_CENTER = 2;
    public static final int HORIZONTAL_ALIGN_END = 1;
    public static final int HORIZONTAL_ALIGN_START = 0;
    private static final String TAG = "Flow";
    public static final int VERTICAL = 1;
    public static final int VERTICAL_ALIGN_BASELINE = 3;
    public static final int VERTICAL_ALIGN_BOTTOM = 1;
    public static final int VERTICAL_ALIGN_CENTER = 2;
    public static final int VERTICAL_ALIGN_TOP = 0;
    public static final int WRAP_ALIGNED = 2;
    public static final int WRAP_CHAIN = 1;
    public static final int WRAP_NONE;
    private androidx.constraintlayout.solver.widgets.Flow mFlow;

    public Flow(Context arg1) {
        super(arg1);
    }

    public Flow(Context arg1, AttributeSet arg2) {
        super(arg1, arg2);
    }

    public Flow(Context arg1, AttributeSet arg2, int arg3) {
        super(arg1, arg2, arg3);
    }

    protected void init(AttributeSet arg7) {
        super.init(arg7);
        this.mFlow = new androidx.constraintlayout.solver.widgets.Flow();
        if(arg7 != null) {
            TypedArray v7 = this.getContext().obtainStyledAttributes(arg7, styleable.ConstraintLayout_Layout);
            int v0 = v7.getIndexCount();
            int v2;
            for(v2 = 0; v2 < v0; ++v2) {
                int v3 = v7.getIndex(v2);
                if(v3 == styleable.ConstraintLayout_Layout_android_orientation) {
                    this.mFlow.setOrientation(v7.getInt(v3, 0));
                }
                else if(v3 == styleable.ConstraintLayout_Layout_android_padding) {
                    this.mFlow.setPadding(v7.getDimensionPixelSize(v3, 0));
                }
                else if(v3 == styleable.ConstraintLayout_Layout_android_paddingStart) {
                    this.mFlow.setPaddingStart(v7.getDimensionPixelSize(v3, 0));
                }
                else if(v3 == styleable.ConstraintLayout_Layout_android_paddingEnd) {
                    this.mFlow.setPaddingEnd(v7.getDimensionPixelSize(v3, 0));
                }
                else if(v3 == styleable.ConstraintLayout_Layout_android_paddingLeft) {
                    this.mFlow.setPaddingLeft(v7.getDimensionPixelSize(v3, 0));
                }
                else if(v3 == styleable.ConstraintLayout_Layout_android_paddingTop) {
                    this.mFlow.setPaddingTop(v7.getDimensionPixelSize(v3, 0));
                }
                else if(v3 == styleable.ConstraintLayout_Layout_android_paddingRight) {
                    this.mFlow.setPaddingRight(v7.getDimensionPixelSize(v3, 0));
                }
                else if(v3 == styleable.ConstraintLayout_Layout_android_paddingBottom) {
                    this.mFlow.setPaddingBottom(v7.getDimensionPixelSize(v3, 0));
                }
                else if(v3 == styleable.ConstraintLayout_Layout_flow_wrapMode) {
                    this.mFlow.setWrapMode(v7.getInt(v3, 0));
                }
                else if(v3 == styleable.ConstraintLayout_Layout_flow_horizontalStyle) {
                    this.mFlow.setHorizontalStyle(v7.getInt(v3, 0));
                }
                else if(v3 == styleable.ConstraintLayout_Layout_flow_verticalStyle) {
                    this.mFlow.setVerticalStyle(v7.getInt(v3, 0));
                }
                else if(v3 == styleable.ConstraintLayout_Layout_flow_firstHorizontalStyle) {
                    this.mFlow.setFirstHorizontalStyle(v7.getInt(v3, 0));
                }
                else if(v3 == styleable.ConstraintLayout_Layout_flow_lastHorizontalStyle) {
                    this.mFlow.setLastHorizontalStyle(v7.getInt(v3, 0));
                }
                else if(v3 == styleable.ConstraintLayout_Layout_flow_firstVerticalStyle) {
                    this.mFlow.setFirstVerticalStyle(v7.getInt(v3, 0));
                }
                else if(v3 == styleable.ConstraintLayout_Layout_flow_lastVerticalStyle) {
                    this.mFlow.setLastVerticalStyle(v7.getInt(v3, 0));
                }
                else {
                    float v5 = 0.5f;
                    if(v3 == styleable.ConstraintLayout_Layout_flow_horizontalBias) {
                        this.mFlow.setHorizontalBias(v7.getFloat(v3, v5));
                    }
                    else if(v3 == styleable.ConstraintLayout_Layout_flow_firstHorizontalBias) {
                        this.mFlow.setFirstHorizontalBias(v7.getFloat(v3, v5));
                    }
                    else if(v3 == styleable.ConstraintLayout_Layout_flow_lastHorizontalBias) {
                        this.mFlow.setLastHorizontalBias(v7.getFloat(v3, v5));
                    }
                    else if(v3 == styleable.ConstraintLayout_Layout_flow_firstVerticalBias) {
                        this.mFlow.setFirstVerticalBias(v7.getFloat(v3, v5));
                    }
                    else if(v3 == styleable.ConstraintLayout_Layout_flow_lastVerticalBias) {
                        this.mFlow.setLastVerticalBias(v7.getFloat(v3, v5));
                    }
                    else if(v3 == styleable.ConstraintLayout_Layout_flow_verticalBias) {
                        this.mFlow.setVerticalBias(v7.getFloat(v3, v5));
                    }
                    else {
                        int v5_1 = 2;
                        if(v3 == styleable.ConstraintLayout_Layout_flow_horizontalAlign) {
                            this.mFlow.setHorizontalAlign(v7.getInt(v3, v5_1));
                        }
                        else if(v3 == styleable.ConstraintLayout_Layout_flow_verticalAlign) {
                            this.mFlow.setVerticalAlign(v7.getInt(v3, v5_1));
                        }
                        else if(v3 == styleable.ConstraintLayout_Layout_flow_horizontalGap) {
                            this.mFlow.setHorizontalGap(v7.getDimensionPixelSize(v3, 0));
                        }
                        else if(v3 == styleable.ConstraintLayout_Layout_flow_verticalGap) {
                            this.mFlow.setVerticalGap(v7.getDimensionPixelSize(v3, 0));
                        }
                        else if(v3 == styleable.ConstraintLayout_Layout_flow_maxElementsWrap) {
                            this.mFlow.setMaxElementsWrap(v7.getInt(v3, -1));
                        }
                    }
                }
            }
        }

        this.mHelperWidget = this.mFlow;
        this.validateParams();
    }

    public void loadParameters(Constraint arg1, HelperWidget arg2, LayoutParams arg3, SparseArray arg4) {
        super.loadParameters(arg1, arg2, arg3, arg4);
        if(((arg2 instanceof androidx.constraintlayout.solver.widgets.Flow)) && arg3.orientation != -1) {
            ((androidx.constraintlayout.solver.widgets.Flow)arg2).setOrientation(arg3.orientation);
        }
    }

    protected void onMeasure(int arg2, int arg3) {
        this.onMeasure(this.mFlow, arg2, arg3);
    }

    public void onMeasure(androidx.constraintlayout.solver.widgets.VirtualLayout arg3, int arg4, int arg5) {
        int v0 = View$MeasureSpec.getMode(arg4);
        arg4 = View$MeasureSpec.getSize(arg4);
        int v1 = View$MeasureSpec.getMode(arg5);
        arg5 = View$MeasureSpec.getSize(arg5);
        if(arg3 != null) {
            arg3.measure(v0, arg4, v1, arg5);
            this.setMeasuredDimension(arg3.getMeasuredWidth(), arg3.getMeasuredHeight());
            return;
        }

        this.setMeasuredDimension(0, 0);
    }

    public void resolveRtl(ConstraintWidget arg1, boolean arg2) {
        this.mFlow.applyRtl(arg2);
    }

    public void setFirstHorizontalBias(float arg2) {
        this.mFlow.setFirstHorizontalBias(arg2);
        this.requestLayout();
    }

    public void setFirstHorizontalStyle(int arg2) {
        this.mFlow.setFirstHorizontalStyle(arg2);
        this.requestLayout();
    }

    public void setFirstVerticalBias(float arg2) {
        this.mFlow.setFirstVerticalBias(arg2);
        this.requestLayout();
    }

    public void setFirstVerticalStyle(int arg2) {
        this.mFlow.setFirstVerticalStyle(arg2);
        this.requestLayout();
    }

    public void setHorizontalAlign(int arg2) {
        this.mFlow.setHorizontalAlign(arg2);
        this.requestLayout();
    }

    public void setHorizontalBias(float arg2) {
        this.mFlow.setHorizontalBias(arg2);
        this.requestLayout();
    }

    public void setHorizontalGap(int arg2) {
        this.mFlow.setHorizontalGap(arg2);
        this.requestLayout();
    }

    public void setHorizontalStyle(int arg2) {
        this.mFlow.setHorizontalStyle(arg2);
        this.requestLayout();
    }

    public void setMaxElementsWrap(int arg2) {
        this.mFlow.setMaxElementsWrap(arg2);
        this.requestLayout();
    }

    public void setOrientation(int arg2) {
        this.mFlow.setOrientation(arg2);
        this.requestLayout();
    }

    public void setPadding(int arg2) {
        this.mFlow.setPadding(arg2);
        this.requestLayout();
    }

    public void setPaddingBottom(int arg2) {
        this.mFlow.setPaddingBottom(arg2);
        this.requestLayout();
    }

    public void setPaddingLeft(int arg2) {
        this.mFlow.setPaddingLeft(arg2);
        this.requestLayout();
    }

    public void setPaddingRight(int arg2) {
        this.mFlow.setPaddingRight(arg2);
        this.requestLayout();
    }

    public void setPaddingTop(int arg2) {
        this.mFlow.setPaddingTop(arg2);
        this.requestLayout();
    }

    public void setVerticalAlign(int arg2) {
        this.mFlow.setVerticalAlign(arg2);
        this.requestLayout();
    }

    public void setVerticalBias(float arg2) {
        this.mFlow.setVerticalBias(arg2);
        this.requestLayout();
    }

    public void setVerticalGap(int arg2) {
        this.mFlow.setVerticalGap(arg2);
        this.requestLayout();
    }

    public void setVerticalStyle(int arg2) {
        this.mFlow.setVerticalStyle(arg2);
        this.requestLayout();
    }

    public void setWrapMode(int arg2) {
        this.mFlow.setWrapMode(arg2);
        this.requestLayout();
    }
}

