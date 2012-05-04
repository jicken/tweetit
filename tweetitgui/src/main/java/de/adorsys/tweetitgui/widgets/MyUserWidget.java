package de.adorsys.tweetitgui.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.editor.ui.client.ValueBoxEditorDecorator;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import de.adorsys.tweetitgui.model.MyUser;

import javax.validation.ConstraintViolation;
import java.util.ArrayList;
import java.util.Set;

public class MyUserWidget extends Composite implements Editor<MyUser> {

    private static final MyUserUiBinder UI_BINDER = GWT.create(MyUserUiBinder.class);

    private final MyUserEditorDriver editorDriver = GWT.create(MyUserEditorDriver.class);

    interface MyUserUiBinder extends UiBinder<Widget, MyUserWidget> {
    }

    public interface MyUserEditorDriver extends SimpleBeanEditorDriver<MyUser, MyUserWidget> {
    }

    @UiField
    ValueBoxEditorDecorator<String> userId;
    @UiField
    ValueBoxEditorDecorator<String> nickname;

    public MyUserWidget() {
        this(new MyUser());
    }

    public MyUserWidget(MyUser dataObject) {
        initWidget(UI_BINDER.createAndBindUi(this));
        editorDriver.initialize(this);
        editorDriver.edit(dataObject);

    }

    public MyUserEditorDriver getEditorDriver() {
        return editorDriver;
    }

    public void showErrors(
          Set<ConstraintViolation<MyUser>> validate) {
        editorDriver.setConstraintViolations(new ArrayList<ConstraintViolation<?>>(validate));
    }

}
