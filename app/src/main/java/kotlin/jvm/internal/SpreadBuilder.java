package kotlin.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class SpreadBuilder {
    private final ArrayList list;

    public SpreadBuilder(int arg2) {
        super();
        this.list = new ArrayList(arg2);
    }

    public void add(Object arg1) {
        this.list.add(arg1);
    }

    public void addSpread(Object arg4) {
        if(arg4 == null) {
        }
        else if((arg4 instanceof Object[])) {
            if(arg4.length > 0) {
                this.list.ensureCapacity(this.list.size() + arg4.length);
                Collections.addAll(this.list, ((Object[])arg4));
                return;
            }
        }
        else if((arg4 instanceof Collection)) {
            this.list.addAll(((Collection)arg4));
            return;
        }
        else if((arg4 instanceof Iterable)) {
            Iterator v4 = ((Iterable)arg4).iterator();
            while(v4.hasNext()) {
                this.list.add(v4.next());
            }
        }
        else {
            if(!(arg4 instanceof Iterator)) {
                goto label_37;
            }

            while(((Iterator)arg4).hasNext()) {
                this.list.add(((Iterator)arg4).next());
            }
        }

        return;
    label_37:
        throw new UnsupportedOperationException("Don\'t know how to spread " + arg4.getClass());
    }

    public int size() {
        return this.list.size();
    }

    public Object[] toArray(Object[] arg1) {
        return this.list.toArray(arg1);
    }
}

