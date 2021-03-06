package com.sissi.pipeline.in.iq.vcard;

import com.sissi.context.JIDContext;
import com.sissi.protocol.Protocol;
import com.sissi.protocol.iq.vcard.VCard;
import com.sissi.ucenter.vcard.VCardContext;

/**
 * 当前JID VCard
 * @author kim 2013年12月10日
 */
public class VCardGet4SelfProcessor extends VCardGetProcessor {

	public VCardGet4SelfProcessor(VCardContext vcardContext) {
		super(vcardContext);
	}

	@Override
	protected VCard get(JIDContext context, Protocol protocol) {
		return super.vcardContext.pull(context.jid(), protocol.cast(VCard.class));
	}
}
