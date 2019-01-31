package architecture;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Instructions {
     

    // Registers (inputs)
    private int op;
    private int rs;
    private int rt;
    private int rd;
    private int shamt;
    private int funct;
    private int bitConst;
    private int jump;
    private int instructionType;
    private int last4;
    private int instruction;
    Instructions ins;
    public String input;
   
    // Components
    private static int pc;
    private int ic; //Instruction Counter

    public Wires w=new Wires();
    public RegCl r= new RegCl();
    
    Instructions(int y){
    }
    
    Instructions(String input) {

       // Scanner sc = new Scanner(System.in);
        
        //input = sc.next();
        this.input=input;
        this.op = BinaryFunctions.binaryToDecU(BinaryFunctions.toArray(input, 0, 5));
        
            this.rs = BinaryFunctions.binaryToDecU(BinaryFunctions.toArray(input, 6, 10));
            this.rt = BinaryFunctions.binaryToDecU(BinaryFunctions.toArray(input, 11, 15));
        

        
            this.rd = BinaryFunctions.binaryToDecU(BinaryFunctions.toArray(input, 16, 20));
            this.shamt = BinaryFunctions.binaryToDecU(BinaryFunctions.toArray(input, 21, 25));
            this.funct = BinaryFunctions.binaryToDecU(BinaryFunctions.toArray(input, 26, 31));
        

        
            this.bitConst = BinaryFunctions.binaryToDec(BinaryFunctions.toArray(input, 16, 31));
            //We need to keep the signed value of the 16 bit constant

        
            this.jump = BinaryFunctions.binaryToDecU(BinaryFunctions.toArray(input, 6, 31));
        
            
            //this.last4 = BinaryFunctions.binaryToDecU(BinaryFunctions.toArray(input, 0, 4));
            this.instruction = BinaryFunctions.binaryToDecU(BinaryFunctions.toArray(input, 0, 31));
    }

    

    //Setters
    public void SetOP(int op) {
        this.op = op;
    }

    public void Setrs(int rs) {
        this.rs = rs;
    }

    public void Setrt(int rt) {
        this.rt = rt;
    }

    public static void Setpc(int p) throws Exception{
  
        if( p<0 || p%4 !=0 )
            throw new Exception();
       else
            pc = p;
        

    }

    public void Setic(int c) {
        this.ic = c;
    }
    public void Setfunct(int c) {
        this.funct = c;
    }
//     public void SetBranch(int branch){this.branch=branch;}
//     public void Setrd(int RegDst){this.RegDst=RegDst;}
//     public void SetMemRead(int MemRead){this.MemRead=MemRead;}
//     public void SetMemtoReg(int MemtoReg){this.MemtoReg=MemtoReg;}
//     public void SetALUop(int ALUop){this.ALUop=ALUop;}
//     public void SetMemWrite(int MemWrite){this.MemWrite=MemWrite;}
//     public void SetALUsrs(int ALUsrc){this.ALUsrc=ALUsrc;}
//     public void SetRegWrite(int RegWrite){this.RegWrite=RegWrite;}
//     public void SetZeroFlag(int ZeroFlag){this.ZeroFlag=ZeroFlag;}

    //Getters
    public int getOP() {
        return this.op;
    }

    public int getrs() {
        return this.rs;
    }

    public int getrt() {
        return this.rt;
    }
    
    public int getrd() {
        return this.rd;
    }

    public static int getpc() {
        return pc;
    }

    public int getic() {
        return ic;
    }
    public int getfunct() {
        return this.funct;
    }
    
    public int getBitConst(){
        return this.bitConst;
    }
    
    public int getJump(){
        return this.jump;
    }
    //Sherif Added This function
    public int GetinstructionType(){     
        return instructionType;
    }
    
    public int getLast4(){     
        return last4;
    }
    
    public int getInstruction(){     
        return instruction;
    }
//     public int GetBranch(){return this.branch;}
//     public int Getrd(){return this.RegDst;}
//     public int GetMemRead(){return this.MemRead;}
//     public int GetMemtoReg(){return this.MemtoReg;}
//     public int GetALUop(){return this.ALUop;}
//     public int GetMemWrite(){return this.MemWrite;}
//     public int GetALUsrs(){return this.ALUsrc;}
//     public int GetRegWrite(){return this.RegWrite;}
//     public int GetZeroFlag(){return this.ZeroFlag;}
    
    /*
   • Arithmetic:    add =1    R-type   function=32  
                    addi=2    I-type   function=8   
   • Load/Store:    lw=3      I-type   function=35
                    sw=4      I-type   function=43
                    lb=5      I-type   function=32  
                    lbu=6     I-type   function=36
                    sb=7      I-type   function=40
   • Logic:         sll=8     R-type   function=0
                    nor=9     R-type   function=39
   • Control flow:  beq=10    I-type   function=4
                    j=11      J-type   function=2
                    jal=12    J-type   function=3
                    jr=13     R-type   function=8
   • Comparison:    slt=14    R-type   function=42
                    slti=15   I-type   function=10
   */
    
    public void identifyType() throws Exception
    {
 
        
        
        if(this.op==0)
        {
            
            switch (this.funct)
            {
                case 32:  //add
                {
                    this.instructionType=1;
                    break;
                }
                case 0:  //sll
                {
                    this.instructionType=8;
                    break;
                }
                case 39:  //nor
                {
                    this.instructionType=9;
                    break;
                }
                case 8:  //jr
                {
                    this.instructionType=13;
                    break;
                }
                case 42:  //slt
                {
                    this.instructionType=14;
                    break;
                }         
                 default:{
                     throw new Exception();
                }
            }
            Wires.sAluOp=2;
            Wires.sMemToReg=0;
            Wires.sMemWrite=0;
            Wires.sMemRead=0;
            if(this.instructionType !=13){
            Wires.sBranch=0;
            Wires.sAluSrc=0;
            Wires.sRegDst=1;
            Wires.sRegWrite=1;
            Wires.sJump=0;
            Wires.sZeroFlag=0;
            Wires.sjrAnd=1;
            }
        }
        else
        {
            switch(this.op)
                {
                case 8:  //addi
                {
                    this.instructionType=2;
                    break;
                }
                case 35:  //lw
                {
                    this.instructionType=3;
                    break;
                }
                case 43:  //sw
                {
                    this.instructionType=4;
                    break;
                }
                case 32:  //lb
                {
                    this.instructionType=5;
                    break;
                }
                case 36:  //lbu
                {
                    this.instructionType=6;
                    break;
                }
                case 40:  //sb
                {
                    this.instructionType=7;
                    break;
                }
                case 4:  //beq
                {
                    this.instructionType=10;
                    break;
                }
                case 2:  //j
                {
                    this.instructionType=11;
                    break;
                }
                case 3:  //jal
                {
                    this.instructionType=12;
                    break;
                }
                case 10:  //slti:
                {
                    this.instructionType=15;
                    break;
                }
                
                 default:{
                     throw new Exception();
                     
                }
                        
                }
            
            Wires.sMemRead=0;
            Wires.sMemWrite=0;
            Wires.sjrAnd=0;
          if(this.instructionType != 11 && this.instructionType != 12){
          Wires.sBranch=0;
          Wires.sAluSrc=1;
          Wires.sZeroFlag=0;
          Wires.sJump=0;
          }
        }
        
    }
    public void execute(){
        
        try{
        identifyType();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Some of the entered instructions are not supported", "ERROR!",JOptionPane.WARNING_MESSAGE);
            pc=-4;
            return;
        }
        
        Wires.sReadData1=Mem_Reg.registers[rs];
        Wires.sReadData2=Mem_Reg.registers[rt];
        
        switch (this.instructionType){
            case 1:
            {
                this.add();
                break;
            }
            case 2:{
                
                this.addi();
                break;
            }
            case 3:{
                this.lw();
                break;
            }
            case 4:{
                this.sw();
                break;
            }
            case 5:{
                this.lb();
                break;
            }
            case 6:{
                this.lbu();
                break;
            }
            case 7:{
                this.sb();
                break;
            }
            case 8:{
                this.sll();
                break;
            }
            case 9:{
                this.nor();
                break;
            }
            case 10:{
                this.beq();
                break;
            }
            case 11:{
                this.j();
                break;
            }
            case 12:{
                this.jal();
                break;
            }
            case 13:{
                this.jr();
                break;
            }
            case 14:{
                this.slt();
                break;
            }
            case 15:{
                this.slti();
                break;
                
            }
           
                
        }
        ArrayList<Memory> m = new ArrayList<Memory>();
   
        //for(int i=0;i<32;i++) 
        //ccregisters[i]=Mem_Reg.registers[i];
        //DataPath.saveRegisters(this.ccregisters);
        for(int i=0;i<Mem_Reg.memory.size();i++){
            for(int j=0;j<m.size();j++){
                if(Mem_Reg.memory.get(i).address==m.get(j).address){
                    m.remove(j);
                break;
                }
            }
                m.add(Mem_Reg.memory.get(i));
           
        }
        DataPath.saveMem(m);
        
        
        
    }
    public void add(){

        Wires.sAluResult=Mem_Reg.registers[rs]+Mem_Reg.registers[rt];
        Wires.sALUsecond=Mem_Reg.registers[rt];
        Mem_Reg.SetReg(rd, Mem_Reg.registers[rs] + Mem_Reg.registers[rt]);
        pc += 4;
        if(Mem_Reg.registers[rd]==0)
            Wires.sZeroFlag=1;
    }
    public void addi(){
       
        Wires.sAluResult=Mem_Reg.registers[rs]+bitConst;
        Mem_Reg.SetReg(rt, Mem_Reg.registers[rs] +this.bitConst);
        pc += 4;
        if(Mem_Reg.registers[rt]==0)
            Wires.sZeroFlag=1;
        Wires.sAluOp=0;
        Wires.sAluSrc=1;
        Wires.sMemToReg=0;
        Wires.sRegDst=0;
        Wires.sRegWrite=1;
    }
    
    public void lw(){
        //BinaryFunctions.printNumber(Mem_Reg.getWord(Mem_Reg.registers[rs] + bitConst));
       
        Wires.sAluResult=Mem_Reg.registers[rs]+bitConst;
        Mem_Reg.SetReg(rt, BinaryFunctions.binaryToDec(Mem_Reg.getWord(Mem_Reg.registers[rs] + bitConst)));
        pc += 4;
        if(Mem_Reg.registers[rs]+bitConst==0)
            Wires.sZeroFlag=1;
        Wires.sAluOp=0;
        Wires.sAluSrc=1;
        Wires.sMemToReg=1;
        Wires.sRegDst=0;
        Wires.sRegWrite=1;
        Wires.sMemRead=1;
     
    }
    public void sw(){
        Wires.sAluResult=Mem_Reg.registers[rs]+bitConst;
       
        //System.out.println(rs);
        Mem_Reg.addWord(Mem_Reg.registers[rs] + bitConst, Mem_Reg.registers[rt]);
        pc += 4;
        if(Mem_Reg.registers[rs]+bitConst==0)
            Wires.sZeroFlag=1;
        Wires.sAluOp=0;
        Wires.sAluSrc=1;
        Wires.sRegWrite=0;
        Wires.sMemWrite=1;
        Wires.sMemRead=0;
        Wires.sMemToReg=-1;
        Wires.sRegDst=-1;
       
    }
    public void lb(){
        Wires.sAluResult=Mem_Reg.registers[rs]+bitConst;
        Mem_Reg.SetReg(rt, BinaryFunctions.binaryToDec(Mem_Reg.getByte(Mem_Reg.registers[rs] + bitConst)));
        pc += 4;
         if(Mem_Reg.registers[rt]+bitConst==0)
            Wires.sZeroFlag=1;
        Wires.sAluOp=0;
        Wires.sAluSrc=1;
        Wires.sMemToReg=1;
        Wires.sRegDst=0;
        Wires.sRegWrite=1;
        Wires.sMemRead=1;
        
        
    }
    public void lbu(){
       Wires.sAluResult=Mem_Reg.registers[rs]+bitConst;
        Mem_Reg.SetReg(rt , BinaryFunctions.binaryToDecU(Mem_Reg.getByte(Mem_Reg.registers[rs] + bitConst)));
        pc += 4;
         if(Mem_Reg.registers[rs]+bitConst==0)
            Wires.sZeroFlag=1;
        Wires.sAluOp=0;
        Wires.sAluSrc=1;
        Wires.sMemToReg=1;
        Wires.sRegDst=0;
        Wires.sRegWrite=1;
        Wires.sMemRead=1;
    }
    public void sb(){
       Wires.sAluResult=Mem_Reg.registers[rs]+bitConst;
        Mem_Reg.addByte(Mem_Reg.registers[rs]+bitConst,Mem_Reg.registers[rt]);
        pc += 4;
        if(Mem_Reg.registers[rs]+bitConst==0)
            Wires.sZeroFlag=1;
        Wires.sAluOp=0;
        Wires.sAluSrc=1;
        Wires.sRegWrite=0;
        Wires.sMemWrite=1;
        Wires.sMemToReg=-1;
        Wires.sRegDst=-1;
        

    }
    public void sll(){
       
        Wires.sALUsecond=Mem_Reg.registers[rt];
        Mem_Reg.SetReg(rd,(int) (Mem_Reg.registers[rt]*(Math.pow(2,this.shamt))));
        pc += 4;
        if(rd==0)
            Wires.sZeroFlag=1;
    }
    public void nor(){
       
        Wires.sALUsecond=Mem_Reg.registers[rt];
        Mem_Reg.SetReg(rd,~(Mem_Reg.registers[rs] | Mem_Reg.registers[rt]));
        pc += 4;
        if(rd==0)
            Wires.sZeroFlag=1;
    }
    public void beq(){
       
        if(Mem_Reg.registers[rs] - Mem_Reg.registers[rt]==0){
              Wires.sZeroFlag=1;
              pc+= (this.bitConst)*4;
              Wires.spcInput=pc;
        }
        pc+=4;
        Wires.spcInput=pc;
        
        
        Wires.sAluOp=1;
        Wires.sAluSrc=0;
        Wires.sRegWrite=0;
        Wires.sBranch=1;   
        Wires.sMemToReg=-1;
        Wires.sRegDst=-1;
    }
    public void j(){
        Wires.sJump= 1;
        Wires.sRegWrite=0;
        pc= (this.jump*4);
        Wires.spcInput=pc;
        Wires.sMemToReg=-1;
        Wires.sRegDst=-1;
        Wires.sZeroFlag=-1;
        Wires.sBranch=-1;
        Wires.sAluOp=-1;
        Wires.sAluSrc=-1;
        
    }
    public void jal(){
        Wires.sJump= 1;
        Wires.sRegWrite=1;
        Mem_Reg.registers[31]=pc+4;
        pc = (this.jump*4); 
        Wires.spcInput=pc;
       // Wires.sMemToReg=-1;
        Wires.sRegDst=2;
        //Wires.sZeroFlag=-1;
        //Wires.sBranch=-1;
        //Wires.sAluOp=-1;
        Wires.sAluSrc=-1;
    }
    public void jr(){
        Wires.sJump= 1;
        Wires.sRegWrite=0;
        Wires.sRegDst=-1;
        Wires.sZeroFlag=-1;
        Wires.sBranch=-1;
        Wires.sAluSrc=-1;
        
        pc = Mem_Reg.registers[rs];
        Wires.spcInput=pc;
    }
    public void slt(){
        Wires.sAluResult=Mem_Reg.registers[rs]-Mem_Reg.registers[rt];
        Wires.sALUsecond=Mem_Reg.registers[rt];
        if(Mem_Reg.registers[rs]-Mem_Reg.registers[rt]==0){
            Wires.sZeroFlag=1;
        }
        if(Mem_Reg.registers[rs]<Mem_Reg.registers[rt])
            Mem_Reg.SetReg(rd, 1);
        else
            Mem_Reg.SetReg(rd, 0);
        pc+=4;
        
    }
    public void slti(){
        Wires.sAluResult=Mem_Reg.registers[rs]-bitConst;
        
        if(Mem_Reg.registers[rs]<bitConst)
            Mem_Reg.SetReg(rt, 1);
        else 
            Mem_Reg.SetReg(rt, 0);
        
        if(Mem_Reg.registers[rs]-bitConst==0){
            Wires.sZeroFlag=1;
        }
        pc+=4;
        
        Wires.sAluOp=1;
        Wires.sMemToReg=0;
        Wires.sRegWrite=1;
        Wires.sRegDst=0;
    }

}
