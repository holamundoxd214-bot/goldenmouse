package androidx.arch.core.internal;

import java.util.Iterator;
import java.util.Map$Entry;
import java.util.WeakHashMap;

public class SafeIterableMap implements Iterable {
    class AscendingIterator extends ListIterator {
        AscendingIterator(Entry arg1, Entry arg2) {
            super(arg1, arg2);
        }

        Entry backward(Entry arg1) {
            return arg1.mPrevious;
        }

        Entry forward(Entry arg1) {
            return arg1.mNext;
        }
    }

    class DescendingIterator extends ListIterator {
        DescendingIterator(Entry arg1, Entry arg2) {
            super(arg1, arg2);
        }

        Entry backward(Entry arg1) {
            return arg1.mNext;
        }

        Entry forward(Entry arg1) {
            return arg1.mPrevious;
        }
    }

    class Entry implements Map$Entry {
        final Object mKey;
        Entry mNext;
        Entry mPrevious;
        final Object mValue;

        Entry(Object arg1, Object arg2) {
            super();
            this.mKey = arg1;
            this.mValue = arg2;
        }

        public boolean equals(Object arg5) {
            if((((Entry)arg5)) == this) {
                return 1;
            }

            if(!(arg5 instanceof Entry)) {
                return 0;
            }

            if((this.mKey.equals(((Entry)arg5).mKey)) && (this.mValue.equals(((Entry)arg5).mValue))) {
                return 1;
            }

            return 0;
        }

        public Object getKey() {
            return this.mKey;
        }

        public Object getValue() {
            return this.mValue;
        }

        public int hashCode() {
            return this.mValue.hashCode() ^ this.mKey.hashCode();
        }

        public Object setValue(Object arg1) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.mKey + "=" + this.mValue;
        }
    }

    public class IteratorWithAdditions extends SupportRemove implements Iterator {
        private boolean mBeforeStart;
        private Entry mCurrent;

        IteratorWithAdditions(SafeIterableMap arg1) {
            SafeIterableMap.this = arg1;
            super();
            this.mBeforeStart = true;
        }

        public boolean hasNext() {
            if(this.mBeforeStart) {
                if(SafeIterableMap.this.mStart != null) {
                    return 1;
                }

                return 0;
            }

            Entry v3 = this.mCurrent;
            if(v3 != null && v3.mNext != null) {
                return 1;
            }

            return 0;
        }

        public Object next() {
            return this.next();
        }

        public Map$Entry next() {
            Entry v0;
            if(this.mBeforeStart) {
                this.mBeforeStart = false;
                v0 = SafeIterableMap.this.mStart;
                this.mCurrent = v0;
                return ((Map$Entry)v0);
            }

            v0 = this.mCurrent;
            v0 = v0 != null ? v0.mNext : null;
            this.mCurrent = v0;
            return ((Map$Entry)v0);
        }

        void supportRemove(Entry arg2) {
            Entry v0 = this.mCurrent;
            if(arg2 == v0) {
                arg2 = v0.mPrevious;
                this.mCurrent = arg2;
                boolean v2 = arg2 == null ? true : false;
                this.mBeforeStart = v2;
            }
        }
    }

    abstract class ListIterator extends SupportRemove implements Iterator {
        Entry mExpectedEnd;
        Entry mNext;

        ListIterator(Entry arg1, Entry arg2) {
            super();
            this.mExpectedEnd = arg2;
            this.mNext = arg1;
        }

        abstract Entry backward(Entry arg1);

        abstract Entry forward(Entry arg1);

        public boolean hasNext() {
            if(this.mNext != null) {
                return 1;
            }

            return 0;
        }

        public Object next() {
            return this.next();
        }

        public Map$Entry next() {
            Entry v0 = this.mNext;
            this.mNext = this.nextNode();
            return ((Map$Entry)v0);
        }

        private Entry nextNode() {
            Entry v0 = this.mNext;
            Entry v1 = this.mExpectedEnd;
            if(v0 != v1) {
                if(v1 == null) {
                }
                else {
                    return this.forward(v0);
                }
            }

            return null;
        }

        public void supportRemove(Entry arg2) {
            if(this.mExpectedEnd == arg2 && arg2 == this.mNext) {
                this.mNext = null;
                this.mExpectedEnd = null;
            }

            Entry v0 = this.mExpectedEnd;
            if(v0 == arg2) {
                this.mExpectedEnd = this.backward(v0);
            }

            if(this.mNext == arg2) {
                this.mNext = this.nextNode();
            }
        }
    }

    public abstract class SupportRemove {
        public SupportRemove() {
            super();
        }

        abstract void supportRemove(Entry arg1);
    }

    private Entry mEnd;
    private final WeakHashMap mIterators;
    private int mSize;
    Entry mStart;

    public SafeIterableMap() {
        super();
        this.mIterators = new WeakHashMap();
        this.mSize = 0;
    }

    public Iterator descendingIterator() {
        DescendingIterator v0 = new DescendingIterator(this.mEnd, this.mStart);
        this.mIterators.put(v0, Boolean.valueOf(false));
        return ((Iterator)v0);
    }

    public Map$Entry eldest() {
        return this.mStart;
    }

    public boolean equals(Object arg5) {
        if((((SafeIterableMap)arg5)) == this) {
            return 1;
        }

        if(!(arg5 instanceof SafeIterableMap)) {
            return 0;
        }

        if(this.size() != ((SafeIterableMap)arg5).size()) {
            return 0;
        }

        Iterator v4 = this.iterator();
        Iterator v5 = ((SafeIterableMap)arg5).iterator();
        do {
            if((v4.hasNext()) && (v5.hasNext())) {
                Object v1 = v4.next();
                Object v3 = v5.next();
                if(v1 != null || v3 == null) {
                    if(v1 == null) {
                        continue;
                    }

                    if(v1.equals(v3)) {
                        continue;
                    }
                }

                return 0;
            }

            goto label_25;
        }
        while(true);

        return 0;
    label_25:
        if(!v4.hasNext() && !v5.hasNext()) {
            return 1;
        }

        return 0;
    }

    protected Entry get(Object arg2) {
        Entry v1 = this.mStart;
        while(v1 != null) {
            if(v1.mKey.equals(arg2)) {
            }
            else {
                v1 = v1.mNext;
                continue;
            }

            return v1;
        }

        return v1;
    }

    public int hashCode() {
        Iterator v2 = this.iterator();
        int v0;
        for(v0 = 0; v2.hasNext(); v0 += v2.next().hashCode()) {
        }

        return v0;
    }

    public Iterator iterator() {
        AscendingIterator v0 = new AscendingIterator(this.mStart, this.mEnd);
        this.mIterators.put(v0, Boolean.valueOf(false));
        return ((Iterator)v0);
    }

    public IteratorWithAdditions iteratorWithAdditions() {
        IteratorWithAdditions v0 = new IteratorWithAdditions(this);
        this.mIterators.put(v0, Boolean.valueOf(false));
        return v0;
    }

    public Map$Entry newest() {
        return this.mEnd;
    }

    Entry put(Object arg2, Object arg3) {
        Entry v0 = new Entry(arg2, arg3);
        ++this.mSize;
        Entry v2 = this.mEnd;
        if(v2 == null) {
            this.mStart = v0;
            this.mEnd = v0;
            return v0;
        }

        v2.mNext = v0;
        v0.mPrevious = this.mEnd;
        this.mEnd = v0;
        return v0;
    }

    public Object putIfAbsent(Object arg2, Object arg3) {
        Entry v0 = this.get(arg2);
        if(v0 != null) {
            return v0.mValue;
        }

        this.put(arg2, arg3);
        return null;
    }

    public Object remove(Object arg4) {
        Entry v4 = this.get(arg4);
        Object v0 = null;
        if(v4 == null) {
            return v0;
        }

        --this.mSize;
        if(!this.mIterators.isEmpty()) {
            Iterator v1 = this.mIterators.keySet().iterator();
            while(v1.hasNext()) {
                v1.next().supportRemove(v4);
            }
        }

        if(v4.mPrevious != null) {
            v4.mPrevious.mNext = v4.mNext;
        }
        else {
            this.mStart = v4.mNext;
        }

        if(v4.mNext != null) {
            v4.mNext.mPrevious = v4.mPrevious;
        }
        else {
            this.mEnd = v4.mPrevious;
        }

        v4.mNext = ((Entry)v0);
        v4.mPrevious = ((Entry)v0);
        return v4.mValue;
    }

    public int size() {
        return this.mSize;
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder("[");
        Iterator v2 = this.iterator();
        while(v2.hasNext()) {
            v0.append(v2.next().toString());
            if(!v2.hasNext()) {
                continue;
            }

            v0.append(", ");
        }

        v0.append("]");
        return v0.toString();
    }
}

