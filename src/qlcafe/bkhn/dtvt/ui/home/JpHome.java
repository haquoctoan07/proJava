package qlcafe.bkhn.dtvt.ui.home;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JpHome extends JPanel {
	public static JLabel jLabel1;
	private JPanel jPanel1;
	public JpHome() {
		initComponents();
	}
	private void initComponents() {

		jPanel1 = new JPanel();
		jLabel1 = new JLabel();

		setPreferredSize(new java.awt.Dimension(1255, 600));

		jPanel1.setPreferredSize(new java.awt.Dimension(1255, 600));

		jLabel1.setIcon(new ImageIcon(getClass().getResource("/qlcafe/bkhn/dtvt/ui/images/coffee-twitter-background.jpg")));
		jLabel1.setMaximumSize(new java.awt.Dimension(1258, 519));
		jLabel1.setMinimumSize(new java.awt.Dimension(1258, 519));
		jLabel1.setPreferredSize(new java.awt.Dimension(1258, 519));

		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap())
				);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 525, GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE))
				);

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 1258, GroupLayout.PREFERRED_SIZE)
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 525, GroupLayout.PREFERRED_SIZE)
				);
	}

}

