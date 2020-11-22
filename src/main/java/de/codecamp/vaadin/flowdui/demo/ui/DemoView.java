package de.codecamp.vaadin.flowdui.demo.ui;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.Route;

import de.codecamp.vaadin.flowdui.FragmentComposite;
import de.codecamp.vaadin.flowdui.FragmentId;
import de.codecamp.vaadin.flowdui.Mapped;
import de.codecamp.vaadin.flowdui.Slotted;
import de.codecamp.vaadin.flowdui.TemplateComposite;


@Route("demo")
public class DemoView
  extends TemplateComposite
{

  /**
   * Created in the template and mapped to this field.
   */
  @Mapped("shuffleButton")
  private Button shuffleButton;

  /**
   * Created here and mapped into the template.
   */
  @Slotted("localeGrid")
  private Grid<Locale> localeGrid = new Grid<>(Locale.class);


  public DemoView()
  {
  }


  @Override
  protected Component initContent()
  {
    Component content = super.initContent();

    localeGrid.removeAllColumns();
    localeGrid.addColumn(Locale::toLanguageTag).setHeader("Language Tag");
    localeGrid.addColumn("displayLanguage");
    localeGrid.addColumn("displayCountry");
    localeGrid.addColumn("displayVariant");
    localeGrid.setDetailsVisibleOnClick(true);
    localeGrid.setItemDetailsRenderer(new ComponentRenderer<>(locale -> {
      LocaleDetails details = new LocaleDetails();
      details.setLocale(locale);
      return details;
    }));


    shuffleButton.addClickListener(e -> shuffleLocales());

    localeGrid.setItems(Locale.getAvailableLocales());

    return content;
  }

  private void shuffleLocales()
  {
    List<Locale> locales = Arrays.asList(Locale.getAvailableLocales());
    Collections.shuffle(locales);
    localeGrid.setItems(locales);
  }


  @FragmentId("DetailsFragment")
  public static class LocaleDetails
    extends FragmentComposite
  {

    @Mapped("info")
    private TextField info;


    public void setLocale(Locale locale)
    {
      info.setValue(locale.getDisplayLanguage(locale) + " / " + locale.getDisplayCountry(locale)
          + " / " + locale.getDisplayVariant(locale));
    }

  }

}
