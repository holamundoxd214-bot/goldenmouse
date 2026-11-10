package androidx.appcompat.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable$ClassLoaderCreator;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent$DispatcherState;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View$MeasureSpec;
import android.view.View$OnClickListener;
import android.view.View$OnFocusChangeListener;
import android.view.View$OnKeyListener;
import android.view.View$OnLayoutChangeListener;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView$OnItemClickListener;
import android.widget.AdapterView$OnItemSelectedListener;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView$OnEditorActionListener;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.core.view.ViewCompat;
import androidx.cursoradapter.widget.CursorAdapter;
import androidx.customview.view.AbsSavedState;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public class SearchView extends LinearLayoutCompat implements CollapsibleActionView {
    class androidx.appcompat.widget.SearchView$10 implements TextWatcher {
        androidx.appcompat.widget.SearchView$10(SearchView arg1) {
            SearchView.this = arg1;
            super();
        }

        public void afterTextChanged(Editable arg1) {
        }

        public void beforeTextChanged(CharSequence arg1, int arg2, int arg3, int arg4) {
        }

        public void onTextChanged(CharSequence arg1, int arg2, int arg3, int arg4) {
            SearchView.this.onTextChanged(arg1);
        }
    }

    class androidx.appcompat.widget.SearchView$1 implements Runnable {
        androidx.appcompat.widget.SearchView$1(SearchView arg1) {
            SearchView.this = arg1;
            super();
        }

        public void run() {
            SearchView.this.updateFocusedState();
        }
    }

    class androidx.appcompat.widget.SearchView$2 implements Runnable {
        androidx.appcompat.widget.SearchView$2(SearchView arg1) {
            SearchView.this = arg1;
            super();
        }

        public void run() {
            if((SearchView.this.mSuggestionsAdapter instanceof SuggestionsAdapter)) {
                SearchView.this.mSuggestionsAdapter.changeCursor(null);
            }
        }
    }

    class androidx.appcompat.widget.SearchView$5 implements View$OnClickListener {
        androidx.appcompat.widget.SearchView$5(SearchView arg1) {
            SearchView.this = arg1;
            super();
        }

        public void onClick(View arg3) {
            ImageView v0 = SearchView.this.mSearchButton;
            SearchView v1 = SearchView.this;
            if(arg3 == (((View)v0))) {
                v1.onSearchClicked();
                return;
            }

            v0 = v1.mCloseButton;
            v1 = SearchView.this;
            if(arg3 == (((View)v0))) {
                v1.onCloseClicked();
                return;
            }

            v0 = v1.mGoButton;
            v1 = SearchView.this;
            if(arg3 == (((View)v0))) {
                v1.onSubmitQuery();
                return;
            }

            v0 = v1.mVoiceButton;
            v1 = SearchView.this;
            if(arg3 == (((View)v0))) {
                v1.onVoiceClicked();
                return;
            }

            if(arg3 == v1.mSearchSrcTextView) {
                SearchView.this.forceSuggestionQuery();
            }
        }
    }

    class androidx.appcompat.widget.SearchView$6 implements View$OnKeyListener {
        androidx.appcompat.widget.SearchView$6(SearchView arg1) {
            SearchView.this = arg1;
            super();
        }

        public boolean onKey(View arg4, int arg5, KeyEvent arg6) {
            if(SearchView.this.mSearchable == null) {
                return 0;
            }

            if((SearchView.this.mSearchSrcTextView.isPopupShowing()) && SearchView.this.mSearchSrcTextView.getListSelection() != -1) {
                return SearchView.this.onSuggestionsKey(arg4, arg5, arg6);
            }

            if(!SearchView.this.mSearchSrcTextView.isEmpty() && (arg6.hasNoModifiers()) && arg6.getAction() == 1 && arg5 == 66) {
                arg4.cancelLongPress();
                SearchView.this.launchQuerySearch(0, null, SearchView.this.mSearchSrcTextView.getText().toString());
                return 1;
            }

            return 0;
        }
    }

    class androidx.appcompat.widget.SearchView$7 implements TextView$OnEditorActionListener {
        androidx.appcompat.widget.SearchView$7(SearchView arg1) {
            SearchView.this = arg1;
            super();
        }

        public boolean onEditorAction(TextView arg1, int arg2, KeyEvent arg3) {
            SearchView.this.onSubmitQuery();
            return 1;
        }
    }

    class androidx.appcompat.widget.SearchView$8 implements AdapterView$OnItemClickListener {
        androidx.appcompat.widget.SearchView$8(SearchView arg1) {
            SearchView.this = arg1;
            super();
        }

        public void onItemClick(AdapterView arg1, View arg2, int arg3, long arg4) {
            SearchView.this.onItemClicked(arg3, 0, null);
        }
    }

    class androidx.appcompat.widget.SearchView$9 implements AdapterView$OnItemSelectedListener {
        androidx.appcompat.widget.SearchView$9(SearchView arg1) {
            SearchView.this = arg1;
            super();
        }

        public void onItemSelected(AdapterView arg1, View arg2, int arg3, long arg4) {
            SearchView.this.onItemSelected(arg3);
        }

        public void onNothingSelected(AdapterView arg1) {
        }
    }

    class Api29Impl {
        private Api29Impl() {
            super();
        }

        static void refreshAutoCompleteResults(AutoCompleteTextView arg0) {
            arg0.refreshAutoCompleteResults();
        }

        static void setInputMethodMode(SearchAutoComplete arg0, int arg1) {
            arg0.setInputMethodMode(arg1);
        }
    }

    public interface OnCloseListener {
        boolean onClose();
    }

    public interface OnQueryTextListener {
        boolean onQueryTextChange(String arg1);

        boolean onQueryTextSubmit(String arg1);
    }

    public interface OnSuggestionListener {
        boolean onSuggestionClick(int arg1);

        boolean onSuggestionSelect(int arg1);
    }

    class PreQAutoCompleteTextViewReflector {
        private Method mDoAfterTextChanged;
        private Method mDoBeforeTextChanged;
        private Method mEnsureImeVisible;

        PreQAutoCompleteTextViewReflector() {
            Method v2;
            super();
            this.mDoBeforeTextChanged = null;
            this.mDoAfterTextChanged = null;
            this.mEnsureImeVisible = null;
            PreQAutoCompleteTextViewReflector.preApi29Check();
            try {
                v2 = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged");
                this.mDoBeforeTextChanged = v2;
                v2.setAccessible(true);
                goto label_14;
            }
            catch(NoSuchMethodException ) {
                try {
                label_14:
                    v2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged");
                    this.mDoAfterTextChanged = v2;
                    v2.setAccessible(true);
                    goto label_20;
                }
                catch(NoSuchMethodException ) {
                    try {
                    label_20:
                        Method v0 = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                        this.mEnsureImeVisible = v0;
                        v0.setAccessible(true);
                        return;
                    }
                    catch(NoSuchMethodException ) {
                        return;
                    }
                }
            }
        }

        void doAfterTextChanged(AutoCompleteTextView arg2) {
            PreQAutoCompleteTextViewReflector.preApi29Check();
            Method v1 = this.mDoAfterTextChanged;
            if(v1 != null) {
                try {
                    v1.invoke(arg2);
                    return;
                }
                catch(Exception ) {
                    return;
                }
            }
        }

        void doBeforeTextChanged(AutoCompleteTextView arg2) {
            PreQAutoCompleteTextViewReflector.preApi29Check();
            Method v1 = this.mDoBeforeTextChanged;
            if(v1 != null) {
                try {
                    v1.invoke(arg2);
                    return;
                }
                catch(Exception ) {
                    return;
                }
            }
        }

        void ensureImeVisible(AutoCompleteTextView arg2) {
            PreQAutoCompleteTextViewReflector.preApi29Check();
            Method v1 = this.mEnsureImeVisible;
            if(v1 != null) {
                try {
                    v1.invoke(arg2, Boolean.valueOf(true));
                    return;
                }
                catch(Exception ) {
                    return;
                }
            }
        }

        private static void preApi29Check() {
            if(Build$VERSION.SDK_INT < 29) {
                return;
            }

            throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
        }
    }

    class SavedState extends AbsSavedState {
        class androidx.appcompat.widget.SearchView$SavedState$1 implements Parcelable$ClassLoaderCreator {
            androidx.appcompat.widget.SearchView$SavedState$1() {
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
        boolean isIconified;

        static {
            SavedState.CREATOR = new androidx.appcompat.widget.SearchView$SavedState$1();
        }

        SavedState(Parcelable arg1) {
            super(arg1);
        }

        public SavedState(Parcel arg1, ClassLoader arg2) {
            super(arg1, arg2);
            this.isIconified = arg1.readValue(null).booleanValue();
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.isIconified + "}";
        }

        public void writeToParcel(Parcel arg1, int arg2) {
            super.writeToParcel(arg1, arg2);
            arg1.writeValue(Boolean.valueOf(this.isIconified));
        }
    }

    public class SearchAutoComplete extends AppCompatAutoCompleteTextView {
        class androidx.appcompat.widget.SearchView$SearchAutoComplete$1 implements Runnable {
            androidx.appcompat.widget.SearchView$SearchAutoComplete$1(SearchAutoComplete arg1) {
                SearchAutoComplete.this = arg1;
                super();
            }

            public void run() {
                SearchAutoComplete.this.showSoftInputIfNecessary();
            }
        }

        private boolean mHasPendingShowSoftInputRequest;
        final Runnable mRunShowSoftInputIfNecessary;
        private SearchView mSearchView;
        private int mThreshold;

        public SearchAutoComplete(Context arg2) {
            this(arg2, null);
        }

        public SearchAutoComplete(Context arg2, AttributeSet arg3) {
            this(arg2, arg3, attr.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context arg1, AttributeSet arg2, int arg3) {
            super(arg1, arg2, arg3);
            this.mRunShowSoftInputIfNecessary = new androidx.appcompat.widget.SearchView$SearchAutoComplete$1(this);
            this.mThreshold = this.getThreshold();
        }

        public boolean enoughToFilter() {
            if(this.mThreshold > 0) {
                if(super.enoughToFilter()) {
                }
                else {
                    return 0;
                }
            }

            return 1;
        }

        void ensureImeVisible() {
            if(Build$VERSION.SDK_INT >= 29) {
                Api29Impl.setInputMethodMode(this, 1);
                if(this.enoughToFilter()) {
                    this.showDropDown();
                }

                return;
            }

            SearchView.PRE_API_29_HIDDEN_METHOD_INVOKER.ensureImeVisible(((AutoCompleteTextView)this));
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration v3 = this.getResources().getConfiguration();
            int v0 = v3.screenWidthDp;
            int v1 = v3.screenHeightDp;
            if(v0 >= 960 && v1 >= 720 && v3.orientation == 2) {
                return 0x100;
            }

            if(v0 < 600 && (v0 < 640 || v1 < 480)) {
                return 0xA0;
            }

            return 0xC0;
        }

        boolean isEmpty() {
            if(TextUtils.getTrimmedLength(this.getText()) == 0) {
                return 1;
            }

            return 0;
        }

        public InputConnection onCreateInputConnection(EditorInfo arg2) {
            InputConnection v2 = super.onCreateInputConnection(arg2);
            if(this.mHasPendingShowSoftInputRequest) {
                this.removeCallbacks(this.mRunShowSoftInputIfNecessary);
                this.post(this.mRunShowSoftInputIfNecessary);
            }

            return v2;
        }

        protected void onFinishInflate() {
            super.onFinishInflate();
            this.setMinWidth(((int)TypedValue.applyDimension(1, ((float)this.getSearchViewTextMinWidthDp()), this.getResources().getDisplayMetrics())));
        }

        protected void onFocusChanged(boolean arg1, int arg2, Rect arg3) {
            super.onFocusChanged(arg1, arg2, arg3);
            this.mSearchView.onTextFocusChanged();
        }

        public boolean onKeyPreIme(int arg3, KeyEvent arg4) {
            if(arg3 == 4) {
                if(arg4.getAction() == 0 && arg4.getRepeatCount() == 0) {
                    KeyEvent$DispatcherState v3 = this.getKeyDispatcherState();
                    if(v3 != null) {
                        v3.startTracking(arg4, this);
                    }

                    return 1;
                }

                if(arg4.getAction() != 1) {
                    goto label_25;
                }

                KeyEvent$DispatcherState v0 = this.getKeyDispatcherState();
                if(v0 != null) {
                    v0.handleUpEvent(arg4);
                }

                if(!arg4.isTracking()) {
                    goto label_25;
                }

                if(arg4.isCanceled()) {
                    goto label_25;
                }

                this.mSearchView.clearFocus();
                this.setImeVisibility(false);
                return 1;
            }

        label_25:
            return super.onKeyPreIme(arg3, arg4);
        }

        public void onWindowFocusChanged(boolean arg1) {
            super.onWindowFocusChanged(arg1);
            if((arg1) && (this.mSearchView.hasFocus()) && this.getVisibility() == 0) {
                this.mHasPendingShowSoftInputRequest = true;
                if(SearchView.isLandscapeMode(this.getContext())) {
                    this.ensureImeVisible();
                }
            }
        }

        public void performCompletion() {
        }

        protected void replaceText(CharSequence arg1) {
        }

        void setImeVisibility(boolean arg3) {
            Object v0 = this.getContext().getSystemService("input_method");
            if(!arg3) {
                this.mHasPendingShowSoftInputRequest = false;
                this.removeCallbacks(this.mRunShowSoftInputIfNecessary);
                ((InputMethodManager)v0).hideSoftInputFromWindow(this.getWindowToken(), 0);
                return;
            }

            if(((InputMethodManager)v0).isActive(((View)this))) {
                this.mHasPendingShowSoftInputRequest = false;
                this.removeCallbacks(this.mRunShowSoftInputIfNecessary);
                ((InputMethodManager)v0).showSoftInput(((View)this), 0);
                return;
            }

            this.mHasPendingShowSoftInputRequest = true;
        }

        void setSearchView(SearchView arg1) {
            this.mSearchView = arg1;
        }

        public void setThreshold(int arg1) {
            super.setThreshold(arg1);
            this.mThreshold = arg1;
        }

        void showSoftInputIfNecessary() {
            if(this.mHasPendingShowSoftInputRequest) {
                this.getContext().getSystemService("input_method").showSoftInput(((View)this), 0);
                this.mHasPendingShowSoftInputRequest = false;
            }
        }
    }

    class UpdatableTouchDelegate extends TouchDelegate {
        private final Rect mActualBounds;
        private boolean mDelegateTargeted;
        private final View mDelegateView;
        private final int mSlop;
        private final Rect mSlopBounds;
        private final Rect mTargetBounds;

        public UpdatableTouchDelegate(Rect arg2, Rect arg3, View arg4) {
            super(arg2, arg4);
            this.mSlop = ViewConfiguration.get(arg4.getContext()).getScaledTouchSlop();
            this.mTargetBounds = new Rect();
            this.mSlopBounds = new Rect();
            this.mActualBounds = new Rect();
            this.setBounds(arg2, arg3);
            this.mDelegateView = arg4;
        }

        public boolean onTouchEvent(MotionEvent arg9) {
            boolean v2_1;
            int v0 = ((int)arg9.getX());
            int v1 = ((int)arg9.getY());
            int v2 = arg9.getAction();
            int v3 = 2;
            boolean v5 = true;
            if(v2 != 0) {
                if(v2 == 1 || v2 == v3) {
                    v2_1 = this.mDelegateTargeted;
                    if((v2_1) && !this.mSlopBounds.contains(v0, v1)) {
                        v5 = v2_1;
                        v2 = 0;
                        goto label_37;
                    }
                }
                else if(v2 != 3) {
                    goto label_35;
                }
                else {
                    v2_1 = this.mDelegateTargeted;
                    this.mDelegateTargeted = false;
                }

                v5 = v2_1;
                v2 = 1;
            }
            else {
                if(this.mTargetBounds.contains(v0, v1)) {
                    this.mDelegateTargeted = true;
                    v2 = 1;
                    goto label_37;
                }

            label_35:
                v2 = 1;
                v5 = false;
            }

        label_37:
            if(v5) {
                if(v2 == 0 || (this.mActualBounds.contains(v0, v1))) {
                    arg9.setLocation(((float)(v0 - this.mActualBounds.left)), ((float)(v1 - this.mActualBounds.top)));
                }
                else {
                    arg9.setLocation(((float)(this.mDelegateView.getWidth() / v3)), ((float)(this.mDelegateView.getHeight() / v3)));
                }

                return this.mDelegateView.dispatchTouchEvent(arg9);
            }

            return 0;
        }

        public void setBounds(Rect arg3, Rect arg4) {
            this.mTargetBounds.set(arg3);
            this.mSlopBounds.set(arg3);
            this.mSlopBounds.inset(-this.mSlop, -this.mSlop);
            this.mActualBounds.set(arg4);
        }
    }

    static final boolean DBG = false;
    private static final String IME_OPTION_NO_MICROPHONE = "nm";
    static final String LOG_TAG = "SearchView";
    static final PreQAutoCompleteTextViewReflector PRE_API_29_HIDDEN_METHOD_INVOKER;
    private Bundle mAppSearchData;
    private boolean mClearingFocus;
    final ImageView mCloseButton;
    private final ImageView mCollapsedIcon;
    private int mCollapsedImeOptions;
    private final CharSequence mDefaultQueryHint;
    private final View mDropDownAnchor;
    private boolean mExpandedInActionView;
    final ImageView mGoButton;
    private boolean mIconified;
    private boolean mIconifiedByDefault;
    private int mMaxWidth;
    private CharSequence mOldQueryText;
    private final View$OnClickListener mOnClickListener;
    private OnCloseListener mOnCloseListener;
    private final TextView$OnEditorActionListener mOnEditorActionListener;
    private final AdapterView$OnItemClickListener mOnItemClickListener;
    private final AdapterView$OnItemSelectedListener mOnItemSelectedListener;
    private OnQueryTextListener mOnQueryChangeListener;
    View$OnFocusChangeListener mOnQueryTextFocusChangeListener;
    private View$OnClickListener mOnSearchClickListener;
    private OnSuggestionListener mOnSuggestionListener;
    private final WeakHashMap mOutsideDrawablesCache;
    private CharSequence mQueryHint;
    private boolean mQueryRefinement;
    private Runnable mReleaseCursorRunnable;
    final ImageView mSearchButton;
    private final View mSearchEditFrame;
    private final Drawable mSearchHintIcon;
    private final View mSearchPlate;
    final SearchAutoComplete mSearchSrcTextView;
    private Rect mSearchSrcTextViewBounds;
    private Rect mSearchSrtTextViewBoundsExpanded;
    SearchableInfo mSearchable;
    private final View mSubmitArea;
    private boolean mSubmitButtonEnabled;
    private final int mSuggestionCommitIconResId;
    private final int mSuggestionRowLayout;
    CursorAdapter mSuggestionsAdapter;
    private int[] mTemp;
    private int[] mTemp2;
    View$OnKeyListener mTextKeyListener;
    private TextWatcher mTextWatcher;
    private UpdatableTouchDelegate mTouchDelegate;
    private final Runnable mUpdateDrawableStateRunnable;
    private CharSequence mUserQuery;
    private final Intent mVoiceAppSearchIntent;
    final ImageView mVoiceButton;
    private boolean mVoiceButtonEnabled;
    private final Intent mVoiceWebSearchIntent;

    static {
        PreQAutoCompleteTextViewReflector v0 = Build$VERSION.SDK_INT < 29 ? new PreQAutoCompleteTextViewReflector() : null;
        SearchView.PRE_API_29_HIDDEN_METHOD_INVOKER = v0;
    }

    public SearchView(Context arg2) {
        this(arg2, null);
    }

    public SearchView(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, attr.searchViewStyle);
    }

    public SearchView(Context arg17, AttributeSet arg18, int arg19) {
        SearchView v0 = this;
        super(arg17, arg18, arg19);
        v0.mSearchSrcTextViewBounds = new Rect();
        v0.mSearchSrtTextViewBoundsExpanded = new Rect();
        v0.mTemp = new int[2];
        v0.mTemp2 = new int[2];
        v0.mUpdateDrawableStateRunnable = new androidx.appcompat.widget.SearchView$1(v0);
        v0.mReleaseCursorRunnable = new androidx.appcompat.widget.SearchView$2(v0);
        v0.mOutsideDrawablesCache = new WeakHashMap();
        androidx.appcompat.widget.SearchView$5 v7 = new androidx.appcompat.widget.SearchView$5(v0);
        v0.mOnClickListener = ((View$OnClickListener)v7);
        v0.mTextKeyListener = new androidx.appcompat.widget.SearchView$6(v0);
        androidx.appcompat.widget.SearchView$7 v8 = new androidx.appcompat.widget.SearchView$7(v0);
        v0.mOnEditorActionListener = ((TextView$OnEditorActionListener)v8);
        androidx.appcompat.widget.SearchView$8 v9 = new androidx.appcompat.widget.SearchView$8(v0);
        v0.mOnItemClickListener = ((AdapterView$OnItemClickListener)v9);
        androidx.appcompat.widget.SearchView$9 v10 = new androidx.appcompat.widget.SearchView$9(v0);
        v0.mOnItemSelectedListener = ((AdapterView$OnItemSelectedListener)v10);
        v0.mTextWatcher = new androidx.appcompat.widget.SearchView$10(v0);
        TintTypedArray v12 = TintTypedArray.obtainStyledAttributes(arg17, arg18, styleable.SearchView, arg19, 0);
        ViewCompat.saveAttributeDataForStyleable(((View)v0), arg17, styleable.SearchView, arg18, v12.getWrappedTypeArray(), arg19, 0);
        LayoutInflater.from(arg17).inflate(v12.getResourceId(styleable.SearchView_layout, layout.abc_search_view), ((ViewGroup)v0), true);
        View v1 = v0.findViewById(id.search_src_text);
        v0.mSearchSrcTextView = ((SearchAutoComplete)v1);
        ((SearchAutoComplete)v1).setSearchView(v0);
        v0.mSearchEditFrame = v0.findViewById(id.search_edit_frame);
        View v2 = v0.findViewById(id.search_plate);
        v0.mSearchPlate = v2;
        View v4 = v0.findViewById(id.submit_area);
        v0.mSubmitArea = v4;
        View v5 = v0.findViewById(id.search_button);
        v0.mSearchButton = ((ImageView)v5);
        View v6 = v0.findViewById(id.search_go_btn);
        v0.mGoButton = ((ImageView)v6);
        View v13 = v0.findViewById(id.search_close_btn);
        v0.mCloseButton = ((ImageView)v13);
        View v14 = v0.findViewById(id.search_voice_btn);
        v0.mVoiceButton = ((ImageView)v14);
        View v15 = v0.findViewById(id.search_mag_icon);
        v0.mCollapsedIcon = ((ImageView)v15);
        ViewCompat.setBackground(v2, v12.getDrawable(styleable.SearchView_queryBackground));
        ViewCompat.setBackground(v4, v12.getDrawable(styleable.SearchView_submitBackground));
        ((ImageView)v5).setImageDrawable(v12.getDrawable(styleable.SearchView_searchIcon));
        ((ImageView)v6).setImageDrawable(v12.getDrawable(styleable.SearchView_goIcon));
        ((ImageView)v13).setImageDrawable(v12.getDrawable(styleable.SearchView_closeIcon));
        ((ImageView)v14).setImageDrawable(v12.getDrawable(styleable.SearchView_voiceIcon));
        ((ImageView)v15).setImageDrawable(v12.getDrawable(styleable.SearchView_searchIcon));
        v0.mSearchHintIcon = v12.getDrawable(styleable.SearchView_searchHintIcon);
        TooltipCompat.setTooltipText(v5, v0.getResources().getString(string.abc_searchview_description_search));
        v0.mSuggestionRowLayout = v12.getResourceId(styleable.SearchView_suggestionRowLayout, layout.abc_search_dropdown_item_icons_2line);
        v0.mSuggestionCommitIconResId = v12.getResourceId(styleable.SearchView_commitIcon, 0);
        ((ImageView)v5).setOnClickListener(((View$OnClickListener)v7));
        ((ImageView)v13).setOnClickListener(((View$OnClickListener)v7));
        ((ImageView)v6).setOnClickListener(((View$OnClickListener)v7));
        ((ImageView)v14).setOnClickListener(((View$OnClickListener)v7));
        ((SearchAutoComplete)v1).setOnClickListener(((View$OnClickListener)v7));
        ((SearchAutoComplete)v1).addTextChangedListener(v0.mTextWatcher);
        ((SearchAutoComplete)v1).setOnEditorActionListener(((TextView$OnEditorActionListener)v8));
        ((SearchAutoComplete)v1).setOnItemClickListener(((AdapterView$OnItemClickListener)v9));
        ((SearchAutoComplete)v1).setOnItemSelectedListener(((AdapterView$OnItemSelectedListener)v10));
        ((SearchAutoComplete)v1).setOnKeyListener(v0.mTextKeyListener);
        ((SearchAutoComplete)v1).setOnFocusChangeListener(new View$OnFocusChangeListener() {
            public void onFocusChange(View arg1, boolean arg2) {
                if(SearchView.this.mOnQueryTextFocusChangeListener != null) {
                    SearchView.this.mOnQueryTextFocusChangeListener.onFocusChange(SearchView.this, arg2);
                }
            }
        });
        v0.setIconifiedByDefault(v12.getBoolean(styleable.SearchView_iconifiedByDefault, true));
        int v3 = -1;
        int v2_1 = v12.getDimensionPixelSize(styleable.SearchView_android_maxWidth, v3);
        if(v2_1 != v3) {
            v0.setMaxWidth(v2_1);
        }

        v0.mDefaultQueryHint = v12.getText(styleable.SearchView_defaultQueryHint);
        v0.mQueryHint = v12.getText(styleable.SearchView_queryHint);
        v2_1 = v12.getInt(styleable.SearchView_android_imeOptions, v3);
        if(v2_1 != v3) {
            v0.setImeOptions(v2_1);
        }

        v2_1 = v12.getInt(styleable.SearchView_android_inputType, v3);
        if(v2_1 != v3) {
            v0.setInputType(v2_1);
        }

        v0.setFocusable(v12.getBoolean(styleable.SearchView_android_focusable, true));
        v12.recycle();
        Intent v2_2 = new Intent("android.speech.action.WEB_SEARCH");
        v0.mVoiceWebSearchIntent = v2_2;
        v2_2.addFlags(0x10000000);
        v2_2.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        v2_2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        v0.mVoiceAppSearchIntent = v2_2;
        v2_2.addFlags(0x10000000);
        v1 = v0.findViewById(((SearchAutoComplete)v1).getDropDownAnchor());
        v0.mDropDownAnchor = v1;
        if(v1 != null) {
            v1.addOnLayoutChangeListener(new View$OnLayoutChangeListener() {
                public void onLayoutChange(View arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9) {
                    SearchView.this.adjustDropDownSizeAndPosition();
                }
            });
        }

        v0.updateViewsVisibility(v0.mIconifiedByDefault);
        v0.updateQueryHint();
    }

    void adjustDropDownSizeAndPosition() {
        if(this.mDropDownAnchor.getWidth() > 1) {
            Resources v0 = this.getContext().getResources();
            int v1 = this.mSearchPlate.getPaddingLeft();
            Rect v2 = new Rect();
            boolean v3 = ViewUtils.isLayoutRtl(((View)this));
            int v4 = this.mIconifiedByDefault ? v0.getDimensionPixelSize(dimen.abc_dropdownitem_icon_width) + v0.getDimensionPixelSize(dimen.abc_dropdownitem_text_padding_left) : 0;
            this.mSearchSrcTextView.getDropDownBackground().getPadding(v2);
            int v0_1 = v3 ? -v2.left : v1 - (v2.left + v4);
            this.mSearchSrcTextView.setDropDownHorizontalOffset(v0_1);
            this.mSearchSrcTextView.setDropDownWidth(this.mDropDownAnchor.getWidth() + v2.left + v2.right + v4 - v1);
        }
    }

    public void clearFocus() {
        this.mClearingFocus = true;
        super.clearFocus();
        this.mSearchSrcTextView.clearFocus();
        this.mSearchSrcTextView.setImeVisibility(false);
        this.mClearingFocus = false;
    }

    private Intent createIntent(String arg2, Uri arg3, String arg4, String arg5, int arg6, String arg7) {
        Intent v0 = new Intent(arg2);
        v0.addFlags(0x10000000);
        if(arg3 != null) {
            v0.setData(arg3);
        }

        v0.putExtra("user_query", this.mUserQuery);
        if(arg5 != null) {
            v0.putExtra("query", arg5);
        }

        if(arg4 != null) {
            v0.putExtra("intent_extra_data_key", arg4);
        }

        Bundle v2 = this.mAppSearchData;
        if(v2 != null) {
            v0.putExtra("app_data", v2);
        }

        if(arg6 != 0) {
            v0.putExtra("action_key", arg6);
            v0.putExtra("action_msg", arg7);
        }

        v0.setComponent(this.mSearchable.getSearchActivity());
        return v0;
    }

    private Intent createIntentFromSuggestion(Cursor arg10, int arg11, String arg12) {
        int v10;
        Intent v1 = null;
        try {
            String v0_1 = SuggestionsAdapter.getColumnString(arg10, "suggest_intent_action");
            if(v0_1 == null) {
                v0_1 = this.mSearchable.getSuggestIntentAction();
            }

            if(v0_1 == null) {
                v0_1 = "android.intent.action.SEARCH";
            }

            String v3 = v0_1;
            v0_1 = SuggestionsAdapter.getColumnString(arg10, "suggest_intent_data");
            if(v0_1 == null) {
                v0_1 = this.mSearchable.getSuggestIntentData();
            }

            if(v0_1 != null) {
                String v2 = SuggestionsAdapter.getColumnString(arg10, "suggest_intent_data_id");
                if(v2 != null) {
                    v0_1 = v0_1 + "/" + Uri.encode(v2);
                }
            }

            Uri v4 = v0_1 == null ? ((Uri)v1) : Uri.parse(v0_1);
            return this.createIntent(v3, v4, SuggestionsAdapter.getColumnString(arg10, "suggest_intent_extra_data"), SuggestionsAdapter.getColumnString(arg10, "suggest_intent_query"), arg11, arg12);
        }
        catch(RuntimeException v0) {
            RuntimeException v9 = v0;
            try {
                v10 = arg10.getPosition();
            }
            catch(RuntimeException ) {
                v10 = -1;
            }

            Log.w("SearchView", "Search suggestions cursor at row " + v10 + " returned exception.", ((Throwable)v9));
            return v1;
        }
    }

    private Intent createVoiceAppSearchIntent(Intent arg8, SearchableInfo arg9) {
        ComponentName v0 = arg9.getSearchActivity();
        Intent v1 = new Intent("android.intent.action.SEARCH");
        v1.setComponent(v0);
        PendingIntent v1_1 = PendingIntent.getActivity(this.getContext(), 0, v1, 0x42000000);
        Bundle v2 = new Bundle();
        Bundle v3 = this.mAppSearchData;
        if(v3 != null) {
            v2.putParcelable("app_data", ((Parcelable)v3));
        }

        Intent v3_1 = new Intent(arg8);
        Resources v7 = this.getResources();
        String v8 = arg9.getVoiceLanguageModeId() != 0 ? v7.getString(arg9.getVoiceLanguageModeId()) : "free_form";
        String v5 = null;
        String v4 = arg9.getVoicePromptTextId() != 0 ? v7.getString(arg9.getVoicePromptTextId()) : v5;
        String v7_1 = arg9.getVoiceLanguageId() != 0 ? v7.getString(arg9.getVoiceLanguageId()) : v5;
        int v9 = arg9.getVoiceMaxResults() != 0 ? arg9.getVoiceMaxResults() : 1;
        v3_1.putExtra("android.speech.extra.LANGUAGE_MODEL", v8);
        v3_1.putExtra("android.speech.extra.PROMPT", v4);
        v3_1.putExtra("android.speech.extra.LANGUAGE", v7_1);
        v3_1.putExtra("android.speech.extra.MAX_RESULTS", v9);
        if(v0 == null) {
        }
        else {
            v5 = v0.flattenToShortString();
        }

        v3_1.putExtra("calling_package", v5);
        v3_1.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", ((Parcelable)v1_1));
        v3_1.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", v2);
        return v3_1;
    }

    private Intent createVoiceWebSearchIntent(Intent arg1, SearchableInfo arg2) {
        Intent v0 = new Intent(arg1);
        ComponentName v1 = arg2.getSearchActivity();
        String v1_1 = v1 == null ? null : v1.flattenToShortString();
        v0.putExtra("calling_package", v1_1);
        return v0;
    }

    private void dismissSuggestions() {
        this.mSearchSrcTextView.dismissDropDown();
    }

    void forceSuggestionQuery() {
        int v0 = Build$VERSION.SDK_INT;
        SearchAutoComplete v1 = this.mSearchSrcTextView;
        if(v0 >= 29) {
            Api29Impl.refreshAutoCompleteResults(((AutoCompleteTextView)v1));
            return;
        }

        PreQAutoCompleteTextViewReflector v0_1 = SearchView.PRE_API_29_HIDDEN_METHOD_INVOKER;
        v0_1.doBeforeTextChanged(((AutoCompleteTextView)v1));
        v0_1.doAfterTextChanged(this.mSearchSrcTextView);
    }

    private void getChildBoundsWithinSearchView(View arg4, Rect arg5) {
        arg4.getLocationInWindow(this.mTemp);
        this.getLocationInWindow(this.mTemp2);
        int[] v0 = this.mTemp;
        int v2 = v0[1];
        int[] v3 = this.mTemp2;
        v2 -= v3[1];
        int v0_1 = v0[0] - v3[0];
        arg5.set(v0_1, v2, arg4.getWidth() + v0_1, arg4.getHeight() + v2);
    }

    private CharSequence getDecoratedHint(CharSequence arg5) {
        if(this.mIconifiedByDefault) {
            if(this.mSearchHintIcon == null) {
            }
            else {
                int v0 = ((int)((((double)this.mSearchSrcTextView.getTextSize())) * 1.25));
                this.mSearchHintIcon.setBounds(0, 0, v0, v0);
                SpannableStringBuilder v0_1 = new SpannableStringBuilder("   ");
                v0_1.setSpan(new ImageSpan(this.mSearchHintIcon), 1, 2, 33);
                v0_1.append(arg5);
                return ((CharSequence)v0_1);
            }
        }

        return arg5;
    }

    public int getImeOptions() {
        return this.mSearchSrcTextView.getImeOptions();
    }

    public int getInputType() {
        return this.mSearchSrcTextView.getInputType();
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    private int getPreferredHeight() {
        return this.getContext().getResources().getDimensionPixelSize(dimen.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return this.getContext().getResources().getDimensionPixelSize(dimen.abc_search_view_preferred_width);
    }

    public CharSequence getQuery() {
        return this.mSearchSrcTextView.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence v0 = this.mQueryHint;
        if(v0 != null) {
            return v0;
        }

        SearchableInfo v0_1 = this.mSearchable;
        if(v0_1 != null && v0_1.getHintId() != 0) {
            return this.getContext().getText(this.mSearchable.getHintId());
        }

        return this.mDefaultQueryHint;
    }

    int getSuggestionCommitIconResId() {
        return this.mSuggestionCommitIconResId;
    }

    int getSuggestionRowLayout() {
        return this.mSuggestionRowLayout;
    }

    public CursorAdapter getSuggestionsAdapter() {
        return this.mSuggestionsAdapter;
    }

    private boolean hasVoiceSearch() {
        Intent v0_1;
        SearchableInfo v0 = this.mSearchable;
        if(v0 != null && (v0.getVoiceSearchEnabled())) {
            if(this.mSearchable.getVoiceSearchLaunchWebSearch()) {
                v0_1 = this.mVoiceWebSearchIntent;
            }
            else if(this.mSearchable.getVoiceSearchLaunchRecognizer()) {
                v0_1 = this.mVoiceAppSearchIntent;
            }
            else {
                v0_1 = null;
            }

            if(v0_1 == null) {
                return 0;
            }

            if(this.getContext().getPackageManager().resolveActivity(v0_1, 0x10000) == null) {
                return 0;
            }

            return 1;
        }

        return 0;
    }

    public boolean isIconfiedByDefault() {
        return this.mIconifiedByDefault;
    }

    public boolean isIconified() {
        return this.mIconified;
    }

    static boolean isLandscapeMode(Context arg1) {
        if(arg1.getResources().getConfiguration().orientation == 2) {
            return 1;
        }

        return 0;
    }

    public boolean isQueryRefinementEnabled() {
        return this.mQueryRefinement;
    }

    private boolean isSubmitAreaEnabled() {
        if(((this.mSubmitButtonEnabled) || (this.mVoiceButtonEnabled)) && !this.isIconified()) {
            return 1;
        }

        return 0;
    }

    public boolean isSubmitButtonEnabled() {
        return this.mSubmitButtonEnabled;
    }

    private void launchIntent(Intent arg3) {
        if(arg3 == null) {
            return;
        }

        try {
            this.getContext().startActivity(arg3);
            return;
        }
        catch(RuntimeException v2) {
            Log.e("SearchView", "Failed launch activity: " + arg3, ((Throwable)v2));
            return;
        }
    }

    void launchQuerySearch(int arg8, String arg9, String arg10) {
        this.getContext().startActivity(this.createIntent("android.intent.action.SEARCH", null, null, arg10, arg8, arg9));
    }

    private boolean launchSuggestion(int arg2, int arg3, String arg4) {
        Cursor v0 = this.mSuggestionsAdapter.getCursor();
        if(v0 != null && (v0.moveToPosition(arg2))) {
            this.launchIntent(this.createIntentFromSuggestion(v0, arg3, arg4));
            return 1;
        }

        return 0;
    }

    public void onActionViewCollapsed() {
        this.setQuery("", false);
        this.clearFocus();
        this.updateViewsVisibility(true);
        this.mSearchSrcTextView.setImeOptions(this.mCollapsedImeOptions);
        this.mExpandedInActionView = false;
    }

    public void onActionViewExpanded() {
        if(this.mExpandedInActionView) {
            return;
        }

        this.mExpandedInActionView = true;
        int v0 = this.mSearchSrcTextView.getImeOptions();
        this.mCollapsedImeOptions = v0;
        this.mSearchSrcTextView.setImeOptions(v0 | 0x2000000);
        this.mSearchSrcTextView.setText("");
        this.setIconified(false);
    }

    void onCloseClicked() {
        if(TextUtils.isEmpty(this.mSearchSrcTextView.getText())) {
            if(this.mIconifiedByDefault) {
                OnCloseListener v0 = this.mOnCloseListener;
                if(v0 != null && (v0.onClose())) {
                    return;
                }

                this.clearFocus();
                this.updateViewsVisibility(true);
            }

            return;
        }

        this.mSearchSrcTextView.setText("");
        this.mSearchSrcTextView.requestFocus();
        this.mSearchSrcTextView.setImeVisibility(true);
    }

    protected void onDetachedFromWindow() {
        this.removeCallbacks(this.mUpdateDrawableStateRunnable);
        this.post(this.mReleaseCursorRunnable);
        super.onDetachedFromWindow();
    }

    boolean onItemClicked(int arg1, int arg2, String arg3) {
        OnSuggestionListener v2 = this.mOnSuggestionListener;
        if(v2 != null) {
            if(!v2.onSuggestionClick(arg1)) {
            }
            else {
                return 0;
            }
        }

        this.launchSuggestion(arg1, 0, null);
        this.mSearchSrcTextView.setImeVisibility(false);
        this.dismissSuggestions();
        return 1;
    }

    boolean onItemSelected(int arg2) {
        OnSuggestionListener v0 = this.mOnSuggestionListener;
        if(v0 != null) {
            if(!v0.onSuggestionSelect(arg2)) {
            }
            else {
                return 0;
            }
        }

        this.rewriteQueryFromSuggestion(arg2);
        return 1;
    }

    protected void onLayout(boolean arg1, int arg2, int arg3, int arg4, int arg5) {
        super.onLayout(arg1, arg2, arg3, arg4, arg5);
        if(arg1) {
            this.getChildBoundsWithinSearchView(this.mSearchSrcTextView, this.mSearchSrcTextViewBounds);
            this.mSearchSrtTextViewBoundsExpanded.set(this.mSearchSrcTextViewBounds.left, 0, this.mSearchSrcTextViewBounds.right, arg5 - arg3);
            UpdatableTouchDelegate v1 = this.mTouchDelegate;
            if(v1 == null) {
                v1 = new UpdatableTouchDelegate(this.mSearchSrtTextViewBoundsExpanded, this.mSearchSrcTextViewBounds, this.mSearchSrcTextView);
                this.mTouchDelegate = v1;
                this.setTouchDelegate(((TouchDelegate)v1));
                return;
            }
            else {
                v1.setBounds(this.mSearchSrtTextViewBoundsExpanded, this.mSearchSrcTextViewBounds);
            }
        }
    }

    protected void onMeasure(int arg4, int arg5) {
        if(this.isIconified()) {
            super.onMeasure(arg4, arg5);
            return;
        }

        int v0 = View$MeasureSpec.getMode(arg4);
        arg4 = View$MeasureSpec.getSize(arg4);
        int v1 = 0x80000000;
        int v2 = 0x40000000;
        if(v0 == v1) {
            v0 = this.mMaxWidth;
            arg4 = v0 > 0 ? Math.min(v0, arg4) : Math.min(this.getPreferredWidth(), arg4);
        }
        else if(v0 == 0) {
            arg4 = this.mMaxWidth;
            if(arg4 > 0) {
            }
            else {
                arg4 = this.getPreferredWidth();
            }
        }
        else if(v0 != v2) {
        }
        else {
            v0 = this.mMaxWidth;
            if(v0 > 0) {
                arg4 = Math.min(v0, arg4);
            }
        }

        v0 = View$MeasureSpec.getMode(arg5);
        arg5 = View$MeasureSpec.getSize(arg5);
        if(v0 == v1) {
            arg5 = Math.min(this.getPreferredHeight(), arg5);
        }
        else if(v0 != 0) {
        }
        else {
            arg5 = this.getPreferredHeight();
        }

        super.onMeasure(View$MeasureSpec.makeMeasureSpec(arg4, v2), View$MeasureSpec.makeMeasureSpec(arg5, v2));
    }

    protected void onQueryRefine(CharSequence arg1) {
        this.setQuery(arg1);
    }

    protected void onRestoreInstanceState(Parcelable arg2) {
        if(!(arg2 instanceof SavedState)) {
            super.onRestoreInstanceState(arg2);
            return;
        }

        super.onRestoreInstanceState(((SavedState)arg2).getSuperState());
        this.updateViewsVisibility(((SavedState)arg2).isIconified);
        this.requestLayout();
    }

    protected Parcelable onSaveInstanceState() {
        SavedState v1 = new SavedState(super.onSaveInstanceState());
        v1.isIconified = this.isIconified();
        return ((Parcelable)v1);
    }

    void onSearchClicked() {
        this.updateViewsVisibility(false);
        this.mSearchSrcTextView.requestFocus();
        this.mSearchSrcTextView.setImeVisibility(true);
        View$OnClickListener v0 = this.mOnSearchClickListener;
        if(v0 != null) {
            v0.onClick(((View)this));
        }
    }

    void onSubmitQuery() {
        Editable v0 = this.mSearchSrcTextView.getText();
        if(v0 != null && TextUtils.getTrimmedLength(((CharSequence)v0)) > 0) {
            OnQueryTextListener v1 = this.mOnQueryChangeListener;
            if(v1 != null && (v1.onQueryTextSubmit(v0.toString()))) {
                return;
            }

            if(this.mSearchable != null) {
                this.launchQuerySearch(0, null, v0.toString());
            }

            this.mSearchSrcTextView.setImeVisibility(false);
            this.dismissSuggestions();
        }
    }

    boolean onSuggestionsKey(View arg2, int arg3, KeyEvent arg4) {
        if(this.mSearchable == null) {
            return 0;
        }

        if(this.mSuggestionsAdapter == null) {
            return 0;
        }

        if(arg4.getAction() == 0 && (arg4.hasNoModifiers())) {
            if(arg3 != 66 && arg3 != 84) {
                if(arg3 == 61) {
                }
                else {
                    int v2 = 21;
                    if(arg3 != v2) {
                        if(arg3 == 22) {
                        }
                        else if(arg3 == 19) {
                            this.mSearchSrcTextView.getListSelection();
                            return 0;
                        }
                        else {
                            return 0;
                        }
                    }

                    v2 = arg3 == v2 ? 0 : this.mSearchSrcTextView.length();
                    this.mSearchSrcTextView.setSelection(v2);
                    this.mSearchSrcTextView.setListSelection(0);
                    this.mSearchSrcTextView.clearListSelection();
                    this.mSearchSrcTextView.ensureImeVisible();
                    return 1;
                }
            }

            return this.onItemClicked(this.mSearchSrcTextView.getListSelection(), 0, null);
        }

        return 0;
    }

    void onTextChanged(CharSequence arg3) {
        Editable v0 = this.mSearchSrcTextView.getText();
        this.mUserQuery = ((CharSequence)v0);
        boolean v0_1 = TextUtils.isEmpty(((CharSequence)v0));
        this.updateSubmitButton((((int)v0_1)) ^ 1);
        this.updateVoiceButton(v0_1);
        this.updateCloseButton();
        this.updateSubmitArea();
        if(this.mOnQueryChangeListener != null && !TextUtils.equals(arg3, this.mOldQueryText)) {
            this.mOnQueryChangeListener.onQueryTextChange(arg3.toString());
        }

        this.mOldQueryText = arg3.toString();
    }

    void onTextFocusChanged() {
        this.updateViewsVisibility(this.isIconified());
        this.postUpdateFocusedState();
        if(this.mSearchSrcTextView.hasFocus()) {
            this.forceSuggestionQuery();
        }
    }

    void onVoiceClicked() {
        SearchableInfo v0 = this.mSearchable;
        if(v0 == null) {
        }
        else {
            try {
                if(v0.getVoiceSearchLaunchWebSearch()) {
                    this.getContext().startActivity(this.createVoiceWebSearchIntent(this.mVoiceWebSearchIntent, v0));
                    return;
                }
                else if(v0.getVoiceSearchLaunchRecognizer()) {
                    this.getContext().startActivity(this.createVoiceAppSearchIntent(this.mVoiceAppSearchIntent, v0));
                }
            }
            catch(ActivityNotFoundException ) {
                Log.w("SearchView", "Could not find voice search activity");
                return;
            }
        }
    }

    public void onWindowFocusChanged(boolean arg1) {
        super.onWindowFocusChanged(arg1);
        this.postUpdateFocusedState();
    }

    private void postUpdateFocusedState() {
        this.post(this.mUpdateDrawableStateRunnable);
    }

    public boolean requestFocus(int arg3, Rect arg4) {
        if(this.mClearingFocus) {
            return 0;
        }

        if(!this.isFocusable()) {
            return 0;
        }

        if(!this.isIconified()) {
            boolean v3 = this.mSearchSrcTextView.requestFocus(arg3, arg4);
            if(v3) {
                this.updateViewsVisibility(false);
            }

            return v3;
        }

        return super.requestFocus(arg3, arg4);
    }

    private void rewriteQueryFromSuggestion(int arg3) {
        Editable v0 = this.mSearchSrcTextView.getText();
        Cursor v1 = this.mSuggestionsAdapter.getCursor();
        if(v1 == null) {
            return;
        }

        if(v1.moveToPosition(arg3)) {
            CharSequence v3 = this.mSuggestionsAdapter.convertToString(v1);
            if(v3 != null) {
                this.setQuery(v3);
                return;
            }

            this.setQuery(((CharSequence)v0));
            return;
        }

        this.setQuery(((CharSequence)v0));
    }

    public void setAppSearchData(Bundle arg1) {
        this.mAppSearchData = arg1;
    }

    public void setIconified(boolean arg1) {
        if(arg1) {
            this.onCloseClicked();
            return;
        }

        this.onSearchClicked();
    }

    public void setIconifiedByDefault(boolean arg2) {
        if(this.mIconifiedByDefault == arg2) {
            return;
        }

        this.mIconifiedByDefault = arg2;
        this.updateViewsVisibility(arg2);
        this.updateQueryHint();
    }

    public void setImeOptions(int arg1) {
        this.mSearchSrcTextView.setImeOptions(arg1);
    }

    public void setInputType(int arg1) {
        this.mSearchSrcTextView.setInputType(arg1);
    }

    public void setMaxWidth(int arg1) {
        this.mMaxWidth = arg1;
        this.requestLayout();
    }

    public void setOnCloseListener(OnCloseListener arg1) {
        this.mOnCloseListener = arg1;
    }

    public void setOnQueryTextFocusChangeListener(View$OnFocusChangeListener arg1) {
        this.mOnQueryTextFocusChangeListener = arg1;
    }

    public void setOnQueryTextListener(OnQueryTextListener arg1) {
        this.mOnQueryChangeListener = arg1;
    }

    public void setOnSearchClickListener(View$OnClickListener arg1) {
        this.mOnSearchClickListener = arg1;
    }

    public void setOnSuggestionListener(OnSuggestionListener arg1) {
        this.mOnSuggestionListener = arg1;
    }

    private void setQuery(CharSequence arg2) {
        this.mSearchSrcTextView.setText(arg2);
        SearchAutoComplete v1 = this.mSearchSrcTextView;
        int v2 = TextUtils.isEmpty(arg2) ? 0 : arg2.length();
        v1.setSelection(v2);
    }

    public void setQuery(CharSequence arg3, boolean arg4) {
        this.mSearchSrcTextView.setText(arg3);
        if(arg3 != null) {
            this.mSearchSrcTextView.setSelection(this.mSearchSrcTextView.length());
            this.mUserQuery = arg3;
        }

        if((arg4) && !TextUtils.isEmpty(arg3)) {
            this.onSubmitQuery();
        }
    }

    public void setQueryHint(CharSequence arg1) {
        this.mQueryHint = arg1;
        this.updateQueryHint();
    }

    public void setQueryRefinementEnabled(boolean arg2) {
        this.mQueryRefinement = arg2;
        CursorAdapter v1 = this.mSuggestionsAdapter;
        if((v1 instanceof SuggestionsAdapter)) {
            int v2 = arg2 ? 2 : 1;
            ((SuggestionsAdapter)v1).setQueryRefinement(v2);
        }
    }

    public void setSearchableInfo(SearchableInfo arg2) {
        this.mSearchable = arg2;
        if(arg2 != null) {
            this.updateSearchAutoComplete();
            this.updateQueryHint();
        }

        boolean v2 = this.hasVoiceSearch();
        this.mVoiceButtonEnabled = v2;
        if(v2) {
            this.mSearchSrcTextView.setPrivateImeOptions("nm");
        }

        this.updateViewsVisibility(this.isIconified());
    }

    public void setSubmitButtonEnabled(boolean arg1) {
        this.mSubmitButtonEnabled = arg1;
        this.updateViewsVisibility(this.isIconified());
    }

    public void setSuggestionsAdapter(CursorAdapter arg1) {
        this.mSuggestionsAdapter = arg1;
        this.mSearchSrcTextView.setAdapter(((ListAdapter)arg1));
    }

    private void updateCloseButton() {
        int v2;
        boolean v0 = TextUtils.isEmpty(this.mSearchSrcTextView.getText());
        int v1 = 0;
        if(v0) {
            if((this.mIconifiedByDefault) && !this.mExpandedInActionView) {
                goto label_12;
            }

            v2 = 0;
        }
        else {
        label_12:
            v2 = 1;
        }

        ImageView v3 = this.mCloseButton;
        if(v2 != 0) {
        }
        else {
            v1 = 8;
        }

        v3.setVisibility(v1);
        Drawable v4 = this.mCloseButton.getDrawable();
        if(v4 != null) {
            int[] v0_1 = !v0 ? SearchView.ENABLED_STATE_SET : SearchView.EMPTY_STATE_SET;
            v4.setState(v0_1);
        }
    }

    void updateFocusedState() {
        int[] v0 = this.mSearchSrcTextView.hasFocus() ? SearchView.FOCUSED_STATE_SET : SearchView.EMPTY_STATE_SET;
        Drawable v1 = this.mSearchPlate.getBackground();
        if(v1 != null) {
            v1.setState(v0);
        }

        v1 = this.mSubmitArea.getBackground();
        if(v1 != null) {
            v1.setState(v0);
        }

        this.invalidate();
    }

    private void updateQueryHint() {
        String v0_1;
        CharSequence v0 = this.getQueryHint();
        SearchAutoComplete v1 = this.mSearchSrcTextView;
        if(v0 == null) {
            v0_1 = "";
        }

        v1.setHint(this.getDecoratedHint(((CharSequence)v0_1)));
    }

    private void updateSearchAutoComplete() {
        this.mSearchSrcTextView.setThreshold(this.mSearchable.getSuggestThreshold());
        this.mSearchSrcTextView.setImeOptions(this.mSearchable.getImeOptions());
        int v0 = this.mSearchable.getInputType();
        int v2 = 1;
        if((v0 & 15) == 1) {
            v0 &= 0xFFFEFFFF;
            if(this.mSearchable.getSuggestAuthority() != null) {
                v0 |= 0x90000;
            }
        }

        this.mSearchSrcTextView.setInputType(v0);
        CursorAdapter v0_1 = this.mSuggestionsAdapter;
        if(v0_1 != null) {
            v0_1.changeCursor(null);
        }

        if(this.mSearchable.getSuggestAuthority() != null) {
            SuggestionsAdapter v0_2 = new SuggestionsAdapter(this.getContext(), this, this.mSearchable, this.mOutsideDrawablesCache);
            this.mSuggestionsAdapter = ((CursorAdapter)v0_2);
            this.mSearchSrcTextView.setAdapter(((ListAdapter)v0_2));
            v0_1 = this.mSuggestionsAdapter;
            if(this.mQueryRefinement) {
                v2 = 2;
            }

            ((SuggestionsAdapter)v0_1).setQueryRefinement(v2);
        }
    }

    private void updateSubmitArea() {
        int v0;
        if(this.isSubmitAreaEnabled()) {
            if(this.mGoButton.getVisibility() != 0 && this.mVoiceButton.getVisibility() != 0) {
                goto label_10;
            }

            v0 = 0;
        }
        else {
        label_10:
            v0 = 8;
        }

        this.mSubmitArea.setVisibility(v0);
    }

    private void updateSubmitButton(boolean arg2) {
        int v2;
        if(!this.mSubmitButtonEnabled || !this.isSubmitAreaEnabled() || !this.hasFocus()) {
        label_11:
            v2 = 8;
        }
        else {
            if(!arg2 && (this.mVoiceButtonEnabled)) {
                goto label_11;
            }

            v2 = 0;
        }

        this.mGoButton.setVisibility(v2);
    }

    private void updateViewsVisibility(boolean arg7) {
        this.mIconified = arg7;
        int v0 = 0;
        int v1 = 8;
        int v2 = arg7 ? 0 : v1;
        boolean v3 = TextUtils.isEmpty(this.mSearchSrcTextView.getText());
        this.mSearchButton.setVisibility(v2);
        this.updateSubmitButton((((int)v3)) ^ 1);
        View v2_1 = this.mSearchEditFrame;
        int v7 = arg7 ? v1 : 0;
        v2_1.setVisibility(v7);
        if(this.mCollapsedIcon.getDrawable() == null || (this.mIconifiedByDefault)) {
            v0 = v1;
        }

        this.mCollapsedIcon.setVisibility(v0);
        this.updateCloseButton();
        this.updateVoiceButton(v3);
        this.updateSubmitArea();
    }

    private void updateVoiceButton(boolean arg3) {
        int v1 = 8;
        if((this.mVoiceButtonEnabled) && !this.isIconified() && (arg3)) {
            this.mGoButton.setVisibility(v1);
            v1 = 0;
        }

        this.mVoiceButton.setVisibility(v1);
    }
}

