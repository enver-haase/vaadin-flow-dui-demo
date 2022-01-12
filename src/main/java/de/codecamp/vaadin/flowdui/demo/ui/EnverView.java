package de.codecamp.vaadin.flowdui.demo.ui;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;


@Route("")
public class EnverView extends VerticalLayout {
    public EnverView(){
        add(new RouterLink("Demo", DemoView.class));
        add(new RouterLink("ComponentTest", ComponentTestView.class));
        add(new RouterLink("PARiSS test", DesignerDesignedView.class));
    }
}
