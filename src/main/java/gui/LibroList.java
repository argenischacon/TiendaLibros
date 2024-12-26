
package gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.Libro;
import logica.LibroRepository;
import logica.Purpose;


public class LibroList extends javax.swing.JFrame {
    
    private DefaultTableModel modelTabla;
    private LibroRepository librorepo;
    
    public LibroList() {
        librorepo = new LibroRepository();
        modelTabla = new DefaultTableModel();
        cargarModeloTabla();
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLibros = new javax.swing.JTable();
        btnAgregarLIbro = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TiendaLibros");

        tblLibros.setModel(modelTabla);
        jScrollPane1.setViewportView(tblLibros);

        btnAgregarLIbro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/agregar.png"))); // NOI18N
        btnAgregarLIbro.setToolTipText("Guardar libro");
        btnAgregarLIbro.setPreferredSize(new java.awt.Dimension(73, 73));
        btnAgregarLIbro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarLIbroActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/editar.png"))); // NOI18N
        btnEditar.setToolTipText("Editar libro");
        btnEditar.setPreferredSize(new java.awt.Dimension(73, 73));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eliminar.png"))); // NOI18N
        btnEliminar.setToolTipText("Editar libro");
        btnEliminar.setPreferredSize(new java.awt.Dimension(73, 73));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregarLIbro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(112, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAgregarLIbro, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarLIbroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarLIbroActionPerformed
        LibroForm libroform = new LibroForm(this, true, Purpose.SAVE);
        libroform.setLocationRelativeTo(this);
        libroform.setVisible(true);
        libroform.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                cargarModeloTabla();
            }
        });
        
    }//GEN-LAST:event_btnAgregarLIbroActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        //Verificar que una fila haya sido seleccionada
        if(tblLibros.getSelectedRow() != -1){
        //obtener el id del libro
        long idLibro = (Long)tblLibros.getValueAt(tblLibros.getSelectedRow(), 0);
        //crear LibroForm
        LibroForm libroForm = new LibroForm(this, true, Purpose.UPDATE, idLibro);
        libroForm.setLocationRelativeTo(this);
        libroForm.setVisible(true);
        libroForm.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                cargarModeloTabla();
            }
            
        });
            
        }else{
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
                    
        }
        
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if(tblLibros.getSelectedRow() != -1){
            int opcion = JOptionPane.showConfirmDialog(this, "Desea eliminar este libro?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if(opcion == JOptionPane.YES_OPTION){
            long idLibro =(Long)tblLibros.getValueAt(tblLibros.getSelectedRow(), 0);
            librorepo.delete(librorepo.findById(idLibro));
            JOptionPane.showMessageDialog(this, "Libro eliminado");
            cargarModeloTabla();
            }
        }else{
            JOptionPane.showMessageDialog(this, "No se ha seleccionado ninguna fila");
        }
            
            
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarLIbro;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblLibros;
    // End of variables declaration//GEN-END:variables

    private void cargarModeloTabla() {
        modelTabla.setRowCount(0);
        modelTabla.setColumnIdentifiers(new Object[] {"id", "titulo", "autor",
        "precio", "categoria", "fechaPublicacion"});
        //Cargar datos al modelo (proveniente de la base de datos)
        List<Libro> libros = librorepo.findAll();
        
        for(Libro l: libros){
            modelTabla.addRow(new Object [] {l.getId(), l.getTitulo(), l.getAutor(), 
            l.getPrecio(), l.getCategoria().getNombre(), l.getFechaPublicacion()});
        }
    }
}
