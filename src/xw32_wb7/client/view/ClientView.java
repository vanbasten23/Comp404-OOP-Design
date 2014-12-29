package xw32_wb7.client.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import xw32_wb7.chatroom.model.Member;
import xw32_wb7.chatroom.view.ITeamView2ModelAdapter;
import xw32_wb7.chatroom.view.LobbyMiniView;
import xw32_wb7.chatroom.view.TeamMiniView;

/**
 * This is the clent view in the client MVC.
 * @author xw32,wb7
 */
public class ClientView extends JFrame {

	private static final long serialVersionUID = 7731370294313888186L;
	/**
	 * Content panel
	 */
	private JPanel contentPane;
	/**
	 * View to model adapter
	 */
	private IClientView2ModelAdpt _cv2mAdpt;//client view to model adapter.
	/**
	 * The textfield used to enter IP address
	 */
	private JTextField ipTxt;
	/**
	 * Panel in the north
	 */
	private JPanel northPanel;
	/**
	 * Call connectTo method
	 */
	private JButton btnConnect;
	/**
	 * The label "Connect to:"
	 */
	private JLabel lblConnectTo;
	/**
	 * ScrollPanel handling
	 */
	private JScrollPane scrollPane;
	/**
	 * System information displays on this textArea
	 */
	private JTextArea sysInfoTxt = new JTextArea();
	/**
	 * Create game MVC
	 */
	private final JButton btnCreateMap;
	/**
	 * The Quit button.
	 */
	private JButton btnQuit;

	/**
	 * Launch the application.
	 */
	public void start(){
		setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public ClientView(IClientView2ModelAdpt _cv2mAdpt) {
		this._cv2mAdpt = _cv2mAdpt;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		northPanel = new JPanel();
		northPanel.setBounds(5, 5, 440, 39);
		northPanel.setLayout(new GridLayout(1, 1, 1, 0));
		contentPane.add(northPanel,BorderLayout.NORTH);
		
		lblConnectTo = new JLabel("Connect to:");
		northPanel.add(lblConnectTo);
		
		ipTxt = new JTextField();
		ipTxt.setToolTipText("Input the server IP address here.");
		northPanel.add(ipTxt);
		
		ipTxt.setColumns(10);
		btnCreateMap = new JButton("Create Map!");
		btnConnect  = new JButton("Connect!");
		btnConnect.setToolTipText("Click to connect the server.");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connect();
				btnCreateMap.setEnabled(true);
			}
		});
		
		northPanel.add(btnConnect);
		
		
		btnQuit = new JButton("Quit");
		btnQuit.setToolTipText("Click to quit the client application.");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_cv2mAdpt.quit();
			}
		});
		northPanel.add(btnQuit);
		
		scrollPane = new JScrollPane();
		
		scrollPane.setBounds(5, 45, 440, 230);
		contentPane.add(scrollPane, BorderLayout.CENTER);		
		sysInfoTxt.setWrapStyleWord(true);
		sysInfoTxt.setLineWrap(true);
		sysInfoTxt.setEnabled(false);
		sysInfoTxt.setEditable(false);
		
		sysInfoTxt.setBounds(152, 138, 1, 16);
		scrollPane.setViewportView(sysInfoTxt);
		
		/**
		 * When client close the app by force, i.e. by clicking the cross or pressing command+q,
		 * client send leave message to all the people in the lobby and in the team.
		 */
		addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
            	_cv2mAdpt.quit();
                System.exit(0);
            }
        });
	}
	
	/**
	 * append system info on client view.
	 * @param s
	 */
	public void append(String s){
		sysInfoTxt.append(s);
		sysInfoTxt.setCaretPosition(sysInfoTxt.getText().length());
	}
	
	/**
	 * Connect method, let client connect to a server
	 */
	private void connect(){
		append("Connecting to remote person...\n");
		append(_cv2mAdpt.connectTo(ipTxt.getText()) + "\n");
		
	}
	
	/**
	 * A user-friendly function to set local IP address
	 * @param ip
	 * 		local IP address
	 */
	public void setRemoteAddress(String ip){
		ipTxt.setText(ip);
	}
	
	/**
	 * Make a team chatroom miniView responding to creating the whole MVC.
	 * @param _teamView2ModelAdpt
	 * 		team view to model adapter
	 * @return
	 * 		the teamMiniView object
	 */
	public TeamMiniView<Member> makeMiniTeamView(ITeamView2ModelAdapter _teamView2ModelAdpt) {
		TeamMiniView<Member> teamMiniView = new TeamMiniView<Member>(_teamView2ModelAdpt);
		return teamMiniView;
	}
	
	/**
	 * Make a lobby chatroom miniView responding to creating the whole MVC
	 * @param _lobbyView2TeamModelAdpt
	 * 		team view to model adapter
	 * @return
	 * 		the lobbyMiniView Object
	 */
	public LobbyMiniView makeMiniLobbyView(ITeamView2ModelAdapter _lobbyView2TeamModelAdpt) {
		LobbyMiniView lobbyMiniView = new LobbyMiniView(_lobbyView2TeamModelAdpt);
		return lobbyMiniView;
	}
	
	
}
