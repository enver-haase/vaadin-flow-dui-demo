package de.codecamp.vaadin.flowdui.demo.ui;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.router.Route;
import de.codecamp.vaadin.flowdui.Mapped;
import de.codecamp.vaadin.flowdui.TemplateComposite;
import de.codecamp.vaadin.flowdui.TemplateId;

@Route("pariss")
@TemplateId("de.codecamp.vaadin.flowdui.demo.ui.designer-designed-view")
public class DesignerDesignedView extends TemplateComposite {

    @Mapped("com.daimlertruck.buttonid")
    private Button daimlerButton;


    public DesignerDesignedView(){
        initContent();

        System.err.println("XXXX Text is "+daimlerButton.getText());
    }

    @Override
    protected Component initContent() {
        Component c = super.initContent();

        if (daimlerButton.getText().contains("com.daimlertruck.fooview.foobutton")){ // WARNING: do not use 'equals'
            System.err.println("Setting new text...");
            daimlerButton.setText("Translated Foo");
        }

        return c;
    }
}
