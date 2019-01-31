/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package architecture;

/**
 *
 * @author Sherif Ashraf
 */
public class Wires {
    
    public static int spc;
    public static int spcInput;
    public static String sinstruction;
    public static int sIns3126;
    public static int sIns2521;
    public static int sIns2016;
    public static int sIns1511;
    public static int sIns50;
    public static int sIns250; 
    public static int sIns150;
    public static int sMuxdst;      //wire contains the destination register
    public static int spc4;         //wire out from adder that adds pc+4
    public static int slast4;        //wire contains last 4 bits to be concatenated in jump instructions
    public static int sShiftLeft28;  //wire contains 28 bits after 26 to jump instrucyion
    public static int sJump32;       //wire contains 28bits(shiftleft28) concatenated with 4 bits(last4)
    public static int sSignExt;     //wire contains 32 after 16
    public static int sReadData1;   //wire contains value in register1
    public static int sReadData2;   //wire contains value in register2
    public static int sMuxSrc;     //wire contains whether register2 or 32bits sign extended enters ALU
    public static int sAluCtrl;      //wire out from ALU CONTROL
    public static int sAluResult;  //wire out from ALU
    public static int sReadDataMemory; //wire out from Data Memory(in load)
    public static int sMuxMemtoReg;  //wire contains whether data from memory or from Alu that goes to Resgisters Memory
    public static int sShiftLeft32; //wire contains 32 bits from Sign Extend in beq/bne instruction
    public static int sAddBranch;    //wire out from ALU that takes pc+4 andshiftleft32
    public static int sAndGate;      //wire out from And gate
    //public int MuxAnd;     //wire out from Mux with control And that used in branch instructions
    //public int MuxJump;//drawn       //wire out from Mux with jump control that used in jump instructions
    public static int sAluOp;
    public static int sAluSrc;
    public static int sMemToReg;
    public static int sRegDst;
    public static int sRegWrite;
    public static int sBranch;               
    public static int sJump;
    public static int sZeroFlag;  
    public static int sMemWrite;
    public static int sMemRead;
    public static int sALUsecond;
    public static int sjrMux;
    public static int sjrAnd;
    public static int sjalMux;
    public static int ssltSignal;
    public static int ssltEx;
    public static int ssltMux;
    public static int slbSignal;
    public static int slbMux;
    public static int slb_lwMux;
    public static int ssb;
    
    
    
    
    
    
    public int pc;
    public int pcInput;
    public String instruction;
    public int Ins3126;
    public int Ins2521;
    public int Ins2016;
    public int Ins1511;
    public int Ins50;
    public int Ins250; 
    public int Ins150;
    public int Muxdst;      //wire contains the destination register
    public int pc4;         //wire out from adder that adds pc+4
    public int last4;        //wire contains last 4 bits to be concatenated in jump instructions
    public int ShiftLeft28;  //wire contains 28 bits after 26 to jump instrucyion
    public int Jump32;       //wire contains 28bits(shiftleft28) concatenated with 4 bits(last4)
    public int SignExt;     //wire contains 32 after 16
    public int ReadData1;   //wire contains value in register1
    public int ReadData2;   //wire contains value in register2
    public int MuxSrc;     //wire contains whether register2 or 32bits sign extended enters ALU
    public int AluCtrl;      //wire out from ALU CONTROL
    public int AluResult;  //wire out from ALU
    public int ReadDataMemory; //wire out from Data Memory(in load)
    public int MuxMemtoReg;  //wire contains whether data from memory or from Alu that goes to Resgisters Memory
    public int ShiftLeft32; //wire contains 32 bits from Sign Extend in beq/bne instruction
    public int AddBranch;    //wire out from ALU that takes pc+4 andshiftleft32
    public int AndGate;      //wire out from And gate
    //public int MuxAnd;     //wire out from Mux with control And that used in branch instructions
    //public int MuxJump;//drawn       //wire out from Mux with jump control that used in jump instructions
    public int AluOp;
    public int AluSrc;
    public int MemToReg;
    public int RegDst;
    public int RegWrite;
    public int Branch;               
    public int Jump;
    public int ZeroFlag;  
    public int MemWrite;
    public int MemRead;
    public int ALUsecond;
    public int jrMux;
    public int jrAnd;
    public int jalMux;
    public int sltSignal;
    public int sltEx;
    public int sltMux;
    public int lbSignal;
    public int lbMux;
    public int lb_lwMux;
    public int sb;

    public void SetWires(Instructions ins) {
        Wires w = new Wires();
        Wires.sIns3126=ins.getOP();
        Wires.sIns2521=ins.getrs();
        Wires.sIns2016=ins.getrt();
        Wires.sIns1511=ins.getrd();
        Wires.sIns150=ins.getBitConst();
        Wires.sIns50=ins.getfunct();
        Wires.sIns250=ins.getJump();
        Wires.spc=ins.getic();
        Wires.spc4=ins.getic()+4;
        
        Wires.sShiftLeft28=Wires.sIns250 *4;
        
        int[] t1=BinaryFunctions.decToBinary(ins.getBitConst(),32);
             
        
        Wires.sSignExt=BinaryFunctions.binaryToDec(t1);
        Wires.sShiftLeft32=Wires.sSignExt*4;
        Wires.sAddBranch=Wires.spc4+Wires.sShiftLeft32;
        Wires.sinstruction=ins.input;
        
        

        
        
        Wires.sReadData1=Wires.sReadData1;
        Wires.sReadData2=Wires.sReadData2;
        Wires.sAluResult=Wires.sAluResult;
        Wires.sALUsecond=Wires.sALUsecond;
        Wires.sjrAnd=Wires.sjrAnd;
        Wires.ssb=0;
        
        if(Wires.sAluResult<0)
            Wires.ssltEx=1;
        else
            Wires.ssltEx=0;
       

       int[]t2=BinaryFunctions.db(Wires.spc4);

        int t3[]=new int[4];
        for(int i=0;i<4;i++){
            t3[i]=t2[i];
            
        }
        
       int[] j= BinaryFunctions.decToBinary(Wires.sShiftLeft28,32);
       
       for(int i=0;i<4;i++){
            j[i]=t3[i];
            
        }
        Wires.sJump32=BinaryFunctions.binaryToDecU(j);
        Wires.slast4=BinaryFunctions.binaryToDecU(t3);
        Wires.slbSignal=0;
        
        
        switch(ins.GetinstructionType()){
            case 1:
                Wires.ssltSignal=0;
                Wires.sMuxdst=ins.getrd();
                Wires.sAluCtrl=2;
                Wires.sMuxMemtoReg=Wires.sAluResult;
                Wires.sjalMux=Wires.sAluResult;
                Wires.ssltMux=Wires.sAluResult;
                Wires.spcInput=Wires.spc4;
                Wires.sjrMux=Wires.spcInput;
                break;
                
            case 2:
                Wires.ssltSignal=0;
                Wires.sMuxdst=ins.getrt();
                Wires.sAluCtrl=0;
                Wires.sMuxMemtoReg=Wires.sAluResult;
                Wires.sjalMux=Wires.sAluResult;
                Wires.ssltMux=Wires.sAluResult;
                Wires.spcInput=Wires.spc4;
                Wires.sjrMux=Wires.spcInput;
                Wires.sALUsecond=Wires.sSignExt;
                break;
                
                case 3:
                Wires.ssltSignal=0;
                Wires.sMuxdst=ins.getrt();
                Wires.sReadDataMemory=Mem_Reg.registers[ins.getrt()];
                Wires.sMuxMemtoReg=Mem_Reg.registers[ins.getrt()];
                Wires.sjalMux=Wires.sMuxMemtoReg;
                Wires.ssltMux=Wires.sMuxMemtoReg;
                Wires.spcInput=Wires.spc4;
                Wires.sjrMux=Wires.spcInput;
                Wires.sALUsecond=Wires.sSignExt;
                Wires.slb_lwMux=Mem_Reg.registers[ins.getrt()];
                break;
                
                case 4:
                Wires.spcInput=Wires.spc4;
                Wires.sjrMux=Wires.spcInput;
                Wires.sALUsecond=Wires.sSignExt;
                break;
                
                case 5: //lb
                    Wires.slbSignal=1;
                    Wires.sReadDataMemory=BinaryFunctions.binaryToDec(Mem_Reg.getWord(Wires.sAluResult));
                    Wires.sMuxMemtoReg=Mem_Reg.registers[ins.getrt()];
                     Wires.sMuxdst=ins.getrt();
                    Wires.sjalMux=Wires.sMuxMemtoReg;
                    Wires.ssltMux=Wires.sMuxMemtoReg;
                    Wires.spcInput=Wires.spc4;
                    Wires.sjrMux=Wires.spcInput;
                    Wires.sALUsecond=Wires.sSignExt;
                    Wires.slbSignal=1;
                    Wires.slbMux=Mem_Reg.registers[ins.getrt()];
                    Wires.slb_lwMux=Mem_Reg.registers[ins.getrt()];
                    break;
                    
                case 6: //lbu
                    Wires.sReadDataMemory=BinaryFunctions.binaryToDec(Mem_Reg.getWord(Wires.sAluResult));
                    Wires.sMuxMemtoReg=Mem_Reg.registers[ins.getrt()];
                    Wires.ssltSignal=0;
                    Wires.sMuxdst=ins.getrt();
                    Wires.sjalMux=Wires.sMuxMemtoReg;
                    Wires.ssltMux=Wires.sMuxMemtoReg;
                    Wires.spcInput=Wires.spc4;
                    Wires.sjrMux=Wires.spcInput;
                    Wires.sALUsecond=Wires.sSignExt;
                    Wires.slbSignal=1;
                    Wires.slbMux=BinaryFunctions.binaryToDec(Mem_Reg.getByte(Wires.sAluResult));
                    Wires.slb_lwMux=Mem_Reg.registers[ins.getrt()];
                    break;
                
                case 7: //sb
                     Wires.spcInput=Wires.spc4;
                     Wires.sjrMux=Wires.spcInput;
                     Wires.sALUsecond=Wires.sSignExt;
                     Wires.ssb=1;
                    break;
                
                case 8:
                Wires.ssltSignal=0;
                Wires.sMuxdst=ins.getrd();
                Wires.sAluResult=Mem_Reg.registers[ins.getrd()];
                Wires.sMuxMemtoReg=Wires.sAluResult;
                Wires.sjalMux=Wires.sAluResult;
                Wires.ssltMux=Wires.sAluResult;
                Wires.spcInput=Wires.spc4;
                Wires.sALUsecond=Mem_Reg.registers[ins.getrt()];
                Wires.sjrMux=Wires.spcInput;
                break;
                
                case 9:
                Wires.ssltSignal=0;
                Wires.sMuxdst=ins.getrd();
                Wires.sAluResult=Mem_Reg.registers[ins.getrd()];
                Wires.sMuxMemtoReg=Wires.sAluResult;
                Wires.sjalMux=Wires.sAluResult;
                Wires.ssltMux=Wires.sAluResult;
                Wires.sAluCtrl=12;
                Wires.spcInput=Wires.spc4;
                Wires.sALUsecond=Mem_Reg.registers[ins.getrt()];
                Wires.sjrMux=Wires.spcInput;
                break;
                
                case 10:
                Wires.sAluResult=Mem_Reg.registers[ins.getrs()]-Mem_Reg.registers[ins.getrt()];
                Wires.sALUsecond=Mem_Reg.registers[ins.getrt()];
                Wires.sjrMux=Wires.spcInput;
                break;
                
                case 11:
                Wires.sjrMux=Wires.spcInput;
                break; 
                
                case 12: //jal
                Wires.ssltSignal=0;
                Wires.spcInput=Wires.spcInput;
                Wires.sjrMux=Wires.spcInput;
                Wires.sMuxdst=31;
                Wires.sjalMux=Wires.spc4; 
                Wires.ssltMux=Wires.sjalMux;
                
                break;
                
                case 13://jr
                Wires.sjrMux=Wires.spcInput;
                break;
                
                case 14: //slt
                    Wires.ssltSignal=1;
                    Wires.sMuxdst=ins.getrd();
                    Wires.sAluCtrl=7;
                    Wires.sMuxMemtoReg=Wires.sAluResult;
                    Wires.spcInput=Wires.spc4;
                    Wires.sjrMux=Wires.spcInput;
                    Wires.sjalMux=Wires.ssltEx;
                    Wires.ssltMux=Wires.ssltEx;
                    break;
                    
                case 15:
                    Wires.sALUsecond=Wires.sSignExt;
                    Wires.ssltSignal=1;
                    Wires.sMuxdst=ins.getrt();
                    Wires.sMuxMemtoReg=Wires.sAluResult;
                    Wires.spcInput=Wires.spc4;
                    Wires.sjrMux=Wires.spcInput;
                    Wires.sjalMux=Wires.ssltEx;
                    Wires.ssltMux=Wires.ssltEx;
                    break;
        }
        
        
        
        
        
        if(Wires.sZeroFlag==1 && Wires.sBranch ==1)
            Wires.sAndGate=1;
        else 
            Wires.sAndGate=0;
        
        
        
        
    w.pc=Wires.spc;
    w.pcInput=Wires.spcInput;
    w.instruction=Wires.sinstruction;
    w.Ins3126=Wires.sIns3126;
    w.Ins2521=Wires.sIns2521;
    w.Ins2016=Wires.sIns2016;
    w.Ins1511=Wires.sIns1511;
    w.Ins50=Wires.sIns50;
    w.Ins250=Wires.sIns250; 
    w.Ins150=Wires.sIns150;
    w.Muxdst=Wires.sMuxdst;      
    w.pc4=Wires.spc4;         //wire out from adder that adds pc+4
    w.last4=Wires.slast4;        //wire contains last 4 bits to be concatenated in jump instructions
    w.ShiftLeft28=Wires.sShiftLeft28;  
    w.Jump32=Wires.sJump32;       
    w.SignExt=Wires.sSignExt;    
    w.ReadData1=Wires.sReadData1;  
    w.ReadData2=Wires.sReadData2;  
    w.MuxSrc=Wires.sMuxSrc;     
    w.AluCtrl=Wires.sAluCtrl;    
    w.AluResult=Wires.sAluResult;  
    w.ReadDataMemory=Wires.sReadDataMemory;
    w.MuxMemtoReg=Wires.sMuxMemtoReg;  
    w.ShiftLeft32=Wires.sShiftLeft32; 
    w.AddBranch=Wires.sAddBranch;   
    w.AndGate=Wires.sAndGate;      
    w.AluOp=Wires.sAluOp;
    w.AluSrc=Wires.sAluSrc;
    w.MemToReg=Wires.sMemToReg;
    w.RegDst=Wires.sRegDst;
    w.RegWrite=Wires.sRegWrite;
    w.Branch=Wires.sBranch;               
    w.Jump=Wires.sJump;
    w.ZeroFlag=Wires.sZeroFlag;  
    w.MemWrite=Wires.sMemWrite;
    w.MemRead=Wires.sMemRead;
    w.ALUsecond=Wires.sALUsecond;
    w.jrMux=Wires.sjrMux;
    w.jrAnd=Wires.sjrAnd;
    w.jalMux=Wires.sjalMux;
    w.sltSignal=Wires.ssltSignal;
    w.sltEx=Wires.ssltEx;
    w.sltMux=Wires.ssltMux;
    w.lbSignal=Wires.slbSignal;
    w.lbMux=Wires.slbMux;    
    w.lb_lwMux=Wires.slb_lwMux;
    w.sb=Wires.ssb;
        
       DataPath.saveWires(w);
    }
}
