
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;


public class RunClass {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		
		FillLayout fillLayout = new FillLayout();
		fillLayout.type = SWT.HORIZONTAL;
		
		shell.setLayout(fillLayout);
		
		Button button1 = new Button(shell, SWT.PUSH);
		button1.setText("B1");
		Button button3 = new Button(shell, SWT.PUSH);
		button3.setText("B3");
		Button button2 = new Button(shell, SWT.PUSH);
		button2.setText("B2");
		
		
		
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}

}
