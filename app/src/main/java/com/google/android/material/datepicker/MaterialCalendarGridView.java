package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View$MeasureSpec;
import android.view.View;
import android.widget.Adapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.core.util.Pair;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$id;
import com.google.android.material.internal.ViewUtils;
import java.util.Calendar;
import java.util.Iterator;

final class MaterialCalendarGridView extends GridView {
    private final Calendar dayCompute;
    private final boolean nestedScrollable;

    public MaterialCalendarGridView(Context arg2) {
        this(arg2, null);
    }

    public MaterialCalendarGridView(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, 0);
    }

    public MaterialCalendarGridView(Context arg1, AttributeSet arg2, int arg3) {
        super(arg1, arg2, arg3);
        this.dayCompute = UtcDates.getUtcCalendar();
        if(MaterialDatePicker.isFullscreen(this.getContext())) {
            this.setNextFocusLeftId(id.cancel_button);
            this.setNextFocusRightId(id.confirm_button);
        }

        this.nestedScrollable = MaterialDatePicker.isNestedScrollable(this.getContext());
        ViewCompat.setAccessibilityDelegate(((View)this), new AccessibilityDelegateCompat() {
            public void onInitializeAccessibilityNodeInfo(View arg1, AccessibilityNodeInfoCompat arg2) {
                super.onInitializeAccessibilityNodeInfo(arg1, arg2);
                arg2.setCollectionInfo(null);
            }
        });
    }

    private void gainFocus(int arg2, Rect arg3) {
        if(arg2 == 33) {
            this.setSelection(this.getAdapter().lastPositionInMonth());
            return;
        }

        if(arg2 == 130) {
            this.setSelection(this.getAdapter().firstPositionInMonth());
            return;
        }

        super.onFocusChanged(true, arg2, arg3);
    }

    public MonthAdapter getAdapter() {
        return super.getAdapter();
    }

    public Adapter getAdapter() {
        return this.getAdapter();
    }

    public ListAdapter getAdapter() {
        return this.getAdapter();
    }

    private View getChildAtPosition(int arg2) {
        return this.getChildAt(arg2 - this.getFirstVisiblePosition());
    }

    private static int horizontalMidPoint(View arg1) {
        return arg1.getLeft() + arg1.getWidth() / 2;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.getAdapter().notifyDataSetChanged();
    }

    protected final void onDraw(Canvas arg27) {
        int v16;
        int v13;
        int v12;
        int v11_1;
        int v10;
        int v9_1;
        int v14;
        MaterialCalendarGridView v0 = this;
        super.onDraw(arg27);
        MonthAdapter v1 = v0.getAdapter();
        DateSelector v2 = v1.dateSelector;
        CalendarStyle v3 = v1.calendarStyle;
        int v4 = Math.max(v1.firstPositionInMonth(), v0.getFirstVisiblePosition());
        int v5 = Math.min(v1.lastPositionInMonth(), v0.getLastVisiblePosition());
        Long v6 = v1.getItem(v4);
        Long v7 = v1.getItem(v5);
        Iterator v2_1 = v2.getSelectedRanges().iterator();
    label_15:
        while(v2_1.hasNext()) {
            Object v8 = v2_1.next();
            if(((Pair)v8).first != null) {
                if(((Pair)v8).second == null) {
                    continue;
                }

                long v9 = ((Pair)v8).first.longValue();
                long v11 = ((Pair)v8).second.longValue();
                if(MaterialCalendarGridView.skipMonth(v6, v7, Long.valueOf(v9), Long.valueOf(v11))) {
                    continue;
                }

                boolean v8_1 = ViewUtils.isLayoutRtl(((View)v0));
                v14 = 5;
                if(Long.compare(v9, v6.longValue()) < 0) {
                    if(v1.isFirstInRow(v4)) {
                        v9_1 = 0;
                    }
                    else if(!v8_1) {
                        v9_1 = v0.getChildAtPosition(v4 - 1).getRight();
                    }
                    else {
                        v9_1 = v0.getChildAtPosition(v4 - 1).getLeft();
                    }

                    v10 = v9_1;
                    v9_1 = v4;
                }
                else {
                    v0.dayCompute.setTimeInMillis(v9);
                    v9_1 = v1.dayToPosition(v0.dayCompute.get(v14));
                    v10 = MaterialCalendarGridView.horizontalMidPoint(v0.getChildAtPosition(v9_1));
                }

                if(v11 > v7.longValue()) {
                    if(v1.isLastInRow(v5)) {
                        v11_1 = v0.getWidth();
                    }
                    else if(!v8_1) {
                        v11_1 = v0.getChildAtPosition(v5).getRight();
                    }
                    else {
                        v11_1 = v0.getChildAtPosition(v5).getLeft();
                    }

                    v12 = v11_1;
                    v11_1 = v5;
                }
                else {
                    v0.dayCompute.setTimeInMillis(v11);
                    v11_1 = v1.dayToPosition(v0.dayCompute.get(v14));
                    v12 = MaterialCalendarGridView.horizontalMidPoint(v0.getChildAtPosition(v11_1));
                }

                v13 = ((int)v1.getItemId(v9_1));
                v14 = v4;
                v16 = v5;
                v4 = ((int)v1.getItemId(v11_1));
                goto label_87;
            }

            v0 = this;
        }

        return;
    label_87:
        while(v13 <= v4) {
            v5 = v0.getNumColumns() * v13;
            int v15 = v5 + v0.getNumColumns() - 1;
            View v17 = v0.getChildAtPosition(v5);
            int v0_1 = v17.getTop() + v3.day.getTopInset();
            MonthAdapter v18 = v1;
            int v1_1 = v17.getBottom() - v3.day.getBottomInset();
            if(!v8_1) {
                v5 = v5 > v9_1 ? 0 : v10;
                if(v11_1 > v15) {
                    v15 = this.getWidth();
                    goto label_124;
                }

                v15 = v12;
            }
            else {
                v15 = v11_1 > v15 ? 0 : v12;
                v5 = v5 > v9_1 ? this.getWidth() : v10;
                int v25 = v15;
                v15 = v5;
                v5 = v25;
            }

        label_124:
            arg27.drawRect(((float)v5), ((float)v0_1), ((float)v15), ((float)v1_1), v3.rangeFill);
            ++v13;
            v0 = this;
            v1 = v18;
        }

        v0 = this;
        v4 = v14;
        v5 = v16;
        goto label_15;
    }

    protected void onFocusChanged(boolean arg1, int arg2, Rect arg3) {
        if(arg1) {
            this.gainFocus(arg2, arg3);
            return;
        }

        super.onFocusChanged(false, arg2, arg3);
    }

    public boolean onKeyDown(int arg4, KeyEvent arg5) {
        if(!super.onKeyDown(arg4, arg5)) {
            return 0;
        }

        if(this.getSelectedItemPosition() != -1) {
            if(this.getSelectedItemPosition() >= this.getAdapter().firstPositionInMonth()) {
            }
            else if(19 == arg4) {
                this.setSelection(this.getAdapter().firstPositionInMonth());
                return 1;
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public void onMeasure(int arg2, int arg3) {
        if(this.nestedScrollable) {
            super.onMeasure(arg2, View$MeasureSpec.makeMeasureSpec(0xFFFFFF, 0x80000000));
            this.getLayoutParams().height = this.getMeasuredHeight();
            return;
        }

        super.onMeasure(arg2, arg3);
    }

    public void setAdapter(Adapter arg1) {
        this.setAdapter(((ListAdapter)arg1));
    }

    public final void setAdapter(ListAdapter arg2) {
        if((arg2 instanceof MonthAdapter)) {
            super.setAdapter(arg2);
            return;
        }

        throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), MonthAdapter.class.getCanonicalName()));
    }

    public void setSelection(int arg2) {
        if(arg2 < this.getAdapter().firstPositionInMonth()) {
            super.setSelection(this.getAdapter().firstPositionInMonth());
            return;
        }

        super.setSelection(arg2);
    }

    private static boolean skipMonth(Long arg3, Long arg4, Long arg5, Long arg6) {
        if(arg3 != null && arg4 != null && arg5 != null) {
            if(arg6 == null) {
            }
            else if(arg5.longValue() <= arg4.longValue()) {
                if(arg6.longValue() < arg3.longValue()) {
                }
                else {
                    return 0;
                }
            }
        }

        return 1;
    }
}

