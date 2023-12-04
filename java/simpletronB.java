import java.util.Scanner;

public class simpletronB {
    int opcode;
    int operand;
    int dumped;
    int instructionCnt;
	int accumulator;
	int[] memory;
    Scanner scanner;

	public simpletronB() {
        opcode=0;
        operand=0;
        dumped=0;
        instructionCnt=0;
        accumulator=0;
        memory =new int [100];
        // in this case we specify memory[99]=7, memory[98]=1 to do counter control loop 
        memory[99]=7;
        memory[98]=1; 
        scanner =new Scanner(System.in);
	}
    // memory[99]=7, memory[98]=1, memory[97]=remain run times, memory[96]=result, memory[95]= virible a
    // the first instruction put in memory index 00
    public void programLoad() { 
        memory[0]=2099; // load 7
        memory[1]=2197; // initial remain run times
        memory[2]=2097; // load remain run times <-
        memory[3]=3198; // -1
        memory[4]=4111; // branch to end if remain run times <0
        memory[5]=2197; // store remian run times
        memory[6]=2096; // load result
        memory[7]=1095; // read num 
        memory[8]=3095; // add
        memory[9]=2196; // store result
        memory[10]=4002; // branch to instruction 2
        memory[11]=2096; // load result
        memory[12]=3299; // compute average
        memory[13]=2196; // store result
        memory[14]=1196; // end and display 
    }
    public void introduction() {
        System.out.println("this simpletron program read 7 number, compute average and display them");
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
                default :
                    System.out.println("dump");
                    dumped=1;
            }
            instructionCnt++;
        }
    }
    public static void main(String[] args) {
        simpletronB simptr = new simpletronB();
        simptr.programLoad();
        simptr.introduction();
        simptr.runSimletron();
    }
}