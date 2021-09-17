package bondsDashboard.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JTable;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.swing.JTabbedPane;

import bondsDashboard.model.Bond;



public class BondsGUI {

	private JFrame frame;
	private JTable tableBonds;
	private JTextArea txtId;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BondsGUI window = new BondsGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BondsGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 915, 585);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 270, 879, 227);
		//panel_4.add(panel);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblId = new JLabel("id");
		lblId.setHorizontalAlignment(SwingConstants.TRAILING);
		lblId.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblId.setBounds(40, 52, 99, 14);
		panel.add(lblId);
		
		JLabel lblState = new JLabel("State");
		lblState.setHorizontalAlignment(SwingConstants.TRAILING);
		lblState.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblState.setBounds(40, 87, 99, 21);
		panel.add(lblState);
		
		JLabel lblYield = new JLabel("Yield");
		lblYield.setHorizontalAlignment(SwingConstants.TRAILING);
		lblYield.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblYield.setBounds(20, 122, 119, 27);
		panel.add(lblYield);
		
		JLabel lblIssuer = new JLabel("Issuer");
		lblIssuer.setHorizontalAlignment(SwingConstants.TRAILING);
		lblIssuer.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblIssuer.setBounds(375, 52, 99, 14);
		panel.add(lblIssuer);
		
		JLabel lblCoupon = new JLabel("Coupon");
		lblCoupon.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCoupon.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblCoupon.setBounds(437, 87, 119, 21);
		panel.add(lblCoupon);
		
		JLabel lblMoody = new JLabel("Moody");
		lblMoody.setHorizontalAlignment(SwingConstants.TRAILING);
		lblMoody.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblMoody.setBounds(457, 125, 99, 21);
		panel.add(lblMoody);
		
		txtId = new JTextArea();
		txtId.setEditable(false);
		txtId.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtId.setBounds(149, 47, 216, 27);
		panel.add(txtId);
		
		JTextArea txtState = new JTextArea();
		txtState.setEditable(false);
		txtState.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtState.setBounds(149, 85, 247, 27);
		panel.add(txtState);
		
		JTextArea txtYield = new JTextArea();
		txtYield.setEditable(false);
		txtYield.setText(" ");
		txtYield.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtYield.setBounds(149, 123, 247, 27);
		panel.add(txtYield);
		
		JTextArea txtIssuer = new JTextArea();
		txtIssuer.setEditable(false);
		txtIssuer.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtIssuer.setBounds(484, 47, 329, 27);
		panel.add(txtIssuer);
		
		JTextArea txtCoupon = new JTextArea();
		txtCoupon.setEditable(false);
		txtCoupon.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtCoupon.setBounds(566, 85, 247, 27);
		panel.add(txtCoupon);
		
		JTextArea txtMoody = new JTextArea();
		txtMoody.setEditable(false);
		txtMoody.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtMoody.setBounds(566, 123, 247, 27);
		panel.add(txtMoody);
		
		JLabel lblMaturity = new JLabel("Maturity");
		lblMaturity.setHorizontalAlignment(SwingConstants.TRAILING);
		lblMaturity.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblMaturity.setBounds(40, 160, 99, 21);
		panel.add(lblMaturity);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPrice.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblPrice.setBounds(457, 163, 99, 14);
		panel.add(lblPrice);
		
		JTextArea txtMaturity = new JTextArea();
		txtMaturity.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtMaturity.setEditable(false);
		txtMaturity.setBounds(149, 161, 247, 27);
		panel.add(txtMaturity);
		
		JTextArea txtPrice = new JTextArea();
		txtPrice.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtPrice.setEditable(false);
		txtPrice.setBounds(566, 161, 247, 27);
		panel.add(txtPrice);
		
		JLabel lblPurchased = new JLabel("Purchase Date");
		lblPurchased.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPurchased.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblPurchased.setBounds(231, 205, 134, 21);
		panel.add(lblPurchased);
		
		JTextArea txtPurchased = new JTextArea();
		txtPurchased.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtPurchased.setEditable(false);
		txtPurchased.setBounds(375, 199, 216, 27);
		panel.add(txtPurchased);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 899, 545);
		frame.getContentPane().add(tabbedPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		//tabbedPane.addTab("New tab", null, scrollPane_1, null);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		scrollPane_1.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "Issuer", "State", "Coupon", "Yield", "Moody", "Maturity", "Price", "Purchased"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		
		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("My Bonds", null, panel_6, null);
		ChangeListener changeListener = new ChangeListener() {
		      public void stateChanged(ChangeEvent changeEvent) {
		        JTabbedPane sourceTabbedPane = (JTabbedPane) changeEvent.getSource();
		        int index = sourceTabbedPane.getSelectedIndex();
		        if(index==0) {
		        	tableUpdate(true);
		        	lblPurchased.setVisible(true);
		        	txtPurchased.setVisible(true);
		        }
		        else {
		        	tableUpdate(false);
		        	lblPurchased.setVisible(false);
		        	txtPurchased.setVisible(false);
		        }
		      }
		    };
		    tabbedPane.addChangeListener(changeListener);
		panel_6.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(0, 0, 894, 245);
		panel_6.add(panel_7);
		panel_7.setLayout(null);
		
		scrollPane_1.setBounds(0, 0, 894, 246);
		panel_7.add(scrollPane_1);
		JButton btnSell = new JButton("Sell");
		btnSell.setBounds(380, 479, 89, 27);
		panel_6.add(btnSell);
		btnSell.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					seller(txtId.getText());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				tableUpdate(true);
			}
		});
		btnSell.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		JScrollPane scrollPane = new JScrollPane();
		//splitPane.setLeftComponent(scrollPane);
		
		tableBonds = new JTable();
		tableBonds.setFillsViewportHeight(true);
		scrollPane.setViewportView(tableBonds);
		tableBonds.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "Issuer", "State", "Coupon", "Yield", "Moody", "Maturity", "Price"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Bond Market", null, panel_4, null);
		panel_4.setLayout(null);
		
		JButton btnBuy = new JButton("Buy");
		btnBuy.setBounds(382, 479, 89, 27);
		panel_4.add(btnBuy);
		btnBuy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableUpdate(false);
			}
		});
		btnBuy.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnBuy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					buyer(txtId.getText());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				tableUpdate(false);
			}
		});
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 0, 894, 246);
		panel_4.add(panel_5);
		panel_5.setLayout(null);
		scrollPane.setBounds(0, 0, 894, 246);
		panel_5.add(scrollPane);
		tableBonds.getColumnModel().getColumn(0).setResizable(false);
		tableBonds.getColumnModel().getColumn(0).setPreferredWidth(30);
		tableBonds.getColumnModel().getColumn(1).setResizable(false);
		tableBonds.getColumnModel().getColumn(1).setPreferredWidth(200);
		tableBonds.getColumnModel().getColumn(2).setResizable(false);
		tableBonds.getColumnModel().getColumn(2).setPreferredWidth(38);
		tableBonds.getColumnModel().getColumn(3).setResizable(false);
		tableBonds.getColumnModel().getColumn(3).setPreferredWidth(65);
		tableBonds.getColumnModel().getColumn(4).setResizable(false);
		tableBonds.getColumnModel().getColumn(4).setPreferredWidth(65);
		tableBonds.getColumnModel().getColumn(5).setResizable(false);
		tableBonds.getColumnModel().getColumn(5).setPreferredWidth(60);
		tableBonds.getColumnModel().getColumn(6).setResizable(false);
		tableBonds.getColumnModel().getColumn(7).setResizable(false);
		tableBonds.getColumnModel().getColumn(7).setPreferredWidth(70);
		tableBonds.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row=tableBonds.getSelectedRow();
				String id=tableBonds.getModel().getValueAt(row, 0).toString();
				String issuer=tableBonds.getModel().getValueAt(row, 1).toString();
				String state=tableBonds.getModel().getValueAt(row, 2).toString();
				String coupon=tableBonds.getModel().getValueAt(row, 3).toString();
				String yield=tableBonds.getModel().getValueAt(row, 4).toString();
				String moody=tableBonds.getModel().getValueAt(row, 5).toString();
				String maturity=tableBonds.getModel().getValueAt(row, 6).toString();
				String price=tableBonds.getModel().getValueAt(row, 7).toString();
				txtId.setText(id);
				txtIssuer.setText(issuer);
				txtState.setText(state);
				txtCoupon.setText(coupon);
				txtYield.setText(yield);
				txtMoody.setText(moody);
				txtMaturity.setText(maturity);
				txtPrice.setText(price);
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(38);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(60);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(60);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(5).setPreferredWidth(50);
		table.getColumnModel().getColumn(6).setResizable(false);
		table.getColumnModel().getColumn(6).setPreferredWidth(65);
		table.getColumnModel().getColumn(7).setResizable(false);
		table.getColumnModel().getColumn(7).setPreferredWidth(60);
		table.getColumnModel().getColumn(8).setPreferredWidth(65);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row=table.getSelectedRow();
				String id=table.getModel().getValueAt(row, 0).toString();
				String issuer=table.getModel().getValueAt(row, 1).toString();
				String state=table.getModel().getValueAt(row, 2).toString();
				String coupon=table.getModel().getValueAt(row, 3).toString();
				String yield=table.getModel().getValueAt(row, 4).toString();
				String moody=table.getModel().getValueAt(row, 5).toString();
				String maturity=table.getModel().getValueAt(row, 6).toString();
				String price=table.getModel().getValueAt(row, 7).toString();
				String purchased=table.getModel().getValueAt(row, 8).toString();
				txtId.setText(id);
				txtIssuer.setText(issuer);
				txtState.setText(state);
				txtCoupon.setText(coupon);
				txtYield.setText(yield);
				txtMoody.setText(moody);
				txtMaturity.setText(maturity);
				txtPrice.setText(price);
				txtPurchased.setText(purchased);
			}
		});
		tableUpdate(true);
		
	}
	private void buyer(String id) throws IOException, InterruptedException {
		String url="http://localhost:8080/Bonds/Market/Buy?id="+id;
		HttpClient client= HttpClient.newHttpClient();
        HttpRequest request= HttpRequest.newBuilder()
        		.POST(BodyPublishers.ofString(""))
        		.header("Content-Type", "text/plain; charset=UTF-8")
        		.uri(URI.create(url))
        		.build();
        try {
			client.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void seller(String id) throws IOException, InterruptedException {
		String url="http://localhost:8080/Bonds/Market/Sell?id="+id;
		HttpClient client= HttpClient.newHttpClient();
        HttpRequest request= HttpRequest.newBuilder()
        		.POST(BodyPublishers.ofString(""))
        		.header("Content-Type", "text/plain; charset=UTF-8")
        		.uri(URI.create(url))
        		.build();
        client.send(request, HttpResponse.BodyHandlers.ofString());
	}

	private List<Bond> market() throws IOException, InterruptedException{
		String url="http://localhost:8080/Bonds/Bond?sold=false";
		HttpClient client= HttpClient.newHttpClient();
        HttpRequest request= HttpRequest.newBuilder()
        		.GET()
        		.header("accept", "application/json")
        		.uri(URI.create(url))
        		.build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        ObjectMapper mapper = new ObjectMapper();
        List<Bond> bonds=mapper.readValue(response.body(), new TypeReference<List<Bond>>() {});
        return bonds;
	}
	private List<Bond> sold() throws IOException, InterruptedException{
		String url="http://localhost:8080/Bonds/Bond?sold=true";
		HttpClient client= HttpClient.newHttpClient();
        HttpRequest request= HttpRequest.newBuilder()
        		.GET()
        		.header("accept", "application/json")
        		.uri(URI.create(url))
        		.build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        ObjectMapper mapper = new ObjectMapper();
        List<Bond> bonds=mapper.readValue(response.body(), new TypeReference<List<Bond>>() {});
        return bonds;
	}
	private void tableUpdate(boolean type) {
		//if type true, then sold is called
		//if type false, then market is called
		List<Bond> bonds=null;
		if(type) {
			try {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				bonds= sold();
				int size=bonds.size();
				int i=0;
				Bond bond;
				while(i<size) {
					bond=bonds.get(i);
					model.addRow(new Object[]{ bond.getId(), bond.getIssuer(), bond.getState(), bond.getCoupon(), bond.getYield(), bond.getMoody(), bond.getMaturity(), bond.getPrice(), bond.getPurchased()});
					i++;
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else {
			try {
				DefaultTableModel model = (DefaultTableModel) tableBonds.getModel();
				model.setRowCount(0);
				bonds= market();
				int size=bonds.size();
				int i=0;
				Bond bond;
				while(i<size) {
					bond=bonds.get(i);
					model.addRow(new Object[]{ bond.getId(), bond.getIssuer(), bond.getState(), bond.getCoupon(), bond.getYield(), bond.getMoody(), bond.getMaturity(), bond.getPrice()});
					i++;
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
