import java.util.Scanner;

public class simpletronC {
    int opcode;
    int operand;
    int dumped;
    int instructionCnt;
	int accumulator;
	int[] memory;
    Scanner scanner;

	public simpletronC() {
        opcode=0;
        operand=0;
        dumped=0;
        instructionCnt=0;
        accumulator=0;
        memory =new int [100];
        // in this case we specify memory[99]=1 to do loop control
        memory[99]=1;
        scanner =new Scanner(System.in);
	}
    // memory[98]=remain run times, memory[97]=max, memory[96]=varible a 
    // the first instruction put in memory index 00
    public void programLoad() { 
        memory[0]=1098; // initial remain run times
        memory[1]=2098; // load remain run times
        memory[2]=4116; // if run times <0 end
        memory[3]=4216; // if run times ==0 end
        memory[4]=2098; // load remain run times
        memory[5]=3199; // remain times -1
        memory[6]=4116; // if run times <0 end
        memory[7]=2198; // store remian run times
        memory[8]=1096; // read num 
        memory[9]=2097; // load max
        memory[10]=3196; // max-va
        memory[11]=4113; // if acc <0 means va > max, branch to store new max
        memory[12]=4004; // branch to read next num 
        memory[13]=2096; // load va
        memory[14]=2197; // store va into max
        memory[15]=4004; // branch to read next num 
        memory[16]=1197; // end and display
    }
    public void introduction() {
        System.out.println("this simpletron program read n number, display the largest one");
        System.out.println("the first input is n value, if n value <=0, out put 0");
    }
    public void runSimletron() {
        while(dumped==0) {
            // System.out.println(instructionCnt);
            opcode = memory[instructionCnt]/100;
            operand = memory[instructionCnt]%100;
            switch(opcode) {
                case 10: // read from keyboard to memory
                    memory[operand]=scanner.nextInt();
                    break;
                case 11: // write form memory to screen
                    System.out.println(memory[operand]);
                    dumped=1; // display and stop the simpletron
                    break;
                case 20: // load from memory to acc
                    accumulator=memory[operand];
                    break;
                case 21: // store acc to memory
                    memory[operand]=accumulator;
                    break;
                case 30: // add (memory and acc) 
                    accumulator=accumulator+memory[operand];
                    break;
                case 31: // subtract (memory and acc)
                    accumulator=accumulator-memory[operand];
                    break;
                case 32: // divide (memory and acc)
                    accumulator=accumulator/memory[operand];
                    break;
                case 33: // multiply (memory and acc)
                    accumulator=accumulator*memory[operand];
                    break;
                case 40: // branch
                    instructionCnt=operand-1;
                    break;
                case 41: // branch if acc is negative
                    if(accumulator<0) instructionCnt=operand-1;
                    break;
                case 42: // branch if acc is 0
                    if(accumulator==0) instructionCnt=operand-1;
                    break;
                default :
                    System.out.println("dump");
                    dumped=1;
            }
            instructionCnt++;
        }
    }
    public static void main(String[] args) {
        simpletronC simptr = new simpletronC();
        simptr.programLoad();
        simptr.introduction();
        simptr.runSimletron();
    }
}