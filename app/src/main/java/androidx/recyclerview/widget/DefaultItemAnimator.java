package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DefaultItemAnimator extends SimpleItemAnimator {
    class ChangeInfo {
        public int fromX;
        public int fromY;
        public ViewHolder newHolder;
        public ViewHolder oldHolder;
        public int toX;
        public int toY;

        ChangeInfo(ViewHolder arg1, ViewHolder arg2, int arg3, int arg4, int arg5, int arg6) {
            this(arg1, arg2);
            this.fromX = arg3;
            this.fromY = arg4;
            this.toX = arg5;
            this.toY = arg6;
        }

        private ChangeInfo(ViewHolder arg1, ViewHolder arg2) {
            super();
            this.oldHolder = arg1;
            this.newHolder = arg2;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.oldHolder + ", newHolder=" + this.newHolder + ", fromX=" + this.fromX + ", fromY=" + this.fromY + ", toX=" + this.toX + ", toY=" + this.toY + '}';
        }
    }

    class MoveInfo {
        public int fromX;
        public int fromY;
        public ViewHolder holder;
        public int toX;
        public int toY;

        MoveInfo(ViewHolder arg1, int arg2, int arg3, int arg4, int arg5) {
            super();
            this.holder = arg1;
            this.fromX = arg2;
            this.fromY = arg3;
            this.toX = arg4;
            this.toY = arg5;
        }
    }

    private static final boolean DEBUG = false;
    ArrayList mAddAnimations;
    ArrayList mAdditionsList;
    ArrayList mChangeAnimations;
    ArrayList mChangesList;
    ArrayList mMoveAnimations;
    ArrayList mMovesList;
    private ArrayList mPendingAdditions;
    private ArrayList mPendingChanges;
    private ArrayList mPendingMoves;
    private ArrayList mPendingRemovals;
    ArrayList mRemoveAnimations;
    private static TimeInterpolator sDefaultInterpolator;

    public DefaultItemAnimator() {
        super();
        this.mPendingRemovals = new ArrayList();
        this.mPendingAdditions = new ArrayList();
        this.mPendingMoves = new ArrayList();
        this.mPendingChanges = new ArrayList();
        this.mAdditionsList = new ArrayList();
        this.mMovesList = new ArrayList();
        this.mChangesList = new ArrayList();
        this.mAddAnimations = new ArrayList();
        this.mMoveAnimations = new ArrayList();
        this.mRemoveAnimations = new ArrayList();
        this.mChangeAnimations = new ArrayList();
    }

    public boolean animateAdd(ViewHolder arg3) {
        this.resetAnimation(arg3);
        arg3.itemView.setAlpha(0f);
        this.mPendingAdditions.add(arg3);
        return 1;
    }

    void animateAddImpl(ViewHolder arg6) {
        View v0 = arg6.itemView;
        ViewPropertyAnimator v1 = v0.animate();
        this.mAddAnimations.add(arg6);
        v1.alpha(1f).setDuration(this.getAddDuration()).setListener(new AnimatorListenerAdapter(arg6, v0, v1) {
            public void onAnimationCancel(Animator arg1) {
                this.val$view.setAlpha(1f);
            }

            public void onAnimationEnd(Animator arg2) {
                this.val$animation.setListener(null);
                DefaultItemAnimator.this.dispatchAddFinished(this.val$holder);
                DefaultItemAnimator.this.mAddAnimations.remove(this.val$holder);
                DefaultItemAnimator.this.dispatchFinishedWhenDone();
            }

            public void onAnimationStart(Animator arg1) {
                DefaultItemAnimator.this.dispatchAddStarting(this.val$holder);
            }
        }).start();
    }

    public boolean animateChange(ViewHolder arg7, ViewHolder arg8, int arg9, int arg10, int arg11, int arg12) {
        if(arg7 == arg8) {
            return this.animateMove(arg7, arg9, arg10, arg11, arg12);
        }

        DefaultItemAnimator v0 = this;
        float v6 = arg7.itemView.getTranslationX();
        float v1 = arg7.itemView.getTranslationY();
        float v2 = arg7.itemView.getAlpha();
        v0.resetAnimation(arg7);
        int v3 = ((int)((((float)(arg11 - arg9))) - v6));
        int v4 = ((int)((((float)(arg12 - arg10))) - v1));
        arg7.itemView.setTranslationX(v6);
        arg7.itemView.setTranslationY(v1);
        arg7.itemView.setAlpha(v2);
        if(arg8 != null) {
            v0.resetAnimation(arg8);
            arg8.itemView.setTranslationX(((float)(-v3)));
            arg8.itemView.setTranslationY(((float)(-v4)));
            arg8.itemView.setAlpha(0f);
        }

        v0.mPendingChanges.add(new ChangeInfo(arg7, arg8, arg9, arg10, arg11, arg12));
        return 1;
    }

    void animateChangeImpl(ChangeInfo arg7) {
        ViewHolder v0 = arg7.oldHolder;
        View v1 = null;
        View v0_1 = v0 == null ? v1 : v0.itemView;
        ViewHolder v2 = arg7.newHolder;
        if(v2 != null) {
            v1 = v2.itemView;
        }

        if(v0_1 != null) {
            ViewPropertyAnimator v3 = v0_1.animate().setDuration(this.getChangeDuration());
            this.mChangeAnimations.add(arg7.oldHolder);
            v3.translationX(((float)(arg7.toX - arg7.fromX)));
            v3.translationY(((float)(arg7.toY - arg7.fromY)));
            v3.alpha(0f).setListener(new AnimatorListenerAdapter(arg7, v3, v0_1) {
                public void onAnimationEnd(Animator arg3) {
                    this.val$oldViewAnim.setListener(null);
                    this.val$view.setAlpha(1f);
                    this.val$view.setTranslationX(0f);
                    this.val$view.setTranslationY(0f);
                    DefaultItemAnimator.this.dispatchChangeFinished(this.val$changeInfo.oldHolder, true);
                    DefaultItemAnimator.this.mChangeAnimations.remove(this.val$changeInfo.oldHolder);
                    DefaultItemAnimator.this.dispatchFinishedWhenDone();
                }

                public void onAnimationStart(Animator arg2) {
                    DefaultItemAnimator.this.dispatchChangeStarting(this.val$changeInfo.oldHolder, true);
                }
            }).start();
        }

        if(v1 != null) {
            ViewPropertyAnimator v0_2 = v1.animate();
            this.mChangeAnimations.add(arg7.newHolder);
            v0_2.translationX(0f).translationY(0f).setDuration(this.getChangeDuration()).alpha(1f).setListener(new AnimatorListenerAdapter(arg7, v0_2, v1) {
                public void onAnimationEnd(Animator arg3) {
                    this.val$newViewAnimation.setListener(null);
                    this.val$newView.setAlpha(1f);
                    this.val$newView.setTranslationX(0f);
                    this.val$newView.setTranslationY(0f);
                    DefaultItemAnimator.this.dispatchChangeFinished(this.val$changeInfo.newHolder, false);
                    DefaultItemAnimator.this.mChangeAnimations.remove(this.val$changeInfo.newHolder);
                    DefaultItemAnimator.this.dispatchFinishedWhenDone();
                }

                public void onAnimationStart(Animator arg2) {
                    DefaultItemAnimator.this.dispatchChangeStarting(this.val$changeInfo.newHolder, false);
                }
            }).start();
        }
    }

    public boolean animateMove(ViewHolder arg4, int arg5, int arg6, int arg7, int arg8) {
        View v0 = arg4.itemView;
        arg5 += ((int)arg4.itemView.getTranslationX());
        arg6 += ((int)arg4.itemView.getTranslationY());
        this.resetAnimation(arg4);
        int v1 = arg7 - arg5;
        int v2 = arg8 - arg6;
        if(v1 == 0 && v2 == 0) {
            this.dispatchMoveFinished(arg4);
            return 0;
        }

        if(v1 != 0) {
            v0.setTranslationX(((float)(-v1)));
        }

        if(v2 != 0) {
            v0.setTranslationY(((float)(-v2)));
        }

        this.mPendingMoves.add(new MoveInfo(arg4, arg5, arg6, arg7, arg8));
        return 1;
    }

    void animateMoveImpl(ViewHolder arg8, int arg9, int arg10, int arg11, int arg12) {
        View v4 = arg8.itemView;
        int v3 = arg11 - arg9;
        int v5 = arg12 - arg10;
        if(v3 != 0) {
            v4.animate().translationX(0f);
        }

        if(v5 != 0) {
            v4.animate().translationY(0f);
        }

        ViewPropertyAnimator v6 = v4.animate();
        this.mMoveAnimations.add(arg8);
        v6.setDuration(this.getMoveDuration()).setListener(new AnimatorListenerAdapter(arg8, v3, v4, v5, v6) {
            public void onAnimationCancel(Animator arg2) {
                if(this.val$deltaX != 0) {
                    this.val$view.setTranslationX(0f);
                }

                if(this.val$deltaY != 0) {
                    this.val$view.setTranslationY(0f);
                }
            }

            public void onAnimationEnd(Animator arg2) {
                this.val$animation.setListener(null);
                DefaultItemAnimator.this.dispatchMoveFinished(this.val$holder);
                DefaultItemAnimator.this.mMoveAnimations.remove(this.val$holder);
                DefaultItemAnimator.this.dispatchFinishedWhenDone();
            }

            public void onAnimationStart(Animator arg1) {
                DefaultItemAnimator.this.dispatchMoveStarting(this.val$holder);
            }
        }).start();
    }

    public boolean animateRemove(ViewHolder arg1) {
        this.resetAnimation(arg1);
        this.mPendingRemovals.add(arg1);
        return 1;
    }

    private void animateRemoveImpl(ViewHolder arg5) {
        View v0 = arg5.itemView;
        ViewPropertyAnimator v1 = v0.animate();
        this.mRemoveAnimations.add(arg5);
        v1.setDuration(this.getRemoveDuration()).alpha(0f).setListener(new AnimatorListenerAdapter(arg5, v1, v0) {
            public void onAnimationEnd(Animator arg2) {
                this.val$animation.setListener(null);
                this.val$view.setAlpha(1f);
                DefaultItemAnimator.this.dispatchRemoveFinished(this.val$holder);
                DefaultItemAnimator.this.mRemoveAnimations.remove(this.val$holder);
                DefaultItemAnimator.this.dispatchFinishedWhenDone();
            }

            public void onAnimationStart(Animator arg1) {
                DefaultItemAnimator.this.dispatchRemoveStarting(this.val$holder);
            }
        }).start();
    }

    public boolean canReuseUpdatedViewHolder(ViewHolder arg2, List arg3) {
        if(arg3.isEmpty()) {
            if(super.canReuseUpdatedViewHolder(arg2, arg3)) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    void cancelAll(List arg2) {
        int v1;
        for(v1 = arg2.size() - 1; v1 >= 0; --v1) {
            arg2.get(v1).itemView.animate().cancel();
        }
    }

    void dispatchFinishedWhenDone() {
        if(!this.isRunning()) {
            this.dispatchAnimationsFinished();
        }
    }

    public void endAnimation(ViewHolder arg8) {
        Object v4;
        View v0 = arg8.itemView;
        v0.animate().cancel();
        int v1;
        for(v1 = this.mPendingMoves.size() - 1; v1 >= 0; --v1) {
            if(this.mPendingMoves.get(v1).holder == arg8) {
                v0.setTranslationY(0f);
                v0.setTranslationX(0f);
                this.dispatchMoveFinished(arg8);
                this.mPendingMoves.remove(v1);
            }
        }

        this.endChangeAnimation(this.mPendingChanges, arg8);
        float v3 = 1f;
        if(this.mPendingRemovals.remove(arg8)) {
            v0.setAlpha(v3);
            this.dispatchRemoveFinished(arg8);
        }

        if(this.mPendingAdditions.remove(arg8)) {
            v0.setAlpha(v3);
            this.dispatchAddFinished(arg8);
        }

        for(v1 = this.mChangesList.size() - 1; v1 >= 0; --v1) {
            v4 = this.mChangesList.get(v1);
            this.endChangeAnimation(((List)v4), arg8);
            if(((ArrayList)v4).isEmpty()) {
                this.mChangesList.remove(v1);
            }
        }

        for(v1 = this.mMovesList.size() - 1; v1 >= 0; --v1) {
            v4 = this.mMovesList.get(v1);
            int v5 = ((ArrayList)v4).size() - 1;
            while(v5 >= 0) {
                if(((ArrayList)v4).get(v5).holder == arg8) {
                    v0.setTranslationY(0f);
                    v0.setTranslationX(0f);
                    this.dispatchMoveFinished(arg8);
                    ((ArrayList)v4).remove(v5);
                    if(((ArrayList)v4).isEmpty()) {
                        this.mMovesList.remove(v1);
                    }
                }
                else {
                    --v5;
                    continue;
                }

                break;
            }
        }

        for(v1 = this.mAdditionsList.size() - 1; v1 >= 0; --v1) {
            Object v2 = this.mAdditionsList.get(v1);
            if(((ArrayList)v2).remove(arg8)) {
                v0.setAlpha(v3);
                this.dispatchAddFinished(arg8);
                if(((ArrayList)v2).isEmpty()) {
                    this.mAdditionsList.remove(v1);
                }
            }
        }

        this.mRemoveAnimations.remove(arg8);
        this.mAddAnimations.remove(arg8);
        this.mChangeAnimations.remove(arg8);
        this.mMoveAnimations.remove(arg8);
        this.dispatchFinishedWhenDone();
    }

    public void endAnimations() {
        Object v1;
        ArrayList v3_2;
        Object v3_1;
        float v2_1;
        int v0;
        for(v0 = this.mPendingMoves.size() - 1; v0 >= 0; --v0) {
            Object v2 = this.mPendingMoves.get(v0);
            View v3 = ((MoveInfo)v2).holder.itemView;
            v3.setTranslationY(0f);
            v3.setTranslationX(0f);
            this.dispatchMoveFinished(((MoveInfo)v2).holder);
            this.mPendingMoves.remove(v0);
        }

        for(v0 = this.mPendingRemovals.size() - 1; v0 >= 0; --v0) {
            this.dispatchRemoveFinished(this.mPendingRemovals.get(v0));
            this.mPendingRemovals.remove(v0);
        }

        for(v0 = this.mPendingAdditions.size() - 1; true; --v0) {
            v2_1 = 1f;
            if(v0 < 0) {
                break;
            }

            v3_1 = this.mPendingAdditions.get(v0);
            ((ViewHolder)v3_1).itemView.setAlpha(v2_1);
            this.dispatchAddFinished(((ViewHolder)v3_1));
            this.mPendingAdditions.remove(v0);
        }

        for(v0 = this.mPendingChanges.size() - 1; true; --v0) {
            v3_2 = this.mPendingChanges;
            if(v0 < 0) {
                break;
            }

            this.endChangeAnimationIfNecessary(v3_2.get(v0));
        }

        v3_2.clear();
        if(!this.isRunning()) {
            return;
        }

        for(v0 = this.mMovesList.size() - 1; v0 >= 0; --v0) {
            v3_1 = this.mMovesList.get(v0);
            int v4;
            for(v4 = ((ArrayList)v3_1).size() - 1; v4 >= 0; --v4) {
                Object v5 = ((ArrayList)v3_1).get(v4);
                View v6 = ((MoveInfo)v5).holder.itemView;
                v6.setTranslationY(0f);
                v6.setTranslationX(0f);
                this.dispatchMoveFinished(((MoveInfo)v5).holder);
                ((ArrayList)v3_1).remove(v4);
                if(((ArrayList)v3_1).isEmpty()) {
                    this.mMovesList.remove(v3_1);
                }
            }
        }

        for(v0 = this.mAdditionsList.size() - 1; v0 >= 0; --v0) {
            v1 = this.mAdditionsList.get(v0);
            int v3_3;
            for(v3_3 = ((ArrayList)v1).size() - 1; v3_3 >= 0; --v3_3) {
                Object v4_1 = ((ArrayList)v1).get(v3_3);
                ((ViewHolder)v4_1).itemView.setAlpha(v2_1);
                this.dispatchAddFinished(((ViewHolder)v4_1));
                ((ArrayList)v1).remove(v3_3);
                if(((ArrayList)v1).isEmpty()) {
                    this.mAdditionsList.remove(v1);
                }
            }
        }

        for(v0 = this.mChangesList.size() - 1; v0 >= 0; --v0) {
            v1 = this.mChangesList.get(v0);
            int v2_2;
            for(v2_2 = ((ArrayList)v1).size() - 1; v2_2 >= 0; --v2_2) {
                this.endChangeAnimationIfNecessary(((ArrayList)v1).get(v2_2));
                if(((ArrayList)v1).isEmpty()) {
                    this.mChangesList.remove(v1);
                }
            }
        }

        this.cancelAll(this.mRemoveAnimations);
        this.cancelAll(this.mMoveAnimations);
        this.cancelAll(this.mAddAnimations);
        this.cancelAll(this.mChangeAnimations);
        this.dispatchAnimationsFinished();
    }

    private void endChangeAnimation(List arg4, ViewHolder arg5) {
        int v0;
        for(v0 = arg4.size() - 1; v0 >= 0; --v0) {
            Object v1 = arg4.get(v0);
            if((this.endChangeAnimationIfNecessary(((ChangeInfo)v1), arg5)) && ((ChangeInfo)v1).oldHolder == null && ((ChangeInfo)v1).newHolder == null) {
                arg4.remove(v1);
            }
        }
    }

    private boolean endChangeAnimationIfNecessary(ChangeInfo arg5, ViewHolder arg6) {
        ViewHolder v2 = null;
        boolean v3 = false;
        if(arg5.newHolder == arg6) {
            arg5.newHolder = v2;
        }
        else if(arg5.oldHolder == arg6) {
            arg5.oldHolder = v2;
            v3 = true;
        }
        else {
            return 0;
        }

        arg6.itemView.setAlpha(1f);
        arg6.itemView.setTranslationX(0f);
        arg6.itemView.setTranslationY(0f);
        this.dispatchChangeFinished(arg6, v3);
        return 1;
    }

    private void endChangeAnimationIfNecessary(ChangeInfo arg2) {
        if(arg2.oldHolder != null) {
            this.endChangeAnimationIfNecessary(arg2, arg2.oldHolder);
        }

        if(arg2.newHolder != null) {
            this.endChangeAnimationIfNecessary(arg2, arg2.newHolder);
        }
    }

    public boolean isRunning() {
        if((this.mPendingAdditions.isEmpty()) && (this.mPendingChanges.isEmpty()) && (this.mPendingMoves.isEmpty()) && (this.mPendingRemovals.isEmpty()) && (this.mMoveAnimations.isEmpty()) && (this.mRemoveAnimations.isEmpty()) && (this.mAddAnimations.isEmpty()) && (this.mChangeAnimations.isEmpty()) && (this.mMovesList.isEmpty()) && (this.mAdditionsList.isEmpty())) {
            if(!this.mChangesList.isEmpty()) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    private void resetAnimation(ViewHolder arg3) {
        if(DefaultItemAnimator.sDefaultInterpolator == null) {
            DefaultItemAnimator.sDefaultInterpolator = new ValueAnimator().getInterpolator();
        }

        arg3.itemView.animate().setInterpolator(DefaultItemAnimator.sDefaultInterpolator);
        this.endAnimation(arg3);
    }

    public void runPendingAnimations() {
        ArrayList v5;
        boolean v0 = this.mPendingRemovals.isEmpty();
        boolean v1 = this.mPendingMoves.isEmpty();
        boolean v2 = this.mPendingChanges.isEmpty();
        boolean v3 = this.mPendingAdditions.isEmpty();
        if(!v0 || !v1 || !v3 || !v2) {
            Iterator v4 = this.mPendingRemovals.iterator();
            while(v4.hasNext()) {
                this.animateRemoveImpl(v4.next());
            }

            this.mPendingRemovals.clear();
            if(!v1) {
                v5 = new ArrayList();
                v5.addAll(this.mPendingMoves);
                this.mMovesList.add(v5);
                this.mPendingMoves.clear();
                androidx.recyclerview.widget.DefaultItemAnimator$1 v6 = new Runnable(v5) {
                    public void run() {
                        Iterator v0 = this.val$moves.iterator();
                        while(v0.hasNext()) {
                            Object v1 = v0.next();
                            DefaultItemAnimator.this.animateMoveImpl(((MoveInfo)v1).holder, ((MoveInfo)v1).fromX, ((MoveInfo)v1).fromY, ((MoveInfo)v1).toX, ((MoveInfo)v1).toY);
                        }

                        this.val$moves.clear();
                        DefaultItemAnimator.this.mMovesList.remove(this.val$moves);
                    }
                };
                if(!v0) {
                    ViewCompat.postOnAnimationDelayed(v5.get(0).holder.itemView, ((Runnable)v6), this.getRemoveDuration());
                }
                else {
                    ((Runnable)v6).run();
                }
            }

            if(!v2) {
                v5 = new ArrayList();
                v5.addAll(this.mPendingChanges);
                this.mChangesList.add(v5);
                this.mPendingChanges.clear();
                androidx.recyclerview.widget.DefaultItemAnimator$2 v6_1 = new Runnable(v5) {
                    public void run() {
                        Iterator v0 = this.val$changes.iterator();
                        while(v0.hasNext()) {
                            DefaultItemAnimator.this.animateChangeImpl(v0.next());
                        }

                        this.val$changes.clear();
                        DefaultItemAnimator.this.mChangesList.remove(this.val$changes);
                    }
                };
                if(!v0) {
                    ViewCompat.postOnAnimationDelayed(v5.get(0).oldHolder.itemView, ((Runnable)v6_1), this.getRemoveDuration());
                }
                else {
                    ((Runnable)v6_1).run();
                }
            }

            if(v3) {
                return;
            }

            ArrayList v3_1 = new ArrayList();
            v3_1.addAll(this.mPendingAdditions);
            this.mAdditionsList.add(v3_1);
            this.mPendingAdditions.clear();
            androidx.recyclerview.widget.DefaultItemAnimator$3 v5_1 = new Runnable(v3_1) {
                public void run() {
                    Iterator v0 = this.val$additions.iterator();
                    while(v0.hasNext()) {
                        DefaultItemAnimator.this.animateAddImpl(v0.next());
                    }

                    this.val$additions.clear();
                    DefaultItemAnimator.this.mAdditionsList.remove(this.val$additions);
                }
            };
            if((v0) && (v1)) {
                if(!v2) {
                }
                else {
                    ((Runnable)v5_1).run();
                    return;
                }
            }

            long v6_2 = 0;
            long v8 = !v0 ? this.getRemoveDuration() : v6_2;
            long v0_1 = !v1 ? this.getMoveDuration() : v6_2;
            if(!v2) {
                v6_2 = this.getChangeDuration();
            }

            ViewCompat.postOnAnimationDelayed(v3_1.get(0).itemView, ((Runnable)v5_1), v8 + Math.max(v0_1, v6_2));
        }
        else {
        }
    }
}

