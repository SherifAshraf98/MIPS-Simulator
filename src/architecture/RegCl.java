package architecture;

public class RegCl {
    
    int[] ccregisters= new int[32];
   
        public void setReg(Instructions ins){
             RegCl r = new RegCl();
            for(int i=0;i<32;i++){
                r.ccregisters[i]=Mem_Reg.registers[i];
            }
            DataPath.saveRegisters(r);
        }
}
