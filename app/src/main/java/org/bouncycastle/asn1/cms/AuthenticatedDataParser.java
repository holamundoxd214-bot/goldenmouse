package org.bouncycastle.asn1.cms;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1SequenceParser;
import org.bouncycastle.asn1.ASN1SetParser;
import org.bouncycastle.asn1.ASN1TaggedObjectParser;
import org.bouncycastle.asn1.ASN1Util;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class AuthenticatedDataParser {
    private ASN1Encodable nextObject;
    private boolean originatorInfoCalled;
    private ASN1SequenceParser seq;
    private ASN1Integer version;

    public AuthenticatedDataParser(ASN1SequenceParser arg1) throws IOException {
        super();
        this.seq = arg1;
        this.version = ASN1Integer.getInstance(arg1.readObject());
    }

    public ASN1SetParser getAuthAttrs() throws IOException {
        ASN1Encodable v0 = this.nextObject;
        if(v0 == null) {
            v0 = this.seq.readObject();
            this.nextObject = v0;
        }

        ASN1Encodable v2 = null;
        if((v0 instanceof ASN1TaggedObjectParser)) {
            this.nextObject = v2;
            return ASN1Util.parseContextBaseUniversal(((ASN1TaggedObjectParser)v0), 2, false, 17);
        }

        return ((ASN1SetParser)v2);
    }

    public AlgorithmIdentifier getDigestAlgorithm() throws IOException {
        ASN1Encodable v0 = this.nextObject;
        if(v0 == null) {
            v0 = this.seq.readObject();
            this.nextObject = v0;
        }

        ASN1Encodable v2 = null;
        if((v0 instanceof ASN1TaggedObjectParser)) {
            AlgorithmIdentifier v0_1 = AlgorithmIdentifier.getInstance(v0.toASN1Primitive(), false);
            this.nextObject = v2;
            return v0_1;
        }

        return ((AlgorithmIdentifier)v2);
    }

    public ContentInfoParser getEncapsulatedContentInfo() throws IOException {
        ASN1Encodable v0 = this.nextObject;
        if(v0 == null) {
            v0 = this.seq.readObject();
            this.nextObject = v0;
        }

        ASN1Encodable v1 = null;
        if(v0 != null) {
            this.nextObject = v1;
            return new ContentInfoParser(((ASN1SequenceParser)v0));
        }

        return ((ContentInfoParser)v1);
    }

    public ASN1OctetString getMac() throws IOException {
        ASN1Encodable v0 = this.nextObject;
        if(v0 == null) {
            v0 = this.seq.readObject();
            this.nextObject = v0;
        }

        this.nextObject = null;
        return ASN1OctetString.getInstance(v0.toASN1Primitive());
    }

    public AlgorithmIdentifier getMacAlgorithm() throws IOException {
        ASN1Encodable v0 = this.nextObject;
        if(v0 == null) {
            v0 = this.seq.readObject();
            this.nextObject = v0;
        }

        ASN1Encodable v1 = null;
        if(v0 != null) {
            this.nextObject = v1;
            return AlgorithmIdentifier.getInstance(((ASN1SequenceParser)v0).toASN1Primitive());
        }

        return ((AlgorithmIdentifier)v1);
    }

    public OriginatorInfo getOriginatorInfo() throws IOException {
        this.originatorInfoCalled = true;
        ASN1Encodable v0 = this.nextObject;
        if(v0 == null) {
            v0 = this.seq.readObject();
            this.nextObject = v0;
        }

        ASN1Encodable v2 = null;
        if(((v0 instanceof ASN1TaggedObjectParser)) && (((ASN1TaggedObjectParser)v0).hasContextTag(0))) {
            v0 = ((ASN1TaggedObjectParser)v0).parseBaseUniversal(false, 16);
            this.nextObject = v2;
            return OriginatorInfo.getInstance(((ASN1SequenceParser)v0).getLoadedObject());
        }

        return ((OriginatorInfo)v2);
    }

    public ASN1SetParser getRecipientInfos() throws IOException {
        if(!this.originatorInfoCalled) {
            this.getOriginatorInfo();
        }

        ASN1Encodable v0 = this.nextObject;
        if(v0 == null) {
            v0 = this.seq.readObject();
            this.nextObject = v0;
        }

        this.nextObject = null;
        return ((ASN1SetParser)v0);
    }

    public ASN1SetParser getUnauthAttrs() throws IOException {
        ASN1Encodable v0 = this.nextObject;
        if(v0 == null) {
            v0 = this.seq.readObject();
            this.nextObject = v0;
        }

        ASN1Encodable v1 = null;
        if(v0 != null) {
            this.nextObject = v1;
            return ASN1Util.parseContextBaseUniversal(((ASN1TaggedObjectParser)v0), 3, false, 17);
        }

        return ((ASN1SetParser)v1);
    }

    public ASN1Integer getVersion() {
        return this.version;
    }
}

