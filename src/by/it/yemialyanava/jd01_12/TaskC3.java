package by.it.yemialyanava.jd01_12;
/*TaskC3. В консоль вводится строка, состоящая из выражений и символов «(», «)»,
        «[», «]», «{», «}».
         Проверьте и выведите в консоль корректность расстановки скобок
        (true или false) с помощью коллекций.*/
import java.util.*;

public class TaskC3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char [] charArray = input.toCharArray();

        Map<Character, Character> bracketsPairs = new HashMap<>();
        bracketsPairs.put('[', ']');
        bracketsPairs.put('(', ')');
        bracketsPairs.put('{', '}');

        Set<Character> openbrackets = bracketsPairs.keySet();

        Set<Character> brackets = new HashSet<>();
        brackets.addAll(openbrackets);
        brackets.addAll(bracketsPairs.values());

        Stack<Character> characterStack = new Stack<>();
        boolean correct = true;

        for (int i = 0; i < charArray.length; i++) {
            char currentChar=charArray[i];
            if (brackets.contains(currentChar)){
                if (openbrackets.contains(currentChar)){
                    characterStack.push(currentChar);
                }else {
                    if (characterStack.size()>0){
                        char lastOpenBracket = characterStack.peek();
                        char etalonCloseBracket = bracketsPairs.get(lastOpenBracket);
                        if (etalonCloseBracket==currentChar){
                            characterStack.pop();
                        }else {
                            correct = false;
                            break;
                        }
                    } else{
                        correct= false;
                        break;
                    }
                }
            }
        }
        if (characterStack.size()>0){
            correct = false;
        }
        System.out.println(correct);
    }
}
