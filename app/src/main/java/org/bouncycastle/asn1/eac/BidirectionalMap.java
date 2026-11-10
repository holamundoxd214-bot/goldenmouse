package org.bouncycastle.asn1.eac;

import java.util.Hashtable;

public class BidirectionalMap extends Hashtable {
    Hashtable reverseMap;
    private static final long serialVersionUID = -7457289971962812909L;

    public BidirectionalMap() {
        super();
        this.reverseMap = new Hashtable();
    }

    public Object getReverse(Object arg1) {
        return this.reverseMap.get(arg1);
    }

    public Object put(Object arg2, Object arg3) {
        this.reverseMap.put(arg3, arg2);
        return super.put(arg2, arg3);
    }
}

