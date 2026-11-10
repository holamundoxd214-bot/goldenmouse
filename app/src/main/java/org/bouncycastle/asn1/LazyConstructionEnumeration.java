package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;
import java.util.NoSuchElementException;

class LazyConstructionEnumeration implements Enumeration {
    private ASN1InputStream aIn;
    private Object nextObj;

    public LazyConstructionEnumeration(byte[] arg3) {
        super();
        this.aIn = new ASN1InputStream(arg3, true);
        this.nextObj = this.readObject();
    }

    public boolean hasMoreElements() {
        if(this.nextObj != null) {
            return 1;
        }

        return 0;
    }

    public Object nextElement() {
        Object v0 = this.nextObj;
        if(v0 != null) {
            this.nextObj = this.readObject();
            return v0;
        }

        throw new NoSuchElementException();
    }

    private Object readObject() {
        try {
            return this.aIn.readObject();
        }
        catch(IOException v3) {
            throw new ASN1ParsingException("malformed ASN.1: " + v3, ((Throwable)v3));
        }
    }
}

