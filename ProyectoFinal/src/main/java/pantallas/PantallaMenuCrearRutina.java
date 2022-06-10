package pantallas;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import elementosvisuales.Boton1;
import elementosvisuales.Boton2;
import elementosvisuales.BotonConSonido;
import elementosvisuales.BotonMenu;
import utilsDB.UtilsDB;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import Enums.TipoEntrenamiento;
import clases.Ejercicio;
import clases.EjercicioDinamico;
import clases.Usuario;

import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

public class PantallaMenuCrearRutina extends JPanel{
	private Ventana ventana;
	
	
	public PantallaMenuCrearRutina(Ventana v) {
		setBorder(null);
		setBackground(new Color(37, 42, 52));
		this.ventana = v;
		setSize(800, 464);
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(611, 59, 189, 441);
		add(scrollPane);

		JPanel panelDerecha = new JPanel();
		panelDerecha.setBorder(new LineBorder(Color.WHITE, 2));
		panelDerecha.setBackground(new Color(37, 42, 52));
		scrollPane.setViewportView(panelDerecha);

		JButton botonSNivel = new BotonMenu("Seleccionar Nivel");
		botonSNivel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarAPantalla("nivel");
			}
		});

		JButton botonSEntrenamiento = new BotonMenu("Entrenamientos");
		botonSEntrenamiento.setSize(180, 29);
		botonSEntrenamiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarAPantalla("entrenamiento");
			}
		});

		JButton botonOp4 = new BotonMenu("Crear Rutinas");
		botonOp4.setSize(180, 29);

		JButton botonOp3 = new BotonMenu("Mis rutinas");
		GroupLayout gl_panelDerecha = new GroupLayout(panelDerecha);
		gl_panelDerecha.setHorizontalGroup(gl_panelDerecha.createParallelGroup(Alignment.LEADING)
				.addComponent(botonSNivel, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
				.addComponent(botonSEntrenamiento, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
				.addComponent(botonOp4, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
				.addComponent(botonOp3, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE));
		gl_panelDerecha.setVerticalGroup(gl_panelDerecha.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDerecha.createSequentialGroup()
						.addComponent(botonSNivel, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(botonSEntrenamiento, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(botonOp4, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(botonOp3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)));
		panelDerecha.setLayout(gl_panelDerecha);

		JList list = new JList();
		list.setBounds(0, 500, 800, 0);
		list.setBackground(Color.BLACK);
		add(list);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 59, 94, 441);
		add(scrollPane_2);

		JPanel panelIzquierda = new JPanel();
		scrollPane_2.setRowHeaderView(panelIzquierda);
		panelIzquierda.setBorder(new LineBorder(Color.WHITE, 2));
		panelIzquierda.setBackground(new Color(37, 42, 52));

		JButton botonEditar = new BotonMenu("Editar");
		botonEditar.setVerticalAlignment(SwingConstants.TOP);

		BotonMenu botonPerfil = new BotonMenu("Perfil");

		botonPerfil.setVerticalAlignment(SwingConstants.TOP);

		BotonMenu botonSalir = new BotonMenu("Salir");
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarAPantalla("menu");
			}
		});
		botonSalir.setVerticalAlignment(SwingConstants.TOP);
		botonSalir.setText("Salir");

		GroupLayout gl_panelIzquierda = new GroupLayout(panelIzquierda);
		gl_panelIzquierda.setHorizontalGroup(gl_panelIzquierda.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelIzquierda.createSequentialGroup()
						.addGroup(gl_panelIzquierda.createParallelGroup(Alignment.LEADING)
								.addComponent(botonPerfil, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
								.addComponent(botonEditar, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
								.addComponent(botonSalir, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
						.addGap(20)));
		gl_panelIzquierda.setVerticalGroup(gl_panelIzquierda.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelIzquierda.createSequentialGroup()
						.addComponent(botonPerfil, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(botonEditar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 295, Short.MAX_VALUE)
						.addComponent(botonSalir, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addGap(37)));
		panelIzquierda.setLayout(gl_panelIzquierda);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 800, 59);
		panel.setBorder(new LineBorder(Color.WHITE, 2));
		panel.setBackground(new Color(8, 217, 214));
		add(panel);

		JLabel lblMenu = new JLabel("HARD WORKOUT");
		lblMenu.setBackground(Color.BLACK);
		lblMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenu.setForeground(new Color(37, 42, 52));
		lblMenu.setFont(new Font("Arial", Font.BOLD, 40));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(87)
						.addComponent(lblMenu, GroupLayout.PREFERRED_SIZE, 524, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(183, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(lblMenu,
				GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE));
		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(94, 59, 517, 441);
		panel_1.setBorder(new LineBorder(Color.WHITE, 2));
		panel_1.setBackground(Color.WHITE);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Crear Rutinas");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 26));
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(0, 0, 517, 37);
		panel_1.add(lblNewLabel_1);
		
		final JComboBox comboRepeticiones = new JComboBox();
		comboRepeticiones.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"}));
		comboRepeticiones.setBounds(303, 226, 46, 21);
		panel_1.add(comboRepeticiones);
		
		final JComboBox comboSeries = new JComboBox();
		comboSeries.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		comboSeries.setBounds(441, 226, 41, 21);
		panel_1.add(comboSeries);
		final JComboBox comboEjercicios = new JComboBox();
		comboEjercicios.setModel(new DefaultComboBoxModel(new String[] {""}));
		comboEjercicios.setBounds(26, 226, 211, 21);
		panel_1.add(comboEjercicios);
		if((ventana.usuarioLogeado.getEntrenamiento()+"").equals(TipoEntrenamiento.RESISTENCIA+"")) {
		
		comboEjercicios.setModel(new DefaultComboBoxModel(new String[] {"dominada prona con goma", "2", "3", "4"}));
		
		panel_1.add(comboEjercicios);
		}
		JComboBox comboNumeroEjercicios = new JComboBox();
		comboNumeroEjercicios.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"}));
		comboNumeroEjercicios.setBounds(410, 99, 41, 21);
		panel_1.add(comboNumeroEjercicios);
		
		JLabel lblNewLabel_2 = new JLabel("Cantidad de ejercicios");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(155, 99, 211, 17);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Ejercicios");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(26, 203, 211, 13);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Repeticiones");
		 
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(247, 191, 147, 37);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblSeries = new JLabel("Series");
		lblSeries.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeries.setFont(new Font("Arial", Font.PLAIN, 18));
		lblSeries.setForeground(Color.WHITE);
		lblSeries.setBounds(410, 203, 107, 15);
		panel_1.add(lblSeries);
		
		JButton btGuardar = new JButton("Guardar");
		btGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Statement smt = UtilsDB.conectarBD();
				
				try {
					smt.executeUpdate(
							"Update Ejercicio_Dinamico set repeticiones = " + comboRepeticiones.getSelectedItem() + ",series ="+comboSeries.getSelectedItem()+" where nombre = '" + comboEjercicios.getSelectedItem() + "';");
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				UtilsDB.desconectarBD();
				JOptionPane.showMessageDialog(ventana,comboSeries.getSelectedItem()+" series de "+comboRepeticiones.getSelectedItem()+" repeticiones"+" de " +comboEjercicios.getSelectedItem(), "Ejercicio Seleccionado: ",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btGuardar.setBounds(388, 354, 94, 21);
		panel_1.add(btGuardar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\2DAM\\Documents\\GitHub\\Proyecto-SW\\ProyectoFinal\\calistenia.jpg"));
		lblNewLabel.setBounds(0, -65, 878, 525);
		panel_1.add(lblNewLabel);

	}
}
