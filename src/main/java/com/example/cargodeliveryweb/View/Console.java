package com.example.cargodeliveryweb.View;

public class Console {
    public static void main(String args[]){

        System.out.println(replaceText("“Albania”,\n" +
                "“Andorra”,\n" +
                "“Armenia”,\n" +
                "“Austria”,\n" +
                "“Azerbaijan”,\n" +
                "“Belarus”,\n" +
                "“Belgium”,\n" +
                "“Bosnia and Herzegovina”,\n" +
                "“Bulgaria”,\n" +
                "“Croatia”,\n" +
                "“Cyprus”,\n" +
                "“Czech Republic”,\n" +
                "“Denmark”,\n" +
                "“Estonia”,\n" +
                "“Finland”,\n" +
                "“France”,\n" +
                "“Georgia”,\n" +
                "“Germany”,\n" +
                "“Greece”,\n" +
                "“Hungary”,\n" +
                "“Iceland”,\n" +
                "“Ireland”,\n" +
                "“Italy”,\n" +
                "“Kosovo”,\n" +
                "“Latvia”,\n" +
                "“Liechtenstein”,\n" +
                "“Lithuania”,\n" +
                "“Luxembourg”,\n" +
                "“Macedonia”,\n" +
                "“Malta”,\n" +
                "“Moldova”,\n" +
                "“Monaco”,\n" +
                "“Montenegro”,\n" +
                "“The Netherlands”,\n" +
                "“Norway”,\n" +
                "“Poland”,\n" +
                "“Portugal”,\n" +
                "“Romania”,\n" +
                "“Russia”,\n" +
                "“San Marino”,\n" +
                "“Serbia”,\n" +
                "“Slovakia”,\n" +
                "“Slovenia”,\n" +
                "“Spain”,\n" +
                "“Sweden”,\n" +
                "“Switzerland”,\n" +
                "“Turkey”,\n" +
                "“Ukraine”,\n" +
                "“United Kingdom”,\n" +
                "“Vatican City"));
    }
    static String replaceText(String text){
        String temp = "";
        for(int i =0 ;i < text.length();i++){
            if(text.charAt(i)=='“'||text.charAt(0)=='”'){
                temp +="\"";
            }
            else{
                temp +=text.charAt(i);
            }
        }
        return temp;
    }
}
