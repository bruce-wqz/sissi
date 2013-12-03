package com.sissi.pipeline.in.iq.register;

import com.sissi.context.JIDContext;
import com.sissi.pipeline.Input;
import com.sissi.pipeline.in.iq.IQTypeProcessor;
import com.sissi.protocol.Protocol;
import com.sissi.protocol.iq.login.Register;
import com.sissi.ucenter.RegisterManager;

/**
 * @author kim 2013年12月3日
 */
public class RegisterStoreProcessor implements Input {

	private RegisterManager registerManager;

	private IQTypeProcessor iqTypeProcessor;

	public RegisterStoreProcessor(RegisterManager registerManager, IQTypeProcessor iqTypeProcessor) {
		super();
		this.registerManager = registerManager;
		this.iqTypeProcessor = iqTypeProcessor;
	}

	@Override
	public Boolean input(JIDContext context, Protocol protocol) {
		return this.registerManager.register(Register.class.cast(protocol).getFields()) ? this.iqTypeProcessor.input(context, protocol.clear()) : true;
	}
}