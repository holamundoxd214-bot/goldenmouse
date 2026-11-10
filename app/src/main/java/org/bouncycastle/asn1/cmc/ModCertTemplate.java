package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1Boolean;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.crmf.CertTemplate;

public class ModCertTemplate extends ASN1Object {
    private final BodyPartList certReferences;
    private final CertTemplate certTemplate;
    private final BodyPartPath pkiDataReference;
    private final boolean replace;

    private ModCertTemplate(ASN1Sequence arg6) {
        ASN1Encodable v6;
        super();
        int v1 = 3;
        int v2 = 4;
        if(arg6.size() != v2) {
            if(arg6.size() == v1) {
            }
            else {
                throw new IllegalArgumentException("incorrect sequence size");
            }
        }

        this.pkiDataReference = BodyPartPath.getInstance(arg6.getObjectAt(0));
        this.certReferences = BodyPartList.getInstance(arg6.getObjectAt(1));
        int v4 = 2;
        if(arg6.size() == v2) {
            this.replace = ASN1Boolean.getInstance(arg6.getObjectAt(v4)).isTrue();
            v6 = arg6.getObjectAt(v1);
        }
        else {
            this.replace = true;
            v6 = arg6.getObjectAt(v4);
        }

        this.certTemplate = CertTemplate.getInstance(v6);
    }

    public ModCertTemplate(BodyPartPath arg1, BodyPartList arg2, boolean arg3, CertTemplate arg4) {
        super();
        this.pkiDataReference = arg1;
        this.certReferences = arg2;
        this.replace = arg3;
        this.certTemplate = arg4;
    }

    public BodyPartList getCertReferences() {
        return this.certReferences;
    }

    public CertTemplate getCertTemplate() {
        return this.certTemplate;
    }

    public static ModCertTemplate getInstance(Object arg1) {
        if((arg1 instanceof ModCertTemplate)) {
            return arg1;
        }

        if(arg1 != null) {
            return new ModCertTemplate(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public BodyPartPath getPkiDataReference() {
        return this.pkiDataReference;
    }

    public boolean isReplacingFields() {
        return this.replace;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(4);
        v0.add(this.pkiDataReference);
        v0.add(this.certReferences);
        boolean v1 = this.replace;
        if(!v1) {
            v0.add(ASN1Boolean.getInstance(v1));
        }

        v0.add(this.certTemplate);
        return new DERSequence(v0);
    }
}

