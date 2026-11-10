package androidx.core.view.accessibility;

import android.os.Parcelable;
import android.view.View;
import android.view.accessibility.AccessibilityRecord;
import androidx.annotation.ReplaceWith;
import java.util.List;

public class AccessibilityRecordCompat {
    private final AccessibilityRecord mRecord;

    @Deprecated public AccessibilityRecordCompat(Object arg1) {
        super();
        this.mRecord = ((AccessibilityRecord)arg1);
    }

    @Deprecated public boolean equals(Object arg4) {
        if(this == (((AccessibilityRecordCompat)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof AccessibilityRecordCompat)) {
            return 0;
        }

        AccessibilityRecord v3 = this.mRecord;
        if(v3 == null) {
            if(((AccessibilityRecordCompat)arg4).mRecord == null) {
                return 1;
            }

            return 0;
        }

        return v3.equals(((AccessibilityRecordCompat)arg4).mRecord);
    }

    @Deprecated public int getAddedCount() {
        return this.mRecord.getAddedCount();
    }

    @Deprecated public CharSequence getBeforeText() {
        return this.mRecord.getBeforeText();
    }

    @Deprecated public CharSequence getClassName() {
        return this.mRecord.getClassName();
    }

    @Deprecated public CharSequence getContentDescription() {
        return this.mRecord.getContentDescription();
    }

    @Deprecated public int getCurrentItemIndex() {
        return this.mRecord.getCurrentItemIndex();
    }

    @Deprecated public int getFromIndex() {
        return this.mRecord.getFromIndex();
    }

    @Deprecated public Object getImpl() {
        return this.mRecord;
    }

    @Deprecated public int getItemCount() {
        return this.mRecord.getItemCount();
    }

    @ReplaceWith(expression="record.getMaxScrollX()") @Deprecated public static int getMaxScrollX(AccessibilityRecord arg0) {
        return arg0.getMaxScrollX();
    }

    @Deprecated public int getMaxScrollX() {
        return AccessibilityRecordCompat.getMaxScrollX(this.mRecord);
    }

    @ReplaceWith(expression="record.getMaxScrollY()") @Deprecated public static int getMaxScrollY(AccessibilityRecord arg0) {
        return arg0.getMaxScrollY();
    }

    @Deprecated public int getMaxScrollY() {
        return AccessibilityRecordCompat.getMaxScrollY(this.mRecord);
    }

    @Deprecated public Parcelable getParcelableData() {
        return this.mRecord.getParcelableData();
    }

    @Deprecated public int getRemovedCount() {
        return this.mRecord.getRemovedCount();
    }

    @Deprecated public int getScrollX() {
        return this.mRecord.getScrollX();
    }

    @Deprecated public int getScrollY() {
        return this.mRecord.getScrollY();
    }

    @Deprecated public AccessibilityNodeInfoCompat getSource() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(this.mRecord.getSource());
    }

    @Deprecated public List getText() {
        return this.mRecord.getText();
    }

    @Deprecated public int getToIndex() {
        return this.mRecord.getToIndex();
    }

    @Deprecated public int getWindowId() {
        return this.mRecord.getWindowId();
    }

    @Deprecated public int hashCode() {
        AccessibilityRecord v0 = this.mRecord;
        if(v0 == null) {
            return 0;
        }

        return v0.hashCode();
    }

    @Deprecated public boolean isChecked() {
        return this.mRecord.isChecked();
    }

    @Deprecated public boolean isEnabled() {
        return this.mRecord.isEnabled();
    }

    @Deprecated public boolean isFullScreen() {
        return this.mRecord.isFullScreen();
    }

    @Deprecated public boolean isPassword() {
        return this.mRecord.isPassword();
    }

    @Deprecated public boolean isScrollable() {
        return this.mRecord.isScrollable();
    }

    @Deprecated public static AccessibilityRecordCompat obtain() {
        return new AccessibilityRecordCompat(AccessibilityRecord.obtain());
    }

    @Deprecated public static AccessibilityRecordCompat obtain(AccessibilityRecordCompat arg1) {
        return new AccessibilityRecordCompat(AccessibilityRecord.obtain(arg1.mRecord));
    }

    @Deprecated public void recycle() {
        this.mRecord.recycle();
    }

    @Deprecated public void setAddedCount(int arg1) {
        this.mRecord.setAddedCount(arg1);
    }

    @Deprecated public void setBeforeText(CharSequence arg1) {
        this.mRecord.setBeforeText(arg1);
    }

    @Deprecated public void setChecked(boolean arg1) {
        this.mRecord.setChecked(arg1);
    }

    @Deprecated public void setClassName(CharSequence arg1) {
        this.mRecord.setClassName(arg1);
    }

    @Deprecated public void setContentDescription(CharSequence arg1) {
        this.mRecord.setContentDescription(arg1);
    }

    @Deprecated public void setCurrentItemIndex(int arg1) {
        this.mRecord.setCurrentItemIndex(arg1);
    }

    @Deprecated public void setEnabled(boolean arg1) {
        this.mRecord.setEnabled(arg1);
    }

    @Deprecated public void setFromIndex(int arg1) {
        this.mRecord.setFromIndex(arg1);
    }

    @Deprecated public void setFullScreen(boolean arg1) {
        this.mRecord.setFullScreen(arg1);
    }

    @Deprecated public void setItemCount(int arg1) {
        this.mRecord.setItemCount(arg1);
    }

    @ReplaceWith(expression="record.setMaxScrollX(maxScrollX)") @Deprecated public static void setMaxScrollX(AccessibilityRecord arg0, int arg1) {
        arg0.setMaxScrollX(arg1);
    }

    @Deprecated public void setMaxScrollX(int arg1) {
        AccessibilityRecordCompat.setMaxScrollX(this.mRecord, arg1);
    }

    @ReplaceWith(expression="record.setMaxScrollY(maxScrollY)") @Deprecated public static void setMaxScrollY(AccessibilityRecord arg0, int arg1) {
        arg0.setMaxScrollY(arg1);
    }

    @Deprecated public void setMaxScrollY(int arg1) {
        AccessibilityRecordCompat.setMaxScrollY(this.mRecord, arg1);
    }

    @Deprecated public void setParcelableData(Parcelable arg1) {
        this.mRecord.setParcelableData(arg1);
    }

    @Deprecated public void setPassword(boolean arg1) {
        this.mRecord.setPassword(arg1);
    }

    @Deprecated public void setRemovedCount(int arg1) {
        this.mRecord.setRemovedCount(arg1);
    }

    @Deprecated public void setScrollX(int arg1) {
        this.mRecord.setScrollX(arg1);
    }

    @Deprecated public void setScrollY(int arg1) {
        this.mRecord.setScrollY(arg1);
    }

    @Deprecated public void setScrollable(boolean arg1) {
        this.mRecord.setScrollable(arg1);
    }

    @ReplaceWith(expression="record.setSource(root, virtualDescendantId)") @Deprecated public static void setSource(AccessibilityRecord arg0, View arg1, int arg2) {
        arg0.setSource(arg1, arg2);
    }

    @Deprecated public void setSource(View arg1) {
        this.mRecord.setSource(arg1);
    }

    @Deprecated public void setSource(View arg1, int arg2) {
        AccessibilityRecordCompat.setSource(this.mRecord, arg1, arg2);
    }

    @Deprecated public void setToIndex(int arg1) {
        this.mRecord.setToIndex(arg1);
    }
}

