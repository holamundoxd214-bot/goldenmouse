package androidx.appcompat.widget;

import android.content.Context;
import android.content.DialogInterface$OnClickListener;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources$Theme;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.PorterDuff$Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View$BaseSavedState;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import android.view.ViewTreeObserver$OnGlobalLayoutListener;
import android.view.ViewTreeObserver;
import android.widget.Adapter;
import android.widget.AdapterView$OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow$OnDismissListener;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$styleable;
import androidx.appcompat.app.AlertDialog$Builder;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.TintableBackgroundView;
import androidx.core.view.ViewCompat;

public class AppCompatSpinner extends Spinner implements TintableBackgroundView {
    final class Api16Impl {
        private Api16Impl() {
            super();
        }

        static void removeOnGlobalLayoutListener(ViewTreeObserver arg0, ViewTreeObserver$OnGlobalLayoutListener arg1) {
            arg0.removeOnGlobalLayoutListener(arg1);
        }
    }

    final class Api17Impl {
        private Api17Impl() {
            super();
        }

        static int getTextAlignment(View arg0) {
            return arg0.getTextAlignment();
        }

        static int getTextDirection(View arg0) {
            return arg0.getTextDirection();
        }

        static void setTextAlignment(View arg0, int arg1) {
            arg0.setTextAlignment(arg1);
        }

        static void setTextDirection(View arg0, int arg1) {
            arg0.setTextDirection(arg1);
        }
    }

    final class Api23Impl {
        private Api23Impl() {
            super();
        }

        static void setDropDownViewTheme(ThemedSpinnerAdapter arg1, Resources$Theme arg2) {
            if(!ObjectsCompat.equals(arg1.getDropDownViewTheme(), arg2)) {
                arg1.setDropDownViewTheme(arg2);
            }
        }
    }

    class DialogPopup implements DialogInterface$OnClickListener, SpinnerPopup {
        private ListAdapter mListAdapter;
        AlertDialog mPopup;
        private CharSequence mPrompt;

        DialogPopup(AppCompatSpinner arg1) {
            AppCompatSpinner.this = arg1;
            super();
        }

        public void dismiss() {
            AlertDialog v0 = this.mPopup;
            if(v0 != null) {
                v0.dismiss();
                this.mPopup = null;
            }
        }

        public Drawable getBackground() {
            return null;
        }

        public CharSequence getHintText() {
            return this.mPrompt;
        }

        public int getHorizontalOffset() {
            return 0;
        }

        public int getHorizontalOriginalOffset() {
            return 0;
        }

        public int getVerticalOffset() {
            return 0;
        }

        public boolean isShowing() {
            AlertDialog v0 = this.mPopup;
            if(v0 != null) {
                return v0.isShowing();
            }

            return 0;
        }

        public void onClick(DialogInterface arg4, int arg5) {
            AppCompatSpinner.this.setSelection(arg5);
            if(AppCompatSpinner.this.getOnItemClickListener() != null) {
                AppCompatSpinner.this.performItemClick(null, arg5, this.mListAdapter.getItemId(arg5));
            }

            this.dismiss();
        }

        public void setAdapter(ListAdapter arg1) {
            this.mListAdapter = arg1;
        }

        public void setBackgroundDrawable(Drawable arg1) {
            Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        public void setHorizontalOffset(int arg1) {
            Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        public void setHorizontalOriginalOffset(int arg1) {
            Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }

        public void setPromptText(CharSequence arg1) {
            this.mPrompt = arg1;
        }

        public void setVerticalOffset(int arg1) {
            Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        public void show(int arg4, int arg5) {
            if(this.mListAdapter == null) {
                return;
            }

            Builder v0 = new Builder(AppCompatSpinner.this.getPopupContext());
            CharSequence v1 = this.mPrompt;
            if(v1 != null) {
                v0.setTitle(v1);
            }

            AlertDialog v0_1 = v0.setSingleChoiceItems(this.mListAdapter, AppCompatSpinner.this.getSelectedItemPosition(), ((DialogInterface$OnClickListener)this)).create();
            this.mPopup = v0_1;
            ListView v0_2 = v0_1.getListView();
            Api17Impl.setTextDirection(((View)v0_2), arg4);
            Api17Impl.setTextAlignment(((View)v0_2), arg5);
            this.mPopup.show();
        }
    }

    class DropDownAdapter implements ListAdapter, SpinnerAdapter {
        private SpinnerAdapter mAdapter;
        private ListAdapter mListAdapter;

        public DropDownAdapter(SpinnerAdapter arg2, Resources$Theme arg3) {
            super();
            this.mAdapter = arg2;
            if((arg2 instanceof ListAdapter)) {
                this.mListAdapter = arg2;
            }

            if(arg3 != null) {
                if((arg2 instanceof ThemedSpinnerAdapter)) {
                    Api23Impl.setDropDownViewTheme(((ThemedSpinnerAdapter)arg2), arg3);
                    return;
                }
                else if(((arg2 instanceof androidx.appcompat.widget.ThemedSpinnerAdapter)) && ((androidx.appcompat.widget.ThemedSpinnerAdapter)arg2).getDropDownViewTheme() == null) {
                    ((androidx.appcompat.widget.ThemedSpinnerAdapter)arg2).setDropDownViewTheme(arg3);
                }
            }
        }

        public boolean areAllItemsEnabled() {
            ListAdapter v0 = this.mListAdapter;
            if(v0 != null) {
                return v0.areAllItemsEnabled();
            }

            return 1;
        }

        public int getCount() {
            SpinnerAdapter v0 = this.mAdapter;
            if(v0 == null) {
                return 0;
            }

            return v0.getCount();
        }

        public View getDropDownView(int arg1, View arg2, ViewGroup arg3) {
            SpinnerAdapter v0 = this.mAdapter;
            if(v0 == null) {
                return null;
            }

            return v0.getDropDownView(arg1, arg2, arg3);
        }

        public Object getItem(int arg1) {
            SpinnerAdapter v0 = this.mAdapter;
            if(v0 == null) {
                return null;
            }

            return v0.getItem(arg1);
        }

        public long getItemId(int arg1) {
            SpinnerAdapter v0 = this.mAdapter;
            if(v0 == null) {
                return -1;
            }

            return v0.getItemId(arg1);
        }

        public int getItemViewType(int arg1) {
            return 0;
        }

        public View getView(int arg1, View arg2, ViewGroup arg3) {
            return this.getDropDownView(arg1, arg2, arg3);
        }

        public int getViewTypeCount() {
            return 1;
        }

        public boolean hasStableIds() {
            SpinnerAdapter v0 = this.mAdapter;
            if(v0 != null && (v0.hasStableIds())) {
                return 1;
            }

            return 0;
        }

        public boolean isEmpty() {
            if(this.getCount() == 0) {
                return 1;
            }

            return 0;
        }

        public boolean isEnabled(int arg1) {
            ListAdapter v0 = this.mListAdapter;
            if(v0 != null) {
                return v0.isEnabled(arg1);
            }

            return 1;
        }

        public void registerDataSetObserver(DataSetObserver arg1) {
            SpinnerAdapter v0 = this.mAdapter;
            if(v0 != null) {
                v0.registerDataSetObserver(arg1);
            }
        }

        public void unregisterDataSetObserver(DataSetObserver arg1) {
            SpinnerAdapter v0 = this.mAdapter;
            if(v0 != null) {
                v0.unregisterDataSetObserver(arg1);
            }
        }
    }

    class DropdownPopup extends ListPopupWindow implements SpinnerPopup {
        ListAdapter mAdapter;
        private CharSequence mHintText;
        private int mOriginalHorizontalOffset;
        private final Rect mVisibleRect;

        public DropdownPopup(AppCompatSpinner arg1, Context arg2, AttributeSet arg3, int arg4) {
            AppCompatSpinner.this = arg1;
            super(arg2, arg3, arg4);
            this.mVisibleRect = new Rect();
            this.setAnchorView(((View)arg1));
            this.setModal(true);
            this.setPromptPosition(0);
            this.setOnItemClickListener(new AdapterView$OnItemClickListener(arg1) {
                public void onItemClick(AdapterView arg1, View arg2, int arg3, long arg4) {
                    this.this$1.this$0.setSelection(arg3);
                    if(this.this$1.this$0.getOnItemClickListener() != null) {
                        this.this$1.this$0.performItemClick(arg2, arg3, this.this$1.mAdapter.getItemId(arg3));
                    }

                    this.this$1.dismiss();
                }
            });
        }

        static void access$001(DropdownPopup arg0) {
            super.show();
        }

        void computeContentWidth() {
            int v0_2;
            Drawable v0 = this.getBackground();
            AppCompatSpinner v1 = AppCompatSpinner.this;
            if(v0 != null) {
                v0.getPadding(v1.mTempRect);
                boolean v0_1 = ViewUtils.isLayoutRtl(AppCompatSpinner.this);
                v1 = AppCompatSpinner.this;
                v0_2 = v0_1 ? v1.mTempRect.right : -v1.mTempRect.left;
            }
            else {
                Rect v0_3 = v1.mTempRect;
                AppCompatSpinner.this.mTempRect.right = 0;
                v0_3.left = 0;
                v0_2 = 0;
            }

            int v1_1 = AppCompatSpinner.this.getPaddingLeft();
            int v2 = AppCompatSpinner.this.getPaddingRight();
            int v3 = AppCompatSpinner.this.getWidth();
            int v4 = AppCompatSpinner.this.mDropDownWidth;
            AppCompatSpinner v5 = AppCompatSpinner.this;
            if(v4 == -2) {
                v4 = v5.compatMeasureContentWidth(this.mAdapter, this.getBackground());
                int v5_1 = AppCompatSpinner.this.getContext().getResources().getDisplayMetrics().widthPixels - AppCompatSpinner.this.mTempRect.left - AppCompatSpinner.this.mTempRect.right;
                if(v4 > v5_1) {
                    v4 = v5_1;
                }

                this.setContentWidth(Math.max(v4, v3 - v1_1 - v2));
            }
            else {
                if(v5.mDropDownWidth == -1) {
                    this.setContentWidth(v3 - v1_1 - v2);
                    goto label_67;
                }

                this.setContentWidth(AppCompatSpinner.this.mDropDownWidth);
            }

        label_67:
            v0_2 += ViewUtils.isLayoutRtl(AppCompatSpinner.this) ? v3 - v2 - this.getWidth() - this.getHorizontalOriginalOffset() : v1_1 + this.getHorizontalOriginalOffset();
            this.setHorizontalOffset(v0_2);
        }

        public CharSequence getHintText() {
            return this.mHintText;
        }

        public int getHorizontalOriginalOffset() {
            return this.mOriginalHorizontalOffset;
        }

        boolean isVisibleToUser(View arg2) {
            if((ViewCompat.isAttachedToWindow(arg2)) && (arg2.getGlobalVisibleRect(this.mVisibleRect))) {
                return 1;
            }

            return 0;
        }

        public void setAdapter(ListAdapter arg1) {
            super.setAdapter(arg1);
            this.mAdapter = arg1;
        }

        public void setHorizontalOriginalOffset(int arg1) {
            this.mOriginalHorizontalOffset = arg1;
        }

        public void setPromptText(CharSequence arg1) {
            this.mHintText = arg1;
        }

        public void show(int arg4, int arg5) {
            boolean v0 = this.isShowing();
            this.computeContentWidth();
            this.setInputMethodMode(2);
            super.show();
            ListView v1 = this.getListView();
            v1.setChoiceMode(1);
            Api17Impl.setTextDirection(((View)v1), arg4);
            Api17Impl.setTextAlignment(((View)v1), arg5);
            this.setSelection(AppCompatSpinner.this.getSelectedItemPosition());
            if(v0) {
            }
            else {
                ViewTreeObserver v4 = AppCompatSpinner.this.getViewTreeObserver();
                if(v4 != null) {
                    androidx.appcompat.widget.AppCompatSpinner$DropdownPopup$2 v5 = new ViewTreeObserver$OnGlobalLayoutListener() {
                        public void onGlobalLayout() {
                            boolean v0 = this.this$1.isVisibleToUser(this.this$1.this$0);
                            DropdownPopup v1 = this.this$1;
                            if(!v0) {
                                v1.dismiss();
                                return;
                            }

                            v1.computeContentWidth();
                            DropdownPopup.access$001(this.this$1);
                        }
                    };
                    v4.addOnGlobalLayoutListener(((ViewTreeObserver$OnGlobalLayoutListener)v5));
                    this.setOnDismissListener(new PopupWindow$OnDismissListener(((ViewTreeObserver$OnGlobalLayoutListener)v5)) {
                        public void onDismiss() {
                            ViewTreeObserver v0 = this.this$1.this$0.getViewTreeObserver();
                            if(v0 != null) {
                                v0.removeGlobalOnLayoutListener(this.val$layoutListener);
                            }
                        }
                    });
                }
            }
        }
    }

    class SavedState extends View$BaseSavedState {
        class androidx.appcompat.widget.AppCompatSpinner$SavedState$1 implements Parcelable$Creator {
            androidx.appcompat.widget.AppCompatSpinner$SavedState$1() {
                super();
            }

            public SavedState createFromParcel(Parcel arg1) {
                return new SavedState(arg1);
            }

            public Object createFromParcel(Parcel arg1) {
                return this.createFromParcel(arg1);
            }

            public SavedState[] newArray(int arg1) {
                return new SavedState[arg1];
            }

            public Object[] newArray(int arg1) {
                return this.newArray(arg1);
            }
        }

        public static final Parcelable$Creator CREATOR;
        boolean mShowDropdown;

        static {
            SavedState.CREATOR = new androidx.appcompat.widget.AppCompatSpinner$SavedState$1();
        }

        SavedState(Parcelable arg1) {
            super(arg1);
        }

        SavedState(Parcel arg1) {
            super(arg1);
            boolean v1 = arg1.readByte() != 0 ? true : false;
            this.mShowDropdown = v1;
        }

        public void writeToParcel(Parcel arg1, int arg2) {
            super.writeToParcel(arg1, arg2);
            arg1.writeByte(((byte)this.mShowDropdown));
        }
    }

    interface SpinnerPopup {
        void dismiss();

        Drawable getBackground();

        CharSequence getHintText();

        int getHorizontalOffset();

        int getHorizontalOriginalOffset();

        int getVerticalOffset();

        boolean isShowing();

        void setAdapter(ListAdapter arg1);

        void setBackgroundDrawable(Drawable arg1);

        void setHorizontalOffset(int arg1);

        void setHorizontalOriginalOffset(int arg1);

        void setPromptText(CharSequence arg1);

        void setVerticalOffset(int arg1);

        void show(int arg1, int arg2);
    }

    private static final int[] ATTRS_ANDROID_SPINNERMODE = null;
    private static final int MAX_ITEMS_MEASURED = 15;
    private static final int MODE_DIALOG = 0;
    private static final int MODE_DROPDOWN = 1;
    private static final int MODE_THEME = -1;
    private static final String TAG = "AppCompatSpinner";
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    int mDropDownWidth;
    private ForwardingListener mForwardingListener;
    private SpinnerPopup mPopup;
    private final Context mPopupContext;
    private final boolean mPopupSet;
    private SpinnerAdapter mTempAdapter;
    final Rect mTempRect;

    static {
        AppCompatSpinner.ATTRS_ANDROID_SPINNERMODE = new int[]{0x10102F1};
    }

    public AppCompatSpinner(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, attr.spinnerStyle);
    }

    public AppCompatSpinner(Context arg2) {
        this(arg2, null);
    }

    public AppCompatSpinner(Context arg3, int arg4) {
        this(arg3, null, attr.spinnerStyle, arg4);
    }

    public AppCompatSpinner(Context arg7, AttributeSet arg8, int arg9, int arg10) {
        this(arg7, arg8, arg9, arg10, null);
    }

    public AppCompatSpinner(Context arg2, AttributeSet arg3, int arg4) {
        this(arg2, arg3, arg4, -1);
    }

    public AppCompatSpinner(Context arg7, AttributeSet arg8, int arg9, int arg10, Resources$Theme arg11) {
        TypedArray v11_1;
        super(arg7, arg8, arg9);
        this.mTempRect = new Rect();
        ThemeUtils.checkAppCompatTheme(((View)this), this.getContext());
        TintTypedArray v0 = TintTypedArray.obtainStyledAttributes(arg7, arg8, styleable.Spinner, arg9, 0);
        this.mBackgroundTintHelper = new AppCompatBackgroundHelper(((View)this));
        if(arg11 != null) {
            this.mPopupContext = new ContextThemeWrapper(arg7, arg11);
        }
        else {
            int v11 = v0.getResourceId(styleable.Spinner_popupTheme, 0);
            this.mPopupContext = v11 != 0 ? new ContextThemeWrapper(arg7, v11) : arg7;
        }

        TypedArray v2 = null;
        if(arg10 != -1) {
            goto label_52;
        }

        try {
            v11_1 = arg7.obtainStyledAttributes(arg8, AppCompatSpinner.ATTRS_ANDROID_SPINNERMODE, arg9, 0);
        }
        catch(Throwable v6) {
            goto label_49;
        }
        catch(Exception v3) {
            v11_1 = v2;
            goto label_42;
        }

        try {
            if(v11_1.hasValue(0)) {
                arg10 = v11_1.getInt(0, 0);
            }

            goto label_33;
        }
        catch(Throwable v6) {
        label_48:
            v2 = v11_1;
        }
        catch(Exception v3) {
            try {
            label_42:
                Log.i("AppCompatSpinner", "Could not read android:spinnerMode", ((Throwable)v3));
                if(v11_1 != null) {
                }
                else {
                    goto label_52;
                }
            }
            catch(Throwable v6) {
                goto label_48;
            }

            goto label_34;
        }

    label_49:
        if(v2 != null) {
            v2.recycle();
        }

        throw v6;
    label_33:
        if(v11_1 != null) {
        label_34:
            v11_1.recycle();
        }

    label_52:
        if(arg10 == 0) {
            DialogPopup v10_1 = new DialogPopup(this);
            this.mPopup = ((SpinnerPopup)v10_1);
            ((SpinnerPopup)v10_1).setPromptText(v0.getString(styleable.Spinner_android_prompt));
        }
        else if(arg10 != 1) {
        }
        else {
            DropdownPopup v10 = new DropdownPopup(this, this.mPopupContext, arg8, arg9);
            TintTypedArray v1 = TintTypedArray.obtainStyledAttributes(this.mPopupContext, arg8, styleable.Spinner, arg9, 0);
            this.mDropDownWidth = v1.getLayoutDimension(styleable.Spinner_android_dropDownWidth, -2);
            v10.setBackgroundDrawable(v1.getDrawable(styleable.Spinner_android_popupBackground));
            v10.setPromptText(v0.getString(styleable.Spinner_android_prompt));
            v1.recycle();
            this.mPopup = ((SpinnerPopup)v10);
            this.mForwardingListener = new ForwardingListener(((View)this), v10) {
                public ShowableListMenu getPopup() {
                    return this.val$popup;
                }

                public boolean onForwardingStarted() {
                    if(!AppCompatSpinner.this.getInternalPopup().isShowing()) {
                        AppCompatSpinner.this.showPopup();
                    }

                    return 1;
                }
            };
        }

        CharSequence[] v10_2 = v0.getTextArray(styleable.Spinner_android_entries);
        if(v10_2 != null) {
            ArrayAdapter v1_1 = new ArrayAdapter(arg7, 0x1090008, ((Object[])v10_2));
            v1_1.setDropDownViewResource(layout.support_simple_spinner_dropdown_item);
            this.setAdapter(((SpinnerAdapter)v1_1));
        }

        v0.recycle();
        this.mPopupSet = true;
        SpinnerAdapter v7 = this.mTempAdapter;
        if(v7 != null) {
            this.setAdapter(v7);
            this.mTempAdapter = ((SpinnerAdapter)v2);
        }

        this.mBackgroundTintHelper.loadFromAttributes(arg8, arg9);
    }

    int compatMeasureContentWidth(SpinnerAdapter arg11, Drawable arg12) {
        int v0 = 0;
        if(arg11 == null) {
            return 0;
        }

        int v1 = View$MeasureSpec.makeMeasureSpec(this.getMeasuredWidth(), 0);
        int v2 = View$MeasureSpec.makeMeasureSpec(this.getMeasuredHeight(), 0);
        int v3 = Math.max(0, this.getSelectedItemPosition());
        int v4 = Math.min(arg11.getCount(), v3 + 15);
        View v5 = null;
        int v6 = Math.max(0, v3 - (15 - (v4 - v3)));
        View v7 = v5;
        v3 = 0;
        while(v6 < v4) {
            int v8 = arg11.getItemViewType(v6);
            if(v8 != v0) {
                v7 = v5;
                v0 = v8;
            }

            v7 = arg11.getView(v6, v7, ((ViewGroup)this));
            if(v7.getLayoutParams() == null) {
                v7.setLayoutParams(new ViewGroup$LayoutParams(-2, -2));
            }

            v7.measure(v1, v2);
            v3 = Math.max(v3, v7.getMeasuredWidth());
            ++v6;
        }

        if(arg12 != null) {
            arg12.getPadding(this.mTempRect);
            v3 += this.mTempRect.left + this.mTempRect.right;
        }

        return v3;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper v0 = this.mBackgroundTintHelper;
        if(v0 != null) {
            v0.applySupportBackgroundTint();
        }
    }

    public int getDropDownHorizontalOffset() {
        SpinnerPopup v0 = this.mPopup;
        if(v0 != null) {
            return v0.getHorizontalOffset();
        }

        return super.getDropDownHorizontalOffset();
    }

    public int getDropDownVerticalOffset() {
        SpinnerPopup v0 = this.mPopup;
        if(v0 != null) {
            return v0.getVerticalOffset();
        }

        return super.getDropDownVerticalOffset();
    }

    public int getDropDownWidth() {
        if(this.mPopup != null) {
            return this.mDropDownWidth;
        }

        return super.getDropDownWidth();
    }

    final SpinnerPopup getInternalPopup() {
        return this.mPopup;
    }

    public Drawable getPopupBackground() {
        SpinnerPopup v0 = this.mPopup;
        if(v0 != null) {
            return v0.getBackground();
        }

        return super.getPopupBackground();
    }

    public Context getPopupContext() {
        return this.mPopupContext;
    }

    public CharSequence getPrompt() {
        SpinnerPopup v0 = this.mPopup;
        if(v0 != null) {
            return v0.getHintText();
        }

        return super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper v0 = this.mBackgroundTintHelper;
        if(v0 != null) {
            return v0.getSupportBackgroundTintList();
        }

        return null;
    }

    public PorterDuff$Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper v0 = this.mBackgroundTintHelper;
        if(v0 != null) {
            return v0.getSupportBackgroundTintMode();
        }

        return null;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SpinnerPopup v0 = this.mPopup;
        if(v0 != null && (v0.isShowing())) {
            this.mPopup.dismiss();
        }
    }

    protected void onMeasure(int arg3, int arg4) {
        super.onMeasure(arg3, arg4);
        if(this.mPopup != null && View$MeasureSpec.getMode(arg3) == 0x80000000) {
            this.setMeasuredDimension(Math.min(Math.max(this.getMeasuredWidth(), this.compatMeasureContentWidth(this.getAdapter(), this.getBackground())), View$MeasureSpec.getSize(arg3)), this.getMeasuredHeight());
        }
    }

    public void onRestoreInstanceState(Parcelable arg2) {
        super.onRestoreInstanceState(((SavedState)arg2).getSuperState());
        if(((SavedState)arg2).mShowDropdown) {
            ViewTreeObserver v2 = this.getViewTreeObserver();
            if(v2 != null) {
                v2.addOnGlobalLayoutListener(new ViewTreeObserver$OnGlobalLayoutListener() {
                    public void onGlobalLayout() {
                        if(!AppCompatSpinner.this.getInternalPopup().isShowing()) {
                            AppCompatSpinner.this.showPopup();
                        }

                        ViewTreeObserver v0 = AppCompatSpinner.this.getViewTreeObserver();
                        if(v0 != null) {
                            Api16Impl.removeOnGlobalLayoutListener(v0, ((ViewTreeObserver$OnGlobalLayoutListener)this));
                        }
                    }
                });
            }
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState v0 = new SavedState(super.onSaveInstanceState());
        SpinnerPopup v2 = this.mPopup;
        boolean v2_1 = v2 == null || !v2.isShowing() ? false : true;
        v0.mShowDropdown = v2_1;
        return ((Parcelable)v0);
    }

    public boolean onTouchEvent(MotionEvent arg2) {
        ForwardingListener v0 = this.mForwardingListener;
        if(v0 != null && (v0.onTouch(((View)this), arg2))) {
            return 1;
        }

        return super.onTouchEvent(arg2);
    }

    public boolean performClick() {
        SpinnerPopup v0 = this.mPopup;
        if(v0 != null) {
            if(!v0.isShowing()) {
                this.showPopup();
            }

            return 1;
        }

        return super.performClick();
    }

    public void setAdapter(SpinnerAdapter arg3) {
        if(!this.mPopupSet) {
            this.mTempAdapter = arg3;
            return;
        }

        super.setAdapter(arg3);
        if(this.mPopup != null) {
            Context v0 = this.mPopupContext;
            if(v0 == null) {
                v0 = this.getContext();
            }

            this.mPopup.setAdapter(new DropDownAdapter(arg3, v0.getTheme()));
        }
    }

    public void setAdapter(Adapter arg1) {
        this.setAdapter(((SpinnerAdapter)arg1));
    }

    public void setBackgroundDrawable(Drawable arg1) {
        super.setBackgroundDrawable(arg1);
        AppCompatBackgroundHelper v0 = this.mBackgroundTintHelper;
        if(v0 != null) {
            v0.onSetBackgroundDrawable(arg1);
        }
    }

    public void setBackgroundResource(int arg1) {
        super.setBackgroundResource(arg1);
        AppCompatBackgroundHelper v0 = this.mBackgroundTintHelper;
        if(v0 != null) {
            v0.onSetBackgroundResource(arg1);
        }
    }

    public void setDropDownHorizontalOffset(int arg2) {
        SpinnerPopup v0 = this.mPopup;
        if(v0 != null) {
            v0.setHorizontalOriginalOffset(arg2);
            this.mPopup.setHorizontalOffset(arg2);
            return;
        }

        super.setDropDownHorizontalOffset(arg2);
    }

    public void setDropDownVerticalOffset(int arg2) {
        SpinnerPopup v0 = this.mPopup;
        if(v0 != null) {
            v0.setVerticalOffset(arg2);
            return;
        }

        super.setDropDownVerticalOffset(arg2);
    }

    public void setDropDownWidth(int arg2) {
        if(this.mPopup != null) {
            this.mDropDownWidth = arg2;
            return;
        }

        super.setDropDownWidth(arg2);
    }

    public void setPopupBackgroundDrawable(Drawable arg2) {
        SpinnerPopup v0 = this.mPopup;
        if(v0 != null) {
            v0.setBackgroundDrawable(arg2);
            return;
        }

        super.setPopupBackgroundDrawable(arg2);
    }

    public void setPopupBackgroundResource(int arg2) {
        this.setPopupBackgroundDrawable(AppCompatResources.getDrawable(this.getPopupContext(), arg2));
    }

    public void setPrompt(CharSequence arg2) {
        SpinnerPopup v0 = this.mPopup;
        if(v0 != null) {
            v0.setPromptText(arg2);
            return;
        }

        super.setPrompt(arg2);
    }

    public void setSupportBackgroundTintList(ColorStateList arg1) {
        AppCompatBackgroundHelper v0 = this.mBackgroundTintHelper;
        if(v0 != null) {
            v0.setSupportBackgroundTintList(arg1);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff$Mode arg1) {
        AppCompatBackgroundHelper v0 = this.mBackgroundTintHelper;
        if(v0 != null) {
            v0.setSupportBackgroundTintMode(arg1);
        }
    }

    void showPopup() {
        this.mPopup.show(Api17Impl.getTextDirection(((View)this)), Api17Impl.getTextAlignment(((View)this)));
    }
}

