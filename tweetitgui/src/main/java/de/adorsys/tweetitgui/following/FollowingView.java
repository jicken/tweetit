
package de.adorsys.tweetitgui.following;

import com.google.gwt.user.client.ui.IsWidget;
import com.mvp4g.client.presenter.PresenterInterface;
import com.mvp4g.client.view.ReverseViewInterface;

import de.adorsys.tweetitgui.TweetitguiEventBus;
import de.adorsys.tweetitgui.model.FollowingUser;

import java.util.List;

public interface FollowingView extends IsWidget, ReverseViewInterface<FollowingView.FollowingPresenter> {

    void setValue(List<FollowingUser> followingUsers);

    public interface FollowingPresenter extends PresenterInterface<FollowingView, TweetitguiEventBus> {
		
	}

}
