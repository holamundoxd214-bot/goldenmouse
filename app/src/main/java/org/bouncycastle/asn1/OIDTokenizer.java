package org.bouncycastle.asn1;

public class OIDTokenizer {
    private int index;
    private String oid;

    public OIDTokenizer(String arg1) {
        super();
        this.oid = arg1;
        this.index = 0;
    }

    public boolean hasMoreTokens() {
        if(this.index != -1) {
            return 1;
        }

        return 0;
    }

    public String nextToken() {
        int v0 = this.index;
        int v1 = -1;
        if(v0 == v1) {
            return null;
        }

        v0 = this.oid.indexOf(46, v0);
        String v2 = this.oid;
        if(v0 == v1) {
            String v0_1 = v2.substring(this.index);
            this.index = v1;
            return v0_1;
        }

        String v1_1 = v2.substring(this.index, v0);
        this.index = v0 + 1;
        return v1_1;
    }
}

