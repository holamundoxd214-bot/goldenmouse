package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView$OnItemClickListener;
import android.widget.AdapterView;
import android.widget.FrameLayout$LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ListFragment extends Fragment {
    class androidx.fragment.app.ListFragment$1 implements Runnable {
        androidx.fragment.app.ListFragment$1(ListFragment arg1) {
            ListFragment.this = arg1;
            super();
        }

        public void run() {
            ListFragment.this.mList.focusableViewAvailable(ListFragment.this.mList);
        }
    }

    class androidx.fragment.app.ListFragment$2 implements AdapterView$OnItemClickListener {
        androidx.fragment.app.ListFragment$2(ListFragment arg1) {
            ListFragment.this = arg1;
            super();
        }

        public void onItemClick(AdapterView arg1, View arg2, int arg3, long arg4) {
            ListFragment.this.onListItemClick(((ListView)arg1), arg2, arg3, arg4);
        }
    }

    static final int INTERNAL_EMPTY_ID = 0xFF0001;
    static final int INTERNAL_LIST_CONTAINER_ID = 0xFF0003;
    static final int INTERNAL_PROGRESS_CONTAINER_ID = 0xFF0002;
    ListAdapter mAdapter;
    CharSequence mEmptyText;
    View mEmptyView;
    private final Handler mHandler;
    ListView mList;
    View mListContainer;
    boolean mListShown;
    private final AdapterView$OnItemClickListener mOnClickListener;
    View mProgressContainer;
    private final Runnable mRequestFocus;
    TextView mStandardEmptyView;

    public ListFragment() {
        super();
        this.mHandler = new Handler();
        this.mRequestFocus = new androidx.fragment.app.ListFragment$1(this);
        this.mOnClickListener = new androidx.fragment.app.ListFragment$2(this);
    }

    private void ensureList() {
        if(this.mList != null) {
            return;
        }

        View v0 = this.getView();
        if(v0 != null) {
            if((v0 instanceof ListView)) {
                this.mList = ((ListView)v0);
            }
            else {
                View v1 = v0.findViewById(0xFF0001);
                this.mStandardEmptyView = ((TextView)v1);
                if(v1 == null) {
                    this.mEmptyView = v0.findViewById(0x1020004);
                }
                else {
                    ((TextView)v1).setVisibility(8);
                }

                this.mProgressContainer = v0.findViewById(0xFF0002);
                this.mListContainer = v0.findViewById(0xFF0003);
                v0 = v0.findViewById(0x102000A);
                if(!(v0 instanceof ListView)) {
                    if(v0 == null) {
                        throw new RuntimeException("Your content must have a ListView whose id attribute is \'android.R.id.list\'");
                    }

                    throw new RuntimeException("Content has view with id attribute \'android.R.id.list\' that is not a ListView class");
                }

                this.mList = ((ListView)v0);
                v1 = this.mEmptyView;
                if(v1 != null) {
                    ((ListView)v0).setEmptyView(v1);
                    goto label_50;
                }

                CharSequence v0_1 = this.mEmptyText;
                if(v0_1 == null) {
                    goto label_50;
                }

                this.mStandardEmptyView.setText(v0_1);
                this.mList.setEmptyView(this.mStandardEmptyView);
            }

        label_50:
            this.mListShown = true;
            this.mList.setOnItemClickListener(this.mOnClickListener);
            ListAdapter v0_2 = this.mAdapter;
            if(v0_2 != null) {
                this.mAdapter = null;
                this.setListAdapter(v0_2);
            }
            else if(this.mProgressContainer != null) {
                this.setListShown(false, false);
            }

            this.mHandler.post(this.mRequestFocus);
            return;
        }

        throw new IllegalStateException("Content view not yet created");
    }

    public ListAdapter getListAdapter() {
        return this.mAdapter;
    }

    public ListView getListView() {
        this.ensureList();
        return this.mList;
    }

    public long getSelectedItemId() {
        this.ensureList();
        return this.mList.getSelectedItemId();
    }

    public int getSelectedItemPosition() {
        this.ensureList();
        return this.mList.getSelectedItemPosition();
    }

    public View onCreateView(LayoutInflater arg4, ViewGroup arg5, Bundle arg6) {
        Context v3 = this.requireContext();
        FrameLayout v4 = new FrameLayout(v3);
        LinearLayout v5 = new LinearLayout(v3);
        v5.setId(0xFF0002);
        v5.setOrientation(1);
        v5.setVisibility(8);
        v5.setGravity(17);
        v5.addView(new ProgressBar(v3, null, 0x101007A), new FrameLayout$LayoutParams(-2, -2));
        v4.addView(((View)v5), new FrameLayout$LayoutParams(-1, -1));
        FrameLayout v5_1 = new FrameLayout(v3);
        v5_1.setId(0xFF0003);
        TextView v0 = new TextView(v3);
        v0.setId(0xFF0001);
        v0.setGravity(17);
        v5_1.addView(((View)v0), new FrameLayout$LayoutParams(-1, -1));
        ListView v6 = new ListView(v3);
        v6.setId(0x102000A);
        v6.setDrawSelectorOnTop(false);
        v5_1.addView(((View)v6), new FrameLayout$LayoutParams(-1, -1));
        v4.addView(((View)v5_1), new FrameLayout$LayoutParams(-1, -1));
        v4.setLayoutParams(new FrameLayout$LayoutParams(-1, -1));
        return ((View)v4);
    }

    public void onDestroyView() {
        this.mHandler.removeCallbacks(this.mRequestFocus);
        this.mList = null;
        this.mListShown = false;
        this.mListContainer = null;
        this.mProgressContainer = null;
        this.mEmptyView = null;
        this.mStandardEmptyView = null;
        super.onDestroyView();
    }

    public void onListItemClick(ListView arg1, View arg2, int arg3, long arg4) {
    }

    public void onViewCreated(View arg1, Bundle arg2) {
        super.onViewCreated(arg1, arg2);
        this.ensureList();
    }

    public final ListAdapter requireListAdapter() {
        ListAdapter v0 = this.getListAdapter();
        if(v0 != null) {
            return v0;
        }

        throw new IllegalStateException("ListFragment " + this + " does not have a ListAdapter.");
    }

    public void setEmptyText(CharSequence arg3) {
        this.ensureList();
        TextView v0 = this.mStandardEmptyView;
        if(v0 != null) {
            v0.setText(arg3);
            if(this.mEmptyText == null) {
                this.mList.setEmptyView(this.mStandardEmptyView);
            }

            this.mEmptyText = arg3;
            return;
        }

        throw new IllegalStateException("Can\'t be used with a custom content view");
    }

    public void setListAdapter(ListAdapter arg5) {
        boolean v1 = false;
        int v0 = this.mAdapter != null ? 1 : 0;
        this.mAdapter = arg5;
        ListView v3 = this.mList;
        if(v3 != null) {
            v3.setAdapter(arg5);
            if(!this.mListShown && v0 == 0) {
                if(this.requireView().getWindowToken() != null) {
                    v1 = true;
                }

                this.setListShown(true, v1);
            }
        }
    }

    private void setListShown(boolean arg6, boolean arg7) {
        this.ensureList();
        View v0 = this.mProgressContainer;
        if(v0 != null) {
            if(this.mListShown == arg6) {
                return;
            }

            this.mListShown = arg6;
            int v1 = 8;
            int v3 = 0x10A0001;
            int v4 = 0x10A0000;
            if(arg6) {
                if(arg7) {
                    v0.startAnimation(AnimationUtils.loadAnimation(this.getContext(), v3));
                    this.mListContainer.startAnimation(AnimationUtils.loadAnimation(this.getContext(), v4));
                }
                else {
                    v0.clearAnimation();
                    this.mListContainer.clearAnimation();
                }

                this.mProgressContainer.setVisibility(v1);
                this.mListContainer.setVisibility(0);
                return;
            }

            if(arg7) {
                v0.startAnimation(AnimationUtils.loadAnimation(this.getContext(), v4));
                this.mListContainer.startAnimation(AnimationUtils.loadAnimation(this.getContext(), v3));
            }
            else {
                v0.clearAnimation();
                this.mListContainer.clearAnimation();
            }

            this.mProgressContainer.setVisibility(0);
            this.mListContainer.setVisibility(v1);
            return;
        }

        throw new IllegalStateException("Can\'t be used with a custom content view");
    }

    public void setListShown(boolean arg2) {
        this.setListShown(arg2, true);
    }

    public void setListShownNoAnimation(boolean arg2) {
        this.setListShown(arg2, false);
    }

    public void setSelection(int arg1) {
        this.ensureList();
        this.mList.setSelection(arg1);
    }
}

