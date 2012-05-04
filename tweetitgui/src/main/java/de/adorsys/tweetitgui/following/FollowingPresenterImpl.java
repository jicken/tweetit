
package de.adorsys.tweetitgui.following;

import com.google.inject.Inject;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;
import de.adorsys.tweetitgui.TweetitguiEventBus;
import de.adorsys.tweetitgui.following.FollowingView.FollowingPresenter;
import de.adorsys.tweetitgui.model.FollowingUser;
import de.adorsys.tweetitgui.model.MyUser;
import de.adorsys.tweetitgui.service.UserService;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import java.util.ArrayList;
import java.util.List;

@Presenter( view = FollowingViewImpl.class )
public class FollowingPresenterImpl extends BasePresenter<FollowingView, TweetitguiEventBus> implements FollowingPresenter {

    @Inject
    private UserService userService;

	public void onStart() {
//        List<FollowingUser> users = Arrays.asList(new FollowingUser("0", "Torben", false), new FollowingUser("1", "Sandro", false));
//        getView().setValue(users);

        userService.listAll(new MethodCallback<List<MyUser>>() {
            @Override
            public void onFailure(Method method, Throwable exception) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void onSuccess(Method method, List<MyUser> response) {
                List<FollowingUser> myUsers = new ArrayList<FollowingUser>(response.size());
                for (MyUser myUser : response) {
                    myUsers.add(new FollowingUser(myUser.getUserId(), myUser.getNickname(), false));
                }
                getView().setValue(myUsers);
            }
        });
    }


}
