/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormMenu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author WINDOWS 10
 */
public class Produkmasuk extends javax.swing.JPanel {

    /**
     * Creates new form Produkmasuk
     */
    
    DefaultTableModel model = new DefaultTableModel();
    private void load_tabelsupplierpm() {
        
        model.addColumn("No");
        model.addColumn("ID Supplier");
        model.addColumn("Nama Supplier");
        model.addColumn("Alamat");
        model.addColumn("No. Telepon");
        model.addColumn("Keterangan");
        
        try { 
            int no = 1;
            String sql = "SELECT * FROM supplier ORDER BY id_supplier";
            Connection conn = (Connection) koneksi.configDB();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(sql);
            while (res.next()){
                model.addRow (new Object[] {no++, res.getString(1),
                    res.getString(2), res.getString(3), res.getString(4), res.getString(5)});
            }
        TabelPertama.setModel(model);
        } catch (SQLException e){
        }
    }
    
    DefaultTableModel model2 = new DefaultTableModel();
     private void load_tabelbarangpm() {
        
        model2.addColumn("No");
        model2.addColumn("ID Alat Musik");
        model2.addColumn("Nama Alat Musik");
        model2.addColumn("Harga");
        model2.addColumn("Stok");
        
        try { 
            int no = 1;
            String sql = "SELECT idalatmusik, namaalatmusik, harga_jual, stok FROM alatmusik ORDER BY idalatmusik";
            java.sql.Connection conn = (Connection) koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()){
                model2.addRow (new Object[] {no++, res.getString(1),
                    res.getString(2), res.getString(3), res.getString(4)});
            }
        TabelPertama.setModel(model2);
        } catch (SQLException e){
        }
    }
     
     DefaultTableModel model3 = new DefaultTableModel();
     private void tabelkeranjang(){
         model3.addColumn("ID Produk Masuk");
         model3.addColumn("ID Supplier");
         model3.addColumn("ID Alat Msuik");
         model3.addColumn("Nama Alat Musik");
         model3.addColumn("Harga");
         model3.addColumn("Jumlah");
         model3.addColumn("Total Harga");
         model3.addColumn("Tanggal");
         
         
         TabelKeranjang.setModel(model3);
         
     }
     
    public Produkmasuk() {
        initComponents();
        load_tabelbarangpm();
        tabelkeranjang();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtKembalian = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelPertama = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabelKeranjang = new javax.swing.JTable();
        txtPencarian = new javax.swing.JTextField();
        txtSupplier = new javax.swing.JTextField();
        txtJumlah = new javax.swing.JTextField();
        txtHargaBeli = new javax.swing.JTextField();
        txtTotalHarga = new javax.swing.JTextField();
        txtBayar = new javax.swing.JTextField();
        opsiTabel = new javax.swing.JComboBox<>();
        btnTambahkan = new javax.swing.JPanel();
        background = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtKembalian.setBorder(null);
        txtKembalian.setOpaque(false);
        add(txtKembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 799, 470, 40));

        TabelPertama.setModel(new javax.swing.table.DefaultTableModel(
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
        TabelPertama.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelPertamaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelPertama);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 800, 290));

        TabelKeranjang.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(TabelKeranjang);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 552, 970, 400));

        txtPencarian.setBorder(null);
        txtPencarian.setOpaque(false);
        add(txtPencarian, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 137, 230, 30));

        txtSupplier.setBorder(null);
        txtSupplier.setOpaque(false);
        add(txtSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 240, 410, 30));

        txtJumlah.setBorder(null);
        txtJumlah.setOpaque(false);
        add(txtJumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 350, 240, 30));

        txtHargaBeli.setBorder(null);
        txtHargaBeli.setOpaque(false);
        add(txtHargaBeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 350, 240, 30));

        txtTotalHarga.setBorder(null);
        txtTotalHarga.setOpaque(false);
        add(txtTotalHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 570, 470, 40));

        txtBayar.setBorder(null);
        txtBayar.setOpaque(false);
        add(txtBayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 684, 470, 40));

        opsiTabel.setBackground(new java.awt.Color(255, 255, 255));
        opsiTabel.setEditable(true);
        opsiTabel.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        opsiTabel.setForeground(new java.awt.Color(0, 0, 0));
        opsiTabel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SUPPLIER", "BARANG" }));
        opsiTabel.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                opsiTabelItemStateChanged(evt);
            }
        });
        add(opsiTabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 200, -1));

        btnTambahkan.setOpaque(false);
        btnTambahkan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTambahkanMouseClicked(evt);
            }
        });
        add(btnTambahkan, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 410, 270, 50));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/TampilanProdukmasuk.png"))); // NOI18N
        add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void opsiTabelItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_opsiTabelItemStateChanged
        if(opsiTabel.getSelectedIndex() == 0){
            load_tabelsupplierpm();
            String id = model.getValueAt(xpgl ,1).toString();
            
            idpgl0 = id;
        }else{
            load_tabelbarangpm();
            String id = TabelPertama.getValueAt(xpgl, 1).toString();
            String nama = TabelPertama.getValueAt(xpgl, 2).toString();
            String harga = TabelPertama.getValueAt(xpgl,3).toString();
            
            idpgl1 = id;
            namapgl= nama;
            hargapgl = harga;
        }
    }//GEN-LAST:event_opsiTabelItemStateChanged
    public int xpgl;
    private void TabelPertamaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelPertamaMouseClicked
        int x = TabelPertama.getSelectedRow();
        xpgl = x;
    }//GEN-LAST:event_TabelPertamaMouseClicked
    public String idpgl0;
    public String idpgl1;
    public String namapgl;
    public String hargapgl;
    
    private void btnTambahkanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahkanMouseClicked
        int Jumlah = Integer.parseInt(txtJumlah.getText());
        int harga = Integer.parseInt(hargapgl);
        int hargatotal = Jumlah * harga;
        
        txtHargaBeli.setText(String.valueOf(hargatotal));
        
        Date date = new Date();
        DateFormat formattanggal = new SimpleDateFormat("YYYY-MM-dd");
        String sekarang = formattanggal.format(date);
        String code = null;
        try{
            String sql = "SELECT MAX(right(id_produkmasuk,8)) from produkmasuk";
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
              code = "PM"+tambah+auto_kode;
            }
            
        }catch(Exception e){
            code ="PM00000001";
        }
        
        model3.addRow( new Object[] {code, idpgl0, idpgl1, namapgl, hargapgl, Jumlah, hargatotal, sekarang});
    }//GEN-LAST:event_btnTambahkanMouseClicked
  
     public void tambahtotalkeranjang(){
        int hasil = 0 ;
        for(int i = 0; i < TabelKeranjang.getRowCount();i++){
            String hht = TabelKeranjang.getValueAt(i, 5).toString();
            if("".equals(hht)){
                hht = "0";
            }
            int ht1 = Integer.parseInt(hht);
             hasil +=  ht1;
        }
        txtTotalHarga.setText(String.valueOf(hasil));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelKeranjang;
    private javax.swing.JTable TabelPertama;
    private javax.swing.JLabel background;
    private javax.swing.JPanel btnTambahkan;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> opsiTabel;
    private javax.swing.JTextField txtBayar;
    private javax.swing.JTextField txtHargaBeli;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtKembalian;
    private javax.swing.JTextField txtPencarian;
    private javax.swing.JTextField txtSupplier;
    private javax.swing.JTextField txtTotalHarga;
    // End of variables declaration//GEN-END:variables
}
