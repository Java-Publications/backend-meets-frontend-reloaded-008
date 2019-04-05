package org.rapidpm.vaadin.v10.issuetracker;

import com.github.appreciated.app.layout.behaviour.AppLayout;
import com.github.appreciated.app.layout.behaviour.Behaviour;
import com.github.appreciated.app.layout.builder.AppLayoutBuilder;
import com.github.appreciated.app.layout.component.menu.left.builder.LeftAppMenuBuilder;
import com.github.appreciated.app.layout.component.menu.left.items.LeftClickableItem;
import com.github.appreciated.app.layout.router.AppLayoutRouterLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.server.StreamResource;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import org.rapidpm.vaadin.v10.issuetracker.services.SecurityService;
import org.rapidpm.vaadin.v10.issuetracker.views.main.MainView;
import org.rapidpm.vaadin.v10.issuetracker.views.pages.DashboardView;
import org.rapidpm.vaadin.v10.issuetracker.views.pages.ProfileView;
import org.rapidpm.vaadin.v10.issuetracker.views.pages.TrendsView;

import static com.vaadin.flow.component.icon.VaadinIcon.*;

@Theme(Lumo.class)
public class MainLayout extends AppLayoutRouterLayout {

  public static final  String ITM_DASHBOARD = "mainview.menue.item.dashboard";
  public static final  String ITM_PROFILE   = "mainview.menue.item.profile";
  public static final  String ITM_TRENDS    = "mainview.menue.item.trends";
  public static final  String ITM_LOGOUT    = "mainview.menue.item.logout";
  public static final  String TITLE         = "mainview.app.title";
  private static final String LOGO_PNG      = "logo.png";

  public MainLayout() {
    Image img = new Image(new StreamResource(LOGO_PNG, () -> MainLayout.class.getResourceAsStream("/" + LOGO_PNG)),
                          "Vaadin Logo"
    );

    //app layout specific
    img.setHeight("var(--app-layout-menu-button-height)");

    AppLayout appLayout = AppLayoutBuilder
        .get(Behaviour.LEFT_RESPONSIVE_HYBRID)
        .withTitle(getTranslation(TITLE))
        .withIconComponent(img)
        .withAppMenu(appMenu())
        .build();

    init(appLayout);
  }


  private Component appMenu() {
    return LeftAppMenuBuilder
        .get()
        .add(getTranslation(ITM_DASHBOARD), DASHBOARD.create(), DashboardView.class)
        .add(getTranslation(ITM_PROFILE), USER.create(), ProfileView.class)
        .add(getTranslation(ITM_TRENDS), TRENDING_UP.create(), TrendsView.class)
        .add(new LeftClickableItem(getTranslation(ITM_LOGOUT), SIGN_OUT.create(), e -> {
          UI            ui      = UI.getCurrent();
          VaadinSession session = ui.getSession();
          session.setAttribute(SecurityService.User.class, null);
          session.close();
          ui.navigate(MainView.class);
        }))
        .build();
  }
}
