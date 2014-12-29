package xw32_wb7.chatroom.view;

import java.awt.BorderLayout;
import java.rmi.RemoteException;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import common.IMember;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JList;

import java.awt.GridLayout;

/**
 * This is the lobby mini view.
 * @author xw32, wb7
 *
 */
public class LobbyMiniView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4450764599617453022L;
	private JPanel contentPane;
	private ITeamView2ModelAdapter _lobbyView2TeamModelAdpt;
	private final JPanel pnlNorthLobby = new JPanel();
	private final JLabel lblLobby = new JLabel("Lobby");
	private final JScrollPane scrollPaneLobby = new JScrollPane();
	private final JTextArea textAreaLobby = new JTextArea();
	private final JPanel pnlSouthLobby = new JPanel();
	private final JTextField textFieldInputLobby = new JTextField();
	private final JLabel lblInput = new JLabel("Input:");
	private final JButton btnSendLobby = new JButton("send");
	private final JPanel pnlWestLobby = new JPanel();
	private final JLabel lblNewLabel = new JLabel("User list:");
	private final JList<String> listAllUser = new JList<String>();
	private final JButton btnLeave = new JButton("Leave");
	/**
	 * Launch the application.
	 */
	public void start(){
		setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public LobbyMiniView(ITeamView2ModelAdapter _lobbyView2TeamModelAdpt) {
		textFieldInputLobby.setToolTipText("Input the text message here:");
		textFieldInputLobby.setColumns(16);
		this._lobbyView2TeamModelAdpt = _lobbyView2TeamModelAdpt;
		initGUI();
	}
	
	/**
	 * Initialize lobby GUI.
	 */
	private void initGUI() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		contentPane.add(pnlNorthLobby, BorderLayout.NORTH);
		lblLobby.setHorizontalAlignment(SwingConstants.CENTER);
		
		pnlNorthLobby.add(lblLobby);
		
		contentPane.add(scrollPaneLobby, BorderLayout.CENTER);
		
		textAreaLobby.setEditable(false);
		scrollPaneLobby.setViewportView(textAreaLobby);
		
		contentPane.add(pnlSouthLobby, BorderLayout.SOUTH);
		
		pnlSouthLobby.add(lblInput);
		
		pnlSouthLobby.add(textFieldInputLobby);
		btnSendLobby.setToolTipText("Click to send text message");
		btnSendLobby.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_lobbyView2TeamModelAdpt.send(textFieldInputLobby.getText());
				textFieldInputLobby.setText("");
			}
		});
		
		pnlSouthLobby.add(btnSendLobby);
		btnLeave.setToolTipText("Click to leave the lobby");
		btnLeave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_lobbyView2TeamModelAdpt.leave();
			}
		});
		
		pnlSouthLobby.add(btnLeave);
		
		contentPane.add(pnlWestLobby, BorderLayout.WEST);
		pnlWestLobby.setLayout(new GridLayout(2, 1, 0, 0));
		
		pnlWestLobby.add(lblNewLabel);
		
		pnlWestLobby.add(listAllUser);
	}

	/**
	 * Append the text message of type String onto the lobby GUI.
	 * @param s The text message to display
	 */
	public void append(String s){
		textAreaLobby.append(s);
	}
	
	/**
	 * Add newly added member to the member JList on the GUI. 
	 * @param memberStubList
	 */
	public void refreshMemberList(Collection<IMember> memberStubList){
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
		listAllUser.setListData(memberStubArray);
	}
	
}
