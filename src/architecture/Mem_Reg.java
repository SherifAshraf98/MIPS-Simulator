package architecture;
import java.util.*;
import javax.swing.JOptionPane;

class Memory{
    int value[] = new int[8];
    int address;
    public Memory(int address, int value[]){
        this.value = value;
        this.address = address;
    }
}

public class Mem_Reg {
   public static int[] registers = new int[32];
   //public int[] ccregisters= new int[32];
 
    //public ArrayList<Memory> smemory = new ArrayList<Memory>();
    public static ArrayList<Memory> memory = new ArrayList<Memory>();
    

    public static void addValuesToMemory(){
       registers[29]=1048576;
     while(true){
         Scanner sc = new Scanner(System.in);
         System.out.println("Please enter Memory Address OR  enter -1 to exit: ");
         int s=sc.nextInt();
         if(s == -1){
           break;
         }
         if (s% 4 != 0 && s != 0 && s != -1) {
             System.out.println("Address is not a multiple of 4, please enter a correct address");
             continue;
         }
         
         
         System.out.println("Please enter the value: ");
         int value=sc.nextInt();
         
         Mem_Reg.addWord(s, value);
     }
    }
   public static void addByte(int address, int value){
    //Mem_Reg.memory[address] = BinaryFunctions.decToBinary(value, 8);
    Mem_Reg.memory.add(new Memory(address ,BinaryFunctions.decToBinary(value, 8)));
}
   public static int[] getByte(int address){
       //return memory[address];
       for (int i = 0; i < Mem_Reg.memory.size(); i++){
           if (Mem_Reg.memory.get(i).address == address){
               return Mem_Reg.memory.get(i).value;
           }
       }
       return BinaryFunctions.decToBinary(0, 8);
   }
   public static void addWord(int address, int value){
       if (address % 4 != 0 && address != 0) JOptionPane.showMessageDialog(null, "Word address is not a multiple of 4","Error",JOptionPane.WARNING_MESSAGE);
       else{
           for (int i = 0; i < 4; i++){
           addByte(address + i, BinaryFunctions.binaryToDec(BinaryFunctions.getBits(BinaryFunctions.decToBinary(value, 32), 0 + i * 8 , 7 + i * 8)));
           }
       }
   }
   public static int[] getWord(int address){
       int array[] = new int[32];
//       for (int i = 0; i < 8; i++){
//           array[i] = memory[address][i];
//       }
//       for (int i = 0; i < 8; i++){
//           array[i + 8] = memory[address + 1][i];
//       }
//       for (int i = 0; i < 8; i++){
//           array[i + 16] = memory[address + 2][i];
//       }
//       for (int i = 0; i < 8; i++){
//           array[i + 24] = memory[address + 3][i];
//       }
for (int i = 0; i < 8; i++){
           array[i] = getByte(address)[i];
       }
       for (int i = 0; i < 8; i++){
           array[i + 8] = getByte(address + 1)[i];
       }
       for (int i = 0; i < 8; i++){
           array[i + 16] = getByte(address + 2)[i];
       }
       for (int i = 0; i < 8; i++){
           array[i + 24] = getByte(address + 3)[i];
       }
       return array;
   }
     
     
   
   
    
    public static void SetReg(int index,int value){
        if (index==0){
            JOptionPane.showMessageDialog(null, "Register 0 can't be modified","Error",JOptionPane.WARNING_MESSAGE);
        }
        else
            registers[index]=value;
   
    }
    
     /*public static void printReg ()
    {
        
        for (int i = 0; i < registers.length; i++)
        {
            
            switch (i) //6
            {
                case 0:
                {
                   System.out.println("$Zero"+"\t"+0);
                   break;
                }
                case 1:
                {
                   System.out.println("$at"+"\t"+registers[i]);
                   break;
                }
                case 28:
                {
                   System.out.println("$gp"+"\t"+registers[i]);
                   break;
                }
                case 29:
                {
                   System.out.println("$sp"+"\t"+registers[i]);
                   break;
                }
                case 30:
                {
                   System.out.println("$fp"+"\t"+registers[i]);
                   break;
                }
                case 31:
                {
                   System.out.println("$ra"+"\t"+registers[i]);
                   break;
                }   
            }
            if(i==2||i==3) //2
            {
                System.out.println("$v"+(i-2)+"\t"+registers[i]);
            }
            if(i>=4&&i<=7) //4
            {
                System.out.println("$a"+(i-4)+"\t"+registers[i]);
            }
            if(i>=8&&i<=15) //8
            {
                System.out.println("$t"+(i-8)+"\t"+registers[i]);
            }
            if(i>=16&&i<=23) //8
            {
                System.out.println("$s"+(i-16)+"\t"+registers[i]);
            }
            if(i==24||i==25) //2
            {
                System.out.println("$t"+(i-16)+"\t"+registers[i]);
            }
            if(i==26||i==27) //2
            {
                System.out.println("$k"+(i-26)+"\t"+registers[i]);
            }
                        
        }
    }*/
    
}
