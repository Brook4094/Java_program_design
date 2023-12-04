import java.util.Scanner;

public class simpletronA {
    int opcode;
    int operand;
    int dumped;
    int instructionCnt;
	int accumulator;
	int[] memory;
    Scanner scanner;

	public simpletronA() {
        opcode=0;
        operand=0;
        dumped=0;
        instructionCnt=0;
        accumulator=0;
        memory =new int [100];
        scanner =new Scanner(System.in);
	}
    // the varible a,b,c, will  put in memory index 99,98,97...
    // the first instruction put in memory index 00
    public void programLoad() { 
        memory[0]=1099; // read num into va
        memory[1]=2099; // load a into acc
        memory[2]=4111; // input <0 branch instruction 11 to end
        memory[3]=2199; // store a
        memory[4]=1098; // read num into vb
        memory[5]=2098; // load b into acc
        memory[6]=4111; // input <0 branch instruction 11 to end
        memory[7]=2198; // store b
        memory[8]=2099; // load a into acc
        memory[9]=3098; // a + b;
        memory[10]=4003; // branch to instruction 3
        memory[11]=1199; // end and display 
    }
    public void introduction() {
        System.out.println("this simpletron program read 10 postive number, compute sum and display them");
        System.out.println("this program will keep reading numbers until the user input a negative value");
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
        simpletronA simptr = new simpletronA();
        simptr.programLoad();
        simptr.introduction();
        simptr.runSimletron();
    }
}