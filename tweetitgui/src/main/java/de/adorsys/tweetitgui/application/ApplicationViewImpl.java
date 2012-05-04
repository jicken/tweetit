
package de.adorsys.tweetitgui.application;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import de.adorsys.tweetitgui.Messages;
import de.adorsys.tweetitgui.ReverseCompositeView;
import de.adorsys.tweetitgui.application.ApplicationView.ApplicationPresenter;
import de.adorsys.tweetitgui.following.FollowingViewImpl;

public class ApplicationViewImpl extends ReverseCompositeView<ApplicationPresenter> implements ApplicationView {

    private static RootViewUiBinder uiBinder = GWT.create( RootViewUiBinder.class );

    interface RootViewUiBinder extends UiBinder<Widget, ApplicationViewImpl> {
    }

    @UiField
    DivElement output;

    @UiField
    DivElement hallo;

    @UiField(provided = true)
    FollowingViewImpl following;

    @UiField
    SimplePanel body;

    @Inject
    public ApplicationViewImpl(Messages msg, FollowingViewImpl following) {
        // instantiation using Gin --> provided --> @Singleton
        this.following = following;
        initWidget( uiBinder.createAndBindUi( this ) );
        output.setInnerText(msg.testMessage());
        hallo.setInnerText(msg.hallo("Torben"));
    }

    @Override
    public SimplePanel getBody() {
        return body;
    }
}
