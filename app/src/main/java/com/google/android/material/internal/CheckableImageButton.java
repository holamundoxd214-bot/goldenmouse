package com.google.android.material.internal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable$ClassLoaderCreator;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;
import androidx.appcompat.R$attr;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;

public class CheckableImageButton extends AppCompatImageButton implements Checkable {
    class SavedState extends AbsSavedState {
        class com.google.android.material.internal.CheckableImageButton$SavedState$1 implements Parcelable$ClassLoaderCreator {
            com.google.android.material.internal.CheckableImageButton$SavedState$1() {
                super();
            }

            public SavedState createFromParcel(Parcel arg2) {
                return new SavedState(arg2, null);
            }

            public SavedState createFromParcel(Parcel arg1, ClassLoader arg2) {
                return new SavedState(arg1, arg2);
            }

            public Object createFromParcel(Parcel arg1) {
                return this.createFromParcel(arg1);
            }

            public Object createFromParcel(Parcel arg1, ClassLoader arg2) {
                return this.createFromParcel(arg1, arg2);
            }

            public SavedState[] newArray(int arg1) {
                return new SavedState[arg1];
            }

            public Object[] newArray(int arg1) {
                return this.newArray(arg1);
            }
        }

        public static final Parcelable$Creator CREATOR;
        boolean checked;

        static {
            SavedState.CREATOR = new com.google.android.material.internal.CheckableImageButton$SavedState$1();
        }

        public SavedState(Parcelable arg1) {
            super(arg1);
        }

        public SavedState(Parcel arg1, ClassLoader arg2) {
            super(arg1, arg2);
            this.readFromParcel(arg1);
        }

        private void readFromParcel(Parcel arg2) {
            boolean v0 = true;
            if(arg2.readInt() == 1) {
            }
            else {
                v0 = false;
            }

            this.checked = v0;
        }

        public void writeToParcel(Parcel arg1, int arg2) {
            super.writeToParcel(arg1, arg2);
            arg1.writeInt(this.checked);
        }
    }

    private static final int[] DRAWABLE_STATE_CHECKED;
    private boolean checkable;
    private boolean checked;
    private boolean pressable;

    static {
        CheckableImageButton.DRAWABLE_STATE_CHECKED = new int[]{0x10100A0};
    }

    public CheckableImageButton(Context arg2) {
        this(arg2, null);
    }

    public CheckableImageButton(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, attr.imageButtonStyle);
    }

    public CheckableImageButton(Context arg1, AttributeSet arg2, int arg3) {
        super(arg1, arg2, arg3);
        this.checkable = true;
        this.pressable = true;
        ViewCompat.setAccessibilityDelegate(((View)this), new AccessibilityDelegateCompat() {
            public void onInitializeAccessibilityEvent(View arg1, AccessibilityEvent arg2) {
                super.onInitializeAccessibilityEvent(arg1, arg2);
                arg2.setChecked(CheckableImageButton.this.isChecked());
            }

            public void onInitializeAccessibilityNodeInfo(View arg1, AccessibilityNodeInfoCompat arg2) {
                super.onInitializeAccessibilityNodeInfo(arg1, arg2);
                arg2.setCheckable(CheckableImageButton.this.isCheckable());
                arg2.setChecked(CheckableImageButton.this.isChecked());
            }
        });
    }

    public boolean isCheckable() {
        return this.checkable;
    }

    public boolean isChecked() {
        return this.checked;
    }

    public boolean isPressable() {
        return this.pressable;
    }

    public int[] onCreateDrawableState(int arg3) {
        if(this.checked) {
            return CheckableImageButton.mergeDrawableStates(super.onCreateDrawableState(arg3 + CheckableImageButton.DRAWABLE_STATE_CHECKED.length), CheckableImageButton.DRAWABLE_STATE_CHECKED);
        }

        return super.onCreateDrawableState(arg3);
    }

    protected void onRestoreInstanceState(Parcelable arg2) {
        if(!(arg2 instanceof SavedState)) {
            super.onRestoreInstanceState(arg2);
            return;
        }

        super.onRestoreInstanceState(((SavedState)arg2).getSuperState());
        this.setChecked(((SavedState)arg2).checked);
    }

    protected Parcelable onSaveInstanceState() {
        SavedState v1 = new SavedState(super.onSaveInstanceState());
        v1.checked = this.checked;
        return ((Parcelable)v1);
    }

    public void setCheckable(boolean arg2) {
        if(this.checkable != arg2) {
            this.checkable = arg2;
            this.sendAccessibilityEvent(0);
        }
    }

    public void setChecked(boolean arg2) {
        if((this.checkable) && this.checked != arg2) {
            this.checked = arg2;
            this.refreshDrawableState();
            this.sendAccessibilityEvent(0x800);
        }
    }

    public void setPressable(boolean arg1) {
        this.pressable = arg1;
    }

    public void setPressed(boolean arg2) {
        if(this.pressable) {
            super.setPressed(arg2);
        }
    }

    public void toggle() {
        this.setChecked(this.checked ^ 1);
    }
}

