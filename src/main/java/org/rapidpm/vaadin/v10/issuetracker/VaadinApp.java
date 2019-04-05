/**
 * Copyright © 2017 Sven Ruppert (sven.ruppert@gmail.com)
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.rapidpm.vaadin.v10.issuetracker;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import org.rapidpm.dependencies.core.logger.HasLogger;
import org.rapidpm.vaadin.v10.issuetracker.views.main.MainView;

@Route(value = VaadinApp.NAVIGATION_ROOT, layout = MainLayout.class)
public class VaadinApp extends Composite<Div> implements HasLogger {

  public static final String NAVIGATION_ROOT = "";

  @Override protected void onAttach(AttachEvent attachEvent) {
    super.onAttach(attachEvent);
    logger().info("navigated to ROOT .. now redirecting..");
    UI
        .getCurrent()
        .navigate(MainView.class);
  }
}
