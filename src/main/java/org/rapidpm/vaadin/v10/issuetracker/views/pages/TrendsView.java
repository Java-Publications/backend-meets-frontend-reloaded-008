package org.rapidpm.vaadin.v10.issuetracker.views.pages;


import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.router.Route;
import org.rapidpm.vaadin.v10.issuetracker.MainLayout;

import static org.rapidpm.vaadin.v10.issuetracker.views.pages.TrendsView.NAV;


@Route(value = NAV, layout = MainLayout.class)
public class TrendsView extends Composite<Div> {
  public static final String NAV = "trends";


  public TrendsView() {
    getContent().add(new Span("Trends"));
  }
}
