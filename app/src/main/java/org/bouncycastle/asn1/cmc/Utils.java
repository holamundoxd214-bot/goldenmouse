package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.x509.Extension;

class Utils {
    Utils() {
        super();
    }

    static BodyPartID[] clone(BodyPartID[] arg3) {
        BodyPartID[] v0 = new BodyPartID[arg3.length];
        System.arraycopy(arg3, 0, v0, 0, arg3.length);
        return v0;
    }

    static Extension[] clone(Extension[] arg3) {
        Extension[] v0 = new Extension[arg3.length];
        System.arraycopy(arg3, 0, v0, 0, arg3.length);
        return v0;
    }

    static BodyPartID[] toBodyPartIDArray(ASN1Sequence arg3) {
        BodyPartID[] v0 = new BodyPartID[arg3.size()];
        int v1;
        for(v1 = 0; v1 != arg3.size(); ++v1) {
            v0[v1] = BodyPartID.getInstance(arg3.getObjectAt(v1));
        }

        return v0;
    }
}

