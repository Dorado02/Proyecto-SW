package pantallas;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import elementosvisuales.Boton1;
import elementosvisuales.Boton2;
import elementosvisuales.BotonMenu;
import excepciones.NivelVacioException;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.SQLException;
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
import clases.Usuario;

import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;

public class PantallaMenuNivel extends JPanel {
	private Ventana ventana;

	public PantallaMenuNivel(Ventana v) {
		setBorder(null);
		setBackground(new Color(37, 42, 52));
		this.ventana = v;
		setSize(800, 500);
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
		botonOp4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ventana.usuarioLogeado.getEntrenamiento()==null||ventana.usuarioLogeado.getNivel()==0) {
					JOptionPane.showMessageDialog(ventana,"Selecciona tu nivel y tu entrenamiento","Error",JOptionPane.ERROR_MESSAGE);
					
				}
				else {
					ventana.cambiarAPantalla("crearRutina");
				}
			}
		});
		botonOp4.setSize(180, 29);
		;

		JButton botonOp3 = new BotonMenu("New button");
		botonOp3.setText("Mis rutinas");
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

		BotonMenu botonSalir = new BotonMenu("Salir");
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarAPantalla("menu");
			}
		});
		botonSalir.setVerticalAlignment(SwingConstants.TOP);
		botonSalir.setText("Salir");

		BotonMenu botonPerfil = new BotonMenu("Perfil");

		botonPerfil.setVerticalAlignment(SwingConstants.TOP);
		GroupLayout gl_panelIzquierda = new GroupLayout(panelIzquierda);
		gl_panelIzquierda.setHorizontalGroup(gl_panelIzquierda.createParallelGroup(Alignment.LEADING)
				.addComponent(botonPerfil, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
				.addComponent(botonEditar, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
				.addComponent(botonSalir, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE));
		gl_panelIzquierda.setVerticalGroup(gl_panelIzquierda.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelIzquierda.createSequentialGroup()
						.addComponent(botonPerfil, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(botonEditar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(292).addComponent(botonSalir, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)));
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

		final JComboBox comboNivel = new JComboBox();
		comboNivel.setEditable(true);
		comboNivel
				.setModel(new DefaultComboBoxModel(new String[] {"...","1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
		comboNivel.setBounds(324, 148, 59, 23);
		panel_1.add(comboNivel);

		JButton botonNivel = new JButton("Seleccionar Nivel");
		botonNivel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nombre = ventana.usuarioLogeado.getNombre();
					String nivelS = (String) comboNivel.getSelectedItem();
					byte nivel = 0;
					switch (nivelS) {
					case "...":
						nivel = 0;
						break;
					case "1":
						nivel = 1;
						break;
					case "2":
						nivel = 2;
						break;
					case "3":
						nivel = 3;
						break;
					case "4":
						nivel = 4;
						break;
					case "5":
						nivel = 5;
						break;
					case "6":
						nivel = 6;
						break;
					case "7":
						nivel = 7;
						break;
					case "8":
						nivel = 8;
						break;
					case "9":
						nivel = 9;
						break;
					case "10":
						nivel = 10;
						break;

					}
					Usuario u = new Usuario(nombre, nivel);
					ventana.usuarioLogeado.setNivel(nivel);
					JOptionPane.showMessageDialog(ventana, nivel + " ", "Nivel Seleccionado: ",
							JOptionPane.INFORMATION_MESSAGE);
					ventana.cambiarAPantalla("menu");
				} catch (SQLException | NivelVacioException e1) {
					JOptionPane.showMessageDialog(
							ventana,e1.getMessage(),"Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		botonNivel.setBounds(94, 148, 126, 23);
		panel_1.add(botonNivel);

		JLabel labelNivel = new JLabel("Selecciona tu Nivel");
		labelNivel.setForeground(Color.WHITE);
		labelNivel.setBackground(Color.BLUE);
		labelNivel.setHorizontalAlignment(SwingConstants.CENTER);
		labelNivel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		labelNivel.setBounds(0, 0, 517, 65);
		panel_1.add(labelNivel);

		JButton botonAyuda = new JButton("Ayuda:");
		botonAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(ventana, "Nivel 1: >3 dominadas,>3 fondos. > 5 flexiones\r\n"
						+ "Nivel 2: 3 dominadas, 3 fondos, 5 flexiones\r\n"
						+ "Nivel 3: 7 dominadas, 7 fondos, 13 flexiones,tuck de front/plancha\r\n"
						+ "Nivel 4: 1 muscle up, 10 dominadas, 12 fondos, 20 flexiones, tuck advance front/plancha\r\n"
						+ "Nivel 5: 3 muscle up, 14 dominadas, 18 fondos, 30 flexiones, 5 reps en tuck advance \r\n"
						+ "Nivel 6: 7 muscle up, 17 dominadas, 23 fondos, 40 flexiones, >3sg de front/plancha\r\n"
						+ "Nivel 7: 12 muscle up,23 dominadas, 30 fondos, 5 sg de front/plancha\r\n"
						+ "Nivel 8: 17 muscle ups, 30 dominadas, 40 fondos,10sg front/plancha\r\n"
						+ "Nivel 9: 25 muscle ups, 20sg front/plancha, press front/plancha\r\n"
						+ "Nivel 10: 30sg front/plancha, >10 reps front plancha", "Informacion sobre los niveles",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		botonAyuda.setBounds(94, 349, 80, 23);
		panel_1.add(botonAyuda);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("./fondo (2).jpg"));
		lblNewLabel.setBounds(0, 0, 536, 441);
		panel_1.add(lblNewLabel);

	}
}
