class Spreadsheet {
    HashMap<String,Integer> sheet;

    public Spreadsheet(int rows) {
        sheet = new HashMap<String,Integer>();
    }
    
    public void setCell(String cell, int value) {
        sheet.put(cell,value); 
    }
    
    public void resetCell(String cell) {
        sheet.put(cell,0); 
    }
    
    public int getValue(String formula) {
        int equalToIndex = formula.indexOf('=');
        int plusIndex = formula.indexOf('+');
        int result=0;
        String firstOperand  = formula.substring(equalToIndex+1, plusIndex);
        String secondOperand = formula.substring(plusIndex+1, formula.length());

        if(firstOperand.charAt(0)>='A' && firstOperand.charAt(0)<='Z'){
            
            result = sheet.getOrDefault(firstOperand,0);
        }
        else{
            int number = Integer.valueOf(firstOperand);
            result = number;
        }

         if(secondOperand.charAt(0)>='A' && secondOperand.charAt(0)<='Z'){
            
            result += sheet.getOrDefault(secondOperand,0);
        }
        else{
            int number = Integer.valueOf(secondOperand);
            result += number;
        }

        return result;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */