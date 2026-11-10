package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface$OnCancelListener;
import android.content.DialogInterface$OnClickListener;
import android.content.DialogInterface$OnDismissListener;
import android.content.DialogInterface$OnKeyListener;
import android.content.DialogInterface$OnMultiChoiceClickListener;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View$OnClickListener;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AdapterView$OnItemClickListener;
import android.widget.AdapterView$OnItemSelectedListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout$LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import java.lang.ref.WeakReference;

class AlertController {
    class androidx.appcompat.app.AlertController$1 implements View$OnClickListener {
        androidx.appcompat.app.AlertController$1(AlertController arg1) {
            AlertController.this = arg1;
            super();
        }

        public void onClick(View arg2) {
            Message v2;
            if(arg2 != AlertController.this.mButtonPositive || AlertController.this.mButtonPositiveMessage == null) {
                if(arg2 == AlertController.this.mButtonNegative && AlertController.this.mButtonNegativeMessage != null) {
                    v2 = Message.obtain(AlertController.this.mButtonNegativeMessage);
                    goto label_31;
                }

                if(arg2 == AlertController.this.mButtonNeutral && AlertController.this.mButtonNeutralMessage != null) {
                    v2 = Message.obtain(AlertController.this.mButtonNeutralMessage);
                    goto label_31;
                }

                v2 = null;
            }
            else {
                v2 = Message.obtain(AlertController.this.mButtonPositiveMessage);
            }

        label_31:
            if(v2 != null) {
                v2.sendToTarget();
            }

            AlertController.this.mHandler.obtainMessage(1, AlertController.this.mDialog).sendToTarget();
        }
    }

    public class AlertParams {
        public interface OnPrepareListViewListener {
            void onPrepareListView(ListView arg1);
        }

        public ListAdapter mAdapter;
        public boolean mCancelable;
        public int mCheckedItem;
        public boolean[] mCheckedItems;
        public final Context mContext;
        public Cursor mCursor;
        public View mCustomTitleView;
        public boolean mForceInverseBackground;
        public Drawable mIcon;
        public int mIconAttrId;
        public int mIconId;
        public final LayoutInflater mInflater;
        public String mIsCheckedColumn;
        public boolean mIsMultiChoice;
        public boolean mIsSingleChoice;
        public CharSequence[] mItems;
        public String mLabelColumn;
        public CharSequence mMessage;
        public Drawable mNegativeButtonIcon;
        public DialogInterface$OnClickListener mNegativeButtonListener;
        public CharSequence mNegativeButtonText;
        public Drawable mNeutralButtonIcon;
        public DialogInterface$OnClickListener mNeutralButtonListener;
        public CharSequence mNeutralButtonText;
        public DialogInterface$OnCancelListener mOnCancelListener;
        public DialogInterface$OnMultiChoiceClickListener mOnCheckboxClickListener;
        public DialogInterface$OnClickListener mOnClickListener;
        public DialogInterface$OnDismissListener mOnDismissListener;
        public AdapterView$OnItemSelectedListener mOnItemSelectedListener;
        public DialogInterface$OnKeyListener mOnKeyListener;
        public OnPrepareListViewListener mOnPrepareListViewListener;
        public Drawable mPositiveButtonIcon;
        public DialogInterface$OnClickListener mPositiveButtonListener;
        public CharSequence mPositiveButtonText;
        public boolean mRecycleOnMeasure;
        public CharSequence mTitle;
        public View mView;
        public int mViewLayoutResId;
        public int mViewSpacingBottom;
        public int mViewSpacingLeft;
        public int mViewSpacingRight;
        public boolean mViewSpacingSpecified;
        public int mViewSpacingTop;

        public AlertParams(Context arg2) {
            super();
            this.mIconId = 0;
            this.mIconAttrId = 0;
            this.mViewSpacingSpecified = false;
            this.mCheckedItem = -1;
            this.mRecycleOnMeasure = true;
            this.mContext = arg2;
            this.mCancelable = true;
            this.mInflater = arg2.getSystemService("layout_inflater");
        }

        public void apply(AlertController arg14) {
            AlertController v7;
            CharSequence v0_1;
            View v0 = this.mCustomTitleView;
            if(v0 != null) {
                arg14.setCustomTitle(v0);
            }
            else {
                v0_1 = this.mTitle;
                if(v0_1 != null) {
                    arg14.setTitle(v0_1);
                }

                Drawable v0_2 = this.mIcon;
                if(v0_2 != null) {
                    arg14.setIcon(v0_2);
                }

                int v0_3 = this.mIconId;
                if(v0_3 != 0) {
                    arg14.setIcon(v0_3);
                }

                v0_3 = this.mIconAttrId;
                if(v0_3 == 0) {
                    goto label_17;
                }

                arg14.setIcon(arg14.getIconAttributeResId(v0_3));
            }

        label_17:
            v0_1 = this.mMessage;
            if(v0_1 != null) {
                arg14.setMessage(v0_1);
            }

            CharSequence v3 = this.mPositiveButtonText;
            if(v3 != null || this.mPositiveButtonIcon != null) {
                arg14.setButton(-1, v3, this.mPositiveButtonListener, null, this.mPositiveButtonIcon);
                v7 = arg14;
            }
            else {
                v7 = arg14;
            }

            CharSequence v9 = this.mNegativeButtonText;
            if(v9 != null || this.mNegativeButtonIcon != null) {
                v7.setButton(-2, v9, this.mNegativeButtonListener, null, this.mNegativeButtonIcon);
            }

            v9 = this.mNeutralButtonText;
            if(v9 != null || this.mNeutralButtonIcon != null) {
                v7.setButton(-3, v9, this.mNeutralButtonListener, null, this.mNeutralButtonIcon);
            }

            if(this.mItems != null || this.mCursor != null || this.mAdapter != null) {
                this.createListView(v7);
            }

            View v8 = this.mView;
            if(v8 != null) {
                if(this.mViewSpacingSpecified) {
                    v7.setView(v8, this.mViewSpacingLeft, this.mViewSpacingTop, this.mViewSpacingRight, this.mViewSpacingBottom);
                    return;
                }

                v7.setView(v8);
                return;
            }

            int v13 = this.mViewLayoutResId;
            if(v13 != 0) {
                v7.setView(v13);
            }
        }

        private void createListView(AlertController arg16) {
            androidx.appcompat.app.AlertController$AlertParams$2 v7_1;
            AlertController v6 = arg16;
            View v5 = this.mInflater.inflate(v6.mListLayout, null);
            if(!this.mIsMultiChoice) {
                int v0 = this.mIsSingleChoice ? v6.mSingleChoiceItemLayout : v6.mListItemLayout;
                int v9 = v0;
                int v2 = 0x1020014;
                if(this.mCursor != null) {
                    SimpleCursorAdapter v7_2 = new SimpleCursorAdapter(this.mContext, v9, this.mCursor, new String[]{this.mLabelColumn}, new int[]{v2});
                    goto label_54;
                }

                ListAdapter v7_3 = this.mAdapter;
                if(v7_3 != null) {
                    goto label_54;
                }

                CheckedItemAdapter v7_4 = new CheckedItemAdapter(this.mContext, v9, v2, this.mItems);
            }
            else if(this.mCursor == null) {
                androidx.appcompat.app.AlertController$AlertParams$1 v7 = new ArrayAdapter(this.mContext, v6.mMultiChoiceItemLayout, 0x1020014, this.mItems, v5) {
                    public View getView(int arg1, View arg2, ViewGroup arg3) {
                        arg2 = super.getView(arg1, arg2, arg3);
                        if(AlertParams.this.mCheckedItems != null && (AlertParams.this.mCheckedItems[arg1])) {
                            this.val$listView.setItemChecked(arg1, true);
                        }

                        return arg2;
                    }
                };
            }
            else {
                v7_1 = new CursorAdapter(this.mContext, this.mCursor, false, ((RecycleListView)v5), v6) {
                    private final int mIsCheckedIndex;
                    private final int mLabelIndex;

                    public void bindView(View arg1, Context arg2, Cursor arg3) {
                        arg1.findViewById(0x1020014).setText(arg3.getString(this.mLabelIndex));
                        RecycleListView v1 = this.val$listView;
                        int v2 = arg3.getPosition();
                        int v0 = arg3.getInt(this.mIsCheckedIndex);
                        boolean v3 = true;
                        if(v0 == 1) {
                        }
                        else {
                            v3 = false;
                        }

                        v1.setItemChecked(v2, v3);
                    }

                    public View newView(Context arg1, Cursor arg2, ViewGroup arg3) {
                        return AlertParams.this.mInflater.inflate(this.val$dialog.mMultiChoiceItemLayout, arg3, false);
                    }
                };
            }

        label_54:
            OnPrepareListViewListener v0_1 = this.mOnPrepareListViewListener;
            if(v0_1 != null) {
                v0_1.onPrepareListView(((ListView)v5));
            }

            v6.mAdapter = ((ListAdapter)v7_1);
            v6.mCheckedItem = this.mCheckedItem;
            if(this.mOnClickListener != null) {
                ((RecycleListView)v5).setOnItemClickListener(new AdapterView$OnItemClickListener(v6) {
                    public void onItemClick(AdapterView arg1, View arg2, int arg3, long arg4) {
                        AlertParams.this.mOnClickListener.onClick(this.val$dialog.mDialog, arg3);
                        if(!AlertParams.this.mIsSingleChoice) {
                            this.val$dialog.mDialog.dismiss();
                        }
                    }
                });
            }
            else if(this.mOnCheckboxClickListener != null) {
                ((RecycleListView)v5).setOnItemClickListener(new AdapterView$OnItemClickListener(((RecycleListView)v5), v6) {
                    public void onItemClick(AdapterView arg1, View arg2, int arg3, long arg4) {
                        if(AlertParams.this.mCheckedItems != null) {
                            AlertParams.this.mCheckedItems[arg3] = this.val$listView.isItemChecked(arg3);
                        }

                        AlertParams.this.mOnCheckboxClickListener.onClick(this.val$dialog.mDialog, arg3, this.val$listView.isItemChecked(arg3));
                    }
                });
            }

            AdapterView$OnItemSelectedListener v0_2 = this.mOnItemSelectedListener;
            if(v0_2 != null) {
                ((RecycleListView)v5).setOnItemSelectedListener(v0_2);
            }

            if(this.mIsSingleChoice) {
                ((RecycleListView)v5).setChoiceMode(1);
            }
            else if(this.mIsMultiChoice) {
                ((RecycleListView)v5).setChoiceMode(2);
            }

            v6.mListView = ((ListView)v5);
        }
    }

    final class ButtonHandler extends Handler {
        private static final int MSG_DISMISS_DIALOG = 1;
        private WeakReference mDialog;

        public ButtonHandler(DialogInterface arg2) {
            super();
            this.mDialog = new WeakReference(arg2);
        }

        public void handleMessage(Message arg3) {
            int v0 = arg3.what;
            if(v0 != -3 && v0 != -2 && v0 != -1) {
                if(v0 != 1) {
                    return;
                }
                else {
                    arg3.obj.dismiss();
                    return;
                }
            }

            arg3.obj.onClick(this.mDialog.get(), arg3.what);
        }
    }

    class CheckedItemAdapter extends ArrayAdapter {
        public CheckedItemAdapter(Context arg1, int arg2, int arg3, CharSequence[] arg4) {
            super(arg1, arg2, arg3, ((Object[])arg4));
        }

        public long getItemId(int arg1) {
            return ((long)arg1);
        }

        public boolean hasStableIds() {
            return 1;
        }
    }

    public class RecycleListView extends ListView {
        private final int mPaddingBottomNoButtons;
        private final int mPaddingTopNoTitle;

        public RecycleListView(Context arg2) {
            this(arg2, null);
        }

        public RecycleListView(Context arg2, AttributeSet arg3) {
            super(arg2, arg3);
            TypedArray v2 = arg2.obtainStyledAttributes(arg3, styleable.RecycleListView);
            this.mPaddingBottomNoButtons = v2.getDimensionPixelOffset(styleable.RecycleListView_paddingBottomNoButtons, -1);
            this.mPaddingTopNoTitle = v2.getDimensionPixelOffset(styleable.RecycleListView_paddingTopNoTitle, -1);
        }

        public void setHasDecor(boolean arg3, boolean arg4) {
            if(arg4) {
                if(!arg3) {
                }
                else {
                    return;
                }
            }

            int v0 = this.getPaddingLeft();
            int v3 = arg3 ? this.getPaddingTop() : this.mPaddingTopNoTitle;
            int v1 = this.getPaddingRight();
            int v4 = arg4 ? this.getPaddingBottom() : this.mPaddingBottomNoButtons;
            this.setPadding(v0, v3, v1, v4);
        }
    }

    ListAdapter mAdapter;
    private int mAlertDialogLayout;
    private final View$OnClickListener mButtonHandler;
    private final int mButtonIconDimen;
    Button mButtonNegative;
    private Drawable mButtonNegativeIcon;
    Message mButtonNegativeMessage;
    private CharSequence mButtonNegativeText;
    Button mButtonNeutral;
    private Drawable mButtonNeutralIcon;
    Message mButtonNeutralMessage;
    private CharSequence mButtonNeutralText;
    private int mButtonPanelLayoutHint;
    private int mButtonPanelSideLayout;
    Button mButtonPositive;
    private Drawable mButtonPositiveIcon;
    Message mButtonPositiveMessage;
    private CharSequence mButtonPositiveText;
    int mCheckedItem;
    private final Context mContext;
    private View mCustomTitleView;
    final AppCompatDialog mDialog;
    Handler mHandler;
    private Drawable mIcon;
    private int mIconId;
    private ImageView mIconView;
    int mListItemLayout;
    int mListLayout;
    ListView mListView;
    private CharSequence mMessage;
    private TextView mMessageView;
    int mMultiChoiceItemLayout;
    NestedScrollView mScrollView;
    private boolean mShowTitle;
    int mSingleChoiceItemLayout;
    private CharSequence mTitle;
    private TextView mTitleView;
    private View mView;
    private int mViewLayoutResId;
    private int mViewSpacingBottom;
    private int mViewSpacingLeft;
    private int mViewSpacingRight;
    private boolean mViewSpacingSpecified;
    private int mViewSpacingTop;
    private final Window mWindow;

    public AlertController(Context arg4, AppCompatDialog arg5, Window arg6) {
        super();
        this.mViewSpacingSpecified = false;
        this.mIconId = 0;
        this.mCheckedItem = -1;
        this.mButtonPanelLayoutHint = 0;
        this.mButtonHandler = new androidx.appcompat.app.AlertController$1(this);
        this.mContext = arg4;
        this.mDialog = arg5;
        this.mWindow = arg6;
        this.mHandler = new ButtonHandler(((DialogInterface)arg5));
        TypedArray v4 = arg4.obtainStyledAttributes(null, styleable.AlertDialog, attr.alertDialogStyle, 0);
        this.mAlertDialogLayout = v4.getResourceId(styleable.AlertDialog_android_layout, 0);
        this.mButtonPanelSideLayout = v4.getResourceId(styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.mListLayout = v4.getResourceId(styleable.AlertDialog_listLayout, 0);
        this.mMultiChoiceItemLayout = v4.getResourceId(styleable.AlertDialog_multiChoiceItemLayout, 0);
        this.mSingleChoiceItemLayout = v4.getResourceId(styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.mListItemLayout = v4.getResourceId(styleable.AlertDialog_listItemLayout, 0);
        this.mShowTitle = v4.getBoolean(styleable.AlertDialog_showTitle, true);
        this.mButtonIconDimen = v4.getDimensionPixelSize(styleable.AlertDialog_buttonIconDimen, 0);
        v4.recycle();
        arg5.supportRequestWindowFeature(1);
    }

    static boolean canTextInput(View arg4) {
        if(arg4.onCheckIsTextEditor()) {
            return 1;
        }

        if(!(arg4 instanceof ViewGroup)) {
            return 0;
        }

        int v0 = ((ViewGroup)arg4).getChildCount();
        do {
            if(v0 <= 0) {
                return 0;
            }

            --v0;
        }
        while(!AlertController.canTextInput(((ViewGroup)arg4).getChildAt(v0)));

        return 1;
    }

    private void centerButton(Button arg2) {
        ViewGroup$LayoutParams v1 = arg2.getLayoutParams();
        ((LinearLayout$LayoutParams)v1).gravity = 1;
        ((LinearLayout$LayoutParams)v1).weight = 0.5f;
        arg2.setLayoutParams(v1);
    }

    public Button getButton(int arg2) {
        if(arg2 != -3) {
            if(arg2 != -2) {
                if(arg2 != -1) {
                    return null;
                }

                return this.mButtonPositive;
            }

            return this.mButtonNegative;
        }

        return this.mButtonNeutral;
    }

    public int getIconAttributeResId(int arg3) {
        TypedValue v0 = new TypedValue();
        this.mContext.getTheme().resolveAttribute(arg3, v0, true);
        return v0.resourceId;
    }

    public ListView getListView() {
        return this.mListView;
    }

    public void installContent() {
        this.mDialog.setContentView(this.selectContentView());
        this.setupView();
    }

    static void manageScrollIndicators(View arg3, View arg4, View arg5) {
        int v0 = 0;
        int v1 = 4;
        if(arg4 != null) {
            int v2 = arg3.canScrollVertically(-1) ? 0 : v1;
            arg4.setVisibility(v2);
        }

        if(arg5 != null) {
            if(arg3.canScrollVertically(1)) {
            }
            else {
                v0 = v1;
            }

            arg5.setVisibility(v0);
        }
    }

    public boolean onKeyDown(int arg1, KeyEvent arg2) {
        NestedScrollView v0 = this.mScrollView;
        if(v0 != null && (v0.executeKeyEvent(arg2))) {
            return 1;
        }

        return 0;
    }

    public boolean onKeyUp(int arg1, KeyEvent arg2) {
        NestedScrollView v0 = this.mScrollView;
        if(v0 != null && (v0.executeKeyEvent(arg2))) {
            return 1;
        }

        return 0;
    }

    private ViewGroup resolvePanel(View arg2, View arg3) {
        if(arg2 == null) {
            if((arg3 instanceof ViewStub)) {
                arg3 = ((ViewStub)arg3).inflate();
            }

            return arg3;
        }

        if(arg3 != null) {
            ViewParent v1 = arg3.getParent();
            if((v1 instanceof ViewGroup)) {
                ((ViewGroup)v1).removeView(arg3);
            }
        }

        if((arg2 instanceof ViewStub)) {
            arg2 = ((ViewStub)arg2).inflate();
        }

        return arg2;
    }

    private int selectContentView() {
        int v0 = this.mButtonPanelSideLayout;
        if(v0 == 0) {
            return this.mAlertDialogLayout;
        }

        if(this.mButtonPanelLayoutHint == 1) {
            return v0;
        }

        return this.mAlertDialogLayout;
    }

    public void setButton(int arg1, CharSequence arg2, DialogInterface$OnClickListener arg3, Message arg4, Drawable arg5) {
        if(arg4 == null && arg3 != null) {
            arg4 = this.mHandler.obtainMessage(arg1, arg3);
        }

        if(arg1 != -3) {
            if(arg1 != -2) {
                if(arg1 == -1) {
                    this.mButtonPositiveText = arg2;
                    this.mButtonPositiveMessage = arg4;
                    this.mButtonPositiveIcon = arg5;
                    return;
                }

                throw new IllegalArgumentException("Button does not exist");
            }

            this.mButtonNegativeText = arg2;
            this.mButtonNegativeMessage = arg4;
            this.mButtonNegativeIcon = arg5;
            return;
        }

        this.mButtonNeutralText = arg2;
        this.mButtonNeutralMessage = arg4;
        this.mButtonNeutralIcon = arg5;
    }

    public void setButtonPanelLayoutHint(int arg1) {
        this.mButtonPanelLayoutHint = arg1;
    }

    public void setCustomTitle(View arg1) {
        this.mCustomTitleView = arg1;
    }

    public void setIcon(int arg2) {
        this.mIcon = null;
        this.mIconId = arg2;
        ImageView v0 = this.mIconView;
        if(v0 != null) {
            if(arg2 != 0) {
                v0.setVisibility(0);
                this.mIconView.setImageResource(this.mIconId);
                return;
            }
            else {
                v0.setVisibility(8);
            }
        }
    }

    public void setIcon(Drawable arg3) {
        this.mIcon = arg3;
        this.mIconId = 0;
        ImageView v1 = this.mIconView;
        if(v1 != null) {
            if(arg3 != null) {
                v1.setVisibility(0);
                this.mIconView.setImageDrawable(arg3);
                return;
            }
            else {
                v1.setVisibility(8);
            }
        }
    }

    public void setMessage(CharSequence arg1) {
        this.mMessage = arg1;
        TextView v0 = this.mMessageView;
        if(v0 != null) {
            v0.setText(arg1);
        }
    }

    private void setScrollIndicators(ViewGroup arg3, View arg4, int arg5, int arg6) {
        View v0 = this.mWindow.findViewById(id.scrollIndicatorUp);
        View v2 = this.mWindow.findViewById(id.scrollIndicatorDown);
        ViewCompat.setScrollIndicators(arg4, arg5, arg6);
        if(v0 != null) {
            arg3.removeView(v0);
        }

        if(v2 != null) {
            arg3.removeView(v2);
        }
    }

    public void setTitle(CharSequence arg1) {
        this.mTitle = arg1;
        TextView v0 = this.mTitleView;
        if(v0 != null) {
            v0.setText(arg1);
        }
    }

    public void setView(int arg2) {
        this.mView = null;
        this.mViewLayoutResId = arg2;
        this.mViewSpacingSpecified = false;
    }

    public void setView(View arg1) {
        this.mView = arg1;
        this.mViewLayoutResId = 0;
        this.mViewSpacingSpecified = false;
    }

    public void setView(View arg1, int arg2, int arg3, int arg4, int arg5) {
        this.mView = arg1;
        this.mViewLayoutResId = 0;
        this.mViewSpacingSpecified = true;
        this.mViewSpacingLeft = arg2;
        this.mViewSpacingTop = arg3;
        this.mViewSpacingRight = arg4;
        this.mViewSpacingBottom = arg5;
    }

    private void setupButtons(ViewGroup arg8) {
        Drawable v5_1;
        int v0_1;
        View v0 = arg8.findViewById(0x1020019);
        this.mButtonPositive = ((Button)v0);
        ((Button)v0).setOnClickListener(this.mButtonHandler);
        int v1 = 8;
        Drawable v2 = null;
        if(!TextUtils.isEmpty(this.mButtonPositiveText) || this.mButtonPositiveIcon != null) {
            this.mButtonPositive.setText(this.mButtonPositiveText);
            Drawable v0_2 = this.mButtonPositiveIcon;
            if(v0_2 != null) {
                v0_2.setBounds(0, 0, this.mButtonIconDimen, this.mButtonIconDimen);
                this.mButtonPositive.setCompoundDrawables(this.mButtonPositiveIcon, v2, v2, v2);
            }

            this.mButtonPositive.setVisibility(0);
            v0_1 = 1;
        }
        else {
            this.mButtonPositive.setVisibility(v1);
            v0_1 = 0;
        }

        View v5 = arg8.findViewById(0x102001A);
        this.mButtonNegative = ((Button)v5);
        ((Button)v5).setOnClickListener(this.mButtonHandler);
        if(!TextUtils.isEmpty(this.mButtonNegativeText) || this.mButtonNegativeIcon != null) {
            this.mButtonNegative.setText(this.mButtonNegativeText);
            v5_1 = this.mButtonNegativeIcon;
            if(v5_1 != null) {
                v5_1.setBounds(0, 0, this.mButtonIconDimen, this.mButtonIconDimen);
                this.mButtonNegative.setCompoundDrawables(this.mButtonNegativeIcon, v2, v2, v2);
            }

            this.mButtonNegative.setVisibility(0);
            v0_1 |= 2;
        }
        else {
            this.mButtonNegative.setVisibility(v1);
        }

        v5 = arg8.findViewById(0x102001B);
        this.mButtonNeutral = ((Button)v5);
        ((Button)v5).setOnClickListener(this.mButtonHandler);
        if(!TextUtils.isEmpty(this.mButtonNeutralText) || this.mButtonNeutralIcon != null) {
            this.mButtonNeutral.setText(this.mButtonNeutralText);
            v5_1 = this.mButtonNeutralIcon;
            if(v5_1 != null) {
                v5_1.setBounds(0, 0, this.mButtonIconDimen, this.mButtonIconDimen);
                this.mButtonNeutral.setCompoundDrawables(this.mButtonNeutralIcon, v2, v2, v2);
            }

            this.mButtonNeutral.setVisibility(0);
            v0_1 |= 4;
        }
        else {
            this.mButtonNeutral.setVisibility(v1);
        }

        if(AlertController.shouldCenterSingleButton(this.mContext)) {
            if(v0_1 == 1) {
                this.centerButton(this.mButtonPositive);
            }
            else if(v0_1 == 2) {
                this.centerButton(this.mButtonNegative);
            }
            else if(v0_1 == 4) {
                this.centerButton(this.mButtonNeutral);
            }
        }

        if(v0_1 != 0) {
            return;
        }

        arg8.setVisibility(v1);
    }

    private void setupContent(ViewGroup arg4) {
        View v0 = this.mWindow.findViewById(id.scrollView);
        this.mScrollView = ((NestedScrollView)v0);
        ((NestedScrollView)v0).setFocusable(false);
        this.mScrollView.setNestedScrollingEnabled(false);
        v0 = arg4.findViewById(0x102000B);
        this.mMessageView = ((TextView)v0);
        if(v0 == null) {
            return;
        }

        CharSequence v1 = this.mMessage;
        if(v1 != null) {
            ((TextView)v0).setText(v1);
            return;
        }

        int v1_1 = 8;
        ((TextView)v0).setVisibility(v1_1);
        this.mScrollView.removeView(this.mMessageView);
        if(this.mListView != null) {
            ViewParent v4 = this.mScrollView.getParent();
            int v0_1 = ((ViewGroup)v4).indexOfChild(this.mScrollView);
            ((ViewGroup)v4).removeViewAt(v0_1);
            ((ViewGroup)v4).addView(this.mListView, v0_1, new ViewGroup$LayoutParams(-1, -1));
            return;
        }

        arg4.setVisibility(v1_1);
    }

    private void setupCustomContent(ViewGroup arg6) {
        View v0 = this.mView;
        int v1 = 0;
        if(v0 != null) {
        }
        else if(this.mViewLayoutResId != 0) {
            v0 = LayoutInflater.from(this.mContext).inflate(this.mViewLayoutResId, arg6, false);
        }
        else {
            v0 = null;
        }

        if(v0 != null) {
            v1 = 1;
        }

        if(v1 == 0 || !AlertController.canTextInput(v0)) {
            this.mWindow.setFlags(0x20000, 0x20000);
        }

        if(v1 != 0) {
            View v1_1 = this.mWindow.findViewById(id.custom);
            ((FrameLayout)v1_1).addView(v0, new ViewGroup$LayoutParams(-1, -1));
            if(this.mViewSpacingSpecified) {
                ((FrameLayout)v1_1).setPadding(this.mViewSpacingLeft, this.mViewSpacingTop, this.mViewSpacingRight, this.mViewSpacingBottom);
            }

            if(this.mListView != null) {
                arg6.getLayoutParams().weight = 0f;
            }

            return;
        }

        arg6.setVisibility(8);
    }

    private void setupTitle(ViewGroup arg6) {
        int v1 = 8;
        if(this.mCustomTitleView != null) {
            arg6.addView(this.mCustomTitleView, 0, new ViewGroup$LayoutParams(-1, -2));
            this.mWindow.findViewById(id.title_template).setVisibility(v1);
            return;
        }

        this.mIconView = this.mWindow.findViewById(0x1020006);
        if(!TextUtils.isEmpty(this.mTitle) && (this.mShowTitle)) {
            View v6 = this.mWindow.findViewById(id.alertTitle);
            this.mTitleView = ((TextView)v6);
            ((TextView)v6).setText(this.mTitle);
            int v6_1 = this.mIconId;
            if(v6_1 != 0) {
                this.mIconView.setImageResource(v6_1);
                return;
            }
            else {
                Drawable v6_2 = this.mIcon;
                if(v6_2 != null) {
                    this.mIconView.setImageDrawable(v6_2);
                    return;
                }
                else {
                    this.mTitleView.setPadding(this.mIconView.getPaddingLeft(), this.mIconView.getPaddingTop(), this.mIconView.getPaddingRight(), this.mIconView.getPaddingBottom());
                    this.mIconView.setVisibility(v1);
                    return;
                }
            }
        }

        this.mWindow.findViewById(id.title_template).setVisibility(v1);
        this.mIconView.setVisibility(v1);
        arg6.setVisibility(v1);
    }

    private void setupView() {
        NestedScrollView v0_3;
        ListView v0_2;
        View v0 = this.mWindow.findViewById(id.parentPanel);
        View v1 = v0.findViewById(id.topPanel);
        View v2 = v0.findViewById(id.contentPanel);
        View v3 = v0.findViewById(id.buttonPanel);
        v0 = v0.findViewById(id.customPanel);
        this.setupCustomContent(((ViewGroup)v0));
        View v4 = ((ViewGroup)v0).findViewById(id.topPanel);
        View v5 = ((ViewGroup)v0).findViewById(id.contentPanel);
        View v6 = ((ViewGroup)v0).findViewById(id.buttonPanel);
        ViewGroup v1_1 = this.resolvePanel(v4, v1);
        ViewGroup v2_1 = this.resolvePanel(v5, v2);
        ViewGroup v3_1 = this.resolvePanel(v6, v3);
        this.setupContent(v2_1);
        this.setupButtons(v3_1);
        this.setupTitle(v1_1);
        int v4_1 = 8;
        int v6_1 = 0;
        int v0_1 = v0 == null || ((ViewGroup)v0).getVisibility() == v4_1 ? 0 : 1;
        boolean v7 = v1_1 == null || v1_1.getVisibility() == v4_1 ? false : true;
        boolean v3_2 = v3_1 == null || v3_1.getVisibility() == v4_1 ? false : true;
        if(!v3_2 && v2_1 != null) {
            v4 = v2_1.findViewById(id.textSpacerNoButtons);
            if(v4 != null) {
                v4.setVisibility(0);
            }
        }

        if(v7) {
            NestedScrollView v4_2 = this.mScrollView;
            if(v4_2 != null) {
                v4_2.setClipToPadding(true);
            }

            v1 = this.mMessage != null || this.mListView != null ? v1_1.findViewById(id.titleDividerNoCustom) : null;
            if(v1 == null) {
                goto label_72;
            }

            v1.setVisibility(0);
        }
        else {
            if(v2_1 == null) {
                goto label_72;
            }

            v1 = v2_1.findViewById(id.textSpacerNoTitle);
            if(v1 == null) {
                goto label_72;
            }

            v1.setVisibility(0);
        }

    label_72:
        ListView v1_2 = this.mListView;
        if((v1_2 instanceof RecycleListView)) {
            ((RecycleListView)v1_2).setHasDecor(v7, v3_2);
        }

        if(v0_1 == 0) {
            v0_2 = this.mListView;
            if(v0_2 != null) {
            }
            else {
                v0_3 = this.mScrollView;
            }

            if((((ListView)v0_3)) == null) {
                goto label_87;
            }

            if(v3_2) {
                v6_1 = 2;
            }

            this.setScrollIndicators(v2_1, ((View)v0_3), (((int)v7)) | v6_1, 3);
        }

    label_87:
        v0_2 = this.mListView;
        if(v0_2 != null) {
            ListAdapter v1_3 = this.mAdapter;
            if(v1_3 != null) {
                v0_2.setAdapter(v1_3);
                int v8 = this.mCheckedItem;
                if(v8 > -1) {
                    v0_2.setItemChecked(v8, true);
                    v0_2.setSelection(v8);
                }
            }
        }
    }

    private static boolean shouldCenterSingleButton(Context arg3) {
        TypedValue v0 = new TypedValue();
        arg3.getTheme().resolveAttribute(attr.alertDialogCenterButtons, v0, true);
        if(v0.data != 0) {
            return 1;
        }

        return 0;
    }
}

