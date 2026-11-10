package org.bouncycastle.asn1.cms;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1ParsingException;
import org.bouncycastle.asn1.ASN1SequenceParser;
import org.bouncycastle.asn1.ASN1SetParser;
import org.bouncycastle.asn1.ASN1TaggedObjectParser;
import org.bouncycastle.asn1.ASN1Util;

public class AuthEnvelopedDataParser {
    private boolean isData;
    private ASN1Encodable nextObject;
    private boolean originatorInfoCalled;
    private ASN1SequenceParser seq;
    private ASN1Integer version;

    public AuthEnvelopedDataParser(ASN1SequenceParser arg1) throws IOException {
        super();
        this.seq = arg1;
        ASN1Integer v1 = ASN1Integer.getInstance(arg1.readObject());
        this.version = v1;
        if(v1.hasValue(0)) {
            return;
        }

        throw new ASN1ParsingException("AuthEnvelopedData version number must be 0");
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
            return ASN1Util.parseContextBaseUniversal(((ASN1TaggedObjectParser)v0), 1, false, 17);
        }

        if(this.isData) {
            return ((ASN1SetParser)v2);
        }

        throw new ASN1ParsingException("authAttrs must be present with non-data content");
    }

    public EncryptedContentInfoParser getAuthEncryptedContentInfo() throws IOException {
        EncryptedContentInfoParser v1_1;
        ASN1Encodable v0 = this.nextObject;
        if(v0 == null) {
            v0 = this.seq.readObject();
            this.nextObject = v0;
        }

        ASN1Encodable v1 = null;
        if(v0 != null) {
            this.nextObject = v1;
            v1_1 = new EncryptedContentInfoParser(((ASN1SequenceParser)v0));
            this.isData = CMSObjectIdentifiers.data.equals(v1_1.getContentType());
        }

        return v1_1;
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
            return ASN1Util.parseContextBaseUniversal(((ASN1TaggedObjectParser)v0), 2, false, 17);
        }

        return ((ASN1SetParser)v1);
    }

    public ASN1Integer getVersion() {
        return this.version;
    }
}

