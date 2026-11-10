package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.Extension;

public class ExtensionReq extends ASN1Object {
    private final Extension[] extensions;

    private ExtensionReq(ASN1Sequence arg4) {
        super();
        this.extensions = new Extension[arg4.size()];
        int v0;
        for(v0 = 0; v0 != arg4.size(); ++v0) {
            this.extensions[v0] = Extension.getInstance(arg4.getObjectAt(v0));
        }
    }

    public ExtensionReq(Extension arg3) {
        super();
        this.extensions = new Extension[]{arg3};
    }

    public ExtensionReq(Extension[] arg1) {
        super();
        this.extensions = Utils.clone(arg1);
    }

    public Extension[] getExtensions() {
        return Utils.clone(this.extensions);
    }

    public static ExtensionReq getInstance(Object arg1) {
        if((arg1 instanceof ExtensionReq)) {
            return arg1;
        }

        if(arg1 != null) {
            return new ExtensionReq(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public static ExtensionReq getInstance(ASN1TaggedObject arg0, boolean arg1) {
        return ExtensionReq.getInstance(ASN1Sequence.getInstance(arg0, arg1));
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.extensions);
    }
}

