class Spreadsheet {
    ArrayList<ArrayList<Integer>> sheet;

    public Spreadsheet(int rows) {
        sheet = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<rows+1;i++){
            sheet.add(new ArrayList<Integer>());
            for(int j=0;j<27;j++){
                sheet.get(i).add(0);
            }
        }
    }
    
    public void setCell(String cell, int value) {
       // System.out.println(sheet);
        int column = Integer.valueOf(cell.charAt(0)-'A');
        int row = Integer.valueOf(cell.substring(1,cell.length()));
        sheet.get(row).set(column, value); 
    }
    
    public void resetCell(String cell) {
        int column = Integer.valueOf(cell.charAt(0)-'A');
        int row = Integer.valueOf(cell.substring(1,cell.length()));
        sheet.get(row).set(column, 0); 
    }
    
    public int getValue(String formula) {
        int equalToIndex = formula.indexOf('=');
        int plusIndex = formula.indexOf('+');
        int result=0;
        String firstOperand  = formula.substring(equalToIndex+1, plusIndex);
        String secondOperand = formula.substring(plusIndex+1, formula.length());

        if(firstOperand.charAt(0)>='A' && firstOperand.charAt(0)<='Z'){
            int column = Integer.valueOf(firstOperand.charAt(0)-'A');
            int row =Integer.valueOf(firstOperand.substring(1,firstOperand.length()));
            result = sheet.get(row).get(column);
        }
        else{
            int number = Integer.valueOf(firstOperand);
            result = number;
        }

         if(secondOperand.charAt(0)>='A' && secondOperand.charAt(0)<='Z'){
            int column = Integer.valueOf(secondOperand.charAt(0)-'A');
            int row =Integer.valueOf(secondOperand.substring(1,secondOperand.length()));
            result += sheet.get(row).get(column);
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