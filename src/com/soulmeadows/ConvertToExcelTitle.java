package com.soulmeadows;

public class ConvertToExcelTitle {
    public String convertToTitle(int columnNumber) {
        var sb = new StringBuilder();
        if(columnNumber > 26){
            int count = columnNumber / 26;
            columnNumber %= 26;
            while(count-- > 0){
                sb.append("A");
            }
        }
        sb.append((char)(columnNumber + 'A'));
        return sb.toString();
    }
    public static void main(String[] args) {
        new ConvertToExcelTitle().convertToTitle(27);
    }
}
