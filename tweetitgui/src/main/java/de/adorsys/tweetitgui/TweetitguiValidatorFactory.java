
package de.adorsys.tweetitgui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.validation.client.AbstractGwtValidatorFactory;
import com.google.gwt.validation.client.GwtValidation;
import com.google.gwt.validation.client.impl.AbstractGwtValidator;
import de.adorsys.tweetitgui.model.TweetDTO;
import de.adorsys.tweetitgui.model.TweetitguiModel;

import javax.validation.Validator;
import javax.validation.groups.Default;

public final class TweetitguiValidatorFactory extends AbstractGwtValidatorFactory {

	@GwtValidation(value = { TweetitguiModel.class, TweetDTO.class }, groups = { Default.class })
	public interface GwtValidator extends Validator {
	}

	@Override
	public AbstractGwtValidator createValidator() {
		return GWT.create(GwtValidator.class);
	}
}
