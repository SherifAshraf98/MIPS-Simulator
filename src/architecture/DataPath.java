/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package architecture;

import java.util.*;
import javax.swing.*;
import java.awt.*; 

/**
 *
 * @author Qaffas
 */
public class DataPath extends javax.swing.JFrame {
    public static ArrayList<Wires> wires=new ArrayList<Wires>();
    public static ArrayList<RegCl> reg = new ArrayList<RegCl>();
    public static ArrayList<ArrayList<Memory>> mem = new ArrayList<ArrayList<Memory>>();
    public static int key = 0;
    public static int pos = 0;
    public static int rp=0;
    public Wires wp;
   
    /**
     * Creates new form DataPath
     */
    public DataPath() {
        initComponents();
        this.setMaximizedBounds(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds());
        this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
//        AluOp.setText(Integer.toString(Wires.AluOp));
//        AluSrc.setText(Integer.toString(Wires.AluSrc));
//        pc.setText(Integer.toString(Wires.pc));
//        pc4.setText(Integer.toString(Wires.pc4));
//        RegWrite.setText(Integer.toString(Wires.RegWrite));
//        Jump.setText(Integer.toString(Wires.Jump));
//        MemToReg.setText(Integer.toString(Wires.MemToReg));
//        MemWrite.setText(Integer.toString(Wires.MemWrite));
//        MemRead.setText(Integer.toString(Wires.MemRead));
//        Branch.setText(Integer.toString(Wires.Branch));
//        ZeroFlag.setText(Integer.toString(Wires.ZeroFlag));

        drawWires();
        drawReg();
        drawMem();
        
    }
    public static void saveWires(Wires w){
        wires.add(w);
       
    }
    
    public static void saveRegisters(RegCl r){
        reg.add(r);
       /* if(reg.size()>5)
      System.out.println(reg.get(5)[4]);*/
    }
    
    public static void saveMem(ArrayList<Memory> m){
        mem.add(m);
    }
    
    public void drawWires(){
        Wires w = wires.get(key);
         if(key>0)
             wp=wires.get(key-1);
        
        pc.setText(Integer.toString(w.pc));
        pc4.setText(Integer.toString(w.pc4));
        instruction.setText(w.instruction);
        Ins3126.setText(Integer.toString(w.Ins3126));
        Ins2521.setText(Integer.toString(w.Ins2521));
        Ins2016.setText(Integer.toString(w.Ins2016));
        Ins1511.setText(Integer.toString(w.Ins1511));
        Ins150.setText(Integer.toString(w.Ins150));
        Ins50.setText(Integer.toString(w.Ins50));
        Ins250.setText(Integer.toString(w.Ins250));
        ReadData1.setText(Integer.toString(w.ReadData1));
        ReadData2.setText(Integer.toString(w.ReadData2));
        ALUsecond.setText(Integer.toString(w.ALUsecond));
        AluResult.setText(Integer.toString(w.AluResult));
        pcInput.setText(Integer.toString(w.pcInput));
        
        if(w.ZeroFlag != -1)
            ZeroFlag.setText(Integer.toString(w.ZeroFlag));
        else if(w.ZeroFlag == -1 && key==0){
            w.ZeroFlag =0;
            ZeroFlag.setText(Integer.toString(w.ZeroFlag));
        }
        else{
            w.ZeroFlag =wp.ZeroFlag;
            ZeroFlag.setText(Integer.toString(w.ZeroFlag));
        }
            
        if(w.MemRead==1)
          memOut.setText(Integer.toString(w.ReadDataMemory));
       
        else if(w.MemRead==0 && key==0){
         w.ReadDataMemory=0;
         memOut.setText(Integer.toString(w.ReadDataMemory));   
        }
        else {
            w.ReadDataMemory =wp.ReadDataMemory;
            memOut.setText(Integer.toString(w.ReadDataMemory));
        }
        
        
        if(w.MemToReg!=-1)
            MemToReg.setText(Integer.toString(w.MemToReg));
        else if(w.MemToReg==-1 && key==0 ){
            w.MemToReg=0;
            MemToReg.setText(Integer.toString(w.MemToReg));
        }
        else{
            w.MemToReg =wp.MemToReg;
            MemToReg.setText(Integer.toString(w.MemToReg));
        }
            
        
        
        
        if(w.MemToReg != -1)
            MuxMemtoReg.setText(Integer.toString(w.MuxMemtoReg));
        else if(w.MemToReg==-1 && key ==0){
            w.MuxMemtoReg=0;
            MuxMemtoReg.setText("0"); 
        }
        else{
            w.MuxMemtoReg=wp.MuxMemtoReg;
            MuxMemtoReg.setText(Integer.toString(w.MuxMemtoReg));
        }
        
        AndGate.setText(Integer.toString(w.AndGate));
        
   
        
        
        if(w.RegDst!=-1)
            Muxdst.setText(Integer.toString(w.Muxdst));
        else if (w.RegDst==-1 && key==0){
            w.Muxdst=0;
            Muxdst.setText(Integer.toString(w.Muxdst));
        }
        
        else{
            w.Muxdst=wp.Muxdst;
            Muxdst.setText(Integer.toString(w.Muxdst));
        }
        
        
        if(w.RegDst!=-1)
            RegDst.setText(Integer.toString(w.RegDst));
        else if(w.RegDst==-1 && key==0 ){
            w.RegDst=0;
            RegDst.setText(Integer.toString(w.RegDst));
        }
        else{
            w.RegDst=wp.RegDst;
            RegDst.setText(Integer.toString(w.RegDst));
        }
            
        
         if(w.Branch!=-1)
            Branch.setText(Integer.toString(w.Branch));
        else if(w.Branch==-1 && key ==0 ){
            w.Branch=0;
            Branch.setText(Integer.toString(w.Branch));
        }
        else{
            w.Branch=wp.Branch;
            Branch.setText(Integer.toString(w.Branch));
        }
         
         MemRead.setText(Integer.toString(w.MemRead));
         MemWrite.setText(Integer.toString(w.MemWrite));
         
         
         
        if(w.AluOp!=-1)
            AluOp.setText(Integer.toString(w.AluOp));
        else if(w.AluOp==-1 && key==0 ){
            w.AluOp=0;
            AluOp.setText(Integer.toString(w.AluOp));
        }
        else{
            w.AluOp=wp.AluOp;
            AluOp.setText(Integer.toString(w.AluOp));
        }
            
        
        
        
        if(w.AluSrc!=-1)
            AluSrc.setText(Integer.toString(w.AluSrc));
        else if(w.AluSrc==-1 && key==0 ){
            w.AluSrc=0;
            AluSrc.setText(Integer.toString(w.AluSrc));
        }
        else{
            w.AluSrc=wp.AluSrc;
            AluSrc.setText(Integer.toString(w.AluSrc));
        }
        
        RegWrite.setText(Integer.toString(w.RegWrite));
        AluCtrl.setText(Integer.toString(w.AluCtrl));
        Jump.setText(Integer.toString(w.Jump));
        ShiftLeft28.setText(Integer.toString(w.ShiftLeft28));
        ALUsecond.setText(Integer.toString(w.ALUsecond));
        last4.setText(Integer.toString(w.last4));
        jrMux.setText(Integer.toString(w.jrMux));
        jrAnd.setText(Integer.toString(w.jrAnd));
        jalMux.setText(Integer.toString(w.jalMux));
        SignExt.setText(Integer.toString(w.SignExt));
        Jump32.setText(Integer.toString(w.Jump32));
        ShiftLeft32.setText(Integer.toString(w.ShiftLeft32));
        sltSignal.setText(Integer.toString(w.sltSignal));
        sltEx.setText(Integer.toString(w.sltEx));
        sltMux.setText(Integer.toString(w.sltMux));
        lbSignal.setText(Integer.toString(w.lbSignal));
        lb_lwMux.setText(Integer.toString(w.lb_lwMux));
        sb.setText(Integer.toString(w.sb));
    }
    
    public void drawReg(){
        RegCl r = reg.get(key);
        if(reg.size()>5)
      
        zero.setText(Integer.toString(r.ccregisters[0]));
        at.setText(Integer.toString(r.ccregisters[1]));
        v0.setText(Integer.toString(r.ccregisters[2]));
        v1.setText(Integer.toString(r.ccregisters[3]));
        a0.setText(Integer.toString(r.ccregisters[4]));
        a1.setText(Integer.toString(r.ccregisters[5]));
        a2.setText(Integer.toString(r.ccregisters[6]));
        a3.setText(Integer.toString(r.ccregisters[7]));
        t0.setText(Integer.toString(r.ccregisters[8]));
        t1.setText(Integer.toString(r.ccregisters[9]));
        t2.setText(Integer.toString(r.ccregisters[10]));
        t3.setText(Integer.toString(r.ccregisters[11]));
        t4.setText(Integer.toString(r.ccregisters[12]));
        t5.setText(Integer.toString(r.ccregisters[13]));
        t6.setText(Integer.toString(r.ccregisters[14]));
        t7.setText(Integer.toString(r.ccregisters[15]));
        s0.setText(Integer.toString(r.ccregisters[16]));
        s1.setText(Integer.toString(r.ccregisters[17]));
        s2.setText(Integer.toString(r.ccregisters[18]));
        s3.setText(Integer.toString(r.ccregisters[19]));
        s4.setText(Integer.toString(r.ccregisters[20]));
        s5.setText(Integer.toString(r.ccregisters[21]));
        s6.setText(Integer.toString(r.ccregisters[22]));
        s7.setText(Integer.toString(r.ccregisters[23]));
        t8.setText(Integer.toString(r.ccregisters[24]));
        t9.setText(Integer.toString(r.ccregisters[25]));
        k0.setText(Integer.toString(r.ccregisters[26]));
        k1.setText(Integer.toString(r.ccregisters[27]));
        gp.setText(Integer.toString(r.ccregisters[28]));
        sp.setText(Integer.toString(r.ccregisters[29]));
        fp.setText(Integer.toString(r.ccregisters[30]));
        ra.setText(Integer.toString(r.ccregisters[31]));
    }
    
    public void drawMem(){
 
        ArrayList<Memory> m = mem.get(key);
         JLabel[] l = new JLabel[m.size()];
        for(int i=0;i<m.size();i++){
            l[i]=new JLabel("Address: "+m.get(i).address+" Contains: "+BinaryFunctions.binaryToDec(m.get(i).value)); 
            
            jPanel5.add(l[i]);    
        }
        //jPanel5.repaint();
        //jScrollPane2.repaint();
       // this.repaint();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        zero = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        at = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        v0 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        v1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        a0 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        a1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        a2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        a3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        t0 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        t1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        t2 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        t3 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        t4 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        t5 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        t6 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        t7 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        s0 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        s1 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        s2 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        s3 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        s4 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        s5 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        s6 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        s7 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        t8 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        t9 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        k0 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        k1 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        gp = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        sp = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        fp = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        ra = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        pc = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pc4 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        pcInput = new javax.swing.JLabel();
        hgugvmj1 = new javax.swing.JLabel();
        instruction = new javax.swing.JLabel();
        mhvfridj1 = new javax.swing.JLabel();
        Ins3126 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Ins2521 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Ins2016 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        Ins1511 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        MemToReg = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        AluOp = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        AluSrc = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        RegWrite = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        AluCtrl = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        Jump = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        last4 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        Muxdst = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        Jump32 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        Ins250 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        ShiftLeft28 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jrAnd = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jalMux = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jrMux = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        MemRead = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        ZeroFlag = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        MemWrite = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        Branch = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        Ins150 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        Ins50 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        RegDst = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        SignExt = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        ReadData1 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        ReadData2 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        AluResult = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        MuxMemtoReg = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        AndGate = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        AddBranch = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        ALUsecond = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        memOut = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        ShiftLeft32 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        sltSignal = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        sltEx = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        sltMux = new javax.swing.JLabel();
        jl = new javax.swing.JLabel();
        lbSignal = new javax.swing.JLabel();
        jll = new javax.swing.JLabel();
        lb_lwMux = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        sb = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Output");
        setBounds(new java.awt.Rectangle(0, 0, 600, 200));
        setMinimumSize(new java.awt.Dimension(1300, 200));
        setSize(new java.awt.Dimension(600, 200));
        getContentPane().add(jPanel4, java.awt.BorderLayout.EAST);

        jPanel2.setMinimumSize(new java.awt.Dimension(260, 150));
        jPanel2.setPreferredSize(new java.awt.Dimension(807, 60));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        jButton1.setText("Previous Clock Cycle");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);

        jButton2.setText("Next Clock Cycle");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);

        getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new java.awt.GridLayout(32, 2));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("$0");
        jPanel3.add(jLabel1);

        zero.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        zero.setText("0");
        jPanel3.add(zero);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("$at");
        jPanel3.add(jLabel5);

        at.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        at.setText("0");
        jPanel3.add(at);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("$v0");
        jPanel3.add(jLabel6);

        v0.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        v0.setText("0");
        jPanel3.add(v0);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("$v1");
        jPanel3.add(jLabel7);

        v1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        v1.setText("0");
        jPanel3.add(v1);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("$a0");
        jPanel3.add(jLabel8);

        a0.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        a0.setText("0");
        jPanel3.add(a0);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("$a1");
        jPanel3.add(jLabel9);

        a1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        a1.setText("0");
        jPanel3.add(a1);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("$a2");
        jPanel3.add(jLabel10);

        a2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        a2.setText("0");
        jPanel3.add(a2);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("$a3");
        jPanel3.add(jLabel11);

        a3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        a3.setText("0");
        jPanel3.add(a3);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("$t0");
        jPanel3.add(jLabel12);

        t0.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        t0.setText("0");
        jPanel3.add(t0);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("$t1");
        jPanel3.add(jLabel13);

        t1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        t1.setText("0");
        jPanel3.add(t1);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("$t2");
        jPanel3.add(jLabel14);

        t2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        t2.setText("0");
        jPanel3.add(t2);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("$t3");
        jPanel3.add(jLabel15);

        t3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        t3.setText("0");
        jPanel3.add(t3);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("$t4");
        jPanel3.add(jLabel16);

        t4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        t4.setText("0");
        jPanel3.add(t4);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("$t5");
        jPanel3.add(jLabel17);

        t5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        t5.setText("0");
        jPanel3.add(t5);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("$t6");
        jPanel3.add(jLabel18);

        t6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        t6.setText("0");
        jPanel3.add(t6);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("$t7");
        jPanel3.add(jLabel19);

        t7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        t7.setText("0");
        jPanel3.add(t7);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setText("$s0");
        jPanel3.add(jLabel22);

        s0.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        s0.setText("0");
        jPanel3.add(s0);

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel34.setText("$s1");
        jPanel3.add(jLabel34);

        s1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        s1.setText("0");
        jPanel3.add(s1);

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel37.setText("$s2");
        jPanel3.add(jLabel37);

        s2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        s2.setText("0");
        jPanel3.add(s2);

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel38.setText("$s3");
        jPanel3.add(jLabel38);

        s3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        s3.setText("0");
        jPanel3.add(s3);

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel60.setText("$s4");
        jPanel3.add(jLabel60);

        s4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        s4.setText("0");
        jPanel3.add(s4);

        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel61.setText("$s5");
        jPanel3.add(jLabel61);

        s5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        s5.setText("0");
        jPanel3.add(s5);

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel62.setText("$s6");
        jPanel3.add(jLabel62);

        s6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        s6.setText("0");
        jPanel3.add(s6);

        jLabel63.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel63.setText("$s7");
        jPanel3.add(jLabel63);

        s7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        s7.setText("0");
        jPanel3.add(s7);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("$t8");
        jPanel3.add(jLabel20);

        t8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        t8.setText("0");
        jPanel3.add(t8);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("$t9");
        jPanel3.add(jLabel21);

        t9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        t9.setText("0");
        jPanel3.add(t9);

        jLabel64.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel64.setText("$k0");
        jPanel3.add(jLabel64);

        k0.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        k0.setText("0");
        jPanel3.add(k0);

        jLabel65.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel65.setText("$k1");
        jPanel3.add(jLabel65);

        k1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        k1.setText("0");
        jPanel3.add(k1);

        jLabel66.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel66.setText("$gp");
        jPanel3.add(jLabel66);

        gp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        gp.setText("0");
        jPanel3.add(gp);

        jLabel67.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel67.setText("$sp");
        jPanel3.add(jLabel67);

        sp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sp.setText("0");
        jPanel3.add(sp);

        jLabel68.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel68.setText("$fp");
        jPanel3.add(jLabel68);

        fp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        fp.setText("0");
        jPanel3.add(fp);

        jLabel69.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel69.setText("$ra");
        jPanel3.add(jLabel69);

        ra.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ra.setText("0");
        jPanel3.add(ra);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.GridLayout(45, 2, 15, 0));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(204, 0, 0));
        jLabel33.setText("PC");
        jPanel1.add(jLabel33);

        pc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pc.setForeground(new java.awt.Color(204, 0, 0));
        pc.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        pc.setText("0");
        jPanel1.add(pc);

        jLabel2.setFont(jLabel2.getFont().deriveFont(jLabel2.getFont().getStyle() | java.awt.Font.BOLD, 14));
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setText("PC+4");
        jPanel1.add(jLabel2);

        pc4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pc4.setForeground(new java.awt.Color(0, 0, 255));
        pc4.setText("0");
        jPanel1.add(pc4);

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(204, 0, 0));
        jLabel57.setText("Pc input");
        jPanel1.add(jLabel57);

        pcInput.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pcInput.setForeground(new java.awt.Color(204, 0, 0));
        pcInput.setText("0");
        jPanel1.add(pcInput);

        hgugvmj1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        hgugvmj1.setForeground(new java.awt.Color(0, 0, 255));
        hgugvmj1.setText("Instruction");
        jPanel1.add(hgugvmj1);

        instruction.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        instruction.setForeground(new java.awt.Color(0, 0, 255));
        instruction.setText("0");
        jPanel1.add(instruction);

        mhvfridj1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        mhvfridj1.setForeground(new java.awt.Color(204, 0, 0));
        mhvfridj1.setText("OP code");
        jPanel1.add(mhvfridj1);

        Ins3126.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Ins3126.setForeground(new java.awt.Color(204, 0, 0));
        Ins3126.setText("0");
        jPanel1.add(Ins3126);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        jLabel3.setText("Rs");
        jPanel1.add(jLabel3);

        Ins2521.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Ins2521.setForeground(new java.awt.Color(0, 0, 255));
        Ins2521.setText("0");
        jPanel1.add(Ins2521);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 0, 0));
        jLabel4.setText("Rt");
        jPanel1.add(jLabel4);

        Ins2016.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Ins2016.setForeground(new java.awt.Color(204, 0, 0));
        Ins2016.setText("0");
        jPanel1.add(Ins2016);

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(0, 0, 255));
        jLabel39.setText("Rd");
        jPanel1.add(jLabel39);

        Ins1511.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Ins1511.setForeground(new java.awt.Color(0, 0, 255));
        Ins1511.setText("0");
        jPanel1.add(Ins1511);

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(204, 0, 0));
        jLabel23.setText("MemtoReg");
        jPanel1.add(jLabel23);

        MemToReg.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        MemToReg.setForeground(new java.awt.Color(204, 0, 0));
        MemToReg.setText("0");
        jPanel1.add(MemToReg);

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 255));
        jLabel24.setText("ALUOp");
        jPanel1.add(jLabel24);

        AluOp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AluOp.setForeground(new java.awt.Color(0, 0, 255));
        AluOp.setText("0");
        jPanel1.add(AluOp);

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(204, 0, 0));
        jLabel25.setText("ALUSrc");
        jPanel1.add(jLabel25);

        AluSrc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AluSrc.setForeground(new java.awt.Color(204, 0, 0));
        AluSrc.setText("0");
        jPanel1.add(AluSrc);

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 0, 255));
        jLabel26.setText("RegWrite");
        jPanel1.add(jLabel26);

        RegWrite.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        RegWrite.setForeground(new java.awt.Color(0, 0, 255));
        RegWrite.setText("0");
        jPanel1.add(RegWrite);

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(204, 0, 0));
        jLabel27.setText("ALU control output");
        jPanel1.add(jLabel27);

        AluCtrl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AluCtrl.setForeground(new java.awt.Color(204, 0, 0));
        AluCtrl.setText("0");
        jPanel1.add(AluCtrl);

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 0, 255));
        jLabel28.setText("Jump");
        jPanel1.add(jLabel28);

        Jump.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Jump.setForeground(new java.awt.Color(0, 0, 255));
        Jump.setText("0");
        jPanel1.add(Jump);

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(204, 0, 0));
        jLabel29.setText("Jump last 4");
        jPanel1.add(jLabel29);

        last4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        last4.setForeground(new java.awt.Color(204, 0, 0));
        last4.setText("0");
        jPanel1.add(last4);

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 0, 255));
        jLabel30.setText("Reg Mux output");
        jPanel1.add(jLabel30);

        Muxdst.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Muxdst.setForeground(new java.awt.Color(0, 0, 255));
        Muxdst.setText("0");
        jPanel1.add(Muxdst);

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(204, 0, 0));
        jLabel31.setText("Jump 32");
        jPanel1.add(jLabel31);

        Jump32.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Jump32.setForeground(new java.awt.Color(204, 0, 0));
        Jump32.setText("0");
        jPanel1.add(Jump32);

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 0, 255));
        jLabel32.setText("Jump 26 bits");
        jPanel1.add(jLabel32);

        Ins250.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Ins250.setForeground(new java.awt.Color(0, 0, 255));
        Ins250.setText("0");
        jPanel1.add(Ins250);

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(204, 0, 0));
        jLabel35.setText("Shift 2 jump");
        jPanel1.add(jLabel35);

        ShiftLeft28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ShiftLeft28.setForeground(new java.awt.Color(204, 0, 0));
        ShiftLeft28.setText("0");
        jPanel1.add(ShiftLeft28);

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 0, 255));
        jLabel36.setText("Rtype And Output");
        jPanel1.add(jLabel36);

        jrAnd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jrAnd.setForeground(new java.awt.Color(0, 0, 255));
        jrAnd.setText("0");
        jPanel1.add(jrAnd);

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(204, 0, 0));
        jLabel40.setText("JAL Mux Output");
        jPanel1.add(jLabel40);

        jalMux.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jalMux.setForeground(new java.awt.Color(204, 0, 0));
        jalMux.setText("0");
        jPanel1.add(jalMux);

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(0, 0, 255));
        jLabel41.setText("JR Mux Output");
        jPanel1.add(jLabel41);

        jrMux.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jrMux.setForeground(new java.awt.Color(0, 0, 255));
        jrMux.setText("0");
        jPanel1.add(jrMux);

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(204, 0, 0));
        jLabel42.setText("MemRead");
        jPanel1.add(jLabel42);

        MemRead.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        MemRead.setForeground(new java.awt.Color(204, 0, 0));
        MemRead.setText("0");
        jPanel1.add(MemRead);

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(0, 0, 255));
        jLabel43.setText("ZeroFlag");
        jPanel1.add(jLabel43);

        ZeroFlag.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ZeroFlag.setForeground(new java.awt.Color(0, 0, 255));
        ZeroFlag.setText("0");
        jPanel1.add(ZeroFlag);

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(204, 0, 0));
        jLabel44.setText("MemWrite");
        jPanel1.add(jLabel44);

        MemWrite.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        MemWrite.setForeground(new java.awt.Color(204, 0, 0));
        MemWrite.setText("0");
        jPanel1.add(MemWrite);

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(0, 0, 255));
        jLabel45.setText("Branch");
        jPanel1.add(jLabel45);

        Branch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Branch.setForeground(new java.awt.Color(0, 0, 255));
        Branch.setText("0");
        jPanel1.add(Branch);

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(204, 0, 0));
        jLabel46.setText("16 Bit");
        jPanel1.add(jLabel46);

        Ins150.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Ins150.setForeground(new java.awt.Color(204, 0, 0));
        Ins150.setText("0");
        jPanel1.add(Ins150);

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(0, 0, 255));
        jLabel47.setText("Function Code");
        jPanel1.add(jLabel47);

        Ins50.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Ins50.setForeground(new java.awt.Color(0, 0, 255));
        Ins50.setText("0");
        jPanel1.add(Ins50);

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(204, 0, 0));
        jLabel48.setText("RegDst");
        jPanel1.add(jLabel48);

        RegDst.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        RegDst.setForeground(new java.awt.Color(204, 0, 0));
        RegDst.setText("0");
        jPanel1.add(RegDst);

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(0, 0, 255));
        jLabel49.setText("Sign Extend");
        jPanel1.add(jLabel49);

        SignExt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SignExt.setForeground(new java.awt.Color(0, 0, 255));
        SignExt.setText("0");
        jPanel1.add(SignExt);

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(204, 0, 0));
        jLabel50.setText("Read Data 1");
        jPanel1.add(jLabel50);

        ReadData1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ReadData1.setForeground(new java.awt.Color(204, 0, 0));
        ReadData1.setText("0");
        jPanel1.add(ReadData1);

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(0, 0, 255));
        jLabel51.setText("Read Data 2");
        jPanel1.add(jLabel51);

        ReadData2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ReadData2.setForeground(new java.awt.Color(0, 0, 255));
        ReadData2.setText("0");
        jPanel1.add(ReadData2);

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(204, 0, 0));
        jLabel52.setText("ALU Result");
        jPanel1.add(jLabel52);

        AluResult.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AluResult.setForeground(new java.awt.Color(204, 0, 0));
        AluResult.setText("0");
        jPanel1.add(AluResult);

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(0, 0, 255));
        jLabel53.setText("MemtoReg mux");
        jPanel1.add(jLabel53);

        MuxMemtoReg.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        MuxMemtoReg.setForeground(new java.awt.Color(0, 0, 255));
        MuxMemtoReg.setText("0");
        jPanel1.add(MuxMemtoReg);

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(204, 0, 0));
        jLabel54.setText("Branch And");
        jPanel1.add(jLabel54);

        AndGate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AndGate.setForeground(new java.awt.Color(204, 0, 0));
        AndGate.setText("0");
        jPanel1.add(AndGate);

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(0, 0, 255));
        jLabel55.setText("Branch Adder");
        jPanel1.add(jLabel55);

        AddBranch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AddBranch.setForeground(new java.awt.Color(0, 0, 255));
        AddBranch.setText("0");
        jPanel1.add(AddBranch);

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(204, 0, 0));
        jLabel56.setText("ALU Second Input");
        jPanel1.add(jLabel56);

        ALUsecond.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ALUsecond.setForeground(new java.awt.Color(204, 0, 0));
        ALUsecond.setText("0");
        jPanel1.add(ALUsecond);

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(0, 0, 255));
        jLabel58.setText("Memory Output");
        jPanel1.add(jLabel58);

        memOut.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        memOut.setForeground(new java.awt.Color(0, 0, 255));
        memOut.setText("0");
        jPanel1.add(memOut);

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(204, 0, 0));
        jLabel59.setText("Shift left 32");
        jPanel1.add(jLabel59);

        ShiftLeft32.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ShiftLeft32.setForeground(new java.awt.Color(204, 0, 0));
        ShiftLeft32.setText("0");
        jPanel1.add(ShiftLeft32);

        jLabel70.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(0, 0, 255));
        jLabel70.setText("SLT Signal");
        jPanel1.add(jLabel70);

        sltSignal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sltSignal.setForeground(new java.awt.Color(0, 0, 255));
        sltSignal.setText("0");
        jPanel1.add(sltSignal);

        jLabel72.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(204, 0, 0));
        jLabel72.setText("SLT Extender");
        jPanel1.add(jLabel72);

        sltEx.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sltEx.setForeground(new java.awt.Color(204, 0, 0));
        sltEx.setText("0");
        jPanel1.add(sltEx);

        jLabel74.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(0, 0, 255));
        jLabel74.setText("SLT Mux");
        jPanel1.add(jLabel74);

        sltMux.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sltMux.setForeground(new java.awt.Color(0, 0, 255));
        sltMux.setText("0");
        jPanel1.add(sltMux);

        jl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jl.setForeground(new java.awt.Color(204, 0, 0));
        jl.setText("Load Byte Signal");
        jPanel1.add(jl);

        lbSignal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbSignal.setForeground(new java.awt.Color(204, 0, 0));
        lbSignal.setText("0");
        jPanel1.add(lbSignal);

        jll.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jll.setForeground(new java.awt.Color(0, 0, 255));
        jll.setText("Load Byte/Word Mux");
        jPanel1.add(jll);

        lb_lwMux.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_lwMux.setForeground(new java.awt.Color(0, 0, 255));
        lb_lwMux.setText("0");
        jPanel1.add(lb_lwMux);

        jLabel71.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(204, 0, 0));
        jLabel71.setText("Store Byte Signal");
        jPanel1.add(jLabel71);

        sb.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sb.setForeground(new java.awt.Color(204, 0, 0));
        sb.setText("0");
        jPanel1.add(sb);

        jScrollPane1.setViewportView(jPanel1);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.LINE_START);

        jScrollPane2.setPreferredSize(new java.awt.Dimension(200, 100));

        jPanel5.setLayout(new java.awt.GridLayout(400, 1));
        jScrollPane2.setViewportView(jPanel5);

        getContentPane().add(jScrollPane2, java.awt.BorderLayout.EAST);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(key>0){
           key--;
           drawWires();
           drawReg();
           jPanel5.removeAll();
  
               jPanel5.setVisible(false);
           drawMem();
           jPanel5.setVisible(true);
           
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(key+1<wires.size()){
        key++;
        drawWires();
        drawReg();
        jPanel5.removeAll();
       jPanel5.setVisible(false);
        drawMem();
        jPanel5.setVisible(true);
        }
    }//GEN-LAST:event_jButton2ActionPerformed
         
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DataPath.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataPath.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataPath.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataPath.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataPath().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ALUsecond;
    private javax.swing.JLabel AddBranch;
    private javax.swing.JLabel AluCtrl;
    private javax.swing.JLabel AluOp;
    private javax.swing.JLabel AluResult;
    private javax.swing.JLabel AluSrc;
    private javax.swing.JLabel AndGate;
    private javax.swing.JLabel Branch;
    private javax.swing.JLabel Ins150;
    private javax.swing.JLabel Ins1511;
    private javax.swing.JLabel Ins2016;
    private javax.swing.JLabel Ins250;
    private javax.swing.JLabel Ins2521;
    private javax.swing.JLabel Ins3126;
    private javax.swing.JLabel Ins50;
    private javax.swing.JLabel Jump;
    private javax.swing.JLabel Jump32;
    private javax.swing.JLabel MemRead;
    private javax.swing.JLabel MemToReg;
    private javax.swing.JLabel MemWrite;
    private javax.swing.JLabel MuxMemtoReg;
    private javax.swing.JLabel Muxdst;
    private javax.swing.JLabel ReadData1;
    private javax.swing.JLabel ReadData2;
    private javax.swing.JLabel RegDst;
    private javax.swing.JLabel RegWrite;
    private javax.swing.JLabel ShiftLeft28;
    protected static javax.swing.JLabel ShiftLeft32;
    protected static javax.swing.JLabel SignExt;
    private javax.swing.JLabel ZeroFlag;
    private javax.swing.JLabel a0;
    private javax.swing.JLabel a1;
    private javax.swing.JLabel a2;
    private javax.swing.JLabel a3;
    private javax.swing.JLabel at;
    private javax.swing.JLabel fp;
    private javax.swing.JLabel gp;
    private javax.swing.JLabel hgugvmj1;
    private javax.swing.JLabel instruction;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jalMux;
    private javax.swing.JLabel jl;
    private javax.swing.JLabel jll;
    private javax.swing.JLabel jrAnd;
    private javax.swing.JLabel jrMux;
    private javax.swing.JLabel k0;
    private javax.swing.JLabel k1;
    private javax.swing.JLabel last4;
    private javax.swing.JLabel lbSignal;
    private javax.swing.JLabel lb_lwMux;
    private javax.swing.JLabel memOut;
    private javax.swing.JLabel mhvfridj1;
    private javax.swing.JLabel pc;
    private javax.swing.JLabel pc4;
    private javax.swing.JLabel pcInput;
    private javax.swing.JLabel ra;
    private javax.swing.JLabel s0;
    private javax.swing.JLabel s1;
    private javax.swing.JLabel s2;
    private javax.swing.JLabel s3;
    private javax.swing.JLabel s4;
    private javax.swing.JLabel s5;
    private javax.swing.JLabel s6;
    private javax.swing.JLabel s7;
    private javax.swing.JLabel sb;
    private javax.swing.JLabel sltEx;
    private javax.swing.JLabel sltMux;
    private javax.swing.JLabel sltSignal;
    private javax.swing.JLabel sp;
    private javax.swing.JLabel t0;
    private javax.swing.JLabel t1;
    private javax.swing.JLabel t2;
    private javax.swing.JLabel t3;
    private javax.swing.JLabel t4;
    private javax.swing.JLabel t5;
    private javax.swing.JLabel t6;
    private javax.swing.JLabel t7;
    private javax.swing.JLabel t8;
    private javax.swing.JLabel t9;
    private javax.swing.JLabel v0;
    private javax.swing.JLabel v1;
    private javax.swing.JLabel zero;
    // End of variables declaration//GEN-END:variables
}
