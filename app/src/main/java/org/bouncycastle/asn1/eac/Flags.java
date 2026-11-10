package org.bouncycastle.asn1.eac;

import java.util.Enumeration;
import java.util.Hashtable;

public class Flags {
    class StringJoiner {
        boolean First;
        StringBuilder b;
        String mSeparator;

        public StringJoiner(String arg2) {
            super();
            this.First = true;
            this.b = new StringBuilder();
            this.mSeparator = arg2;
        }

        public void add(String arg3) {
            if(this.First) {
                this.First = false;
            }
            else {
                this.b.append(this.mSeparator);
            }

            this.b.append(arg3);
        }

        public String toString() {
            return this.b.toString();
        }
    }

    int value;

    public Flags(int arg1) {
        super();
        this.value = arg1;
    }

    public Flags() {
        super();
        this.value = 0;
    }

    String decode(Hashtable arg5) {
        StringJoiner v0 = new StringJoiner(" ");
        Enumeration v1 = arg5.keys();
        while(v1.hasMoreElements()) {
            Object v2 = v1.nextElement();
            if(!this.isSet(((Integer)v2).intValue())) {
                continue;
            }

            v0.add(arg5.get(v2));
        }

        return v0.toString();
    }

    public int getFlags() {
        return this.value;
    }

    public boolean isSet(int arg1) {
        if((this.value & arg1) != 0) {
            return 1;
        }

        return 0;
    }

    public void set(int arg2) {
        this.value |= arg2;
    }
}

