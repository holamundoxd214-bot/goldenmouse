package androidx.coordinatorlayout.widget;

import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools$Pool;
import androidx.core.util.Pools$SimplePool;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class DirectedAcyclicGraph {
    private final SimpleArrayMap mGraph;
    private final Pool mListPool;
    private final ArrayList mSortResult;
    private final HashSet mSortTmpMarked;

    public DirectedAcyclicGraph() {
        super();
        this.mListPool = new SimplePool(10);
        this.mGraph = new SimpleArrayMap();
        this.mSortResult = new ArrayList();
        this.mSortTmpMarked = new HashSet();
    }

    public void addEdge(Object arg2, Object arg3) {
        if((this.mGraph.containsKey(arg2)) && (this.mGraph.containsKey(arg3))) {
            Object v0 = this.mGraph.get(arg2);
            if(v0 == null) {
                ArrayList v0_1 = this.getEmptyList();
                this.mGraph.put(arg2, v0_1);
            }

            ((ArrayList)v0).add(arg3);
            return;
        }

        throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
    }

    public void addNode(Object arg2) {
        if(!this.mGraph.containsKey(arg2)) {
            this.mGraph.put(arg2, null);
        }
    }

    public void clear() {
        SimpleArrayMap v2;
        int v0 = this.mGraph.size();
        int v1;
        for(v1 = 0; true; ++v1) {
            v2 = this.mGraph;
            if(v1 >= v0) {
                break;
            }

            Object v2_1 = v2.valueAt(v1);
            if(v2_1 != null) {
                this.poolList(((ArrayList)v2_1));
            }
        }

        v2.clear();
    }

    public boolean contains(Object arg1) {
        return this.mGraph.containsKey(arg1);
    }

    private void dfs(Object arg5, ArrayList arg6, HashSet arg7) {
        if(arg6.contains(arg5)) {
            return;
        }

        if(!arg7.contains(arg5)) {
            arg7.add(arg5);
            Object v0 = this.mGraph.get(arg5);
            if(v0 != null) {
                int v1 = ((ArrayList)v0).size();
                int v2;
                for(v2 = 0; v2 < v1; ++v2) {
                    this.dfs(((ArrayList)v0).get(v2), arg6, arg7);
                }
            }

            arg7.remove(arg5);
            arg6.add(arg5);
            return;
        }

        throw new RuntimeException("This graph contains cyclic dependencies");
    }

    private ArrayList getEmptyList() {
        Object v0 = this.mListPool.acquire();
        if(v0 == null) {
            ArrayList v0_1 = new ArrayList();
        }

        return ((ArrayList)v0);
    }

    public List getIncomingEdges(Object arg1) {
        return this.mGraph.get(arg1);
    }

    public List getOutgoingEdges(Object arg5) {
        int v0 = this.mGraph.size();
        ArrayList v1 = null;
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            Object v3 = this.mGraph.valueAt(v2);
            if(v3 != null && (((ArrayList)v3).contains(arg5))) {
                if(v1 == null) {
                    v1 = new ArrayList();
                }

                v1.add(this.mGraph.keyAt(v2));
            }
        }

        return ((List)v1);
    }

    public ArrayList getSortedList() {
        this.mSortResult.clear();
        this.mSortTmpMarked.clear();
        int v0 = this.mGraph.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            this.dfs(this.mGraph.keyAt(v1), this.mSortResult, this.mSortTmpMarked);
        }

        return this.mSortResult;
    }

    public boolean hasOutgoingEdges(Object arg5) {
        int v0 = this.mGraph.size();
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            Object v3 = this.mGraph.valueAt(v2);
            if(v3 != null && (((ArrayList)v3).contains(arg5))) {
                return 1;
            }
        }

        return 0;
    }

    private void poolList(ArrayList arg1) {
        arg1.clear();
        this.mListPool.release(arg1);
    }

    int size() {
        return this.mGraph.size();
    }
}

