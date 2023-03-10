package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import Logica.Calcular;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class Ventana extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton seleccionador;
	private File file;
	private JTree tree;
	private DefaultMutableTreeNode raiz;
	private DefaultTreeModel modelo;
	private JScrollPane scrollPane_1;
	private Calcular calcular;
	private JButton botonComputar;
	private JTextPane textCantidades;
	private JTextPane textEspacio;
	private JTextPane textMasGrandes;
	private JLabel JLCantidades;
	
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 938, 649);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		seleccionador = new JButton("Seleccionar Directorio");
		seleccionador.setBounds(79, 49, 190, 21);
		seleccionador.setBackground(Color.LIGHT_GRAY);
		seleccionador.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		contentPane.add(seleccionador);
		seleccionador.addActionListener(this);
		
		
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(39, 100, 347, 322);
		contentPane.add(scrollPane_1);
		
		tree = new JTree();
		scrollPane_1.setViewportView(tree);
		
		tree.setBackground(new Color(211, 211, 211));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(96, 296, 215, -201);
		contentPane.add(scrollPane);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(54, 105, 257, -35);
		contentPane.add(desktopPane);
		
		JLabel lblNewLabel = new JLabel("Cantidades :");
		lblNewLabel.setToolTipText("Determina  Cantidad de archivos y carpetas en la carpeta seleccionada");
		lblNewLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		lblNewLabel.setBounds(441, 142, 120, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Espacio  (en Bytes): ");
		lblNewLabel_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(414, 321, 147, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Archivos mas grandes :");
		lblNewLabel_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(395, 457, 190, 29);
		contentPane.add(lblNewLabel_2);
		
		JTextPane textCantidades = new JTextPane();
		textCantidades.setBackground(new Color(255, 255, 224));
		textCantidades.setBounds(591, 136, 235, 101);
		contentPane.add(textCantidades);
		
		JTextPane textEspacio = new JTextPane();
		textEspacio.setBackground(new Color(255, 255, 224));
		textEspacio.setBounds(591, 296, 235, 101);
		contentPane.add(textEspacio);
		
		JTextPane textMasGrandes = new JTextPane();
		textMasGrandes.setBackground(new Color(255, 255, 224));
		textMasGrandes.setBounds(591, 437, 235, 101);
		contentPane.add(textMasGrandes);
		
		JButton botonComputar = new JButton("Computar ");
		botonComputar.setBackground(new Color(192, 192, 192));
		botonComputar.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		botonComputar.setBounds(632, 30, 171, 21);
		contentPane.add(botonComputar);
		botonComputar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textCantidades.setText("");
				textEspacio.setText("");
				textMasGrandes.setText("");
				
				calcular= new Calcular();
				
				textCantidades.setText("Hola");
				textCantidades.setText("Cantidad de directorios: "+cantDirectorios());
				textCantidades.setText(textCantidades.getText() + "\n Cantidad de archivos: "+cantidadArchivos());
				textEspacio.setText("Cantidad de espacio: "+ file.length());
				for (String s : calcular.TresMasGrandes(file)) {
					if (textMasGrandes.getText () == "")
						textMasGrandes.setText("" + s);
					else
						textMasGrandes.setText(textMasGrandes.getText () + "\n" + s);
				}
				
			}
		});
		
		
	}
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==seleccionador) {
			
			JFileChooser fileChooser= new JFileChooser();
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			 int respuesta =fileChooser.showSaveDialog(null);	//Select  file to open
				if(respuesta == JFileChooser.APPROVE_OPTION) {
					file = new File(fileChooser.getSelectedFile().getAbsolutePath());
					actualizar(file);
				}else {
					JOptionPane.showMessageDialog(null, "No ha seleccionado ningun directorio");
						
					
		}
	}
	}
	private void actualizar (File archivo) {
		JOptionPane.showMessageDialog(null, "La carpeta raiz es : "+file.getAbsolutePath());
		raiz= new DefaultMutableTreeNode(file.getName());
		modelo = new DefaultTreeModel(raiz);
		crea(raiz,file);
		
		tree.setModel(modelo);
	}
	private void crea (DefaultMutableTreeNode nodo , File carpeta) {
		
		File[] archivos= carpeta.listFiles();
			if(archivos!=null) {
				int contador=0;
				for(File f: archivos) {
					DefaultMutableTreeNode hijo= new DefaultMutableTreeNode(f.getName());
					modelo.insertNodeInto(hijo, nodo, contador);
					contador++;
					if(f.isDirectory()) {
						crea(hijo,f);
					}
				
				}
		   }
}
	private int cantidadArchivos () {
	
	int cantFiles=0;
	File list[] = file.listFiles();
	if (list != null && list.length > 0) {
      for (int i = 0; i < list.length; i++) {
        	 if(list[i].isFile()){
        		 	cantFiles++;
        	 }
      }
	}
      return cantFiles;
}
	private int cantDirectorios() {
		int cantDirectorios=0;
		
		File list[] = file.listFiles();
		if (list != null && list.length > 0) {
		      for (int i = 0; i < list.length; i++) {
		        	 if(list[i].isDirectory()){
		        		 	cantDirectorios++;
		        	 }
		      }
			}
		return cantDirectorios;
	}

}


