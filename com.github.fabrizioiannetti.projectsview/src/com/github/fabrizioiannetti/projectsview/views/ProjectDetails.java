package com.github.fabrizioiannetti.projectsview.views;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class ProjectDetails extends Composite {

	private Label projectIcon;
	private Label projectName;

	public ProjectDetails(Composite parent, int style) {
		super(parent, style);
		GridLayoutFactory.fillDefaults().numColumns(2).applyTo(parent);
		projectIcon = new Label(parent, SWT.NONE);
		projectName = new Label(parent, SWT.NONE);
		GridDataFactory.fillDefaults().applyTo(projectIcon);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(projectName);
	}

}
