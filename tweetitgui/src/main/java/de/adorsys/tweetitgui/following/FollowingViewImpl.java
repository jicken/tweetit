
package de.adorsys.tweetitgui.following;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Singleton;
import de.adorsys.tweetitgui.ReverseCompositeView;
import de.adorsys.tweetitgui.following.FollowingView.FollowingPresenter;
import de.adorsys.tweetitgui.model.FollowingUser;
import de.adorsys.tweetitgui.widgets.FollowingUserTableWidget;

import java.util.List;

@Singleton
public class FollowingViewImpl extends ReverseCompositeView<FollowingPresenter> implements FollowingView {

    private static RootViewUiBinder uiBinder = GWT.create( RootViewUiBinder.class );

    interface RootViewUiBinder extends UiBinder<Widget, FollowingViewImpl> {
    }

    @UiField
    FollowingUserTableWidget followingUserTableWidget;

    public FollowingViewImpl() {
        initWidget( uiBinder.createAndBindUi( this ) );
    }

    @Override
    public void setValue(List<FollowingUser> followingUsers) {
        followingUserTableWidget.setValue(followingUsers);
    }
}
