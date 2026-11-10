package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;

class GhostViewHolder extends FrameLayout {
    class Api21Impl {
        private Api21Impl() {
            super();
        }

        static float getZ(View arg0) {
            return arg0.getZ();
        }
    }

    private boolean mAttached;
    private ViewGroup mParent;

    GhostViewHolder(ViewGroup arg2) {
        super(arg2.getContext());
        this.setClipChildren(false);
        this.mParent = arg2;
        arg2.setTag(id.ghost_view_holder, this);
        ViewCompat.addOverlayView(this.mParent, ((View)this));
        this.mAttached = true;
    }

    void addGhostView(GhostViewPort arg3) {
        ArrayList v0 = new ArrayList();
        GhostViewHolder.getParents(arg3.mView, v0);
        int v0_1 = this.getInsertIndex(v0);
        if(v0_1 >= 0) {
            if(v0_1 >= this.getChildCount()) {
            }
            else {
                this.addView(((View)arg3), v0_1);
                return;
            }
        }

        this.addView(((View)arg3));
    }

    static GhostViewHolder getHolder(ViewGroup arg1) {
        return arg1.getTag(id.ghost_view_holder);
    }

    private int getInsertIndex(ArrayList arg6) {
        ArrayList v0 = new ArrayList();
        int v1 = this.getChildCount() - 1;
        int v2 = 0;
        while(v2 <= v1) {
            int v3 = (v2 + v1) / 2;
            GhostViewHolder.getParents(this.getChildAt(v3).mView, v0);
            if(GhostViewHolder.isOnTop(arg6, v0)) {
                v2 = v3 + 1;
            }
            else {
                v1 = v3 - 1;
            }

            v0.clear();
        }

        return v2;
    }

    private static void getParents(View arg2, ArrayList arg3) {
        ViewParent v0 = arg2.getParent();
        if((v0 instanceof ViewGroup)) {
            GhostViewHolder.getParents(((View)v0), arg3);
        }

        arg3.add(arg2);
    }

    private static boolean isOnTop(ArrayList arg6, ArrayList arg7) {
        if(!arg6.isEmpty() && !arg7.isEmpty()) {
            if(arg6.get(0) != arg7.get(0)) {
            }
            else {
                int v2 = Math.min(arg6.size(), arg7.size());
                int v3 = 1;
                while(true) {
                    if(v3 < v2) {
                        Object v4 = arg6.get(v3);
                        Object v5 = arg7.get(v3);
                        if(v4 != v5) {
                            return GhostViewHolder.isOnTop(((View)v4), ((View)v5));
                        }
                        else {
                            ++v3;
                            continue;
                        }
                    }
                    else {
                        break;
                    }

                    return 1;
                }

                if(arg7.size() == v2) {
                    return 1;
                }
                else {
                    return 0;
                }
            }
        }

        return 1;
    }

    private static boolean isOnTop(View arg6, View arg7) {
        ViewParent v0 = arg6.getParent();
        int v1 = ((ViewGroup)v0).getChildCount();
        if(Float.compare(Api21Impl.getZ(arg6), Api21Impl.getZ(arg7)) != 0) {
            if(Api21Impl.getZ(arg6) > Api21Impl.getZ(arg7)) {
                return 1;
            }

            return 0;
        }

        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            View v5 = ((ViewGroup)v0).getChildAt(ViewGroupUtils.getChildDrawingOrder(((ViewGroup)v0), v2));
            if(v5 == arg6) {
                return 0;
            }

            if(v5 == arg7) {
                return 1;
            }
        }

        return 1;
    }

    public void onViewAdded(View arg2) {
        if(this.mAttached) {
            super.onViewAdded(arg2);
            return;
        }

        throw new IllegalStateException("This GhostViewHolder is detached!");
    }

    public void onViewRemoved(View arg4) {
        super.onViewRemoved(arg4);
        if(this.getChildCount() == 1 && this.getChildAt(0) == arg4 || this.getChildCount() == 0) {
            this.mParent.setTag(id.ghost_view_holder, null);
            this.mParent.getOverlay().remove(((View)this));
            this.mAttached = false;
        }
    }

    void popToOverlayTop() {
        if(this.mAttached) {
            this.mParent.getOverlay().remove(((View)this));
            this.mParent.getOverlay().add(((View)this));
            return;
        }

        throw new IllegalStateException("This GhostViewHolder is detached!");
    }
}

