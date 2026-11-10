package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import java.lang.reflect.Array;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map$Entry;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class ArrayMap extends SimpleArrayMap implements Map {
    final class EntrySet extends AbstractSet {
        EntrySet(ArrayMap arg1) {
            ArrayMap.this = arg1;
            super();
        }

        public Iterator iterator() {
            return new MapIterator(ArrayMap.this);
        }

        public int size() {
            return ArrayMap.this.size();
        }
    }

    final class KeyIterator extends IndexBasedArrayIterator {
        KeyIterator(ArrayMap arg1) {
            ArrayMap.this = arg1;
            super(arg1.size());
        }

        protected Object elementAt(int arg1) {
            return ArrayMap.this.keyAt(arg1);
        }

        protected void removeAt(int arg1) {
            ArrayMap.this.removeAt(arg1);
        }
    }

    final class KeySet implements Set {
        KeySet(ArrayMap arg1) {
            ArrayMap.this = arg1;
            super();
        }

        public boolean add(Object arg1) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection arg1) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            ArrayMap.this.clear();
        }

        public boolean contains(Object arg1) {
            return ArrayMap.this.containsKey(arg1);
        }

        public boolean containsAll(Collection arg1) {
            return ArrayMap.this.containsAll(arg1);
        }

        public boolean equals(Object arg1) {
            return ArrayMap.equalsSetHelper(((Set)this), arg1);
        }

        public int hashCode() {
            int v0 = ArrayMap.this.size() - 1;
            int v2 = 0;
            while(v0 >= 0) {
                Object v3 = ArrayMap.this.keyAt(v0);
                int v3_1 = v3 == null ? 0 : v3.hashCode();
                v2 += v3_1;
                --v0;
            }

            return v2;
        }

        public boolean isEmpty() {
            return ArrayMap.this.isEmpty();
        }

        public Iterator iterator() {
            return new KeyIterator(ArrayMap.this);
        }

        public boolean remove(Object arg2) {
            int v2 = ArrayMap.this.indexOfKey(arg2);
            if(v2 >= 0) {
                ArrayMap.this.removeAt(v2);
                return 1;
            }

            return 0;
        }

        public boolean removeAll(Collection arg1) {
            return ArrayMap.this.removeAll(arg1);
        }

        public boolean retainAll(Collection arg1) {
            return ArrayMap.this.retainAll(arg1);
        }

        public int size() {
            return ArrayMap.this.size();
        }

        public Object[] toArray() {
            int v0 = ArrayMap.this.size();
            Object[] v1 = new Object[v0];
            int v2;
            for(v2 = 0; v2 < v0; ++v2) {
                v1[v2] = ArrayMap.this.keyAt(v2);
            }

            return v1;
        }

        public Object[] toArray(Object[] arg4) {
            Object v4;
            int v0 = this.size();
            if(arg4.length < v0) {
                v4 = Array.newInstance(arg4.getClass().getComponentType(), v0);
            }

            int v1;
            for(v1 = 0; v1 < v0; ++v1) {
                ((Object[])v4)[v1] = ArrayMap.this.keyAt(v1);
            }

            if(((Object[])v4).length > v0) {
                ((Object[])v4)[v0] = null;
            }

            return ((Object[])v4);
        }
    }

    final class MapIterator implements Iterator, Map$Entry {
        int mEnd;
        boolean mEntryValid;
        int mIndex;

        MapIterator(ArrayMap arg1) {
            ArrayMap.this = arg1;
            super();
            this.mEnd = arg1.size() - 1;
            this.mIndex = -1;
        }

        public boolean equals(Object arg5) {
            if(this.mEntryValid) {
                if(!(arg5 instanceof Map$Entry)) {
                    return 0;
                }

                if((ContainerHelpersKt.equal(((Map$Entry)arg5).getKey(), ArrayMap.this.keyAt(this.mIndex))) && (ContainerHelpersKt.equal(((Map$Entry)arg5).getValue(), ArrayMap.this.valueAt(this.mIndex)))) {
                    return 1;
                }

                return 0;
            }

            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public Object getKey() {
            if(this.mEntryValid) {
                return ArrayMap.this.keyAt(this.mIndex);
            }

            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public Object getValue() {
            if(this.mEntryValid) {
                return ArrayMap.this.valueAt(this.mIndex);
            }

            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public boolean hasNext() {
            if(this.mIndex < this.mEnd) {
                return 1;
            }

            return 0;
        }

        public int hashCode() {
            if(this.mEntryValid) {
                Object v0 = ArrayMap.this.keyAt(this.mIndex);
                Object v2 = ArrayMap.this.valueAt(this.mIndex);
                int v1 = 0;
                int v0_1 = v0 == null ? 0 : v0.hashCode();
                if(v2 == null) {
                }
                else {
                    v1 = v2.hashCode();
                }

                return v0_1 ^ v1;
            }

            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public Object next() {
            return this.next();
        }

        public Map$Entry next() {
            if(this.hasNext()) {
                ++this.mIndex;
                this.mEntryValid = true;
                return this;
            }

            throw new NoSuchElementException();
        }

        public void remove() {
            if(this.mEntryValid) {
                ArrayMap.this.removeAt(this.mIndex);
                --this.mIndex;
                --this.mEnd;
                this.mEntryValid = false;
                return;
            }

            throw new IllegalStateException();
        }

        public Object setValue(Object arg2) {
            if(this.mEntryValid) {
                return ArrayMap.this.setValueAt(this.mIndex, arg2);
            }

            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return this.getKey() + "=" + this.getValue();
        }
    }

    final class ValueCollection implements Collection {
        ValueCollection(ArrayMap arg1) {
            ArrayMap.this = arg1;
            super();
        }

        public boolean add(Object arg1) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection arg1) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            ArrayMap.this.clear();
        }

        public boolean contains(Object arg1) {
            if(ArrayMap.this.__restricted$indexOfValue(arg1) >= 0) {
                return 1;
            }

            return 0;
        }

        public boolean containsAll(Collection arg2) {
            Iterator v2 = arg2.iterator();
            do {
                if(!v2.hasNext()) {
                    return 1;
                }
            }
            while(this.contains(v2.next()));

            return 0;
        }

        public boolean isEmpty() {
            return ArrayMap.this.isEmpty();
        }

        public Iterator iterator() {
            return new ValueIterator(ArrayMap.this);
        }

        public boolean remove(Object arg2) {
            int v2 = ArrayMap.this.__restricted$indexOfValue(arg2);
            if(v2 >= 0) {
                ArrayMap.this.removeAt(v2);
                return 1;
            }

            return 0;
        }

        public boolean removeAll(Collection arg6) {
            int v0 = ArrayMap.this.size();
            int v1 = 0;
            boolean v2 = false;
            while(v1 < v0) {
                if(arg6.contains(ArrayMap.this.valueAt(v1))) {
                    ArrayMap.this.removeAt(v1);
                    --v1;
                    --v0;
                    v2 = true;
                }

                ++v1;
            }

            return v2;
        }

        public boolean retainAll(Collection arg6) {
            int v0 = ArrayMap.this.size();
            int v1 = 0;
            boolean v2 = false;
            while(v1 < v0) {
                if(!arg6.contains(ArrayMap.this.valueAt(v1))) {
                    ArrayMap.this.removeAt(v1);
                    --v1;
                    --v0;
                    v2 = true;
                }

                ++v1;
            }

            return v2;
        }

        public int size() {
            return ArrayMap.this.size();
        }

        public Object[] toArray() {
            int v0 = ArrayMap.this.size();
            Object[] v1 = new Object[v0];
            int v2;
            for(v2 = 0; v2 < v0; ++v2) {
                v1[v2] = ArrayMap.this.valueAt(v2);
            }

            return v1;
        }

        public Object[] toArray(Object[] arg4) {
            Object v4;
            int v0 = this.size();
            if(arg4.length < v0) {
                v4 = Array.newInstance(arg4.getClass().getComponentType(), v0);
            }

            int v1;
            for(v1 = 0; v1 < v0; ++v1) {
                ((Object[])v4)[v1] = ArrayMap.this.valueAt(v1);
            }

            if(((Object[])v4).length > v0) {
                ((Object[])v4)[v0] = null;
            }

            return ((Object[])v4);
        }
    }

    final class ValueIterator extends IndexBasedArrayIterator {
        ValueIterator(ArrayMap arg1) {
            ArrayMap.this = arg1;
            super(arg1.size());
        }

        protected Object elementAt(int arg1) {
            return ArrayMap.this.valueAt(arg1);
        }

        protected void removeAt(int arg1) {
            ArrayMap.this.removeAt(arg1);
        }
    }

    EntrySet mEntrySet;
    KeySet mKeySet;
    ValueCollection mValues;

    public ArrayMap() {
        super();
    }

    public ArrayMap(int arg1) {
        super(arg1);
    }

    public ArrayMap(SimpleArrayMap arg1) {
        super(arg1);
    }

    public boolean containsAll(Collection arg2) {
        Iterator v2 = arg2.iterator();
        do {
            if(!v2.hasNext()) {
                return 1;
            }
        }
        while(this.containsKey(v2.next()));

        return 0;
    }

    public boolean containsKey(Object arg1) {
        return super.containsKey(arg1);
    }

    public boolean containsValue(Object arg1) {
        return super.containsValue(arg1);
    }

    public Set entrySet() {
        EntrySet v0 = this.mEntrySet;
        if(v0 == null) {
            v0 = new EntrySet(this);
            this.mEntrySet = v0;
        }

        return ((Set)v0);
    }

    static boolean equalsSetHelper(Set arg4, Object arg5) {
        if(arg4 == (((Set)arg5))) {
            return 1;
        }

        if((arg5 instanceof Set)) {
            try {
                if(arg4.size() == ((Set)arg5).size() && (arg4.containsAll(((Collection)arg5)))) {
                    return 1;
                }
            }
            catch(ClassCastException ) {
            }

            return 0;
        }

        return 0;
    }

    public Object get(Object arg1) {
        return super.get(arg1);
    }

    public Set keySet() {
        KeySet v0 = this.mKeySet;
        if(v0 == null) {
            v0 = new KeySet(this);
            this.mKeySet = v0;
        }

        return ((Set)v0);
    }

    public void putAll(Map arg3) {
        this.ensureCapacity(this.size() + arg3.size());
        Iterator v3 = arg3.entrySet().iterator();
        while(v3.hasNext()) {
            Object v0 = v3.next();
            this.put(((Map$Entry)v0).getKey(), ((Map$Entry)v0).getValue());
        }
    }

    public Object remove(Object arg1) {
        return super.remove(arg1);
    }

    public boolean removeAll(Collection arg3) {
        int v0 = this.size();
        Iterator v3 = arg3.iterator();
        while(v3.hasNext()) {
            this.remove(v3.next());
        }

        if(v0 != this.size()) {
            return 1;
        }

        return 0;
    }

    public boolean retainAll(Collection arg5) {
        int v0 = this.size();
        int v1;
        for(v1 = this.size() - 1; v1 >= 0; --v1) {
            if(!arg5.contains(this.keyAt(v1))) {
                this.removeAt(v1);
            }
        }

        if(v0 != this.size()) {
            return 1;
        }

        return 0;
    }

    public Collection values() {
        ValueCollection v0 = this.mValues;
        if(v0 == null) {
            v0 = new ValueCollection(this);
            this.mValues = v0;
        }

        return ((Collection)v0);
    }
}

