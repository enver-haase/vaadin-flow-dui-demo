package de.codecamp.vaadin.flowdui.demo.ui;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep.LabelsPosition;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

import de.codecamp.vaadin.flowdui.Mapped;
import de.codecamp.vaadin.flowdui.Slotted;
import de.codecamp.vaadin.flowdui.TemplateComposite;


@Route("component-test")
public class ComponentTestView
  extends TemplateComposite
{

  @Mapped("dialogOpenButton")
  private Button dialogOpenButton;

  @Mapped("dialog")
  private Dialog dialog;

  @Slotted("formLayoutSlot")
  private final FormLayout slotted = new FormLayout();


  public ComponentTestView()
  {
  }


  @Override
  protected Component initContent()
  {
    Component content = super.initContent();

    dialogOpenButton.addClickListener(event -> dialog.open());


    TextField titleField = new TextField();
    titleField.setPlaceholder("Sir");
    Label titleFieldLabel = new Label("Title");
    titleFieldLabel.addComponentAsFirst(VaadinIcon.ANGLE_UP.create());
    slotted.addFormItem(titleField, titleFieldLabel);

    TextField firstNameField = new TextField();
    firstNameField.setPlaceholder("John");
    slotted.addFormItem(firstNameField, "First name");

    TextField lastNameField = new TextField();
    lastNameField.setPlaceholder("Doe");
    slotted.addFormItem(lastNameField, "Last name");

    LabelsPosition lp = LabelsPosition.TOP;
    slotted.setResponsiveSteps( //
        new ResponsiveStep("25em", 1, lp), //
        new ResponsiveStep("32em", 2, lp), //
        new ResponsiveStep("40em", 3, lp));

    return content;
  }

}
