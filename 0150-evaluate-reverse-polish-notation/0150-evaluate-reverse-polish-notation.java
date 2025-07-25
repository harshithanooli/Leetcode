class Solution {
    public int evalRPN(String[] tokens) {
        HashSet<String> operators =  new HashSet<>();

        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");

        Stack<Integer> operands = new Stack<>();

        for(int i=0;i<tokens.length;i++){
            if(operators.contains(tokens[i])){
                int operand1 = operands.pop();
                int operand2 = operands.pop();
                switch (tokens[i]){
                    case "+":
                        operands.push(operand2+operand1);
                        break;
                    case "-":
                        operands.push(operand2-operand1);
                        break;
                    case "*":
                        operands.push(operand2*operand1);
                        break;
                    case "/":
                        operands.push(operand2/operand1);
                        break;
                }
            }
            else{
                operands.push(Integer.valueOf(tokens[i]));
            }
        }

        return operands.pop();
    }
}