/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormMenu;

import com.barcodelib.barcode.Linear;

import com.onbarcode.barcode.android.EAN13;
import com.onbarcode.barcode.android.IBarcode;
import java.awt.Font;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author WINDOWS 10
 */
public class Barang extends javax.swing.JPanel {

    /**
     * Creates new form Barang
     */
    
    DefaultTableModel model = new DefaultTableModel();
    private void load_tabelbarang() {
        
        model.addColumn("No");
        model.addColumn("ID Alat Musik");
        model.addColumn("Nama Alat Musik");
        model.addColumn("Harga Beli");
        model.addColumn("Harga Jual");
        model.addColumn("Stok");
        
        try { 
            int no = 1;
            String sql = "SELECT * FROM alatmusik ORDER BY idalatmusik";
            java.sql.Connection conn = (Connection) koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()){
                model.addRow (new Object[] {no++, res.getString(1),
                    res.getString(2), res.getString(3), res.getString(4), res.getString(5)});
            }
            tabelbarang.setModel(model);
        } catch (SQLException e){
        }
    }
    private void Auto_kodebarang(){
        try{
            String sql = "SELECT MAX(right(idalatmusik,8)) from alatmusik";
            Connection conn = (Connection) koneksi.configDB();
            Statement st = conn.createStatement();
            ResultSet rst = st.executeQuery(sql);
            if(rst.next()){
                String auto_kode,tambah;int kdb;
                auto_kode = Integer.toString(rst.getInt(1)+1);
                kdb = auto_kode.length();
                tambah = "";
                for (int i = 1; i <= 8 - kdb; i++ ){
                    tambah = tambah + "0";
                }
                txtidbarang.setText("AM"+tambah+auto_kode);
            }
            
        }catch(Exception e){
            txtidbarang.setText("AM00000001");
        }
        
    }
    
    public void kosongkan(){
        Auto_kodebarang();
        txtnamabarang.setText(null);
        txthargabeli.setText(null);
        txthargajual.setText(null);
        txtstok.setText(null);
        
    }
    
    
    public Barang() {
        initComponents();
        Auto_kodebarang();
        load_tabelbarang();
        txtidbarang.disable();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtstok = new javax.swing.JTextField();
        txthargabeli = new javax.swing.JTextField();
        txtnamabarang = new javax.swing.JTextField();
        txtidbarang = new javax.swing.JTextField();
        txthargajual = new javax.swing.JTextField();
        txtcaribarang = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelbarang = new javax.swing.JTable();
        btnTambah = new javax.swing.JPanel();
        btnEdit = new javax.swing.JPanel();
        btnHapus = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtstok.setBackground(new java.awt.Color(255, 255, 255));
        txtstok.setBorder(null);
        txtstok.setOpaque(false);
        add(txtstok, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 687, 580, 40));

        txthargabeli.setBorder(null);
        txthargabeli.setOpaque(false);
        txthargabeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthargabeliActionPerformed(evt);
            }
        });
        add(txthargabeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 463, 580, 40));

        txtnamabarang.setBorder(null);
        txtnamabarang.setOpaque(false);
        add(txtnamabarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 352, 580, 40));

        txtidbarang.setBackground(new java.awt.Color(255, 255, 255));
        txtidbarang.setBorder(null);
        txtidbarang.setOpaque(false);
        add(txtidbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 580, 40));

        txthargajual.setBackground(new java.awt.Color(255, 255, 255));
        txthargajual.setBorder(null);
        txthargajual.setOpaque(false);
        add(txthargajual, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 577, 580, 40));

        txtcaribarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcaribarangActionPerformed(evt);
            }
        });
        add(txtcaribarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 100, 230, 30));

        tabelbarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelbarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelbarangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelbarang);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 160, 780, 790));

        btnTambah.setOpaque(false);
        btnTambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTambahMouseClicked(evt);
            }
        });
        add(btnTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 806, 180, 70));

        btnEdit.setOpaque(false);
        btnEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditMouseClicked(evt);
            }
        });
        add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 806, 180, 70));

        btnHapus.setOpaque(false);
        btnHapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHapusMouseClicked(evt);
            }
        });
        add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 806, 180, 70));

        jPanel1.setOpaque(false);
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });
        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 97, 125, 39));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/TampilanBarang.png"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 1010));
    }// </editor-fold>//GEN-END:initComponents

    private void txtcaribarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcaribarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcaribarangActionPerformed

    private void txthargabeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthargabeliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthargabeliActionPerformed

    
    private void btnTambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahMouseClicked
        try {
            String sql3 = "INSERT INTO alatmusik VALUES ('"+txtidbarang.getText()+"','"+txtnamabarang.getText()+
                    "',"+txthargajual.getText()+","+txthargabeli.getText()+","+txtstok.getText()+")";
            java.sql.Connection conn = (Connection) koneksi.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql3);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Penyimpanan Data Berhasil");
            DefaultTableModel model = (DefaultTableModel)tabelbarang.getModel();
            model.setRowCount(0);
            load_tabelbarang();
            kosongkan();
   
        } catch (HeadlessException | SQLException e){
             JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnTambahMouseClicked

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
        try {
            String sql = "UPDATE alatmusik "+"SET namaalatmusik = '"+txtnamabarang.getText()+"',"
                + " harga_jual = '"+txthargajual.getText()
                +"', harga_beli = '"+txthargabeli.getText()
                +"', stok = '"+txtstok.getText()+"'"+
                " WHERE idalatmusik = '"+txtidbarang.getText()+"'";
            java.sql.Connection conn = (Connection) koneksi.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Data Berhasil di Perbarui");
            DefaultTableModel model = (DefaultTableModel)tabelbarang.getModel();
            model.setRowCount(0);
            load_tabelbarang();
        //lebar_tabelbarang();
    } catch (HeadlessException | SQLException e) {
        JOptionPane.showMessageDialog(null, "Perubahan Data Gagal!\n"+e.getMessage());
    }
    kosongkan();
                                           

    }//GEN-LAST:event_btnEditMouseClicked

    private void btnHapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusMouseClicked
    // Tampilan Barang
    try {
        String sql = "DELETE FROM alatmusik WHERE idalatmusik ='"+txtidbarang.getText()+"'";
        java.sql.Connection conn = (Connection) koneksi.configDB();
        java.sql.PreparedStatement pst = conn.prepareStatement(sql);
        pst.execute();
        JOptionPane.showMessageDialog(null,"Data Berhasil di Hapus");
        DefaultTableModel model = (DefaultTableModel)tabelbarang.getModel();
        model.setRowCount(0);
        load_tabelbarang();
        //lebar_tabelbarang();
    } catch (HeadlessException | SQLException e) {
        JOptionPane.showMessageDialog(this, e.getMessage());
    }
    kosongkan();
    Auto_kodebarang();
                           
    }//GEN-LAST:event_btnHapusMouseClicked

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        try {
        String sqls = "SELECT * FROM alatmusik WHERE idalatmusik LIKE '%"+txtcaribarang.getText()+
                    "%' OR namaalatmusik LIKE '%"+txtcaribarang.getText()+"%' OR harga_jual LIKE '"+txtcaribarang.getText()+"'"
                + " OR harga_beli LIKE '"+txtcaribarang.getText()+
                    "' OR stok LIKE '"+txtcaribarang.getText()+"' ORDER BY idalatmusik";
        java.sql.Connection conn = (Connection) koneksi.configDB();
        java.sql.PreparedStatement pst = conn.prepareStatement(sqls);
        java.sql.ResultSet ress = pst.executeQuery(sqls);
        DefaultTableModel model = (DefaultTableModel)tabelbarang.getModel();
        model.setRowCount(0);
            int no = 1;
            while (ress.next()){
                model.addRow (new Object[] {no++, ress.getString(1),
                    ress.getString(2), ress.getString(3), ress.getString(4), ress.getString(5)});
            }
        tabelbarang.setModel(model);
        } catch (SQLException ex) {
    }    
       
    }//GEN-LAST:event_jPanel1MouseClicked

    private void tabelbarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelbarangMouseClicked
        int baris = tabelbarang.rowAtPoint(evt.getPoint());
        
         if (tabelbarang.getValueAt(baris, 1)==null){
            txtidbarang.setText("");
        } else {
            txtidbarang.setText(tabelbarang.getValueAt(baris, 1).toString());
        }
        if (tabelbarang.getValueAt(baris, 2)==null){
            txtnamabarang.setText("");
        } else {
            txtnamabarang.setText(tabelbarang.getValueAt(baris, 2).toString());
        }
        if (tabelbarang.getValueAt(baris, 3)==null){
            txthargabeli.setText("");
        } else {
            txthargabeli.setText(tabelbarang.getValueAt(baris, 3).toString());
        }
        if(tabelbarang.getValueAt(baris, 4)==null){
            txthargajual.setText("");
        }else{
            txthargajual.setText(tabelbarang.getValueAt(baris,4).toString());
        }
        if(tabelbarang.getValueAt(baris,5)==null){
            txtstok.setText("");
        }else {
            txtstok.setText(tabelbarang.getValueAt(baris, 5).toString());
        }
        
        
        
    }//GEN-LAST:event_tabelbarangMouseClicked

    private void generate(String kode) throws Exception{
        EAN13 barcode = new EAN13();
        
        barcode.setData(kode);
        barcode.setUom(IBarcode.UOM_PIXEL);
        barcode.setX(3f);
        barcode.setY(75f);
        
        barcode.setLeftMargin(0f);
        barcode.setRightMargin(0f);
        barcode.setTopMargin(0f);
        barcode.setBottomMargin(0f);
        
        barcode.setResolution(72);
        barcode.setShowText(true);
       
        //barcode.setTextFont(new Font("Arial", 0, 12));
        barcode.setTextMargin(6);
        barcode.setRotate(IBarcode.ROTATE_0);
        //barcode.drawBarcode("src" + "/" + "img" + "/barcode/" + kode + ".gif");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnEdit;
    private javax.swing.JPanel btnHapus;
    private javax.swing.JPanel btnTambah;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelbarang;
    private javax.swing.JTextField txtcaribarang;
    private javax.swing.JTextField txthargabeli;
    private javax.swing.JTextField txthargajual;
    private javax.swing.JTextField txtidbarang;
    private javax.swing.JTextField txtnamabarang;
    private javax.swing.JTextField txtstok;
    // End of variables declaration//GEN-END:variables
}
