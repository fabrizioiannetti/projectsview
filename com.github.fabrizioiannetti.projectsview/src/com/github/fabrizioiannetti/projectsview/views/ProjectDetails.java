package com.github.fabrizioiannetti.projectsview.views;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.PlatformUI;

public class ProjectDetails extends Composite {

	private Label projectIcon;
	private Label projectName;

	public ProjectDetails(Composite parent, int style) {
		super(parent, style);
		GridLayoutFactory.fillDefaults().numColumns(2).applyTo(this);
		setBackground(new Color(getDisplay(), 200, 200, 200));
		projectIcon = new Label(this, SWT.NONE);
		projectIcon.setImage(PlatformUI.getWorkbench().
				getSharedImages().getImage(org.eclipse.ui.ide.IDE.SharedImages.IMG_OBJ_PROJECT));
		projectName = new Label(this, SWT.NONE);
		projectName.setText("Project Details here");
		GridDataFactory.fillDefaults().minSize(24, 24).applyTo(projectIcon);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(projectName);
	}
	
	public void update(SelectionChangedEvent event) {
		ISelection selection = event.getSelection();
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection s = (IStructuredSelection) selection;
			if (s.size() == 1) {
				Object object = s.getFirstElement();
				if (object instanceof IResource) {
					IProject p = ((IResource) object).getProject();
					update(p);
				}
			}
		}
	}

	public void update(IProject p) {
		projectName.setText(p.getName());
	}
}
