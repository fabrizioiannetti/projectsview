package com.github.fabrizioiannetti.projectsview.views;


import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.navigator.CommonNavigator;


public class ProjectsView extends CommonNavigator {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "com.github.fabrizioiannetti.projectsview.views.ProjectsView";

	private ProjectDetails projectDetails;

	/**
	 * The UI consists of a Project detail pane on the top
	 * and the usual navigator below.
	 */
	public void createPartControl(Composite parent) {
		GridLayoutFactory.fillDefaults().applyTo(parent);
		projectDetails = new ProjectDetails(parent, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(projectDetails);

		Composite treeComposite = new Composite(parent, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(treeComposite);
		treeComposite.setLayout(new FillLayout());
		super.createPartControl(treeComposite);
		getCommonViewer().addSelectionChangedListener(event -> projectDetails.update(event));
	}
}