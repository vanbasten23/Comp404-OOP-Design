package xw32_wb7.chatroom.view;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.rmi.RemoteException;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import common.IMember;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * This is the team mini view.
 * @author xw32, wb7
 *
 * @param <T>
 */
public class TeamMiniView<T> extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1420484933537515397L;
	
	private JPanel contentPane;
	
	/**
	 * Below is the components of team
	 */
	private ITeamView2ModelAdapter _teamView2ModelAdpt;
	private final JPanel pnlWestTeam = new JPanel();
	private final JLabel lblTeammates = new JLabel("Teammates:");
	private final JList<T> teammateList = new JList<T>();
	private final JPanel panel = new JPanel();
	private final JButton btnSendText = new JButton("Send text");
	private final JScrollPane scrollPaneTeam = new JScrollPane();
	private final JTextArea textAreaTeam = new JTextArea();
	private final JTextField textField = new JTextField();
	private final JButton btnLeave = new JButton("Leave");
	
	/**
	 * Construct a team mini view.
	 * @param _teamView2ModelAdpt The team view to team model adapter.
	 */
	public TeamMiniView(ITeamView2ModelAdapter _teamView2ModelAdpt) {
		textField.setToolTipText("Input the text message here");
		textField.setColumns(20);
		this._teamView2ModelAdpt = _teamView2ModelAdpt;
		
		initGUI();
	}

	/**
	 * Initialize the team GUI.
	 */
	private void initGUI() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1000, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		lblTeammates.setMaximumSize(new Dimension(100, 24));
		
		contentPane.add(pnlWestTeam, BorderLayout.WEST);
		pnlWestTeam.setLayout(new GridLayout(2, 1, 0, 0));
		lblTeammates.setVerticalAlignment(SwingConstants.TOP);
		
		pnlWestTeam.add(lblTeammates);
		
		pnlWestTeam.add(teammateList);
		
		panel.setBackground(Color.CYAN);
		
		contentPane.add(panel, BorderLayout.SOUTH);
		
		panel.add(textField);
		btnSendText.setToolTipText("Click to send the text message");
		btnSendText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_teamView2ModelAdpt.send(textField.getText());
				textField.setText("");
			}
		});
		
		panel.add(btnSendText);
		btnLeave.setToolTipText("Click to leave the team");
		btnLeave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_teamView2ModelAdpt.leave();
			}
		});
		
		panel.add(btnLeave);
		
		contentPane.add(scrollPaneTeam, BorderLayout.CENTER);
		
		textAreaTeam.setEditable(false);
		scrollPaneTeam.setViewportView(textAreaTeam);
	}

	/**
	 * start the mini team view
	 */
	public void start() {
		setVisible(true);
	}
	
	/**
	 * Append string onto the GUI.
	 * @param s
	 */
	public void append(String s){
		textAreaTeam.append(s);
	}
	
	@SuppressWarnings("unchecked")
	/**
	 * Add member stub to the memberStubList.
	 * @param memberStubList
	 */
	public void refreshMemberList(Collection<IMember> memberStubList){
		teammateList.removeAll();
		String[] memberStubArray = new String[memberStubList.size()];
		Iterator<IMember> it = memberStubList.iterator();
		int i=0;
		while (it.hasNext()) {
			try {
				memberStubArray[i++] = it.next().getName();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		teammateList.setListData((T[]) memberStubArray);
	}
	
	
}
