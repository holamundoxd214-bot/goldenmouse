package androidx.transition;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TransitionValues {
    final ArrayList mTargetedTransitions;
    public final Map values;
    public View view;

    public TransitionValues(View arg2) {
        super();
        this.values = new HashMap();
        this.mTargetedTransitions = new ArrayList();
        this.view = arg2;
    }

    @Deprecated public TransitionValues() {
        super();
        this.values = new HashMap();
        this.mTargetedTransitions = new ArrayList();
    }

    public boolean equals(Object arg3) {
        if(((arg3 instanceof TransitionValues)) && this.view == ((TransitionValues)arg3).view && (this.values.equals(((TransitionValues)arg3).values))) {
            return 1;
        }

        return 0;
    }

    public int hashCode() {
        return this.view.hashCode() * 0x1F + this.values.hashCode();
    }

    public String toString() {
        String v1 = "\n";
        String v0 = "TransitionValues@" + Integer.toHexString(this.hashCode()) + ":\n" + "    view = " + this.view + v1 + "    values:";
        Iterator v2 = this.values.keySet().iterator();
        while(v2.hasNext()) {
            Object v3 = v2.next();
            v0 = v0 + "    " + (((String)v3)) + ": " + this.values.get(v3) + v1;
        }

        return v0;
    }
}

