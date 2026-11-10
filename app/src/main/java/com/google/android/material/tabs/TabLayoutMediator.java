package com.google.android.material.tabs;

import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$AdapterDataObserver;
import androidx.viewpager2.widget.ViewPager2$OnPageChangeCallback;
import androidx.viewpager2.widget.ViewPager2;
import java.lang.ref.WeakReference;

public final class TabLayoutMediator {
    class PagerAdapterObserver extends AdapterDataObserver {
        PagerAdapterObserver(TabLayoutMediator arg1) {
            TabLayoutMediator.this = arg1;
            super();
        }

        public void onChanged() {
            TabLayoutMediator.this.populateTabsFromPagerAdapter();
        }

        public void onItemRangeChanged(int arg1, int arg2) {
            TabLayoutMediator.this.populateTabsFromPagerAdapter();
        }

        public void onItemRangeChanged(int arg1, int arg2, Object arg3) {
            TabLayoutMediator.this.populateTabsFromPagerAdapter();
        }

        public void onItemRangeInserted(int arg1, int arg2) {
            TabLayoutMediator.this.populateTabsFromPagerAdapter();
        }

        public void onItemRangeMoved(int arg1, int arg2, int arg3) {
            TabLayoutMediator.this.populateTabsFromPagerAdapter();
        }

        public void onItemRangeRemoved(int arg1, int arg2) {
            TabLayoutMediator.this.populateTabsFromPagerAdapter();
        }
    }

    public interface TabConfigurationStrategy {
        void onConfigureTab(Tab arg1, int arg2);
    }

    class TabLayoutOnPageChangeCallback extends OnPageChangeCallback {
        private int previousScrollState;
        private int scrollState;
        private final WeakReference tabLayoutRef;

        TabLayoutOnPageChangeCallback(TabLayout arg2) {
            super();
            this.tabLayoutRef = new WeakReference(arg2);
            this.reset();
        }

        public void onPageScrollStateChanged(int arg2) {
            this.previousScrollState = this.scrollState;
            this.scrollState = arg2;
            Object v2 = this.tabLayoutRef.get();
            if(v2 != null) {
                ((TabLayout)v2).updateViewPagerScrollState(this.scrollState);
            }
        }

        public void onPageScrolled(int arg7, float arg8, int arg9) {
            boolean v4;
            Object v0 = this.tabLayoutRef.get();
            if(v0 != null) {
                arg9 = this.scrollState;
                int v2 = 2;
                boolean v3 = true;
                if(arg9 != v2 || this.previousScrollState == 1) {
                    v4 = true;
                }
                else {
                    v4 = true;
                    v3 = false;
                }

                if(arg9 == v2) {
                    if(this.previousScrollState != 0) {
                    }
                    else {
                        v4 = false;
                    }
                }

                ((TabLayout)v0).setScrollPosition(arg7, arg8, v3, v4, false);
            }
        }

        public void onPageSelected(int arg4) {
            boolean v3;
            Object v0 = this.tabLayoutRef.get();
            if(v0 != null && ((TabLayout)v0).getSelectedTabPosition() != arg4 && arg4 < ((TabLayout)v0).getTabCount()) {
                int v1 = this.scrollState;
                if(v1 != 0) {
                    if(v1 == 2 && this.previousScrollState == 0) {
                        goto label_16;
                    }

                    v3 = false;
                }
                else {
                label_16:
                    v3 = true;
                }

                ((TabLayout)v0).selectTab(((TabLayout)v0).getTabAt(arg4), v3);
            }
        }

        void reset() {
            this.scrollState = 0;
            this.previousScrollState = 0;
        }
    }

    class ViewPagerOnTabSelectedListener implements OnTabSelectedListener {
        private final boolean smoothScroll;
        private final ViewPager2 viewPager;

        ViewPagerOnTabSelectedListener(ViewPager2 arg1, boolean arg2) {
            super();
            this.viewPager = arg1;
            this.smoothScroll = arg2;
        }

        public void onTabReselected(Tab arg1) {
        }

        public void onTabSelected(Tab arg2) {
            this.viewPager.setCurrentItem(arg2.getPosition(), this.smoothScroll);
        }

        public void onTabUnselected(Tab arg1) {
        }
    }

    private Adapter adapter;
    private boolean attached;
    private final boolean autoRefresh;
    private TabLayoutOnPageChangeCallback onPageChangeCallback;
    private OnTabSelectedListener onTabSelectedListener;
    private AdapterDataObserver pagerAdapterObserver;
    private final boolean smoothScroll;
    private final TabConfigurationStrategy tabConfigurationStrategy;
    private final TabLayout tabLayout;
    private final ViewPager2 viewPager;

    public TabLayoutMediator(TabLayout arg2, ViewPager2 arg3, TabConfigurationStrategy arg4) {
        this(arg2, arg3, true, arg4);
    }

    public TabLayoutMediator(TabLayout arg7, ViewPager2 arg8, boolean arg9, TabConfigurationStrategy arg10) {
        this(arg7, arg8, arg9, true, arg10);
    }

    public TabLayoutMediator(TabLayout arg1, ViewPager2 arg2, boolean arg3, boolean arg4, TabConfigurationStrategy arg5) {
        super();
        this.tabLayout = arg1;
        this.viewPager = arg2;
        this.autoRefresh = arg3;
        this.smoothScroll = arg4;
        this.tabConfigurationStrategy = arg5;
    }

    public void attach() {
        if(!this.attached) {
            Adapter v0 = this.viewPager.getAdapter();
            this.adapter = v0;
            if(v0 != null) {
                this.attached = true;
                TabLayoutOnPageChangeCallback v1 = new TabLayoutOnPageChangeCallback(this.tabLayout);
                this.onPageChangeCallback = v1;
                this.viewPager.registerOnPageChangeCallback(((OnPageChangeCallback)v1));
                ViewPagerOnTabSelectedListener v1_1 = new ViewPagerOnTabSelectedListener(this.viewPager, this.smoothScroll);
                this.onTabSelectedListener = ((OnTabSelectedListener)v1_1);
                this.tabLayout.addOnTabSelectedListener(((OnTabSelectedListener)v1_1));
                if(this.autoRefresh) {
                    PagerAdapterObserver v1_2 = new PagerAdapterObserver(this);
                    this.pagerAdapterObserver = ((AdapterDataObserver)v1_2);
                    this.adapter.registerAdapterDataObserver(((AdapterDataObserver)v1_2));
                }

                this.populateTabsFromPagerAdapter();
                this.tabLayout.setScrollPosition(this.viewPager.getCurrentItem(), 0f, true);
                return;
            }

            throw new IllegalStateException("TabLayoutMediator attached before ViewPager2 has an adapter");
        }

        throw new IllegalStateException("TabLayoutMediator is already attached");
    }

    public void detach() {
        AdapterDataObserver v1 = null;
        if(this.autoRefresh) {
            Adapter v0 = this.adapter;
            if(v0 != null) {
                v0.unregisterAdapterDataObserver(this.pagerAdapterObserver);
                this.pagerAdapterObserver = v1;
            }
        }

        this.tabLayout.removeOnTabSelectedListener(this.onTabSelectedListener);
        this.viewPager.unregisterOnPageChangeCallback(this.onPageChangeCallback);
        this.onTabSelectedListener = ((OnTabSelectedListener)v1);
        this.onPageChangeCallback = ((TabLayoutOnPageChangeCallback)v1);
        this.adapter = ((Adapter)v1);
        this.attached = false;
    }

    public boolean isAttached() {
        return this.attached;
    }

    void populateTabsFromPagerAdapter() {
        this.tabLayout.removeAllTabs();
        Adapter v0 = this.adapter;
        if(v0 != null) {
            int v0_1 = v0.getItemCount();
            int v2;
            for(v2 = 0; v2 < v0_1; ++v2) {
                Tab v3 = this.tabLayout.newTab();
                this.tabConfigurationStrategy.onConfigureTab(v3, v2);
                this.tabLayout.addTab(v3, false);
            }

            if(v0_1 > 0) {
                v0_1 = Math.min(this.viewPager.getCurrentItem(), this.tabLayout.getTabCount() - 1);
                if(v0_1 != this.tabLayout.getSelectedTabPosition()) {
                    this.tabLayout.selectTab(this.tabLayout.getTabAt(v0_1));
                }
            }
        }
    }
}

