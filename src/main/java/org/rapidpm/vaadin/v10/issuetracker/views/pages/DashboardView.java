package org.rapidpm.vaadin.v10.issuetracker.views.pages;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.router.Route;
import org.rapidpm.vaadin.v10.issuetracker.MainLayout;

import static org.rapidpm.vaadin.v10.issuetracker.views.pages.DashboardView.NAV;

@Route(value = NAV, layout = MainLayout.class)
public class DashboardView extends Composite<Div> {
  public static final String NAV = "dashbord";

  public DashboardView() {
    getContent().add(new Span("Dashboard"));
  }
}
