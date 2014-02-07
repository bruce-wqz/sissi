package com.sissi.pipeline.in.presence;

import com.sissi.context.JIDContext;
import com.sissi.pipeline.in.ProxyProcessor;
import com.sissi.protocol.Protocol;
import com.sissi.ucenter.VCardContext;

/**
 * @author kim 2014年1月14日
 */
public class PresenceCheckExistsProcessor extends ProxyProcessor {

	private final VCardContext vcardContext;

	public PresenceCheckExistsProcessor(VCardContext vcardContext) {
		super();
		this.vcardContext = vcardContext;
	}

	@Override
	public boolean input(JIDContext context, Protocol protocol) {
		return !protocol.to() || this.vcardContext.exists(protocol.getTo()) ? true : false;
	}
}