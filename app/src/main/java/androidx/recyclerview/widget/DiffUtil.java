package androidx.recyclerview.widget;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class DiffUtil {
    final class androidx.recyclerview.widget.DiffUtil$1 implements Comparator {
        androidx.recyclerview.widget.DiffUtil$1() {
            super();
        }

        public int compare(Snake arg2, Snake arg3) {
            int v1 = arg2.x - arg3.x;
            if(v1 == 0) {
                v1 = arg2.y - arg3.y;
            }

            return v1;
        }

        public int compare(Object arg1, Object arg2) {
            return this.compare(((Snake)arg1), ((Snake)arg2));
        }
    }

    public abstract class Callback {
        public Callback() {
            super();
        }

        public abstract boolean areContentsTheSame(int arg1, int arg2);

        public abstract boolean areItemsTheSame(int arg1, int arg2);

        public Object getChangePayload(int arg1, int arg2) {
            return null;
        }

        public abstract int getNewListSize();

        public abstract int getOldListSize();
    }

    public class DiffResult {
        private static final int FLAG_CHANGED = 2;
        private static final int FLAG_IGNORE = 16;
        private static final int FLAG_MASK = 0x1F;
        private static final int FLAG_MOVED_CHANGED = 4;
        private static final int FLAG_MOVED_NOT_CHANGED = 8;
        private static final int FLAG_NOT_CHANGED = 1;
        private static final int FLAG_OFFSET = 5;
        public static final int NO_POSITION = -1;
        private final Callback mCallback;
        private final boolean mDetectMoves;
        private final int[] mNewItemStatuses;
        private final int mNewListSize;
        private final int[] mOldItemStatuses;
        private final int mOldListSize;
        private final List mSnakes;

        DiffResult(Callback arg1, List arg2, int[] arg3, int[] arg4, boolean arg5) {
            super();
            this.mSnakes = arg2;
            this.mOldItemStatuses = arg3;
            this.mNewItemStatuses = arg4;
            Arrays.fill(arg3, 0);
            Arrays.fill(arg4, 0);
            this.mCallback = arg1;
            this.mOldListSize = arg1.getOldListSize();
            this.mNewListSize = arg1.getNewListSize();
            this.mDetectMoves = arg5;
            this.addRootSnake();
            this.findMatchingItems();
        }

        private void addRootSnake() {
            Object v0 = this.mSnakes.isEmpty() ? null : this.mSnakes.get(0);
            if(v0 != null && ((Snake)v0).x == 0) {
                if(((Snake)v0).y != 0) {
                }
                else {
                    return;
                }
            }

            Snake v0_1 = new Snake();
            v0_1.x = 0;
            v0_1.y = 0;
            v0_1.removal = false;
            v0_1.size = 0;
            v0_1.reverse = false;
            this.mSnakes.add(0, v0_1);
        }

        public int convertNewPositionToOld(int arg4) {
            if(arg4 >= 0 && arg4 < this.mNewListSize) {
                int v3 = this.mNewItemStatuses[arg4];
                if((v3 & 0x1F) == 0) {
                    return -1;
                }
                else {
                    return v3 >> 5;
                }
            }

            throw new IndexOutOfBoundsException("Index out of bounds - passed position = " + arg4 + ", new list size = " + this.mNewListSize);
        }

        public int convertOldPositionToNew(int arg4) {
            if(arg4 >= 0 && arg4 < this.mOldListSize) {
                int v3 = this.mOldItemStatuses[arg4];
                if((v3 & 0x1F) == 0) {
                    return -1;
                }
                else {
                    return v3 >> 5;
                }
            }

            throw new IndexOutOfBoundsException("Index out of bounds - passed position = " + arg4 + ", old list size = " + this.mOldListSize);
        }

        private void dispatchAdditions(List arg7, ListUpdateCallback arg8, int arg9, int arg10, int arg11) {
            if(!this.mDetectMoves) {
                arg8.onInserted(arg9, arg10);
                return;
            }

            --arg10;
            while(arg10 >= 0) {
                int v2 = arg11 + arg10;
                int v1 = this.mNewItemStatuses[v2];
                int v3 = v1 & 0x1F;
                if(v3 != 0) {
                    int v4 = 4;
                    if(v3 != v4 && v3 != 8) {
                        if(v3 == 16) {
                            arg7.add(new PostponedUpdate(v2, arg9, false));
                            goto label_54;
                        }
                        else {
                            throw new IllegalStateException("unknown flag for pos " + v2 + " " + Long.toBinaryString(((long)v3)));
                        }
                    }

                    v1 >>= 5;
                    arg8.onMoved(DiffResult.removePostponedUpdate(arg7, v1, true).currentPos, arg9);
                    if(v3 != v4) {
                        goto label_54;
                    }

                    arg8.onChanged(arg9, 1, this.mCallback.getChangePayload(v1, v2));
                }
                else {
                    arg8.onInserted(arg9, 1);
                    Iterator v1_1 = arg7.iterator();
                    while(v1_1.hasNext()) {
                        Object v2_1 = v1_1.next();
                        ++((PostponedUpdate)v2_1).currentPos;
                    }
                }

            label_54:
                --arg10;
            }
        }

        private void dispatchRemovals(List arg9, ListUpdateCallback arg10, int arg11, int arg12, int arg13) {
            if(!this.mDetectMoves) {
                arg10.onRemoved(arg11, arg12);
                return;
            }

            --arg12;
            while(arg12 >= 0) {
                int v2 = arg13 + arg12;
                int v1 = this.mOldItemStatuses[v2];
                int v3 = v1 & 0x1F;
                if(v3 != 0) {
                    int v4 = 4;
                    if(v3 != v4 && v3 != 8) {
                        if(v3 == 16) {
                            arg9.add(new PostponedUpdate(v2, arg11 + arg12, true));
                            goto label_60;
                        }
                        else {
                            throw new IllegalStateException("unknown flag for pos " + v2 + " " + Long.toBinaryString(((long)v3)));
                        }
                    }

                    v1 >>= 5;
                    PostponedUpdate v5 = DiffResult.removePostponedUpdate(arg9, v1, false);
                    arg10.onMoved(arg11 + arg12, v5.currentPos - 1);
                    if(v3 != v4) {
                        goto label_60;
                    }

                    arg10.onChanged(v5.currentPos - 1, 1, this.mCallback.getChangePayload(v2, v1));
                }
                else {
                    arg10.onRemoved(arg11 + arg12, 1);
                    Iterator v1_1 = arg9.iterator();
                    while(v1_1.hasNext()) {
                        Object v2_1 = v1_1.next();
                        --((PostponedUpdate)v2).currentPos;
                    }
                }

            label_60:
                --arg12;
            }
        }

        public void dispatchUpdatesTo(ListUpdateCallback arg13) {
            DiffResult v1;
            ListUpdateCallback v3;
            if((arg13 instanceof BatchingListUpdateCallback)) {
                v3 = arg13;
            }
            else {
                BatchingListUpdateCallback v3_1 = new BatchingListUpdateCallback(arg13);
            }

            ArrayList v2 = new ArrayList();
            int v13 = this.mOldListSize;
            int v0 = this.mNewListSize;
            int v8 = this.mSnakes.size() - 1;
            while(v8 >= 0) {
                Object v9 = this.mSnakes.get(v8);
                int v10 = ((Snake)v9).size;
                int v4 = ((Snake)v9).x + v10;
                int v11 = ((Snake)v9).y + v10;
                if(v4 < v13) {
                    v1 = this;
                    v1.dispatchRemovals(((List)v2), v3, v4, v13 - v4, v4);
                }
                else {
                    v1 = this;
                }

                if(v11 < v0) {
                    v1.dispatchAdditions(((List)v2), v3, v4, v0 - v11, v11);
                }

                --v10;
                while(v10 >= 0) {
                    if((v1.mOldItemStatuses[((Snake)v9).x + v10] & 0x1F) == 2) {
                        ((BatchingListUpdateCallback)v3).onChanged(((Snake)v9).x + v10, 1, v1.mCallback.getChangePayload(((Snake)v9).x + v10, ((Snake)v9).y + v10));
                    }

                    --v10;
                }

                v13 = ((Snake)v9).x;
                v0 = ((Snake)v9).y;
                --v8;
                this = v1;
            }

            ((BatchingListUpdateCallback)v3).dispatchLastEvent();
        }

        public void dispatchUpdatesTo(Adapter arg2) {
            this.dispatchUpdatesTo(new AdapterListUpdateCallback(arg2));
        }

        private void findAddition(int arg3, int arg4, int arg5) {
            if(this.mOldItemStatuses[arg3 - 1] != 0) {
                return;
            }

            this.findMatchingItem(arg3, arg4, arg5, false);
        }

        private boolean findMatchingItem(int arg9, int arg10, int arg11, boolean arg12) {
            int v0;
            int v1;
            if(arg12) {
                --arg10;
                v1 = arg9;
                v0 = arg10;
            }
            else {
                v0 = arg9 - 1;
                v1 = v0;
            }

            while(arg11 >= 0) {
                Object v2 = this.mSnakes.get(arg11);
                int v3 = ((Snake)v2).x + ((Snake)v2).size;
                int v4 = ((Snake)v2).y + ((Snake)v2).size;
                int v5 = 8;
                int v6 = 4;
                if(arg12) {
                    --v1;
                    while(v1 >= v3) {
                        if(this.mCallback.areItemsTheSame(v1, v0)) {
                            if(this.mCallback.areContentsTheSame(v1, v0)) {
                            }
                            else {
                                v5 = v6;
                            }

                            this.mNewItemStatuses[v0] = v1 << 5 | 16;
                            this.mOldItemStatuses[v1] = v0 << 5 | v5;
                            return 1;
                        }
                        else {
                            --v1;
                            continue;
                        }

                        break;
                    }
                }
                else {
                    --arg10;
                    while(arg10 >= v4) {
                        if(this.mCallback.areItemsTheSame(v0, arg10)) {
                            if(this.mCallback.areContentsTheSame(v0, arg10)) {
                            }
                            else {
                                v5 = v6;
                            }

                            --arg9;
                            this.mOldItemStatuses[arg9] = arg10 << 5 | 16;
                            this.mNewItemStatuses[arg10] = arg9 << 5 | v5;
                            return 1;
                        }

                        --arg10;
                    }
                }

                v1 = ((Snake)v2).x;
                arg10 = ((Snake)v2).y;
                --arg11;
            }

            return 0;
        }

        private void findMatchingItems() {
            int v0 = this.mOldListSize;
            int v1 = this.mNewListSize;
            int v2;
            for(v2 = this.mSnakes.size() - 1; v2 >= 0; --v2) {
                Object v4 = this.mSnakes.get(v2);
                int v5 = ((Snake)v4).x + ((Snake)v4).size;
                int v6 = ((Snake)v4).y + ((Snake)v4).size;
                if(this.mDetectMoves) {
                    while(v0 > v5) {
                        this.findAddition(v0, v1, v2);
                        --v0;
                    }

                    while(v1 > v6) {
                        this.findRemoval(v0, v1, v2);
                        --v1;
                    }
                }

                for(v0 = 0; v0 < ((Snake)v4).size; ++v0) {
                    v1 = ((Snake)v4).x + v0;
                    v5 = ((Snake)v4).y + v0;
                    v6 = this.mCallback.areContentsTheSame(v1, v5) ? 1 : 2;
                    this.mOldItemStatuses[v1] = v5 << 5 | v6;
                    this.mNewItemStatuses[v5] = v1 << 5 | v6;
                }

                v0 = ((Snake)v4).x;
                v1 = ((Snake)v4).y;
            }
        }

        private void findRemoval(int arg3, int arg4, int arg5) {
            if(this.mNewItemStatuses[arg4 - 1] != 0) {
                return;
            }

            this.findMatchingItem(arg3, arg4, arg5, true);
        }

        List getSnakes() {
            return this.mSnakes;
        }

        private static PostponedUpdate removePostponedUpdate(List arg5, int arg6, boolean arg7) {
            Object v2;
            int v0;
            for(v0 = arg5.size() - 1; v0 >= 0; --v0) {
                v2 = arg5.get(v0);
                if(((PostponedUpdate)v2).posInOwnerList == arg6 && ((PostponedUpdate)v2).removal == arg7) {
                    arg5.remove(v0);
                    goto label_10;
                }
            }

            return null;
        label_10:
            while(v0 < arg5.size()) {
                Object v6 = arg5.get(v0);
                int v3 = ((PostponedUpdate)v6).currentPos;
                int v4 = arg7 ? 1 : -1;
                ((PostponedUpdate)v6).currentPos = v3 + v4;
                ++v0;
            }

            return ((PostponedUpdate)v2);
        }
    }

    public abstract class ItemCallback {
        public ItemCallback() {
            super();
        }

        public abstract boolean areContentsTheSame(Object arg1, Object arg2);

        public abstract boolean areItemsTheSame(Object arg1, Object arg2);

        public Object getChangePayload(Object arg1, Object arg2) {
            return null;
        }
    }

    class PostponedUpdate {
        int currentPos;
        int posInOwnerList;
        boolean removal;

        public PostponedUpdate(int arg1, int arg2, boolean arg3) {
            super();
            this.posInOwnerList = arg1;
            this.currentPos = arg2;
            this.removal = arg3;
        }
    }

    class Range {
        int newListEnd;
        int newListStart;
        int oldListEnd;
        int oldListStart;

        public Range(int arg1, int arg2, int arg3, int arg4) {
            super();
            this.oldListStart = arg1;
            this.oldListEnd = arg2;
            this.newListStart = arg3;
            this.newListEnd = arg4;
        }

        public Range() {
            super();
        }
    }

    class Snake {
        boolean removal;
        boolean reverse;
        int size;
        int x;
        int y;

        Snake() {
            super();
        }
    }

    private static final Comparator SNAKE_COMPARATOR;

    static {
        DiffUtil.SNAKE_COMPARATOR = new androidx.recyclerview.widget.DiffUtil$1();
    }

    private DiffUtil() {
        super();
    }

    public static DiffResult calculateDiff(Callback arg1) {
        return DiffUtil.calculateDiff(arg1, true);
    }

    public static DiffResult calculateDiff(Callback arg13, boolean arg14) {
        Range v6_1;
        int v0 = arg13.getOldListSize();
        int v1 = arg13.getNewListSize();
        ArrayList v4 = new ArrayList();
        ArrayList v2 = new ArrayList();
        ((List)v2).add(new Range(0, v0, 0, v1));
        int v12 = v0 + v1 + Math.abs(v0 - v1);
        v0 = v12 * 2;
        int[] v5 = new int[v0];
        int[] v6 = new int[v0];
        ArrayList v0_1 = new ArrayList();
        while(!((List)v2).isEmpty()) {
            Object v1_1 = ((List)v2).remove(((List)v2).size() - 1);
            int[] v11 = v6;
            int[] v10 = v5;
            Callback v5_1 = arg13;
            Snake v13 = DiffUtil.diffPartial(v5_1, ((Range)v1_1).oldListStart, ((Range)v1_1).oldListEnd, ((Range)v1_1).newListStart, ((Range)v1_1).newListEnd, v10, v11, v12);
            Callback v3 = v5_1;
            v5 = v10;
            if(v13 != null) {
                if(v13.size > 0) {
                    ((List)v4).add(v13);
                }

                v13.x += ((Range)v1_1).oldListStart;
                v13.y += ((Range)v1_1).newListStart;
                if(((List)v0_1).isEmpty()) {
                    v6_1 = new Range();
                }
                else {
                    Object v6_2 = ((List)v0_1).remove(((List)v0_1).size() - 1);
                }

                v6_1.oldListStart = ((Range)v1_1).oldListStart;
                v6_1.newListStart = ((Range)v1_1).newListStart;
                if(v13.reverse) {
                    v6_1.oldListEnd = v13.x;
                    v6_1.newListEnd = v13.y;
                }
                else if(v13.removal) {
                    v6_1.oldListEnd = v13.x - 1;
                    v6_1.newListEnd = v13.y;
                }
                else {
                    v6_1.oldListEnd = v13.x;
                    v6_1.newListEnd = v13.y - 1;
                }

                ((List)v2).add(v6_1);
                if(!v13.reverse) {
                    ((Range)v1_1).oldListStart = v13.x + v13.size;
                    ((Range)v1_1).newListStart = v13.y + v13.size;
                }
                else if(v13.removal) {
                    ((Range)v1_1).oldListStart = v13.x + v13.size + 1;
                    ((Range)v1_1).newListStart = v13.y + v13.size;
                }
                else {
                    ((Range)v1_1).oldListStart = v13.x + v13.size;
                    ((Range)v1_1).newListStart = v13.y + v13.size + 1;
                }

                ((List)v2).add(v1_1);
            }
            else {
                ((List)v0_1).add(v1_1);
            }

            arg13 = v3;
            v6 = v11;
        }

        Collections.sort(((List)v4), DiffUtil.SNAKE_COMPARATOR);
        return new DiffResult(arg13, ((List)v4), v5, v6, arg14);
    }

    private static Snake diffPartial(Callback arg17, int arg18, int arg19, int arg20, int arg21, int[] arg22, int[] arg23, int arg24) {
        Snake v0_1;
        boolean v14;
        int v13;
        Callback v0 = arg17;
        int[] v1 = arg22;
        int[] v2 = arg23;
        int v3 = arg19 - arg18;
        int v4 = arg21 - arg20;
        int v5 = 1;
        if(v3 >= 1) {
            if(v4 < 1) {
            }
            else {
                int v6 = v3 - v4;
                int v7 = (v3 + v4 + 1) / 2;
                int v8 = arg24 - v7 - 1;
                int v9 = arg24 + v7 + 1;
                boolean v10 = false;
                Arrays.fill(v1, v8, v9, 0);
                Arrays.fill(v2, v8 + v6, v9 + v6, v3);
                v8 = v6 % 2 != 0 ? 1 : 0;
                v9 = 0;
                while(v9 <= v7) {
                    int v11 = -v9;
                    int v12 = v11;
                    while(v12 <= v9) {
                        if(v12 != v11) {
                            if(v12 != v9) {
                                v13 = arg24 + v12;
                                if(v1[v13 - 1] < v1[v13 + v5]) {
                                    goto label_47;
                                }
                            }

                            v13 = v1[arg24 + v12 - v5] + v5;
                            v14 = ((boolean)v5);
                        }
                        else {
                        label_47:
                            v13 = v1[arg24 + v12 + v5];
                            v14 = v10;
                        }

                        int v15 = v13 - v12;
                        while(true) {
                            if(v13 >= v3) {
                                break;
                            }
                            else if(v15 < v4) {
                                arg19 = v5;
                                if(v0.areItemsTheSame(arg18 + v13, arg20 + v15)) {
                                    ++v13;
                                    ++v15;
                                    v5 = arg19;
                                    continue;
                                }
                            }
                            else {
                                break;
                            }

                            goto label_65;
                        }

                        arg19 = v5;
                    label_65:
                        v5 = arg24 + v12;
                        v1[v5] = v13;
                        if(v8 != 0 && v12 >= v6 - v9 + 1 && v12 <= v6 + v9 - 1 && v13 >= v2[v5]) {
                            v0_1 = new Snake();
                            v0_1.x = v2[v5];
                            ((Snake)v0).y = ((Snake)v0).x - v12;
                            v0_1.size = v1[v5] - v2[v5];
                            v0_1.removal = v14;
                            v0_1.reverse = false;
                            return v0_1;
                        }

                        v12 += 2;
                        v10 = false;
                        v5 = arg19;
                    }

                    arg19 = v5;
                    boolean v5_1 = v10;
                    int v10_1 = v11;
                    while(v10_1 <= v9) {
                        v12 = v10_1 + v6;
                        if(v12 != v9 + v6) {
                            if(v12 != v11 + v6) {
                                v13 = arg24 + v12;
                                if(v2[v13 - 1] < v2[v13 + 1]) {
                                    goto label_118;
                                }
                            }

                            v13 = v2[arg24 + v12 + 1] - 1;
                            v14 = ((boolean)arg19);
                        }
                        else {
                        label_118:
                            v13 = v2[arg24 + v12 - 1];
                            v14 = v5_1;
                        }

                        for(v15 = v13 - v12; v13 > 0; --v15) {
                            if(v15 <= 0) {
                                break;
                            }

                            if(!v0.areItemsTheSame(arg18 + v13 - 1, arg20 + v15 - 1)) {
                                break;
                            }

                            --v13;
                        }

                        int v1_1 = arg24 + v12;
                        v2[v1_1] = v13;
                        if(v8 == 0 && v12 >= v11 && v12 <= v9 && arg22[v1_1] >= v13) {
                            v0_1 = new Snake();
                            v0_1.x = v2[v1_1];
                            ((Snake)v0).y = ((Snake)v0).x - v12;
                            v0_1.size = arg22[v1_1] - v2[v1_1];
                            v0_1.removal = v14;
                            v0_1.reverse = ((boolean)arg19);
                            return v0_1;
                        }

                        v10_1 += 2;
                        boolean v19 = arg19;
                        v5_1 = false;
                    }

                    ++v9;
                    v5 = arg19;
                    v10 = false;
                    v1 = arg22;
                }

                throw new IllegalStateException("DiffUtil hit an unexpected case while trying to calculate the optimal path. Please make sure your data is not changing during the diff calculation.");
            }
        }

        return null;
    }
}

