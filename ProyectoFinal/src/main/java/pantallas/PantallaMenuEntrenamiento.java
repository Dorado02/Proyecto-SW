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
import elementosvisuales.BotonConSonido;
import elementosvisuales.BotonMenu;

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
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import Enums.TipoEntrenamiento;
import clases.Entrenamiento;
import clases.Usuario;

public class PantallaMenuEntrenamiento extends JPanel {
	private Ventana ventana;

	public PantallaMenuEntrenamiento(Ventana v) {
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

		JButton botonMusica = new BotonConSonido("");
		botonMusica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}

		});
		botonMusica.setBounds(447, 365, 60, 29);
		panel_1.add(botonMusica);

		JLabel lblNewLabel_1 = new JLabel("Pulsa para motivacion");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(282, 365, 155, 29);
		panel_1.add(lblNewLabel_1);

		final JComboBox listaEntrenamientos = new JComboBox();
		listaEntrenamientos.setModel(new DefaultComboBoxModel(TipoEntrenamiento.values()));
		listaEntrenamientos.setBounds(302, 119, 159, 29);
		panel_1.add(listaEntrenamientos);

		JButton botonSeleccionar = new JButton("Seleccionar");
		botonSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					String nombre = ventana.usuarioLogeado.getNombre();
					TipoEntrenamiento entrenamiento = (TipoEntrenamiento) listaEntrenamientos.getSelectedItem();
					Usuario u = new Usuario(nombre, entrenamiento);
					ventana.usuarioLogeado.setEntrenamiento(entrenamiento);
					JOptionPane.showMessageDialog(
							ventana,entrenamiento+" ","Entrenamiento seleccionado",
							JOptionPane.INFORMATION_MESSAGE);
					ventana.cambiarAPantalla("menu");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		botonSeleccionar.setBounds(124, 122, 104, 23);
		panel_1.add(botonSeleccionar);
		
		JLabel lbSeleccionarEntrenamiento = new JLabel("Selecciona Entrenamiento");
		lbSeleccionarEntrenamiento.setForeground(Color.WHITE);
		lbSeleccionarEntrenamiento.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lbSeleccionarEntrenamiento.setHorizontalAlignment(SwingConstants.CENTER);
		lbSeleccionarEntrenamiento.setBounds(0, 10, 517, 52);
		panel_1.add(lbSeleccionarEntrenamiento);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("./fondo (1).jpg"));
		lblNewLabel.setBounds(0, -48, 655, 536);
		panel_1.add(lblNewLabel);

	}
}
